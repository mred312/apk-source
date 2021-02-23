package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.background.systemalarm.C1096c;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DelayMetCommandHandler implements WorkConstraintsCallback, ExecutionListener, C1096c.C1098b {

    /* renamed from: j */
    private static final String f5177j = Logger.tagWithPrefix("DelayMetCommandHandler");

    /* renamed from: a */
    private final Context f5178a;

    /* renamed from: b */
    private final int f5179b;

    /* renamed from: c */
    private final String f5180c;

    /* renamed from: d */
    private final SystemAlarmDispatcher f5181d;

    /* renamed from: e */
    private final WorkConstraintsTracker f5182e;

    /* renamed from: f */
    private final Object f5183f = new Object();

    /* renamed from: g */
    private int f5184g = 0;
    @Nullable

    /* renamed from: h */
    private PowerManager.WakeLock f5185h;

    /* renamed from: i */
    private boolean f5186i = false;

    DelayMetCommandHandler(@NonNull Context context, int i, @NonNull String str, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f5178a = context;
        this.f5179b = i;
        this.f5181d = systemAlarmDispatcher;
        this.f5180c = str;
        this.f5182e = new WorkConstraintsTracker(context, systemAlarmDispatcher.mo8909d(), this);
    }

    /* renamed from: a */
    private void m3938a() {
        synchronized (this.f5183f) {
            this.f5182e.reset();
            this.f5181d.mo8911f().mo8922c(this.f5180c);
            PowerManager.WakeLock wakeLock = this.f5185h;
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.get().debug(f5177j, String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.f5185h, this.f5180c}), new Throwable[0]);
                this.f5185h.release();
            }
        }
    }

    /* renamed from: c */
    private void m3939c() {
        synchronized (this.f5183f) {
            if (this.f5184g < 2) {
                this.f5184g = 2;
                Logger logger = Logger.get();
                String str = f5177j;
                logger.debug(str, String.format("Stopping work for WorkSpec %s", new Object[]{this.f5180c}), new Throwable[0]);
                Intent f = CommandHandler.m3927f(this.f5178a, this.f5180c);
                SystemAlarmDispatcher systemAlarmDispatcher = this.f5181d;
                systemAlarmDispatcher.mo8913i(new SystemAlarmDispatcher.C1091b(systemAlarmDispatcher, f, this.f5179b));
                if (this.f5181d.mo8908c().isEnqueued(this.f5180c)) {
                    Logger.get().debug(str, String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.f5180c}), new Throwable[0]);
                    Intent e = CommandHandler.m3926e(this.f5178a, this.f5180c);
                    SystemAlarmDispatcher systemAlarmDispatcher2 = this.f5181d;
                    systemAlarmDispatcher2.mo8913i(new SystemAlarmDispatcher.C1091b(systemAlarmDispatcher2, e, this.f5179b));
                } else {
                    Logger.get().debug(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.f5180c}), new Throwable[0]);
                }
            } else {
                Logger.get().debug(f5177j, String.format("Already stopped work for %s", new Object[]{this.f5180c}), new Throwable[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: b */
    public void mo8903b() {
        this.f5185h = WakeLocks.newWakeLock(this.f5178a, String.format("%s (%s)", new Object[]{this.f5180c, Integer.valueOf(this.f5179b)}));
        Logger logger = Logger.get();
        String str = f5177j;
        logger.debug(str, String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.f5185h, this.f5180c}), new Throwable[0]);
        this.f5185h.acquire();
        WorkSpec workSpec = this.f5181d.mo8910e().getWorkDatabase().workSpecDao().getWorkSpec(this.f5180c);
        if (workSpec == null) {
            m3939c();
            return;
        }
        boolean hasConstraints = workSpec.hasConstraints();
        this.f5186i = hasConstraints;
        if (!hasConstraints) {
            Logger.get().debug(str, String.format("No constraints for %s", new Object[]{this.f5180c}), new Throwable[0]);
            onAllConstraintsMet(Collections.singletonList(this.f5180c));
            return;
        }
        this.f5182e.replace(Collections.singletonList(workSpec));
    }

    public void onAllConstraintsMet(@NonNull List<String> list) {
        if (list.contains(this.f5180c)) {
            synchronized (this.f5183f) {
                if (this.f5184g == 0) {
                    this.f5184g = 1;
                    Logger.get().debug(f5177j, String.format("onAllConstraintsMet for %s", new Object[]{this.f5180c}), new Throwable[0]);
                    if (this.f5181d.mo8908c().startWork(this.f5180c)) {
                        this.f5181d.mo8911f().mo8921b(this.f5180c, 600000, this);
                    } else {
                        m3938a();
                    }
                } else {
                    Logger.get().debug(f5177j, String.format("Already started work for %s", new Object[]{this.f5180c}), new Throwable[0]);
                }
            }
        }
    }

    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        m3939c();
    }

    public void onExecuted(@NonNull String str, boolean z) {
        Logger.get().debug(f5177j, String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z)}), new Throwable[0]);
        m3938a();
        if (z) {
            Intent e = CommandHandler.m3926e(this.f5178a, this.f5180c);
            SystemAlarmDispatcher systemAlarmDispatcher = this.f5181d;
            systemAlarmDispatcher.mo8913i(new SystemAlarmDispatcher.C1091b(systemAlarmDispatcher, e, this.f5179b));
        }
        if (this.f5186i) {
            Intent a = CommandHandler.m3922a(this.f5178a);
            SystemAlarmDispatcher systemAlarmDispatcher2 = this.f5181d;
            systemAlarmDispatcher2.mo8913i(new SystemAlarmDispatcher.C1091b(systemAlarmDispatcher2, a, this.f5179b));
        }
    }

    public void onTimeLimitExceeded(@NonNull String str) {
        Logger.get().debug(f5177j, String.format("Exceeded time limits on execution for %s", new Object[]{str}), new Throwable[0]);
        m3939c();
    }
}
