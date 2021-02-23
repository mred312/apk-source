package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpy implements zzepf<zza> {

    /* renamed from: a */
    private final zzeps<Context> f13647a;

    /* renamed from: b */
    private final zzeps<zzawq> f13648b;

    private zzbpy(zzbpv zzbpv, zzeps<Context> zzeps, zzeps<zzawq> zzeps2) {
        this.f13647a = zzeps;
        this.f13648b = zzeps2;
    }

    public static zzbpy zza(zzbpv zzbpv, zzeps<Context> zzeps, zzeps<zzawq> zzeps2) {
        return new zzbpy(zzbpv, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zza) zzepl.zza(new zza(this.f13647a.get(), this.f13648b.get(), (zzasw) null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
