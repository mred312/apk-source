package com.google.firebase.crashlytics.internal.send;

import com.bumptech.glide.load.Key;
import com.google.android.datatransport.Transformer;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.nio.charset.Charset;

/* renamed from: com.google.firebase.crashlytics.internal.send.b */
/* compiled from: DataTransportCrashlyticsReportSender */
final /* synthetic */ class C3452b implements Transformer {

    /* renamed from: a */
    private static final C3452b f19516a = new C3452b();

    private C3452b() {
    }

    /* renamed from: a */
    public static Transformer m11693a() {
        return f19516a;
    }

    public Object apply(Object obj) {
        return DataTransportCrashlyticsReportSender.f19508c.reportToJson((CrashlyticsReport) obj).getBytes(Charset.forName(Key.STRING_CHARSET_NAME));
    }
}
