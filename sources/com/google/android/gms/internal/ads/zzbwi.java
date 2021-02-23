package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbwi implements zzepf<zzbwd> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbwl>>> f13794a;

    private zzbwi(zzeps<Set<zzbxy<zzbwl>>> zzeps) {
        this.f13794a = zzeps;
    }

    public static zzbwi zzs(zzeps<Set<zzbxy<zzbwl>>> zzeps) {
        return new zzbwi(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbwd(this.f13794a.get());
    }
}
