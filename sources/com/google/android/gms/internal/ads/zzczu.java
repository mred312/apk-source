package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzczu implements zzepf<zzczs> {

    /* renamed from: a */
    private final zzeps<Executor> f15106a;

    /* renamed from: b */
    private final zzeps<zzcmx> f15107b;

    public zzczu(zzeps<Executor> zzeps, zzeps<zzcmx> zzeps2) {
        this.f15106a = zzeps;
        this.f15107b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzczs(this.f15106a.get(), this.f15107b.get());
    }
}
