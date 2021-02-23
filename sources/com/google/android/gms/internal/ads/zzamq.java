package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzamq {

    /* renamed from: a */
    private zzalb f12532a;

    /* renamed from: b */
    private zzdyz<zzalz> f12533b;

    zzamq(zzalb zzalb) {
        this.f12532a = zzalb;
    }

    /* renamed from: a */
    private final void m7499a() {
        if (this.f12533b == null) {
            zzazq zzazq = new zzazq();
            this.f12533b = zzazq;
            this.f12532a.zzb((zzef) null).zza(new C2383s2(zzazq), new C2346r2(zzazq));
        }
    }

    public final <I, O> zzamx<I, O> zzb(String str, zzame<I> zzame, zzamf<O> zzamf) {
        m7499a();
        return new zzamx<>(this.f12533b, str, zzame, zzamf);
    }

    public final void zzc(String str, zzahv<? super zzalz> zzahv) {
        m7499a();
        this.f12533b = zzdyr.zzb(this.f12533b, new C2461u2(str, zzahv), (Executor) zzazj.zzegu);
    }

    public final void zzd(String str, zzahv<? super zzalz> zzahv) {
        this.f12533b = zzdyr.zzb(this.f12533b, new C2424t2(str, zzahv), (Executor) zzazj.zzegu);
    }
}
