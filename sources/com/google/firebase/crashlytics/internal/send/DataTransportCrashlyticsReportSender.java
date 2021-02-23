package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.Destination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

public class DataTransportCrashlyticsReportSender {

    /* renamed from: c */
    private static final CrashlyticsReportJsonTransform f19508c = new CrashlyticsReportJsonTransform();

    /* renamed from: d */
    private static final String f19509d = m11691c("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: e */
    private static final String f19510e = m11691c("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: f */
    private static final Transformer<CrashlyticsReport, byte[]> f19511f = C3452b.m11693a();

    /* renamed from: a */
    private final Transport<CrashlyticsReport> f19512a;

    /* renamed from: b */
    private final Transformer<CrashlyticsReport, byte[]> f19513b;

    DataTransportCrashlyticsReportSender(Transport<CrashlyticsReport> transport, Transformer<CrashlyticsReport, byte[]> transformer) {
        this.f19512a = transport;
        this.f19513b = transformer;
    }

    /* renamed from: a */
    static /* synthetic */ void m11689a(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
        } else {
            taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
        }
    }

    /* renamed from: c */
    private static String m11691c(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static DataTransportCrashlyticsReportSender create(Context context) {
        TransportRuntime.initialize(context);
        Encoding of = Encoding.m5015of("json");
        Transformer<CrashlyticsReport, byte[]> transformer = f19511f;
        return new DataTransportCrashlyticsReportSender(TransportRuntime.getInstance().newFactory((Destination) new CCTDestination(f19509d, f19510e)).getTransport("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, of, transformer), transformer);
    }

    @NonNull
    public Task<CrashlyticsReportWithSessionId> sendReport(@NonNull CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        CrashlyticsReport report = crashlyticsReportWithSessionId.getReport();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f19512a.schedule(Event.ofUrgent(report), C3451a.m11692a(taskCompletionSource, crashlyticsReportWithSessionId));
        return taskCompletionSource.getTask();
    }
}
