package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqk implements zzepf<zzbxy<zzva>> {

    /* renamed from: a */
    private final zzeps<zzcke> f13670a;

    /* renamed from: b */
    private final zzeps<Executor> f13671b;

    private zzbqk(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        this.f13670a = zzeps;
        this.f13671b = zzeps2;
    }

    public static zzbqk zzu(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqk(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13670a.get(), this.f13671b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
