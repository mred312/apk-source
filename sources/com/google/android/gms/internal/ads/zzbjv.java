package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbjv implements zzbru, zzbsi, zzbsm, zzbtj, zzva {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f13362a;

    /* renamed from: b */
    private final Executor f13363b;

    /* renamed from: c */
    private final ScheduledExecutorService f13364c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzdnj f13365d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzdmu f13366e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final zzdrx f13367f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzdnv f13368g;

    /* renamed from: h */
    private final zzef f13369h;

    /* renamed from: i */
    private final zzacg f13370i;

    /* renamed from: j */
    private final zzacl f13371j;
    @Nullable

    /* renamed from: k */
    private final View f13372k;
    @GuardedBy("this")

    /* renamed from: l */
    private boolean f13373l;
    @GuardedBy("this")

    /* renamed from: m */
    private boolean f13374m;

    public zzbjv(Context context, Executor executor, ScheduledExecutorService scheduledExecutorService, zzdnj zzdnj, zzdmu zzdmu, zzdrx zzdrx, zzdnv zzdnv, @Nullable View view, zzef zzef, zzacg zzacg, zzacl zzacl) {
        this.f13362a = context;
        this.f13363b = executor;
        this.f13364c = scheduledExecutorService;
        this.f13365d = zzdnj;
        this.f13366e = zzdmu;
        this.f13367f = zzdrx;
        this.f13368g = zzdnv;
        this.f13369h = zzef;
        this.f13372k = view;
        this.f13370i = zzacg;
        this.f13371j = zzacl;
    }

    public final void onAdClicked() {
        if ((((Boolean) zzwq.zzqe().zzd(zzabf.zzcny)).booleanValue() && this.f13365d.zzhik.zzerj.zzhhy) || !zzacy.zzdcd.get().booleanValue()) {
            zzdnv zzdnv = this.f13368g;
            zzdrx zzdrx = this.f13367f;
            zzdnj zzdnj = this.f13365d;
            zzdmu zzdmu = this.f13366e;
            List<String> zza = zzdrx.zza(zzdnj, zzdmu, zzdmu.zzdls);
            zzp.zzkq();
            zzdnv.zza(zza, zzm.zzbc(this.f13362a) ? zzcql.zzgqc : zzcql.zzgqb);
            return;
        }
        zzdyr.zza(zzdyi.zzg(this.f13371j.zza(this.f13362a, this.f13370i.zzsg(), this.f13370i.zzsh())).zza(((Long) zzwq.zzqe().zzd(zzabf.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.f13364c), new C2355rb(this), this.f13363b);
    }

    public final void onAdClosed() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a1, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onAdImpression() {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.f13374m     // Catch:{ all -> 0x00a2 }
            if (r0 != 0) goto L_0x00a0
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcrp     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x00a2 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a2 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a2 }
            r1 = 0
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzef r0 = r9.f13369h     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzdv r0 = r0.zzca()     // Catch:{ all -> 0x00a2 }
            android.content.Context r2 = r9.f13362a     // Catch:{ all -> 0x00a2 }
            android.view.View r3 = r9.f13372k     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = r0.zza((android.content.Context) r2, (android.view.View) r3, (android.app.Activity) r1)     // Catch:{ all -> 0x00a2 }
        L_0x0026:
            r5 = r1
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcny     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x00a2 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a2 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a2 }
            r8 = 1
            if (r0 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzdnj r0 = r9.f13365d     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzdnh r0 = r0.zzhik     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzdmz r0 = r0.zzerj     // Catch:{ all -> 0x00a2 }
            boolean r0 = r0.zzhhy     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r0 != 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzacn<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacy.zzdce     // Catch:{ all -> 0x00a2 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00a2 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a2 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a2 }
            if (r0 != 0) goto L_0x0058
            goto L_0x0089
        L_0x0058:
            com.google.android.gms.internal.ads.zzacl r0 = r9.f13371j     // Catch:{ all -> 0x00a2 }
            android.content.Context r1 = r9.f13362a     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzdyz r0 = r0.zzk(r1)     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzdyi r0 = com.google.android.gms.internal.ads.zzdyi.zzg(r0)     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabf.zzcor     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x00a2 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x00a2 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x00a2 }
            long r1 = r1.longValue()     // Catch:{ all -> 0x00a2 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00a2 }
            java.util.concurrent.ScheduledExecutorService r4 = r9.f13364c     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzdyi r0 = r0.zza((long) r1, (java.util.concurrent.TimeUnit) r3, (java.util.concurrent.ScheduledExecutorService) r4)     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.qb r1 = new com.google.android.gms.internal.ads.qb     // Catch:{ all -> 0x00a2 }
            r1.<init>(r9, r5)     // Catch:{ all -> 0x00a2 }
            java.util.concurrent.Executor r2 = r9.f13363b     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzdyr.zza(r0, r1, r2)     // Catch:{ all -> 0x00a2 }
            r9.f13374m = r8     // Catch:{ all -> 0x00a2 }
            goto L_0x00a0
        L_0x0089:
            com.google.android.gms.internal.ads.zzdnv r0 = r9.f13368g     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzdrx r1 = r9.f13367f     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzdnj r2 = r9.f13365d     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.internal.ads.zzdmu r3 = r9.f13366e     // Catch:{ all -> 0x00a2 }
            r4 = 0
            r6 = 0
            java.util.List<java.lang.String> r7 = r3.zzdlt     // Catch:{ all -> 0x00a2 }
            java.util.List r1 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a2 }
            r0.zzi(r1)     // Catch:{ all -> 0x00a2 }
            r9.f13374m = r8     // Catch:{ all -> 0x00a2 }
            monitor-exit(r9)
            return
        L_0x00a0:
            monitor-exit(r9)
            return
        L_0x00a2:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjv.onAdImpression():void");
    }

    public final void onAdLeftApplication() {
    }

    public final synchronized void onAdLoaded() {
        if (this.f13373l) {
            ArrayList arrayList = new ArrayList(this.f13366e.zzdlt);
            arrayList.addAll(this.f13366e.zzhgr);
            this.f13368g.zzi(this.f13367f.zza(this.f13365d, this.f13366e, true, (String) null, (String) null, arrayList));
        } else {
            zzdnv zzdnv = this.f13368g;
            zzdrx zzdrx = this.f13367f;
            zzdnj zzdnj = this.f13365d;
            zzdmu zzdmu = this.f13366e;
            zzdnv.zzi(zzdrx.zza(zzdnj, zzdmu, zzdmu.zzhgt));
            zzdnv zzdnv2 = this.f13368g;
            zzdrx zzdrx2 = this.f13367f;
            zzdnj zzdnj2 = this.f13365d;
            zzdmu zzdmu2 = this.f13366e;
            zzdnv2.zzi(zzdrx2.zza(zzdnj2, zzdmu2, zzdmu2.zzhgr));
        }
        this.f13373l = true;
    }

    public final void onAdOpened() {
    }

    public final void onRewardedVideoCompleted() {
        zzdnv zzdnv = this.f13368g;
        zzdrx zzdrx = this.f13367f;
        zzdnj zzdnj = this.f13365d;
        zzdmu zzdmu = this.f13366e;
        zzdnv.zzi(zzdrx.zza(zzdnj, zzdmu, zzdmu.zzhgs));
    }

    public final void onRewardedVideoStarted() {
        zzdnv zzdnv = this.f13368g;
        zzdrx zzdrx = this.f13367f;
        zzdnj zzdnj = this.f13365d;
        zzdmu zzdmu = this.f13366e;
        zzdnv.zzi(zzdrx.zza(zzdnj, zzdmu, zzdmu.zzdvc));
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
        zzdnv zzdnv = this.f13368g;
        zzdrx zzdrx = this.f13367f;
        zzdmu zzdmu = this.f13366e;
        zzdnv.zzi(zzdrx.zza(zzdmu, zzdmu.zzdvd, zzauf));
    }

    public final void zzj(zzve zzve) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqg)).booleanValue()) {
            this.f13368g.zzi(this.f13367f.zza(this.f13365d, this.f13366e, zzdrx.zza(2, zzve.errorCode, this.f13366e.zzhgu)));
        }
    }
}
