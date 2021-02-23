package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzder implements zzepf<zzdek> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15501a;

    /* renamed from: b */
    private final zzeps<ScheduledExecutorService> f15502b;

    /* renamed from: c */
    private final zzeps<String> f15503c;

    /* renamed from: d */
    private final zzeps<zzcwz> f15504d;

    /* renamed from: e */
    private final zzeps<Context> f15505e;

    /* renamed from: f */
    private final zzeps<zzdnn> f15506f;

    /* renamed from: g */
    private final zzeps<zzcwx> f15507g;

    private zzder(zzeps<zzdzc> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<String> zzeps3, zzeps<zzcwz> zzeps4, zzeps<Context> zzeps5, zzeps<zzdnn> zzeps6, zzeps<zzcwx> zzeps7) {
        this.f15501a = zzeps;
        this.f15502b = zzeps2;
        this.f15503c = zzeps3;
        this.f15504d = zzeps4;
        this.f15505e = zzeps5;
        this.f15506f = zzeps6;
        this.f15507g = zzeps7;
    }

    public static zzder zzb(zzeps<zzdzc> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<String> zzeps3, zzeps<zzcwz> zzeps4, zzeps<Context> zzeps5, zzeps<zzdnn> zzeps6, zzeps<zzcwx> zzeps7) {
        return new zzder(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7);
    }

    public final /* synthetic */ Object get() {
        return new zzdek(this.f15501a.get(), this.f15502b.get(), this.f15503c.get(), this.f15504d.get(), this.f15505e.get(), this.f15506f.get(), this.f15507g.get());
    }
}
