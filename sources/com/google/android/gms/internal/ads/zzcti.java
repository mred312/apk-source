package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcti implements zzepf<zzctg> {

    /* renamed from: a */
    private final zzeps<Context> f14829a;

    /* renamed from: b */
    private final zzeps<zzazh> f14830b;

    /* renamed from: c */
    private final zzeps<zzbzx> f14831c;

    /* renamed from: d */
    private final zzeps<Executor> f14832d;

    public zzcti(zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzbzx> zzeps3, zzeps<Executor> zzeps4) {
        this.f14829a = zzeps;
        this.f14830b = zzeps2;
        this.f14831c = zzeps3;
        this.f14832d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzctg(this.f14829a.get(), this.f14830b.get(), this.f14831c.get(), this.f14832d.get());
    }
}
