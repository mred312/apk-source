package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddq implements zzepf<zzddn> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15458a;

    /* renamed from: b */
    private final zzeps<zzdnn> f15459b;

    /* renamed from: c */
    private final zzeps<PackageInfo> f15460c;

    /* renamed from: d */
    private final zzeps<zzf> f15461d;

    public zzddq(zzeps<zzdzc> zzeps, zzeps<zzdnn> zzeps2, zzeps<PackageInfo> zzeps3, zzeps<zzf> zzeps4) {
        this.f15458a = zzeps;
        this.f15459b = zzeps2;
        this.f15460c = zzeps3;
        this.f15461d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzddn(this.f15458a.get(), this.f15459b.get(), this.f15460c.get(), this.f15461d.get());
    }
}
