package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

/* renamed from: com.google.firebase.crashlytics.internal.send.a */
/* compiled from: DataTransportCrashlyticsReportSender */
final /* synthetic */ class C3451a implements TransportScheduleCallback {

    /* renamed from: a */
    private final TaskCompletionSource f19514a;

    /* renamed from: b */
    private final CrashlyticsReportWithSessionId f19515b;

    private C3451a(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.f19514a = taskCompletionSource;
        this.f19515b = crashlyticsReportWithSessionId;
    }

    /* renamed from: a */
    public static TransportScheduleCallback m11692a(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        return new C3451a(taskCompletionSource, crashlyticsReportWithSessionId);
    }

    public void onSchedule(Exception exc) {
        DataTransportCrashlyticsReportSender.m11689a(this.f19514a, this.f19515b, exc);
    }
}
