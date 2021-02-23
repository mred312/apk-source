package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzepq<T> {

    /* renamed from: a */
    private final List<zzeps<T>> f16367a;

    /* renamed from: b */
    private final List<zzeps<Collection<T>>> f16368b;

    private zzepq(int i, int i2) {
        this.f16367a = zzepe.zzic(i);
        this.f16368b = zzepe.zzic(i2);
    }

    public final zzepq<T> zzau(zzeps<? extends T> zzeps) {
        this.f16367a.add(zzeps);
        return this;
    }

    public final zzepq<T> zzav(zzeps<? extends Collection<? extends T>> zzeps) {
        this.f16368b.add(zzeps);
        return this;
    }

    public final zzepo<T> zzblv() {
        return new zzepo<>(this.f16367a, this.f16368b);
    }
}
