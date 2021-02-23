package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzbl;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdnb implements zzbl {

    /* renamed from: a */
    private final JSONObject f15789a;
    @Nullable
    public final String zzdrn;
    @Nullable
    public final String zzdrp;
    public final JSONObject zzgao;

    zzdnb(JsonReader jsonReader) {
        JSONObject zzc = zzbk.zzc(jsonReader);
        this.f15789a = zzc;
        this.zzdrp = zzc.optString("ad_html", (String) null);
        this.zzdrn = zzc.optString("ad_base_url", (String) null);
        this.zzgao = zzc.optJSONObject("ad_json");
    }

    public final void zza(JsonWriter jsonWriter) {
        zzbk.zza(jsonWriter, this.f15789a);
    }
}
