package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcvr implements zzepf<zzcvo> {

    /* renamed from: a */
    private final zzeps<Context> f14950a;

    /* renamed from: b */
    private final zzeps<Executor> f14951b;

    /* renamed from: c */
    private final zzeps<zzchf> f14952c;

    public zzcvr(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzchf> zzeps3) {
        this.f14950a = zzeps;
        this.f14951b = zzeps2;
        this.f14952c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzcvo(this.f14950a.get(), this.f14951b.get(), this.f14952c.get());
    }
}
