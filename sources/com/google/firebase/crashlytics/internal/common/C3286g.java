package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.firebase.crashlytics.internal.common.g */
/* compiled from: CrashlyticsController */
final /* synthetic */ class C3286g implements FilenameFilter {

    /* renamed from: a */
    private static final C3286g f19088a = new C3286g();

    private C3286g() {
    }

    /* renamed from: a */
    public static FilenameFilter m11314a() {
        return f19088a;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(".ae");
    }
}
