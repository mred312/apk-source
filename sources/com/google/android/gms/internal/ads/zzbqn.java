package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqn implements zzepf<zzbqo> {

    /* renamed from: a */
    private final zzeps<Context> f13674a;

    /* renamed from: b */
    private final zzeps<zzdnn> f13675b;

    /* renamed from: c */
    private final zzeps<zzazh> f13676c;

    /* renamed from: d */
    private final zzeps<zzf> f13677d;

    /* renamed from: e */
    private final zzeps<zzclp> f13678e;

    private zzbqn(zzeps<Context> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzazh> zzeps3, zzeps<zzf> zzeps4, zzeps<zzclp> zzeps5) {
        this.f13674a = zzeps;
        this.f13675b = zzeps2;
        this.f13676c = zzeps3;
        this.f13677d = zzeps4;
        this.f13678e = zzeps5;
    }

    public static zzbqn zzb(zzeps<Context> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzazh> zzeps3, zzeps<zzf> zzeps4, zzeps<zzclp> zzeps5) {
        return new zzbqn(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzbqo(this.f13674a.get(), this.f13675b.get(), this.f13676c.get(), this.f13677d.get(), this.f13678e.get());
    }
}
