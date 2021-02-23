package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdhk implements zzepf<zzdhi> {

    /* renamed from: a */
    private final zzeps<zzarr> f15633a;

    /* renamed from: b */
    private final zzeps<ScheduledExecutorService> f15634b;

    /* renamed from: c */
    private final zzeps<Context> f15635c;

    public zzdhk(zzeps<zzarr> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<Context> zzeps3) {
        this.f15633a = zzeps;
        this.f15634b = zzeps2;
        this.f15635c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzdhi(this.f15633a.get(), this.f15634b.get(), this.f15635c.get());
    }
}
