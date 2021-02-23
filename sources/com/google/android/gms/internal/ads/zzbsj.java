package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbsj implements zzepf<zzbsb> {

    /* renamed from: a */
    private final zzeps<zzbsf> f13753a;

    /* renamed from: b */
    private final zzeps<Set<zzbxy<zzbry>>> f13754b;

    /* renamed from: c */
    private final zzeps<Executor> f13755c;

    private zzbsj(zzeps<zzbsf> zzeps, zzeps<Set<zzbxy<zzbry>>> zzeps2, zzeps<Executor> zzeps3) {
        this.f13753a = zzeps;
        this.f13754b = zzeps2;
        this.f13755c = zzeps3;
    }

    public static zzbsj zzj(zzeps<zzbsf> zzeps, zzeps<Set<zzbxy<zzbry>>> zzeps2, zzeps<Executor> zzeps3) {
        return new zzbsj(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzbsb(this.f13753a.get(), this.f13754b.get(), this.f13755c.get());
    }
}
