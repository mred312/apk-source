package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.h */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3190h implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C3191i f18780a;

    C3190h(C3191i iVar) {
        this.f18780a = iVar;
    }

    public final void run() {
        synchronized (this.f18780a.f18782b) {
            if (this.f18780a.f18783c != null) {
                this.f18780a.f18783c.onCanceled();
            }
        }
    }
}
