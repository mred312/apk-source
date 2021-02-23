package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbmw implements zzepf<zzawu> {

    /* renamed from: a */
    private final zzeps<Context> f13522a;

    /* renamed from: b */
    private final zzeps<zzdnn> f13523b;

    public zzbmw(zzbmh zzbmh, zzeps<Context> zzeps, zzeps<zzdnn> zzeps2) {
        this.f13522a = zzeps;
        this.f13523b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzawu) zzepl.zza(new zzawu(this.f13522a.get(), this.f13523b.get().zzhip), "Cannot return null from a non-@Nullable @Provides method");
    }
}
