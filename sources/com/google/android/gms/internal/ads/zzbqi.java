package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqi implements zzepf<zzbxy<zzbub>> {

    /* renamed from: a */
    private final zzeps<zzbul> f13666a;

    /* renamed from: b */
    private final zzeps<Executor> f13667b;

    private zzbqi(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.f13666a = zzeps;
        this.f13667b = zzeps2;
    }

    public static zzbqi zzs(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqi(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13666a.get(), this.f13667b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
