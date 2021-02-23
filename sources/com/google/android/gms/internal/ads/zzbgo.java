package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbgo implements zzepf<Context> {

    /* renamed from: a */
    private final zzbgl f13255a;

    public zzbgo(zzbgl zzbgl) {
        this.f13255a = zzbgl;
    }

    public static Context zza(zzbgl zzbgl) {
        return (Context) zzepl.zza(zzbgl.mo16253a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13255a);
    }
}
