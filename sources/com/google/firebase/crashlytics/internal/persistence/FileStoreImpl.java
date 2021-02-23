package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;

public class FileStoreImpl implements FileStore {
    public static final String FILES_PATH = ".com.google.firebase.crashlytics";

    /* renamed from: a */
    private final Context f19466a;

    public FileStoreImpl(Context context) {
        this.f19466a = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo21417a(File file) {
        if (file == null) {
            Logger.getLogger().mo20859d("Null File");
            return null;
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            Logger.getLogger().mo20869w("Couldn't create file");
            return null;
        }
    }

    public File getFilesDir() {
        return mo21417a(new File(this.f19466a.getFilesDir(), FILES_PATH));
    }

    public String getFilesDirPath() {
        return new File(this.f19466a.getFilesDir(), FILES_PATH).getPath();
    }
}
