package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdod<T> {
    @GuardedBy("this")

    /* renamed from: a */
    private final Deque<zzdyz<T>> f15817a = new LinkedBlockingDeque();

    /* renamed from: b */
    private final Callable<T> f15818b;

    /* renamed from: c */
    private final zzdzc f15819c;

    public zzdod(Callable<T> callable, zzdzc zzdzc) {
        this.f15818b = callable;
        this.f15819c = zzdzc;
    }

    public final synchronized void ensureSize(int i) {
        int size = i - this.f15817a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f15817a.add(this.f15819c.zze(this.f15818b));
        }
    }

    public final synchronized zzdyz<T> zzaux() {
        ensureSize(1);
        return this.f15817a.poll();
    }

    public final synchronized void zzd(zzdyz<T> zzdyz) {
        this.f15817a.addFirst(zzdyz);
    }
}
