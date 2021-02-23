package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbla implements zzepf<View> {

    /* renamed from: a */
    private final zzbkx f13458a;

    public zzbla(zzbkx zzbkx) {
        this.f13458a = zzbkx;
    }

    public static View zza(zzbkx zzbkx) {
        return (View) zzepl.zza(zzbkx.zzain(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13458a);
    }
}
