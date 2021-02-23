package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdfd implements zzdfi<zzdfj<Bundle>> {

    /* renamed from: a */
    private final zzdzc f15529a;

    /* renamed from: b */
    private final Context f15530b;

    zzdfd(zzdzc zzdzc, Context context) {
        this.f15529a = zzdzc;
        this.f15530b = context;
    }

    public static Bundle zza(Context context, JSONArray jSONArray) {
        int i;
        Object obj;
        SharedPreferences sharedPreferences;
        String str;
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            String optString = optJSONObject.optString("bk");
            String optString2 = optJSONObject.optString("sk");
            int optInt = optJSONObject.optInt("type", -1);
            if (optInt == 0) {
                i = C2188mu.f10015a;
            } else if (optInt == 1) {
                i = C2188mu.f10016b;
            } else if (optInt != 2) {
                i = 0;
            } else {
                i = C2188mu.f10017c;
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && i != 0) {
                String[] split = optString2.split("/");
                if (split.length > 2 || split.length == 0) {
                    obj = null;
                } else {
                    if (split.length == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str = split[0];
                    } else {
                        sharedPreferences = context.getSharedPreferences(split[0], 0);
                        str = split[1];
                    }
                    obj = sharedPreferences.getAll().get(str);
                }
                if (obj != null) {
                    int i3 = C2114ku.f9778a[i - 1];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3 && (obj instanceof Boolean)) {
                                bundle.putBoolean(optString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(optString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(optString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(optString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(optString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdfj mo17092a() {
        String str = (String) zzwq.zzqe().zzd(zzabf.zzcwq);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new C2151lu(zza(this.f15530b, new JSONArray(str)));
        } catch (JSONException e) {
            zzaza.zzb("JSON parsing error", e);
            return null;
        }
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        return this.f15529a.zze(new C2077ju(this));
    }
}
