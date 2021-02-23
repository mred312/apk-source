package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.n6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3061n6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzn f18270a;

    /* renamed from: b */
    private final /* synthetic */ zzio f18271b;

    C3061n6(zzio zzio, zzn zzn) {
        this.f18271b = zzio;
        this.f18270a = zzn;
    }

    public final void run() {
        zzej q = this.f18271b.f18673c;
        if (q == null) {
            this.f18271b.zzq().zze().zza("Failed to send consent settings to service");
            return;
        }
        try {
            q.zze(this.f18270a);
            this.f18271b.zzaj();
        } catch (RemoteException e) {
            this.f18271b.zzq().zze().zza("Failed to send consent settings to the service", e);
        }
    }
}
