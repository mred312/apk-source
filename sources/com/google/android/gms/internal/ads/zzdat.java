package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdat implements zzdfi<zzdar> {

    /* renamed from: a */
    private final String f15145a;

    /* renamed from: b */
    private final zzdzc f15146b;

    /* renamed from: c */
    private final zzciq f15147c;

    public zzdat(String str, zzdzc zzdzc, zzciq zzciq) {
        this.f15145a = str;
        this.f15146b = zzdzc;
        this.f15147c = zzciq;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0018 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e A[Catch:{ zzdnr -> 0x002b }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.os.Bundle m8337b(com.google.android.gms.internal.ads.zzdoe r3) {
        /*
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.google.android.gms.internal.ads.zzaqc r1 = r3.zzum()     // Catch:{ zzdnr -> 0x0018 }
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = "sdk_version"
            com.google.android.gms.internal.ads.zzaqc r2 = r3.zzum()     // Catch:{ zzdnr -> 0x0018 }
            java.lang.String r2 = r2.toString()     // Catch:{ zzdnr -> 0x0018 }
            r0.putString(r1, r2)     // Catch:{ zzdnr -> 0x0018 }
        L_0x0018:
            com.google.android.gms.internal.ads.zzaqc r1 = r3.zzul()     // Catch:{ zzdnr -> 0x002b }
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = "adapter_version"
            com.google.android.gms.internal.ads.zzaqc r3 = r3.zzul()     // Catch:{ zzdnr -> 0x002b }
            java.lang.String r3 = r3.toString()     // Catch:{ zzdnr -> 0x002b }
            r0.putString(r1, r3)     // Catch:{ zzdnr -> 0x002b }
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdat.m8337b(com.google.android.gms.internal.ads.zzdoe):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdar mo17073a() {
        List<String> asList = Arrays.asList(((String) zzwq.zzqe().zzd(zzabf.zzcqa)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                bundle.putBundle(str, m8337b(this.f15147c.zzd(str, new JSONObject())));
            } catch (zzdnr unused) {
            }
        }
        return new zzdar(bundle);
    }

    public final zzdyz<zzdar> zzasm() {
        if (new BigInteger(this.f15145a).equals(BigInteger.ONE)) {
            if (!zzdwc.zzar((String) zzwq.zzqe().zzd(zzabf.zzcqa))) {
                return this.f15146b.zze(new C2413ss(this));
            }
        }
        return zzdyr.zzag(new zzdar(new Bundle()));
    }
}
