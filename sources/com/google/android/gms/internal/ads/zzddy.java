package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddy implements zzepf<zzddz> {

    /* renamed from: a */
    private final zzeps<ApplicationInfo> f15472a;

    /* renamed from: b */
    private final zzeps<PackageInfo> f15473b;

    private zzddy(zzeps<ApplicationInfo> zzeps, zzeps<PackageInfo> zzeps2) {
        this.f15472a = zzeps;
        this.f15473b = zzeps2;
    }

    public static zzddz zza(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return new zzddz(applicationInfo, packageInfo);
    }

    public static zzddy zzbe(zzeps<ApplicationInfo> zzeps, zzeps<PackageInfo> zzeps2) {
        return new zzddy(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.f15472a.get(), this.f15473b.get());
    }
}
