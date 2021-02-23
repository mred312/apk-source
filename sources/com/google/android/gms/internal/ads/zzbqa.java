package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqa implements zzepf<zzbxy<zzva>> {

    /* renamed from: a */
    private final zzeps<zzbul> f13651a;

    /* renamed from: b */
    private final zzeps<Executor> f13652b;

    private zzbqa(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.f13651a = zzeps;
        this.f13652b = zzeps2;
    }

    public static zzbqa zzl(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqa(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13651a.get(), this.f13652b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
