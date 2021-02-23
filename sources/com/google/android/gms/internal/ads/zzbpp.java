package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpp implements zzepf<zzbxy<zzva>> {

    /* renamed from: a */
    private final zzeps<zzbjv> f13628a;

    /* renamed from: b */
    private final zzeps<Executor> f13629b;

    private zzbpp(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        this.f13628a = zzeps;
        this.f13629b = zzeps2;
    }

    public static zzbpp zze(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpp(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13628a.get(), this.f13629b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
