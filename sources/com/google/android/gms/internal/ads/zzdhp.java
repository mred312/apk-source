package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdhp implements zzepf<ApplicationInfo> {

    /* renamed from: a */
    private final zzdhn f15640a;

    public zzdhp(zzdhn zzdhn) {
        this.f15640a = zzdhn;
    }

    public static ApplicationInfo zzc(zzdhn zzdhn) {
        return (ApplicationInfo) zzepl.zza(zzdhn.zzato(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzc(this.f15640a);
    }
}
