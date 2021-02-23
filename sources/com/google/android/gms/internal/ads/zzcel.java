package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcel implements zzepf<zzcej> {

    /* renamed from: a */
    private final zzeps<zzax> f14191a;

    /* renamed from: b */
    private final zzeps<Clock> f14192b;

    /* renamed from: c */
    private final zzeps<Executor> f14193c;

    public zzcel(zzeps<zzax> zzeps, zzeps<Clock> zzeps2, zzeps<Executor> zzeps3) {
        this.f14191a = zzeps;
        this.f14192b = zzeps2;
        this.f14193c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzcej(this.f14191a.get(), this.f14192b.get(), this.f14193c.get());
    }
}
