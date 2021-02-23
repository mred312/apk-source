package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmw implements zzepf<zzcns> {

    /* renamed from: a */
    private final zzeps<Context> f14610a;

    private zzcmw(zzeps<Context> zzeps) {
        this.f14610a = zzeps;
    }

    public static zzcmw zzad(zzeps<Context> zzeps) {
        return new zzcmw(zzeps);
    }

    public static zzcns zzcj(Context context) {
        return (zzcns) zzepl.zza(new zzcns(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzcj(this.f14610a.get());
    }
}
