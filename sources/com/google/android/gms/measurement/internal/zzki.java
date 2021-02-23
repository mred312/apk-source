package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzlq;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzng;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzny;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public class zzki implements C3050m4 {

    /* renamed from: A */
    private static volatile zzki f18691A;

    /* renamed from: a */
    private zzfp f18692a;

    /* renamed from: b */
    private zzeu f18693b;

    /* renamed from: c */
    private C2950c f18694c;

    /* renamed from: d */
    private C3031k3 f18695d;

    /* renamed from: e */
    private zzke f18696e;

    /* renamed from: f */
    private C2939a8 f18697f;

    /* renamed from: g */
    private final zzks f18698g;

    /* renamed from: h */
    private C3105s5 f18699h;

    /* renamed from: i */
    private zzjo f18700i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final zzfv f18701j;

    /* renamed from: k */
    private boolean f18702k;

    /* renamed from: l */
    private boolean f18703l;
    @VisibleForTesting

    /* renamed from: m */
    private long f18704m;

    /* renamed from: n */
    private List<Runnable> f18705n;

    /* renamed from: o */
    private int f18706o;

    /* renamed from: p */
    private int f18707p;

    /* renamed from: q */
    private boolean f18708q;

    /* renamed from: r */
    private boolean f18709r;

    /* renamed from: s */
    private boolean f18710s;

    /* renamed from: t */
    private FileLock f18711t;

    /* renamed from: u */
    private FileChannel f18712u;

    /* renamed from: v */
    private List<Long> f18713v;

    /* renamed from: w */
    private List<Long> f18714w;

    /* renamed from: x */
    private long f18715x;

    /* renamed from: y */
    private final Map<String, zzad> f18716y;

    /* renamed from: z */
    private final C3143w7 f18717z;

    /* renamed from: com.google.android.gms.measurement.internal.zzki$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    private class C3171a implements C2960d {

        /* renamed from: a */
        zzcd.zzg f18718a;

        /* renamed from: b */
        List<Long> f18719b;

        /* renamed from: c */
        List<zzcd.zzc> f18720c;

        /* renamed from: d */
        private long f18721d;

        private C3171a(zzki zzki) {
        }

        /* renamed from: c */
        private static long m10952c(zzcd.zzc zzc) {
            return ((zzc.zze() / 1000) / 60) / 60;
        }

        /* renamed from: a */
        public final boolean mo19885a(long j, zzcd.zzc zzc) {
            Preconditions.checkNotNull(zzc);
            if (this.f18720c == null) {
                this.f18720c = new ArrayList();
            }
            if (this.f18719b == null) {
                this.f18719b = new ArrayList();
            }
            if (this.f18720c.size() > 0 && m10952c(this.f18720c.get(0)) != m10952c(zzc)) {
                return false;
            }
            long zzbo = this.f18721d + ((long) zzc.zzbo());
            if (zzbo >= ((long) Math.max(0, zzat.zzh.zza(null).intValue()))) {
                return false;
            }
            this.f18721d = zzbo;
            this.f18720c.add(zzc);
            this.f18719b.add(Long.valueOf(j));
            if (this.f18720c.size() >= Math.max(1, zzat.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        /* renamed from: b */
        public final void mo19886b(zzcd.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.f18718a = zzg;
        }

        /* synthetic */ C3171a(zzki zzki, C3089q7 q7Var) {
            this(zzki);
        }
    }

    private zzki(zzkq zzkq) {
        this(zzkq, (zzfv) null);
    }

    /* renamed from: A */
    private final boolean m10899A() {
        m10912Y();
        mo20508R();
        return zze().mo19864l0() || !TextUtils.isEmpty(zze().mo19849d());
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01aa  */
    @androidx.annotation.WorkerThread
    /* renamed from: B */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m10900B() {
        /*
            r21 = this;
            r0 = r21
            r21.m10912Y()
            r21.mo20508R()
            long r1 = r0.f18704m
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.common.util.Clock r1 = r1.zzl()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.f18704m
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzw()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.k3 r1 = r21.m10910W()
            r1.mo20013c()
            com.google.android.gms.measurement.internal.zzke r1 = r21.m10911X()
            r1.zze()
            return
        L_0x004b:
            r0.f18704m = r3
        L_0x004d:
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            boolean r1 = r1.zzaf()
            if (r1 == 0) goto L_0x0255
            boolean r1 = r21.m10899A()
            if (r1 != 0) goto L_0x005d
            goto L_0x0255
        L_0x005d:
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.common.util.Clock r1 = r1.zzl()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzat.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.c r5 = r21.zze()
            boolean r5 = r5.zzy()
            if (r5 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.c r5 = r21.zze()
            boolean r5 = r5.mo19851e()
            if (r5 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r5 = 0
            goto L_0x0090
        L_0x008f:
            r5 = 1
        L_0x0090:
            if (r5 == 0) goto L_0x00cc
            com.google.android.gms.measurement.internal.zzfv r10 = r0.f18701j
            com.google.android.gms.measurement.internal.zzy r10 = r10.zza()
            java.lang.String r10 = r10.zzu()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00bb
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00bb
            com.google.android.gms.measurement.internal.zzeg<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzat.zzu
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00dc
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzeg<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzat.zzt
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00dc
        L_0x00cc:
            com.google.android.gms.measurement.internal.zzeg<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzat.zzs
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzfv r12 = r0.f18701j
            com.google.android.gms.measurement.internal.m3 r12 = r12.zzb()
            com.google.android.gms.measurement.internal.zzfh r12 = r12.f18228d
            long r12 = r12.zza()
            com.google.android.gms.measurement.internal.zzfv r14 = r0.f18701j
            com.google.android.gms.measurement.internal.m3 r14 = r14.zzb()
            com.google.android.gms.measurement.internal.zzfh r14 = r14.f18229e
            long r14 = r14.zza()
            com.google.android.gms.measurement.internal.c r16 = r21.zze()
            r17 = r10
            long r9 = r16.mo19861j0()
            com.google.android.gms.measurement.internal.c r11 = r21.zze()
            r19 = r7
            long r6 = r11.mo19863k0()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0113
        L_0x0110:
            r10 = r3
            goto L_0x0188
        L_0x0113:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x0139
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0139
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x0139:
            com.google.android.gms.measurement.internal.zzks r5 = r21.zzh()
            r12 = r17
            boolean r5 = r5.mo20551x(r8, r12)
            if (r5 != 0) goto L_0x0147
            long r10 = r8 + r12
        L_0x0147:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0188
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0188
            r5 = 0
        L_0x0150:
            r6 = 20
            com.google.android.gms.measurement.internal.zzeg<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzat.zzab
            r8 = 0
            java.lang.Object r7 = r7.zza(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r9 = 0
            int r7 = java.lang.Math.max(r9, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0110
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzeg<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzat.zzaa
            java.lang.Object r12 = r12.zza(r8)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r10 = r10 + r12
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0185
            goto L_0x0188
        L_0x0185:
            int r5 = r5 + 1
            goto L_0x0150
        L_0x0188:
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01aa
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzw()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.k3 r1 = r21.m10910W()
            r1.mo20013c()
            com.google.android.gms.measurement.internal.zzke r1 = r21.m10911X()
            r1.zze()
            return
        L_0x01aa:
            com.google.android.gms.measurement.internal.zzeu r1 = r21.zzd()
            boolean r1 = r1.zze()
            if (r1 != 0) goto L_0x01d2
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzw()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.k3 r1 = r21.m10910W()
            r1.mo20012b()
            com.google.android.gms.measurement.internal.zzke r1 = r21.m10911X()
            r1.zze()
            return
        L_0x01d2:
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.measurement.internal.m3 r1 = r1.zzb()
            com.google.android.gms.measurement.internal.zzfh r1 = r1.f18230f
            long r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzat.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzks r7 = r21.zzh()
            boolean r7 = r7.mo20551x(r1, r5)
            if (r7 != 0) goto L_0x01fe
            long r1 = r1 + r5
            long r10 = java.lang.Math.max(r10, r1)
        L_0x01fe:
            com.google.android.gms.measurement.internal.k3 r1 = r21.m10910W()
            r1.mo20013c()
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.common.util.Clock r1 = r1.zzl()
            long r1 = r1.currentTimeMillis()
            long r10 = r10 - r1
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x023a
            com.google.android.gms.measurement.internal.zzeg<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzat.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r10 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.measurement.internal.m3 r1 = r1.zzb()
            com.google.android.gms.measurement.internal.zzfh r1 = r1.f18228d
            com.google.android.gms.measurement.internal.zzfv r2 = r0.f18701j
            com.google.android.gms.common.util.Clock r2 = r2.zzl()
            long r2 = r2.currentTimeMillis()
            r1.zza(r2)
        L_0x023a:
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzw()
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzke r1 = r21.m10911X()
            r1.zza(r10)
            return
        L_0x0255:
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzw()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.k3 r1 = r21.m10910W()
            r1.mo20013c()
            com.google.android.gms.measurement.internal.zzke r1 = r21.m10911X()
            r1.zze()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.m10900B():void");
    }

    @WorkerThread
    /* renamed from: C */
    private final void m10901C() {
        m10912Y();
        if (this.f18708q || this.f18709r || this.f18710s) {
            this.f18701j.zzq().zzw().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f18708q), Boolean.valueOf(this.f18709r), Boolean.valueOf(this.f18710s));
            return;
        }
        this.f18701j.zzq().zzw().zza("Stopping uploading service(s)");
        List<Runnable> list = this.f18705n;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.f18705n.clear();
        }
    }

    @WorkerThread
    @VisibleForTesting
    /* renamed from: D */
    private final boolean m10902D() {
        FileLock fileLock;
        m10912Y();
        if (!this.f18701j.zza().zza(zzat.zzbh) || (fileLock = this.f18711t) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.f18701j.zzm().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.f18712u = channel;
                FileLock tryLock = channel.tryLock();
                this.f18711t = tryLock;
                if (tryLock != null) {
                    this.f18701j.zzq().zzw().zza("Storage concurrent access okay");
                    return true;
                }
                this.f18701j.zzq().zze().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.f18701j.zzq().zze().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.f18701j.zzq().zze().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.f18701j.zzq().zzh().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.f18701j.zzq().zzw().zza("Storage concurrent access okay");
            return true;
        }
    }

    @WorkerThread
    /* renamed from: E */
    private final zzn m10903E(String str) {
        String str2 = str;
        C3013i3 P = zze().mo19834P(str2);
        if (P == null || TextUtils.isEmpty(P.mo19956T())) {
            this.f18701j.zzq().zzv().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean F = m10904F(P);
        if (F == null || F.booleanValue()) {
            return new zzn(str, P.mo19937A(), P.mo19956T(), P.mo19958V(), P.mo19960X(), P.mo19962Z(), P.mo19966b0(), (String) null, P.mo19972e0(), false, P.mo19949M(), P.mo19983k(), 0, 0, P.mo19985l(), P.mo19987m(), false, P.mo19940D(), P.mo19989n(), P.mo19970d0(), P.mo19990o(), (!zznt.zzb() || !this.f18701j.zza().zze(str2, zzat.zzbi)) ? null : P.mo19943G(), (!zzmj.zzb() || !this.f18701j.zza().zza(zzat.zzci)) ? "" : mo20513b(str).zza());
        }
        this.f18701j.zzq().zze().zza("App version does not match; dropping. appId", zzer.zza(str));
        return null;
    }

    @WorkerThread
    /* renamed from: F */
    private final Boolean m10904F(C3013i3 i3Var) {
        Boolean bool = Boolean.TRUE;
        try {
            if (i3Var.mo19958V() != -2147483648L) {
                if (i3Var.mo19958V() == ((long) Wrappers.packageManager(this.f18701j.zzm()).getPackageInfo(i3Var.mo19995t(), 0).versionCode)) {
                    return bool;
                }
            } else {
                String str = Wrappers.packageManager(this.f18701j.zzm()).getPackageInfo(i3Var.mo19995t(), 0).versionName;
                if (i3Var.mo19956T() != null && i3Var.mo19956T().equals(str)) {
                    return bool;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: G */
    private final void m10905G(zzcd.zzc.zza zza, zzcd.zzc.zza zza2) {
        Preconditions.checkArgument("_e".equals(zza.zzd()));
        zzh();
        zzcd.zze f = zzks.m10958f((zzcd.zzc) ((zzhz) zza.zzz()), "_et");
        if (f.zze() && f.zzf() > 0) {
            long zzf = f.zzf();
            zzh();
            zzcd.zze f2 = zzks.m10958f((zzcd.zzc) ((zzhz) zza2.zzz()), "_et");
            if (f2 != null && f2.zzf() > 0) {
                zzf += f2.zzf();
            }
            zzh();
            zzks.m10963o(zza2, "_et", Long.valueOf(zzf));
            zzh();
            zzks.m10963o(zza, "_fr", 1L);
        }
    }

    @WorkerThread
    /* renamed from: H */
    private final void m10906H(zzar zzar, zzn zzn) {
        if (zzny.zzb() && this.f18701j.zza().zza(zzat.zzbz)) {
            zzev zza = zzev.zza(zzar);
            this.f18701j.zzh().mo20572m(zza.zzb, zze().mo19855g0(zzn.zza));
            this.f18701j.zzh().mo20574o(zza, this.f18701j.zza().zza(zzn.zza));
            zzar = zza.zza();
        }
        if (this.f18701j.zza().zza(zzat.zzbd) && "_cmp".equals(zzar.zza) && "referrer API v2".equals(zzar.zzb.mo20242e("_cis"))) {
            String e = zzar.zzb.mo20242e("gclid");
            if (!TextUtils.isEmpty(e)) {
                mo20518p(new zzkr("_lgclid", zzar.zzd, e, "auto"), zzn);
            }
        }
        mo20515j(zzar, zzn);
    }

    /* renamed from: I */
    private static void m10907I(C3071o7 o7Var) {
        if (o7Var == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!o7Var.mo20081a()) {
            String valueOf = String.valueOf(o7Var.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0927, code lost:
        r11 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02f4 A[Catch:{ SQLiteException -> 0x0283, all -> 0x09b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0353 A[Catch:{ SQLiteException -> 0x0283, all -> 0x09b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016a A[Catch:{ SQLiteException -> 0x0283, all -> 0x09b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0172 A[Catch:{ SQLiteException -> 0x0283, all -> 0x09b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02bb A[Catch:{ SQLiteException -> 0x0283, all -> 0x09b8 }] */
    @androidx.annotation.WorkerThread
    /* renamed from: O */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m10908O(com.google.android.gms.measurement.internal.zzar r27, com.google.android.gms.measurement.internal.zzn r28) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            r3 = r28
            java.lang.String r4 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)
            java.lang.String r5 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r26.m10912Y()
            r26.mo20508R()
            java.lang.String r15 = r3.zza
            r26.zzh()
            boolean r7 = com.google.android.gms.measurement.internal.zzks.m10970y(r27, r28)
            if (r7 != 0) goto L_0x0026
            return
        L_0x0026:
            boolean r7 = r3.zzh
            if (r7 != 0) goto L_0x002e
            r1.mo20506N(r3)
            return
        L_0x002e:
            com.google.android.gms.measurement.internal.zzfp r7 = r26.zzc()
            java.lang.String r8 = r2.zza
            boolean r7 = r7.mo20337e(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            if (r7 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzq()
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzh()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzfv r5 = r1.f18701j
            com.google.android.gms.measurement.internal.zzep r5 = r5.zzi()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zza((java.lang.String) r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfp r3 = r26.zzc()
            boolean r3 = r3.mo20343k(r15)
            if (r3 != 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzfp r3 = r26.zzc()
            boolean r3 = r3.zzh(r15)
            if (r3 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r3 = 0
            goto L_0x0074
        L_0x0073:
            r3 = 1
        L_0x0074:
            if (r3 != 0) goto L_0x0094
            java.lang.String r4 = r2.zza
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x0094
            com.google.android.gms.measurement.internal.zzfv r4 = r1.f18701j
            com.google.android.gms.measurement.internal.zzkw r7 = r4.zzh()
            com.google.android.gms.measurement.internal.w7 r8 = r1.f18717z
            r10 = 11
            java.lang.String r12 = r2.zza
            r2 = 0
            java.lang.String r11 = "_ev"
            r9 = r15
            r4 = r13
            r13 = r2
            r7.mo20575p(r8, r9, r10, r11, r12, r13)
            goto L_0x0095
        L_0x0094:
            r4 = r13
        L_0x0095:
            if (r3 == 0) goto L_0x00de
            com.google.android.gms.measurement.internal.c r2 = r26.zze()
            com.google.android.gms.measurement.internal.i3 r2 = r2.mo19834P(r15)
            if (r2 == 0) goto L_0x00de
            long r5 = r2.mo19978h0()
            long r7 = r2.mo19976g0()
            long r5 = java.lang.Math.max(r5, r7)
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j
            com.google.android.gms.common.util.Clock r3 = r3.zzl()
            long r7 = r3.currentTimeMillis()
            long r7 = r7 - r5
            long r5 = java.lang.Math.abs(r7)
            com.google.android.gms.measurement.internal.zzeg<java.lang.Long> r3 = com.google.android.gms.measurement.internal.zzat.zzy
            java.lang.Object r3 = r3.zza(r4)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzq()
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzv()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.m10922l(r2)
        L_0x00de:
            return
        L_0x00df:
            boolean r7 = com.google.android.gms.internal.measurement.zzmi.zzb()
            if (r7 == 0) goto L_0x010e
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzat.zzbv
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r8)
            if (r7 == 0) goto L_0x010e
            com.google.android.gms.measurement.internal.zzev r2 = com.google.android.gms.measurement.internal.zzev.zza(r27)
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzh()
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j
            com.google.android.gms.measurement.internal.zzy r8 = r8.zza()
            int r8 = r8.zza((java.lang.String) r15)
            r7.mo20574o(r2, r8)
            com.google.android.gms.measurement.internal.zzar r2 = r2.zza()
        L_0x010e:
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzq()
            r8 = 2
            boolean r7 = r7.zza((int) r8)
            if (r7 == 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzq()
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzw()
            com.google.android.gms.measurement.internal.zzfv r9 = r1.f18701j
            com.google.android.gms.measurement.internal.zzep r9 = r9.zzi()
            java.lang.String r9 = r9.zza((com.google.android.gms.measurement.internal.zzar) r2)
            java.lang.String r10 = "Logging event"
            r7.zza(r10, r9)
        L_0x0134:
            com.google.android.gms.measurement.internal.c r7 = r26.zze()
            r7.zze()
            r1.mo20506N(r3)     // Catch:{ all -> 0x09b8 }
            java.lang.String r7 = "ecommerce_purchase"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x09b8 }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x09b8 }
            java.lang.String r9 = "refund"
            if (r7 != 0) goto L_0x015f
            java.lang.String r7 = "purchase"
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x09b8 }
            boolean r7 = r7.equals(r10)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x015f
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09b8 }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x015d
            goto L_0x015f
        L_0x015d:
            r7 = 0
            goto L_0x0160
        L_0x015f:
            r7 = 1
        L_0x0160:
            java.lang.String r10 = "_iap"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x09b8 }
            boolean r10 = r10.equals(r11)     // Catch:{ all -> 0x09b8 }
            if (r10 != 0) goto L_0x016f
            if (r7 == 0) goto L_0x016d
            goto L_0x016f
        L_0x016d:
            r10 = 0
            goto L_0x0170
        L_0x016f:
            r10 = 1
        L_0x0170:
            if (r10 == 0) goto L_0x0303
            com.google.android.gms.measurement.internal.zzam r10 = r2.zzb     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = "currency"
            java.lang.String r10 = r10.mo20242e(r11)     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = "value"
            if (r7 == 0) goto L_0x01dc
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x09b8 }
            java.lang.Double r7 = r7.mo20241d(r11)     // Catch:{ all -> 0x09b8 }
            double r17 = r7.doubleValue()     // Catch:{ all -> 0x09b8 }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r7 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r7 != 0) goto L_0x01a5
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x09b8 }
            java.lang.Long r7 = r7.mo20240c(r11)     // Catch:{ all -> 0x09b8 }
            long r12 = r7.longValue()     // Catch:{ all -> 0x09b8 }
            double r11 = (double) r12
            java.lang.Double.isNaN(r11)
            double r17 = r11 * r19
        L_0x01a5:
            r11 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r7 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x01bf
            r11 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r7 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x01bf
            long r11 = java.lang.Math.round(r17)     // Catch:{ all -> 0x09b8 }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09b8 }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x01e6
            long r11 = -r11
            goto L_0x01e6
        L_0x01bf:
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzh()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r15)     // Catch:{ all -> 0x09b8 }
            java.lang.Double r10 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x09b8 }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x09b8 }
            r23 = r5
            r5 = 0
            r11 = 0
            goto L_0x02f2
        L_0x01dc:
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x09b8 }
            java.lang.Long r7 = r7.mo20240c(r11)     // Catch:{ all -> 0x09b8 }
            long r11 = r7.longValue()     // Catch:{ all -> 0x09b8 }
        L_0x01e6:
            boolean r7 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x02ee
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ all -> 0x09b8 }
            java.lang.String r7 = r10.toUpperCase(r7)     // Catch:{ all -> 0x09b8 }
            java.lang.String r9 = "[A-Z]{3}"
            boolean r9 = r7.matches(r9)     // Catch:{ all -> 0x09b8 }
            if (r9 == 0) goto L_0x02ee
            java.lang.String r9 = "_ltv_"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x09b8 }
            int r10 = r7.length()     // Catch:{ all -> 0x09b8 }
            if (r10 == 0) goto L_0x020b
            java.lang.String r7 = r9.concat(r7)     // Catch:{ all -> 0x09b8 }
            goto L_0x0210
        L_0x020b:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x09b8 }
            r7.<init>(r9)     // Catch:{ all -> 0x09b8 }
        L_0x0210:
            r10 = r7
            com.google.android.gms.measurement.internal.c r7 = r26.zze()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.v7 r7 = r7.mo19838U(r15, r10)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x024a
            java.lang.Object r7 = r7.f18419e     // Catch:{ all -> 0x09b8 }
            boolean r9 = r7 instanceof java.lang.Long     // Catch:{ all -> 0x09b8 }
            if (r9 != 0) goto L_0x0222
            goto L_0x024a
        L_0x0222:
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x09b8 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.v7 r17 = new com.google.android.gms.measurement.internal.v7     // Catch:{ all -> 0x09b8 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r13 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.common.util.Clock r13 = r13.zzl()     // Catch:{ all -> 0x09b8 }
            long r18 = r13.currentTimeMillis()     // Catch:{ all -> 0x09b8 }
            long r7 = r7 + r11
            java.lang.Long r13 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09b8 }
            r7 = r17
            r8 = r15
            r23 = r5
            r5 = 0
            r6 = 1
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x09b8 }
        L_0x0247:
            r6 = r17
            goto L_0x02b1
        L_0x024a:
            r23 = r5
            r5 = 0
            r6 = 1
            com.google.android.gms.measurement.internal.c r7 = r26.zze()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r9 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zza()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzat.zzad     // Catch:{ all -> 0x09b8 }
            int r9 = r9.zzb(r15, r13)     // Catch:{ all -> 0x09b8 }
            int r9 = r9 - r6
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x09b8 }
            r7.zzc()     // Catch:{ all -> 0x09b8 }
            r7.zzaj()     // Catch:{ all -> 0x09b8 }
            android.database.sqlite.SQLiteDatabase r13 = r7.mo19847c()     // Catch:{ SQLiteException -> 0x0283 }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0283 }
            r6[r5] = r15     // Catch:{ SQLiteException -> 0x0283 }
            r16 = 1
            r6[r16] = r15     // Catch:{ SQLiteException -> 0x0283 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x0283 }
            r16 = 2
            r6[r16] = r9     // Catch:{ SQLiteException -> 0x0283 }
            r13.execSQL(r8, r6)     // Catch:{ SQLiteException -> 0x0283 }
            goto L_0x0296
        L_0x0283:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r15)     // Catch:{ all -> 0x09b8 }
            r7.zza(r8, r9, r6)     // Catch:{ all -> 0x09b8 }
        L_0x0296:
            com.google.android.gms.measurement.internal.v7 r17 = new com.google.android.gms.measurement.internal.v7     // Catch:{ all -> 0x09b8 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r6 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.common.util.Clock r6 = r6.zzl()     // Catch:{ all -> 0x09b8 }
            long r18 = r6.currentTimeMillis()     // Catch:{ all -> 0x09b8 }
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x09b8 }
            r7 = r17
            r8 = r15
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x09b8 }
            goto L_0x0247
        L_0x02b1:
            com.google.android.gms.measurement.internal.c r7 = r26.zze()     // Catch:{ all -> 0x09b8 }
            boolean r7 = r7.mo19831A(r6)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x02f1
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r15)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r10 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzep r10 = r10.zzi()     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r6.f18417c     // Catch:{ all -> 0x09b8 }
            java.lang.String r10 = r10.zzc(r11)     // Catch:{ all -> 0x09b8 }
            java.lang.Object r6 = r6.f18419e     // Catch:{ all -> 0x09b8 }
            r7.zza(r8, r9, r10, r6)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r6 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzkw r7 = r6.zzh()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.w7 r8 = r1.f18717z     // Catch:{ all -> 0x09b8 }
            r10 = 9
            r11 = 0
            r12 = 0
            r13 = 0
            r9 = r15
            r7.mo20575p(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x09b8 }
            goto L_0x02f1
        L_0x02ee:
            r23 = r5
            r5 = 0
        L_0x02f1:
            r11 = 1
        L_0x02f2:
            if (r11 != 0) goto L_0x0306
            com.google.android.gms.measurement.internal.c r2 = r26.zze()     // Catch:{ all -> 0x09b8 }
            r2.mo19845b()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.c r2 = r26.zze()
            r2.mo19850d0()
            return
        L_0x0303:
            r23 = r5
            r5 = 0
        L_0x0306:
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x09b8 }
            boolean r6 = com.google.android.gms.measurement.internal.zzkw.m11010w(r6)     // Catch:{ all -> 0x09b8 }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09b8 }
            boolean r18 = r14.equals(r7)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            r7.zzh()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x09b8 }
            long r7 = com.google.android.gms.measurement.internal.zzkw.zza((com.google.android.gms.measurement.internal.zzam) r7)     // Catch:{ all -> 0x09b8 }
            r19 = 1
            long r11 = r7 + r19
            com.google.android.gms.measurement.internal.c r7 = r26.zze()     // Catch:{ all -> 0x09b8 }
            long r8 = r26.m10913Z()     // Catch:{ all -> 0x09b8 }
            r13 = 1
            r16 = 0
            r17 = 0
            r10 = r15
            r14 = r6
            r27 = r15
            r15 = r16
            r16 = r18
            com.google.android.gms.measurement.internal.zzaf r7 = r7.mo19858i(r8, r10, r11, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x09b8 }
            long r8 = r7.f18494b     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzat.zzj     // Catch:{ all -> 0x09b8 }
            r14 = 0
            java.lang.Object r10 = r10.zza(r14)     // Catch:{ all -> 0x09b8 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x09b8 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x09b8 }
            long r10 = (long) r10     // Catch:{ all -> 0x09b8 }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            int r15 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x0380
            long r8 = r8 % r10
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0371
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r27)     // Catch:{ all -> 0x09b8 }
            long r5 = r7.f18494b     // Catch:{ all -> 0x09b8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x09b8 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x09b8 }
        L_0x0371:
            com.google.android.gms.measurement.internal.c r2 = r26.zze()     // Catch:{ all -> 0x09b8 }
            r2.mo19845b()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.c r2 = r26.zze()
            r2.mo19850d0()
            return
        L_0x0380:
            if (r6 == 0) goto L_0x03d7
            long r8 = r7.f18493a     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzat.zzl     // Catch:{ all -> 0x09b8 }
            java.lang.Object r15 = r15.zza(r14)     // Catch:{ all -> 0x09b8 }
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ all -> 0x09b8 }
            int r15 = r15.intValue()     // Catch:{ all -> 0x09b8 }
            long r14 = (long) r15     // Catch:{ all -> 0x09b8 }
            long r8 = r8 - r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x03d7
            long r8 = r8 % r10
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x03b4
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r27)     // Catch:{ all -> 0x09b8 }
            long r6 = r7.f18493a     // Catch:{ all -> 0x09b8 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x09b8 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x09b8 }
        L_0x03b4:
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzkw r7 = r3.zzh()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.w7 r8 = r1.f18717z     // Catch:{ all -> 0x09b8 }
            r10 = 16
            java.lang.String r11 = "_ev"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x09b8 }
            r13 = 0
            r9 = r27
            r7.mo20575p(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.c r2 = r26.zze()     // Catch:{ all -> 0x09b8 }
            r2.mo19845b()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.c r2 = r26.zze()
            r2.mo19850d0()
            return
        L_0x03d7:
            if (r18 == 0) goto L_0x0426
            long r8 = r7.f18496d     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r10 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r10 = r10.zza()     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzat.zzk     // Catch:{ all -> 0x09b8 }
            int r10 = r10.zzb(r11, r14)     // Catch:{ all -> 0x09b8 }
            r11 = 1000000(0xf4240, float:1.401298E-39)
            int r10 = java.lang.Math.min(r11, r10)     // Catch:{ all -> 0x09b8 }
            int r10 = java.lang.Math.max(r5, r10)     // Catch:{ all -> 0x09b8 }
            long r10 = (long) r10     // Catch:{ all -> 0x09b8 }
            long r8 = r8 - r10
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0426
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0417
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r27)     // Catch:{ all -> 0x09b8 }
            long r5 = r7.f18496d     // Catch:{ all -> 0x09b8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x09b8 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x09b8 }
        L_0x0417:
            com.google.android.gms.measurement.internal.c r2 = r26.zze()     // Catch:{ all -> 0x09b8 }
            r2.mo19845b()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.c r2 = r26.zze()
            r2.mo19850d0()
            return
        L_0x0426:
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x09b8 }
            android.os.Bundle r14 = r7.zzb()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzh()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09b8 }
            r7.mo20573n(r14, r8, r9)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzh()     // Catch:{ all -> 0x09b8 }
            r15 = r27
            boolean r7 = r7.mo20563T(r15)     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = "_r"
            if (r7 == 0) goto L_0x0465
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzh()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = "_dbg"
            java.lang.Long r9 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x09b8 }
            r7.mo20573n(r14, r8, r9)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzh()     // Catch:{ all -> 0x09b8 }
            java.lang.Long r8 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x09b8 }
            r7.mo20573n(r14, r11, r8)     // Catch:{ all -> 0x09b8 }
        L_0x0465:
            java.lang.String r7 = "_s"
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x09b8 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x048c
            com.google.android.gms.measurement.internal.c r7 = r26.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.v7 r7 = r7.mo19838U(r8, r4)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x048c
            java.lang.Object r8 = r7.f18419e     // Catch:{ all -> 0x09b8 }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x048c
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzkw r8 = r8.zzh()     // Catch:{ all -> 0x09b8 }
            java.lang.Object r7 = r7.f18419e     // Catch:{ all -> 0x09b8 }
            r8.mo20573n(r14, r4, r7)     // Catch:{ all -> 0x09b8 }
        L_0x048c:
            com.google.android.gms.measurement.internal.c r4 = r26.zze()     // Catch:{ all -> 0x09b8 }
            long r7 = r4.mo19837T(r15)     // Catch:{ all -> 0x09b8 }
            int r4 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x04af
            com.google.android.gms.measurement.internal.zzfv r4 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzh()     // Catch:{ all -> 0x09b8 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r15)     // Catch:{ all -> 0x09b8 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09b8 }
            r4.zza(r9, r10, r7)     // Catch:{ all -> 0x09b8 }
        L_0x04af:
            com.google.android.gms.measurement.internal.zzak r4 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09b8 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x09b8 }
            long r12 = r2.zzd     // Catch:{ all -> 0x09b8 }
            r18 = 0
            r7 = r4
            r2 = r10
            r10 = r15
            r5 = r11
            r11 = r2
            r16 = r14
            r2 = r15
            r25 = 0
            r14 = r18
            r7.<init>((com.google.android.gms.measurement.internal.zzfv) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (android.os.Bundle) r16)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.c r7 = r26.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = r4.f18499b     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.h r7 = r7.mo19862k(r2, r8)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x054f
            com.google.android.gms.measurement.internal.c r7 = r26.zze()     // Catch:{ all -> 0x09b8 }
            long r7 = r7.mo19852e0(r2)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r9 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zza()     // Catch:{ all -> 0x09b8 }
            int r9 = r9.mo20601c(r2)     // Catch:{ all -> 0x09b8 }
            long r9 = (long) r9     // Catch:{ all -> 0x09b8 }
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0535
            if (r6 == 0) goto L_0x0535
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r2)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzi()     // Catch:{ all -> 0x09b8 }
            java.lang.String r4 = r4.f18499b     // Catch:{ all -> 0x09b8 }
            java.lang.String r4 = r7.zza((java.lang.String) r4)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x09b8 }
            int r7 = r7.mo20601c(r2)     // Catch:{ all -> 0x09b8 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x09b8 }
            r3.zza(r5, r6, r4, r7)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzkw r7 = r3.zzh()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.w7 r8 = r1.f18717z     // Catch:{ all -> 0x09b8 }
            r10 = 8
            r11 = 0
            r12 = 0
            r13 = 0
            r9 = r2
            r7.mo20575p(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.c r2 = r26.zze()
            r2.mo19850d0()
            return
        L_0x0535:
            com.google.android.gms.measurement.internal.h r6 = new com.google.android.gms.measurement.internal.h     // Catch:{ all -> 0x09b8 }
            java.lang.String r9 = r4.f18499b     // Catch:{ all -> 0x09b8 }
            r10 = 0
            r12 = 0
            long r14 = r4.f18501d     // Catch:{ all -> 0x09b8 }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r6
            r8 = r2
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x09b8 }
            goto L_0x055d
        L_0x054f:
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            long r8 = r7.f18098f     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzak r4 = r4.mo20231a(r2, r8)     // Catch:{ all -> 0x09b8 }
            long r8 = r4.f18501d     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.h r6 = r7.mo19921a(r8)     // Catch:{ all -> 0x09b8 }
        L_0x055d:
            com.google.android.gms.measurement.internal.c r2 = r26.zze()     // Catch:{ all -> 0x09b8 }
            r2.mo19871u(r6)     // Catch:{ all -> 0x09b8 }
            r26.m10912Y()     // Catch:{ all -> 0x09b8 }
            r26.mo20508R()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)     // Catch:{ all -> 0x09b8 }
            java.lang.String r2 = r4.f18498a     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x09b8 }
            java.lang.String r2 = r4.f18498a     // Catch:{ all -> 0x09b8 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x09b8 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = com.google.android.gms.internal.measurement.zzcd.zzg.zzbh()     // Catch:{ all -> 0x09b8 }
            r6 = 1
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r2.zza((int) r6)     // Catch:{ all -> 0x09b8 }
            java.lang.String r7 = "android"
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r2.zza((java.lang.String) r7)     // Catch:{ all -> 0x09b8 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x059c
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09b8 }
            r2.zzf((java.lang.String) r7)     // Catch:{ all -> 0x09b8 }
        L_0x059c:
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x05a9
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x09b8 }
            r2.zze((java.lang.String) r7)     // Catch:{ all -> 0x09b8 }
        L_0x05a9:
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x05b6
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x09b8 }
            r2.zzg((java.lang.String) r7)     // Catch:{ all -> 0x09b8 }
        L_0x05b6:
            long r7 = r3.zzj     // Catch:{ all -> 0x09b8 }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x05c3
            int r8 = (int) r7     // Catch:{ all -> 0x09b8 }
            r2.zzh((int) r8)     // Catch:{ all -> 0x09b8 }
        L_0x05c3:
            long r7 = r3.zze     // Catch:{ all -> 0x09b8 }
            r2.zzf((long) r7)     // Catch:{ all -> 0x09b8 }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x05d5
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x09b8 }
            r2.zzk((java.lang.String) r7)     // Catch:{ all -> 0x09b8 }
        L_0x05d5:
            boolean r7 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x0600
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x09b8 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r8)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x0600
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzad r7 = r1.mo20513b(r7)     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = r3.zzw     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzad r8 = com.google.android.gms.measurement.internal.zzad.zza((java.lang.String) r8)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzad r7 = r7.zzb((com.google.android.gms.measurement.internal.zzad) r8)     // Catch:{ all -> 0x09b8 }
            java.lang.String r7 = r7.zza()     // Catch:{ all -> 0x09b8 }
            r2.zzq(r7)     // Catch:{ all -> 0x09b8 }
        L_0x0600:
            boolean r7 = com.google.android.gms.internal.measurement.zznt.zzb()     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x064f
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzat.zzbi     // Catch:{ all -> 0x09b8 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x064f
            java.lang.String r7 = r2.zzo()     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x062d
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x062d
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x09b8 }
            r2.zzp(r7)     // Catch:{ all -> 0x09b8 }
        L_0x062d:
            java.lang.String r7 = r2.zzo()     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x0666
            java.lang.String r7 = r2.zzs()     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x0666
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x0666
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09b8 }
            r2.zzo(r7)     // Catch:{ all -> 0x09b8 }
            goto L_0x0666
        L_0x064f:
            java.lang.String r7 = r2.zzo()     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x0666
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x0666
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09b8 }
            r2.zzo(r7)     // Catch:{ all -> 0x09b8 }
        L_0x0666:
            long r7 = r3.zzf     // Catch:{ all -> 0x09b8 }
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0671
            r2.zzh((long) r7)     // Catch:{ all -> 0x09b8 }
        L_0x0671:
            long r7 = r3.zzt     // Catch:{ all -> 0x09b8 }
            r2.zzk((long) r7)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzks r7 = r26.zzh()     // Catch:{ all -> 0x09b8 }
            java.util.List r7 = r7.mo20541E()     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x0683
            r2.zzd((java.lang.Iterable<? extends java.lang.Integer>) r7)     // Catch:{ all -> 0x09b8 }
        L_0x0683:
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzad r7 = r1.mo20513b(r7)     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = r3.zzw     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzad r8 = com.google.android.gms.measurement.internal.zzad.zza((java.lang.String) r8)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzad r7 = r7.zzb((com.google.android.gms.measurement.internal.zzad) r8)     // Catch:{ all -> 0x09b8 }
            boolean r8 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x06ad
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r8 = r8.zza()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x09b8 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r11)     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x06ad
            boolean r8 = r7.zzc()     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x0753
        L_0x06ad:
            com.google.android.gms.measurement.internal.zzjo r8 = r1.f18700i     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09b8 }
            android.util.Pair r8 = r8.mo20487b(r11, r7)     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x06db
            java.lang.Object r11 = r8.first     // Catch:{ all -> 0x09b8 }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ all -> 0x09b8 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x09b8 }
            if (r11 != 0) goto L_0x06db
            boolean r11 = r3.zzo     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x0753
            java.lang.Object r11 = r8.first     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x09b8 }
            r2.zzh((java.lang.String) r11)     // Catch:{ all -> 0x09b8 }
            java.lang.Object r8 = r8.second     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x0753
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x09b8 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x09b8 }
            r2.zza((boolean) r8)     // Catch:{ all -> 0x09b8 }
            goto L_0x0753
        L_0x06db:
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzal r8 = r8.zzw()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            android.content.Context r11 = r11.zzm()     // Catch:{ all -> 0x09b8 }
            boolean r8 = r8.zza(r11)     // Catch:{ all -> 0x09b8 }
            if (r8 != 0) goto L_0x0753
            boolean r8 = r3.zzp     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x0753
            boolean r8 = com.google.android.gms.internal.measurement.zzox.zzb()     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x0707
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r8 = r8.zza()     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzat.zzcf     // Catch:{ all -> 0x09b8 }
            boolean r8 = r8.zze(r11, r12)     // Catch:{ all -> 0x09b8 }
            if (r8 != 0) goto L_0x0753
        L_0x0707:
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            android.content.Context r8 = r8.zzm()     // Catch:{ all -> 0x09b8 }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = "android_id"
            java.lang.String r8 = android.provider.Settings.Secure.getString(r8, r11)     // Catch:{ all -> 0x09b8 }
            if (r8 != 0) goto L_0x0733
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzh()     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = "null secure ID. appId"
            java.lang.String r12 = r2.zzj()     // Catch:{ all -> 0x09b8 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r12)     // Catch:{ all -> 0x09b8 }
            r8.zza(r11, r12)     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = "null"
            goto L_0x0750
        L_0x0733:
            boolean r11 = r8.isEmpty()     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x0750
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzer r11 = r11.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r11 = r11.zzh()     // Catch:{ all -> 0x09b8 }
            java.lang.String r12 = "empty secure ID. appId"
            java.lang.String r13 = r2.zzj()     // Catch:{ all -> 0x09b8 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r13)     // Catch:{ all -> 0x09b8 }
            r11.zza(r12, r13)     // Catch:{ all -> 0x09b8 }
        L_0x0750:
            r2.zzm(r8)     // Catch:{ all -> 0x09b8 }
        L_0x0753:
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzal r8 = r8.zzw()     // Catch:{ all -> 0x09b8 }
            r8.zzaa()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = android.os.Build.MODEL     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r8 = r2.zzc((java.lang.String) r8)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzal r11 = r11.zzw()     // Catch:{ all -> 0x09b8 }
            r11.zzaa()     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r8 = r8.zzb((java.lang.String) r11)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzal r11 = r11.zzw()     // Catch:{ all -> 0x09b8 }
            long r11 = r11.zze()     // Catch:{ all -> 0x09b8 }
            int r12 = (int) r11     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r8 = r8.zzf((int) r12)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzal r11 = r11.zzw()     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r11.zzf()     // Catch:{ all -> 0x09b8 }
            r8.zzd((java.lang.String) r11)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r8 = r8.zza()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzat.zzbx     // Catch:{ all -> 0x09b8 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r11)     // Catch:{ all -> 0x09b8 }
            if (r8 != 0) goto L_0x07a0
            long r11 = r3.zzl     // Catch:{ all -> 0x09b8 }
            r2.zzj((long) r11)     // Catch:{ all -> 0x09b8 }
        L_0x07a0:
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            boolean r8 = r8.zzaa()     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x07ce
            boolean r8 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x07c0
            com.google.android.gms.measurement.internal.zzfv r8 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r8 = r8.zza()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x09b8 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r11)     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x07c0
            r2.zzj()     // Catch:{ all -> 0x09b8 }
            goto L_0x07c3
        L_0x07c0:
            r2.zzj()     // Catch:{ all -> 0x09b8 }
        L_0x07c3:
            boolean r8 = android.text.TextUtils.isEmpty(r25)     // Catch:{ all -> 0x09b8 }
            if (r8 != 0) goto L_0x07ce
            r8 = r25
            r2.zzn(r8)     // Catch:{ all -> 0x09b8 }
        L_0x07ce:
            com.google.android.gms.measurement.internal.c r8 = r26.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.i3 r8 = r8.mo19834P(r11)     // Catch:{ all -> 0x09b8 }
            if (r8 != 0) goto L_0x087b
            com.google.android.gms.measurement.internal.i3 r8 = new com.google.android.gms.measurement.internal.i3     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x09b8 }
            r8.<init>(r11, r12)     // Catch:{ all -> 0x09b8 }
            boolean r11 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x07ff
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r11 = r11.zza()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x09b8 }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r12)     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x07ff
            java.lang.String r11 = r1.m10918e(r7)     // Catch:{ all -> 0x09b8 }
            r8.mo19967c(r11)     // Catch:{ all -> 0x09b8 }
            goto L_0x0806
        L_0x07ff:
            java.lang.String r11 = r26.m10915a0()     // Catch:{ all -> 0x09b8 }
            r8.mo19967c(r11)     // Catch:{ all -> 0x09b8 }
        L_0x0806:
            java.lang.String r11 = r3.zzk     // Catch:{ all -> 0x09b8 }
            r8.mo19942F(r11)     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r3.zzb     // Catch:{ all -> 0x09b8 }
            r8.mo19993r(r11)     // Catch:{ all -> 0x09b8 }
            boolean r11 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x082a
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r11 = r11.zza()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x09b8 }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r12)     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x082a
            boolean r11 = r7.zzc()     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x0835
        L_0x082a:
            com.google.android.gms.measurement.internal.zzjo r11 = r1.f18700i     // Catch:{ all -> 0x09b8 }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r11.zza(r12)     // Catch:{ all -> 0x09b8 }
            r8.mo19939C(r11)     // Catch:{ all -> 0x09b8 }
        L_0x0835:
            r8.mo19944H(r9)     // Catch:{ all -> 0x09b8 }
            r8.mo19963a(r9)     // Catch:{ all -> 0x09b8 }
            r8.mo19992q(r9)     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r3.zzc     // Catch:{ all -> 0x09b8 }
            r8.mo19945I(r11)     // Catch:{ all -> 0x09b8 }
            long r11 = r3.zzj     // Catch:{ all -> 0x09b8 }
            r8.mo19996u(r11)     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r3.zzd     // Catch:{ all -> 0x09b8 }
            r8.mo19948L(r11)     // Catch:{ all -> 0x09b8 }
            long r11 = r3.zze     // Catch:{ all -> 0x09b8 }
            r8.mo20000y(r11)     // Catch:{ all -> 0x09b8 }
            long r11 = r3.zzf     // Catch:{ all -> 0x09b8 }
            r8.mo19938B(r11)     // Catch:{ all -> 0x09b8 }
            boolean r11 = r3.zzh     // Catch:{ all -> 0x09b8 }
            r8.mo19971e(r11)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r11 = r11.zza()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzat.zzbx     // Catch:{ all -> 0x09b8 }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r12)     // Catch:{ all -> 0x09b8 }
            if (r11 != 0) goto L_0x086f
            long r11 = r3.zzl     // Catch:{ all -> 0x09b8 }
            r8.mo19968c0(r11)     // Catch:{ all -> 0x09b8 }
        L_0x086f:
            long r11 = r3.zzt     // Catch:{ all -> 0x09b8 }
            r8.mo19941E(r11)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.c r11 = r26.zze()     // Catch:{ all -> 0x09b8 }
            r11.mo19872v(r8)     // Catch:{ all -> 0x09b8 }
        L_0x087b:
            boolean r11 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x0895
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r11 = r11.zza()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x09b8 }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r12)     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x0895
            boolean r7 = r7.zze()     // Catch:{ all -> 0x09b8 }
            if (r7 == 0) goto L_0x08a6
        L_0x0895:
            java.lang.String r7 = r8.mo19999x()     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x08a6
            java.lang.String r7 = r8.mo19999x()     // Catch:{ all -> 0x09b8 }
            r2.zzi((java.lang.String) r7)     // Catch:{ all -> 0x09b8 }
        L_0x08a6:
            java.lang.String r7 = r8.mo19949M()     // Catch:{ all -> 0x09b8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09b8 }
            if (r7 != 0) goto L_0x08b7
            java.lang.String r7 = r8.mo19949M()     // Catch:{ all -> 0x09b8 }
            r2.zzl((java.lang.String) r7)     // Catch:{ all -> 0x09b8 }
        L_0x08b7:
            com.google.android.gms.measurement.internal.c r7 = r26.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x09b8 }
            java.util.List r3 = r7.mo19867p(r3)     // Catch:{ all -> 0x09b8 }
            r11 = 0
        L_0x08c2:
            int r7 = r3.size()     // Catch:{ all -> 0x09b8 }
            if (r11 >= r7) goto L_0x08f9
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r7 = com.google.android.gms.internal.measurement.zzcd.zzk.zzj()     // Catch:{ all -> 0x09b8 }
            java.lang.Object r8 = r3.get(r11)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.v7 r8 = (com.google.android.gms.measurement.internal.C3134v7) r8     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = r8.f18417c     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r7 = r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x09b8 }
            java.lang.Object r8 = r3.get(r11)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.v7 r8 = (com.google.android.gms.measurement.internal.C3134v7) r8     // Catch:{ all -> 0x09b8 }
            long r12 = r8.f18418d     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r7 = r7.zza((long) r12)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzks r8 = r26.zzh()     // Catch:{ all -> 0x09b8 }
            java.lang.Object r12 = r3.get(r11)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.v7 r12 = (com.google.android.gms.measurement.internal.C3134v7) r12     // Catch:{ all -> 0x09b8 }
            java.lang.Object r12 = r12.f18419e     // Catch:{ all -> 0x09b8 }
            r8.mo20550q(r7, r12)     // Catch:{ all -> 0x09b8 }
            r2.zza((com.google.android.gms.internal.measurement.zzcd.zzk.zza) r7)     // Catch:{ all -> 0x09b8 }
            int r11 = r11 + 1
            goto L_0x08c2
        L_0x08f9:
            com.google.android.gms.measurement.internal.c r3 = r26.zze()     // Catch:{ IOException -> 0x096c }
            com.google.android.gms.internal.measurement.zzjh r7 = r2.zzz()     // Catch:{ IOException -> 0x096c }
            com.google.android.gms.internal.measurement.zzhz r7 = (com.google.android.gms.internal.measurement.zzhz) r7     // Catch:{ IOException -> 0x096c }
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = (com.google.android.gms.internal.measurement.zzcd.zzg) r7     // Catch:{ IOException -> 0x096c }
            long r2 = r3.mo19853f(r7)     // Catch:{ IOException -> 0x096c }
            com.google.android.gms.measurement.internal.c r7 = r26.zze()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzam r8 = r4.f18503f     // Catch:{ all -> 0x09b8 }
            if (r8 == 0) goto L_0x0962
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x09b8 }
        L_0x0915:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x0929
            java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x09b8 }
            boolean r11 = r5.equals(r11)     // Catch:{ all -> 0x09b8 }
            if (r11 == 0) goto L_0x0915
        L_0x0927:
            r11 = 1
            goto L_0x0963
        L_0x0929:
            com.google.android.gms.measurement.internal.zzfp r5 = r26.zzc()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = r4.f18498a     // Catch:{ all -> 0x09b8 }
            java.lang.String r11 = r4.f18499b     // Catch:{ all -> 0x09b8 }
            boolean r5 = r5.mo20338f(r8, r11)     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.c r11 = r26.zze()     // Catch:{ all -> 0x09b8 }
            long r12 = r26.m10913Z()     // Catch:{ all -> 0x09b8 }
            java.lang.String r14 = r4.f18498a     // Catch:{ all -> 0x09b8 }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            com.google.android.gms.measurement.internal.zzaf r8 = r11.mo19860j(r12, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x09b8 }
            if (r5 == 0) goto L_0x0962
            long r11 = r8.f18497e     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzfv r5 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzy r5 = r5.zza()     // Catch:{ all -> 0x09b8 }
            java.lang.String r8 = r4.f18498a     // Catch:{ all -> 0x09b8 }
            int r5 = r5.zzc(r8)     // Catch:{ all -> 0x09b8 }
            long r13 = (long) r5     // Catch:{ all -> 0x09b8 }
            int r5 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0962
            goto L_0x0927
        L_0x0962:
            r11 = 0
        L_0x0963:
            boolean r2 = r7.mo19876z(r4, r2, r11)     // Catch:{ all -> 0x09b8 }
            if (r2 == 0) goto L_0x0985
            r1.f18704m = r9     // Catch:{ all -> 0x09b8 }
            goto L_0x0985
        L_0x096c:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfv r4 = r1.f18701j     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzq()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zze()     // Catch:{ all -> 0x09b8 }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzj()     // Catch:{ all -> 0x09b8 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r2)     // Catch:{ all -> 0x09b8 }
            r4.zza(r5, r2, r3)     // Catch:{ all -> 0x09b8 }
        L_0x0985:
            com.google.android.gms.measurement.internal.c r2 = r26.zze()     // Catch:{ all -> 0x09b8 }
            r2.mo19845b()     // Catch:{ all -> 0x09b8 }
            com.google.android.gms.measurement.internal.c r2 = r26.zze()
            r2.mo19850d0()
            r26.m10900B()
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzw()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r23
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x09b8:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.c r3 = r26.zze()
            r3.mo19850d0()
            goto L_0x09c3
        L_0x09c2:
            throw r2
        L_0x09c3:
            goto L_0x09c2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.m10908O(com.google.android.gms.measurement.internal.zzar, com.google.android.gms.measurement.internal.zzn):void");
    }

    /* renamed from: Q */
    private final boolean m10909Q(zzn zzn) {
        return (!zznt.zzb() || !this.f18701j.zza().zze(zzn.zza, zzat.zzbi)) ? !TextUtils.isEmpty(zzn.zzb) || !TextUtils.isEmpty(zzn.zzr) : !TextUtils.isEmpty(zzn.zzb) || !TextUtils.isEmpty(zzn.zzv) || !TextUtils.isEmpty(zzn.zzr);
    }

    /* renamed from: W */
    private final C3031k3 m10910W() {
        C3031k3 k3Var = this.f18695d;
        if (k3Var != null) {
            return k3Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    /* renamed from: X */
    private final zzke m10911X() {
        m10907I(this.f18696e);
        return this.f18696e;
    }

    @WorkerThread
    /* renamed from: Y */
    private final void m10912Y() {
        this.f18701j.zzp().zzc();
    }

    /* renamed from: Z */
    private final long m10913Z() {
        long currentTimeMillis = this.f18701j.zzl().currentTimeMillis();
        C3049m3 zzb = this.f18701j.zzb();
        zzb.zzaa();
        zzb.zzc();
        long zza = zzb.f18232h.zza();
        if (zza == 0) {
            zza = 1 + ((long) zzb.zzo().mo20564V().nextInt(86400000));
            zzb.f18232h.zza(zza);
        }
        return ((((currentTimeMillis + zza) / 1000) / 60) / 60) / 24;
    }

    @WorkerThread
    @VisibleForTesting
    /* renamed from: a */
    private final int m10914a(FileChannel fileChannel) {
        m10912Y();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f18701j.zzq().zze().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.f18701j.zzq().zzh().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.f18701j.zzq().zze().zza("Failed to read from channel", e);
            return 0;
        }
    }

    @WorkerThread
    @Deprecated
    /* renamed from: a0 */
    private final String m10915a0() {
        byte[] bArr = new byte[16];
        this.f18701j.zzh().mo20564V().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f1  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.C3013i3 m10916c(com.google.android.gms.measurement.internal.zzn r9, com.google.android.gms.measurement.internal.C3013i3 r10, java.lang.String r11) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzad r0 = com.google.android.gms.measurement.internal.zzad.zza
            boolean r1 = com.google.android.gms.internal.measurement.zzmj.zzb()
            if (r1 == 0) goto L_0x0026
            com.google.android.gms.measurement.internal.zzfv r1 = r8.f18701j
            com.google.android.gms.measurement.internal.zzy r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzci
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r2)
            if (r1 == 0) goto L_0x0026
            java.lang.String r0 = r9.zza
            com.google.android.gms.measurement.internal.zzad r0 = r8.mo20513b(r0)
            java.lang.String r1 = r9.zzw
            com.google.android.gms.measurement.internal.zzad r1 = com.google.android.gms.measurement.internal.zzad.zza((java.lang.String) r1)
            com.google.android.gms.measurement.internal.zzad r0 = r0.zzb((com.google.android.gms.measurement.internal.zzad) r1)
        L_0x0026:
            r1 = 1
            if (r10 != 0) goto L_0x0069
            com.google.android.gms.measurement.internal.i3 r10 = new com.google.android.gms.measurement.internal.i3
            com.google.android.gms.measurement.internal.zzfv r2 = r8.f18701j
            java.lang.String r3 = r9.zza
            r10.<init>(r2, r3)
            boolean r2 = com.google.android.gms.internal.measurement.zzmj.zzb()
            if (r2 == 0) goto L_0x005d
            com.google.android.gms.measurement.internal.zzfv r2 = r8.f18701j
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzci
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x005d
            boolean r2 = r0.zze()
            if (r2 == 0) goto L_0x0053
            java.lang.String r2 = r8.m10918e(r0)
            r10.mo19967c(r2)
        L_0x0053:
            boolean r0 = r0.zzc()
            if (r0 == 0) goto L_0x0067
            r10.mo19939C(r11)
            goto L_0x0067
        L_0x005d:
            java.lang.String r0 = r8.m10915a0()
            r10.mo19967c(r0)
            r10.mo19939C(r11)
        L_0x0067:
            r11 = 1
            goto L_0x00bb
        L_0x0069:
            boolean r2 = com.google.android.gms.internal.measurement.zzmj.zzb()
            if (r2 == 0) goto L_0x0083
            com.google.android.gms.measurement.internal.zzfv r2 = r8.f18701j
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzci
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x0083
            boolean r2 = r0.zzc()
            if (r2 == 0) goto L_0x00ba
        L_0x0083:
            java.lang.String r2 = r10.mo19946J()
            boolean r2 = r11.equals(r2)
            if (r2 != 0) goto L_0x00ba
            r10.mo19939C(r11)
            boolean r11 = com.google.android.gms.internal.measurement.zzmj.zzb()
            if (r11 == 0) goto L_0x00b2
            com.google.android.gms.measurement.internal.zzfv r11 = r8.f18701j
            com.google.android.gms.measurement.internal.zzy r11 = r11.zza()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzci
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r2)
            if (r11 == 0) goto L_0x00b2
            boolean r11 = r0.zze()
            if (r11 == 0) goto L_0x0067
            java.lang.String r11 = r8.m10918e(r0)
            r10.mo19967c(r11)
            goto L_0x0067
        L_0x00b2:
            java.lang.String r11 = r8.m10915a0()
            r10.mo19967c(r11)
            goto L_0x0067
        L_0x00ba:
            r11 = 0
        L_0x00bb:
            java.lang.String r0 = r9.zzb
            java.lang.String r2 = r10.mo19937A()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x00cd
            java.lang.String r11 = r9.zzb
            r10.mo19993r(r11)
            r11 = 1
        L_0x00cd:
            java.lang.String r0 = r9.zzr
            java.lang.String r2 = r10.mo19940D()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x00df
            java.lang.String r11 = r9.zzr
            r10.mo19997v(r11)
            r11 = 1
        L_0x00df:
            boolean r0 = com.google.android.gms.internal.measurement.zznt.zzb()
            if (r0 == 0) goto L_0x0109
            com.google.android.gms.measurement.internal.zzfv r0 = r8.f18701j
            com.google.android.gms.measurement.internal.zzy r0 = r0.zza()
            java.lang.String r2 = r10.mo19995t()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbi
            boolean r0 = r0.zze(r2, r3)
            if (r0 == 0) goto L_0x0109
            java.lang.String r0 = r9.zzv
            java.lang.String r2 = r10.mo19943G()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x0109
            java.lang.String r11 = r9.zzv
            r10.mo20001z(r11)
            r11 = 1
        L_0x0109:
            java.lang.String r0 = r9.zzk
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0123
            java.lang.String r0 = r9.zzk
            java.lang.String r2 = r10.mo19949M()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0123
            java.lang.String r11 = r9.zzk
            r10.mo19942F(r11)
            r11 = 1
        L_0x0123:
            long r2 = r9.zze
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0139
            long r6 = r10.mo19962Z()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0139
            long r2 = r9.zze
            r10.mo20000y(r2)
            r11 = 1
        L_0x0139:
            java.lang.String r0 = r9.zzc
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0153
            java.lang.String r0 = r9.zzc
            java.lang.String r2 = r10.mo19956T()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0153
            java.lang.String r11 = r9.zzc
            r10.mo19945I(r11)
            r11 = 1
        L_0x0153:
            long r2 = r9.zzj
            long r6 = r10.mo19958V()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0163
            long r2 = r9.zzj
            r10.mo19996u(r2)
            r11 = 1
        L_0x0163:
            java.lang.String r0 = r9.zzd
            if (r0 == 0) goto L_0x0177
            java.lang.String r2 = r10.mo19960X()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0177
            java.lang.String r11 = r9.zzd
            r10.mo19948L(r11)
            r11 = 1
        L_0x0177:
            long r2 = r9.zzf
            long r6 = r10.mo19966b0()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0187
            long r2 = r9.zzf
            r10.mo19938B(r2)
            r11 = 1
        L_0x0187:
            boolean r0 = r9.zzh
            boolean r2 = r10.mo19972e0()
            if (r0 == r2) goto L_0x0195
            boolean r11 = r9.zzh
            r10.mo19971e(r11)
            r11 = 1
        L_0x0195:
            java.lang.String r0 = r9.zzg
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = r9.zzg
            java.lang.String r2 = r10.mo19979i()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01af
            java.lang.String r11 = r9.zzg
            r10.mo19951O(r11)
            r11 = 1
        L_0x01af:
            com.google.android.gms.measurement.internal.zzfv r0 = r8.f18701j
            com.google.android.gms.measurement.internal.zzy r0 = r0.zza()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzbx
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r2)
            if (r0 != 0) goto L_0x01cd
            long r2 = r9.zzl
            long r6 = r10.mo19983k()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x01cd
            long r2 = r9.zzl
            r10.mo19968c0(r2)
            r11 = 1
        L_0x01cd:
            boolean r0 = r9.zzo
            boolean r2 = r10.mo19985l()
            if (r0 == r2) goto L_0x01db
            boolean r11 = r9.zzo
            r10.mo19994s(r11)
            r11 = 1
        L_0x01db:
            boolean r0 = r9.zzp
            boolean r2 = r10.mo19987m()
            if (r0 == r2) goto L_0x01e9
            boolean r11 = r9.zzp
            r10.mo19998w(r11)
            r11 = 1
        L_0x01e9:
            java.lang.Boolean r0 = r9.zzs
            java.lang.Boolean r2 = r10.mo19989n()
            if (r0 == r2) goto L_0x01f7
            java.lang.Boolean r11 = r9.zzs
            r10.mo19965b(r11)
            r11 = 1
        L_0x01f7:
            long r2 = r9.zzt
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x020b
            long r4 = r10.mo19970d0()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x020b
            long r2 = r9.zzt
            r10.mo19941E(r2)
            goto L_0x020c
        L_0x020b:
            r1 = r11
        L_0x020c:
            if (r1 == 0) goto L_0x0215
            com.google.android.gms.measurement.internal.c r9 = r8.zze()
            r9.mo19872v(r10)
        L_0x0215:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.m10916c(com.google.android.gms.measurement.internal.zzn, com.google.android.gms.measurement.internal.i3, java.lang.String):com.google.android.gms.measurement.internal.i3");
    }

    @WorkerThread
    /* renamed from: e */
    private final String m10918e(zzad zzad) {
        if (!zzmj.zzb() || !this.f18701j.zza().zza(zzat.zzci) || zzad.zze()) {
            return m10915a0();
        }
        return null;
    }

    @VisibleForTesting
    /* renamed from: g */
    private static void m10919g(zzcd.zzc.zza zza, int i, String str) {
        List<zzcd.zze> zza2 = zza.zza();
        int i2 = 0;
        while (i2 < zza2.size()) {
            if (!"_err".equals(zza2.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zza.zza((zzcd.zze) ((zzhz) zzcd.zze.zzm().zza("_err").zza(Long.valueOf((long) i).longValue()).zzz())).zza((zzcd.zze) ((zzhz) zzcd.zze.zzm().zza("_ev").zzb(str).zzz()));
    }

    @VisibleForTesting
    /* renamed from: h */
    private static void m10920h(zzcd.zzc.zza zza, @NonNull String str) {
        List<zzcd.zze> zza2 = zza.zza();
        for (int i = 0; i < zza2.size(); i++) {
            if (str.equals(zza2.get(i).zzb())) {
                zza.zzb(i);
                return;
            }
        }
    }

    @VisibleForTesting
    /* renamed from: i */
    private final void m10921i(zzcd.zzg.zza zza, long j, boolean z) {
        C3134v7 v7Var;
        String str = z ? "_se" : "_lte";
        C3134v7 U = zze().mo19838U(zza.zzj(), str);
        if (U == null || U.f18419e == null) {
            v7Var = new C3134v7(zza.zzj(), "auto", str, this.f18701j.zzl().currentTimeMillis(), Long.valueOf(j));
        } else {
            v7Var = new C3134v7(zza.zzj(), "auto", str, this.f18701j.zzl().currentTimeMillis(), Long.valueOf(((Long) U.f18419e).longValue() + j));
        }
        zzcd.zzk zzk = (zzcd.zzk) ((zzhz) zzcd.zzk.zzj().zza(str).zza(this.f18701j.zzl().currentTimeMillis()).zzb(((Long) v7Var.f18419e).longValue()).zzz());
        boolean z2 = false;
        int b = zzks.m10957b(zza, str);
        if (b >= 0) {
            zza.zza(b, zzk);
            z2 = true;
        }
        if (!z2) {
            zza.zza(zzk);
        }
        if (j > 0) {
            zze().mo19831A(v7Var);
            this.f18701j.zzq().zzw().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", v7Var.f18419e);
        }
    }

    @WorkerThread
    /* renamed from: l */
    private final void m10922l(C3013i3 i3Var) {
        ArrayMap arrayMap;
        m10912Y();
        if (!zznt.zzb() || !this.f18701j.zza().zze(i3Var.mo19995t(), zzat.zzbi)) {
            if (TextUtils.isEmpty(i3Var.mo19937A()) && TextUtils.isEmpty(i3Var.mo19940D())) {
                mo20523u(i3Var.mo19995t(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(i3Var.mo19937A()) && TextUtils.isEmpty(i3Var.mo19943G()) && TextUtils.isEmpty(i3Var.mo19940D())) {
            mo20523u(i3Var.mo19995t(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String zza = this.f18701j.zza().zza(i3Var);
        try {
            URL url = new URL(zza);
            this.f18701j.zzq().zzw().zza("Fetching remote configuration", i3Var.mo19995t());
            zzca.zzb zza2 = zzc().zza(i3Var.mo19995t());
            String zzb = zzc().zzb(i3Var.mo19995t());
            if (zza2 == null || TextUtils.isEmpty(zzb)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzb);
                arrayMap = arrayMap2;
            }
            this.f18708q = true;
            zzeu zzd = zzd();
            String t = i3Var.mo19995t();
            C3107s7 s7Var = new C3107s7(this);
            zzd.zzc();
            zzd.zzaj();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(s7Var);
            zzd.zzp().zzc(new C2994g3(zzd, t, url, (byte[]) null, arrayMap, s7Var));
        } catch (MalformedURLException unused) {
            this.f18701j.zzq().zze().zza("Failed to parse config URL. Not fetching. appId", zzer.zza(i3Var.mo19995t()), zza);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: o */
    public final void m10924o(zzkq zzkq) {
        this.f18701j.zzp().zzc();
        C2950c cVar = new C2950c(this);
        cVar.zzak();
        this.f18694c = cVar;
        this.f18701j.zza().mo20600b(this.f18692a);
        zzjo zzjo = new zzjo(this);
        zzjo.zzak();
        this.f18700i = zzjo;
        C2939a8 a8Var = new C2939a8(this);
        a8Var.zzak();
        this.f18697f = a8Var;
        C3105s5 s5Var = new C3105s5(this);
        s5Var.zzak();
        this.f18699h = s5Var;
        zzke zzke = new zzke(this);
        zzke.zzak();
        this.f18696e = zzke;
        this.f18695d = new C3031k3(this);
        if (this.f18706o != this.f18707p) {
            this.f18701j.zzq().zze().zza("Not all upload components initialized", Integer.valueOf(this.f18706o), Integer.valueOf(this.f18707p));
        }
        this.f18702k = true;
    }

    @WorkerThread
    @VisibleForTesting
    /* renamed from: x */
    private final boolean m10925x(int i, FileChannel fileChannel) {
        m10912Y();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f18701j.zzq().zze().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            if (this.f18701j.zza().zza(zzat.zzbr) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.f18701j.zzq().zze().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.f18701j.zzq().zze().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* renamed from: y */
    private final boolean m10926y(zzcd.zzc.zza zza, zzcd.zzc.zza zza2) {
        String str;
        Preconditions.checkArgument("_e".equals(zza.zzd()));
        zzh();
        zzcd.zze f = zzks.m10958f((zzcd.zzc) ((zzhz) zza.zzz()), "_sc");
        String str2 = null;
        if (f == null) {
            str = null;
        } else {
            str = f.zzd();
        }
        zzh();
        zzcd.zze f2 = zzks.m10958f((zzcd.zzc) ((zzhz) zza2.zzz()), "_pc");
        if (f2 != null) {
            str2 = f2.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        m10905G(zza, zza2);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0252, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0259, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x025a, code lost:
        r5 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x025c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x025d, code lost:
        r25 = "";
        r4 = r6;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0263, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0264, code lost:
        r5 = r1;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a5, code lost:
        r6 = r0;
        r25 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:616:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0259 A[ExcHandler: all (th java.lang.Throwable), PHI: r6 
      PHI: (r6v128 android.database.Cursor) = (r6v131 android.database.Cursor), (r6v131 android.database.Cursor), (r6v131 android.database.Cursor), (r6v168 android.database.Cursor), (r6v168 android.database.Cursor), (r6v168 android.database.Cursor), (r6v176 android.database.Cursor), (r6v176 android.database.Cursor), (r6v176 android.database.Cursor), (r6v176 android.database.Cursor) binds: [B:53:0x00f2, B:54:?, B:56:0x00fd, B:42:0x00d9, B:49:0x00e8, B:50:?, B:17:0x007b, B:23:0x0087, B:25:0x008b, B:26:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:17:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0263 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0282 A[SYNTHETIC, Splitter:B:132:0x0282] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0289 A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0295 A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x046c A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x046e A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0471 A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0472 A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0491 A[SYNTHETIC, Splitter:B:220:0x0491] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x052f A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0591 A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0595 A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x05fb A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x062b A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x064a A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x073e A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x08cc A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x08e4 A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x08fe A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:492:0x0c83 A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:493:0x0c96 A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x0c99 A[Catch:{ IOException -> 0x0233, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:496:0x0cc0 A[SYNTHETIC, Splitter:B:496:0x0cc0] */
    /* JADX WARNING: Removed duplicated region for block: B:607:0x100b  */
    /* JADX WARNING: Removed duplicated region for block: B:615:0x1022 A[SYNTHETIC, Splitter:B:615:0x1022] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011c A[Catch:{ SQLiteException -> 0x0250, all -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:633:0x04f4 A[EDGE_INSN: B:633:0x04f4->B:229:0x04f4 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0134 A[SYNTHETIC, Splitter:B:65:0x0134] */
    @androidx.annotation.WorkerThread
    /* renamed from: z */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m10927z(java.lang.String r44, long r45) {
        /*
            r43 = this;
            r1 = r43
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            java.lang.String r4 = ""
            com.google.android.gms.measurement.internal.c r5 = r43.zze()
            r5.zze()
            com.google.android.gms.measurement.internal.zzki$a r5 = new com.google.android.gms.measurement.internal.zzki$a     // Catch:{ all -> 0x1028 }
            r6 = 0
            r5.<init>(r1, r6)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.c r7 = r43.zze()     // Catch:{ all -> 0x1028 }
            long r8 = r1.f18715x     // Catch:{ all -> 0x1028 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x1028 }
            r7.zzc()     // Catch:{ all -> 0x1028 }
            r7.zzaj()     // Catch:{ all -> 0x1028 }
            r11 = -1
            r13 = 2
            r14 = 0
            r15 = 1
            android.database.sqlite.SQLiteDatabase r10 = r7.mo19847c()     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            boolean r16 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            if (r16 == 0) goto L_0x0093
            int r16 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r16 == 0) goto L_0x0046
            java.lang.String[] r6 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            java.lang.String r16 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            r6[r14] = r16     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            java.lang.String r16 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            r6[r15] = r16     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            goto L_0x004e
        L_0x0046:
            java.lang.String[] r6 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            java.lang.String r16 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            r6[r14] = r16     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
        L_0x004e:
            int r16 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r16 == 0) goto L_0x0057
            java.lang.String r16 = "rowid <= ? and "
            r45 = r16
            goto L_0x0059
        L_0x0057:
            r45 = r4
        L_0x0059:
            int r13 = r45.length()     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            int r13 = r13 + 148
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            r11.<init>(r13)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            java.lang.String r12 = "select app_id, metadata_fingerprint from raw_events where "
            r11.append(r12)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            r12 = r45
            r11.append(r12)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            java.lang.String r12 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r11.append(r12)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            java.lang.String r11 = r11.toString()     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            android.database.Cursor r6 = r10.rawQuery(r11, r6)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            boolean r11 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x025c, all -> 0x0259 }
            if (r11 != 0) goto L_0x0087
            if (r6 == 0) goto L_0x00e4
            r6.close()     // Catch:{ all -> 0x1028 }
            goto L_0x00e4
        L_0x0087:
            java.lang.String r11 = r6.getString(r14)     // Catch:{ SQLiteException -> 0x025c, all -> 0x0259 }
            java.lang.String r12 = r6.getString(r15)     // Catch:{ SQLiteException -> 0x0254, all -> 0x0259 }
            r6.close()     // Catch:{ SQLiteException -> 0x0254, all -> 0x0259 }
            goto L_0x00f0
        L_0x0093:
            int r6 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r6 == 0) goto L_0x00aa
            r6 = 2
            java.lang.String[] r11 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            r6 = 0
            r11[r14] = r6     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            r11[r15] = r6     // Catch:{ SQLiteException -> 0x00a4, all -> 0x0263 }
            goto L_0x00af
        L_0x00a4:
            r0 = move-exception
            r6 = r0
            r25 = r4
            goto L_0x026d
        L_0x00aa:
            java.lang.String[] r11 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r6 = 0
            r11[r14] = r6     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
        L_0x00af:
            r12 = -1
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x00b8
            java.lang.String r6 = " and rowid <= ?"
            goto L_0x00b9
        L_0x00b8:
            r6 = r4
        L_0x00b9:
            int r12 = r6.length()     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            int r12 = r12 + 84
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r13.<init>(r12)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r12 = "select metadata_fingerprint from raw_events where app_id = ?"
            r13.append(r12)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r13.append(r6)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r6 = " order by rowid limit 1;"
            r13.append(r6)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r6 = r13.toString()     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            android.database.Cursor r6 = r10.rawQuery(r6, r11)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            boolean r11 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x025c, all -> 0x0259 }
            if (r11 != 0) goto L_0x00e8
            if (r6 == 0) goto L_0x00e4
            r6.close()     // Catch:{ all -> 0x1028 }
        L_0x00e4:
            r25 = r4
            goto L_0x0285
        L_0x00e8:
            java.lang.String r12 = r6.getString(r14)     // Catch:{ SQLiteException -> 0x025c, all -> 0x0259 }
            r6.close()     // Catch:{ SQLiteException -> 0x025c, all -> 0x0259 }
            r11 = 0
        L_0x00f0:
            java.lang.String r17 = "raw_events_metadata"
            java.lang.String[] r13 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0254, all -> 0x0259 }
            java.lang.String r16 = "metadata"
            r13[r14] = r16     // Catch:{ SQLiteException -> 0x0254, all -> 0x0259 }
            java.lang.String r19 = "app_id = ? and metadata_fingerprint = ?"
            r25 = r4
            r15 = 2
            java.lang.String[] r4 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0252, all -> 0x0259 }
            r4[r14] = r11     // Catch:{ SQLiteException -> 0x0252, all -> 0x0259 }
            r15 = 1
            r4[r15] = r12     // Catch:{ SQLiteException -> 0x0252, all -> 0x0259 }
            r21 = 0
            r22 = 0
            java.lang.String r23 = "rowid"
            java.lang.String r24 = "2"
            r16 = r10
            r18 = r13
            r20 = r4
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x0252, all -> 0x0259 }
            boolean r6 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            if (r6 != 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzer r6 = r7.zzq()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.measurement.internal.zzet r6 = r6.zze()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            java.lang.String r8 = "Raw event metadata record is missing. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r6.zza(r8, r9)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            if (r4 == 0) goto L_0x0285
            r4.close()     // Catch:{ all -> 0x1028 }
            goto L_0x0285
        L_0x0134:
            byte[] r6 = r4.getBlob(r14)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r13 = com.google.android.gms.internal.measurement.zzcd.zzg.zzbh()     // Catch:{ IOException -> 0x0233 }
            com.google.android.gms.internal.measurement.zzjk r6 = com.google.android.gms.measurement.internal.zzks.m10959g(r13, r6)     // Catch:{ IOException -> 0x0233 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r6 = (com.google.android.gms.internal.measurement.zzcd.zzg.zza) r6     // Catch:{ IOException -> 0x0233 }
            com.google.android.gms.internal.measurement.zzjh r6 = r6.zzz()     // Catch:{ IOException -> 0x0233 }
            com.google.android.gms.internal.measurement.zzhz r6 = (com.google.android.gms.internal.measurement.zzhz) r6     // Catch:{ IOException -> 0x0233 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = (com.google.android.gms.internal.measurement.zzcd.zzg) r6     // Catch:{ IOException -> 0x0233 }
            boolean r13 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            if (r13 == 0) goto L_0x0161
            com.google.android.gms.measurement.internal.zzer r13 = r7.zzq()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzh()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            java.lang.String r15 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r13.zza(r15, r14)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
        L_0x0161:
            r4.close()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r5.mo19886b(r6)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r13 = -1
            int r6 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x0184
            java.lang.String r6 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r13 = 0
            r14[r13] = r11     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r13 = 1
            r14[r13] = r12     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r9 = 2
            r14[r9] = r8     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r19 = r6
            r20 = r14
            goto L_0x0193
        L_0x0184:
            java.lang.String r6 = "app_id = ? and metadata_fingerprint = ?"
            r8 = 2
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r8 = 0
            r9[r8] = r11     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r8 = 1
            r9[r8] = r12     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r19 = r6
            r20 = r9
        L_0x0193:
            java.lang.String r17 = "raw_events"
            r6 = 4
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            java.lang.String r8 = "rowid"
            r9 = 0
            r6[r9] = r8     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            java.lang.String r8 = "name"
            r9 = 1
            r6[r9] = r8     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            java.lang.String r8 = "timestamp"
            r9 = 2
            r6[r9] = r8     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            java.lang.String r8 = "data"
            r9 = 3
            r6[r9] = r8     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r21 = 0
            r22 = 0
            java.lang.String r23 = "rowid"
            r24 = 0
            r16 = r10
            r18 = r6
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            boolean r6 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            if (r6 != 0) goto L_0x01da
            com.google.android.gms.measurement.internal.zzer r6 = r7.zzq()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzh()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            java.lang.String r8 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r6.zza(r8, r9)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            if (r4 == 0) goto L_0x0285
            r4.close()     // Catch:{ all -> 0x1028 }
            goto L_0x0285
        L_0x01da:
            r6 = 0
            long r8 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r6 = 3
            byte[] r10 = r4.getBlob(r6)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r6 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch:{ IOException -> 0x0214 }
            com.google.android.gms.internal.measurement.zzjk r6 = com.google.android.gms.measurement.internal.zzks.m10959g(r6, r10)     // Catch:{ IOException -> 0x0214 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r6 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r6     // Catch:{ IOException -> 0x0214 }
            r10 = 1
            java.lang.String r12 = r4.getString(r10)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r10 = r6.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r12 = 2
            long r13 = r4.getLong(r12)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r10.zza((long) r13)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.internal.measurement.zzjh r6 = r6.zzz()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.internal.measurement.zzhz r6 = (com.google.android.gms.internal.measurement.zzhz) r6     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.internal.measurement.zzcd$zzc r6 = (com.google.android.gms.internal.measurement.zzcd.zzc) r6     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            boolean r6 = r5.mo19885a(r8, r6)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            if (r6 != 0) goto L_0x0227
            if (r4 == 0) goto L_0x0285
            r4.close()     // Catch:{ all -> 0x1028 }
            goto L_0x0285
        L_0x0214:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzer r8 = r7.zzq()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zze()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            java.lang.String r9 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r8.zza(r9, r10, r6)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
        L_0x0227:
            boolean r6 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            if (r6 != 0) goto L_0x01da
            if (r4 == 0) goto L_0x0285
            r4.close()     // Catch:{ all -> 0x1028 }
            goto L_0x0285
        L_0x0233:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzer r8 = r7.zzq()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zze()     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            java.lang.String r9 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            r8.zza(r9, r10, r6)     // Catch:{ SQLiteException -> 0x0250, all -> 0x024c }
            if (r4 == 0) goto L_0x0285
            r4.close()     // Catch:{ all -> 0x1028 }
            goto L_0x0285
        L_0x024c:
            r0 = move-exception
            r5 = r1
            r6 = r4
            goto L_0x0266
        L_0x0250:
            r0 = move-exception
            goto L_0x0261
        L_0x0252:
            r0 = move-exception
            goto L_0x0257
        L_0x0254:
            r0 = move-exception
            r25 = r4
        L_0x0257:
            r4 = r6
            goto L_0x0261
        L_0x0259:
            r0 = move-exception
            r5 = r1
            goto L_0x0266
        L_0x025c:
            r0 = move-exception
            r25 = r4
            r4 = r6
            r11 = 0
        L_0x0261:
            r6 = r0
            goto L_0x026f
        L_0x0263:
            r0 = move-exception
            r5 = r1
            r6 = 0
        L_0x0266:
            r1 = r0
            goto L_0x1020
        L_0x0269:
            r0 = move-exception
            r25 = r4
            r6 = r0
        L_0x026d:
            r4 = 0
            r11 = 0
        L_0x026f:
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzq()     // Catch:{ all -> 0x101c }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zze()     // Catch:{ all -> 0x101c }
            java.lang.String r8 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r11)     // Catch:{ all -> 0x101c }
            r7.zza(r8, r9, r6)     // Catch:{ all -> 0x101c }
            if (r4 == 0) goto L_0x0285
            r4.close()     // Catch:{ all -> 0x1028 }
        L_0x0285:
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r4 = r5.f18720c     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x0292
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x0290
            goto L_0x0292
        L_0x0290:
            r4 = 0
            goto L_0x0293
        L_0x0292:
            r4 = 1
        L_0x0293:
            if (r4 != 0) goto L_0x100b
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = r5.f18718a     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz$zza r4 = r4.zzbn()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r4 = (com.google.android.gms.internal.measurement.zzcd.zzg.zza) r4     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r4 = r4.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfv r6 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zza()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzat.zzat     // Catch:{ all -> 0x1028 }
            boolean r6 = r6.zze(r7, r8)     // Catch:{ all -> 0x1028 }
            r7 = -1
            r8 = -1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x02bc:
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r9 = r5.f18720c     // Catch:{ all -> 0x1028 }
            int r9 = r9.size()     // Catch:{ all -> 0x1028 }
            r18 = r13
            java.lang.String r13 = "_fr"
            r19 = r2
            java.lang.String r2 = "_et"
            r20 = r14
            java.lang.String r14 = "_e"
            r21 = r6
            r22 = r7
            if (r12 >= r9) goto L_0x095b
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r9 = r5.f18720c     // Catch:{ all -> 0x1028 }
            java.lang.Object r9 = r9.get(r12)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz$zza r9 = r9.zzbn()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r9 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfp r6 = r43.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1028 }
            r26 = r12
            java.lang.String r12 = r9.zzd()     // Catch:{ all -> 0x1028 }
            boolean r6 = r6.mo20337e(r7, r12)     // Catch:{ all -> 0x1028 }
            java.lang.String r7 = "_err"
            if (r6 == 0) goto L_0x037b
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r12)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfv r13 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzep r13 = r13.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r14 = r9.zzd()     // Catch:{ all -> 0x1028 }
            java.lang.String r13 = r13.zza((java.lang.String) r14)     // Catch:{ all -> 0x1028 }
            r2.zza(r6, r12, r13)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfp r2 = r43.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.mo20343k(r6)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x0344
            com.google.android.gms.measurement.internal.zzfp r2 = r43.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zzh(r6)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0342
            goto L_0x0344
        L_0x0342:
            r2 = 0
            goto L_0x0345
        L_0x0344:
            r2 = 1
        L_0x0345:
            if (r2 != 0) goto L_0x036e
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = r7.equals(r2)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x036e
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzkw r27 = r2.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.w7 r2 = r1.f18717z     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r29 = r6.zzx()     // Catch:{ all -> 0x1028 }
            r30 = 11
            java.lang.String r31 = "_ev"
            java.lang.String r32 = r9.zzd()     // Catch:{ all -> 0x1028 }
            r33 = 0
            r28 = r2
            r27.mo20575p(r28, r29, r30, r31, r32, r33)     // Catch:{ all -> 0x1028 }
        L_0x036e:
            r27 = r15
            r13 = r18
            r14 = r20
            r6 = r26
            r7 = 3
            r16 = r3
            goto L_0x094d
        L_0x037b:
            boolean r6 = com.google.android.gms.internal.measurement.zzlq.zzb()     // Catch:{ all -> 0x1028 }
            if (r6 == 0) goto L_0x040b
            com.google.android.gms.measurement.internal.zzfv r6 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zza()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1028 }
            r27 = r15
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzat.zzcl     // Catch:{ all -> 0x1028 }
            boolean r6 = r6.zze(r12, r15)     // Catch:{ all -> 0x1028 }
            if (r6 == 0) goto L_0x040d
            java.lang.String r6 = r9.zzd()     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = com.google.android.gms.measurement.internal.zzgs.zza(r3)     // Catch:{ all -> 0x1028 }
            boolean r6 = r6.equals(r12)     // Catch:{ all -> 0x1028 }
            if (r6 == 0) goto L_0x040d
            r9.zza((java.lang.String) r3)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfv r6 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzw()     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = "Renaming ad_impression to _ai"
            r6.zza(r12)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfv r6 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()     // Catch:{ all -> 0x1028 }
            r12 = 5
            boolean r6 = r6.zza((int) r12)     // Catch:{ all -> 0x1028 }
            if (r6 == 0) goto L_0x040d
            r6 = 0
        L_0x03c5:
            int r12 = r9.zzb()     // Catch:{ all -> 0x1028 }
            if (r6 >= r12) goto L_0x040d
            java.lang.String r12 = "ad_platform"
            com.google.android.gms.internal.measurement.zzcd$zze r15 = r9.zza((int) r6)     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r15.zzb()     // Catch:{ all -> 0x1028 }
            boolean r12 = r12.equals(r15)     // Catch:{ all -> 0x1028 }
            if (r12 == 0) goto L_0x0408
            com.google.android.gms.internal.measurement.zzcd$zze r12 = r9.zza((int) r6)     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzd()     // Catch:{ all -> 0x1028 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x1028 }
            if (r12 != 0) goto L_0x0408
            java.lang.String r12 = "admob"
            com.google.android.gms.internal.measurement.zzcd$zze r15 = r9.zza((int) r6)     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r15.zzd()     // Catch:{ all -> 0x1028 }
            boolean r12 = r12.equalsIgnoreCase(r15)     // Catch:{ all -> 0x1028 }
            if (r12 == 0) goto L_0x0408
            com.google.android.gms.measurement.internal.zzfv r12 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzj()     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = "AdMob ad impression logged from app. Potentially duplicative."
            r12.zza(r15)     // Catch:{ all -> 0x1028 }
        L_0x0408:
            int r6 = r6 + 1
            goto L_0x03c5
        L_0x040b:
            r27 = r15
        L_0x040d:
            com.google.android.gms.measurement.internal.zzfp r6 = r43.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x1028 }
            boolean r6 = r6.mo20338f(r12, r15)     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = "_c"
            if (r6 != 0) goto L_0x047e
            r43.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x1028 }
            r16 = r3
            int r3 = r15.hashCode()     // Catch:{ all -> 0x1028 }
            r29 = r10
            r10 = 94660(0x171c4, float:1.32647E-40)
            if (r3 == r10) goto L_0x0459
            r10 = 95025(0x17331, float:1.33158E-40)
            if (r3 == r10) goto L_0x044f
            r10 = 95027(0x17333, float:1.33161E-40)
            if (r3 == r10) goto L_0x0445
            goto L_0x0463
        L_0x0445:
            java.lang.String r3 = "_ui"
            boolean r3 = r15.equals(r3)     // Catch:{ all -> 0x1028 }
            if (r3 == 0) goto L_0x0463
            r3 = 1
            goto L_0x0464
        L_0x044f:
            java.lang.String r3 = "_ug"
            boolean r3 = r15.equals(r3)     // Catch:{ all -> 0x1028 }
            if (r3 == 0) goto L_0x0463
            r3 = 2
            goto L_0x0464
        L_0x0459:
            java.lang.String r3 = "_in"
            boolean r3 = r15.equals(r3)     // Catch:{ all -> 0x1028 }
            if (r3 == 0) goto L_0x0463
            r3 = 0
            goto L_0x0464
        L_0x0463:
            r3 = -1
        L_0x0464:
            if (r3 == 0) goto L_0x046e
            r10 = 1
            if (r3 == r10) goto L_0x046e
            r10 = 2
            if (r3 == r10) goto L_0x046e
            r3 = 0
            goto L_0x046f
        L_0x046e:
            r3 = 1
        L_0x046f:
            if (r3 == 0) goto L_0x0472
            goto L_0x0482
        L_0x0472:
            r30 = r2
            r31 = r4
            r32 = r11
            r10 = r13
            r11 = r14
        L_0x047a:
            r13 = r18
            goto L_0x0665
        L_0x047e:
            r16 = r3
            r29 = r10
        L_0x0482:
            r30 = r2
            r3 = 0
            r10 = 0
            r15 = 0
        L_0x0487:
            int r2 = r9.zzb()     // Catch:{ all -> 0x1028 }
            r31 = r4
            java.lang.String r4 = "_r"
            if (r15 >= r2) goto L_0x04f4
            com.google.android.gms.internal.measurement.zzcd$zze r2 = r9.zza((int) r15)     // Catch:{ all -> 0x1028 }
            java.lang.String r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            boolean r2 = r12.equals(r2)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x04be
            com.google.android.gms.internal.measurement.zzcd$zze r2 = r9.zza((int) r15)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz$zza r2 = r2.zzbn()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r2     // Catch:{ all -> 0x1028 }
            r3 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((long) r3)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r2 = r2.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r2 = (com.google.android.gms.internal.measurement.zzhz) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r2 = (com.google.android.gms.internal.measurement.zzcd.zze) r2     // Catch:{ all -> 0x1028 }
            r9.zza((int) r15, (com.google.android.gms.internal.measurement.zzcd.zze) r2)     // Catch:{ all -> 0x1028 }
            r32 = r11
            r3 = 1
            goto L_0x04ed
        L_0x04be:
            com.google.android.gms.internal.measurement.zzcd$zze r2 = r9.zza((int) r15)     // Catch:{ all -> 0x1028 }
            java.lang.String r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x04eb
            com.google.android.gms.internal.measurement.zzcd$zze r2 = r9.zza((int) r15)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz$zza r2 = r2.zzbn()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r2     // Catch:{ all -> 0x1028 }
            r32 = r11
            r10 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((long) r10)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r2 = r2.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r2 = (com.google.android.gms.internal.measurement.zzhz) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r2 = (com.google.android.gms.internal.measurement.zzcd.zze) r2     // Catch:{ all -> 0x1028 }
            r9.zza((int) r15, (com.google.android.gms.internal.measurement.zzcd.zze) r2)     // Catch:{ all -> 0x1028 }
            r10 = 1
            goto L_0x04ed
        L_0x04eb:
            r32 = r11
        L_0x04ed:
            int r15 = r15 + 1
            r4 = r31
            r11 = r32
            goto L_0x0487
        L_0x04f4:
            r32 = r11
            if (r3 != 0) goto L_0x052b
            if (r6 == 0) goto L_0x052b
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzw()     // Catch:{ all -> 0x1028 }
            java.lang.String r3 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzep r11 = r11.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = r11.zza((java.lang.String) r15)     // Catch:{ all -> 0x1028 }
            r2.zza(r3, r11)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = com.google.android.gms.internal.measurement.zzcd.zze.zzm()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((java.lang.String) r12)     // Catch:{ all -> 0x1028 }
            r3 = r13
            r11 = r14
            r13 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((long) r13)     // Catch:{ all -> 0x1028 }
            r9.zza((com.google.android.gms.internal.measurement.zzcd.zze.zza) r2)     // Catch:{ all -> 0x1028 }
            goto L_0x052d
        L_0x052b:
            r3 = r13
            r11 = r14
        L_0x052d:
            if (r10 != 0) goto L_0x055d
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzw()     // Catch:{ all -> 0x1028 }
            java.lang.String r10 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfv r13 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzep r13 = r13.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r14 = r9.zzd()     // Catch:{ all -> 0x1028 }
            java.lang.String r13 = r13.zza((java.lang.String) r14)     // Catch:{ all -> 0x1028 }
            r2.zza(r10, r13)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = com.google.android.gms.internal.measurement.zzcd.zze.zzm()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((java.lang.String) r4)     // Catch:{ all -> 0x1028 }
            r13 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((long) r13)     // Catch:{ all -> 0x1028 }
            r9.zza((com.google.android.gms.internal.measurement.zzcd.zze.zza) r2)     // Catch:{ all -> 0x1028 }
        L_0x055d:
            com.google.android.gms.measurement.internal.c r33 = r43.zze()     // Catch:{ all -> 0x1028 }
            long r34 = r43.m10913Z()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r2 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r36 = r2.zzx()     // Catch:{ all -> 0x1028 }
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 1
            com.google.android.gms.measurement.internal.zzaf r2 = r33.mo19860j(r34, r36, r37, r38, r39, r40, r41)     // Catch:{ all -> 0x1028 }
            long r13 = r2.f18497e     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x1028 }
            int r2 = r2.zzc(r10)     // Catch:{ all -> 0x1028 }
            r10 = r3
            long r2 = (long) r2     // Catch:{ all -> 0x1028 }
            int r15 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r15 <= 0) goto L_0x0595
            m10920h(r9, r4)     // Catch:{ all -> 0x1028 }
            goto L_0x0597
        L_0x0595:
            r18 = 1
        L_0x0597:
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = com.google.android.gms.measurement.internal.zzkw.m11010w(r2)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x047a
            if (r6 == 0) goto L_0x047a
            com.google.android.gms.measurement.internal.c r33 = r43.zze()     // Catch:{ all -> 0x1028 }
            long r34 = r43.m10913Z()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r2 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r36 = r2.zzx()     // Catch:{ all -> 0x1028 }
            r37 = 0
            r38 = 0
            r39 = 1
            r40 = 0
            r41 = 0
            com.google.android.gms.measurement.internal.zzaf r2 = r33.mo19860j(r34, r36, r37, r38, r39, r40, r41)     // Catch:{ all -> 0x1028 }
            long r2 = r2.f18495c     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfv r4 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzy r4 = r4.zza()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r13 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r13 = r13.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzat.zzm     // Catch:{ all -> 0x1028 }
            int r4 = r4.zzb(r13, r14)     // Catch:{ all -> 0x1028 }
            long r13 = (long) r4     // Catch:{ all -> 0x1028 }
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x047a
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r4)     // Catch:{ all -> 0x1028 }
            r2.zza(r3, r4)     // Catch:{ all -> 0x1028 }
            r2 = -1
            r3 = 0
            r4 = 0
            r13 = 0
        L_0x05f5:
            int r14 = r9.zzb()     // Catch:{ all -> 0x1028 }
            if (r13 >= r14) goto L_0x0620
            com.google.android.gms.internal.measurement.zzcd$zze r14 = r9.zza((int) r13)     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r14.zzb()     // Catch:{ all -> 0x1028 }
            boolean r15 = r12.equals(r15)     // Catch:{ all -> 0x1028 }
            if (r15 == 0) goto L_0x0612
            com.google.android.gms.internal.measurement.zzhz$zza r2 = r14.zzbn()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r2     // Catch:{ all -> 0x1028 }
            r3 = r2
            r2 = r13
            goto L_0x061d
        L_0x0612:
            java.lang.String r14 = r14.zzb()     // Catch:{ all -> 0x1028 }
            boolean r14 = r7.equals(r14)     // Catch:{ all -> 0x1028 }
            if (r14 == 0) goto L_0x061d
            r4 = 1
        L_0x061d:
            int r13 = r13 + 1
            goto L_0x05f5
        L_0x0620:
            if (r4 == 0) goto L_0x0629
            if (r3 == 0) goto L_0x0629
            r9.zzb((int) r2)     // Catch:{ all -> 0x1028 }
            goto L_0x047a
        L_0x0629:
            if (r3 == 0) goto L_0x064a
            java.lang.Object r3 = r3.clone()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz$zza r3 = (com.google.android.gms.internal.measurement.zzhz.zza) r3     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r3 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r3     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r3 = r3.zza((java.lang.String) r7)     // Catch:{ all -> 0x1028 }
            r13 = 10
            com.google.android.gms.internal.measurement.zzcd$zze$zza r3 = r3.zza((long) r13)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r3 = r3.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r3 = (com.google.android.gms.internal.measurement.zzhz) r3     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3     // Catch:{ all -> 0x1028 }
            r9.zza((int) r2, (com.google.android.gms.internal.measurement.zzcd.zze) r3)     // Catch:{ all -> 0x1028 }
            goto L_0x047a
        L_0x064a:
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zze()     // Catch:{ all -> 0x1028 }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r4)     // Catch:{ all -> 0x1028 }
            r2.zza(r3, r4)     // Catch:{ all -> 0x1028 }
            goto L_0x047a
        L_0x0665:
            if (r6 == 0) goto L_0x0728
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x1028 }
            java.util.List r3 = r9.zza()     // Catch:{ all -> 0x1028 }
            r2.<init>(r3)     // Catch:{ all -> 0x1028 }
            r3 = 0
            r4 = -1
            r6 = -1
        L_0x0673:
            int r7 = r2.size()     // Catch:{ all -> 0x1028 }
            java.lang.String r14 = "currency"
            java.lang.String r15 = "value"
            if (r3 >= r7) goto L_0x06a3
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r7 = (com.google.android.gms.internal.measurement.zzcd.zze) r7     // Catch:{ all -> 0x1028 }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x1028 }
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x068f
            r4 = r3
            goto L_0x06a0
        L_0x068f:
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r7 = (com.google.android.gms.internal.measurement.zzcd.zze) r7     // Catch:{ all -> 0x1028 }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x1028 }
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x06a0
            r6 = r3
        L_0x06a0:
            int r3 = r3 + 1
            goto L_0x0673
        L_0x06a3:
            r3 = -1
            if (r4 == r3) goto L_0x0729
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3     // Catch:{ all -> 0x1028 }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x1028 }
            if (r3 != 0) goto L_0x06d9
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3     // Catch:{ all -> 0x1028 }
            boolean r3 = r3.zzi()     // Catch:{ all -> 0x1028 }
            if (r3 != 0) goto L_0x06d9
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzj()     // Catch:{ all -> 0x1028 }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.zza(r3)     // Catch:{ all -> 0x1028 }
            r9.zzb((int) r4)     // Catch:{ all -> 0x1028 }
            m10920h(r9, r12)     // Catch:{ all -> 0x1028 }
            r2 = 18
            m10919g(r9, r2, r15)     // Catch:{ all -> 0x1028 }
            goto L_0x0728
        L_0x06d9:
            r3 = -1
            if (r6 != r3) goto L_0x06df
            r2 = 1
            r7 = 3
            goto L_0x070b
        L_0x06df:
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r2 = (com.google.android.gms.internal.measurement.zzcd.zze) r2     // Catch:{ all -> 0x1028 }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x1028 }
            int r6 = r2.length()     // Catch:{ all -> 0x1028 }
            r7 = 3
            if (r6 == r7) goto L_0x06f2
        L_0x06f0:
            r2 = 1
            goto L_0x070b
        L_0x06f2:
            r6 = 0
        L_0x06f3:
            int r15 = r2.length()     // Catch:{ all -> 0x1028 }
            if (r6 >= r15) goto L_0x070a
            int r15 = r2.codePointAt(r6)     // Catch:{ all -> 0x1028 }
            boolean r17 = java.lang.Character.isLetter(r15)     // Catch:{ all -> 0x1028 }
            if (r17 != 0) goto L_0x0704
            goto L_0x06f0
        L_0x0704:
            int r15 = java.lang.Character.charCount(r15)     // Catch:{ all -> 0x1028 }
            int r6 = r6 + r15
            goto L_0x06f3
        L_0x070a:
            r2 = 0
        L_0x070b:
            if (r2 == 0) goto L_0x072a
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzj()     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r6)     // Catch:{ all -> 0x1028 }
            r9.zzb((int) r4)     // Catch:{ all -> 0x1028 }
            m10920h(r9, r12)     // Catch:{ all -> 0x1028 }
            r2 = 19
            m10919g(r9, r2, r14)     // Catch:{ all -> 0x1028 }
            goto L_0x072a
        L_0x0728:
            r3 = -1
        L_0x0729:
            r7 = 3
        L_0x072a:
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzat.zzas     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r4, r6)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x08cc
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x079b
            r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r2 = r9.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r2 = (com.google.android.gms.internal.measurement.zzhz) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r2 = com.google.android.gms.measurement.internal.zzks.m10958f(r2, r10)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x0796
            if (r32 == 0) goto L_0x078c
            long r14 = r32.zzf()     // Catch:{ all -> 0x1028 }
            long r17 = r9.zzf()     // Catch:{ all -> 0x1028 }
            long r14 = r14 - r17
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x1028 }
            r17 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r2 > 0) goto L_0x078c
            java.lang.Object r2 = r32.clone()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz$zza r2 = (com.google.android.gms.internal.measurement.zzhz.zza) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch:{ all -> 0x1028 }
            boolean r4 = r1.m10926y(r9, r2)     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x078c
            r4 = r31
            r4.zza((int) r8, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2)     // Catch:{ all -> 0x1028 }
            r10 = r22
            r6 = r30
        L_0x0786:
            r29 = 0
            r32 = 0
            goto L_0x08d2
        L_0x078c:
            r4 = r31
            r29 = r9
            r10 = r20
        L_0x0792:
            r6 = r30
            goto L_0x08d2
        L_0x0796:
            r4 = r31
            r10 = r22
            goto L_0x0792
        L_0x079b:
            r4 = r31
            java.lang.String r2 = "_vs"
            java.lang.String r6 = r9.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x07f2
            r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r2 = r9.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r2 = (com.google.android.gms.internal.measurement.zzhz) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ all -> 0x1028 }
            r6 = r30
            com.google.android.gms.internal.measurement.zzcd$zze r2 = com.google.android.gms.measurement.internal.zzks.m10958f(r2, r6)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x07ee
            if (r29 == 0) goto L_0x07e6
            long r14 = r29.zzf()     // Catch:{ all -> 0x1028 }
            long r17 = r9.zzf()     // Catch:{ all -> 0x1028 }
            long r14 = r14 - r17
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x1028 }
            r17 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r2 > 0) goto L_0x07e6
            java.lang.Object r2 = r29.clone()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz$zza r2 = (com.google.android.gms.internal.measurement.zzhz.zza) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch:{ all -> 0x1028 }
            boolean r10 = r1.m10926y(r2, r9)     // Catch:{ all -> 0x1028 }
            if (r10 == 0) goto L_0x07e6
            r10 = r22
            r4.zza((int) r10, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2)     // Catch:{ all -> 0x1028 }
            goto L_0x0786
        L_0x07e6:
            r10 = r22
            r32 = r9
            r8 = r20
            goto L_0x08d2
        L_0x07ee:
            r10 = r22
            goto L_0x08d2
        L_0x07f2:
            r10 = r22
            r6 = r30
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzat.zzbl     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r12, r14)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x08d2
            java.lang.String r2 = "_ab"
            java.lang.String r12 = r9.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x08d2
            r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r2 = r9.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r2 = (com.google.android.gms.internal.measurement.zzhz) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r2 = com.google.android.gms.measurement.internal.zzks.m10958f(r2, r6)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x08d2
            if (r29 == 0) goto L_0x08d2
            long r14 = r29.zzf()     // Catch:{ all -> 0x1028 }
            long r17 = r9.zzf()     // Catch:{ all -> 0x1028 }
            long r14 = r14 - r17
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x1028 }
            r17 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r2 > 0) goto L_0x08d2
            java.lang.Object r2 = r29.clone()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz$zza r2 = (com.google.android.gms.internal.measurement.zzhz.zza) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch:{ all -> 0x1028 }
            r1.m10905G(r2, r9)     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r2.zzd()     // Catch:{ all -> 0x1028 }
            boolean r12 = r11.equals(r12)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r12)     // Catch:{ all -> 0x1028 }
            r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r12 = r2.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r12 = (com.google.android.gms.internal.measurement.zzhz) r12     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r12 = (com.google.android.gms.internal.measurement.zzcd.zzc) r12     // Catch:{ all -> 0x1028 }
            java.lang.String r14 = "_sn"
            com.google.android.gms.internal.measurement.zzcd$zze r12 = com.google.android.gms.measurement.internal.zzks.m10958f(r12, r14)     // Catch:{ all -> 0x1028 }
            r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r14 = r2.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r14 = (com.google.android.gms.internal.measurement.zzhz) r14     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r14 = (com.google.android.gms.internal.measurement.zzcd.zzc) r14     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = "_sc"
            com.google.android.gms.internal.measurement.zzcd$zze r14 = com.google.android.gms.measurement.internal.zzks.m10958f(r14, r15)     // Catch:{ all -> 0x1028 }
            r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r15 = r2.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r15 = (com.google.android.gms.internal.measurement.zzhz) r15     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r15 = (com.google.android.gms.internal.measurement.zzcd.zzc) r15     // Catch:{ all -> 0x1028 }
            java.lang.String r3 = "_si"
            com.google.android.gms.internal.measurement.zzcd$zze r3 = com.google.android.gms.measurement.internal.zzks.m10958f(r15, r3)     // Catch:{ all -> 0x1028 }
            if (r12 == 0) goto L_0x088d
            java.lang.String r12 = r12.zzd()     // Catch:{ all -> 0x1028 }
            goto L_0x088f
        L_0x088d:
            r12 = r25
        L_0x088f:
            boolean r15 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x1028 }
            if (r15 != 0) goto L_0x089d
            r43.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = "_sn"
            com.google.android.gms.measurement.internal.zzks.m10963o(r9, r15, r12)     // Catch:{ all -> 0x1028 }
        L_0x089d:
            if (r14 == 0) goto L_0x08a4
            java.lang.String r12 = r14.zzd()     // Catch:{ all -> 0x1028 }
            goto L_0x08a6
        L_0x08a4:
            r12 = r25
        L_0x08a6:
            boolean r14 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x1028 }
            if (r14 != 0) goto L_0x08b4
            r43.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r14 = "_sc"
            com.google.android.gms.measurement.internal.zzks.m10963o(r9, r14, r12)     // Catch:{ all -> 0x1028 }
        L_0x08b4:
            if (r3 == 0) goto L_0x08c6
            r43.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = "_si"
            long r14 = r3.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzks.m10963o(r9, r12, r3)     // Catch:{ all -> 0x1028 }
        L_0x08c6:
            r4.zza((int) r10, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2)     // Catch:{ all -> 0x1028 }
            r29 = 0
            goto L_0x08d2
        L_0x08cc:
            r10 = r22
            r6 = r30
            r4 = r31
        L_0x08d2:
            if (r21 != 0) goto L_0x0933
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0933
            int r2 = r9.zzb()     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x08fe
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r3 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r6)     // Catch:{ all -> 0x1028 }
            r2.zza(r3, r6)     // Catch:{ all -> 0x1028 }
            goto L_0x0933
        L_0x08fe:
            r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r2 = r9.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r2 = (com.google.android.gms.internal.measurement.zzhz) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ all -> 0x1028 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzks.m10956B(r2, r6)     // Catch:{ all -> 0x1028 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x092b
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r3 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r6)     // Catch:{ all -> 0x1028 }
            r2.zza(r3, r6)     // Catch:{ all -> 0x1028 }
            goto L_0x0933
        L_0x092b:
            long r2 = r2.longValue()     // Catch:{ all -> 0x1028 }
            long r2 = r27 + r2
            r27 = r2
        L_0x0933:
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r2 = r5.f18720c     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r3 = r9.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r3 = (com.google.android.gms.internal.measurement.zzhz) r3     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r3 = (com.google.android.gms.internal.measurement.zzcd.zzc) r3     // Catch:{ all -> 0x1028 }
            r6 = r26
            r2.set(r6, r3)     // Catch:{ all -> 0x1028 }
            int r14 = r20 + 1
            r4.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9)     // Catch:{ all -> 0x1028 }
            r22 = r10
            r10 = r29
            r11 = r32
        L_0x094d:
            int r12 = r6 + 1
            r3 = r16
            r2 = r19
            r6 = r21
            r7 = r22
            r15 = r27
            goto L_0x02bc
        L_0x095b:
            r6 = r2
            r10 = r13
            r11 = r14
            r27 = r15
            if (r21 == 0) goto L_0x09b7
            r14 = r20
            r15 = r27
            r2 = 0
        L_0x0967:
            if (r2 >= r14) goto L_0x09b5
            com.google.android.gms.internal.measurement.zzcd$zzc r3 = r4.zzb((int) r2)     // Catch:{ all -> 0x1028 }
            java.lang.String r7 = r3.zzc()     // Catch:{ all -> 0x1028 }
            boolean r7 = r11.equals(r7)     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x0988
            r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r7 = com.google.android.gms.measurement.internal.zzks.m10958f(r3, r10)     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x0988
            r4.zzc((int) r2)     // Catch:{ all -> 0x1028 }
            int r14 = r14 + -1
            int r2 = r2 + -1
            goto L_0x09b2
        L_0x0988:
            r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r3 = com.google.android.gms.measurement.internal.zzks.m10958f(r3, r6)     // Catch:{ all -> 0x1028 }
            if (r3 == 0) goto L_0x09b2
            boolean r7 = r3.zze()     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x09a0
            long r7 = r3.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x1028 }
            goto L_0x09a1
        L_0x09a0:
            r3 = 0
        L_0x09a1:
            if (r3 == 0) goto L_0x09b2
            long r7 = r3.longValue()     // Catch:{ all -> 0x1028 }
            r12 = 0
            int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r9 <= 0) goto L_0x09b2
            long r7 = r3.longValue()     // Catch:{ all -> 0x1028 }
            long r15 = r15 + r7
        L_0x09b2:
            r3 = 1
            int r2 = r2 + r3
            goto L_0x0967
        L_0x09b5:
            r2 = r15
            goto L_0x09b9
        L_0x09b7:
            r2 = r27
        L_0x09b9:
            r6 = 0
            r1.m10921i(r4, r2, r6)     // Catch:{ all -> 0x1028 }
            java.util.List r6 = r4.zza()     // Catch:{ all -> 0x1028 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x1028 }
        L_0x09c5:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x09df
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r7 = (com.google.android.gms.internal.measurement.zzcd.zzc) r7     // Catch:{ all -> 0x1028 }
            java.lang.String r8 = "_s"
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x1028 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x09c5
            r6 = 1
            goto L_0x09e0
        L_0x09df:
            r6 = 0
        L_0x09e0:
            java.lang.String r7 = "_se"
            if (r6 == 0) goto L_0x09ef
            com.google.android.gms.measurement.internal.c r6 = r43.zze()     // Catch:{ all -> 0x1028 }
            java.lang.String r8 = r4.zzj()     // Catch:{ all -> 0x1028 }
            r6.mo19836R(r8, r7)     // Catch:{ all -> 0x1028 }
        L_0x09ef:
            java.lang.String r6 = "_sid"
            int r6 = com.google.android.gms.measurement.internal.zzks.m10957b(r4, r6)     // Catch:{ all -> 0x1028 }
            if (r6 < 0) goto L_0x09f9
            r6 = 1
            goto L_0x09fa
        L_0x09f9:
            r6 = 0
        L_0x09fa:
            if (r6 == 0) goto L_0x0a01
            r6 = 1
            r1.m10921i(r4, r2, r6)     // Catch:{ all -> 0x1028 }
            goto L_0x0a23
        L_0x0a01:
            int r2 = com.google.android.gms.measurement.internal.zzks.m10957b(r4, r7)     // Catch:{ all -> 0x1028 }
            if (r2 < 0) goto L_0x0a23
            r4.zze((int) r2)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zze()     // Catch:{ all -> 0x1028 }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r6)     // Catch:{ all -> 0x1028 }
            r2.zza(r3, r6)     // Catch:{ all -> 0x1028 }
        L_0x0a23:
            com.google.android.gms.measurement.internal.zzks r2 = r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r3 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzw()     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = "Checking account type status for ad personalization signals"
            r3.zza(r6)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfp r3 = r2.zzj()     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r4.zzj()     // Catch:{ all -> 0x1028 }
            boolean r3 = r3.mo20341i(r6)     // Catch:{ all -> 0x1028 }
            if (r3 == 0) goto L_0x0ab4
            com.google.android.gms.measurement.internal.c r3 = r2.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r4.zzj()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.i3 r3 = r3.mo19834P(r6)     // Catch:{ all -> 0x1028 }
            if (r3 == 0) goto L_0x0ab4
            boolean r3 = r3.mo19985l()     // Catch:{ all -> 0x1028 }
            if (r3 == 0) goto L_0x0ab4
            com.google.android.gms.measurement.internal.zzal r3 = r2.zzk()     // Catch:{ all -> 0x1028 }
            boolean r3 = r3.mo20235d()     // Catch:{ all -> 0x1028 }
            if (r3 == 0) goto L_0x0ab4
            com.google.android.gms.measurement.internal.zzer r3 = r2.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzv()     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = "Turning off ad personalization due to account type"
            r3.zza(r6)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r3 = com.google.android.gms.internal.measurement.zzcd.zzk.zzj()     // Catch:{ all -> 0x1028 }
            r6 = r19
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r3 = r3.zza((java.lang.String) r6)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzal r2 = r2.zzk()     // Catch:{ all -> 0x1028 }
            long r7 = r2.mo20233b()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r2 = r3.zza((long) r7)     // Catch:{ all -> 0x1028 }
            r7 = 1
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r2 = r2.zzb((long) r7)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r2 = r2.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r2 = (com.google.android.gms.internal.measurement.zzhz) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzk r2 = (com.google.android.gms.internal.measurement.zzcd.zzk) r2     // Catch:{ all -> 0x1028 }
            r3 = 0
        L_0x0a92:
            int r7 = r4.zze()     // Catch:{ all -> 0x1028 }
            if (r3 >= r7) goto L_0x0aae
            com.google.android.gms.internal.measurement.zzcd$zzk r7 = r4.zzd((int) r3)     // Catch:{ all -> 0x1028 }
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x1028 }
            boolean r7 = r6.equals(r7)     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x0aab
            r4.zza((int) r3, (com.google.android.gms.internal.measurement.zzcd.zzk) r2)     // Catch:{ all -> 0x1028 }
            r3 = 1
            goto L_0x0aaf
        L_0x0aab:
            int r3 = r3 + 1
            goto L_0x0a92
        L_0x0aae:
            r3 = 0
        L_0x0aaf:
            if (r3 != 0) goto L_0x0ab4
            r4.zza((com.google.android.gms.internal.measurement.zzcd.zzk) r2)     // Catch:{ all -> 0x1028 }
        L_0x0ab4:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r4.zzb((long) r2)     // Catch:{ all -> 0x1028 }
            r6 = -9223372036854775808
            r2.zzc((long) r6)     // Catch:{ all -> 0x1028 }
            r2 = 0
        L_0x0ac3:
            int r3 = r4.zzb()     // Catch:{ all -> 0x1028 }
            if (r2 >= r3) goto L_0x0af6
            com.google.android.gms.internal.measurement.zzcd$zzc r3 = r4.zzb((int) r2)     // Catch:{ all -> 0x1028 }
            long r6 = r3.zze()     // Catch:{ all -> 0x1028 }
            long r8 = r4.zzf()     // Catch:{ all -> 0x1028 }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x0ae0
            long r6 = r3.zze()     // Catch:{ all -> 0x1028 }
            r4.zzb((long) r6)     // Catch:{ all -> 0x1028 }
        L_0x0ae0:
            long r6 = r3.zze()     // Catch:{ all -> 0x1028 }
            long r8 = r4.zzg()     // Catch:{ all -> 0x1028 }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0af3
            long r6 = r3.zze()     // Catch:{ all -> 0x1028 }
            r4.zzc((long) r6)     // Catch:{ all -> 0x1028 }
        L_0x0af3:
            int r2 = r2 + 1
            goto L_0x0ac3
        L_0x0af6:
            boolean r2 = com.google.android.gms.internal.measurement.zzox.zzb()     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0b11
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()     // Catch:{ all -> 0x1028 }
            java.lang.String r3 = r4.zzj()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzat.zzcf     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r3, r6)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0b11
            r4.zzq()     // Catch:{ all -> 0x1028 }
        L_0x0b11:
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r4.zzp()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.a8 r6 = r43.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.String r7 = r4.zzj()     // Catch:{ all -> 0x1028 }
            java.util.List r8 = r4.zza()     // Catch:{ all -> 0x1028 }
            java.util.List r9 = r4.zzd()     // Catch:{ all -> 0x1028 }
            long r10 = r4.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x1028 }
            long r11 = r4.zzg()     // Catch:{ all -> 0x1028 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x1028 }
            java.util.List r3 = r6.mo19818c(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x1028 }
            r2.zzc((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcd.zza>) r3)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfv r2 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r3 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zzi(r3)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0e7b
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x1007 }
            r2.<init>()     // Catch:{ all -> 0x1007 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x1007 }
            r3.<init>()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.zzfv r6 = r1.f18701j     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.zzkw r6 = r6.zzh()     // Catch:{ all -> 0x1007 }
            java.security.SecureRandom r6 = r6.mo20564V()     // Catch:{ all -> 0x1007 }
            r7 = 0
        L_0x0b63:
            int r8 = r4.zzb()     // Catch:{ all -> 0x1007 }
            if (r7 >= r8) goto L_0x0e42
            com.google.android.gms.internal.measurement.zzcd$zzc r8 = r4.zzb((int) r7)     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzhz$zza r8 = r8.zzbn()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r8 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8     // Catch:{ all -> 0x1007 }
            java.lang.String r9 = r8.zzd()     // Catch:{ all -> 0x1007 }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x1007 }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0bf3
            r43.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r9 = r8.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r9 = (com.google.android.gms.internal.measurement.zzhz) r9     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = "_en"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzks.m10956B(r9, r11)     // Catch:{ all -> 0x1028 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x1028 }
            java.lang.Object r11 = r2.get(r9)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.h r11 = (com.google.android.gms.measurement.internal.C3000h) r11     // Catch:{ all -> 0x1028 }
            if (r11 != 0) goto L_0x0bad
            com.google.android.gms.measurement.internal.c r11 = r43.zze()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.h r11 = r11.mo19862k(r12, r9)     // Catch:{ all -> 0x1028 }
            r2.put(r9, r11)     // Catch:{ all -> 0x1028 }
        L_0x0bad:
            java.lang.Long r9 = r11.f18101i     // Catch:{ all -> 0x1028 }
            if (r9 != 0) goto L_0x0be8
            java.lang.Long r9 = r11.f18102j     // Catch:{ all -> 0x1028 }
            long r12 = r9.longValue()     // Catch:{ all -> 0x1028 }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0bc5
            r43.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.Long r9 = r11.f18102j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzks.m10963o(r8, r10, r9)     // Catch:{ all -> 0x1028 }
        L_0x0bc5:
            java.lang.Boolean r9 = r11.f18103k     // Catch:{ all -> 0x1028 }
            if (r9 == 0) goto L_0x0bdd
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x1028 }
            if (r9 == 0) goto L_0x0bdd
            r43.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r9 = "_efs"
            r10 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzks.m10963o(r8, r9, r12)     // Catch:{ all -> 0x1028 }
        L_0x0bdd:
            com.google.android.gms.internal.measurement.zzjh r9 = r8.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r9 = (com.google.android.gms.internal.measurement.zzhz) r9     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1028 }
            r3.add(r9)     // Catch:{ all -> 0x1028 }
        L_0x0be8:
            r4.zza((int) r7, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8)     // Catch:{ all -> 0x1028 }
        L_0x0beb:
            r9 = r2
            r44 = r5
            r15 = r6
            r5 = 1
            goto L_0x0e38
        L_0x0bf3:
            com.google.android.gms.measurement.internal.zzfp r9 = r43.zzc()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzcd$zzg r11 = r5.f18718a     // Catch:{ all -> 0x1007 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x1007 }
            long r11 = r9.mo20342j(r11)     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.zzfv r9 = r1.f18701j     // Catch:{ all -> 0x1007 }
            r9.zzh()     // Catch:{ all -> 0x1007 }
            long r13 = r8.zzf()     // Catch:{ all -> 0x1007 }
            long r13 = com.google.android.gms.measurement.internal.zzkw.zza((long) r13, (long) r11)     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzjh r9 = r8.zzz()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzhz r9 = (com.google.android.gms.internal.measurement.zzhz) r9     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1007 }
            java.lang.String r15 = "_dbg"
            r19 = r11
            r16 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x1007 }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x1007 }
            if (r12 != 0) goto L_0x0c80
            if (r11 != 0) goto L_0x0c29
            goto L_0x0c80
        L_0x0c29:
            java.util.List r9 = r9.zza()     // Catch:{ all -> 0x1028 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x1028 }
        L_0x0c31:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x1028 }
            if (r12 == 0) goto L_0x0c80
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zze r12 = (com.google.android.gms.internal.measurement.zzcd.zze) r12     // Catch:{ all -> 0x1028 }
            r44 = r9
            java.lang.String r9 = r12.zzb()     // Catch:{ all -> 0x1028 }
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x1028 }
            if (r9 == 0) goto L_0x0c7d
            boolean r9 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x1028 }
            if (r9 == 0) goto L_0x0c5b
            long r15 = r12.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.Long r9 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x1028 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x1028 }
            if (r9 != 0) goto L_0x0c7b
        L_0x0c5b:
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x1028 }
            if (r9 == 0) goto L_0x0c69
            java.lang.String r9 = r12.zzd()     // Catch:{ all -> 0x1028 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x1028 }
            if (r9 != 0) goto L_0x0c7b
        L_0x0c69:
            boolean r9 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x1028 }
            if (r9 == 0) goto L_0x0c80
            double r15 = r12.zzj()     // Catch:{ all -> 0x1028 }
            java.lang.Double r9 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x1028 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x1028 }
            if (r9 == 0) goto L_0x0c80
        L_0x0c7b:
            r9 = 1
            goto L_0x0c81
        L_0x0c7d:
            r9 = r44
            goto L_0x0c31
        L_0x0c80:
            r9 = 0
        L_0x0c81:
            if (r9 != 0) goto L_0x0c96
            com.google.android.gms.measurement.internal.zzfp r9 = r43.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzg r11 = r5.f18718a     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r8.zzd()     // Catch:{ all -> 0x1028 }
            int r9 = r9.mo20339g(r11, r12)     // Catch:{ all -> 0x1028 }
            goto L_0x0c97
        L_0x0c96:
            r9 = 1
        L_0x0c97:
            if (r9 > 0) goto L_0x0cc0
            com.google.android.gms.measurement.internal.zzfv r10 = r1.f18701j     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzer r10 = r10.zzq()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r8.zzd()     // Catch:{ all -> 0x1028 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x1028 }
            r10.zza(r11, r12, r9)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzjh r9 = r8.zzz()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzhz r9 = (com.google.android.gms.internal.measurement.zzhz) r9     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1028 }
            r3.add(r9)     // Catch:{ all -> 0x1028 }
            r4.zza((int) r7, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8)     // Catch:{ all -> 0x1028 }
            goto L_0x0beb
        L_0x0cc0:
            java.lang.String r11 = r8.zzd()     // Catch:{ all -> 0x1007 }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.h r11 = (com.google.android.gms.measurement.internal.C3000h) r11     // Catch:{ all -> 0x1007 }
            if (r11 != 0) goto L_0x0d1e
            com.google.android.gms.measurement.internal.c r11 = r43.zze()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.f18718a     // Catch:{ all -> 0x1007 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1007 }
            java.lang.String r15 = r8.zzd()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.h r11 = r11.mo19862k(r12, r15)     // Catch:{ all -> 0x1007 }
            if (r11 != 0) goto L_0x0d1e
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.zzer r11 = r11.zzq()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.zzet r11 = r11.zzh()     // Catch:{ all -> 0x1007 }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzcd$zzg r15 = r5.f18718a     // Catch:{ all -> 0x1007 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x1007 }
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x1007 }
            r11.zza(r12, r15, r1)     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.h r11 = new com.google.android.gms.measurement.internal.h     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzcd$zzg r1 = r5.f18718a     // Catch:{ all -> 0x1007 }
            java.lang.String r27 = r1.zzx()     // Catch:{ all -> 0x1007 }
            java.lang.String r28 = r8.zzd()     // Catch:{ all -> 0x1007 }
            r29 = 1
            r31 = 1
            r33 = 1
            long r35 = r8.zzf()     // Catch:{ all -> 0x1007 }
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r26 = r11
            r26.<init>(r27, r28, r29, r31, r33, r35, r37, r39, r40, r41, r42)     // Catch:{ all -> 0x1007 }
        L_0x0d1e:
            r43.zzh()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzjh r1 = r8.zzz()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzhz r1 = (com.google.android.gms.internal.measurement.zzhz) r1     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzcd$zzc r1 = (com.google.android.gms.internal.measurement.zzcd.zzc) r1     // Catch:{ all -> 0x1007 }
            java.lang.String r12 = "_eid"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzks.m10956B(r1, r12)     // Catch:{ all -> 0x1007 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x1007 }
            if (r1 == 0) goto L_0x0d35
            r12 = 1
            goto L_0x0d36
        L_0x0d35:
            r12 = 0
        L_0x0d36:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x1007 }
            r15 = 1
            if (r9 != r15) goto L_0x0d6b
            com.google.android.gms.internal.measurement.zzjh r1 = r8.zzz()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzhz r1 = (com.google.android.gms.internal.measurement.zzhz) r1     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzcd$zzc r1 = (com.google.android.gms.internal.measurement.zzcd.zzc) r1     // Catch:{ all -> 0x1007 }
            r3.add(r1)     // Catch:{ all -> 0x1007 }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x1007 }
            if (r1 == 0) goto L_0x0d66
            java.lang.Long r1 = r11.f18101i     // Catch:{ all -> 0x1007 }
            if (r1 != 0) goto L_0x0d5a
            java.lang.Long r1 = r11.f18102j     // Catch:{ all -> 0x1007 }
            if (r1 != 0) goto L_0x0d5a
            java.lang.Boolean r1 = r11.f18103k     // Catch:{ all -> 0x1007 }
            if (r1 == 0) goto L_0x0d66
        L_0x0d5a:
            r1 = 0
            com.google.android.gms.measurement.internal.h r9 = r11.mo19923c(r1, r1, r1)     // Catch:{ all -> 0x1007 }
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x1007 }
            r2.put(r1, r9)     // Catch:{ all -> 0x1007 }
        L_0x0d66:
            r4.zza((int) r7, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8)     // Catch:{ all -> 0x1007 }
            goto L_0x0beb
        L_0x0d6b:
            int r15 = r6.nextInt(r9)     // Catch:{ all -> 0x1007 }
            if (r15 != 0) goto L_0x0dad
            r43.zzh()     // Catch:{ all -> 0x1007 }
            r44 = r5
            r15 = r6
            long r5 = (long) r9     // Catch:{ all -> 0x1007 }
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.zzks.m10963o(r8, r10, r1)     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzjh r1 = r8.zzz()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzhz r1 = (com.google.android.gms.internal.measurement.zzhz) r1     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzcd$zzc r1 = (com.google.android.gms.internal.measurement.zzcd.zzc) r1     // Catch:{ all -> 0x1007 }
            r3.add(r1)     // Catch:{ all -> 0x1007 }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x1007 }
            if (r1 == 0) goto L_0x0d99
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x1007 }
            r5 = 0
            com.google.android.gms.measurement.internal.h r11 = r11.mo19923c(r5, r1, r5)     // Catch:{ all -> 0x1007 }
        L_0x0d99:
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x1007 }
            long r5 = r8.zzf()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.h r5 = r11.mo19922b(r5, r13)     // Catch:{ all -> 0x1007 }
            r2.put(r1, r5)     // Catch:{ all -> 0x1007 }
            r9 = r2
            r5 = 1
            goto L_0x0e35
        L_0x0dad:
            r44 = r5
            r15 = r6
            java.lang.Long r5 = r11.f18100h     // Catch:{ all -> 0x1007 }
            if (r5 == 0) goto L_0x0dbd
            long r5 = r5.longValue()     // Catch:{ all -> 0x1007 }
            r17 = r1
            r16 = r2
            goto L_0x0dd2
        L_0x0dbd:
            r5 = r43
            com.google.android.gms.measurement.internal.zzfv r6 = r5.f18701j     // Catch:{ all -> 0x1007 }
            r6.zzh()     // Catch:{ all -> 0x1007 }
            long r5 = r8.zzg()     // Catch:{ all -> 0x1007 }
            r17 = r1
            r16 = r2
            r1 = r19
            long r5 = com.google.android.gms.measurement.internal.zzkw.zza((long) r5, (long) r1)     // Catch:{ all -> 0x1007 }
        L_0x0dd2:
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x0e1d
            r43.zzh()     // Catch:{ all -> 0x1007 }
            java.lang.String r1 = "_efs"
            r5 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.zzks.m10963o(r8, r1, r2)     // Catch:{ all -> 0x1007 }
            r43.zzh()     // Catch:{ all -> 0x1007 }
            long r1 = (long) r9     // Catch:{ all -> 0x1007 }
            java.lang.Long r9 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.zzks.m10963o(r8, r10, r9)     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzjh r9 = r8.zzz()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzhz r9 = (com.google.android.gms.internal.measurement.zzhz) r9     // Catch:{ all -> 0x1007 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1007 }
            r3.add(r9)     // Catch:{ all -> 0x1007 }
            boolean r9 = r12.booleanValue()     // Catch:{ all -> 0x1007 }
            if (r9 == 0) goto L_0x0e0b
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x1007 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x1007 }
            r9 = 0
            com.google.android.gms.measurement.internal.h r11 = r11.mo19923c(r9, r1, r2)     // Catch:{ all -> 0x1007 }
        L_0x0e0b:
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x1007 }
            long r9 = r8.zzf()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.h r2 = r11.mo19922b(r9, r13)     // Catch:{ all -> 0x1007 }
            r9 = r16
            r9.put(r1, r2)     // Catch:{ all -> 0x1007 }
            goto L_0x0e35
        L_0x0e1d:
            r9 = r16
            r5 = 1
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x1007 }
            if (r1 == 0) goto L_0x0e35
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x1007 }
            r2 = r17
            r10 = 0
            com.google.android.gms.measurement.internal.h r2 = r11.mo19923c(r2, r10, r10)     // Catch:{ all -> 0x1007 }
            r9.put(r1, r2)     // Catch:{ all -> 0x1007 }
        L_0x0e35:
            r4.zza((int) r7, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8)     // Catch:{ all -> 0x1007 }
        L_0x0e38:
            int r7 = r7 + 1
            r1 = r43
            r5 = r44
            r2 = r9
            r6 = r15
            goto L_0x0b63
        L_0x0e42:
            r9 = r2
            r44 = r5
            int r1 = r3.size()     // Catch:{ all -> 0x1007 }
            int r2 = r4.zzb()     // Catch:{ all -> 0x1007 }
            if (r1 >= r2) goto L_0x0e56
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r1 = r4.zzc()     // Catch:{ all -> 0x1007 }
            r1.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcd.zzc>) r3)     // Catch:{ all -> 0x1007 }
        L_0x0e56:
            java.util.Set r1 = r9.entrySet()     // Catch:{ all -> 0x1007 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x1007 }
        L_0x0e5e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x1007 }
            if (r2 == 0) goto L_0x0e78
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x1007 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.c r3 = r43.zze()     // Catch:{ all -> 0x1007 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.h r2 = (com.google.android.gms.measurement.internal.C3000h) r2     // Catch:{ all -> 0x1007 }
            r3.mo19871u(r2)     // Catch:{ all -> 0x1007 }
            goto L_0x0e5e
        L_0x0e78:
            r1 = r44
            goto L_0x0e7c
        L_0x0e7b:
            r1 = r5
        L_0x0e7c:
            com.google.android.gms.internal.measurement.zzcd$zzg r2 = r1.f18718a     // Catch:{ all -> 0x1007 }
            java.lang.String r2 = r2.zzx()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.c r3 = r43.zze()     // Catch:{ all -> 0x1007 }
            com.google.android.gms.measurement.internal.i3 r3 = r3.mo19834P(r2)     // Catch:{ all -> 0x1007 }
            if (r3 != 0) goto L_0x0ea8
            r5 = r43
            com.google.android.gms.measurement.internal.zzfv r3 = r5.f18701j     // Catch:{ all -> 0x1026 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzq()     // Catch:{ all -> 0x1026 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zze()     // Catch:{ all -> 0x1026 }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r1.f18718a     // Catch:{ all -> 0x1026 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1026 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r7)     // Catch:{ all -> 0x1026 }
            r3.zza(r6, r7)     // Catch:{ all -> 0x1026 }
            goto L_0x0f05
        L_0x0ea8:
            r5 = r43
            int r6 = r4.zzb()     // Catch:{ all -> 0x1026 }
            if (r6 <= 0) goto L_0x0f05
            long r6 = r3.mo19954R()     // Catch:{ all -> 0x1026 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0ebe
            r4.zze((long) r6)     // Catch:{ all -> 0x1026 }
            goto L_0x0ec1
        L_0x0ebe:
            r4.zzi()     // Catch:{ all -> 0x1026 }
        L_0x0ec1:
            long r8 = r3.mo19952P()     // Catch:{ all -> 0x1026 }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0ecc
            goto L_0x0ecd
        L_0x0ecc:
            r6 = r8
        L_0x0ecd:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0ed5
            r4.zzd((long) r6)     // Catch:{ all -> 0x1026 }
            goto L_0x0ed8
        L_0x0ed5:
            r4.zzh()     // Catch:{ all -> 0x1026 }
        L_0x0ed8:
            r3.mo19980i0()     // Catch:{ all -> 0x1026 }
            long r6 = r3.mo19974f0()     // Catch:{ all -> 0x1026 }
            int r7 = (int) r6     // Catch:{ all -> 0x1026 }
            r4.zzg((int) r7)     // Catch:{ all -> 0x1026 }
            long r6 = r4.zzf()     // Catch:{ all -> 0x1026 }
            r3.mo19963a(r6)     // Catch:{ all -> 0x1026 }
            long r6 = r4.zzg()     // Catch:{ all -> 0x1026 }
            r3.mo19992q(r6)     // Catch:{ all -> 0x1026 }
            java.lang.String r6 = r3.mo19981j()     // Catch:{ all -> 0x1026 }
            if (r6 == 0) goto L_0x0efb
            r4.zzj((java.lang.String) r6)     // Catch:{ all -> 0x1026 }
            goto L_0x0efe
        L_0x0efb:
            r4.zzn()     // Catch:{ all -> 0x1026 }
        L_0x0efe:
            com.google.android.gms.measurement.internal.c r6 = r43.zze()     // Catch:{ all -> 0x1026 }
            r6.mo19872v(r3)     // Catch:{ all -> 0x1026 }
        L_0x0f05:
            int r3 = r4.zzb()     // Catch:{ all -> 0x1026 }
            if (r3 <= 0) goto L_0x0f66
            com.google.android.gms.measurement.internal.zzfp r3 = r43.zzc()     // Catch:{ all -> 0x1026 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r1.f18718a     // Catch:{ all -> 0x1026 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1026 }
            com.google.android.gms.internal.measurement.zzca$zzb r3 = r3.zza(r6)     // Catch:{ all -> 0x1026 }
            if (r3 == 0) goto L_0x0f2a
            boolean r6 = r3.zza()     // Catch:{ all -> 0x1026 }
            if (r6 != 0) goto L_0x0f22
            goto L_0x0f2a
        L_0x0f22:
            long r6 = r3.zzb()     // Catch:{ all -> 0x1026 }
            r4.zzi((long) r6)     // Catch:{ all -> 0x1026 }
            goto L_0x0f55
        L_0x0f2a:
            com.google.android.gms.internal.measurement.zzcd$zzg r3 = r1.f18718a     // Catch:{ all -> 0x1026 }
            java.lang.String r3 = r3.zzam()     // Catch:{ all -> 0x1026 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x1026 }
            if (r3 == 0) goto L_0x0f3c
            r6 = -1
            r4.zzi((long) r6)     // Catch:{ all -> 0x1026 }
            goto L_0x0f55
        L_0x0f3c:
            com.google.android.gms.measurement.internal.zzfv r3 = r5.f18701j     // Catch:{ all -> 0x1026 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzq()     // Catch:{ all -> 0x1026 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzh()     // Catch:{ all -> 0x1026 }
            java.lang.String r6 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r1.f18718a     // Catch:{ all -> 0x1026 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1026 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r7)     // Catch:{ all -> 0x1026 }
            r3.zza(r6, r7)     // Catch:{ all -> 0x1026 }
        L_0x0f55:
            com.google.android.gms.measurement.internal.c r3 = r43.zze()     // Catch:{ all -> 0x1026 }
            com.google.android.gms.internal.measurement.zzjh r4 = r4.zzz()     // Catch:{ all -> 0x1026 }
            com.google.android.gms.internal.measurement.zzhz r4 = (com.google.android.gms.internal.measurement.zzhz) r4     // Catch:{ all -> 0x1026 }
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = (com.google.android.gms.internal.measurement.zzcd.zzg) r4     // Catch:{ all -> 0x1026 }
            r13 = r18
            r3.mo19875y(r4, r13)     // Catch:{ all -> 0x1026 }
        L_0x0f66:
            com.google.android.gms.measurement.internal.c r3 = r43.zze()     // Catch:{ all -> 0x1026 }
            java.util.List<java.lang.Long> r1 = r1.f18719b     // Catch:{ all -> 0x1026 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)     // Catch:{ all -> 0x1026 }
            r3.zzc()     // Catch:{ all -> 0x1026 }
            r3.zzaj()     // Catch:{ all -> 0x1026 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x1026 }
            java.lang.String r6 = "rowid in ("
            r4.<init>(r6)     // Catch:{ all -> 0x1026 }
            r6 = 0
        L_0x0f7d:
            int r7 = r1.size()     // Catch:{ all -> 0x1026 }
            if (r6 >= r7) goto L_0x0f9a
            if (r6 == 0) goto L_0x0f8a
            java.lang.String r7 = ","
            r4.append(r7)     // Catch:{ all -> 0x1026 }
        L_0x0f8a:
            java.lang.Object r7 = r1.get(r6)     // Catch:{ all -> 0x1026 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x1026 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x1026 }
            r4.append(r7)     // Catch:{ all -> 0x1026 }
            int r6 = r6 + 1
            goto L_0x0f7d
        L_0x0f9a:
            java.lang.String r6 = ")"
            r4.append(r6)     // Catch:{ all -> 0x1026 }
            android.database.sqlite.SQLiteDatabase r6 = r3.mo19847c()     // Catch:{ all -> 0x1026 }
            java.lang.String r7 = "raw_events"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x1026 }
            r8 = 0
            int r4 = r6.delete(r7, r4, r8)     // Catch:{ all -> 0x1026 }
            int r6 = r1.size()     // Catch:{ all -> 0x1026 }
            if (r4 == r6) goto L_0x0fcd
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzq()     // Catch:{ all -> 0x1026 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zze()     // Catch:{ all -> 0x1026 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x1026 }
            int r1 = r1.size()     // Catch:{ all -> 0x1026 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x1026 }
            r3.zza(r6, r4, r1)     // Catch:{ all -> 0x1026 }
        L_0x0fcd:
            com.google.android.gms.measurement.internal.c r1 = r43.zze()     // Catch:{ all -> 0x1026 }
            android.database.sqlite.SQLiteDatabase r3 = r1.mo19847c()     // Catch:{ all -> 0x1026 }
            java.lang.String r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0fe4 }
            r7 = 0
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0fe4 }
            r7 = 1
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0fe4 }
            r3.execSQL(r4, r6)     // Catch:{ SQLiteException -> 0x0fe4 }
            goto L_0x0ff7
        L_0x0fe4:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()     // Catch:{ all -> 0x1026 }
            com.google.android.gms.measurement.internal.zzet r1 = r1.zze()     // Catch:{ all -> 0x1026 }
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r2)     // Catch:{ all -> 0x1026 }
            r1.zza(r4, r2, r3)     // Catch:{ all -> 0x1026 }
        L_0x0ff7:
            com.google.android.gms.measurement.internal.c r1 = r43.zze()     // Catch:{ all -> 0x1026 }
            r1.mo19845b()     // Catch:{ all -> 0x1026 }
            com.google.android.gms.measurement.internal.c r1 = r43.zze()
            r1.mo19850d0()
            r1 = 1
            return r1
        L_0x1007:
            r0 = move-exception
            r5 = r43
            goto L_0x102a
        L_0x100b:
            r5 = r1
            com.google.android.gms.measurement.internal.c r1 = r43.zze()     // Catch:{ all -> 0x1026 }
            r1.mo19845b()     // Catch:{ all -> 0x1026 }
            com.google.android.gms.measurement.internal.c r1 = r43.zze()
            r1.mo19850d0()
            r1 = 0
            return r1
        L_0x101c:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r6 = r4
        L_0x1020:
            if (r6 == 0) goto L_0x1025
            r6.close()     // Catch:{ all -> 0x1026 }
        L_0x1025:
            throw r1     // Catch:{ all -> 0x1026 }
        L_0x1026:
            r0 = move-exception
            goto L_0x102a
        L_0x1028:
            r0 = move-exception
            r5 = r1
        L_0x102a:
            r1 = r0
            com.google.android.gms.measurement.internal.c r2 = r43.zze()
            r2.mo19850d0()
            goto L_0x1034
        L_0x1033:
            throw r1
        L_0x1034:
            goto L_0x1033
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.m10927z(java.lang.String, long):boolean");
    }

    public static zzki zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f18691A == null) {
            synchronized (zzki.class) {
                if (f18691A == null) {
                    f18691A = new zzki(new zzkq(context));
                }
            }
        }
        return f18691A;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: J */
    public final void mo20502J(zzkr zzkr, zzn zzn) {
        m10912Y();
        mo20508R();
        if (m10909Q(zzn)) {
            if (!zzn.zzh) {
                mo20506N(zzn);
            } else if (!"_npa".equals(zzkr.zza) || zzn.zzs == null) {
                this.f18701j.zzq().zzv().zza("Removing user property", this.f18701j.zzi().zzc(zzkr.zza));
                zze().zze();
                try {
                    mo20506N(zzn);
                    zze().mo19836R(zzn.zza, zzkr.zza);
                    zze().mo19845b();
                    this.f18701j.zzq().zzv().zza("User property removed", this.f18701j.zzi().zzc(zzkr.zza));
                } finally {
                    zze().mo19850d0();
                }
            } else {
                this.f18701j.zzq().zzv().zza("Falling back to manifest metadata value for ad personalization");
                mo20518p(new zzkr("_npa", this.f18701j.zzl().currentTimeMillis(), Long.valueOf(zzn.zzs.booleanValue() ? 1 : 0), "auto"), zzn);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03ab A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0481 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011b A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01d2 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0206 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0208 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x020c A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x022f A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0235 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0242 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0255 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04ad }] */
    @androidx.annotation.WorkerThread
    /* renamed from: K */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo20503K(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.m10912Y()
            r21.mo20508R()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r7 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            boolean r7 = r21.m10909Q(r22)
            if (r7 != 0) goto L_0x0023
            return
        L_0x0023:
            com.google.android.gms.measurement.internal.c r7 = r21.zze()
            java.lang.String r8 = r2.zza
            com.google.android.gms.measurement.internal.i3 r7 = r7.mo19834P(r8)
            r8 = 0
            if (r7 == 0) goto L_0x0056
            java.lang.String r10 = r7.mo19937A()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0056
            java.lang.String r10 = r2.zzb
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0056
            r7.mo19947K(r8)
            com.google.android.gms.measurement.internal.c r10 = r21.zze()
            r10.mo19872v(r7)
            com.google.android.gms.measurement.internal.zzfp r7 = r21.zzc()
            java.lang.String r10 = r2.zza
            r7.mo20340h(r10)
        L_0x0056:
            boolean r7 = r2.zzh
            if (r7 != 0) goto L_0x005e
            r21.mo20506N(r22)
            return
        L_0x005e:
            long r10 = r2.zzm
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j
            com.google.android.gms.common.util.Clock r7 = r7.zzl()
            long r10 = r7.currentTimeMillis()
        L_0x006e:
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j
            com.google.android.gms.measurement.internal.zzal r7 = r7.zzw()
            r7.mo20234c()
            int r7 = r2.zzn
            r15 = 1
            if (r7 == 0) goto L_0x0098
            if (r7 == r15) goto L_0x0098
            com.google.android.gms.measurement.internal.zzfv r12 = r1.f18701j
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzq()
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzh()
            java.lang.String r13 = r2.zza
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r13)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r12.zza(r14, r13, r7)
            r7 = 0
        L_0x0098:
            com.google.android.gms.measurement.internal.c r12 = r21.zze()
            r12.zze()
            com.google.android.gms.measurement.internal.c r12 = r21.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x04ad }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.v7 r14 = r12.mo19838U(r13, r14)     // Catch:{ all -> 0x04ad }
            if (r14 == 0) goto L_0x00bc
            java.lang.String r12 = "auto"
            java.lang.String r13 = r14.f18416b     // Catch:{ all -> 0x04ad }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x04ad }
            if (r12 == 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            r18 = r3
            r3 = 1
            goto L_0x010f
        L_0x00bc:
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04ad }
            if (r12 == 0) goto L_0x00f9
            com.google.android.gms.measurement.internal.zzkr r13 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04ad }
            java.lang.String r18 = "_npa"
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04ad }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x04ad }
            if (r12 == 0) goto L_0x00cf
            r19 = 1
            goto L_0x00d1
        L_0x00cf:
            r19 = r8
        L_0x00d1:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x04ad }
            java.lang.String r20 = "auto"
            r8 = 1
            r12 = r13
            r8 = r13
            r13 = r18
            r18 = r3
            r9 = r14
            r3 = 1
            r14 = r10
            r16 = r19
            r17 = r20
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04ad }
            if (r9 == 0) goto L_0x00f5
            java.lang.Object r9 = r9.f18419e     // Catch:{ all -> 0x04ad }
            java.lang.Long r12 = r8.zzc     // Catch:{ all -> 0x04ad }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x04ad }
            if (r9 != 0) goto L_0x010f
        L_0x00f5:
            r1.mo20518p(r8, r2)     // Catch:{ all -> 0x04ad }
            goto L_0x010f
        L_0x00f9:
            r18 = r3
            r9 = r14
            r3 = 1
            if (r9 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzkr r8 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = "_npa"
            r16 = 0
            java.lang.String r17 = "auto"
            r12 = r8
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04ad }
            r1.mo20502J(r8, r2)     // Catch:{ all -> 0x04ad }
        L_0x010f:
            com.google.android.gms.measurement.internal.c r8 = r21.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.i3 r8 = r8.mo19834P(r9)     // Catch:{ all -> 0x04ad }
            if (r8 == 0) goto L_0x01d0
            com.google.android.gms.measurement.internal.zzfv r12 = r1.f18701j     // Catch:{ all -> 0x04ad }
            r12.zzh()     // Catch:{ all -> 0x04ad }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = r8.mo19937A()     // Catch:{ all -> 0x04ad }
            java.lang.String r14 = r2.zzr     // Catch:{ all -> 0x04ad }
            java.lang.String r15 = r8.mo19940D()     // Catch:{ all -> 0x04ad }
            boolean r12 = com.google.android.gms.measurement.internal.zzkw.m10986C(r12, r13, r14, r15)     // Catch:{ all -> 0x04ad }
            if (r12 == 0) goto L_0x01d0
            com.google.android.gms.measurement.internal.zzfv r12 = r1.f18701j     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzq()     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzh()     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r14 = r8.mo19995t()     // Catch:{ all -> 0x04ad }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r14)     // Catch:{ all -> 0x04ad }
            r12.zza(r13, r14)     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.c r12 = r21.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r8 = r8.mo19995t()     // Catch:{ all -> 0x04ad }
            r12.zzaj()     // Catch:{ all -> 0x04ad }
            r12.zzc()     // Catch:{ all -> 0x04ad }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x04ad }
            android.database.sqlite.SQLiteDatabase r13 = r12.mo19847c()     // Catch:{ SQLiteException -> 0x01bd }
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01bd }
            r15 = 0
            r14[r15] = r8     // Catch:{ SQLiteException -> 0x01bd }
            java.lang.String r9 = "events"
            int r9 = r13.delete(r9, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "user_attributes"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "apps"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "consent_settings"
            int r0 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r0
            if (r9 <= 0) goto L_0x01cf
            com.google.android.gms.measurement.internal.zzer r0 = r12.zzq()     // Catch:{ SQLiteException -> 0x01bd }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzw()     // Catch:{ SQLiteException -> 0x01bd }
            java.lang.String r13 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ SQLiteException -> 0x01bd }
            r0.zza(r13, r8, r9)     // Catch:{ SQLiteException -> 0x01bd }
            goto L_0x01cf
        L_0x01bd:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzer r9 = r12.zzq()     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzet r9 = r9.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r8)     // Catch:{ all -> 0x04ad }
            r9.zza(r12, r8, r0)     // Catch:{ all -> 0x04ad }
        L_0x01cf:
            r8 = 0
        L_0x01d0:
            if (r8 == 0) goto L_0x022f
            long r12 = r8.mo19958V()     // Catch:{ all -> 0x04ad }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01ea
            long r12 = r8.mo19958V()     // Catch:{ all -> 0x04ad }
            r9 = r4
            long r3 = r2.zzj     // Catch:{ all -> 0x04ad }
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01eb
            r0 = 1
            goto L_0x01ec
        L_0x01ea:
            r9 = r4
        L_0x01eb:
            r0 = 0
        L_0x01ec:
            long r3 = r8.mo19958V()     // Catch:{ all -> 0x04ad }
            int r12 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x0208
            java.lang.String r3 = r8.mo19956T()     // Catch:{ all -> 0x04ad }
            if (r3 == 0) goto L_0x0208
            java.lang.String r3 = r8.mo19956T()     // Catch:{ all -> 0x04ad }
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x04ad }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04ad }
            if (r3 != 0) goto L_0x0208
            r14 = 1
            goto L_0x0209
        L_0x0208:
            r14 = 0
        L_0x0209:
            r0 = r0 | r14
            if (r0 == 0) goto L_0x0230
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04ad }
            r0.<init>()     // Catch:{ all -> 0x04ad }
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r8.mo19956T()     // Catch:{ all -> 0x04ad }
            r0.putString(r3, r4)     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzar r3 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04ad }
            r14.<init>(r0)     // Catch:{ all -> 0x04ad }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04ad }
            r1.mo20515j(r3, r2)     // Catch:{ all -> 0x04ad }
            goto L_0x0230
        L_0x022f:
            r9 = r4
        L_0x0230:
            r21.mo20506N(r22)     // Catch:{ all -> 0x04ad }
            if (r7 != 0) goto L_0x0242
            com.google.android.gms.measurement.internal.c r0 = r21.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04ad }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.h r0 = r0.mo19862k(r3, r4)     // Catch:{ all -> 0x04ad }
            goto L_0x0253
        L_0x0242:
            r3 = 1
            if (r7 != r3) goto L_0x0252
            com.google.android.gms.measurement.internal.c r0 = r21.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04ad }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.h r0 = r0.mo19862k(r3, r4)     // Catch:{ all -> 0x04ad }
            goto L_0x0253
        L_0x0252:
            r0 = 0
        L_0x0253:
            if (r0 != 0) goto L_0x0481
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r10 / r3
            r14 = 1
            long r12 = r12 + r14
            long r12 = r12 * r3
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r4 = "_c"
            java.lang.String r8 = "_et"
            if (r7 != 0) goto L_0x03df
            com.google.android.gms.measurement.internal.zzkr r7 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04ad }
            java.lang.String r14 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04ad }
            java.lang.String r17 = "auto"
            r12 = r7
            r13 = r14
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04ad }
            r1.mo20518p(r7, r2)     // Catch:{ all -> 0x04ad }
            r21.m10912Y()     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x04ad }
            r7.zza(r12)     // Catch:{ all -> 0x04ad }
            r21.m10912Y()     // Catch:{ all -> 0x04ad }
            r21.mo20508R()     // Catch:{ all -> 0x04ad }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x04ad }
            r7.<init>()     // Catch:{ all -> 0x04ad }
            r12 = 1
            r7.putLong(r4, r12)     // Catch:{ all -> 0x04ad }
            r7.putLong(r3, r12)     // Catch:{ all -> 0x04ad }
            r3 = 0
            r7.putLong(r6, r3)     // Catch:{ all -> 0x04ad }
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04ad }
            r7.putLong(r9, r3)     // Catch:{ all -> 0x04ad }
            r14 = r18
            r7.putLong(r14, r3)     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zza()     // Catch:{ all -> 0x04ad }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzat.zzas     // Catch:{ all -> 0x04ad }
            boolean r3 = r3.zze(r4, r12)     // Catch:{ all -> 0x04ad }
            if (r3 == 0) goto L_0x02c3
            r3 = 1
            r7.putLong(r8, r3)     // Catch:{ all -> 0x04ad }
            goto L_0x02c5
        L_0x02c3:
            r3 = 1
        L_0x02c5:
            boolean r12 = r2.zzq     // Catch:{ all -> 0x04ad }
            if (r12 == 0) goto L_0x02cc
            r7.putLong(r0, r3)     // Catch:{ all -> 0x04ad }
        L_0x02cc:
            com.google.android.gms.measurement.internal.c r0 = r21.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04ad }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x04ad }
            r0.zzc()     // Catch:{ all -> 0x04ad }
            r0.zzaj()     // Catch:{ all -> 0x04ad }
            java.lang.String r4 = "first_open_count"
            long r3 = r0.mo19854f0(r3, r4)     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzfv r0 = r1.f18701j     // Catch:{ all -> 0x04ad }
            android.content.Context r0 = r0.zzm()     // Catch:{ all -> 0x04ad }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04ad }
            if (r0 != 0) goto L_0x0306
            com.google.android.gms.measurement.internal.zzfv r0 = r1.f18701j     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzq()     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r6 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04ad }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r9)     // Catch:{ all -> 0x04ad }
            r0.zza(r6, r9)     // Catch:{ all -> 0x04ad }
        L_0x0302:
            r12 = 0
            goto L_0x03c3
        L_0x0306:
            com.google.android.gms.measurement.internal.zzfv r0 = r1.f18701j     // Catch:{ NameNotFoundException -> 0x0318 }
            android.content.Context r0 = r0.zzm()     // Catch:{ NameNotFoundException -> 0x0318 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0318 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x0318 }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x0318 }
            goto L_0x032f
        L_0x0318:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfv r12 = r1.f18701j     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzq()     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.zza     // Catch:{ all -> 0x04ad }
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r15)     // Catch:{ all -> 0x04ad }
            r12.zza(r13, r15, r0)     // Catch:{ all -> 0x04ad }
            r0 = 0
        L_0x032f:
            if (r0 == 0) goto L_0x037f
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04ad }
            r15 = 0
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x037f
            r18 = r14
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x04ad }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0362
            com.google.android.gms.measurement.internal.zzfv r0 = r1.f18701j     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zza()     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzat.zzbm     // Catch:{ all -> 0x04ad }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r12)     // Catch:{ all -> 0x04ad }
            if (r0 == 0) goto L_0x035b
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0360
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04ad }
            goto L_0x0360
        L_0x035b:
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04ad }
        L_0x0360:
            r14 = 0
            goto L_0x0363
        L_0x0362:
            r14 = 1
        L_0x0363:
            com.google.android.gms.measurement.internal.zzkr r0 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = "_fi"
            if (r14 == 0) goto L_0x036c
            r14 = 1
            goto L_0x036e
        L_0x036c:
            r14 = 0
        L_0x036e:
            java.lang.Long r16 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x04ad }
            java.lang.String r17 = "auto"
            r12 = r0
            r6 = r18
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04ad }
            r1.mo20518p(r0, r2)     // Catch:{ all -> 0x04ad }
            goto L_0x0380
        L_0x037f:
            r6 = r14
        L_0x0380:
            com.google.android.gms.measurement.internal.zzfv r0 = r1.f18701j     // Catch:{ NameNotFoundException -> 0x0392 }
            android.content.Context r0 = r0.zzm()     // Catch:{ NameNotFoundException -> 0x0392 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0392 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x0392 }
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x0392 }
            goto L_0x03a9
        L_0x0392:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfv r12 = r1.f18701j     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzq()     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zze()     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x04ad }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r14)     // Catch:{ all -> 0x04ad }
            r12.zza(r13, r14, r0)     // Catch:{ all -> 0x04ad }
            r0 = 0
        L_0x03a9:
            if (r0 == 0) goto L_0x0302
            int r12 = r0.flags     // Catch:{ all -> 0x04ad }
            r13 = 1
            r12 = r12 & r13
            if (r12 == 0) goto L_0x03b6
            r12 = 1
            r7.putLong(r9, r12)     // Catch:{ all -> 0x04ad }
        L_0x03b6:
            int r0 = r0.flags     // Catch:{ all -> 0x04ad }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0302
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04ad }
            goto L_0x0302
        L_0x03c3:
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x03ca
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04ad }
        L_0x03ca:
            com.google.android.gms.measurement.internal.zzar r0 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04ad }
            r14.<init>(r7)     // Catch:{ all -> 0x04ad }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04ad }
            r1.m10906H(r0, r2)     // Catch:{ all -> 0x04ad }
            goto L_0x043b
        L_0x03df:
            r5 = 1
            if (r7 != r5) goto L_0x043b
            com.google.android.gms.measurement.internal.zzkr r5 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04ad }
            java.lang.String r6 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04ad }
            java.lang.String r17 = "auto"
            r12 = r5
            r13 = r6
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04ad }
            r1.mo20518p(r5, r2)     // Catch:{ all -> 0x04ad }
            r21.m10912Y()     // Catch:{ all -> 0x04ad }
            r21.mo20508R()     // Catch:{ all -> 0x04ad }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x04ad }
            r5.<init>()     // Catch:{ all -> 0x04ad }
            r6 = 1
            r5.putLong(r4, r6)     // Catch:{ all -> 0x04ad }
            r5.putLong(r3, r6)     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zza()     // Catch:{ all -> 0x04ad }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzat.zzas     // Catch:{ all -> 0x04ad }
            boolean r3 = r3.zze(r4, r6)     // Catch:{ all -> 0x04ad }
            if (r3 == 0) goto L_0x041e
            r3 = 1
            r5.putLong(r8, r3)     // Catch:{ all -> 0x04ad }
            goto L_0x0420
        L_0x041e:
            r3 = 1
        L_0x0420:
            boolean r6 = r2.zzq     // Catch:{ all -> 0x04ad }
            if (r6 == 0) goto L_0x0427
            r5.putLong(r0, r3)     // Catch:{ all -> 0x04ad }
        L_0x0427:
            com.google.android.gms.measurement.internal.zzar r0 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04ad }
            r14.<init>(r5)     // Catch:{ all -> 0x04ad }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04ad }
            r1.m10906H(r0, r2)     // Catch:{ all -> 0x04ad }
        L_0x043b:
            com.google.android.gms.measurement.internal.zzfv r0 = r1.f18701j     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zza()     // Catch:{ all -> 0x04ad }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzat     // Catch:{ all -> 0x04ad }
            boolean r0 = r0.zze(r3, r4)     // Catch:{ all -> 0x04ad }
            if (r0 != 0) goto L_0x049e
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04ad }
            r0.<init>()     // Catch:{ all -> 0x04ad }
            r3 = 1
            r0.putLong(r8, r3)     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zza()     // Catch:{ all -> 0x04ad }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzat.zzas     // Catch:{ all -> 0x04ad }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x04ad }
            if (r3 == 0) goto L_0x046c
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04ad }
        L_0x046c:
            com.google.android.gms.measurement.internal.zzar r3 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04ad }
            r14.<init>(r0)     // Catch:{ all -> 0x04ad }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04ad }
            r1.m10906H(r3, r2)     // Catch:{ all -> 0x04ad }
            goto L_0x049e
        L_0x0481:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x04ad }
            if (r0 == 0) goto L_0x049e
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04ad }
            r0.<init>()     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.zzar r3 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04ad }
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04ad }
            r14.<init>(r0)     // Catch:{ all -> 0x04ad }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04ad }
            r1.m10906H(r3, r2)     // Catch:{ all -> 0x04ad }
        L_0x049e:
            com.google.android.gms.measurement.internal.c r0 = r21.zze()     // Catch:{ all -> 0x04ad }
            r0.mo19845b()     // Catch:{ all -> 0x04ad }
            com.google.android.gms.measurement.internal.c r0 = r21.zze()
            r0.mo19850d0()
            return
        L_0x04ad:
            r0 = move-exception
            com.google.android.gms.measurement.internal.c r2 = r21.zze()
            r2.mo19850d0()
            goto L_0x04b7
        L_0x04b6:
            throw r0
        L_0x04b7:
            goto L_0x04b6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.mo20503K(com.google.android.gms.measurement.internal.zzn):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: L */
    public final void mo20504L(zzw zzw) {
        zzn E = m10903E(zzw.zza);
        if (E != null) {
            mo20505M(zzw, E);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: M */
    public final void mo20505M(zzw zzw, zzn zzn) {
        Preconditions.checkNotNull(zzw);
        Preconditions.checkNotEmpty(zzw.zza);
        Preconditions.checkNotNull(zzw.zzc);
        Preconditions.checkNotEmpty(zzw.zzc.zza);
        m10912Y();
        mo20508R();
        if (m10909Q(zzn)) {
            if (!zzn.zzh) {
                mo20506N(zzn);
                return;
            }
            zze().zze();
            try {
                mo20506N(zzn);
                zzw V = zze().mo19839V(zzw.zza, zzw.zzc.zza);
                if (V != null) {
                    this.f18701j.zzq().zzv().zza("Removing conditional user property", zzw.zza, this.f18701j.zzi().zzc(zzw.zzc.zza));
                    zze().mo19841X(zzw.zza, zzw.zzc.zza);
                    if (V.zze) {
                        zze().mo19836R(zzw.zza, zzw.zzc.zza);
                    }
                    zzar zzar = zzw.zzk;
                    if (zzar != null) {
                        Bundle bundle = null;
                        zzam zzam = zzar.zzb;
                        if (zzam != null) {
                            bundle = zzam.zzb();
                        }
                        Bundle bundle2 = bundle;
                        zzkw zzh = this.f18701j.zzh();
                        String str = zzw.zza;
                        zzar zzar2 = zzw.zzk;
                        m10908O(zzh.mo20570i(str, zzar2.zza, bundle2, V.zzb, zzar2.zzd, true, false, zzlq.zzb() && this.f18701j.zza().zza(zzat.zzcl)), zzn);
                    }
                } else {
                    this.f18701j.zzq().zzh().zza("Conditional user property doesn't exist", zzer.zza(zzw.zza), this.f18701j.zzi().zzc(zzw.zzc.zza));
                }
                zze().mo19845b();
            } finally {
                zze().mo19850d0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: N */
    public final C3013i3 mo20506N(zzn zzn) {
        String str;
        m10912Y();
        mo20508R();
        Preconditions.checkNotNull(zzn);
        Preconditions.checkNotEmpty(zzn.zza);
        C3013i3 P = zze().mo19834P(zzn.zza);
        zzad zzad = zzad.zza;
        if (zzmj.zzb() && this.f18701j.zza().zza(zzat.zzci)) {
            zzad = mo20513b(zzn.zza).zzb(zzad.zza(zzn.zzw));
        }
        if (!zzmj.zzb() || !this.f18701j.zza().zza(zzat.zzci) || zzad.zzc()) {
            str = this.f18700i.zza(zzn.zza);
        } else {
            str = "";
        }
        if (!zzng.zzb() || !this.f18701j.zza().zza(zzat.zzbn)) {
            return m10916c(zzn, P, str);
        }
        if (P == null) {
            P = new C3013i3(this.f18701j, zzn.zza);
            if (!zzmj.zzb() || !this.f18701j.zza().zza(zzat.zzci)) {
                P.mo19967c(m10915a0());
                P.mo19939C(str);
            } else {
                if (zzad.zze()) {
                    P.mo19967c(m10918e(zzad));
                }
                if (zzad.zzc()) {
                    P.mo19939C(str);
                }
            }
        } else if ((!zzmj.zzb() || !this.f18701j.zza().zza(zzat.zzci) || zzad.zzc()) && !str.equals(P.mo19946J())) {
            P.mo19939C(str);
            if (!zzmj.zzb() || !this.f18701j.zza().zza(zzat.zzci)) {
                P.mo19967c(m10915a0());
            } else {
                P.mo19967c(m10918e(zzad));
            }
        }
        P.mo19993r(zzn.zzb);
        P.mo19997v(zzn.zzr);
        if (zznt.zzb() && this.f18701j.zza().zze(P.mo19995t(), zzat.zzbi)) {
            P.mo20001z(zzn.zzv);
        }
        if (!TextUtils.isEmpty(zzn.zzk)) {
            P.mo19942F(zzn.zzk);
        }
        long j = zzn.zze;
        if (j != 0) {
            P.mo20000y(j);
        }
        if (!TextUtils.isEmpty(zzn.zzc)) {
            P.mo19945I(zzn.zzc);
        }
        P.mo19996u(zzn.zzj);
        String str2 = zzn.zzd;
        if (str2 != null) {
            P.mo19948L(str2);
        }
        P.mo19938B(zzn.zzf);
        P.mo19971e(zzn.zzh);
        if (!TextUtils.isEmpty(zzn.zzg)) {
            P.mo19951O(zzn.zzg);
        }
        if (!this.f18701j.zza().zza(zzat.zzbx)) {
            P.mo19968c0(zzn.zzl);
        }
        P.mo19994s(zzn.zzo);
        P.mo19998w(zzn.zzp);
        P.mo19965b(zzn.zzs);
        P.mo19941E(zzn.zzt);
        if (P.mo19973f()) {
            zze().mo19872v(P);
        }
        return P;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: P */
    public final String mo20507P(zzn zzn) {
        try {
            return (String) this.f18701j.zzp().zza(new C3098r7(this, zzn)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.f18701j.zzq().zze().zza("Failed to get app instance id. appId", zzer.zza(zzn.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: R */
    public final void mo20508R() {
        if (!this.f18702k) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:136|137) */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        r1.f18701j.zzq().zze().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzer.zza(r5), r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:136:0x0371 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x022e A[Catch:{ all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02c1 A[Catch:{ all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02d2 A[Catch:{ all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02f6 A[Catch:{ MalformedURLException -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02f8 A[Catch:{ MalformedURLException -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0300 A[Catch:{ MalformedURLException -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0310 A[Catch:{ MalformedURLException -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0328 A[Catch:{ MalformedURLException -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0227 A[Catch:{ all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0228 A[Catch:{ all -> 0x03ad }] */
    @androidx.annotation.WorkerThread
    /* renamed from: S */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo20509S() {
        /*
            r17 = this;
            r1 = r17
            r17.m10912Y()
            r17.mo20508R()
            r0 = 1
            r1.f18710s = r0
            r2 = 0
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzio r3 = r3.zzv()     // Catch:{ all -> 0x03ad }
            java.lang.Boolean r3 = r3.mo20459h()     // Catch:{ all -> 0x03ad }
            if (r3 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.zzfv r0 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzq()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzh()     // Catch:{ all -> 0x03ad }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
            r0.zza(r3)     // Catch:{ all -> 0x03ad }
            r1.f18710s = r2
            r17.m10901C()
            return
        L_0x002d:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x0048
            com.google.android.gms.measurement.internal.zzfv r0 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzq()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zze()     // Catch:{ all -> 0x03ad }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            r0.zza(r3)     // Catch:{ all -> 0x03ad }
            r1.f18710s = r2
            r17.m10901C()
            return
        L_0x0048:
            long r3 = r1.f18704m     // Catch:{ all -> 0x03ad }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0059
            r17.m10900B()     // Catch:{ all -> 0x03ad }
            r1.f18710s = r2
            r17.m10901C()
            return
        L_0x0059:
            r17.m10912Y()     // Catch:{ all -> 0x03ad }
            java.util.List<java.lang.Long> r3 = r1.f18713v     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x0062
            r3 = 1
            goto L_0x0063
        L_0x0062:
            r3 = 0
        L_0x0063:
            if (r3 == 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzfv r0 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzq()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzw()     // Catch:{ all -> 0x03ad }
            java.lang.String r3 = "Uploading requested multiple times"
            r0.zza(r3)     // Catch:{ all -> 0x03ad }
            r1.f18710s = r2
            r17.m10901C()
            return
        L_0x007a:
            com.google.android.gms.measurement.internal.zzeu r3 = r17.zzd()     // Catch:{ all -> 0x03ad }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x03ad }
            if (r3 != 0) goto L_0x009c
            com.google.android.gms.measurement.internal.zzfv r0 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzq()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzw()     // Catch:{ all -> 0x03ad }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.zza(r3)     // Catch:{ all -> 0x03ad }
            r17.m10900B()     // Catch:{ all -> 0x03ad }
            r1.f18710s = r2
            r17.m10901C()
            return
        L_0x009c:
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.common.util.Clock r3 = r3.zzl()     // Catch:{ all -> 0x03ad }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzat.zzap     // Catch:{ all -> 0x03ad }
            r9 = 0
            int r7 = r7.zzb(r9, r8)     // Catch:{ all -> 0x03ad }
            long r10 = com.google.android.gms.measurement.internal.zzy.zzj()     // Catch:{ all -> 0x03ad }
            long r10 = r3 - r10
            r8 = 0
        L_0x00ba:
            if (r8 >= r7) goto L_0x00c5
            boolean r12 = r1.m10927z(r9, r10)     // Catch:{ all -> 0x03ad }
            if (r12 == 0) goto L_0x00c5
            int r8 = r8 + 1
            goto L_0x00ba
        L_0x00c5:
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.m3 r7 = r7.zzb()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzfh r7 = r7.f18228d     // Catch:{ all -> 0x03ad }
            long r7 = r7.zza()     // Catch:{ all -> 0x03ad }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.zzfv r5 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzq()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzv()     // Catch:{ all -> 0x03ad }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r3 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x03ad }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x03ad }
            r5.zza(r6, r7)     // Catch:{ all -> 0x03ad }
        L_0x00ee:
            com.google.android.gms.measurement.internal.c r5 = r17.zze()     // Catch:{ all -> 0x03ad }
            java.lang.String r5 = r5.mo19849d()     // Catch:{ all -> 0x03ad }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x03ad }
            r7 = -1
            if (r6 != 0) goto L_0x0385
            long r10 = r1.f18715x     // Catch:{ all -> 0x03ad }
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x010e
            com.google.android.gms.measurement.internal.c r6 = r17.zze()     // Catch:{ all -> 0x03ad }
            long r6 = r6.mo19865m0()     // Catch:{ all -> 0x03ad }
            r1.f18715x = r6     // Catch:{ all -> 0x03ad }
        L_0x010e:
            com.google.android.gms.measurement.internal.zzfv r6 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zza()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzat.zzf     // Catch:{ all -> 0x03ad }
            int r6 = r6.zzb(r5, r7)     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzat.zzg     // Catch:{ all -> 0x03ad }
            int r7 = r7.zzb(r5, r8)     // Catch:{ all -> 0x03ad }
            int r7 = java.lang.Math.max(r2, r7)     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.c r8 = r17.zze()     // Catch:{ all -> 0x03ad }
            java.util.List r6 = r8.mo19868q(r5, r6, r7)     // Catch:{ all -> 0x03ad }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x03ad }
            if (r7 != 0) goto L_0x03a7
            boolean r7 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x03ad }
            if (r7 == 0) goto L_0x0156
            com.google.android.gms.measurement.internal.zzfv r7 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zza()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x03ad }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r8)     // Catch:{ all -> 0x03ad }
            if (r7 == 0) goto L_0x0156
            com.google.android.gms.measurement.internal.zzad r7 = r1.mo20513b(r5)     // Catch:{ all -> 0x03ad }
            boolean r7 = r7.zzc()     // Catch:{ all -> 0x03ad }
            if (r7 == 0) goto L_0x01a9
        L_0x0156:
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x03ad }
        L_0x015a:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x03ad }
            if (r8 == 0) goto L_0x0179
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x03ad }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x03ad }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzcd$zzg r8 = (com.google.android.gms.internal.measurement.zzcd.zzg) r8     // Catch:{ all -> 0x03ad }
            java.lang.String r10 = r8.zzad()     // Catch:{ all -> 0x03ad }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x03ad }
            if (r10 != 0) goto L_0x015a
            java.lang.String r7 = r8.zzad()     // Catch:{ all -> 0x03ad }
            goto L_0x017a
        L_0x0179:
            r7 = r9
        L_0x017a:
            if (r7 == 0) goto L_0x01a9
            r8 = 0
        L_0x017d:
            int r10 = r6.size()     // Catch:{ all -> 0x03ad }
            if (r8 >= r10) goto L_0x01a9
            java.lang.Object r10 = r6.get(r8)     // Catch:{ all -> 0x03ad }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x03ad }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = (com.google.android.gms.internal.measurement.zzcd.zzg) r10     // Catch:{ all -> 0x03ad }
            java.lang.String r11 = r10.zzad()     // Catch:{ all -> 0x03ad }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x03ad }
            if (r11 != 0) goto L_0x01a6
            java.lang.String r10 = r10.zzad()     // Catch:{ all -> 0x03ad }
            boolean r10 = r10.equals(r7)     // Catch:{ all -> 0x03ad }
            if (r10 != 0) goto L_0x01a6
            java.util.List r6 = r6.subList(r2, r8)     // Catch:{ all -> 0x03ad }
            goto L_0x01a9
        L_0x01a6:
            int r8 = r8 + 1
            goto L_0x017d
        L_0x01a9:
            com.google.android.gms.internal.measurement.zzcd$zzf$zza r7 = com.google.android.gms.internal.measurement.zzcd.zzf.zzb()     // Catch:{ all -> 0x03ad }
            int r8 = r6.size()     // Catch:{ all -> 0x03ad }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x03ad }
            int r11 = r6.size()     // Catch:{ all -> 0x03ad }
            r10.<init>(r11)     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzy r11 = r11.zza()     // Catch:{ all -> 0x03ad }
            boolean r11 = r11.zzh(r5)     // Catch:{ all -> 0x03ad }
            if (r11 == 0) goto L_0x01e6
            boolean r11 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x03ad }
            if (r11 == 0) goto L_0x01e4
            com.google.android.gms.measurement.internal.zzfv r11 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzy r11 = r11.zza()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x03ad }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r12)     // Catch:{ all -> 0x03ad }
            if (r11 == 0) goto L_0x01e4
            com.google.android.gms.measurement.internal.zzad r11 = r1.mo20513b(r5)     // Catch:{ all -> 0x03ad }
            boolean r11 = r11.zzc()     // Catch:{ all -> 0x03ad }
            if (r11 == 0) goto L_0x01e6
        L_0x01e4:
            r11 = 1
            goto L_0x01e7
        L_0x01e6:
            r11 = 0
        L_0x01e7:
            boolean r12 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x03ad }
            if (r12 == 0) goto L_0x0208
            com.google.android.gms.measurement.internal.zzfv r12 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzy r12 = r12.zza()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x03ad }
            boolean r12 = r12.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r13)     // Catch:{ all -> 0x03ad }
            if (r12 == 0) goto L_0x0208
            com.google.android.gms.measurement.internal.zzad r12 = r1.mo20513b(r5)     // Catch:{ all -> 0x03ad }
            boolean r12 = r12.zzc()     // Catch:{ all -> 0x03ad }
            if (r12 == 0) goto L_0x0206
            goto L_0x0208
        L_0x0206:
            r12 = 0
            goto L_0x0209
        L_0x0208:
            r12 = 1
        L_0x0209:
            boolean r13 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x03ad }
            if (r13 == 0) goto L_0x022a
            com.google.android.gms.measurement.internal.zzfv r13 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzy r13 = r13.zza()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x03ad }
            boolean r13 = r13.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r14)     // Catch:{ all -> 0x03ad }
            if (r13 == 0) goto L_0x022a
            com.google.android.gms.measurement.internal.zzad r13 = r1.mo20513b(r5)     // Catch:{ all -> 0x03ad }
            boolean r13 = r13.zze()     // Catch:{ all -> 0x03ad }
            if (r13 == 0) goto L_0x0228
            goto L_0x022a
        L_0x0228:
            r13 = 0
            goto L_0x022b
        L_0x022a:
            r13 = 1
        L_0x022b:
            r14 = 0
        L_0x022c:
            if (r14 >= r8) goto L_0x02b2
            java.lang.Object r15 = r6.get(r14)     // Catch:{ all -> 0x03ad }
            android.util.Pair r15 = (android.util.Pair) r15     // Catch:{ all -> 0x03ad }
            java.lang.Object r15 = r15.first     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzcd$zzg r15 = (com.google.android.gms.internal.measurement.zzcd.zzg) r15     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzhz$zza r15 = r15.zzbn()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r15 = (com.google.android.gms.internal.measurement.zzcd.zzg.zza) r15     // Catch:{ all -> 0x03ad }
            java.lang.Object r16 = r6.get(r14)     // Catch:{ all -> 0x03ad }
            r0 = r16
            android.util.Pair r0 = (android.util.Pair) r0     // Catch:{ all -> 0x03ad }
            java.lang.Object r0 = r0.second     // Catch:{ all -> 0x03ad }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x03ad }
            r10.add(r0)     // Catch:{ all -> 0x03ad }
            r16 = r10
            r9 = 32053(0x7d35, double:1.58363E-319)
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r9 = r15.zzg((long) r9)     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r9 = r9.zza((long) r3)     // Catch:{ all -> 0x03ad }
            r9.zzb((boolean) r2)     // Catch:{ all -> 0x03ad }
            if (r11 != 0) goto L_0x0261
            r15.zzr()     // Catch:{ all -> 0x03ad }
        L_0x0261:
            boolean r9 = com.google.android.gms.internal.measurement.zzmj.zzb()     // Catch:{ all -> 0x03ad }
            if (r9 == 0) goto L_0x0282
            com.google.android.gms.measurement.internal.zzfv r9 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zza()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x03ad }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r10)     // Catch:{ all -> 0x03ad }
            if (r9 == 0) goto L_0x0282
            if (r12 != 0) goto L_0x027d
            r15.zzk()     // Catch:{ all -> 0x03ad }
            r15.zzl()     // Catch:{ all -> 0x03ad }
        L_0x027d:
            if (r13 != 0) goto L_0x0282
            r15.zzm()     // Catch:{ all -> 0x03ad }
        L_0x0282:
            com.google.android.gms.measurement.internal.zzfv r9 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zza()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzat.zzaw     // Catch:{ all -> 0x03ad }
            boolean r9 = r9.zze(r5, r10)     // Catch:{ all -> 0x03ad }
            if (r9 == 0) goto L_0x02a7
            com.google.android.gms.internal.measurement.zzjh r9 = r15.zzz()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzhz r9 = (com.google.android.gms.internal.measurement.zzhz) r9     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzcd$zzg r9 = (com.google.android.gms.internal.measurement.zzcd.zzg) r9     // Catch:{ all -> 0x03ad }
            byte[] r9 = r9.zzbk()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzks r10 = r17.zzh()     // Catch:{ all -> 0x03ad }
            long r9 = r10.mo20542c(r9)     // Catch:{ all -> 0x03ad }
            r15.zzl((long) r9)     // Catch:{ all -> 0x03ad }
        L_0x02a7:
            r7.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r15)     // Catch:{ all -> 0x03ad }
            int r14 = r14 + 1
            r10 = r16
            r0 = 1
            r9 = 0
            goto L_0x022c
        L_0x02b2:
            r16 = r10
            com.google.android.gms.measurement.internal.zzfv r6 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()     // Catch:{ all -> 0x03ad }
            r9 = 2
            boolean r6 = r6.zza((int) r9)     // Catch:{ all -> 0x03ad }
            if (r6 == 0) goto L_0x02d2
            com.google.android.gms.measurement.internal.zzks r6 = r17.zzh()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzjh r9 = r7.zzz()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzhz r9 = (com.google.android.gms.internal.measurement.zzhz) r9     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzcd$zzf r9 = (com.google.android.gms.internal.measurement.zzcd.zzf) r9     // Catch:{ all -> 0x03ad }
            java.lang.String r6 = r6.mo20547j(r9)     // Catch:{ all -> 0x03ad }
            goto L_0x02d3
        L_0x02d2:
            r6 = 0
        L_0x02d3:
            r17.zzh()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzjh r9 = r7.zzz()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzhz r9 = (com.google.android.gms.internal.measurement.zzhz) r9     // Catch:{ all -> 0x03ad }
            com.google.android.gms.internal.measurement.zzcd$zzf r9 = (com.google.android.gms.internal.measurement.zzcd.zzf) r9     // Catch:{ all -> 0x03ad }
            byte[] r14 = r9.zzbk()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzeg<java.lang.String> r9 = com.google.android.gms.measurement.internal.zzat.zzp     // Catch:{ all -> 0x03ad }
            r0 = 0
            java.lang.Object r0 = r9.zza(r0)     // Catch:{ all -> 0x03ad }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x03ad }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0371 }
            r13.<init>(r0)     // Catch:{ MalformedURLException -> 0x0371 }
            boolean r9 = r16.isEmpty()     // Catch:{ MalformedURLException -> 0x0371 }
            if (r9 != 0) goto L_0x02f8
            r9 = 1
            goto L_0x02f9
        L_0x02f8:
            r9 = 0
        L_0x02f9:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r9)     // Catch:{ MalformedURLException -> 0x0371 }
            java.util.List<java.lang.Long> r9 = r1.f18713v     // Catch:{ MalformedURLException -> 0x0371 }
            if (r9 == 0) goto L_0x0310
            com.google.android.gms.measurement.internal.zzfv r9 = r1.f18701j     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzq()     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.measurement.internal.zzet r9 = r9.zze()     // Catch:{ MalformedURLException -> 0x0371 }
            java.lang.String r10 = "Set uploading progress before finishing the previous upload"
            r9.zza(r10)     // Catch:{ MalformedURLException -> 0x0371 }
            goto L_0x0319
        L_0x0310:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x0371 }
            r10 = r16
            r9.<init>(r10)     // Catch:{ MalformedURLException -> 0x0371 }
            r1.f18713v = r9     // Catch:{ MalformedURLException -> 0x0371 }
        L_0x0319:
            com.google.android.gms.measurement.internal.zzfv r9 = r1.f18701j     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.measurement.internal.m3 r9 = r9.zzb()     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.measurement.internal.zzfh r9 = r9.f18229e     // Catch:{ MalformedURLException -> 0x0371 }
            r9.zza(r3)     // Catch:{ MalformedURLException -> 0x0371 }
            java.lang.String r3 = "?"
            if (r8 <= 0) goto L_0x0330
            com.google.android.gms.internal.measurement.zzcd$zzg r3 = r7.zza((int) r2)     // Catch:{ MalformedURLException -> 0x0371 }
            java.lang.String r3 = r3.zzx()     // Catch:{ MalformedURLException -> 0x0371 }
        L_0x0330:
            com.google.android.gms.measurement.internal.zzfv r4 = r1.f18701j     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzq()     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzw()     // Catch:{ MalformedURLException -> 0x0371 }
            java.lang.String r7 = "Uploading data. app, uncompressed size, data"
            int r8 = r14.length     // Catch:{ MalformedURLException -> 0x0371 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x0371 }
            r4.zza(r7, r3, r8, r6)     // Catch:{ MalformedURLException -> 0x0371 }
            r3 = 1
            r1.f18709r = r3     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.measurement.internal.zzeu r11 = r17.zzd()     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.measurement.internal.p7 r3 = new com.google.android.gms.measurement.internal.p7     // Catch:{ MalformedURLException -> 0x0371 }
            r3.<init>(r1, r5)     // Catch:{ MalformedURLException -> 0x0371 }
            r11.zzc()     // Catch:{ MalformedURLException -> 0x0371 }
            r11.zzaj()     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.measurement.internal.zzfo r4 = r11.zzp()     // Catch:{ MalformedURLException -> 0x0371 }
            com.google.android.gms.measurement.internal.g3 r6 = new com.google.android.gms.measurement.internal.g3     // Catch:{ MalformedURLException -> 0x0371 }
            r15 = 0
            r10 = r6
            r12 = r5
            r16 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x0371 }
            r4.zzc(r6)     // Catch:{ MalformedURLException -> 0x0371 }
            goto L_0x03a7
        L_0x0371:
            com.google.android.gms.measurement.internal.zzfv r3 = r1.f18701j     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzq()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zze()     // Catch:{ all -> 0x03ad }
            java.lang.String r4 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r5)     // Catch:{ all -> 0x03ad }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x03ad }
            goto L_0x03a7
        L_0x0385:
            r1.f18715x = r7     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.c r0 = r17.zze()     // Catch:{ all -> 0x03ad }
            long r5 = com.google.android.gms.measurement.internal.zzy.zzj()     // Catch:{ all -> 0x03ad }
            long r3 = r3 - r5
            java.lang.String r0 = r0.mo19866n(r3)     // Catch:{ all -> 0x03ad }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x03ad }
            if (r3 != 0) goto L_0x03a7
            com.google.android.gms.measurement.internal.c r3 = r17.zze()     // Catch:{ all -> 0x03ad }
            com.google.android.gms.measurement.internal.i3 r0 = r3.mo19834P(r0)     // Catch:{ all -> 0x03ad }
            if (r0 == 0) goto L_0x03a7
            r1.m10922l(r0)     // Catch:{ all -> 0x03ad }
        L_0x03a7:
            r1.f18710s = r2
            r17.m10901C()
            return
        L_0x03ad:
            r0 = move-exception
            r1.f18710s = r2
            r17.m10901C()
            goto L_0x03b5
        L_0x03b4:
            throw r0
        L_0x03b5:
            goto L_0x03b4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.mo20509S():void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    /* renamed from: T */
    public final void mo20510T() {
        m10912Y();
        mo20508R();
        if (!this.f18703l) {
            this.f18703l = true;
            if (m10902D()) {
                int a = m10914a(this.f18712u);
                int f = this.f18701j.zzx().mo20278f();
                m10912Y();
                if (a > f) {
                    this.f18701j.zzq().zze().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a), Integer.valueOf(f));
                } else if (a >= f) {
                } else {
                    if (m10925x(f, this.f18712u)) {
                        this.f18701j.zzq().zzw().zza("Storage version upgraded. Previous, current version", Integer.valueOf(a), Integer.valueOf(f));
                    } else {
                        this.f18701j.zzq().zze().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(a), Integer.valueOf(f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: U */
    public final void mo20511U() {
        this.f18707p++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: V */
    public final zzfv mo20512V() {
        return this.f18701j;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: b */
    public final zzad mo20513b(String str) {
        zzad zzad = zzad.zza;
        if (!zzmj.zzb() || !this.f18701j.zza().zza(zzat.zzci)) {
            return zzad;
        }
        m10912Y();
        mo20508R();
        zzad zzad2 = this.f18716y.get(str);
        if (zzad2 != null) {
            return zzad2;
        }
        zzad h0 = zze().mo19857h0(str);
        if (h0 != null) {
            zzad = h0;
        }
        mo20524v(str, zzad);
        return zzad;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    /* renamed from: f */
    public final void mo20514f(int i, Throwable th, byte[] bArr, String str) {
        C2950c zze;
        m10912Y();
        mo20508R();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.f18709r = false;
                m10901C();
                throw th2;
            }
        }
        List<Long> list = this.f18713v;
        this.f18713v = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.f18701j.zzb().f18228d.zza(this.f18701j.zzl().currentTimeMillis());
                this.f18701j.zzb().f18229e.zza(0);
                m10900B();
                this.f18701j.zzq().zzw().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zze();
                try {
                    for (Long next : list) {
                        try {
                            zze = zze();
                            long longValue = next.longValue();
                            zze.zzc();
                            zze.zzaj();
                            if (zze.mo19847c().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zze.zzq().zze().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            List<Long> list2 = this.f18714w;
                            if (list2 == null || !list2.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zze().mo19845b();
                    zze().mo19850d0();
                    this.f18714w = null;
                    if (!zzd().zze() || !m10899A()) {
                        this.f18715x = -1;
                        m10900B();
                    } else {
                        mo20509S();
                    }
                    this.f18704m = 0;
                } catch (Throwable th3) {
                    zze().mo19850d0();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.f18701j.zzq().zze().zza("Database error while trying to delete uploaded bundles", e3);
                this.f18704m = this.f18701j.zzl().elapsedRealtime();
                this.f18701j.zzq().zzw().zza("Disable upload, time", Long.valueOf(this.f18704m));
            }
        } else {
            this.f18701j.zzq().zzw().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.f18701j.zzb().f18229e.zza(this.f18701j.zzl().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.f18701j.zzb().f18230f.zza(this.f18701j.zzl().currentTimeMillis());
            }
            zze().mo19874x(list);
            m10900B();
        }
        this.f18709r = false;
        m10901C();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: j */
    public final void mo20515j(zzar zzar, zzn zzn) {
        List<zzw> list;
        List<zzw> list2;
        List<zzw> list3;
        zzar zzar2 = zzar;
        zzn zzn2 = zzn;
        Preconditions.checkNotNull(zzn);
        Preconditions.checkNotEmpty(zzn2.zza);
        m10912Y();
        mo20508R();
        String str = zzn2.zza;
        long j = zzar2.zzd;
        zzh();
        if (zzks.m10970y(zzar, zzn)) {
            if (!zzn2.zzh) {
                mo20506N(zzn2);
                return;
            }
            List<String> list4 = zzn2.zzu;
            if (list4 != null) {
                if (list4.contains(zzar2.zza)) {
                    Bundle zzb = zzar2.zzb.zzb();
                    zzb.putLong("ga_safelisted", 1);
                    zzar2 = new zzar(zzar2.zza, new zzam(zzb), zzar2.zzc, zzar2.zzd);
                } else {
                    this.f18701j.zzq().zzv().zza("Dropping non-safelisted event. appId, event name, origin", str, zzar2.zza, zzar2.zzc);
                    return;
                }
            }
            zze().zze();
            try {
                C2950c zze = zze();
                Preconditions.checkNotEmpty(str);
                zze.zzc();
                zze.zzaj();
                if (j < 0) {
                    zze.zzq().zzh().zza("Invalid time querying timed out conditional properties", zzer.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze.mo19870s("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzw next : list) {
                    if (next != null) {
                        this.f18701j.zzq().zzw().zza("User property timed out", next.zza, this.f18701j.zzi().zzc(next.zzc.zza), next.zzc.zza());
                        if (next.zzg != null) {
                            m10908O(new zzar(next.zzg, j), zzn2);
                        }
                        zze().mo19841X(str, next.zzc.zza);
                    }
                }
                C2950c zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzc();
                zze2.zzaj();
                if (j < 0) {
                    zze2.zzq().zzh().zza("Invalid time querying expired conditional properties", zzer.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze2.mo19870s("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzw next2 : list2) {
                    if (next2 != null) {
                        this.f18701j.zzq().zzw().zza("User property expired", next2.zza, this.f18701j.zzi().zzc(next2.zzc.zza), next2.zzc.zza());
                        zze().mo19836R(str, next2.zzc.zza);
                        zzar zzar3 = next2.zzk;
                        if (zzar3 != null) {
                            arrayList.add(zzar3);
                        }
                        zze().mo19841X(str, next2.zzc.zza);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    m10908O(new zzar((zzar) obj, j), zzn2);
                }
                C2950c zze3 = zze();
                String str2 = zzar2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze3.zzc();
                zze3.zzaj();
                if (j < 0) {
                    zze3.zzq().zzh().zza("Invalid time querying triggered conditional properties", zzer.zza(str), zze3.zzn().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze3.mo19870s("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzw next3 : list3) {
                    if (next3 != null) {
                        zzkr zzkr = next3.zzc;
                        C3134v7 v7Var = r4;
                        C3134v7 v7Var2 = new C3134v7(next3.zza, next3.zzb, zzkr.zza, j, zzkr.zza());
                        if (zze().mo19831A(v7Var)) {
                            this.f18701j.zzq().zzw().zza("User property triggered", next3.zza, this.f18701j.zzi().zzc(v7Var.f18417c), v7Var.f18419e);
                        } else {
                            this.f18701j.zzq().zze().zza("Too many active user properties, ignoring", zzer.zza(next3.zza), this.f18701j.zzi().zzc(v7Var.f18417c), v7Var.f18419e);
                        }
                        zzar zzar4 = next3.zzi;
                        if (zzar4 != null) {
                            arrayList2.add(zzar4);
                        }
                        next3.zzc = new zzkr(v7Var);
                        next3.zze = true;
                        zze().zza(next3);
                    }
                }
                m10908O(zzar2, zzn2);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    m10908O(new zzar((zzar) obj2, j), zzn2);
                }
                zze().mo19845b();
            } finally {
                zze().mo19850d0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00df  */
    @androidx.annotation.WorkerThread
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo20516k(com.google.android.gms.measurement.internal.zzar r36, java.lang.String r37) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r3 = r37
            com.google.android.gms.measurement.internal.c r2 = r35.zze()
            com.google.android.gms.measurement.internal.i3 r2 = r2.mo19834P(r3)
            if (r2 == 0) goto L_0x0112
            java.lang.String r4 = r2.mo19956T()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x001c
            goto L_0x0112
        L_0x001c:
            java.lang.Boolean r4 = r0.m10904F(r2)
            if (r4 != 0) goto L_0x0040
            java.lang.String r4 = r1.zza
            java.lang.String r5 = "_ui"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfv r4 = r0.f18701j
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzh()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r37)
            java.lang.String r6 = "Could not find package. appId"
            r4.zza(r6, r5)
            goto L_0x005a
        L_0x0040:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zze()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r37)
            java.lang.String r3 = "App version does not match; dropping event. appId"
            r1.zza(r3, r2)
            return
        L_0x005a:
            com.google.android.gms.measurement.internal.zzn r15 = new com.google.android.gms.measurement.internal.zzn
            java.lang.String r4 = r2.mo19937A()
            java.lang.String r5 = r2.mo19956T()
            long r6 = r2.mo19958V()
            java.lang.String r8 = r2.mo19960X()
            long r9 = r2.mo19962Z()
            long r11 = r2.mo19966b0()
            boolean r14 = r2.mo19972e0()
            r16 = 0
            java.lang.String r17 = r2.mo19949M()
            long r18 = r2.mo19983k()
            r20 = 0
            r22 = 0
            boolean r23 = r2.mo19985l()
            boolean r24 = r2.mo19987m()
            r25 = 0
            java.lang.String r26 = r2.mo19940D()
            java.lang.Boolean r27 = r2.mo19989n()
            long r28 = r2.mo19970d0()
            java.util.List r30 = r2.mo19990o()
            boolean r31 = com.google.android.gms.internal.measurement.zznt.zzb()
            if (r31 == 0) goto L_0x00bf
            com.google.android.gms.measurement.internal.zzfv r13 = r0.f18701j
            com.google.android.gms.measurement.internal.zzy r13 = r13.zza()
            java.lang.String r1 = r2.mo19995t()
            r32 = r14
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzat.zzbi
            boolean r1 = r13.zze(r1, r14)
            if (r1 == 0) goto L_0x00c1
            java.lang.String r1 = r2.mo19943G()
            goto L_0x00c2
        L_0x00bf:
            r32 = r14
        L_0x00c1:
            r1 = 0
        L_0x00c2:
            boolean r2 = com.google.android.gms.internal.measurement.zzmj.zzb()
            if (r2 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzfv r2 = r0.f18701j
            com.google.android.gms.measurement.internal.zzy r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzat.zzci
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r13)
            if (r2 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzad r2 = r0.mo20513b(r3)
            java.lang.String r2 = r2.zza()
            goto L_0x00e1
        L_0x00df:
            java.lang.String r2 = ""
        L_0x00e1:
            r33 = r2
            r2 = r15
            r3 = r37
            r13 = 0
            r14 = r32
            r34 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r19 = r20
            r21 = r22
            r22 = r23
            r23 = r24
            r24 = r25
            r25 = r26
            r26 = r27
            r27 = r28
            r29 = r30
            r30 = r1
            r31 = r33
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (long) r19, (int) r21, (boolean) r22, (boolean) r23, (boolean) r24, (java.lang.String) r25, (java.lang.Boolean) r26, (long) r27, (java.util.List<java.lang.String>) r29, (java.lang.String) r30, (java.lang.String) r31)
            r1 = r36
            r2 = r34
            r0.m10906H(r1, r2)
            return
        L_0x0112:
            com.google.android.gms.measurement.internal.zzfv r1 = r0.f18701j
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzv()
            java.lang.String r2 = "No app data available; dropping event"
            r1.zza(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.mo20516k(com.google.android.gms.measurement.internal.zzar, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final void mo20517n(C3071o7 o7Var) {
        this.f18706o++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: p */
    public final void mo20518p(zzkr zzkr, zzn zzn) {
        m10912Y();
        mo20508R();
        if (m10909Q(zzn)) {
            if (!zzn.zzh) {
                mo20506N(zzn);
                return;
            }
            int I = this.f18701j.zzh().mo20558I(zzkr.zza);
            if (I != 0) {
                this.f18701j.zzh();
                String zza = zzkw.zza(zzkr.zza, 24, true);
                String str = zzkr.zza;
                this.f18701j.zzh().mo20575p(this.f18717z, zzn.zza, I, "_ev", zza, str != null ? str.length() : 0);
                return;
            }
            int J = this.f18701j.zzh().mo20559J(zzkr.zza, zzkr.zza());
            if (J != 0) {
                this.f18701j.zzh();
                String zza2 = zzkw.zza(zzkr.zza, 24, true);
                Object zza3 = zzkr.zza();
                this.f18701j.zzh().mo20575p(this.f18717z, zzn.zza, J, "_ev", zza2, (zza3 == null || (!(zza3 instanceof String) && !(zza3 instanceof CharSequence))) ? 0 : String.valueOf(zza3).length());
                return;
            }
            Object O = this.f18701j.zzh().mo20561O(zzkr.zza, zzkr.zza());
            if (O != null) {
                if ("_sid".equals(zzkr.zza)) {
                    long j = zzkr.zzb;
                    String str2 = zzkr.zze;
                    long j2 = 0;
                    C3134v7 U = zze().mo19838U(zzn.zza, "_sno");
                    if (U != null) {
                        Object obj = U.f18419e;
                        if (obj instanceof Long) {
                            j2 = ((Long) obj).longValue();
                            mo20518p(new zzkr("_sno", j, Long.valueOf(j2 + 1), str2), zzn);
                        }
                    }
                    if (U != null) {
                        this.f18701j.zzq().zzh().zza("Retrieved last session number from database does not contain a valid (long) value", U.f18419e);
                    }
                    C3000h k = zze().mo19862k(zzn.zza, "_s");
                    if (k != null) {
                        j2 = k.f18095c;
                        this.f18701j.zzq().zzw().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                    }
                    mo20518p(new zzkr("_sno", j, Long.valueOf(j2 + 1), str2), zzn);
                }
                C3134v7 v7Var = new C3134v7(zzn.zza, zzkr.zze, zzkr.zza, zzkr.zzb, O);
                this.f18701j.zzq().zzw().zza("Setting user property", this.f18701j.zzi().zzc(v7Var.f18417c), O);
                zze().zze();
                try {
                    mo20506N(zzn);
                    boolean A = zze().mo19831A(v7Var);
                    zze().mo19845b();
                    if (!A) {
                        this.f18701j.zzq().zze().zza("Too many unique user properties are set. Ignoring user property", this.f18701j.zzi().zzc(v7Var.f18417c), v7Var.f18419e);
                        this.f18701j.zzh().mo20575p(this.f18717z, zzn.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zze().mo19850d0();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    /* renamed from: q */
    public final void mo20519q(zzn zzn) {
        if (this.f18713v != null) {
            ArrayList arrayList = new ArrayList();
            this.f18714w = arrayList;
            arrayList.addAll(this.f18713v);
        }
        C2950c zze = zze();
        String str = zzn.zza;
        Preconditions.checkNotEmpty(str);
        zze.zzc();
        zze.zzaj();
        try {
            SQLiteDatabase c = zze.mo19847c();
            String[] strArr = {str};
            int delete = c.delete("apps", "app_id=?", strArr) + 0 + c.delete("events", "app_id=?", strArr) + c.delete("user_attributes", "app_id=?", strArr) + c.delete("conditional_properties", "app_id=?", strArr) + c.delete("raw_events", "app_id=?", strArr) + c.delete("raw_events_metadata", "app_id=?", strArr) + c.delete("queue", "app_id=?", strArr) + c.delete("audience_filter_values", "app_id=?", strArr) + c.delete("main_event_params", "app_id=?", strArr) + c.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze.zzq().zzw().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze.zzq().zze().zza("Error resetting analytics data. appId, error", zzer.zza(str), e);
        }
        if (zzn.zzh) {
            mo20503K(zzn);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: r */
    public final void mo20520r(zzw zzw) {
        zzn E = m10903E(zzw.zza);
        if (E != null) {
            mo20521s(zzw, E);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: s */
    public final void mo20521s(zzw zzw, zzn zzn) {
        boolean z;
        Preconditions.checkNotNull(zzw);
        Preconditions.checkNotEmpty(zzw.zza);
        Preconditions.checkNotNull(zzw.zzb);
        Preconditions.checkNotNull(zzw.zzc);
        Preconditions.checkNotEmpty(zzw.zzc.zza);
        m10912Y();
        mo20508R();
        if (m10909Q(zzn)) {
            if (!zzn.zzh) {
                mo20506N(zzn);
                return;
            }
            zzw zzw2 = new zzw(zzw);
            boolean z2 = false;
            zzw2.zze = false;
            zze().zze();
            try {
                zzw V = zze().mo19839V(zzw2.zza, zzw2.zzc.zza);
                if (V != null && !V.zzb.equals(zzw2.zzb)) {
                    this.f18701j.zzq().zzh().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f18701j.zzi().zzc(zzw2.zzc.zza), zzw2.zzb, V.zzb);
                }
                if (V != null && (z = V.zze)) {
                    zzw2.zzb = V.zzb;
                    zzw2.zzd = V.zzd;
                    zzw2.zzh = V.zzh;
                    zzw2.zzf = V.zzf;
                    zzw2.zzi = V.zzi;
                    zzw2.zze = z;
                    zzkr zzkr = zzw2.zzc;
                    zzw2.zzc = new zzkr(zzkr.zza, V.zzc.zzb, zzkr.zza(), V.zzc.zze);
                } else if (TextUtils.isEmpty(zzw2.zzf)) {
                    zzkr zzkr2 = zzw2.zzc;
                    zzw2.zzc = new zzkr(zzkr2.zza, zzw2.zzd, zzkr2.zza(), zzw2.zzc.zze);
                    zzw2.zze = true;
                    z2 = true;
                }
                if (zzw2.zze) {
                    zzkr zzkr3 = zzw2.zzc;
                    C3134v7 v7Var = new C3134v7(zzw2.zza, zzw2.zzb, zzkr3.zza, zzkr3.zzb, zzkr3.zza());
                    if (zze().mo19831A(v7Var)) {
                        this.f18701j.zzq().zzv().zza("User property updated immediately", zzw2.zza, this.f18701j.zzi().zzc(v7Var.f18417c), v7Var.f18419e);
                    } else {
                        this.f18701j.zzq().zze().zza("(2)Too many active user properties, ignoring", zzer.zza(zzw2.zza), this.f18701j.zzi().zzc(v7Var.f18417c), v7Var.f18419e);
                    }
                    if (z2 && zzw2.zzi != null) {
                        m10908O(new zzar(zzw2.zzi, zzw2.zzd), zzn);
                    }
                }
                if (zze().zza(zzw2)) {
                    this.f18701j.zzq().zzv().zza("Conditional property added", zzw2.zza, this.f18701j.zzi().zzc(zzw2.zzc.zza), zzw2.zzc.zza());
                } else {
                    this.f18701j.zzq().zze().zza("Too many conditional properties, ignoring", zzer.zza(zzw2.zza), this.f18701j.zzi().zzc(zzw2.zzc.zza), zzw2.zzc.zza());
                }
                zze().mo19845b();
            } finally {
                zze().mo19850d0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: t */
    public final void mo20522t(Runnable runnable) {
        m10912Y();
        if (this.f18705n == null) {
            this.f18705n = new ArrayList();
        }
        this.f18705n.add(runnable);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0172 A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0176 A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    @androidx.annotation.WorkerThread
    @com.google.android.gms.common.util.VisibleForTesting
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo20523u(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.m10912Y()
            r6.mo20508R()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0196 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzfv r1 = r6.f18701j     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzw()     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0196 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0196 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.c r1 = r6.zze()     // Catch:{ all -> 0x0196 }
            r1.zze()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.c r1 = r6.zze()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.i3 r1 = r1.mo19834P(r7)     // Catch:{ all -> 0x018d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfv r8 = r6.f18701j     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzq()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzh()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r7)     // Catch:{ all -> 0x018d }
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzfv r10 = r6.f18701j     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r10 = r10.zzl()     // Catch:{ all -> 0x018d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.mo19950N(r10)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.c r10 = r6.zze()     // Catch:{ all -> 0x018d }
            r10.mo19872v(r1)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfv r10 = r6.f18701j     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzer r10 = r10.zzq()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzw()     // Catch:{ all -> 0x018d }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfp r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            r9.zzc(r7)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfv r7 = r6.f18701j     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.m3 r7 = r7.zzb()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfh r7 = r7.f18229e     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfv r9 = r6.f18701j     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzl()     // Catch:{ all -> 0x018d }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r9)     // Catch:{ all -> 0x018d }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzfv r7 = r6.f18701j     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.m3 r7 = r7.zzb()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfh r7 = r7.f18230f     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfv r8 = r6.f18701j     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r8 = r8.zzl()     // Catch:{ all -> 0x018d }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r8)     // Catch:{ all -> 0x018d }
        L_0x00c5:
            r6.m10900B()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x018d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x018d }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x018d }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x018d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x018d }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzfp r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.c r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.mo19850d0()     // Catch:{ all -> 0x0196 }
            r6.f18708q = r0
            r6.m10901C()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzfp r11 = r6.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.internal.measurement.zzca$zzb r11 = r11.zza(r7)     // Catch:{ all -> 0x018d }
            if (r11 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzfp r11 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.c r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.mo19850d0()     // Catch:{ all -> 0x0196 }
            r6.f18708q = r0
            r6.m10901C()
            return
        L_0x0124:
            com.google.android.gms.measurement.internal.zzfv r9 = r6.f18701j     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzl()     // Catch:{ all -> 0x018d }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.mo19947K(r2)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.c r9 = r6.zze()     // Catch:{ all -> 0x018d }
            r9.mo19872v(r1)     // Catch:{ all -> 0x018d }
            if (r8 != r5) goto L_0x014a
            com.google.android.gms.measurement.internal.zzfv r8 = r6.f18701j     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzq()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzj()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0162
        L_0x014a:
            com.google.android.gms.measurement.internal.zzfv r7 = r6.f18701j     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzq()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzw()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            int r10 = r10.length     // Catch:{ all -> 0x018d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x018d }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x018d }
        L_0x0162:
            com.google.android.gms.measurement.internal.zzeu r7 = r6.zzd()     // Catch:{ all -> 0x018d }
            boolean r7 = r7.zze()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            boolean r7 = r6.m10899A()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            r6.mo20509S()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x0176:
            r6.m10900B()     // Catch:{ all -> 0x018d }
        L_0x0179:
            com.google.android.gms.measurement.internal.c r7 = r6.zze()     // Catch:{ all -> 0x018d }
            r7.mo19845b()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.c r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.mo19850d0()     // Catch:{ all -> 0x0196 }
            r6.f18708q = r0
            r6.m10901C()
            return
        L_0x018d:
            r7 = move-exception
            com.google.android.gms.measurement.internal.c r8 = r6.zze()     // Catch:{ all -> 0x0196 }
            r8.mo19850d0()     // Catch:{ all -> 0x0196 }
            throw r7     // Catch:{ all -> 0x0196 }
        L_0x0196:
            r7 = move-exception
            r6.f18708q = r0
            r6.m10901C()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.mo20523u(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: v */
    public final void mo20524v(String str, zzad zzad) {
        if (zzmj.zzb() && this.f18701j.zza().zza(zzat.zzci)) {
            m10912Y();
            mo20508R();
            this.f18716y.put(str, zzad);
            C2950c zze = zze();
            if (zzmj.zzb() && zze.zzs().zza(zzat.zzci)) {
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(zzad);
                zze.zzc();
                zze.zzaj();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", zzad.zza());
                try {
                    if (zze.mo19847c().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                        zze.zzq().zze().zza("Failed to insert/update consent setting (got -1). appId", zzer.zza(str));
                    }
                } catch (SQLiteException e) {
                    zze.zzq().zze().zza("Error storing consent setting. appId, error", zzer.zza(str), e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public final void mo20525w(boolean z) {
        m10900B();
    }

    public final zzy zzb() {
        return this.f18701j.zza();
    }

    public final zzfp zzc() {
        m10907I(this.f18692a);
        return this.f18692a;
    }

    public final zzeu zzd() {
        m10907I(this.f18693b);
        return this.f18693b;
    }

    public final C2950c zze() {
        m10907I(this.f18694c);
        return this.f18694c;
    }

    public final C2939a8 zzf() {
        m10907I(this.f18697f);
        return this.f18697f;
    }

    public final C3105s5 zzg() {
        m10907I(this.f18699h);
        return this.f18699h;
    }

    public final zzks zzh() {
        m10907I(this.f18698g);
        return this.f18698g;
    }

    public final zzjo zzi() {
        return this.f18700i;
    }

    public final zzep zzj() {
        return this.f18701j.zzi();
    }

    public final zzkw zzk() {
        return this.f18701j.zzh();
    }

    public final Clock zzl() {
        return this.f18701j.zzl();
    }

    public final Context zzm() {
        return this.f18701j.zzm();
    }

    public final zzfo zzp() {
        return this.f18701j.zzp();
    }

    public final zzer zzq() {
        return this.f18701j.zzq();
    }

    public final zzx zzt() {
        return this.f18701j.zzt();
    }

    private zzki(zzkq zzkq, zzfv zzfv) {
        this.f18702k = false;
        this.f18717z = new C3125u7(this);
        Preconditions.checkNotNull(zzkq);
        zzfv zza = zzfv.zza(zzkq.f18722a, (zzae) null, (Long) null);
        this.f18701j = zza;
        this.f18715x = -1;
        zzks zzks = new zzks(this);
        zzks.zzak();
        this.f18698g = zzks;
        zzeu zzeu = new zzeu(this);
        zzeu.zzak();
        this.f18693b = zzeu;
        zzfp zzfp = new zzfp(this);
        zzfp.zzak();
        this.f18692a = zzfp;
        this.f18716y = new HashMap();
        zza.zzp().zza((Runnable) new C3089q7(this, zzkq));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza() {
        this.f18701j.zzp().zzc();
        zze().mo19859i0();
        if (this.f18701j.zzb().f18228d.zza() == 0) {
            this.f18701j.zzb().f18228d.zza(this.f18701j.zzl().currentTimeMillis());
        }
        m10900B();
    }
}
