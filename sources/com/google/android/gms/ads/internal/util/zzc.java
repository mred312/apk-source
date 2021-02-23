package com.google.android.gms.ads.internal.util;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zzc implements Runnable {
    private final /* synthetic */ zza zzece;

    zzc(zza zza) {
        this.zzece = zza;
    }

    public final void run() {
        Thread unused = this.zzece.thread = Thread.currentThread();
        this.zzece.zzvm();
    }
}
