package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbre;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.yw */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2641yw<R extends zzbre<? extends zzboc>> {

    /* renamed from: a */
    private final zzdpd f12234a;

    /* renamed from: b */
    private final zzdkk f12235b;

    /* renamed from: c */
    private final zzdkn<R> f12236c;

    /* renamed from: d */
    private final Executor f12237d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public zzdkj f12238e;

    public C2641yw(zzdpd zzdpd, zzdkk zzdkk, zzdkn<R> zzdkn, Executor executor) {
        this.f12234a = zzdpd;
        this.f12235b = zzdkk;
        this.f12236c = zzdkn;
        this.f12237d = executor;
    }

    /* access modifiers changed from: private */
    @Deprecated
    /* renamed from: d */
    public final zzdpq m7383d() {
        zzdnn zzago = ((zzbre) this.f12236c.zzc(this.f12235b).zzafp()).zzago();
        return this.f12234a.zza(zzago.zzhio, zzago.zzhip, zzago.zzhis);
    }

    /* renamed from: c */
    public final zzdyz<zzdkj> mo15071c() {
        zzdyz zzdyz;
        zzdkj zzdkj = this.f12238e;
        if (zzdkj != null) {
            return zzdyr.zzag(zzdkj);
        }
        if (!zzadf.zzddc.get().booleanValue()) {
            zzdkj zzdkj2 = new zzdkj((zzatl) null, m7383d(), (C1747ax) null);
            this.f12238e = zzdkj2;
            zzdyz = zzdyr.zzag(zzdkj2);
        } else {
            zzdyz = zzdyi.zzg(((zzbre) this.f12236c.zzc(this.f12235b).zza(new zzdjv(this.f12234a.zzavc().zzhlq)).zzafp()).zzagh().zza(this.f12234a.zzavc())).zza(new C2678zw(this), this.f12237d).zza(zzcoh.class, new C1747ax(this), this.f12237d);
        }
        return zzdyr.zzb(zzdyz, C2603xw.f11961a, this.f12237d);
    }
}
