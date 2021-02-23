package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbnp implements zzepf<zzbnk> {

    /* renamed from: a */
    private final zzeps<zzbob> f13543a;

    /* renamed from: b */
    private final zzeps<zzagd> f13544b;

    /* renamed from: c */
    private final zzeps<Runnable> f13545c;

    /* renamed from: d */
    private final zzeps<Executor> f13546d;

    public zzbnp(zzeps<zzbob> zzeps, zzeps<zzagd> zzeps2, zzeps<Runnable> zzeps3, zzeps<Executor> zzeps4) {
        this.f13543a = zzeps;
        this.f13544b = zzeps2;
        this.f13545c = zzeps3;
        this.f13546d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzbnk(this.f13543a.get(), this.f13544b.get(), this.f13545c.get(), this.f13546d.get());
    }
}
