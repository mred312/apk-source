package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

/* renamed from: com.google.firebase.crashlytics.internal.common.j */
/* compiled from: CrashlyticsFileMarker */
class C3324j {

    /* renamed from: a */
    private final String f19189a;

    /* renamed from: b */
    private final FileStore f19190b;

    public C3324j(String str, FileStore fileStore) {
        this.f19189a = str;
        this.f19190b = fileStore;
    }

    /* renamed from: b */
    private File m11439b() {
        return new File(this.f19190b.getFilesDir(), this.f19189a);
    }

    /* renamed from: a */
    public boolean mo21028a() {
        try {
            return m11439b().createNewFile();
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.mo20862e("Error creating marker: " + this.f19189a, e);
            return false;
        }
    }

    /* renamed from: c */
    public boolean mo21029c() {
        return m11439b().exists();
    }

    /* renamed from: d */
    public boolean mo21030d() {
        return m11439b().delete();
    }
}
