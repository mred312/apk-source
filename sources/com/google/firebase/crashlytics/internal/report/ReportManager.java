package com.google.firebase.crashlytics.internal.report;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.model.NativeSessionReport;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.model.SessionReport;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ReportManager {

    /* renamed from: a */
    private final ReportUploader.ReportFilesProvider f19485a;

    public ReportManager(ReportUploader.ReportFilesProvider reportFilesProvider) {
        this.f19485a = reportFilesProvider;
    }

    public boolean areReportsAvailable() {
        File[] completeSessionFiles = this.f19485a.getCompleteSessionFiles();
        File[] nativeReportFiles = this.f19485a.getNativeReportFiles();
        if (completeSessionFiles != null && completeSessionFiles.length > 0) {
            return true;
        }
        if (nativeReportFiles == null || nativeReportFiles.length <= 0) {
            return false;
        }
        return true;
    }

    public void deleteReport(Report report) {
        report.remove();
    }

    public void deleteReports(List<Report> list) {
        for (Report deleteReport : list) {
            deleteReport(deleteReport);
        }
    }

    public List<Report> findReports() {
        Logger.getLogger().mo20859d("Checking for crash reports...");
        File[] completeSessionFiles = this.f19485a.getCompleteSessionFiles();
        File[] nativeReportFiles = this.f19485a.getNativeReportFiles();
        LinkedList linkedList = new LinkedList();
        if (completeSessionFiles != null) {
            for (File file : completeSessionFiles) {
                Logger.getLogger().mo20859d("Found crash report " + file.getPath());
                linkedList.add(new SessionReport(file));
            }
        }
        if (nativeReportFiles != null) {
            for (File nativeSessionReport : nativeReportFiles) {
                linkedList.add(new NativeSessionReport(nativeSessionReport));
            }
        }
        if (linkedList.isEmpty()) {
            Logger.getLogger().mo20859d("No reports found.");
        }
        return linkedList;
    }
}
