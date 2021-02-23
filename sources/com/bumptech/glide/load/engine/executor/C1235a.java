package com.bumptech.glide.load.engine.executor;

import android.os.Build;
import android.os.StrictMode;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* renamed from: com.bumptech.glide.load.engine.executor.a */
/* compiled from: RuntimeCompat */
final class C1235a {

    /* renamed from: com.bumptech.glide.load.engine.executor.a$a */
    /* compiled from: RuntimeCompat */
    class C1236a implements FilenameFilter {

        /* renamed from: a */
        final /* synthetic */ Pattern f5819a;

        C1236a(Pattern pattern) {
            this.f5819a = pattern;
        }

        public boolean accept(File file, String str) {
            return this.f5819a.matcher(str).matches();
        }
    }

    /* renamed from: a */
    static int m4328a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(m4329b(), availableProcessors) : availableProcessors;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    private static int m4329b() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            fileArr = new File("/sys/devices/system/cpu/").listFiles(new C1236a(Pattern.compile("cpu[0-9]+")));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        return Math.max(1, fileArr != null ? fileArr.length : 0);
    }
}
