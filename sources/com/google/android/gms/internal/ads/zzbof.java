package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbof<AdT> implements zzepf<zzbog<AdT>> {

    /* renamed from: a */
    private final zzeps<Map<String, zzcqz<AdT>>> f13584a;

    private zzbof(zzeps<Map<String, zzcqz<AdT>>> zzeps) {
        this.f13584a = zzeps;
    }

    public static <AdT> zzbof<AdT> zzd(zzeps<Map<String, zzcqz<AdT>>> zzeps) {
        return new zzbof<>(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbog(this.f13584a.get());
    }
}
