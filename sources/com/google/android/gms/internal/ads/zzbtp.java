package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbtp implements zzepf<zzbtn> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbto>>> f13763a;

    private zzbtp(zzeps<Set<zzbxy<zzbto>>> zzeps) {
        this.f13763a = zzeps;
    }

    public static zzbtp zzn(zzeps<Set<zzbxy<zzbto>>> zzeps) {
        return new zzbtp(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbtn(this.f13763a.get());
    }
}
