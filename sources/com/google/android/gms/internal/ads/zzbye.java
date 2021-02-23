package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbye implements zzepf<zzbyc> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbyd>>> f13849a;

    private zzbye(zzeps<Set<zzbxy<zzbyd>>> zzeps) {
        this.f13849a = zzeps;
    }

    public static zzbye zzu(zzeps<Set<zzbxy<zzbyd>>> zzeps) {
        return new zzbye(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbyc(this.f13849a.get());
    }
}
