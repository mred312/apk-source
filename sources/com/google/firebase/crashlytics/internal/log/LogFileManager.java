package com.google.firebase.crashlytics.internal.log;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.util.Set;

public class LogFileManager {

    /* renamed from: d */
    private static final C3338b f19210d = new C3338b();

    /* renamed from: a */
    private final Context f19211a;

    /* renamed from: b */
    private final DirectoryProvider f19212b;

    /* renamed from: c */
    private C3342a f19213c;

    public interface DirectoryProvider {
        File getLogFileDir();
    }

    /* renamed from: com.google.firebase.crashlytics.internal.log.LogFileManager$b */
    private static final class C3338b implements C3342a {
        private C3338b() {
        }

        /* renamed from: a */
        public void mo21055a() {
        }

        /* renamed from: b */
        public String mo21056b() {
            return null;
        }

        /* renamed from: c */
        public byte[] mo21057c() {
            return null;
        }

        /* renamed from: d */
        public void mo21058d() {
        }

        /* renamed from: e */
        public void mo21059e(long j, String str) {
        }
    }

    public LogFileManager(Context context, DirectoryProvider directoryProvider) {
        this(context, directoryProvider, (String) null);
    }

    /* renamed from: a */
    private String m11482a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        if (lastIndexOf == -1) {
            return name;
        }
        return name.substring(20, lastIndexOf);
    }

    /* renamed from: b */
    private File m11483b(String str) {
        return new File(this.f19212b.getLogFileDir(), "crashlytics-userlog-" + str + ".temp");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo21048c(File file, int i) {
        this.f19213c = new C3343b(file, i);
    }

    public void clearLog() {
        this.f19213c.mo21058d();
    }

    public void discardOldLogFiles(Set<String> set) {
        File[] listFiles = this.f19212b.getLogFileDir().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(m11482a(file))) {
                    file.delete();
                }
            }
        }
    }

    public byte[] getBytesForLog() {
        return this.f19213c.mo21057c();
    }

    @Nullable
    public String getLogString() {
        return this.f19213c.mo21056b();
    }

    public final void setCurrentSession(String str) {
        this.f19213c.mo21055a();
        this.f19213c = f19210d;
        if (str != null) {
            if (!CommonUtils.getBooleanResourceValue(this.f19211a, "com.crashlytics.CollectCustomLogs", true)) {
                Logger.getLogger().mo20859d("Preferences requested no custom logs. Aborting log file creation.");
            } else {
                mo21048c(m11483b(str), 65536);
            }
        }
    }

    public void writeToLog(long j, String str) {
        this.f19213c.mo21059e(j, str);
    }

    public LogFileManager(Context context, DirectoryProvider directoryProvider, String str) {
        this.f19211a = context;
        this.f19212b = directoryProvider;
        this.f19213c = f19210d;
        setCurrentSession(str);
    }
}
