package com.google.android.gms.config.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Logs {

    public static final class AndroidConfigFetchProto extends GeneratedMessageLite<AndroidConfigFetchProto, Builder> implements AndroidConfigFetchProtoOrBuilder {
        public static final int REASON_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public static final AndroidConfigFetchProto f7743d;

        /* renamed from: e */
        private static volatile Parser<AndroidConfigFetchProto> f7744e;

        /* renamed from: b */
        private int f7745b;

        /* renamed from: c */
        private ConfigFetchReason f7746c;

        public static final class Builder extends GeneratedMessageLite.Builder<AndroidConfigFetchProto, Builder> implements AndroidConfigFetchProtoOrBuilder {
            /* synthetic */ Builder(C1698a aVar) {
                this();
            }

            public Builder clearReason() {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).m5728u();
                return this;
            }

            public ConfigFetchReason getReason() {
                return ((AndroidConfigFetchProto) this.instance).getReason();
            }

            public boolean hasReason() {
                return ((AndroidConfigFetchProto) this.instance).hasReason();
            }

            public Builder mergeReason(ConfigFetchReason configFetchReason) {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).m5729v(configFetchReason);
                return this;
            }

            public Builder setReason(ConfigFetchReason configFetchReason) {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).m5730w(configFetchReason);
                return this;
            }

            private Builder() {
                super(AndroidConfigFetchProto.f7743d);
            }

            public Builder setReason(ConfigFetchReason.Builder builder) {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).m5730w((ConfigFetchReason) builder.build());
                return this;
            }
        }

        static {
            AndroidConfigFetchProto androidConfigFetchProto = new AndroidConfigFetchProto();
            f7743d = androidConfigFetchProto;
            GeneratedMessageLite.registerDefaultInstance(AndroidConfigFetchProto.class, androidConfigFetchProto);
        }

        private AndroidConfigFetchProto() {
        }

        public static AndroidConfigFetchProto getDefaultInstance() {
            return f7743d;
        }

        public static Builder newBuilder() {
            return (Builder) f7743d.createBuilder();
        }

        public static AndroidConfigFetchProto parseDelimitedFrom(InputStream inputStream) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseDelimitedFrom(f7743d, inputStream);
        }

        public static AndroidConfigFetchProto parseFrom(ByteBuffer byteBuffer) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(f7743d, byteBuffer);
        }

        public static Parser<AndroidConfigFetchProto> parser() {
            return f7743d.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public void m5728u() {
            this.f7746c = null;
            this.f7745b &= -2;
        }

        /* access modifiers changed from: private */
        /* renamed from: v */
        public void m5729v(ConfigFetchReason configFetchReason) {
            configFetchReason.getClass();
            ConfigFetchReason configFetchReason2 = this.f7746c;
            if (configFetchReason2 == null || configFetchReason2 == ConfigFetchReason.getDefaultInstance()) {
                this.f7746c = configFetchReason;
            } else {
                this.f7746c = (ConfigFetchReason) ((ConfigFetchReason.Builder) ConfigFetchReason.newBuilder(this.f7746c).mergeFrom(configFetchReason)).buildPartial();
            }
            this.f7745b |= 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: w */
        public void m5730w(ConfigFetchReason configFetchReason) {
            configFetchReason.getClass();
            this.f7746c = configFetchReason;
            this.f7745b |= 1;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C1698a.f7755a[methodToInvoke.ordinal()]) {
                case 1:
                    return new AndroidConfigFetchProto();
                case 2:
                    return new Builder((C1698a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f7743d, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t\u0000", new Object[]{"bitField0_", "reason_"});
                case 4:
                    return f7743d;
                case 5:
                    Parser<AndroidConfigFetchProto> parser = f7744e;
                    if (parser == null) {
                        synchronized (AndroidConfigFetchProto.class) {
                            parser = f7744e;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f7743d);
                                f7744e = parser;
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

        public ConfigFetchReason getReason() {
            ConfigFetchReason configFetchReason = this.f7746c;
            return configFetchReason == null ? ConfigFetchReason.getDefaultInstance() : configFetchReason;
        }

        public boolean hasReason() {
            return (this.f7745b & 1) != 0;
        }

        public static Builder newBuilder(AndroidConfigFetchProto androidConfigFetchProto) {
            return (Builder) f7743d.createBuilder(androidConfigFetchProto);
        }

        public static AndroidConfigFetchProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseDelimitedFrom(f7743d, inputStream, extensionRegistryLite);
        }

        public static AndroidConfigFetchProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(f7743d, byteBuffer, extensionRegistryLite);
        }

        public static AndroidConfigFetchProto parseFrom(ByteString byteString) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(f7743d, byteString);
        }

        public static AndroidConfigFetchProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(f7743d, byteString, extensionRegistryLite);
        }

        public static AndroidConfigFetchProto parseFrom(byte[] bArr) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(f7743d, bArr);
        }

        public static AndroidConfigFetchProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(f7743d, bArr, extensionRegistryLite);
        }

        public static AndroidConfigFetchProto parseFrom(InputStream inputStream) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(f7743d, inputStream);
        }

        public static AndroidConfigFetchProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(f7743d, inputStream, extensionRegistryLite);
        }

        public static AndroidConfigFetchProto parseFrom(CodedInputStream codedInputStream) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(f7743d, codedInputStream);
        }

        public static AndroidConfigFetchProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(f7743d, codedInputStream, extensionRegistryLite);
        }
    }

    public interface AndroidConfigFetchProtoOrBuilder extends MessageLiteOrBuilder {
        ConfigFetchReason getReason();

        boolean hasReason();
    }

    public static final class ConfigFetchReason extends GeneratedMessageLite<ConfigFetchReason, Builder> implements ConfigFetchReasonOrBuilder {
        public static final int TYPE_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public static final ConfigFetchReason f7747d;

        /* renamed from: e */
        private static volatile Parser<ConfigFetchReason> f7748e;

        /* renamed from: b */
        private int f7749b;

        /* renamed from: c */
        private int f7750c;

        public enum AndroidConfigFetchType implements Internal.EnumLite {
            UNKNOWN(0),
            SCHEDULED(1),
            BOOT_COMPLETED(2),
            PACKAGE_ADDED(3),
            PACKAGE_REMOVED(4),
            GMS_CORE_UPDATED(5),
            SECRET_CODE(6);
            
            public static final int BOOT_COMPLETED_VALUE = 2;
            public static final int GMS_CORE_UPDATED_VALUE = 5;
            public static final int PACKAGE_ADDED_VALUE = 3;
            public static final int PACKAGE_REMOVED_VALUE = 4;
            public static final int SCHEDULED_VALUE = 1;
            public static final int SECRET_CODE_VALUE = 6;
            public static final int UNKNOWN_VALUE = 0;

            /* renamed from: b */
            private static final Internal.EnumLiteMap<AndroidConfigFetchType> f7751b = null;

            /* renamed from: a */
            private final int f7753a;

            /* renamed from: com.google.android.gms.config.proto.Logs$ConfigFetchReason$AndroidConfigFetchType$a */
            class C1696a implements Internal.EnumLiteMap<AndroidConfigFetchType> {
                C1696a() {
                }

                /* renamed from: a */
                public AndroidConfigFetchType findValueByNumber(int i) {
                    return AndroidConfigFetchType.forNumber(i);
                }
            }

            /* renamed from: com.google.android.gms.config.proto.Logs$ConfigFetchReason$AndroidConfigFetchType$b */
            private static final class C1697b implements Internal.EnumVerifier {

                /* renamed from: a */
                static final Internal.EnumVerifier f7754a = null;

                static {
                    f7754a = new C1697b();
                }

                private C1697b() {
                }

                public boolean isInRange(int i) {
                    return AndroidConfigFetchType.forNumber(i) != null;
                }
            }

            static {
                f7751b = new C1696a();
            }

            private AndroidConfigFetchType(int i) {
                this.f7753a = i;
            }

            public static AndroidConfigFetchType forNumber(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return SCHEDULED;
                    case 2:
                        return BOOT_COMPLETED;
                    case 3:
                        return PACKAGE_ADDED;
                    case 4:
                        return PACKAGE_REMOVED;
                    case 5:
                        return GMS_CORE_UPDATED;
                    case 6:
                        return SECRET_CODE;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<AndroidConfigFetchType> internalGetValueMap() {
                return f7751b;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return C1697b.f7754a;
            }

            public final int getNumber() {
                return this.f7753a;
            }

            @Deprecated
            public static AndroidConfigFetchType valueOf(int i) {
                return forNumber(i);
            }
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ConfigFetchReason, Builder> implements ConfigFetchReasonOrBuilder {
            /* synthetic */ Builder(C1698a aVar) {
                this();
            }

            public Builder clearType() {
                copyOnWrite();
                ((ConfigFetchReason) this.instance).m5734t();
                return this;
            }

            public AndroidConfigFetchType getType() {
                return ((ConfigFetchReason) this.instance).getType();
            }

            public boolean hasType() {
                return ((ConfigFetchReason) this.instance).hasType();
            }

            public Builder setType(AndroidConfigFetchType androidConfigFetchType) {
                copyOnWrite();
                ((ConfigFetchReason) this.instance).m5735u(androidConfigFetchType);
                return this;
            }

            private Builder() {
                super(ConfigFetchReason.f7747d);
            }
        }

        static {
            ConfigFetchReason configFetchReason = new ConfigFetchReason();
            f7747d = configFetchReason;
            GeneratedMessageLite.registerDefaultInstance(ConfigFetchReason.class, configFetchReason);
        }

        private ConfigFetchReason() {
        }

        public static ConfigFetchReason getDefaultInstance() {
            return f7747d;
        }

        public static Builder newBuilder() {
            return (Builder) f7747d.createBuilder();
        }

        public static ConfigFetchReason parseDelimitedFrom(InputStream inputStream) {
            return (ConfigFetchReason) GeneratedMessageLite.parseDelimitedFrom(f7747d, inputStream);
        }

        public static ConfigFetchReason parseFrom(ByteBuffer byteBuffer) {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(f7747d, byteBuffer);
        }

        public static Parser<ConfigFetchReason> parser() {
            return f7747d.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: t */
        public void m5734t() {
            this.f7749b &= -2;
            this.f7750c = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public void m5735u(AndroidConfigFetchType androidConfigFetchType) {
            this.f7750c = androidConfigFetchType.getNumber();
            this.f7749b |= 1;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C1698a.f7755a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ConfigFetchReason();
                case 2:
                    return new Builder((C1698a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f7747d, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"bitField0_", "type_", AndroidConfigFetchType.internalGetVerifier()});
                case 4:
                    return f7747d;
                case 5:
                    Parser<ConfigFetchReason> parser = f7748e;
                    if (parser == null) {
                        synchronized (ConfigFetchReason.class) {
                            parser = f7748e;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f7747d);
                                f7748e = parser;
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

        public AndroidConfigFetchType getType() {
            AndroidConfigFetchType forNumber = AndroidConfigFetchType.forNumber(this.f7750c);
            return forNumber == null ? AndroidConfigFetchType.UNKNOWN : forNumber;
        }

        public boolean hasType() {
            return (this.f7749b & 1) != 0;
        }

        public static Builder newBuilder(ConfigFetchReason configFetchReason) {
            return (Builder) f7747d.createBuilder(configFetchReason);
        }

        public static ConfigFetchReason parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchReason) GeneratedMessageLite.parseDelimitedFrom(f7747d, inputStream, extensionRegistryLite);
        }

        public static ConfigFetchReason parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(f7747d, byteBuffer, extensionRegistryLite);
        }

        public static ConfigFetchReason parseFrom(ByteString byteString) {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(f7747d, byteString);
        }

        public static ConfigFetchReason parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(f7747d, byteString, extensionRegistryLite);
        }

        public static ConfigFetchReason parseFrom(byte[] bArr) {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(f7747d, bArr);
        }

        public static ConfigFetchReason parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(f7747d, bArr, extensionRegistryLite);
        }

        public static ConfigFetchReason parseFrom(InputStream inputStream) {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(f7747d, inputStream);
        }

        public static ConfigFetchReason parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(f7747d, inputStream, extensionRegistryLite);
        }

        public static ConfigFetchReason parseFrom(CodedInputStream codedInputStream) {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(f7747d, codedInputStream);
        }

        public static ConfigFetchReason parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(f7747d, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ConfigFetchReasonOrBuilder extends MessageLiteOrBuilder {
        ConfigFetchReason.AndroidConfigFetchType getType();

        boolean hasType();
    }

    /* renamed from: com.google.android.gms.config.proto.Logs$a */
    static /* synthetic */ class C1698a {

        /* renamed from: a */
        static final /* synthetic */ int[] f7755a;

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
                f7755a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7755a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7755a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7755a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7755a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7755a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7755a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.config.proto.Logs.C1698a.<clinit>():void");
        }
    }

    private Logs() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
