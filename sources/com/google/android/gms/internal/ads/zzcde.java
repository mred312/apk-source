package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcde implements zzepf<zzcda> {

    /* renamed from: a */
    private final zzeps<zzf> f14131a;

    /* renamed from: b */
    private final zzeps<zzdnn> f14132b;

    /* renamed from: c */
    private final zzeps<zzcci> f14133c;

    /* renamed from: d */
    private final zzeps<zzcce> f14134d;

    /* renamed from: e */
    private final zzeps<zzcdi> f14135e;

    /* renamed from: f */
    private final zzeps<zzcdq> f14136f;

    /* renamed from: g */
    private final zzeps<Executor> f14137g;

    /* renamed from: h */
    private final zzeps<Executor> f14138h;

    /* renamed from: i */
    private final zzeps<zzcbz> f14139i;

    private zzcde(zzeps<zzf> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzcci> zzeps3, zzeps<zzcce> zzeps4, zzeps<zzcdi> zzeps5, zzeps<zzcdq> zzeps6, zzeps<Executor> zzeps7, zzeps<Executor> zzeps8, zzeps<zzcbz> zzeps9) {
        this.f14131a = zzeps;
        this.f14132b = zzeps2;
        this.f14133c = zzeps3;
        this.f14134d = zzeps4;
        this.f14135e = zzeps5;
        this.f14136f = zzeps6;
        this.f14137g = zzeps7;
        this.f14138h = zzeps8;
        this.f14139i = zzeps9;
    }

    public static zzcde zza(zzeps<zzf> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzcci> zzeps3, zzeps<zzcce> zzeps4, zzeps<zzcdi> zzeps5, zzeps<zzcdq> zzeps6, zzeps<Executor> zzeps7, zzeps<Executor> zzeps8, zzeps<zzcbz> zzeps9) {
        return new zzcde(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7, zzeps8, zzeps9);
    }

    public final /* synthetic */ Object get() {
        return new zzcda(this.f14131a.get(), this.f14132b.get(), this.f14133c.get(), this.f14134d.get(), this.f14135e.get(), this.f14136f.get(), this.f14137g.get(), this.f14138h.get(), this.f14139i.get());
    }
}
