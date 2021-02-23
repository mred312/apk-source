package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzczs implements zzdyb<zzatl, zzczx> {

    /* renamed from: a */
    private Executor f15101a;

    /* renamed from: b */
    private zzcmx f15102b;

    public zzczs(Executor executor, zzcmx zzcmx) {
        this.f15101a = executor;
        this.f15102b = zzcmx;
    }

    public final /* synthetic */ zzdyz zzf(Object obj) {
        zzatl zzatl = (zzatl) obj;
        return zzdyr.zzb(this.f15102b.zzg(zzatl), new C2001hs(zzatl), this.f15101a);
    }
}
