package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.WakeLocks;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.C1092c {

    /* renamed from: d */
    private static final String f5206d = Logger.tagWithPrefix("SystemAlarmService");

    /* renamed from: b */
    private SystemAlarmDispatcher f5207b;

    /* renamed from: c */
    private boolean f5208c;

    @MainThread
    /* renamed from: a */
    private void m3953a() {
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.f5207b = systemAlarmDispatcher;
        systemAlarmDispatcher.mo8914k(this);
    }

    @MainThread
    public void onAllCommandsCompleted() {
        this.f5208c = true;
        Logger.get().debug(f5206d, "All commands completed in dispatcher", new Throwable[0]);
        WakeLocks.checkWakeLocks();
        stopSelf();
    }

    public void onCreate() {
        super.onCreate();
        m3953a();
        this.f5208c = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5208c = true;
        this.f5207b.mo8912h();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.f5208c) {
            Logger.get().info(f5206d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f5207b.mo8912h();
            m3953a();
            this.f5208c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f5207b.add(intent, i2);
        return 3;
    }
}
