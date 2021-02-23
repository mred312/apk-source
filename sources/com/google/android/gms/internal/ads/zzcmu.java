package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmu implements zzepf<PackageInfo> {

    /* renamed from: a */
    private final zzeps<Context> f14608a;

    /* renamed from: b */
    private final zzeps<ApplicationInfo> f14609b;

    private zzcmu(zzeps<Context> zzeps, zzeps<ApplicationInfo> zzeps2) {
        this.f14608a = zzeps;
        this.f14609b = zzeps2;
    }

    public static zzcmu zzas(zzeps<Context> zzeps, zzeps<ApplicationInfo> zzeps2) {
        return new zzcmu(zzeps, zzeps2);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        return zzcmk.zza(this.f14608a.get(), this.f14609b.get());
    }
}
