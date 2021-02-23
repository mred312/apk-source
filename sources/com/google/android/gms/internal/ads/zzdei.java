package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdei implements zzepf<zzdeg> {

    /* renamed from: a */
    private final zzeps<Context> f15486a;

    /* renamed from: b */
    private final zzeps<String> f15487b;

    private zzdei(zzeps<Context> zzeps, zzeps<String> zzeps2) {
        this.f15486a = zzeps;
        this.f15487b = zzeps2;
    }

    public static zzdei zzbg(zzeps<Context> zzeps, zzeps<String> zzeps2) {
        return new zzdei(zzeps, zzeps2);
    }

    public static zzdeg zzs(Context context, String str) {
        return new zzdeg(context, str);
    }

    public final /* synthetic */ Object get() {
        return zzs(this.f15486a.get(), this.f15487b.get());
    }
}
