package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Method extends GeneratedMessageLite<Method, Builder> implements MethodOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Method f20634i;

    /* renamed from: j */
    private static volatile Parser<Method> f20635j;

    /* renamed from: b */
    private String f20636b = "";

    /* renamed from: c */
    private String f20637c = "";

    /* renamed from: d */
    private boolean f20638d;

    /* renamed from: e */
    private String f20639e = "";

    /* renamed from: f */
    private boolean f20640f;

    /* renamed from: g */
    private Internal.ProtobufList<Option> f20641g = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: h */
    private int f20642h;

    public static final class Builder extends GeneratedMessageLite.Builder<Method, Builder> implements MethodOrBuilder {
        /* synthetic */ Builder(C3658a aVar) {
            this();
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            copyOnWrite();
            ((Method) this.instance).m12872N(iterable);
            return this;
        }

        public Builder addOptions(Option option) {
            copyOnWrite();
            ((Method) this.instance).m12874P(option);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Method) this.instance).m12875Q();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((Method) this.instance).m12876R();
            return this;
        }

        public Builder clearRequestStreaming() {
            copyOnWrite();
            ((Method) this.instance).m12877S();
            return this;
        }

        public Builder clearRequestTypeUrl() {
            copyOnWrite();
            ((Method) this.instance).m12878T();
            return this;
        }

        public Builder clearResponseStreaming() {
            copyOnWrite();
            ((Method) this.instance).m12879U();
            return this;
        }

        public Builder clearResponseTypeUrl() {
            copyOnWrite();
            ((Method) this.instance).m12880V();
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((Method) this.instance).m12881W();
            return this;
        }

        public String getName() {
            return ((Method) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Method) this.instance).getNameBytes();
        }

        public Option getOptions(int i) {
            return ((Method) this.instance).getOptions(i);
        }

        public int getOptionsCount() {
            return ((Method) this.instance).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Method) this.instance).getOptionsList());
        }

        public boolean getRequestStreaming() {
            return ((Method) this.instance).getRequestStreaming();
        }

        public String getRequestTypeUrl() {
            return ((Method) this.instance).getRequestTypeUrl();
        }

        public ByteString getRequestTypeUrlBytes() {
            return ((Method) this.instance).getRequestTypeUrlBytes();
        }

        public boolean getResponseStreaming() {
            return ((Method) this.instance).getResponseStreaming();
        }

        public String getResponseTypeUrl() {
            return ((Method) this.instance).getResponseTypeUrl();
        }

        public ByteString getResponseTypeUrlBytes() {
            return ((Method) this.instance).getResponseTypeUrlBytes();
        }

        public Syntax getSyntax() {
            return ((Method) this.instance).getSyntax();
        }

        public int getSyntaxValue() {
            return ((Method) this.instance).getSyntaxValue();
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((Method) this.instance).m12883Y(i);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Method) this.instance).m12884Z(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Method) this.instance).m12885a0(byteString);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            copyOnWrite();
            ((Method) this.instance).m12886b0(i, option);
            return this;
        }

        public Builder setRequestStreaming(boolean z) {
            copyOnWrite();
            ((Method) this.instance).m12887c0(z);
            return this;
        }

        public Builder setRequestTypeUrl(String str) {
            copyOnWrite();
            ((Method) this.instance).m12888d0(str);
            return this;
        }

        public Builder setRequestTypeUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((Method) this.instance).m12889e0(byteString);
            return this;
        }

        public Builder setResponseStreaming(boolean z) {
            copyOnWrite();
            ((Method) this.instance).m12890f0(z);
            return this;
        }

        public Builder setResponseTypeUrl(String str) {
            copyOnWrite();
            ((Method) this.instance).m12891g0(str);
            return this;
        }

        public Builder setResponseTypeUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((Method) this.instance).m12892h0(byteString);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            copyOnWrite();
            ((Method) this.instance).m12893i0(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            copyOnWrite();
            ((Method) this.instance).m12894j0(i);
            return this;
        }

        private Builder() {
            super(Method.f20634i);
        }

        public Builder addOptions(int i, Option option) {
            copyOnWrite();
            ((Method) this.instance).m12873O(i, option);
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Method) this.instance).m12886b0(i, (Option) builder.build());
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            copyOnWrite();
            ((Method) this.instance).m12874P((Option) builder.build());
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Method) this.instance).m12873O(i, (Option) builder.build());
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Method$a */
    static /* synthetic */ class C3658a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20643a;

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
                f20643a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20643a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20643a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20643a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20643a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20643a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20643a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Method.C3658a.<clinit>():void");
        }
    }

    static {
        Method method = new Method();
        f20634i = method;
        GeneratedMessageLite.registerDefaultInstance(Method.class, method);
    }

    private Method() {
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public void m12872N(Iterable<? extends Option> iterable) {
        m12882X();
        AbstractMessageLite.addAll(iterable, this.f20641g);
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m12873O(int i, Option option) {
        option.getClass();
        m12882X();
        this.f20641g.add(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public void m12874P(Option option) {
        option.getClass();
        m12882X();
        this.f20641g.add(option);
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m12875Q() {
        this.f20636b = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public void m12876R() {
        this.f20641g = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m12877S() {
        this.f20638d = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m12878T() {
        this.f20637c = getDefaultInstance().getRequestTypeUrl();
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public void m12879U() {
        this.f20640f = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public void m12880V() {
        this.f20639e = getDefaultInstance().getResponseTypeUrl();
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public void m12881W() {
        this.f20642h = 0;
    }

    /* renamed from: X */
    private void m12882X() {
        if (!this.f20641g.isModifiable()) {
            this.f20641g = GeneratedMessageLite.mutableCopy(this.f20641g);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public void m12883Y(int i) {
        m12882X();
        this.f20641g.remove(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public void m12884Z(String str) {
        str.getClass();
        this.f20636b = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a0 */
    public void m12885a0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20636b = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: b0 */
    public void m12886b0(int i, Option option) {
        option.getClass();
        m12882X();
        this.f20641g.set(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public void m12887c0(boolean z) {
        this.f20638d = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: d0 */
    public void m12888d0(String str) {
        str.getClass();
        this.f20637c = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: e0 */
    public void m12889e0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20637c = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: f0 */
    public void m12890f0(boolean z) {
        this.f20640f = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: g0 */
    public void m12891g0(String str) {
        str.getClass();
        this.f20639e = str;
    }

    public static Method getDefaultInstance() {
        return f20634i;
    }

    /* access modifiers changed from: private */
    /* renamed from: h0 */
    public void m12892h0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20639e = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: i0 */
    public void m12893i0(Syntax syntax) {
        this.f20642h = syntax.getNumber();
    }

    /* access modifiers changed from: private */
    /* renamed from: j0 */
    public void m12894j0(int i) {
        this.f20642h = i;
    }

    public static Builder newBuilder() {
        return (Builder) f20634i.createBuilder();
    }

    public static Method parseDelimitedFrom(InputStream inputStream) {
        return (Method) GeneratedMessageLite.parseDelimitedFrom(f20634i, inputStream);
    }

    public static Method parseFrom(ByteBuffer byteBuffer) {
        return (Method) GeneratedMessageLite.parseFrom(f20634i, byteBuffer);
    }

    public static Parser<Method> parser() {
        return f20634i.getParserForType();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3658a.f20643a[methodToInvoke.ordinal()]) {
            case 1:
                return new Method();
            case 2:
                return new Builder((C3658a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20634i, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0007\u0006\u001b\u0007\f", new Object[]{"name_", "requestTypeUrl_", "requestStreaming_", "responseTypeUrl_", "responseStreaming_", "options_", Option.class, "syntax_"});
            case 4:
                return f20634i;
            case 5:
                Parser<Method> parser = f20635j;
                if (parser == null) {
                    synchronized (Method.class) {
                        parser = f20635j;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20634i);
                            f20635j = parser;
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
        return this.f20636b;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f20636b);
    }

    public Option getOptions(int i) {
        return this.f20641g.get(i);
    }

    public int getOptionsCount() {
        return this.f20641g.size();
    }

    public List<Option> getOptionsList() {
        return this.f20641g;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.f20641g.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.f20641g;
    }

    public boolean getRequestStreaming() {
        return this.f20638d;
    }

    public String getRequestTypeUrl() {
        return this.f20637c;
    }

    public ByteString getRequestTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.f20637c);
    }

    public boolean getResponseStreaming() {
        return this.f20640f;
    }

    public String getResponseTypeUrl() {
        return this.f20639e;
    }

    public ByteString getResponseTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.f20639e);
    }

    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.f20642h);
        return forNumber == null ? Syntax.UNRECOGNIZED : forNumber;
    }

    public int getSyntaxValue() {
        return this.f20642h;
    }

    public static Builder newBuilder(Method method) {
        return (Builder) f20634i.createBuilder(method);
    }

    public static Method parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.parseDelimitedFrom(f20634i, inputStream, extensionRegistryLite);
    }

    public static Method parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.parseFrom(f20634i, byteBuffer, extensionRegistryLite);
    }

    public static Method parseFrom(ByteString byteString) {
        return (Method) GeneratedMessageLite.parseFrom(f20634i, byteString);
    }

    public static Method parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.parseFrom(f20634i, byteString, extensionRegistryLite);
    }

    public static Method parseFrom(byte[] bArr) {
        return (Method) GeneratedMessageLite.parseFrom(f20634i, bArr);
    }

    public static Method parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.parseFrom(f20634i, bArr, extensionRegistryLite);
    }

    public static Method parseFrom(InputStream inputStream) {
        return (Method) GeneratedMessageLite.parseFrom(f20634i, inputStream);
    }

    public static Method parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.parseFrom(f20634i, inputStream, extensionRegistryLite);
    }

    public static Method parseFrom(CodedInputStream codedInputStream) {
        return (Method) GeneratedMessageLite.parseFrom(f20634i, codedInputStream);
    }

    public static Method parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.parseFrom(f20634i, codedInputStream, extensionRegistryLite);
    }
}
