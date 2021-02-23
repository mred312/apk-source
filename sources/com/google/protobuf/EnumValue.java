package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class EnumValue extends GeneratedMessageLite<EnumValue, Builder> implements EnumValueOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final EnumValue f20471e;

    /* renamed from: f */
    private static volatile Parser<EnumValue> f20472f;

    /* renamed from: b */
    private String f20473b = "";

    /* renamed from: c */
    private int f20474c;

    /* renamed from: d */
    private Internal.ProtobufList<Option> f20475d = GeneratedMessageLite.emptyProtobufList();

    public static final class Builder extends GeneratedMessageLite.Builder<EnumValue, Builder> implements EnumValueOrBuilder {
        /* synthetic */ Builder(C3628a aVar) {
            this();
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            copyOnWrite();
            ((EnumValue) this.instance).m12580C(iterable);
            return this;
        }

        public Builder addOptions(Option option) {
            copyOnWrite();
            ((EnumValue) this.instance).m12582E(option);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((EnumValue) this.instance).m12583F();
            return this;
        }

        public Builder clearNumber() {
            copyOnWrite();
            ((EnumValue) this.instance).m12584G();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((EnumValue) this.instance).m12585H();
            return this;
        }

        public String getName() {
            return ((EnumValue) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((EnumValue) this.instance).getNameBytes();
        }

        public int getNumber() {
            return ((EnumValue) this.instance).getNumber();
        }

        public Option getOptions(int i) {
            return ((EnumValue) this.instance).getOptions(i);
        }

        public int getOptionsCount() {
            return ((EnumValue) this.instance).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((EnumValue) this.instance).getOptionsList());
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((EnumValue) this.instance).m12587J(i);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((EnumValue) this.instance).m12588K(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((EnumValue) this.instance).m12589L(byteString);
            return this;
        }

        public Builder setNumber(int i) {
            copyOnWrite();
            ((EnumValue) this.instance).m12590M(i);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            copyOnWrite();
            ((EnumValue) this.instance).m12591N(i, option);
            return this;
        }

        private Builder() {
            super(EnumValue.f20471e);
        }

        public Builder addOptions(int i, Option option) {
            copyOnWrite();
            ((EnumValue) this.instance).m12581D(i, option);
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((EnumValue) this.instance).m12591N(i, (Option) builder.build());
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            copyOnWrite();
            ((EnumValue) this.instance).m12582E((Option) builder.build());
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((EnumValue) this.instance).m12581D(i, (Option) builder.build());
            return this;
        }
    }

    /* renamed from: com.google.protobuf.EnumValue$a */
    static /* synthetic */ class C3628a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20476a;

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
                f20476a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20476a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20476a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20476a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20476a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20476a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20476a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.EnumValue.C3628a.<clinit>():void");
        }
    }

    static {
        EnumValue enumValue = new EnumValue();
        f20471e = enumValue;
        GeneratedMessageLite.registerDefaultInstance(EnumValue.class, enumValue);
    }

    private EnumValue() {
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public void m12580C(Iterable<? extends Option> iterable) {
        m12586I();
        AbstractMessageLite.addAll(iterable, this.f20475d);
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m12581D(int i, Option option) {
        option.getClass();
        m12586I();
        this.f20475d.add(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m12582E(Option option) {
        option.getClass();
        m12586I();
        this.f20475d.add(option);
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m12583F() {
        this.f20473b = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m12584G() {
        this.f20474c = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public void m12585H() {
        this.f20475d = GeneratedMessageLite.emptyProtobufList();
    }

    /* renamed from: I */
    private void m12586I() {
        if (!this.f20475d.isModifiable()) {
            this.f20475d = GeneratedMessageLite.mutableCopy(this.f20475d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public void m12587J(int i) {
        m12586I();
        this.f20475d.remove(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public void m12588K(String str) {
        str.getClass();
        this.f20473b = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public void m12589L(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20473b = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public void m12590M(int i) {
        this.f20474c = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public void m12591N(int i, Option option) {
        option.getClass();
        m12586I();
        this.f20475d.set(i, option);
    }

    public static EnumValue getDefaultInstance() {
        return f20471e;
    }

    public static Builder newBuilder() {
        return (Builder) f20471e.createBuilder();
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream) {
        return (EnumValue) GeneratedMessageLite.parseDelimitedFrom(f20471e, inputStream);
    }

    public static EnumValue parseFrom(ByteBuffer byteBuffer) {
        return (EnumValue) GeneratedMessageLite.parseFrom(f20471e, byteBuffer);
    }

    public static Parser<EnumValue> parser() {
        return f20471e.getParserForType();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3628a.f20476a[methodToInvoke.ordinal()]) {
            case 1:
                return new EnumValue();
            case 2:
                return new Builder((C3628a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20471e, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u001b", new Object[]{"name_", "number_", "options_", Option.class});
            case 4:
                return f20471e;
            case 5:
                Parser<EnumValue> parser = f20472f;
                if (parser == null) {
                    synchronized (EnumValue.class) {
                        parser = f20472f;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20471e);
                            f20472f = parser;
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

    public String getName() {
        return this.f20473b;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f20473b);
    }

    public int getNumber() {
        return this.f20474c;
    }

    public Option getOptions(int i) {
        return this.f20475d.get(i);
    }

    public int getOptionsCount() {
        return this.f20475d.size();
    }

    public List<Option> getOptionsList() {
        return this.f20475d;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.f20475d.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.f20475d;
    }

    public static Builder newBuilder(EnumValue enumValue) {
        return (Builder) f20471e.createBuilder(enumValue);
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseDelimitedFrom(f20471e, inputStream, extensionRegistryLite);
    }

    public static EnumValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseFrom(f20471e, byteBuffer, extensionRegistryLite);
    }

    public static EnumValue parseFrom(ByteString byteString) {
        return (EnumValue) GeneratedMessageLite.parseFrom(f20471e, byteString);
    }

    public static EnumValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseFrom(f20471e, byteString, extensionRegistryLite);
    }

    public static EnumValue parseFrom(byte[] bArr) {
        return (EnumValue) GeneratedMessageLite.parseFrom(f20471e, bArr);
    }

    public static EnumValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseFrom(f20471e, bArr, extensionRegistryLite);
    }

    public static EnumValue parseFrom(InputStream inputStream) {
        return (EnumValue) GeneratedMessageLite.parseFrom(f20471e, inputStream);
    }

    public static EnumValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseFrom(f20471e, inputStream, extensionRegistryLite);
    }

    public static EnumValue parseFrom(CodedInputStream codedInputStream) {
        return (EnumValue) GeneratedMessageLite.parseFrom(f20471e, codedInputStream);
    }

    public static EnumValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseFrom(f20471e, codedInputStream, extensionRegistryLite);
    }
}
