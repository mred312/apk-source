package com.google.firebase.crashlytics.internal;

import android.util.Log;

public class Logger {
    public static final String TAG = "FirebaseCrashlytics";

    /* renamed from: c */
    static final Logger f18958c = new Logger(TAG);

    /* renamed from: a */
    private final String f18959a;

    /* renamed from: b */
    private int f18960b = 4;

    public Logger(String str) {
        this.f18959a = str;
    }

    /* renamed from: a */
    private boolean m11205a(int i) {
        return this.f18960b <= i || Log.isLoggable(this.f18959a, i);
    }

    public static Logger getLogger() {
        return f18958c;
    }

    /* renamed from: d */
    public void mo20860d(String str, Throwable th) {
        if (m11205a(3)) {
            Log.d(this.f18959a, str, th);
        }
    }

    /* renamed from: e */
    public void mo20862e(String str, Throwable th) {
        if (m11205a(6)) {
            Log.e(this.f18959a, str, th);
        }
    }

    /* renamed from: i */
    public void mo20864i(String str, Throwable th) {
        if (m11205a(4)) {
            Log.i(this.f18959a, str, th);
        }
    }

    public void log(int i, String str) {
        log(i, str, false);
    }

    /* renamed from: v */
    public void mo20868v(String str, Throwable th) {
        if (m11205a(2)) {
            Log.v(this.f18959a, str, th);
        }
    }

    /* renamed from: w */
    public void mo20870w(String str, Throwable th) {
        if (m11205a(5)) {
            Log.w(this.f18959a, str, th);
        }
    }

    public void log(int i, String str, boolean z) {
        if (z || m11205a(i)) {
            Log.println(i, this.f18959a, str);
        }
    }

    /* renamed from: d */
    public void mo20859d(String str) {
        mo20860d(str, (Throwable) null);
    }

    /* renamed from: e */
    public void mo20861e(String str) {
        mo20862e(str, (Throwable) null);
    }

    /* renamed from: i */
    public void mo20863i(String str) {
        mo20864i(str, (Throwable) null);
    }

    /* renamed from: v */
    public void mo20867v(String str) {
        mo20868v(str, (Throwable) null);
    }

    /* renamed from: w */
    public void mo20869w(String str) {
        mo20870w(str, (Throwable) null);
    }
}
