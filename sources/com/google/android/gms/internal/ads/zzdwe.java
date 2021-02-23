package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzdwe {
    @NullableDecl

    /* renamed from: a */
    private static final Object f16030a;

    static {
        Object b = m8536b();
        f16030a = b;
        if (b != null) {
            m8535a("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        if (b != null) {
            m8537c();
        }
    }

    @NullableDecl
    /* renamed from: a */
    private static Method m8535a(String str, Class<?>... clsArr) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    /* renamed from: b */
    private static Object m8536b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    /* renamed from: c */
    private static Method m8537c() {
        try {
            Method a = m8535a("getStackTraceDepth", Throwable.class);
            if (a == null) {
                return null;
            }
            a.invoke(m8536b(), new Object[]{new Throwable()});
            return a;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static String zza(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zzeid.zza(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void zzi(Throwable th) {
        zzdvv.checkNotNull(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    @Deprecated
    public static RuntimeException zzj(Throwable th) {
        zzi(th);
        throw new RuntimeException(th);
    }
}
