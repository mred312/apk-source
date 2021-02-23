package com.google.protobuf;

import com.google.protobuf.Internal;
import java.lang.reflect.Field;

final class FieldInfo implements Comparable<FieldInfo> {

    /* renamed from: a */
    private final Field f20506a;

    /* renamed from: b */
    private final FieldType f20507b;

    /* renamed from: c */
    private final Class<?> f20508c;

    /* renamed from: d */
    private final int f20509d;

    /* renamed from: e */
    private final Field f20510e;

    /* renamed from: f */
    private final int f20511f;

    /* renamed from: g */
    private final boolean f20512g;

    /* renamed from: h */
    private final boolean f20513h;

    /* renamed from: i */
    private final C3702f0 f20514i;

    /* renamed from: j */
    private final Field f20515j;

    /* renamed from: k */
    private final Class<?> f20516k;

    /* renamed from: l */
    private final Object f20517l;

    /* renamed from: m */
    private final Internal.EnumVerifier f20518m;

    public static final class Builder {

        /* renamed from: a */
        private Field f20519a;

        /* renamed from: b */
        private FieldType f20520b;

        /* renamed from: c */
        private int f20521c;

        /* renamed from: d */
        private Field f20522d;

        /* renamed from: e */
        private int f20523e;

        /* renamed from: f */
        private boolean f20524f;

        /* renamed from: g */
        private boolean f20525g;

        /* renamed from: h */
        private C3702f0 f20526h;

        /* renamed from: i */
        private Class<?> f20527i;

        /* renamed from: j */
        private Object f20528j;

        /* renamed from: k */
        private Internal.EnumVerifier f20529k;

        /* renamed from: l */
        private Field f20530l;

        private Builder() {
        }

        public FieldInfo build() {
            C3702f0 f0Var = this.f20526h;
            if (f0Var != null) {
                return FieldInfo.m12672f(this.f20521c, this.f20520b, f0Var, this.f20527i, this.f20525g, this.f20529k);
            }
            Object obj = this.f20528j;
            if (obj != null) {
                return FieldInfo.m12671e(this.f20519a, this.f20521c, obj, this.f20529k);
            }
            Field field = this.f20522d;
            if (field == null) {
                Internal.EnumVerifier enumVerifier = this.f20529k;
                if (enumVerifier != null) {
                    Field field2 = this.f20530l;
                    if (field2 == null) {
                        return FieldInfo.m12670d(this.f20519a, this.f20521c, this.f20520b, enumVerifier);
                    }
                    return FieldInfo.m12674h(this.f20519a, this.f20521c, this.f20520b, enumVerifier, field2);
                }
                Field field3 = this.f20530l;
                if (field3 == null) {
                    return FieldInfo.m12669c(this.f20519a, this.f20521c, this.f20520b, this.f20525g);
                }
                return FieldInfo.m12673g(this.f20519a, this.f20521c, this.f20520b, field3);
            } else if (this.f20524f) {
                return FieldInfo.m12676j(this.f20519a, this.f20521c, this.f20520b, field, this.f20523e, this.f20525g, this.f20529k);
            } else {
                return FieldInfo.m12675i(this.f20519a, this.f20521c, this.f20520b, field, this.f20523e, this.f20525g, this.f20529k);
            }
        }

        public Builder withCachedSizeField(Field field) {
            this.f20530l = field;
            return this;
        }

        public Builder withEnforceUtf8(boolean z) {
            this.f20525g = z;
            return this;
        }

        public Builder withEnumVerifier(Internal.EnumVerifier enumVerifier) {
            this.f20529k = enumVerifier;
            return this;
        }

        public Builder withField(Field field) {
            if (this.f20526h == null) {
                this.f20519a = field;
                return this;
            }
            throw new IllegalStateException("Cannot set field when building a oneof.");
        }

        public Builder withFieldNumber(int i) {
            this.f20521c = i;
            return this;
        }

        public Builder withMapDefaultEntry(Object obj) {
            this.f20528j = obj;
            return this;
        }

        public Builder withOneof(C3702f0 f0Var, Class<?> cls) {
            if (this.f20519a == null && this.f20522d == null) {
                this.f20527i = cls;
                return this;
            }
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        }

        public Builder withPresence(Field field, int i) {
            Internal.m12791b(field, "presenceField");
            this.f20522d = field;
            this.f20523e = i;
            return this;
        }

        public Builder withRequired(boolean z) {
            this.f20524f = z;
            return this;
        }

        public Builder withType(FieldType fieldType) {
            this.f20520b = fieldType;
            return this;
        }
    }

    /* renamed from: com.google.protobuf.FieldInfo$a */
    static /* synthetic */ class C3636a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20531a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.protobuf.FieldType[] r0 = com.google.protobuf.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20531a = r0
                com.google.protobuf.FieldType r1 = com.google.protobuf.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20531a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.FieldType r1 = com.google.protobuf.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20531a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.FieldType r1 = com.google.protobuf.FieldType.MESSAGE_LIST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20531a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.FieldType r1 = com.google.protobuf.FieldType.GROUP_LIST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.FieldInfo.C3636a.<clinit>():void");
        }
    }

    private FieldInfo(Field field, int i, FieldType fieldType, Class<?> cls, Field field2, int i2, boolean z, boolean z2, C3702f0 f0Var, Class<?> cls2, Object obj, Internal.EnumVerifier enumVerifier, Field field3) {
        this.f20506a = field;
        this.f20507b = fieldType;
        this.f20508c = cls;
        this.f20509d = i;
        this.f20510e = field2;
        this.f20511f = i2;
        this.f20512g = z;
        this.f20513h = z2;
        this.f20516k = cls2;
        this.f20517l = obj;
        this.f20518m = enumVerifier;
        this.f20515j = field3;
    }

    /* renamed from: a */
    private static void m12668a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: " + i);
        }
    }

    /* renamed from: c */
    public static FieldInfo m12669c(Field field, int i, FieldType fieldType, boolean z) {
        FieldType fieldType2 = fieldType;
        m12668a(i);
        Field field2 = field;
        Internal.m12791b(field, "field");
        Internal.m12791b(fieldType2, "fieldType");
        if (fieldType2 != FieldType.MESSAGE_LIST && fieldType2 != FieldType.GROUP_LIST) {
            return new FieldInfo(field, i, fieldType, (Class<?>) null, (Field) null, 0, false, z, (C3702f0) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, (Field) null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    /* renamed from: d */
    public static FieldInfo m12670d(Field field, int i, FieldType fieldType, Internal.EnumVerifier enumVerifier) {
        m12668a(i);
        Internal.m12791b(field, "field");
        return new FieldInfo(field, i, fieldType, (Class<?>) null, (Field) null, 0, false, false, (C3702f0) null, (Class<?>) null, (Object) null, enumVerifier, (Field) null);
    }

    /* renamed from: e */
    public static FieldInfo m12671e(Field field, int i, Object obj, Internal.EnumVerifier enumVerifier) {
        Object obj2 = obj;
        Internal.m12791b(obj2, "mapDefaultEntry");
        m12668a(i);
        Internal.m12791b(field, "field");
        return new FieldInfo(field, i, FieldType.MAP, (Class<?>) null, (Field) null, 0, false, true, (C3702f0) null, (Class<?>) null, obj2, enumVerifier, (Field) null);
    }

    /* renamed from: f */
    public static FieldInfo m12672f(int i, FieldType fieldType, C3702f0 f0Var, Class<?> cls, boolean z, Internal.EnumVerifier enumVerifier) {
        FieldType fieldType2 = fieldType;
        m12668a(i);
        Internal.m12791b(fieldType2, "fieldType");
        Internal.m12791b(f0Var, "oneof");
        Internal.m12791b(cls, "oneofStoredType");
        if (fieldType.isScalar()) {
            return new FieldInfo((Field) null, i, fieldType, (Class<?>) null, (Field) null, 0, false, z, f0Var, cls, (Object) null, enumVerifier, (Field) null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Oneof is only supported for scalar fields. Field ");
        int i2 = i;
        sb.append(i);
        sb.append(" is of type ");
        sb.append(fieldType2);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: g */
    public static FieldInfo m12673g(Field field, int i, FieldType fieldType, Field field2) {
        FieldType fieldType2 = fieldType;
        m12668a(i);
        Field field3 = field;
        Internal.m12791b(field, "field");
        Internal.m12791b(fieldType2, "fieldType");
        if (fieldType2 != FieldType.MESSAGE_LIST && fieldType2 != FieldType.GROUP_LIST) {
            return new FieldInfo(field, i, fieldType, (Class<?>) null, (Field) null, 0, false, false, (C3702f0) null, (Class<?>) null, (Object) null, (Internal.EnumVerifier) null, field2);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    /* renamed from: h */
    public static FieldInfo m12674h(Field field, int i, FieldType fieldType, Internal.EnumVerifier enumVerifier, Field field2) {
        m12668a(i);
        Internal.m12791b(field, "field");
        return new FieldInfo(field, i, fieldType, (Class<?>) null, (Field) null, 0, false, false, (C3702f0) null, (Class<?>) null, (Object) null, enumVerifier, field2);
    }

    /* renamed from: i */
    public static FieldInfo m12675i(Field field, int i, FieldType fieldType, Field field2, int i2, boolean z, Internal.EnumVerifier enumVerifier) {
        Field field3 = field2;
        m12668a(i);
        Field field4 = field;
        Internal.m12791b(field, "field");
        Internal.m12791b(fieldType, "fieldType");
        Internal.m12791b(field3, "presenceField");
        if (field3 == null || m12677v(i2)) {
            int i3 = i2;
            return new FieldInfo(field, i, fieldType, (Class<?>) null, field2, i2, false, z, (C3702f0) null, (Class<?>) null, (Object) null, enumVerifier, (Field) null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i2);
    }

    /* renamed from: j */
    public static FieldInfo m12676j(Field field, int i, FieldType fieldType, Field field2, int i2, boolean z, Internal.EnumVerifier enumVerifier) {
        Field field3 = field2;
        m12668a(i);
        Field field4 = field;
        Internal.m12791b(field, "field");
        Internal.m12791b(fieldType, "fieldType");
        Internal.m12791b(field3, "presenceField");
        if (field3 == null || m12677v(i2)) {
            int i3 = i2;
            return new FieldInfo(field, i, fieldType, (Class<?>) null, field2, i2, true, z, (C3702f0) null, (Class<?>) null, (Object) null, enumVerifier, (Field) null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i2);
    }

    /* renamed from: v */
    private static boolean m12677v(int i) {
        return i != 0 && (i & (i + -1)) == 0;
    }

    /* renamed from: b */
    public int compareTo(FieldInfo fieldInfo) {
        return this.f20509d - fieldInfo.f20509d;
    }

    /* renamed from: k */
    public Field mo23246k() {
        return this.f20515j;
    }

    /* renamed from: l */
    public Internal.EnumVerifier mo23247l() {
        return this.f20518m;
    }

    /* renamed from: m */
    public Field mo23248m() {
        return this.f20506a;
    }

    /* renamed from: n */
    public int mo23249n() {
        return this.f20509d;
    }

    /* renamed from: o */
    public Object mo23250o() {
        return this.f20517l;
    }

    /* renamed from: p */
    public Class<?> mo23251p() {
        int i = C3636a.f20531a[this.f20507b.ordinal()];
        if (i == 1 || i == 2) {
            Field field = this.f20506a;
            return field != null ? field.getType() : this.f20516k;
        } else if (i == 3 || i == 4) {
            return this.f20508c;
        } else {
            return null;
        }
    }

    /* renamed from: q */
    public C3702f0 mo23252q() {
        return this.f20514i;
    }

    /* renamed from: r */
    public Field mo23253r() {
        return this.f20510e;
    }

    /* renamed from: s */
    public int mo23254s() {
        return this.f20511f;
    }

    /* renamed from: t */
    public FieldType mo23255t() {
        return this.f20507b;
    }

    /* renamed from: u */
    public boolean mo23256u() {
        return this.f20513h;
    }

    /* renamed from: w */
    public boolean mo23257w() {
        return this.f20512g;
    }
}
