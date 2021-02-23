package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.measurement.internal.p6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3079p6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ boolean f18300a = true;

    /* renamed from: b */
    private final /* synthetic */ boolean f18301b;

    /* renamed from: c */
    private final /* synthetic */ zzw f18302c;

    /* renamed from: d */
    private final /* synthetic */ zzn f18303d;

    /* renamed from: e */
    private final /* synthetic */ zzw f18304e;

    /* renamed from: f */
    private final /* synthetic */ zzio f18305f;

    C3079p6(zzio zzio, boolean z, boolean z2, zzw zzw, zzn zzn, zzw zzw2) {
        this.f18305f = zzio;
        this.f18301b = z2;
        this.f18302c = zzw;
        this.f18303d = zzn;
        this.f18304e = zzw2;
    }

    public final void run() {
        zzej q = this.f18305f.f18673c;
        if (q == null) {
            this.f18305f.zzq().zze().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f18300a) {
            this.f18305f.mo20457e(q, this.f18301b ? null : this.f18302c, this.f18303d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f18304e.zza)) {
                    q.zza(this.f18302c, this.f18303d);
                } else {
                    q.zza(this.f18302c);
                }
            } catch (RemoteException e) {
                this.f18305f.zzq().zze().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.f18305f.zzaj();
    }
}
