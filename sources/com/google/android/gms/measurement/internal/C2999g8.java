package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.google.android.gms.measurement.internal.g8 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
abstract class C2999g8 {

    /* renamed from: a */
    String f18087a;

    /* renamed from: b */
    int f18088b;

    /* renamed from: c */
    Boolean f18089c;

    /* renamed from: d */
    Boolean f18090d;

    /* renamed from: e */
    Long f18091e;

    /* renamed from: f */
    Long f18092f;

    C2999g8(String str, int i) {
        this.f18087a = str;
        this.f18088b = i;
    }

    /* renamed from: b */
    static Boolean m10509b(double d, zzbv.zzd zzd) {
        try {
            return m10515h(new BigDecimal(d), zzd, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: c */
    static Boolean m10510c(long j, zzbv.zzd zzd) {
        try {
            return m10515h(new BigDecimal(j), zzd, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    /* renamed from: d */
    static Boolean m10511d(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* renamed from: e */
    static Boolean m10512e(String str, zzbv.zzd zzd) {
        if (!zzks.m10971z(str)) {
            return null;
        }
        try {
            return m10515h(new BigDecimal(str), zzd, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: f */
    private static Boolean m10513f(String str, zzbv.zzf.zzb zzb, boolean z, String str2, List<String> list, String str3, zzer zzer) {
        if (str == null) {
            return null;
        }
        if (zzb == zzbv.zzf.zzb.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzb != zzbv.zzf.zzb.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (C2959c8.f18006a[zzb.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzer != null) {
                        zzer.zzh().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    @VisibleForTesting
    /* renamed from: g */
    static Boolean m10514g(String str, zzbv.zzf zzf, zzer zzer) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zzf);
        if (str == null || !zzf.zza() || zzf.zzb() == zzbv.zzf.zzb.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        zzbv.zzf.zzb zzb = zzf.zzb();
        zzbv.zzf.zzb zzb2 = zzbv.zzf.zzb.IN_LIST;
        if (zzb == zzb2) {
            if (zzf.zzh() == 0) {
                return null;
            }
        } else if (!zzf.zzc()) {
            return null;
        }
        zzbv.zzf.zzb zzb3 = zzf.zzb();
        boolean zzf2 = zzf.zzf();
        if (zzf2 || zzb3 == zzbv.zzf.zzb.REGEXP || zzb3 == zzb2) {
            str2 = zzf.zzd();
        } else {
            str2 = zzf.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (zzf.zzh() == 0) {
            list = null;
        } else {
            List<String> zzg = zzf.zzg();
            if (!zzf2) {
                ArrayList arrayList = new ArrayList(zzg.size());
                for (String upperCase : zzg) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zzg = Collections.unmodifiableList(arrayList);
            }
            list = zzg;
        }
        return m10513f(str, zzb3, zzf2, str3, list, zzb3 == zzbv.zzf.zzb.REGEXP ? str3 : null, zzer);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0080, code lost:
        if (r3 != null) goto L_0x0082;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean m10515h(java.math.BigDecimal r9, com.google.android.gms.internal.measurement.zzbv.zzd r10, double r11) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)
            boolean r0 = r10.zza()
            r1 = 0
            if (r0 == 0) goto L_0x010b
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r0 = r10.zzb()
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r2 = com.google.android.gms.internal.measurement.zzbv.zzd.zza.UNKNOWN_COMPARISON_TYPE
            if (r0 != r2) goto L_0x0014
            goto L_0x010b
        L_0x0014:
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r0 = r10.zzb()
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r2 = com.google.android.gms.internal.measurement.zzbv.zzd.zza.BETWEEN
            if (r0 != r2) goto L_0x0029
            boolean r0 = r10.zzg()
            if (r0 == 0) goto L_0x0028
            boolean r0 = r10.zzi()
            if (r0 != 0) goto L_0x0030
        L_0x0028:
            return r1
        L_0x0029:
            boolean r0 = r10.zze()
            if (r0 != 0) goto L_0x0030
            return r1
        L_0x0030:
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r0 = r10.zzb()
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r3 = r10.zzb()
            if (r3 != r2) goto L_0x0065
            java.lang.String r3 = r10.zzh()
            boolean r3 = com.google.android.gms.measurement.internal.zzks.m10971z(r3)
            if (r3 == 0) goto L_0x0064
            java.lang.String r3 = r10.zzj()
            boolean r3 = com.google.android.gms.measurement.internal.zzks.m10971z(r3)
            if (r3 != 0) goto L_0x004f
            goto L_0x0064
        L_0x004f:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0064 }
            java.lang.String r4 = r10.zzh()     // Catch:{ NumberFormatException -> 0x0064 }
            r3.<init>(r4)     // Catch:{ NumberFormatException -> 0x0064 }
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0064 }
            java.lang.String r10 = r10.zzj()     // Catch:{ NumberFormatException -> 0x0064 }
            r4.<init>(r10)     // Catch:{ NumberFormatException -> 0x0064 }
            r10 = r3
            r3 = r1
            goto L_0x007b
        L_0x0064:
            return r1
        L_0x0065:
            java.lang.String r3 = r10.zzf()
            boolean r3 = com.google.android.gms.measurement.internal.zzks.m10971z(r3)
            if (r3 != 0) goto L_0x0070
            return r1
        L_0x0070:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x010b }
            java.lang.String r10 = r10.zzf()     // Catch:{ NumberFormatException -> 0x010b }
            r3.<init>(r10)     // Catch:{ NumberFormatException -> 0x010b }
            r10 = r1
            r4 = r10
        L_0x007b:
            if (r0 != r2) goto L_0x0080
            if (r10 != 0) goto L_0x0082
            return r1
        L_0x0080:
            if (r3 == 0) goto L_0x010b
        L_0x0082:
            int[] r2 = com.google.android.gms.measurement.internal.C2959c8.f18007b
            int r0 = r0.ordinal()
            r0 = r2[r0]
            r2 = -1
            r5 = 0
            r6 = 1
            if (r0 == r6) goto L_0x00ff
            r7 = 2
            if (r0 == r7) goto L_0x00f3
            r8 = 3
            if (r0 == r8) goto L_0x00ab
            r11 = 4
            if (r0 == r11) goto L_0x0099
            goto L_0x010b
        L_0x0099:
            int r10 = r9.compareTo(r10)
            if (r10 == r2) goto L_0x00a6
            int r9 = r9.compareTo(r4)
            if (r9 == r6) goto L_0x00a6
            r5 = 1
        L_0x00a6:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00ab:
            r0 = 0
            int r10 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r10 == 0) goto L_0x00e7
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r11)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r7)
            java.math.BigDecimal r10 = r10.multiply(r0)
            java.math.BigDecimal r10 = r3.subtract(r10)
            int r10 = r9.compareTo(r10)
            if (r10 != r6) goto L_0x00e2
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r11)
            java.math.BigDecimal r11 = new java.math.BigDecimal
            r11.<init>(r7)
            java.math.BigDecimal r10 = r10.multiply(r11)
            java.math.BigDecimal r10 = r3.add(r10)
            int r9 = r9.compareTo(r10)
            if (r9 != r2) goto L_0x00e2
            r5 = 1
        L_0x00e2:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00e7:
            int r9 = r9.compareTo(r3)
            if (r9 != 0) goto L_0x00ee
            r5 = 1
        L_0x00ee:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00f3:
            int r9 = r9.compareTo(r3)
            if (r9 != r6) goto L_0x00fa
            r5 = 1
        L_0x00fa:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00ff:
            int r9 = r9.compareTo(r3)
            if (r9 != r2) goto L_0x0106
            r5 = 1
        L_0x0106:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x010b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2999g8.m10515h(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzbv$zzd, double):java.lang.Boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract int mo19891a();

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public abstract boolean mo19892i();

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public abstract boolean mo19893j();
}
