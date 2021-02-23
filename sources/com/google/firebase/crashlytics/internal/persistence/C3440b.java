package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FileFilter;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.b */
/* compiled from: CrashlyticsReportPersistence */
final /* synthetic */ class C3440b implements FileFilter {

    /* renamed from: a */
    private final String f19468a;

    private C3440b(String str) {
        this.f19468a = str;
    }

    /* renamed from: a */
    public static FileFilter m11645a(String str) {
        return new C3440b(str);
    }

    public boolean accept(File file) {
        return CrashlyticsReportPersistence.m11632p(this.f19468a, file);
    }
}
