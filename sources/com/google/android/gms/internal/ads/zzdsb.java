package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdsb implements zzepf<zzdrz> {

    /* renamed from: a */
    private final zzeps<Executor> f15923a;

    /* renamed from: b */
    private final zzeps<zzaze> f15924b;

    public zzdsb(zzeps<Executor> zzeps, zzeps<zzaze> zzeps2) {
        this.f15923a = zzeps;
        this.f15924b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzdrz(this.f15923a.get(), this.f15924b.get());
    }
}
