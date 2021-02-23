package com.google.protobuf;

import com.google.protobuf.Field;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Type extends GeneratedMessageLite<Type, Builder> implements TypeOrBuilder {
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final Type f20692h;

    /* renamed from: i */
    private static volatile Parser<Type> f20693i;

    /* renamed from: b */
    private String f20694b = "";

    /* renamed from: c */
    private Internal.ProtobufList<Field> f20695c = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: d */
    private Internal.ProtobufList<String> f20696d = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: e */
    private Internal.ProtobufList<Option> f20697e = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: f */
    private SourceContext f20698f;

    /* renamed from: g */
    private int f20699g;

    public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements TypeOrBuilder {
        /* synthetic */ Builder(C3670a aVar) {
            this();
        }

        public Builder addAllFields(Iterable<? extends Field> iterable) {
            copyOnWrite();
            ((Type) this.instance).m12983R(iterable);
            return this;
        }

        public Builder addAllOneofs(Iterable<String> iterable) {
            copyOnWrite();
            ((Type) this.instance).m12984S(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            copyOnWrite();
            ((Type) this.instance).m12985T(iterable);
            return this;
        }

        public Builder addFields(Field field) {
            copyOnWrite();
            ((Type) this.instance).m12987V(field);
            return this;
        }

        public Builder addOneofs(String str) {
            copyOnWrite();
            ((Type) this.instance).m12988W(str);
            return this;
        }

        public Builder addOneofsBytes(ByteString byteString) {
            copyOnWrite();
            ((Type) this.instance).m12989X(byteString);
            return this;
        }

        public Builder addOptions(Option option) {
            copyOnWrite();
            ((Type) this.instance).m12991Z(option);
            return this;
        }

        public Builder clearFields() {
            copyOnWrite();
            ((Type) this.instance).m12992a0();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Type) this.instance).m12993b0();
            return this;
        }

        public Builder clearOneofs() {
            copyOnWrite();
            ((Type) this.instance).m12994c0();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((Type) this.instance).m12995d0();
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            ((Type) this.instance).m12996e0();
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((Type) this.instance).m12997f0();
            return this;
        }

        public Field getFields(int i) {
            return ((Type) this.instance).getFields(i);
        }

        public int getFieldsCount() {
            return ((Type) this.instance).getFieldsCount();
        }

        public List<Field> getFieldsList() {
            return Collections.unmodifiableList(((Type) this.instance).getFieldsList());
        }

        public String getName() {
            return ((Type) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Type) this.instance).getNameBytes();
        }

        public String getOneofs(int i) {
            return ((Type) this.instance).getOneofs(i);
        }

        public ByteString getOneofsBytes(int i) {
            return ((Type) this.instance).getOneofsBytes(i);
        }

        public int getOneofsCount() {
            return ((Type) this.instance).getOneofsCount();
        }

        public List<String> getOneofsList() {
            return Collections.unmodifiableList(((Type) this.instance).getOneofsList());
        }

        public Option getOptions(int i) {
            return ((Type) this.instance).getOptions(i);
        }

        public int getOptionsCount() {
            return ((Type) this.instance).getOptionsCount();
        }

        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Type) this.instance).getOptionsList());
        }

        public SourceContext getSourceContext() {
            return ((Type) this.instance).getSourceContext();
        }

        public Syntax getSyntax() {
            return ((Type) this.instance).getSyntax();
        }

        public int getSyntaxValue() {
            return ((Type) this.instance).getSyntaxValue();
        }

        public boolean hasSourceContext() {
            return ((Type) this.instance).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((Type) this.instance).m13001j0(sourceContext);
            return this;
        }

        public Builder removeFields(int i) {
            copyOnWrite();
            ((Type) this.instance).m13002k0(i);
            return this;
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((Type) this.instance).m13003l0(i);
            return this;
        }

        public Builder setFields(int i, Field field) {
            copyOnWrite();
            ((Type) this.instance).m13004m0(i, field);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Type) this.instance).m13005n0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Type) this.instance).m13006o0(byteString);
            return this;
        }

        public Builder setOneofs(int i, String str) {
            copyOnWrite();
            ((Type) this.instance).m13007p0(i, str);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            copyOnWrite();
            ((Type) this.instance).m13009q0(i, option);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((Type) this.instance).m13011r0(sourceContext);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            copyOnWrite();
            ((Type) this.instance).m13013s0(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            copyOnWrite();
            ((Type) this.instance).m13015t0(i);
            return this;
        }

        private Builder() {
            super(Type.f20692h);
        }

        public Builder addFields(int i, Field field) {
            copyOnWrite();
            ((Type) this.instance).m12986U(i, field);
            return this;
        }

        public Builder addOptions(int i, Option option) {
            copyOnWrite();
            ((Type) this.instance).m12990Y(i, option);
            return this;
        }

        public Builder setFields(int i, Field.Builder builder) {
            copyOnWrite();
            ((Type) this.instance).m13004m0(i, (Field) builder.build());
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Type) this.instance).m13009q0(i, (Option) builder.build());
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            copyOnWrite();
            ((Type) this.instance).m13011r0((SourceContext) builder.build());
            return this;
        }

        public Builder addFields(Field.Builder builder) {
            copyOnWrite();
            ((Type) this.instance).m12987V((Field) builder.build());
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            copyOnWrite();
            ((Type) this.instance).m12991Z((Option) builder.build());
            return this;
        }

        public Builder addFields(int i, Field.Builder builder) {
            copyOnWrite();
            ((Type) this.instance).m12986U(i, (Field) builder.build());
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Type) this.instance).m12990Y(i, (Option) builder.build());
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Type$a */
    static /* synthetic */ class C3670a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20700a;

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
                f20700a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20700a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20700a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20700a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20700a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20700a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20700a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Type.C3670a.<clinit>():void");
        }
    }

    static {
        Type type = new Type();
        f20692h = type;
        GeneratedMessageLite.registerDefaultInstance(Type.class, type);
    }

    private Type() {
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public void m12983R(Iterable<? extends Field> iterable) {
        m12998g0();
        AbstractMessageLite.addAll(iterable, this.f20695c);
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m12984S(Iterable<String> iterable) {
        m12999h0();
        AbstractMessageLite.addAll(iterable, this.f20696d);
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m12985T(Iterable<? extends Option> iterable) {
        m13000i0();
        AbstractMessageLite.addAll(iterable, this.f20697e);
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public void m12986U(int i, Field field) {
        field.getClass();
        m12998g0();
        this.f20695c.add(i, field);
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public void m12987V(Field field) {
        field.getClass();
        m12998g0();
        this.f20695c.add(field);
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public void m12988W(String str) {
        str.getClass();
        m12999h0();
        this.f20696d.add(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public void m12989X(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        m12999h0();
        this.f20696d.add(byteString.toStringUtf8());
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public void m12990Y(int i, Option option) {
        option.getClass();
        m13000i0();
        this.f20697e.add(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public void m12991Z(Option option) {
        option.getClass();
        m13000i0();
        this.f20697e.add(option);
    }

    /* access modifiers changed from: private */
    /* renamed from: a0 */
    public void m12992a0() {
        this.f20695c = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* renamed from: b0 */
    public void m12993b0() {
        this.f20694b = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public void m12994c0() {
        this.f20696d = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* renamed from: d0 */
    public void m12995d0() {
        this.f20697e = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* renamed from: e0 */
    public void m12996e0() {
        this.f20698f = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: f0 */
    public void m12997f0() {
        this.f20699g = 0;
    }

    /* renamed from: g0 */
    private void m12998g0() {
        if (!this.f20695c.isModifiable()) {
            this.f20695c = GeneratedMessageLite.mutableCopy(this.f20695c);
        }
    }

    public static Type getDefaultInstance() {
        return f20692h;
    }

    /* renamed from: h0 */
    private void m12999h0() {
        if (!this.f20696d.isModifiable()) {
            this.f20696d = GeneratedMessageLite.mutableCopy(this.f20696d);
        }
    }

    /* renamed from: i0 */
    private void m13000i0() {
        if (!this.f20697e.isModifiable()) {
            this.f20697e = GeneratedMessageLite.mutableCopy(this.f20697e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j0 */
    public void m13001j0(SourceContext sourceContext) {
        sourceContext.getClass();
        SourceContext sourceContext2 = this.f20698f;
        if (sourceContext2 == null || sourceContext2 == SourceContext.getDefaultInstance()) {
            this.f20698f = sourceContext;
        } else {
            this.f20698f = (SourceContext) ((SourceContext.Builder) SourceContext.newBuilder(this.f20698f).mergeFrom(sourceContext)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k0 */
    public void m13002k0(int i) {
        m12998g0();
        this.f20695c.remove(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: l0 */
    public void m13003l0(int i) {
        m13000i0();
        this.f20697e.remove(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: m0 */
    public void m13004m0(int i, Field field) {
        field.getClass();
        m12998g0();
        this.f20695c.set(i, field);
    }

    /* access modifiers changed from: private */
    /* renamed from: n0 */
    public void m13005n0(String str) {
        str.getClass();
        this.f20694b = str;
    }

    public static Builder newBuilder() {
        return (Builder) f20692h.createBuilder();
    }

    /* access modifiers changed from: private */
    /* renamed from: o0 */
    public void m13006o0(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f20694b = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    /* renamed from: p0 */
    public void m13007p0(int i, String str) {
        str.getClass();
        m12999h0();
        this.f20696d.set(i, str);
    }

    public static Type parseDelimitedFrom(InputStream inputStream) {
        return (Type) GeneratedMessageLite.parseDelimitedFrom(f20692h, inputStream);
    }

    public static Type parseFrom(ByteBuffer byteBuffer) {
        return (Type) GeneratedMessageLite.parseFrom(f20692h, byteBuffer);
    }

    public static Parser<Type> parser() {
        return f20692h.getParserForType();
    }

    /* access modifiers changed from: private */
    /* renamed from: q0 */
    public void m13009q0(int i, Option option) {
        option.getClass();
        m13000i0();
        this.f20697e.set(i, option);
    }

    /* access modifiers changed from: private */
    /* renamed from: r0 */
    public void m13011r0(SourceContext sourceContext) {
        sourceContext.getClass();
        this.f20698f = sourceContext;
    }

    /* access modifiers changed from: private */
    /* renamed from: s0 */
    public void m13013s0(Syntax syntax) {
        this.f20699g = syntax.getNumber();
    }

    /* access modifiers changed from: private */
    /* renamed from: t0 */
    public void m13015t0(int i) {
        this.f20699g = i;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3670a.f20700a[methodToInvoke.ordinal()]) {
            case 1:
                return new Type();
            case 2:
                return new Builder((C3670a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20692h, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003Ț\u0004\u001b\u0005\t\u0006\f", new Object[]{"name_", "fields_", Field.class, "oneofs_", "options_", Option.class, "sourceContext_", "syntax_"});
            case 4:
                return f20692h;
            case 5:
                Parser<Type> parser = f20693i;
                if (parser == null) {
                    synchronized (Type.class) {
                        parser = f20693i;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20692h);
                            f20693i = parser;
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

    public Field getFields(int i) {
        return this.f20695c.get(i);
    }

    public int getFieldsCount() {
        return this.f20695c.size();
    }

    public List<Field> getFieldsList() {
        return this.f20695c;
    }

    public FieldOrBuilder getFieldsOrBuilder(int i) {
        return this.f20695c.get(i);
    }

    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.f20695c;
    }

    public String getName() {
        return this.f20694b;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f20694b);
    }

    public String getOneofs(int i) {
        return this.f20696d.get(i);
    }

    public ByteString getOneofsBytes(int i) {
        return ByteString.copyFromUtf8(this.f20696d.get(i));
    }

    public int getOneofsCount() {
        return this.f20696d.size();
    }

    public List<String> getOneofsList() {
        return this.f20696d;
    }

    public Option getOptions(int i) {
        return this.f20697e.get(i);
    }

    public int getOptionsCount() {
        return this.f20697e.size();
    }

    public List<Option> getOptionsList() {
        return this.f20697e;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.f20697e.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.f20697e;
    }

    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.f20698f;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.f20699g);
        return forNumber == null ? Syntax.UNRECOGNIZED : forNumber;
    }

    public int getSyntaxValue() {
        return this.f20699g;
    }

    public boolean hasSourceContext() {
        return this.f20698f != null;
    }

    public static Builder newBuilder(Type type) {
        return (Builder) f20692h.createBuilder(type);
    }

    public static Type parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.parseDelimitedFrom(f20692h, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.parseFrom(f20692h, byteBuffer, extensionRegistryLite);
    }

    public static Type parseFrom(ByteString byteString) {
        return (Type) GeneratedMessageLite.parseFrom(f20692h, byteString);
    }

    public static Type parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.parseFrom(f20692h, byteString, extensionRegistryLite);
    }

    public static Type parseFrom(byte[] bArr) {
        return (Type) GeneratedMessageLite.parseFrom(f20692h, bArr);
    }

    public static Type parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.parseFrom(f20692h, bArr, extensionRegistryLite);
    }

    public static Type parseFrom(InputStream inputStream) {
        return (Type) GeneratedMessageLite.parseFrom(f20692h, inputStream);
    }

    public static Type parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.parseFrom(f20692h, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(CodedInputStream codedInputStream) {
        return (Type) GeneratedMessageLite.parseFrom(f20692h, codedInputStream);
    }

    public static Type parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.parseFrom(f20692h, codedInputStream, extensionRegistryLite);
    }
}
