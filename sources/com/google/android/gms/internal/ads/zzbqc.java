package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqc implements zzepf<zzbxy<zzbry>> {

    /* renamed from: a */
    private final zzeps<zzcke> f13655a;

    /* renamed from: b */
    private final zzeps<Executor> f13656b;

    private zzbqc(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        this.f13655a = zzeps;
        this.f13656b = zzeps2;
    }

    public static zzbqc zzn(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqc(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13655a.get(), this.f13656b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
