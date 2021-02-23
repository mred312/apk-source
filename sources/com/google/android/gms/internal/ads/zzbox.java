package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbox implements zzepf<zzbxy<zzbsm>> {

    /* renamed from: a */
    private final zzeps<zzbtw> f13599a;

    /* renamed from: b */
    private final zzeps<Executor> f13600b;

    private zzbox(zzeps<zzbtw> zzeps, zzeps<Executor> zzeps2) {
        this.f13599a = zzeps;
        this.f13600b = zzeps2;
    }

    public static zzbox zzb(zzeps<zzbtw> zzeps, zzeps<Executor> zzeps2) {
        return new zzbox(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13599a.get(), this.f13600b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
