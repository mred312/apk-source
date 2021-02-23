package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzft implements Callable {

    /* renamed from: a */
    private final zzfa f16412a;

    /* renamed from: b */
    private final zzcf.zza.C3977zza f16413b;

    public zzft(zzfa zzfa, zzcf.zza.C3977zza zza) {
        this.f16412a = zzfa;
        this.f16413b = zza;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Void call() {
        if (this.f16412a.zzcp() != null) {
            this.f16412a.zzcp().get();
        }
        zzcf.zza zzco = this.f16412a.zzco();
        if (zzco == null) {
            return null;
        }
        try {
            synchronized (this.f16413b) {
                zzcf.zza.C3977zza zza = this.f16413b;
                byte[] byteArray = zzco.toByteArray();
                zza.zza(byteArray, 0, byteArray.length, zzeju.zzbhf());
            }
            return null;
        } catch (zzeks unused) {
            return null;
        }
    }
}
