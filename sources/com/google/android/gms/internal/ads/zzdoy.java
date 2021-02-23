package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdoy implements zzepf<Context> {

    /* renamed from: a */
    private final zzdot f15839a;

    /* renamed from: b */
    private final zzeps<zzdor> f15840b;

    private zzdoy(zzdot zzdot, zzeps<zzdor> zzeps) {
        this.f15839a = zzdot;
        this.f15840b = zzeps;
    }

    public static Context zzb(zzdot zzdot, zzdor zzdor) {
        return (Context) zzepl.zza(zzdor.zzaaa, "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzdoy zzc(zzdot zzdot, zzeps<zzdor> zzeps) {
        return new zzdoy(zzdot, zzeps);
    }

    public final /* synthetic */ Object get() {
        return zzb(this.f15839a, this.f15840b.get());
    }
}
