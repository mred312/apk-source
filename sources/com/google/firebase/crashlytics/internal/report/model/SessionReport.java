package com.google.firebase.crashlytics.internal.report.model;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SessionReport implements Report {

    /* renamed from: a */
    private final File f19500a;

    /* renamed from: b */
    private final File[] f19501b;

    /* renamed from: c */
    private final Map<String, String> f19502c;

    public SessionReport(File file) {
        this(file, Collections.emptyMap());
    }

    public Map<String, String> getCustomHeaders() {
        return Collections.unmodifiableMap(this.f19502c);
    }

    public File getFile() {
        return this.f19500a;
    }

    public String getFileName() {
        return getFile().getName();
    }

    public File[] getFiles() {
        return this.f19501b;
    }

    public String getIdentifier() {
        String fileName = getFileName();
        return fileName.substring(0, fileName.lastIndexOf(46));
    }

    public Report.Type getType() {
        return Report.Type.JAVA;
    }

    public void remove() {
        Logger logger = Logger.getLogger();
        logger.mo20859d("Removing report at " + this.f19500a.getPath());
        this.f19500a.delete();
    }

    public SessionReport(File file, Map<String, String> map) {
        this.f19500a = file;
        this.f19501b = new File[]{file};
        this.f19502c = new HashMap(map);
    }
}
