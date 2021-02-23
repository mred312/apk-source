package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.a */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1661a implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ LifecycleCallback f7482a;

    /* renamed from: b */
    private final /* synthetic */ String f7483b;

    /* renamed from: c */
    private final /* synthetic */ zzb f7484c;

    C1661a(zzb zzb, LifecycleCallback lifecycleCallback, String str) {
        this.f7484c = zzb;
        this.f7482a = lifecycleCallback;
        this.f7483b = str;
    }

    public final void run() {
        if (this.f7484c.f7490b > 0) {
            this.f7482a.onCreate(this.f7484c.f7491c != null ? this.f7484c.f7491c.getBundle(this.f7483b) : null);
        }
        if (this.f7484c.f7490b >= 2) {
            this.f7482a.onStart();
        }
        if (this.f7484c.f7490b >= 3) {
            this.f7482a.onResume();
        }
        if (this.f7484c.f7490b >= 4) {
            this.f7482a.onStop();
        }
        if (this.f7484c.f7490b >= 5) {
            this.f7482a.onDestroy();
        }
    }
}
