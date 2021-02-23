package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzczl implements zzepf<zzcyx> {

    /* renamed from: a */
    private final zzeps<zzbgm> f15089a;

    /* renamed from: b */
    private final zzeps<Context> f15090b;

    /* renamed from: c */
    private final zzeps<zzef> f15091c;

    /* renamed from: d */
    private final zzeps<zzazh> f15092d;

    /* renamed from: e */
    private final zzeps<zzdod<zzcgh>> f15093e;

    /* renamed from: f */
    private final zzeps<zzdzc> f15094f;

    /* renamed from: g */
    private final zzeps<ScheduledExecutorService> f15095g;

    public zzczl(zzeps<zzbgm> zzeps, zzeps<Context> zzeps2, zzeps<zzef> zzeps3, zzeps<zzazh> zzeps4, zzeps<zzdod<zzcgh>> zzeps5, zzeps<zzdzc> zzeps6, zzeps<ScheduledExecutorService> zzeps7) {
        this.f15089a = zzeps;
        this.f15090b = zzeps2;
        this.f15091c = zzeps3;
        this.f15092d = zzeps4;
        this.f15093e = zzeps5;
        this.f15094f = zzeps6;
        this.f15095g = zzeps7;
    }

    public final /* synthetic */ Object get() {
        return new zzcyx(this.f15089a.get(), this.f15090b.get(), this.f15091c.get(), this.f15092d.get(), this.f15093e.get(), this.f15094f.get(), this.f15095g.get());
    }
}
