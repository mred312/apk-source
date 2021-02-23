package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzw;

/* renamed from: com.google.android.gms.measurement.internal.h6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3007h6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzn f18118a;

    /* renamed from: b */
    private final /* synthetic */ zzw f18119b;

    /* renamed from: c */
    private final /* synthetic */ zzio f18120c;

    C3007h6(zzio zzio, zzn zzn, zzw zzw) {
        this.f18120c = zzio;
        this.f18118a = zzn;
        this.f18119b = zzw;
    }

    public final void run() {
        try {
            if (!zzmj.zzb() || !this.f18120c.zzs().zza(zzat.zzcg) || this.f18120c.zzr().mo20050o().zze()) {
                zzej q = this.f18120c.f18673c;
                if (q == null) {
                    this.f18120c.zzq().zze().zza("Failed to get app instance id");
                    this.f18120c.zzo().zza(this.f18119b, (String) null);
                    return;
                }
                String zzc = q.zzc(this.f18118a);
                if (zzc != null) {
                    this.f18120c.zze().mo20387j(zzc);
                    this.f18120c.zzr().f18235k.zza(zzc);
                }
                this.f18120c.zzaj();
                this.f18120c.zzo().zza(this.f18119b, zzc);
                return;
            }
            this.f18120c.zzq().zzj().zza("Analytics storage consent denied; will not get app instance id");
            this.f18120c.zze().mo20387j((String) null);
            this.f18120c.zzr().f18235k.zza((String) null);
        } catch (RemoteException e) {
            this.f18120c.zzq().zze().zza("Failed to get app instance id", e);
        } finally {
            this.f18120c.zzo().zza(this.f18119b, (String) null);
        }
    }
}
