package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class zzs {

    /* renamed from: a */
    private static Object f7580a = new Object();
    @GuardedBy("sLock")

    /* renamed from: b */
    private static boolean f7581b;
    @Nullable

    /* renamed from: c */
    private static String f7582c;

    /* renamed from: d */
    private static int f7583d;

    /* renamed from: a */
    private static void m5321a(Context context) {
        synchronized (f7580a) {
            if (!f7581b) {
                f7581b = true;
                try {
                    Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f7582c = bundle.getString("com.google.app.id");
                        f7583d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }

    @Nullable
    public static String zza(Context context) {
        m5321a(context);
        return f7582c;
    }

    public static int zzb(Context context) {
        m5321a(context);
        return f7583d;
    }
}
