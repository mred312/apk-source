package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public class zzcr {
    @GuardedBy("DirectBootUtils.class")

    /* renamed from: a */
    private static UserManager f17611a;

    /* renamed from: b */
    private static volatile boolean f17612b = (!zza());

    private zzcr() {
    }

    @RequiresApi(24)
    @TargetApi(24)
    @GuardedBy("DirectBootUtils.class")
    /* renamed from: a */
    private static boolean m10299a(Context context) {
        boolean z;
        boolean z2 = true;
        int i = 1;
        while (true) {
            z = false;
            if (i > 2) {
                break;
            }
            if (f17611a == null) {
                f17611a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = f17611a;
            if (userManager == null) {
                return true;
            }
            try {
                if (!userManager.isUserUnlocked() && userManager.isUserRunning(Process.myUserHandle())) {
                    z2 = false;
                }
                z = z2;
            } catch (NullPointerException e) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e);
                f17611a = null;
                i++;
            }
        }
        if (z) {
            f17611a = null;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        return r3;
     */
    @androidx.annotation.RequiresApi(24)
    @android.annotation.TargetApi(24)
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m10300b(android.content.Context r3) {
        /*
            boolean r0 = f17612b
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Class<com.google.android.gms.internal.measurement.zzcr> r0 = com.google.android.gms.internal.measurement.zzcr.class
            monitor-enter(r0)
            boolean r2 = f17612b     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r1
        L_0x000f:
            boolean r3 = m10299a(r3)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0017
            f17612b = r3     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcr.m10300b(android.content.Context):boolean");
    }

    public static boolean zza() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean zza(Context context) {
        return !zza() || m10300b(context);
    }
}
