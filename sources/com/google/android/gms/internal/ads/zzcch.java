package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbk;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcch extends zzcci {

    /* renamed from: a */
    private final JSONObject f14067a;

    /* renamed from: b */
    private final boolean f14068b;

    /* renamed from: c */
    private final boolean f14069c;

    /* renamed from: d */
    private final boolean f14070d;

    /* renamed from: e */
    private final boolean f14071e;

    public zzcch(zzdmu zzdmu, JSONObject jSONObject) {
        super(zzdmu);
        boolean z = false;
        this.f14067a = zzbk.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        this.f14068b = zzbk.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.f14069c = zzbk.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.f14070d = zzbk.zza(false, jSONObject, "enable_omid");
        if (!(jSONObject == null || jSONObject.optJSONObject("overlay") == null)) {
            z = true;
        }
        this.f14071e = z;
    }

    public final boolean zzamy() {
        return this.f14070d;
    }

    public final JSONObject zzann() {
        JSONObject jSONObject = this.f14067a;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zzgdi.zzduv);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzano() {
        return this.f14071e;
    }

    public final boolean zzanp() {
        return this.f14068b;
    }

    public final boolean zzanq() {
        return this.f14069c;
    }
}
