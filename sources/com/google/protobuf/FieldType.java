package com.google.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public enum FieldType {
    DOUBLE(0, r4, r8),
    FLOAT(1, r4, r9),
    INT64(2, r4, r5),
    UINT64(3, r4, r5),
    INT32(4, r4, r11),
    FIXED64(5, r4, r10),
    FIXED32(6, r4, r11),
    BOOL(7, r4, r12),
    STRING(8, r4, r13),
    MESSAGE(9, r4, r14),
    BYTES(10, r4, r15),
    UINT32(11, r4, r11),
    ENUM(12, r4, r16),
    SFIXED32(13, r4, r11),
    SFIXED64(14, r4, r10),
    SINT32(15, r4, r11),
    SINT64(16, r4, r10),
    GROUP(17, r4, r14),
    DOUBLE_LIST(18, r4, r8),
    FLOAT_LIST(19, r4, r9),
    INT64_LIST(20, r4, r5),
    UINT64_LIST(21, r4, r5),
    INT32_LIST(22, r4, r11),
    FIXED64_LIST(23, r4, r10),
    FIXED32_LIST(24, r4, r11),
    BOOL_LIST(25, r4, r12),
    STRING_LIST(26, r4, r13),
    MESSAGE_LIST(27, r4, r14),
    BYTES_LIST(28, r4, r15),
    UINT32_LIST(29, r4, r11),
    ENUM_LIST(30, r4, r16),
    SFIXED32_LIST(31, r4, r11),
    SFIXED64_LIST(32, r4, r10),
    SINT32_LIST(33, r4, r11),
    SINT64_LIST(34, r4, r10),
    DOUBLE_LIST_PACKED(35, r4, r8),
    FLOAT_LIST_PACKED(36, r4, r9),
    INT64_LIST_PACKED(37, r4, r5),
    UINT64_LIST_PACKED(38, r4, r5),
    INT32_LIST_PACKED(39, r4, r11),
    FIXED64_LIST_PACKED(40, r4, r10),
    FIXED32_LIST_PACKED(41, r4, r11),
    BOOL_LIST_PACKED(42, r4, r12),
    UINT32_LIST_PACKED(43, r4, r11),
    ENUM_LIST_PACKED(44, r4, r16),
    SFIXED32_LIST_PACKED(45, r4, r11),
    SFIXED64_LIST_PACKED(46, r4, r8),
    SINT32_LIST_PACKED(47, r4, JavaType.INT),
    SINT64_LIST_PACKED(48, r4, r8),
    GROUP_LIST(49, r7, r14),
    MAP(50, C3640b.MAP, JavaType.VOID);
    

    /* renamed from: f */
    private static final FieldType[] f20542f = null;

    /* renamed from: g */
    private static final Type[] f20543g = null;

    /* renamed from: a */
    private final JavaType f20545a;

    /* renamed from: b */
    private final int f20546b;

    /* renamed from: c */
    private final C3640b f20547c;

    /* renamed from: d */
    private final Class<?> f20548d;

    /* renamed from: e */
    private final boolean f20549e;

    /* renamed from: com.google.protobuf.FieldType$a */
    static /* synthetic */ class C3639a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20550a = null;

        /* renamed from: b */
        static final /* synthetic */ int[] f20551b = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.google.protobuf.JavaType[] r0 = com.google.protobuf.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20551b = r0
                r1 = 1
                com.google.protobuf.JavaType r2 = com.google.protobuf.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f20551b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.JavaType r3 = com.google.protobuf.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f20551b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.JavaType r4 = com.google.protobuf.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.protobuf.FieldType$b[] r3 = com.google.protobuf.FieldType.C3640b.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f20550a = r3
                com.google.protobuf.FieldType$b r4 = com.google.protobuf.FieldType.C3640b.MAP     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f20550a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.protobuf.FieldType$b r3 = com.google.protobuf.FieldType.C3640b.VECTOR     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f20550a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.google.protobuf.FieldType$b r1 = com.google.protobuf.FieldType.C3640b.SCALAR     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.FieldType.C3639a.<clinit>():void");
        }
    }

    /* renamed from: com.google.protobuf.FieldType$b */
    enum C3640b {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        

        /* renamed from: a */
        private final boolean f20557a;

        private C3640b(boolean z) {
            this.f20557a = z;
        }

        /* renamed from: a */
        public boolean mo23314a() {
            return this.f20557a;
        }
    }

    static {
        int i;
        f20543g = new Type[0];
        FieldType[] values = values();
        f20542f = new FieldType[values.length];
        for (FieldType fieldType : values) {
            f20542f[fieldType.f20546b] = fieldType;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r5 = com.google.protobuf.FieldType.C3639a.f20551b[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FieldType(int r4, com.google.protobuf.FieldType.C3640b r5, com.google.protobuf.JavaType r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r1.f20546b = r4
            r1.f20547c = r5
            r1.f20545a = r6
            int[] r2 = com.google.protobuf.FieldType.C3639a.f20550a
            int r3 = r5.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0022
            if (r2 == r3) goto L_0x001b
            r2 = 0
            r1.f20548d = r2
            goto L_0x0028
        L_0x001b:
            java.lang.Class r2 = r6.getBoxedType()
            r1.f20548d = r2
            goto L_0x0028
        L_0x0022:
            java.lang.Class r2 = r6.getBoxedType()
            r1.f20548d = r2
        L_0x0028:
            r2 = 0
            com.google.protobuf.FieldType$b r0 = com.google.protobuf.FieldType.C3640b.SCALAR
            if (r5 != r0) goto L_0x003d
            int[] r5 = com.google.protobuf.FieldType.C3639a.f20551b
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x003d
            if (r5 == r3) goto L_0x003d
            r3 = 3
            if (r5 == r3) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            r1.f20549e = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.FieldType.<init>(java.lang.String, int, int, com.google.protobuf.FieldType$b, com.google.protobuf.JavaType):void");
    }

    /* renamed from: a */
    private static Type m12737a(Class<?> cls) {
        for (Type type : cls.getGenericInterfaces()) {
            if (type instanceof ParameterizedType) {
                if (List.class.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                    return type;
                }
            }
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        if (List.class.isAssignableFrom((Class) ((ParameterizedType) genericSuperclass).getRawType())) {
            return genericSuperclass;
        }
        return null;
    }

    /* renamed from: b */
    private static Type m12738b(Class<?> cls, Type[] typeArr) {
        Class<? super Object> cls2;
        boolean z;
        while (true) {
            int i = 0;
            Class<? super Object> cls3 = cls;
            if (cls3 != List.class) {
                Type a = m12737a(cls3);
                if (!(a instanceof ParameterizedType)) {
                    typeArr = f20543g;
                    Class<? super Object>[] interfaces = cls3.getInterfaces();
                    int length = interfaces.length;
                    while (true) {
                        if (i >= length) {
                            cls2 = cls3.getSuperclass();
                            break;
                        }
                        Class<? super Object> cls4 = interfaces[i];
                        if (List.class.isAssignableFrom(cls4)) {
                            cls2 = cls4;
                            break;
                        }
                        i++;
                    }
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) a;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                        Type type = actualTypeArguments[i2];
                        if (type instanceof TypeVariable) {
                            TypeVariable[] typeParameters = cls3.getTypeParameters();
                            if (typeArr.length == typeParameters.length) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= typeParameters.length) {
                                        z = false;
                                        break;
                                    } else if (type == typeParameters[i3]) {
                                        actualTypeArguments[i2] = typeArr[i3];
                                        z = true;
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (!z) {
                                    throw new RuntimeException("Unable to find replacement for " + type);
                                }
                            } else {
                                throw new RuntimeException("Type array mismatch");
                            }
                        }
                    }
                    typeArr = actualTypeArguments;
                    cls2 = (Class) parameterizedType.getRawType();
                }
                cls3 = cls2;
            } else if (typeArr.length == 1) {
                return typeArr[0];
            } else {
                throw new RuntimeException("Unable to identify parameter type for List<T>");
            }
        }
    }

    /* renamed from: c */
    private boolean m12739c(Field field) {
        Class<?> type = field.getType();
        if (!this.f20545a.getType().isAssignableFrom(type)) {
            return false;
        }
        Type[] typeArr = f20543g;
        if (field.getGenericType() instanceof ParameterizedType) {
            typeArr = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        }
        Type b = m12738b(type, typeArr);
        if (!(b instanceof Class)) {
            return true;
        }
        return this.f20548d.isAssignableFrom((Class) b);
    }

    public static FieldType forId(int i) {
        if (i < 0) {
            return null;
        }
        FieldType[] fieldTypeArr = f20542f;
        if (i >= fieldTypeArr.length) {
            return null;
        }
        return fieldTypeArr[i];
    }

    public JavaType getJavaType() {
        return this.f20545a;
    }

    /* renamed from: id */
    public int mo23307id() {
        return this.f20546b;
    }

    public boolean isList() {
        return this.f20547c.mo23314a();
    }

    public boolean isMap() {
        return this.f20547c == C3640b.MAP;
    }

    public boolean isPacked() {
        return C3640b.PACKED_VECTOR.equals(this.f20547c);
    }

    public boolean isPrimitiveScalar() {
        return this.f20549e;
    }

    public boolean isScalar() {
        return this.f20547c == C3640b.SCALAR;
    }

    public boolean isValidForField(Field field) {
        if (C3640b.VECTOR.equals(this.f20547c)) {
            return m12739c(field);
        }
        return this.f20545a.getType().isAssignableFrom(field.getType());
    }
}
