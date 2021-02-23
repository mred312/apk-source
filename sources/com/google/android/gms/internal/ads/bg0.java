package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class bg0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ cg0 f7915a;

    /* renamed from: b */
    private final /* synthetic */ xf0 f7916b;

    bg0(xf0 xf0, cg0 cg0) {
        this.f7916b = xf0;
        this.f7915a = cg0;
    }

    public final void run() {
        this.f7915a.mo13779a();
        int size = this.f7916b.f11923p.size();
        for (int i = 0; i < size; i++) {
            ((zzni) this.f7916b.f11923p.valueAt(i)).disable();
        }
    }
}
