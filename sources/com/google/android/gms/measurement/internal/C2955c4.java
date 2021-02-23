package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzmj;

/* renamed from: com.google.android.gms.measurement.internal.c4 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C2955c4 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzn f17996a;

    /* renamed from: b */
    private final /* synthetic */ zzfw f17997b;

    C2955c4(zzfw zzfw, zzn zzn) {
        this.f17997b = zzfw;
        this.f17996a = zzn;
    }

    public final void run() {
        this.f17997b.f18635a.mo20510T();
        zzki a = this.f17997b.f18635a;
        zzn zzn = this.f17996a;
        if (zzmj.zzb() && a.zzb().zza(zzat.zzci)) {
            a.zzp().zzc();
            a.mo20508R();
            Preconditions.checkNotEmpty(zzn.zza);
            zzad zza = zzad.zza(zzn.zzw);
            zzad b = a.mo20513b(zzn.zza);
            a.mo20524v(zzn.zza, zza);
            if (zza.zza(b)) {
                a.mo20519q(zzn);
            }
        }
    }
}
