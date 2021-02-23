package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.c */
/* compiled from: CrashlyticsReportPersistence */
final /* synthetic */ class C3441c implements FilenameFilter {

    /* renamed from: a */
    private static final C3441c f19469a = new C3441c();

    private C3441c() {
    }

    /* renamed from: a */
    public static FilenameFilter m11646a() {
        return f19469a;
    }

    public boolean accept(File file, String str) {
        return CrashlyticsReportPersistence.m11631o(file, str);
    }
}
