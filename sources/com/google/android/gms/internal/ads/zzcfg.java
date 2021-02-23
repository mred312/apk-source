package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcfg implements zzepf<zzcfc> {

    /* renamed from: a */
    private final zzeps<Executor> f14266a;

    /* renamed from: b */
    private final zzeps<zzces> f14267b;

    public zzcfg(zzeps<Executor> zzeps, zzeps<zzces> zzeps2) {
        this.f14266a = zzeps;
        this.f14267b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzcfc(this.f14266a.get(), this.f14267b.get());
    }
}
