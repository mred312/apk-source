package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqv implements zzepf<zzbqu> {

    /* renamed from: a */
    private final zzeps<zzbsl> f13694a;

    /* renamed from: b */
    private final zzeps<zzdmu> f13695b;

    /* renamed from: c */
    private final zzeps<ScheduledExecutorService> f13696c;

    /* renamed from: d */
    private final zzeps<Executor> f13697d;

    private zzbqv(zzeps<zzbsl> zzeps, zzeps<zzdmu> zzeps2, zzeps<ScheduledExecutorService> zzeps3, zzeps<Executor> zzeps4) {
        this.f13694a = zzeps;
        this.f13695b = zzeps2;
        this.f13696c = zzeps3;
        this.f13697d = zzeps4;
    }

    public static zzbqv zzb(zzeps<zzbsl> zzeps, zzeps<zzdmu> zzeps2, zzeps<ScheduledExecutorService> zzeps3, zzeps<Executor> zzeps4) {
        return new zzbqv(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzbqu(this.f13694a.get(), this.f13695b.get(), this.f13696c.get(), this.f13697d.get());
    }
}
