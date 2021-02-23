package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.e */
/* compiled from: CrashlyticsReportPersistence */
final /* synthetic */ class C3443e implements Comparator {

    /* renamed from: a */
    private static final C3443e f19471a = new C3443e();

    private C3443e() {
    }

    /* renamed from: a */
    public static Comparator m11648a() {
        return f19471a;
    }

    public int compare(Object obj, Object obj2) {
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
