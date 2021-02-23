package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbxk implements zzepf<zzcum> {

    /* renamed from: a */
    private final zzbwp f13838a;

    /* renamed from: b */
    private final zzeps<Clock> f13839b;

    /* renamed from: c */
    private final zzeps<zzcuo> f13840c;

    /* renamed from: d */
    private final zzeps<zzcrg> f13841d;

    private zzbxk(zzbwp zzbwp, zzeps<Clock> zzeps, zzeps<zzcuo> zzeps2, zzeps<zzcrg> zzeps3) {
        this.f13838a = zzbwp;
        this.f13839b = zzeps;
        this.f13840c = zzeps2;
        this.f13841d = zzeps3;
    }

    public static zzbxk zza(zzbwp zzbwp, zzeps<Clock> zzeps, zzeps<zzcuo> zzeps2, zzeps<zzcrg> zzeps3) {
        return new zzbxk(zzbwp, zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return (zzcum) zzepl.zza(this.f13838a.zza(this.f13839b.get(), this.f13840c.get(), this.f13841d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
