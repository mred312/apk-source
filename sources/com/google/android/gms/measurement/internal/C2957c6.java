package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.c6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2957c6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18000a;

    /* renamed from: b */
    private final /* synthetic */ zzn f18001b;

    /* renamed from: c */
    private final /* synthetic */ boolean f18002c;

    /* renamed from: d */
    private final /* synthetic */ zzio f18003d;

    C2957c6(zzio zzio, AtomicReference atomicReference, zzn zzn, boolean z) {
        this.f18003d = zzio;
        this.f18000a = atomicReference;
        this.f18001b = zzn;
        this.f18002c = z;
    }

    public final void run() {
        synchronized (this.f18000a) {
            try {
                zzej q = this.f18003d.f18673c;
                if (q == null) {
                    this.f18003d.zzq().zze().zza("Failed to get all user properties; not connected to service");
                    this.f18000a.notify();
                    return;
                }
                this.f18000a.set(q.zza(this.f18001b, this.f18002c));
                this.f18003d.zzaj();
                this.f18000a.notify();
            } catch (RemoteException e) {
                try {
                    this.f18003d.zzq().zze().zza("Failed to get all user properties; remote exception", e);
                    this.f18000a.notify();
                } catch (Throwable th) {
                    this.f18000a.notify();
                    throw th;
                }
            }
        }
    }
}
