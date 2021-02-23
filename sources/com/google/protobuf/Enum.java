package com.google.protobuf;

import com.google.protobuf.EnumValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Enum extends GeneratedMessageLite<Enum, Builder> implements EnumOrBuilder {
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final Enum f20463g;

    /* renamed from: h */
    private static volatile Parser<Enum> f20464h;

    /* renamed from: b */
    private String f20465b = "";

    /* renamed from: c */
    private Internal.ProtobufList<EnumValue> f20466c = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: d */
    private Internal.ProtobufList<Option> f20467d = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: e */
    private SourceContext f20468e;

    /* renamed from: f */
    private int f20469f;

    public static final class Builder extends GeneratedMessageLite.Builder<Enum, Builder> implements EnumOrBuilder {
        /* synthetic */ Builder(C3627a aVar) {
            this();
        }

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> iterable) {
            copyOnWrite();
            ((Enum) this.instance).m12545M(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            copyOnWrite();
            ((Enum) this.instance).m12546N(iterable);
            return this;
        }

        public Builder addEnumvalue(EnumValue enumValue) {
            copyOnWrite();
            ((Enum) this.instance).m12548P(enumValue);
            return this;
        }

        public Builder addOptions(Option option) {
            copyOnWrite();
            ((Enum) this.instance).m12550R(option);
            return this;
        }

        public Builder clearEnumvalue() {
            copyOnWrite();
            ((Enum) this.instance).m12551S();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Enum) this.instance).m12552T();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((Enum) this.instance).m12553U();
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            ((Enum) this.instance).m12554V();
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((Enum) this.instance).m12555W();
            return this;
        }

        public EnumValue getEnumvalue(int i) {
            return ((Enum) this.instance).getEnumvalue(i);
        }

        public int getEnumvalueCount() {
            return ((Enum) this.instance).getEnumvalueCount();
        }

        public List<EnumValue> getEnumvalueList() {
            return Collections.unmodifiableList(((Enum) this.instance).getEnumvalueList());
        }

        public String getName() {
            return ((Enum) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Enum) this.instance).getNameBytes();
        }

        public Option getOptions(int i) {
            return ((Enum) this.instance).getOptions(i);
        }

        public int getOptionsCount() {
            return ((Enum) this.instance).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Enum) this.instance).getOptionsList());
        }

        public SourceContext getSourceContext() {
            return ((Enum) this.instance).getSourceContext();
        }

        public Syntax getSyntax() {
            return ((Enum) this.instance).getSyntax();
        }

        public int getSyntaxValue() {
            return ((Enum) this.instance).getSyntaxValue();
        }

        public boolean hasSourceContext() {
            return ((Enum) this.instance).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((Enum) this.instance).m12558Z(sourceContext);
            return this;
        }

        public Builder removeEnumvalue(int i) {
            copyOnWrite();
            ((Enum) this.instance).m12559a0(i);
            return this;
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((Enum) this.instance).m12560b0(i);
            return this;
        }

        public Builder setEnumvalue(int i, EnumValue enumValue) {
            copyOnWrite();
            ((Enum) this.instance).m12561c0(i, enumValue);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Enum) this.instance).m12562d0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Enum) this.instance).m12563e0(byteString);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            copyOnWrite();
            ((Enum) this.instance).m12564f0(i, option);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((Enum) this.instance).m12565g0(sourceContext);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            copyOnWrite();
            ((Enum) this.instance).m12566h0(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            copyOnWrite();
            ((Enum) this.instance).m12567i0(i);
            return this;
        }

        private Builder() {
            super(Enum.f20463g);
        }

        public Builder addEnumvalue(int i, EnumValue enumValue) {
            copyOnWrite();
            ((Enum) this.instance).m12547O(i, enumValue);
            return this;
        }

        public Builder addOptions(int i, Option option) {
            copyOnWrite();
            ((Enum) this.instance).m12549Q(i, option);
            return this;
        }

        public Builder setEnumvalue(int i, EnumValue.Builder builder) {
            copyOnWrite();
            ((Enum) this.instance).m12561c0(i, (EnumValue) builder.build());
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Enum) this.instance).m12564f0(i, (Option) builder.build());
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            copyOnWrite();
            ((Enum) this.instance).m12565g0((SourceContext) builder.build());
            return this;
        }

        public Builder addEnumvalue(EnumValue.Builder builder) {
            copyOnWrite();
            ((Enum) this.instance).m12548P((EnumValue) builder.build());
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            copyOnWrite();
            ((Enum) this.instance).m12550R((Option) builder.build());
            return this;
        }

        public Builder addEnumvalue(int i, EnumValue.Builder builder) {
            copyOnWrite();
            ((Enum) this.instance).m12547O(i, (EnumValue) builder.build());
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Enum) this.instance).m12549Q(i, (Option) builder.build());
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Enum$a */
    static /* synthetic */ class C3627a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20470a;

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
                f20470a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20470a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20470a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20470a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20470a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20470a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20470a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Enum.C3627a.<clinit>():void");
        }
    }

    static {
        Enum enumR = new Enum();
        f20463g = enumR;
        GeneratedMessageLite.registerDefaultInstance(Enum.class, enumR);
    }

    private Enum() {
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public void m12545M(Iterable<? extends EnumValue> iterable) {
        m12556X();
        AbstractMessageLite.addAll(iterable, this.f20466c);
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public void m12546N(Iterable<? extends Option> iterable) {
        m12557Y();
        AbstractMessageLite.addAll(iterable, this.f20467d);
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m12547O(int i, EnumValue enumValue) {
        enumValue.getClass();
        m12556X();
        this.f20466c.add(i, enumValue);
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public void m12548P(EnumValue enumValue) {
        enumValue.getClass();
        m12556X();
        this.f20466c.add(enumValue);
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m12549Q(int i, Option option) {
        option.getClass();
        m12557Y();
        this.f20467d.add(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public void m12550R(Option option) {
        option.getClass();
        m12557Y();
        this.f20467d.add(option);
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m12551S() {
        this.f20466c = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m12552T() {
        this.f20465b = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public void m12553U() {
        this.f20467d = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public void m12554V() {
        this.f20468e = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public void m12555W() {
        this.f20469f = 0;
    }

    /* renamed from: X */
    private void m12556X() {
        if (!this.f20466c.isModifiable()) {
            this.f20466c = GeneratedMessageLite.mutableCopy(this.f20466c);
        }
    }

    /* renamed from: Y */
    private void m12557Y() {
        if (!this.f20467d.isModifiable()) {
            this.f20467d = GeneratedMessageLite.mutableCopy(this.f20467d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public void m12558Z(SourceContext sourceContext) {
        sourceContext.getClass();
        SourceContext sourceContext2 = this.f20468e;
        if (sourceContext2 == null || sourceContext2 == SourceContext.getDefaultInstance()) {
            this.f20468e = sourceContext;
        } else {
            this.f20468e = (SourceContext) ((SourceContext.Builder) SourceContext.newBuilder(this.f20468e).mergeFrom(sourceContext)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a0 */
    public void m12559a0(int i) {
        m12556X();
        this.f20466c.remove(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: b0 */
    public void m12560b0(int i) {
        m12557Y();
        this.f20467d.remove(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public void m12561c0(int i, EnumValue enumValue) {
        enumValue.getClass();
        m12556X();
        this.f20466c.set(i, enumValue);
    }

    /* access modifiers changed from: private */
    /* renamed from: d0 */
    public void m12562d0(String str) {
        str.getClass();
        this.f20465b = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: e0 */
    public void m12563e0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20465b = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: f0 */
    public void m12564f0(int i, Option option) {
        option.getClass();
        m12557Y();
        this.f20467d.set(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: g0 */
    public void m12565g0(SourceContext sourceContext) {
        sourceContext.getClass();
        this.f20468e = sourceContext;
    }

    public static Enum getDefaultInstance() {
        return f20463g;
    }

    /* access modifiers changed from: private */
    /* renamed from: h0 */
    public void m12566h0(Syntax syntax) {
        this.f20469f = syntax.getNumber();
    }

    /* access modifiers changed from: private */
    /* renamed from: i0 */
    public void m12567i0(int i) {
        this.f20469f = i;
    }

    public static Builder newBuilder() {
        return (Builder) f20463g.createBuilder();
    }

    public static Enum parseDelimitedFrom(InputStream inputStream) {
        return (Enum) GeneratedMessageLite.parseDelimitedFrom(f20463g, inputStream);
    }

    public static Enum parseFrom(ByteBuffer byteBuffer) {
        return (Enum) GeneratedMessageLite.parseFrom(f20463g, byteBuffer);
    }

    public static Parser<Enum> parser() {
        return f20463g.getParserForType();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3627a.f20470a[methodToInvoke.ordinal()]) {
            case 1:
                return new Enum();
            case 2:
                return new Builder((C3627a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20463g, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002\u001b\u0003\u001b\u0004\t\u0005\f", new Object[]{"name_", "enumvalue_", EnumValue.class, "options_", Option.class, "sourceContext_", "syntax_"});
            case 4:
                return f20463g;
            case 5:
                Parser<Enum> parser = f20464h;
                if (parser == null) {
                    synchronized (Enum.class) {
                        parser = f20464h;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20463g);
                            f20464h = parser;
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

    public EnumValue getEnumvalue(int i) {
        return this.f20466c.get(i);
    }

    public int getEnumvalueCount() {
        return this.f20466c.size();
    }

    public List<EnumValue> getEnumvalueList() {
        return this.f20466c;
    }

    public EnumValueOrBuilder getEnumvalueOrBuilder(int i) {
        return this.f20466c.get(i);
    }

    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.f20466c;
    }

    public String getName() {
        return this.f20465b;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f20465b);
    }

    public Option getOptions(int i) {
        return this.f20467d.get(i);
    }

    public int getOptionsCount() {
        return this.f20467d.size();
    }

    public List<Option> getOptionsList() {
        return this.f20467d;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.f20467d.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.f20467d;
    }

    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.f20468e;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.f20469f);
        return forNumber == null ? Syntax.UNRECOGNIZED : forNumber;
    }

    public int getSyntaxValue() {
        return this.f20469f;
    }

    public boolean hasSourceContext() {
        return this.f20468e != null;
    }

    public static Builder newBuilder(Enum enumR) {
        return (Builder) f20463g.createBuilder(enumR);
    }

    public static Enum parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.parseDelimitedFrom(f20463g, inputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.parseFrom(f20463g, byteBuffer, extensionRegistryLite);
    }

    public static Enum parseFrom(ByteString byteString) {
        return (Enum) GeneratedMessageLite.parseFrom(f20463g, byteString);
    }

    public static Enum parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.parseFrom(f20463g, byteString, extensionRegistryLite);
    }

    public static Enum parseFrom(byte[] bArr) {
        return (Enum) GeneratedMessageLite.parseFrom(f20463g, bArr);
    }

    public static Enum parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.parseFrom(f20463g, bArr, extensionRegistryLite);
    }

    public static Enum parseFrom(InputStream inputStream) {
        return (Enum) GeneratedMessageLite.parseFrom(f20463g, inputStream);
    }

    public static Enum parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.parseFrom(f20463g, inputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(CodedInputStream codedInputStream) {
        return (Enum) GeneratedMessageLite.parseFrom(f20463g, codedInputStream);
    }

    public static Enum parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.parseFrom(f20463g, codedInputStream, extensionRegistryLite);
    }
}
