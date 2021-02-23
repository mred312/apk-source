package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdp implements zzdv {
    @Nullable

    /* renamed from: m */
    private static zzdp f15841m;

    /* renamed from: a */
    private final Context f15842a;

    /* renamed from: b */
    private final zzdtz f15843b;

    /* renamed from: c */
    private final zzdui f15844c;

    /* renamed from: d */
    private final zzduj f15845d;

    /* renamed from: e */
    private final wc0 f15846e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final zzdsi f15847f;

    /* renamed from: g */
    private final Executor f15848g;

    /* renamed from: h */
    private final zzgn f15849h;

    /* renamed from: i */
    private final zzduf f15850i;
    @VisibleForTesting

    /* renamed from: j */
    private volatile long f15851j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Object f15852k = new Object();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public volatile boolean f15853l;

    @VisibleForTesting
    private zzdp(@NonNull Context context, @NonNull zzdsi zzdsi, @NonNull zzdtz zzdtz, @NonNull zzdui zzdui, @NonNull zzduj zzduj, @NonNull wc0 wc0, @NonNull Executor executor, @NonNull zzdsg zzdsg, zzgn zzgn) {
        this.f15842a = context;
        this.f15847f = zzdsi;
        this.f15843b = zzdtz;
        this.f15844c = zzdui;
        this.f15845d = zzduj;
        this.f15846e = wc0;
        this.f15848g = executor;
        this.f15849h = zzgn;
        this.f15850i = new C2531vz(this, zzdsg);
    }

    /* renamed from: a */
    static zzdp m8445a(@NonNull Context context, @NonNull zzdsi zzdsi, @NonNull zzdsj zzdsj) {
        return m8446b(context, zzdsi, zzdsj, Executors.newCachedThreadPool());
    }

    /* renamed from: b */
    private static zzdp m8446b(@NonNull Context context, @NonNull zzdsi zzdsi, @NonNull zzdsj zzdsj, @NonNull Executor executor) {
        zzdsv zza = zzdsv.zza(context, executor, zzdsi, zzdsj);
        zzey zzey = new zzey(context);
        wc0 wc0 = new wc0(zzdsj, zza, new zzfh(context, zzey), zzey);
        zzgn zzaxp = new zzdtl(context, zzdsi).zzaxp();
        zzdsg zzdsg = new zzdsg();
        return new zzdp(context, zzdsi, new zzdtz(context, zzaxp), new zzdui(context, zzaxp, new i00(zzdsi)), new zzduj(context, wc0, zzdsi, zzdsg), wc0, executor, zzdsg, zzaxp);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a4 A[Catch:{ zzeks -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1 A[Catch:{ zzeks -> 0x0112 }] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m8450g() {
        /*
            r12 = this;
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = com.google.android.gms.internal.ads.zzduh.zzhru
            com.google.android.gms.internal.ads.zzdua r3 = r12.m8454k(r2)
            r4 = 0
            if (r3 == 0) goto L_0x0020
            com.google.android.gms.internal.ads.zzgt r4 = r3.zzaxz()
            java.lang.String r4 = r4.zzdg()
            com.google.android.gms.internal.ads.zzgt r3 = r3.zzaxz()
            java.lang.String r3 = r3.zzdh()
            r9 = r3
            r8 = r4
            goto L_0x0022
        L_0x0020:
            r8 = r4
            r9 = r8
        L_0x0022:
            android.content.Context r5 = r12.f15842a     // Catch:{ zzeks -> 0x0112 }
            r6 = 1
            com.google.android.gms.internal.ads.zzgn r7 = r12.f15849h     // Catch:{ zzeks -> 0x0112 }
            java.lang.String r10 = "1"
            com.google.android.gms.internal.ads.zzdsi r11 = r12.f15847f     // Catch:{ zzeks -> 0x0112 }
            com.google.android.gms.internal.ads.zzdud r3 = com.google.android.gms.internal.ads.zzdsr.zza(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ zzeks -> 0x0112 }
            byte[] r4 = r3.zzhrt     // Catch:{ zzeks -> 0x0112 }
            if (r4 == 0) goto L_0x0105
            int r5 = r4.length     // Catch:{ zzeks -> 0x0112 }
            if (r5 != 0) goto L_0x0038
            goto L_0x0105
        L_0x0038:
            com.google.android.gms.internal.ads.zzeiu r4 = com.google.android.gms.internal.ads.zzeiu.zzt(r4)     // Catch:{ zzeks -> 0x0112 }
            com.google.android.gms.internal.ads.zzeju r5 = com.google.android.gms.internal.ads.zzeju.zzbhf()     // Catch:{ zzeks -> 0x0112 }
            com.google.android.gms.internal.ads.zzgp r4 = com.google.android.gms.internal.ads.zzgp.zza(r4, r5)     // Catch:{ zzeks -> 0x0112 }
            com.google.android.gms.internal.ads.zzgt r5 = r4.zzdc()     // Catch:{ zzeks -> 0x0112 }
            java.lang.String r5 = r5.zzdg()     // Catch:{ zzeks -> 0x0112 }
            boolean r5 = r5.isEmpty()     // Catch:{ zzeks -> 0x0112 }
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzgt r5 = r4.zzdc()     // Catch:{ zzeks -> 0x0112 }
            java.lang.String r5 = r5.zzdh()     // Catch:{ zzeks -> 0x0112 }
            boolean r5 = r5.isEmpty()     // Catch:{ zzeks -> 0x0112 }
            if (r5 != 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzeiu r5 = r4.zzde()     // Catch:{ zzeks -> 0x0112 }
            byte[] r5 = r5.toByteArray()     // Catch:{ zzeks -> 0x0112 }
            int r5 = r5.length     // Catch:{ zzeks -> 0x0112 }
            if (r5 != 0) goto L_0x006e
            goto L_0x00a1
        L_0x006e:
            com.google.android.gms.internal.ads.zzdua r5 = r12.m8454k(r2)     // Catch:{ zzeks -> 0x0112 }
            if (r5 != 0) goto L_0x0075
            goto L_0x00a2
        L_0x0075:
            com.google.android.gms.internal.ads.zzgt r5 = r5.zzaxz()     // Catch:{ zzeks -> 0x0112 }
            if (r5 != 0) goto L_0x007c
            goto L_0x00a2
        L_0x007c:
            com.google.android.gms.internal.ads.zzgt r8 = r4.zzdc()     // Catch:{ zzeks -> 0x0112 }
            java.lang.String r8 = r8.zzdg()     // Catch:{ zzeks -> 0x0112 }
            java.lang.String r9 = r5.zzdg()     // Catch:{ zzeks -> 0x0112 }
            boolean r8 = r8.equals(r9)     // Catch:{ zzeks -> 0x0112 }
            if (r8 == 0) goto L_0x00a2
            com.google.android.gms.internal.ads.zzgt r8 = r4.zzdc()     // Catch:{ zzeks -> 0x0112 }
            java.lang.String r8 = r8.zzdh()     // Catch:{ zzeks -> 0x0112 }
            java.lang.String r5 = r5.zzdh()     // Catch:{ zzeks -> 0x0112 }
            boolean r5 = r8.equals(r5)     // Catch:{ zzeks -> 0x0112 }
            if (r5 != 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r6 = 0
        L_0x00a2:
            if (r6 != 0) goto L_0x00b1
            com.google.android.gms.internal.ads.zzdsi r2 = r12.f15847f     // Catch:{ zzeks -> 0x0112 }
            r3 = 5010(0x1392, float:7.02E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzeks -> 0x0112 }
            long r4 = r4 - r0
            r2.zzh(r3, r4)     // Catch:{ zzeks -> 0x0112 }
            return
        L_0x00b1:
            com.google.android.gms.internal.ads.zzduf r5 = r12.f15850i     // Catch:{ zzeks -> 0x0112 }
            int r3 = r3.status     // Catch:{ zzeks -> 0x0112 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzabf.zzcqs     // Catch:{ zzeks -> 0x0112 }
            com.google.android.gms.internal.ads.zzabb r8 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ zzeks -> 0x0112 }
            java.lang.Object r6 = r8.zzd(r6)     // Catch:{ zzeks -> 0x0112 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ zzeks -> 0x0112 }
            boolean r6 = r6.booleanValue()     // Catch:{ zzeks -> 0x0112 }
            if (r6 == 0) goto L_0x00db
            r6 = 3
            if (r3 != r6) goto L_0x00d1
            com.google.android.gms.internal.ads.zzdui r3 = r12.f15844c     // Catch:{ zzeks -> 0x0112 }
            boolean r7 = r3.zza(r4)     // Catch:{ zzeks -> 0x0112 }
            goto L_0x00e1
        L_0x00d1:
            r6 = 4
            if (r3 != r6) goto L_0x00e1
            com.google.android.gms.internal.ads.zzdui r3 = r12.f15844c     // Catch:{ zzeks -> 0x0112 }
            boolean r7 = r3.zza(r4, r5)     // Catch:{ zzeks -> 0x0112 }
            goto L_0x00e1
        L_0x00db:
            com.google.android.gms.internal.ads.zzdtz r3 = r12.f15843b     // Catch:{ zzeks -> 0x0112 }
            boolean r7 = r3.zza(r4, r5)     // Catch:{ zzeks -> 0x0112 }
        L_0x00e1:
            if (r7 != 0) goto L_0x00f0
            com.google.android.gms.internal.ads.zzdsi r2 = r12.f15847f     // Catch:{ zzeks -> 0x0112 }
            r3 = 4009(0xfa9, float:5.618E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzeks -> 0x0112 }
            long r4 = r4 - r0
            r2.zzh(r3, r4)     // Catch:{ zzeks -> 0x0112 }
            return
        L_0x00f0:
            com.google.android.gms.internal.ads.zzdua r2 = r12.m8454k(r2)     // Catch:{ zzeks -> 0x0112 }
            if (r2 == 0) goto L_0x0104
            com.google.android.gms.internal.ads.zzduj r3 = r12.f15845d     // Catch:{ zzeks -> 0x0112 }
            r3.zzb(r2)     // Catch:{ zzeks -> 0x0112 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ zzeks -> 0x0112 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r12.f15851j = r2     // Catch:{ zzeks -> 0x0112 }
        L_0x0104:
            return
        L_0x0105:
            com.google.android.gms.internal.ads.zzdsi r2 = r12.f15847f     // Catch:{ zzeks -> 0x0112 }
            r3 = 5009(0x1391, float:7.019E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzeks -> 0x0112 }
            long r4 = r4 - r0
            r2.zzh(r3, r4)     // Catch:{ zzeks -> 0x0112 }
            return
        L_0x0112:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzdsi r3 = r12.f15847f
            r4 = 4002(0xfa2, float:5.608E-42)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r3.zza(r4, r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdp.m8450g():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m8451h() {
        /*
            r6 = this;
            boolean r0 = r6.f15853l
            if (r0 != 0) goto L_0x0033
            java.lang.Object r0 = r6.f15852k
            monitor-enter(r0)
            boolean r1 = r6.f15853l     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0030 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r6.f15851j     // Catch:{ all -> 0x0030 }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzduj r1 = r6.f15845d     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzdua r1 = r1.zzaye()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzff(r3)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
        L_0x002b:
            r6.zzbr()     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdp.m8451h():void");
    }

    /* renamed from: k */
    private final zzdua m8454k(int i) {
        if (!zzdtl.zza(this.f15849h)) {
            return null;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqs)).booleanValue()) {
            return this.f15844c.zzp(i);
        }
        return this.f15843b.zzp(i);
    }

    public static synchronized zzdp zza(@NonNull String str, @NonNull Context context, boolean z) {
        zzdp zzdp;
        synchronized (zzdp.class) {
            if (f15841m == null) {
                zzdsj zzaxa = zzdsj.zzawz().zzgy(str).zzbp(z).zzaxa();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzdp b = m8446b(context, zzdsi.zza(context, newCachedThreadPool), zzaxa, newCachedThreadPool);
                f15841m = b;
                b.mo17208f();
                f15841m.m8451h();
            }
            zzdp = f15841m;
        }
        return zzdp;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final synchronized void mo17208f() {
        long currentTimeMillis = System.currentTimeMillis();
        zzdua k = m8454k(zzduh.zzhru);
        if (k == null || k.zza()) {
            this.f15847f.zzh(4013, System.currentTimeMillis() - currentTimeMillis);
        } else {
            this.f15845d.zzb(k);
        }
    }

    public final void zza(int i, int i2, int i3) {
    }

    public final void zzb(View view) {
        this.f15846e.mo14974a(view);
    }

    public final void zzbr() {
        if (zzdtl.zza(this.f15849h)) {
            this.f15848g.execute(new f10(this));
        }
    }

    public final String zzb(Context context) {
        m8451h();
        zzdsl zzayd = this.f15845d.zzayd();
        if (zzayd == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzt = zzayd.zzt(context, (String) null);
        this.f15847f.zza(5001, System.currentTimeMillis() - currentTimeMillis, zzt, (Map<String, String>) null);
        return zzt;
    }

    public final void zza(MotionEvent motionEvent) {
        zzdsl zzayd = this.f15845d.zzayd();
        if (zzayd != null) {
            try {
                zzayd.zza((String) null, motionEvent);
            } catch (zzduk e) {
                this.f15847f.zza(e.zzayf(), -1, e);
            }
        }
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        m8451h();
        zzdsl zzayd = this.f15845d.zzayd();
        if (zzayd == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza = zzayd.zza(context, (String) null, str, view, activity);
        this.f15847f.zza(5000, System.currentTimeMillis() - currentTimeMillis, zza, (Map<String, String>) null);
        return zza;
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public final String zza(Context context, View view, Activity activity) {
        m8451h();
        zzdsl zzayd = this.f15845d.zzayd();
        if (zzayd == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb = zzayd.zzb(context, (String) null, view, activity);
        this.f15847f.zza(5002, System.currentTimeMillis() - currentTimeMillis, zzb, (Map<String, String>) null);
        return zzb;
    }
}
