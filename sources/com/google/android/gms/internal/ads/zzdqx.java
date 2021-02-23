package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdqx<E, V> implements zzdyz<V> {

    /* renamed from: a */
    private final E f15878a;

    /* renamed from: b */
    private final String f15879b;

    /* renamed from: c */
    private final zzdyz<V> f15880c;

    @VisibleForTesting(otherwise = 3)
    public zzdqx(E e, String str, zzdyz<V> zzdyz) {
        this.f15878a = e;
        this.f15879b = str;
        this.f15880c = zzdyz;
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.f15880c.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.f15880c.cancel(z);
    }

    public final V get() {
        return this.f15880c.get();
    }

    public final boolean isCancelled() {
        return this.f15880c.isCancelled();
    }

    public final boolean isDone() {
        return this.f15880c.isDone();
    }

    public final String toString() {
        String str = this.f15879b;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }

    public final E zzawt() {
        return this.f15878a;
    }

    public final String zzawu() {
        return this.f15879b;
    }

    public final V get(long j, TimeUnit timeUnit) {
        return this.f15880c.get(j, timeUnit);
    }
}
