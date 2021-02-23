package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbsn implements zzepf<zzbsl> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbsm>>> f13757a;

    private zzbsn(zzeps<Set<zzbxy<zzbsm>>> zzeps) {
        this.f13757a = zzeps;
    }

    public static zzbsn zzi(zzeps<Set<zzbxy<zzbsm>>> zzeps) {
        return new zzbsn(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbsl(this.f13757a.get());
    }
}
