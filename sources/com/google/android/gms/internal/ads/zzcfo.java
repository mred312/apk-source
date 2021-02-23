package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcfo {

    /* renamed from: a */
    private final Executor f14268a;

    /* renamed from: b */
    private final zzbkr f14269b;

    /* renamed from: c */
    private final zzbxx f14270c;

    zzcfo(Executor executor, zzbkr zzbkr, zzbxx zzbxx) {
        this.f14268a = executor;
        this.f14270c = zzbxx;
        this.f14269b = zzbkr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo16834a(zzbdv zzbdv, Map map) {
        this.f14269b.disable();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16835b(zzbdv zzbdv, Map map) {
        this.f14269b.enable();
    }

    public final void zzl(zzbdv zzbdv) {
        if (zzbdv != null) {
            this.f14270c.zzv(zzbdv.getView());
            this.f14270c.zza(new C2589xi(zzbdv), this.f14268a);
            this.f14270c.zza(new C2664zi(zzbdv), this.f14268a);
            this.f14270c.zza(this.f14269b, this.f14268a);
            this.f14269b.zzg(zzbdv);
            zzbdv.zza("/trackActiveViewUnit", (zzahv<? super zzbdv>) new C2627yi(this));
            zzbdv.zza("/untrackActiveViewUnit", (zzahv<? super zzbdv>) new C1733aj(this));
        }
    }
}
