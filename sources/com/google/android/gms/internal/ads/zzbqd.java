package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqd implements zzepf<zzbxy<zzbto>> {

    /* renamed from: a */
    private final zzeps<zzbul> f13657a;

    /* renamed from: b */
    private final zzeps<Executor> f13658b;

    private zzbqd(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.f13657a = zzeps;
        this.f13658b = zzeps2;
    }

    public static zzbqd zzo(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqd(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13657a.get(), this.f13658b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
