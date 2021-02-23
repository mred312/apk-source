package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkt {
    @Nullable
    public static JSONObject zza(zzdmu zzdmu) {
        try {
            return new JSONObject(zzdmu.zzduv);
        } catch (JSONException unused) {
            return null;
        }
    }
}
