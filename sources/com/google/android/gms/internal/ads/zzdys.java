package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdys<V> {

    /* renamed from: a */
    private final boolean f16087a;

    /* renamed from: b */
    private final zzdwm<zzdyz<? extends V>> f16088b;

    private zzdys(boolean z, zzdwm<zzdyz<? extends V>> zzdwm) {
        this.f16087a = z;
        this.f16088b = zzdwm;
    }

    public final <C> zzdyz<C> zza(Callable<C> callable, Executor executor) {
        return new f30(this.f16088b, this.f16087a, executor, callable);
    }

    /* synthetic */ zzdys(boolean z, zzdwm zzdwm, k30 k30) {
        this(z, zzdwm);
    }
}
