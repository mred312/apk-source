package androidx.core.p003os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

@Deprecated
/* renamed from: androidx.core.os.TraceCompat */
public final class TraceCompat {

    /* renamed from: a */
    private static long f2431a;

    /* renamed from: b */
    private static Method f2432b;

    /* renamed from: c */
    private static Method f2433c;

    /* renamed from: d */
    private static Method f2434d;

    /* renamed from: e */
    private static Method f2435e;

    static {
        Class<String> cls = String.class;
        int i = Build.VERSION.SDK_INT;
        if (i >= 18 && i < 29) {
            try {
                f2431a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                Class cls2 = Long.TYPE;
                f2432b = Trace.class.getMethod("isTagEnabled", new Class[]{cls2});
                Class cls3 = Integer.TYPE;
                f2433c = Trace.class.getMethod("asyncTraceBegin", new Class[]{cls2, cls, cls3});
                f2434d = Trace.class.getMethod("asyncTraceEnd", new Class[]{cls2, cls, cls3});
                f2435e = Trace.class.getMethod("traceCounter", new Class[]{cls2, cls, cls3});
            } catch (Exception e) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e);
            }
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String str, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            Trace.beginAsyncSection(str, i);
        } else if (i2 >= 18) {
            try {
                f2433c.invoke((Object) null, new Object[]{Long.valueOf(f2431a), str, Integer.valueOf(i)});
            } catch (Exception unused) {
                Log.v("TraceCompat", "Unable to invoke asyncTraceBegin() via reflection.");
            }
        }
    }

    public static void beginSection(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endAsyncSection(@NonNull String str, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            Trace.endAsyncSection(str, i);
        } else if (i2 >= 18) {
            try {
                f2434d.invoke((Object) null, new Object[]{Long.valueOf(f2431a), str, Integer.valueOf(i)});
            } catch (Exception unused) {
                Log.v("TraceCompat", "Unable to invoke endAsyncSection() via reflection.");
            }
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static boolean isEnabled() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return Trace.isEnabled();
        }
        if (i >= 18) {
            try {
                return ((Boolean) f2432b.invoke((Object) null, new Object[]{Long.valueOf(f2431a)})).booleanValue();
            } catch (Exception unused) {
                Log.v("TraceCompat", "Unable to invoke isTagEnabled() via reflection.");
            }
        }
        return false;
    }

    public static void setCounter(@NonNull String str, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            Trace.setCounter(str, (long) i);
        } else if (i2 >= 18) {
            try {
                f2435e.invoke((Object) null, new Object[]{Long.valueOf(f2431a), str, Integer.valueOf(i)});
            } catch (Exception unused) {
                Log.v("TraceCompat", "Unable to invoke traceCounter() via reflection.");
            }
        }
    }
}
