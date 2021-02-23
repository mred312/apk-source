package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

/* renamed from: com.google.firebase.crashlytics.internal.common.m */
/* compiled from: InstallerPackageNameProvider */
class C3328m {

    /* renamed from: a */
    private String f19198a;

    C3328m() {
    }

    /* renamed from: b */
    private static String m11449b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized String mo21033a(Context context) {
        if (this.f19198a == null) {
            this.f19198a = m11449b(context);
        }
        return "".equals(this.f19198a) ? null : this.f19198a;
    }
}
