package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Timestamp extends GeneratedMessageLite<Timestamp, Builder> implements TimestampOrBuilder {
    public static final int NANOS_FIELD_NUMBER = 2;
    public static final int SECONDS_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Timestamp f20687d;

    /* renamed from: e */
    private static volatile Parser<Timestamp> f20688e;

    /* renamed from: b */
    private long f20689b;

    /* renamed from: c */
    private int f20690c;

    public static final class Builder extends GeneratedMessageLite.Builder<Timestamp, Builder> implements TimestampOrBuilder {
        /* synthetic */ Builder(C3669a aVar) {
            this();
        }

        public Builder clearNanos() {
            copyOnWrite();
            ((Timestamp) this.instance).m12962v();
            return this;
        }

        public Builder clearSeconds() {
            copyOnWrite();
            ((Timestamp) this.instance).m12963w();
            return this;
        }

        public int getNanos() {
            return ((Timestamp) this.instance).getNanos();
        }

        public long getSeconds() {
            return ((Timestamp) this.instance).getSeconds();
        }

        public Builder setNanos(int i) {
            copyOnWrite();
            ((Timestamp) this.instance).m12964x(i);
            return this;
        }

        public Builder setSeconds(long j) {
            copyOnWrite();
            ((Timestamp) this.instance).m12965y(j);
            return this;
        }

        private Builder() {
            super(Timestamp.f20687d);
        }
    }

    /* renamed from: com.google.protobuf.Timestamp$a */
    static /* synthetic */ class C3669a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20691a;

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
                f20691a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20691a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20691a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20691a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20691a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20691a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20691a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Timestamp.C3669a.<clinit>():void");
        }
    }

    static {
        Timestamp timestamp = new Timestamp();
        f20687d = timestamp;
        GeneratedMessageLite.registerDefaultInstance(Timestamp.class, timestamp);
    }

    private Timestamp() {
    }

    public static Timestamp getDefaultInstance() {
        return f20687d;
    }

    public static Builder newBuilder() {
        return (Builder) f20687d.createBuilder();
    }

    public static Timestamp parseDelimitedFrom(InputStream inputStream) {
        return (Timestamp) GeneratedMessageLite.parseDelimitedFrom(f20687d, inputStream);
    }

    public static Timestamp parseFrom(ByteBuffer byteBuffer) {
        return (Timestamp) GeneratedMessageLite.parseFrom(f20687d, byteBuffer);
    }

    public static Parser<Timestamp> parser() {
        return f20687d.getParserForType();
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m12962v() {
        this.f20690c = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m12963w() {
        this.f20689b = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m12964x(int i) {
        this.f20690c = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m12965y(long j) {
        this.f20689b = j;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C3669a.f20691a[methodToInvoke.ordinal()]) {
            case 1:
                return new Timestamp();
            case 2:
                return new Builder((C3669a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f20687d, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"seconds_", "nanos_"});
            case 4:
                return f20687d;
            case 5:
                Parser<Timestamp> parser = f20688e;
                if (parser == null) {
                    synchronized (Timestamp.class) {
                        parser = f20688e;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20687d);
                            f20688e = parser;
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

    public int getNanos() {
        return this.f20690c;
    }

    public long getSeconds() {
        return this.f20689b;
    }

    public static Builder newBuilder(Timestamp timestamp) {
        return (Builder) f20687d.createBuilder(timestamp);
    }

    public static Timestamp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp) GeneratedMessageLite.parseDelimitedFrom(f20687d, inputStream, extensionRegistryLite);
    }

    public static Timestamp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp) GeneratedMessageLite.parseFrom(f20687d, byteBuffer, extensionRegistryLite);
    }

    public static Timestamp parseFrom(ByteString byteString) {
        return (Timestamp) GeneratedMessageLite.parseFrom(f20687d, byteString);
    }

    public static Timestamp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp) GeneratedMessageLite.parseFrom(f20687d, byteString, extensionRegistryLite);
    }

    public static Timestamp parseFrom(byte[] bArr) {
        return (Timestamp) GeneratedMessageLite.parseFrom(f20687d, bArr);
    }

    public static Timestamp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp) GeneratedMessageLite.parseFrom(f20687d, bArr, extensionRegistryLite);
    }

    public static Timestamp parseFrom(InputStream inputStream) {
        return (Timestamp) GeneratedMessageLite.parseFrom(f20687d, inputStream);
    }

    public static Timestamp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp) GeneratedMessageLite.parseFrom(f20687d, inputStream, extensionRegistryLite);
    }

    public static Timestamp parseFrom(CodedInputStream codedInputStream) {
        return (Timestamp) GeneratedMessageLite.parseFrom(f20687d, codedInputStream);
    }

    public static Timestamp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp) GeneratedMessageLite.parseFrom(f20687d, codedInputStream, extensionRegistryLite);
    }
}
