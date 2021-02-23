package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbdj extends zzbcx implements zzpd<zzon> {

    /* renamed from: a */
    private String f13161a;

    /* renamed from: b */
    private final zzbbf f13162b;

    /* renamed from: c */
    private boolean f13163c;

    /* renamed from: d */
    private final C2166m8 f13164d = new C2166m8();

    /* renamed from: e */
    private final zzbcp f13165e = new zzbcp();

    /* renamed from: f */
    private ByteBuffer f13166f;

    /* renamed from: g */
    private boolean f13167g;

    /* renamed from: h */
    private final Object f13168h = new Object();

    /* renamed from: i */
    private final String f13169i;

    /* renamed from: j */
    private final int f13170j;

    /* renamed from: k */
    private boolean f13171k;

    public zzbdj(zzbbe zzbbe, zzbbf zzbbf) {
        super(zzbbe);
        this.f13162b = zzbbf;
        this.f13169i = zzbbe != null ? zzbbe.zzaal() : "";
        this.f13170j = zzbbe != null ? zzbbe.zzaam() : 0;
    }

    /* renamed from: e */
    private final void m7723e() {
        int b = (int) this.f13164d.mo14417b();
        int zzq = (int) this.f13165e.zzq(this.f13166f);
        int position = this.f13166f.position();
        int round = Math.round(((float) zzq) * (((float) position) / ((float) b)));
        boolean z = round > 0;
        int zzabq = zzbca.zzabq();
        int zzabr = zzbca.zzabr();
        String str = this.f13161a;
        zza(str, zzfk(str), position, b, (long) round, (long) zzq, z, zzabq, zzabr);
    }

    public final void abort() {
        this.f13163c = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.f13168h) {
            ByteBuffer byteBuffer = this.f13166f;
            if (byteBuffer != null && !this.f13167g) {
                byteBuffer.flip();
                this.f13167g = true;
            }
            this.f13163c = true;
        }
        return this.f13166f;
    }

    public final String getUrl() {
        return this.f13161a;
    }

    public final /* synthetic */ void zza(Object obj, zzoo zzoo) {
        zzon zzon = (zzon) obj;
        if (zzon instanceof zzoq) {
            this.f13164d.mo14416a((zzoq) zzon);
        }
    }

    public final boolean zzabv() {
        return this.f13171k;
    }

    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.gms.internal.ads.zzoq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.internal.ads.zzoq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: com.google.android.gms.internal.ads.zzbbw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: com.google.android.gms.internal.ads.zzoq} */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c7, code lost:
        if (r9.f13166f.remaining() > 0) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c9, code lost:
        m7723e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d0, code lost:
        if (r9.f13163c != false) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d2, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00da, code lost:
        if ((r12 - r16) < r4) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00dc, code lost:
        m7723e();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e8, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r1 = new java.lang.StringBuilder(49);
        r1.append("Timeout exceeded. Limit: ");
        r1.append(r6);
        r1.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010f, code lost:
        throw new java.io.IOException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0110, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1 = r9.f13166f.limit();
        r3 = new java.lang.StringBuilder(35);
        r3.append("Precache abort at ");
        r3.append(r1);
        r3.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0135, code lost:
        throw new java.io.IOException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013c, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfj(java.lang.String r22) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            r9.f13161a = r10
            java.lang.String r11 = r21.zzfk(r22)
            java.lang.String r12 = "error"
            r13 = 0
            com.google.android.gms.internal.ads.zzoq r0 = new com.google.android.gms.internal.ads.zzoq     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = r9.zzefk     // Catch:{ Exception -> 0x0141 }
            r3 = 0
            com.google.android.gms.internal.ads.zzbbf r1 = r9.f13162b     // Catch:{ Exception -> 0x0141 }
            int r5 = r1.zzeku     // Catch:{ Exception -> 0x0141 }
            int r6 = r1.zzekw     // Catch:{ Exception -> 0x0141 }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0141 }
            com.google.android.gms.internal.ads.zzbbf r1 = r9.f13162b     // Catch:{ Exception -> 0x0141 }
            boolean r1 = r1.zzela     // Catch:{ Exception -> 0x0141 }
            if (r1 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzbbw r8 = new com.google.android.gms.internal.ads.zzbbw     // Catch:{ Exception -> 0x0037 }
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x0037 }
            java.lang.String r4 = r9.f13169i     // Catch:{ Exception -> 0x0037 }
            int r5 = r9.f13170j     // Catch:{ Exception -> 0x0037 }
            r6 = 0
            r7 = 0
            r1 = r8
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0037 }
            r0 = r8
            goto L_0x003a
        L_0x0037:
            r0 = move-exception
            goto L_0x0144
        L_0x003a:
            android.net.Uri r1 = android.net.Uri.parse(r22)     // Catch:{ Exception -> 0x0141 }
            com.google.android.gms.internal.ads.zzoo r2 = new com.google.android.gms.internal.ads.zzoo     // Catch:{ Exception -> 0x0141 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0141 }
            r0.zza(r2)     // Catch:{ Exception -> 0x0141 }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbbe> r1 = r9.zzeog     // Catch:{ Exception -> 0x0141 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0141 }
            com.google.android.gms.internal.ads.zzbbe r1 = (com.google.android.gms.internal.ads.zzbbe) r1     // Catch:{ Exception -> 0x0141 }
            if (r1 == 0) goto L_0x0053
            r1.zza((java.lang.String) r11, (com.google.android.gms.internal.ads.zzbcx) r9)     // Catch:{ Exception -> 0x0037 }
        L_0x0053:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ Exception -> 0x0141 }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0141 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzabf.zzcmj     // Catch:{ Exception -> 0x0141 }
            com.google.android.gms.internal.ads.zzabb r5 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x0141 }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ Exception -> 0x0141 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0141 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0141 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzabf.zzcmi     // Catch:{ Exception -> 0x0141 }
            com.google.android.gms.internal.ads.zzabb r7 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x0141 }
            java.lang.Object r6 = r7.zzd(r6)     // Catch:{ Exception -> 0x0141 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x0141 }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x0141 }
            com.google.android.gms.internal.ads.zzbbf r8 = r9.f13162b     // Catch:{ Exception -> 0x0141 }
            int r8 = r8.zzekt     // Catch:{ Exception -> 0x0141 }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x0141 }
            r9.f13166f = r8     // Catch:{ Exception -> 0x0141 }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r8]     // Catch:{ Exception -> 0x0141 }
            r16 = r2
        L_0x008b:
            java.nio.ByteBuffer r14 = r9.f13166f     // Catch:{ Exception -> 0x0141 }
            int r14 = r14.remaining()     // Catch:{ Exception -> 0x0141 }
            int r14 = java.lang.Math.min(r14, r8)     // Catch:{ Exception -> 0x0141 }
            int r14 = r0.read(r15, r13, r14)     // Catch:{ Exception -> 0x0141 }
            r8 = -1
            if (r14 != r8) goto L_0x00ae
            r8 = 1
            r9.f13171k = r8     // Catch:{ Exception -> 0x0037 }
            com.google.android.gms.internal.ads.zzbcp r0 = r9.f13165e     // Catch:{ Exception -> 0x0037 }
            java.nio.ByteBuffer r1 = r9.f13166f     // Catch:{ Exception -> 0x0037 }
            long r0 = r0.zzq(r1)     // Catch:{ Exception -> 0x0037 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x0037 }
            long r0 = (long) r1     // Catch:{ Exception -> 0x0037 }
            r9.zzc(r10, r11, r0)     // Catch:{ Exception -> 0x0037 }
        L_0x00ac:
            r1 = 1
            goto L_0x00cd
        L_0x00ae:
            java.lang.Object r8 = r9.f13168h     // Catch:{ Exception -> 0x0141 }
            monitor-enter(r8)     // Catch:{ Exception -> 0x0141 }
            boolean r13 = r9.f13163c     // Catch:{ all -> 0x0136 }
            if (r13 != 0) goto L_0x00be
            java.nio.ByteBuffer r13 = r9.f13166f     // Catch:{ all -> 0x0136 }
            r18 = r12
            r12 = 0
            r13.put(r15, r12, r14)     // Catch:{ all -> 0x013f }
            goto L_0x00c0
        L_0x00be:
            r18 = r12
        L_0x00c0:
            monitor-exit(r8)     // Catch:{ all -> 0x013f }
            java.nio.ByteBuffer r8 = r9.f13166f     // Catch:{ Exception -> 0x013b }
            int r8 = r8.remaining()     // Catch:{ Exception -> 0x013b }
            if (r8 > 0) goto L_0x00ce
            r21.m7723e()     // Catch:{ Exception -> 0x013b }
            goto L_0x00ac
        L_0x00cd:
            return r1
        L_0x00ce:
            boolean r8 = r9.f13163c     // Catch:{ Exception -> 0x013b }
            if (r8 != 0) goto L_0x0110
            long r12 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x013b }
            long r19 = r12 - r16
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x00e1
            r21.m7723e()     // Catch:{ Exception -> 0x013b }
            r16 = r12
        L_0x00e1:
            long r12 = r12 - r2
            r19 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r6
            int r8 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r8 > 0) goto L_0x00f0
            r12 = r18
            r8 = 8192(0x2000, float:1.14794E-41)
            r13 = 0
            goto L_0x008b
        L_0x00f0:
            java.lang.String r12 = "downloadTimeout"
            r0 = 49
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0037 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r0 = "Timeout exceeded. Limit: "
            r1.append(r0)     // Catch:{ Exception -> 0x0037 }
            r1.append(r6)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r0 = " sec"
            r1.append(r0)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0037 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x0037 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0037 }
            throw r1     // Catch:{ Exception -> 0x0037 }
        L_0x0110:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0037 }
            java.nio.ByteBuffer r1 = r9.f13166f     // Catch:{ Exception -> 0x0037 }
            int r1 = r1.limit()     // Catch:{ Exception -> 0x0037 }
            r2 = 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0037 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r2 = "Precache abort at "
            r3.append(r2)     // Catch:{ Exception -> 0x0037 }
            r3.append(r1)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r1 = " bytes"
            r3.append(r1)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0037 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0037 }
            throw r0     // Catch:{ Exception -> 0x0037 }
        L_0x0136:
            r0 = move-exception
            r18 = r12
        L_0x0139:
            monitor-exit(r8)     // Catch:{ all -> 0x013f }
            throw r0     // Catch:{ Exception -> 0x013b }
        L_0x013b:
            r0 = move-exception
            r12 = r18
            goto L_0x0144
        L_0x013f:
            r0 = move-exception
            goto L_0x0139
        L_0x0141:
            r0 = move-exception
            r18 = r12
        L_0x0144:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r1)
            java.lang.String r1 = ":"
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = java.lang.String.valueOf(r22)
            int r1 = r1.length()
            int r1 = r1 + 34
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " Exception: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzaza.zzfa(r1)
            r9.zza(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdj.zzfj(java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public final String zzfk(String str) {
        String valueOf = String.valueOf(super.zzfk(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }
}
