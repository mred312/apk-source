package com.google.android.gms.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzvr;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class AdapterResponseInfo {
    private final zzvr zzadd;
    private final AdError zzade;

    private AdapterResponseInfo(zzvr zzvr) {
        AdError adError;
        this.zzadd = zzvr;
        zzve zzve = zzvr.zzcia;
        if (zzve == null) {
            adError = null;
        } else {
            adError = zzve.zzpl();
        }
        this.zzade = adError;
    }

    @Nullable
    public static AdapterResponseInfo zza(@Nullable zzvr zzvr) {
        if (zzvr != null) {
            return new AdapterResponseInfo(zzvr);
        }
        return null;
    }

    @Nullable
    public final AdError getAdError() {
        return this.zzade;
    }

    public final String getAdapterClassName() {
        return this.zzadd.zzchy;
    }

    public final Bundle getCredentials() {
        return this.zzadd.zzcib;
    }

    public final long getLatencyMillis() {
        return this.zzadd.zzchz;
    }

    public final String toString() {
        try {
            return zzdr().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzdr() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.zzadd.zzchy);
        jSONObject.put("Latency", this.zzadd.zzchz);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.zzadd.zzcib.keySet()) {
            jSONObject2.put(str, this.zzadd.zzcib.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.zzade;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", adError.zzdr());
        }
        return jSONObject;
    }
}
