package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckr implements zzepf<zzckq> {

    /* renamed from: a */
    private final zzeps<zzckv> f14512a;

    /* renamed from: b */
    private final zzeps<Executor> f14513b;

    public zzckr(zzeps<zzckv> zzeps, zzeps<Executor> zzeps2) {
        this.f14512a = zzeps;
        this.f14513b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzckq(this.f14512a.get(), this.f14513b.get());
    }
}
