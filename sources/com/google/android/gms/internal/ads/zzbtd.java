package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbtd implements zzepf<zzbsu> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbru>>> f13759a;

    private zzbtd(zzeps<Set<zzbxy<zzbru>>> zzeps) {
        this.f13759a = zzeps;
    }

    public static zzbtd zzk(zzeps<Set<zzbxy<zzbru>>> zzeps) {
        return new zzbtd(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbsu(this.f13759a.get());
    }
}
