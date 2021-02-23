package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzczx {
    public final String zzgxz;
    public String zzgya;
    public Bundle zzgyb = new Bundle();

    public zzczx(JsonReader jsonReader) {
        Map<String, String> hashMap = new HashMap<>();
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName = nextName == null ? "" : nextName;
            nextName.hashCode();
            if (nextName.equals("params")) {
                str = jsonReader.nextString();
            } else if (!nextName.equals("signal_dictionary")) {
                jsonReader.skipValue();
            } else {
                hashMap = zzbk.zzb(jsonReader);
            }
        }
        this.zzgxz = str;
        jsonReader.endObject();
        for (Map.Entry next : hashMap.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                this.zzgyb.putString((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final zzczx mo17070a(Bundle bundle) {
        try {
            this.zzgya = zzp.zzkq().zzc(bundle).toString();
        } catch (JSONException unused) {
            this.zzgya = "{}";
        }
        return this;
    }
}
