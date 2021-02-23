package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzfn extends zzgl {

    /* renamed from: g */
    private static final zzgo<zzcy> f16404g = new zzgo<>();

    /* renamed from: e */
    private final Context f16405e;

    /* renamed from: f */
    private zzby.zza f16406f = null;

    public zzfn(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2, Context context, zzby.zza zza2) {
        super(zzfa, str, str2, zza, i, 27);
        this.f16405e = context;
        this.f16406f = zza2;
    }

    /* renamed from: a */
    private static String m8941a(zzby.zza zza) {
        if (zza == null || !zza.zzz() || zzff.zzar(zza.zzaa().zzaf())) {
            return null;
        }
        return zza.zzaa().zzaf();
    }

    /* renamed from: b */
    private final String m8942b() {
        try {
            if (this.zzwb.zzcp() != null) {
                this.zzwb.zzcp().get();
            }
            zzcf.zza zzco = this.zzwb.zzco();
            if (zzco == null || !zzco.zzaj()) {
                return null;
            }
            return zzco.zzaf();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzcw() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzgo<com.google.android.gms.internal.ads.zzcy> r0 = f16404g
            android.content.Context r1 = r10.f16405e
            java.lang.String r1 = r1.getPackageName()
            java.util.concurrent.atomic.AtomicReference r0 = r0.zzas(r1)
            monitor-enter(r0)
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcy r1 = (com.google.android.gms.internal.ads.zzcy) r1     // Catch:{ all -> 0x0113 }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0036
            java.lang.String r4 = r1.zznt     // Catch:{ all -> 0x0113 }
            boolean r4 = com.google.android.gms.internal.ads.zzff.zzar(r4)     // Catch:{ all -> 0x0113 }
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = r1.zznt     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = "E"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0113 }
            if (r4 != 0) goto L_0x0036
            java.lang.String r1 = r1.zznt     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0113 }
            if (r1 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r1 = 0
            goto L_0x0037
        L_0x0036:
            r1 = 1
        L_0x0037:
            if (r1 == 0) goto L_0x00df
            com.google.android.gms.internal.ads.zzby$zza r1 = r10.f16406f     // Catch:{ all -> 0x0113 }
            java.lang.String r1 = m8941a(r1)     // Catch:{ all -> 0x0113 }
            boolean r1 = com.google.android.gms.internal.ads.zzff.zzar(r1)     // Catch:{ all -> 0x0113 }
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzcb r1 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED     // Catch:{ all -> 0x0113 }
            goto L_0x0082
        L_0x0048:
            com.google.android.gms.internal.ads.zzby$zza r1 = r10.f16406f     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = m8941a(r1)     // Catch:{ all -> 0x0113 }
            boolean r4 = com.google.android.gms.internal.ads.zzff.zzar(r4)     // Catch:{ all -> 0x0113 }
            if (r4 == 0) goto L_0x006a
            if (r1 == 0) goto L_0x006a
            boolean r4 = r1.zzx()     // Catch:{ all -> 0x0113 }
            if (r4 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzby$zzb r1 = r1.zzy()     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcb r1 = r1.zzac()     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcb r4 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x0113 }
            if (r1 != r4) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x006a:
            r1 = 0
        L_0x006b:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0113 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0113 }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzfa r1 = r10.zzwb     // Catch:{ all -> 0x0113 }
            boolean r1 = r1.zzcm()     // Catch:{ all -> 0x0113 }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzcb r1 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x0113 }
            goto L_0x0082
        L_0x0080:
            com.google.android.gms.internal.ads.zzcb r1 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x0113 }
        L_0x0082:
            com.google.android.gms.internal.ads.zzcb r4 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x0113 }
            if (r1 != r4) goto L_0x0088
            r4 = 1
            goto L_0x0089
        L_0x0088:
            r4 = 0
        L_0x0089:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0113 }
            java.lang.reflect.Method r5 = r10.zzabi     // Catch:{ all -> 0x0113 }
            r6 = 0
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x0113 }
            android.content.Context r9 = r10.f16405e     // Catch:{ all -> 0x0113 }
            r8[r2] = r9     // Catch:{ all -> 0x0113 }
            r8[r3] = r4     // Catch:{ all -> 0x0113 }
            java.lang.Object r2 = r5.invoke(r6, r8)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcy r4 = new com.google.android.gms.internal.ads.zzcy     // Catch:{ all -> 0x0113 }
            r4.<init>(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = r4.zznt     // Catch:{ all -> 0x0113 }
            boolean r2 = com.google.android.gms.internal.ads.zzff.zzar(r2)     // Catch:{ all -> 0x0113 }
            if (r2 != 0) goto L_0x00b6
            java.lang.String r2 = r4.zznt     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = "E"
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x0113 }
            if (r2 == 0) goto L_0x00dc
        L_0x00b6:
            int[] r2 = com.google.android.gms.internal.ads.fd0.f8452a     // Catch:{ all -> 0x0113 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x0113 }
            r1 = r2[r1]     // Catch:{ all -> 0x0113 }
            if (r1 == r3) goto L_0x00d0
            if (r1 == r7) goto L_0x00c3
            goto L_0x00dc
        L_0x00c3:
            java.lang.String r1 = r10.m8942b()     // Catch:{ all -> 0x0113 }
            boolean r2 = com.google.android.gms.internal.ads.zzff.zzar(r1)     // Catch:{ all -> 0x0113 }
            if (r2 != 0) goto L_0x00dc
            r4.zznt = r1     // Catch:{ all -> 0x0113 }
            goto L_0x00dc
        L_0x00d0:
            com.google.android.gms.internal.ads.zzby$zza r1 = r10.f16406f     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzby$zzc r1 = r1.zzaa()     // Catch:{ all -> 0x0113 }
            java.lang.String r1 = r1.zzaf()     // Catch:{ all -> 0x0113 }
            r4.zznt = r1     // Catch:{ all -> 0x0113 }
        L_0x00dc:
            r0.set(r4)     // Catch:{ all -> 0x0113 }
        L_0x00df:
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcy r1 = (com.google.android.gms.internal.ads.zzcy) r1     // Catch:{ all -> 0x0113 }
            monitor-exit(r0)     // Catch:{ all -> 0x0113 }
            com.google.android.gms.internal.ads.zzcf$zza$zza r2 = r10.zzaay
            monitor-enter(r2)
            if (r1 == 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r10.zzaay     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r1.zznt     // Catch:{ all -> 0x0110 }
            r0.zzv((java.lang.String) r3)     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r10.zzaay     // Catch:{ all -> 0x0110 }
            long r3 = r1.zznu     // Catch:{ all -> 0x0110 }
            r0.zzt((long) r3)     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r10.zzaay     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r1.zznv     // Catch:{ all -> 0x0110 }
            r0.zzx((java.lang.String) r3)     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r10.zzaay     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r1.zznw     // Catch:{ all -> 0x0110 }
            r0.zzy((java.lang.String) r3)     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r10.zzaay     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = r1.zznx     // Catch:{ all -> 0x0110 }
            r0.zzz((java.lang.String) r1)     // Catch:{ all -> 0x0110 }
        L_0x010e:
            monitor-exit(r2)     // Catch:{ all -> 0x0110 }
            return
        L_0x0110:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0110 }
            throw r0
        L_0x0113:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0113 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfn.zzcw():void");
    }
}
