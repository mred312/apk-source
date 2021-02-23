package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzabk {
    public static void zza(zzabi zzabi, @Nullable zzabj zzabj) {
        if (zzabj.mo15171a() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzabj.mo15172b())) {
            zzabi.zza(zzabj.mo15171a(), zzabj.mo15172b(), zzabj.mo15173c(), zzabj.mo15174d());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
