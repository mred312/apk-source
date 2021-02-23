package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.p4 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final /* synthetic */ class C3077p4 implements Runnable {

    /* renamed from: a */
    private final zzgy f18294a;

    C3077p4(zzgy zzgy) {
        this.f18294a = zzgy;
    }

    public final void run() {
        zzgy zzgy = this.f18294a;
        zzgy.zzc();
        if (zzgy.zzr().f18247w.zza()) {
            zzgy.zzq().zzv().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza = zzgy.zzr().f18248x.zza();
        zzgy.zzr().f18248x.zza(1 + zza);
        if (zza >= 5) {
            zzgy.zzq().zzh().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzgy.zzr().f18247w.zza(true);
            return;
        }
        zzgy.zzy.zzag();
    }
}
