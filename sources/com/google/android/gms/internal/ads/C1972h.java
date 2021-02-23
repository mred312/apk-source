package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.h */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1972h extends zzaaq<Long> {
    C1972h(int i, String str, Long l) {
        super(1, str, l, (C1898f) null);
    }

    public final /* synthetic */ Object zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (!bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            return (Long) zzrk();
        }
        String valueOf2 = String.valueOf(getKey());
        return Long.valueOf(bundle.getLong(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
    }

    public final /* synthetic */ Object zzb(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(getKey(), ((Long) zzrk()).longValue()));
    }

    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Object obj) {
        editor.putLong(getKey(), ((Long) obj).longValue());
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzrk()).longValue()));
    }
}
