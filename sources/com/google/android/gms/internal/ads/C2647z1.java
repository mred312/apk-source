package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* renamed from: com.google.android.gms.internal.ads.z1 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2647z1 implements zzazu<zzako> {

    /* renamed from: a */
    private final /* synthetic */ zzals f12245a;

    /* renamed from: b */
    private final /* synthetic */ zzalb f12246b;

    C2647z1(zzalb zzalb, zzals zzals) {
        this.f12246b = zzalb;
        this.f12245a = zzals;
    }

    public final /* synthetic */ void zzh(Object obj) {
        zzako zzako = (zzako) obj;
        synchronized (this.f12246b.f12503a) {
            int unused = this.f12246b.f12510h = 0;
            if (!(this.f12246b.f12509g == null || this.f12245a == this.f12246b.f12509g)) {
                zzd.zzee("New JS engine is loaded, marking previous one as destroyable.");
                this.f12246b.f12509g.zztx();
            }
            zzals unused2 = this.f12246b.f12509g = this.f12245a;
        }
    }
}
