package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class q20<V, X extends Throwable> extends r20<V, X, zzdyb<? super X, ? extends V>, zzdyz<? extends V>> {
    q20(zzdyz<? extends V> zzdyz, Class<X> cls, zzdyb<? super X, ? extends V> zzdyb) {
        super(zzdyz, cls, zzdyb);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public final /* synthetic */ void mo14630t(Object obj) {
        setFuture((zzdyz) obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public final /* synthetic */ Object mo14631v(Object obj, Throwable th) {
        zzdyb zzdyb = (zzdyb) obj;
        zzdyz zzf = zzdyb.zzf(th);
        zzdvv.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdyb);
        return zzf;
    }
}
