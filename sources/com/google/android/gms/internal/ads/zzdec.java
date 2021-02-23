package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdec implements zzepf<zzdea> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15479a;

    /* renamed from: b */
    private final zzeps<Bundle> f15480b;

    private zzdec(zzeps<zzdzc> zzeps, zzeps<Bundle> zzeps2) {
        this.f15479a = zzeps;
        this.f15480b = zzeps2;
    }

    public static zzdec zzbf(zzeps<zzdzc> zzeps, zzeps<Bundle> zzeps2) {
        return new zzdec(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdea(this.f15479a.get(), this.f15480b.get());
    }
}
