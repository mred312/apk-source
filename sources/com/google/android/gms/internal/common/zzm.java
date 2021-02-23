package com.google.android.gms.internal.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class zzm {
    static {
        zza();
    }

    public static boolean zza() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @RequiresApi(24)
    @TargetApi(24)
    public static Context zza(Context context) {
        if (context.isDeviceProtectedStorage()) {
            return context;
        }
        return context.createDeviceProtectedStorageContext();
    }
}
