package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzcf;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzfa {

    /* renamed from: q */
    private static final String f16372q = "zzfa";

    /* renamed from: a */
    private ExecutorService f16373a;

    /* renamed from: b */
    private DexClassLoader f16374b;

    /* renamed from: c */
    private zzeh f16375c;
    protected Context context;

    /* renamed from: d */
    private byte[] f16376d;

    /* renamed from: e */
    private volatile AdvertisingIdClient f16377e = null;

    /* renamed from: f */
    private volatile boolean f16378f;

    /* renamed from: g */
    private Future f16379g;

    /* renamed from: h */
    private boolean f16380h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile zzcf.zza f16381i;

    /* renamed from: j */
    private Future f16382j;

    /* renamed from: k */
    private zzdt f16383k;

    /* renamed from: l */
    private boolean f16384l;

    /* renamed from: m */
    private boolean f16385m;

    /* renamed from: n */
    private Map<Pair<String, String>, zzgj> f16386n;

    /* renamed from: o */
    private boolean f16387o;

    /* renamed from: p */
    private zzey f16388p;

    private zzfa(Context context2) {
        boolean z = false;
        this.f16378f = false;
        this.f16379g = null;
        this.f16381i = null;
        this.f16382j = null;
        this.f16384l = false;
        this.f16385m = false;
        this.f16387o = false;
        Context applicationContext = context2.getApplicationContext();
        z = applicationContext != null ? true : z;
        this.f16380h = z;
        this.context = z ? applicationContext : context2;
        this.f16386n = new HashMap();
        if (this.f16388p == null) {
            this.f16388p = new zzey(this.context);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c0 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d4 A[SYNTHETIC, Splitter:B:42:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00db A[SYNTHETIC, Splitter:B:46:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e5 A[SYNTHETIC, Splitter:B:54:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ec A[SYNTHETIC, Splitter:B:58:0x00ec] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m8922d(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "test"
            java.io.File r1 = new java.io.File
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r10
            r5 = 1
            r3[r5] = r11
            java.lang.String r6 = "%s/%s.tmp"
            java.lang.String r3 = java.lang.String.format(r6, r3)
            r1.<init>(r3)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x001d
            return
        L_0x001d:
            java.io.File r3 = new java.io.File
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r10
            r2[r5] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r2)
            r3.<init>(r10)
            boolean r10 = r3.exists()
            if (r10 != 0) goto L_0x0035
            return
        L_0x0035:
            long r5 = r3.length()
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 > 0) goto L_0x0040
            return
        L_0x0040:
            int r10 = (int) r5
            byte[] r10 = new byte[r10]
            r2 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d0 }
            r5.<init>(r3)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d0 }
            int r6 = r5.read(r10)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            if (r6 > 0) goto L_0x0056
            r5.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            m8927j(r3)
            return
        L_0x0056:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r6.print(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r6.print(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r6.print(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r0 = com.google.android.gms.internal.ads.zzcf.zzc.zzbe()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzeiu r6 = com.google.android.gms.internal.ads.zzeiu.zzt(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r0 = r0.zzd(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r11 = r11.getBytes()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzeiu r11 = com.google.android.gms.internal.ads.zzeiu.zzt(r11)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r11 = r0.zzc(r11)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzeh r0 = r9.f16375c     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r6 = r9.f16376d     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.lang.String r10 = r0.zzb(r6, r10)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r10 = r10.getBytes()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzeiu r0 = com.google.android.gms.internal.ads.zzeiu.zzt(r10)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r0 = r11.zza(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r10 = com.google.android.gms.internal.ads.C2370rq.m6823e(r10)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzeiu r10 = com.google.android.gms.internal.ads.zzeiu.zzt(r10)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r0.zzb(r10)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r1.createNewFile()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r10.<init>(r1)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzels r11 = r11.zzbhv()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzekh r11 = (com.google.android.gms.internal.ads.zzekh) r11     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzcf$zzc r11 = (com.google.android.gms.internal.ads.zzcf.zzc) r11     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            int r0 = r11.length     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r10.write(r11, r4, r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r10.close()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r5.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00c0:
            r10.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            m8927j(r3)
            return
        L_0x00c7:
            r11 = move-exception
            goto L_0x00cb
        L_0x00c9:
            r11 = move-exception
            r10 = r2
        L_0x00cb:
            r2 = r5
            goto L_0x00d2
        L_0x00cd:
            r10 = r2
        L_0x00ce:
            r2 = r5
            goto L_0x00e3
        L_0x00d0:
            r11 = move-exception
            r10 = r2
        L_0x00d2:
            if (r2 == 0) goto L_0x00d9
            r2.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00d9
        L_0x00d8:
        L_0x00d9:
            if (r10 == 0) goto L_0x00de
            r10.close()     // Catch:{ IOException -> 0x00de }
        L_0x00de:
            m8927j(r3)
            throw r11
        L_0x00e2:
            r10 = r2
        L_0x00e3:
            if (r2 == 0) goto L_0x00ea
            r2.close()     // Catch:{ IOException -> 0x00e9 }
            goto L_0x00ea
        L_0x00e9:
        L_0x00ea:
            if (r10 == 0) goto L_0x00ef
            r10.close()     // Catch:{ IOException -> 0x00ef }
        L_0x00ef:
            m8927j(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfa.m8922d(java.io.File, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static boolean m8923e(int i, zzcf.zza zza) {
        if (i >= 4) {
            return false;
        }
        if (zza != null && zza.zzaj() && !zza.zzaf().equals("0000000000000000000000000000000000000000000000000000000000000000") && zza.zzao() && zza.zzap().zzbg() && zza.zzap().zzbh() != -2) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    private static void m8924f(String str) {
        m8927j(new File(str));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00cc */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e4 A[SYNTHETIC, Splitter:B:55:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00eb A[SYNTHETIC, Splitter:B:59:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f2 A[SYNTHETIC, Splitter:B:66:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f9 A[SYNTHETIC, Splitter:B:70:0x00f9] */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m8926i(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r10
            r4 = 1
            r2[r4] = r11
            java.lang.String r5 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r5, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x001b
            return r3
        L_0x001b:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r10
            r1[r4] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r1)
            r2.<init>(r10)
            boolean r10 = r2.exists()
            if (r10 == 0) goto L_0x0033
            return r3
        L_0x0033:
            r10 = 0
            long r5 = r0.length()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0042
            m8927j(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            return r3
        L_0x0042:
            int r1 = (int) r5     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            byte[] r1 = new byte[r1]     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            r5.<init>(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            int r6 = r5.read(r1)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            if (r6 > 0) goto L_0x005e
            java.lang.String r11 = f16372q     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r11, r1)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            m8927j(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r5.close()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            return r3
        L_0x005e:
            com.google.android.gms.internal.ads.zzeju r6 = com.google.android.gms.internal.ads.zzeju.zzbhf()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzcf$zzc r1 = com.google.android.gms.internal.ads.zzcf.zzc.zzb(r1, r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzeiu r7 = r1.zzbc()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r7 = r7.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r6.<init>(r7)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            boolean r11 = r11.equals(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            if (r11 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzeiu r11 = r1.zzbb()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzeiu r6 = r1.zzba()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r6 = r6.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r6 = com.google.android.gms.internal.ads.C2370rq.m6823e(r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            if (r11 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzeiu r11 = r1.zzbd()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            if (r11 != 0) goto L_0x00a8
            goto L_0x00d2
        L_0x00a8:
            com.google.android.gms.internal.ads.zzeh r11 = r9.f16375c     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r0 = r9.f16376d     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzeiu r1 = r1.zzba()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r1 = r1.toByteArray()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r6.<init>(r1)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r11 = r11.zza(r0, r6)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r2.createNewFile()     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r0.<init>(r2)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            int r10 = r11.length     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00d0 }
            r0.write(r11, r3, r10)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00d0 }
            r5.close()     // Catch:{ IOException -> 0x00cc }
        L_0x00cc:
            r0.close()     // Catch:{ IOException -> 0x00cf }
        L_0x00cf:
            return r4
        L_0x00d0:
            r11 = move-exception
            goto L_0x00db
        L_0x00d2:
            m8927j(r0)     // Catch:{ zzek | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r5.close()     // Catch:{ IOException -> 0x00d8 }
        L_0x00d8:
            return r3
        L_0x00d9:
            r11 = move-exception
            r0 = r10
        L_0x00db:
            r10 = r5
            goto L_0x00e2
        L_0x00dd:
            r0 = r10
        L_0x00de:
            r10 = r5
            goto L_0x00f0
        L_0x00e0:
            r11 = move-exception
            r0 = r10
        L_0x00e2:
            if (r10 == 0) goto L_0x00e9
            r10.close()     // Catch:{ IOException -> 0x00e8 }
            goto L_0x00e9
        L_0x00e8:
        L_0x00e9:
            if (r0 == 0) goto L_0x00ee
            r0.close()     // Catch:{ IOException -> 0x00ee }
        L_0x00ee:
            throw r11
        L_0x00ef:
            r0 = r10
        L_0x00f0:
            if (r10 == 0) goto L_0x00f7
            r10.close()     // Catch:{ IOException -> 0x00f6 }
            goto L_0x00f7
        L_0x00f6:
        L_0x00f7:
            if (r0 == 0) goto L_0x00fc
            r0.close()     // Catch:{ IOException -> 0x00fc }
        L_0x00fc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfa.m8926i(java.io.File, java.lang.String):boolean");
    }

    /* renamed from: j */
    private static void m8927j(File file) {
        if (!file.exists()) {
            Log.d(f16372q, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void m8928l() {
        try {
            if (this.f16377e == null && this.f16380h) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.context);
                advertisingIdClient.start();
                this.f16377e = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.f16377e = null;
        }
    }

    @VisibleForTesting
    /* renamed from: m */
    private final zzcf.zza m8929m() {
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            Context context2 = this.context;
            return zzdsp.zzj(context2, context2.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(1:22)(2:23|24))|25|26|27|28|29|(2:31|(1:33)(2:34|35))|36|(1:38)|39|40|41|42|43|44|45|66) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004d */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[Catch:{ zzek -> 0x012f, zzet -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[Catch:{ all -> 0x00fe, FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2 A[Catch:{ all -> 0x00fe, FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfa zza(android.content.Context r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.String r0 = "%s/%s.dex"
            com.google.android.gms.internal.ads.zzfa r1 = new com.google.android.gms.internal.ads.zzfa
            r1.<init>(r9)
            com.google.android.gms.internal.ads.xc0 r9 = new com.google.android.gms.internal.ads.xc0     // Catch:{ zzet -> 0x0136 }
            r9.<init>()     // Catch:{ zzet -> 0x0136 }
            java.util.concurrent.ExecutorService r9 = java.util.concurrent.Executors.newCachedThreadPool(r9)     // Catch:{ zzet -> 0x0136 }
            r1.f16373a = r9     // Catch:{ zzet -> 0x0136 }
            r1.f16378f = r12     // Catch:{ zzet -> 0x0136 }
            if (r12 == 0) goto L_0x0023
            java.util.concurrent.ExecutorService r9 = r1.f16373a     // Catch:{ zzet -> 0x0136 }
            com.google.android.gms.internal.ads.ad0 r12 = new com.google.android.gms.internal.ads.ad0     // Catch:{ zzet -> 0x0136 }
            r12.<init>(r1)     // Catch:{ zzet -> 0x0136 }
            java.util.concurrent.Future r9 = r9.submit(r12)     // Catch:{ zzet -> 0x0136 }
            r1.f16379g = r9     // Catch:{ zzet -> 0x0136 }
        L_0x0023:
            java.util.concurrent.ExecutorService r9 = r1.f16373a     // Catch:{ zzet -> 0x0136 }
            com.google.android.gms.internal.ads.cd0 r12 = new com.google.android.gms.internal.ads.cd0     // Catch:{ zzet -> 0x0136 }
            r12.<init>(r1)     // Catch:{ zzet -> 0x0136 }
            r9.execute(r12)     // Catch:{ zzet -> 0x0136 }
            r9 = 1
            r12 = 0
            com.google.android.gms.common.GoogleApiAvailabilityLight r2 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ all -> 0x004d }
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x004d }
            int r3 = r2.getApkVersion(r3)     // Catch:{ all -> 0x004d }
            if (r3 <= 0) goto L_0x003d
            r3 = 1
            goto L_0x003e
        L_0x003d:
            r3 = 0
        L_0x003e:
            r1.f16384l = r3     // Catch:{ all -> 0x004d }
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x004d }
            int r2 = r2.isGooglePlayServicesAvailable(r3)     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x004a
            r2 = 1
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            r1.f16385m = r2     // Catch:{ all -> 0x004d }
        L_0x004d:
            r1.mo17777b(r12, r9)     // Catch:{ zzet -> 0x0136 }
            boolean r2 = com.google.android.gms.internal.ads.zzff.isMainThread()     // Catch:{ zzet -> 0x0136 }
            if (r2 == 0) goto L_0x0071
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabf.zzcrh     // Catch:{ zzet -> 0x0136 }
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ zzet -> 0x0136 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ zzet -> 0x0136 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ zzet -> 0x0136 }
            boolean r2 = r2.booleanValue()     // Catch:{ zzet -> 0x0136 }
            if (r2 != 0) goto L_0x0069
            goto L_0x0071
        L_0x0069:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ zzet -> 0x0136 }
            java.lang.String r10 = "Task Context initialization must not be called from the UI thread."
            r9.<init>(r10)     // Catch:{ zzet -> 0x0136 }
            throw r9     // Catch:{ zzet -> 0x0136 }
        L_0x0071:
            com.google.android.gms.internal.ads.zzeh r2 = new com.google.android.gms.internal.ads.zzeh     // Catch:{ zzet -> 0x0136 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ zzet -> 0x0136 }
            r1.f16375c = r2     // Catch:{ zzet -> 0x0136 }
            byte[] r10 = r2.zzao(r10)     // Catch:{ zzek -> 0x012f }
            r1.f16376d = r10     // Catch:{ zzek -> 0x012f }
            android.content.Context r10 = r1.context     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            java.io.File r10 = r10.getCacheDir()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            if (r10 != 0) goto L_0x0098
            android.content.Context r10 = r1.context     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r2 = "dex"
            java.io.File r10 = r10.getDir(r2, r12)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            if (r10 == 0) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            com.google.android.gms.internal.ads.zzet r9 = new com.google.android.gms.internal.ads.zzet     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            throw r9     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
        L_0x0098:
            java.lang.String r2 = "1596060835607"
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r5 = "%s/%s.jar"
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r7[r12] = r10     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r7[r9] = r2     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r5 = java.lang.String.format(r5, r7)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            boolean r5 = r4.exists()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            if (r5 != 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzeh r5 = r1.f16375c     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            byte[] r7 = r1.f16376d     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            byte[] r11 = r5.zza(r7, r11)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r4.createNewFile()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            int r7 = r11.length     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r5.write(r11, r12, r7)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r5.close()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
        L_0x00c9:
            r1.m8926i(r10, r2)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            dalvik.system.DexClassLoader r11 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x00fe }
            java.lang.String r5 = r4.getAbsolutePath()     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = r10.getAbsolutePath()     // Catch:{ all -> 0x00fe }
            android.content.Context r8 = r1.context     // Catch:{ all -> 0x00fe }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x00fe }
            r11.<init>(r5, r7, r3, r8)     // Catch:{ all -> 0x00fe }
            r1.f16374b = r11     // Catch:{ all -> 0x00fe }
            m8927j(r4)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r1.m8922d(r10, r2)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r11[r12] = r10     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r11[r9] = r2     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r10 = java.lang.String.format(r0, r11)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            m8924f(r10)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            com.google.android.gms.internal.ads.zzdt r10 = new com.google.android.gms.internal.ads.zzdt     // Catch:{ zzet -> 0x0136 }
            r10.<init>(r1)     // Catch:{ zzet -> 0x0136 }
            r1.f16383k = r10     // Catch:{ zzet -> 0x0136 }
            r1.f16387o = r9     // Catch:{ zzet -> 0x0136 }
            goto L_0x0136
        L_0x00fe:
            r11 = move-exception
            m8927j(r4)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r1.m8922d(r10, r2)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r3[r12] = r10     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            r3[r9] = r2     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r9 = java.lang.String.format(r0, r3)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            m8924f(r9)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
            throw r11     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzek -> 0x011a, NullPointerException -> 0x0113 }
        L_0x0113:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzet r10 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzet -> 0x0136 }
            throw r10     // Catch:{ zzet -> 0x0136 }
        L_0x011a:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzet r10 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzet -> 0x0136 }
            throw r10     // Catch:{ zzet -> 0x0136 }
        L_0x0121:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzet r10 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzet -> 0x0136 }
            throw r10     // Catch:{ zzet -> 0x0136 }
        L_0x0128:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzet r10 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzet -> 0x0136 }
            throw r10     // Catch:{ zzet -> 0x0136 }
        L_0x012f:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzet r10 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzet -> 0x0136 }
            throw r10     // Catch:{ zzet -> 0x0136 }
        L_0x0136:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfa.zza(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.zzfa");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public final void mo17777b(int i, boolean z) {
        if (this.f16385m) {
            Future<?> submit = this.f16373a.submit(new zc0(this, i, z));
            if (i == 0) {
                this.f16382j = submit;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: g */
    public final zzcf.zza mo17778g(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException unused) {
            }
        }
        return m8929m();
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean isInitialized() {
        return this.f16387o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final zzey mo17781k() {
        return this.f16388p;
    }

    public final int zzbu() {
        if (this.f16383k != null) {
            return zzdt.zzbu();
        }
        return Integer.MIN_VALUE;
    }

    public final boolean zzcf() {
        return this.f16388p.mo17775a();
    }

    public final ExecutorService zzcg() {
        return this.f16373a;
    }

    public final DexClassLoader zzch() {
        return this.f16374b;
    }

    public final zzeh zzci() {
        return this.f16375c;
    }

    public final byte[] zzcj() {
        return this.f16376d;
    }

    public final boolean zzck() {
        return this.f16384l;
    }

    public final zzdt zzcl() {
        return this.f16383k;
    }

    public final boolean zzcm() {
        return this.f16385m;
    }

    public final zzcf.zza zzco() {
        return this.f16381i;
    }

    public final Future zzcp() {
        return this.f16382j;
    }

    public final AdvertisingIdClient zzcs() {
        if (!this.f16378f) {
            return null;
        }
        if (this.f16377e != null) {
            return this.f16377e;
        }
        Future future = this.f16379g;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.f16379g = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.f16379g.cancel(true);
            }
        }
        return this.f16377e;
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.f16386n.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.f16386n.put(new Pair(str, str2), new zzgj(this, str, str2, clsArr));
        return true;
    }

    public final Method zza(String str, String str2) {
        zzgj zzgj = this.f16386n.get(new Pair(str, str2));
        if (zzgj == null) {
            return null;
        }
        return zzgj.zzdb();
    }
}
