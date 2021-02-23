package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqf implements zzepf<zzbxy<zzp>> {

    /* renamed from: a */
    private final zzeps<zzbov> f13661a;

    private zzbqf(zzbpx zzbpx, zzeps<zzbov> zzeps) {
        this.f13661a = zzeps;
    }

    public static zzbqf zza(zzbpx zzbpx, zzeps<zzbov> zzeps) {
        return new zzbqf(zzbpx, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13661a.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}
