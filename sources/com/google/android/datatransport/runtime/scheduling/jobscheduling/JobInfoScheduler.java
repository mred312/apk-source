package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

@RequiresApi(api = 21)
public class JobInfoScheduler implements WorkScheduler {

    /* renamed from: a */
    private final Context f7282a;

    /* renamed from: b */
    private final EventStore f7283b;

    /* renamed from: c */
    private final SchedulerConfig f7284c;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.f7282a = context;
        this.f7283b = eventStore;
        this.f7284c = schedulerConfig;
    }

    /* renamed from: b */
    private boolean m5086b(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo next : jobScheduler.getAllPendingJobs()) {
            int i3 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i) {
                if (i3 >= i2) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public int mo11464a(TransportContext transportContext) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f7282a.getPackageName().getBytes(Charset.forName(Key.STRING_CHARSET_NAME)));
        adler32.update(transportContext.getBackendName().getBytes(Charset.forName(Key.STRING_CHARSET_NAME)));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.toInt(transportContext.getPriority())).array());
        if (transportContext.getExtras() != null) {
            adler32.update(transportContext.getExtras());
        }
        return (int) adler32.getValue();
    }

    public void schedule(TransportContext transportContext, int i) {
        ComponentName componentName = new ComponentName(this.f7282a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f7282a.getSystemService("jobscheduler");
        int a = mo11464a(transportContext);
        if (m5086b(jobScheduler, a, i)) {
            Logging.m5072d("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", (Object) transportContext);
            return;
        }
        long nextCallTime = this.f7283b.getNextCallTime(transportContext);
        JobInfo.Builder configureJob = this.f7284c.configureJob(new JobInfo.Builder(a, componentName), transportContext.getPriority(), nextCallTime, i);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", transportContext.getBackendName());
        persistableBundle.putInt("priority", PriorityMapping.toInt(transportContext.getPriority()));
        if (transportContext.getExtras() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(transportContext.getExtras(), 0));
        }
        configureJob.setExtras(persistableBundle);
        Logging.m5074d("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Integer.valueOf(a), Long.valueOf(this.f7284c.getScheduleDelay(transportContext.getPriority(), nextCallTime, i)), Long.valueOf(nextCallTime), Integer.valueOf(i));
        jobScheduler.schedule(configureJob.build());
    }
}
