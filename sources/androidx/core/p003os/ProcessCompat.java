package androidx.core.p003os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* renamed from: androidx.core.os.ProcessCompat */
public final class ProcessCompat {

    @RequiresApi(16)
    /* renamed from: androidx.core.os.ProcessCompat$a */
    static class C0485a {

        /* renamed from: a */
        private static final Object f2425a = new Object();

        /* renamed from: b */
        private static Method f2426b;

        /* renamed from: c */
        private static boolean f2427c;

        @SuppressLint({"PrivateApi"})
        /* renamed from: a */
        static boolean m1610a(int i) {
            try {
                synchronized (f2425a) {
                    if (!f2427c) {
                        f2427c = true;
                        f2426b = Class.forName("android.os.UserId").getDeclaredMethod("isApp", new Class[]{Integer.TYPE});
                    }
                }
                Method method = f2426b;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke((Object) null, new Object[]{Integer.valueOf(i)});
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @RequiresApi(17)
    /* renamed from: androidx.core.os.ProcessCompat$b */
    static class C0486b {

        /* renamed from: a */
        private static final Object f2428a = new Object();

        /* renamed from: b */
        private static Method f2429b;

        /* renamed from: c */
        private static boolean f2430c;

        @SuppressLint({"DiscouragedPrivateApi"})
        /* renamed from: a */
        static boolean m1611a(int i) {
            try {
                synchronized (f2428a) {
                    if (!f2430c) {
                        f2430c = true;
                        f2429b = UserHandle.class.getDeclaredMethod("isApp", new Class[]{Integer.TYPE});
                    }
                }
                Method method = f2429b;
                if (method != null) {
                    if (((Boolean) method.invoke((Object) null, new Object[]{Integer.valueOf(i)})) == null) {
                        throw new NullPointerException();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @RequiresApi(24)
    /* renamed from: androidx.core.os.ProcessCompat$c */
    static class C0487c {
        /* renamed from: a */
        static boolean m1612a(int i) {
            return Process.isApplicationUid(i);
        }
    }

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return C0487c.m1612a(i);
        }
        if (i2 >= 17) {
            return C0486b.m1611a(i);
        }
        if (i2 == 16) {
            return C0485a.m1610a(i);
        }
        return true;
    }
}
