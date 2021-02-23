package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbrp extends zzyq {

    /* renamed from: a */
    private final String f13744a;

    /* renamed from: b */
    private final String f13745b;

    /* renamed from: c */
    private final List<zzvr> f13746c;

    public zzbrp(zzdmu zzdmu, String str, zzcrg zzcrg) {
        String str2;
        String str3 = null;
        if (zzdmu == null) {
            str2 = null;
        } else {
            str2 = zzdmu.zzfxo;
        }
        this.f13745b = str2;
        str3 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? m7858a(zzdmu) : str3;
        this.f13744a = str3 != null ? str3 : str;
        this.f13746c = zzcrg.getAdapterResponses();
    }

    /* renamed from: a */
    private static String m7858a(zzdmu zzdmu) {
        try {
            return zzdmu.zzhha.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    public final List<zzvr> getAdapterResponses() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzczb)).booleanValue()) {
            return null;
        }
        return this.f13746c;
    }

    public final String getMediationAdapterClassName() {
        return this.f13744a;
    }

    public final String getResponseId() {
        return this.f13745b;
    }
}
