package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbsv implements zzepf<zzbso> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbsp>>> f13758a;

    private zzbsv(zzeps<Set<zzbxy<zzbsp>>> zzeps) {
        this.f13758a = zzeps;
    }

    public static zzbsv zzj(zzeps<Set<zzbxy<zzbsp>>> zzeps) {
        return new zzbsv(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbso(this.f13758a.get());
    }
}
