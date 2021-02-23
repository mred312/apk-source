package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbix implements zzepf<zzdst> {

    /* renamed from: a */
    private final zzeps<Context> f13352a;

    public zzbix(zzeps<Context> zzeps) {
        this.f13352a = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (zzdst) zzepl.zza(new zzdst(this.f13352a.get(), zzp.zzle().zzyw()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
