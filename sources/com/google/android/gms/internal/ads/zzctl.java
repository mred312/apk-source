package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzctl implements zzcre<zzdoe, zzcst> {

    /* renamed from: a */
    private final zzciq f14833a;

    public zzctl(zzciq zzciq) {
        this.f14833a = zzciq;
    }

    public final zzcrb<zzdoe, zzcst> zzf(String str, JSONObject jSONObject) {
        zzdoe zzd = this.f14833a.zzd(str, jSONObject);
        if (zzd == null) {
            return null;
        }
        return new zzcrb<>(zzd, new zzcst(), str);
    }
}
