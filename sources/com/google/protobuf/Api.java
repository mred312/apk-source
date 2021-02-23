package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Method;
import com.google.protobuf.Mixin;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Api extends GeneratedMessageLite<Api, Builder> implements ApiOrBuilder {
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Api f20344i;

    /* renamed from: j */
    private static volatile Parser<Api> f20345j;

    /* renamed from: b */
    private String f20346b = "";

    /* renamed from: c */
    private Internal.ProtobufList<Method> f20347c = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: d */
    private Internal.ProtobufList<Option> f20348d = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: e */
    private String f20349e = "";

    /* renamed from: f */
    private SourceContext f20350f;

    /* renamed from: g */
    private Internal.ProtobufList<Mixin> f20351g = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: h */
    private int f20352h;

    public static final class Builder extends GeneratedMessageLite.Builder<Api, Builder> implements ApiOrBuilder {
        /* synthetic */ Builder(C3598a aVar) {
            this();
        }

        public Builder addAllMethods(Iterable<? extends Method> iterable) {
            copyOnWrite();
            ((Api) this.instance).m12356V(iterable);
            return this;
        }

        public Builder addAllMixins(Iterable<? extends Mixin> iterable) {
            copyOnWrite();
            ((Api) this.instance).m12357W(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            copyOnWrite();
            ((Api) this.instance).m12358X(iterable);
            return this;
        }

        public Builder addMethods(Method method) {
            copyOnWrite();
            ((Api) this.instance).m12360Z(method);
            return this;
        }

        public Builder addMixins(Mixin mixin) {
            copyOnWrite();
            ((Api) this.instance).m12362b0(mixin);
            return this;
        }

        public Builder addOptions(Option option) {
            copyOnWrite();
            ((Api) this.instance).m12364d0(option);
            return this;
        }

        public Builder clearMethods() {
            copyOnWrite();
            ((Api) this.instance).m12365e0();
            return this;
        }

        public Builder clearMixins() {
            copyOnWrite();
            ((Api) this.instance).m12366f0();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Api) this.instance).m12367g0();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((Api) this.instance).m12368h0();
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            ((Api) this.instance).m12369i0();
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((Api) this.instance).m12370j0();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((Api) this.instance).m12371k0();
            return this;
        }

        public Method getMethods(int i) {
            return ((Api) this.instance).getMethods(i);
        }

        public int getMethodsCount() {
            return ((Api) this.instance).getMethodsCount();
        }

        public List<Method> getMethodsList() {
            return Collections.unmodifiableList(((Api) this.instance).getMethodsList());
        }

        public Mixin getMixins(int i) {
            return ((Api) this.instance).getMixins(i);
        }

        public int getMixinsCount() {
            return ((Api) this.instance).getMixinsCount();
        }

        public List<Mixin> getMixinsList() {
            return Collections.unmodifiableList(((Api) this.instance).getMixinsList());
        }

        public String getName() {
            return ((Api) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Api) this.instance).getNameBytes();
        }

        public Option getOptions(int i) {
            return ((Api) this.instance).getOptions(i);
        }

        public int getOptionsCount() {
            return ((Api) this.instance).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Api) this.instance).getOptionsList());
        }

        public SourceContext getSourceContext() {
            return ((Api) this.instance).getSourceContext();
        }

        public Syntax getSyntax() {
            return ((Api) this.instance).getSyntax();
        }

        public int getSyntaxValue() {
            return ((Api) this.instance).getSyntaxValue();
        }

        public String getVersion() {
            return ((Api) this.instance).getVersion();
        }

        public ByteString getVersionBytes() {
            return ((Api) this.instance).getVersionBytes();
        }

        public boolean hasSourceContext() {
            return ((Api) this.instance).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((Api) this.instance).m12375o0(sourceContext);
            return this;
        }

        public Builder removeMethods(int i) {
            copyOnWrite();
            ((Api) this.instance).m12376p0(i);
            return this;
        }

        public Builder removeMixins(int i) {
            copyOnWrite();
            ((Api) this.instance).m12378q0(i);
            return this;
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((Api) this.instance).m12380r0(i);
            return this;
        }

        public Builder setMethods(int i, Method method) {
            copyOnWrite();
            ((Api) this.instance).m12382s0(i, method);
            return this;
        }

        public Builder setMixins(int i, Mixin mixin) {
            copyOnWrite();
            ((Api) this.instance).m12384t0(i, mixin);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Api) this.instance).m12386u0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Api) this.instance).m12388v0(byteString);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            copyOnWrite();
            ((Api) this.instance).m12390w0(i, option);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((Api) this.instance).m12392x0(sourceContext);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            copyOnWrite();
            ((Api) this.instance).m12394y0(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            copyOnWrite();
            ((Api) this.instance).m12396z0(i);
            return this;
        }

        public Builder setVersion(String str) {
            copyOnWrite();
            ((Api) this.instance).m12334A0(str);
            return this;
        }

        public Builder setVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((Api) this.instance).m12336B0(byteString);
            return this;
        }

        private Builder() {
            super(Api.f20344i);
        }

        public Builder addMethods(int i, Method method) {
            copyOnWrite();
            ((Api) this.instance).m12359Y(i, method);
            return this;
        }

        public Builder addMixins(int i, Mixin mixin) {
            copyOnWrite();
            ((Api) this.instance).m12361a0(i, mixin);
            return this;
        }

        public Builder addOptions(int i, Option option) {
            copyOnWrite();
            ((Api) this.instance).m12363c0(i, option);
            return this;
        }

        public Builder setMethods(int i, Method.Builder builder) {
            copyOnWrite();
            ((Api) this.instance).m12382s0(i, (Method) builder.build());
            return this;
        }

        public Builder setMixins(int i, Mixin.Builder builder) {
            copyOnWrite();
            ((Api) this.instance).m12384t0(i, (Mixin) builder.build());
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Api) this.instance).m12390w0(i, (Option) builder.build());
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            copyOnWrite();
            ((Api) this.instance).m12392x0((SourceContext) builder.build());
            return this;
        }

        public Builder addMethods(Method.Builder builder) {
            copyOnWrite();
            ((Api) this.instance).m12360Z((Method) builder.build());
            return this;
        }

        public Builder addMixins(Mixin.Builder builder) {
            copyOnWrite();
            ((Api) this.instance).m12362b0((Mixin) builder.build());
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            copyOnWrite();
            ((Api) this.instance).m12364d0((Option) builder.build());
            return this;
        }

        public Builder addMethods(int i, Method.Builder builder) {
            copyOnWrite();
            ((Api) this.instance).m12359Y(i, (Method) builder.build());
            return this;
        }

        public Builder addMixins(int i, Mixin.Builder builder) {
            copyOnWrite();
            ((Api) this.instance).m12361a0(i, (Mixin) builder.build());
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Api) this.instance).m12363c0(i, (Option) builder.build());
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Api$a */
    static /* synthetic */ class C3598a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20353a;

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
                f20353a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20353a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20353a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20353a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20353a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20353a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20353a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Api.C3598a.<clinit>():void");
        }
    }

    static {
        Api api = new Api();
        f20344i = api;
        GeneratedMessageLite.registerDefaultInstance(Api.class, api);
    }

    private Api() {
    }

    /* access modifiers changed from: private */
    /* renamed from: A0 */
    public void m12334A0(String str) {
        str.getClass();
        this.f20349e = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: B0 */
    public void m12336B0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20349e = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public void m12356V(Iterable<? extends Method> iterable) {
        m12372l0();
        AbstractMessageLite.addAll(iterable, this.f20347c);
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public void m12357W(Iterable<? extends Mixin> iterable) {
        m12373m0();
        AbstractMessageLite.addAll(iterable, this.f20351g);
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public void m12358X(Iterable<? extends Option> iterable) {
        m12374n0();
        AbstractMessageLite.addAll(iterable, this.f20348d);
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public void m12359Y(int i, Method method) {
        method.getClass();
        m12372l0();
        this.f20347c.add(i, method);
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public void m12360Z(Method method) {
        method.getClass();
        m12372l0();
        this.f20347c.add(method);
    }

    /* access modifiers changed from: private */
    /* renamed from: a0 */
    public void m12361a0(int i, Mixin mixin) {
        mixin.getClass();
        m12373m0();
        this.f20351g.add(i, mixin);
    }

    /* access modifiers changed from: private */
    /* renamed from: b0 */
    public void m12362b0(Mixin mixin) {
        mixin.getClass();
        m12373m0();
        this.f20351g.add(mixin);
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public void m12363c0(int i, Option option) {
        option.getClass();
        m12374n0();
        this.f20348d.add(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: d0 */
    public void m12364d0(Option option) {
        option.getClass();
        m12374n0();
        this.f20348d.add(option);
    }

    /* access modifiers changed from: private */
    /* renamed from: e0 */
    public void m12365e0() {
        this.f20347c = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* renamed from: f0 */
    public void m12366f0() {
        this.f20351g = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* renamed from: g0 */
    public void m12367g0() {
        this.f20346b = getDefaultInstance().getName();
    }

    public static Api getDefaultInstance() {
        return f20344i;
    }

    /* access modifiers changed from: private */
    /* renamed from: h0 */
    public void m12368h0() {
        this.f20348d = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* renamed from: i0 */
    public void m12369i0() {
        this.f20350f = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: j0 */
    public void m12370j0() {
        this.f20352h = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: k0 */
    public void m12371k0() {
        this.f20349e = getDefaultInstance().getVersion();
    }

    /* renamed from: l0 */
    private void m12372l0() {
        if (!this.f20347c.isModifiable()) {
            this.f20347c = GeneratedMessageLite.mutableCopy(this.f20347c);
        }
    }

    /* renamed from: m0 */
    private void m12373m0() {
        if (!this.f20351g.isModifiable()) {
            this.f20351g = GeneratedMessageLite.mutableCopy(this.f20351g);
        }
    }

    /* renamed from: n0 */
    private void m12374n0() {
        if (!this.f20348d.isModifiable()) {
            this.f20348d = GeneratedMessageLite.mutableCopy(this.f20348d);
        }
    }

    public static Builder newBuilder() {
        return (Builder) f20344i.createBuilder();
    }

    /* access modifiers changed from: private */
    /* renamed from: o0 */
    public void m12375o0(SourceContext sourceContext) {
        sourceContext.getClass();
        SourceContext sourceContext2 = this.f20350f;
        if (sourceContext2 == null || sourceContext2 == SourceContext.getDefaultInstance()) {
            this.f20350f = sourceContext;
        } else {
            this.f20350f = (SourceContext) ((SourceContext.Builder) SourceContext.newBuilder(this.f20350f).mergeFrom(sourceContext)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p0 */
    public void m12376p0(int i) {
        m12372l0();
        this.f20347c.remove(i);
    }

    public static Api parseDelimitedFrom(InputStream inputStream) {
        return (Api) GeneratedMessageLite.parseDelimitedFrom(f20344i, inputStream);
    }

    public static Api parseFrom(ByteBuffer byteBuffer) {
        return (Api) GeneratedMessageLite.parseFrom(f20344i, byteBuffer);
    }

    public static Parser<Api> parser() {
        return f20344i.getParserForType();
    }

    /* access modifiers changed from: private */
    /* renamed from: q0 */
    public void m12378q0(int i) {
        m12373m0();
        this.f20351g.remove(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: r0 */
    public void m12380r0(int i) {
        m12374n0();
        this.f20348d.remove(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: s0 */
    public void m12382s0(int i, Method method) {
        method.getClass();
        m12372l0();
        this.f20347c.set(i, method);
    }

    /* access modifiers changed from: private */
    /* renamed from: t0 */
    public void m12384t0(int i, Mixin mixin) {
        mixin.getClass();
        m12373m0();
        this.f20351g.set(i, mixin);
    }

    /* access modifiers changed from: private */
    /* renamed from: u0 */
    public void m12386u0(String str) {
        str.getClass();
        this.f20346b = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: v0 */
    public void m12388v0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20346b = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: w0 */
    public void m12390w0(int i, Option option) {
        option.getClass();
        m12374n0();
        this.f20348d.set(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: x0 */
    public void m12392x0(SourceContext sourceContext) {
        sourceContext.getClass();
        this.f20350f = sourceContext;
    }

    /* access modifiers changed from: private */
    /* renamed from: y0 */
    public void m12394y0(Syntax syntax) {
        this.f20352h = syntax.getNumber();
    }

    /* access modifiers changed from: private */
    /* renamed from: z0 */
    public void m12396z0(int i) {
        this.f20352h = i;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3598a.f20353a[methodToInvoke.ordinal()]) {
            case 1:
                return new Api();
            case 2:
                return new Builder((C3598a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20344i, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003\u001b\u0004Ȉ\u0005\t\u0006\u001b\u0007\f", new Object[]{"name_", "methods_", Method.class, "options_", Option.class, "version_", "sourceContext_", "mixins_", Mixin.class, "syntax_"});
            case 4:
                return f20344i;
            case 5:
                Parser<Api> parser = f20345j;
                if (parser == null) {
                    synchronized (Api.class) {
                        parser = f20345j;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20344i);
                            f20345j = parser;
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

    public Method getMethods(int i) {
        return this.f20347c.get(i);
    }

    public int getMethodsCount() {
        return this.f20347c.size();
    }

    public List<Method> getMethodsList() {
        return this.f20347c;
    }

    public MethodOrBuilder getMethodsOrBuilder(int i) {
        return this.f20347c.get(i);
    }

    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.f20347c;
    }

    public Mixin getMixins(int i) {
        return this.f20351g.get(i);
    }

    public int getMixinsCount() {
        return this.f20351g.size();
    }

    public List<Mixin> getMixinsList() {
        return this.f20351g;
    }

    public MixinOrBuilder getMixinsOrBuilder(int i) {
        return this.f20351g.get(i);
    }

    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.f20351g;
    }

    public String getName() {
        return this.f20346b;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f20346b);
    }

    public Option getOptions(int i) {
        return this.f20348d.get(i);
    }

    public int getOptionsCount() {
        return this.f20348d.size();
    }

    public List<Option> getOptionsList() {
        return this.f20348d;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.f20348d.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.f20348d;
    }

    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.f20350f;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.f20352h);
        return forNumber == null ? Syntax.UNRECOGNIZED : forNumber;
    }

    public int getSyntaxValue() {
        return this.f20352h;
    }

    public String getVersion() {
        return this.f20349e;
    }

    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.f20349e);
    }

    public boolean hasSourceContext() {
        return this.f20350f != null;
    }

    public static Builder newBuilder(Api api) {
        return (Builder) f20344i.createBuilder(api);
    }

    public static Api parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.parseDelimitedFrom(f20344i, inputStream, extensionRegistryLite);
    }

    public static Api parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.parseFrom(f20344i, byteBuffer, extensionRegistryLite);
    }

    public static Api parseFrom(ByteString byteString) {
        return (Api) GeneratedMessageLite.parseFrom(f20344i, byteString);
    }

    public static Api parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.parseFrom(f20344i, byteString, extensionRegistryLite);
    }

    public static Api parseFrom(byte[] bArr) {
        return (Api) GeneratedMessageLite.parseFrom(f20344i, bArr);
    }

    public static Api parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.parseFrom(f20344i, bArr, extensionRegistryLite);
    }

    public static Api parseFrom(InputStream inputStream) {
        return (Api) GeneratedMessageLite.parseFrom(f20344i, inputStream);
    }

    public static Api parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.parseFrom(f20344i, inputStream, extensionRegistryLite);
    }

    public static Api parseFrom(CodedInputStream codedInputStream) {
        return (Api) GeneratedMessageLite.parseFrom(f20344i, codedInputStream);
    }

    public static Api parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Api) GeneratedMessageLite.parseFrom(f20344i, codedInputStream, extensionRegistryLite);
    }
}
