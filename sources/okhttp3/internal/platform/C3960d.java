package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: okhttp3.internal.platform.d */
/* compiled from: OptionalMethod */
class C3960d<T> {

    /* renamed from: a */
    private final Class<?> f21308a;

    /* renamed from: b */
    private final String f21309b;

    /* renamed from: c */
    private final Class[] f21310c;

    C3960d(Class<?> cls, String str, Class... clsArr) {
        this.f21308a = cls;
        this.f21309b = str;
        this.f21310c = clsArr;
    }

    /* renamed from: a */
    private Method m14389a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f21309b;
        if (str == null) {
            return null;
        }
        Method b = m14390b(cls, str, this.f21310c);
        if (b == null || (cls2 = this.f21308a) == null || cls2.isAssignableFrom(b.getReturnType())) {
            return b;
        }
        return null;
    }

    /* renamed from: b */
    private static Method m14390b(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    /* renamed from: c */
    public Object mo25132c(T t, Object... objArr) {
        Method a = m14389a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f21309b + " not supported for object " + t);
        }
    }

    /* renamed from: d */
    public Object mo25133d(T t, Object... objArr) {
        Method a = m14389a(t.getClass());
        if (a == null) {
            return null;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: e */
    public Object mo25134e(T t, Object... objArr) {
        try {
            return mo25133d(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: f */
    public Object mo25135f(T t, Object... objArr) {
        try {
            return mo25132c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: g */
    public boolean mo25136g(T t) {
        return m14389a(t.getClass()) != null;
    }
}
