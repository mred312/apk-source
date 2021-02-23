package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.f6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2987f6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzn f18060a;

    /* renamed from: b */
    private final /* synthetic */ zzio f18061b;

    C2987f6(zzio zzio, zzn zzn) {
        this.f18061b = zzio;
        this.f18060a = zzn;
    }

    public final void run() {
        zzej q = this.f18061b.f18673c;
        if (q == null) {
            this.f18061b.zzq().zze().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            q.zzd(this.f18060a);
        } catch (RemoteException e) {
            this.f18061b.zzq().zze().zza("Failed to reset data on the service: remote exception", e);
        }
        this.f18061b.zzaj();
    }
}
