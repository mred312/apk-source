package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.measurement.internal.q6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3088q6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ boolean f18324a;

    /* renamed from: b */
    private final /* synthetic */ boolean f18325b;

    /* renamed from: c */
    private final /* synthetic */ zzar f18326c;

    /* renamed from: d */
    private final /* synthetic */ zzn f18327d;

    /* renamed from: e */
    private final /* synthetic */ String f18328e;

    /* renamed from: f */
    private final /* synthetic */ zzio f18329f;

    C3088q6(zzio zzio, boolean z, boolean z2, zzar zzar, zzn zzn, String str) {
        this.f18329f = zzio;
        this.f18324a = z;
        this.f18325b = z2;
        this.f18326c = zzar;
        this.f18327d = zzn;
        this.f18328e = str;
    }

    public final void run() {
        zzej q = this.f18329f.f18673c;
        if (q == null) {
            this.f18329f.zzq().zze().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f18324a) {
            this.f18329f.mo20457e(q, this.f18325b ? null : this.f18326c, this.f18327d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f18328e)) {
                    q.zza(this.f18326c, this.f18327d);
                } else {
                    q.zza(this.f18326c, this.f18328e, this.f18329f.zzq().zzx());
                }
            } catch (RemoteException e) {
                this.f18329f.zzq().zze().zza("Failed to send event to the service", e);
            }
        }
        this.f18329f.zzaj();
    }
}
