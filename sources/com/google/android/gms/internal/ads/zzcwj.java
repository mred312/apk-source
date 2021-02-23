package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcwj<AdT> implements zzcqz<AdT> {
    @Nullable

    /* renamed from: a */
    private final zzacb f14985a;

    /* renamed from: b */
    private final zzdzc f14986b;

    /* renamed from: c */
    private final zzdro f14987c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzcwo<AdT> f14988d;

    public zzcwj(zzdro zzdro, zzdzc zzdzc, @Nullable zzacb zzacb, zzcwo<AdT> zzcwo) {
        this.f14987c = zzdro;
        this.f14986b = zzdzc;
        this.f14985a = zzacb;
        this.f14988d = zzcwo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo17013b(zzabu zzabu) {
        this.f14985a.zza(zzabu);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzhgx;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzdnj r1, com.google.android.gms.internal.ads.zzdmu r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzacb r1 = r0.f14985a
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzdnb r1 = r2.zzhgx
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zzdrp
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcwj.zza(com.google.android.gms.internal.ads.zzdnj, com.google.android.gms.internal.ads.zzdmu):boolean");
    }

    public final zzdyz<AdT> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzazq zzazq = new zzazq();
        zzcwr zzcwr = new zzcwr();
        zzcwr.zza(new C2184mq(this, zzazq, zzdnj, zzdmu, zzcwr));
        zzdnb zzdnb = zzdmu.zzhgx;
        return this.f14987c.zzu(zzdrl.CUSTOM_RENDER_SYN).zza(new C2221nq(this, new zzabu(zzcwr, zzdnb.zzdrn, zzdnb.zzdrp)), this.f14986b).zzw(zzdrl.CUSTOM_RENDER_ACK).zze(zzazq).zzaww();
    }
}
