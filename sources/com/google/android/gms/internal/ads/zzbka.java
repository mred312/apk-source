package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbka implements zzepf<zzbjv> {

    /* renamed from: a */
    private final zzeps<Context> f13385a;

    /* renamed from: b */
    private final zzeps<Executor> f13386b;

    /* renamed from: c */
    private final zzeps<ScheduledExecutorService> f13387c;

    /* renamed from: d */
    private final zzeps<zzdnj> f13388d;

    /* renamed from: e */
    private final zzeps<zzdmu> f13389e;

    /* renamed from: f */
    private final zzeps<zzdrx> f13390f;

    /* renamed from: g */
    private final zzeps<zzdnv> f13391g;

    /* renamed from: h */
    private final zzeps<View> f13392h;

    /* renamed from: i */
    private final zzeps<zzef> f13393i;

    /* renamed from: j */
    private final zzeps<zzacg> f13394j;

    /* renamed from: k */
    private final zzeps<zzacl> f13395k;

    private zzbka(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<ScheduledExecutorService> zzeps3, zzeps<zzdnj> zzeps4, zzeps<zzdmu> zzeps5, zzeps<zzdrx> zzeps6, zzeps<zzdnv> zzeps7, zzeps<View> zzeps8, zzeps<zzef> zzeps9, zzeps<zzacg> zzeps10, zzeps<zzacl> zzeps11) {
        this.f13385a = zzeps;
        this.f13386b = zzeps2;
        this.f13387c = zzeps3;
        this.f13388d = zzeps4;
        this.f13389e = zzeps5;
        this.f13390f = zzeps6;
        this.f13391g = zzeps7;
        this.f13392h = zzeps8;
        this.f13393i = zzeps9;
        this.f13394j = zzeps10;
        this.f13395k = zzeps11;
    }

    public static zzbka zza(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<ScheduledExecutorService> zzeps3, zzeps<zzdnj> zzeps4, zzeps<zzdmu> zzeps5, zzeps<zzdrx> zzeps6, zzeps<zzdnv> zzeps7, zzeps<View> zzeps8, zzeps<zzef> zzeps9, zzeps<zzacg> zzeps10, zzeps<zzacl> zzeps11) {
        return new zzbka(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7, zzeps8, zzeps9, zzeps10, zzeps11);
    }

    public final /* synthetic */ Object get() {
        return new zzbjv(this.f13385a.get(), this.f13386b.get(), this.f13387c.get(), this.f13388d.get(), this.f13389e.get(), this.f13390f.get(), this.f13391g.get(), this.f13392h.get(), this.f13393i.get(), this.f13394j.get(), this.f13395k.get());
    }
}
