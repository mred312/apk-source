package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.i7 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final /* synthetic */ class C3017i7 implements Runnable {

    /* renamed from: a */
    private final C2978e7 f18170a;

    C3017i7(C2978e7 e7Var) {
        this.f18170a = e7Var;
    }

    public final void run() {
        C2978e7 e7Var = this.f18170a;
        C2988f7 f7Var = e7Var.f18045c;
        long j = e7Var.f18043a;
        long j2 = e7Var.f18044b;
        f7Var.f18063b.zzc();
        f7Var.f18063b.zzq().zzv().zza("Application going to the background");
        boolean z = true;
        if (f7Var.f18063b.zzs().zza(zzat.zzbu)) {
            f7Var.f18063b.zzr().f18246v.zza(true);
        }
        Bundle bundle = new Bundle();
        if (!f7Var.f18063b.zzs().zzh().booleanValue()) {
            f7Var.f18063b.zzb.mo19932f(j2);
            if (f7Var.f18063b.zzs().zza(zzat.zzbl)) {
                bundle.putLong("_et", f7Var.f18063b.mo20498b(j2));
                zzij.zza(f7Var.f18063b.zzh().zza(true), bundle, true);
            } else {
                z = false;
            }
            f7Var.f18063b.zza(false, z, j2);
        }
        f7Var.f18063b.zze().mo20388k("auto", "_ab", j, bundle);
    }
}
