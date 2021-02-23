package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbnt implements zzbtj, zzqu {

    /* renamed from: a */
    private final zzdmu f13556a;

    /* renamed from: b */
    private final zzbsl f13557b;

    /* renamed from: c */
    private final zzbtn f13558c;

    /* renamed from: d */
    private final AtomicBoolean f13559d = new AtomicBoolean();

    /* renamed from: e */
    private final AtomicBoolean f13560e = new AtomicBoolean();

    public zzbnt(zzdmu zzdmu, zzbsl zzbsl, zzbtn zzbtn) {
        this.f13556a = zzdmu;
        this.f13557b = zzbsl;
        this.f13558c = zzbtn;
    }

    /* renamed from: a */
    private final void m7827a() {
        if (this.f13559d.compareAndSet(false, true)) {
            this.f13557b.onAdImpression();
        }
    }

    public final synchronized void onAdLoaded() {
        if (this.f13556a.zzhgq != 1) {
            m7827a();
        }
    }

    public final void zza(zzqv zzqv) {
        if (this.f13556a.zzhgq == 1 && zzqv.zzbqz) {
            m7827a();
        }
        if (zzqv.zzbqz && this.f13560e.compareAndSet(false, true)) {
            this.f13558c.zzakz();
        }
    }
}
