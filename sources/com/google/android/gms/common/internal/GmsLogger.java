package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class GmsLogger {

    /* renamed from: a */
    private final String f7549a;
    @Nullable

    /* renamed from: b */
    private final String f7550b;

    public GmsLogger(String str, @Nullable String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f7549a = str;
        if (str2 == null || str2.length() <= 0) {
            this.f7550b = null;
        } else {
            this.f7550b = str2;
        }
    }

    /* renamed from: a */
    private final String m5281a(String str) {
        String str2 = this.f7550b;
        if (str2 == null) {
            return str;
        }
        return str2.concat(str);
    }

    /* renamed from: b */
    private final String m5282b(String str, Object... objArr) {
        String format = String.format(str, objArr);
        String str2 = this.f7550b;
        if (str2 == null) {
            return format;
        }
        return str2.concat(format);
    }

    @KeepForSdk
    public final boolean canLog(int i) {
        return Log.isLoggable(this.f7549a, i);
    }

    @KeepForSdk
    public final boolean canLogPii() {
        return false;
    }

    @KeepForSdk
    /* renamed from: d */
    public final void mo12965d(String str, String str2) {
        if (canLog(3)) {
            Log.d(str, m5281a(str2));
        }
    }

    @KeepForSdk
    /* renamed from: e */
    public final void mo12967e(String str, String str2) {
        if (canLog(6)) {
            Log.e(str, m5281a(str2));
        }
    }

    @KeepForSdk
    public final void efmt(String str, String str2, Object... objArr) {
        if (canLog(6)) {
            Log.e(str, m5282b(str2, objArr));
        }
    }

    @KeepForSdk
    /* renamed from: i */
    public final void mo12970i(String str, String str2) {
        if (canLog(4)) {
            Log.i(str, m5281a(str2));
        }
    }

    @KeepForSdk
    public final void pii(String str, String str2) {
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            Log.i(" PII_LOG".length() != 0 ? valueOf.concat(" PII_LOG") : new String(valueOf), m5281a(str2));
        }
    }

    @KeepForSdk
    /* renamed from: v */
    public final void mo12974v(String str, String str2) {
        if (canLog(2)) {
            Log.v(str, m5281a(str2));
        }
    }

    @KeepForSdk
    /* renamed from: w */
    public final void mo12976w(String str, String str2) {
        if (canLog(5)) {
            Log.w(str, m5281a(str2));
        }
    }

    @KeepForSdk
    public final void wfmt(String str, String str2, Object... objArr) {
        if (canLog(5)) {
            Log.w(this.f7549a, m5282b(str2, objArr));
        }
    }

    @KeepForSdk
    public final void wtf(String str, String str2, Throwable th) {
        if (canLog(7)) {
            Log.e(str, m5281a(str2), th);
            Log.wtf(str, m5281a(str2), th);
        }
    }

    @KeepForSdk
    /* renamed from: d */
    public final void mo12966d(String str, String str2, Throwable th) {
        if (canLog(3)) {
            Log.d(str, m5281a(str2), th);
        }
    }

    @KeepForSdk
    /* renamed from: e */
    public final void mo12968e(String str, String str2, Throwable th) {
        if (canLog(6)) {
            Log.e(str, m5281a(str2), th);
        }
    }

    @KeepForSdk
    /* renamed from: i */
    public final void mo12971i(String str, String str2, Throwable th) {
        if (canLog(4)) {
            Log.i(str, m5281a(str2), th);
        }
    }

    @KeepForSdk
    public final void pii(String str, String str2, Throwable th) {
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            Log.i(" PII_LOG".length() != 0 ? valueOf.concat(" PII_LOG") : new String(valueOf), m5281a(str2), th);
        }
    }

    @KeepForSdk
    /* renamed from: v */
    public final void mo12975v(String str, String str2, Throwable th) {
        if (canLog(2)) {
            Log.v(str, m5281a(str2), th);
        }
    }

    @KeepForSdk
    /* renamed from: w */
    public final void mo12977w(String str, String str2, Throwable th) {
        if (canLog(5)) {
            Log.w(str, m5281a(str2), th);
        }
    }

    public GmsLogger(String str) {
        this(str, (String) null);
    }
}
