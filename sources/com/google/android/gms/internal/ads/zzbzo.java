package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzo implements zzepf<zzawu> {

    /* renamed from: a */
    private final zzeps<Context> f13881a;

    /* renamed from: b */
    private final zzeps<zzdnn> f13882b;

    private zzbzo(zzbzc zzbzc, zzeps<Context> zzeps, zzeps<zzdnn> zzeps2) {
        this.f13881a = zzeps;
        this.f13882b = zzeps2;
    }

    public static zzbzo zza(zzbzc zzbzc, zzeps<Context> zzeps, zzeps<zzdnn> zzeps2) {
        return new zzbzo(zzbzc, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzawu) zzepl.zza(new zzawu(this.f13881a.get(), this.f13882b.get().zzhip), "Cannot return null from a non-@Nullable @Provides method");
    }
}
