package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.i6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3016i6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Bundle f18167a;

    /* renamed from: b */
    private final /* synthetic */ zzn f18168b;

    /* renamed from: c */
    private final /* synthetic */ zzio f18169c;

    C3016i6(zzio zzio, Bundle bundle, zzn zzn) {
        this.f18169c = zzio;
        this.f18167a = bundle;
        this.f18168b = zzn;
    }

    public final void run() {
        zzej q = this.f18169c.f18673c;
        if (q == null) {
            this.f18169c.zzq().zze().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            q.zza(this.f18167a, this.f18168b);
        } catch (RemoteException e) {
            this.f18169c.zzq().zze().zza("Failed to send default event parameters to service", e);
        }
    }
}
