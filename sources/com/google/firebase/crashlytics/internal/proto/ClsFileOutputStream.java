package com.google.firebase.crashlytics.internal.proto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class ClsFileOutputStream extends FileOutputStream {
    public static final String IN_PROGRESS_SESSION_FILE_EXTENSION = ".cls_temp";
    public static final String SESSION_FILE_EXTENSION = ".cls";
    public static final FilenameFilter TEMP_FILENAME_FILTER = new C3445a();

    /* renamed from: a */
    private final String f19473a;

    /* renamed from: b */
    private File f19474b;

    /* renamed from: c */
    private File f19475c;

    /* renamed from: d */
    private boolean f19476d;

    /* renamed from: com.google.firebase.crashlytics.internal.proto.ClsFileOutputStream$a */
    class C3445a implements FilenameFilter {
        C3445a() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION);
        }
    }

    public ClsFileOutputStream(String str, String str2) {
        this(new File(str), str2);
    }

    public synchronized void close() {
        if (!this.f19476d) {
            this.f19476d = true;
            super.flush();
            super.close();
            File file = new File(this.f19473a + SESSION_FILE_EXTENSION);
            if (this.f19474b.renameTo(file)) {
                this.f19474b = null;
                this.f19475c = file;
                return;
            }
            String str = "";
            if (file.exists()) {
                str = " (target already exists)";
            } else if (!this.f19474b.exists()) {
                str = " (source does not exist)";
            }
            throw new IOException("Could not rename temp file: " + this.f19474b + " -> " + file + str);
        }
    }

    public void closeInProgressStream() {
        if (!this.f19476d) {
            this.f19476d = true;
            super.flush();
            super.close();
        }
    }

    public File getCompleteFile() {
        return this.f19475c;
    }

    public File getInProgressFile() {
        return this.f19474b;
    }

    public ClsFileOutputStream(File file, String str) {
        super(new File(file, str + IN_PROGRESS_SESSION_FILE_EXTENSION));
        this.f19476d = false;
        String str2 = file + File.separator + str;
        this.f19473a = str2;
        this.f19474b = new File(str2 + IN_PROGRESS_SESSION_FILE_EXTENSION);
    }
}
