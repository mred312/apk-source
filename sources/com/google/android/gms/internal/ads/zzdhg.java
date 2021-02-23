package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdhg implements zzepf<zzdhe> {

    /* renamed from: a */
    private final zzeps<zzamy> f15625a;

    /* renamed from: b */
    private final zzeps<ScheduledExecutorService> f15626b;

    /* renamed from: c */
    private final zzeps<Boolean> f15627c;

    /* renamed from: d */
    private final zzeps<ApplicationInfo> f15628d;

    public zzdhg(zzeps<zzamy> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<Boolean> zzeps3, zzeps<ApplicationInfo> zzeps4) {
        this.f15625a = zzeps;
        this.f15626b = zzeps2;
        this.f15627c = zzeps3;
        this.f15628d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzdhe(this.f15625a.get(), this.f15626b.get(), this.f15627c.get().booleanValue(), this.f15628d.get());
    }
}
