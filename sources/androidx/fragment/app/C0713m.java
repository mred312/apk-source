package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* renamed from: androidx.fragment.app.m */
/* compiled from: LogWriter */
final class C0713m extends Writer {

    /* renamed from: a */
    private final String f3397a;

    /* renamed from: b */
    private StringBuilder f3398b = new StringBuilder(128);

    C0713m(String str) {
        this.f3397a = str;
    }

    /* renamed from: a */
    private void m2506a() {
        if (this.f3398b.length() > 0) {
            Log.d(this.f3397a, this.f3398b.toString());
            StringBuilder sb = this.f3398b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        m2506a();
    }

    public void flush() {
        m2506a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                m2506a();
            } else {
                this.f3398b.append(c);
            }
        }
    }
}
