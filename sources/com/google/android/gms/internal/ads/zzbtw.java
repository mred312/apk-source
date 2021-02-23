package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbtw extends zzbwk<zzbub> implements zzbsm, zzbto {

    /* renamed from: b */
    private final zzdmu f13764b;

    /* renamed from: c */
    private AtomicBoolean f13765c = new AtomicBoolean();

    public zzbtw(Set<zzbxy<zzbub>> set, zzdmu zzdmu) {
        super(set);
        this.f13764b = zzdmu;
    }

    /* renamed from: c */
    private final void m7859c() {
        zzvp zzvp;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyd)).booleanValue() && this.f13765c.compareAndSet(false, true) && (zzvp = this.f13764b.zzhhm) != null && zzvp.type == 3) {
            zza(new C1876ee(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16451b(zzbub zzbub) {
        zzbub.zzb(this.f13764b.zzhhm);
    }

    public final void onAdImpression() {
        int i = this.f13764b.zzhgp;
        if (i == 2 || i == 5 || i == 4) {
            m7859c();
        }
    }

    public final void zzakz() {
        if (this.f13764b.zzhgp == 1) {
            m7859c();
        }
    }
}
