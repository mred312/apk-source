package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: com.google.protobuf.t0 */
/* compiled from: UnsafeUtil */
final class C3752t0 {

    /* renamed from: a */
    private static final Logger f20865a = Logger.getLogger(C3752t0.class.getName());

    /* renamed from: b */
    private static final Unsafe f20866b = m13718G();

    /* renamed from: c */
    private static final Class<?> f20867c = C3687b.m13155b();

    /* renamed from: d */
    private static final boolean f20868d = m13751p(Long.TYPE);

    /* renamed from: e */
    private static final boolean f20869e = m13751p(Integer.TYPE);

    /* renamed from: f */
    private static final C3757e f20870f = m13716E();

    /* renamed from: g */
    private static final boolean f20871g = m13735X();

    /* renamed from: h */
    private static final boolean f20872h = m13734W();

    /* renamed from: i */
    static final long f20873i = ((long) m13746k(byte[].class));

    /* renamed from: j */
    private static final long f20874j = m13753r(m13748m());

    /* renamed from: k */
    static final boolean f20875k = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    /* renamed from: com.google.protobuf.t0$a */
    /* compiled from: UnsafeUtil */
    static class C3753a implements PrivilegedExceptionAction<Unsafe> {
        C3753a() {
        }

        /* renamed from: a */
        public Unsafe run() {
            Class<Unsafe> cls = Unsafe.class;
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get((Object) null);
                if (cls.isInstance(obj)) {
                    return cls.cast(obj);
                }
            }
            return null;
        }
    }

    /* renamed from: com.google.protobuf.t0$b */
    /* compiled from: UnsafeUtil */
    private static final class C3754b extends C3757e {
        C3754b(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: c */
        public void mo24041c(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: d */
        public void mo24042d(byte[] bArr, long j, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: e */
        public boolean mo24043e(Object obj, long j) {
            if (C3752t0.f20875k) {
                return C3752t0.m13755t(obj, j);
            }
            return C3752t0.m13756u(obj, j);
        }

        /* renamed from: f */
        public byte mo24044f(long j) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: g */
        public byte mo24045g(Object obj, long j) {
            if (C3752t0.f20875k) {
                return C3752t0.m13759x(obj, j);
            }
            return C3752t0.m13760y(obj, j);
        }

        /* renamed from: h */
        public double mo24046h(Object obj, long j) {
            return Double.longBitsToDouble(mo24057l(obj, j));
        }

        /* renamed from: i */
        public float mo24047i(Object obj, long j) {
            return Float.intBitsToFloat(mo24056j(obj, j));
        }

        /* renamed from: k */
        public long mo24048k(long j) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: o */
        public void mo24049o(Object obj, long j, boolean z) {
            if (C3752t0.f20875k) {
                C3752t0.m13723L(obj, j, z);
            } else {
                C3752t0.m13724M(obj, j, z);
            }
        }

        /* renamed from: p */
        public void mo24050p(long j, byte b) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: q */
        public void mo24051q(Object obj, long j, byte b) {
            if (C3752t0.f20875k) {
                C3752t0.m13727P(obj, j, b);
            } else {
                C3752t0.m13728Q(obj, j, b);
            }
        }

        /* renamed from: r */
        public void mo24052r(Object obj, long j, double d) {
            mo24061u(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: s */
        public void mo24053s(Object obj, long j, float f) {
            mo24060t(obj, j, Float.floatToIntBits(f));
        }
    }

    /* renamed from: com.google.protobuf.t0$c */
    /* compiled from: UnsafeUtil */
    private static final class C3755c extends C3757e {
        C3755c(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: c */
        public void mo24041c(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: d */
        public void mo24042d(byte[] bArr, long j, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: e */
        public boolean mo24043e(Object obj, long j) {
            if (C3752t0.f20875k) {
                return C3752t0.m13755t(obj, j);
            }
            return C3752t0.m13756u(obj, j);
        }

        /* renamed from: f */
        public byte mo24044f(long j) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: g */
        public byte mo24045g(Object obj, long j) {
            if (C3752t0.f20875k) {
                return C3752t0.m13759x(obj, j);
            }
            return C3752t0.m13760y(obj, j);
        }

        /* renamed from: h */
        public double mo24046h(Object obj, long j) {
            return Double.longBitsToDouble(mo24057l(obj, j));
        }

        /* renamed from: i */
        public float mo24047i(Object obj, long j) {
            return Float.intBitsToFloat(mo24056j(obj, j));
        }

        /* renamed from: k */
        public long mo24048k(long j) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: o */
        public void mo24049o(Object obj, long j, boolean z) {
            if (C3752t0.f20875k) {
                C3752t0.m13723L(obj, j, z);
            } else {
                C3752t0.m13724M(obj, j, z);
            }
        }

        /* renamed from: p */
        public void mo24050p(long j, byte b) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: q */
        public void mo24051q(Object obj, long j, byte b) {
            if (C3752t0.f20875k) {
                C3752t0.m13727P(obj, j, b);
            } else {
                C3752t0.m13728Q(obj, j, b);
            }
        }

        /* renamed from: r */
        public void mo24052r(Object obj, long j, double d) {
            mo24061u(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: s */
        public void mo24053s(Object obj, long j, float f) {
            mo24060t(obj, j, Float.floatToIntBits(f));
        }
    }

    /* renamed from: com.google.protobuf.t0$d */
    /* compiled from: UnsafeUtil */
    private static final class C3756d extends C3757e {
        C3756d(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: c */
        public void mo24041c(long j, byte[] bArr, long j2, long j3) {
            this.f20876a.copyMemory((Object) null, j, bArr, C3752t0.f20873i + j2, j3);
        }

        /* renamed from: d */
        public void mo24042d(byte[] bArr, long j, long j2, long j3) {
            this.f20876a.copyMemory(bArr, C3752t0.f20873i + j, (Object) null, j2, j3);
        }

        /* renamed from: e */
        public boolean mo24043e(Object obj, long j) {
            return this.f20876a.getBoolean(obj, j);
        }

        /* renamed from: f */
        public byte mo24044f(long j) {
            return this.f20876a.getByte(j);
        }

        /* renamed from: g */
        public byte mo24045g(Object obj, long j) {
            return this.f20876a.getByte(obj, j);
        }

        /* renamed from: h */
        public double mo24046h(Object obj, long j) {
            return this.f20876a.getDouble(obj, j);
        }

        /* renamed from: i */
        public float mo24047i(Object obj, long j) {
            return this.f20876a.getFloat(obj, j);
        }

        /* renamed from: k */
        public long mo24048k(long j) {
            return this.f20876a.getLong(j);
        }

        /* renamed from: o */
        public void mo24049o(Object obj, long j, boolean z) {
            this.f20876a.putBoolean(obj, j, z);
        }

        /* renamed from: p */
        public void mo24050p(long j, byte b) {
            this.f20876a.putByte(j, b);
        }

        /* renamed from: q */
        public void mo24051q(Object obj, long j, byte b) {
            this.f20876a.putByte(obj, j, b);
        }

        /* renamed from: r */
        public void mo24052r(Object obj, long j, double d) {
            this.f20876a.putDouble(obj, j, d);
        }

        /* renamed from: s */
        public void mo24053s(Object obj, long j, float f) {
            this.f20876a.putFloat(obj, j, f);
        }
    }

    /* renamed from: com.google.protobuf.t0$e */
    /* compiled from: UnsafeUtil */
    private static abstract class C3757e {

        /* renamed from: a */
        Unsafe f20876a;

        C3757e(Unsafe unsafe) {
            this.f20876a = unsafe;
        }

        /* renamed from: a */
        public final int mo24054a(Class<?> cls) {
            return this.f20876a.arrayBaseOffset(cls);
        }

        /* renamed from: b */
        public final int mo24055b(Class<?> cls) {
            return this.f20876a.arrayIndexScale(cls);
        }

        /* renamed from: c */
        public abstract void mo24041c(long j, byte[] bArr, long j2, long j3);

        /* renamed from: d */
        public abstract void mo24042d(byte[] bArr, long j, long j2, long j3);

        /* renamed from: e */
        public abstract boolean mo24043e(Object obj, long j);

        /* renamed from: f */
        public abstract byte mo24044f(long j);

        /* renamed from: g */
        public abstract byte mo24045g(Object obj, long j);

        /* renamed from: h */
        public abstract double mo24046h(Object obj, long j);

        /* renamed from: i */
        public abstract float mo24047i(Object obj, long j);

        /* renamed from: j */
        public final int mo24056j(Object obj, long j) {
            return this.f20876a.getInt(obj, j);
        }

        /* renamed from: k */
        public abstract long mo24048k(long j);

        /* renamed from: l */
        public final long mo24057l(Object obj, long j) {
            return this.f20876a.getLong(obj, j);
        }

        /* renamed from: m */
        public final Object mo24058m(Object obj, long j) {
            return this.f20876a.getObject(obj, j);
        }

        /* renamed from: n */
        public final long mo24059n(Field field) {
            return this.f20876a.objectFieldOffset(field);
        }

        /* renamed from: o */
        public abstract void mo24049o(Object obj, long j, boolean z);

        /* renamed from: p */
        public abstract void mo24050p(long j, byte b);

        /* renamed from: q */
        public abstract void mo24051q(Object obj, long j, byte b);

        /* renamed from: r */
        public abstract void mo24052r(Object obj, long j, double d);

        /* renamed from: s */
        public abstract void mo24053s(Object obj, long j, float f);

        /* renamed from: t */
        public final void mo24060t(Object obj, long j, int i) {
            this.f20876a.putInt(obj, j, i);
        }

        /* renamed from: u */
        public final void mo24061u(Object obj, long j, long j2) {
            this.f20876a.putLong(obj, j, j2);
        }

        /* renamed from: v */
        public final void mo24062v(Object obj, long j, Object obj2) {
            this.f20876a.putObject(obj, j, obj2);
        }
    }

    static {
        Class<Object[]> cls = Object[].class;
        Class<double[]> cls2 = double[].class;
        Class<float[]> cls3 = float[].class;
        Class<long[]> cls4 = long[].class;
        Class<int[]> cls5 = int[].class;
        Class<boolean[]> cls6 = boolean[].class;
        m13746k(cls6);
        m13747l(cls6);
        m13746k(cls5);
        m13747l(cls5);
        m13746k(cls4);
        m13747l(cls4);
        m13746k(cls3);
        m13747l(cls3);
        m13746k(cls2);
        m13747l(cls2);
        m13746k(cls);
        m13747l(cls);
    }

    private C3752t0() {
    }

    /* renamed from: A */
    static float m13712A(Object obj, long j) {
        return f20870f.mo24047i(obj, j);
    }

    /* renamed from: B */
    static int m13713B(Object obj, long j) {
        return f20870f.mo24056j(obj, j);
    }

    /* renamed from: C */
    static long m13714C(long j) {
        return f20870f.mo24048k(j);
    }

    /* renamed from: D */
    static long m13715D(Object obj, long j) {
        return f20870f.mo24057l(obj, j);
    }

    /* renamed from: E */
    private static C3757e m13716E() {
        Unsafe unsafe = f20866b;
        if (unsafe == null) {
            return null;
        }
        if (!C3687b.m13156c()) {
            return new C3756d(unsafe);
        }
        if (f20868d) {
            return new C3755c(unsafe);
        }
        if (f20869e) {
            return new C3754b(unsafe);
        }
        return null;
    }

    /* renamed from: F */
    static Object m13717F(Object obj, long j) {
        return f20870f.mo24058m(obj, j);
    }

    /* renamed from: G */
    static Unsafe m13718G() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C3753a());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: H */
    static boolean m13719H() {
        return f20872h;
    }

    /* renamed from: I */
    static boolean m13720I() {
        return f20871g;
    }

    /* renamed from: J */
    static long m13721J(Field field) {
        return f20870f.mo24059n(field);
    }

    /* renamed from: K */
    static void m13722K(Object obj, long j, boolean z) {
        f20870f.mo24049o(obj, j, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public static void m13723L(Object obj, long j, boolean z) {
        m13727P(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public static void m13724M(Object obj, long j, boolean z) {
        m13728Q(obj, j, z ? (byte) 1 : 0);
    }

    /* renamed from: N */
    static void m13725N(long j, byte b) {
        f20870f.mo24050p(j, b);
    }

    /* renamed from: O */
    static void m13726O(byte[] bArr, long j, byte b) {
        f20870f.mo24051q(bArr, f20873i + j, b);
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public static void m13727P(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        m13731T(obj, j2, ((255 & b) << i) | (m13713B(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public static void m13728Q(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        m13731T(obj, j2, ((255 & b) << i) | (m13713B(obj, j2) & ((255 << i) ^ -1)));
    }

    /* renamed from: R */
    static void m13729R(Object obj, long j, double d) {
        f20870f.mo24052r(obj, j, d);
    }

    /* renamed from: S */
    static void m13730S(Object obj, long j, float f) {
        f20870f.mo24053s(obj, j, f);
    }

    /* renamed from: T */
    static void m13731T(Object obj, long j, int i) {
        f20870f.mo24060t(obj, j, i);
    }

    /* renamed from: U */
    static void m13732U(Object obj, long j, long j2) {
        f20870f.mo24061u(obj, j, j2);
    }

    /* renamed from: V */
    static void m13733V(Object obj, long j, Object obj2) {
        f20870f.mo24062v(obj, j, obj2);
    }

    /* renamed from: W */
    private static boolean m13734W() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f20866b;
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
            if (C3687b.m13156c()) {
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
            Logger logger = f20865a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    /* renamed from: X */
    private static boolean m13735X() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f20866b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (m13748m() == null) {
                return false;
            }
            if (C3687b.m13156c()) {
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
            Logger logger = f20865a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    /* renamed from: i */
    static long m13744i(ByteBuffer byteBuffer) {
        return f20870f.mo24057l(byteBuffer, f20874j);
    }

    /* renamed from: j */
    static <T> T m13745j(Class<T> cls) {
        try {
            return f20866b.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: k */
    private static int m13746k(Class<?> cls) {
        if (f20872h) {
            return f20870f.mo24054a(cls);
        }
        return -1;
    }

    /* renamed from: l */
    private static int m13747l(Class<?> cls) {
        if (f20872h) {
            return f20870f.mo24055b(cls);
        }
        return -1;
    }

    /* renamed from: m */
    private static Field m13748m() {
        Field q;
        if (C3687b.m13156c() && (q = m13752q(Buffer.class, "effectiveDirectAddress")) != null) {
            return q;
        }
        Field q2 = m13752q(Buffer.class, "address");
        if (q2 == null || q2.getType() != Long.TYPE) {
            return null;
        }
        return q2;
    }

    /* renamed from: n */
    static void m13749n(long j, byte[] bArr, long j2, long j3) {
        f20870f.mo24041c(j, bArr, j2, j3);
    }

    /* renamed from: o */
    static void m13750o(byte[] bArr, long j, long j2, long j3) {
        f20870f.mo24042d(bArr, j, j2, j3);
    }

    /* renamed from: p */
    private static boolean m13751p(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!C3687b.m13156c()) {
            return false;
        }
        try {
            Class<?> cls3 = f20867c;
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

    /* renamed from: q */
    private static Field m13752q(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: r */
    private static long m13753r(Field field) {
        C3757e eVar;
        if (field == null || (eVar = f20870f) == null) {
            return -1;
        }
        return eVar.mo24059n(field);
    }

    /* renamed from: s */
    static boolean m13754s(Object obj, long j) {
        return f20870f.mo24043e(obj, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public static boolean m13755t(Object obj, long j) {
        return m13759x(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public static boolean m13756u(Object obj, long j) {
        return m13760y(obj, j) != 0;
    }

    /* renamed from: v */
    static byte m13757v(long j) {
        return f20870f.mo24044f(j);
    }

    /* renamed from: w */
    static byte m13758w(byte[] bArr, long j) {
        return f20870f.mo24045g(bArr, f20873i + j);
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public static byte m13759x(Object obj, long j) {
        return (byte) ((m13713B(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3))) & 255);
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public static byte m13760y(Object obj, long j) {
        return (byte) ((m13713B(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255);
    }

    /* renamed from: z */
    static double m13761z(Object obj, long j) {
        return f20870f.mo24046h(obj, j);
    }
}
