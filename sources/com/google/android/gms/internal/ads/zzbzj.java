package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzj implements zzepf<zzbxy<zzp>> {

    /* renamed from: a */
    private final zzeps<zzcah> f13876a;

    private zzbzj(zzbzc zzbzc, zzeps<zzcah> zzeps) {
        this.f13876a = zzeps;
    }

    public static zzbzj zzc(zzbzc zzbzc, zzeps<zzcah> zzeps) {
        return new zzbzj(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13876a.get(), zzazj.zzegt), "Cannot return null from a non-@Nullable @Provides method");
    }
}
