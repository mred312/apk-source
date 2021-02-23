package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;
import java.util.List;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbdi extends zzbcx implements zzbck {

    /* renamed from: a */
    private zzbca f13156a;

    /* renamed from: b */
    private String f13157b;

    /* renamed from: c */
    private boolean f13158c;

    /* renamed from: d */
    private Exception f13159d;

    /* renamed from: e */
    private boolean f13160e;

    public zzbdi(zzbbe zzbbe, zzbbf zzbbf) {
        super(zzbbe);
        zzbca zzbca = new zzbca(zzbbe.getContext(), zzbbf, (zzbbe) this.zzeog.get());
        this.f13156a = zzbca;
        zzbca.zza((zzbck) this);
    }

    /* renamed from: e */
    private static String m7721e(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    /* renamed from: f */
    private final void m7722f(String str) {
        synchronized (this) {
            this.f13158c = true;
            notify();
            release();
        }
        String str2 = this.f13157b;
        if (str2 != null) {
            String zzfk = zzfk(str2);
            Exception exc = this.f13159d;
            if (exc != null) {
                zza(this.f13157b, zzfk, "badUrl", m7721e(str, exc));
            } else {
                zza(this.f13157b, zzfk, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final void abort() {
        m7722f((String) null);
    }

    public final void release() {
        zzbca zzbca = this.f13156a;
        if (zzbca != null) {
            zzbca.zza((zzbck) null);
            this.f13156a.release();
        }
        super.release();
    }

    public final void zza(String str, Exception exc) {
        String str2 = (String) zzwq.zzqe().zzd(zzabf.zzcmc);
        if (str2 != null) {
            List asList = Arrays.asList(str2.split(","));
            if (asList.contains("all") || asList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.f13159d = exc;
        zzaza.zzd("Precache error", exc);
        m7722f(str);
    }

    public final zzbca zzabu() {
        synchronized (this) {
            this.f13160e = true;
            notify();
        }
        this.f13156a.zza((zzbck) null);
        zzbca zzbca = this.f13156a;
        this.f13156a = null;
        return zzbca;
    }

    public final void zzb(boolean z, long j) {
        zzbbe zzbbe = (zzbbe) this.zzeog.get();
        if (zzbbe != null) {
            zzazj.zzegt.execute(new C2203n8(zzbbe, z, j));
        }
    }

    public final void zzdl(int i) {
        this.f13156a.zzabs().zzdt(i);
    }

    public final void zzdm(int i) {
        this.f13156a.zzabs().zzdu(i);
    }

    public final void zzdn(int i) {
        this.f13156a.zzabs().zzdn(i);
    }

    public final void zzdo(int i) {
        this.f13156a.zzabs().zzdo(i);
    }

    public final void zzdr(int i) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009d, code lost:
        r0 = r15.f13159d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009f, code lost:
        if (r0 == null) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ad, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ae, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00af, code lost:
        r17 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ba, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0150, code lost:
        r5 = r45;
        r6 = r46;
        r7 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r5.zzc(r6, r7, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zze(java.lang.String r46, java.lang.String[] r47) {
        /*
            r45 = this;
            r15 = r45
            r13 = r46
            r0 = r47
            r15.f13157b = r13
            java.lang.String r14 = r45.zzfk(r46)
            java.lang.String r17 = "error"
            r18 = 0
            int r1 = r0.length     // Catch:{ Exception -> 0x01d6 }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x01d6 }
            r2 = 0
        L_0x0014:
            int r3 = r0.length     // Catch:{ Exception -> 0x01d6 }
            if (r2 >= r3) goto L_0x0029
            r3 = r0[r2]     // Catch:{ Exception -> 0x0022 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0022 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0022 }
            int r2 = r2 + 1
            goto L_0x0014
        L_0x0022:
            r0 = move-exception
            r1 = r0
            r6 = r13
            r7 = r14
            r5 = r15
            goto L_0x01db
        L_0x0029:
            com.google.android.gms.internal.ads.zzbca r0 = r15.f13156a     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r2 = r15.zzefk     // Catch:{ Exception -> 0x01d6 }
            r0.zza((android.net.Uri[]) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x01d6 }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbbe> r0 = r15.zzeog     // Catch:{ Exception -> 0x01d6 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.internal.ads.zzbbe r0 = (com.google.android.gms.internal.ads.zzbbe) r0     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x003d
            r0.zza((java.lang.String) r14, (com.google.android.gms.internal.ads.zzbcx) r15)     // Catch:{ Exception -> 0x0022 }
        L_0x003d:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ Exception -> 0x01d6 }
            long r19 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabf.zzcmj     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x01d6 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d6 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d6 }
            long r11 = r1.longValue()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabf.zzcmi     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x01d6 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d6 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d6 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x01d6 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r9 = r1 * r3
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabf.zzcmh     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x01d6 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d6 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x01d6 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01d6 }
            long r6 = (long) r1     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabf.zzcqn     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x01d6 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d6 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x01d6 }
            boolean r21 = r1.booleanValue()     // Catch:{ Exception -> 0x01d6 }
            r22 = -1
            r1 = r22
        L_0x008e:
            monitor-enter(r45)     // Catch:{ Exception -> 0x01d6 }
            long r3 = r0.currentTimeMillis()     // Catch:{ all -> 0x01cc }
            long r3 = r3 - r19
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x01a1
            boolean r3 = r15.f13158c     // Catch:{ all -> 0x01cc }
            if (r3 == 0) goto L_0x00b3
            java.lang.Exception r0 = r15.f13159d     // Catch:{ all -> 0x01cc }
            if (r0 == 0) goto L_0x00a4
            java.lang.String r1 = "badUrl"
            throw r0     // Catch:{ all -> 0x00ae }
        L_0x00a4:
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x00ae }
            throw r0     // Catch:{ all -> 0x00ae }
        L_0x00ae:
            r0 = move-exception
            r17 = r1
            goto L_0x01cd
        L_0x00b3:
            boolean r3 = r15.f13160e     // Catch:{ all -> 0x01cc }
            r24 = 1
            if (r3 == 0) goto L_0x00bd
            monitor-exit(r45)     // Catch:{ all -> 0x01cc }
            r5 = r15
            goto L_0x0170
        L_0x00bd:
            com.google.android.gms.internal.ads.zzbca r3 = r15.f13156a     // Catch:{ all -> 0x01cc }
            com.google.android.gms.internal.ads.zzhd r3 = r3.zzabp()     // Catch:{ all -> 0x01cc }
            if (r3 == 0) goto L_0x0194
            long r4 = r3.getDuration()     // Catch:{ all -> 0x01cc }
            r25 = 0
            int r8 = (r4 > r25 ? 1 : (r4 == r25 ? 0 : -1))
            if (r8 <= 0) goto L_0x0174
            long r27 = r3.getBufferedPosition()     // Catch:{ all -> 0x01cc }
            int r3 = (r27 > r1 ? 1 : (r27 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0143
            int r1 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r1 <= 0) goto L_0x00dd
            r8 = 1
            goto L_0x00de
        L_0x00dd:
            r8 = 0
        L_0x00de:
            if (r21 == 0) goto L_0x00e9
            com.google.android.gms.internal.ads.zzbca r1 = r15.f13156a     // Catch:{ all -> 0x01cc }
            long r1 = r1.zzzo()     // Catch:{ all -> 0x01cc }
            r29 = r1
            goto L_0x00eb
        L_0x00e9:
            r29 = r22
        L_0x00eb:
            if (r21 == 0) goto L_0x00f6
            com.google.android.gms.internal.ads.zzbca r1 = r15.f13156a     // Catch:{ all -> 0x01cc }
            long r1 = r1.zzna()     // Catch:{ all -> 0x01cc }
            r31 = r1
            goto L_0x00f8
        L_0x00f6:
            r31 = r22
        L_0x00f8:
            if (r21 == 0) goto L_0x0103
            com.google.android.gms.internal.ads.zzbca r1 = r15.f13156a     // Catch:{ all -> 0x01cc }
            long r1 = r1.getTotalBytes()     // Catch:{ all -> 0x01cc }
            r33 = r1
            goto L_0x0105
        L_0x0103:
            r33 = r22
        L_0x0105:
            int r16 = com.google.android.gms.internal.ads.zzbca.zzabq()     // Catch:{ all -> 0x013b }
            int r35 = com.google.android.gms.internal.ads.zzbca.zzabr()     // Catch:{ all -> 0x013b }
            r1 = r45
            r2 = r46
            r3 = r14
            r36 = r4
            r4 = r27
            r38 = r6
            r6 = r36
            r40 = r9
            r9 = r29
            r42 = r11
            r11 = r31
            r44 = r14
            r13 = r33
            r15 = r16
            r16 = r35
            r1.zza(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x0132 }
            r1 = r27
            r3 = r36
            goto L_0x014c
        L_0x0132:
            r0 = move-exception
            r5 = r45
            r6 = r46
            r7 = r44
            goto L_0x01d0
        L_0x013b:
            r0 = move-exception
            r5 = r45
            r6 = r46
            r7 = r14
            goto L_0x01d0
        L_0x0143:
            r38 = r6
            r40 = r9
            r42 = r11
            r44 = r14
            r3 = r4
        L_0x014c:
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x015b
            r5 = r45
            r6 = r46
            r7 = r44
            r5.zzc(r6, r7, r3)     // Catch:{ all -> 0x01d4 }
            monitor-exit(r45)     // Catch:{ all -> 0x01d4 }
            goto L_0x0170
        L_0x015b:
            r5 = r45
            r6 = r46
            r7 = r44
            com.google.android.gms.internal.ads.zzbca r3 = r5.f13156a     // Catch:{ all -> 0x01d4 }
            long r3 = r3.getBytesTransferred()     // Catch:{ all -> 0x01d4 }
            int r8 = (r3 > r38 ? 1 : (r3 == r38 ? 0 : -1))
            if (r8 < 0) goto L_0x0171
            int r3 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x0171
            monitor-exit(r45)     // Catch:{ all -> 0x01d4 }
        L_0x0170:
            return r24
        L_0x0171:
            r3 = r42
            goto L_0x017c
        L_0x0174:
            r38 = r6
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            r3 = r11
        L_0x017c:
            r5.wait(r3)     // Catch:{ InterruptedException -> 0x018a }
            monitor-exit(r45)     // Catch:{ all -> 0x01d4 }
            r11 = r3
            r15 = r5
            r13 = r6
            r14 = r7
            r6 = r38
            r9 = r40
            goto L_0x008e
        L_0x018a:
            java.lang.String r1 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = "Wait interrupted."
            r0.<init>(r2)     // Catch:{ all -> 0x01c8 }
            throw r0     // Catch:{ all -> 0x01c8 }
        L_0x0194:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = "ExoPlayer was released during preloading."
            r0.<init>(r2)     // Catch:{ all -> 0x01c8 }
            throw r0     // Catch:{ all -> 0x01c8 }
        L_0x01a1:
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c8 }
            r2 = 47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c8 }
            r3.<init>(r2)     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = "Timeout reached. Limit: "
            r3.append(r2)     // Catch:{ all -> 0x01c8 }
            r8 = r40
            r3.append(r8)     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = " ms"
            r3.append(r2)     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x01c8 }
            r0.<init>(r2)     // Catch:{ all -> 0x01c8 }
            throw r0     // Catch:{ all -> 0x01c8 }
        L_0x01c8:
            r0 = move-exception
            r17 = r1
            goto L_0x01d0
        L_0x01cc:
            r0 = move-exception
        L_0x01cd:
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01d0:
            monitor-exit(r45)     // Catch:{ all -> 0x01d4 }
            throw r0     // Catch:{ Exception -> 0x01d2 }
        L_0x01d2:
            r0 = move-exception
            goto L_0x01da
        L_0x01d4:
            r0 = move-exception
            goto L_0x01d0
        L_0x01d6:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01da:
            r1 = r0
        L_0x01db:
            r0 = r17
            java.lang.String r2 = r1.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r46)
            int r3 = r3.length()
            int r3 = r3 + 34
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Failed to preload url "
            r4.append(r3)
            r4.append(r6)
            java.lang.String r3 = " Exception: "
            r4.append(r3)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.google.android.gms.internal.ads.zzaza.zzfa(r2)
            r45.release()
            java.lang.String r1 = m7721e(r0, r1)
            r5.zza(r6, r7, r0, r1)
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdi.zze(java.lang.String, java.lang.String[]):boolean");
    }

    public final boolean zzfj(String str) {
        return zze(str, new String[]{str});
    }

    /* access modifiers changed from: protected */
    public final String zzfk(String str) {
        String valueOf = String.valueOf(super.zzfk(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    public final void zzn(int i, int i2) {
    }
}
