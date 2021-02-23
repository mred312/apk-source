package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class hg0 {

    /* renamed from: a */
    private int f9200a = 1000;

    /* renamed from: b */
    private int[] f9201b = new int[1000];

    /* renamed from: c */
    private long[] f9202c = new long[1000];

    /* renamed from: d */
    private int[] f9203d = new int[1000];

    /* renamed from: e */
    private int[] f9204e = new int[1000];

    /* renamed from: f */
    private long[] f9205f = new long[1000];

    /* renamed from: g */
    private zzkg[] f9206g = new zzkg[1000];

    /* renamed from: h */
    private zzhp[] f9207h = new zzhp[1000];

    /* renamed from: i */
    private int f9208i;

    /* renamed from: j */
    private int f9209j;

    /* renamed from: k */
    private int f9210k;

    /* renamed from: l */
    private int f9211l;

    /* renamed from: m */
    private long f9212m = Long.MIN_VALUE;

    /* renamed from: n */
    private long f9213n = Long.MIN_VALUE;

    /* renamed from: o */
    private boolean f9214o = true;

    /* renamed from: p */
    private boolean f9215p = true;

    /* renamed from: q */
    private zzhp f9216q;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        return -3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int mo14206a(com.google.android.gms.internal.ads.zzhr r5, com.google.android.gms.internal.ads.zzjl r6, boolean r7, boolean r8, com.google.android.gms.internal.ads.zzhp r9, com.google.android.gms.internal.ads.zznj r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.mo14215j()     // Catch:{ all -> 0x0096 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0020
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.setFlags(r5)     // Catch:{ all -> 0x0096 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.gms.internal.ads.zzhp r6 = r4.f9216q     // Catch:{ all -> 0x0096 }
            if (r6 == 0) goto L_0x001e
            if (r7 != 0) goto L_0x001a
            if (r6 == r9) goto L_0x001e
        L_0x001a:
            r5.zzahv = r6     // Catch:{ all -> 0x0096 }
            monitor-exit(r4)
            return r1
        L_0x001e:
            monitor-exit(r4)
            return r2
        L_0x0020:
            if (r7 != 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzhp[] r7 = r4.f9207h     // Catch:{ all -> 0x0096 }
            int r8 = r4.f9210k     // Catch:{ all -> 0x0096 }
            r7 = r7[r8]     // Catch:{ all -> 0x0096 }
            if (r7 == r9) goto L_0x002b
            goto L_0x008c
        L_0x002b:
            java.nio.ByteBuffer r5 = r6.zzda     // Catch:{ all -> 0x0096 }
            r7 = 0
            r9 = 1
            if (r5 != 0) goto L_0x0033
            r5 = 1
            goto L_0x0034
        L_0x0033:
            r5 = 0
        L_0x0034:
            if (r5 == 0) goto L_0x0038
            monitor-exit(r4)
            return r2
        L_0x0038:
            long[] r5 = r4.f9205f     // Catch:{ all -> 0x0096 }
            r0 = r5[r8]     // Catch:{ all -> 0x0096 }
            r6.zzanz = r0     // Catch:{ all -> 0x0096 }
            int[] r5 = r4.f9204e     // Catch:{ all -> 0x0096 }
            r5 = r5[r8]     // Catch:{ all -> 0x0096 }
            r6.setFlags(r5)     // Catch:{ all -> 0x0096 }
            int[] r5 = r4.f9203d     // Catch:{ all -> 0x0096 }
            int r8 = r4.f9210k     // Catch:{ all -> 0x0096 }
            r5 = r5[r8]     // Catch:{ all -> 0x0096 }
            r10.size = r5     // Catch:{ all -> 0x0096 }
            long[] r5 = r4.f9202c     // Catch:{ all -> 0x0096 }
            r0 = r5[r8]     // Catch:{ all -> 0x0096 }
            r10.zzawl = r0     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.ads.zzkg[] r5 = r4.f9206g     // Catch:{ all -> 0x0096 }
            r5 = r5[r8]     // Catch:{ all -> 0x0096 }
            r10.zzaro = r5     // Catch:{ all -> 0x0096 }
            long r0 = r4.f9212m     // Catch:{ all -> 0x0096 }
            long r5 = r6.zzanz     // Catch:{ all -> 0x0096 }
            long r5 = java.lang.Math.max(r0, r5)     // Catch:{ all -> 0x0096 }
            r4.f9212m = r5     // Catch:{ all -> 0x0096 }
            int r5 = r4.f9208i     // Catch:{ all -> 0x0096 }
            int r5 = r5 - r9
            r4.f9208i = r5     // Catch:{ all -> 0x0096 }
            int r6 = r4.f9210k     // Catch:{ all -> 0x0096 }
            int r6 = r6 + r9
            r4.f9210k = r6     // Catch:{ all -> 0x0096 }
            int r8 = r4.f9209j     // Catch:{ all -> 0x0096 }
            int r8 = r8 + r9
            r4.f9209j = r8     // Catch:{ all -> 0x0096 }
            int r8 = r4.f9200a     // Catch:{ all -> 0x0096 }
            if (r6 != r8) goto L_0x0078
            r4.f9210k = r7     // Catch:{ all -> 0x0096 }
        L_0x0078:
            if (r5 <= 0) goto L_0x0081
            long[] r5 = r4.f9202c     // Catch:{ all -> 0x0096 }
            int r6 = r4.f9210k     // Catch:{ all -> 0x0096 }
            r6 = r5[r6]     // Catch:{ all -> 0x0096 }
            goto L_0x0088
        L_0x0081:
            long r5 = r10.zzawl     // Catch:{ all -> 0x0096 }
            int r7 = r10.size     // Catch:{ all -> 0x0096 }
            long r7 = (long) r7     // Catch:{ all -> 0x0096 }
            long r5 = r5 + r7
            r6 = r5
        L_0x0088:
            r10.zzbgi = r6     // Catch:{ all -> 0x0096 }
            monitor-exit(r4)
            return r3
        L_0x008c:
            com.google.android.gms.internal.ads.zzhp[] r6 = r4.f9207h     // Catch:{ all -> 0x0096 }
            int r7 = r4.f9210k     // Catch:{ all -> 0x0096 }
            r6 = r6[r7]     // Catch:{ all -> 0x0096 }
            r5.zzahv = r6     // Catch:{ all -> 0x0096 }
            monitor-exit(r4)
            return r1
        L_0x0096:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hg0.mo14206a(com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzjl, boolean, boolean, com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zznj):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00cc, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo14207b(long r6, int r8, long r9, int r11, com.google.android.gms.internal.ads.zzkg r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f9214o     // Catch:{ all -> 0x00cd }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.f9214o = r1     // Catch:{ all -> 0x00cd }
        L_0x000e:
            boolean r0 = r5.f9215p     // Catch:{ all -> 0x00cd }
            r2 = 1
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.gms.internal.ads.zzpc.checkState(r0)     // Catch:{ all -> 0x00cd }
            r5.mo14209d(r6)     // Catch:{ all -> 0x00cd }
            long[] r0 = r5.f9205f     // Catch:{ all -> 0x00cd }
            int r3 = r5.f9211l     // Catch:{ all -> 0x00cd }
            r0[r3] = r6     // Catch:{ all -> 0x00cd }
            long[] r6 = r5.f9202c     // Catch:{ all -> 0x00cd }
            r6[r3] = r9     // Catch:{ all -> 0x00cd }
            int[] r7 = r5.f9203d     // Catch:{ all -> 0x00cd }
            r7[r3] = r11     // Catch:{ all -> 0x00cd }
            int[] r7 = r5.f9204e     // Catch:{ all -> 0x00cd }
            r7[r3] = r8     // Catch:{ all -> 0x00cd }
            com.google.android.gms.internal.ads.zzkg[] r7 = r5.f9206g     // Catch:{ all -> 0x00cd }
            r7[r3] = r12     // Catch:{ all -> 0x00cd }
            com.google.android.gms.internal.ads.zzhp[] r7 = r5.f9207h     // Catch:{ all -> 0x00cd }
            com.google.android.gms.internal.ads.zzhp r8 = r5.f9216q     // Catch:{ all -> 0x00cd }
            r7[r3] = r8     // Catch:{ all -> 0x00cd }
            int[] r7 = r5.f9201b     // Catch:{ all -> 0x00cd }
            r7[r3] = r1     // Catch:{ all -> 0x00cd }
            int r7 = r5.f9208i     // Catch:{ all -> 0x00cd }
            int r7 = r7 + r2
            r5.f9208i = r7     // Catch:{ all -> 0x00cd }
            int r8 = r5.f9200a     // Catch:{ all -> 0x00cd }
            if (r7 != r8) goto L_0x00c4
            int r7 = r8 + 1000
            int[] r9 = new int[r7]     // Catch:{ all -> 0x00cd }
            long[] r10 = new long[r7]     // Catch:{ all -> 0x00cd }
            long[] r11 = new long[r7]     // Catch:{ all -> 0x00cd }
            int[] r12 = new int[r7]     // Catch:{ all -> 0x00cd }
            int[] r0 = new int[r7]     // Catch:{ all -> 0x00cd }
            com.google.android.gms.internal.ads.zzkg[] r2 = new com.google.android.gms.internal.ads.zzkg[r7]     // Catch:{ all -> 0x00cd }
            com.google.android.gms.internal.ads.zzhp[] r3 = new com.google.android.gms.internal.ads.zzhp[r7]     // Catch:{ all -> 0x00cd }
            int r4 = r5.f9210k     // Catch:{ all -> 0x00cd }
            int r8 = r8 - r4
            java.lang.System.arraycopy(r6, r4, r10, r1, r8)     // Catch:{ all -> 0x00cd }
            long[] r6 = r5.f9205f     // Catch:{ all -> 0x00cd }
            int r4 = r5.f9210k     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r6, r4, r11, r1, r8)     // Catch:{ all -> 0x00cd }
            int[] r6 = r5.f9204e     // Catch:{ all -> 0x00cd }
            int r4 = r5.f9210k     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r6, r4, r12, r1, r8)     // Catch:{ all -> 0x00cd }
            int[] r6 = r5.f9203d     // Catch:{ all -> 0x00cd }
            int r4 = r5.f9210k     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r6, r4, r0, r1, r8)     // Catch:{ all -> 0x00cd }
            com.google.android.gms.internal.ads.zzkg[] r6 = r5.f9206g     // Catch:{ all -> 0x00cd }
            int r4 = r5.f9210k     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r6, r4, r2, r1, r8)     // Catch:{ all -> 0x00cd }
            com.google.android.gms.internal.ads.zzhp[] r6 = r5.f9207h     // Catch:{ all -> 0x00cd }
            int r4 = r5.f9210k     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r6, r4, r3, r1, r8)     // Catch:{ all -> 0x00cd }
            int[] r6 = r5.f9201b     // Catch:{ all -> 0x00cd }
            int r4 = r5.f9210k     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r6, r4, r9, r1, r8)     // Catch:{ all -> 0x00cd }
            int r6 = r5.f9210k     // Catch:{ all -> 0x00cd }
            long[] r4 = r5.f9202c     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r4, r1, r10, r8, r6)     // Catch:{ all -> 0x00cd }
            long[] r4 = r5.f9205f     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r4, r1, r11, r8, r6)     // Catch:{ all -> 0x00cd }
            int[] r4 = r5.f9204e     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r4, r1, r12, r8, r6)     // Catch:{ all -> 0x00cd }
            int[] r4 = r5.f9203d     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r4, r1, r0, r8, r6)     // Catch:{ all -> 0x00cd }
            com.google.android.gms.internal.ads.zzkg[] r4 = r5.f9206g     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r4, r1, r2, r8, r6)     // Catch:{ all -> 0x00cd }
            com.google.android.gms.internal.ads.zzhp[] r4 = r5.f9207h     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r4, r1, r3, r8, r6)     // Catch:{ all -> 0x00cd }
            int[] r4 = r5.f9201b     // Catch:{ all -> 0x00cd }
            java.lang.System.arraycopy(r4, r1, r9, r8, r6)     // Catch:{ all -> 0x00cd }
            r5.f9202c = r10     // Catch:{ all -> 0x00cd }
            r5.f9205f = r11     // Catch:{ all -> 0x00cd }
            r5.f9204e = r12     // Catch:{ all -> 0x00cd }
            r5.f9203d = r0     // Catch:{ all -> 0x00cd }
            r5.f9206g = r2     // Catch:{ all -> 0x00cd }
            r5.f9207h = r3     // Catch:{ all -> 0x00cd }
            r5.f9201b = r9     // Catch:{ all -> 0x00cd }
            r5.f9210k = r1     // Catch:{ all -> 0x00cd }
            int r6 = r5.f9200a     // Catch:{ all -> 0x00cd }
            r5.f9211l = r6     // Catch:{ all -> 0x00cd }
            r5.f9208i = r6     // Catch:{ all -> 0x00cd }
            r5.f9200a = r7     // Catch:{ all -> 0x00cd }
            monitor-exit(r5)
            return
        L_0x00c4:
            int r3 = r3 + r2
            r5.f9211l = r3     // Catch:{ all -> 0x00cd }
            if (r3 != r8) goto L_0x00cb
            r5.f9211l = r1     // Catch:{ all -> 0x00cd }
        L_0x00cb:
            monitor-exit(r5)
            return
        L_0x00cd:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hg0.mo14207b(long, int, long, int, com.google.android.gms.internal.ads.zzkg):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        return -1;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long mo14208c(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.mo14215j()     // Catch:{ all -> 0x005c }
            r1 = -1
            if (r0 == 0) goto L_0x005a
            long[] r0 = r8.f9205f     // Catch:{ all -> 0x005c }
            int r3 = r8.f9210k     // Catch:{ all -> 0x005c }
            r4 = r0[r3]     // Catch:{ all -> 0x005c }
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x005a
        L_0x0014:
            long r4 = r8.f9213n     // Catch:{ all -> 0x005c }
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x001e
            if (r11 != 0) goto L_0x001e
            monitor-exit(r8)
            return r1
        L_0x001e:
            r11 = 0
            r0 = -1
            r4 = -1
        L_0x0021:
            int r5 = r8.f9211l     // Catch:{ all -> 0x005c }
            if (r3 == r5) goto L_0x003e
            long[] r5 = r8.f9205f     // Catch:{ all -> 0x005c }
            r6 = r5[r3]     // Catch:{ all -> 0x005c }
            int r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x003e
            int[] r5 = r8.f9204e     // Catch:{ all -> 0x005c }
            r5 = r5[r3]     // Catch:{ all -> 0x005c }
            r5 = r5 & 1
            if (r5 == 0) goto L_0x0036
            r4 = r11
        L_0x0036:
            int r3 = r3 + 1
            int r5 = r8.f9200a     // Catch:{ all -> 0x005c }
            int r3 = r3 % r5
            int r11 = r11 + 1
            goto L_0x0021
        L_0x003e:
            if (r4 != r0) goto L_0x0042
            monitor-exit(r8)
            return r1
        L_0x0042:
            int r9 = r8.f9210k     // Catch:{ all -> 0x005c }
            int r9 = r9 + r4
            int r10 = r8.f9200a     // Catch:{ all -> 0x005c }
            int r9 = r9 % r10
            r8.f9210k = r9     // Catch:{ all -> 0x005c }
            int r10 = r8.f9209j     // Catch:{ all -> 0x005c }
            int r10 = r10 + r4
            r8.f9209j = r10     // Catch:{ all -> 0x005c }
            int r10 = r8.f9208i     // Catch:{ all -> 0x005c }
            int r10 = r10 - r4
            r8.f9208i = r10     // Catch:{ all -> 0x005c }
            long[] r10 = r8.f9202c     // Catch:{ all -> 0x005c }
            r9 = r10[r9]     // Catch:{ all -> 0x005c }
            monitor-exit(r8)
            return r9
        L_0x005a:
            monitor-exit(r8)
            return r1
        L_0x005c:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x0060
        L_0x005f:
            throw r9
        L_0x0060:
            goto L_0x005f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hg0.mo14208c(long, boolean):long");
    }

    /* renamed from: d */
    public final synchronized void mo14209d(long j) {
        this.f9213n = Math.max(this.f9213n, j);
    }

    /* renamed from: e */
    public final synchronized boolean mo14210e(zzhp zzhp) {
        if (zzhp == null) {
            this.f9215p = true;
            return false;
        }
        this.f9215p = false;
        if (zzpt.zza(zzhp, this.f9216q)) {
            return false;
        }
        this.f9216q = zzhp;
        return true;
    }

    /* renamed from: f */
    public final synchronized long mo14211f() {
        return Math.max(this.f9212m, this.f9213n);
    }

    /* renamed from: g */
    public final void mo14212g() {
        this.f9209j = 0;
        this.f9210k = 0;
        this.f9211l = 0;
        this.f9208i = 0;
        this.f9214o = true;
    }

    /* renamed from: h */
    public final void mo14213h() {
        this.f9212m = Long.MIN_VALUE;
        this.f9213n = Long.MIN_VALUE;
    }

    /* renamed from: i */
    public final int mo14214i() {
        return this.f9209j + this.f9208i;
    }

    /* renamed from: j */
    public final synchronized boolean mo14215j() {
        return this.f9208i != 0;
    }

    /* renamed from: k */
    public final synchronized zzhp mo14216k() {
        if (this.f9215p) {
            return null;
        }
        return this.f9216q;
    }

    /* renamed from: l */
    public final synchronized long mo14217l() {
        if (!mo14215j()) {
            return -1;
        }
        int i = this.f9210k;
        int i2 = this.f9208i;
        int i3 = this.f9200a;
        int i4 = ((i + i2) - 1) % i3;
        this.f9210k = (i + i2) % i3;
        this.f9209j += i2;
        this.f9208i = 0;
        return this.f9202c[i4] + ((long) this.f9203d[i4]);
    }
}
