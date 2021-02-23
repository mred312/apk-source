package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbk;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdmz {
    public final int responseCode;
    public final String zzbvf;
    public final List<String> zzdlv;
    public final String zzdvn;
    public final long zzgot;
    public final int zzhhx;
    public final boolean zzhhy;
    @Nullable
    public final zzdmw zzhhz;

    zzdmz(JsonReader jsonReader) {
        List<String> emptyList = Collections.emptyList();
        jsonReader.beginObject();
        String str = "";
        String str2 = str;
        long j = 0;
        zzdmw zzdmw = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("nofill_urls".equals(nextName)) {
                emptyList = zzbk.zza(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if ("is_idless".equals(nextName)) {
                z = jsonReader.nextBoolean();
            } else if ("response_code".equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j = jsonReader.nextLong();
            } else {
                if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcyz)).booleanValue() || !"public_error".equals(nextName) || jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
                    jsonReader.skipValue();
                } else {
                    zzdmw = new zzdmw(jsonReader);
                }
            }
        }
        jsonReader.endObject();
        this.zzdlv = emptyList;
        this.zzhhx = i;
        this.zzbvf = str;
        this.zzdvn = str2;
        this.responseCode = i2;
        this.zzgot = j;
        this.zzhhz = zzdmw;
        this.zzhhy = z;
    }
}
