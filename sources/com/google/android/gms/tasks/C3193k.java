package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.k */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3193k implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f18787a;

    /* renamed from: b */
    private final /* synthetic */ C3192j f18788b;

    C3193k(C3192j jVar, Task task) {
        this.f18788b = jVar;
        this.f18787a = task;
    }

    public final void run() {
        synchronized (this.f18788b.f18785b) {
            if (this.f18788b.f18786c != null) {
                this.f18788b.f18786c.onComplete(this.f18787a);
            }
        }
    }
}
