package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbbf {
    public final boolean zzekr;
    public final int zzeks;
    public final int zzekt;
    public final int zzeku;
    public final int zzekw;
    public final int zzekx;
    public final int zzeky;
    public final int zzekz;
    public final boolean zzela;
    public final int zzelb;

    public zzbbf(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzekr = m7663a(jSONObject, "aggressive_media_codec_release", zzabf.zzcms);
        this.zzeks = m7665c(jSONObject, "byte_buffer_precache_limit", zzabf.zzcma);
        this.zzekt = m7665c(jSONObject, "exo_cache_buffer_size", zzabf.zzcmh);
        this.zzeku = m7665c(jSONObject, "exo_connect_timeout_millis", zzabf.zzclw);
        m7666d(jSONObject, "exo_player_version", zzabf.zzclv);
        this.zzekw = m7665c(jSONObject, "exo_read_timeout_millis", zzabf.zzclx);
        this.zzekx = m7665c(jSONObject, "load_check_interval_bytes", zzabf.zzcly);
        this.zzeky = m7665c(jSONObject, "player_precache_limit", zzabf.zzclz);
        this.zzekz = m7665c(jSONObject, "socket_receive_buffer_size", zzabf.zzcmb);
        this.zzela = m7663a(jSONObject, "use_cache_data_source", zzabf.zzcte);
        this.zzelb = m7665c(jSONObject, "min_retry_count", zzabf.zzcmd);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzaaq, com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m7663a(org.json.JSONObject r1, java.lang.String r2, com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3) {
        /*
            com.google.android.gms.internal.ads.zzabb r0 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r3 = r0.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            boolean r1 = m7664b(r1, r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbf.m7663a(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzaaq):boolean");
    }

    /* renamed from: b */
    private static boolean m7664b(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzaaq, com.google.android.gms.internal.ads.zzaaq<java.lang.Integer>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m7665c(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            int r0 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzabb r0 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r0.zzd(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbf.m7665c(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzaaq):int");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzaaq, com.google.android.gms.internal.ads.zzaaq<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m7666d(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzaaq<java.lang.String> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzabb r0 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r0.zzd(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbf.m7666d(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzaaq):java.lang.String");
    }
}
