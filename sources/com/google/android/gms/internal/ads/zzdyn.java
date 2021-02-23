package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzdyn<V> extends zzdwj implements Future<V> {
    protected zzdyn() {
    }

    public boolean cancel(boolean z) {
        return zzayo().cancel(z);
    }

    public V get() {
        return zzayo().get();
    }

    public boolean isCancelled() {
        return zzayo().isCancelled();
    }

    public boolean isDone() {
        return zzayo().isDone();
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzazn */
    public abstract Future<? extends V> zzayo();

    public V get(long j, TimeUnit timeUnit) {
        return zzayo().get(j, timeUnit);
    }
}
