package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.f */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3188f implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f18776a;

    /* renamed from: b */
    private final /* synthetic */ C3186d f18777b;

    C3188f(C3186d dVar, Task task) {
        this.f18777b = dVar;
        this.f18776a = task;
    }

    public final void run() {
        if (this.f18776a.isCanceled()) {
            this.f18777b.f18772c.mo20693c();
            return;
        }
        try {
            this.f18777b.f18772c.mo20692b(this.f18777b.f18771b.then(this.f18776a));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.f18777b.f18772c.mo20691a((Exception) e.getCause());
            } else {
                this.f18777b.f18772c.mo20691a(e);
            }
        } catch (Exception e2) {
            this.f18777b.f18772c.mo20691a(e2);
        }
    }
}
