package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class Logger {

    /* renamed from: a */
    private final String f7586a;

    /* renamed from: b */
    private final String f7587b;

    /* renamed from: c */
    private final int f7588c;

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Logger(java.lang.String r7, java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L_0x0006
            java.lang.String r8 = ""
            goto L_0x0036
        L_0x0006:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 91
            r0.append(r1)
            int r1 = r8.length
            r2 = 0
        L_0x0012:
            if (r2 >= r1) goto L_0x0028
            r3 = r8[r2]
            int r4 = r0.length()
            r5 = 1
            if (r4 <= r5) goto L_0x0022
            java.lang.String r4 = ","
            r0.append(r4)
        L_0x0022:
            r0.append(r3)
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0028:
            r8 = 93
            r0.append(r8)
            r8 = 32
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x0036:
            r6.<init>((java.lang.String) r7, (java.lang.String) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.logging.Logger.<init>(java.lang.String, java.lang.String[]):void");
    }

    @KeepForSdk
    /* renamed from: d */
    public void mo13033d(String str, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.f7586a, format(str, objArr));
        }
    }

    @KeepForSdk
    /* renamed from: e */
    public void mo13035e(String str, @Nullable Object... objArr) {
        Log.e(this.f7586a, format(str, objArr));
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public String format(String str, @Nullable Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f7587b.concat(str);
    }

    @KeepForSdk
    public String getTag() {
        return this.f7586a;
    }

    @KeepForSdk
    /* renamed from: i */
    public void mo13038i(String str, @Nullable Object... objArr) {
        Log.i(this.f7586a, format(str, objArr));
    }

    @KeepForSdk
    public boolean isLoggable(int i) {
        return this.f7588c <= i;
    }

    @KeepForSdk
    /* renamed from: v */
    public void mo13041v(String str, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.f7586a, format(str, objArr));
        }
    }

    @KeepForSdk
    /* renamed from: w */
    public void mo13042w(String str, @Nullable Object... objArr) {
        Log.w(this.f7586a, format(str, objArr));
    }

    @KeepForSdk
    public void wtf(String str, Throwable th, @Nullable Object... objArr) {
        Log.wtf(this.f7586a, format(str, objArr), th);
    }

    @KeepForSdk
    /* renamed from: e */
    public void mo13034e(String str, Throwable th, @Nullable Object... objArr) {
        Log.e(this.f7586a, format(str, objArr), th);
    }

    @KeepForSdk
    public void wtf(Throwable th) {
        Log.wtf(this.f7586a, th);
    }

    @KeepForSdk
    /* renamed from: d */
    public void mo13032d(String str, Throwable th, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.f7586a, format(str, objArr), th);
        }
    }

    @KeepForSdk
    /* renamed from: v */
    public void mo13040v(String str, Throwable th, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.f7586a, format(str, objArr), th);
        }
    }

    private Logger(String str, String str2) {
        this.f7587b = str2;
        this.f7586a = str;
        new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f7586a, i)) {
            i++;
        }
        this.f7588c = i;
    }
}
