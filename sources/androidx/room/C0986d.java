package androidx.room;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* renamed from: androidx.room.d */
/* compiled from: TransactionExecutor */
class C0986d implements Executor {

    /* renamed from: a */
    private final Executor f4593a;

    /* renamed from: b */
    private final ArrayDeque<Runnable> f4594b = new ArrayDeque<>();

    /* renamed from: c */
    private Runnable f4595c;

    /* renamed from: androidx.room.d$a */
    /* compiled from: TransactionExecutor */
    class C0987a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f4596a;

        C0987a(Runnable runnable) {
            this.f4596a = runnable;
        }

        public void run() {
            try {
                this.f4596a.run();
            } finally {
                C0986d.this.mo7903a();
            }
        }
    }

    C0986d(@NonNull Executor executor) {
        this.f4593a = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo7903a() {
        Runnable poll = this.f4594b.poll();
        this.f4595c = poll;
        if (poll != null) {
            this.f4593a.execute(poll);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.f4594b.offer(new C0987a(runnable));
        if (this.f4595c == null) {
            mo7903a();
        }
    }
}
