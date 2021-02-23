package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.j6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3025j6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzig f18185a;

    /* renamed from: b */
    private final /* synthetic */ zzio f18186b;

    C3025j6(zzio zzio, zzig zzig) {
        this.f18186b = zzio;
        this.f18185a = zzig;
    }

    public final void run() {
        zzej q = this.f18186b.f18673c;
        if (q == null) {
            this.f18186b.zzq().zze().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzig zzig = this.f18185a;
            if (zzig == null) {
                q.zza(0, (String) null, (String) null, this.f18186b.zzm().getPackageName());
            } else {
                q.zza(zzig.zzc, zzig.zza, zzig.zzb, this.f18186b.zzm().getPackageName());
            }
            this.f18186b.zzaj();
        } catch (RemoteException e) {
            this.f18186b.zzq().zze().zza("Failed to send current screen to the service", e);
        }
    }
}
