package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* renamed from: com.google.android.gms.measurement.internal.g6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2997g6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzn f18083a;

    /* renamed from: b */
    private final /* synthetic */ zzio f18084b;

    C2997g6(zzio zzio, zzn zzn) {
        this.f18084b = zzio;
        this.f18083a = zzn;
    }

    public final void run() {
        zzej q = this.f18084b.f18673c;
        if (q == null) {
            this.f18084b.zzq().zze().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            q.zza(this.f18083a);
            this.f18084b.zzi().zzac();
            this.f18084b.mo20457e(q, (AbstractSafeParcelable) null, this.f18083a);
            this.f18084b.zzaj();
        } catch (RemoteException e) {
            this.f18084b.zzq().zze().zza("Failed to send app launch to the service", e);
        }
    }
}
