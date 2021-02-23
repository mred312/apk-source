package com.google.firebase.crashlytics.internal.report;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable;
import com.google.firebase.crashlytics.internal.common.DataTransportState;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportUploader {
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final short[] f19486h = {10, 20, 30, 60, 120, 300};

    /* renamed from: a */
    private final CreateReportSpiCall f19487a;
    @Nullable

    /* renamed from: b */
    private final String f19488b;

    /* renamed from: c */
    private final String f19489c;

    /* renamed from: d */
    private final DataTransportState f19490d;

    /* renamed from: e */
    private final ReportManager f19491e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final HandlingExceptionCheck f19492f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Thread f19493g;

    public interface HandlingExceptionCheck {
        boolean isHandlingException();
    }

    public interface Provider {
        ReportUploader createReportUploader(@NonNull AppSettingsData appSettingsData);
    }

    public interface ReportFilesProvider {
        File[] getCompleteSessionFiles();

        File[] getNativeReportFiles();
    }

    /* renamed from: com.google.firebase.crashlytics.internal.report.ReportUploader$a */
    private class C3449a extends BackgroundPriorityRunnable {

        /* renamed from: a */
        private final List<Report> f19494a;

        /* renamed from: b */
        private final boolean f19495b;

        /* renamed from: c */
        private final float f19496c;

        C3449a(List<Report> list, boolean z, float f) {
            this.f19494a = list;
            this.f19495b = z;
            this.f19496c = f;
        }

        /* renamed from: a */
        private void m11684a(List<Report> list, boolean z) {
            Logger logger = Logger.getLogger();
            logger.mo20859d("Starting report processing in " + this.f19496c + " second(s)...");
            float f = this.f19496c;
            if (f > 0.0f) {
                try {
                    Thread.sleep((long) (f * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (!ReportUploader.this.f19492f.isHandlingException()) {
                int i = 0;
                while (list.size() > 0 && !ReportUploader.this.f19492f.isHandlingException()) {
                    Logger logger2 = Logger.getLogger();
                    logger2.mo20859d("Attempting to send " + list.size() + " report(s)");
                    ArrayList arrayList = new ArrayList();
                    for (Report next : list) {
                        if (!ReportUploader.this.uploadReport(next, z)) {
                            arrayList.add(next);
                        }
                    }
                    if (arrayList.size() > 0) {
                        int i2 = i + 1;
                        long j = (long) ReportUploader.f19486h[Math.min(i, ReportUploader.f19486h.length - 1)];
                        Logger logger3 = Logger.getLogger();
                        logger3.mo20859d("Report submission: scheduling delayed retry in " + j + " seconds");
                        try {
                            Thread.sleep(j * 1000);
                            i = i2;
                        } catch (InterruptedException unused2) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    list = arrayList;
                }
            }
        }

        public void onRun() {
            try {
                m11684a(this.f19494a, this.f19495b);
            } catch (Exception e) {
                Logger.getLogger().mo20862e("An unexpected error occurred while attempting to upload crash reports.", e);
            }
            Thread unused = ReportUploader.this.f19493g = null;
        }
    }

    public ReportUploader(@Nullable String str, String str2, DataTransportState dataTransportState, ReportManager reportManager, CreateReportSpiCall createReportSpiCall, HandlingExceptionCheck handlingExceptionCheck) {
        if (createReportSpiCall != null) {
            this.f19487a = createReportSpiCall;
            this.f19488b = str;
            this.f19489c = str2;
            this.f19490d = dataTransportState;
            this.f19491e = reportManager;
            this.f19492f = handlingExceptionCheck;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A[Catch:{ Exception -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean uploadReport(com.google.firebase.crashlytics.internal.report.model.Report r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            com.google.firebase.crashlytics.internal.report.model.CreateReportRequest r1 = new com.google.firebase.crashlytics.internal.report.model.CreateReportRequest     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = r5.f19488b     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = r5.f19489c     // Catch:{ Exception -> 0x0067 }
            r1.<init>(r2, r3, r6)     // Catch:{ Exception -> 0x0067 }
            com.google.firebase.crashlytics.internal.common.DataTransportState r2 = r5.f19490d     // Catch:{ Exception -> 0x0067 }
            com.google.firebase.crashlytics.internal.common.DataTransportState r3 = com.google.firebase.crashlytics.internal.common.DataTransportState.ALL     // Catch:{ Exception -> 0x0067 }
            r4 = 1
            if (r2 != r3) goto L_0x001b
            com.google.firebase.crashlytics.internal.Logger r7 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = "Send to Reports Endpoint disabled. Removing Reports Endpoint report."
            r7.mo20859d(r1)     // Catch:{ Exception -> 0x0067 }
            goto L_0x0030
        L_0x001b:
            com.google.firebase.crashlytics.internal.common.DataTransportState r3 = com.google.firebase.crashlytics.internal.common.DataTransportState.JAVA_ONLY     // Catch:{ Exception -> 0x0067 }
            if (r2 != r3) goto L_0x0032
            com.google.firebase.crashlytics.internal.report.model.Report$Type r2 = r6.getType()     // Catch:{ Exception -> 0x0067 }
            com.google.firebase.crashlytics.internal.report.model.Report$Type r3 = com.google.firebase.crashlytics.internal.report.model.Report.Type.JAVA     // Catch:{ Exception -> 0x0067 }
            if (r2 != r3) goto L_0x0032
            com.google.firebase.crashlytics.internal.Logger r7 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = "Send to Reports Endpoint for non-native reports disabled. Removing Reports Uploader report."
            r7.mo20859d(r1)     // Catch:{ Exception -> 0x0067 }
        L_0x0030:
            r7 = 1
            goto L_0x005e
        L_0x0032:
            com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall r2 = r5.f19487a     // Catch:{ Exception -> 0x0067 }
            boolean r7 = r2.invoke(r1, r7)     // Catch:{ Exception -> 0x0067 }
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ Exception -> 0x0067 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067 }
            r2.<init>()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = "Crashlytics Reports Endpoint upload "
            r2.append(r3)     // Catch:{ Exception -> 0x0067 }
            if (r7 == 0) goto L_0x004b
            java.lang.String r3 = "complete: "
            goto L_0x004d
        L_0x004b:
            java.lang.String r3 = "FAILED: "
        L_0x004d:
            r2.append(r3)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = r6.getIdentifier()     // Catch:{ Exception -> 0x0067 }
            r2.append(r3)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0067 }
            r1.mo20863i(r2)     // Catch:{ Exception -> 0x0067 }
        L_0x005e:
            if (r7 == 0) goto L_0x0080
            com.google.firebase.crashlytics.internal.report.ReportManager r7 = r5.f19491e     // Catch:{ Exception -> 0x0067 }
            r7.deleteReport(r6)     // Catch:{ Exception -> 0x0067 }
            r0 = 1
            goto L_0x0080
        L_0x0067:
            r7 = move-exception
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error occurred sending report "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r1.mo20862e(r6, r7)
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.report.ReportUploader.uploadReport(com.google.firebase.crashlytics.internal.report.model.Report, boolean):boolean");
    }

    public synchronized void uploadReportsAsync(List<Report> list, boolean z, float f) {
        if (this.f19493g != null) {
            Logger.getLogger().mo20859d("Report upload has already been started.");
            return;
        }
        Thread thread = new Thread(new C3449a(list, z, f), "Crashlytics Report Uploader");
        this.f19493g = thread;
        thread.start();
    }
}
