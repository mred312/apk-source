package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzax;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbja implements zzepf<zzax> {

    /* renamed from: a */
    private final zzeps<Context> f13354a;

    public zzbja(zzeps<Context> zzeps) {
        this.f13354a = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (zzax) zzepl.zza(new zzax(this.f13354a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
