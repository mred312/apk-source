package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdce implements zzepf<zzdms> {

    /* renamed from: a */
    private final zzeps<Clock> f15411a;

    public zzdce(zzeps<Clock> zzeps) {
        this.f15411a = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (zzdms) zzepl.zza(new zzdms(this.f15411a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
