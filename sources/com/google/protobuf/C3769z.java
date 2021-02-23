package com.google.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.protobuf.ByteString;
import com.google.protobuf.C3689c;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* renamed from: com.google.protobuf.z */
/* compiled from: MessageSchema */
final class C3769z<T> implements C3722m0<T> {

    /* renamed from: r */
    private static final int[] f20880r = new int[0];

    /* renamed from: s */
    private static final Unsafe f20881s = C3752t0.m13718G();

    /* renamed from: a */
    private final int[] f20882a;

    /* renamed from: b */
    private final Object[] f20883b;

    /* renamed from: c */
    private final int f20884c;

    /* renamed from: d */
    private final int f20885d;

    /* renamed from: e */
    private final MessageLite f20886e;

    /* renamed from: f */
    private final boolean f20887f;

    /* renamed from: g */
    private final boolean f20888g;

    /* renamed from: h */
    private final boolean f20889h;

    /* renamed from: i */
    private final boolean f20890i;

    /* renamed from: j */
    private final int[] f20891j;

    /* renamed from: k */
    private final int f20892k;

    /* renamed from: l */
    private final int f20893l;

    /* renamed from: m */
    private final C3688b0 f20894m;

    /* renamed from: n */
    private final C3738q f20895n;

    /* renamed from: o */
    private final C3746r0<?, ?> f20896o;

    /* renamed from: p */
    private final C3710j<?> f20897p;

    /* renamed from: q */
    private final C3751t f20898q;

    /* renamed from: com.google.protobuf.z$a */
    /* compiled from: MessageSchema */
    static /* synthetic */ class C3770a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20899a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20899a = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f20899a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.C3770a.<clinit>():void");
        }
    }

    private C3769z(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, C3688b0 b0Var, C3738q qVar, C3746r0<?, ?> r0Var, C3710j<?> jVar, C3751t tVar) {
        this.f20882a = iArr;
        this.f20883b = objArr;
        this.f20884c = i;
        this.f20885d = i2;
        this.f20888g = messageLite instanceof GeneratedMessageLite;
        this.f20889h = z;
        this.f20887f = jVar != null && jVar.mo23895e(messageLite);
        this.f20890i = z2;
        this.f20891j = iArr2;
        this.f20892k = i3;
        this.f20893l = i4;
        this.f20894m = b0Var;
        this.f20895n = qVar;
        this.f20896o = r0Var;
        this.f20897p = jVar;
        this.f20886e = messageLite;
        this.f20898q = tVar;
    }

    /* renamed from: A */
    private static <T> int m13923A(T t, long j) {
        return C3752t0.m13713B(t, j);
    }

    /* renamed from: B */
    private static boolean m13924B(int i) {
        return (i & 536870912) != 0;
    }

    /* renamed from: C */
    private boolean m13925C(T t, int i) {
        if (this.f20889h) {
            int t0 = m13977t0(i);
            long V = m13944V(t0);
            switch (m13975s0(t0)) {
                case 0:
                    if (C3752t0.m13761z(t, V) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return true;
                    }
                    return false;
                case 1:
                    if (C3752t0.m13712A(t, V) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (C3752t0.m13715D(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (C3752t0.m13715D(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (C3752t0.m13713B(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (C3752t0.m13715D(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (C3752t0.m13713B(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return C3752t0.m13754s(t, V);
                case 8:
                    Object F = C3752t0.m13717F(t, V);
                    if (F instanceof String) {
                        return !((String) F).isEmpty();
                    }
                    if (F instanceof ByteString) {
                        return !ByteString.EMPTY.equals(F);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (C3752t0.m13717F(t, V) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !ByteString.EMPTY.equals(C3752t0.m13717F(t, V));
                case 11:
                    if (C3752t0.m13713B(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (C3752t0.m13713B(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (C3752t0.m13713B(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (C3752t0.m13715D(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (C3752t0.m13713B(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (C3752t0.m13715D(t, V) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (C3752t0.m13717F(t, V) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int i0 = m13956i0(i);
            if ((C3752t0.m13713B(t, (long) (i0 & 1048575)) & (1 << (i0 >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: D */
    private boolean m13926D(T t, int i, int i2, int i3) {
        if (this.f20889h) {
            return m13925C(t, i);
        }
        return (i2 & i3) != 0;
    }

    /* renamed from: E */
    private static boolean m13927E(Object obj, int i, C3722m0 m0Var) {
        return m0Var.mo23808g(C3752t0.m13717F(obj, m13944V(i)));
    }

    /* renamed from: F */
    private <N> boolean m13928F(Object obj, int i, int i2) {
        List list = (List) C3752t0.m13717F(obj, m13944V(i));
        if (list.isEmpty()) {
            return true;
        }
        C3722m0 v = m13980v(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!v.mo23808g(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: G */
    private boolean m13929G(T t, int i, int i2) {
        Map<?, ?> h = this.f20898q.mo24038h(C3752t0.m13717F(t, m13944V(i)));
        if (h.isEmpty()) {
            return true;
        }
        if (this.f20898q.mo24033c(m13978u(i2)).f20630c.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        C3722m0<?> m0Var = null;
        for (Object next : h.values()) {
            if (m0Var == null) {
                m0Var = C3707h0.m13389a().mo23886d(next.getClass());
            }
            if (!m0Var.mo23808g(next)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: H */
    private boolean m13930H(T t, T t2, int i) {
        long i0 = (long) (m13956i0(i) & 1048575);
        return C3752t0.m13713B(t, i0) == C3752t0.m13713B(t2, i0);
    }

    /* renamed from: I */
    private boolean m13931I(T t, int i, int i2) {
        return C3752t0.m13713B(t, (long) (m13956i0(i2) & 1048575)) == i;
    }

    /* renamed from: J */
    private static boolean m13932J(int i) {
        return (i & 268435456) != 0;
    }

    /* renamed from: K */
    private static List<?> m13933K(Object obj, long j) {
        return (List) C3752t0.m13717F(obj, j);
    }

    /* renamed from: L */
    private static <T> long m13934L(T t, long j) {
        return C3752t0.m13715D(t, j);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: M */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void m13935M(com.google.protobuf.C3746r0<UT, UB> r17, com.google.protobuf.C3710j<ET> r18, T r19, com.google.protobuf.C3714k0 r20, com.google.protobuf.ExtensionRegistryLite r21) {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r10 = r19
            r0 = r20
            r11 = r21
            r12 = 0
            r13 = r12
            r14 = r13
        L_0x000d:
            int r1 = r20.mo23814B()     // Catch:{ all -> 0x060f }
            int r3 = r8.m13954g0(r1)     // Catch:{ all -> 0x060f }
            if (r3 >= 0) goto L_0x008c
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0033
            int r0 = r8.f20892k
        L_0x001e:
            int r1 = r8.f20893l
            if (r0 >= r1) goto L_0x002d
            int[] r1 = r8.f20891j
            r1 = r1[r0]
            java.lang.Object r13 = r8.m13970q(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x001e
        L_0x002d:
            if (r13 == 0) goto L_0x0032
            r9.mo24009o(r10, r13)
        L_0x0032:
            return
        L_0x0033:
            boolean r2 = r8.f20887f     // Catch:{ all -> 0x060f }
            if (r2 != 0) goto L_0x003b
            r15 = r18
            r3 = r12
            goto L_0x0044
        L_0x003b:
            com.google.protobuf.MessageLite r2 = r8.f20886e     // Catch:{ all -> 0x060f }
            r15 = r18
            java.lang.Object r1 = r15.mo23892b(r11, r2, r1)     // Catch:{ all -> 0x060f }
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x005b
            if (r14 != 0) goto L_0x004c
            com.google.protobuf.FieldSet r14 = r18.mo23894d(r19)     // Catch:{ all -> 0x060f }
        L_0x004c:
            r1 = r18
            r2 = r20
            r4 = r21
            r5 = r14
            r6 = r13
            r7 = r17
            java.lang.Object r13 = r1.mo23897g(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x060f }
            goto L_0x000d
        L_0x005b:
            boolean r1 = r9.mo24011q(r0)     // Catch:{ all -> 0x060f }
            if (r1 == 0) goto L_0x0068
            boolean r1 = r20.mo23821I()     // Catch:{ all -> 0x060f }
            if (r1 == 0) goto L_0x0075
            goto L_0x000d
        L_0x0068:
            if (r13 != 0) goto L_0x006e
            java.lang.Object r13 = r9.mo24000f(r10)     // Catch:{ all -> 0x060f }
        L_0x006e:
            boolean r1 = r9.mo24007m(r13, r0)     // Catch:{ all -> 0x060f }
            if (r1 == 0) goto L_0x0075
            goto L_0x000d
        L_0x0075:
            int r0 = r8.f20892k
        L_0x0077:
            int r1 = r8.f20893l
            if (r0 >= r1) goto L_0x0086
            int[] r1 = r8.f20891j
            r1 = r1[r0]
            java.lang.Object r13 = r8.m13970q(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0077
        L_0x0086:
            if (r13 == 0) goto L_0x008b
            r9.mo24009o(r10, r13)
        L_0x008b:
            return
        L_0x008c:
            r15 = r18
            int r4 = r8.m13977t0(r3)     // Catch:{ all -> 0x060f }
            int r2 = m13975s0(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            switch(r2) {
                case 0: goto L_0x059b;
                case 1: goto L_0x058b;
                case 2: goto L_0x057b;
                case 3: goto L_0x056b;
                case 4: goto L_0x055b;
                case 5: goto L_0x054b;
                case 6: goto L_0x053b;
                case 7: goto L_0x052b;
                case 8: goto L_0x0523;
                case 9: goto L_0x04ec;
                case 10: goto L_0x04dc;
                case 11: goto L_0x04cc;
                case 12: goto L_0x04a9;
                case 13: goto L_0x0499;
                case 14: goto L_0x0489;
                case 15: goto L_0x0479;
                case 16: goto L_0x0469;
                case 17: goto L_0x0432;
                case 18: goto L_0x0423;
                case 19: goto L_0x0414;
                case 20: goto L_0x0405;
                case 21: goto L_0x03f6;
                case 22: goto L_0x03e7;
                case 23: goto L_0x03d8;
                case 24: goto L_0x03c9;
                case 25: goto L_0x03ba;
                case 26: goto L_0x03b5;
                case 27: goto L_0x03a3;
                case 28: goto L_0x0394;
                case 29: goto L_0x0385;
                case 30: goto L_0x036e;
                case 31: goto L_0x035f;
                case 32: goto L_0x0350;
                case 33: goto L_0x0341;
                case 34: goto L_0x0332;
                case 35: goto L_0x0323;
                case 36: goto L_0x0314;
                case 37: goto L_0x0305;
                case 38: goto L_0x02f6;
                case 39: goto L_0x02e7;
                case 40: goto L_0x02d8;
                case 41: goto L_0x02c9;
                case 42: goto L_0x02ba;
                case 43: goto L_0x02ab;
                case 44: goto L_0x0294;
                case 45: goto L_0x0285;
                case 46: goto L_0x0276;
                case 47: goto L_0x0267;
                case 48: goto L_0x0258;
                case 49: goto L_0x0242;
                case 50: goto L_0x0231;
                case 51: goto L_0x021d;
                case 52: goto L_0x0209;
                case 53: goto L_0x01f5;
                case 54: goto L_0x01e1;
                case 55: goto L_0x01cd;
                case 56: goto L_0x01b9;
                case 57: goto L_0x01a5;
                case 58: goto L_0x0191;
                case 59: goto L_0x0189;
                case 60: goto L_0x0150;
                case 61: goto L_0x0140;
                case 62: goto L_0x012c;
                case 63: goto L_0x0105;
                case 64: goto L_0x00f1;
                case 65: goto L_0x00dd;
                case 66: goto L_0x00c9;
                case 67: goto L_0x00b5;
                case 68: goto L_0x00a1;
                default: goto L_0x0099;
            }     // Catch:{ InvalidWireTypeException -> 0x05c8 }
        L_0x0099:
            if (r13 != 0) goto L_0x05ab
            java.lang.Object r13 = r17.mo24008n()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x05ab
        L_0x00a1:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.m0 r2 = r8.m13980v(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = r0.mo23847p(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x00b5:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r6 = r20.mo23858y()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x00c9:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r2 = r20.mo23857x()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x00dd:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r6 = r20.mo23845n()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x00f1:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r2 = r20.mo23822J()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0105:
            int r2 = r20.mo23855v()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Internal$EnumVerifier r5 = r8.m13976t(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r5 == 0) goto L_0x011c
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r5 == 0) goto L_0x0116
            goto L_0x011c
        L_0x0116:
            java.lang.Object r13 = com.google.protobuf.C3726o0.m13535L(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x011c:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x012c:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r2 = r20.mo23848q()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0140:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.ByteString r2 = r20.mo23818F()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0150:
            boolean r2 = r8.m13931I(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r2 == 0) goto L_0x0172
            long r5 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = com.google.protobuf.C3752t0.m13717F(r10, r5)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.m0 r5 = r8.m13980v(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r5 = r0.mo23815C(r5, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = com.google.protobuf.Internal.m12793d(r2, r5)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x0184
        L_0x0172:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.m0 r2 = r8.m13980v(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = r0.mo23815C(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
        L_0x0184:
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0189:
            r8.m13961l0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0191:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            boolean r2 = r20.mo23843l()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x01a5:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r2 = r20.mo23842k()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x01b9:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r6 = r20.mo23832c()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x01cd:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r2 = r20.mo23820H()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x01e1:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r6 = r20.mo23831b()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x01f5:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r6 = r20.mo23825M()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0209:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            float r2 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x021d:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            double r6 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Double r2 = java.lang.Double.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13969p0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0231:
            java.lang.Object r4 = r8.m13978u(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r1 = r16
            r2 = r19
            r5 = r21
            r6 = r20
            r1.m13936N(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0242:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.m0 r6 = r8.m13980v(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r1 = r16
            r2 = r19
            r3 = r4
            r5 = r20
            r7 = r21
            r1.m13957j0(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0258:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23837g(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0267:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23829a(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0276:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23852s(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0285:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23834d(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0294:
            com.google.protobuf.q r2 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r2 = r2.mo23984e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23854u(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Internal$EnumVerifier r3 = r8.m13976t(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r13 = com.google.protobuf.C3726o0.m13524A(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02ab:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23840i(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02ba:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23859z(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02c9:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23856w(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02d8:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23827O(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02e7:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23853t(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x02f6:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23846o(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0305:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23849r(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0314:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23819G(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0323:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23824L(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0332:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23837g(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0341:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23829a(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0350:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23852s(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x035f:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23834d(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x036e:
            com.google.protobuf.q r2 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r2 = r2.mo23984e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23854u(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Internal$EnumVerifier r3 = r8.m13976t(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r13 = com.google.protobuf.C3726o0.m13524A(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0385:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23840i(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0394:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23823K(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03a3:
            com.google.protobuf.m0 r5 = r8.m13980v(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r1 = r16
            r2 = r19
            r3 = r4
            r4 = r20
            r6 = r21
            r1.m13959k0(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03b5:
            r8.m13963m0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03ba:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23859z(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03c9:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23856w(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03d8:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23827O(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03e7:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23853t(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x03f6:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23846o(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0405:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23849r(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0414:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23819G(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0423:
            com.google.protobuf.q r1 = r8.f20895n     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.util.List r1 = r1.mo23984e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r0.mo23824L(r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0432:
            boolean r1 = r8.m13925C(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r1 == 0) goto L_0x0455
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r1 = com.google.protobuf.C3752t0.m13717F(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.m0 r2 = r8.m13980v(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = r0.mo23847p(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r1 = com.google.protobuf.Internal.m12793d(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0455:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.m0 r4 = r8.m13980v(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r4 = r0.mo23847p(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0469:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = r20.mo23858y()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13732U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0479:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r4 = r20.mo23857x()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13731T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0489:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = r20.mo23845n()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13732U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0499:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r4 = r20.mo23822J()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13731T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x04a9:
            int r2 = r20.mo23855v()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.Internal$EnumVerifier r5 = r8.m13976t(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r5 == 0) goto L_0x04c0
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r5 == 0) goto L_0x04ba
            goto L_0x04c0
        L_0x04ba:
            java.lang.Object r13 = com.google.protobuf.C3726o0.m13535L(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x04c0:
            long r4 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13731T(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x04cc:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r4 = r20.mo23848q()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13731T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x04dc:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.ByteString r4 = r20.mo23818F()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x04ec:
            boolean r1 = r8.m13925C(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r1 == 0) goto L_0x050f
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r1 = com.google.protobuf.C3752t0.m13717F(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.m0 r2 = r8.m13980v(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r2 = r0.mo23815C(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r1 = com.google.protobuf.Internal.m12793d(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r2 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x050f:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.m0 r4 = r8.m13980v(r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            java.lang.Object r4 = r0.mo23815C(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13733V(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x0523:
            r8.m13961l0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x052b:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            boolean r4 = r20.mo23843l()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13722K(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x053b:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r4 = r20.mo23842k()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13731T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x054b:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = r20.mo23832c()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13732U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x055b:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            int r4 = r20.mo23820H()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13731T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x056b:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = r20.mo23831b()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13732U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x057b:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            long r4 = r20.mo23825M()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13732U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x058b:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            float r4 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13730S(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x059b:
            long r1 = m13944V(r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            double r4 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            com.google.protobuf.C3752t0.m13729R(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            r8.m13967o0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            goto L_0x000d
        L_0x05ab:
            boolean r1 = r9.mo24007m(r13, r0)     // Catch:{ InvalidWireTypeException -> 0x05c8 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f20892k
        L_0x05b3:
            int r1 = r8.f20893l
            if (r0 >= r1) goto L_0x05c2
            int[] r1 = r8.f20891j
            r1 = r1[r0]
            java.lang.Object r13 = r8.m13970q(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05b3
        L_0x05c2:
            if (r13 == 0) goto L_0x05c7
            r9.mo24009o(r10, r13)
        L_0x05c7:
            return
        L_0x05c8:
            boolean r1 = r9.mo24011q(r0)     // Catch:{ all -> 0x060f }
            if (r1 == 0) goto L_0x05eb
            boolean r1 = r20.mo23821I()     // Catch:{ all -> 0x060f }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f20892k
        L_0x05d6:
            int r1 = r8.f20893l
            if (r0 >= r1) goto L_0x05e5
            int[] r1 = r8.f20891j
            r1 = r1[r0]
            java.lang.Object r13 = r8.m13970q(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05d6
        L_0x05e5:
            if (r13 == 0) goto L_0x05ea
            r9.mo24009o(r10, r13)
        L_0x05ea:
            return
        L_0x05eb:
            if (r13 != 0) goto L_0x05f2
            java.lang.Object r1 = r9.mo24000f(r10)     // Catch:{ all -> 0x060f }
            r13 = r1
        L_0x05f2:
            boolean r1 = r9.mo24007m(r13, r0)     // Catch:{ all -> 0x060f }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f20892k
        L_0x05fa:
            int r1 = r8.f20893l
            if (r0 >= r1) goto L_0x0609
            int[] r1 = r8.f20891j
            r1 = r1[r0]
            java.lang.Object r13 = r8.m13970q(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05fa
        L_0x0609:
            if (r13 == 0) goto L_0x060e
            r9.mo24009o(r10, r13)
        L_0x060e:
            return
        L_0x060f:
            r0 = move-exception
            int r1 = r8.f20892k
        L_0x0612:
            int r2 = r8.f20893l
            if (r1 >= r2) goto L_0x0621
            int[] r2 = r8.f20891j
            r2 = r2[r1]
            java.lang.Object r13 = r8.m13970q(r10, r2, r13, r9)
            int r1 = r1 + 1
            goto L_0x0612
        L_0x0621:
            if (r13 == 0) goto L_0x0626
            r9.mo24009o(r10, r13)
        L_0x0626:
            goto L_0x0628
        L_0x0627:
            throw r0
        L_0x0628:
            goto L_0x0627
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.m13935M(com.google.protobuf.r0, com.google.protobuf.j, java.lang.Object, com.google.protobuf.k0, com.google.protobuf.ExtensionRegistryLite):void");
    }

    /* renamed from: N */
    private final <K, V> void m13936N(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, C3714k0 k0Var) {
        long V = m13944V(m13977t0(i));
        Object F = C3752t0.m13717F(obj, V);
        if (F == null) {
            F = this.f20898q.mo24035e(obj2);
            C3752t0.m13733V(obj, V, F);
        } else if (this.f20898q.mo24037g(F)) {
            Object e = this.f20898q.mo24035e(obj2);
            this.f20898q.mo24031a(e, F);
            C3752t0.m13733V(obj, V, e);
            F = e;
        }
        k0Var.mo23816D(this.f20898q.mo24034d(F), this.f20898q.mo24033c(obj2), extensionRegistryLite);
    }

    /* renamed from: O */
    private void m13937O(T t, T t2, int i) {
        long V = m13944V(m13977t0(i));
        if (m13925C(t2, i)) {
            Object F = C3752t0.m13717F(t, V);
            Object F2 = C3752t0.m13717F(t2, V);
            if (F != null && F2 != null) {
                C3752t0.m13733V(t, V, Internal.m12793d(F, F2));
                m13967o0(t, i);
            } else if (F2 != null) {
                C3752t0.m13733V(t, V, F2);
                m13967o0(t, i);
            }
        }
    }

    /* renamed from: P */
    private void m13938P(T t, T t2, int i) {
        int t0 = m13977t0(i);
        int U = m13943U(i);
        long V = m13944V(t0);
        if (m13931I(t2, U, i)) {
            Object F = C3752t0.m13717F(t, V);
            Object F2 = C3752t0.m13717F(t2, V);
            if (F != null && F2 != null) {
                C3752t0.m13733V(t, V, Internal.m12793d(F, F2));
                m13969p0(t, U, i);
            } else if (F2 != null) {
                C3752t0.m13733V(t, V, F2);
                m13969p0(t, U, i);
            }
        }
    }

    /* renamed from: Q */
    private void m13939Q(T t, T t2, int i) {
        int t0 = m13977t0(i);
        long V = m13944V(t0);
        int U = m13943U(i);
        switch (m13975s0(t0)) {
            case 0:
                if (m13925C(t2, i)) {
                    C3752t0.m13729R(t, V, C3752t0.m13761z(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 1:
                if (m13925C(t2, i)) {
                    C3752t0.m13730S(t, V, C3752t0.m13712A(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 2:
                if (m13925C(t2, i)) {
                    C3752t0.m13732U(t, V, C3752t0.m13715D(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 3:
                if (m13925C(t2, i)) {
                    C3752t0.m13732U(t, V, C3752t0.m13715D(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 4:
                if (m13925C(t2, i)) {
                    C3752t0.m13731T(t, V, C3752t0.m13713B(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 5:
                if (m13925C(t2, i)) {
                    C3752t0.m13732U(t, V, C3752t0.m13715D(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 6:
                if (m13925C(t2, i)) {
                    C3752t0.m13731T(t, V, C3752t0.m13713B(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 7:
                if (m13925C(t2, i)) {
                    C3752t0.m13722K(t, V, C3752t0.m13754s(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 8:
                if (m13925C(t2, i)) {
                    C3752t0.m13733V(t, V, C3752t0.m13717F(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 9:
                m13937O(t, t2, i);
                return;
            case 10:
                if (m13925C(t2, i)) {
                    C3752t0.m13733V(t, V, C3752t0.m13717F(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 11:
                if (m13925C(t2, i)) {
                    C3752t0.m13731T(t, V, C3752t0.m13713B(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 12:
                if (m13925C(t2, i)) {
                    C3752t0.m13731T(t, V, C3752t0.m13713B(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 13:
                if (m13925C(t2, i)) {
                    C3752t0.m13731T(t, V, C3752t0.m13713B(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 14:
                if (m13925C(t2, i)) {
                    C3752t0.m13732U(t, V, C3752t0.m13715D(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 15:
                if (m13925C(t2, i)) {
                    C3752t0.m13731T(t, V, C3752t0.m13713B(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 16:
                if (m13925C(t2, i)) {
                    C3752t0.m13732U(t, V, C3752t0.m13715D(t2, V));
                    m13967o0(t, i);
                    return;
                }
                return;
            case 17:
                m13937O(t, t2, i);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f20895n.mo23983d(t, t2, V);
                return;
            case 50:
                C3726o0.m13529F(this.f20898q, t, t2, V);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (m13931I(t2, U, i)) {
                    C3752t0.m13733V(t, V, C3752t0.m13717F(t2, V));
                    m13969p0(t, U, i);
                    return;
                }
                return;
            case 60:
                m13938P(t, t2, i);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (m13931I(t2, U, i)) {
                    C3752t0.m13733V(t, V, C3752t0.m13717F(t2, V));
                    m13969p0(t, U, i);
                    return;
                }
                return;
            case 68:
                m13938P(t, t2, i);
                return;
            default:
                return;
        }
    }

    /* renamed from: R */
    static <T> C3769z<T> m13940R(Class<T> cls, C3766w wVar, C3688b0 b0Var, C3738q qVar, C3746r0<?, ?> r0Var, C3710j<?> jVar, C3751t tVar) {
        if (wVar instanceof C3711j0) {
            return m13942T((C3711j0) wVar, b0Var, qVar, r0Var, jVar, tVar);
        }
        return m13941S((StructuralMessageInfo) wVar, b0Var, qVar, r0Var, jVar, tVar);
    }

    /* renamed from: S */
    static <T> C3769z<T> m13941S(StructuralMessageInfo structuralMessageInfo, C3688b0 b0Var, C3738q qVar, C3746r0<?, ?> r0Var, C3710j<?> jVar, C3751t tVar) {
        int i;
        int i2;
        int i3;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] d = structuralMessageInfo.mo23612d();
        if (d.length == 0) {
            i2 = 0;
            i = 0;
        } else {
            i2 = d[0].mo23249n();
            i = d[d.length - 1].mo23249n();
        }
        int length = d.length;
        int[] iArr = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i4 = 0;
        int i5 = 0;
        for (FieldInfo fieldInfo : d) {
            if (fieldInfo.mo23255t() == FieldType.MAP) {
                i4++;
            } else if (fieldInfo.mo23255t().mo23307id() >= 18 && fieldInfo.mo23255t().mo23307id() <= 49) {
                i5++;
            }
        }
        int[] iArr2 = null;
        int[] iArr3 = i4 > 0 ? new int[i4] : null;
        if (i5 > 0) {
            iArr2 = new int[i5];
        }
        int[] c = structuralMessageInfo.mo23611c();
        if (c == null) {
            c = f20880r;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i6 < d.length) {
            FieldInfo fieldInfo2 = d[i6];
            int n = fieldInfo2.mo23249n();
            m13973r0(fieldInfo2, iArr, i7, z, objArr);
            if (i8 < c.length && c[i8] == n) {
                c[i8] = i7;
                i8++;
            }
            if (fieldInfo2.mo23255t() == FieldType.MAP) {
                iArr3[i9] = i7;
                i9++;
            } else if (fieldInfo2.mo23255t().mo23307id() >= 18 && fieldInfo2.mo23255t().mo23307id() <= 49) {
                i3 = i7;
                iArr2[i10] = (int) C3752t0.m13721J(fieldInfo2.mo23248m());
                i10++;
                i6++;
                i7 = i3 + 3;
            }
            i3 = i7;
            i6++;
            i7 = i3 + 3;
        }
        if (iArr3 == null) {
            iArr3 = f20880r;
        }
        if (iArr2 == null) {
            iArr2 = f20880r;
        }
        int[] iArr4 = new int[(c.length + iArr3.length + iArr2.length)];
        System.arraycopy(c, 0, iArr4, 0, c.length);
        System.arraycopy(iArr3, 0, iArr4, c.length, iArr3.length);
        System.arraycopy(iArr2, 0, iArr4, c.length + iArr3.length, iArr2.length);
        return new C3769z(iArr, objArr, i2, i, structuralMessageInfo.mo23610b(), z, true, iArr4, c.length, c.length + iArr3.length, b0Var, qVar, r0Var, jVar, tVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x033d  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0392  */
    /* renamed from: T */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.protobuf.C3769z<T> m13942T(com.google.protobuf.C3711j0 r36, com.google.protobuf.C3688b0 r37, com.google.protobuf.C3738q r38, com.google.protobuf.C3746r0<?, ?> r39, com.google.protobuf.C3710j<?> r40, com.google.protobuf.C3751t r41) {
        /*
            com.google.protobuf.ProtoSyntax r0 = r36.getSyntax()
            com.google.protobuf.ProtoSyntax r1 = com.google.protobuf.ProtoSyntax.PROTO3
            r2 = 0
            if (r0 != r1) goto L_0x000b
            r10 = 1
            goto L_0x000c
        L_0x000b:
            r10 = 0
        L_0x000c:
            java.lang.String r0 = r36.mo23902d()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r6) goto L_0x0035
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r7 = 1
            r8 = 13
        L_0x0022:
            int r9 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0032
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r8
            r4 = r4 | r7
            int r8 = r8 + 13
            r7 = r9
            goto L_0x0022
        L_0x0032:
            int r7 = r7 << r8
            r4 = r4 | r7
            goto L_0x0036
        L_0x0035:
            r9 = 1
        L_0x0036:
            int r7 = r9 + 1
            char r8 = r0.charAt(r9)
            if (r8 < r6) goto L_0x0055
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0042:
            int r11 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0052
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r8 = r8 | r7
            int r9 = r9 + 13
            r7 = r11
            goto L_0x0042
        L_0x0052:
            int r7 = r7 << r9
            r8 = r8 | r7
            r7 = r11
        L_0x0055:
            if (r8 != 0) goto L_0x0062
            int[] r8 = f20880r
            r13 = r8
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            goto L_0x0177
        L_0x0062:
            int r8 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0081
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006e:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x007e
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r7 = r7 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x006e
        L_0x007e:
            int r8 = r8 << r9
            r7 = r7 | r8
            r8 = r11
        L_0x0081:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x00a0
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x008d:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x009d
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x008d
        L_0x009d:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00a0:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x00bf
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00ac:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00bc
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00ac
        L_0x00bc:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00bf:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00de
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00cb:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00db
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00cb
        L_0x00db:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00de:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00fd
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ea:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x00fa
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ea
        L_0x00fa:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00fd:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x011e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0109:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x011a
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0109
        L_0x011a:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x011e:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x0141
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x012a:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x013c
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x012a
        L_0x013c:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0141:
            int r16 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x0166
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r2 = r16
            r16 = 13
        L_0x014f:
            int r18 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r6) goto L_0x0161
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r16
            r15 = r15 | r2
            int r16 = r16 + 13
            r2 = r18
            goto L_0x014f
        L_0x0161:
            int r2 = r2 << r16
            r15 = r15 | r2
            r16 = r18
        L_0x0166:
            int r2 = r15 + r13
            int r2 = r2 + r14
            int[] r2 = new int[r2]
            int r14 = r7 * 2
            int r14 = r14 + r8
            r8 = r7
            r7 = r16
            r35 = r13
            r13 = r2
            r2 = r9
            r9 = r35
        L_0x0177:
            sun.misc.Unsafe r5 = f20881s
            java.lang.Object[] r18 = r36.mo23901c()
            com.google.protobuf.MessageLite r19 = r36.mo23610b()
            java.lang.Class r3 = r19.getClass()
            int r6 = r12 * 3
            int[] r6 = new int[r6]
            int r12 = r12 * 2
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r21 = r15 + r9
            r23 = r15
            r24 = r21
            r9 = 0
            r22 = 0
        L_0x0196:
            if (r7 >= r1) goto L_0x03e6
            int r25 = r7 + 1
            char r7 = r0.charAt(r7)
            r26 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r1) goto L_0x01ca
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r1 = r25
            r25 = 13
        L_0x01ab:
            int r27 = r1 + 1
            char r1 = r0.charAt(r1)
            r28 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r15) goto L_0x01c4
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r25
            r7 = r7 | r1
            int r25 = r25 + 13
            r1 = r27
            r15 = r28
            goto L_0x01ab
        L_0x01c4:
            int r1 = r1 << r25
            r7 = r7 | r1
            r1 = r27
            goto L_0x01ce
        L_0x01ca:
            r28 = r15
            r1 = r25
        L_0x01ce:
            int r15 = r1 + 1
            char r1 = r0.charAt(r1)
            r25 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r15) goto L_0x0200
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r15 = r25
            r25 = 13
        L_0x01e1:
            int r27 = r15 + 1
            char r15 = r0.charAt(r15)
            r29 = r10
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x01fa
            r10 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r25
            r1 = r1 | r10
            int r25 = r25 + 13
            r15 = r27
            r10 = r29
            goto L_0x01e1
        L_0x01fa:
            int r10 = r15 << r25
            r1 = r1 | r10
            r15 = r27
            goto L_0x0204
        L_0x0200:
            r29 = r10
            r15 = r25
        L_0x0204:
            r10 = r1 & 255(0xff, float:3.57E-43)
            r25 = r11
            r11 = r1 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0211
            int r11 = r9 + 1
            r13[r9] = r22
            r9 = r11
        L_0x0211:
            r11 = 51
            r31 = r9
            if (r10 < r11) goto L_0x02b1
            int r11 = r15 + 1
            char r15 = r0.charAt(r15)
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r9) goto L_0x0240
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r33 = 13
        L_0x0226:
            int r34 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r9) goto L_0x023b
            r9 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r33
            r15 = r15 | r9
            int r33 = r33 + 13
            r11 = r34
            r9 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0226
        L_0x023b:
            int r9 = r11 << r33
            r15 = r15 | r9
            r11 = r34
        L_0x0240:
            int r9 = r10 + -51
            r33 = r11
            r11 = 9
            if (r9 == r11) goto L_0x0262
            r11 = 17
            if (r9 != r11) goto L_0x024d
            goto L_0x0262
        L_0x024d:
            r11 = 12
            if (r9 != r11) goto L_0x026f
            r9 = r4 & 1
            r11 = 1
            if (r9 != r11) goto L_0x026f
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r11
            int r11 = r14 + 1
            r14 = r18[r14]
            r12[r9] = r14
            goto L_0x026e
        L_0x0262:
            int r9 = r22 / 3
            int r9 = r9 * 2
            r11 = 1
            int r9 = r9 + r11
            int r11 = r14 + 1
            r14 = r18[r14]
            r12[r9] = r14
        L_0x026e:
            r14 = r11
        L_0x026f:
            int r15 = r15 * 2
            r9 = r18[r15]
            boolean r11 = r9 instanceof java.lang.reflect.Field
            if (r11 == 0) goto L_0x027a
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0282
        L_0x027a:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = m13965n0(r3, r9)
            r18[r15] = r9
        L_0x0282:
            r11 = r6
            r34 = r7
            long r6 = r5.objectFieldOffset(r9)
            int r7 = (int) r6
            int r15 = r15 + 1
            r6 = r18[r15]
            boolean r9 = r6 instanceof java.lang.reflect.Field
            if (r9 == 0) goto L_0x0295
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            goto L_0x029d
        L_0x0295:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = m13965n0(r3, r6)
            r18[r15] = r6
        L_0x029d:
            r9 = r7
            long r6 = r5.objectFieldOffset(r6)
            int r7 = (int) r6
            r32 = r0
            r19 = r3
            r0 = r4
            r4 = r7
            r7 = r9
            r9 = r10
            r6 = r14
            r14 = r33
            r15 = 0
            goto L_0x03a9
        L_0x02b1:
            r11 = r6
            r34 = r7
            int r6 = r14 + 1
            r7 = r18[r14]
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = m13965n0(r3, r7)
            r9 = 49
            r14 = 9
            if (r10 == r14) goto L_0x0326
            r14 = 17
            if (r10 != r14) goto L_0x02c9
            goto L_0x0326
        L_0x02c9:
            r14 = 27
            if (r10 == r14) goto L_0x0316
            if (r10 != r9) goto L_0x02d0
            goto L_0x0316
        L_0x02d0:
            r14 = 12
            if (r10 == r14) goto L_0x0305
            r14 = 30
            if (r10 == r14) goto L_0x0305
            r14 = 44
            if (r10 != r14) goto L_0x02dd
            goto L_0x0305
        L_0x02dd:
            r14 = 50
            if (r10 != r14) goto L_0x0303
            int r14 = r23 + 1
            r13[r23] = r22
            int r23 = r22 / 3
            int r23 = r23 * 2
            int r27 = r6 + 1
            r6 = r18[r6]
            r12[r23] = r6
            r6 = r1 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x02fe
            int r23 = r23 + 1
            int r6 = r27 + 1
            r27 = r18[r27]
            r12[r23] = r27
            r23 = r14
            goto L_0x0332
        L_0x02fe:
            r23 = r14
            r6 = r27
            goto L_0x0332
        L_0x0303:
            r9 = 1
            goto L_0x0332
        L_0x0305:
            r14 = r4 & 1
            r9 = 1
            if (r14 != r9) goto L_0x0332
            int r14 = r22 / 3
            int r14 = r14 * 2
            int r14 = r14 + r9
            int r20 = r6 + 1
            r6 = r18[r6]
            r12[r14] = r6
            goto L_0x0322
        L_0x0316:
            r9 = 1
            int r14 = r22 / 3
            int r14 = r14 * 2
            int r14 = r14 + r9
            int r20 = r6 + 1
            r6 = r18[r6]
            r12[r14] = r6
        L_0x0322:
            r14 = r10
            r6 = r20
            goto L_0x0333
        L_0x0326:
            r9 = 1
            int r14 = r22 / 3
            int r14 = r14 * 2
            int r14 = r14 + r9
            java.lang.Class r20 = r7.getType()
            r12[r14] = r20
        L_0x0332:
            r14 = r10
        L_0x0333:
            long r9 = r5.objectFieldOffset(r7)
            int r7 = (int) r9
            r9 = r4 & 1
            r10 = 1
            if (r9 != r10) goto L_0x0392
            r9 = r14
            r14 = 17
            if (r9 > r14) goto L_0x038c
            int r14 = r15 + 1
            char r15 = r0.charAt(r15)
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x0368
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x0351:
            int r30 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r10) goto L_0x0363
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r19
            r15 = r15 | r14
            int r19 = r19 + 13
            r14 = r30
            goto L_0x0351
        L_0x0363:
            int r14 = r14 << r19
            r15 = r15 | r14
            r14 = r30
        L_0x0368:
            int r19 = r8 * 2
            int r30 = r15 / 32
            int r19 = r19 + r30
            r10 = r18[r19]
            r32 = r0
            boolean r0 = r10 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0379
            java.lang.reflect.Field r10 = (java.lang.reflect.Field) r10
            goto L_0x0381
        L_0x0379:
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = m13965n0(r3, r10)
            r18[r19] = r10
        L_0x0381:
            r19 = r3
            r0 = r4
            long r3 = r5.objectFieldOffset(r10)
            int r4 = (int) r3
            int r15 = r15 % 32
            goto L_0x039b
        L_0x038c:
            r32 = r0
            r19 = r3
            r0 = r4
            goto L_0x0398
        L_0x0392:
            r32 = r0
            r19 = r3
            r0 = r4
            r9 = r14
        L_0x0398:
            r14 = r15
            r4 = 0
            r15 = 0
        L_0x039b:
            r3 = 18
            if (r9 < r3) goto L_0x03a9
            r3 = 49
            if (r9 > r3) goto L_0x03a9
            int r3 = r24 + 1
            r13[r24] = r7
            r24 = r3
        L_0x03a9:
            int r3 = r22 + 1
            r11[r22] = r34
            int r10 = r3 + 1
            r22 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03b8
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03b9
        L_0x03b8:
            r0 = 0
        L_0x03b9:
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x03c0
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c1
        L_0x03c0:
            r1 = 0
        L_0x03c1:
            r0 = r0 | r1
            int r1 = r9 << 20
            r0 = r0 | r1
            r0 = r0 | r7
            r11[r3] = r0
            int r0 = r10 + 1
            int r1 = r15 << 20
            r1 = r1 | r4
            r11[r10] = r1
            r7 = r14
            r3 = r19
            r4 = r22
            r1 = r26
            r15 = r28
            r10 = r29
            r9 = r31
            r22 = r0
            r14 = r6
            r6 = r11
            r11 = r25
            r0 = r32
            goto L_0x0196
        L_0x03e6:
            r29 = r10
            r25 = r11
            r28 = r15
            r11 = r6
            com.google.protobuf.z r0 = new com.google.protobuf.z
            com.google.protobuf.MessageLite r9 = r36.mo23610b()
            r1 = 0
            r4 = r0
            r5 = r11
            r6 = r12
            r7 = r2
            r8 = r25
            r11 = r1
            r12 = r13
            r13 = r28
            r14 = r21
            r15 = r37
            r16 = r38
            r17 = r39
            r18 = r40
            r19 = r41
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.m13942T(com.google.protobuf.j0, com.google.protobuf.b0, com.google.protobuf.q, com.google.protobuf.r0, com.google.protobuf.j, com.google.protobuf.t):com.google.protobuf.z");
    }

    /* renamed from: U */
    private int m13943U(int i) {
        return this.f20882a[i];
    }

    /* renamed from: V */
    private static long m13944V(int i) {
        return (long) (i & 1048575);
    }

    /* renamed from: W */
    private static <T> boolean m13945W(T t, long j) {
        return ((Boolean) C3752t0.m13717F(t, j)).booleanValue();
    }

    /* renamed from: X */
    private static <T> double m13946X(T t, long j) {
        return ((Double) C3752t0.m13717F(t, j)).doubleValue();
    }

    /* renamed from: Y */
    private static <T> float m13947Y(T t, long j) {
        return ((Float) C3752t0.m13717F(t, j)).floatValue();
    }

    /* renamed from: Z */
    private static <T> int m13948Z(T t, long j) {
        return ((Integer) C3752t0.m13717F(t, j)).intValue();
    }

    /* renamed from: a0 */
    private static <T> long m13949a0(T t, long j) {
        return ((Long) C3752t0.m13717F(t, j)).longValue();
    }

    /* renamed from: b0 */
    private <K, V> int m13950b0(T t, byte[] bArr, int i, int i2, int i3, long j, C3689c.C3691b bVar) {
        T t2 = t;
        long j2 = j;
        Unsafe unsafe = f20881s;
        int i4 = i3;
        Object u = m13978u(i3);
        Object object = unsafe.getObject(t, j2);
        if (this.f20898q.mo24037g(object)) {
            Object e = this.f20898q.mo24035e(u);
            this.f20898q.mo24031a(e, object);
            unsafe.putObject(t, j2, e);
            object = e;
        }
        return m13962m(bArr, i, i2, this.f20898q.mo24033c(u), this.f20898q.mo24034d(object), bVar);
    }

    /* renamed from: c0 */
    private int m13951c0(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C3689c.C3691b bVar) {
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        C3689c.C3691b bVar2 = bVar;
        Unsafe unsafe = f20881s;
        long j3 = (long) (this.f20882a[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(C3689c.m13175d(bArr, i)));
                    int i14 = i9 + 8;
                    unsafe.putInt(t2, j3, i11);
                    return i14;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(C3689c.m13183l(bArr, i)));
                    int i15 = i9 + 4;
                    unsafe.putInt(t2, j3, i11);
                    return i15;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int L = C3689c.m13169L(bArr2, i9, bVar2);
                    unsafe.putObject(t2, j2, Long.valueOf(bVar2.f20753b));
                    unsafe.putInt(t2, j3, i11);
                    return L;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int I = C3689c.m13166I(bArr2, i9, bVar2);
                    unsafe.putObject(t2, j2, Integer.valueOf(bVar2.f20752a));
                    unsafe.putInt(t2, j3, i11);
                    return I;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(C3689c.m13181j(bArr, i)));
                    int i16 = i9 + 8;
                    unsafe.putInt(t2, j3, i11);
                    return i16;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(C3689c.m13179h(bArr, i)));
                    int i17 = i9 + 4;
                    unsafe.putInt(t2, j3, i11);
                    return i17;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int L2 = C3689c.m13169L(bArr2, i9, bVar2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(bVar2.f20753b != 0));
                    unsafe.putInt(t2, j3, i11);
                    return L2;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int I2 = C3689c.m13166I(bArr2, i9, bVar2);
                    int i18 = bVar2.f20752a;
                    if (i18 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & 536870912) == 0 || C3759u0.m13854u(bArr2, I2, I2 + i18)) {
                        unsafe.putObject(t2, j2, new String(bArr2, I2, i18, Internal.f20591a));
                        I2 += i18;
                    } else {
                        throw InvalidProtocolBufferException.m12801c();
                    }
                    unsafe.putInt(t2, j3, i11);
                    return I2;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int p = C3689c.m13187p(m13980v(i13), bArr2, i9, i2, bVar2);
                    Object object = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, bVar2.f20754c);
                    } else {
                        unsafe.putObject(t2, j2, Internal.m12793d(object, bVar2.f20754c));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return p;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int b = C3689c.m13173b(bArr2, i9, bVar2);
                    unsafe.putObject(t2, j2, bVar2.f20754c);
                    unsafe.putInt(t2, j3, i11);
                    return b;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int I3 = C3689c.m13166I(bArr2, i9, bVar2);
                    int i19 = bVar2.f20752a;
                    Internal.EnumVerifier t3 = m13976t(i13);
                    if (t3 == null || t3.isInRange(i19)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i19));
                        unsafe.putInt(t2, j3, i11);
                    } else {
                        m13982w(t).mo23698n(i10, Long.valueOf((long) i19));
                    }
                    return I3;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int I4 = C3689c.m13166I(bArr2, i9, bVar2);
                    unsafe.putObject(t2, j2, Integer.valueOf(CodedInputStream.decodeZigZag32(bVar2.f20752a)));
                    unsafe.putInt(t2, j3, i11);
                    return I4;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int L3 = C3689c.m13169L(bArr2, i9, bVar2);
                    unsafe.putObject(t2, j2, Long.valueOf(CodedInputStream.decodeZigZag64(bVar2.f20753b)));
                    unsafe.putInt(t2, j3, i11);
                    return L3;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int n = C3689c.m13185n(m13980v(i13), bArr, i, i2, (i10 & -8) | 4, bVar);
                    Object object2 = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j2, bVar2.f20754c);
                    } else {
                        unsafe.putObject(t2, j2, Internal.m12793d(object2, bVar2.f20754c));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return n;
                }
                break;
        }
        return i9;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0105, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0137, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0153, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0155, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01dc, code lost:
        if (r0 != r15) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x020a, code lost:
        if (r0 != r15) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0229, code lost:
        if (r0 != r15) goto L_0x023d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: e0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m13952e0(T r28, byte[] r29, int r30, int r31, com.google.protobuf.C3689c.C3691b r32) {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            sun.misc.Unsafe r9 = f20881s
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0013:
            if (r0 >= r13) goto L_0x0250
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0025
            int r0 = com.google.protobuf.C3689c.m13165H(r0, r12, r3, r11)
            int r3 = r11.f20752a
            r8 = r0
            r17 = r3
            goto L_0x0028
        L_0x0025:
            r17 = r0
            r8 = r3
        L_0x0028:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0035
            int r2 = r2 / 3
            int r0 = r15.m13955h0(r7, r2)
            goto L_0x0039
        L_0x0035:
            int r0 = r15.m13954g0(r7)
        L_0x0039:
            r4 = r0
            if (r4 != r10) goto L_0x0047
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x022d
        L_0x0047:
            int[] r0 = r15.f20882a
            int r1 = r4 + 1
            r5 = r0[r1]
            int r3 = m13975s0(r5)
            long r1 = m13944V(r5)
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0161
            r0 = 1
            switch(r3) {
                case 0: goto L_0x0148;
                case 1: goto L_0x0139;
                case 2: goto L_0x0127;
                case 3: goto L_0x0127;
                case 4: goto L_0x0119;
                case 5: goto L_0x0109;
                case 6: goto L_0x00f8;
                case 7: goto L_0x00e2;
                case 8: goto L_0x00cb;
                case 9: goto L_0x00aa;
                case 10: goto L_0x009d;
                case 11: goto L_0x0119;
                case 12: goto L_0x008e;
                case 13: goto L_0x00f8;
                case 14: goto L_0x0109;
                case 15: goto L_0x007b;
                case 16: goto L_0x0060;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x019e
        L_0x0060:
            if (r6 != 0) goto L_0x019e
            int r6 = com.google.protobuf.C3689c.m13169L(r12, r8, r11)
            r19 = r1
            long r0 = r11.f20753b
            long r21 = com.google.protobuf.CodedInputStream.decodeZigZag64(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x0137
        L_0x007b:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0159
            int r0 = com.google.protobuf.C3689c.m13166I(r12, r8, r11)
            int r1 = r11.f20752a
            int r1 = com.google.protobuf.CodedInputStream.decodeZigZag32(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x0155
        L_0x008e:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0159
            int r0 = com.google.protobuf.C3689c.m13166I(r12, r8, r11)
            int r1 = r11.f20752a
            r9.putInt(r14, r2, r1)
            goto L_0x0155
        L_0x009d:
            r2 = r1
            if (r6 != r10) goto L_0x019e
            int r0 = com.google.protobuf.C3689c.m13173b(r12, r8, r11)
            java.lang.Object r1 = r11.f20754c
            r9.putObject(r14, r2, r1)
            goto L_0x0105
        L_0x00aa:
            r2 = r1
            if (r6 != r10) goto L_0x019e
            com.google.protobuf.m0 r0 = r15.m13980v(r4)
            int r0 = com.google.protobuf.C3689c.m13187p(r0, r12, r8, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c1
            java.lang.Object r1 = r11.f20754c
            r9.putObject(r14, r2, r1)
            goto L_0x0105
        L_0x00c1:
            java.lang.Object r5 = r11.f20754c
            java.lang.Object r1 = com.google.protobuf.Internal.m12793d(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x0105
        L_0x00cb:
            r2 = r1
            if (r6 != r10) goto L_0x019e
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00d8
            int r0 = com.google.protobuf.C3689c.m13160C(r12, r8, r11)
            goto L_0x00dc
        L_0x00d8:
            int r0 = com.google.protobuf.C3689c.m13163F(r12, r8, r11)
        L_0x00dc:
            java.lang.Object r1 = r11.f20754c
            r9.putObject(r14, r2, r1)
            goto L_0x0105
        L_0x00e2:
            r2 = r1
            if (r6 != 0) goto L_0x019e
            int r1 = com.google.protobuf.C3689c.m13169L(r12, r8, r11)
            long r5 = r11.f20753b
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00f2
            goto L_0x00f3
        L_0x00f2:
            r0 = 0
        L_0x00f3:
            com.google.protobuf.C3752t0.m13722K(r14, r2, r0)
            r0 = r1
            goto L_0x0105
        L_0x00f8:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x019e
            int r0 = com.google.protobuf.C3689c.m13179h(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x0105:
            r2 = r4
            r1 = r7
            goto L_0x024d
        L_0x0109:
            r2 = r1
            if (r6 != r0) goto L_0x019e
            long r5 = com.google.protobuf.C3689c.m13181j(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x0153
        L_0x0119:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0159
            int r0 = com.google.protobuf.C3689c.m13166I(r12, r8, r11)
            int r1 = r11.f20752a
            r9.putInt(r14, r2, r1)
            goto L_0x0155
        L_0x0127:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0159
            int r6 = com.google.protobuf.C3689c.m13169L(r12, r8, r11)
            long r4 = r11.f20753b
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x0137:
            r0 = r6
            goto L_0x0155
        L_0x0139:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x0159
            float r0 = com.google.protobuf.C3689c.m13183l(r12, r8)
            com.google.protobuf.C3752t0.m13730S(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x0155
        L_0x0148:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x0159
            double r0 = com.google.protobuf.C3689c.m13175d(r12, r8)
            com.google.protobuf.C3752t0.m13729R(r14, r2, r0)
        L_0x0153:
            int r0 = r8 + 8
        L_0x0155:
            r1 = r7
            r2 = r10
            goto L_0x024d
        L_0x0159:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01a5
        L_0x0161:
            r0 = 27
            if (r3 != r0) goto L_0x01a9
            if (r6 != r10) goto L_0x019e
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.protobuf.Internal$ProtobufList r0 = (com.google.protobuf.Internal.ProtobufList) r0
            boolean r3 = r0.isModifiable()
            if (r3 != 0) goto L_0x0185
            int r3 = r0.size()
            if (r3 != 0) goto L_0x017c
            r3 = 10
            goto L_0x017e
        L_0x017c:
            int r3 = r3 * 2
        L_0x017e:
            com.google.protobuf.Internal$ProtobufList r0 = r0.mutableCopyWithCapacity(r3)
            r9.putObject(r14, r1, r0)
        L_0x0185:
            r5 = r0
            com.google.protobuf.m0 r0 = r15.m13980v(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.protobuf.C3689c.m13188q(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x024d
        L_0x019e:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01a5:
            r26 = -1
            goto L_0x020d
        L_0x01a9:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e0
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.m13953f0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x022c
        L_0x01de:
            goto L_0x023d
        L_0x01e0:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x020f
            r7 = r30
            if (r7 != r10) goto L_0x020d
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.m13950b0(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x022c
            goto L_0x01de
        L_0x020d:
            r2 = r15
            goto L_0x022d
        L_0x020f:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.m13951c0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x022c
            goto L_0x01de
        L_0x022c:
            r2 = r0
        L_0x022d:
            com.google.protobuf.UnknownFieldSetLite r4 = m13982w(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.protobuf.C3689c.m13164G(r0, r1, r2, r3, r4, r5)
        L_0x023d:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
        L_0x024d:
            r10 = -1
            goto L_0x0013
        L_0x0250:
            r1 = r13
            if (r0 != r1) goto L_0x0254
            return r0
        L_0x0254:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.m12805g()
            goto L_0x025a
        L_0x0259:
            throw r0
        L_0x025a:
            goto L_0x0259
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.m13952e0(java.lang.Object, byte[], int, int, com.google.protobuf.c$b):int");
    }

    /* renamed from: f0 */
    private int m13953f0(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, C3689c.C3691b bVar) {
        int i8;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i5;
        int i11 = i6;
        long j3 = j2;
        C3689c.C3691b bVar2 = bVar;
        Unsafe unsafe = f20881s;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t, j3);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j3, protobufList);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i10 == 2) {
                    return C3689c.m13190s(bArr, i9, protobufList, bVar2);
                }
                if (i10 == 1) {
                    return C3689c.m13176e(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 19:
            case 36:
                if (i10 == 2) {
                    return C3689c.m13193v(bArr, i9, protobufList, bVar2);
                }
                if (i10 == 5) {
                    return C3689c.m13184m(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i10 == 2) {
                    return C3689c.m13197z(bArr, i9, protobufList, bVar2);
                }
                if (i10 == 0) {
                    return C3689c.m13170M(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i10 == 2) {
                    return C3689c.m13196y(bArr, i9, protobufList, bVar2);
                }
                if (i10 == 0) {
                    return C3689c.m13167J(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i10 == 2) {
                    return C3689c.m13192u(bArr, i9, protobufList, bVar2);
                }
                if (i10 == 1) {
                    return C3689c.m13182k(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i10 == 2) {
                    return C3689c.m13191t(bArr, i9, protobufList, bVar2);
                }
                if (i10 == 5) {
                    return C3689c.m13180i(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 25:
            case 42:
                if (i10 == 2) {
                    return C3689c.m13189r(bArr, i9, protobufList, bVar2);
                }
                if (i10 == 0) {
                    return C3689c.m13172a(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 26:
                if (i10 == 2) {
                    if ((j & 536870912) == 0) {
                        return C3689c.m13161D(i3, bArr, i, i2, protobufList, bVar);
                    }
                    return C3689c.m13162E(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 27:
                if (i10 == 2) {
                    return C3689c.m13188q(m13980v(i11), i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 28:
                if (i10 == 2) {
                    return C3689c.m13174c(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 30:
            case 44:
                if (i10 == 2) {
                    i8 = C3689c.m13196y(bArr, i9, protobufList, bVar2);
                } else if (i10 == 0) {
                    i8 = C3689c.m13167J(i3, bArr, i, i2, protobufList, bVar);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t2;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) C3726o0.m13524A(i4, protobufList, m13976t(i11), unknownFieldSetLite, this.f20896o);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return i8;
            case 33:
            case 47:
                if (i10 == 2) {
                    return C3689c.m13194w(bArr, i9, protobufList, bVar2);
                }
                if (i10 == 0) {
                    return C3689c.m13158A(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 34:
            case 48:
                if (i10 == 2) {
                    return C3689c.m13195x(bArr, i9, protobufList, bVar2);
                }
                if (i10 == 0) {
                    return C3689c.m13159B(i3, bArr, i, i2, protobufList, bVar);
                }
                break;
            case 49:
                if (i10 == 3) {
                    return C3689c.m13186o(m13980v(i11), i3, bArr, i, i2, protobufList, bVar);
                }
                break;
        }
        return i9;
    }

    /* renamed from: g0 */
    private int m13954g0(int i) {
        if (i < this.f20884c || i > this.f20885d) {
            return -1;
        }
        return m13971q0(i, 0);
    }

    /* renamed from: h0 */
    private int m13955h0(int i, int i2) {
        if (i < this.f20884c || i > this.f20885d) {
            return -1;
        }
        return m13971q0(i, i2);
    }

    /* renamed from: i0 */
    private int m13956i0(int i) {
        return this.f20882a[i + 2];
    }

    /* renamed from: j0 */
    private <E> void m13957j0(Object obj, long j, C3714k0 k0Var, C3722m0<E> m0Var, ExtensionRegistryLite extensionRegistryLite) {
        k0Var.mo23839h(this.f20895n.mo23984e(obj, j), m0Var, extensionRegistryLite);
    }

    /* renamed from: k */
    private boolean m13958k(T t, T t2, int i) {
        return m13925C(t, i) == m13925C(t2, i);
    }

    /* renamed from: k0 */
    private <E> void m13959k0(Object obj, int i, C3714k0 k0Var, C3722m0<E> m0Var, ExtensionRegistryLite extensionRegistryLite) {
        k0Var.mo23844m(this.f20895n.mo23984e(obj, m13944V(i)), m0Var, extensionRegistryLite);
    }

    /* renamed from: l */
    private static <T> boolean m13960l(T t, long j) {
        return C3752t0.m13754s(t, j);
    }

    /* renamed from: l0 */
    private void m13961l0(Object obj, int i, C3714k0 k0Var) {
        if (m13924B(i)) {
            C3752t0.m13733V(obj, m13944V(i), k0Var.mo23826N());
        } else if (this.f20888g) {
            C3752t0.m13733V(obj, m13944V(i), k0Var.mo23835e());
        } else {
            C3752t0.m13733V(obj, m13944V(i), k0Var.mo23818F());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r0v6, types: [int, byte] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K, V> int m13962m(byte[] r15, int r16, int r17, com.google.protobuf.MapEntryLite.C3657b<K, V> r18, java.util.Map<K, V> r19, com.google.protobuf.C3689c.C3691b r20) {
        /*
            r14 = this;
            r7 = r15
            r8 = r17
            r9 = r18
            r0 = r16
            r10 = r20
            int r0 = com.google.protobuf.C3689c.m13166I(r15, r0, r10)
            int r1 = r10.f20752a
            if (r1 < 0) goto L_0x0081
            int r2 = r8 - r0
            if (r1 > r2) goto L_0x0081
            int r11 = r0 + r1
            K r1 = r9.f20629b
            V r2 = r9.f20631d
            r12 = r1
            r13 = r2
        L_0x001d:
            if (r0 >= r11) goto L_0x0074
            int r1 = r0 + 1
            byte r0 = r7[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.protobuf.C3689c.m13165H(r0, r15, r1, r10)
            int r1 = r10.f20752a
            r2 = r0
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            int r1 = r0 >>> 3
            r3 = r0 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0057
            r4 = 2
            if (r1 == r4) goto L_0x003a
            goto L_0x006f
        L_0x003a:
            com.google.protobuf.WireFormat$FieldType r1 = r9.f20630c
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x006f
            com.google.protobuf.WireFormat$FieldType r4 = r9.f20630c
            V r0 = r9.f20631d
            java.lang.Class r5 = r0.getClass()
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.m13964n(r1, r2, r3, r4, r5, r6)
            java.lang.Object r13 = r10.f20754c
            goto L_0x001d
        L_0x0057:
            com.google.protobuf.WireFormat$FieldType r1 = r9.f20628a
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x006f
            com.google.protobuf.WireFormat$FieldType r4 = r9.f20628a
            r5 = 0
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.m13964n(r1, r2, r3, r4, r5, r6)
            java.lang.Object r12 = r10.f20754c
            goto L_0x001d
        L_0x006f:
            int r0 = com.google.protobuf.C3689c.m13171N(r0, r15, r2, r8, r10)
            goto L_0x001d
        L_0x0074:
            if (r0 != r11) goto L_0x007c
            r0 = r19
            r0.put(r12, r13)
            return r11
        L_0x007c:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.m12805g()
            throw r0
        L_0x0081:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.m12808j()
            goto L_0x0087
        L_0x0086:
            throw r0
        L_0x0087:
            goto L_0x0086
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.m13962m(byte[], int, int, com.google.protobuf.MapEntryLite$b, java.util.Map, com.google.protobuf.c$b):int");
    }

    /* renamed from: m0 */
    private void m13963m0(Object obj, int i, C3714k0 k0Var) {
        if (m13924B(i)) {
            k0Var.mo23817E(this.f20895n.mo23984e(obj, m13944V(i)));
        } else {
            k0Var.mo23836f(this.f20895n.mo23984e(obj, m13944V(i)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r3 + 8;
     */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m13964n(byte[] r2, int r3, int r4, com.google.protobuf.WireFormat.FieldType r5, java.lang.Class<?> r6, com.google.protobuf.C3689c.C3691b r7) {
        /*
            r1 = this;
            int[] r0 = com.google.protobuf.C3769z.C3770a.f20899a
            int r5 = r5.ordinal()
            r5 = r0[r5]
            switch(r5) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "unsupported field type."
            r2.<init>(r3)
            throw r2
        L_0x0013:
            int r2 = com.google.protobuf.C3689c.m13163F(r2, r3, r7)
            goto L_0x00ae
        L_0x0019:
            int r2 = com.google.protobuf.C3689c.m13169L(r2, r3, r7)
            long r3 = r7.f20753b
            long r3 = com.google.protobuf.CodedInputStream.decodeZigZag64(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r7.f20754c = r3
            goto L_0x00ae
        L_0x002b:
            int r2 = com.google.protobuf.C3689c.m13166I(r2, r3, r7)
            int r3 = r7.f20752a
            int r3 = com.google.protobuf.CodedInputStream.decodeZigZag32(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.f20754c = r3
            goto L_0x00ae
        L_0x003d:
            com.google.protobuf.h0 r5 = com.google.protobuf.C3707h0.m13389a()
            com.google.protobuf.m0 r5 = r5.mo23886d(r6)
            int r2 = com.google.protobuf.C3689c.m13187p(r5, r2, r3, r4, r7)
            goto L_0x00ae
        L_0x004a:
            int r2 = com.google.protobuf.C3689c.m13169L(r2, r3, r7)
            long r3 = r7.f20753b
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r7.f20754c = r3
            goto L_0x00ae
        L_0x0057:
            int r2 = com.google.protobuf.C3689c.m13166I(r2, r3, r7)
            int r3 = r7.f20752a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.f20754c = r3
            goto L_0x00ae
        L_0x0064:
            float r2 = com.google.protobuf.C3689c.m13183l(r2, r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r7.f20754c = r2
            goto L_0x0084
        L_0x006f:
            long r4 = com.google.protobuf.C3689c.m13181j(r2, r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r7.f20754c = r2
            goto L_0x0091
        L_0x007a:
            int r2 = com.google.protobuf.C3689c.m13179h(r2, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r7.f20754c = r2
        L_0x0084:
            int r2 = r3 + 4
            goto L_0x00ae
        L_0x0087:
            double r4 = com.google.protobuf.C3689c.m13175d(r2, r3)
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r7.f20754c = r2
        L_0x0091:
            int r2 = r3 + 8
            goto L_0x00ae
        L_0x0094:
            int r2 = com.google.protobuf.C3689c.m13173b(r2, r3, r7)
            goto L_0x00ae
        L_0x0099:
            int r2 = com.google.protobuf.C3689c.m13169L(r2, r3, r7)
            long r3 = r7.f20753b
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r3 = 1
            goto L_0x00a8
        L_0x00a7:
            r3 = 0
        L_0x00a8:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r7.f20754c = r3
        L_0x00ae:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.m13964n(byte[], int, int, com.google.protobuf.WireFormat$FieldType, java.lang.Class, com.google.protobuf.c$b):int");
    }

    /* renamed from: n0 */
    private static Field m13965n0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* renamed from: o */
    private static <T> double m13966o(T t, long j) {
        return C3752t0.m13761z(t, j);
    }

    /* renamed from: o0 */
    private void m13967o0(T t, int i) {
        if (!this.f20889h) {
            int i0 = m13956i0(i);
            long j = (long) (i0 & 1048575);
            C3752t0.m13731T(t, j, C3752t0.m13713B(t, j) | (1 << (i0 >>> 20)));
        }
    }

    /* renamed from: p */
    private boolean m13968p(T t, T t2, int i) {
        int t0 = m13977t0(i);
        long V = m13944V(t0);
        switch (m13975s0(t0)) {
            case 0:
                if (!m13958k(t, t2, i) || Double.doubleToLongBits(C3752t0.m13761z(t, V)) != Double.doubleToLongBits(C3752t0.m13761z(t2, V))) {
                    return false;
                }
                return true;
            case 1:
                if (!m13958k(t, t2, i) || Float.floatToIntBits(C3752t0.m13712A(t, V)) != Float.floatToIntBits(C3752t0.m13712A(t2, V))) {
                    return false;
                }
                return true;
            case 2:
                if (!m13958k(t, t2, i) || C3752t0.m13715D(t, V) != C3752t0.m13715D(t2, V)) {
                    return false;
                }
                return true;
            case 3:
                if (!m13958k(t, t2, i) || C3752t0.m13715D(t, V) != C3752t0.m13715D(t2, V)) {
                    return false;
                }
                return true;
            case 4:
                if (!m13958k(t, t2, i) || C3752t0.m13713B(t, V) != C3752t0.m13713B(t2, V)) {
                    return false;
                }
                return true;
            case 5:
                if (!m13958k(t, t2, i) || C3752t0.m13715D(t, V) != C3752t0.m13715D(t2, V)) {
                    return false;
                }
                return true;
            case 6:
                if (!m13958k(t, t2, i) || C3752t0.m13713B(t, V) != C3752t0.m13713B(t2, V)) {
                    return false;
                }
                return true;
            case 7:
                if (!m13958k(t, t2, i) || C3752t0.m13754s(t, V) != C3752t0.m13754s(t2, V)) {
                    return false;
                }
                return true;
            case 8:
                if (!m13958k(t, t2, i) || !C3726o0.m13534K(C3752t0.m13717F(t, V), C3752t0.m13717F(t2, V))) {
                    return false;
                }
                return true;
            case 9:
                if (!m13958k(t, t2, i) || !C3726o0.m13534K(C3752t0.m13717F(t, V), C3752t0.m13717F(t2, V))) {
                    return false;
                }
                return true;
            case 10:
                if (!m13958k(t, t2, i) || !C3726o0.m13534K(C3752t0.m13717F(t, V), C3752t0.m13717F(t2, V))) {
                    return false;
                }
                return true;
            case 11:
                if (!m13958k(t, t2, i) || C3752t0.m13713B(t, V) != C3752t0.m13713B(t2, V)) {
                    return false;
                }
                return true;
            case 12:
                if (!m13958k(t, t2, i) || C3752t0.m13713B(t, V) != C3752t0.m13713B(t2, V)) {
                    return false;
                }
                return true;
            case 13:
                if (!m13958k(t, t2, i) || C3752t0.m13713B(t, V) != C3752t0.m13713B(t2, V)) {
                    return false;
                }
                return true;
            case 14:
                if (!m13958k(t, t2, i) || C3752t0.m13715D(t, V) != C3752t0.m13715D(t2, V)) {
                    return false;
                }
                return true;
            case 15:
                if (!m13958k(t, t2, i) || C3752t0.m13713B(t, V) != C3752t0.m13713B(t2, V)) {
                    return false;
                }
                return true;
            case 16:
                if (!m13958k(t, t2, i) || C3752t0.m13715D(t, V) != C3752t0.m13715D(t2, V)) {
                    return false;
                }
                return true;
            case 17:
                if (!m13958k(t, t2, i) || !C3726o0.m13534K(C3752t0.m13717F(t, V), C3752t0.m13717F(t2, V))) {
                    return false;
                }
                return true;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return C3726o0.m13534K(C3752t0.m13717F(t, V), C3752t0.m13717F(t2, V));
            case 50:
                return C3726o0.m13534K(C3752t0.m13717F(t, V), C3752t0.m13717F(t2, V));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!m13930H(t, t2, i) || !C3726o0.m13534K(C3752t0.m13717F(t, V), C3752t0.m13717F(t2, V))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    /* renamed from: p0 */
    private void m13969p0(T t, int i, int i2) {
        C3752t0.m13731T(t, (long) (m13956i0(i2) & 1048575), i);
    }

    /* renamed from: q */
    private final <UT, UB> UB m13970q(Object obj, int i, UB ub, C3746r0<UT, UB> r0Var) {
        Internal.EnumVerifier t;
        int U = m13943U(i);
        Object F = C3752t0.m13717F(obj, m13944V(m13977t0(i)));
        if (F == null || (t = m13976t(i)) == null) {
            return ub;
        }
        return m13972r(i, U, this.f20898q.mo24034d(F), t, ub, r0Var);
    }

    /* renamed from: q0 */
    private int m13971q0(int i, int i2) {
        int length = (this.f20882a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int U = m13943U(i4);
            if (i == U) {
                return i4;
            }
            if (i < U) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* renamed from: r */
    private final <K, V, UT, UB> UB m13972r(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, C3746r0<UT, UB> r0Var) {
        MapEntryLite.C3657b<?, ?> c = this.f20898q.mo24033c(m13978u(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = r0Var.mo24008n();
                }
                ByteString.C3606g f = ByteString.m12407f(MapEntryLite.m12848a(c, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.m12851e(f.mo22971b(), c, next.getKey(), next.getValue());
                    r0Var.mo23998d(ub, i2, f.mo22970a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* renamed from: r0 */
    private static void m13973r0(FieldInfo fieldInfo, int[] iArr, int i, boolean z, Object[] objArr) {
        int i2;
        int i3;
        C3702f0 q = fieldInfo.mo23252q();
        if (q == null) {
            FieldType t = fieldInfo.mo23255t();
            int J = (int) C3752t0.m13721J(fieldInfo.mo23248m());
            int id = t.mo23307id();
            int i4 = 0;
            if (z || t.isList() || t.isMap()) {
                if (fieldInfo.mo23246k() == null) {
                    i2 = 0;
                } else {
                    i2 = (int) C3752t0.m13721J(fieldInfo.mo23246k());
                }
                i3 = 0;
            } else {
                i2 = (int) C3752t0.m13721J(fieldInfo.mo23253r());
                i3 = Integer.numberOfTrailingZeros(fieldInfo.mo23254s());
            }
            iArr[i] = fieldInfo.mo23249n();
            int i5 = i + 1;
            int i6 = fieldInfo.mo23256u() ? 536870912 : 0;
            if (fieldInfo.mo23257w()) {
                i4 = 268435456;
            }
            iArr[i5] = (id << 20) | i4 | i6 | J;
            iArr[i + 2] = i2 | (i3 << 20);
            Class<?> p = fieldInfo.mo23251p();
            if (fieldInfo.mo23250o() != null) {
                int i7 = (i / 3) * 2;
                objArr[i7] = fieldInfo.mo23250o();
                if (p != null) {
                    objArr[i7 + 1] = p;
                } else if (fieldInfo.mo23247l() != null) {
                    objArr[i7 + 1] = fieldInfo.mo23247l();
                }
            } else if (p != null) {
                objArr[((i / 3) * 2) + 1] = p;
            } else if (fieldInfo.mo23247l() != null) {
                objArr[((i / 3) * 2) + 1] = fieldInfo.mo23247l();
            }
        } else {
            fieldInfo.mo23255t().mo23307id();
            q.mo23875a();
            throw null;
        }
    }

    /* renamed from: s */
    private static <T> float m13974s(T t, long j) {
        return C3752t0.m13712A(t, j);
    }

    /* renamed from: s0 */
    private static int m13975s0(int i) {
        return (i & 267386880) >>> 20;
    }

    /* renamed from: t */
    private Internal.EnumVerifier m13976t(int i) {
        return (Internal.EnumVerifier) this.f20883b[((i / 3) * 2) + 1];
    }

    /* renamed from: t0 */
    private int m13977t0(int i) {
        return this.f20882a[i + 1];
    }

    /* renamed from: u */
    private Object m13978u(int i) {
        return this.f20883b[(i / 3) * 2];
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* renamed from: u0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13979u0(T r18, com.google.protobuf.Writer r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f20887f
            if (r3 == 0) goto L_0x0021
            com.google.protobuf.j<?> r3 = r0.f20897p
            com.google.protobuf.FieldSet r3 = r3.mo23893c(r1)
            boolean r5 = r3.mo23293r()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.mo23296w()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            r6 = -1
            int[] r7 = r0.f20882a
            int r7 = r7.length
            sun.misc.Unsafe r8 = f20881s
            r10 = 0
            r11 = 0
        L_0x002b:
            if (r10 >= r7) goto L_0x049a
            int r12 = r0.m13977t0(r10)
            int r13 = r0.m13943U(r10)
            int r14 = m13975s0(r12)
            boolean r15 = r0.f20889h
            if (r15 != 0) goto L_0x005e
            r15 = 17
            if (r14 > r15) goto L_0x005e
            int[] r15 = r0.f20882a
            int r16 = r10 + 2
            r15 = r15[r16]
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r15 & r16
            r16 = r5
            if (r9 == r6) goto L_0x0056
            long r4 = (long) r9
            int r11 = r8.getInt(r1, r4)
            r6 = r9
        L_0x0056:
            int r4 = r15 >>> 20
            r5 = 1
            int r4 = r5 << r4
            r5 = r16
            goto L_0x0063
        L_0x005e:
            r16 = r5
            r5 = r16
            r4 = 0
        L_0x0063:
            if (r5 == 0) goto L_0x0081
            com.google.protobuf.j<?> r9 = r0.f20897p
            int r9 = r9.mo23891a(r5)
            if (r9 > r13) goto L_0x0081
            com.google.protobuf.j<?> r9 = r0.f20897p
            r9.mo23900j(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007f
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0063
        L_0x007f:
            r5 = 0
            goto L_0x0063
        L_0x0081:
            r15 = r5
            r9 = r6
            long r5 = m13944V(r12)
            switch(r14) {
                case 0: goto L_0x0489;
                case 1: goto L_0x047d;
                case 2: goto L_0x0471;
                case 3: goto L_0x0465;
                case 4: goto L_0x0459;
                case 5: goto L_0x044d;
                case 6: goto L_0x0441;
                case 7: goto L_0x0435;
                case 8: goto L_0x0429;
                case 9: goto L_0x0418;
                case 10: goto L_0x0409;
                case 11: goto L_0x03fc;
                case 12: goto L_0x03ef;
                case 13: goto L_0x03e2;
                case 14: goto L_0x03d5;
                case 15: goto L_0x03c8;
                case 16: goto L_0x03bb;
                case 17: goto L_0x03aa;
                case 18: goto L_0x039a;
                case 19: goto L_0x038a;
                case 20: goto L_0x037a;
                case 21: goto L_0x036a;
                case 22: goto L_0x035a;
                case 23: goto L_0x034a;
                case 24: goto L_0x033a;
                case 25: goto L_0x032a;
                case 26: goto L_0x031b;
                case 27: goto L_0x0308;
                case 28: goto L_0x02f9;
                case 29: goto L_0x02e9;
                case 30: goto L_0x02d9;
                case 31: goto L_0x02c9;
                case 32: goto L_0x02b9;
                case 33: goto L_0x02a9;
                case 34: goto L_0x0299;
                case 35: goto L_0x0289;
                case 36: goto L_0x0279;
                case 37: goto L_0x0269;
                case 38: goto L_0x0259;
                case 39: goto L_0x0249;
                case 40: goto L_0x0239;
                case 41: goto L_0x0229;
                case 42: goto L_0x0219;
                case 43: goto L_0x0209;
                case 44: goto L_0x01f9;
                case 45: goto L_0x01e9;
                case 46: goto L_0x01d9;
                case 47: goto L_0x01c9;
                case 48: goto L_0x01b9;
                case 49: goto L_0x01a6;
                case 50: goto L_0x019d;
                case 51: goto L_0x018e;
                case 52: goto L_0x017f;
                case 53: goto L_0x0170;
                case 54: goto L_0x0161;
                case 55: goto L_0x0152;
                case 56: goto L_0x0143;
                case 57: goto L_0x0134;
                case 58: goto L_0x0125;
                case 59: goto L_0x0116;
                case 60: goto L_0x0103;
                case 61: goto L_0x00f3;
                case 62: goto L_0x00e5;
                case 63: goto L_0x00d7;
                case 64: goto L_0x00c9;
                case 65: goto L_0x00bb;
                case 66: goto L_0x00ad;
                case 67: goto L_0x009f;
                case 68: goto L_0x008d;
                default: goto L_0x008a;
            }
        L_0x008a:
            r12 = 0
            goto L_0x0494
        L_0x008d:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.protobuf.m0 r5 = r0.m13980v(r10)
            r2.mo23792s(r13, r4, r5)
            goto L_0x008a
        L_0x009f:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = m13949a0(r1, r5)
            r2.mo23764F(r13, r4)
            goto L_0x008a
        L_0x00ad:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = m13948Z(r1, r5)
            r2.mo23772N(r13, r4)
            goto L_0x008a
        L_0x00bb:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = m13949a0(r1, r5)
            r2.mo23799z(r13, r4)
            goto L_0x008a
        L_0x00c9:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = m13948Z(r1, r5)
            r2.mo23793t(r13, r4)
            goto L_0x008a
        L_0x00d7:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = m13948Z(r1, r5)
            r2.mo23768J(r13, r4)
            goto L_0x008a
        L_0x00e5:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = m13948Z(r1, r5)
            r2.mo23777d(r13, r4)
            goto L_0x008a
        L_0x00f3:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r2.mo23795v(r13, r4)
            goto L_0x008a
        L_0x0103:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.protobuf.m0 r5 = r0.m13980v(r10)
            r2.mo23783j(r13, r4, r5)
            goto L_0x008a
        L_0x0116:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            r0.m13987y0(r13, r4, r2)
            goto L_0x008a
        L_0x0125:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            boolean r4 = m13945W(r1, r5)
            r2.mo23791r(r13, r4)
            goto L_0x008a
        L_0x0134:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = m13948Z(r1, r5)
            r2.mo23779f(r13, r4)
            goto L_0x008a
        L_0x0143:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = m13949a0(r1, r5)
            r2.mo23784k(r13, r4)
            goto L_0x008a
        L_0x0152:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = m13948Z(r1, r5)
            r2.mo23796w(r13, r4)
            goto L_0x008a
        L_0x0161:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = m13949a0(r1, r5)
            r2.mo23788o(r13, r4)
            goto L_0x008a
        L_0x0170:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = m13949a0(r1, r5)
            r2.mo23790q(r13, r4)
            goto L_0x008a
        L_0x017f:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            float r4 = m13947Y(r1, r5)
            r2.mo23765G(r13, r4)
            goto L_0x008a
        L_0x018e:
            boolean r4 = r0.m13931I(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            double r4 = m13946X(r1, r5)
            r2.mo23780g(r13, r4)
            goto L_0x008a
        L_0x019d:
            java.lang.Object r4 = r8.getObject(r1, r5)
            r0.m13985x0(r2, r13, r4, r10)
            goto L_0x008a
        L_0x01a6:
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.m0 r6 = r0.m13980v(r10)
            com.google.protobuf.C3726o0.m13544U(r4, r5, r2, r6)
            goto L_0x008a
        L_0x01b9:
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 1
            com.google.protobuf.C3726o0.m13553b0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01c9:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13551a0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01d9:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13549Z(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01e9:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13548Y(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01f9:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13540Q(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0209:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13557d0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0219:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13537N(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0229:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13541R(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0239:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13542S(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0249:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13545V(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0259:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13559e0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0269:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13546W(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0279:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13543T(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0289:
            r12 = 1
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13539P(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0299:
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            com.google.protobuf.C3726o0.m13553b0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02a9:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13551a0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02b9:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13549Z(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02c9:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13548Y(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02d9:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13540Q(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02e9:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13557d0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02f9:
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13538O(r4, r5, r2)
            goto L_0x008a
        L_0x0308:
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.m0 r6 = r0.m13980v(r10)
            com.google.protobuf.C3726o0.m13547X(r4, r5, r2, r6)
            goto L_0x008a
        L_0x031b:
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13555c0(r4, r5, r2)
            goto L_0x008a
        L_0x032a:
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            com.google.protobuf.C3726o0.m13537N(r4, r5, r2, r12)
            goto L_0x0494
        L_0x033a:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13541R(r4, r5, r2, r12)
            goto L_0x0494
        L_0x034a:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13542S(r4, r5, r2, r12)
            goto L_0x0494
        L_0x035a:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13545V(r4, r5, r2, r12)
            goto L_0x0494
        L_0x036a:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13559e0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x037a:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13546W(r4, r5, r2, r12)
            goto L_0x0494
        L_0x038a:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13543T(r4, r5, r2, r12)
            goto L_0x0494
        L_0x039a:
            r12 = 0
            int r4 = r0.m13943U(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.protobuf.C3726o0.m13539P(r4, r5, r2, r12)
            goto L_0x0494
        L_0x03aa:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.protobuf.m0 r5 = r0.m13980v(r10)
            r2.mo23792s(r13, r4, r5)
            goto L_0x0494
        L_0x03bb:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r8.getLong(r1, r5)
            r2.mo23764F(r13, r4)
            goto L_0x0494
        L_0x03c8:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.mo23772N(r13, r4)
            goto L_0x0494
        L_0x03d5:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r8.getLong(r1, r5)
            r2.mo23799z(r13, r4)
            goto L_0x0494
        L_0x03e2:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.mo23793t(r13, r4)
            goto L_0x0494
        L_0x03ef:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.mo23768J(r13, r4)
            goto L_0x0494
        L_0x03fc:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.mo23777d(r13, r4)
            goto L_0x0494
        L_0x0409:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r2.mo23795v(r13, r4)
            goto L_0x0494
        L_0x0418:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.protobuf.m0 r5 = r0.m13980v(r10)
            r2.mo23783j(r13, r4, r5)
            goto L_0x0494
        L_0x0429:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            r0.m13987y0(r13, r4, r2)
            goto L_0x0494
        L_0x0435:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            boolean r4 = m13960l(r1, r5)
            r2.mo23791r(r13, r4)
            goto L_0x0494
        L_0x0441:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.mo23779f(r13, r4)
            goto L_0x0494
        L_0x044d:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r8.getLong(r1, r5)
            r2.mo23784k(r13, r4)
            goto L_0x0494
        L_0x0459:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.mo23796w(r13, r4)
            goto L_0x0494
        L_0x0465:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r8.getLong(r1, r5)
            r2.mo23788o(r13, r4)
            goto L_0x0494
        L_0x0471:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r8.getLong(r1, r5)
            r2.mo23790q(r13, r4)
            goto L_0x0494
        L_0x047d:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            float r4 = m13974s(r1, r5)
            r2.mo23765G(r13, r4)
            goto L_0x0494
        L_0x0489:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            double r4 = m13966o(r1, r5)
            r2.mo23780g(r13, r4)
        L_0x0494:
            int r10 = r10 + 3
            r6 = r9
            r5 = r15
            goto L_0x002b
        L_0x049a:
            r16 = r5
        L_0x049c:
            if (r5 == 0) goto L_0x04b3
            com.google.protobuf.j<?> r4 = r0.f20897p
            r4.mo23900j(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04b1
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x049c
        L_0x04b1:
            r5 = 0
            goto L_0x049c
        L_0x04b3:
            com.google.protobuf.r0<?, ?> r3 = r0.f20896o
            r0.m13989z0(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.m13979u0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* renamed from: v */
    private C3722m0 m13980v(int i) {
        int i2 = (i / 3) * 2;
        C3722m0 m0Var = (C3722m0) this.f20883b[i2];
        if (m0Var != null) {
            return m0Var;
        }
        C3722m0 d = C3707h0.m13389a().mo23886d((Class) this.f20883b[i2 + 1]);
        this.f20883b[i2] = d;
        return d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: v0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13981v0(T r13, com.google.protobuf.Writer r14) {
        /*
            r12 = this;
            boolean r0 = r12.f20887f
            r1 = 0
            if (r0 == 0) goto L_0x001c
            com.google.protobuf.j<?> r0 = r12.f20897p
            com.google.protobuf.FieldSet r0 = r0.mo23893c(r13)
            boolean r2 = r0.mo23293r()
            if (r2 != 0) goto L_0x001c
            java.util.Iterator r0 = r0.mo23296w()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x001e
        L_0x001c:
            r0 = r1
            r2 = r0
        L_0x001e:
            int[] r3 = r12.f20882a
            int r3 = r3.length
            r4 = 0
            r5 = 0
        L_0x0023:
            if (r5 >= r3) goto L_0x0586
            int r6 = r12.m13977t0(r5)
            int r7 = r12.m13943U(r5)
        L_0x002d:
            if (r2 == 0) goto L_0x004b
            com.google.protobuf.j<?> r8 = r12.f20897p
            int r8 = r8.mo23891a(r2)
            if (r8 > r7) goto L_0x004b
            com.google.protobuf.j<?> r8 = r12.f20897p
            r8.mo23900j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002d
        L_0x0049:
            r2 = r1
            goto L_0x002d
        L_0x004b:
            int r8 = m13975s0(r6)
            r9 = 1
            switch(r8) {
                case 0: goto L_0x0571;
                case 1: goto L_0x055f;
                case 2: goto L_0x054d;
                case 3: goto L_0x053b;
                case 4: goto L_0x0529;
                case 5: goto L_0x0517;
                case 6: goto L_0x0505;
                case 7: goto L_0x04f2;
                case 8: goto L_0x04df;
                case 9: goto L_0x04c8;
                case 10: goto L_0x04b3;
                case 11: goto L_0x04a0;
                case 12: goto L_0x048d;
                case 13: goto L_0x047a;
                case 14: goto L_0x0467;
                case 15: goto L_0x0454;
                case 16: goto L_0x0441;
                case 17: goto L_0x042a;
                case 18: goto L_0x0417;
                case 19: goto L_0x0404;
                case 20: goto L_0x03f1;
                case 21: goto L_0x03de;
                case 22: goto L_0x03cb;
                case 23: goto L_0x03b8;
                case 24: goto L_0x03a5;
                case 25: goto L_0x0392;
                case 26: goto L_0x037f;
                case 27: goto L_0x0368;
                case 28: goto L_0x0355;
                case 29: goto L_0x0342;
                case 30: goto L_0x032f;
                case 31: goto L_0x031c;
                case 32: goto L_0x0309;
                case 33: goto L_0x02f6;
                case 34: goto L_0x02e3;
                case 35: goto L_0x02d0;
                case 36: goto L_0x02bd;
                case 37: goto L_0x02aa;
                case 38: goto L_0x0297;
                case 39: goto L_0x0284;
                case 40: goto L_0x0271;
                case 41: goto L_0x025e;
                case 42: goto L_0x024b;
                case 43: goto L_0x0238;
                case 44: goto L_0x0225;
                case 45: goto L_0x0212;
                case 46: goto L_0x01ff;
                case 47: goto L_0x01ec;
                case 48: goto L_0x01d9;
                case 49: goto L_0x01c2;
                case 50: goto L_0x01b5;
                case 51: goto L_0x01a2;
                case 52: goto L_0x018f;
                case 53: goto L_0x017c;
                case 54: goto L_0x0169;
                case 55: goto L_0x0156;
                case 56: goto L_0x0143;
                case 57: goto L_0x0130;
                case 58: goto L_0x011d;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f3;
                case 61: goto L_0x00de;
                case 62: goto L_0x00cb;
                case 63: goto L_0x00b8;
                case 64: goto L_0x00a5;
                case 65: goto L_0x0092;
                case 66: goto L_0x007f;
                case 67: goto L_0x006c;
                case 68: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x0582
        L_0x0055:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            com.google.protobuf.m0 r8 = r12.m13980v(r5)
            r14.mo23792s(r7, r6, r8)
            goto L_0x0582
        L_0x006c:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            long r8 = m13949a0(r13, r8)
            r14.mo23764F(r7, r8)
            goto L_0x0582
        L_0x007f:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13948Z(r13, r8)
            r14.mo23772N(r7, r6)
            goto L_0x0582
        L_0x0092:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            long r8 = m13949a0(r13, r8)
            r14.mo23799z(r7, r8)
            goto L_0x0582
        L_0x00a5:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13948Z(r13, r8)
            r14.mo23793t(r7, r6)
            goto L_0x0582
        L_0x00b8:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13948Z(r13, r8)
            r14.mo23768J(r7, r6)
            goto L_0x0582
        L_0x00cb:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13948Z(r13, r8)
            r14.mo23777d(r7, r6)
            goto L_0x0582
        L_0x00de:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            r14.mo23795v(r7, r6)
            goto L_0x0582
        L_0x00f3:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            com.google.protobuf.m0 r8 = r12.m13980v(r5)
            r14.mo23783j(r7, r6, r8)
            goto L_0x0582
        L_0x010a:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            r12.m13987y0(r7, r6, r14)
            goto L_0x0582
        L_0x011d:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            boolean r6 = m13945W(r13, r8)
            r14.mo23791r(r7, r6)
            goto L_0x0582
        L_0x0130:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13948Z(r13, r8)
            r14.mo23779f(r7, r6)
            goto L_0x0582
        L_0x0143:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            long r8 = m13949a0(r13, r8)
            r14.mo23784k(r7, r8)
            goto L_0x0582
        L_0x0156:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13948Z(r13, r8)
            r14.mo23796w(r7, r6)
            goto L_0x0582
        L_0x0169:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            long r8 = m13949a0(r13, r8)
            r14.mo23788o(r7, r8)
            goto L_0x0582
        L_0x017c:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            long r8 = m13949a0(r13, r8)
            r14.mo23790q(r7, r8)
            goto L_0x0582
        L_0x018f:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            float r6 = m13947Y(r13, r8)
            r14.mo23765G(r7, r6)
            goto L_0x0582
        L_0x01a2:
            boolean r8 = r12.m13931I(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            double r8 = m13946X(r13, r8)
            r14.mo23780g(r7, r8)
            goto L_0x0582
        L_0x01b5:
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            r12.m13985x0(r14, r7, r6, r5)
            goto L_0x0582
        L_0x01c2:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.m0 r8 = r12.m13980v(r5)
            com.google.protobuf.C3726o0.m13544U(r7, r6, r14, r8)
            goto L_0x0582
        L_0x01d9:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13553b0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ec:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13551a0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ff:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13549Z(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0212:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13548Y(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0225:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13540Q(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0238:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13557d0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x024b:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13537N(r7, r6, r14, r9)
            goto L_0x0582
        L_0x025e:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13541R(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0271:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13542S(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0284:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13545V(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0297:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13559e0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02aa:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13546W(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02bd:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13543T(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02d0:
            int r7 = r12.m13943U(r5)
            long r10 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13539P(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02e3:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13553b0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x02f6:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13551a0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0309:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13549Z(r7, r6, r14, r4)
            goto L_0x0582
        L_0x031c:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13548Y(r7, r6, r14, r4)
            goto L_0x0582
        L_0x032f:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13540Q(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0342:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13557d0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0355:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13538O(r7, r6, r14)
            goto L_0x0582
        L_0x0368:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.m0 r8 = r12.m13980v(r5)
            com.google.protobuf.C3726o0.m13547X(r7, r6, r14, r8)
            goto L_0x0582
        L_0x037f:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13555c0(r7, r6, r14)
            goto L_0x0582
        L_0x0392:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13537N(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03a5:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13541R(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03b8:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13542S(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03cb:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13545V(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03de:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13559e0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03f1:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13546W(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0404:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13543T(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0417:
            int r7 = r12.m13943U(r5)
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.C3726o0.m13539P(r7, r6, r14, r4)
            goto L_0x0582
        L_0x042a:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            com.google.protobuf.m0 r8 = r12.m13980v(r5)
            r14.mo23792s(r7, r6, r8)
            goto L_0x0582
        L_0x0441:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            long r8 = m13934L(r13, r8)
            r14.mo23764F(r7, r8)
            goto L_0x0582
        L_0x0454:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13923A(r13, r8)
            r14.mo23772N(r7, r6)
            goto L_0x0582
        L_0x0467:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            long r8 = m13934L(r13, r8)
            r14.mo23799z(r7, r8)
            goto L_0x0582
        L_0x047a:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13923A(r13, r8)
            r14.mo23793t(r7, r6)
            goto L_0x0582
        L_0x048d:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13923A(r13, r8)
            r14.mo23768J(r7, r6)
            goto L_0x0582
        L_0x04a0:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13923A(r13, r8)
            r14.mo23777d(r7, r6)
            goto L_0x0582
        L_0x04b3:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            r14.mo23795v(r7, r6)
            goto L_0x0582
        L_0x04c8:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            com.google.protobuf.m0 r8 = r12.m13980v(r5)
            r14.mo23783j(r7, r6, r8)
            goto L_0x0582
        L_0x04df:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r13, r8)
            r12.m13987y0(r7, r6, r14)
            goto L_0x0582
        L_0x04f2:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            boolean r6 = m13960l(r13, r8)
            r14.mo23791r(r7, r6)
            goto L_0x0582
        L_0x0505:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13923A(r13, r8)
            r14.mo23779f(r7, r6)
            goto L_0x0582
        L_0x0517:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            long r8 = m13934L(r13, r8)
            r14.mo23784k(r7, r8)
            goto L_0x0582
        L_0x0529:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            int r6 = m13923A(r13, r8)
            r14.mo23796w(r7, r6)
            goto L_0x0582
        L_0x053b:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            long r8 = m13934L(r13, r8)
            r14.mo23788o(r7, r8)
            goto L_0x0582
        L_0x054d:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            long r8 = m13934L(r13, r8)
            r14.mo23790q(r7, r8)
            goto L_0x0582
        L_0x055f:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            float r6 = m13974s(r13, r8)
            r14.mo23765G(r7, r6)
            goto L_0x0582
        L_0x0571:
            boolean r8 = r12.m13925C(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = m13944V(r6)
            double r8 = m13966o(r13, r8)
            r14.mo23780g(r7, r8)
        L_0x0582:
            int r5 = r5 + 3
            goto L_0x0023
        L_0x0586:
            if (r2 == 0) goto L_0x059c
            com.google.protobuf.j<?> r3 = r12.f20897p
            r3.mo23900j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x059a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0586
        L_0x059a:
            r2 = r1
            goto L_0x0586
        L_0x059c:
            com.google.protobuf.r0<?, ?> r0 = r12.f20896o
            r12.m13989z0(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.m13981v0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* renamed from: w */
    static UnknownFieldSetLite m13982w(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite l = UnknownFieldSetLite.m13042l();
        generatedMessageLite.unknownFields = l;
        return l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: w0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13983w0(T r11, com.google.protobuf.Writer r12) {
        /*
            r10 = this;
            com.google.protobuf.r0<?, ?> r0 = r10.f20896o
            r10.m13989z0(r0, r11, r12)
            boolean r0 = r10.f20887f
            r1 = 0
            if (r0 == 0) goto L_0x0021
            com.google.protobuf.j<?> r0 = r10.f20897p
            com.google.protobuf.FieldSet r0 = r0.mo23893c(r11)
            boolean r2 = r0.mo23293r()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.mo23285h()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.f20882a
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x058c
            int r4 = r10.m13977t0(r3)
            int r5 = r10.m13943U(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            com.google.protobuf.j<?> r6 = r10.f20897p
            int r6 = r6.mo23891a(r2)
            if (r6 <= r5) goto L_0x0050
            com.google.protobuf.j<?> r6 = r10.f20897p
            r6.mo23900j(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = m13975s0(r4)
            r7 = 1
            r8 = 0
            switch(r6) {
                case 0: goto L_0x0577;
                case 1: goto L_0x0565;
                case 2: goto L_0x0553;
                case 3: goto L_0x0541;
                case 4: goto L_0x052f;
                case 5: goto L_0x051d;
                case 6: goto L_0x050b;
                case 7: goto L_0x04f8;
                case 8: goto L_0x04e5;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04b9;
                case 11: goto L_0x04a6;
                case 12: goto L_0x0493;
                case 13: goto L_0x0480;
                case 14: goto L_0x046d;
                case 15: goto L_0x045a;
                case 16: goto L_0x0447;
                case 17: goto L_0x0430;
                case 18: goto L_0x041d;
                case 19: goto L_0x040a;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e4;
                case 22: goto L_0x03d1;
                case 23: goto L_0x03be;
                case 24: goto L_0x03ab;
                case 25: goto L_0x0398;
                case 26: goto L_0x0385;
                case 27: goto L_0x036e;
                case 28: goto L_0x035b;
                case 29: goto L_0x0348;
                case 30: goto L_0x0335;
                case 31: goto L_0x0322;
                case 32: goto L_0x030f;
                case 33: goto L_0x02fc;
                case 34: goto L_0x02e9;
                case 35: goto L_0x02d6;
                case 36: goto L_0x02c3;
                case 37: goto L_0x02b0;
                case 38: goto L_0x029d;
                case 39: goto L_0x028a;
                case 40: goto L_0x0277;
                case 41: goto L_0x0264;
                case 42: goto L_0x0251;
                case 43: goto L_0x023e;
                case 44: goto L_0x022b;
                case 45: goto L_0x0218;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01df;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bb;
                case 51: goto L_0x01a8;
                case 52: goto L_0x0195;
                case 53: goto L_0x0182;
                case 54: goto L_0x016f;
                case 55: goto L_0x015c;
                case 56: goto L_0x0149;
                case 57: goto L_0x0136;
                case 58: goto L_0x0123;
                case 59: goto L_0x0110;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e4;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00be;
                case 64: goto L_0x00ab;
                case 65: goto L_0x0098;
                case 66: goto L_0x0085;
                case 67: goto L_0x0072;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0588
        L_0x005b:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            com.google.protobuf.m0 r6 = r10.m13980v(r3)
            r12.mo23792s(r5, r4, r6)
            goto L_0x0588
        L_0x0072:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            long r6 = m13949a0(r11, r6)
            r12.mo23764F(r5, r6)
            goto L_0x0588
        L_0x0085:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13948Z(r11, r6)
            r12.mo23772N(r5, r4)
            goto L_0x0588
        L_0x0098:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            long r6 = m13949a0(r11, r6)
            r12.mo23799z(r5, r6)
            goto L_0x0588
        L_0x00ab:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13948Z(r11, r6)
            r12.mo23793t(r5, r4)
            goto L_0x0588
        L_0x00be:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13948Z(r11, r6)
            r12.mo23768J(r5, r4)
            goto L_0x0588
        L_0x00d1:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13948Z(r11, r6)
            r12.mo23777d(r5, r4)
            goto L_0x0588
        L_0x00e4:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r12.mo23795v(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            com.google.protobuf.m0 r6 = r10.m13980v(r3)
            r12.mo23783j(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            r10.m13987y0(r5, r4, r12)
            goto L_0x0588
        L_0x0123:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            boolean r4 = m13945W(r11, r6)
            r12.mo23791r(r5, r4)
            goto L_0x0588
        L_0x0136:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13948Z(r11, r6)
            r12.mo23779f(r5, r4)
            goto L_0x0588
        L_0x0149:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            long r6 = m13949a0(r11, r6)
            r12.mo23784k(r5, r6)
            goto L_0x0588
        L_0x015c:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13948Z(r11, r6)
            r12.mo23796w(r5, r4)
            goto L_0x0588
        L_0x016f:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            long r6 = m13949a0(r11, r6)
            r12.mo23788o(r5, r6)
            goto L_0x0588
        L_0x0182:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            long r6 = m13949a0(r11, r6)
            r12.mo23790q(r5, r6)
            goto L_0x0588
        L_0x0195:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            float r4 = m13947Y(r11, r6)
            r12.mo23765G(r5, r4)
            goto L_0x0588
        L_0x01a8:
            boolean r6 = r10.m13931I(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            double r6 = m13946X(r11, r6)
            r12.mo23780g(r5, r6)
            goto L_0x0588
        L_0x01bb:
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            r10.m13985x0(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.m0 r6 = r10.m13980v(r3)
            com.google.protobuf.C3726o0.m13544U(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13553b0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13551a0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13549Z(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13548Y(r5, r4, r12, r7)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13540Q(r5, r4, r12, r7)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13557d0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13537N(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13541R(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13542S(r5, r4, r12, r7)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13545V(r5, r4, r12, r7)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13559e0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13546W(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13543T(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.m13943U(r3)
            long r8 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13539P(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13553b0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13551a0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13549Z(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13548Y(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13540Q(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13557d0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13538O(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.m0 r6 = r10.m13980v(r3)
            com.google.protobuf.C3726o0.m13547X(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13555c0(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13537N(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13541R(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13542S(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13545V(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13559e0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13546W(r5, r4, r12, r8)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13543T(r5, r4, r12, r8)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.m13943U(r3)
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.C3726o0.m13539P(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            com.google.protobuf.m0 r6 = r10.m13980v(r3)
            r12.mo23792s(r5, r4, r6)
            goto L_0x0588
        L_0x0447:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            long r6 = m13934L(r11, r6)
            r12.mo23764F(r5, r6)
            goto L_0x0588
        L_0x045a:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13923A(r11, r6)
            r12.mo23772N(r5, r4)
            goto L_0x0588
        L_0x046d:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            long r6 = m13934L(r11, r6)
            r12.mo23799z(r5, r6)
            goto L_0x0588
        L_0x0480:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13923A(r11, r6)
            r12.mo23793t(r5, r4)
            goto L_0x0588
        L_0x0493:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13923A(r11, r6)
            r12.mo23768J(r5, r4)
            goto L_0x0588
        L_0x04a6:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13923A(r11, r6)
            r12.mo23777d(r5, r4)
            goto L_0x0588
        L_0x04b9:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r12.mo23795v(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            com.google.protobuf.m0 r6 = r10.m13980v(r3)
            r12.mo23783j(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            java.lang.Object r4 = com.google.protobuf.C3752t0.m13717F(r11, r6)
            r10.m13987y0(r5, r4, r12)
            goto L_0x0588
        L_0x04f8:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            boolean r4 = m13960l(r11, r6)
            r12.mo23791r(r5, r4)
            goto L_0x0588
        L_0x050b:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13923A(r11, r6)
            r12.mo23779f(r5, r4)
            goto L_0x0588
        L_0x051d:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            long r6 = m13934L(r11, r6)
            r12.mo23784k(r5, r6)
            goto L_0x0588
        L_0x052f:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            int r4 = m13923A(r11, r6)
            r12.mo23796w(r5, r4)
            goto L_0x0588
        L_0x0541:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            long r6 = m13934L(r11, r6)
            r12.mo23788o(r5, r6)
            goto L_0x0588
        L_0x0553:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            long r6 = m13934L(r11, r6)
            r12.mo23790q(r5, r6)
            goto L_0x0588
        L_0x0565:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            float r4 = m13974s(r11, r6)
            r12.mo23765G(r5, r4)
            goto L_0x0588
        L_0x0577:
            boolean r6 = r10.m13925C(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = m13944V(r4)
            double r6 = m13966o(r11, r6)
            r12.mo23780g(r5, r6)
        L_0x0588:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x058c:
            if (r2 == 0) goto L_0x05a3
            com.google.protobuf.j<?> r11 = r10.f20897p
            r11.mo23900j(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x05a1
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x058c
        L_0x05a1:
            r2 = r1
            goto L_0x058c
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.m13983w0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0347, code lost:
        r4 = (r4 + r8) + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0461, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0518, code lost:
        r5 = r5 + 3;
        r4 = r16;
     */
    /* renamed from: x */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m13984x(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            sun.misc.Unsafe r2 = f20881s
            r4 = -1
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000a:
            int[] r8 = r0.f20882a
            int r8 = r8.length
            if (r5 >= r8) goto L_0x051e
            int r8 = r0.m13977t0(r5)
            int r9 = r0.m13943U(r5)
            int r10 = m13975s0(r8)
            r11 = 17
            r12 = 1048575(0xfffff, float:1.469367E-39)
            r13 = 1
            if (r10 > r11) goto L_0x0039
            int[] r11 = r0.f20882a
            int r14 = r5 + 2
            r11 = r11[r14]
            r12 = r12 & r11
            int r14 = r11 >>> 20
            int r14 = r13 << r14
            r15 = r14
            if (r12 == r4) goto L_0x0037
            long r13 = (long) r12
            int r7 = r2.getInt(r1, r13)
            r4 = r12
        L_0x0037:
            r14 = r15
            goto L_0x0057
        L_0x0039:
            boolean r11 = r0.f20890i
            if (r11 == 0) goto L_0x0055
            com.google.protobuf.FieldType r11 = com.google.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r11 = r11.mo23307id()
            if (r10 < r11) goto L_0x0055
            com.google.protobuf.FieldType r11 = com.google.protobuf.FieldType.SINT64_LIST_PACKED
            int r11 = r11.mo23307id()
            if (r10 > r11) goto L_0x0055
            int[] r11 = r0.f20882a
            int r13 = r5 + 2
            r11 = r11[r13]
            r11 = r11 & r12
            goto L_0x0056
        L_0x0055:
            r11 = 0
        L_0x0056:
            r14 = 0
        L_0x0057:
            long r12 = m13944V(r8)
            r8 = 0
            r16 = r4
            r3 = 0
            switch(r10) {
                case 0: goto L_0x050c;
                case 1: goto L_0x0502;
                case 2: goto L_0x04f4;
                case 3: goto L_0x04e6;
                case 4: goto L_0x04d8;
                case 5: goto L_0x04ce;
                case 6: goto L_0x04c4;
                case 7: goto L_0x04b9;
                case 8: goto L_0x049d;
                case 9: goto L_0x048c;
                case 10: goto L_0x047d;
                case 11: goto L_0x0470;
                case 12: goto L_0x0463;
                case 13: goto L_0x0458;
                case 14: goto L_0x044f;
                case 15: goto L_0x0442;
                case 16: goto L_0x0435;
                case 17: goto L_0x0422;
                case 18: goto L_0x0413;
                case 19: goto L_0x0407;
                case 20: goto L_0x03fb;
                case 21: goto L_0x03ef;
                case 22: goto L_0x03e3;
                case 23: goto L_0x03d7;
                case 24: goto L_0x03cb;
                case 25: goto L_0x03bf;
                case 26: goto L_0x03b4;
                case 27: goto L_0x03a5;
                case 28: goto L_0x0399;
                case 29: goto L_0x038c;
                case 30: goto L_0x037f;
                case 31: goto L_0x0372;
                case 32: goto L_0x0365;
                case 33: goto L_0x0358;
                case 34: goto L_0x034b;
                case 35: goto L_0x032b;
                case 36: goto L_0x030e;
                case 37: goto L_0x02f1;
                case 38: goto L_0x02d4;
                case 39: goto L_0x02b6;
                case 40: goto L_0x0298;
                case 41: goto L_0x027a;
                case 42: goto L_0x025c;
                case 43: goto L_0x023e;
                case 44: goto L_0x0220;
                case 45: goto L_0x0202;
                case 46: goto L_0x01e4;
                case 47: goto L_0x01c6;
                case 48: goto L_0x01a8;
                case 49: goto L_0x0198;
                case 50: goto L_0x0188;
                case 51: goto L_0x017a;
                case 52: goto L_0x016e;
                case 53: goto L_0x015e;
                case 54: goto L_0x014e;
                case 55: goto L_0x013e;
                case 56: goto L_0x0132;
                case 57: goto L_0x0125;
                case 58: goto L_0x0118;
                case 59: goto L_0x00fa;
                case 60: goto L_0x00e6;
                case 61: goto L_0x00d4;
                case 62: goto L_0x00c4;
                case 63: goto L_0x00b4;
                case 64: goto L_0x00a7;
                case 65: goto L_0x009b;
                case 66: goto L_0x008b;
                case 67: goto L_0x007b;
                case 68: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x041f
        L_0x0065:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.protobuf.MessageLite r3 = (com.google.protobuf.MessageLite) r3
            com.google.protobuf.m0 r4 = r0.m13980v(r5)
            int r3 = com.google.protobuf.CodedOutputStream.m12479b(r9, r3, r4)
            goto L_0x041e
        L_0x007b:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            long r3 = m13949a0(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeSInt64Size(r9, r3)
            goto L_0x041e
        L_0x008b:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            int r3 = m13948Z(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeSInt32Size(r9, r3)
            goto L_0x041e
        L_0x009b:
            boolean r8 = r0.m13931I(r1, r9, r5)
            if (r8 == 0) goto L_0x041f
            int r3 = com.google.protobuf.CodedOutputStream.computeSFixed64Size(r9, r3)
            goto L_0x041e
        L_0x00a7:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            r3 = 0
            int r4 = com.google.protobuf.CodedOutputStream.computeSFixed32Size(r9, r3)
            goto L_0x0461
        L_0x00b4:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            int r3 = m13948Z(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeEnumSize(r9, r3)
            goto L_0x041e
        L_0x00c4:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            int r3 = m13948Z(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeUInt32Size(r9, r3)
            goto L_0x041e
        L_0x00d4:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x041e
        L_0x00e6:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.protobuf.m0 r4 = r0.m13980v(r5)
            int r3 = com.google.protobuf.C3726o0.m13569o(r9, r3, r4)
            goto L_0x041e
        L_0x00fa:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof com.google.protobuf.ByteString
            if (r4 == 0) goto L_0x0110
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x041e
        L_0x0110:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeStringSize(r9, r3)
            goto L_0x041e
        L_0x0118:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            r3 = 1
            int r3 = com.google.protobuf.CodedOutputStream.computeBoolSize(r9, r3)
            goto L_0x041e
        L_0x0125:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            r3 = 0
            int r4 = com.google.protobuf.CodedOutputStream.computeFixed32Size(r9, r3)
            goto L_0x0461
        L_0x0132:
            boolean r8 = r0.m13931I(r1, r9, r5)
            if (r8 == 0) goto L_0x041f
            int r3 = com.google.protobuf.CodedOutputStream.computeFixed64Size(r9, r3)
            goto L_0x041e
        L_0x013e:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            int r3 = m13948Z(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeInt32Size(r9, r3)
            goto L_0x041e
        L_0x014e:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            long r3 = m13949a0(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeUInt64Size(r9, r3)
            goto L_0x041e
        L_0x015e:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            long r3 = m13949a0(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeInt64Size(r9, r3)
            goto L_0x041e
        L_0x016e:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            int r3 = com.google.protobuf.CodedOutputStream.computeFloatSize(r9, r8)
            goto L_0x041e
        L_0x017a:
            boolean r3 = r0.m13931I(r1, r9, r5)
            if (r3 == 0) goto L_0x041f
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeDoubleSize(r9, r3)
            goto L_0x041e
        L_0x0188:
            com.google.protobuf.t r3 = r0.f20898q
            java.lang.Object r4 = r2.getObject(r1, r12)
            java.lang.Object r8 = r0.m13978u(r5)
            int r3 = r3.mo24036f(r9, r4, r8)
            goto L_0x041e
        L_0x0198:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            com.google.protobuf.m0 r4 = r0.m13980v(r5)
            int r3 = com.google.protobuf.C3726o0.m13564j(r9, r3, r4)
            goto L_0x041e
        L_0x01a8:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13574t(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x01bc
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01bc:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x01c6:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13572r(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x01da
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01da:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x01e4:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13563i(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x01f8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01f8:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x0202:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13561g(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x0216
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0216:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x0220:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13558e(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x0234
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0234:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x023e:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13577w(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x0252
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0252:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x025c:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13552b(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x0270
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0270:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x027a:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13561g(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x028e
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x028e:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x0298:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13563i(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x02ac
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02ac:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x02b6:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13566l(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x02ca
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02ca:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x02d4:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13579y(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x02e8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02e8:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x02f1:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13568n(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x0305
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0305:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x030e:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13561g(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x0322
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0322:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x032b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13563i(r3)
            if (r3 <= 0) goto L_0x041f
            boolean r4 = r0.f20890i
            if (r4 == 0) goto L_0x033f
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x033f:
            int r4 = com.google.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
        L_0x0347:
            int r4 = r4 + r8
            int r4 = r4 + r3
            goto L_0x0461
        L_0x034b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.protobuf.C3726o0.m13573s(r9, r3, r4)
            goto L_0x041e
        L_0x0358:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13571q(r9, r3, r4)
            goto L_0x041e
        L_0x0365:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13562h(r9, r3, r4)
            goto L_0x041e
        L_0x0372:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13560f(r9, r3, r4)
            goto L_0x041e
        L_0x037f:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13556d(r9, r3, r4)
            goto L_0x041e
        L_0x038c:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13576v(r9, r3, r4)
            goto L_0x041e
        L_0x0399:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13554c(r9, r3)
            goto L_0x041e
        L_0x03a5:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            com.google.protobuf.m0 r4 = r0.m13980v(r5)
            int r3 = com.google.protobuf.C3726o0.m13570p(r9, r3, r4)
            goto L_0x041e
        L_0x03b4:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13575u(r9, r3)
            goto L_0x041e
        L_0x03bf:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.protobuf.C3726o0.m13550a(r9, r3, r4)
            goto L_0x041e
        L_0x03cb:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13560f(r9, r3, r4)
            goto L_0x041e
        L_0x03d7:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13562h(r9, r3, r4)
            goto L_0x041e
        L_0x03e3:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13565k(r9, r3, r4)
            goto L_0x041e
        L_0x03ef:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13578x(r9, r3, r4)
            goto L_0x041e
        L_0x03fb:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13567m(r9, r3, r4)
            goto L_0x041e
        L_0x0407:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13560f(r9, r3, r4)
            goto L_0x041e
        L_0x0413:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.C3726o0.m13562h(r9, r3, r4)
        L_0x041e:
            int r6 = r6 + r3
        L_0x041f:
            r10 = 0
            goto L_0x0518
        L_0x0422:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.protobuf.MessageLite r3 = (com.google.protobuf.MessageLite) r3
            com.google.protobuf.m0 r4 = r0.m13980v(r5)
            int r3 = com.google.protobuf.CodedOutputStream.m12479b(r9, r3, r4)
            goto L_0x041e
        L_0x0435:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            long r3 = r2.getLong(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeSInt64Size(r9, r3)
            goto L_0x041e
        L_0x0442:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            int r3 = r2.getInt(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeSInt32Size(r9, r3)
            goto L_0x041e
        L_0x044f:
            r8 = r7 & r14
            if (r8 == 0) goto L_0x041f
            int r3 = com.google.protobuf.CodedOutputStream.computeSFixed64Size(r9, r3)
            goto L_0x041e
        L_0x0458:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            r3 = 0
            int r4 = com.google.protobuf.CodedOutputStream.computeSFixed32Size(r9, r3)
        L_0x0461:
            int r6 = r6 + r4
            goto L_0x041f
        L_0x0463:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            int r3 = r2.getInt(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeEnumSize(r9, r3)
            goto L_0x041e
        L_0x0470:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            int r3 = r2.getInt(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeUInt32Size(r9, r3)
            goto L_0x041e
        L_0x047d:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x041e
        L_0x048c:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.protobuf.m0 r4 = r0.m13980v(r5)
            int r3 = com.google.protobuf.C3726o0.m13569o(r9, r3, r4)
            goto L_0x041e
        L_0x049d:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof com.google.protobuf.ByteString
            if (r4 == 0) goto L_0x04b1
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x041e
        L_0x04b1:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.protobuf.CodedOutputStream.computeStringSize(r9, r3)
            goto L_0x041e
        L_0x04b9:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            r3 = 1
            int r3 = com.google.protobuf.CodedOutputStream.computeBoolSize(r9, r3)
            goto L_0x041e
        L_0x04c4:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x041f
            r10 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeFixed32Size(r9, r10)
            goto L_0x0517
        L_0x04ce:
            r10 = 0
            r8 = r7 & r14
            if (r8 == 0) goto L_0x0518
            int r3 = com.google.protobuf.CodedOutputStream.computeFixed64Size(r9, r3)
            goto L_0x0517
        L_0x04d8:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0518
            int r3 = r2.getInt(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeInt32Size(r9, r3)
            goto L_0x0517
        L_0x04e6:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0518
            long r3 = r2.getLong(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeUInt64Size(r9, r3)
            goto L_0x0517
        L_0x04f4:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0518
            long r3 = r2.getLong(r1, r12)
            int r3 = com.google.protobuf.CodedOutputStream.computeInt64Size(r9, r3)
            goto L_0x0517
        L_0x0502:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0518
            int r3 = com.google.protobuf.CodedOutputStream.computeFloatSize(r9, r8)
            goto L_0x0517
        L_0x050c:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0518
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.computeDoubleSize(r9, r3)
        L_0x0517:
            int r6 = r6 + r3
        L_0x0518:
            int r5 = r5 + 3
            r4 = r16
            goto L_0x000a
        L_0x051e:
            com.google.protobuf.r0<?, ?> r2 = r0.f20896o
            int r2 = r0.m13988z(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.f20887f
            if (r2 == 0) goto L_0x0534
            com.google.protobuf.j<?> r2 = r0.f20897p
            com.google.protobuf.FieldSet r1 = r2.mo23893c(r1)
            int r1 = r1.mo23291o()
            int r6 = r6 + r1
        L_0x0534:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.m13984x(java.lang.Object):int");
    }

    /* renamed from: x0 */
    private <K, V> void m13985x0(Writer writer, int i, Object obj, int i2) {
        if (obj != null) {
            writer.mo23761C(i, this.f20898q.mo24033c(m13978u(i2)), this.f20898q.mo24038h(obj));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: y */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m13986y(T r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = f20881s
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0008:
            int[] r6 = r0.f20882a
            int r6 = r6.length
            if (r4 >= r6) goto L_0x04e3
            int r6 = r15.m13977t0(r4)
            int r7 = m13975s0(r6)
            int r8 = r15.m13943U(r4)
            long r9 = m13944V(r6)
            com.google.protobuf.FieldType r6 = com.google.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r6 = r6.mo23307id()
            if (r7 < r6) goto L_0x0038
            com.google.protobuf.FieldType r6 = com.google.protobuf.FieldType.SINT64_LIST_PACKED
            int r6 = r6.mo23307id()
            if (r7 > r6) goto L_0x0038
            int[] r6 = r0.f20882a
            int r11 = r4 + 2
            r6 = r6[r11]
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r11
            goto L_0x0039
        L_0x0038:
            r6 = 0
        L_0x0039:
            r11 = 1
            r12 = 0
            r13 = 0
            switch(r7) {
                case 0: goto L_0x04d1;
                case 1: goto L_0x04c5;
                case 2: goto L_0x04b5;
                case 3: goto L_0x04a5;
                case 4: goto L_0x0495;
                case 5: goto L_0x0489;
                case 6: goto L_0x047d;
                case 7: goto L_0x0471;
                case 8: goto L_0x0453;
                case 9: goto L_0x043f;
                case 10: goto L_0x042e;
                case 11: goto L_0x041f;
                case 12: goto L_0x0410;
                case 13: goto L_0x0405;
                case 14: goto L_0x03fa;
                case 15: goto L_0x03eb;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03bc;
                case 19: goto L_0x03b3;
                case 20: goto L_0x03aa;
                case 21: goto L_0x03a1;
                case 22: goto L_0x0398;
                case 23: goto L_0x038f;
                case 24: goto L_0x0386;
                case 25: goto L_0x037d;
                case 26: goto L_0x0374;
                case 27: goto L_0x0367;
                case 28: goto L_0x035e;
                case 29: goto L_0x0355;
                case 30: goto L_0x034b;
                case 31: goto L_0x0341;
                case 32: goto L_0x0337;
                case 33: goto L_0x032d;
                case 34: goto L_0x0323;
                case 35: goto L_0x0303;
                case 36: goto L_0x02e6;
                case 37: goto L_0x02c9;
                case 38: goto L_0x02ac;
                case 39: goto L_0x028e;
                case 40: goto L_0x0270;
                case 41: goto L_0x0252;
                case 42: goto L_0x0234;
                case 43: goto L_0x0216;
                case 44: goto L_0x01f8;
                case 45: goto L_0x01da;
                case 46: goto L_0x01bc;
                case 47: goto L_0x019e;
                case 48: goto L_0x0180;
                case 49: goto L_0x0172;
                case 50: goto L_0x0162;
                case 51: goto L_0x0154;
                case 52: goto L_0x0148;
                case 53: goto L_0x0138;
                case 54: goto L_0x0128;
                case 55: goto L_0x0118;
                case 56: goto L_0x010c;
                case 57: goto L_0x0100;
                case 58: goto L_0x00f4;
                case 59: goto L_0x00d6;
                case 60: goto L_0x00c2;
                case 61: goto L_0x00b0;
                case 62: goto L_0x00a0;
                case 63: goto L_0x0090;
                case 64: goto L_0x0084;
                case 65: goto L_0x0078;
                case 66: goto L_0x0068;
                case 67: goto L_0x0058;
                case 68: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x04df
        L_0x0042:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r1, r9)
            com.google.protobuf.MessageLite r6 = (com.google.protobuf.MessageLite) r6
            com.google.protobuf.m0 r7 = r15.m13980v(r4)
            int r6 = com.google.protobuf.CodedOutputStream.m12479b(r8, r6, r7)
            goto L_0x03c4
        L_0x0058:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = m13949a0(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeSInt64Size(r8, r6)
            goto L_0x03c4
        L_0x0068:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = m13948Z(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeSInt32Size(r8, r6)
            goto L_0x03c4
        L_0x0078:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeSFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0084:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeSFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x0090:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = m13948Z(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeEnumSize(r8, r6)
            goto L_0x03c4
        L_0x00a0:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = m13948Z(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32Size(r8, r6)
            goto L_0x03c4
        L_0x00b0:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r1, r9)
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            int r6 = com.google.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x00c2:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r1, r9)
            com.google.protobuf.m0 r7 = r15.m13980v(r4)
            int r6 = com.google.protobuf.C3726o0.m13569o(r8, r6, r7)
            goto L_0x03c4
        L_0x00d6:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r1, r9)
            boolean r7 = r6 instanceof com.google.protobuf.ByteString
            if (r7 == 0) goto L_0x00ec
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            int r6 = com.google.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x00ec:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.protobuf.CodedOutputStream.computeStringSize(r8, r6)
            goto L_0x03c4
        L_0x00f4:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeBoolSize(r8, r11)
            goto L_0x03c4
        L_0x0100:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x010c:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0118:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = m13948Z(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeInt32Size(r8, r6)
            goto L_0x03c4
        L_0x0128:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = m13949a0(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt64Size(r8, r6)
            goto L_0x03c4
        L_0x0138:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = m13949a0(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeInt64Size(r8, r6)
            goto L_0x03c4
        L_0x0148:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeFloatSize(r8, r12)
            goto L_0x03c4
        L_0x0154:
            boolean r6 = r15.m13931I(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = com.google.protobuf.CodedOutputStream.computeDoubleSize(r8, r6)
            goto L_0x03c4
        L_0x0162:
            com.google.protobuf.t r6 = r0.f20898q
            java.lang.Object r7 = com.google.protobuf.C3752t0.m13717F(r1, r9)
            java.lang.Object r9 = r15.m13978u(r4)
            int r6 = r6.mo24036f(r8, r7, r9)
            goto L_0x03c4
        L_0x0172:
            java.util.List r6 = m13933K(r1, r9)
            com.google.protobuf.m0 r7 = r15.m13980v(r4)
            int r6 = com.google.protobuf.C3726o0.m13564j(r8, r6, r7)
            goto L_0x03c4
        L_0x0180:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13574t(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x0194
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0194:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x019e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13572r(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x01b2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01b2:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x01bc:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13563i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x01d0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01d0:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x01da:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13561g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x01ee
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01ee:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x01f8:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13558e(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x020c
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x020c:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0216:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13577w(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x022a
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x022a:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0234:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13552b(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x0248
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0248:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0252:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13561g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x0266
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0266:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0270:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13563i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x0284
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0284:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x028e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13566l(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x02a2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02a2:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x02ac:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13579y(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x02c0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02c0:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x02c9:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13568n(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x02dd
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02dd:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x02e6:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13561g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x02fa
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02fa:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0303:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.C3726o0.m13563i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20890i
            if (r9 == 0) goto L_0x0317
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0317:
            int r6 = com.google.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
        L_0x031f:
            int r6 = r6 + r8
            int r6 = r6 + r7
            goto L_0x03c4
        L_0x0323:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13573s(r8, r6, r3)
            goto L_0x03c4
        L_0x032d:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13571q(r8, r6, r3)
            goto L_0x03c4
        L_0x0337:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13562h(r8, r6, r3)
            goto L_0x03c4
        L_0x0341:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13560f(r8, r6, r3)
            goto L_0x03c4
        L_0x034b:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13556d(r8, r6, r3)
            goto L_0x03c4
        L_0x0355:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13576v(r8, r6, r3)
            goto L_0x03c4
        L_0x035e:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13554c(r8, r6)
            goto L_0x03c4
        L_0x0367:
            java.util.List r6 = m13933K(r1, r9)
            com.google.protobuf.m0 r7 = r15.m13980v(r4)
            int r6 = com.google.protobuf.C3726o0.m13570p(r8, r6, r7)
            goto L_0x03c4
        L_0x0374:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13575u(r8, r6)
            goto L_0x03c4
        L_0x037d:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13550a(r8, r6, r3)
            goto L_0x03c4
        L_0x0386:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13560f(r8, r6, r3)
            goto L_0x03c4
        L_0x038f:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13562h(r8, r6, r3)
            goto L_0x03c4
        L_0x0398:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13565k(r8, r6, r3)
            goto L_0x03c4
        L_0x03a1:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13578x(r8, r6, r3)
            goto L_0x03c4
        L_0x03aa:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13567m(r8, r6, r3)
            goto L_0x03c4
        L_0x03b3:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13560f(r8, r6, r3)
            goto L_0x03c4
        L_0x03bc:
            java.util.List r6 = m13933K(r1, r9)
            int r6 = com.google.protobuf.C3726o0.m13562h(r8, r6, r3)
        L_0x03c4:
            int r5 = r5 + r6
            goto L_0x04df
        L_0x03c7:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r1, r9)
            com.google.protobuf.MessageLite r6 = (com.google.protobuf.MessageLite) r6
            com.google.protobuf.m0 r7 = r15.m13980v(r4)
            int r6 = com.google.protobuf.CodedOutputStream.m12479b(r8, r6, r7)
            goto L_0x03c4
        L_0x03dc:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.protobuf.C3752t0.m13715D(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeSInt64Size(r8, r6)
            goto L_0x03c4
        L_0x03eb:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.C3752t0.m13713B(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeSInt32Size(r8, r6)
            goto L_0x03c4
        L_0x03fa:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeSFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0405:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeSFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x0410:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.C3752t0.m13713B(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeEnumSize(r8, r6)
            goto L_0x03c4
        L_0x041f:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.C3752t0.m13713B(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt32Size(r8, r6)
            goto L_0x03c4
        L_0x042e:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r1, r9)
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            int r6 = com.google.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x043f:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r1, r9)
            com.google.protobuf.m0 r7 = r15.m13980v(r4)
            int r6 = com.google.protobuf.C3726o0.m13569o(r8, r6, r7)
            goto L_0x03c4
        L_0x0453:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.C3752t0.m13717F(r1, r9)
            boolean r7 = r6 instanceof com.google.protobuf.ByteString
            if (r7 == 0) goto L_0x0469
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            int r6 = com.google.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x0469:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.protobuf.CodedOutputStream.computeStringSize(r8, r6)
            goto L_0x03c4
        L_0x0471:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeBoolSize(r8, r11)
            goto L_0x03c4
        L_0x047d:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x0489:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0495:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.C3752t0.m13713B(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeInt32Size(r8, r6)
            goto L_0x03c4
        L_0x04a5:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.protobuf.C3752t0.m13715D(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeUInt64Size(r8, r6)
            goto L_0x03c4
        L_0x04b5:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.protobuf.C3752t0.m13715D(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.computeInt64Size(r8, r6)
            goto L_0x03c4
        L_0x04c5:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.computeFloatSize(r8, r12)
            goto L_0x03c4
        L_0x04d1:
            boolean r6 = r15.m13925C(r1, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = com.google.protobuf.CodedOutputStream.computeDoubleSize(r8, r6)
            goto L_0x03c4
        L_0x04df:
            int r4 = r4 + 3
            goto L_0x0008
        L_0x04e3:
            com.google.protobuf.r0<?, ?> r2 = r0.f20896o
            int r1 = r15.m13988z(r2, r1)
            int r5 = r5 + r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.m13986y(java.lang.Object):int");
    }

    /* renamed from: y0 */
    private void m13987y0(int i, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.mo23787n(i, (String) obj);
        } else {
            writer.mo23795v(i, (ByteString) obj);
        }
    }

    /* renamed from: z */
    private <UT, UB> int m13988z(C3746r0<UT, UB> r0Var, T t) {
        return r0Var.mo24002h(r0Var.mo24001g(t));
    }

    /* renamed from: z0 */
    private <UT, UB> void m13989z0(C3746r0<UT, UB> r0Var, T t, Writer writer) {
        r0Var.mo24014t(r0Var.mo24001g(t), writer);
    }

    /* renamed from: a */
    public void mo23802a(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.f20882a.length; i += 3) {
            m13939Q(t, t2, i);
        }
        C3726o0.m13530G(this.f20896o, t, t2);
        if (this.f20887f) {
            C3726o0.m13528E(this.f20897p, t, t2);
        }
    }

    /* renamed from: b */
    public boolean mo23803b(T t, T t2) {
        int length = this.f20882a.length;
        for (int i = 0; i < length; i += 3) {
            if (!m13968p(t, t2, i)) {
                return false;
            }
        }
        if (!this.f20896o.mo24001g(t).equals(this.f20896o.mo24001g(t2))) {
            return false;
        }
        if (this.f20887f) {
            return this.f20897p.mo23893c(t).equals(this.f20897p.mo23893c(t2));
        }
        return true;
    }

    /* renamed from: c */
    public T mo23804c() {
        return this.f20894m.mo23812a(this.f20886e);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c1, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0225, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0226, code lost:
        r1 = r1 + 3;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo23805d(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f20882a
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022a
            int r3 = r8.m13977t0(r1)
            int r4 = r8.m13943U(r1)
            long r5 = m13944V(r3)
            int r3 = m13975s0(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0217;
                case 1: goto L_0x020c;
                case 2: goto L_0x0201;
                case 3: goto L_0x01f6;
                case 4: goto L_0x01ef;
                case 5: goto L_0x01e4;
                case 6: goto L_0x01dd;
                case 7: goto L_0x01d2;
                case 8: goto L_0x01c5;
                case 9: goto L_0x01b7;
                case 10: goto L_0x01ab;
                case 11: goto L_0x01a3;
                case 12: goto L_0x019b;
                case 13: goto L_0x0193;
                case 14: goto L_0x0187;
                case 15: goto L_0x017f;
                case 16: goto L_0x0173;
                case 17: goto L_0x0168;
                case 18: goto L_0x015c;
                case 19: goto L_0x015c;
                case 20: goto L_0x015c;
                case 21: goto L_0x015c;
                case 22: goto L_0x015c;
                case 23: goto L_0x015c;
                case 24: goto L_0x015c;
                case 25: goto L_0x015c;
                case 26: goto L_0x015c;
                case 27: goto L_0x015c;
                case 28: goto L_0x015c;
                case 29: goto L_0x015c;
                case 30: goto L_0x015c;
                case 31: goto L_0x015c;
                case 32: goto L_0x015c;
                case 33: goto L_0x015c;
                case 34: goto L_0x015c;
                case 35: goto L_0x015c;
                case 36: goto L_0x015c;
                case 37: goto L_0x015c;
                case 38: goto L_0x015c;
                case 39: goto L_0x015c;
                case 40: goto L_0x015c;
                case 41: goto L_0x015c;
                case 42: goto L_0x015c;
                case 43: goto L_0x015c;
                case 44: goto L_0x015c;
                case 45: goto L_0x015c;
                case 46: goto L_0x015c;
                case 47: goto L_0x015c;
                case 48: goto L_0x015c;
                case 49: goto L_0x015c;
                case 50: goto L_0x0150;
                case 51: goto L_0x013a;
                case 52: goto L_0x0128;
                case 53: goto L_0x0116;
                case 54: goto L_0x0104;
                case 55: goto L_0x00f6;
                case 56: goto L_0x00e4;
                case 57: goto L_0x00d6;
                case 58: goto L_0x00c4;
                case 59: goto L_0x00b0;
                case 60: goto L_0x009e;
                case 61: goto L_0x008c;
                case 62: goto L_0x007e;
                case 63: goto L_0x0070;
                case 64: goto L_0x0062;
                case 65: goto L_0x0050;
                case 66: goto L_0x0042;
                case 67: goto L_0x0030;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0226
        L_0x001e:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = com.google.protobuf.C3752t0.m13717F(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0030:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = m13949a0(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0042:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = m13948Z(r9, r5)
            goto L_0x0225
        L_0x0050:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = m13949a0(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0062:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = m13948Z(r9, r5)
            goto L_0x0225
        L_0x0070:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = m13948Z(r9, r5)
            goto L_0x0225
        L_0x007e:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = m13948Z(r9, r5)
            goto L_0x0225
        L_0x008c:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.C3752t0.m13717F(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x009e:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = com.google.protobuf.C3752t0.m13717F(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00b0:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.C3752t0.m13717F(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00c4:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            boolean r3 = m13945W(r9, r5)
            int r3 = com.google.protobuf.Internal.hashBoolean(r3)
            goto L_0x0225
        L_0x00d6:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = m13948Z(r9, r5)
            goto L_0x0225
        L_0x00e4:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = m13949a0(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x00f6:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = m13948Z(r9, r5)
            goto L_0x0225
        L_0x0104:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = m13949a0(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0116:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = m13949a0(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0128:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            float r3 = m13947Y(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x013a:
            boolean r3 = r8.m13931I(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            double r3 = m13946X(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0150:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.C3752t0.m13717F(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x015c:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.C3752t0.m13717F(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0168:
            java.lang.Object r3 = com.google.protobuf.C3752t0.m13717F(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
            goto L_0x01c1
        L_0x0173:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.C3752t0.m13715D(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x017f:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.C3752t0.m13713B(r9, r5)
            goto L_0x0225
        L_0x0187:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.C3752t0.m13715D(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0193:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.C3752t0.m13713B(r9, r5)
            goto L_0x0225
        L_0x019b:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.C3752t0.m13713B(r9, r5)
            goto L_0x0225
        L_0x01a3:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.C3752t0.m13713B(r9, r5)
            goto L_0x0225
        L_0x01ab:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.C3752t0.m13717F(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01b7:
            java.lang.Object r3 = com.google.protobuf.C3752t0.m13717F(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
        L_0x01c1:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0226
        L_0x01c5:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.C3752t0.m13717F(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01d2:
            int r2 = r2 * 53
            boolean r3 = com.google.protobuf.C3752t0.m13754s(r9, r5)
            int r3 = com.google.protobuf.Internal.hashBoolean(r3)
            goto L_0x0225
        L_0x01dd:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.C3752t0.m13713B(r9, r5)
            goto L_0x0225
        L_0x01e4:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.C3752t0.m13715D(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x01ef:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.C3752t0.m13713B(r9, r5)
            goto L_0x0225
        L_0x01f6:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.C3752t0.m13715D(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0201:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.C3752t0.m13715D(r9, r5)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x020c:
            int r2 = r2 * 53
            float r3 = com.google.protobuf.C3752t0.m13712A(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x0217:
            int r2 = r2 * 53
            double r3 = com.google.protobuf.C3752t0.m13761z(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.protobuf.Internal.hashLong(r3)
        L_0x0225:
            int r2 = r2 + r3
        L_0x0226:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022a:
            int r2 = r2 * 53
            com.google.protobuf.r0<?, ?> r0 = r8.f20896o
            java.lang.Object r0 = r0.mo24001g(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f20887f
            if (r0 == 0) goto L_0x0248
            int r2 = r2 * 53
            com.google.protobuf.j<?> r0 = r8.f20897p
            com.google.protobuf.FieldSet r9 = r0.mo23893c(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0248:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.mo23805d(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0345, code lost:
        if (r0 != r15) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x038e, code lost:
        if (r0 != r15) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03b1, code lost:
        if (r0 != r15) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x03b4, code lost:
        r2 = r0;
        r8 = r18;
        r0 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f9, code lost:
        r12 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015f, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01fb, code lost:
        r6 = r6 | r20;
        r2 = r8;
        r3 = r13;
        r1 = r17;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0223, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0259, code lost:
        r6 = r6 | r20;
        r2 = r8;
        r0 = r11;
        r3 = r13;
        r1 = r17;
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0262, code lost:
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0294, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0296, code lost:
        r6 = r6 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0298, code lost:
        r11 = r34;
        r2 = r8;
        r3 = r13;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02a0, code lost:
        r0 = r34;
        r22 = r6;
        r19 = r7;
        r20 = r8;
        r28 = r10;
        r2 = r11;
        r8 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03ea  */
    /* renamed from: d0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo24077d0(T r30, byte[] r31, int r32, int r33, int r34, com.google.protobuf.C3689c.C3691b r35) {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = f20881s
            r16 = 0
            r0 = r32
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            if (r0 >= r13) goto L_0x040d
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.protobuf.C3689c.m13165H(r0, r12, r3, r9)
            int r3 = r9.f20752a
            r4 = r0
            r5 = r3
            goto L_0x002a
        L_0x0028:
            r5 = r0
            r4 = r3
        L_0x002a:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x0037
            int r2 = r2 / r8
            int r1 = r15.m13955h0(r3, r2)
            goto L_0x003b
        L_0x0037:
            int r1 = r15.m13954g0(r3)
        L_0x003b:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004e
            r17 = r3
            r2 = r4
            r8 = r5
            r22 = r6
            r19 = r7
            r28 = r10
            r0 = r11
            r20 = 0
            goto L_0x03b9
        L_0x004e:
            int[] r1 = r15.f20882a
            int r18 = r2 + 1
            r1 = r1[r18]
            int r8 = m13975s0(r1)
            long r11 = m13944V(r1)
            r18 = r5
            r5 = 17
            r19 = r1
            if (r8 > r5) goto L_0x02ae
            int[] r5 = r15.f20882a
            int r20 = r2 + 2
            r5 = r5[r20]
            int r20 = r5 >>> 20
            r1 = 1
            int r20 = r1 << r20
            r22 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r22
            if (r5 == r7) goto L_0x0086
            r13 = -1
            r17 = r2
            if (r7 == r13) goto L_0x007f
            long r1 = (long) r7
            r10.putInt(r14, r1, r6)
        L_0x007f:
            long r1 = (long) r5
            int r6 = r10.getInt(r14, r1)
            r7 = r5
            goto L_0x0089
        L_0x0086:
            r17 = r2
            r13 = -1
        L_0x0089:
            r1 = 5
            switch(r8) {
                case 0: goto L_0x027e;
                case 1: goto L_0x0266;
                case 2: goto L_0x023f;
                case 3: goto L_0x023f;
                case 4: goto L_0x0226;
                case 5: goto L_0x0204;
                case 6: goto L_0x01e3;
                case 7: goto L_0x01c1;
                case 8: goto L_0x019c;
                case 9: goto L_0x0164;
                case 10: goto L_0x0148;
                case 11: goto L_0x0226;
                case 12: goto L_0x0117;
                case 13: goto L_0x01e3;
                case 14: goto L_0x0204;
                case 15: goto L_0x00fd;
                case 16: goto L_0x00dc;
                case 17: goto L_0x009a;
                default: goto L_0x008d;
            }
        L_0x008d:
            r12 = r31
            r11 = r4
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            goto L_0x02a0
        L_0x009a:
            r2 = 3
            if (r0 != r2) goto L_0x00d5
            int r0 = r3 << 3
            r5 = r0 | 4
            r2 = r17
            com.google.protobuf.m0 r0 = r15.m13980v(r2)
            r1 = r31
            r8 = r2
            r2 = r4
            r17 = r3
            r3 = r33
            r4 = r5
            r13 = r18
            r5 = r35
            int r0 = com.google.protobuf.C3689c.m13185n(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x00c2
            java.lang.Object r1 = r9.f20754c
            r10.putObject(r14, r11, r1)
            goto L_0x00cf
        L_0x00c2:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.f20754c
            java.lang.Object r1 = com.google.protobuf.Internal.m12793d(r1, r2)
            r10.putObject(r14, r11, r1)
        L_0x00cf:
            r6 = r6 | r20
            r12 = r31
            goto L_0x0298
        L_0x00d5:
            r8 = r17
            r13 = r18
            r17 = r3
            goto L_0x00f9
        L_0x00dc:
            r8 = r17
            r13 = r18
            r17 = r3
            if (r0 != 0) goto L_0x00f9
            r2 = r11
            r12 = r31
            int r11 = com.google.protobuf.C3689c.m13169L(r12, r4, r9)
            long r0 = r9.f20753b
            long r4 = com.google.protobuf.CodedInputStream.decodeZigZag64(r0)
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            goto L_0x0259
        L_0x00f9:
            r12 = r31
            goto L_0x015f
        L_0x00fd:
            r8 = r17
            r13 = r18
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != 0) goto L_0x015f
            int r0 = com.google.protobuf.C3689c.m13166I(r12, r4, r9)
            int r1 = r9.f20752a
            int r1 = com.google.protobuf.CodedInputStream.decodeZigZag32(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0296
        L_0x0117:
            r8 = r17
            r13 = r18
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != 0) goto L_0x015f
            int r0 = com.google.protobuf.C3689c.m13166I(r12, r4, r9)
            int r1 = r9.f20752a
            com.google.protobuf.Internal$EnumVerifier r4 = r15.m13976t(r8)
            if (r4 == 0) goto L_0x0143
            boolean r4 = r4.isInRange(r1)
            if (r4 == 0) goto L_0x0135
            goto L_0x0143
        L_0x0135:
            com.google.protobuf.UnknownFieldSetLite r2 = m13982w(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.mo23698n(r13, r1)
            goto L_0x0298
        L_0x0143:
            r10.putInt(r14, r2, r1)
            goto L_0x0296
        L_0x0148:
            r8 = r17
            r13 = r18
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != r1) goto L_0x015f
            int r0 = com.google.protobuf.C3689c.m13173b(r12, r4, r9)
            java.lang.Object r1 = r9.f20754c
            r10.putObject(r14, r2, r1)
            goto L_0x0296
        L_0x015f:
            r11 = r4
            r18 = -1
            goto L_0x02a0
        L_0x0164:
            r8 = r17
            r13 = r18
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != r1) goto L_0x0196
            com.google.protobuf.m0 r0 = r15.m13980v(r8)
            r11 = r33
            r18 = -1
            int r0 = com.google.protobuf.C3689c.m13187p(r0, r12, r4, r11, r9)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x0187
            java.lang.Object r1 = r9.f20754c
            r10.putObject(r14, r2, r1)
            goto L_0x01fb
        L_0x0187:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.f20754c
            java.lang.Object r1 = com.google.protobuf.Internal.m12793d(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x01fb
        L_0x0196:
            r11 = r33
            r18 = -1
            goto L_0x0223
        L_0x019c:
            r8 = r17
            r13 = r18
            r1 = 2
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            if (r0 != r1) goto L_0x0223
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r19 & r0
            if (r0 != 0) goto L_0x01b7
            int r0 = com.google.protobuf.C3689c.m13160C(r12, r4, r9)
            goto L_0x01bb
        L_0x01b7:
            int r0 = com.google.protobuf.C3689c.m13163F(r12, r4, r9)
        L_0x01bb:
            java.lang.Object r1 = r9.f20754c
            r10.putObject(r14, r2, r1)
            goto L_0x01fb
        L_0x01c1:
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            if (r0 != 0) goto L_0x0223
            int r0 = com.google.protobuf.C3689c.m13169L(r12, r4, r9)
            long r4 = r9.f20753b
            r23 = 0
            int r1 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r1 == 0) goto L_0x01de
            r1 = 1
            goto L_0x01df
        L_0x01de:
            r1 = 0
        L_0x01df:
            com.google.protobuf.C3752t0.m13722K(r14, r2, r1)
            goto L_0x01fb
        L_0x01e3:
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            if (r0 != r1) goto L_0x0223
            int r0 = com.google.protobuf.C3689c.m13179h(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x01fb:
            r6 = r6 | r20
            r2 = r8
            r3 = r13
            r1 = r17
            r13 = r11
            goto L_0x0262
        L_0x0204:
            r8 = r17
            r13 = r18
            r1 = 1
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            if (r0 != r1) goto L_0x0223
            long r21 = com.google.protobuf.C3689c.m13181j(r12, r4)
            r0 = r10
            r1 = r30
            r11 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x0294
        L_0x0223:
            r11 = r4
            goto L_0x02a0
        L_0x0226:
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            if (r0 != 0) goto L_0x02a0
            int r0 = com.google.protobuf.C3689c.m13166I(r12, r11, r9)
            int r1 = r9.f20752a
            r10.putInt(r14, r2, r1)
            goto L_0x0296
        L_0x023f:
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            if (r0 != 0) goto L_0x02a0
            int r11 = com.google.protobuf.C3689c.m13169L(r12, r11, r9)
            long r4 = r9.f20753b
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
        L_0x0259:
            r6 = r6 | r20
            r2 = r8
            r0 = r11
            r3 = r13
            r1 = r17
            r13 = r33
        L_0x0262:
            r11 = r34
            goto L_0x0017
        L_0x0266:
            r8 = r17
            r13 = r18
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            if (r0 != r1) goto L_0x02a0
            float r0 = com.google.protobuf.C3689c.m13183l(r12, r11)
            com.google.protobuf.C3752t0.m13730S(r14, r2, r0)
            int r0 = r11 + 4
            goto L_0x0296
        L_0x027e:
            r8 = r17
            r13 = r18
            r1 = 1
            r18 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            if (r0 != r1) goto L_0x02a0
            double r0 = com.google.protobuf.C3689c.m13175d(r12, r11)
            com.google.protobuf.C3752t0.m13729R(r14, r2, r0)
        L_0x0294:
            int r0 = r11 + 8
        L_0x0296:
            r6 = r6 | r20
        L_0x0298:
            r11 = r34
            r2 = r8
            r3 = r13
            r1 = r17
            goto L_0x02fd
        L_0x02a0:
            r0 = r34
            r22 = r6
            r19 = r7
            r20 = r8
            r28 = r10
            r2 = r11
            r8 = r13
            goto L_0x03b9
        L_0x02ae:
            r5 = r2
            r17 = r3
            r2 = r11
            r13 = r18
            r18 = -1
            r12 = r31
            r11 = r4
            r1 = 27
            if (r8 != r1) goto L_0x030e
            r1 = 2
            if (r0 != r1) goto L_0x0301
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.protobuf.Internal$ProtobufList r0 = (com.google.protobuf.Internal.ProtobufList) r0
            boolean r1 = r0.isModifiable()
            if (r1 != 0) goto L_0x02de
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02d5
            r1 = 10
            goto L_0x02d7
        L_0x02d5:
            int r1 = r1 * 2
        L_0x02d7:
            com.google.protobuf.Internal$ProtobufList r0 = r0.mutableCopyWithCapacity(r1)
            r10.putObject(r14, r2, r0)
        L_0x02de:
            r8 = r0
            com.google.protobuf.m0 r0 = r15.m13980v(r5)
            r1 = r13
            r2 = r31
            r3 = r11
            r4 = r33
            r20 = r5
            r5 = r8
            r22 = r6
            r6 = r35
            int r0 = com.google.protobuf.C3689c.m13188q(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r3 = r13
            r1 = r17
            r2 = r20
            r6 = r22
        L_0x02fd:
            r13 = r33
            goto L_0x0017
        L_0x0301:
            r20 = r5
            r22 = r6
            r19 = r7
            r28 = r10
            r15 = r11
            r18 = r13
            goto L_0x0391
        L_0x030e:
            r20 = r5
            r22 = r6
            r1 = 49
            if (r8 > r1) goto L_0x0361
            r1 = r19
            long r5 = (long) r1
            r4 = r0
            r0 = r29
            r1 = r30
            r23 = r2
            r2 = r31
            r3 = r11
            r32 = r4
            r4 = r33
            r25 = r5
            r5 = r13
            r6 = r17
            r19 = r7
            r7 = r32
            r27 = r8
            r8 = r20
            r28 = r10
            r9 = r25
            r15 = r11
            r11 = r27
            r18 = r13
            r12 = r23
            r14 = r35
            int r0 = r0.m13953f0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x03b4
        L_0x0347:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r17
            r3 = r18
            r7 = r19
            r2 = r20
            r6 = r22
        L_0x035d:
            r10 = r28
            goto L_0x0017
        L_0x0361:
            r32 = r0
            r23 = r2
            r27 = r8
            r28 = r10
            r15 = r11
            r18 = r13
            r1 = r19
            r19 = r7
            r0 = 50
            r9 = r27
            if (r9 != r0) goto L_0x0397
            r7 = r32
            r0 = 2
            if (r7 != r0) goto L_0x0391
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r20
            r6 = r23
            r8 = r35
            int r0 = r0.m13950b0(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x03b4
            goto L_0x0347
        L_0x0391:
            r0 = r34
            r2 = r15
            r8 = r18
            goto L_0x03b9
        L_0x0397:
            r7 = r32
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r17
            r10 = r23
            r12 = r20
            r13 = r35
            int r0 = r0.m13951c0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x03b4
            goto L_0x0347
        L_0x03b4:
            r2 = r0
            r8 = r18
            r0 = r34
        L_0x03b9:
            if (r8 != r0) goto L_0x03c7
            if (r0 == 0) goto L_0x03c7
            r9 = r29
            r10 = r0
            r0 = r2
            r3 = r8
            r7 = r19
            r6 = r22
            goto L_0x0415
        L_0x03c7:
            r9 = r29
            r10 = r0
            boolean r0 = r9.f20887f
            r11 = r35
            if (r0 == 0) goto L_0x03ea
            com.google.protobuf.ExtensionRegistryLite r0 = r11.f20755d
            com.google.protobuf.ExtensionRegistryLite r1 = com.google.protobuf.ExtensionRegistryLite.getEmptyRegistry()
            if (r0 == r1) goto L_0x03ea
            com.google.protobuf.MessageLite r5 = r9.f20886e
            com.google.protobuf.r0<?, ?> r6 = r9.f20896o
            r0 = r8
            r1 = r31
            r3 = r33
            r4 = r30
            r7 = r35
            int r0 = com.google.protobuf.C3689c.m13178g(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x03f9
        L_0x03ea:
            com.google.protobuf.UnknownFieldSetLite r4 = m13982w(r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.protobuf.C3689c.m13164G(r0, r1, r2, r3, r4, r5)
        L_0x03f9:
            r14 = r30
            r12 = r31
            r13 = r33
            r3 = r8
            r15 = r9
            r9 = r11
            r1 = r17
            r7 = r19
            r2 = r20
            r6 = r22
            r11 = r10
            goto L_0x035d
        L_0x040d:
            r22 = r6
            r19 = r7
            r28 = r10
            r10 = r11
            r9 = r15
        L_0x0415:
            r1 = -1
            if (r7 == r1) goto L_0x0421
            long r1 = (long) r7
            r4 = r30
            r5 = r28
            r5.putInt(r4, r1, r6)
            goto L_0x0423
        L_0x0421:
            r4 = r30
        L_0x0423:
            r1 = 0
            int r2 = r9.f20892k
        L_0x0426:
            int r5 = r9.f20893l
            if (r2 >= r5) goto L_0x0439
            int[] r5 = r9.f20891j
            r5 = r5[r2]
            com.google.protobuf.r0<?, ?> r6 = r9.f20896o
            java.lang.Object r1 = r9.m13970q(r4, r5, r1, r6)
            com.google.protobuf.UnknownFieldSetLite r1 = (com.google.protobuf.UnknownFieldSetLite) r1
            int r2 = r2 + 1
            goto L_0x0426
        L_0x0439:
            if (r1 == 0) goto L_0x0440
            com.google.protobuf.r0<?, ?> r2 = r9.f20896o
            r2.mo24009o(r4, r1)
        L_0x0440:
            if (r10 != 0) goto L_0x044c
            r1 = r33
            if (r0 != r1) goto L_0x0447
            goto L_0x0452
        L_0x0447:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.m12805g()
            throw r0
        L_0x044c:
            r1 = r33
            if (r0 > r1) goto L_0x0453
            if (r3 != r10) goto L_0x0453
        L_0x0452:
            return r0
        L_0x0453:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.m12805g()
            goto L_0x0459
        L_0x0458:
            throw r0
        L_0x0459:
            goto L_0x0458
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3769z.mo24077d0(java.lang.Object, byte[], int, int, int, com.google.protobuf.c$b):int");
    }

    /* renamed from: e */
    public void mo23806e(T t, Writer writer) {
        if (writer.mo23785l() == Writer.FieldOrder.DESCENDING) {
            m13983w0(t, writer);
        } else if (this.f20889h) {
            m13981v0(t, writer);
        } else {
            m13979u0(t, writer);
        }
    }

    /* renamed from: f */
    public void mo23807f(T t) {
        int i;
        int i2 = this.f20892k;
        while (true) {
            i = this.f20893l;
            if (i2 >= i) {
                break;
            }
            long V = m13944V(m13977t0(this.f20891j[i2]));
            Object F = C3752t0.m13717F(t, V);
            if (F != null) {
                C3752t0.m13733V(t, V, this.f20898q.mo24032b(F));
            }
            i2++;
        }
        int length = this.f20891j.length;
        while (i < length) {
            this.f20895n.mo23982c(t, (long) this.f20891j[i]);
            i++;
        }
        this.f20896o.mo24004j(t);
        if (this.f20887f) {
            this.f20897p.mo23896f(t);
        }
    }

    /* renamed from: g */
    public final boolean mo23808g(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f20892k; i4++) {
            int i5 = this.f20891j[i4];
            int U = m13943U(i5);
            int t0 = m13977t0(i5);
            if (!this.f20889h) {
                int i6 = this.f20882a[i5 + 2];
                int i7 = 1048575 & i6;
                i = 1 << (i6 >>> 20);
                if (i7 != i2) {
                    i3 = f20881s.getInt(t, (long) i7);
                    i2 = i7;
                }
            } else {
                i = 0;
            }
            if (m13932J(t0) && !m13926D(t, i5, i3, i)) {
                return false;
            }
            int s0 = m13975s0(t0);
            if (s0 != 9 && s0 != 17) {
                if (s0 != 27) {
                    if (s0 == 60 || s0 == 68) {
                        if (m13931I(t, U, i5) && !m13927E(t, t0, m13980v(i5))) {
                            return false;
                        }
                    } else if (s0 != 49) {
                        if (s0 == 50 && !m13929G(t, t0, i5)) {
                            return false;
                        }
                    }
                }
                if (!m13928F(t, t0, i5)) {
                    return false;
                }
            } else if (m13926D(t, i5, i3, i) && !m13927E(t, t0, m13980v(i5))) {
                return false;
            }
        }
        return !this.f20887f || this.f20897p.mo23893c(t).mo23295t();
    }

    /* renamed from: h */
    public void mo23809h(T t, C3714k0 k0Var, ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.getClass();
        m13935M(this.f20896o, this.f20897p, t, k0Var, extensionRegistryLite);
    }

    /* renamed from: i */
    public void mo23810i(T t, byte[] bArr, int i, int i2, C3689c.C3691b bVar) {
        if (this.f20889h) {
            m13952e0(t, bArr, i, i2, bVar);
        } else {
            mo24077d0(t, bArr, i, i2, 0, bVar);
        }
    }

    /* renamed from: j */
    public int mo23811j(T t) {
        return this.f20889h ? m13986y(t) : m13984x(t);
    }
}
