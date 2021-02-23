package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.crashlytics.internal.common.s */
/* compiled from: SessionReportingCoordinator */
class C3335s {

    /* renamed from: a */
    private final CrashlyticsReportDataCapture f19204a;

    /* renamed from: b */
    private final CrashlyticsReportPersistence f19205b;

    /* renamed from: c */
    private final DataTransportCrashlyticsReportSender f19206c;

    /* renamed from: d */
    private final LogFileManager f19207d;

    /* renamed from: e */
    private final UserMetadata f19208e;

    C3335s(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager, UserMetadata userMetadata) {
        this.f19204a = crashlyticsReportDataCapture;
        this.f19205b = crashlyticsReportPersistence;
        this.f19206c = dataTransportCrashlyticsReportSender;
        this.f19207d = logFileManager;
        this.f19208e = userMetadata;
    }

    /* renamed from: b */
    public static C3335s m11468b(Context context, IdManager idManager, FileStore fileStore, C3276a aVar, LogFileManager logFileManager, UserMetadata userMetadata, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsDataProvider settingsDataProvider) {
        return new C3335s(new CrashlyticsReportDataCapture(context, idManager, aVar, stackTraceTrimmingStrategy), new CrashlyticsReportPersistence(new File(fileStore.getFilesDirPath()), settingsDataProvider), DataTransportCrashlyticsReportSender.create(context), logFileManager, userMetadata);
    }

    @NonNull
    /* renamed from: e */
    private static List<CrashlyticsReport.CustomAttribute> m11469e(@NonNull Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(CrashlyticsReport.CustomAttribute.builder().setKey((String) next.getKey()).setValue((String) next.getValue()).build());
        }
        Collections.sort(arrayList, C3334r.m11466a());
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean m11471h(@NonNull Task<CrashlyticsReportWithSessionId> task) {
        if (task.isSuccessful()) {
            CrashlyticsReportWithSessionId result = task.getResult();
            Logger logger = Logger.getLogger();
            logger.mo20859d("Crashlytics report successfully enqueued to DataTransport: " + result.getSessionId());
            this.f19205b.deleteFinalizedReport(result.getSessionId());
            return true;
        }
        Logger.getLogger().mo20860d("Crashlytics report could not be enqueued to DataTransport", task.getException());
        return false;
    }

    /* renamed from: i */
    private void m11472i(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j, boolean z) {
        boolean equals = str2.equals("crash");
        CrashlyticsReport.Session.Event captureEventData = this.f19204a.captureEventData(th, thread, str2, j, 4, 8, z);
        CrashlyticsReport.Session.Event.Builder builder = captureEventData.toBuilder();
        String logString = this.f19207d.getLogString();
        if (logString != null) {
            builder.setLog(CrashlyticsReport.Session.Event.Log.builder().setContent(logString).build());
        } else {
            Logger.getLogger().mo20859d("No log data to include with this event.");
        }
        List<CrashlyticsReport.CustomAttribute> e = m11469e(this.f19208e.getCustomKeys());
        if (!e.isEmpty()) {
            builder.setApp(captureEventData.getApp().toBuilder().setCustomAttributes(ImmutableList.from(e)).build());
        }
        String str3 = str;
        this.f19205b.persistEvent(builder.build(), str, equals);
    }

    /* renamed from: c */
    public void mo21040c(@NonNull String str, @NonNull List<C3331o> list) {
        ArrayList arrayList = new ArrayList();
        for (C3331o c : list) {
            CrashlyticsReport.FilesPayload.File c2 = c.mo20952c();
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        this.f19205b.finalizeSessionWithNativeEvent(str, CrashlyticsReport.FilesPayload.builder().setFiles(ImmutableList.from(arrayList)).build());
    }

    /* renamed from: d */
    public void mo21041d(long j, @Nullable String str) {
        this.f19205b.finalizeReports(str, j);
    }

    /* renamed from: g */
    public void mo21042g(@NonNull String str, long j) {
        this.f19205b.persistReport(this.f19204a.captureReportData(str, j));
    }

    /* renamed from: j */
    public void mo21043j(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j) {
        Logger logger = Logger.getLogger();
        logger.mo20859d("Persisting fatal event for session " + str);
        m11472i(th, thread, str, "crash", j, true);
    }

    /* renamed from: k */
    public void mo21044k(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j) {
        Logger logger = Logger.getLogger();
        logger.mo20859d("Persisting non-fatal event for session " + str);
        m11472i(th, thread, str, "error", j, false);
    }

    /* renamed from: l */
    public void mo21045l(@NonNull String str) {
        String userId = this.f19208e.getUserId();
        if (userId == null) {
            Logger.getLogger().mo20859d("Could not persist user ID; no user ID available");
        } else {
            this.f19205b.persistUserIdForSession(userId, str);
        }
    }

    /* renamed from: m */
    public void mo21046m() {
        this.f19205b.deleteAllReports();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public Task<Void> mo21047n(@NonNull Executor executor, @NonNull DataTransportState dataTransportState) {
        if (dataTransportState == DataTransportState.NONE) {
            Logger.getLogger().mo20859d("Send via DataTransport disabled. Removing DataTransport reports.");
            this.f19205b.deleteAllReports();
            return Tasks.forResult(null);
        }
        List<CrashlyticsReportWithSessionId> loadFinalizedReports = this.f19205b.loadFinalizedReports();
        ArrayList arrayList = new ArrayList();
        for (CrashlyticsReportWithSessionId next : loadFinalizedReports) {
            if (next.getReport().getType() != CrashlyticsReport.Type.NATIVE || dataTransportState == DataTransportState.ALL) {
                arrayList.add(this.f19206c.sendReport(next).continueWith(executor, C3333q.m11465a(this)));
            } else {
                Logger.getLogger().mo20859d("Send native reports via DataTransport disabled. Removing DataTransport reports.");
                this.f19205b.deleteFinalizedReport(next.getSessionId());
            }
        }
        return Tasks.whenAll((Collection<? extends Task<?>>) arrayList);
    }
}
