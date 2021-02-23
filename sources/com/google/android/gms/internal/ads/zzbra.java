package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbra implements zzepf<C1764bd> {

    /* renamed from: a */
    private final zzeps<Context> f13709a;

    /* renamed from: b */
    private final zzeps<zzdmu> f13710b;

    /* renamed from: c */
    private final zzeps<zzarq> f13711c;

    private zzbra(zzeps<Context> zzeps, zzeps<zzdmu> zzeps2, zzeps<zzarq> zzeps3) {
        this.f13709a = zzeps;
        this.f13710b = zzeps2;
        this.f13711c = zzeps3;
    }

    public static zzbra zzh(zzeps<Context> zzeps, zzeps<zzdmu> zzeps2, zzeps<zzarq> zzeps3) {
        return new zzbra(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new C1764bd(this.f13709a.get(), this.f13710b.get(), this.f13711c.get());
    }
}
