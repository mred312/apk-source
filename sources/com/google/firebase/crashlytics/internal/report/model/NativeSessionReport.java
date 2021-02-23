package com.google.firebase.crashlytics.internal.report.model;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.util.Map;

public class NativeSessionReport implements Report {

    /* renamed from: a */
    private final File f19498a;

    public NativeSessionReport(File file) {
        this.f19498a = file;
    }

    public Map<String, String> getCustomHeaders() {
        return null;
    }

    public File getFile() {
        return null;
    }

    public String getFileName() {
        return null;
    }

    public File[] getFiles() {
        return this.f19498a.listFiles();
    }

    public String getIdentifier() {
        return this.f19498a.getName();
    }

    public Report.Type getType() {
        return Report.Type.NATIVE;
    }

    public void remove() {
        for (File file : getFiles()) {
            Logger.getLogger().mo20859d("Removing native report file at " + file.getPath());
            file.delete();
        }
        Logger.getLogger().mo20859d("Removing native report directory at " + this.f19498a);
        this.f19498a.delete();
    }
}
