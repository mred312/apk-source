package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtc;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcwc<AdT, AdapterT, ListenerT extends zzbtc> implements zzepf<zzcvy<AdT, AdapterT, ListenerT>> {

    /* renamed from: a */
    private final zzeps<zzdro> f14970a;

    /* renamed from: b */
    private final zzeps<zzdzc> f14971b;

    /* renamed from: c */
    private final zzeps<zzcre<AdapterT, ListenerT>> f14972c;

    /* renamed from: d */
    private final zzeps<zzcrh<AdT, AdapterT, ListenerT>> f14973d;

    private zzcwc(zzeps<zzdro> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzcre<AdapterT, ListenerT>> zzeps3, zzeps<zzcrh<AdT, AdapterT, ListenerT>> zzeps4) {
        this.f14970a = zzeps;
        this.f14971b = zzeps2;
        this.f14972c = zzeps3;
        this.f14973d = zzeps4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbtc> zzcwc<AdT, AdapterT, ListenerT> zzf(zzeps<zzdro> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzcre<AdapterT, ListenerT>> zzeps3, zzeps<zzcrh<AdT, AdapterT, ListenerT>> zzeps4) {
        return new zzcwc<>(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzcvy(this.f14970a.get(), this.f14971b.get(), this.f14972c.get(), this.f14973d.get());
    }
}
