package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.a */
/* compiled from: CrashlyticsReportJsonTransform */
final /* synthetic */ class C3424a implements CrashlyticsReportJsonTransform.C3423a {

    /* renamed from: a */
    private static final C3424a f19429a = new C3424a();

    private C3424a() {
    }

    /* renamed from: b */
    public static CrashlyticsReportJsonTransform.C3423a m11584b() {
        return f19429a;
    }

    /* renamed from: a */
    public Object mo21389a(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.m11568l(jsonReader);
    }
}
