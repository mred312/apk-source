package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmScheduler implements Scheduler {

    /* renamed from: b */
    private static final String f5204b = Logger.tagWithPrefix("SystemAlarmScheduler");

    /* renamed from: a */
    private final Context f5205a;

    public SystemAlarmScheduler(@NonNull Context context) {
        this.f5205a = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m3952a(@NonNull WorkSpec workSpec) {
        Logger.get().debug(f5204b, String.format("Scheduling work with workSpecId %s", new Object[]{workSpec.f5281id}), new Throwable[0]);
        this.f5205a.startService(CommandHandler.m3926e(this.f5205a, workSpec.f5281id));
    }

    public void cancel(@NonNull String str) {
        this.f5205a.startService(CommandHandler.m3927f(this.f5205a, str));
    }

    public void schedule(@NonNull WorkSpec... workSpecArr) {
        for (WorkSpec a : workSpecArr) {
            m3952a(a);
        }
    }
}
