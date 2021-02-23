package com.google.protobuf;

import com.google.protobuf.Internal;

public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);
    
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;

    /* renamed from: b */
    private static final Internal.EnumLiteMap<Syntax> f20683b = null;

    /* renamed from: a */
    private final int f20685a;

    /* renamed from: com.google.protobuf.Syntax$a */
    static class C3667a implements Internal.EnumLiteMap<Syntax> {
        C3667a() {
        }

        /* renamed from: a */
        public Syntax findValueByNumber(int i) {
            return Syntax.forNumber(i);
        }
    }

    /* renamed from: com.google.protobuf.Syntax$b */
    private static final class C3668b implements Internal.EnumVerifier {

        /* renamed from: a */
        static final Internal.EnumVerifier f20686a = null;

        static {
            f20686a = new C3668b();
        }

        private C3668b() {
        }

        public boolean isInRange(int i) {
            return Syntax.forNumber(i) != null;
        }
    }

    static {
        f20683b = new C3667a();
    }

    private Syntax(int i) {
        this.f20685a = i;
    }

    public static Syntax forNumber(int i) {
        if (i == 0) {
            return SYNTAX_PROTO2;
        }
        if (i != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return f20683b;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return C3668b.f20686a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f20685a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static Syntax valueOf(int i) {
        return forNumber(i);
    }
}
