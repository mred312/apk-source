package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class SerialExecutor implements Executor {

    /* renamed from: a */
    private final ArrayDeque<C1132a> f5339a = new ArrayDeque<>();

    /* renamed from: b */
    private final Executor f5340b;

    /* renamed from: c */
    private final Object f5341c = new Object();

    /* renamed from: d */
    private volatile Runnable f5342d;

    /* renamed from: androidx.work.impl.utils.SerialExecutor$a */
    static class C1132a implements Runnable {

        /* renamed from: a */
        final SerialExecutor f5343a;

        /* renamed from: b */
        final Runnable f5344b;

        C1132a(@NonNull SerialExecutor serialExecutor, @NonNull Runnable runnable) {
            this.f5343a = serialExecutor;
            this.f5344b = runnable;
        }

        public void run() {
            try {
                this.f5344b.run();
            } finally {
                this.f5343a.mo9074a();
            }
        }
    }

    public SerialExecutor(@NonNull Executor executor) {
        this.f5340b = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9074a() {
        synchronized (this.f5341c) {
            Runnable poll = this.f5339a.poll();
            this.f5342d = poll;
            if (poll != null) {
                this.f5340b.execute(this.f5342d);
            }
        }
    }

    public void execute(@NonNull Runnable runnable) {
        synchronized (this.f5341c) {
            this.f5339a.add(new C1132a(this, runnable));
            if (this.f5342d == null) {
                mo9074a();
            }
        }
    }
}
