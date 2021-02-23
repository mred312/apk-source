package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzahd implements zzahv<zzbdv> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzaza.zzfa("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzaza.zzfa("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = zzp.zzkx().elapsedRealtime() + (Long.parseLong(str4) - zzp.zzkx().currentTimeMillis());
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbdv.zzaan().zzb(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e) {
                    zzaza.zzd("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzaza.zzfa("No value given for CSI experiment.");
                return;
            }
            zzabs zzry = zzbdv.zzaan().zzry();
            if (zzry == null) {
                zzaza.zzfa("No ticker for WebView, dropping experiment ID.");
            } else {
                zzry.zzh("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzaza.zzfa("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzaza.zzfa("No name given for CSI extra.");
            } else {
                zzabs zzry2 = zzbdv.zzaan().zzry();
                if (zzry2 == null) {
                    zzaza.zzfa("No ticker for WebView, dropping extra parameter.");
                } else {
                    zzry2.zzh(str6, str7);
                }
            }
        }
    }
}
