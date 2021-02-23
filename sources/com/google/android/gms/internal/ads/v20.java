package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class v20<I, O> extends t20<I, O, zzdyb<? super I, ? extends O>, zzdyz<? extends O>> {
    v20(zzdyz<? extends I> zzdyz, zzdyb<? super I, ? extends O> zzdyb) {
        super(zzdyz, zzdyb);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public final /* synthetic */ void mo14816t(Object obj) {
        setFuture((zzdyz) obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public final /* synthetic */ Object mo14817w(Object obj, @NullableDecl Object obj2) {
        zzdyb zzdyb = (zzdyb) obj;
        zzdyz zzf = zzdyb.zzf(obj2);
        zzdvv.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdyb);
        return zzf;
    }
}
