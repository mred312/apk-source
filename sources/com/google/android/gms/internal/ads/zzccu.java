package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzccu implements zzepf<zzawu> {

    /* renamed from: a */
    private final zzeps<Context> f14092a;

    /* renamed from: b */
    private final zzeps<zzdnn> f14093b;

    private zzccu(zzccq zzccq, zzeps<Context> zzeps, zzeps<zzdnn> zzeps2) {
        this.f14092a = zzeps;
        this.f14093b = zzeps2;
    }

    public static zzccu zza(zzccq zzccq, zzeps<Context> zzeps, zzeps<zzdnn> zzeps2) {
        return new zzccu(zzccq, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzawu) zzepl.zza(new zzawu(this.f14092a.get(), this.f14093b.get().zzhip), "Cannot return null from a non-@Nullable @Provides method");
    }
}
