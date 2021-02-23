package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.measurement.f6 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2758f6 {

    /* renamed from: a */
    private static final Logger f17300a = Logger.getLogger(C2758f6.class.getName());

    /* renamed from: b */
    private static final Unsafe f17301b;

    /* renamed from: c */
    private static final Class<?> f17302c = C2723b3.m9322c();

    /* renamed from: d */
    private static final boolean f17303d;

    /* renamed from: e */
    private static final boolean f17304e;

    /* renamed from: f */
    private static final C2762d f17305f;

    /* renamed from: g */
    private static final boolean f17306g = m9412E();

    /* renamed from: h */
    private static final boolean f17307h = m9408A();

    /* renamed from: i */
    private static final long f17308i = ((long) m9436n(byte[].class));

    /* renamed from: j */
    static final boolean f17309j = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    /* renamed from: com.google.android.gms.internal.measurement.f6$a */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    private static final class C2759a extends C2762d {
        C2759a(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final byte mo18635a(Object obj, long j) {
            if (C2758f6.f17309j) {
                return C2758f6.m9419L(obj, j);
            }
            return C2758f6.m9420M(obj, j);
        }

        /* renamed from: b */
        public final void mo18636b(Object obj, long j, byte b) {
            if (C2758f6.f17309j) {
                C2758f6.m9443u(obj, j, b);
            } else {
                C2758f6.m9447y(obj, j, b);
            }
        }

        /* renamed from: c */
        public final void mo18637c(Object obj, long j, double d) {
            mo18644f(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: d */
        public final void mo18638d(Object obj, long j, float f) {
            mo18643e(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: g */
        public final void mo18639g(Object obj, long j, boolean z) {
            if (C2758f6.f17309j) {
                C2758f6.m9448z(obj, j, z);
            } else {
                C2758f6.m9411D(obj, j, z);
            }
        }

        /* renamed from: h */
        public final boolean mo18640h(Object obj, long j) {
            if (C2758f6.f17309j) {
                return C2758f6.m9421N(obj, j);
            }
            return C2758f6.m9422O(obj, j);
        }

        /* renamed from: i */
        public final float mo18641i(Object obj, long j) {
            return Float.intBitsToFloat(mo18645k(obj, j));
        }

        /* renamed from: j */
        public final double mo18642j(Object obj, long j) {
            return Double.longBitsToDouble(mo18646l(obj, j));
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.f6$b */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    private static final class C2760b extends C2762d {
        C2760b(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final byte mo18635a(Object obj, long j) {
            return this.f17310a.getByte(obj, j);
        }

        /* renamed from: b */
        public final void mo18636b(Object obj, long j, byte b) {
            this.f17310a.putByte(obj, j, b);
        }

        /* renamed from: c */
        public final void mo18637c(Object obj, long j, double d) {
            this.f17310a.putDouble(obj, j, d);
        }

        /* renamed from: d */
        public final void mo18638d(Object obj, long j, float f) {
            this.f17310a.putFloat(obj, j, f);
        }

        /* renamed from: g */
        public final void mo18639g(Object obj, long j, boolean z) {
            this.f17310a.putBoolean(obj, j, z);
        }

        /* renamed from: h */
        public final boolean mo18640h(Object obj, long j) {
            return this.f17310a.getBoolean(obj, j);
        }

        /* renamed from: i */
        public final float mo18641i(Object obj, long j) {
            return this.f17310a.getFloat(obj, j);
        }

        /* renamed from: j */
        public final double mo18642j(Object obj, long j) {
            return this.f17310a.getDouble(obj, j);
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.f6$c */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    private static final class C2761c extends C2762d {
        C2761c(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final byte mo18635a(Object obj, long j) {
            if (C2758f6.f17309j) {
                return C2758f6.m9419L(obj, j);
            }
            return C2758f6.m9420M(obj, j);
        }

        /* renamed from: b */
        public final void mo18636b(Object obj, long j, byte b) {
            if (C2758f6.f17309j) {
                C2758f6.m9443u(obj, j, b);
            } else {
                C2758f6.m9447y(obj, j, b);
            }
        }

        /* renamed from: c */
        public final void mo18637c(Object obj, long j, double d) {
            mo18644f(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: d */
        public final void mo18638d(Object obj, long j, float f) {
            mo18643e(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: g */
        public final void mo18639g(Object obj, long j, boolean z) {
            if (C2758f6.f17309j) {
                C2758f6.m9448z(obj, j, z);
            } else {
                C2758f6.m9411D(obj, j, z);
            }
        }

        /* renamed from: h */
        public final boolean mo18640h(Object obj, long j) {
            if (C2758f6.f17309j) {
                return C2758f6.m9421N(obj, j);
            }
            return C2758f6.m9422O(obj, j);
        }

        /* renamed from: i */
        public final float mo18641i(Object obj, long j) {
            return Float.intBitsToFloat(mo18645k(obj, j));
        }

        /* renamed from: j */
        public final double mo18642j(Object obj, long j) {
            return Double.longBitsToDouble(mo18646l(obj, j));
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.f6$d */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    private static abstract class C2762d {

        /* renamed from: a */
        Unsafe f17310a;

        C2762d(Unsafe unsafe) {
            this.f17310a = unsafe;
        }

        /* renamed from: a */
        public abstract byte mo18635a(Object obj, long j);

        /* renamed from: b */
        public abstract void mo18636b(Object obj, long j, byte b);

        /* renamed from: c */
        public abstract void mo18637c(Object obj, long j, double d);

        /* renamed from: d */
        public abstract void mo18638d(Object obj, long j, float f);

        /* renamed from: e */
        public final void mo18643e(Object obj, long j, int i) {
            this.f17310a.putInt(obj, j, i);
        }

        /* renamed from: f */
        public final void mo18644f(Object obj, long j, long j2) {
            this.f17310a.putLong(obj, j, j2);
        }

        /* renamed from: g */
        public abstract void mo18639g(Object obj, long j, boolean z);

        /* renamed from: h */
        public abstract boolean mo18640h(Object obj, long j);

        /* renamed from: i */
        public abstract float mo18641i(Object obj, long j);

        /* renamed from: j */
        public abstract double mo18642j(Object obj, long j);

        /* renamed from: k */
        public final int mo18645k(Object obj, long j) {
            return this.f17310a.getInt(obj, j);
        }

        /* renamed from: l */
        public final long mo18646l(Object obj, long j) {
            return this.f17310a.getLong(obj, j);
        }
    }

    static {
        Class<Object[]> cls = Object[].class;
        Class<double[]> cls2 = double[].class;
        Class<float[]> cls3 = float[].class;
        Class<long[]> cls4 = long[].class;
        Class<int[]> cls5 = int[].class;
        Class<boolean[]> cls6 = boolean[].class;
        Unsafe t = m9442t();
        f17301b = t;
        boolean B = m9409B(Long.TYPE);
        f17303d = B;
        boolean B2 = m9409B(Integer.TYPE);
        f17304e = B2;
        C2762d dVar = null;
        if (t != null) {
            if (!C2723b3.m9321b()) {
                dVar = new C2760b(t);
            } else if (B) {
                dVar = new C2761c(t);
            } else if (B2) {
                dVar = new C2759a(t);
            }
        }
        f17305f = dVar;
        m9436n(cls6);
        m9441s(cls6);
        m9436n(cls5);
        m9441s(cls5);
        m9436n(cls4);
        m9441s(cls4);
        m9436n(cls3);
        m9441s(cls3);
        m9436n(cls2);
        m9441s(cls2);
        m9436n(cls);
        m9441s(cls);
        Field G = m9414G();
        if (!(G == null || dVar == null)) {
            dVar.f17310a.objectFieldOffset(G);
        }
    }

    private C2758f6() {
    }

    /* renamed from: A */
    private static boolean m9408A() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f17301b;
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
            if (C2723b3.m9321b()) {
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
            Logger logger = f17300a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    /* renamed from: B */
    private static boolean m9409B(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!C2723b3.m9321b()) {
            return false;
        }
        try {
            Class<?> cls3 = f17302c;
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

    /* renamed from: C */
    static double m9410C(Object obj, long j) {
        return f17305f.mo18642j(obj, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public static void m9411D(Object obj, long j, boolean z) {
        m9447y(obj, j, z ? (byte) 1 : 0);
    }

    /* renamed from: E */
    private static boolean m9412E() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f17301b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (m9414G() == null) {
                return false;
            }
            if (C2723b3.m9321b()) {
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
            Logger logger = f17300a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    /* renamed from: F */
    static Object m9413F(Object obj, long j) {
        return f17305f.f17310a.getObject(obj, j);
    }

    /* renamed from: G */
    private static Field m9414G() {
        Field d;
        if (C2723b3.m9321b() && (d = m9426d(Buffer.class, "effectiveDirectAddress")) != null) {
            return d;
        }
        Field d2 = m9426d(Buffer.class, "address");
        if (d2 == null || d2.getType() != Long.TYPE) {
            return null;
        }
        return d2;
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public static byte m9419L(Object obj, long j) {
        return (byte) (m9424b(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public static byte m9420M(Object obj, long j) {
        return (byte) (m9424b(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public static boolean m9421N(Object obj, long j) {
        return m9419L(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public static boolean m9422O(Object obj, long j) {
        return m9420M(obj, j) != 0;
    }

    /* renamed from: a */
    static byte m9423a(byte[] bArr, long j) {
        return f17305f.mo18635a(bArr, f17308i + j);
    }

    /* renamed from: b */
    static int m9424b(Object obj, long j) {
        return f17305f.mo18645k(obj, j);
    }

    /* renamed from: c */
    static <T> T m9425c(Class<T> cls) {
        try {
            return f17301b.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: d */
    private static Field m9426d(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: f */
    static void m9428f(Object obj, long j, double d) {
        f17305f.mo18637c(obj, j, d);
    }

    /* renamed from: g */
    static void m9429g(Object obj, long j, float f) {
        f17305f.mo18638d(obj, j, f);
    }

    /* renamed from: h */
    static void m9430h(Object obj, long j, int i) {
        f17305f.mo18643e(obj, j, i);
    }

    /* renamed from: i */
    static void m9431i(Object obj, long j, long j2) {
        f17305f.mo18644f(obj, j, j2);
    }

    /* renamed from: j */
    static void m9432j(Object obj, long j, Object obj2) {
        f17305f.f17310a.putObject(obj, j, obj2);
    }

    /* renamed from: k */
    static void m9433k(Object obj, long j, boolean z) {
        f17305f.mo18639g(obj, j, z);
    }

    /* renamed from: l */
    static void m9434l(byte[] bArr, long j, byte b) {
        f17305f.mo18636b(bArr, f17308i + j, b);
    }

    /* renamed from: m */
    static boolean m9435m() {
        return f17307h;
    }

    /* renamed from: n */
    private static int m9436n(Class<?> cls) {
        if (f17307h) {
            return f17305f.f17310a.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* renamed from: o */
    static long m9437o(Object obj, long j) {
        return f17305f.mo18646l(obj, j);
    }

    /* renamed from: r */
    static boolean m9440r() {
        return f17306g;
    }

    /* renamed from: s */
    private static int m9441s(Class<?> cls) {
        if (f17307h) {
            return f17305f.f17310a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* renamed from: t */
    static Unsafe m9442t() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C2778h6());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public static void m9443u(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        m9430h(obj, j2, ((255 & b) << i) | (m9424b(obj, j2) & ((255 << i) ^ -1)));
    }

    /* renamed from: w */
    static boolean m9445w(Object obj, long j) {
        return f17305f.mo18640h(obj, j);
    }

    /* renamed from: x */
    static float m9446x(Object obj, long j) {
        return f17305f.mo18641i(obj, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public static void m9447y(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        m9430h(obj, j2, ((255 & b) << i) | (m9424b(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public static void m9448z(Object obj, long j, boolean z) {
        m9443u(obj, j, z ? (byte) 1 : 0);
    }
}
