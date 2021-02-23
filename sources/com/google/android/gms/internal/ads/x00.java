package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class x00 implements w00 {

    /* renamed from: a */
    private static final zzcf.zza f11742a = ((zzcf.zza) ((zzekh) zzcf.zza.zzaq().zzv("E").zzbhv()));

    x00() {
    }

    /* renamed from: a */
    public final zzcf.zza mo14852a(Context context) {
        return zzdsp.zzj(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    /* renamed from: b */
    public final zzcf.zza mo14853b() {
        return f11742a;
    }
}
