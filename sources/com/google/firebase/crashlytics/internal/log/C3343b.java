package com.google.firebase.crashlytics.internal.log;

import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.log.QueueFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* renamed from: com.google.firebase.crashlytics.internal.log.b */
/* compiled from: QueueFileLogStore */
class C3343b implements C3342a {

    /* renamed from: d */
    private static final Charset f19229d = Charset.forName(Key.STRING_CHARSET_NAME);

    /* renamed from: a */
    private final File f19230a;

    /* renamed from: b */
    private final int f19231b;

    /* renamed from: c */
    private QueueFile f19232c;

    /* renamed from: com.google.firebase.crashlytics.internal.log.b$a */
    /* compiled from: QueueFileLogStore */
    class C3344a implements QueueFile.ElementReader {

        /* renamed from: a */
        final /* synthetic */ byte[] f19233a;

        /* renamed from: b */
        final /* synthetic */ int[] f19234b;

        C3344a(C3343b bVar, byte[] bArr, int[] iArr) {
            this.f19233a = bArr;
            this.f19234b = iArr;
        }

        public void read(InputStream inputStream, int i) {
            try {
                inputStream.read(this.f19233a, this.f19234b[0], i);
                int[] iArr = this.f19234b;
                iArr[0] = iArr[0] + i;
            } finally {
                inputStream.close();
            }
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.log.b$b */
    /* compiled from: QueueFileLogStore */
    private class C3345b {

        /* renamed from: a */
        public final byte[] f19235a;

        /* renamed from: b */
        public final int f19236b;

        C3345b(C3343b bVar, byte[] bArr, int i) {
            this.f19235a = bArr;
            this.f19236b = i;
        }
    }

    C3343b(File file, int i) {
        this.f19230a = file;
        this.f19231b = i;
    }

    /* renamed from: f */
    private void m11521f(long j, String str) {
        if (this.f19232c != null) {
            if (str == null) {
                str = "null";
            }
            try {
                int i = this.f19231b / 4;
                if (str.length() > i) {
                    str = "..." + str.substring(str.length() - i);
                }
                this.f19232c.mo21061e(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")}).getBytes(f19229d));
                while (!this.f19232c.mo21065k() && this.f19232c.mo21068v() > this.f19231b) {
                    this.f19232c.mo21066r();
                }
            } catch (IOException e) {
                Logger.getLogger().mo20862e("There was a problem writing to the Crashlytics log.", e);
            }
        }
    }

    /* renamed from: g */
    private C3345b m11522g() {
        if (!this.f19230a.exists()) {
            return null;
        }
        m11523h();
        QueueFile queueFile = this.f19232c;
        if (queueFile == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[queueFile.mo21068v()];
        try {
            this.f19232c.mo21064i(new C3344a(this, bArr, iArr));
        } catch (IOException e) {
            Logger.getLogger().mo20862e("A problem occurred while reading the Crashlytics log file.", e);
        }
        return new C3345b(this, bArr, iArr[0]);
    }

    /* renamed from: h */
    private void m11523h() {
        if (this.f19232c == null) {
            try {
                this.f19232c = new QueueFile(this.f19230a);
            } catch (IOException e) {
                Logger logger = Logger.getLogger();
                logger.mo20862e("Could not open log file: " + this.f19230a, e);
            }
        }
    }

    /* renamed from: a */
    public void mo21055a() {
        CommonUtils.closeOrLog(this.f19232c, "There was a problem closing the Crashlytics log file.");
        this.f19232c = null;
    }

    /* renamed from: b */
    public String mo21056b() {
        byte[] c = mo21057c();
        if (c != null) {
            return new String(c, f19229d);
        }
        return null;
    }

    /* renamed from: c */
    public byte[] mo21057c() {
        C3345b g = m11522g();
        if (g == null) {
            return null;
        }
        int i = g.f19236b;
        byte[] bArr = new byte[i];
        System.arraycopy(g.f19235a, 0, bArr, 0, i);
        return bArr;
    }

    /* renamed from: d */
    public void mo21058d() {
        mo21055a();
        this.f19230a.delete();
    }

    /* renamed from: e */
    public void mo21059e(long j, String str) {
        m11523h();
        m11521f(j, str);
    }
}
