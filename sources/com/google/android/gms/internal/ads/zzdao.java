package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdao implements zzepf<C2298ps> {

    /* renamed from: a */
    private final zzeps<Set<String>> f15143a;

    private zzdao(zzeps<Set<String>> zzeps) {
        this.f15143a = zzeps;
    }

    public static zzdao zzak(zzeps<Set<String>> zzeps) {
        return new zzdao(zzeps);
    }

    public static C2298ps zzd(Set<String> set) {
        return new C2298ps(set);
    }

    public final /* synthetic */ Object get() {
        return zzd(this.f15143a.get());
    }
}
