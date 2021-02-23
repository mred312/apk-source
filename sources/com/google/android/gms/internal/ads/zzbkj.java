package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkj implements zzepf<zzbki> {

    /* renamed from: a */
    private final zzeps<zzamq> f13411a;

    /* renamed from: b */
    private final zzeps<zzbkg> f13412b;

    /* renamed from: c */
    private final zzeps<Executor> f13413c;

    /* renamed from: d */
    private final zzeps<zzbjz> f13414d;

    /* renamed from: e */
    private final zzeps<Clock> f13415e;

    private zzbkj(zzeps<zzamq> zzeps, zzeps<zzbkg> zzeps2, zzeps<Executor> zzeps3, zzeps<zzbjz> zzeps4, zzeps<Clock> zzeps5) {
        this.f13411a = zzeps;
        this.f13412b = zzeps2;
        this.f13413c = zzeps3;
        this.f13414d = zzeps4;
        this.f13415e = zzeps5;
    }

    public static zzbkj zza(zzeps<zzamq> zzeps, zzeps<zzbkg> zzeps2, zzeps<Executor> zzeps3, zzeps<zzbjz> zzeps4, zzeps<Clock> zzeps5) {
        return new zzbkj(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzbki(this.f13411a.get(), this.f13412b.get(), this.f13413c.get(), this.f13414d.get(), this.f13415e.get());
    }
}
