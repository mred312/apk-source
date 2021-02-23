package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: androidx.core.app.a */
/* compiled from: ActivityRecreator */
final class C0430a {

    /* renamed from: a */
    protected static final Class<?> f2215a;

    /* renamed from: b */
    protected static final Field f2216b = m1439b();

    /* renamed from: c */
    protected static final Field f2217c = m1443f();

    /* renamed from: d */
    protected static final Method f2218d;

    /* renamed from: e */
    protected static final Method f2219e;

    /* renamed from: f */
    protected static final Method f2220f;

    /* renamed from: g */
    private static final Handler f2221g = new Handler(Looper.getMainLooper());

    /* renamed from: androidx.core.app.a$a */
    /* compiled from: ActivityRecreator */
    class C0431a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0434d f2222a;

        /* renamed from: b */
        final /* synthetic */ Object f2223b;

        C0431a(C0434d dVar, Object obj) {
            this.f2222a = dVar;
            this.f2223b = obj;
        }

        public void run() {
            this.f2222a.f2228a = this.f2223b;
        }
    }

    /* renamed from: androidx.core.app.a$b */
    /* compiled from: ActivityRecreator */
    class C0432b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Application f2224a;

        /* renamed from: b */
        final /* synthetic */ C0434d f2225b;

        C0432b(Application application, C0434d dVar) {
            this.f2224a = application;
            this.f2225b = dVar;
        }

        public void run() {
            this.f2224a.unregisterActivityLifecycleCallbacks(this.f2225b);
        }
    }

    /* renamed from: androidx.core.app.a$c */
    /* compiled from: ActivityRecreator */
    class C0433c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f2226a;

        /* renamed from: b */
        final /* synthetic */ Object f2227b;

        C0433c(Object obj, Object obj2) {
            this.f2226a = obj;
            this.f2227b = obj2;
        }

        public void run() {
            Boolean bool = Boolean.FALSE;
            try {
                Method method = C0430a.f2218d;
                if (method != null) {
                    method.invoke(this.f2226a, new Object[]{this.f2227b, bool, "AppCompat recreation"});
                    return;
                }
                C0430a.f2219e.invoke(this.f2226a, new Object[]{this.f2227b, bool});
            } catch (RuntimeException e) {
                if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                    throw e;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* renamed from: androidx.core.app.a$d */
    /* compiled from: ActivityRecreator */
    private static final class C0434d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a */
        Object f2228a;

        /* renamed from: b */
        private Activity f2229b;

        /* renamed from: c */
        private boolean f2230c = false;

        /* renamed from: d */
        private boolean f2231d = false;

        /* renamed from: e */
        private boolean f2232e = false;

        C0434d(@NonNull Activity activity) {
            this.f2229b = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f2229b == activity) {
                this.f2229b = null;
                this.f2231d = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f2231d && !this.f2232e && !this.f2230c && C0430a.m1445h(this.f2228a, activity)) {
                this.f2232e = true;
                this.f2228a = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f2229b == activity) {
                this.f2230c = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a = m1438a();
        f2215a = a;
        f2218d = m1441d(a);
        f2219e = m1440c(a);
        f2220f = m1442e(a);
    }

    /* renamed from: a */
    private static Class<?> m1438a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static Field m1439b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static Method m1440c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: d */
    private static Method m1441d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: e */
    private static Method m1442e(Class<?> cls) {
        if (m1444g() && cls != null) {
            try {
                Class cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: f */
    private static Field m1443f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: g */
    private static boolean m1444g() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    /* renamed from: h */
    protected static boolean m1445h(Object obj, Activity activity) {
        try {
            Object obj2 = f2217c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            f2221g.postAtFrontOfQueue(new C0433c(f2216b.get(activity), obj2));
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* renamed from: i */
    static boolean m1446i(@NonNull Activity activity) {
        Object obj;
        Application application;
        C0434d dVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (m1444g() && f2220f == null) {
            return false;
        } else {
            if (f2219e == null && f2218d == null) {
                return false;
            }
            try {
                Object obj2 = f2217c.get(activity);
                if (obj2 == null || (obj = f2216b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                dVar = new C0434d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f2221g;
                handler.post(new C0431a(dVar, obj2));
                if (m1444g()) {
                    Method method = f2220f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, new Object[]{obj2, null, null, 0, bool, null, null, bool, bool});
                } else {
                    activity.recreate();
                }
                handler.post(new C0432b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
