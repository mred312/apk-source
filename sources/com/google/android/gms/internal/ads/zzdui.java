package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Hex;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdui {

    /* renamed from: e */
    private static final Object f15978e = new Object();

    /* renamed from: a */
    private final Context f15979a;

    /* renamed from: b */
    private final SharedPreferences f15980b;

    /* renamed from: c */
    private final String f15981c;

    /* renamed from: d */
    private final zzdtn f15982d;

    public zzdui(@NonNull Context context, @NonNull zzgn zzgn, @NonNull zzdtn zzdtn) {
        this.f15979a = context;
        this.f15981c = Integer.toString(zzgn.zzv());
        this.f15980b = context.getSharedPreferences("pcvmspf", 0);
        this.f15982d = zzdtn;
    }

    /* renamed from: a */
    private final void m8514a(int i, long j) {
        zzdtn zzdtn = this.f15982d;
        if (zzdtn != null) {
            zzdtn.zza(i, j);
        }
    }

    /* renamed from: b */
    private final void m8515b(int i, long j, String str) {
        zzdtn zzdtn = this.f15982d;
        if (zzdtn != null) {
            zzdtn.zza(i, j, str);
        }
    }

    /* renamed from: c */
    private final String m8516c() {
        String valueOf = String.valueOf(this.f15981c);
        return valueOf.length() != 0 ? "FBAMTD".concat(valueOf) : new String("FBAMTD");
    }

    /* renamed from: d */
    private final String m8517d() {
        String valueOf = String.valueOf(this.f15981c);
        return valueOf.length() != 0 ? "LATMTD".concat(valueOf) : new String("LATMTD");
    }

    /* renamed from: e */
    private static String m8518e(@NonNull zzgp zzgp) {
        return Hex.bytesToStringLowercase(((zzgt) ((zzekh) zzgt.zzdl().zzav(zzgp.zzdc().zzdg()).zzaw(zzgp.zzdc().zzdh()).zzdk(zzgp.zzdc().zzdj()).zzdl(zzgp.zzdc().zzdk()).zzdj(zzgp.zzdc().zzdi()).zzbhv())).zzbfg().toByteArray());
    }

    /* renamed from: f */
    private final zzgt m8519f(int i) {
        String str;
        if (i == zzduh.zzhru) {
            str = this.f15980b.getString(m8517d(), (String) null);
        } else {
            str = i == zzduh.zzhrv ? this.f15980b.getString(m8516c(), (String) null) : null;
        }
        if (str == null) {
            return null;
        }
        try {
            return zzgt.zzb(zzeiu.zzt(Hex.stringToBytes(str)), zzeju.zzbhf());
        } catch (zzeks unused) {
            return null;
        }
    }

    /* renamed from: g */
    private final File m8520g(@NonNull String str) {
        return new File(new File(this.f15979a.getDir("pccache", 0), this.f15981c), str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b1 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzgp r18, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzduf r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Object r4 = f15978e
            monitor-enter(r4)
            int r5 = com.google.android.gms.internal.ads.zzduh.zzhru     // Catch:{ all -> 0x018a }
            com.google.android.gms.internal.ads.zzgt r6 = r1.m8519f(r5)     // Catch:{ all -> 0x018a }
            com.google.android.gms.internal.ads.zzgt r7 = r18.zzdc()     // Catch:{ all -> 0x018a }
            java.lang.String r7 = r7.zzdg()     // Catch:{ all -> 0x018a }
            r8 = 0
            if (r6 == 0) goto L_0x002d
            java.lang.String r6 = r6.zzdg()     // Catch:{ all -> 0x018a }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x002d
            r0 = 4014(0xfae, float:5.625E-42)
            r1.m8514a(r0, r2)     // Catch:{ all -> 0x018a }
            monitor-exit(r4)     // Catch:{ all -> 0x018a }
            return r8
        L_0x002d:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x018a }
            java.io.File r6 = r1.m8520g(r7)     // Catch:{ all -> 0x018a }
            boolean r11 = r6.exists()     // Catch:{ all -> 0x018a }
            r12 = 4015(0xfaf, float:5.626E-42)
            if (r11 == 0) goto L_0x0081
            r11 = 4023(0xfb7, float:5.637E-42)
            boolean r14 = r6.isDirectory()     // Catch:{ all -> 0x018a }
            if (r14 == 0) goto L_0x0048
            java.lang.String r14 = "1"
            goto L_0x004a
        L_0x0048:
            java.lang.String r14 = "0"
        L_0x004a:
            boolean r6 = r6.isFile()     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x0053
            java.lang.String r6 = "1"
            goto L_0x0055
        L_0x0053:
            java.lang.String r6 = "0"
        L_0x0055:
            int r15 = r14.length()     // Catch:{ all -> 0x018a }
            int r15 = r15 + 5
            int r16 = r6.length()     // Catch:{ all -> 0x018a }
            int r15 = r15 + r16
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            r13.<init>(r15)     // Catch:{ all -> 0x018a }
            java.lang.String r15 = "d:"
            r13.append(r15)     // Catch:{ all -> 0x018a }
            r13.append(r14)     // Catch:{ all -> 0x018a }
            java.lang.String r14 = ",f:"
            r13.append(r14)     // Catch:{ all -> 0x018a }
            r13.append(r6)     // Catch:{ all -> 0x018a }
            java.lang.String r6 = r13.toString()     // Catch:{ all -> 0x018a }
            r1.m8515b(r11, r9, r6)     // Catch:{ all -> 0x018a }
            r1.m8514a(r12, r9)     // Catch:{ all -> 0x018a }
            goto L_0x00ae
        L_0x0081:
            boolean r11 = r6.mkdirs()     // Catch:{ all -> 0x018a }
            if (r11 != 0) goto L_0x00ae
            r11 = 4024(0xfb8, float:5.639E-42)
            java.lang.String r13 = "cw:"
            boolean r6 = r6.canWrite()     // Catch:{ all -> 0x018a }
            if (r6 == 0) goto L_0x0094
            java.lang.String r6 = "1"
            goto L_0x0096
        L_0x0094:
            java.lang.String r6 = "0"
        L_0x0096:
            int r14 = r6.length()     // Catch:{ all -> 0x018a }
            if (r14 == 0) goto L_0x00a1
            java.lang.String r6 = r13.concat(r6)     // Catch:{ all -> 0x018a }
            goto L_0x00a6
        L_0x00a1:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x018a }
            r6.<init>(r13)     // Catch:{ all -> 0x018a }
        L_0x00a6:
            r1.m8515b(r11, r9, r6)     // Catch:{ all -> 0x018a }
            r1.m8514a(r12, r9)     // Catch:{ all -> 0x018a }
            r6 = 0
            goto L_0x00af
        L_0x00ae:
            r6 = 1
        L_0x00af:
            if (r6 != 0) goto L_0x00b3
            monitor-exit(r4)     // Catch:{ all -> 0x018a }
            return r8
        L_0x00b3:
            java.io.File r6 = r1.m8520g(r7)     // Catch:{ all -> 0x018a }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x018a }
            java.lang.String r9 = "pcam.jar"
            r7.<init>(r6, r9)     // Catch:{ all -> 0x018a }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x018a }
            java.lang.String r10 = "pcbc"
            r9.<init>(r6, r10)     // Catch:{ all -> 0x018a }
            com.google.android.gms.internal.ads.zzeiu r10 = r18.zzdd()     // Catch:{ all -> 0x018a }
            byte[] r10 = r10.toByteArray()     // Catch:{ all -> 0x018a }
            boolean r10 = com.google.android.gms.internal.ads.zzduc.zza((java.io.File) r7, (byte[]) r10)     // Catch:{ all -> 0x018a }
            if (r10 != 0) goto L_0x00da
            r0 = 4016(0xfb0, float:5.628E-42)
            r1.m8514a(r0, r2)     // Catch:{ all -> 0x018a }
            monitor-exit(r4)     // Catch:{ all -> 0x018a }
            return r8
        L_0x00da:
            com.google.android.gms.internal.ads.zzeiu r10 = r18.zzde()     // Catch:{ all -> 0x018a }
            byte[] r10 = r10.toByteArray()     // Catch:{ all -> 0x018a }
            boolean r9 = com.google.android.gms.internal.ads.zzduc.zza((java.io.File) r9, (byte[]) r10)     // Catch:{ all -> 0x018a }
            if (r9 != 0) goto L_0x00ef
            r0 = 4017(0xfb1, float:5.629E-42)
            r1.m8514a(r0, r2)     // Catch:{ all -> 0x018a }
            monitor-exit(r4)     // Catch:{ all -> 0x018a }
            return r8
        L_0x00ef:
            if (r0 == 0) goto L_0x0101
            boolean r0 = r0.zzb(r7)     // Catch:{ all -> 0x018a }
            if (r0 != 0) goto L_0x0101
            r0 = 4018(0xfb2, float:5.63E-42)
            r1.m8514a(r0, r2)     // Catch:{ all -> 0x018a }
            com.google.android.gms.internal.ads.zzduc.zze(r6)     // Catch:{ all -> 0x018a }
            monitor-exit(r4)     // Catch:{ all -> 0x018a }
            return r8
        L_0x0101:
            java.lang.String r0 = m8518e(r18)     // Catch:{ all -> 0x018a }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x018a }
            android.content.SharedPreferences r9 = r1.f15980b     // Catch:{ all -> 0x018a }
            java.lang.String r10 = r17.m8517d()     // Catch:{ all -> 0x018a }
            r11 = 0
            java.lang.String r9 = r9.getString(r10, r11)     // Catch:{ all -> 0x018a }
            android.content.SharedPreferences r10 = r1.f15980b     // Catch:{ all -> 0x018a }
            android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ all -> 0x018a }
            java.lang.String r11 = r17.m8517d()     // Catch:{ all -> 0x018a }
            r10.putString(r11, r0)     // Catch:{ all -> 0x018a }
            if (r9 == 0) goto L_0x012a
            java.lang.String r0 = r17.m8516c()     // Catch:{ all -> 0x018a }
            r10.putString(r0, r9)     // Catch:{ all -> 0x018a }
        L_0x012a:
            boolean r0 = r10.commit()     // Catch:{ all -> 0x018a }
            if (r0 != 0) goto L_0x0135
            r9 = 4019(0xfb3, float:5.632E-42)
            r1.m8514a(r9, r6)     // Catch:{ all -> 0x018a }
        L_0x0135:
            if (r0 != 0) goto L_0x0139
            monitor-exit(r4)     // Catch:{ all -> 0x018a }
            return r8
        L_0x0139:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x018a }
            r0.<init>()     // Catch:{ all -> 0x018a }
            com.google.android.gms.internal.ads.zzgt r5 = r1.m8519f(r5)     // Catch:{ all -> 0x018a }
            if (r5 == 0) goto L_0x014b
            java.lang.String r5 = r5.zzdg()     // Catch:{ all -> 0x018a }
            r0.add(r5)     // Catch:{ all -> 0x018a }
        L_0x014b:
            int r5 = com.google.android.gms.internal.ads.zzduh.zzhrv     // Catch:{ all -> 0x018a }
            com.google.android.gms.internal.ads.zzgt r5 = r1.m8519f(r5)     // Catch:{ all -> 0x018a }
            if (r5 == 0) goto L_0x015a
            java.lang.String r5 = r5.zzdg()     // Catch:{ all -> 0x018a }
            r0.add(r5)     // Catch:{ all -> 0x018a }
        L_0x015a:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x018a }
            android.content.Context r6 = r1.f15979a     // Catch:{ all -> 0x018a }
            java.lang.String r7 = "pccache"
            java.io.File r6 = r6.getDir(r7, r8)     // Catch:{ all -> 0x018a }
            java.lang.String r7 = r1.f15981c     // Catch:{ all -> 0x018a }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x018a }
            java.io.File[] r5 = r5.listFiles()     // Catch:{ all -> 0x018a }
            int r6 = r5.length     // Catch:{ all -> 0x018a }
        L_0x016e:
            if (r8 >= r6) goto L_0x0182
            r7 = r5[r8]     // Catch:{ all -> 0x018a }
            java.lang.String r9 = r7.getName()     // Catch:{ all -> 0x018a }
            boolean r9 = r0.contains(r9)     // Catch:{ all -> 0x018a }
            if (r9 != 0) goto L_0x017f
            com.google.android.gms.internal.ads.zzduc.zze(r7)     // Catch:{ all -> 0x018a }
        L_0x017f:
            int r8 = r8 + 1
            goto L_0x016e
        L_0x0182:
            r0 = 5014(0x1396, float:7.026E-42)
            r1.m8514a(r0, r2)     // Catch:{ all -> 0x018a }
            monitor-exit(r4)     // Catch:{ all -> 0x018a }
            r0 = 1
            return r0
        L_0x018a:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x018a }
            goto L_0x018e
        L_0x018d:
            throw r0
        L_0x018e:
            goto L_0x018d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdui.zza(com.google.android.gms.internal.ads.zzgp, com.google.android.gms.internal.ads.zzduf):boolean");
    }

    @Nullable
    public final zzdua zzp(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (f15978e) {
            zzgt f = m8519f(i);
            if (f == null) {
                m8514a(4022, currentTimeMillis);
                return null;
            }
            File g = m8520g(f.zzdg());
            File file = new File(g, "pcam.jar");
            if (!file.exists()) {
                file = new File(g, "pcam");
            }
            File file2 = new File(g, "pcbc");
            File file3 = new File(g, "pcopt");
            m8514a(5016, currentTimeMillis);
            zzdua zzdua = new zzdua(f, file, file2, file3);
            return zzdua;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzgp r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Object r2 = f15978e
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzgt r3 = r7.zzdc()     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = r3.zzdg()     // Catch:{ all -> 0x0054 }
            java.io.File r3 = r6.m8520g(r3)     // Catch:{ all -> 0x0054 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "pcbc"
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzeiu r3 = r7.zzde()     // Catch:{ all -> 0x0054 }
            byte[] r3 = r3.toByteArray()     // Catch:{ all -> 0x0054 }
            boolean r3 = com.google.android.gms.internal.ads.zzduc.zza((java.io.File) r4, (byte[]) r3)     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0030
            r7 = 4020(0xfb4, float:5.633E-42)
            r6.m8514a(r7, r0)     // Catch:{ all -> 0x0054 }
            r7 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0030:
            java.lang.String r7 = m8518e(r7)     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences r3 = r6.f15980b     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r6.m8517d()     // Catch:{ all -> 0x0054 }
            r3.putString(r4, r7)     // Catch:{ all -> 0x0054 }
            boolean r7 = r3.commit()     // Catch:{ all -> 0x0054 }
            if (r7 == 0) goto L_0x004d
            r3 = 5015(0x1397, float:7.028E-42)
            r6.m8514a(r3, r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0052
        L_0x004d:
            r3 = 4021(0xfb5, float:5.635E-42)
            r6.m8514a(r3, r0)     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0054:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdui.zza(com.google.android.gms.internal.ads.zzgp):boolean");
    }
}
