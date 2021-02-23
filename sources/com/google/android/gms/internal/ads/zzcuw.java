package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcuw implements zzepf<zzcuu> {

    /* renamed from: a */
    private final zzeps<Context> f14917a;

    /* renamed from: b */
    private final zzeps<Executor> f14918b;

    /* renamed from: c */
    private final zzeps<zzchf> f14919c;

    public zzcuw(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzchf> zzeps3) {
        this.f14917a = zzeps;
        this.f14918b = zzeps2;
        this.f14919c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzcuu(this.f14917a.get(), this.f14918b.get(), this.f14919c.get());
    }
}
