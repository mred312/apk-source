package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Any extends GeneratedMessageLite<Any, Builder> implements AnyOrBuilder {
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Any f20339d;

    /* renamed from: e */
    private static volatile Parser<Any> f20340e;

    /* renamed from: b */
    private String f20341b = "";

    /* renamed from: c */
    private ByteString f20342c = ByteString.EMPTY;

    public static final class Builder extends GeneratedMessageLite.Builder<Any, Builder> implements AnyOrBuilder {
        /* synthetic */ Builder(C3597a aVar) {
            this();
        }

        public Builder clearTypeUrl() {
            copyOnWrite();
            ((Any) this.instance).m12329w();
            return this;
        }

        public Builder clearValue() {
            copyOnWrite();
            ((Any) this.instance).m12330x();
            return this;
        }

        public String getTypeUrl() {
            return ((Any) this.instance).getTypeUrl();
        }

        public ByteString getTypeUrlBytes() {
            return ((Any) this.instance).getTypeUrlBytes();
        }

        public ByteString getValue() {
            return ((Any) this.instance).getValue();
        }

        public Builder setTypeUrl(String str) {
            copyOnWrite();
            ((Any) this.instance).m12331y(str);
            return this;
        }

        public Builder setTypeUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((Any) this.instance).m12332z(byteString);
            return this;
        }

        public Builder setValue(ByteString byteString) {
            copyOnWrite();
            ((Any) this.instance).m12322A(byteString);
            return this;
        }

        private Builder() {
            super(Any.f20339d);
        }
    }

    /* renamed from: com.google.protobuf.Any$a */
    static /* synthetic */ class C3597a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20343a;

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
                f20343a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20343a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20343a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20343a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20343a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20343a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20343a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Any.C3597a.<clinit>():void");
        }
    }

    static {
        Any any = new Any();
        f20339d = any;
        GeneratedMessageLite.registerDefaultInstance(Any.class, any);
    }

    private Any() {
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m12322A(ByteString byteString) {
        byteString.getClass();
        this.f20342c = byteString;
    }

    public static Any getDefaultInstance() {
        return f20339d;
    }

    public static Builder newBuilder() {
        return (Builder) f20339d.createBuilder();
    }

    public static Any parseDelimitedFrom(InputStream inputStream) {
        return (Any) GeneratedMessageLite.parseDelimitedFrom(f20339d, inputStream);
    }

    public static Any parseFrom(ByteBuffer byteBuffer) {
        return (Any) GeneratedMessageLite.parseFrom(f20339d, byteBuffer);
    }

    public static Parser<Any> parser() {
        return f20339d.getParserForType();
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m12329w() {
        this.f20341b = getDefaultInstance().getTypeUrl();
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m12330x() {
        this.f20342c = getDefaultInstance().getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m12331y(String str) {
        str.getClass();
        this.f20341b = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m12332z(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20341b = byteString.toStringUtf8();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3597a.f20343a[methodToInvoke.ordinal()]) {
            case 1:
                return new Any();
            case 2:
                return new Builder((C3597a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20339d, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"typeUrl_", "value_"});
            case 4:
                return f20339d;
            case 5:
                Parser<Any> parser = f20340e;
                if (parser == null) {
                    synchronized (Any.class) {
                        parser = f20340e;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20339d);
                            f20340e = parser;
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

    public String getTypeUrl() {
        return this.f20341b;
    }

    public ByteString getTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.f20341b);
    }

    public ByteString getValue() {
        return this.f20342c;
    }

    public static Builder newBuilder(Any any) {
        return (Builder) f20339d.createBuilder(any);
    }

    public static Any parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Any) GeneratedMessageLite.parseDelimitedFrom(f20339d, inputStream, extensionRegistryLite);
    }

    public static Any parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Any) GeneratedMessageLite.parseFrom(f20339d, byteBuffer, extensionRegistryLite);
    }

    public static Any parseFrom(ByteString byteString) {
        return (Any) GeneratedMessageLite.parseFrom(f20339d, byteString);
    }

    public static Any parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Any) GeneratedMessageLite.parseFrom(f20339d, byteString, extensionRegistryLite);
    }

    public static Any parseFrom(byte[] bArr) {
        return (Any) GeneratedMessageLite.parseFrom(f20339d, bArr);
    }

    public static Any parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Any) GeneratedMessageLite.parseFrom(f20339d, bArr, extensionRegistryLite);
    }

    public static Any parseFrom(InputStream inputStream) {
        return (Any) GeneratedMessageLite.parseFrom(f20339d, inputStream);
    }

    public static Any parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Any) GeneratedMessageLite.parseFrom(f20339d, inputStream, extensionRegistryLite);
    }

    public static Any parseFrom(CodedInputStream codedInputStream) {
        return (Any) GeneratedMessageLite.parseFrom(f20339d, codedInputStream);
    }

    public static Any parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Any) GeneratedMessageLite.parseFrom(f20339d, codedInputStream, extensionRegistryLite);
    }
}
