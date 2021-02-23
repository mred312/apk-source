package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.tc */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2434tc implements zzdyo<zzboi> {

    /* renamed from: a */
    private final /* synthetic */ zzdyo f11164a;

    /* renamed from: b */
    private final /* synthetic */ zzboj f11165b;

    C2434tc(zzboj zzboj, zzdyo zzdyo) {
        this.f11165b = zzboj;
        this.f11164a = zzdyo;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.f11165b.m7837d(((zzboi) obj).zzfuy, this.f11164a);
    }

    public final void zzb(Throwable th) {
        this.f11164a.zzb(th);
        this.f11165b.m7838e();
    }
}
