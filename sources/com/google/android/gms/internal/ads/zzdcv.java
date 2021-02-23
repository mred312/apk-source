package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdcv implements zzepf<zzdct> {

    /* renamed from: a */
    private final zzeps<Context> f15433a;

    /* renamed from: b */
    private final zzeps<zzdzc> f15434b;

    private zzdcv(zzeps<Context> zzeps, zzeps<zzdzc> zzeps2) {
        this.f15433a = zzeps;
        this.f15434b = zzeps2;
    }

    public static zzdcv zzbc(zzeps<Context> zzeps, zzeps<zzdzc> zzeps2) {
        return new zzdcv(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdct(this.f15433a.get(), this.f15434b.get());
    }
}
