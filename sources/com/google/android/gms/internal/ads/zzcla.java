package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcla implements zzepf<zzckv> {

    /* renamed from: a */
    private final zzeps<Executor> f14532a;

    /* renamed from: b */
    private final zzeps<zzaze> f14533b;

    /* renamed from: c */
    private final zzeps<Context> f14534c;

    /* renamed from: d */
    private final zzeps<zzazh> f14535d;

    public zzcla(zzeps<Executor> zzeps, zzeps<zzaze> zzeps2, zzeps<Context> zzeps3, zzeps<zzazh> zzeps4) {
        this.f14532a = zzeps;
        this.f14533b = zzeps2;
        this.f14534c = zzeps3;
        this.f14535d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzckv(this.f14532a.get(), this.f14533b.get(), this.f14534c.get(), this.f14535d.get());
    }
}
