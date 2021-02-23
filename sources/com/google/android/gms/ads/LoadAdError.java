package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzwq;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class LoadAdError extends AdError {
    @Nullable
    private final ResponseInfo zzadi;

    public LoadAdError(int i, @NonNull String str, @NonNull String str2, @Nullable AdError adError, @Nullable ResponseInfo responseInfo) {
        super(i, str, str2, adError);
        this.zzadi = responseInfo;
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzczb)).booleanValue()) {
            return this.zzadi;
        }
        return null;
    }

    public final String toString() {
        try {
            return zzdr().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzdr() {
        JSONObject zzdr = super.zzdr();
        ResponseInfo responseInfo = getResponseInfo();
        if (responseInfo == null) {
            zzdr.put("Response Info", "null");
        } else {
            zzdr.put("Response Info", responseInfo.zzdr());
        }
        return zzdr;
    }
}
