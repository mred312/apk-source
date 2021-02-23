package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzmj;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.e6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2977e6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18040a;

    /* renamed from: b */
    private final /* synthetic */ zzn f18041b;

    /* renamed from: c */
    private final /* synthetic */ zzio f18042c;

    C2977e6(zzio zzio, AtomicReference atomicReference, zzn zzn) {
        this.f18042c = zzio;
        this.f18040a = atomicReference;
        this.f18041b = zzn;
    }

    public final void run() {
        synchronized (this.f18040a) {
            try {
                if (!zzmj.zzb() || !this.f18042c.zzs().zza(zzat.zzcg) || this.f18042c.zzr().mo20050o().zze()) {
                    zzej q = this.f18042c.f18673c;
                    if (q == null) {
                        this.f18042c.zzq().zze().zza("Failed to get app instance id");
                        this.f18040a.notify();
                        return;
                    }
                    this.f18040a.set(q.zzc(this.f18041b));
                    String str = (String) this.f18040a.get();
                    if (str != null) {
                        this.f18042c.zze().mo20387j(str);
                        this.f18042c.zzr().f18235k.zza(str);
                    }
                    this.f18042c.zzaj();
                    this.f18040a.notify();
                } else {
                    this.f18042c.zzq().zzj().zza("Analytics storage consent denied; will not get app instance id");
                    this.f18042c.zze().mo20387j((String) null);
                    this.f18042c.zzr().f18235k.zza((String) null);
                    this.f18040a.set((Object) null);
                    this.f18040a.notify();
                }
            } catch (RemoteException e) {
                try {
                    this.f18042c.zzq().zze().zza("Failed to get app instance id", e);
                    this.f18040a.notify();
                } catch (Throwable th) {
                    this.f18040a.notify();
                    throw th;
                }
            }
        }
    }
}
