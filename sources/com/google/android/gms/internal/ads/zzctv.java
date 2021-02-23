package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzctv implements zzepf<zzctw> {

    /* renamed from: a */
    private final zzeps<Context> f14844a;

    /* renamed from: b */
    private final zzeps<zzcat> f14845b;

    /* renamed from: c */
    private final zzeps<Executor> f14846c;

    public zzctv(zzeps<Context> zzeps, zzeps<zzcat> zzeps2, zzeps<Executor> zzeps3) {
        this.f14844a = zzeps;
        this.f14845b = zzeps2;
        this.f14846c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzctw(this.f14844a.get(), this.f14845b.get(), this.f14846c.get());
    }
}
