package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.l */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3194l implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f18789a;

    /* renamed from: b */
    private final /* synthetic */ C3195m f18790b;

    C3194l(C3195m mVar, Task task) {
        this.f18790b = mVar;
        this.f18789a = task;
    }

    public final void run() {
        synchronized (this.f18790b.f18792b) {
            if (this.f18790b.f18793c != null) {
                this.f18790b.f18793c.onFailure(this.f18789a.getException());
            }
        }
    }
}
