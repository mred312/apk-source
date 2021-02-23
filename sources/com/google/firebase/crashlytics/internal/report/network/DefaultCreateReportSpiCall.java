package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.ResponseParser;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {

    /* renamed from: f */
    private final String f19506f;

    public DefaultCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        this(str, str2, httpRequestFactory, HttpMethod.POST, str3);
    }

    /* renamed from: b */
    private HttpRequest m11685b(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        HttpRequest header = httpRequest.header(AbstractSpiCall.HEADER_GOOGLE_APP_ID, createReportRequest.googleAppId).header(AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE).header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.f19506f);
        for (Map.Entry<String, String> header2 : createReportRequest.report.getCustomHeaders().entrySet()) {
            header = header.header(header2);
        }
        return header;
    }

    /* renamed from: c */
    private HttpRequest m11686c(HttpRequest httpRequest, Report report) {
        HttpRequest part = httpRequest.part("report[identifier]", report.getIdentifier());
        if (report.getFiles().length == 1) {
            Logger.getLogger().mo20859d("Adding single file " + report.getFileName() + " to report " + report.getIdentifier());
            return part.part("report[file]", report.getFileName(), "application/octet-stream", report.getFile());
        }
        int i = 0;
        for (File file : report.getFiles()) {
            Logger.getLogger().mo20859d("Adding file " + file.getName() + " to report " + report.getIdentifier());
            StringBuilder sb = new StringBuilder();
            sb.append("report[file");
            sb.append(i);
            sb.append("]");
            part = part.part(sb.toString(), file.getName(), "application/octet-stream", file);
            i++;
        }
        return part;
    }

    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        if (z) {
            HttpRequest c = m11686c(m11685b(getHttpRequest(), createReportRequest), createReportRequest.report);
            Logger logger = Logger.getLogger();
            logger.mo20859d("Sending report to: " + getUrl());
            try {
                HttpResponse execute = c.execute();
                int code = execute.code();
                Logger logger2 = Logger.getLogger();
                logger2.mo20859d("Create report request ID: " + execute.header(AbstractSpiCall.HEADER_REQUEST_ID));
                Logger logger3 = Logger.getLogger();
                logger3.mo20859d("Result was: " + code);
                return ResponseParser.parse(code) == 0;
            } catch (IOException e) {
                Logger.getLogger().mo20862e("Create report HTTP request failed.", e);
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }

    DefaultCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod, String str3) {
        super(str, str2, httpRequestFactory, httpMethod);
        this.f19506f = str3;
    }
}
