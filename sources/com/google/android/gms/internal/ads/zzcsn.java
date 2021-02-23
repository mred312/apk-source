package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcsn implements zzepf<zzcsm> {

    /* renamed from: a */
    private final zzeps<Context> f14792a;

    /* renamed from: b */
    private final zzeps<Executor> f14793b;

    /* renamed from: c */
    private final zzeps<zzbzx> f14794c;

    /* renamed from: d */
    private final zzeps<zzdms> f14795d;

    public zzcsn(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzbzx> zzeps3, zzeps<zzdms> zzeps4) {
        this.f14792a = zzeps;
        this.f14793b = zzeps2;
        this.f14794c = zzeps3;
        this.f14795d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzcsm(this.f14792a.get(), this.f14793b.get(), this.f14794c.get(), this.f14795d.get());
    }
}
