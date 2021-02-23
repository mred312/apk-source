package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmt implements zzepf<String> {

    /* renamed from: a */
    private final zzeps<Context> f14607a;

    private zzcmt(zzeps<Context> zzeps) {
        this.f14607a = zzeps;
    }

    public static zzcmt zzac(zzeps<Context> zzeps) {
        return new zzcmt(zzeps);
    }

    public static String zzci(Context context) {
        return (String) zzepl.zza(context.getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzci(this.f14607a.get());
    }
}
