package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Comparator;

/* renamed from: com.google.firebase.crashlytics.internal.common.r */
/* compiled from: SessionReportingCoordinator */
final /* synthetic */ class C3334r implements Comparator {

    /* renamed from: a */
    private static final C3334r f19203a = new C3334r();

    private C3334r() {
    }

    /* renamed from: a */
    public static Comparator m11466a() {
        return f19203a;
    }

    public int compare(Object obj, Object obj2) {
        return ((CrashlyticsReport.CustomAttribute) obj).getKey().compareTo(((CrashlyticsReport.CustomAttribute) obj2).getKey());
    }
}
