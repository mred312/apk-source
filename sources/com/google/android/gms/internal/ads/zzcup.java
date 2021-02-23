package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcup<AdT> implements zzdyb<zzdnj, AdT> {

    /* renamed from: a */
    private final zzdro f14903a;

    /* renamed from: b */
    private final zzbrx f14904b;

    /* renamed from: c */
    private final zzdrx f14905c;

    /* renamed from: d */
    private final zzdrz f14906d;

    /* renamed from: e */
    private final Executor f14907e;

    /* renamed from: f */
    private final ScheduledExecutorService f14908f;

    /* renamed from: g */
    private final zzbod<AdT> f14909g;

    /* renamed from: h */
    private final zzcum f14910h;

    /* renamed from: i */
    private final zzcrg f14911i;

    public zzcup(zzdro zzdro, zzcum zzcum, zzbrx zzbrx, zzdrx zzdrx, zzdrz zzdrz, zzbod<AdT> zzbod, Executor executor, ScheduledExecutorService scheduledExecutorService, zzcrg zzcrg) {
        this.f14903a = zzdro;
        this.f14910h = zzcum;
        this.f14904b = zzbrx;
        this.f14905c = zzdrx;
        this.f14906d = zzdrz;
        this.f14909g = zzbod;
        this.f14907e = executor;
        this.f14908f = scheduledExecutorService;
        this.f14911i = zzcrg;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo17008a(zzdnj zzdnj, zzdmu zzdmu, zzcqz zzcqz, Throwable th) {
        zzcum zzcum = this.f14910h;
        zzdmz zzdmz = zzdnj.zzhik.zzerj;
        zzdyz zza = zzdyr.zza(zzcqz.zzb(zzdnj, zzdmu), (long) zzdmu.zzhhh, TimeUnit.MILLISECONDS, this.f14908f);
        zzcum.mo17005b(zzdmz, zzdmu, zza);
        return zza;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzdyz zzf(java.lang.Object r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzdnj r10 = (com.google.android.gms.internal.ads.zzdnj) r10
            com.google.android.gms.internal.ads.zzdnh r0 = r10.zzhik
            com.google.android.gms.internal.ads.zzdmz r0 = r0.zzerj
            int r0 = r0.responseCode
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 300(0x12c, float:4.2E-43)
            if (r0 == 0) goto L_0x0044
            if (r0 < r1) goto L_0x0027
            if (r0 >= r2) goto L_0x0027
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcvg
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0044
            java.lang.String r0 = "No fill."
            goto L_0x0046
        L_0x0027:
            if (r0 < r2) goto L_0x0030
            r3 = 400(0x190, float:5.6E-43)
            if (r0 >= r3) goto L_0x0030
            java.lang.String r0 = "No location header to follow redirect or too many redirects."
            goto L_0x0046
        L_0x0030:
            r3 = 46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Received error HTTP response code: "
            r4.append(r3)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            goto L_0x0046
        L_0x0044:
            java.lang.String r0 = "No ad config."
        L_0x0046:
            com.google.android.gms.internal.ads.zzdnh r3 = r10.zzhik
            com.google.android.gms.internal.ads.zzdmz r3 = r3.zzerj
            com.google.android.gms.internal.ads.zzdmw r3 = r3.zzhhz
            if (r3 == 0) goto L_0x0052
            java.lang.String r0 = r3.getDescription()
        L_0x0052:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabf.zzcza
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzdnh r3 = r10.zzhik
            com.google.android.gms.internal.ads.zzdmz r3 = r3.zzerj
            int r3 = r3.responseCode
            if (r3 < r1) goto L_0x006e
            if (r3 < r2) goto L_0x007a
        L_0x006e:
            com.google.android.gms.internal.ads.zzcuq r10 = new com.google.android.gms.internal.ads.zzcuq
            com.google.android.gms.internal.ads.zzdok r1 = com.google.android.gms.internal.ads.zzdok.NO_FILL
            r10.<init>(r1, r0)
            com.google.android.gms.internal.ads.zzdyz r10 = com.google.android.gms.internal.ads.zzdyr.immediateFailedFuture(r10)
            return r10
        L_0x007a:
            com.google.android.gms.internal.ads.zzdro r1 = r9.f14903a
            com.google.android.gms.internal.ads.zzdrl r2 = com.google.android.gms.internal.ads.zzdrl.RENDER_CONFIG_INIT
            com.google.android.gms.internal.ads.zzdre r1 = r1.zzu(r2)
            com.google.android.gms.internal.ads.zzcuq r2 = new com.google.android.gms.internal.ads.zzcuq
            com.google.android.gms.internal.ads.zzdok r3 = com.google.android.gms.internal.ads.zzdok.NO_FILL
            r2.<init>(r3, r0)
            com.google.android.gms.internal.ads.zzdyz r0 = com.google.android.gms.internal.ads.zzdyr.immediateFailedFuture(r2)
            com.google.android.gms.internal.ads.zzdrg r0 = r1.zze(r0)
            com.google.android.gms.internal.ads.zzdqx r0 = r0.zzaww()
            com.google.android.gms.internal.ads.zzbrx r1 = r9.f14904b
            com.google.android.gms.internal.ads.zzbjw r2 = new com.google.android.gms.internal.ads.zzbjw
            com.google.android.gms.internal.ads.zzdrz r3 = r9.f14906d
            com.google.android.gms.internal.ads.zzdrx r4 = r9.f14905c
            r2.<init>(r10, r3, r4)
            java.util.concurrent.Executor r3 = r9.f14907e
            r1.zza(r2, r3)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabf.zzczb
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r2 = 0
            if (r1 == 0) goto L_0x0107
            com.google.android.gms.internal.ads.zzdnh r1 = r10.zzhik
            java.util.List<com.google.android.gms.internal.ads.zzdmu> r1 = r1.zzhih
            java.util.Iterator r1 = r1.iterator()
        L_0x00c0:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0107
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzdmu r3 = (com.google.android.gms.internal.ads.zzdmu) r3
            com.google.android.gms.internal.ads.zzcrg r4 = r9.f14911i
            r4.zzd(r3)
            java.util.List<java.lang.String> r4 = r3.zzhgo
            java.util.Iterator r4 = r4.iterator()
        L_0x00d7:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00f5
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzbod<AdT> r6 = r9.f14909g
            int r7 = r3.zzhgp
            com.google.android.gms.internal.ads.zzcqz r5 = r6.zze(r7, r5)
            if (r5 == 0) goto L_0x00d7
            boolean r5 = r5.zza(r10, r3)
            if (r5 == 0) goto L_0x00d7
            r4 = 1
            goto L_0x00f6
        L_0x00f5:
            r4 = 0
        L_0x00f6:
            if (r4 != 0) goto L_0x00c0
            com.google.android.gms.internal.ads.zzcrg r4 = r9.f14911i
            r5 = 0
            com.google.android.gms.internal.ads.zzdok r7 = com.google.android.gms.internal.ads.zzdok.INTERNAL_ERROR
            r8 = 0
            com.google.android.gms.internal.ads.zzve r7 = com.google.android.gms.internal.ads.zzdoi.zza(r7, r8, r8)
            r4.zza(r3, r5, r7)
            goto L_0x00c0
        L_0x0107:
            com.google.android.gms.internal.ads.zzdnh r1 = r10.zzhik
            java.util.List<com.google.android.gms.internal.ads.zzdmu> r1 = r1.zzhih
            java.util.Iterator r1 = r1.iterator()
        L_0x010f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x017e
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzdmu r3 = (com.google.android.gms.internal.ads.zzdmu) r3
            java.util.List<java.lang.String> r4 = r3.zzhgo
            java.util.Iterator r4 = r4.iterator()
        L_0x0121:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x017b
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzbod<AdT> r6 = r9.f14909g
            int r7 = r3.zzhgp
            com.google.android.gms.internal.ads.zzcqz r6 = r6.zze(r7, r5)
            if (r6 == 0) goto L_0x0121
            boolean r7 = r6.zza(r10, r3)
            if (r7 == 0) goto L_0x0121
            com.google.android.gms.internal.ads.zzdro r4 = r9.f14903a
            com.google.android.gms.internal.ads.zzdrl r7 = com.google.android.gms.internal.ads.zzdrl.RENDER_CONFIG_WATERFALL
            com.google.android.gms.internal.ads.zzdrg r0 = r4.zza(r7, r0)
            java.lang.String r4 = java.lang.String.valueOf(r5)
            int r4 = r4.length()
            int r4 = r4 + 26
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            java.lang.String r4 = "render-config-"
            r7.append(r4)
            r7.append(r2)
            java.lang.String r4 = "-"
            r7.append(r4)
            r7.append(r5)
            java.lang.String r4 = r7.toString()
            com.google.android.gms.internal.ads.zzdrg r0 = r0.zzgu(r4)
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            com.google.android.gms.internal.ads.qp r5 = new com.google.android.gms.internal.ads.qp
            r5.<init>(r9, r10, r3, r6)
            com.google.android.gms.internal.ads.zzdrg r0 = r0.zza(r4, r5)
            com.google.android.gms.internal.ads.zzdqx r0 = r0.zzaww()
        L_0x017b:
            int r2 = r2 + 1
            goto L_0x010f
        L_0x017e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcup.zzf(java.lang.Object):com.google.android.gms.internal.ads.zzdyz");
    }
}
