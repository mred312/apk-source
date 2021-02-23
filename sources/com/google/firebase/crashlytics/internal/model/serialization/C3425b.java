package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.b */
/* compiled from: CrashlyticsReportJsonTransform */
final /* synthetic */ class C3425b implements CrashlyticsReportJsonTransform.C3423a {

    /* renamed from: a */
    private static final C3425b f19430a = new C3425b();

    private C3425b() {
    }

    /* renamed from: b */
    public static CrashlyticsReportJsonTransform.C3423a m11586b() {
        return f19430a;
    }

    /* renamed from: a */
    public Object mo21389a(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.m11578v(jsonReader);
    }
}
