package com.google.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Value f20722d;

    /* renamed from: e */
    private static volatile Parser<Value> f20723e;

    /* renamed from: b */
    private int f20724b = 0;

    /* renamed from: c */
    private Object f20725c;

    public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
        /* synthetic */ Builder(C3675a aVar) {
            this();
        }

        public Builder clearBoolValue() {
            copyOnWrite();
            ((Value) this.instance).m13065I();
            return this;
        }

        public Builder clearKind() {
            copyOnWrite();
            ((Value) this.instance).m13066J();
            return this;
        }

        public Builder clearListValue() {
            copyOnWrite();
            ((Value) this.instance).m13067K();
            return this;
        }

        public Builder clearNullValue() {
            copyOnWrite();
            ((Value) this.instance).m13068L();
            return this;
        }

        public Builder clearNumberValue() {
            copyOnWrite();
            ((Value) this.instance).m13069M();
            return this;
        }

        public Builder clearStringValue() {
            copyOnWrite();
            ((Value) this.instance).m13070N();
            return this;
        }

        public Builder clearStructValue() {
            copyOnWrite();
            ((Value) this.instance).m13071O();
            return this;
        }

        public boolean getBoolValue() {
            return ((Value) this.instance).getBoolValue();
        }

        public KindCase getKindCase() {
            return ((Value) this.instance).getKindCase();
        }

        public ListValue getListValue() {
            return ((Value) this.instance).getListValue();
        }

        public NullValue getNullValue() {
            return ((Value) this.instance).getNullValue();
        }

        public int getNullValueValue() {
            return ((Value) this.instance).getNullValueValue();
        }

        public double getNumberValue() {
            return ((Value) this.instance).getNumberValue();
        }

        public String getStringValue() {
            return ((Value) this.instance).getStringValue();
        }

        public ByteString getStringValueBytes() {
            return ((Value) this.instance).getStringValueBytes();
        }

        public Struct getStructValue() {
            return ((Value) this.instance).getStructValue();
        }

        public boolean hasListValue() {
            return ((Value) this.instance).hasListValue();
        }

        public boolean hasStructValue() {
            return ((Value) this.instance).hasStructValue();
        }

        public Builder mergeListValue(ListValue listValue) {
            copyOnWrite();
            ((Value) this.instance).m13072P(listValue);
            return this;
        }

        public Builder mergeStructValue(Struct struct) {
            copyOnWrite();
            ((Value) this.instance).m13073Q(struct);
            return this;
        }

        public Builder setBoolValue(boolean z) {
            copyOnWrite();
            ((Value) this.instance).m13074R(z);
            return this;
        }

        public Builder setListValue(ListValue listValue) {
            copyOnWrite();
            ((Value) this.instance).m13075S(listValue);
            return this;
        }

        public Builder setNullValue(NullValue nullValue) {
            copyOnWrite();
            ((Value) this.instance).m13076T(nullValue);
            return this;
        }

        public Builder setNullValueValue(int i) {
            copyOnWrite();
            ((Value) this.instance).m13077U(i);
            return this;
        }

        public Builder setNumberValue(double d) {
            copyOnWrite();
            ((Value) this.instance).m13078V(d);
            return this;
        }

        public Builder setStringValue(String str) {
            copyOnWrite();
            ((Value) this.instance).m13079W(str);
            return this;
        }

        public Builder setStringValueBytes(ByteString byteString) {
            copyOnWrite();
            ((Value) this.instance).m13080X(byteString);
            return this;
        }

        public Builder setStructValue(Struct struct) {
            copyOnWrite();
            ((Value) this.instance).m13081Y(struct);
            return this;
        }

        private Builder() {
            super(Value.f20722d);
        }

        public Builder setListValue(ListValue.Builder builder) {
            copyOnWrite();
            ((Value) this.instance).m13075S((ListValue) builder.build());
            return this;
        }

        public Builder setStructValue(Struct.Builder builder) {
            copyOnWrite();
            ((Value) this.instance).m13081Y((Struct) builder.build());
            return this;
        }
    }

    public enum KindCase {
        NULL_VALUE(1),
        NUMBER_VALUE(2),
        STRING_VALUE(3),
        BOOL_VALUE(4),
        STRUCT_VALUE(5),
        LIST_VALUE(6),
        KIND_NOT_SET(0);
        

        /* renamed from: a */
        private final int f20727a;

        private KindCase(int i) {
            this.f20727a = i;
        }

        public static KindCase forNumber(int i) {
            switch (i) {
                case 0:
                    return KIND_NOT_SET;
                case 1:
                    return NULL_VALUE;
                case 2:
                    return NUMBER_VALUE;
                case 3:
                    return STRING_VALUE;
                case 4:
                    return BOOL_VALUE;
                case 5:
                    return STRUCT_VALUE;
                case 6:
                    return LIST_VALUE;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.f20727a;
        }

        @Deprecated
        public static KindCase valueOf(int i) {
            return forNumber(i);
        }
    }

    /* renamed from: com.google.protobuf.Value$a */
    static /* synthetic */ class C3675a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20728a;

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
                f20728a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20728a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20728a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20728a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20728a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20728a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20728a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Value.C3675a.<clinit>():void");
        }
    }

    static {
        Value value = new Value();
        f20722d = value;
        GeneratedMessageLite.registerDefaultInstance(Value.class, value);
    }

    private Value() {
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public void m13065I() {
        if (this.f20724b == 4) {
            this.f20724b = 0;
            this.f20725c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public void m13066J() {
        this.f20724b = 0;
        this.f20725c = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public void m13067K() {
        if (this.f20724b == 6) {
            this.f20724b = 0;
            this.f20725c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public void m13068L() {
        if (this.f20724b == 1) {
            this.f20724b = 0;
            this.f20725c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public void m13069M() {
        if (this.f20724b == 2) {
            this.f20724b = 0;
            this.f20725c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public void m13070N() {
        if (this.f20724b == 3) {
            this.f20724b = 0;
            this.f20725c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m13071O() {
        if (this.f20724b == 5) {
            this.f20724b = 0;
            this.f20725c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public void m13072P(ListValue listValue) {
        listValue.getClass();
        if (this.f20724b != 6 || this.f20725c == ListValue.getDefaultInstance()) {
            this.f20725c = listValue;
        } else {
            this.f20725c = ((ListValue.Builder) ListValue.newBuilder((ListValue) this.f20725c).mergeFrom(listValue)).buildPartial();
        }
        this.f20724b = 6;
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m13073Q(Struct struct) {
        struct.getClass();
        if (this.f20724b != 5 || this.f20725c == Struct.getDefaultInstance()) {
            this.f20725c = struct;
        } else {
            this.f20725c = ((Struct.Builder) Struct.newBuilder((Struct) this.f20725c).mergeFrom(struct)).buildPartial();
        }
        this.f20724b = 5;
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public void m13074R(boolean z) {
        this.f20724b = 4;
        this.f20725c = Boolean.valueOf(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m13075S(ListValue listValue) {
        listValue.getClass();
        this.f20725c = listValue;
        this.f20724b = 6;
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m13076T(NullValue nullValue) {
        this.f20725c = Integer.valueOf(nullValue.getNumber());
        this.f20724b = 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public void m13077U(int i) {
        this.f20724b = 1;
        this.f20725c = Integer.valueOf(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public void m13078V(double d) {
        this.f20724b = 2;
        this.f20725c = Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public void m13079W(String str) {
        str.getClass();
        this.f20724b = 3;
        this.f20725c = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public void m13080X(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20725c = byteString.toStringUtf8();
        this.f20724b = 3;
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public void m13081Y(Struct struct) {
        struct.getClass();
        this.f20725c = struct;
        this.f20724b = 5;
    }

    public static Value getDefaultInstance() {
        return f20722d;
    }

    public static Builder newBuilder() {
        return (Builder) f20722d.createBuilder();
    }

    public static Value parseDelimitedFrom(InputStream inputStream) {
        return (Value) GeneratedMessageLite.parseDelimitedFrom(f20722d, inputStream);
    }

    public static Value parseFrom(ByteBuffer byteBuffer) {
        return (Value) GeneratedMessageLite.parseFrom(f20722d, byteBuffer);
    }

    public static Parser<Value> parser() {
        return f20722d.getParserForType();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3675a.f20728a[methodToInvoke.ordinal()]) {
            case 1:
                return new Value();
            case 2:
                return new Builder((C3675a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20722d, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"kind_", "kindCase_", Struct.class, ListValue.class});
            case 4:
                return f20722d;
            case 5:
                Parser<Value> parser = f20723e;
                if (parser == null) {
                    synchronized (Value.class) {
                        parser = f20723e;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20722d);
                            f20723e = parser;
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

    public boolean getBoolValue() {
        if (this.f20724b == 4) {
            return ((Boolean) this.f20725c).booleanValue();
        }
        return false;
    }

    public KindCase getKindCase() {
        return KindCase.forNumber(this.f20724b);
    }

    public ListValue getListValue() {
        if (this.f20724b == 6) {
            return (ListValue) this.f20725c;
        }
        return ListValue.getDefaultInstance();
    }

    public NullValue getNullValue() {
        if (this.f20724b != 1) {
            return NullValue.NULL_VALUE;
        }
        NullValue forNumber = NullValue.forNumber(((Integer) this.f20725c).intValue());
        return forNumber == null ? NullValue.UNRECOGNIZED : forNumber;
    }

    public int getNullValueValue() {
        if (this.f20724b == 1) {
            return ((Integer) this.f20725c).intValue();
        }
        return 0;
    }

    public double getNumberValue() {
        return this.f20724b == 2 ? ((Double) this.f20725c).doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public String getStringValue() {
        return this.f20724b == 3 ? (String) this.f20725c : "";
    }

    public ByteString getStringValueBytes() {
        return ByteString.copyFromUtf8(this.f20724b == 3 ? (String) this.f20725c : "");
    }

    public Struct getStructValue() {
        if (this.f20724b == 5) {
            return (Struct) this.f20725c;
        }
        return Struct.getDefaultInstance();
    }

    public boolean hasListValue() {
        return this.f20724b == 6;
    }

    public boolean hasStructValue() {
        return this.f20724b == 5;
    }

    public static Builder newBuilder(Value value) {
        return (Builder) f20722d.createBuilder(value);
    }

    public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.parseDelimitedFrom(f20722d, inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.parseFrom(f20722d, byteBuffer, extensionRegistryLite);
    }

    public static Value parseFrom(ByteString byteString) {
        return (Value) GeneratedMessageLite.parseFrom(f20722d, byteString);
    }

    public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.parseFrom(f20722d, byteString, extensionRegistryLite);
    }

    public static Value parseFrom(byte[] bArr) {
        return (Value) GeneratedMessageLite.parseFrom(f20722d, bArr);
    }

    public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.parseFrom(f20722d, bArr, extensionRegistryLite);
    }

    public static Value parseFrom(InputStream inputStream) {
        return (Value) GeneratedMessageLite.parseFrom(f20722d, inputStream);
    }

    public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.parseFrom(f20722d, inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(CodedInputStream codedInputStream) {
        return (Value) GeneratedMessageLite.parseFrom(f20722d, codedInputStream);
    }

    public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.parseFrom(f20722d, codedInputStream, extensionRegistryLite);
    }
}
