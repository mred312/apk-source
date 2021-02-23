package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Mixin extends GeneratedMessageLite<Mixin, Builder> implements MixinOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ROOT_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Mixin f20644d;

    /* renamed from: e */
    private static volatile Parser<Mixin> f20645e;

    /* renamed from: b */
    private String f20646b = "";

    /* renamed from: c */
    private String f20647c = "";

    public static final class Builder extends GeneratedMessageLite.Builder<Mixin, Builder> implements MixinOrBuilder {
        /* synthetic */ Builder(C3659a aVar) {
            this();
        }

        public Builder clearName() {
            copyOnWrite();
            ((Mixin) this.instance).m12915x();
            return this;
        }

        public Builder clearRoot() {
            copyOnWrite();
            ((Mixin) this.instance).m12916y();
            return this;
        }

        public String getName() {
            return ((Mixin) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Mixin) this.instance).getNameBytes();
        }

        public String getRoot() {
            return ((Mixin) this.instance).getRoot();
        }

        public ByteString getRootBytes() {
            return ((Mixin) this.instance).getRootBytes();
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Mixin) this.instance).m12917z(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Mixin) this.instance).m12905A(byteString);
            return this;
        }

        public Builder setRoot(String str) {
            copyOnWrite();
            ((Mixin) this.instance).m12906B(str);
            return this;
        }

        public Builder setRootBytes(ByteString byteString) {
            copyOnWrite();
            ((Mixin) this.instance).m12907C(byteString);
            return this;
        }

        private Builder() {
            super(Mixin.f20644d);
        }
    }

    /* renamed from: com.google.protobuf.Mixin$a */
    static /* synthetic */ class C3659a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20648a;

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
                f20648a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20648a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20648a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20648a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20648a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20648a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20648a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Mixin.C3659a.<clinit>():void");
        }
    }

    static {
        Mixin mixin = new Mixin();
        f20644d = mixin;
        GeneratedMessageLite.registerDefaultInstance(Mixin.class, mixin);
    }

    private Mixin() {
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m12905A(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20646b = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m12906B(String str) {
        str.getClass();
        this.f20647c = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public void m12907C(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20647c = byteString.toStringUtf8();
    }

    public static Mixin getDefaultInstance() {
        return f20644d;
    }

    public static Builder newBuilder() {
        return (Builder) f20644d.createBuilder();
    }

    public static Mixin parseDelimitedFrom(InputStream inputStream) {
        return (Mixin) GeneratedMessageLite.parseDelimitedFrom(f20644d, inputStream);
    }

    public static Mixin parseFrom(ByteBuffer byteBuffer) {
        return (Mixin) GeneratedMessageLite.parseFrom(f20644d, byteBuffer);
    }

    public static Parser<Mixin> parser() {
        return f20644d.getParserForType();
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m12915x() {
        this.f20646b = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m12916y() {
        this.f20647c = getDefaultInstance().getRoot();
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m12917z(String str) {
        str.getClass();
        this.f20646b = str;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3659a.f20648a[methodToInvoke.ordinal()]) {
            case 1:
                return new Mixin();
            case 2:
                return new Builder((C3659a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20644d, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"name_", "root_"});
            case 4:
                return f20644d;
            case 5:
                Parser<Mixin> parser = f20645e;
                if (parser == null) {
                    synchronized (Mixin.class) {
                        parser = f20645e;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20644d);
                            f20645e = parser;
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
        return this.f20646b;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f20646b);
    }

    public String getRoot() {
        return this.f20647c;
    }

    public ByteString getRootBytes() {
        return ByteString.copyFromUtf8(this.f20647c);
    }

    public static Builder newBuilder(Mixin mixin) {
        return (Builder) f20644d.createBuilder(mixin);
    }

    public static Mixin parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.parseDelimitedFrom(f20644d, inputStream, extensionRegistryLite);
    }

    public static Mixin parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.parseFrom(f20644d, byteBuffer, extensionRegistryLite);
    }

    public static Mixin parseFrom(ByteString byteString) {
        return (Mixin) GeneratedMessageLite.parseFrom(f20644d, byteString);
    }

    public static Mixin parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.parseFrom(f20644d, byteString, extensionRegistryLite);
    }

    public static Mixin parseFrom(byte[] bArr) {
        return (Mixin) GeneratedMessageLite.parseFrom(f20644d, bArr);
    }

    public static Mixin parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.parseFrom(f20644d, bArr, extensionRegistryLite);
    }

    public static Mixin parseFrom(InputStream inputStream) {
        return (Mixin) GeneratedMessageLite.parseFrom(f20644d, inputStream);
    }

    public static Mixin parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.parseFrom(f20644d, inputStream, extensionRegistryLite);
    }

    public static Mixin parseFrom(CodedInputStream codedInputStream) {
        return (Mixin) GeneratedMessageLite.parseFrom(f20644d, codedInputStream);
    }

    public static Mixin parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Mixin) GeneratedMessageLite.parseFrom(f20644d, codedInputStream, extensionRegistryLite);
    }
}
