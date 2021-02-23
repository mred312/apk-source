package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcvu implements zzcre<zzapo, zzcst> {

    /* renamed from: a */
    private final zzcwx f14954a;

    public zzcvu(zzcwx zzcwx) {
        this.f14954a = zzcwx;
    }

    public final zzcrb<zzapo, zzcst> zzf(String str, JSONObject jSONObject) {
        zzapo zzgm = this.f14954a.zzgm(str);
        if (zzgm == null) {
            return null;
        }
        return new zzcrb<>(zzgm, new zzcst(), str);
    }
}
