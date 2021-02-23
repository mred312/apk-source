package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Value;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class ListValue extends GeneratedMessageLite<ListValue, Builder> implements ListValueOrBuilder {
    public static final int VALUES_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final ListValue f20620c;

    /* renamed from: d */
    private static volatile Parser<ListValue> f20621d;

    /* renamed from: b */
    private Internal.ProtobufList<Value> f20622b = GeneratedMessageLite.emptyProtobufList();

    public static final class Builder extends GeneratedMessageLite.Builder<ListValue, Builder> implements ListValueOrBuilder {
        /* synthetic */ Builder(C3655a aVar) {
            this();
        }

        public Builder addAllValues(Iterable<? extends Value> iterable) {
            copyOnWrite();
            ((ListValue) this.instance).m12845x(iterable);
            return this;
        }

        public Builder addValues(Value value) {
            copyOnWrite();
            ((ListValue) this.instance).m12847z(value);
            return this;
        }

        public Builder clearValues() {
            copyOnWrite();
            ((ListValue) this.instance).m12834A();
            return this;
        }

        public Value getValues(int i) {
            return ((ListValue) this.instance).getValues(i);
        }

        public int getValuesCount() {
            return ((ListValue) this.instance).getValuesCount();
        }

        public List<Value> getValuesList() {
            return Collections.unmodifiableList(((ListValue) this.instance).getValuesList());
        }

        public Builder removeValues(int i) {
            copyOnWrite();
            ((ListValue) this.instance).m12836C(i);
            return this;
        }

        public Builder setValues(int i, Value value) {
            copyOnWrite();
            ((ListValue) this.instance).m12837D(i, value);
            return this;
        }

        private Builder() {
            super(ListValue.f20620c);
        }

        public Builder addValues(int i, Value value) {
            copyOnWrite();
            ((ListValue) this.instance).m12846y(i, value);
            return this;
        }

        public Builder setValues(int i, Value.Builder builder) {
            copyOnWrite();
            ((ListValue) this.instance).m12837D(i, (Value) builder.build());
            return this;
        }

        public Builder addValues(Value.Builder builder) {
            copyOnWrite();
            ((ListValue) this.instance).m12847z((Value) builder.build());
            return this;
        }

        public Builder addValues(int i, Value.Builder builder) {
            copyOnWrite();
            ((ListValue) this.instance).m12846y(i, (Value) builder.build());
            return this;
        }
    }

    /* renamed from: com.google.protobuf.ListValue$a */
    static /* synthetic */ class C3655a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20623a;

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
                f20623a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20623a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20623a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20623a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20623a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20623a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20623a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ListValue.C3655a.<clinit>():void");
        }
    }

    static {
        ListValue listValue = new ListValue();
        f20620c = listValue;
        GeneratedMessageLite.registerDefaultInstance(ListValue.class, listValue);
    }

    private ListValue() {
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m12834A() {
        this.f20622b = GeneratedMessageLite.emptyProtobufList();
    }

    /* renamed from: B */
    private void m12835B() {
        if (!this.f20622b.isModifiable()) {
            this.f20622b = GeneratedMessageLite.mutableCopy(this.f20622b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public void m12836C(int i) {
        m12835B();
        this.f20622b.remove(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m12837D(int i, Value value) {
        value.getClass();
        m12835B();
        this.f20622b.set(i, value);
    }

    public static ListValue getDefaultInstance() {
        return f20620c;
    }

    public static Builder newBuilder() {
        return (Builder) f20620c.createBuilder();
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream) {
        return (ListValue) GeneratedMessageLite.parseDelimitedFrom(f20620c, inputStream);
    }

    public static ListValue parseFrom(ByteBuffer byteBuffer) {
        return (ListValue) GeneratedMessageLite.parseFrom(f20620c, byteBuffer);
    }

    public static Parser<ListValue> parser() {
        return f20620c.getParserForType();
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m12845x(Iterable<? extends Value> iterable) {
        m12835B();
        AbstractMessageLite.addAll(iterable, this.f20622b);
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m12846y(int i, Value value) {
        value.getClass();
        m12835B();
        this.f20622b.add(i, value);
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m12847z(Value value) {
        value.getClass();
        m12835B();
        this.f20622b.add(value);
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3655a.f20623a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListValue();
            case 2:
                return new Builder((C3655a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20620c, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", Value.class});
            case 4:
                return f20620c;
            case 5:
                Parser<ListValue> parser = f20621d;
                if (parser == null) {
                    synchronized (ListValue.class) {
                        parser = f20621d;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20620c);
                            f20621d = parser;
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

    public Value getValues(int i) {
        return this.f20622b.get(i);
    }

    public int getValuesCount() {
        return this.f20622b.size();
    }

    public List<Value> getValuesList() {
        return this.f20622b;
    }

    public ValueOrBuilder getValuesOrBuilder(int i) {
        return this.f20622b.get(i);
    }

    public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
        return this.f20622b;
    }

    public static Builder newBuilder(ListValue listValue) {
        return (Builder) f20620c.createBuilder(listValue);
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseDelimitedFrom(f20620c, inputStream, extensionRegistryLite);
    }

    public static ListValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseFrom(f20620c, byteBuffer, extensionRegistryLite);
    }

    public static ListValue parseFrom(ByteString byteString) {
        return (ListValue) GeneratedMessageLite.parseFrom(f20620c, byteString);
    }

    public static ListValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseFrom(f20620c, byteString, extensionRegistryLite);
    }

    public static ListValue parseFrom(byte[] bArr) {
        return (ListValue) GeneratedMessageLite.parseFrom(f20620c, bArr);
    }

    public static ListValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseFrom(f20620c, bArr, extensionRegistryLite);
    }

    public static ListValue parseFrom(InputStream inputStream) {
        return (ListValue) GeneratedMessageLite.parseFrom(f20620c, inputStream);
    }

    public static ListValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseFrom(f20620c, inputStream, extensionRegistryLite);
    }

    public static ListValue parseFrom(CodedInputStream codedInputStream) {
        return (ListValue) GeneratedMessageLite.parseFrom(f20620c, codedInputStream);
    }

    public static ListValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseFrom(f20620c, codedInputStream, extensionRegistryLite);
    }
}
