package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.measurement.internal.r6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3097r6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f18340a;

    /* renamed from: b */
    private final /* synthetic */ String f18341b;

    /* renamed from: c */
    private final /* synthetic */ zzn f18342c;

    /* renamed from: d */
    private final /* synthetic */ zzw f18343d;

    /* renamed from: e */
    private final /* synthetic */ zzio f18344e;

    C3097r6(zzio zzio, String str, String str2, zzn zzn, zzw zzw) {
        this.f18344e = zzio;
        this.f18340a = str;
        this.f18341b = str2;
        this.f18342c = zzn;
        this.f18343d = zzw;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzej q = this.f18344e.f18673c;
            if (q == null) {
                this.f18344e.zzq().zze().zza("Failed to get conditional properties; not connected to service", this.f18340a, this.f18341b);
                return;
            }
            arrayList = zzkw.zzb(q.zza(this.f18340a, this.f18341b, this.f18342c));
            this.f18344e.zzaj();
            this.f18344e.zzo().zza(this.f18343d, arrayList);
        } catch (RemoteException e) {
            this.f18344e.zzq().zze().zza("Failed to get conditional properties; remote exception", this.f18340a, this.f18341b, e);
        } finally {
            this.f18344e.zzo().zza(this.f18343d, arrayList);
        }
    }
}
