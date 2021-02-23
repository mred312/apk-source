package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ki */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2102ki implements zzdyb {

    /* renamed from: a */
    private final zzdyz f9757a;

    C2102ki(zzdyz zzdyz) {
        this.f9757a = zzdyz;
    }

    public final zzdyz zzf(Object obj) {
        zzdyz zzdyz = this.f9757a;
        zzbdv zzbdv = (zzbdv) obj;
        if (zzbdv != null && zzbdv.zzaah() != null) {
            return zzdyz;
        }
        throw new zzcuq(zzdok.INTERNAL_ERROR, "Retrieve video view in instream ad response failed.");
    }
}
