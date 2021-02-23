package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;

/* renamed from: com.google.firebase.crashlytics.internal.common.i */
/* compiled from: CrashlyticsCore */
final /* synthetic */ class C3323i implements BreadcrumbHandler {

    /* renamed from: a */
    private final CrashlyticsCore f19188a;

    private C3323i(CrashlyticsCore crashlyticsCore) {
        this.f19188a = crashlyticsCore;
    }

    /* renamed from: a */
    public static BreadcrumbHandler m11438a(CrashlyticsCore crashlyticsCore) {
        return new C3323i(crashlyticsCore);
    }

    public void handleBreadcrumb(String str) {
        this.f19188a.log(str);
    }
}
