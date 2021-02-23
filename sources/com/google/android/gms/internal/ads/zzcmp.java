package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmp implements zzepf<ApplicationInfo> {

    /* renamed from: a */
    private final zzeps<Context> f14604a;

    private zzcmp(zzeps<Context> zzeps) {
        this.f14604a = zzeps;
    }

    public static zzcmp zzab(zzeps<Context> zzeps) {
        return new zzcmp(zzeps);
    }

    public static ApplicationInfo zzch(Context context) {
        return (ApplicationInfo) zzepl.zza(context.getApplicationInfo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzch(this.f14604a.get());
    }
}
