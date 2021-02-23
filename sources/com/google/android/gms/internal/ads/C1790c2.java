package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* renamed from: com.google.android.gms.internal.ads.c2 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1790c2 implements zzazs {

    /* renamed from: a */
    private final /* synthetic */ zzals f7957a;

    /* renamed from: b */
    private final /* synthetic */ zzalb f7958b;

    C1790c2(zzalb zzalb, zzals zzals) {
        this.f7958b = zzalb;
        this.f7957a = zzals;
    }

    public final void run() {
        synchronized (this.f7958b.f12503a) {
            int unused = this.f7958b.f12510h = 1;
            zzd.zzee("Failed loading new engine. Marking new engine destroyable.");
            this.f7957a.zztx();
        }
    }
}
