package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.GeneratedMessageLite;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Option extends GeneratedMessageLite<Option, Builder> implements OptionOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Option f20653d;

    /* renamed from: e */
    private static volatile Parser<Option> f20654e;

    /* renamed from: b */
    private String f20655b = "";

    /* renamed from: c */
    private Any f20656c;

    public static final class Builder extends GeneratedMessageLite.Builder<Option, Builder> implements OptionOrBuilder {
        /* synthetic */ Builder(C3662a aVar) {
            this();
        }

        public Builder clearName() {
            copyOnWrite();
            ((Option) this.instance).m12929x();
            return this;
        }

        public Builder clearValue() {
            copyOnWrite();
            ((Option) this.instance).m12930y();
            return this;
        }

        public String getName() {
            return ((Option) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Option) this.instance).getNameBytes();
        }

        public Any getValue() {
            return ((Option) this.instance).getValue();
        }

        public boolean hasValue() {
            return ((Option) this.instance).hasValue();
        }

        public Builder mergeValue(Any any) {
            copyOnWrite();
            ((Option) this.instance).m12931z(any);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Option) this.instance).m12919A(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Option) this.instance).m12920B(byteString);
            return this;
        }

        public Builder setValue(Any any) {
            copyOnWrite();
            ((Option) this.instance).m12921C(any);
            return this;
        }

        private Builder() {
            super(Option.f20653d);
        }

        public Builder setValue(Any.Builder builder) {
            copyOnWrite();
            ((Option) this.instance).m12921C((Any) builder.build());
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Option$a */
    static /* synthetic */ class C3662a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20657a;

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
                f20657a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20657a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20657a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20657a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20657a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20657a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20657a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Option.C3662a.<clinit>():void");
        }
    }

    static {
        Option option = new Option();
        f20653d = option;
        GeneratedMessageLite.registerDefaultInstance(Option.class, option);
    }

    private Option() {
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m12919A(String str) {
        str.getClass();
        this.f20655b = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m12920B(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20655b = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public void m12921C(Any any) {
        any.getClass();
        this.f20656c = any;
    }

    public static Option getDefaultInstance() {
        return f20653d;
    }

    public static Builder newBuilder() {
        return (Builder) f20653d.createBuilder();
    }

    public static Option parseDelimitedFrom(InputStream inputStream) {
        return (Option) GeneratedMessageLite.parseDelimitedFrom(f20653d, inputStream);
    }

    public static Option parseFrom(ByteBuffer byteBuffer) {
        return (Option) GeneratedMessageLite.parseFrom(f20653d, byteBuffer);
    }

    public static Parser<Option> parser() {
        return f20653d.getParserForType();
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m12929x() {
        this.f20655b = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m12930y() {
        this.f20656c = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m12931z(Any any) {
        any.getClass();
        Any any2 = this.f20656c;
        if (any2 == null || any2 == Any.getDefaultInstance()) {
            this.f20656c = any;
        } else {
            this.f20656c = (Any) ((Any.Builder) Any.newBuilder(this.f20656c).mergeFrom(any)).buildPartial();
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3662a.f20657a[methodToInvoke.ordinal()]) {
            case 1:
                return new Option();
            case 2:
                return new Builder((C3662a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20653d, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"name_", "value_"});
            case 4:
                return f20653d;
            case 5:
                Parser<Option> parser = f20654e;
                if (parser == null) {
                    synchronized (Option.class) {
                        parser = f20654e;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20653d);
                            f20654e = parser;
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
        return this.f20655b;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f20655b);
    }

    public Any getValue() {
        Any any = this.f20656c;
        return any == null ? Any.getDefaultInstance() : any;
    }

    public boolean hasValue() {
        return this.f20656c != null;
    }

    public static Builder newBuilder(Option option) {
        return (Builder) f20653d.createBuilder(option);
    }

    public static Option parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Option) GeneratedMessageLite.parseDelimitedFrom(f20653d, inputStream, extensionRegistryLite);
    }

    public static Option parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Option) GeneratedMessageLite.parseFrom(f20653d, byteBuffer, extensionRegistryLite);
    }

    public static Option parseFrom(ByteString byteString) {
        return (Option) GeneratedMessageLite.parseFrom(f20653d, byteString);
    }

    public static Option parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Option) GeneratedMessageLite.parseFrom(f20653d, byteString, extensionRegistryLite);
    }

    public static Option parseFrom(byte[] bArr) {
        return (Option) GeneratedMessageLite.parseFrom(f20653d, bArr);
    }

    public static Option parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Option) GeneratedMessageLite.parseFrom(f20653d, bArr, extensionRegistryLite);
    }

    public static Option parseFrom(InputStream inputStream) {
        return (Option) GeneratedMessageLite.parseFrom(f20653d, inputStream);
    }

    public static Option parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Option) GeneratedMessageLite.parseFrom(f20653d, inputStream, extensionRegistryLite);
    }

    public static Option parseFrom(CodedInputStream codedInputStream) {
        return (Option) GeneratedMessageLite.parseFrom(f20653d, codedInputStream);
    }

    public static Option parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Option) GeneratedMessageLite.parseFrom(f20653d, codedInputStream, extensionRegistryLite);
    }
}
