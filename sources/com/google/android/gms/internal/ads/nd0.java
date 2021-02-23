package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class nd0 implements Handler.Callback, zznb, zznd, zzog {

    /* renamed from: A */
    private int f10150A;

    /* renamed from: B */
    private od0 f10151B;

    /* renamed from: C */
    private long f10152C;

    /* renamed from: D */
    private md0 f10153D;

    /* renamed from: E */
    private md0 f10154E;

    /* renamed from: F */
    private md0 f10155F;

    /* renamed from: G */
    private zzhz f10156G;

    /* renamed from: a */
    private final zzhy[] f10157a;

    /* renamed from: b */
    private final zzhx[] f10158b;

    /* renamed from: c */
    private final zzoh f10159c;

    /* renamed from: d */
    private final zzht f10160d;

    /* renamed from: e */
    private final zzpo f10161e;

    /* renamed from: f */
    private final Handler f10162f;

    /* renamed from: g */
    private final HandlerThread f10163g;

    /* renamed from: h */
    private final Handler f10164h;

    /* renamed from: i */
    private final zzhd f10165i;

    /* renamed from: j */
    private final zzie f10166j;

    /* renamed from: k */
    private final zzib f10167k;

    /* renamed from: l */
    private zzho f10168l;

    /* renamed from: m */
    private zzhv f10169m;

    /* renamed from: n */
    private zzhy f10170n;

    /* renamed from: o */
    private zzpg f10171o;

    /* renamed from: p */
    private zzna f10172p;

    /* renamed from: q */
    private zzhy[] f10173q;

    /* renamed from: r */
    private boolean f10174r;

    /* renamed from: s */
    private boolean f10175s;

    /* renamed from: t */
    private boolean f10176t;

    /* renamed from: u */
    private boolean f10177u;

    /* renamed from: v */
    private int f10178v;

    /* renamed from: w */
    private int f10179w = 0;

    /* renamed from: x */
    private int f10180x;

    /* renamed from: y */
    private int f10181y;

    /* renamed from: z */
    private long f10182z;

    public nd0(zzhy[] zzhyArr, zzoh zzoh, zzht zzht, boolean z, int i, Handler handler, zzho zzho, zzhd zzhd) {
        this.f10157a = zzhyArr;
        this.f10159c = zzoh;
        this.f10160d = zzht;
        this.f10175s = z;
        this.f10164h = handler;
        this.f10178v = 1;
        this.f10168l = zzho;
        this.f10165i = zzhd;
        this.f10158b = new zzhx[zzhyArr.length];
        for (int i2 = 0; i2 < zzhyArr.length; i2++) {
            zzhyArr[i2].setIndex(i2);
            this.f10158b[i2] = zzhyArr[i2].zzdz();
        }
        this.f10161e = new zzpo();
        this.f10173q = new zzhy[0];
        this.f10166j = new zzie();
        this.f10167k = new zzib();
        zzoh.zza(this);
        this.f10169m = zzhv.zzahx;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f10163g = handlerThread;
        handlerThread.start();
        this.f10162f = new Handler(handlerThread.getLooper(), this);
    }

    /* renamed from: A */
    private final void m6523A() {
        md0 md0 = this.f10153D;
        if (md0 != null && !md0.f9946j) {
            md0 md02 = this.f10154E;
            if (md02 == null || md02.f9948l == md0) {
                zzhy[] zzhyArr = this.f10173q;
                int length = zzhyArr.length;
                int i = 0;
                while (i < length) {
                    if (zzhyArr[i].zzec()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.f10153D.f9937a.zzhn();
            }
        }
    }

    /* renamed from: B */
    private final void m6524B() {
        long j;
        md0 md0 = this.f10153D;
        if (!md0.f9946j) {
            j = 0;
        } else {
            j = md0.f9937a.zzhp();
        }
        if (j == Long.MIN_VALUE) {
            m6525D(false);
            return;
        }
        long e = this.f10152C - this.f10153D.mo14435e();
        boolean zzdt = this.f10160d.zzdt(j - e);
        m6525D(zzdt);
        if (zzdt) {
            this.f10153D.f9937a.zzef(e);
        }
    }

    /* renamed from: D */
    private final void m6525D(boolean z) {
        if (this.f10177u != z) {
            this.f10177u = z;
            this.f10164h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    /* renamed from: E */
    private final void m6526E(boolean z) {
        this.f10162f.removeMessages(2);
        this.f10176t = false;
        this.f10161e.stop();
        this.f10171o = null;
        this.f10170n = null;
        this.f10152C = 60000000;
        for (zzhy zzhy : this.f10173q) {
            try {
                m6534i(zzhy);
                zzhy.disable();
            } catch (zzhe | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.f10173q = new zzhy[0];
        md0 md0 = this.f10155F;
        if (md0 == null) {
            md0 = this.f10153D;
        }
        m6533h(md0);
        this.f10153D = null;
        this.f10154E = null;
        this.f10155F = null;
        m6525D(false);
        if (z) {
            zzna zzna = this.f10172p;
            if (zzna != null) {
                zzna.zzia();
                this.f10172p = null;
            }
            this.f10156G = null;
        }
    }

    /* renamed from: F */
    private final boolean m6527F(int i) {
        this.f10156G.zza(i, this.f10167k, false);
        this.f10156G.zza(0, this.f10166j, false);
        if (this.f10156G.zza(i, this.f10167k, this.f10166j, this.f10179w) == -1) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private final void m6528b(int i) {
        if (this.f10178v != i) {
            this.f10178v = i;
            this.f10164h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    /* renamed from: d */
    private final int m6529d(int i, zzhz zzhz, zzhz zzhz2) {
        int zzfg = zzhz.zzfg();
        int i2 = -1;
        for (int i3 = 0; i3 < zzfg && i2 == -1; i3++) {
            i = zzhz.zza(i, this.f10167k, this.f10166j, this.f10179w);
            i2 = zzhz2.zzc(zzhz.zza(i, this.f10167k, true).zzafm);
        }
        return i2;
    }

    /* renamed from: e */
    private final Pair<Integer, Long> m6530e(od0 od0) {
        zzhz zzhz = od0.f10360a;
        if (zzhz.isEmpty()) {
            zzhz = this.f10156G;
        }
        try {
            Pair<Integer, Long> p = m6538p(zzhz, od0.f10361b, od0.f10362c);
            zzhz zzhz2 = this.f10156G;
            if (zzhz2 == zzhz) {
                return p;
            }
            int zzc = zzhz2.zzc(zzhz.zza(((Integer) p.first).intValue(), this.f10167k, true).zzafm);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) p.second);
            }
            int d = m6529d(((Integer) p.first).intValue(), zzhz, this.f10156G);
            if (d == -1) {
                return null;
            }
            this.f10156G.zza(d, this.f10167k, false);
            return m6541t(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhu(this.f10156G, od0.f10361b, od0.f10362c);
        }
    }

    /* renamed from: f */
    private final Pair<Integer, Long> m6531f(zzhz zzhz, int i, long j, long j2) {
        zzpc.zzc(i, 0, zzhz.zzff());
        zzhz.zza(i, this.f10166j, false, j2);
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j3 = j + 0;
        long j4 = zzhz.zza(0, this.f10167k, false).zzaif;
        if (j4 != -9223372036854775807L) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j3));
    }

    /* renamed from: g */
    private final void m6532g(long j, long j2) {
        this.f10162f.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f10162f.sendEmptyMessage(2);
        } else {
            this.f10162f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    /* renamed from: h */
    private static void m6533h(md0 md0) {
        while (md0 != null) {
            md0.mo14431a();
            md0 = md0.f9948l;
        }
    }

    /* renamed from: i */
    private static void m6534i(zzhy zzhy) {
        if (zzhy.getState() == 2) {
            zzhy.stop();
        }
    }

    /* renamed from: l */
    private final void m6535l(Object obj, int i) {
        this.f10168l = new zzho(0, 0);
        m6540r(obj, i);
        this.f10168l = new zzho(0, -9223372036854775807L);
        m6528b(4);
        m6526E(false);
    }

    /* renamed from: n */
    private final void m6536n(boolean[] zArr, int i) {
        this.f10173q = new zzhy[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzhy[] zzhyArr = this.f10157a;
            if (i2 < zzhyArr.length) {
                zzhy zzhy = zzhyArr[i2];
                zzoc zzbe = this.f10155F.f9949m.zzbhv.zzbe(i2);
                if (zzbe != null) {
                    int i4 = i3 + 1;
                    this.f10173q[i3] = zzhy;
                    if (zzhy.getState() == 0) {
                        zzia zzia = this.f10155F.f9949m.zzbhx[i2];
                        boolean z = this.f10175s && this.f10178v == 3;
                        boolean z2 = !zArr[i2] && z;
                        int length = zzbe.length();
                        zzhp[] zzhpArr = new zzhp[length];
                        for (int i5 = 0; i5 < length; i5++) {
                            zzhpArr[i5] = zzbe.zzbc(i5);
                        }
                        md0 md0 = this.f10155F;
                        zzhy.zza(zzia, zzhpArr, md0.f9940d[i2], this.f10152C, z2, md0.mo14435e());
                        zzpg zzea = zzhy.zzea();
                        if (zzea != null) {
                            if (this.f10171o == null) {
                                this.f10171o = zzea;
                                this.f10170n = zzhy;
                                zzea.zzb(this.f10169m);
                            } else {
                                throw zzhe.m8960a(new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z) {
                            zzhy.start();
                        }
                    }
                    i3 = i4;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* renamed from: o */
    private final long m6537o(int i, long j) {
        md0 md0;
        m6545x();
        this.f10176t = false;
        m6528b(2);
        md0 md02 = this.f10155F;
        if (md02 == null) {
            md0 md03 = this.f10153D;
            if (md03 != null) {
                md03.mo14431a();
            }
            md0 = null;
        } else {
            md0 = null;
            while (md02 != null) {
                if (md02.f9943g != i || !md02.f9946j) {
                    md02.mo14431a();
                } else {
                    md0 = md02;
                }
                md02 = md02.f9948l;
            }
        }
        md0 md04 = this.f10155F;
        if (!(md04 == md0 && md04 == this.f10154E)) {
            for (zzhy disable : this.f10173q) {
                disable.disable();
            }
            this.f10173q = new zzhy[0];
            this.f10171o = null;
            this.f10170n = null;
            this.f10155F = null;
        }
        if (md0 != null) {
            md0.f9948l = null;
            this.f10153D = md0;
            this.f10154E = md0;
            m6539q(md0);
            md0 md05 = this.f10155F;
            if (md05.f9947k) {
                j = md05.f9937a.zzeg(j);
            }
            m6542u(j);
            m6524B();
        } else {
            this.f10153D = null;
            this.f10154E = null;
            this.f10155F = null;
            m6542u(j);
        }
        this.f10162f.sendEmptyMessage(2);
        return j;
    }

    /* renamed from: p */
    private final Pair<Integer, Long> m6538p(zzhz zzhz, int i, long j) {
        return m6531f(zzhz, i, j, 0);
    }

    /* renamed from: q */
    private final void m6539q(md0 md0) {
        if (this.f10155F != md0) {
            boolean[] zArr = new boolean[this.f10157a.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                zzhy[] zzhyArr = this.f10157a;
                if (i < zzhyArr.length) {
                    zzhy zzhy = zzhyArr[i];
                    zArr[i] = zzhy.getState() != 0;
                    zzoc zzbe = md0.f9949m.zzbhv.zzbe(i);
                    if (zzbe != null) {
                        i2++;
                    }
                    if (zArr[i] && (zzbe == null || (zzhy.zzee() && zzhy.zzeb() == this.f10155F.f9940d[i]))) {
                        if (zzhy == this.f10170n) {
                            this.f10161e.zza(this.f10171o);
                            this.f10171o = null;
                            this.f10170n = null;
                        }
                        m6534i(zzhy);
                        zzhy.disable();
                    }
                    i++;
                } else {
                    this.f10155F = md0;
                    this.f10164h.obtainMessage(3, md0.f9949m).sendToTarget();
                    m6536n(zArr, i2);
                    return;
                }
            }
        }
    }

    /* renamed from: r */
    private final void m6540r(Object obj, int i) {
        this.f10164h.obtainMessage(6, new zzhq(this.f10156G, obj, this.f10168l, i)).sendToTarget();
    }

    /* renamed from: t */
    private final Pair<Integer, Long> m6541t(int i, long j) {
        return m6538p(this.f10156G, 0, -9223372036854775807L);
    }

    /* renamed from: u */
    private final void m6542u(long j) {
        long j2;
        md0 md0 = this.f10155F;
        if (md0 == null) {
            j2 = 60000000;
        } else {
            j2 = md0.mo14435e();
        }
        long j3 = j + j2;
        this.f10152C = j3;
        this.f10161e.zzel(j3);
        for (zzhy zzdo : this.f10173q) {
            zzdo.zzdo(this.f10152C);
        }
    }

    /* renamed from: v */
    private final boolean m6543v(long j) {
        if (j == -9223372036854775807L || this.f10168l.zzagu < j) {
            return true;
        }
        md0 md0 = this.f10155F.f9948l;
        return md0 != null && md0.f9946j;
    }

    /* renamed from: w */
    private final void m6544w() {
        this.f10176t = false;
        this.f10161e.start();
        for (zzhy start : this.f10173q) {
            start.start();
        }
    }

    /* renamed from: x */
    private final void m6545x() {
        this.f10161e.stop();
        for (zzhy i : this.f10173q) {
            m6534i(i);
        }
    }

    /* renamed from: y */
    private final void m6546y() {
        long j;
        md0 md0 = this.f10155F;
        if (md0 != null) {
            long zzhq = md0.f9937a.zzhq();
            if (zzhq != -9223372036854775807L) {
                m6542u(zzhq);
            } else {
                zzhy zzhy = this.f10170n;
                if (zzhy == null || zzhy.zzfe()) {
                    this.f10152C = this.f10161e.zzfz();
                } else {
                    long zzfz = this.f10171o.zzfz();
                    this.f10152C = zzfz;
                    this.f10161e.zzel(zzfz);
                }
                zzhq = this.f10152C - this.f10155F.mo14435e();
            }
            this.f10168l.zzagu = zzhq;
            this.f10182z = SystemClock.elapsedRealtime() * 1000;
            if (this.f10173q.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.f10155F.f9937a.zzhr();
            }
            zzho zzho = this.f10168l;
            if (j == Long.MIN_VALUE) {
                j = this.f10156G.zza(this.f10155F.f9943g, this.f10167k, false).zzaif;
            }
            zzho.zzagv = j;
        }
    }

    /* renamed from: z */
    private final void m6547z() {
        m6526E(true);
        this.f10160d.onStopped();
        m6528b(1);
    }

    /* renamed from: C */
    public final void mo14480C(boolean z) {
        this.f10162f.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo14481a() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f10174r     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.f10162f     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.f10174r     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.f10163g     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0028
        L_0x0027:
            throw r0
        L_0x0028:
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.nd0.mo14481a():void");
    }

    /* renamed from: c */
    public final void mo14482c() {
        this.f10162f.sendEmptyMessage(5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0355, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0413, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0414, code lost:
        r2 = r0;
        r6 = new com.google.android.gms.internal.ads.zzho(r3, r4);
        r8.f10168l = r6;
        r3 = r8.f10164h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x041e, code lost:
        if (r1 != false) goto L_0x0420;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0420, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0422, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0423, code lost:
        r3.obtainMessage(4, r1, 0, r6).sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x042a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:497:0x082f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:498:0x0830, code lost:
        r1 = r0;
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:499:0x0834, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:500:0x0835, code lost:
        r1 = r0;
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:501:0x0839, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:502:0x083a, code lost:
        r1 = r0;
        android.util.Log.e("ExoPlayerImplInternal", "Internal runtime error.", r1);
        r8.f10164h.obtainMessage(8, com.google.android.gms.internal.ads.zzhe.m8960a(r1)).sendToTarget();
        m6547z();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:503:0x0854, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00bd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00be, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00bf, code lost:
        monitor-enter(r34);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r8.f10181y++;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0262 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0263 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0267 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0323 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0337 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x04ed A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x04f4 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x050c A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x050f A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0548 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0558 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x0572 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }, LOOP:8: B:330:0x0572->B:334:0x0582, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005e A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x06b5 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0766 A[Catch:{ all -> 0x0413, all -> 0x0355, all -> 0x00bd, all -> 0x00ca, all -> 0x00b9, zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }] */
    /* JADX WARNING: Removed duplicated region for block: B:501:0x0839 A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            r34 = this;
            r8 = r34
            r1 = r35
            r10 = 1
            int r2 = r1.what     // Catch:{ zzhe -> 0x0871, IOException -> 0x0855, RuntimeException -> 0x0839 }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x07f8;
                case 1: goto L_0x07cd;
                case 2: goto L_0x042b;
                case 3: goto L_0x037c;
                case 4: goto L_0x035d;
                case 5: goto L_0x0359;
                case 6: goto L_0x0342;
                case 7: goto L_0x01f0;
                case 8: goto L_0x01c0;
                case 9: goto L_0x01af;
                case 10: goto L_0x00ce;
                case 11: goto L_0x0090;
                case 12: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            return r9
        L_0x0019:
            int r1 = r1.arg1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10179w = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r2 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            com.google.android.gms.internal.ads.md0 r2 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0024:
            if (r2 == 0) goto L_0x008f
            com.google.android.gms.internal.ads.md0 r3 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != r3) goto L_0x002c
            r3 = 1
            goto L_0x002d
        L_0x002c:
            r3 = 0
        L_0x002d:
            com.google.android.gms.internal.ads.md0 r4 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != r4) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            com.google.android.gms.internal.ads.zzhz r11 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r12 = r2.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r13 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzie r14 = r8.f10166j     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r11 = r11.zza((int) r12, (com.google.android.gms.internal.ads.zzib) r13, (com.google.android.gms.internal.ads.zzie) r14, (int) r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r12 = r2.f9948l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r12 == 0) goto L_0x005c
            if (r11 == r5) goto L_0x005c
            int r13 = r12.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r13 != r11) goto L_0x005c
            com.google.android.gms.internal.ads.md0 r2 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r12 != r2) goto L_0x0050
            r2 = 1
            goto L_0x0051
        L_0x0050:
            r2 = 0
        L_0x0051:
            r3 = r3 | r2
            com.google.android.gms.internal.ads.md0 r2 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r12 != r2) goto L_0x0058
            r2 = 1
            goto L_0x0059
        L_0x0058:
            r2 = 0
        L_0x0059:
            r4 = r4 | r2
            r2 = r12
            goto L_0x0034
        L_0x005c:
            if (r12 == 0) goto L_0x0063
            m6533h(r12)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.f9948l = r6     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0063:
            int r5 = r2.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean r5 = r8.m6527F(r5)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.f9945i = r5     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r4 != 0) goto L_0x006f
            r8.f10153D = r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x006f:
            if (r3 != 0) goto L_0x0086
            com.google.android.gms.internal.ads.md0 r2 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == 0) goto L_0x0086
            int r2 = r2.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r3 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r3 = r3.zzagu     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r3 = r8.m6537o(r2, r3)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r5 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r5.<init>(r2, r3)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r5     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0086:
            int r2 = r8.f10178v     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != r15) goto L_0x008f
            if (r1 == 0) goto L_0x008f
            r8.m6528b(r7)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x008f:
            return r10
        L_0x0090:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhi[] r1 = (com.google.android.gms.internal.ads.zzhi[]) r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r1.length     // Catch:{ all -> 0x00bd }
        L_0x0095:
            if (r9 >= r2) goto L_0x00a5
            r3 = r1[r9]     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzhf r4 = r3.zzaek     // Catch:{ all -> 0x00bd }
            int r5 = r3.zzael     // Catch:{ all -> 0x00bd }
            java.lang.Object r3 = r3.zzaem     // Catch:{ all -> 0x00bd }
            r4.zza(r5, r3)     // Catch:{ all -> 0x00bd }
            int r9 = r9 + 1
            goto L_0x0095
        L_0x00a5:
            com.google.android.gms.internal.ads.zzna r1 = r8.f10172p     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00ae
            android.os.Handler r1 = r8.f10162f     // Catch:{ all -> 0x00bd }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00bd }
        L_0x00ae:
            monitor-enter(r34)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r1 = r8.f10181y     // Catch:{ all -> 0x00b9 }
            int r1 = r1 + r10
            r8.f10181y = r1     // Catch:{ all -> 0x00b9 }
            r34.notifyAll()     // Catch:{ all -> 0x00b9 }
            monitor-exit(r34)     // Catch:{ all -> 0x00b9 }
            return r10
        L_0x00b9:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00b9 }
            throw r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x00bd:
            r0 = move-exception
            r1 = r0
            monitor-enter(r34)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r8.f10181y     // Catch:{ all -> 0x00ca }
            int r2 = r2 + r10
            r8.f10181y = r2     // Catch:{ all -> 0x00ca }
            r34.notifyAll()     // Catch:{ all -> 0x00ca }
            monitor-exit(r34)     // Catch:{ all -> 0x00ca }
            throw r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x00ca:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00ca }
            throw r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x00ce:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x01ae
            r2 = 1
        L_0x00d3:
            if (r1 == 0) goto L_0x01ae
            boolean r3 = r1.f9946j     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 != 0) goto L_0x00db
            goto L_0x01ae
        L_0x00db:
            boolean r3 = r1.mo14437g()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 != 0) goto L_0x00e9
            com.google.android.gms.internal.ads.md0 r3 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 != r3) goto L_0x00e6
            r2 = 0
        L_0x00e6:
            com.google.android.gms.internal.ads.md0 r1 = r1.f9948l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x00d3
        L_0x00e9:
            if (r2 == 0) goto L_0x017d
            com.google.android.gms.internal.ads.md0 r2 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r3 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == r3) goto L_0x00f3
            r2 = 1
            goto L_0x00f4
        L_0x00f3:
            r2 = 0
        L_0x00f4:
            com.google.android.gms.internal.ads.md0 r3 = r3.f9948l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            m6533h(r3)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r3 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3.f9948l = r6     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10153D = r3     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10154E = r3     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhy[] r4 = r8.f10157a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r4 = r4.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean[] r4 = new boolean[r4]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r5 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r11 = r5.zzagu     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r2 = r3.mo14432b(r11, r2, r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r5 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r11 = r5.zzagu     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x011d
            com.google.android.gms.internal.ads.zzho r5 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r5.zzagu = r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6542u(r2)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x011d:
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.f10157a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r2.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean[] r2 = new boolean[r2]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3 = 0
            r5 = 0
        L_0x0124:
            com.google.android.gms.internal.ads.zzhy[] r11 = r8.f10157a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r12 = r11.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 >= r12) goto L_0x016e
            r11 = r11[r3]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r12 = r11.getState()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r12 == 0) goto L_0x0133
            r12 = 1
            goto L_0x0134
        L_0x0133:
            r12 = 0
        L_0x0134:
            r2[r3] = r12     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r12 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zznn[] r12 = r12.f9940d     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r12 = r12[r3]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r12 == 0) goto L_0x0140
            int r5 = r5 + 1
        L_0x0140:
            boolean r13 = r2[r3]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r13 == 0) goto L_0x016b
            com.google.android.gms.internal.ads.zznn r13 = r11.zzeb()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r12 == r13) goto L_0x0162
            com.google.android.gms.internal.ads.zzhy r13 = r8.f10170n     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r11 != r13) goto L_0x015b
            if (r12 != 0) goto L_0x0157
            com.google.android.gms.internal.ads.zzpo r12 = r8.f10161e     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzpg r13 = r8.f10171o     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r12.zza(r13)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0157:
            r8.f10171o = r6     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10170n = r6     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x015b:
            m6534i(r11)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r11.disable()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x016b
        L_0x0162:
            boolean r12 = r4[r3]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r12 == 0) goto L_0x016b
            long r12 = r8.f10152C     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r11.zzdo(r12)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x016b:
            int r3 = r3 + 1
            goto L_0x0124
        L_0x016e:
            android.os.Handler r3 = r8.f10164h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzoj r1 = r1.f9949m     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6536n(r2, r5)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x01a3
        L_0x017d:
            r8.f10153D = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r1 = r1.f9948l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0181:
            if (r1 == 0) goto L_0x0189
            r1.mo14431a()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r1 = r1.f9948l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0181
        L_0x0189:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.f9948l = r6     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean r2 = r1.f9946j     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == 0) goto L_0x01a3
            long r2 = r1.f9944h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r4 = r8.f10152C     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r11 = r1.mo14435e()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r2, r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r3 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3.mo14433c(r1, r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x01a3:
            r34.m6524B()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r34.m6546y()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Handler r1 = r8.f10162f     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendEmptyMessage(r7)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x01ae:
            return r10
        L_0x01af:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzmy r1 = (com.google.android.gms.internal.ads.zzmy) r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r2 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == 0) goto L_0x01bf
            com.google.android.gms.internal.ads.zzmy r2 = r2.f9937a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == r1) goto L_0x01bc
            goto L_0x01bf
        L_0x01bc:
            r34.m6524B()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x01bf:
            return r10
        L_0x01c0:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzmy r1 = (com.google.android.gms.internal.ads.zzmy) r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r2 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == 0) goto L_0x01ef
            com.google.android.gms.internal.ads.zzmy r3 = r2.f9937a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 == r1) goto L_0x01cd
            goto L_0x01ef
        L_0x01cd:
            r2.f9946j = r10     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.mo14437g()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r3 = r2.f9944h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r3 = r2.mo14433c(r3, r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.f9944h = r3     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r1 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 != 0) goto L_0x01ec
            com.google.android.gms.internal.ads.md0 r1 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10154E = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r1 = r1.f9944h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6542u(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r1 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6539q(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x01ec:
            r34.m6524B()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x01ef:
            return r10
        L_0x01f0:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r2 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r3 = r1.first     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r3 = (com.google.android.gms.internal.ads.zzhz) r3     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10156G = r3     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r1 = r1.second     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != 0) goto L_0x025d
            int r4 = r8.f10150A     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r4 <= 0) goto L_0x022f
            com.google.android.gms.internal.ads.od0 r3 = r8.f10151B     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.util.Pair r3 = r8.m6530e(r3)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r4 = r8.f10150A     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10150A = r9     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10151B = r6     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 != 0) goto L_0x0217
            r8.m6535l(r1, r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0341
        L_0x0217:
            com.google.android.gms.internal.ads.zzho r7 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r11 = r3.first     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r11 = r11.intValue()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r3 = r3.second     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r14 = r3.longValue()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r7.<init>(r11, r14)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r7     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x025e
        L_0x022f:
            com.google.android.gms.internal.ads.zzho r4 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r14 = r4.zzafr     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r4 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r4 != 0) goto L_0x025d
            boolean r3 = r3.isEmpty()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 == 0) goto L_0x0242
            r8.m6535l(r1, r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0341
        L_0x0242:
            android.util.Pair r3 = r8.m6541t(r9, r12)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r4 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r7 = r3.first     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r7 = r7.intValue()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r3 = r3.second     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r14 = r3.longValue()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r4.<init>(r7, r14)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r4     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x025d:
            r4 = 0
        L_0x025e:
            com.google.android.gms.internal.ads.md0 r3 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 == 0) goto L_0x0263
            goto L_0x0265
        L_0x0263:
            com.google.android.gms.internal.ads.md0 r3 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0265:
            if (r3 == 0) goto L_0x033e
            com.google.android.gms.internal.ads.zzhz r7 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r11 = r3.f9938b     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r7 = r7.zzc(r11)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r7 != r5) goto L_0x02c7
            int r6 = r3.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r7 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r8.m6529d(r6, r2, r7)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != r5) goto L_0x0280
            r8.m6535l(r1, r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0341
        L_0x0280:
            com.google.android.gms.internal.ads.zzhz r6 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r7 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r6.zza((int) r2, (com.google.android.gms.internal.ads.zzib) r7, (boolean) r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.util.Pair r2 = r8.m6541t(r9, r12)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r6 = r2.first     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r6 = r6.intValue()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r2 = r2.second     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r11 = r2.longValue()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r2 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r7 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.zza((int) r6, (com.google.android.gms.internal.ads.zzib) r7, (boolean) r10)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r2 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r2 = r2.zzafm     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3.f9943g = r5     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x02a8:
            com.google.android.gms.internal.ads.md0 r3 = r3.f9948l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 == 0) goto L_0x02ba
            java.lang.Object r7 = r3.f9938b     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean r7 = r7.equals(r2)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r7 == 0) goto L_0x02b6
            r7 = r6
            goto L_0x02b7
        L_0x02b6:
            r7 = -1
        L_0x02b7:
            r3.f9943g = r7     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x02a8
        L_0x02ba:
            long r2 = r8.m6537o(r6, r11)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r5 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r5.<init>(r6, r2)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r5     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x033e
        L_0x02c7:
            boolean r2 = r8.m6527F(r7)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3.mo14434d(r7, r2)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r2 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 != r2) goto L_0x02d4
            r2 = 1
            goto L_0x02d5
        L_0x02d4:
            r2 = 0
        L_0x02d5:
            com.google.android.gms.internal.ads.zzho r11 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r12 = r11.zzafq     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r7 == r12) goto L_0x02ec
            com.google.android.gms.internal.ads.zzho r12 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r13 = r11.zzafr     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r12.<init>(r7, r13)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r13 = r11.zzagu     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r12.zzagu = r13     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r13 = r11.zzagv     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r12.zzagv = r13     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r12     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x02ec:
            com.google.android.gms.internal.ads.md0 r11 = r3.f9948l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r11 == 0) goto L_0x033e
            com.google.android.gms.internal.ads.zzhz r12 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r13 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzie r14 = r8.f10166j     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r15 = r8.f10179w     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r7 = r12.zza((int) r7, (com.google.android.gms.internal.ads.zzib) r13, (com.google.android.gms.internal.ads.zzie) r14, (int) r15)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r7 == r5) goto L_0x0321
            java.lang.Object r12 = r11.f9938b     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r13 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r14 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r13 = r13.zza((int) r7, (com.google.android.gms.internal.ads.zzib) r14, (boolean) r10)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r13 = r13.zzafm     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean r12 = r12.equals(r13)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r12 == 0) goto L_0x0321
            boolean r3 = r8.m6527F(r7)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r11.mo14434d(r7, r3)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r3 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r11 != r3) goto L_0x031d
            r3 = 1
            goto L_0x031e
        L_0x031d:
            r3 = 0
        L_0x031e:
            r2 = r2 | r3
            r3 = r11
            goto L_0x02ec
        L_0x0321:
            if (r2 != 0) goto L_0x0337
            com.google.android.gms.internal.ads.md0 r2 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r2.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r3 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r5 = r3.zzagu     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r5 = r8.m6537o(r2, r5)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r3 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3.<init>(r2, r5)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r3     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x033e
        L_0x0337:
            r8.f10153D = r3     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3.f9948l = r6     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            m6533h(r11)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x033e:
            r8.m6540r(r1, r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0341:
            return r10
        L_0x0342:
            r8.m6526E(r10)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzht r1 = r8.f10160d     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.zzfc()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6528b(r10)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            monitor-enter(r34)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10174r = r10     // Catch:{ all -> 0x0355 }
            r34.notifyAll()     // Catch:{ all -> 0x0355 }
            monitor-exit(r34)     // Catch:{ all -> 0x0355 }
            return r10
        L_0x0355:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x0355 }
            throw r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0359:
            r34.m6547z()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            return r10
        L_0x035d:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhv r1 = (com.google.android.gms.internal.ads.zzhv) r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzpg r2 = r8.f10171o     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == 0) goto L_0x036a
            com.google.android.gms.internal.ads.zzhv r1 = r2.zzb(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0370
        L_0x036a:
            com.google.android.gms.internal.ads.zzpo r2 = r8.f10161e     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhv r1 = r2.zzb(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0370:
            r8.f10169m = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Handler r2 = r8.f10164h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            return r10
        L_0x037c:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.od0 r1 = (com.google.android.gms.internal.ads.od0) r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r2 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != 0) goto L_0x038d
            int r2 = r8.f10150A     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r2 + r10
            r8.f10150A = r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10151B = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0412
        L_0x038d:
            android.util.Pair r2 = r8.m6530e(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != 0) goto L_0x03b1
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.<init>(r9, r3)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Handler r2 = r8.f10164h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Message r1 = r2.obtainMessage(r15, r10, r9, r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.<init>(r9, r12)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6528b(r15)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6526E(r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0412
        L_0x03b1:
            long r3 = r1.f10362c     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03b9
            r1 = 1
            goto L_0x03ba
        L_0x03b9:
            r1 = 0
        L_0x03ba:
            java.lang.Object r3 = r2.first     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r3 = r3.intValue()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r2 = r2.second     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r4 = r2.longValue()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r2 = r8.f10168l     // Catch:{ all -> 0x0413 }
            int r6 = r2.zzafq     // Catch:{ all -> 0x0413 }
            if (r3 != r6) goto L_0x03f1
            r6 = 1000(0x3e8, double:4.94E-321)
            long r11 = r4 / r6
            long r13 = r2.zzagu     // Catch:{ all -> 0x0413 }
            long r13 = r13 / r6
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x03f1
            com.google.android.gms.internal.ads.zzho r2 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.<init>(r3, r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Handler r3 = r8.f10164h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x03e8
            r1 = 1
            goto L_0x03e9
        L_0x03e8:
            r1 = 0
        L_0x03e9:
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r2)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0412
        L_0x03f1:
            long r6 = r8.m6537o(r3, r4)     // Catch:{ all -> 0x0413 }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x03fb
            r2 = 1
            goto L_0x03fc
        L_0x03fb:
            r2 = 0
        L_0x03fc:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzho r2 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.<init>(r3, r6)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Handler r3 = r8.f10164h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x040a
            r1 = 1
            goto L_0x040b
        L_0x040a:
            r1 = 0
        L_0x040b:
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r2)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0412:
            return r10
        L_0x0413:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzho r6 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r6.<init>(r3, r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r6     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Handler r3 = r8.f10164h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x0422
            r1 = 1
            goto L_0x0423
        L_0x0422:
            r1 = 0
        L_0x0423:
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r6)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            throw r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x042b:
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r1 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 != 0) goto L_0x043b
            com.google.android.gms.internal.ads.zzna r1 = r8.f10172p     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.zzhz()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r14 = r5
            goto L_0x0666
        L_0x043b:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 != 0) goto L_0x0444
            com.google.android.gms.internal.ads.zzho r1 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r1 = r1.zzafq     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x047a
        L_0x0444:
            int r2 = r1.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean r7 = r1.f9945i     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r7 != 0) goto L_0x0487
            boolean r1 = r1.mo14436f()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x0487
            com.google.android.gms.internal.ads.zzhz r1 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r7 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r1 = r1.zza((int) r2, (com.google.android.gms.internal.ads.zzib) r7, (boolean) r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r14 = r1.zzaif     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r1 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x045f
            goto L_0x0487
        L_0x045f:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x046e
            com.google.android.gms.internal.ads.md0 r7 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r7 = r7.f9939c     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r1 = r1.f9939c     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r7 = r7 - r1
            r1 = 100
            if (r7 == r1) goto L_0x0487
        L_0x046e:
            com.google.android.gms.internal.ads.zzhz r1 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r7 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzie r14 = r8.f10166j     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r15 = r8.f10179w     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r1 = r1.zza((int) r2, (com.google.android.gms.internal.ads.zzib) r7, (com.google.android.gms.internal.ads.zzie) r14, (int) r15)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x047a:
            com.google.android.gms.internal.ads.zzhz r2 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r2.zzfg()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 < r2) goto L_0x048a
            com.google.android.gms.internal.ads.zzna r1 = r8.f10172p     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.zzhz()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0487:
            r14 = r5
            goto L_0x0554
        L_0x048a:
            com.google.android.gms.internal.ads.md0 r2 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != 0) goto L_0x0494
            com.google.android.gms.internal.ads.zzho r2 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r3 = r2.zzagu     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0492:
            r14 = r5
            goto L_0x04e9
        L_0x0494:
            com.google.android.gms.internal.ads.zzhz r2 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r7 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.zza((int) r1, (com.google.android.gms.internal.ads.zzib) r7, (boolean) r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r2 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzie r7 = r8.f10166j     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.zza((int) r9, (com.google.android.gms.internal.ads.zzie) r7, (boolean) r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x04a5
            goto L_0x0492
        L_0x04a5:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r1 = r1.mo14435e()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r7 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r14 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r14 = r14.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r15 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r7 = r7.zza((int) r14, (com.google.android.gms.internal.ads.zzib) r15, (boolean) r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r14 = r7.zzaif     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r1 = r1 + r14
            long r14 = r8.f10152C     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r1 = r1 - r14
            com.google.android.gms.internal.ads.zzhz r7 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r14 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r18 = java.lang.Math.max(r3, r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1 = r34
            r2 = r7
            r3 = r14
            r14 = r5
            r4 = r16
            r6 = r18
            android.util.Pair r1 = r1.m6531f(r2, r3, r4, r6)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x0554
            java.lang.Object r2 = r1.first     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r2.intValue()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r1 = r1.second     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r3 = r1.longValue()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1 = r2
        L_0x04e9:
            com.google.android.gms.internal.ads.md0 r2 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != 0) goto L_0x04f4
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x04f1:
            r23 = r5
            goto L_0x0508
        L_0x04f4:
            long r5 = r2.mo14435e()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r2 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r7 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r7 = r7.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r11 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r2 = r2.zza((int) r7, (com.google.android.gms.internal.ads.zzib) r11, (boolean) r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r12 = r2.zzaif     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r5 = r5 + r12
            goto L_0x04f1
        L_0x0508:
            com.google.android.gms.internal.ads.md0 r2 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != 0) goto L_0x050f
            r29 = 0
            goto L_0x0514
        L_0x050f:
            int r2 = r2.f9939c     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r2 + r10
            r29 = r2
        L_0x0514:
            boolean r31 = r8.m6527F(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhz r2 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r5 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.zza((int) r1, (com.google.android.gms.internal.ads.zzib) r5, (boolean) r10)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r2 = new com.google.android.gms.internal.ads.md0     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhy[] r5 = r8.f10157a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhx[] r6 = r8.f10158b     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzoh r7 = r8.f10159c     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzht r11 = r8.f10160d     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzna r12 = r8.f10172p     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r13 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            java.lang.Object r13 = r13.zzafm     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r20 = r2
            r21 = r5
            r22 = r6
            r25 = r7
            r26 = r11
            r27 = r12
            r28 = r13
            r30 = r1
            r32 = r3
            r20.<init>(r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r1 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x054a
            r1.f9948l = r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x054a:
            r8.f10153D = r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzmy r1 = r2.f9937a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.zza(r8, r3)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6525D(r10)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0554:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x056b
            boolean r1 = r1.mo14436f()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x055f
            goto L_0x056b
        L_0x055f:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x056e
            boolean r1 = r8.f10177u     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 != 0) goto L_0x056e
            r34.m6524B()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x056e
        L_0x056b:
            r8.m6525D(r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x056e:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x0666
        L_0x0572:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r2 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == r2) goto L_0x05a9
            long r3 = r8.f10152C     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r5 = r1.f9948l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r5 = r5.f9942f     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x05a9
            r1.mo14431a()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r1 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r1 = r1.f9948l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6539q(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r2 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r3 = r2.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r4 = r2.f9944h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.<init>(r3, r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r34.m6546y()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Handler r1 = r8.f10164h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2 = 5
            com.google.android.gms.internal.ads.zzho r3 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0572
        L_0x05a9:
            boolean r1 = r2.f9945i     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x05cf
            r1 = 0
        L_0x05ae:
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.f10157a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r3 = r2.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 >= r3) goto L_0x0666
            r2 = r2[r1]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r3 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zznn[] r3 = r3.f9940d     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3 = r3[r1]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 == 0) goto L_0x05cc
            com.google.android.gms.internal.ads.zznn r4 = r2.zzeb()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r4 != r3) goto L_0x05cc
            boolean r3 = r2.zzec()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 == 0) goto L_0x05cc
            r2.zzed()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x05cc:
            int r1 = r1 + 1
            goto L_0x05ae
        L_0x05cf:
            r1 = 0
        L_0x05d0:
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.f10157a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r3 = r2.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 >= r3) goto L_0x05f0
            r2 = r2[r1]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r3 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zznn[] r3 = r3.f9940d     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3 = r3[r1]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zznn r4 = r2.zzeb()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r4 != r3) goto L_0x0666
            if (r3 == 0) goto L_0x05ed
            boolean r2 = r2.zzec()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != 0) goto L_0x05ed
            goto L_0x0666
        L_0x05ed:
            int r1 = r1 + 1
            goto L_0x05d0
        L_0x05f0:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r2 = r1.f9948l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == 0) goto L_0x0666
            boolean r3 = r2.f9946j     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 == 0) goto L_0x0666
            com.google.android.gms.internal.ads.zzoj r1 = r1.f9949m     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10154E = r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzoj r3 = r2.f9949m     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzmy r2 = r2.f9937a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r4 = r2.zzhq()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0611
            r2 = 1
            goto L_0x0612
        L_0x0611:
            r2 = 0
        L_0x0612:
            r4 = 0
        L_0x0613:
            com.google.android.gms.internal.ads.zzhy[] r5 = r8.f10157a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r6 = r5.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r4 >= r6) goto L_0x0666
            r5 = r5[r4]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzoe r6 = r1.zzbhv     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzoc r6 = r6.zzbe(r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r6 == 0) goto L_0x0663
            if (r2 != 0) goto L_0x0660
            boolean r6 = r5.zzee()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r6 != 0) goto L_0x0663
            com.google.android.gms.internal.ads.zzoe r6 = r3.zzbhv     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzoc r6 = r6.zzbe(r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzia[] r7 = r1.zzbhx     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r7 = r7[r4]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzia[] r11 = r3.zzbhx     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r11 = r11[r4]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r6 == 0) goto L_0x0660
            boolean r7 = r11.equals(r7)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r7 == 0) goto L_0x0660
            int r7 = r6.length()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhp[] r11 = new com.google.android.gms.internal.ads.zzhp[r7]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r12 = 0
        L_0x0647:
            if (r12 >= r7) goto L_0x0652
            com.google.android.gms.internal.ads.zzhp r13 = r6.zzbc(r12)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r11[r12] = r13     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r12 = r12 + 1
            goto L_0x0647
        L_0x0652:
            com.google.android.gms.internal.ads.md0 r6 = r8.f10154E     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zznn[] r7 = r6.f9940d     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r7 = r7[r4]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r12 = r6.mo14435e()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r5.zza(r11, r7, r12)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0663
        L_0x0660:
            r5.zzed()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0663:
            int r4 = r4 + 1
            goto L_0x0613
        L_0x0666:
            com.google.android.gms.internal.ads.md0 r1 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2 = 10
            if (r1 != 0) goto L_0x0674
            r34.m6523A()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6532g(r14, r2)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x07cc
        L_0x0674:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzpq.beginSection(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r34.m6546y()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r1 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzmy r1 = r1.f9937a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzho r4 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r4 = r4.zzagu     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.zzee(r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhy[] r1 = r8.f10173q     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r4 = r1.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r5 = 0
            r6 = 1
            r7 = 1
        L_0x068d:
            if (r5 >= r4) goto L_0x06c4
            r11 = r1[r5]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r12 = r8.f10152C     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r2 = r8.f10182z     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r11.zzb(r12, r2)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r7 == 0) goto L_0x06a2
            boolean r2 = r11.zzfe()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == 0) goto L_0x06a2
            r7 = 1
            goto L_0x06a3
        L_0x06a2:
            r7 = 0
        L_0x06a3:
            boolean r2 = r11.isReady()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != 0) goto L_0x06b2
            boolean r2 = r11.zzfe()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 == 0) goto L_0x06b0
            goto L_0x06b2
        L_0x06b0:
            r2 = 0
            goto L_0x06b3
        L_0x06b2:
            r2 = 1
        L_0x06b3:
            if (r2 != 0) goto L_0x06b8
            r11.zzef()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x06b8:
            if (r6 == 0) goto L_0x06be
            if (r2 == 0) goto L_0x06be
            r6 = 1
            goto L_0x06bf
        L_0x06be:
            r6 = 0
        L_0x06bf:
            int r5 = r5 + 1
            r2 = 10
            goto L_0x068d
        L_0x06c4:
            if (r6 != 0) goto L_0x06c9
            r34.m6523A()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x06c9:
            com.google.android.gms.internal.ads.zzpg r1 = r8.f10171o     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x06ec
            com.google.android.gms.internal.ads.zzhv r1 = r1.zzfs()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhv r2 = r8.f10169m     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean r2 = r1.equals(r2)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r2 != 0) goto L_0x06ec
            r8.f10169m = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzpo r2 = r8.f10161e     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzpg r3 = r8.f10171o     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.zza(r3)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Handler r2 = r8.f10164h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x06ec:
            com.google.android.gms.internal.ads.zzhz r1 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r2 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r2.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r3 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r1 = r1.zza((int) r2, (com.google.android.gms.internal.ads.zzib) r3, (boolean) r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r1 = r1.zzaif     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r7 == 0) goto L_0x071d
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x070d
            com.google.android.gms.internal.ads.zzho r3 = r8.f10168l     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r3 = r3.zzagu     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x071d
        L_0x070d:
            com.google.android.gms.internal.ads.md0 r3 = r8.f10155F     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean r3 = r3.f9945i     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 == 0) goto L_0x071d
            r3 = 4
            r8.m6528b(r3)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r34.m6545x()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r4 = 2
            goto L_0x0795
        L_0x071d:
            int r3 = r8.f10178v     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r4 = 2
            if (r3 != r4) goto L_0x077c
            com.google.android.gms.internal.ads.zzhy[] r3 = r8.f10173q     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r3 = r3.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 <= 0) goto L_0x076a
            if (r6 == 0) goto L_0x0768
            boolean r1 = r8.f10176t     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r2 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean r3 = r2.f9946j     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 != 0) goto L_0x0734
            long r2 = r2.f9944h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x073a
        L_0x0734:
            com.google.android.gms.internal.ads.zzmy r2 = r2.f9937a     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r2 = r2.zzhr()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x073a:
            r5 = -9223372036854775808
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0754
            com.google.android.gms.internal.ads.md0 r2 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean r3 = r2.f9945i     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 == 0) goto L_0x0748
            r1 = 1
            goto L_0x0764
        L_0x0748:
            com.google.android.gms.internal.ads.zzhz r3 = r8.f10156G     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r2.f9943g     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r5 = r8.f10167k     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzib r2 = r3.zza((int) r2, (com.google.android.gms.internal.ads.zzib) r5, (boolean) r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r2 = r2.zzaif     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0754:
            com.google.android.gms.internal.ads.zzht r5 = r8.f10160d     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.md0 r6 = r8.f10153D     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r11 = r8.f10152C     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r6 = r6.mo14435e()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            long r11 = r11 - r6
            long r2 = r2 - r11
            boolean r1 = r5.zzc(r2, r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0764:
            if (r1 == 0) goto L_0x0768
            r1 = 1
            goto L_0x076e
        L_0x0768:
            r1 = 0
            goto L_0x076e
        L_0x076a:
            boolean r1 = r8.m6543v(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x076e:
            if (r1 == 0) goto L_0x0795
            r1 = 3
            r8.m6528b(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            boolean r1 = r8.f10175s     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x0795
            r34.m6544w()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x0795
        L_0x077c:
            r5 = 3
            if (r3 != r5) goto L_0x0795
            com.google.android.gms.internal.ads.zzhy[] r3 = r8.f10173q     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r3 = r3.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r3 <= 0) goto L_0x0785
            goto L_0x0789
        L_0x0785:
            boolean r6 = r8.m6543v(r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0789:
            if (r6 != 0) goto L_0x0795
            boolean r1 = r8.f10175s     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10176t = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6528b(r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r34.m6545x()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x0795:
            int r1 = r8.f10178v     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 != r4) goto L_0x07a6
            com.google.android.gms.internal.ads.zzhy[] r1 = r8.f10173q     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r2 = r1.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x079c:
            if (r9 >= r2) goto L_0x07a6
            r3 = r1[r9]     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3.zzef()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r9 = r9 + 1
            goto L_0x079c
        L_0x07a6:
            boolean r1 = r8.f10175s     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x07af
            int r1 = r8.f10178v     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2 = 3
            if (r1 == r2) goto L_0x07b3
        L_0x07af:
            int r1 = r8.f10178v     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 != r4) goto L_0x07b9
        L_0x07b3:
            r1 = 10
            r8.m6532g(r14, r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x07c9
        L_0x07b9:
            com.google.android.gms.internal.ads.zzhy[] r1 = r8.f10173q     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r1 = r1.length     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x07c4
            r1 = 1000(0x3e8, double:4.94E-321)
            r8.m6532g(r14, r1)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x07c9
        L_0x07c4:
            android.os.Handler r1 = r8.f10162f     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.removeMessages(r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x07c9:
            com.google.android.gms.internal.ads.zzpq.endSection()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x07cc:
            return r10
        L_0x07cd:
            r4 = 2
            int r1 = r1.arg1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x07d4
            r1 = 1
            goto L_0x07d5
        L_0x07d4:
            r1 = 0
        L_0x07d5:
            r8.f10176t = r9     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10175s = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 != 0) goto L_0x07e2
            r34.m6545x()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r34.m6546y()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x07f7
        L_0x07e2:
            int r1 = r8.f10178v     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2 = 3
            if (r1 != r2) goto L_0x07f0
            r34.m6544w()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Handler r1 = r8.f10162f     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendEmptyMessage(r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            goto L_0x07f7
        L_0x07f0:
            if (r1 != r4) goto L_0x07f7
            android.os.Handler r1 = r8.f10162f     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendEmptyMessage(r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x07f7:
            return r10
        L_0x07f8:
            r4 = 2
            java.lang.Object r2 = r1.obj     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzna r2 = (com.google.android.gms.internal.ads.zzna) r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            int r1 = r1.arg1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x0803
            r1 = 1
            goto L_0x0804
        L_0x0803:
            r1 = 0
        L_0x0804:
            android.os.Handler r3 = r8.f10164h     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3.sendEmptyMessage(r9)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6526E(r10)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzht r3 = r8.f10160d     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r3.zzfb()     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            if (r1 == 0) goto L_0x081f
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r9, r5)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.f10168l = r1     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
        L_0x081f:
            r8.f10172p = r2     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            com.google.android.gms.internal.ads.zzhd r1 = r8.f10165i     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r2.zza(r1, r10, r8)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r8.m6528b(r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            android.os.Handler r1 = r8.f10162f     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            r1.sendEmptyMessage(r4)     // Catch:{ zzhe -> 0x0834, IOException -> 0x082f, RuntimeException -> 0x0839 }
            return r10
        L_0x082f:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x0859
        L_0x0834:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x0875
        L_0x0839:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Internal runtime error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.f10164h
            com.google.android.gms.internal.ads.zzhe r1 = com.google.android.gms.internal.ads.zzhe.m8960a(r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.m6547z()
            return r10
        L_0x0855:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x0859:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Source error."
            android.util.Log.e(r2, r4, r1)
            android.os.Handler r2 = r8.f10164h
            com.google.android.gms.internal.ads.zzhe r1 = com.google.android.gms.internal.ads.zzhe.zza(r1)
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.m6547z()
            return r10
        L_0x0871:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x0875:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Renderer error."
            android.util.Log.e(r2, r4, r1)
            android.os.Handler r2 = r8.f10164h
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.m6547z()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.nd0.handleMessage(android.os.Message):boolean");
    }

    /* renamed from: j */
    public final void mo14484j(zzhz zzhz, int i, long j) {
        this.f10162f.obtainMessage(3, new od0(zzhz, i, j)).sendToTarget();
    }

    /* renamed from: k */
    public final void mo14485k(zzna zzna, boolean z) {
        this.f10162f.obtainMessage(0, 1, 0, zzna).sendToTarget();
    }

    /* renamed from: m */
    public final void mo14486m(zzhi... zzhiArr) {
        if (this.f10174r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.f10180x++;
        this.f10162f.obtainMessage(11, zzhiArr).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x001f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo14487s(com.google.android.gms.internal.ads.zzhi... r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f10174r     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r0 = "Ignoring messages sent after release."
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            int r0 = r3.f10180x     // Catch:{ all -> 0x0031 }
            int r1 = r0 + 1
            r3.f10180x = r1     // Catch:{ all -> 0x0031 }
            android.os.Handler r1 = r3.f10162f     // Catch:{ all -> 0x0031 }
            r2 = 11
            android.os.Message r4 = r1.obtainMessage(r2, r4)     // Catch:{ all -> 0x0031 }
            r4.sendToTarget()     // Catch:{ all -> 0x0031 }
        L_0x001f:
            int r4 = r3.f10181y     // Catch:{ all -> 0x0031 }
            if (r4 > r0) goto L_0x002f
            r3.wait()     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x001f
        L_0x0027:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            r4.interrupt()     // Catch:{ all -> 0x0031 }
            goto L_0x001f
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x0035
        L_0x0034:
            throw r4
        L_0x0035:
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.nd0.mo14487s(com.google.android.gms.internal.ads.zzhi[]):void");
    }

    public final void zza(zzmy zzmy) {
        this.f10162f.obtainMessage(8, zzmy).sendToTarget();
    }

    public final void zzb(zzhz zzhz, Object obj) {
        this.f10162f.obtainMessage(7, Pair.create(zzhz, obj)).sendToTarget();
    }

    public final void zzes() {
        this.f10162f.sendEmptyMessage(10);
    }

    public final /* synthetic */ void zza(zznm zznm) {
        this.f10162f.obtainMessage(9, (zzmy) zznm).sendToTarget();
    }
}
