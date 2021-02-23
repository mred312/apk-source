package com.google.android.gms.ads.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzazh;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zze {
    private Context context;
    private long zzboo = 0;

    public final void zza(Context context2, zzazh zzazh, String str, @Nullable Runnable runnable) {
        zza(context2, zzazh, true, (zzayh) null, str, (String) null, runnable);
    }

    public final void zza(Context context2, zzazh zzazh, String str, zzayh zzayh) {
        zza(context2, zzazh, false, zzayh, zzayh != null ? zzayh.zzxg() : null, str, (Runnable) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r11.zzxe() != false) goto L_0x0054;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(android.content.Context r8, com.google.android.gms.internal.ads.zzazh r9, boolean r10, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzayh r11, java.lang.String r12, @androidx.annotation.Nullable java.lang.String r13, @androidx.annotation.Nullable java.lang.Runnable r14) {
        /*
            r7 = this;
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r0 = r0.elapsedRealtime()
            long r2 = r7.zzboo
            long r0 = r0 - r2
            r2 = 5000(0x1388, double:2.4703E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0017
            java.lang.String r8 = "Not retrying to fetch app settings"
            com.google.android.gms.internal.ads.zzaza.zzfa(r8)
            return
        L_0x0017:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r0 = r0.elapsedRealtime()
            r7.zzboo = r0
            r0 = 0
            r1 = 1
            if (r11 != 0) goto L_0x0027
        L_0x0025:
            r0 = 1
            goto L_0x0054
        L_0x0027:
            long r2 = r11.zzxd()
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r4 = r4.currentTimeMillis()
            long r4 = r4 - r2
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r2 = com.google.android.gms.internal.ads.zzabf.zzcsu
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r2 = r3.zzd(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x004a
            r2 = 1
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            if (r2 != 0) goto L_0x0025
            boolean r11 = r11.zzxe()
            if (r11 != 0) goto L_0x0054
            goto L_0x0025
        L_0x0054:
            if (r0 != 0) goto L_0x0057
            return
        L_0x0057:
            if (r8 != 0) goto L_0x005f
            java.lang.String r8 = "Context not provided to fetch application settings"
            com.google.android.gms.internal.ads.zzaza.zzfa(r8)
            return
        L_0x005f:
            boolean r11 = android.text.TextUtils.isEmpty(r12)
            if (r11 == 0) goto L_0x0071
            boolean r11 = android.text.TextUtils.isEmpty(r13)
            if (r11 == 0) goto L_0x0071
            java.lang.String r8 = "App settings could not be fetched. Required parameters missing"
            com.google.android.gms.internal.ads.zzaza.zzfa(r8)
            return
        L_0x0071:
            android.content.Context r11 = r8.getApplicationContext()
            if (r11 == 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r11 = r8
        L_0x0079:
            r7.context = r11
            com.google.android.gms.internal.ads.zzamc r11 = com.google.android.gms.ads.internal.zzp.zzld()
            android.content.Context r0 = r7.context
            com.google.android.gms.internal.ads.zzaml r9 = r11.zzb(r0, r9)
            com.google.android.gms.internal.ads.zzamh<org.json.JSONObject> r11 = com.google.android.gms.internal.ads.zzamg.zzdjy
            java.lang.String r0 = "google.afma.config.fetchAppSettings"
            com.google.android.gms.internal.ads.zzamd r9 = r9.zza(r0, r11, r11)
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ce }
            r11.<init>()     // Catch:{ Exception -> 0x00ce }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x009e
            java.lang.String r13 = "app_id"
            r11.put(r13, r12)     // Catch:{ Exception -> 0x00ce }
            goto L_0x00a9
        L_0x009e:
            boolean r12 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x00ce }
            if (r12 != 0) goto L_0x00a9
            java.lang.String r12 = "ad_unit_id"
            r11.put(r12, r13)     // Catch:{ Exception -> 0x00ce }
        L_0x00a9:
            java.lang.String r12 = "is_init"
            r11.put(r12, r10)     // Catch:{ Exception -> 0x00ce }
            java.lang.String r10 = "pn"
            java.lang.String r8 = r8.getPackageName()     // Catch:{ Exception -> 0x00ce }
            r11.put(r10, r8)     // Catch:{ Exception -> 0x00ce }
            com.google.android.gms.internal.ads.zzdyz r8 = r9.zzi(r11)     // Catch:{ Exception -> 0x00ce }
            com.google.android.gms.internal.ads.zzdyb r9 = com.google.android.gms.ads.internal.zzd.zzbon     // Catch:{ Exception -> 0x00ce }
            com.google.android.gms.internal.ads.zzdzc r10 = com.google.android.gms.internal.ads.zzazj.zzegu     // Catch:{ Exception -> 0x00ce }
            com.google.android.gms.internal.ads.zzdyz r9 = com.google.android.gms.internal.ads.zzdyr.zzb(r8, r9, (java.util.concurrent.Executor) r10)     // Catch:{ Exception -> 0x00ce }
            if (r14 == 0) goto L_0x00c8
            r8.addListener(r14, r10)     // Catch:{ Exception -> 0x00ce }
        L_0x00c8:
            java.lang.String r8 = "ConfigLoader.maybeFetchNewAppSettings"
            com.google.android.gms.internal.ads.zzazm.zza(r9, r8)     // Catch:{ Exception -> 0x00ce }
            return
        L_0x00ce:
            r8 = move-exception
            java.lang.String r9 = "Error requesting application settings"
            com.google.android.gms.internal.ads.zzaza.zzc(r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zze.zza(android.content.Context, com.google.android.gms.internal.ads.zzazh, boolean, com.google.android.gms.internal.ads.zzayh, java.lang.String, java.lang.String, java.lang.Runnable):void");
    }
}
