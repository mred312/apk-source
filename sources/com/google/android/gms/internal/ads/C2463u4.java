package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@TargetApi(21)
@ParametersAreNonnullByDefault
/* renamed from: com.google.android.gms.internal.ads.u4 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2463u4 {

    /* renamed from: d */
    private static final Map<String, String> f11247d;

    /* renamed from: a */
    private final Context f11248a;

    /* renamed from: b */
    private final List<String> f11249b;

    /* renamed from: c */
    private final zzawh f11250c;

    static {
        HashMap hashMap = new HashMap();
        if (PlatformVersion.isAtLeastLollipop()) {
            hashMap.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            hashMap.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        f11247d = hashMap;
    }

    C2463u4(Context context, List<String> list, zzawh zzawh) {
        this.f11248a = context;
        this.f11249b = list;
        this.f11250c = zzawh;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0025, code lost:
        r5 = true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> mo14857a(java.lang.String[] r11) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r11.length
            r2 = 0
            r3 = 0
        L_0x0008:
            if (r3 >= r1) goto L_0x0076
            r4 = r11[r3]
            java.util.List<java.lang.String> r5 = r10.f11249b
            java.util.Iterator r5 = r5.iterator()
        L_0x0012:
            boolean r6 = r5.hasNext()
            r7 = 1
            if (r6 == 0) goto L_0x0044
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r8 = r6.equals(r4)
            if (r8 == 0) goto L_0x0027
        L_0x0025:
            r5 = 1
            goto L_0x0045
        L_0x0027:
            java.lang.String r8 = "android.webkit.resource."
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r9 = r6.length()
            if (r9 == 0) goto L_0x0038
            java.lang.String r6 = r8.concat(r6)
            goto L_0x003d
        L_0x0038:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r8)
        L_0x003d:
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0012
            goto L_0x0025
        L_0x0044:
            r5 = 0
        L_0x0045:
            if (r5 == 0) goto L_0x006e
            java.util.Map<java.lang.String, java.lang.String> r5 = f11247d
            boolean r6 = r5.containsKey(r4)
            if (r6 == 0) goto L_0x0062
            com.google.android.gms.ads.internal.zzp.zzkq()
            android.content.Context r6 = r10.f11248a
            java.lang.Object r5 = r5.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = com.google.android.gms.ads.internal.util.zzm.zzp(r6, r5)
            if (r5 == 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r7 = 0
        L_0x0062:
            if (r7 == 0) goto L_0x0068
            r0.add(r4)
            goto L_0x0073
        L_0x0068:
            com.google.android.gms.internal.ads.zzawh r5 = r10.f11250c
            r5.mo15805c(r4)
            goto L_0x0073
        L_0x006e:
            com.google.android.gms.internal.ads.zzawh r5 = r10.f11250c
            r5.mo15804b(r4)
        L_0x0073:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x0076:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C2463u4.mo14857a(java.lang.String[]):java.util.List");
    }
}
