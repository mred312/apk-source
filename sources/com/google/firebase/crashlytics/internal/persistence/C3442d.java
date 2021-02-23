package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.d */
/* compiled from: CrashlyticsReportPersistence */
final /* synthetic */ class C3442d implements Comparator {

    /* renamed from: a */
    private static final C3442d f19470a = new C3442d();

    private C3442d() {
    }

    /* renamed from: a */
    public static Comparator m11647a() {
        return f19470a;
    }

    public int compare(Object obj, Object obj2) {
        return CrashlyticsReportPersistence.m11637u((File) obj, (File) obj2);
    }
}
