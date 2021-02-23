package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class PackageManagerWrapper {

    /* renamed from: a */
    private final Context f7651a;

    public PackageManagerWrapper(Context context) {
        this.f7651a = context;
    }

    @KeepForSdk
    public int checkCallingOrSelfPermission(String str) {
        return this.f7651a.checkCallingOrSelfPermission(str);
    }

    @KeepForSdk
    public int checkPermission(String str, String str2) {
        return this.f7651a.getPackageManager().checkPermission(str, str2);
    }

    @KeepForSdk
    public ApplicationInfo getApplicationInfo(String str, int i) {
        return this.f7651a.getPackageManager().getApplicationInfo(str, i);
    }

    @KeepForSdk
    public CharSequence getApplicationLabel(String str) {
        return this.f7651a.getPackageManager().getApplicationLabel(this.f7651a.getPackageManager().getApplicationInfo(str, 0));
    }

    @KeepForSdk
    public PackageInfo getPackageInfo(String str, int i) {
        return this.f7651a.getPackageManager().getPackageInfo(str, i);
    }

    @KeepForSdk
    public boolean isCallerInstantApp() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp(this.f7651a);
        }
        if (!PlatformVersion.isAtLeastO() || (nameForUid = this.f7651a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f7651a.getPackageManager().isInstantApp(nameForUid);
    }

    public final PackageInfo zza(String str, int i, int i2) {
        return this.f7651a.getPackageManager().getPackageInfo(str, 64);
    }

    public final String[] zza(int i) {
        return this.f7651a.getPackageManager().getPackagesForUid(i);
    }

    @TargetApi(19)
    public final boolean zza(int i, String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            try {
                ((AppOpsManager) this.f7651a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.f7651a.getPackageManager().getPackagesForUid(i);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
