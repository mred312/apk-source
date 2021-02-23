package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbdc implements zzahv<zzbbe> {
    /* renamed from: a */
    private static Integer m7719a(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzaza.zzfa(sb.toString());
            return null;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbcx zzbcx;
        zzbbe zzbbe = (zzbbe) obj;
        if (zzaza.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzaza.zzeb(sb.toString());
        }
        zzp.zzlm();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            Integer a = m7719a(map, "periodicReportIntervalMs");
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        String valueOf2 = String.valueOf(str2);
                        zzaza.zzfa(valueOf2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(valueOf2) : new String("Malformed demuxed URL list for precache: "));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (zzbcu.m7710a(zzbbe) != null) {
                    zzaza.zzfa("Precache task is already running.");
                    return;
                } else if (zzbbe.zzaak() == null) {
                    zzaza.zzfa("Precache requires a dependency provider.");
                    return;
                } else {
                    zzbbf zzbbf = new zzbbf((String) map.get("flags"));
                    Integer a2 = m7719a(map, "player");
                    if (a2 == null) {
                        a2 = 0;
                    }
                    if (a != null) {
                        zzbbe.zzdq(a.intValue());
                    }
                    zzbcx = zzbbe.zzaak().zzboh.zza(zzbbe, a2.intValue(), (String) null, zzbbf);
                    new zzbcs(zzbbe, zzbcx, str, strArr).zzxl();
                }
            } else {
                zzbcs a3 = zzbcu.m7710a(zzbbe);
                if (a3 != null) {
                    zzbcx = a3.f13148b;
                } else {
                    zzaza.zzfa("Precache must specify a source.");
                    return;
                }
            }
            Integer a4 = m7719a(map, "minBufferMs");
            if (a4 != null) {
                zzbcx.zzdl(a4.intValue());
            }
            Integer a5 = m7719a(map, "maxBufferMs");
            if (a5 != null) {
                zzbcx.zzdm(a5.intValue());
            }
            Integer a6 = m7719a(map, "bufferForPlaybackMs");
            if (a6 != null) {
                zzbcx.zzdn(a6.intValue());
            }
            Integer a7 = m7719a(map, "bufferForPlaybackAfterRebufferMs");
            if (a7 != null) {
                zzbcx.zzdo(a7.intValue());
            }
        } else if (!zzbcu.zzc(zzbbe)) {
            zzaza.zzfa("Precache abort but no precache task running.");
        }
    }
}
