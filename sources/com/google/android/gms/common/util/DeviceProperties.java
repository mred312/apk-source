package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class DeviceProperties {

    /* renamed from: a */
    private static Boolean f7615a;

    /* renamed from: b */
    private static Boolean f7616b;

    /* renamed from: c */
    private static Boolean f7617c;

    /* renamed from: d */
    private static Boolean f7618d;

    /* renamed from: e */
    private static Boolean f7619e;

    /* renamed from: f */
    private static Boolean f7620f;

    /* renamed from: g */
    private static Boolean f7621g;

    /* renamed from: h */
    private static Boolean f7622h;

    private DeviceProperties() {
    }

    @TargetApi(21)
    /* renamed from: a */
    private static boolean m5343a(Context context) {
        if (f7618d == null) {
            f7618d = Boolean.valueOf(PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f7618d.booleanValue();
    }

    @KeepForSdk
    public static boolean isAuto(Context context) {
        return isAuto(context.getPackageManager());
    }

    @KeepForSdk
    @Deprecated
    public static boolean isFeaturePhone(Context context) {
        return false;
    }

    @KeepForSdk
    public static boolean isLatchsky(Context context) {
        if (f7619e == null) {
            PackageManager packageManager = context.getPackageManager();
            f7619e = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return f7619e.booleanValue();
    }

    @TargetApi(21)
    @KeepForSdk
    public static boolean isSidewinder(Context context) {
        return m5343a(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (f7616b.booleanValue() != false) goto L_0x003e;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isTablet(android.content.res.Resources r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.Boolean r1 = f7615a
            if (r1 != 0) goto L_0x0045
            android.content.res.Configuration r1 = r4.getConfiguration()
            int r1 = r1.screenLayout
            r1 = r1 & 15
            r2 = 3
            r3 = 1
            if (r1 <= r2) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            if (r1 != 0) goto L_0x003e
            java.lang.Boolean r1 = f7616b
            if (r1 != 0) goto L_0x0036
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r1 = r4.screenLayout
            r1 = r1 & 15
            if (r1 > r2) goto L_0x002f
            int r4 = r4.smallestScreenWidthDp
            r1 = 600(0x258, float:8.41E-43)
            if (r4 < r1) goto L_0x002f
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            f7616b = r4
        L_0x0036:
            java.lang.Boolean r4 = f7616b
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x003f
        L_0x003e:
            r0 = 1
        L_0x003f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            f7615a = r4
        L_0x0045:
            java.lang.Boolean r4 = f7615a
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isTablet(android.content.res.Resources):boolean");
    }

    @KeepForSdk
    public static boolean isTv(Context context) {
        return isTv(context.getPackageManager());
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    @KeepForSdk
    public static boolean isWearable(Context context) {
        return isWearable(context.getPackageManager());
    }

    @TargetApi(26)
    @KeepForSdk
    public static boolean isWearableWithoutPlayStore(Context context) {
        if (!isWearable(context)) {
            return false;
        }
        if (PlatformVersion.isAtLeastN()) {
            return m5343a(context) && !PlatformVersion.isAtLeastO();
        }
        return true;
    }

    public static boolean zza(Context context) {
        if (f7620f == null) {
            f7620f = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f7620f.booleanValue();
    }

    @KeepForSdk
    public static boolean isAuto(PackageManager packageManager) {
        if (f7621g == null) {
            f7621g = Boolean.valueOf(PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        return f7621g.booleanValue();
    }

    @KeepForSdk
    public static boolean isTv(PackageManager packageManager) {
        if (f7622h == null) {
            f7622h = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return f7622h.booleanValue();
    }

    @TargetApi(20)
    @KeepForSdk
    public static boolean isWearable(PackageManager packageManager) {
        if (f7617c == null) {
            f7617c = Boolean.valueOf(PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f7617c.booleanValue();
    }
}
