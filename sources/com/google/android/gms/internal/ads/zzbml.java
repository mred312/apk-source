package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbml implements zzepf<View> {

    /* renamed from: a */
    private final zzbmh f13502a;

    public zzbml(zzbmh zzbmh) {
        this.f13502a = zzbmh;
    }

    public static View zza(zzbmh zzbmh) {
        return (View) zzepl.zza(zzbmh.zzaiz(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13502a);
    }
}
