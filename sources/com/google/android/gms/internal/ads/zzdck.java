package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdck implements zzepf<zzdcg> {

    /* renamed from: a */
    private final zzeps<zzamy> f15420a;

    /* renamed from: b */
    private final zzeps<ScheduledExecutorService> f15421b;

    /* renamed from: c */
    private final zzeps<zzf> f15422c;

    /* renamed from: d */
    private final zzeps<ApplicationInfo> f15423d;

    /* renamed from: e */
    private final zzeps<zzdnn> f15424e;

    private zzdck(zzeps<zzamy> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<zzf> zzeps3, zzeps<ApplicationInfo> zzeps4, zzeps<zzdnn> zzeps5) {
        this.f15420a = zzeps;
        this.f15421b = zzeps2;
        this.f15422c = zzeps3;
        this.f15423d = zzeps4;
        this.f15424e = zzeps5;
    }

    public static zzdck zzh(zzeps<zzamy> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<zzf> zzeps3, zzeps<ApplicationInfo> zzeps4, zzeps<zzdnn> zzeps5) {
        return new zzdck(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzdcg(this.f15420a.get(), this.f15421b.get(), this.f15422c.get(), this.f15423d.get(), this.f15424e.get());
    }
}
