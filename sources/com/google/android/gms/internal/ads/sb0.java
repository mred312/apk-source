package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class sb0 {

    /* renamed from: a */
    private static final Logger f11061a = Logger.getLogger(sb0.class.getName());

    /* renamed from: b */
    private static final Unsafe f11062b;

    /* renamed from: c */
    private static final Class<?> f11063c = i80.m6314b();

    /* renamed from: d */
    private static final boolean f11064d;

    /* renamed from: e */
    private static final boolean f11065e;

    /* renamed from: f */
    private static final C2396d f11066f;

    /* renamed from: g */
    private static final boolean f11067g = m6922q();

    /* renamed from: h */
    private static final boolean f11068h = m6921p();

    /* renamed from: i */
    private static final long f11069i = ((long) m6930y(byte[].class));

    /* renamed from: j */
    static final boolean f11070j = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    /* renamed from: com.google.android.gms.internal.ads.sb0$a */
    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    static final class C2393a extends C2396d {
        C2393a(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final void mo14782a(Object obj, long j, double d) {
            mo14790c(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: b */
        public final void mo14783b(Object obj, long j, float f) {
            mo14791e(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: d */
        public final void mo14784d(Object obj, long j, boolean z) {
            if (sb0.f11070j) {
                sb0.m6917l(obj, j, z);
            } else {
                sb0.m6925t(obj, j, z);
            }
        }

        /* renamed from: f */
        public final void mo14785f(Object obj, long j, byte b) {
            if (sb0.f11070j) {
                sb0.m6907b(obj, j, b);
            } else {
                sb0.m6915j(obj, j, b);
            }
        }

        /* renamed from: i */
        public final boolean mo14786i(Object obj, long j) {
            if (sb0.f11070j) {
                return sb0.m6900J(obj, j);
            }
            return sb0.m6901K(obj, j);
        }

        /* renamed from: j */
        public final float mo14787j(Object obj, long j) {
            return Float.intBitsToFloat(mo14792g(obj, j));
        }

        /* renamed from: k */
        public final double mo14788k(Object obj, long j) {
            return Double.longBitsToDouble(mo14793h(obj, j));
        }

        /* renamed from: l */
        public final byte mo14789l(Object obj, long j) {
            if (sb0.f11070j) {
                return sb0.m6898H(obj, j);
            }
            return sb0.m6899I(obj, j);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.sb0$b */
    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    static final class C2394b extends C2396d {
        C2394b(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final void mo14782a(Object obj, long j, double d) {
            this.f11071a.putDouble(obj, j, d);
        }

        /* renamed from: b */
        public final void mo14783b(Object obj, long j, float f) {
            this.f11071a.putFloat(obj, j, f);
        }

        /* renamed from: d */
        public final void mo14784d(Object obj, long j, boolean z) {
            this.f11071a.putBoolean(obj, j, z);
        }

        /* renamed from: f */
        public final void mo14785f(Object obj, long j, byte b) {
            this.f11071a.putByte(obj, j, b);
        }

        /* renamed from: i */
        public final boolean mo14786i(Object obj, long j) {
            return this.f11071a.getBoolean(obj, j);
        }

        /* renamed from: j */
        public final float mo14787j(Object obj, long j) {
            return this.f11071a.getFloat(obj, j);
        }

        /* renamed from: k */
        public final double mo14788k(Object obj, long j) {
            return this.f11071a.getDouble(obj, j);
        }

        /* renamed from: l */
        public final byte mo14789l(Object obj, long j) {
            return this.f11071a.getByte(obj, j);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.sb0$c */
    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    static final class C2395c extends C2396d {
        C2395c(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final void mo14782a(Object obj, long j, double d) {
            mo14790c(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: b */
        public final void mo14783b(Object obj, long j, float f) {
            mo14791e(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: d */
        public final void mo14784d(Object obj, long j, boolean z) {
            if (sb0.f11070j) {
                sb0.m6917l(obj, j, z);
            } else {
                sb0.m6925t(obj, j, z);
            }
        }

        /* renamed from: f */
        public final void mo14785f(Object obj, long j, byte b) {
            if (sb0.f11070j) {
                sb0.m6907b(obj, j, b);
            } else {
                sb0.m6915j(obj, j, b);
            }
        }

        /* renamed from: i */
        public final boolean mo14786i(Object obj, long j) {
            if (sb0.f11070j) {
                return sb0.m6900J(obj, j);
            }
            return sb0.m6901K(obj, j);
        }

        /* renamed from: j */
        public final float mo14787j(Object obj, long j) {
            return Float.intBitsToFloat(mo14792g(obj, j));
        }

        /* renamed from: k */
        public final double mo14788k(Object obj, long j) {
            return Double.longBitsToDouble(mo14793h(obj, j));
        }

        /* renamed from: l */
        public final byte mo14789l(Object obj, long j) {
            if (sb0.f11070j) {
                return sb0.m6898H(obj, j);
            }
            return sb0.m6899I(obj, j);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.sb0$d */
    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    static abstract class C2396d {

        /* renamed from: a */
        Unsafe f11071a;

        C2396d(Unsafe unsafe) {
            this.f11071a = unsafe;
        }

        /* renamed from: a */
        public abstract void mo14782a(Object obj, long j, double d);

        /* renamed from: b */
        public abstract void mo14783b(Object obj, long j, float f);

        /* renamed from: c */
        public final void mo14790c(Object obj, long j, long j2) {
            this.f11071a.putLong(obj, j, j2);
        }

        /* renamed from: d */
        public abstract void mo14784d(Object obj, long j, boolean z);

        /* renamed from: e */
        public final void mo14791e(Object obj, long j, int i) {
            this.f11071a.putInt(obj, j, i);
        }

        /* renamed from: f */
        public abstract void mo14785f(Object obj, long j, byte b);

        /* renamed from: g */
        public final int mo14792g(Object obj, long j) {
            return this.f11071a.getInt(obj, j);
        }

        /* renamed from: h */
        public final long mo14793h(Object obj, long j) {
            return this.f11071a.getLong(obj, j);
        }

        /* renamed from: i */
        public abstract boolean mo14786i(Object obj, long j);

        /* renamed from: j */
        public abstract float mo14787j(Object obj, long j);

        /* renamed from: k */
        public abstract double mo14788k(Object obj, long j);

        /* renamed from: l */
        public abstract byte mo14789l(Object obj, long j);
    }

    static {
        Class<Object[]> cls = Object[].class;
        Class<double[]> cls2 = double[].class;
        Class<float[]> cls3 = float[].class;
        Class<long[]> cls4 = long[].class;
        Class<int[]> cls5 = int[].class;
        Class<boolean[]> cls6 = boolean[].class;
        Unsafe o = m6920o();
        f11062b = o;
        boolean C = m6893C(Long.TYPE);
        f11064d = C;
        boolean C2 = m6893C(Integer.TYPE);
        f11065e = C2;
        C2396d dVar = null;
        if (o != null) {
            if (!i80.m6313a()) {
                dVar = new C2394b(o);
            } else if (C) {
                dVar = new C2395c(o);
            } else if (C2) {
                dVar = new C2393a(o);
            }
        }
        f11066f = dVar;
        m6930y(cls6);
        m6891A(cls6);
        m6930y(cls5);
        m6891A(cls5);
        m6930y(cls4);
        m6891A(cls4);
        m6930y(cls3);
        m6891A(cls3);
        m6930y(cls2);
        m6891A(cls2);
        m6930y(cls);
        m6891A(cls);
        Field r = m6923r();
        if (!(r == null || dVar == null)) {
            dVar.f11071a.objectFieldOffset(r);
        }
    }

    private sb0() {
    }

    /* renamed from: A */
    private static int m6891A(Class<?> cls) {
        if (f11068h) {
            return f11066f.f11071a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* renamed from: B */
    static long m6892B(Object obj, long j) {
        return f11066f.mo14793h(obj, j);
    }

    /* renamed from: C */
    private static boolean m6893C(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!i80.m6313a()) {
            return false;
        }
        try {
            Class<?> cls3 = f11063c;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: D */
    static boolean m6894D(Object obj, long j) {
        return f11066f.mo14786i(obj, j);
    }

    /* renamed from: E */
    static float m6895E(Object obj, long j) {
        return f11066f.mo14787j(obj, j);
    }

    /* renamed from: F */
    static double m6896F(Object obj, long j) {
        return f11066f.mo14788k(obj, j);
    }

    /* renamed from: G */
    static Object m6897G(Object obj, long j) {
        return f11066f.f11071a.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public static byte m6898H(Object obj, long j) {
        return (byte) (m6931z(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public static byte m6899I(Object obj, long j) {
        return (byte) (m6931z(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public static boolean m6900J(Object obj, long j) {
        return m6898H(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public static boolean m6901K(Object obj, long j) {
        return m6899I(obj, j) != 0;
    }

    /* renamed from: a */
    static byte m6906a(byte[] bArr, long j) {
        return f11066f.mo14789l(bArr, f11069i + j);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m6907b(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        m6916k(obj, j2, ((255 & b) << i) | (m6931z(obj, j2) & ((255 << i) ^ -1)));
    }

    /* renamed from: c */
    static void m6908c(Object obj, long j, double d) {
        f11066f.mo14782a(obj, j, d);
    }

    /* renamed from: d */
    static void m6909d(Object obj, long j, float f) {
        f11066f.mo14783b(obj, j, f);
    }

    /* renamed from: e */
    static void m6910e(Object obj, long j, long j2) {
        f11066f.mo14790c(obj, j, j2);
    }

    /* renamed from: f */
    static void m6911f(Object obj, long j, Object obj2) {
        f11066f.f11071a.putObject(obj, j, obj2);
    }

    /* renamed from: g */
    static void m6912g(Object obj, long j, boolean z) {
        f11066f.mo14784d(obj, j, z);
    }

    /* renamed from: h */
    static void m6913h(byte[] bArr, long j, byte b) {
        f11066f.mo14785f(bArr, f11069i + j, b);
    }

    /* renamed from: i */
    private static Field m6914i(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static void m6915j(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        m6916k(obj, j2, ((255 & b) << i) | (m6931z(obj, j2) & ((255 << i) ^ -1)));
    }

    /* renamed from: k */
    static void m6916k(Object obj, long j, int i) {
        f11066f.mo14791e(obj, j, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static void m6917l(Object obj, long j, boolean z) {
        m6907b(obj, j, z ? (byte) 1 : 0);
    }

    /* renamed from: m */
    static boolean m6918m() {
        return f11068h;
    }

    /* renamed from: n */
    static boolean m6919n() {
        return f11067g;
    }

    /* renamed from: o */
    static Unsafe m6920o() {
        try {
            return (Unsafe) AccessController.doPrivileged(new ub0());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: p */
    private static boolean m6921p() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f11062b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls2.getMethod("arrayIndexScale", new Class[]{Class.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getInt", new Class[]{cls, cls3});
            cls2.getMethod("putInt", new Class[]{cls, cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            cls2.getMethod("putLong", new Class[]{cls, cls3, cls3});
            cls2.getMethod("getObject", new Class[]{cls, cls3});
            cls2.getMethod("putObject", new Class[]{cls, cls3, cls});
            if (i80.m6313a()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls, cls3});
            cls2.getMethod("putByte", new Class[]{cls, cls3, Byte.TYPE});
            cls2.getMethod("getBoolean", new Class[]{cls, cls3});
            cls2.getMethod("putBoolean", new Class[]{cls, cls3, Boolean.TYPE});
            cls2.getMethod("getFloat", new Class[]{cls, cls3});
            cls2.getMethod("putFloat", new Class[]{cls, cls3, Float.TYPE});
            cls2.getMethod("getDouble", new Class[]{cls, cls3});
            cls2.getMethod("putDouble", new Class[]{cls, cls3, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = f11061a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    /* renamed from: q */
    private static boolean m6922q() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f11062b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (m6923r() == null) {
                return false;
            }
            if (i80.m6313a()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls3});
            cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{cls3});
            cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls3});
            cls2.getMethod("putLong", new Class[]{cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
            return true;
        } catch (Throwable th) {
            Logger logger = f11061a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    /* renamed from: r */
    private static Field m6923r() {
        Field i;
        if (i80.m6313a() && (i = m6914i(Buffer.class, "effectiveDirectAddress")) != null) {
            return i;
        }
        Field i2 = m6914i(Buffer.class, "address");
        if (i2 == null || i2.getType() != Long.TYPE) {
            return null;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public static void m6925t(Object obj, long j, boolean z) {
        m6915j(obj, j, z ? (byte) 1 : 0);
    }

    /* renamed from: x */
    static <T> T m6929x(Class<T> cls) {
        try {
            return f11062b.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: y */
    private static int m6930y(Class<?> cls) {
        if (f11068h) {
            return f11066f.f11071a.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* renamed from: z */
    static int m6931z(Object obj, long j) {
        return f11066f.mo14792g(obj, j);
    }
}
