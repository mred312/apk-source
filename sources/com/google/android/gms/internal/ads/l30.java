package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class l30<V> implements Runnable {

    /* renamed from: a */
    private final Future<V> f9800a;

    /* renamed from: b */
    private final zzdyo<? super V> f9801b;

    l30(Future<V> future, zzdyo<? super V> zzdyo) {
        this.f9800a = future;
        this.f9801b = zzdyo;
    }

    public final void run() {
        Throwable zza;
        Future<V> future = this.f9800a;
        if (!(future instanceof zzdzr) || (zza = zzdzu.zza((zzdzr) future)) == null) {
            try {
                this.f9801b.onSuccess(zzdyr.zza(this.f9800a));
            } catch (ExecutionException e) {
                this.f9801b.zzb(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.f9801b.zzb(e2);
            }
        } else {
            this.f9801b.zzb(zza);
        }
    }

    public final String toString() {
        return zzdvo.zzy(this).zzz(this.f9801b).toString();
    }
}
