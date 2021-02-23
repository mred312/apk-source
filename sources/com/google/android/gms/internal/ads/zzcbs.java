package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcbs implements zzepf<zzbkr> {

    /* renamed from: a */
    private final zzeps<zzqr> f13998a;

    /* renamed from: b */
    private final zzeps<Executor> f13999b;

    /* renamed from: c */
    private final zzeps<Context> f14000c;

    /* renamed from: d */
    private final zzeps<Clock> f14001d;

    public zzcbs(zzeps<zzqr> zzeps, zzeps<Executor> zzeps2, zzeps<Context> zzeps3, zzeps<Clock> zzeps4) {
        this.f13998a = zzeps;
        this.f13999b = zzeps2;
        this.f14000c = zzeps3;
        this.f14001d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return (zzbkr) zzepl.zza(new zzbkr(this.f13999b.get(), new zzbkg(this.f14000c.get(), this.f13998a.get()), this.f14001d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
