package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Field extends GeneratedMessageLite<Field, Builder> implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final Field f20485l;

    /* renamed from: m */
    private static volatile Parser<Field> f20486m;

    /* renamed from: b */
    private int f20487b;

    /* renamed from: c */
    private int f20488c;

    /* renamed from: d */
    private int f20489d;

    /* renamed from: e */
    private String f20490e = "";

    /* renamed from: f */
    private String f20491f = "";

    /* renamed from: g */
    private int f20492g;

    /* renamed from: h */
    private boolean f20493h;

    /* renamed from: i */
    private Internal.ProtobufList<Option> f20494i = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: j */
    private String f20495j = "";

    /* renamed from: k */
    private String f20496k = "";

    public static final class Builder extends GeneratedMessageLite.Builder<Field, Builder> implements FieldOrBuilder {
        /* synthetic */ Builder(C3635a aVar) {
            this();
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            copyOnWrite();
            ((Field) this.instance).m12625V(iterable);
            return this;
        }

        public Builder addOptions(Option option) {
            copyOnWrite();
            ((Field) this.instance).m12627X(option);
            return this;
        }

        public Builder clearCardinality() {
            copyOnWrite();
            ((Field) this.instance).m12628Y();
            return this;
        }

        public Builder clearDefaultValue() {
            copyOnWrite();
            ((Field) this.instance).m12629Z();
            return this;
        }

        public Builder clearJsonName() {
            copyOnWrite();
            ((Field) this.instance).m12630a0();
            return this;
        }

        public Builder clearKind() {
            copyOnWrite();
            ((Field) this.instance).m12631b0();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Field) this.instance).m12632c0();
            return this;
        }

        public Builder clearNumber() {
            copyOnWrite();
            ((Field) this.instance).m12633d0();
            return this;
        }

        public Builder clearOneofIndex() {
            copyOnWrite();
            ((Field) this.instance).m12634e0();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((Field) this.instance).m12635f0();
            return this;
        }

        public Builder clearPacked() {
            copyOnWrite();
            ((Field) this.instance).m12636g0();
            return this;
        }

        public Builder clearTypeUrl() {
            copyOnWrite();
            ((Field) this.instance).m12637h0();
            return this;
        }

        public Cardinality getCardinality() {
            return ((Field) this.instance).getCardinality();
        }

        public int getCardinalityValue() {
            return ((Field) this.instance).getCardinalityValue();
        }

        public String getDefaultValue() {
            return ((Field) this.instance).getDefaultValue();
        }

        public ByteString getDefaultValueBytes() {
            return ((Field) this.instance).getDefaultValueBytes();
        }

        public String getJsonName() {
            return ((Field) this.instance).getJsonName();
        }

        public ByteString getJsonNameBytes() {
            return ((Field) this.instance).getJsonNameBytes();
        }

        public Kind getKind() {
            return ((Field) this.instance).getKind();
        }

        public int getKindValue() {
            return ((Field) this.instance).getKindValue();
        }

        public String getName() {
            return ((Field) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Field) this.instance).getNameBytes();
        }

        public int getNumber() {
            return ((Field) this.instance).getNumber();
        }

        public int getOneofIndex() {
            return ((Field) this.instance).getOneofIndex();
        }

        public Option getOptions(int i) {
            return ((Field) this.instance).getOptions(i);
        }

        public int getOptionsCount() {
            return ((Field) this.instance).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Field) this.instance).getOptionsList());
        }

        public boolean getPacked() {
            return ((Field) this.instance).getPacked();
        }

        public String getTypeUrl() {
            return ((Field) this.instance).getTypeUrl();
        }

        public ByteString getTypeUrlBytes() {
            return ((Field) this.instance).getTypeUrlBytes();
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((Field) this.instance).m12639j0(i);
            return this;
        }

        public Builder setCardinality(Cardinality cardinality) {
            copyOnWrite();
            ((Field) this.instance).m12640k0(cardinality);
            return this;
        }

        public Builder setCardinalityValue(int i) {
            copyOnWrite();
            ((Field) this.instance).m12641l0(i);
            return this;
        }

        public Builder setDefaultValue(String str) {
            copyOnWrite();
            ((Field) this.instance).m12642m0(str);
            return this;
        }

        public Builder setDefaultValueBytes(ByteString byteString) {
            copyOnWrite();
            ((Field) this.instance).m12643n0(byteString);
            return this;
        }

        public Builder setJsonName(String str) {
            copyOnWrite();
            ((Field) this.instance).m12644o0(str);
            return this;
        }

        public Builder setJsonNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Field) this.instance).m12645p0(byteString);
            return this;
        }

        public Builder setKind(Kind kind) {
            copyOnWrite();
            ((Field) this.instance).m12647q0(kind);
            return this;
        }

        public Builder setKindValue(int i) {
            copyOnWrite();
            ((Field) this.instance).m12649r0(i);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Field) this.instance).m12651s0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Field) this.instance).m12653t0(byteString);
            return this;
        }

        public Builder setNumber(int i) {
            copyOnWrite();
            ((Field) this.instance).m12655u0(i);
            return this;
        }

        public Builder setOneofIndex(int i) {
            copyOnWrite();
            ((Field) this.instance).m12657v0(i);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            copyOnWrite();
            ((Field) this.instance).m12659w0(i, option);
            return this;
        }

        public Builder setPacked(boolean z) {
            copyOnWrite();
            ((Field) this.instance).m12661x0(z);
            return this;
        }

        public Builder setTypeUrl(String str) {
            copyOnWrite();
            ((Field) this.instance).m12663y0(str);
            return this;
        }

        public Builder setTypeUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((Field) this.instance).m12665z0(byteString);
            return this;
        }

        private Builder() {
            super(Field.f20485l);
        }

        public Builder addOptions(int i, Option option) {
            copyOnWrite();
            ((Field) this.instance).m12626W(i, option);
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Field) this.instance).m12659w0(i, (Option) builder.build());
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            copyOnWrite();
            ((Field) this.instance).m12627X((Option) builder.build());
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Field) this.instance).m12626W(i, (Option) builder.build());
            return this;
        }
    }

    public enum Cardinality implements Internal.EnumLite {
        CARDINALITY_UNKNOWN(0),
        CARDINALITY_OPTIONAL(1),
        CARDINALITY_REQUIRED(2),
        CARDINALITY_REPEATED(3),
        UNRECOGNIZED(-1);
        
        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;

        /* renamed from: b */
        private static final Internal.EnumLiteMap<Cardinality> f20497b = null;

        /* renamed from: a */
        private final int f20499a;

        /* renamed from: com.google.protobuf.Field$Cardinality$a */
        static class C3631a implements Internal.EnumLiteMap<Cardinality> {
            C3631a() {
            }

            /* renamed from: a */
            public Cardinality findValueByNumber(int i) {
                return Cardinality.forNumber(i);
            }
        }

        /* renamed from: com.google.protobuf.Field$Cardinality$b */
        private static final class C3632b implements Internal.EnumVerifier {

            /* renamed from: a */
            static final Internal.EnumVerifier f20500a = null;

            static {
                f20500a = new C3632b();
            }

            private C3632b() {
            }

            public boolean isInRange(int i) {
                return Cardinality.forNumber(i) != null;
            }
        }

        static {
            f20497b = new C3631a();
        }

        private Cardinality(int i) {
            this.f20499a = i;
        }

        public static Cardinality forNumber(int i) {
            if (i == 0) {
                return CARDINALITY_UNKNOWN;
            }
            if (i == 1) {
                return CARDINALITY_OPTIONAL;
            }
            if (i == 2) {
                return CARDINALITY_REQUIRED;
            }
            if (i != 3) {
                return null;
            }
            return CARDINALITY_REPEATED;
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return f20497b;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return C3632b.f20500a;
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.f20499a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Cardinality valueOf(int i) {
            return forNumber(i);
        }
    }

    public enum Kind implements Internal.EnumLite {
        TYPE_UNKNOWN(0),
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18),
        UNRECOGNIZED(-1);
        
        public static final int TYPE_BOOL_VALUE = 8;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final int TYPE_INT32_VALUE = 5;
        public static final int TYPE_INT64_VALUE = 3;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final int TYPE_STRING_VALUE = 9;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final int TYPE_UNKNOWN_VALUE = 0;

        /* renamed from: b */
        private static final Internal.EnumLiteMap<Kind> f20501b = null;

        /* renamed from: a */
        private final int f20503a;

        /* renamed from: com.google.protobuf.Field$Kind$a */
        static class C3633a implements Internal.EnumLiteMap<Kind> {
            C3633a() {
            }

            /* renamed from: a */
            public Kind findValueByNumber(int i) {
                return Kind.forNumber(i);
            }
        }

        /* renamed from: com.google.protobuf.Field$Kind$b */
        private static final class C3634b implements Internal.EnumVerifier {

            /* renamed from: a */
            static final Internal.EnumVerifier f20504a = null;

            static {
                f20504a = new C3634b();
            }

            private C3634b() {
            }

            public boolean isInRange(int i) {
                return Kind.forNumber(i) != null;
            }
        }

        static {
            f20501b = new C3633a();
        }

        private Kind(int i) {
            this.f20503a = i;
        }

        public static Kind forNumber(int i) {
            switch (i) {
                case 0:
                    return TYPE_UNKNOWN;
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return f20501b;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return C3634b.f20504a;
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.f20503a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Kind valueOf(int i) {
            return forNumber(i);
        }
    }

    /* renamed from: com.google.protobuf.Field$a */
    static /* synthetic */ class C3635a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20505a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20505a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20505a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20505a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20505a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20505a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20505a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20505a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Field.C3635a.<clinit>():void");
        }
    }

    static {
        Field field = new Field();
        f20485l = field;
        GeneratedMessageLite.registerDefaultInstance(Field.class, field);
    }

    private Field() {
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public void m12625V(Iterable<? extends Option> iterable) {
        m12638i0();
        AbstractMessageLite.addAll(iterable, this.f20494i);
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public void m12626W(int i, Option option) {
        option.getClass();
        m12638i0();
        this.f20494i.add(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public void m12627X(Option option) {
        option.getClass();
        m12638i0();
        this.f20494i.add(option);
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public void m12628Y() {
        this.f20488c = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public void m12629Z() {
        this.f20496k = getDefaultInstance().getDefaultValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: a0 */
    public void m12630a0() {
        this.f20495j = getDefaultInstance().getJsonName();
    }

    /* access modifiers changed from: private */
    /* renamed from: b0 */
    public void m12631b0() {
        this.f20487b = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public void m12632c0() {
        this.f20490e = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    /* renamed from: d0 */
    public void m12633d0() {
        this.f20489d = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: e0 */
    public void m12634e0() {
        this.f20492g = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: f0 */
    public void m12635f0() {
        this.f20494i = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* renamed from: g0 */
    public void m12636g0() {
        this.f20493h = false;
    }

    public static Field getDefaultInstance() {
        return f20485l;
    }

    /* access modifiers changed from: private */
    /* renamed from: h0 */
    public void m12637h0() {
        this.f20491f = getDefaultInstance().getTypeUrl();
    }

    /* renamed from: i0 */
    private void m12638i0() {
        if (!this.f20494i.isModifiable()) {
            this.f20494i = GeneratedMessageLite.mutableCopy(this.f20494i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j0 */
    public void m12639j0(int i) {
        m12638i0();
        this.f20494i.remove(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: k0 */
    public void m12640k0(Cardinality cardinality) {
        this.f20488c = cardinality.getNumber();
    }

    /* access modifiers changed from: private */
    /* renamed from: l0 */
    public void m12641l0(int i) {
        this.f20488c = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: m0 */
    public void m12642m0(String str) {
        str.getClass();
        this.f20496k = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: n0 */
    public void m12643n0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20496k = byteString.toStringUtf8();
    }

    public static Builder newBuilder() {
        return (Builder) f20485l.createBuilder();
    }

    /* access modifiers changed from: private */
    /* renamed from: o0 */
    public void m12644o0(String str) {
        str.getClass();
        this.f20495j = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: p0 */
    public void m12645p0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20495j = byteString.toStringUtf8();
    }

    public static Field parseDelimitedFrom(InputStream inputStream) {
        return (Field) GeneratedMessageLite.parseDelimitedFrom(f20485l, inputStream);
    }

    public static Field parseFrom(ByteBuffer byteBuffer) {
        return (Field) GeneratedMessageLite.parseFrom(f20485l, byteBuffer);
    }

    public static Parser<Field> parser() {
        return f20485l.getParserForType();
    }

    /* access modifiers changed from: private */
    /* renamed from: q0 */
    public void m12647q0(Kind kind) {
        this.f20487b = kind.getNumber();
    }

    /* access modifiers changed from: private */
    /* renamed from: r0 */
    public void m12649r0(int i) {
        this.f20487b = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: s0 */
    public void m12651s0(String str) {
        str.getClass();
        this.f20490e = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: t0 */
    public void m12653t0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20490e = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: u0 */
    public void m12655u0(int i) {
        this.f20489d = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: v0 */
    public void m12657v0(int i) {
        this.f20492g = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: w0 */
    public void m12659w0(int i, Option option) {
        option.getClass();
        m12638i0();
        this.f20494i.set(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: x0 */
    public void m12661x0(boolean z) {
        this.f20493h = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: y0 */
    public void m12663y0(String str) {
        str.getClass();
        this.f20491f = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: z0 */
    public void m12665z0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20491f = byteString.toStringUtf8();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3635a.f20505a[methodToInvoke.ordinal()]) {
            case 1:
                return new Field();
            case 2:
                return new Builder((C3635a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20485l, "\u0000\n\u0000\u0000\u0001\u000b\n\u0000\u0001\u0000\u0001\f\u0002\f\u0003\u0004\u0004Ȉ\u0006Ȉ\u0007\u0004\b\u0007\t\u001b\nȈ\u000bȈ", new Object[]{"kind_", "cardinality_", "number_", "name_", "typeUrl_", "oneofIndex_", "packed_", "options_", Option.class, "jsonName_", "defaultValue_"});
            case 4:
                return f20485l;
            case 5:
                Parser<Field> parser = f20486m;
                if (parser == null) {
                    synchronized (Field.class) {
                        parser = f20486m;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20485l);
                            f20486m = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public Cardinality getCardinality() {
        Cardinality forNumber = Cardinality.forNumber(this.f20488c);
        return forNumber == null ? Cardinality.UNRECOGNIZED : forNumber;
    }

    public int getCardinalityValue() {
        return this.f20488c;
    }

    public String getDefaultValue() {
        return this.f20496k;
    }

    public ByteString getDefaultValueBytes() {
        return ByteString.copyFromUtf8(this.f20496k);
    }

    public String getJsonName() {
        return this.f20495j;
    }

    public ByteString getJsonNameBytes() {
        return ByteString.copyFromUtf8(this.f20495j);
    }

    public Kind getKind() {
        Kind forNumber = Kind.forNumber(this.f20487b);
        return forNumber == null ? Kind.UNRECOGNIZED : forNumber;
    }

    public int getKindValue() {
        return this.f20487b;
    }

    public String getName() {
        return this.f20490e;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f20490e);
    }

    public int getNumber() {
        return this.f20489d;
    }

    public int getOneofIndex() {
        return this.f20492g;
    }

    public Option getOptions(int i) {
        return this.f20494i.get(i);
    }

    public int getOptionsCount() {
        return this.f20494i.size();
    }

    public List<Option> getOptionsList() {
        return this.f20494i;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.f20494i.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.f20494i;
    }

    public boolean getPacked() {
        return this.f20493h;
    }

    public String getTypeUrl() {
        return this.f20491f;
    }

    public ByteString getTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.f20491f);
    }

    public static Builder newBuilder(Field field) {
        return (Builder) f20485l.createBuilder(field);
    }

    public static Field parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.parseDelimitedFrom(f20485l, inputStream, extensionRegistryLite);
    }

    public static Field parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.parseFrom(f20485l, byteBuffer, extensionRegistryLite);
    }

    public static Field parseFrom(ByteString byteString) {
        return (Field) GeneratedMessageLite.parseFrom(f20485l, byteString);
    }

    public static Field parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.parseFrom(f20485l, byteString, extensionRegistryLite);
    }

    public static Field parseFrom(byte[] bArr) {
        return (Field) GeneratedMessageLite.parseFrom(f20485l, bArr);
    }

    public static Field parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.parseFrom(f20485l, bArr, extensionRegistryLite);
    }

    public static Field parseFrom(InputStream inputStream) {
        return (Field) GeneratedMessageLite.parseFrom(f20485l, inputStream);
    }

    public static Field parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.parseFrom(f20485l, inputStream, extensionRegistryLite);
    }

    public static Field parseFrom(CodedInputStream codedInputStream) {
        return (Field) GeneratedMessageLite.parseFrom(f20485l, codedInputStream);
    }

    public static Field parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.parseFrom(f20485l, codedInputStream, extensionRegistryLite);
    }
}
