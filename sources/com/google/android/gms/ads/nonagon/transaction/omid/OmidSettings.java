package com.google.android.gms.ads.nonagon.transaction.omid;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class OmidSettings {
    private final JSONObject zzhja;

    public OmidSettings(JSONObject jSONObject) {
        this.zzhja = jSONObject;
    }

    public OmidMediaType getMediaType() {
        int optInt = this.zzhja.optInt("media_type", -1);
        if (optInt == 0) {
            return OmidMediaType.DISPLAY;
        }
        if (optInt != 1) {
            return OmidMediaType.UNKNOWN;
        }
        return OmidMediaType.VIDEO;
    }

    @Nullable
    public String getVideoEventsOwner() {
        if (zza.zzhiz[getMediaType().ordinal()] != 1) {
            return "javascript";
        }
        return null;
    }
}
