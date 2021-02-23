package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckd implements zzepf<zzcke> {

    /* renamed from: a */
    private final zzeps<Context> f14477a;

    /* renamed from: b */
    private final zzeps<zzdoa> f14478b;

    /* renamed from: c */
    private final zzeps<zzckq> f14479c;

    /* renamed from: d */
    private final zzeps<zzdnj> f14480d;

    /* renamed from: e */
    private final zzeps<zzdmu> f14481e;

    /* renamed from: f */
    private final zzeps<zzcqo> f14482f;

    private zzckd(zzeps<Context> zzeps, zzeps<zzdoa> zzeps2, zzeps<zzckq> zzeps3, zzeps<zzdnj> zzeps4, zzeps<zzdmu> zzeps5, zzeps<zzcqo> zzeps6) {
        this.f14477a = zzeps;
        this.f14478b = zzeps2;
        this.f14479c = zzeps3;
        this.f14480d = zzeps4;
        this.f14481e = zzeps5;
        this.f14482f = zzeps6;
    }

    public static zzckd zza(zzeps<Context> zzeps, zzeps<zzdoa> zzeps2, zzeps<zzckq> zzeps3, zzeps<zzdnj> zzeps4, zzeps<zzdmu> zzeps5, zzeps<zzcqo> zzeps6) {
        return new zzckd(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6);
    }

    public final /* synthetic */ Object get() {
        return new zzcke(this.f14477a.get(), this.f14478b.get(), this.f14479c.get(), this.f14480d.get(), this.f14481e.get(), this.f14482f.get());
    }
}
