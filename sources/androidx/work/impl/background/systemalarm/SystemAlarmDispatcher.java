package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmDispatcher implements ExecutionListener {

    /* renamed from: k */
    static final String f5188k = Logger.tagWithPrefix("SystemAlarmDispatcher");

    /* renamed from: a */
    final Context f5189a;

    /* renamed from: b */
    private final TaskExecutor f5190b;

    /* renamed from: c */
    private final C1096c f5191c;

    /* renamed from: d */
    private final Processor f5192d;

    /* renamed from: e */
    private final WorkManagerImpl f5193e;

    /* renamed from: f */
    final CommandHandler f5194f;

    /* renamed from: g */
    private final Handler f5195g;

    /* renamed from: h */
    final List<Intent> f5196h;

    /* renamed from: i */
    Intent f5197i;
    @Nullable

    /* renamed from: j */
    private C1092c f5198j;

    /* renamed from: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$a */
    class C1090a implements Runnable {
        C1090a() {
        }

        public void run() {
            C1093d dVar;
            SystemAlarmDispatcher systemAlarmDispatcher;
            synchronized (SystemAlarmDispatcher.this.f5196h) {
                SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                systemAlarmDispatcher2.f5197i = systemAlarmDispatcher2.f5196h.get(0);
            }
            Intent intent = SystemAlarmDispatcher.this.f5197i;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = SystemAlarmDispatcher.this.f5197i.getIntExtra("KEY_START_ID", 0);
                Logger logger = Logger.get();
                String str = SystemAlarmDispatcher.f5188k;
                logger.debug(str, String.format("Processing command %s, %s", new Object[]{SystemAlarmDispatcher.this.f5197i, Integer.valueOf(intExtra)}), new Throwable[0]);
                PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(SystemAlarmDispatcher.this.f5189a, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                try {
                    Logger.get().debug(str, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                    newWakeLock.acquire();
                    SystemAlarmDispatcher systemAlarmDispatcher3 = SystemAlarmDispatcher.this;
                    systemAlarmDispatcher3.f5194f.mo8899o(systemAlarmDispatcher3.f5197i, intExtra, systemAlarmDispatcher3);
                    Logger.get().debug(str, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                    newWakeLock.release();
                    systemAlarmDispatcher = SystemAlarmDispatcher.this;
                    dVar = new C1093d(systemAlarmDispatcher);
                } catch (Throwable th) {
                    Logger.get().debug(SystemAlarmDispatcher.f5188k, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                    newWakeLock.release();
                    SystemAlarmDispatcher systemAlarmDispatcher4 = SystemAlarmDispatcher.this;
                    systemAlarmDispatcher4.mo8913i(new C1093d(systemAlarmDispatcher4));
                    throw th;
                }
                systemAlarmDispatcher.mo8913i(dVar);
            }
        }
    }

    /* renamed from: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$b */
    static class C1091b implements Runnable {

        /* renamed from: a */
        private final SystemAlarmDispatcher f5200a;

        /* renamed from: b */
        private final Intent f5201b;

        /* renamed from: c */
        private final int f5202c;

        C1091b(@NonNull SystemAlarmDispatcher systemAlarmDispatcher, @NonNull Intent intent, int i) {
            this.f5200a = systemAlarmDispatcher;
            this.f5201b = intent;
            this.f5202c = i;
        }

        public void run() {
            this.f5200a.add(this.f5201b, this.f5202c);
        }
    }

    /* renamed from: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$c */
    interface C1092c {
        void onAllCommandsCompleted();
    }

    /* renamed from: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$d */
    static class C1093d implements Runnable {

        /* renamed from: a */
        private final SystemAlarmDispatcher f5203a;

        C1093d(@NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
            this.f5203a = systemAlarmDispatcher;
        }

        public void run() {
            this.f5203a.mo8907b();
        }
    }

    SystemAlarmDispatcher(@NonNull Context context) {
        this(context, (Processor) null, (WorkManagerImpl) null);
    }

    /* renamed from: a */
    private void m3941a() {
        if (this.f5195g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    @MainThread
    /* renamed from: g */
    private boolean m3942g(@NonNull String str) {
        m3941a();
        synchronized (this.f5196h) {
            for (Intent action : this.f5196h) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    @MainThread
    /* renamed from: j */
    private void m3943j() {
        m3941a();
        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.f5189a, "ProcessCommand");
        try {
            newWakeLock.acquire();
            this.f5193e.getWorkTaskExecutor().executeOnBackgroundThread(new C1090a());
        } finally {
            newWakeLock.release();
        }
    }

    @MainThread
    public boolean add(@NonNull Intent intent, int i) {
        Logger logger = Logger.get();
        String str = f5188k;
        boolean z = false;
        logger.debug(str, String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        m3941a();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.get().warning(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && m3942g("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i);
            synchronized (this.f5196h) {
                if (!this.f5196h.isEmpty()) {
                    z = true;
                }
                this.f5196h.add(intent);
                if (!z) {
                    m3943j();
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    /* renamed from: b */
    public void mo8907b() {
        Logger logger = Logger.get();
        String str = f5188k;
        logger.debug(str, "Checking if commands are complete.", new Throwable[0]);
        m3941a();
        synchronized (this.f5196h) {
            if (this.f5197i != null) {
                Logger.get().debug(str, String.format("Removing command %s", new Object[]{this.f5197i}), new Throwable[0]);
                if (this.f5196h.remove(0).equals(this.f5197i)) {
                    this.f5197i = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            if (!this.f5194f.mo8898n() && this.f5196h.isEmpty()) {
                Logger.get().debug(str, "No more commands & intents.", new Throwable[0]);
                C1092c cVar = this.f5198j;
                if (cVar != null) {
                    cVar.onAllCommandsCompleted();
                }
            } else if (!this.f5196h.isEmpty()) {
                m3943j();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Processor mo8908c() {
        return this.f5192d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TaskExecutor mo8909d() {
        return this.f5190b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public WorkManagerImpl mo8910e() {
        return this.f5193e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C1096c mo8911f() {
        return this.f5191c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo8912h() {
        Logger.get().debug(f5188k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f5192d.removeExecutionListener(this);
        this.f5191c.mo8920a();
        this.f5198j = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo8913i(@NonNull Runnable runnable) {
        this.f5195g.post(runnable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo8914k(@NonNull C1092c cVar) {
        if (this.f5198j != null) {
            Logger.get().error(f5188k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f5198j = cVar;
        }
    }

    public void onExecuted(@NonNull String str, boolean z) {
        mo8913i(new C1091b(this, CommandHandler.m3924c(this.f5189a, str, z), 0));
    }

    @VisibleForTesting
    SystemAlarmDispatcher(@NonNull Context context, @Nullable Processor processor, @Nullable WorkManagerImpl workManagerImpl) {
        Context applicationContext = context.getApplicationContext();
        this.f5189a = applicationContext;
        this.f5194f = new CommandHandler(applicationContext);
        this.f5191c = new C1096c();
        workManagerImpl = workManagerImpl == null ? WorkManagerImpl.getInstance(context) : workManagerImpl;
        this.f5193e = workManagerImpl;
        processor = processor == null ? workManagerImpl.getProcessor() : processor;
        this.f5192d = processor;
        this.f5190b = workManagerImpl.getWorkTaskExecutor();
        processor.addExecutionListener(this);
        this.f5196h = new ArrayList();
        this.f5197i = null;
        this.f5195g = new Handler(Looper.getMainLooper());
    }
}
