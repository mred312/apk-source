package com.google.android.gms.ads;

import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzve;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class AdError {
    public static final String UNDEFINED_DOMAIN = "undefined";
    private final int code;
    @NonNull
    private final String zzacm;
    @NonNull
    private final String zzacn;
    @Nullable
    private final AdError zzaco;

    public AdError(int i, @NonNull String str, @NonNull String str2) {
        this.code = i;
        this.zzacm = str;
        this.zzacn = str2;
        this.zzaco = null;
    }

    @Nullable
    public AdError getCause() {
        return this.zzaco;
    }

    public int getCode() {
        return this.code;
    }

    @NonNull
    public String getDomain() {
        return this.zzacn;
    }

    @NonNull
    public String getMessage() {
        return this.zzacm;
    }

    public String toString() {
        try {
            return zzdr().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @NonNull
    public final zzve zzdq() {
        zzve zzve;
        if (this.zzaco == null) {
            zzve = null;
        } else {
            AdError adError = this.zzaco;
            zzve = new zzve(adError.code, adError.zzacm, adError.zzacn, (zzve) null, (IBinder) null);
        }
        return new zzve(this.code, this.zzacm, this.zzacn, zzve, (IBinder) null);
    }

    public JSONObject zzdr() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.code);
        jSONObject.put("Message", this.zzacm);
        jSONObject.put("Domain", this.zzacn);
        AdError adError = this.zzaco;
        if (adError == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", adError.zzdr());
        }
        return jSONObject;
    }

    public AdError(int i, @NonNull String str, @NonNull String str2, @NonNull AdError adError) {
        this.code = i;
        this.zzacm = str;
        this.zzacn = str2;
        this.zzaco = adError;
    }
}
