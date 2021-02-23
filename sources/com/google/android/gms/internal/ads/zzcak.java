package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzue;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcak implements zzepf<zzcah> {

    /* renamed from: a */
    private final zzeps<Context> f13906a;

    /* renamed from: b */
    private final zzeps<zzbdv> f13907b;

    /* renamed from: c */
    private final zzeps<zzdmu> f13908c;

    /* renamed from: d */
    private final zzeps<zzazh> f13909d;

    /* renamed from: e */
    private final zzeps<zzue.zza.C3992zza> f13910e;

    private zzcak(zzeps<Context> zzeps, zzeps<zzbdv> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzazh> zzeps4, zzeps<zzue.zza.C3992zza> zzeps5) {
        this.f13906a = zzeps;
        this.f13907b = zzeps2;
        this.f13908c = zzeps3;
        this.f13909d = zzeps4;
        this.f13910e = zzeps5;
    }

    public static zzcak zzc(zzeps<Context> zzeps, zzeps<zzbdv> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzazh> zzeps4, zzeps<zzue.zza.C3992zza> zzeps5) {
        return new zzcak(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzcah(this.f13906a.get(), this.f13907b.get(), this.f13908c.get(), this.f13909d.get(), this.f13910e.get());
    }
}
