package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageInfo;

/* renamed from: com.google.firebase.crashlytics.internal.common.a */
/* compiled from: AppData */
class C3276a {

    /* renamed from: a */
    public final String f19066a;

    /* renamed from: b */
    public final String f19067b;

    /* renamed from: c */
    public final String f19068c;

    /* renamed from: d */
    public final String f19069d;

    /* renamed from: e */
    public final String f19070e;

    /* renamed from: f */
    public final String f19071f;

    public C3276a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f19066a = str;
        this.f19067b = str2;
        this.f19068c = str3;
        this.f19069d = str4;
        this.f19070e = str5;
        this.f19071f = str6;
    }

    /* renamed from: a */
    public static C3276a m11287a(Context context, IdManager idManager, String str, String str2) {
        String packageName = context.getPackageName();
        String installerPackageName = idManager.getInstallerPackageName();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String num = Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = IdManager.DEFAULT_VERSION_NAME;
        }
        return new C3276a(str, str2, installerPackageName, packageName, num, str3);
    }
}
