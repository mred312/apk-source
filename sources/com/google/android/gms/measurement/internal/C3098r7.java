package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzmj;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.r7 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C3098r7 implements Callable<String> {

    /* renamed from: a */
    private final /* synthetic */ zzn f18345a;

    /* renamed from: b */
    private final /* synthetic */ zzki f18346b;

    C3098r7(zzki zzki, zzn zzn) {
        this.f18346b = zzki;
        this.f18345a = zzn;
    }

    public final /* synthetic */ Object call() {
        if (!zzmj.zzb() || !this.f18346b.zzb().zza(zzat.zzci) || (this.f18346b.mo20513b(this.f18345a.zza).zze() && zzad.zza(this.f18345a.zzw).zze())) {
            C3013i3 N = this.f18346b.mo20506N(this.f18345a);
            if (N != null) {
                return N.mo19999x();
            }
            this.f18346b.zzq().zzh().zza("App info was null when attempting to get app instance id");
            return null;
        }
        this.f18346b.zzq().zzw().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
