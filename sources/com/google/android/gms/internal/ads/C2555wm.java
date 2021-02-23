package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.wm */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2555wm implements Callable {

    /* renamed from: a */
    private final zzdyz f11721a;

    /* renamed from: b */
    private final zzdyz f11722b;

    C2555wm(zzdyz zzdyz, zzdyz zzdyz2) {
        this.f11721a = zzdyz;
        this.f11722b = zzdyz2;
    }

    public final Object call() {
        zzdyz zzdyz = this.f11721a;
        zzdyz zzdyz2 = this.f11722b;
        return new zzcpi((zzcpl) zzdyz.get(), ((zzcpf) zzdyz2.get()).zzgoi, ((zzcpf) zzdyz2.get()).zzgoh);
    }
}
