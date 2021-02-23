package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcka implements zzdru {

    /* renamed from: a */
    private Map<zzdrl, zzckc> f14473a;

    /* renamed from: b */
    private zzts f14474b;

    zzcka(zzts zzts, Map<zzdrl, zzckc> map) {
        this.f14473a = map;
        this.f14474b = zzts;
    }

    public final void zza(zzdrl zzdrl, String str) {
    }

    public final void zza(zzdrl zzdrl, String str, Throwable th) {
        if (this.f14473a.containsKey(zzdrl)) {
            this.f14474b.zza(this.f14473a.get(zzdrl).zzgjy);
        }
    }

    public final void zzb(zzdrl zzdrl, String str) {
        if (this.f14473a.containsKey(zzdrl)) {
            this.f14474b.zza(this.f14473a.get(zzdrl).zzgjw);
        }
    }

    public final void zzc(zzdrl zzdrl, String str) {
        if (this.f14473a.containsKey(zzdrl)) {
            this.f14474b.zza(this.f14473a.get(zzdrl).zzgjx);
        }
    }
}
