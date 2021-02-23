package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzaq {
    public static boolean DEBUG = Log.isLoggable("Volley", 2);

    /* renamed from: a */
    private static String f12596a = "Volley";

    /* renamed from: b */
    private static final String f12597b = zzaq.class.getName();

    /* renamed from: com.google.android.gms.internal.ads.zzaq$a */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static class C2682a {

        /* renamed from: c */
        public static final boolean f12598c = zzaq.DEBUG;

        /* renamed from: a */
        private final List<C1792c4> f12599a = new ArrayList();

        /* renamed from: b */
        private boolean f12600b = false;

        C2682a() {
        }

        /* renamed from: a */
        public final synchronized void mo15615a(String str, long j) {
            if (!this.f12600b) {
                this.f12599a.add(new C1792c4(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        /* renamed from: b */
        public final synchronized void mo15616b(String str) {
            long j;
            this.f12600b = true;
            if (this.f12599a.size() == 0) {
                j = 0;
            } else {
                long j2 = this.f12599a.get(0).f7963c;
                List<C1792c4> list = this.f12599a;
                j = list.get(list.size() - 1).f7963c - j2;
            }
            if (j > 0) {
                long j3 = this.f12599a.get(0).f7963c;
                zzaq.m7524d("(%-4d ms) %s", Long.valueOf(j), str);
                for (C1792c4 next : this.f12599a) {
                    long j4 = next.f7963c;
                    zzaq.m7524d("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(next.f7962b), next.f7961a);
                    j3 = j4;
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void finalize() {
            if (!this.f12600b) {
                mo15616b("Request on the loose");
                zzaq.m7525e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    private static String m7523a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(f12597b)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(methodName);
                str2 = sb.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }

    /* renamed from: d */
    public static void m7524d(String str, Object... objArr) {
        Log.d(f12596a, m7523a(str, objArr));
    }

    /* renamed from: e */
    public static void m7525e(String str, Object... objArr) {
        Log.e(f12596a, m7523a(str, objArr));
    }

    /* renamed from: v */
    public static void m7526v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(f12596a, m7523a(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(f12596a, m7523a(str, objArr), th);
    }
}
