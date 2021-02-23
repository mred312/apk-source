package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class AlarmManagerScheduler implements WorkScheduler {

    /* renamed from: a */
    private final Context f7277a;

    /* renamed from: b */
    private final EventStore f7278b;

    /* renamed from: c */
    private AlarmManager f7279c;

    /* renamed from: d */
    private final SchedulerConfig f7280d;

    /* renamed from: e */
    private final Clock f7281e;

    public AlarmManagerScheduler(Context context, EventStore eventStore, Clock clock, SchedulerConfig schedulerConfig) {
        this(context, eventStore, (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM), clock, schedulerConfig);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo11461a(Intent intent) {
        return PendingIntent.getBroadcast(this.f7277a, 0, intent, 536870912) != null;
    }

    public void schedule(TransportContext transportContext, int i) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", transportContext.getBackendName());
        builder.appendQueryParameter("priority", String.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
        if (transportContext.getExtras() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(transportContext.getExtras(), 0));
        }
        Intent intent = new Intent(this.f7277a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i);
        if (mo11461a(intent)) {
            Logging.m5072d("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", (Object) transportContext);
            return;
        }
        long nextCallTime = this.f7278b.getNextCallTime(transportContext);
        long scheduleDelay = this.f7280d.getScheduleDelay(transportContext.getPriority(), nextCallTime, i);
        Logging.m5074d("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Long.valueOf(scheduleDelay), Long.valueOf(nextCallTime), Integer.valueOf(i));
        this.f7279c.set(3, this.f7281e.getTime() + scheduleDelay, PendingIntent.getBroadcast(this.f7277a, 0, intent, 0));
    }

    @VisibleForTesting
    AlarmManagerScheduler(Context context, EventStore eventStore, AlarmManager alarmManager, Clock clock, SchedulerConfig schedulerConfig) {
        this.f7277a = context;
        this.f7278b = eventStore;
        this.f7279c = alarmManager;
        this.f7281e = clock;
        this.f7280d = schedulerConfig;
    }
}
