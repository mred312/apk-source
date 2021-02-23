package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqe implements zzepf<zzbxy<zzbsm>> {

    /* renamed from: a */
    private final zzeps<zzbul> f13659a;

    /* renamed from: b */
    private final zzeps<Executor> f13660b;

    private zzbqe(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.f13659a = zzeps;
        this.f13660b = zzeps2;
    }

    public static zzbqe zzp(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqe(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13659a.get(), this.f13660b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
