package androidx.core.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.Writer;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class LogWriter extends Writer {

    /* renamed from: a */
    private final String f2567a;

    /* renamed from: b */
    private StringBuilder f2568b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f2567a = str;
    }

    /* renamed from: a */
    private void m1693a() {
        if (this.f2568b.length() > 0) {
            Log.d(this.f2567a, this.f2568b.toString());
            StringBuilder sb = this.f2568b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        m1693a();
    }

    public void flush() {
        m1693a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                m1693a();
            } else {
                this.f2568b.append(c);
            }
        }
    }
}
