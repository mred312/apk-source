package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.mi */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2176mi implements zzdyb {

    /* renamed from: a */
    private final zzdyz f9987a;

    C2176mi(zzdyz zzdyz) {
        this.f9987a = zzdyz;
    }

    public final zzdyz zzf(Object obj) {
        zzdyz zzdyz = this.f9987a;
        if (obj != null) {
            return zzdyz;
        }
        return zzdyr.immediateFailedFuture(new zzcuq(zzdok.INTERNAL_ERROR, "Retrieve required value in native ad response failed."));
    }
}
