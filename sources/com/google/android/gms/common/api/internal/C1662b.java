package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.b */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1662b implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ LifecycleCallback f7485a;

    /* renamed from: b */
    private final /* synthetic */ String f7486b;

    /* renamed from: c */
    private final /* synthetic */ zzc f7487c;

    C1662b(zzc zzc, LifecycleCallback lifecycleCallback, String str) {
        this.f7487c = zzc;
        this.f7485a = lifecycleCallback;
        this.f7486b = str;
    }

    public final void run() {
        if (this.f7487c.f7494c0 > 0) {
            this.f7485a.onCreate(this.f7487c.f7495d0 != null ? this.f7487c.f7495d0.getBundle(this.f7486b) : null);
        }
        if (this.f7487c.f7494c0 >= 2) {
            this.f7485a.onStart();
        }
        if (this.f7487c.f7494c0 >= 3) {
            this.f7485a.onResume();
        }
        if (this.f7487c.f7494c0 >= 4) {
            this.f7485a.onStop();
        }
        if (this.f7487c.f7494c0 >= 5) {
            this.f7485a.onDestroy();
        }
    }
}
