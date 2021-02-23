package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdcr implements zzepf<zzdcn> {

    /* renamed from: a */
    private final zzeps<Context> f15428a;

    /* renamed from: b */
    private final zzeps<zzdzc> f15429b;

    private zzdcr(zzeps<Context> zzeps, zzeps<zzdzc> zzeps2) {
        this.f15428a = zzeps;
        this.f15429b = zzeps2;
    }

    public static zzdcn zza(Context context, zzdzc zzdzc) {
        return new zzdcn(context, zzdzc);
    }

    public static zzdcr zzbb(zzeps<Context> zzeps, zzeps<zzdzc> zzeps2) {
        return new zzdcr(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.f15428a.get(), this.f15429b.get());
    }
}
