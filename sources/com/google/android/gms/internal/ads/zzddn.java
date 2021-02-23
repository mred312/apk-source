package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddn implements zzdfi<zzddk> {

    /* renamed from: a */
    private final zzdzc f15454a;

    /* renamed from: b */
    private final zzdnn f15455b;

    /* renamed from: c */
    private final PackageInfo f15456c;

    /* renamed from: d */
    private final zzf f15457d;

    public zzddn(zzdzc zzdzc, zzdnn zzdnn, @Nullable PackageInfo packageInfo, zzf zzf) {
        this.f15454a = zzdzc;
        this.f15455b = zzdnn;
        this.f15456c = packageInfo;
        this.f15457d = zzf;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f5, code lost:
        if (r9 == 3) goto L_0x011a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void mo17083a(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "native_version"
            r1 = 3
            r10.putInt(r0, r1)
            java.lang.String r0 = "native_templates"
            r10.putStringArrayList(r0, r9)
            com.google.android.gms.internal.ads.zzdnn r9 = r8.f15455b
            java.util.ArrayList<java.lang.String> r9 = r9.zzhir
            java.lang.String r0 = "native_custom_templates"
            r10.putStringArrayList(r0, r9)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzabf.zzcsc
            com.google.android.gms.internal.ads.zzabb r0 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r9 = r0.zzd(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            java.lang.String r0 = "landscape"
            java.lang.String r2 = "portrait"
            java.lang.String r3 = "any"
            java.lang.String r4 = "unknown"
            r5 = 2
            r6 = 1
            if (r9 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzdnn r9 = r8.f15455b
            com.google.android.gms.internal.ads.zzadz r9 = r9.zzdnh
            int r9 = r9.versionCode
            if (r9 <= r1) goto L_0x0061
            java.lang.String r9 = "enable_native_media_orientation"
            r10.putBoolean(r9, r6)
            com.google.android.gms.internal.ads.zzdnn r9 = r8.f15455b
            com.google.android.gms.internal.ads.zzadz r9 = r9.zzdnh
            int r9 = r9.zzbnn
            if (r9 == r6) goto L_0x0055
            if (r9 == r5) goto L_0x0053
            if (r9 == r1) goto L_0x0051
            r7 = 4
            if (r9 == r7) goto L_0x004e
            r9 = r4
            goto L_0x0056
        L_0x004e:
            java.lang.String r9 = "square"
            goto L_0x0056
        L_0x0051:
            r9 = r2
            goto L_0x0056
        L_0x0053:
            r9 = r0
            goto L_0x0056
        L_0x0055:
            r9 = r3
        L_0x0056:
            boolean r7 = r4.equals(r9)
            if (r7 != 0) goto L_0x0061
            java.lang.String r7 = "native_media_orientation"
            r10.putString(r7, r9)
        L_0x0061:
            com.google.android.gms.internal.ads.zzdnn r9 = r8.f15455b
            com.google.android.gms.internal.ads.zzadz r9 = r9.zzdnh
            int r9 = r9.zzbnm
            if (r9 == 0) goto L_0x0071
            if (r9 == r6) goto L_0x006f
            if (r9 == r5) goto L_0x0072
            r0 = r4
            goto L_0x0072
        L_0x006f:
            r0 = r2
            goto L_0x0072
        L_0x0071:
            r0 = r3
        L_0x0072:
            boolean r9 = r4.equals(r0)
            if (r9 != 0) goto L_0x007d
            java.lang.String r9 = "native_image_orientation"
            r10.putString(r9, r0)
        L_0x007d:
            com.google.android.gms.internal.ads.zzdnn r9 = r8.f15455b
            com.google.android.gms.internal.ads.zzadz r9 = r9.zzdnh
            boolean r9 = r9.zzbno
            java.lang.String r0 = "native_multiple_images"
            r10.putBoolean(r0, r9)
            com.google.android.gms.internal.ads.zzdnn r9 = r8.f15455b
            com.google.android.gms.internal.ads.zzadz r9 = r9.zzdnh
            boolean r9 = r9.zzbnr
            java.lang.String r0 = "use_custom_mute"
            r10.putBoolean(r0, r9)
            android.content.pm.PackageInfo r9 = r8.f15456c
            if (r9 != 0) goto L_0x0099
            r9 = 0
            goto L_0x009b
        L_0x0099:
            int r9 = r9.versionCode
        L_0x009b:
            com.google.android.gms.ads.internal.util.zzf r0 = r8.f15457d
            int r0 = r0.zzxu()
            if (r9 <= r0) goto L_0x00ad
            com.google.android.gms.ads.internal.util.zzf r0 = r8.f15457d
            r0.zzya()
            com.google.android.gms.ads.internal.util.zzf r0 = r8.f15457d
            r0.zzde(r9)
        L_0x00ad:
            com.google.android.gms.ads.internal.util.zzf r9 = r8.f15457d
            org.json.JSONObject r9 = r9.zzxz()
            if (r9 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzdnn r0 = r8.f15455b
            java.lang.String r0 = r0.zzhip
            org.json.JSONArray r9 = r9.optJSONArray(r0)
            if (r9 == 0) goto L_0x00c4
            java.lang.String r9 = r9.toString()
            goto L_0x00c5
        L_0x00c4:
            r9 = 0
        L_0x00c5:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x00d0
            java.lang.String r0 = "native_advanced_settings"
            r10.putString(r0, r9)
        L_0x00d0:
            com.google.android.gms.internal.ads.zzdnn r9 = r8.f15455b
            int r9 = r9.zzgwz
            if (r9 <= r6) goto L_0x00db
            java.lang.String r0 = "max_num_ads"
            r10.putInt(r0, r9)
        L_0x00db:
            com.google.android.gms.internal.ads.zzdnn r9 = r8.f15455b
            com.google.android.gms.internal.ads.zzajl r9 = r9.zzdui
            if (r9 == 0) goto L_0x012c
            java.lang.String r0 = r9.zzdhu
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0120
            int r0 = r9.versionCode
            java.lang.String r2 = "p"
            java.lang.String r3 = "l"
            if (r0 < r5) goto L_0x00f8
            int r9 = r9.zzbnn
            if (r9 == r5) goto L_0x0119
            if (r9 == r1) goto L_0x011a
            goto L_0x0119
        L_0x00f8:
            int r9 = r9.zzdht
            if (r9 == r6) goto L_0x0119
            if (r9 == r5) goto L_0x011a
            r0 = 52
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Instream ad video aspect ratio "
            r1.append(r0)
            r1.append(r9)
            java.lang.String r9 = " is wrong."
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.google.android.gms.internal.ads.zzaza.zzey(r9)
        L_0x0119:
            r2 = r3
        L_0x011a:
            java.lang.String r9 = "ia_var"
            r10.putString(r9, r2)
            goto L_0x0127
        L_0x0120:
            java.lang.String r9 = r9.zzdhu
            java.lang.String r0 = "ad_tag"
            r10.putString(r0, r9)
        L_0x0127:
            java.lang.String r9 = "instr"
            r10.putBoolean(r9, r6)
        L_0x012c:
            com.google.android.gms.internal.ads.zzdnn r9 = r8.f15455b
            com.google.android.gms.internal.ads.zzagd r9 = r9.zzaun()
            if (r9 == 0) goto L_0x0139
            java.lang.String r9 = "has_delayed_banner_listener"
            r10.putBoolean(r9, r6)
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzddn.mo17083a(java.util.ArrayList, android.os.Bundle):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzddk mo17084b() {
        ArrayList<String> arrayList = this.f15455b.zzhiq;
        if (arrayList == null) {
            return C2488ut.f11443a;
        }
        if (arrayList.isEmpty()) {
            return C2451tt.f11227a;
        }
        return new C2525vt(this, arrayList);
    }

    public final zzdyz<zzddk> zzasm() {
        return this.f15454a.zze(new C2414st(this));
    }
}
