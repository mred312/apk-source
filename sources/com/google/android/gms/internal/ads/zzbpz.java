package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpz implements zzepf<zzbxy<zzbru>> {

    /* renamed from: a */
    private final zzeps<zzbul> f13649a;

    /* renamed from: b */
    private final zzeps<Executor> f13650b;

    private zzbpz(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.f13649a = zzeps;
        this.f13650b = zzeps2;
    }

    public static zzbpz zzk(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpz(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13649a.get(), this.f13650b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
