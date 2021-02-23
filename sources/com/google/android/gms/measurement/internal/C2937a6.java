package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;

/* renamed from: com.google.android.gms.measurement.internal.a6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2937a6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f17941a;

    /* renamed from: b */
    private final /* synthetic */ String f17942b;

    /* renamed from: c */
    private final /* synthetic */ boolean f17943c;

    /* renamed from: d */
    private final /* synthetic */ zzn f17944d;

    /* renamed from: e */
    private final /* synthetic */ zzw f17945e;

    /* renamed from: f */
    private final /* synthetic */ zzio f17946f;

    C2937a6(zzio zzio, String str, String str2, boolean z, zzn zzn, zzw zzw) {
        this.f17946f = zzio;
        this.f17941a = str;
        this.f17942b = str2;
        this.f17943c = z;
        this.f17944d = zzn;
        this.f17945e = zzw;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzej q = this.f17946f.f18673c;
            if (q == null) {
                this.f17946f.zzq().zze().zza("Failed to get user properties; not connected to service", this.f17941a, this.f17942b);
                return;
            }
            bundle = zzkw.zza(q.zza(this.f17941a, this.f17942b, this.f17943c, this.f17944d));
            this.f17946f.zzaj();
            this.f17946f.zzo().zza(this.f17945e, bundle);
        } catch (RemoteException e) {
            this.f17946f.zzq().zze().zza("Failed to get user properties; remote exception", this.f17941a, e);
        } finally {
            this.f17946f.zzo().zza(this.f17945e, bundle);
        }
    }
}
