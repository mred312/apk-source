package com.google.firebase.crashlytics.internal.report.network;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.ResponseParser;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.io.IOException;

public class NativeCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {

    /* renamed from: f */
    private final String f19507f;

    public NativeCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(str, str2, httpRequestFactory, HttpMethod.POST);
        this.f19507f = str3;
    }

    /* renamed from: b */
    private HttpRequest m11687b(HttpRequest httpRequest, String str) {
        httpRequest.header(AbstractSpiCall.HEADER_USER_AGENT, AbstractSpiCall.CRASHLYTICS_USER_AGENT + CrashlyticsCore.getVersion()).header(AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE).header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.f19507f).header(AbstractSpiCall.HEADER_GOOGLE_APP_ID, str);
        return httpRequest;
    }

    /* renamed from: c */
    private HttpRequest m11688c(HttpRequest httpRequest, @Nullable String str, Report report) {
        if (str != null) {
            httpRequest.part(C3457a.ORGANIZATION_ID_PARAM, str);
        }
        httpRequest.part("report_id", report.getIdentifier());
        for (File file : report.getFiles()) {
            if (file.getName().equals("minidump")) {
                httpRequest.part("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("metadata")) {
                httpRequest.part("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                httpRequest.part("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                httpRequest.part("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("app")) {
                httpRequest.part("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("device")) {
                httpRequest.part("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                httpRequest.part("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("user")) {
                httpRequest.part("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                httpRequest.part("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                httpRequest.part("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        return httpRequest;
    }

    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        if (z) {
            HttpRequest httpRequest = getHttpRequest();
            m11687b(httpRequest, createReportRequest.googleAppId);
            m11688c(httpRequest, createReportRequest.organizationId, createReportRequest.report);
            Logger logger = Logger.getLogger();
            logger.mo20859d("Sending report to: " + getUrl());
            try {
                int code = httpRequest.execute().code();
                Logger logger2 = Logger.getLogger();
                logger2.mo20859d("Result was: " + code);
                return ResponseParser.parse(code) == 0;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }
}
