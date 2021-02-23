package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaig implements zzahv<Object> {

    /* renamed from: a */
    private final zzaij f12478a;

    private zzaig(zzaij zzaij) {
        this.f12478a = zzaij;
    }

    public static void zza(zzbdv zzbdv, zzaij zzaij) {
        zzbdv.zza("/reward", (zzahv<? super zzbdv>) new zzaig(zzaij));
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzava zzava = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzava = new zzava(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzaza.zzd("Unable to parse reward amount.", e);
            }
            this.f12478a.zza(zzava);
        } else if ("video_start".equals(str)) {
            this.f12478a.zztl();
        } else if ("video_complete".equals(str)) {
            this.f12478a.zztm();
        }
    }
}
