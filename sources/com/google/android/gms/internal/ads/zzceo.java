package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzceo {

    /* renamed from: a */
    private final zzdzc f14194a;

    /* renamed from: b */
    private final zzces f14195b;

    /* renamed from: c */
    private final zzcfc f14196c;

    public zzceo(zzdzc zzdzc, zzces zzces, zzcfc zzcfc) {
        this.f14194a = zzdzc;
        this.f14195b = zzces;
        this.f14196c = zzcfc;
    }

    public final zzdyz<zzcce> zza(zzdnj zzdnj, zzdmu zzdmu, JSONObject jSONObject) {
        zzdyz zzb;
        JSONObject jSONObject2 = jSONObject;
        zzdnj zzdnj2 = zzdnj;
        zzdyz zze = this.f14194a.zze(new C1917fi(this, zzdnj, zzdmu, jSONObject2));
        zzdyz<List<zzadv>> zzd = this.f14195b.zzd(jSONObject2, "images");
        zzdyz<zzadv> zzc = this.f14195b.zzc(jSONObject2, "secondary_image");
        zzdyz<zzadv> zzc2 = this.f14195b.zzc(jSONObject2, "app_icon");
        zzdyz<zzadq> zze2 = this.f14195b.zze(jSONObject2, "attribution");
        zzdyz<zzbdv> zzm = this.f14195b.zzm(jSONObject2);
        zzces zzces = this.f14195b;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzb = zzdyr.zzag(null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzb = zzdyr.zzag(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzb = zzdyr.zzag(null);
                } else {
                    zzb = zzdyr.zzb(zzdyr.zzag(null), new C2139li(zzces, optString), (Executor) zzazj.zzegt);
                }
            }
        }
        zzdyz zzdyz = zzb;
        zzdyz<List<zzcfd>> zzg = this.f14196c.zzg(jSONObject2, "custom_assets");
        return zzdyr.zza((zzdyz<? extends V>[]) new zzdyz[]{zze, zzd, zzc, zzc2, zze2, zzm, zzdyz, zzg}).zza(new C1954gi(this, zze, zzd, zzc2, zzc, zze2, jSONObject, zzm, zzdyz, zzg), this.f14194a);
    }
}
