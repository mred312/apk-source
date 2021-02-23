package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckb implements zzepf<zzcka> {

    /* renamed from: a */
    private final zzeps<zzts> f14475a;

    /* renamed from: b */
    private final zzeps<Map<zzdrl, zzckc>> f14476b;

    private zzckb(zzeps<zzts> zzeps, zzeps<Map<zzdrl, zzckc>> zzeps2) {
        this.f14475a = zzeps;
        this.f14476b = zzeps2;
    }

    public static zzckb zzai(zzeps<zzts> zzeps, zzeps<Map<zzdrl, zzckc>> zzeps2) {
        return new zzckb(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcka(this.f14475a.get(), this.f14476b.get());
    }
}
