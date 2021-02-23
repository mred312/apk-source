package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class FieldMask extends GeneratedMessageLite<FieldMask, Builder> implements FieldMaskOrBuilder {
    public static final int PATHS_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final FieldMask f20532c;

    /* renamed from: d */
    private static volatile Parser<FieldMask> f20533d;

    /* renamed from: b */
    private Internal.ProtobufList<String> f20534b = GeneratedMessageLite.emptyProtobufList();

    public static final class Builder extends GeneratedMessageLite.Builder<FieldMask, Builder> implements FieldMaskOrBuilder {
        /* synthetic */ Builder(C3637a aVar) {
            this();
        }

        public Builder addAllPaths(Iterable<String> iterable) {
            copyOnWrite();
            ((FieldMask) this.instance).m12699w(iterable);
            return this;
        }

        public Builder addPaths(String str) {
            copyOnWrite();
            ((FieldMask) this.instance).m12700x(str);
            return this;
        }

        public Builder addPathsBytes(ByteString byteString) {
            copyOnWrite();
            ((FieldMask) this.instance).m12701y(byteString);
            return this;
        }

        public Builder clearPaths() {
            copyOnWrite();
            ((FieldMask) this.instance).m12702z();
            return this;
        }

        public String getPaths(int i) {
            return ((FieldMask) this.instance).getPaths(i);
        }

        public ByteString getPathsBytes(int i) {
            return ((FieldMask) this.instance).getPathsBytes(i);
        }

        public int getPathsCount() {
            return ((FieldMask) this.instance).getPathsCount();
        }

        public List<String> getPathsList() {
            return Collections.unmodifiableList(((FieldMask) this.instance).getPathsList());
        }

        public Builder setPaths(int i, String str) {
            copyOnWrite();
            ((FieldMask) this.instance).m12692B(i, str);
            return this;
        }

        private Builder() {
            super(FieldMask.f20532c);
        }
    }

    /* renamed from: com.google.protobuf.FieldMask$a */
    static /* synthetic */ class C3637a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20535a;

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
                f20535a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20535a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20535a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20535a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20535a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20535a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20535a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.FieldMask.C3637a.<clinit>():void");
        }
    }

    static {
        FieldMask fieldMask = new FieldMask();
        f20532c = fieldMask;
        GeneratedMessageLite.registerDefaultInstance(FieldMask.class, fieldMask);
    }

    private FieldMask() {
    }

    /* renamed from: A */
    private void m12691A() {
        if (!this.f20534b.isModifiable()) {
            this.f20534b = GeneratedMessageLite.mutableCopy(this.f20534b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m12692B(int i, String str) {
        str.getClass();
        m12691A();
        this.f20534b.set(i, str);
    }

    public static FieldMask getDefaultInstance() {
        return f20532c;
    }

    public static Builder newBuilder() {
        return (Builder) f20532c.createBuilder();
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream) {
        return (FieldMask) GeneratedMessageLite.parseDelimitedFrom(f20532c, inputStream);
    }

    public static FieldMask parseFrom(ByteBuffer byteBuffer) {
        return (FieldMask) GeneratedMessageLite.parseFrom(f20532c, byteBuffer);
    }

    public static Parser<FieldMask> parser() {
        return f20532c.getParserForType();
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m12699w(Iterable<String> iterable) {
        m12691A();
        AbstractMessageLite.addAll(iterable, this.f20534b);
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m12700x(String str) {
        str.getClass();
        m12691A();
        this.f20534b.add(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m12701y(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        m12691A();
        this.f20534b.add(byteString.toStringUtf8());
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m12702z() {
        this.f20534b = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3637a.f20535a[methodToInvoke.ordinal()]) {
            case 1:
                return new FieldMask();
            case 2:
                return new Builder((C3637a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20532c, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"paths_"});
            case 4:
                return f20532c;
            case 5:
                Parser<FieldMask> parser = f20533d;
                if (parser == null) {
                    synchronized (FieldMask.class) {
                        parser = f20533d;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20532c);
                            f20533d = parser;
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

    public String getPaths(int i) {
        return this.f20534b.get(i);
    }

    public ByteString getPathsBytes(int i) {
        return ByteString.copyFromUtf8(this.f20534b.get(i));
    }

    public int getPathsCount() {
        return this.f20534b.size();
    }

    public List<String> getPathsList() {
        return this.f20534b;
    }

    public static Builder newBuilder(FieldMask fieldMask) {
        return (Builder) f20532c.createBuilder(fieldMask);
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask) GeneratedMessageLite.parseDelimitedFrom(f20532c, inputStream, extensionRegistryLite);
    }

    public static FieldMask parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask) GeneratedMessageLite.parseFrom(f20532c, byteBuffer, extensionRegistryLite);
    }

    public static FieldMask parseFrom(ByteString byteString) {
        return (FieldMask) GeneratedMessageLite.parseFrom(f20532c, byteString);
    }

    public static FieldMask parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask) GeneratedMessageLite.parseFrom(f20532c, byteString, extensionRegistryLite);
    }

    public static FieldMask parseFrom(byte[] bArr) {
        return (FieldMask) GeneratedMessageLite.parseFrom(f20532c, bArr);
    }

    public static FieldMask parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask) GeneratedMessageLite.parseFrom(f20532c, bArr, extensionRegistryLite);
    }

    public static FieldMask parseFrom(InputStream inputStream) {
        return (FieldMask) GeneratedMessageLite.parseFrom(f20532c, inputStream);
    }

    public static FieldMask parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask) GeneratedMessageLite.parseFrom(f20532c, inputStream, extensionRegistryLite);
    }

    public static FieldMask parseFrom(CodedInputStream codedInputStream) {
        return (FieldMask) GeneratedMessageLite.parseFrom(f20532c, codedInputStream);
    }

    public static FieldMask parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask) GeneratedMessageLite.parseFrom(f20532c, codedInputStream, extensionRegistryLite);
    }
}
