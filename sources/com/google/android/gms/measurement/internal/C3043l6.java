package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;

/* renamed from: com.google.android.gms.measurement.internal.l6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3043l6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzar f18213a;

    /* renamed from: b */
    private final /* synthetic */ String f18214b;

    /* renamed from: c */
    private final /* synthetic */ zzw f18215c;

    /* renamed from: d */
    private final /* synthetic */ zzio f18216d;

    C3043l6(zzio zzio, zzar zzar, String str, zzw zzw) {
        this.f18216d = zzio;
        this.f18213a = zzar;
        this.f18214b = str;
        this.f18215c = zzw;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            zzej q = this.f18216d.f18673c;
            if (q == null) {
                this.f18216d.zzq().zze().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            bArr = q.zza(this.f18213a, this.f18214b);
            this.f18216d.zzaj();
            this.f18216d.zzo().zza(this.f18215c, bArr);
        } catch (RemoteException e) {
            this.f18216d.zzq().zze().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.f18216d.zzo().zza(this.f18215c, bArr);
        }
    }
}
