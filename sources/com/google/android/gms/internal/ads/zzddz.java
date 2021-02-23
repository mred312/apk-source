package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddz implements zzdfi<zzdfj<Bundle>>, zzdfj<Bundle> {

    /* renamed from: a */
    private final ApplicationInfo f15474a;

    /* renamed from: b */
    private final PackageInfo f15475b;

    zzddz(ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo) {
        this.f15474a = applicationInfo;
        this.f15475b = packageInfo;
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        return zzdyr.zzag(this);
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.f15474a.packageName;
        PackageInfo packageInfo = this.f15475b;
        String str2 = null;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle.putString("pn", str);
        if (valueOf != null) {
            bundle.putInt("vc", valueOf.intValue());
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwd)).booleanValue()) {
            PackageInfo packageInfo2 = this.f15475b;
            if (packageInfo2 != null) {
                str2 = packageInfo2.versionName;
            }
            if (str2 != null) {
                bundle.putString("vnm", str2);
            }
        }
    }
}
