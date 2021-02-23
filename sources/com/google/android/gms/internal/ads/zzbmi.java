package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbmi implements zzepf<C1911fc> {

    /* renamed from: a */
    private final zzeps<zzbob> f13492a;

    /* renamed from: b */
    private final zzeps<Context> f13493b;

    /* renamed from: c */
    private final zzeps<zzdmx> f13494c;

    /* renamed from: d */
    private final zzeps<View> f13495d;

    /* renamed from: e */
    private final zzeps<zzbdv> f13496e;

    /* renamed from: f */
    private final zzeps<zzbnz> f13497f;

    /* renamed from: g */
    private final zzeps<zzccl> f13498g;

    /* renamed from: h */
    private final zzeps<zzbyc> f13499h;

    /* renamed from: i */
    private final zzeps<zzcxi> f13500i;

    /* renamed from: j */
    private final zzeps<Executor> f13501j;

    public zzbmi(zzeps<zzbob> zzeps, zzeps<Context> zzeps2, zzeps<zzdmx> zzeps3, zzeps<View> zzeps4, zzeps<zzbdv> zzeps5, zzeps<zzbnz> zzeps6, zzeps<zzccl> zzeps7, zzeps<zzbyc> zzeps8, zzeps<zzcxi> zzeps9, zzeps<Executor> zzeps10) {
        this.f13492a = zzeps;
        this.f13493b = zzeps2;
        this.f13494c = zzeps3;
        this.f13495d = zzeps4;
        this.f13496e = zzeps5;
        this.f13497f = zzeps6;
        this.f13498g = zzeps7;
        this.f13499h = zzeps8;
        this.f13500i = zzeps9;
        this.f13501j = zzeps10;
    }

    public static C1911fc zza(zzbob zzbob, Context context, zzdmx zzdmx, View view, zzbdv zzbdv, zzbnz zzbnz, zzccl zzccl, zzbyc zzbyc, zzeoz<zzcxi> zzeoz, Executor executor) {
        return new C1911fc(zzbob, context, zzdmx, view, zzbdv, zzbnz, zzccl, zzbyc, zzeoz, executor);
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13492a.get(), this.f13493b.get(), this.f13494c.get(), this.f13495d.get(), this.f13496e.get(), this.f13497f.get(), this.f13498g.get(), this.f13499h.get(), zzepg.zzat(this.f13500i), this.f13501j.get());
    }
}
