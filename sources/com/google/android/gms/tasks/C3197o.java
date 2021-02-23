package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.o */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3197o implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f18797a;

    /* renamed from: b */
    private final /* synthetic */ C3196n f18798b;

    C3197o(C3196n nVar, Task task) {
        this.f18798b = nVar;
        this.f18797a = task;
    }

    public final void run() {
        synchronized (this.f18798b.f18795b) {
            if (this.f18798b.f18796c != null) {
                this.f18798b.f18796c.onSuccess(this.f18797a.getResult());
            }
        }
    }
}
