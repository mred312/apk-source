package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.query.QueryInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzzn {

    /* renamed from: a */
    private final String f17194a;

    /* renamed from: b */
    private final Bundle f17195b;

    public zzzn(String str, Bundle bundle) {
        this.f17194a = str;
        this.f17195b = bundle;
    }

    public static String zza(QueryInfo queryInfo) {
        String str = zzwq.zzqi().get(queryInfo);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final String getQuery() {
        return this.f17194a;
    }

    public final Bundle getQueryBundle() {
        return this.f17195b;
    }
}
