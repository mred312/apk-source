package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.sc */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2397sc implements zzdyo<zzboc> {

    /* renamed from: a */
    private final /* synthetic */ zzdyo f11072a;

    /* renamed from: b */
    private final /* synthetic */ zzboj f11073b;

    C2397sc(zzboj zzboj, zzdyo zzdyo) {
        this.f11073b = zzboj;
        this.f11072a = zzdyo;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.f11073b.m7838e();
        this.f11072a.onSuccess((zzboc) obj);
    }

    public final void zzb(Throwable th) {
        this.f11073b.m7838e();
        this.f11072a.zzb(th);
    }
}
