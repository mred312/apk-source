package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzbk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzagz implements zzahv<Object> {

    /* renamed from: a */
    private final zzagy f12461a;

    public zzagz(zzagy zzagy) {
        this.f12461a = zzagy;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.f12461a != null) {
            String str = map.get("name");
            if (str == null) {
                zzaza.zzez("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey("info")) {
                try {
                    bundle = zzbk.zzh(new JSONObject(map.get("info")));
                } catch (JSONException e) {
                    zzaza.zzc("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzaza.zzey("Failed to convert ad metadata to Bundle.");
            } else {
                this.f12461a.zza(str, bundle);
            }
        }
    }
}
