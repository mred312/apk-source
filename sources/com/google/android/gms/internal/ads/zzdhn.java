package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdhn {

    /* renamed from: a */
    private final zzatl f15637a;

    /* renamed from: b */
    private final int f15638b;

    public zzdhn(zzatl zzatl, int i) {
        this.f15637a = zzatl;
        this.f15638b = i;
    }

    public final String zzatj() {
        return this.f15637a.packageName;
    }

    public final String zzatk() {
        return this.f15637a.zzdvx.getString("ms");
    }

    @Nullable
    public final PackageInfo zzatl() {
        return this.f15637a.zzdss;
    }

    public final boolean zzatm() {
        return this.f15637a.zzdvy;
    }

    public final List<String> zzatn() {
        return this.f15637a.zzdtc;
    }

    public final ApplicationInfo zzato() {
        return this.f15637a.applicationInfo;
    }

    public final String zzatp() {
        return this.f15637a.zzdvz;
    }

    public final int zzatq() {
        return this.f15638b;
    }
}
