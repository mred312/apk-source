package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.o6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3070o6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzn f18283a;

    /* renamed from: b */
    private final /* synthetic */ zzio f18284b;

    C3070o6(zzio zzio, zzn zzn) {
        this.f18284b = zzio;
        this.f18283a = zzn;
    }

    public final void run() {
        zzej q = this.f18284b.f18673c;
        if (q == null) {
            this.f18284b.zzq().zze().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            q.zzb(this.f18283a);
            this.f18284b.zzaj();
        } catch (RemoteException e) {
            this.f18284b.zzq().zze().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
