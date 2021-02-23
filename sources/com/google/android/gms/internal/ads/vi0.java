package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class vi0 implements Runnable {

    /* renamed from: a */
    private final zzaa f11623a;

    /* renamed from: b */
    private final zzaj f11624b;

    /* renamed from: c */
    private final Runnable f11625c;

    public vi0(zzaa zzaa, zzaj zzaj, Runnable runnable) {
        this.f11623a = zzaa;
        this.f11624b = zzaj;
        this.f11625c = runnable;
    }

    public final void run() {
        this.f11623a.isCanceled();
        if (this.f11624b.isSuccess()) {
            this.f11623a.zza(this.f11624b.result);
        } else {
            this.f11623a.zzb(this.f11624b.zzbr);
        }
        if (this.f11624b.zzbs) {
            this.f11623a.zzc("intermediate-response");
        } else {
            this.f11623a.zzd("done");
        }
        Runnable runnable = this.f11625c;
        if (runnable != null) {
            runnable.run();
        }
    }
}
