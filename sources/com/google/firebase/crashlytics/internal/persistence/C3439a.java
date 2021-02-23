package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.a */
/* compiled from: CrashlyticsReportPersistence */
final /* synthetic */ class C3439a implements FilenameFilter {

    /* renamed from: a */
    private final String f19467a;

    private C3439a(String str) {
        this.f19467a = str;
    }

    /* renamed from: a */
    public static FilenameFilter m11644a(String str) {
        return new C3439a(str);
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.f19467a);
    }
}
