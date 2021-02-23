package com.google.protobuf;

import com.google.protobuf.Internal;

public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    
    public static final int NULL_VALUE_VALUE = 0;

    /* renamed from: b */
    private static final Internal.EnumLiteMap<NullValue> f20649b = null;

    /* renamed from: a */
    private final int f20651a;

    /* renamed from: com.google.protobuf.NullValue$a */
    static class C3660a implements Internal.EnumLiteMap<NullValue> {
        C3660a() {
        }

        /* renamed from: a */
        public NullValue findValueByNumber(int i) {
            return NullValue.forNumber(i);
        }
    }

    /* renamed from: com.google.protobuf.NullValue$b */
    private static final class C3661b implements Internal.EnumVerifier {

        /* renamed from: a */
        static final Internal.EnumVerifier f20652a = null;

        static {
            f20652a = new C3661b();
        }

        private C3661b() {
        }

        public boolean isInRange(int i) {
            return NullValue.forNumber(i) != null;
        }
    }

    static {
        f20649b = new C3660a();
    }

    private NullValue(int i) {
        this.f20651a = i;
    }

    public static NullValue forNumber(int i) {
        if (i != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return f20649b;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return C3661b.f20652a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f20651a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static NullValue valueOf(int i) {
        return forNumber(i);
    }
}
