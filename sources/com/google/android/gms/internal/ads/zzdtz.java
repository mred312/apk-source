package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdtz {

    /* renamed from: a */
    private final File f15963a;
    @VisibleForTesting

    /* renamed from: b */
    private final File f15964b;

    /* renamed from: c */
    private final SharedPreferences f15965c;

    /* renamed from: d */
    private final zzgn f15966d;

    public zzdtz(@NonNull Context context, zzgn zzgn) {
        this.f15965c = context.getSharedPreferences("pcvmspf", 0);
        this.f15963a = zzduc.zza(context.getDir("pccache", 0), false);
        this.f15964b = zzduc.zza(context.getDir("tmppccache", 0), true);
        this.f15966d = zzgn;
    }

    @VisibleForTesting
    /* renamed from: a */
    private static String m8509a(@NonNull zzgt zzgt) {
        return Hex.bytesToStringLowercase(zzgt.zzbfg().toByteArray());
    }

    /* renamed from: b */
    private final File m8510b() {
        File file = new File(this.f15963a, Integer.toString(this.f15966d.zzv()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    /* renamed from: c */
    private final String m8511c() {
        int zzv = this.f15966d.zzv();
        StringBuilder sb = new StringBuilder(17);
        sb.append("FBAMTD");
        sb.append(zzv);
        return sb.toString();
    }

    /* renamed from: d */
    private final String m8512d() {
        int zzv = this.f15966d.zzv();
        StringBuilder sb = new StringBuilder(17);
        sb.append("LATMTD");
        sb.append(zzv);
        return sb.toString();
    }

    @VisibleForTesting
    /* renamed from: e */
    private final zzgt m8513e(int i) {
        String str;
        if (i == zzduh.zzhru) {
            str = this.f15965c.getString(m8512d(), (String) null);
        } else {
            str = i == zzduh.zzhrv ? this.f15965c.getString(m8511c(), (String) null) : null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            zzgt zzl = zzgt.zzl(zzeiu.zzt(Hex.stringToBytes(str)));
            String zzdg = zzl.zzdg();
            File zza = zzduc.zza(zzdg, "pcam.jar", m8510b());
            if (!zza.exists()) {
                zza = zzduc.zza(zzdg, "pcam", m8510b());
            }
            if (zza.exists() && zzduc.zza(zzdg, "pcbc", m8510b()).exists()) {
                return zzl;
            }
            return null;
        } catch (zzeks unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0140, code lost:
        if (r0.commit() != false) goto L_0x0144;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0172  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzgp r9, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzduf r10) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzgt r0 = r9.zzdc()
            java.lang.String r0 = r0.zzdg()
            com.google.android.gms.internal.ads.zzeiu r1 = r9.zzdd()
            byte[] r1 = r1.toByteArray()
            com.google.android.gms.internal.ads.zzeiu r2 = r9.zzde()
            byte[] r2 = r2.toByteArray()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r4 = "pcbc"
            java.lang.String r5 = "pcam.jar"
            r6 = 0
            if (r3 != 0) goto L_0x0059
            if (r2 == 0) goto L_0x0059
            int r3 = r2.length
            if (r3 != 0) goto L_0x0029
            goto L_0x0059
        L_0x0029:
            java.io.File r3 = r8.f15964b
            com.google.android.gms.internal.ads.zzduc.zze(r3)
            java.io.File r3 = r8.f15964b
            r3.mkdirs()
            java.io.File r3 = r8.f15964b
            java.io.File r3 = com.google.android.gms.internal.ads.zzduc.zza((java.lang.String) r0, (java.io.File) r3)
            r3.mkdirs()
            java.io.File r3 = r8.f15964b
            java.io.File r3 = com.google.android.gms.internal.ads.zzduc.zza(r0, r5, r3)
            if (r1 == 0) goto L_0x004e
            int r7 = r1.length
            if (r7 <= 0) goto L_0x004e
            boolean r1 = com.google.android.gms.internal.ads.zzduc.zza((java.io.File) r3, (byte[]) r1)
            if (r1 != 0) goto L_0x004e
            goto L_0x0059
        L_0x004e:
            java.io.File r1 = r8.f15964b
            java.io.File r0 = com.google.android.gms.internal.ads.zzduc.zza(r0, r4, r1)
            boolean r0 = com.google.android.gms.internal.ads.zzduc.zza((java.io.File) r0, (byte[]) r2)
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            if (r0 != 0) goto L_0x005d
            return r6
        L_0x005d:
            com.google.android.gms.internal.ads.zzgt r0 = r9.zzdc()
            java.lang.String r0 = r0.zzdg()
            java.io.File r1 = r8.f15964b
            java.io.File r0 = com.google.android.gms.internal.ads.zzduc.zza(r0, r5, r1)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x007a
            if (r10 == 0) goto L_0x007a
            boolean r10 = r10.zzb(r0)
            if (r10 != 0) goto L_0x007a
            return r6
        L_0x007a:
            com.google.android.gms.internal.ads.zzgt r10 = r9.zzdc()
            java.lang.String r10 = r10.zzdg()
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 1
            if (r0 != 0) goto L_0x00bf
            java.io.File r0 = r8.f15964b
            java.io.File r0 = com.google.android.gms.internal.ads.zzduc.zza(r10, r5, r0)
            java.io.File r2 = r8.f15964b
            java.io.File r2 = com.google.android.gms.internal.ads.zzduc.zza(r10, r4, r2)
            java.io.File r3 = r8.m8510b()
            java.io.File r3 = com.google.android.gms.internal.ads.zzduc.zza(r10, r5, r3)
            java.io.File r5 = r8.m8510b()
            java.io.File r10 = com.google.android.gms.internal.ads.zzduc.zza(r10, r4, r5)
            boolean r4 = r0.exists()
            if (r4 == 0) goto L_0x00b1
            boolean r0 = r0.renameTo(r3)
            if (r0 == 0) goto L_0x00bf
        L_0x00b1:
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x00bf
            boolean r10 = r2.renameTo(r10)
            if (r10 == 0) goto L_0x00bf
            r10 = 1
            goto L_0x00c0
        L_0x00bf:
            r10 = 0
        L_0x00c0:
            if (r10 == 0) goto L_0x0143
            com.google.android.gms.internal.ads.zzgt$zza r10 = com.google.android.gms.internal.ads.zzgt.zzdl()
            com.google.android.gms.internal.ads.zzgt r0 = r9.zzdc()
            java.lang.String r0 = r0.zzdg()
            com.google.android.gms.internal.ads.zzgt$zza r10 = r10.zzav(r0)
            com.google.android.gms.internal.ads.zzgt r0 = r9.zzdc()
            java.lang.String r0 = r0.zzdh()
            com.google.android.gms.internal.ads.zzgt$zza r10 = r10.zzaw(r0)
            com.google.android.gms.internal.ads.zzgt r0 = r9.zzdc()
            long r2 = r0.zzdj()
            com.google.android.gms.internal.ads.zzgt$zza r10 = r10.zzdk(r2)
            com.google.android.gms.internal.ads.zzgt r0 = r9.zzdc()
            long r2 = r0.zzdk()
            com.google.android.gms.internal.ads.zzgt$zza r10 = r10.zzdl(r2)
            com.google.android.gms.internal.ads.zzgt r9 = r9.zzdc()
            long r2 = r9.zzdi()
            com.google.android.gms.internal.ads.zzgt$zza r9 = r10.zzdj(r2)
            com.google.android.gms.internal.ads.zzels r9 = r9.zzbhv()
            com.google.android.gms.internal.ads.zzekh r9 = (com.google.android.gms.internal.ads.zzekh) r9
            com.google.android.gms.internal.ads.zzgt r9 = (com.google.android.gms.internal.ads.zzgt) r9
            int r10 = com.google.android.gms.internal.ads.zzduh.zzhru
            com.google.android.gms.internal.ads.zzgt r10 = r8.m8513e(r10)
            android.content.SharedPreferences r0 = r8.f15965c
            android.content.SharedPreferences$Editor r0 = r0.edit()
            if (r10 == 0) goto L_0x0131
            java.lang.String r2 = r9.zzdg()
            java.lang.String r3 = r10.zzdg()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0131
            java.lang.String r2 = r8.m8511c()
            java.lang.String r10 = m8509a(r10)
            r0.putString(r2, r10)
        L_0x0131:
            java.lang.String r10 = r8.m8512d()
            java.lang.String r9 = m8509a(r9)
            r0.putString(r10, r9)
            boolean r9 = r0.commit()
            if (r9 == 0) goto L_0x0143
            goto L_0x0144
        L_0x0143:
            r1 = 0
        L_0x0144:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            int r10 = com.google.android.gms.internal.ads.zzduh.zzhru
            com.google.android.gms.internal.ads.zzgt r10 = r8.m8513e(r10)
            if (r10 == 0) goto L_0x0158
            java.lang.String r10 = r10.zzdg()
            r9.add(r10)
        L_0x0158:
            int r10 = com.google.android.gms.internal.ads.zzduh.zzhrv
            com.google.android.gms.internal.ads.zzgt r10 = r8.m8513e(r10)
            if (r10 == 0) goto L_0x0167
            java.lang.String r10 = r10.zzdg()
            r9.add(r10)
        L_0x0167:
            java.io.File r10 = r8.m8510b()
            java.io.File[] r10 = r10.listFiles()
            int r0 = r10.length
        L_0x0170:
            if (r6 >= r0) goto L_0x018c
            r2 = r10[r6]
            java.lang.String r2 = r2.getName()
            boolean r3 = r9.contains(r2)
            if (r3 != 0) goto L_0x0189
            java.io.File r3 = r8.m8510b()
            java.io.File r2 = com.google.android.gms.internal.ads.zzduc.zza((java.lang.String) r2, (java.io.File) r3)
            com.google.android.gms.internal.ads.zzduc.zze(r2)
        L_0x0189:
            int r6 = r6 + 1
            goto L_0x0170
        L_0x018c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtz.zza(com.google.android.gms.internal.ads.zzgp, com.google.android.gms.internal.ads.zzduf):boolean");
    }

    public final zzdua zzp(int i) {
        zzgt e = m8513e(i);
        if (e == null) {
            return null;
        }
        String zzdg = e.zzdg();
        File zza = zzduc.zza(zzdg, "pcam.jar", m8510b());
        if (!zza.exists()) {
            zza = zzduc.zza(zzdg, "pcam", m8510b());
        }
        return new zzdua(e, zza, zzduc.zza(zzdg, "pcbc", m8510b()), zzduc.zza(zzdg, "pcopt", m8510b()));
    }
}
