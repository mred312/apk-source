package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcsg implements zzepf<zzcse> {

    /* renamed from: a */
    private final zzeps<Context> f14782a;

    /* renamed from: b */
    private final zzeps<zzazh> f14783b;

    /* renamed from: c */
    private final zzeps<zzbna> f14784c;

    /* renamed from: d */
    private final zzeps<Executor> f14785d;

    public zzcsg(zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzbna> zzeps3, zzeps<Executor> zzeps4) {
        this.f14782a = zzeps;
        this.f14783b = zzeps2;
        this.f14784c = zzeps3;
        this.f14785d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzcse(this.f14782a.get(), this.f14783b.get(), this.f14784c.get(), this.f14785d.get());
    }
}
