package com.google.firebase.crashlytics.internal.persistence;

import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.f */
/* compiled from: CrashlyticsReportPersistence */
final /* synthetic */ class C3444f implements FilenameFilter {

    /* renamed from: a */
    private static final C3444f f19472a = new C3444f();

    private C3444f() {
    }

    /* renamed from: a */
    public static FilenameFilter m11649a() {
        return f19472a;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT);
    }
}
