package com.google.android.gms.config.proto;

import com.google.android.gms.config.proto.Logs;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Config {

    public static final class AppConfigTable extends GeneratedMessageLite<AppConfigTable, Builder> implements AppConfigTableOrBuilder {
        public static final int APP_NAME_FIELD_NUMBER = 1;
        public static final int EXPERIMENT_PAYLOAD_FIELD_NUMBER = 3;
        public static final int NAMESPACE_CONFIG_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public static final AppConfigTable f7658f;

        /* renamed from: g */
        private static volatile Parser<AppConfigTable> f7659g;

        /* renamed from: b */
        private int f7660b;

        /* renamed from: c */
        private String f7661c = "";

        /* renamed from: d */
        private Internal.ProtobufList<AppNamespaceConfigTable> f7662d = GeneratedMessageLite.emptyProtobufList();

        /* renamed from: e */
        private Internal.ProtobufList<ByteString> f7663e = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<AppConfigTable, Builder> implements AppConfigTableOrBuilder {
            /* synthetic */ Builder(C1695a aVar) {
                this();
            }

            public Builder addAllExperimentPayload(Iterable<? extends ByteString> iterable) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5366E(iterable);
                return this;
            }

            public Builder addAllNamespaceConfig(Iterable<? extends AppNamespaceConfigTable> iterable) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5367F(iterable);
                return this;
            }

            public Builder addExperimentPayload(ByteString byteString) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5368G(byteString);
                return this;
            }

            public Builder addNamespaceConfig(AppNamespaceConfigTable appNamespaceConfigTable) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5370I(appNamespaceConfigTable);
                return this;
            }

            public Builder clearAppName() {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5371J();
                return this;
            }

            public Builder clearExperimentPayload() {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5372K();
                return this;
            }

            public Builder clearNamespaceConfig() {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5373L();
                return this;
            }

            public String getAppName() {
                return ((AppConfigTable) this.instance).getAppName();
            }

            public ByteString getAppNameBytes() {
                return ((AppConfigTable) this.instance).getAppNameBytes();
            }

            public ByteString getExperimentPayload(int i) {
                return ((AppConfigTable) this.instance).getExperimentPayload(i);
            }

            public int getExperimentPayloadCount() {
                return ((AppConfigTable) this.instance).getExperimentPayloadCount();
            }

            public List<ByteString> getExperimentPayloadList() {
                return Collections.unmodifiableList(((AppConfigTable) this.instance).getExperimentPayloadList());
            }

            public AppNamespaceConfigTable getNamespaceConfig(int i) {
                return ((AppConfigTable) this.instance).getNamespaceConfig(i);
            }

            public int getNamespaceConfigCount() {
                return ((AppConfigTable) this.instance).getNamespaceConfigCount();
            }

            public List<AppNamespaceConfigTable> getNamespaceConfigList() {
                return Collections.unmodifiableList(((AppConfigTable) this.instance).getNamespaceConfigList());
            }

            public boolean hasAppName() {
                return ((AppConfigTable) this.instance).hasAppName();
            }

            public Builder removeNamespaceConfig(int i) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5376O(i);
                return this;
            }

            public Builder setAppName(String str) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5377P(str);
                return this;
            }

            public Builder setAppNameBytes(ByteString byteString) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5378Q(byteString);
                return this;
            }

            public Builder setExperimentPayload(int i, ByteString byteString) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5379R(i, byteString);
                return this;
            }

            public Builder setNamespaceConfig(int i, AppNamespaceConfigTable appNamespaceConfigTable) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5380S(i, appNamespaceConfigTable);
                return this;
            }

            private Builder() {
                super(AppConfigTable.f7658f);
            }

            public Builder addNamespaceConfig(int i, AppNamespaceConfigTable appNamespaceConfigTable) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5369H(i, appNamespaceConfigTable);
                return this;
            }

            public Builder setNamespaceConfig(int i, AppNamespaceConfigTable.Builder builder) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5380S(i, (AppNamespaceConfigTable) builder.build());
                return this;
            }

            public Builder addNamespaceConfig(AppNamespaceConfigTable.Builder builder) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5370I((AppNamespaceConfigTable) builder.build());
                return this;
            }

            public Builder addNamespaceConfig(int i, AppNamespaceConfigTable.Builder builder) {
                copyOnWrite();
                ((AppConfigTable) this.instance).m5369H(i, (AppNamespaceConfigTable) builder.build());
                return this;
            }
        }

        static {
            AppConfigTable appConfigTable = new AppConfigTable();
            f7658f = appConfigTable;
            GeneratedMessageLite.registerDefaultInstance(AppConfigTable.class, appConfigTable);
        }

        private AppConfigTable() {
        }

        /* access modifiers changed from: private */
        /* renamed from: E */
        public void m5366E(Iterable<? extends ByteString> iterable) {
            m5374M();
            AbstractMessageLite.addAll(iterable, this.f7663e);
        }

        /* access modifiers changed from: private */
        /* renamed from: F */
        public void m5367F(Iterable<? extends AppNamespaceConfigTable> iterable) {
            m5375N();
            AbstractMessageLite.addAll(iterable, this.f7662d);
        }

        /* access modifiers changed from: private */
        /* renamed from: G */
        public void m5368G(ByteString byteString) {
            byteString.getClass();
            m5374M();
            this.f7663e.add(byteString);
        }

        /* access modifiers changed from: private */
        /* renamed from: H */
        public void m5369H(int i, AppNamespaceConfigTable appNamespaceConfigTable) {
            appNamespaceConfigTable.getClass();
            m5375N();
            this.f7662d.add(i, appNamespaceConfigTable);
        }

        /* access modifiers changed from: private */
        /* renamed from: I */
        public void m5370I(AppNamespaceConfigTable appNamespaceConfigTable) {
            appNamespaceConfigTable.getClass();
            m5375N();
            this.f7662d.add(appNamespaceConfigTable);
        }

        /* access modifiers changed from: private */
        /* renamed from: J */
        public void m5371J() {
            this.f7660b &= -2;
            this.f7661c = getDefaultInstance().getAppName();
        }

        /* access modifiers changed from: private */
        /* renamed from: K */
        public void m5372K() {
            this.f7663e = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: L */
        public void m5373L() {
            this.f7662d = GeneratedMessageLite.emptyProtobufList();
        }

        /* renamed from: M */
        private void m5374M() {
            if (!this.f7663e.isModifiable()) {
                this.f7663e = GeneratedMessageLite.mutableCopy(this.f7663e);
            }
        }

        /* renamed from: N */
        private void m5375N() {
            if (!this.f7662d.isModifiable()) {
                this.f7662d = GeneratedMessageLite.mutableCopy(this.f7662d);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: O */
        public void m5376O(int i) {
            m5375N();
            this.f7662d.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: P */
        public void m5377P(String str) {
            str.getClass();
            this.f7660b |= 1;
            this.f7661c = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: Q */
        public void m5378Q(ByteString byteString) {
            this.f7661c = byteString.toStringUtf8();
            this.f7660b |= 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: R */
        public void m5379R(int i, ByteString byteString) {
            byteString.getClass();
            m5374M();
            this.f7663e.set(i, byteString);
        }

        /* access modifiers changed from: private */
        /* renamed from: S */
        public void m5380S(int i, AppNamespaceConfigTable appNamespaceConfigTable) {
            appNamespaceConfigTable.getClass();
            m5375N();
            this.f7662d.set(i, appNamespaceConfigTable);
        }

        public static AppConfigTable getDefaultInstance() {
            return f7658f;
        }

        public static Builder newBuilder() {
            return (Builder) f7658f.createBuilder();
        }

        public static AppConfigTable parseDelimitedFrom(InputStream inputStream) {
            return (AppConfigTable) GeneratedMessageLite.parseDelimitedFrom(f7658f, inputStream);
        }

        public static AppConfigTable parseFrom(ByteBuffer byteBuffer) {
            return (AppConfigTable) GeneratedMessageLite.parseFrom(f7658f, byteBuffer);
        }

        public static Parser<AppConfigTable> parser() {
            return f7658f.getParserForType();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C1695a.f7742a[methodToInvoke.ordinal()]) {
                case 1:
                    return new AppConfigTable();
                case 2:
                    return new Builder((C1695a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f7658f, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\b\u0000\u0002\u001b\u0003\u001c", new Object[]{"bitField0_", "appName_", "namespaceConfig_", AppNamespaceConfigTable.class, "experimentPayload_"});
                case 4:
                    return f7658f;
                case 5:
                    Parser<AppConfigTable> parser = f7659g;
                    if (parser == null) {
                        synchronized (AppConfigTable.class) {
                            parser = f7659g;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f7658f);
                                f7659g = parser;
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

        public String getAppName() {
            return this.f7661c;
        }

        public ByteString getAppNameBytes() {
            return ByteString.copyFromUtf8(this.f7661c);
        }

        public ByteString getExperimentPayload(int i) {
            return this.f7663e.get(i);
        }

        public int getExperimentPayloadCount() {
            return this.f7663e.size();
        }

        public List<ByteString> getExperimentPayloadList() {
            return this.f7663e;
        }

        public AppNamespaceConfigTable getNamespaceConfig(int i) {
            return this.f7662d.get(i);
        }

        public int getNamespaceConfigCount() {
            return this.f7662d.size();
        }

        public List<AppNamespaceConfigTable> getNamespaceConfigList() {
            return this.f7662d;
        }

        public AppNamespaceConfigTableOrBuilder getNamespaceConfigOrBuilder(int i) {
            return this.f7662d.get(i);
        }

        public List<? extends AppNamespaceConfigTableOrBuilder> getNamespaceConfigOrBuilderList() {
            return this.f7662d;
        }

        public boolean hasAppName() {
            return (this.f7660b & 1) != 0;
        }

        public static Builder newBuilder(AppConfigTable appConfigTable) {
            return (Builder) f7658f.createBuilder(appConfigTable);
        }

        public static AppConfigTable parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppConfigTable) GeneratedMessageLite.parseDelimitedFrom(f7658f, inputStream, extensionRegistryLite);
        }

        public static AppConfigTable parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (AppConfigTable) GeneratedMessageLite.parseFrom(f7658f, byteBuffer, extensionRegistryLite);
        }

        public static AppConfigTable parseFrom(ByteString byteString) {
            return (AppConfigTable) GeneratedMessageLite.parseFrom(f7658f, byteString);
        }

        public static AppConfigTable parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (AppConfigTable) GeneratedMessageLite.parseFrom(f7658f, byteString, extensionRegistryLite);
        }

        public static AppConfigTable parseFrom(byte[] bArr) {
            return (AppConfigTable) GeneratedMessageLite.parseFrom(f7658f, bArr);
        }

        public static AppConfigTable parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (AppConfigTable) GeneratedMessageLite.parseFrom(f7658f, bArr, extensionRegistryLite);
        }

        public static AppConfigTable parseFrom(InputStream inputStream) {
            return (AppConfigTable) GeneratedMessageLite.parseFrom(f7658f, inputStream);
        }

        public static AppConfigTable parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppConfigTable) GeneratedMessageLite.parseFrom(f7658f, inputStream, extensionRegistryLite);
        }

        public static AppConfigTable parseFrom(CodedInputStream codedInputStream) {
            return (AppConfigTable) GeneratedMessageLite.parseFrom(f7658f, codedInputStream);
        }

        public static AppConfigTable parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppConfigTable) GeneratedMessageLite.parseFrom(f7658f, codedInputStream, extensionRegistryLite);
        }
    }

    public interface AppConfigTableOrBuilder extends MessageLiteOrBuilder {
        String getAppName();

        ByteString getAppNameBytes();

        ByteString getExperimentPayload(int i);

        int getExperimentPayloadCount();

        List<ByteString> getExperimentPayloadList();

        AppNamespaceConfigTable getNamespaceConfig(int i);

        int getNamespaceConfigCount();

        List<AppNamespaceConfigTable> getNamespaceConfigList();

        boolean hasAppName();
    }

    public static final class AppNamespaceConfigTable extends GeneratedMessageLite<AppNamespaceConfigTable, Builder> implements AppNamespaceConfigTableOrBuilder {
        public static final int DIGEST_FIELD_NUMBER = 2;
        public static final int ENTRY_FIELD_NUMBER = 3;
        public static final int NAMESPACE_FIELD_NUMBER = 1;
        public static final int STATUS_FIELD_NUMBER = 4;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public static final AppNamespaceConfigTable f7664g;

        /* renamed from: h */
        private static volatile Parser<AppNamespaceConfigTable> f7665h;

        /* renamed from: b */
        private int f7666b;

        /* renamed from: c */
        private String f7667c = "";

        /* renamed from: d */
        private String f7668d = "";

        /* renamed from: e */
        private Internal.ProtobufList<KeyValue> f7669e = GeneratedMessageLite.emptyProtobufList();

        /* renamed from: f */
        private int f7670f;

        public static final class Builder extends GeneratedMessageLite.Builder<AppNamespaceConfigTable, Builder> implements AppNamespaceConfigTableOrBuilder {
            /* synthetic */ Builder(C1695a aVar) {
                this();
            }

            public Builder addAllEntry(Iterable<? extends KeyValue> iterable) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5396F(iterable);
                return this;
            }

            public Builder addEntry(KeyValue keyValue) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5398H(keyValue);
                return this;
            }

            public Builder clearDigest() {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5399I();
                return this;
            }

            public Builder clearEntry() {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5400J();
                return this;
            }

            public Builder clearNamespace() {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5401K();
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5402L();
                return this;
            }

            public String getDigest() {
                return ((AppNamespaceConfigTable) this.instance).getDigest();
            }

            public ByteString getDigestBytes() {
                return ((AppNamespaceConfigTable) this.instance).getDigestBytes();
            }

            public KeyValue getEntry(int i) {
                return ((AppNamespaceConfigTable) this.instance).getEntry(i);
            }

            public int getEntryCount() {
                return ((AppNamespaceConfigTable) this.instance).getEntryCount();
            }

            public List<KeyValue> getEntryList() {
                return Collections.unmodifiableList(((AppNamespaceConfigTable) this.instance).getEntryList());
            }

            public String getNamespace() {
                return ((AppNamespaceConfigTable) this.instance).getNamespace();
            }

            public ByteString getNamespaceBytes() {
                return ((AppNamespaceConfigTable) this.instance).getNamespaceBytes();
            }

            public NamespaceStatus getStatus() {
                return ((AppNamespaceConfigTable) this.instance).getStatus();
            }

            public boolean hasDigest() {
                return ((AppNamespaceConfigTable) this.instance).hasDigest();
            }

            public boolean hasNamespace() {
                return ((AppNamespaceConfigTable) this.instance).hasNamespace();
            }

            public boolean hasStatus() {
                return ((AppNamespaceConfigTable) this.instance).hasStatus();
            }

            public Builder removeEntry(int i) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5404N(i);
                return this;
            }

            public Builder setDigest(String str) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5405O(str);
                return this;
            }

            public Builder setDigestBytes(ByteString byteString) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5406P(byteString);
                return this;
            }

            public Builder setEntry(int i, KeyValue keyValue) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5407Q(i, keyValue);
                return this;
            }

            public Builder setNamespace(String str) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5408R(str);
                return this;
            }

            public Builder setNamespaceBytes(ByteString byteString) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5409S(byteString);
                return this;
            }

            public Builder setStatus(NamespaceStatus namespaceStatus) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5410T(namespaceStatus);
                return this;
            }

            private Builder() {
                super(AppNamespaceConfigTable.f7664g);
            }

            public Builder addEntry(int i, KeyValue keyValue) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5397G(i, keyValue);
                return this;
            }

            public Builder setEntry(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5407Q(i, (KeyValue) builder.build());
                return this;
            }

            public Builder addEntry(KeyValue.Builder builder) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5398H((KeyValue) builder.build());
                return this;
            }

            public Builder addEntry(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((AppNamespaceConfigTable) this.instance).m5397G(i, (KeyValue) builder.build());
                return this;
            }
        }

        public enum NamespaceStatus implements Internal.EnumLite {
            UPDATE(0),
            NO_TEMPLATE(1),
            NO_CHANGE(2),
            EMPTY_CONFIG(3),
            NOT_AUTHORIZED(4);
            
            public static final int EMPTY_CONFIG_VALUE = 3;
            public static final int NOT_AUTHORIZED_VALUE = 4;
            public static final int NO_CHANGE_VALUE = 2;
            public static final int NO_TEMPLATE_VALUE = 1;
            public static final int UPDATE_VALUE = 0;

            /* renamed from: b */
            private static final Internal.EnumLiteMap<NamespaceStatus> f7671b = null;

            /* renamed from: a */
            private final int f7673a;

            /* renamed from: com.google.android.gms.config.proto.Config$AppNamespaceConfigTable$NamespaceStatus$a */
            class C1691a implements Internal.EnumLiteMap<NamespaceStatus> {
                C1691a() {
                }

                /* renamed from: a */
                public NamespaceStatus findValueByNumber(int i) {
                    return NamespaceStatus.forNumber(i);
                }
            }

            /* renamed from: com.google.android.gms.config.proto.Config$AppNamespaceConfigTable$NamespaceStatus$b */
            private static final class C1692b implements Internal.EnumVerifier {

                /* renamed from: a */
                static final Internal.EnumVerifier f7674a = null;

                static {
                    f7674a = new C1692b();
                }

                private C1692b() {
                }

                public boolean isInRange(int i) {
                    return NamespaceStatus.forNumber(i) != null;
                }
            }

            static {
                f7671b = new C1691a();
            }

            private NamespaceStatus(int i) {
                this.f7673a = i;
            }

            public static NamespaceStatus forNumber(int i) {
                if (i == 0) {
                    return UPDATE;
                }
                if (i == 1) {
                    return NO_TEMPLATE;
                }
                if (i == 2) {
                    return NO_CHANGE;
                }
                if (i == 3) {
                    return EMPTY_CONFIG;
                }
                if (i != 4) {
                    return null;
                }
                return NOT_AUTHORIZED;
            }

            public static Internal.EnumLiteMap<NamespaceStatus> internalGetValueMap() {
                return f7671b;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return C1692b.f7674a;
            }

            public final int getNumber() {
                return this.f7673a;
            }

            @Deprecated
            public static NamespaceStatus valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            AppNamespaceConfigTable appNamespaceConfigTable = new AppNamespaceConfigTable();
            f7664g = appNamespaceConfigTable;
            GeneratedMessageLite.registerDefaultInstance(AppNamespaceConfigTable.class, appNamespaceConfigTable);
        }

        private AppNamespaceConfigTable() {
        }

        /* access modifiers changed from: private */
        /* renamed from: F */
        public void m5396F(Iterable<? extends KeyValue> iterable) {
            m5403M();
            AbstractMessageLite.addAll(iterable, this.f7669e);
        }

        /* access modifiers changed from: private */
        /* renamed from: G */
        public void m5397G(int i, KeyValue keyValue) {
            keyValue.getClass();
            m5403M();
            this.f7669e.add(i, keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: H */
        public void m5398H(KeyValue keyValue) {
            keyValue.getClass();
            m5403M();
            this.f7669e.add(keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: I */
        public void m5399I() {
            this.f7666b &= -3;
            this.f7668d = getDefaultInstance().getDigest();
        }

        /* access modifiers changed from: private */
        /* renamed from: J */
        public void m5400J() {
            this.f7669e = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: K */
        public void m5401K() {
            this.f7666b &= -2;
            this.f7667c = getDefaultInstance().getNamespace();
        }

        /* access modifiers changed from: private */
        /* renamed from: L */
        public void m5402L() {
            this.f7666b &= -5;
            this.f7670f = 0;
        }

        /* renamed from: M */
        private void m5403M() {
            if (!this.f7669e.isModifiable()) {
                this.f7669e = GeneratedMessageLite.mutableCopy(this.f7669e);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: N */
        public void m5404N(int i) {
            m5403M();
            this.f7669e.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: O */
        public void m5405O(String str) {
            str.getClass();
            this.f7666b |= 2;
            this.f7668d = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: P */
        public void m5406P(ByteString byteString) {
            this.f7668d = byteString.toStringUtf8();
            this.f7666b |= 2;
        }

        /* access modifiers changed from: private */
        /* renamed from: Q */
        public void m5407Q(int i, KeyValue keyValue) {
            keyValue.getClass();
            m5403M();
            this.f7669e.set(i, keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: R */
        public void m5408R(String str) {
            str.getClass();
            this.f7666b |= 1;
            this.f7667c = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: S */
        public void m5409S(ByteString byteString) {
            this.f7667c = byteString.toStringUtf8();
            this.f7666b |= 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: T */
        public void m5410T(NamespaceStatus namespaceStatus) {
            this.f7670f = namespaceStatus.getNumber();
            this.f7666b |= 4;
        }

        public static AppNamespaceConfigTable getDefaultInstance() {
            return f7664g;
        }

        public static Builder newBuilder() {
            return (Builder) f7664g.createBuilder();
        }

        public static AppNamespaceConfigTable parseDelimitedFrom(InputStream inputStream) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseDelimitedFrom(f7664g, inputStream);
        }

        public static AppNamespaceConfigTable parseFrom(ByteBuffer byteBuffer) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseFrom(f7664g, byteBuffer);
        }

        public static Parser<AppNamespaceConfigTable> parser() {
            return f7664g.getParserForType();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C1695a.f7742a[methodToInvoke.ordinal()]) {
                case 1:
                    return new AppNamespaceConfigTable();
                case 2:
                    return new Builder((C1695a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f7664g, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u001b\u0004\f\u0002", new Object[]{"bitField0_", "namespace_", "digest_", "entry_", KeyValue.class, "status_", NamespaceStatus.internalGetVerifier()});
                case 4:
                    return f7664g;
                case 5:
                    Parser<AppNamespaceConfigTable> parser = f7665h;
                    if (parser == null) {
                        synchronized (AppNamespaceConfigTable.class) {
                            parser = f7665h;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f7664g);
                                f7665h = parser;
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

        public String getDigest() {
            return this.f7668d;
        }

        public ByteString getDigestBytes() {
            return ByteString.copyFromUtf8(this.f7668d);
        }

        public KeyValue getEntry(int i) {
            return this.f7669e.get(i);
        }

        public int getEntryCount() {
            return this.f7669e.size();
        }

        public List<KeyValue> getEntryList() {
            return this.f7669e;
        }

        public KeyValueOrBuilder getEntryOrBuilder(int i) {
            return this.f7669e.get(i);
        }

        public List<? extends KeyValueOrBuilder> getEntryOrBuilderList() {
            return this.f7669e;
        }

        public String getNamespace() {
            return this.f7667c;
        }

        public ByteString getNamespaceBytes() {
            return ByteString.copyFromUtf8(this.f7667c);
        }

        public NamespaceStatus getStatus() {
            NamespaceStatus forNumber = NamespaceStatus.forNumber(this.f7670f);
            return forNumber == null ? NamespaceStatus.UPDATE : forNumber;
        }

        public boolean hasDigest() {
            return (this.f7666b & 2) != 0;
        }

        public boolean hasNamespace() {
            return (this.f7666b & 1) != 0;
        }

        public boolean hasStatus() {
            return (this.f7666b & 4) != 0;
        }

        public static Builder newBuilder(AppNamespaceConfigTable appNamespaceConfigTable) {
            return (Builder) f7664g.createBuilder(appNamespaceConfigTable);
        }

        public static AppNamespaceConfigTable parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseDelimitedFrom(f7664g, inputStream, extensionRegistryLite);
        }

        public static AppNamespaceConfigTable parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseFrom(f7664g, byteBuffer, extensionRegistryLite);
        }

        public static AppNamespaceConfigTable parseFrom(ByteString byteString) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseFrom(f7664g, byteString);
        }

        public static AppNamespaceConfigTable parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseFrom(f7664g, byteString, extensionRegistryLite);
        }

        public static AppNamespaceConfigTable parseFrom(byte[] bArr) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseFrom(f7664g, bArr);
        }

        public static AppNamespaceConfigTable parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseFrom(f7664g, bArr, extensionRegistryLite);
        }

        public static AppNamespaceConfigTable parseFrom(InputStream inputStream) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseFrom(f7664g, inputStream);
        }

        public static AppNamespaceConfigTable parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseFrom(f7664g, inputStream, extensionRegistryLite);
        }

        public static AppNamespaceConfigTable parseFrom(CodedInputStream codedInputStream) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseFrom(f7664g, codedInputStream);
        }

        public static AppNamespaceConfigTable parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppNamespaceConfigTable) GeneratedMessageLite.parseFrom(f7664g, codedInputStream, extensionRegistryLite);
        }
    }

    public interface AppNamespaceConfigTableOrBuilder extends MessageLiteOrBuilder {
        String getDigest();

        ByteString getDigestBytes();

        KeyValue getEntry(int i);

        int getEntryCount();

        List<KeyValue> getEntryList();

        String getNamespace();

        ByteString getNamespaceBytes();

        AppNamespaceConfigTable.NamespaceStatus getStatus();

        boolean hasDigest();

        boolean hasNamespace();

        boolean hasStatus();
    }

    public static final class ConfigFetchRequest extends GeneratedMessageLite<ConfigFetchRequest, Builder> implements ConfigFetchRequestOrBuilder {
        public static final int ANDROID_ID_FIELD_NUMBER = 1;
        public static final int API_LEVEL_FIELD_NUMBER = 8;
        public static final int CLIENT_VERSION_FIELD_NUMBER = 6;
        public static final int CONFIG_FIELD_NUMBER = 5;
        public static final int DEVICE_COUNTRY_FIELD_NUMBER = 9;
        public static final int DEVICE_DATA_VERSION_INFO_FIELD_NUMBER = 3;
        public static final int DEVICE_LOCALE_FIELD_NUMBER = 10;
        public static final int DEVICE_SUBTYPE_FIELD_NUMBER = 12;
        public static final int DEVICE_TIMEZONE_ID_FIELD_NUMBER = 14;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 11;
        public static final int GMS_CORE_VERSION_FIELD_NUMBER = 7;
        public static final int OS_VERSION_FIELD_NUMBER = 13;
        public static final int PACKAGE_DATA_FIELD_NUMBER = 2;
        public static final int SECURITY_TOKEN_FIELD_NUMBER = 4;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public static final ConfigFetchRequest f7675q;

        /* renamed from: r */
        private static volatile Parser<ConfigFetchRequest> f7676r;

        /* renamed from: b */
        private int f7677b;

        /* renamed from: c */
        private Logs.AndroidConfigFetchProto f7678c;

        /* renamed from: d */
        private long f7679d;

        /* renamed from: e */
        private Internal.ProtobufList<PackageData> f7680e = GeneratedMessageLite.emptyProtobufList();

        /* renamed from: f */
        private String f7681f = "";

        /* renamed from: g */
        private long f7682g;

        /* renamed from: h */
        private int f7683h;

        /* renamed from: i */
        private int f7684i;

        /* renamed from: j */
        private int f7685j;

        /* renamed from: k */
        private String f7686k = "";

        /* renamed from: l */
        private String f7687l = "";

        /* renamed from: m */
        private int f7688m;

        /* renamed from: n */
        private int f7689n;

        /* renamed from: o */
        private String f7690o = "";

        /* renamed from: p */
        private String f7691p = "";

        public static final class Builder extends GeneratedMessageLite.Builder<ConfigFetchRequest, Builder> implements ConfigFetchRequestOrBuilder {
            /* synthetic */ Builder(C1695a aVar) {
                this();
            }

            public Builder addAllPackageData(Iterable<? extends PackageData> iterable) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5467d0(iterable);
                return this;
            }

            public Builder addPackageData(PackageData packageData) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5469f0(packageData);
                return this;
            }

            public Builder clearAndroidId() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5470g0();
                return this;
            }

            public Builder clearApiLevel() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5471h0();
                return this;
            }

            public Builder clearClientVersion() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5472i0();
                return this;
            }

            public Builder clearConfig() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5473j0();
                return this;
            }

            public Builder clearDeviceCountry() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5474k0();
                return this;
            }

            public Builder clearDeviceDataVersionInfo() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5475l0();
                return this;
            }

            public Builder clearDeviceLocale() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5476m0();
                return this;
            }

            public Builder clearDeviceSubtype() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5477n0();
                return this;
            }

            public Builder clearDeviceTimezoneId() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5478o0();
                return this;
            }

            public Builder clearDeviceType() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5479p0();
                return this;
            }

            public Builder clearGmsCoreVersion() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5481q0();
                return this;
            }

            public Builder clearOsVersion() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5483r0();
                return this;
            }

            public Builder clearPackageData() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5485s0();
                return this;
            }

            public Builder clearSecurityToken() {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5487t0();
                return this;
            }

            public long getAndroidId() {
                return ((ConfigFetchRequest) this.instance).getAndroidId();
            }

            public int getApiLevel() {
                return ((ConfigFetchRequest) this.instance).getApiLevel();
            }

            public int getClientVersion() {
                return ((ConfigFetchRequest) this.instance).getClientVersion();
            }

            public Logs.AndroidConfigFetchProto getConfig() {
                return ((ConfigFetchRequest) this.instance).getConfig();
            }

            public String getDeviceCountry() {
                return ((ConfigFetchRequest) this.instance).getDeviceCountry();
            }

            public ByteString getDeviceCountryBytes() {
                return ((ConfigFetchRequest) this.instance).getDeviceCountryBytes();
            }

            public String getDeviceDataVersionInfo() {
                return ((ConfigFetchRequest) this.instance).getDeviceDataVersionInfo();
            }

            public ByteString getDeviceDataVersionInfoBytes() {
                return ((ConfigFetchRequest) this.instance).getDeviceDataVersionInfoBytes();
            }

            public String getDeviceLocale() {
                return ((ConfigFetchRequest) this.instance).getDeviceLocale();
            }

            public ByteString getDeviceLocaleBytes() {
                return ((ConfigFetchRequest) this.instance).getDeviceLocaleBytes();
            }

            public int getDeviceSubtype() {
                return ((ConfigFetchRequest) this.instance).getDeviceSubtype();
            }

            public String getDeviceTimezoneId() {
                return ((ConfigFetchRequest) this.instance).getDeviceTimezoneId();
            }

            public ByteString getDeviceTimezoneIdBytes() {
                return ((ConfigFetchRequest) this.instance).getDeviceTimezoneIdBytes();
            }

            public int getDeviceType() {
                return ((ConfigFetchRequest) this.instance).getDeviceType();
            }

            public int getGmsCoreVersion() {
                return ((ConfigFetchRequest) this.instance).getGmsCoreVersion();
            }

            public String getOsVersion() {
                return ((ConfigFetchRequest) this.instance).getOsVersion();
            }

            public ByteString getOsVersionBytes() {
                return ((ConfigFetchRequest) this.instance).getOsVersionBytes();
            }

            public PackageData getPackageData(int i) {
                return ((ConfigFetchRequest) this.instance).getPackageData(i);
            }

            public int getPackageDataCount() {
                return ((ConfigFetchRequest) this.instance).getPackageDataCount();
            }

            public List<PackageData> getPackageDataList() {
                return Collections.unmodifiableList(((ConfigFetchRequest) this.instance).getPackageDataList());
            }

            public long getSecurityToken() {
                return ((ConfigFetchRequest) this.instance).getSecurityToken();
            }

            public boolean hasAndroidId() {
                return ((ConfigFetchRequest) this.instance).hasAndroidId();
            }

            public boolean hasApiLevel() {
                return ((ConfigFetchRequest) this.instance).hasApiLevel();
            }

            public boolean hasClientVersion() {
                return ((ConfigFetchRequest) this.instance).hasClientVersion();
            }

            public boolean hasConfig() {
                return ((ConfigFetchRequest) this.instance).hasConfig();
            }

            public boolean hasDeviceCountry() {
                return ((ConfigFetchRequest) this.instance).hasDeviceCountry();
            }

            public boolean hasDeviceDataVersionInfo() {
                return ((ConfigFetchRequest) this.instance).hasDeviceDataVersionInfo();
            }

            public boolean hasDeviceLocale() {
                return ((ConfigFetchRequest) this.instance).hasDeviceLocale();
            }

            public boolean hasDeviceSubtype() {
                return ((ConfigFetchRequest) this.instance).hasDeviceSubtype();
            }

            public boolean hasDeviceTimezoneId() {
                return ((ConfigFetchRequest) this.instance).hasDeviceTimezoneId();
            }

            public boolean hasDeviceType() {
                return ((ConfigFetchRequest) this.instance).hasDeviceType();
            }

            public boolean hasGmsCoreVersion() {
                return ((ConfigFetchRequest) this.instance).hasGmsCoreVersion();
            }

            public boolean hasOsVersion() {
                return ((ConfigFetchRequest) this.instance).hasOsVersion();
            }

            public boolean hasSecurityToken() {
                return ((ConfigFetchRequest) this.instance).hasSecurityToken();
            }

            public Builder mergeConfig(Logs.AndroidConfigFetchProto androidConfigFetchProto) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5491v0(androidConfigFetchProto);
                return this;
            }

            public Builder removePackageData(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5493w0(i);
                return this;
            }

            public Builder setAndroidId(long j) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5495x0(j);
                return this;
            }

            public Builder setApiLevel(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5497y0(i);
                return this;
            }

            public Builder setClientVersion(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5499z0(i);
                return this;
            }

            public Builder setConfig(Logs.AndroidConfigFetchProto androidConfigFetchProto) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5423A0(androidConfigFetchProto);
                return this;
            }

            public Builder setDeviceCountry(String str) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5425B0(str);
                return this;
            }

            public Builder setDeviceCountryBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5427C0(byteString);
                return this;
            }

            public Builder setDeviceDataVersionInfo(String str) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5429D0(str);
                return this;
            }

            public Builder setDeviceDataVersionInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5431E0(byteString);
                return this;
            }

            public Builder setDeviceLocale(String str) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5433F0(str);
                return this;
            }

            public Builder setDeviceLocaleBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5435G0(byteString);
                return this;
            }

            public Builder setDeviceSubtype(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5437H0(i);
                return this;
            }

            public Builder setDeviceTimezoneId(String str) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5439I0(str);
                return this;
            }

            public Builder setDeviceTimezoneIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5441J0(byteString);
                return this;
            }

            public Builder setDeviceType(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5443K0(i);
                return this;
            }

            public Builder setGmsCoreVersion(int i) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5445L0(i);
                return this;
            }

            public Builder setOsVersion(String str) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5447M0(str);
                return this;
            }

            public Builder setOsVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5449N0(byteString);
                return this;
            }

            public Builder setPackageData(int i, PackageData packageData) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5451O0(i, packageData);
                return this;
            }

            public Builder setSecurityToken(long j) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5453P0(j);
                return this;
            }

            private Builder() {
                super(ConfigFetchRequest.f7675q);
            }

            public Builder addPackageData(int i, PackageData packageData) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5468e0(i, packageData);
                return this;
            }

            public Builder setConfig(Logs.AndroidConfigFetchProto.Builder builder) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5423A0((Logs.AndroidConfigFetchProto) builder.build());
                return this;
            }

            public Builder setPackageData(int i, PackageData.Builder builder) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5451O0(i, (PackageData) builder.build());
                return this;
            }

            public Builder addPackageData(PackageData.Builder builder) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5469f0((PackageData) builder.build());
                return this;
            }

            public Builder addPackageData(int i, PackageData.Builder builder) {
                copyOnWrite();
                ((ConfigFetchRequest) this.instance).m5468e0(i, (PackageData) builder.build());
                return this;
            }
        }

        static {
            ConfigFetchRequest configFetchRequest = new ConfigFetchRequest();
            f7675q = configFetchRequest;
            GeneratedMessageLite.registerDefaultInstance(ConfigFetchRequest.class, configFetchRequest);
        }

        private ConfigFetchRequest() {
        }

        /* access modifiers changed from: private */
        /* renamed from: A0 */
        public void m5423A0(Logs.AndroidConfigFetchProto androidConfigFetchProto) {
            androidConfigFetchProto.getClass();
            this.f7678c = androidConfigFetchProto;
            this.f7677b |= 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: B0 */
        public void m5425B0(String str) {
            str.getClass();
            this.f7677b |= 128;
            this.f7686k = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: C0 */
        public void m5427C0(ByteString byteString) {
            this.f7686k = byteString.toStringUtf8();
            this.f7677b |= 128;
        }

        /* access modifiers changed from: private */
        /* renamed from: D0 */
        public void m5429D0(String str) {
            str.getClass();
            this.f7677b |= 4;
            this.f7681f = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: E0 */
        public void m5431E0(ByteString byteString) {
            this.f7681f = byteString.toStringUtf8();
            this.f7677b |= 4;
        }

        /* access modifiers changed from: private */
        /* renamed from: F0 */
        public void m5433F0(String str) {
            str.getClass();
            this.f7677b |= 256;
            this.f7687l = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: G0 */
        public void m5435G0(ByteString byteString) {
            this.f7687l = byteString.toStringUtf8();
            this.f7677b |= 256;
        }

        /* access modifiers changed from: private */
        /* renamed from: H0 */
        public void m5437H0(int i) {
            this.f7677b |= 1024;
            this.f7689n = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: I0 */
        public void m5439I0(String str) {
            str.getClass();
            this.f7677b |= 4096;
            this.f7691p = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: J0 */
        public void m5441J0(ByteString byteString) {
            this.f7691p = byteString.toStringUtf8();
            this.f7677b |= 4096;
        }

        /* access modifiers changed from: private */
        /* renamed from: K0 */
        public void m5443K0(int i) {
            this.f7677b |= 512;
            this.f7688m = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: L0 */
        public void m5445L0(int i) {
            this.f7677b |= 32;
            this.f7684i = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: M0 */
        public void m5447M0(String str) {
            str.getClass();
            this.f7677b |= 2048;
            this.f7690o = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: N0 */
        public void m5449N0(ByteString byteString) {
            this.f7690o = byteString.toStringUtf8();
            this.f7677b |= 2048;
        }

        /* access modifiers changed from: private */
        /* renamed from: O0 */
        public void m5451O0(int i, PackageData packageData) {
            packageData.getClass();
            m5489u0();
            this.f7680e.set(i, packageData);
        }

        /* access modifiers changed from: private */
        /* renamed from: P0 */
        public void m5453P0(long j) {
            this.f7677b |= 8;
            this.f7682g = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: d0 */
        public void m5467d0(Iterable<? extends PackageData> iterable) {
            m5489u0();
            AbstractMessageLite.addAll(iterable, this.f7680e);
        }

        /* access modifiers changed from: private */
        /* renamed from: e0 */
        public void m5468e0(int i, PackageData packageData) {
            packageData.getClass();
            m5489u0();
            this.f7680e.add(i, packageData);
        }

        /* access modifiers changed from: private */
        /* renamed from: f0 */
        public void m5469f0(PackageData packageData) {
            packageData.getClass();
            m5489u0();
            this.f7680e.add(packageData);
        }

        /* access modifiers changed from: private */
        /* renamed from: g0 */
        public void m5470g0() {
            this.f7677b &= -3;
            this.f7679d = 0;
        }

        public static ConfigFetchRequest getDefaultInstance() {
            return f7675q;
        }

        /* access modifiers changed from: private */
        /* renamed from: h0 */
        public void m5471h0() {
            this.f7677b &= -65;
            this.f7685j = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: i0 */
        public void m5472i0() {
            this.f7677b &= -17;
            this.f7683h = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: j0 */
        public void m5473j0() {
            this.f7678c = null;
            this.f7677b &= -2;
        }

        /* access modifiers changed from: private */
        /* renamed from: k0 */
        public void m5474k0() {
            this.f7677b &= -129;
            this.f7686k = getDefaultInstance().getDeviceCountry();
        }

        /* access modifiers changed from: private */
        /* renamed from: l0 */
        public void m5475l0() {
            this.f7677b &= -5;
            this.f7681f = getDefaultInstance().getDeviceDataVersionInfo();
        }

        /* access modifiers changed from: private */
        /* renamed from: m0 */
        public void m5476m0() {
            this.f7677b &= -257;
            this.f7687l = getDefaultInstance().getDeviceLocale();
        }

        /* access modifiers changed from: private */
        /* renamed from: n0 */
        public void m5477n0() {
            this.f7677b &= -1025;
            this.f7689n = 0;
        }

        public static Builder newBuilder() {
            return (Builder) f7675q.createBuilder();
        }

        /* access modifiers changed from: private */
        /* renamed from: o0 */
        public void m5478o0() {
            this.f7677b &= -4097;
            this.f7691p = getDefaultInstance().getDeviceTimezoneId();
        }

        /* access modifiers changed from: private */
        /* renamed from: p0 */
        public void m5479p0() {
            this.f7677b &= -513;
            this.f7688m = 0;
        }

        public static ConfigFetchRequest parseDelimitedFrom(InputStream inputStream) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseDelimitedFrom(f7675q, inputStream);
        }

        public static ConfigFetchRequest parseFrom(ByteBuffer byteBuffer) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseFrom(f7675q, byteBuffer);
        }

        public static Parser<ConfigFetchRequest> parser() {
            return f7675q.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: q0 */
        public void m5481q0() {
            this.f7677b &= -33;
            this.f7684i = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: r0 */
        public void m5483r0() {
            this.f7677b &= -2049;
            this.f7690o = getDefaultInstance().getOsVersion();
        }

        /* access modifiers changed from: private */
        /* renamed from: s0 */
        public void m5485s0() {
            this.f7680e = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: t0 */
        public void m5487t0() {
            this.f7677b &= -9;
            this.f7682g = 0;
        }

        /* renamed from: u0 */
        private void m5489u0() {
            if (!this.f7680e.isModifiable()) {
                this.f7680e = GeneratedMessageLite.mutableCopy(this.f7680e);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: v0 */
        public void m5491v0(Logs.AndroidConfigFetchProto androidConfigFetchProto) {
            androidConfigFetchProto.getClass();
            Logs.AndroidConfigFetchProto androidConfigFetchProto2 = this.f7678c;
            if (androidConfigFetchProto2 == null || androidConfigFetchProto2 == Logs.AndroidConfigFetchProto.getDefaultInstance()) {
                this.f7678c = androidConfigFetchProto;
            } else {
                this.f7678c = (Logs.AndroidConfigFetchProto) ((Logs.AndroidConfigFetchProto.Builder) Logs.AndroidConfigFetchProto.newBuilder(this.f7678c).mergeFrom(androidConfigFetchProto)).buildPartial();
            }
            this.f7677b |= 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: w0 */
        public void m5493w0(int i) {
            m5489u0();
            this.f7680e.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: x0 */
        public void m5495x0(long j) {
            this.f7677b |= 2;
            this.f7679d = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: y0 */
        public void m5497y0(int i) {
            this.f7677b |= 64;
            this.f7685j = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: z0 */
        public void m5499z0(int i) {
            this.f7677b |= 16;
            this.f7683h = i;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C1695a.f7742a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ConfigFetchRequest();
                case 2:
                    return new Builder((C1695a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f7675q, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0001\u0000\u0001\u0005\u0001\u0002\u001b\u0003\b\u0002\u0004\u0005\u0003\u0005\t\u0000\u0006\u0004\u0004\u0007\u0004\u0005\b\u0004\u0006\t\b\u0007\n\b\b\u000b\u0004\t\f\u0004\n\r\b\u000b\u000e\b\f", new Object[]{"bitField0_", "androidId_", "packageData_", PackageData.class, "deviceDataVersionInfo_", "securityToken_", "config_", "clientVersion_", "gmsCoreVersion_", "apiLevel_", "deviceCountry_", "deviceLocale_", "deviceType_", "deviceSubtype_", "osVersion_", "deviceTimezoneId_"});
                case 4:
                    return f7675q;
                case 5:
                    Parser<ConfigFetchRequest> parser = f7676r;
                    if (parser == null) {
                        synchronized (ConfigFetchRequest.class) {
                            parser = f7676r;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f7675q);
                                f7676r = parser;
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

        public long getAndroidId() {
            return this.f7679d;
        }

        public int getApiLevel() {
            return this.f7685j;
        }

        public int getClientVersion() {
            return this.f7683h;
        }

        public Logs.AndroidConfigFetchProto getConfig() {
            Logs.AndroidConfigFetchProto androidConfigFetchProto = this.f7678c;
            return androidConfigFetchProto == null ? Logs.AndroidConfigFetchProto.getDefaultInstance() : androidConfigFetchProto;
        }

        public String getDeviceCountry() {
            return this.f7686k;
        }

        public ByteString getDeviceCountryBytes() {
            return ByteString.copyFromUtf8(this.f7686k);
        }

        public String getDeviceDataVersionInfo() {
            return this.f7681f;
        }

        public ByteString getDeviceDataVersionInfoBytes() {
            return ByteString.copyFromUtf8(this.f7681f);
        }

        public String getDeviceLocale() {
            return this.f7687l;
        }

        public ByteString getDeviceLocaleBytes() {
            return ByteString.copyFromUtf8(this.f7687l);
        }

        public int getDeviceSubtype() {
            return this.f7689n;
        }

        public String getDeviceTimezoneId() {
            return this.f7691p;
        }

        public ByteString getDeviceTimezoneIdBytes() {
            return ByteString.copyFromUtf8(this.f7691p);
        }

        public int getDeviceType() {
            return this.f7688m;
        }

        public int getGmsCoreVersion() {
            return this.f7684i;
        }

        public String getOsVersion() {
            return this.f7690o;
        }

        public ByteString getOsVersionBytes() {
            return ByteString.copyFromUtf8(this.f7690o);
        }

        public PackageData getPackageData(int i) {
            return this.f7680e.get(i);
        }

        public int getPackageDataCount() {
            return this.f7680e.size();
        }

        public List<PackageData> getPackageDataList() {
            return this.f7680e;
        }

        public PackageDataOrBuilder getPackageDataOrBuilder(int i) {
            return this.f7680e.get(i);
        }

        public List<? extends PackageDataOrBuilder> getPackageDataOrBuilderList() {
            return this.f7680e;
        }

        public long getSecurityToken() {
            return this.f7682g;
        }

        public boolean hasAndroidId() {
            return (this.f7677b & 2) != 0;
        }

        public boolean hasApiLevel() {
            return (this.f7677b & 64) != 0;
        }

        public boolean hasClientVersion() {
            return (this.f7677b & 16) != 0;
        }

        public boolean hasConfig() {
            return (this.f7677b & 1) != 0;
        }

        public boolean hasDeviceCountry() {
            return (this.f7677b & 128) != 0;
        }

        public boolean hasDeviceDataVersionInfo() {
            return (this.f7677b & 4) != 0;
        }

        public boolean hasDeviceLocale() {
            return (this.f7677b & 256) != 0;
        }

        public boolean hasDeviceSubtype() {
            return (this.f7677b & 1024) != 0;
        }

        public boolean hasDeviceTimezoneId() {
            return (this.f7677b & 4096) != 0;
        }

        public boolean hasDeviceType() {
            return (this.f7677b & 512) != 0;
        }

        public boolean hasGmsCoreVersion() {
            return (this.f7677b & 32) != 0;
        }

        public boolean hasOsVersion() {
            return (this.f7677b & 2048) != 0;
        }

        public boolean hasSecurityToken() {
            return (this.f7677b & 8) != 0;
        }

        public static Builder newBuilder(ConfigFetchRequest configFetchRequest) {
            return (Builder) f7675q.createBuilder(configFetchRequest);
        }

        public static ConfigFetchRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseDelimitedFrom(f7675q, inputStream, extensionRegistryLite);
        }

        public static ConfigFetchRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseFrom(f7675q, byteBuffer, extensionRegistryLite);
        }

        public static ConfigFetchRequest parseFrom(ByteString byteString) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseFrom(f7675q, byteString);
        }

        public static ConfigFetchRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseFrom(f7675q, byteString, extensionRegistryLite);
        }

        public static ConfigFetchRequest parseFrom(byte[] bArr) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseFrom(f7675q, bArr);
        }

        public static ConfigFetchRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseFrom(f7675q, bArr, extensionRegistryLite);
        }

        public static ConfigFetchRequest parseFrom(InputStream inputStream) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseFrom(f7675q, inputStream);
        }

        public static ConfigFetchRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseFrom(f7675q, inputStream, extensionRegistryLite);
        }

        public static ConfigFetchRequest parseFrom(CodedInputStream codedInputStream) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseFrom(f7675q, codedInputStream);
        }

        public static ConfigFetchRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchRequest) GeneratedMessageLite.parseFrom(f7675q, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ConfigFetchRequestOrBuilder extends MessageLiteOrBuilder {
        long getAndroidId();

        int getApiLevel();

        int getClientVersion();

        Logs.AndroidConfigFetchProto getConfig();

        String getDeviceCountry();

        ByteString getDeviceCountryBytes();

        String getDeviceDataVersionInfo();

        ByteString getDeviceDataVersionInfoBytes();

        String getDeviceLocale();

        ByteString getDeviceLocaleBytes();

        int getDeviceSubtype();

        String getDeviceTimezoneId();

        ByteString getDeviceTimezoneIdBytes();

        int getDeviceType();

        int getGmsCoreVersion();

        String getOsVersion();

        ByteString getOsVersionBytes();

        PackageData getPackageData(int i);

        int getPackageDataCount();

        List<PackageData> getPackageDataList();

        long getSecurityToken();

        boolean hasAndroidId();

        boolean hasApiLevel();

        boolean hasClientVersion();

        boolean hasConfig();

        boolean hasDeviceCountry();

        boolean hasDeviceDataVersionInfo();

        boolean hasDeviceLocale();

        boolean hasDeviceSubtype();

        boolean hasDeviceTimezoneId();

        boolean hasDeviceType();

        boolean hasGmsCoreVersion();

        boolean hasOsVersion();

        boolean hasSecurityToken();
    }

    public static final class ConfigFetchResponse extends GeneratedMessageLite<ConfigFetchResponse, Builder> implements ConfigFetchResponseOrBuilder {
        public static final int APP_CONFIG_FIELD_NUMBER = 4;
        public static final int INTERNAL_METADATA_FIELD_NUMBER = 3;
        public static final int PACKAGE_TABLE_FIELD_NUMBER = 1;
        public static final int STATUS_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public static final ConfigFetchResponse f7692g;

        /* renamed from: h */
        private static volatile Parser<ConfigFetchResponse> f7693h;

        /* renamed from: b */
        private int f7694b;

        /* renamed from: c */
        private Internal.ProtobufList<PackageTable> f7695c = GeneratedMessageLite.emptyProtobufList();

        /* renamed from: d */
        private int f7696d;

        /* renamed from: e */
        private Internal.ProtobufList<KeyValue> f7697e = GeneratedMessageLite.emptyProtobufList();

        /* renamed from: f */
        private Internal.ProtobufList<AppConfigTable> f7698f = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<ConfigFetchResponse, Builder> implements ConfigFetchResponseOrBuilder {
            /* synthetic */ Builder(C1695a aVar) {
                this();
            }

            public Builder addAllAppConfig(Iterable<? extends AppConfigTable> iterable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5511L(iterable);
                return this;
            }

            public Builder addAllInternalMetadata(Iterable<? extends KeyValue> iterable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5512M(iterable);
                return this;
            }

            public Builder addAllPackageTable(Iterable<? extends PackageTable> iterable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5513N(iterable);
                return this;
            }

            public Builder addAppConfig(AppConfigTable appConfigTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5515P(appConfigTable);
                return this;
            }

            public Builder addInternalMetadata(KeyValue keyValue) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5517R(keyValue);
                return this;
            }

            public Builder addPackageTable(PackageTable packageTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5519T(packageTable);
                return this;
            }

            public Builder clearAppConfig() {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5520U();
                return this;
            }

            public Builder clearInternalMetadata() {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5521V();
                return this;
            }

            public Builder clearPackageTable() {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5522W();
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5523X();
                return this;
            }

            public AppConfigTable getAppConfig(int i) {
                return ((ConfigFetchResponse) this.instance).getAppConfig(i);
            }

            public int getAppConfigCount() {
                return ((ConfigFetchResponse) this.instance).getAppConfigCount();
            }

            public List<AppConfigTable> getAppConfigList() {
                return Collections.unmodifiableList(((ConfigFetchResponse) this.instance).getAppConfigList());
            }

            public KeyValue getInternalMetadata(int i) {
                return ((ConfigFetchResponse) this.instance).getInternalMetadata(i);
            }

            public int getInternalMetadataCount() {
                return ((ConfigFetchResponse) this.instance).getInternalMetadataCount();
            }

            public List<KeyValue> getInternalMetadataList() {
                return Collections.unmodifiableList(((ConfigFetchResponse) this.instance).getInternalMetadataList());
            }

            public PackageTable getPackageTable(int i) {
                return ((ConfigFetchResponse) this.instance).getPackageTable(i);
            }

            public int getPackageTableCount() {
                return ((ConfigFetchResponse) this.instance).getPackageTableCount();
            }

            public List<PackageTable> getPackageTableList() {
                return Collections.unmodifiableList(((ConfigFetchResponse) this.instance).getPackageTableList());
            }

            public ResponseStatus getStatus() {
                return ((ConfigFetchResponse) this.instance).getStatus();
            }

            public boolean hasStatus() {
                return ((ConfigFetchResponse) this.instance).hasStatus();
            }

            public Builder removeAppConfig(int i) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5527b0(i);
                return this;
            }

            public Builder removeInternalMetadata(int i) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5528c0(i);
                return this;
            }

            public Builder removePackageTable(int i) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5529d0(i);
                return this;
            }

            public Builder setAppConfig(int i, AppConfigTable appConfigTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5530e0(i, appConfigTable);
                return this;
            }

            public Builder setInternalMetadata(int i, KeyValue keyValue) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5531f0(i, keyValue);
                return this;
            }

            public Builder setPackageTable(int i, PackageTable packageTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5532g0(i, packageTable);
                return this;
            }

            public Builder setStatus(ResponseStatus responseStatus) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5533h0(responseStatus);
                return this;
            }

            private Builder() {
                super(ConfigFetchResponse.f7692g);
            }

            public Builder addAppConfig(int i, AppConfigTable appConfigTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5514O(i, appConfigTable);
                return this;
            }

            public Builder addInternalMetadata(int i, KeyValue keyValue) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5516Q(i, keyValue);
                return this;
            }

            public Builder addPackageTable(int i, PackageTable packageTable) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5518S(i, packageTable);
                return this;
            }

            public Builder setAppConfig(int i, AppConfigTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5530e0(i, (AppConfigTable) builder.build());
                return this;
            }

            public Builder setInternalMetadata(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5531f0(i, (KeyValue) builder.build());
                return this;
            }

            public Builder setPackageTable(int i, PackageTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5532g0(i, (PackageTable) builder.build());
                return this;
            }

            public Builder addAppConfig(AppConfigTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5515P((AppConfigTable) builder.build());
                return this;
            }

            public Builder addInternalMetadata(KeyValue.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5517R((KeyValue) builder.build());
                return this;
            }

            public Builder addPackageTable(PackageTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5519T((PackageTable) builder.build());
                return this;
            }

            public Builder addAppConfig(int i, AppConfigTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5514O(i, (AppConfigTable) builder.build());
                return this;
            }

            public Builder addInternalMetadata(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5516Q(i, (KeyValue) builder.build());
                return this;
            }

            public Builder addPackageTable(int i, PackageTable.Builder builder) {
                copyOnWrite();
                ((ConfigFetchResponse) this.instance).m5518S(i, (PackageTable) builder.build());
                return this;
            }
        }

        public enum ResponseStatus implements Internal.EnumLite {
            SUCCESS(0),
            NO_PACKAGES_IN_REQUEST(1);
            
            public static final int NO_PACKAGES_IN_REQUEST_VALUE = 1;
            public static final int SUCCESS_VALUE = 0;

            /* renamed from: b */
            private static final Internal.EnumLiteMap<ResponseStatus> f7699b = null;

            /* renamed from: a */
            private final int f7701a;

            /* renamed from: com.google.android.gms.config.proto.Config$ConfigFetchResponse$ResponseStatus$a */
            class C1693a implements Internal.EnumLiteMap<ResponseStatus> {
                C1693a() {
                }

                /* renamed from: a */
                public ResponseStatus findValueByNumber(int i) {
                    return ResponseStatus.forNumber(i);
                }
            }

            /* renamed from: com.google.android.gms.config.proto.Config$ConfigFetchResponse$ResponseStatus$b */
            private static final class C1694b implements Internal.EnumVerifier {

                /* renamed from: a */
                static final Internal.EnumVerifier f7702a = null;

                static {
                    f7702a = new C1694b();
                }

                private C1694b() {
                }

                public boolean isInRange(int i) {
                    return ResponseStatus.forNumber(i) != null;
                }
            }

            static {
                f7699b = new C1693a();
            }

            private ResponseStatus(int i) {
                this.f7701a = i;
            }

            public static ResponseStatus forNumber(int i) {
                if (i == 0) {
                    return SUCCESS;
                }
                if (i != 1) {
                    return null;
                }
                return NO_PACKAGES_IN_REQUEST;
            }

            public static Internal.EnumLiteMap<ResponseStatus> internalGetValueMap() {
                return f7699b;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return C1694b.f7702a;
            }

            public final int getNumber() {
                return this.f7701a;
            }

            @Deprecated
            public static ResponseStatus valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            ConfigFetchResponse configFetchResponse = new ConfigFetchResponse();
            f7692g = configFetchResponse;
            GeneratedMessageLite.registerDefaultInstance(ConfigFetchResponse.class, configFetchResponse);
        }

        private ConfigFetchResponse() {
        }

        /* access modifiers changed from: private */
        /* renamed from: L */
        public void m5511L(Iterable<? extends AppConfigTable> iterable) {
            m5524Y();
            AbstractMessageLite.addAll(iterable, this.f7698f);
        }

        /* access modifiers changed from: private */
        /* renamed from: M */
        public void m5512M(Iterable<? extends KeyValue> iterable) {
            m5525Z();
            AbstractMessageLite.addAll(iterable, this.f7697e);
        }

        /* access modifiers changed from: private */
        /* renamed from: N */
        public void m5513N(Iterable<? extends PackageTable> iterable) {
            m5526a0();
            AbstractMessageLite.addAll(iterable, this.f7695c);
        }

        /* access modifiers changed from: private */
        /* renamed from: O */
        public void m5514O(int i, AppConfigTable appConfigTable) {
            appConfigTable.getClass();
            m5524Y();
            this.f7698f.add(i, appConfigTable);
        }

        /* access modifiers changed from: private */
        /* renamed from: P */
        public void m5515P(AppConfigTable appConfigTable) {
            appConfigTable.getClass();
            m5524Y();
            this.f7698f.add(appConfigTable);
        }

        /* access modifiers changed from: private */
        /* renamed from: Q */
        public void m5516Q(int i, KeyValue keyValue) {
            keyValue.getClass();
            m5525Z();
            this.f7697e.add(i, keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: R */
        public void m5517R(KeyValue keyValue) {
            keyValue.getClass();
            m5525Z();
            this.f7697e.add(keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: S */
        public void m5518S(int i, PackageTable packageTable) {
            packageTable.getClass();
            m5526a0();
            this.f7695c.add(i, packageTable);
        }

        /* access modifiers changed from: private */
        /* renamed from: T */
        public void m5519T(PackageTable packageTable) {
            packageTable.getClass();
            m5526a0();
            this.f7695c.add(packageTable);
        }

        /* access modifiers changed from: private */
        /* renamed from: U */
        public void m5520U() {
            this.f7698f = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: V */
        public void m5521V() {
            this.f7697e = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: W */
        public void m5522W() {
            this.f7695c = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: X */
        public void m5523X() {
            this.f7694b &= -2;
            this.f7696d = 0;
        }

        /* renamed from: Y */
        private void m5524Y() {
            if (!this.f7698f.isModifiable()) {
                this.f7698f = GeneratedMessageLite.mutableCopy(this.f7698f);
            }
        }

        /* renamed from: Z */
        private void m5525Z() {
            if (!this.f7697e.isModifiable()) {
                this.f7697e = GeneratedMessageLite.mutableCopy(this.f7697e);
            }
        }

        /* renamed from: a0 */
        private void m5526a0() {
            if (!this.f7695c.isModifiable()) {
                this.f7695c = GeneratedMessageLite.mutableCopy(this.f7695c);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b0 */
        public void m5527b0(int i) {
            m5524Y();
            this.f7698f.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: c0 */
        public void m5528c0(int i) {
            m5525Z();
            this.f7697e.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: d0 */
        public void m5529d0(int i) {
            m5526a0();
            this.f7695c.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: e0 */
        public void m5530e0(int i, AppConfigTable appConfigTable) {
            appConfigTable.getClass();
            m5524Y();
            this.f7698f.set(i, appConfigTable);
        }

        /* access modifiers changed from: private */
        /* renamed from: f0 */
        public void m5531f0(int i, KeyValue keyValue) {
            keyValue.getClass();
            m5525Z();
            this.f7697e.set(i, keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: g0 */
        public void m5532g0(int i, PackageTable packageTable) {
            packageTable.getClass();
            m5526a0();
            this.f7695c.set(i, packageTable);
        }

        public static ConfigFetchResponse getDefaultInstance() {
            return f7692g;
        }

        /* access modifiers changed from: private */
        /* renamed from: h0 */
        public void m5533h0(ResponseStatus responseStatus) {
            this.f7696d = responseStatus.getNumber();
            this.f7694b |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) f7692g.createBuilder();
        }

        public static ConfigFetchResponse parseDelimitedFrom(InputStream inputStream) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseDelimitedFrom(f7692g, inputStream);
        }

        public static ConfigFetchResponse parseFrom(ByteBuffer byteBuffer) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseFrom(f7692g, byteBuffer);
        }

        public static Parser<ConfigFetchResponse> parser() {
            return f7692g.getParserForType();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C1695a.f7742a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ConfigFetchResponse();
                case 2:
                    return new Builder((C1695a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f7692g, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001\u001b\u0002\f\u0000\u0003\u001b\u0004\u001b", new Object[]{"bitField0_", "packageTable_", PackageTable.class, "status_", ResponseStatus.internalGetVerifier(), "internalMetadata_", KeyValue.class, "appConfig_", AppConfigTable.class});
                case 4:
                    return f7692g;
                case 5:
                    Parser<ConfigFetchResponse> parser = f7693h;
                    if (parser == null) {
                        synchronized (ConfigFetchResponse.class) {
                            parser = f7693h;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f7692g);
                                f7693h = parser;
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

        public AppConfigTable getAppConfig(int i) {
            return this.f7698f.get(i);
        }

        public int getAppConfigCount() {
            return this.f7698f.size();
        }

        public List<AppConfigTable> getAppConfigList() {
            return this.f7698f;
        }

        public AppConfigTableOrBuilder getAppConfigOrBuilder(int i) {
            return this.f7698f.get(i);
        }

        public List<? extends AppConfigTableOrBuilder> getAppConfigOrBuilderList() {
            return this.f7698f;
        }

        public KeyValue getInternalMetadata(int i) {
            return this.f7697e.get(i);
        }

        public int getInternalMetadataCount() {
            return this.f7697e.size();
        }

        public List<KeyValue> getInternalMetadataList() {
            return this.f7697e;
        }

        public KeyValueOrBuilder getInternalMetadataOrBuilder(int i) {
            return this.f7697e.get(i);
        }

        public List<? extends KeyValueOrBuilder> getInternalMetadataOrBuilderList() {
            return this.f7697e;
        }

        public PackageTable getPackageTable(int i) {
            return this.f7695c.get(i);
        }

        public int getPackageTableCount() {
            return this.f7695c.size();
        }

        public List<PackageTable> getPackageTableList() {
            return this.f7695c;
        }

        public PackageTableOrBuilder getPackageTableOrBuilder(int i) {
            return this.f7695c.get(i);
        }

        public List<? extends PackageTableOrBuilder> getPackageTableOrBuilderList() {
            return this.f7695c;
        }

        public ResponseStatus getStatus() {
            ResponseStatus forNumber = ResponseStatus.forNumber(this.f7696d);
            return forNumber == null ? ResponseStatus.SUCCESS : forNumber;
        }

        public boolean hasStatus() {
            return (this.f7694b & 1) != 0;
        }

        public static Builder newBuilder(ConfigFetchResponse configFetchResponse) {
            return (Builder) f7692g.createBuilder(configFetchResponse);
        }

        public static ConfigFetchResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseDelimitedFrom(f7692g, inputStream, extensionRegistryLite);
        }

        public static ConfigFetchResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseFrom(f7692g, byteBuffer, extensionRegistryLite);
        }

        public static ConfigFetchResponse parseFrom(ByteString byteString) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseFrom(f7692g, byteString);
        }

        public static ConfigFetchResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseFrom(f7692g, byteString, extensionRegistryLite);
        }

        public static ConfigFetchResponse parseFrom(byte[] bArr) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseFrom(f7692g, bArr);
        }

        public static ConfigFetchResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseFrom(f7692g, bArr, extensionRegistryLite);
        }

        public static ConfigFetchResponse parseFrom(InputStream inputStream) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseFrom(f7692g, inputStream);
        }

        public static ConfigFetchResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseFrom(f7692g, inputStream, extensionRegistryLite);
        }

        public static ConfigFetchResponse parseFrom(CodedInputStream codedInputStream) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseFrom(f7692g, codedInputStream);
        }

        public static ConfigFetchResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigFetchResponse) GeneratedMessageLite.parseFrom(f7692g, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ConfigFetchResponseOrBuilder extends MessageLiteOrBuilder {
        AppConfigTable getAppConfig(int i);

        int getAppConfigCount();

        List<AppConfigTable> getAppConfigList();

        KeyValue getInternalMetadata(int i);

        int getInternalMetadataCount();

        List<KeyValue> getInternalMetadataList();

        PackageTable getPackageTable(int i);

        int getPackageTableCount();

        List<PackageTable> getPackageTableList();

        ConfigFetchResponse.ResponseStatus getStatus();

        boolean hasStatus();
    }

    public static final class KeyValue extends GeneratedMessageLite<KeyValue, Builder> implements KeyValueOrBuilder {
        public static final int KEY_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public static final KeyValue f7703e;

        /* renamed from: f */
        private static volatile Parser<KeyValue> f7704f;

        /* renamed from: b */
        private int f7705b;

        /* renamed from: c */
        private String f7706c = "";

        /* renamed from: d */
        private ByteString f7707d = ByteString.EMPTY;

        public static final class Builder extends GeneratedMessageLite.Builder<KeyValue, Builder> implements KeyValueOrBuilder {
            /* synthetic */ Builder(C1695a aVar) {
                this();
            }

            public Builder clearKey() {
                copyOnWrite();
                ((KeyValue) this.instance).m5552w();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((KeyValue) this.instance).m5553x();
                return this;
            }

            public String getKey() {
                return ((KeyValue) this.instance).getKey();
            }

            public ByteString getKeyBytes() {
                return ((KeyValue) this.instance).getKeyBytes();
            }

            public ByteString getValue() {
                return ((KeyValue) this.instance).getValue();
            }

            public boolean hasKey() {
                return ((KeyValue) this.instance).hasKey();
            }

            public boolean hasValue() {
                return ((KeyValue) this.instance).hasValue();
            }

            public Builder setKey(String str) {
                copyOnWrite();
                ((KeyValue) this.instance).m5554y(str);
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((KeyValue) this.instance).m5555z(byteString);
                return this;
            }

            public Builder setValue(ByteString byteString) {
                copyOnWrite();
                ((KeyValue) this.instance).m5545A(byteString);
                return this;
            }

            private Builder() {
                super(KeyValue.f7703e);
            }
        }

        static {
            KeyValue keyValue = new KeyValue();
            f7703e = keyValue;
            GeneratedMessageLite.registerDefaultInstance(KeyValue.class, keyValue);
        }

        private KeyValue() {
        }

        /* access modifiers changed from: private */
        /* renamed from: A */
        public void m5545A(ByteString byteString) {
            byteString.getClass();
            this.f7705b |= 2;
            this.f7707d = byteString;
        }

        public static KeyValue getDefaultInstance() {
            return f7703e;
        }

        public static Builder newBuilder() {
            return (Builder) f7703e.createBuilder();
        }

        public static KeyValue parseDelimitedFrom(InputStream inputStream) {
            return (KeyValue) GeneratedMessageLite.parseDelimitedFrom(f7703e, inputStream);
        }

        public static KeyValue parseFrom(ByteBuffer byteBuffer) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f7703e, byteBuffer);
        }

        public static Parser<KeyValue> parser() {
            return f7703e.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: w */
        public void m5552w() {
            this.f7705b &= -2;
            this.f7706c = getDefaultInstance().getKey();
        }

        /* access modifiers changed from: private */
        /* renamed from: x */
        public void m5553x() {
            this.f7705b &= -3;
            this.f7707d = getDefaultInstance().getValue();
        }

        /* access modifiers changed from: private */
        /* renamed from: y */
        public void m5554y(String str) {
            str.getClass();
            this.f7705b |= 1;
            this.f7706c = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: z */
        public void m5555z(ByteString byteString) {
            this.f7706c = byteString.toStringUtf8();
            this.f7705b |= 1;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C1695a.f7742a[methodToInvoke.ordinal()]) {
                case 1:
                    return new KeyValue();
                case 2:
                    return new Builder((C1695a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f7703e, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "key_", "value_"});
                case 4:
                    return f7703e;
                case 5:
                    Parser<KeyValue> parser = f7704f;
                    if (parser == null) {
                        synchronized (KeyValue.class) {
                            parser = f7704f;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f7703e);
                                f7704f = parser;
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

        public String getKey() {
            return this.f7706c;
        }

        public ByteString getKeyBytes() {
            return ByteString.copyFromUtf8(this.f7706c);
        }

        public ByteString getValue() {
            return this.f7707d;
        }

        public boolean hasKey() {
            return (this.f7705b & 1) != 0;
        }

        public boolean hasValue() {
            return (this.f7705b & 2) != 0;
        }

        public static Builder newBuilder(KeyValue keyValue) {
            return (Builder) f7703e.createBuilder(keyValue);
        }

        public static KeyValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseDelimitedFrom(f7703e, inputStream, extensionRegistryLite);
        }

        public static KeyValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f7703e, byteBuffer, extensionRegistryLite);
        }

        public static KeyValue parseFrom(ByteString byteString) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f7703e, byteString);
        }

        public static KeyValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f7703e, byteString, extensionRegistryLite);
        }

        public static KeyValue parseFrom(byte[] bArr) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f7703e, bArr);
        }

        public static KeyValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f7703e, bArr, extensionRegistryLite);
        }

        public static KeyValue parseFrom(InputStream inputStream) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f7703e, inputStream);
        }

        public static KeyValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f7703e, inputStream, extensionRegistryLite);
        }

        public static KeyValue parseFrom(CodedInputStream codedInputStream) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f7703e, codedInputStream);
        }

        public static KeyValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f7703e, codedInputStream, extensionRegistryLite);
        }
    }

    public interface KeyValueOrBuilder extends MessageLiteOrBuilder {
        String getKey();

        ByteString getKeyBytes();

        ByteString getValue();

        boolean hasKey();

        boolean hasValue();
    }

    public static final class NamedValue extends GeneratedMessageLite<NamedValue, Builder> implements NamedValueOrBuilder {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public static final NamedValue f7708e;

        /* renamed from: f */
        private static volatile Parser<NamedValue> f7709f;

        /* renamed from: b */
        private int f7710b;

        /* renamed from: c */
        private String f7711c = "";

        /* renamed from: d */
        private String f7712d = "";

        public static final class Builder extends GeneratedMessageLite.Builder<NamedValue, Builder> implements NamedValueOrBuilder {
            /* synthetic */ Builder(C1695a aVar) {
                this();
            }

            public Builder clearName() {
                copyOnWrite();
                ((NamedValue) this.instance).m5566x();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((NamedValue) this.instance).m5567y();
                return this;
            }

            public String getName() {
                return ((NamedValue) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((NamedValue) this.instance).getNameBytes();
            }

            public String getValue() {
                return ((NamedValue) this.instance).getValue();
            }

            public ByteString getValueBytes() {
                return ((NamedValue) this.instance).getValueBytes();
            }

            public boolean hasName() {
                return ((NamedValue) this.instance).hasName();
            }

            public boolean hasValue() {
                return ((NamedValue) this.instance).hasValue();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((NamedValue) this.instance).m5568z(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((NamedValue) this.instance).m5556A(byteString);
                return this;
            }

            public Builder setValue(String str) {
                copyOnWrite();
                ((NamedValue) this.instance).m5557B(str);
                return this;
            }

            public Builder setValueBytes(ByteString byteString) {
                copyOnWrite();
                ((NamedValue) this.instance).m5558C(byteString);
                return this;
            }

            private Builder() {
                super(NamedValue.f7708e);
            }
        }

        static {
            NamedValue namedValue = new NamedValue();
            f7708e = namedValue;
            GeneratedMessageLite.registerDefaultInstance(NamedValue.class, namedValue);
        }

        private NamedValue() {
        }

        /* access modifiers changed from: private */
        /* renamed from: A */
        public void m5556A(ByteString byteString) {
            this.f7711c = byteString.toStringUtf8();
            this.f7710b |= 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: B */
        public void m5557B(String str) {
            str.getClass();
            this.f7710b |= 2;
            this.f7712d = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: C */
        public void m5558C(ByteString byteString) {
            this.f7712d = byteString.toStringUtf8();
            this.f7710b |= 2;
        }

        public static NamedValue getDefaultInstance() {
            return f7708e;
        }

        public static Builder newBuilder() {
            return (Builder) f7708e.createBuilder();
        }

        public static NamedValue parseDelimitedFrom(InputStream inputStream) {
            return (NamedValue) GeneratedMessageLite.parseDelimitedFrom(f7708e, inputStream);
        }

        public static NamedValue parseFrom(ByteBuffer byteBuffer) {
            return (NamedValue) GeneratedMessageLite.parseFrom(f7708e, byteBuffer);
        }

        public static Parser<NamedValue> parser() {
            return f7708e.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: x */
        public void m5566x() {
            this.f7710b &= -2;
            this.f7711c = getDefaultInstance().getName();
        }

        /* access modifiers changed from: private */
        /* renamed from: y */
        public void m5567y() {
            this.f7710b &= -3;
            this.f7712d = getDefaultInstance().getValue();
        }

        /* access modifiers changed from: private */
        /* renamed from: z */
        public void m5568z(String str) {
            str.getClass();
            this.f7710b |= 1;
            this.f7711c = str;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C1695a.f7742a[methodToInvoke.ordinal()]) {
                case 1:
                    return new NamedValue();
                case 2:
                    return new Builder((C1695a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f7708e, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"bitField0_", "name_", "value_"});
                case 4:
                    return f7708e;
                case 5:
                    Parser<NamedValue> parser = f7709f;
                    if (parser == null) {
                        synchronized (NamedValue.class) {
                            parser = f7709f;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f7708e);
                                f7709f = parser;
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
            return this.f7711c;
        }

        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.f7711c);
        }

        public String getValue() {
            return this.f7712d;
        }

        public ByteString getValueBytes() {
            return ByteString.copyFromUtf8(this.f7712d);
        }

        public boolean hasName() {
            return (this.f7710b & 1) != 0;
        }

        public boolean hasValue() {
            return (this.f7710b & 2) != 0;
        }

        public static Builder newBuilder(NamedValue namedValue) {
            return (Builder) f7708e.createBuilder(namedValue);
        }

        public static NamedValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (NamedValue) GeneratedMessageLite.parseDelimitedFrom(f7708e, inputStream, extensionRegistryLite);
        }

        public static NamedValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (NamedValue) GeneratedMessageLite.parseFrom(f7708e, byteBuffer, extensionRegistryLite);
        }

        public static NamedValue parseFrom(ByteString byteString) {
            return (NamedValue) GeneratedMessageLite.parseFrom(f7708e, byteString);
        }

        public static NamedValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (NamedValue) GeneratedMessageLite.parseFrom(f7708e, byteString, extensionRegistryLite);
        }

        public static NamedValue parseFrom(byte[] bArr) {
            return (NamedValue) GeneratedMessageLite.parseFrom(f7708e, bArr);
        }

        public static NamedValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (NamedValue) GeneratedMessageLite.parseFrom(f7708e, bArr, extensionRegistryLite);
        }

        public static NamedValue parseFrom(InputStream inputStream) {
            return (NamedValue) GeneratedMessageLite.parseFrom(f7708e, inputStream);
        }

        public static NamedValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (NamedValue) GeneratedMessageLite.parseFrom(f7708e, inputStream, extensionRegistryLite);
        }

        public static NamedValue parseFrom(CodedInputStream codedInputStream) {
            return (NamedValue) GeneratedMessageLite.parseFrom(f7708e, codedInputStream);
        }

        public static NamedValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (NamedValue) GeneratedMessageLite.parseFrom(f7708e, codedInputStream, extensionRegistryLite);
        }
    }

    public interface NamedValueOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        String getValue();

        ByteString getValueBytes();

        boolean hasName();

        boolean hasValue();
    }

    public static final class PackageData extends GeneratedMessageLite<PackageData, Builder> implements PackageDataOrBuilder {
        public static final int ACTIVE_CONFIG_AGE_SECONDS_FIELD_NUMBER = 20;
        public static final int ANALYTICS_USER_PROPERTY_FIELD_NUMBER = 17;
        public static final int APP_CERT_HASH_FIELD_NUMBER = 10;
        public static final int APP_INSTANCE_ID_FIELD_NUMBER = 12;
        public static final int APP_INSTANCE_ID_TOKEN_FIELD_NUMBER = 14;
        public static final int APP_VERSION_CODE_FIELD_NUMBER = 11;
        public static final int APP_VERSION_FIELD_NUMBER = 13;
        public static final int CERT_HASH_FIELD_NUMBER = 4;
        public static final int CONFIG_ID_FIELD_NUMBER = 5;
        public static final int CUSTOM_VARIABLE_FIELD_NUMBER = 9;
        public static final int DIGEST_FIELD_NUMBER = 3;
        public static final int FETCHED_CONFIG_AGE_SECONDS_FIELD_NUMBER = 19;
        public static final int GAMES_PROJECT_ID_FIELD_NUMBER = 7;
        public static final int GMP_PROJECT_ID_FIELD_NUMBER = 6;
        public static final int NAMESPACE_DIGEST_FIELD_NUMBER = 8;
        public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
        public static final int REQUESTED_CACHE_EXPIRATION_SECONDS_FIELD_NUMBER = 18;
        public static final int REQUESTED_HIDDEN_NAMESPACE_FIELD_NUMBER = 15;
        public static final int SDK_VERSION_FIELD_NUMBER = 16;
        public static final int VERSION_CODE_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */

        /* renamed from: w */
        public static final PackageData f7713w;

        /* renamed from: x */
        private static volatile Parser<PackageData> f7714x;

        /* renamed from: b */
        private int f7715b;

        /* renamed from: c */
        private int f7716c;

        /* renamed from: d */
        private ByteString f7717d;

        /* renamed from: e */
        private ByteString f7718e;

        /* renamed from: f */
        private String f7719f = "";

        /* renamed from: g */
        private String f7720g = "";

        /* renamed from: h */
        private String f7721h = "";

        /* renamed from: i */
        private String f7722i = "";

        /* renamed from: j */
        private Internal.ProtobufList<NamedValue> f7723j = GeneratedMessageLite.emptyProtobufList();

        /* renamed from: k */
        private Internal.ProtobufList<NamedValue> f7724k = GeneratedMessageLite.emptyProtobufList();

        /* renamed from: l */
        private ByteString f7725l;

        /* renamed from: m */
        private int f7726m;

        /* renamed from: n */
        private String f7727n;

        /* renamed from: o */
        private String f7728o;

        /* renamed from: p */
        private String f7729p;

        /* renamed from: q */
        private Internal.ProtobufList<String> f7730q;

        /* renamed from: r */
        private int f7731r;

        /* renamed from: s */
        private Internal.ProtobufList<NamedValue> f7732s;

        /* renamed from: t */
        private int f7733t;

        /* renamed from: u */
        private int f7734u;

        /* renamed from: v */
        private int f7735v;

        public static final class Builder extends GeneratedMessageLite.Builder<PackageData, Builder> implements PackageDataOrBuilder {
            /* synthetic */ Builder(C1695a aVar) {
                this();
            }

            public Builder addAllAnalyticsUserProperty(Iterable<? extends NamedValue> iterable) {
                copyOnWrite();
                ((PackageData) this.instance).m5573B0(iterable);
                return this;
            }

            public Builder addAllCustomVariable(Iterable<? extends NamedValue> iterable) {
                copyOnWrite();
                ((PackageData) this.instance).m5576C0(iterable);
                return this;
            }

            public Builder addAllNamespaceDigest(Iterable<? extends NamedValue> iterable) {
                copyOnWrite();
                ((PackageData) this.instance).m5579D0(iterable);
                return this;
            }

            public Builder addAllRequestedHiddenNamespace(Iterable<String> iterable) {
                copyOnWrite();
                ((PackageData) this.instance).m5582E0(iterable);
                return this;
            }

            public Builder addAnalyticsUserProperty(NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).m5588G0(namedValue);
                return this;
            }

            public Builder addCustomVariable(NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).m5594I0(namedValue);
                return this;
            }

            public Builder addNamespaceDigest(NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).m5600K0(namedValue);
                return this;
            }

            public Builder addRequestedHiddenNamespace(String str) {
                copyOnWrite();
                ((PackageData) this.instance).m5603L0(str);
                return this;
            }

            public Builder addRequestedHiddenNamespaceBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5606M0(byteString);
                return this;
            }

            public Builder clearActiveConfigAgeSeconds() {
                copyOnWrite();
                ((PackageData) this.instance).m5609N0();
                return this;
            }

            public Builder clearAnalyticsUserProperty() {
                copyOnWrite();
                ((PackageData) this.instance).m5612O0();
                return this;
            }

            public Builder clearAppCertHash() {
                copyOnWrite();
                ((PackageData) this.instance).m5615P0();
                return this;
            }

            public Builder clearAppInstanceId() {
                copyOnWrite();
                ((PackageData) this.instance).m5617Q0();
                return this;
            }

            public Builder clearAppInstanceIdToken() {
                copyOnWrite();
                ((PackageData) this.instance).m5619R0();
                return this;
            }

            public Builder clearAppVersion() {
                copyOnWrite();
                ((PackageData) this.instance).m5621S0();
                return this;
            }

            public Builder clearAppVersionCode() {
                copyOnWrite();
                ((PackageData) this.instance).m5623T0();
                return this;
            }

            public Builder clearCertHash() {
                copyOnWrite();
                ((PackageData) this.instance).m5625U0();
                return this;
            }

            public Builder clearConfigId() {
                copyOnWrite();
                ((PackageData) this.instance).m5627V0();
                return this;
            }

            public Builder clearCustomVariable() {
                copyOnWrite();
                ((PackageData) this.instance).m5629W0();
                return this;
            }

            public Builder clearDigest() {
                copyOnWrite();
                ((PackageData) this.instance).m5631X0();
                return this;
            }

            public Builder clearFetchedConfigAgeSeconds() {
                copyOnWrite();
                ((PackageData) this.instance).m5633Y0();
                return this;
            }

            public Builder clearGamesProjectId() {
                copyOnWrite();
                ((PackageData) this.instance).m5635Z0();
                return this;
            }

            public Builder clearGmpProjectId() {
                copyOnWrite();
                ((PackageData) this.instance).m5637a1();
                return this;
            }

            public Builder clearNamespaceDigest() {
                copyOnWrite();
                ((PackageData) this.instance).m5639b1();
                return this;
            }

            public Builder clearPackageName() {
                copyOnWrite();
                ((PackageData) this.instance).m5641c1();
                return this;
            }

            public Builder clearRequestedCacheExpirationSeconds() {
                copyOnWrite();
                ((PackageData) this.instance).m5643d1();
                return this;
            }

            public Builder clearRequestedHiddenNamespace() {
                copyOnWrite();
                ((PackageData) this.instance).m5645e1();
                return this;
            }

            public Builder clearSdkVersion() {
                copyOnWrite();
                ((PackageData) this.instance).m5647f1();
                return this;
            }

            public Builder clearVersionCode() {
                copyOnWrite();
                ((PackageData) this.instance).m5649g1();
                return this;
            }

            public int getActiveConfigAgeSeconds() {
                return ((PackageData) this.instance).getActiveConfigAgeSeconds();
            }

            public NamedValue getAnalyticsUserProperty(int i) {
                return ((PackageData) this.instance).getAnalyticsUserProperty(i);
            }

            public int getAnalyticsUserPropertyCount() {
                return ((PackageData) this.instance).getAnalyticsUserPropertyCount();
            }

            public List<NamedValue> getAnalyticsUserPropertyList() {
                return Collections.unmodifiableList(((PackageData) this.instance).getAnalyticsUserPropertyList());
            }

            public ByteString getAppCertHash() {
                return ((PackageData) this.instance).getAppCertHash();
            }

            public String getAppInstanceId() {
                return ((PackageData) this.instance).getAppInstanceId();
            }

            public ByteString getAppInstanceIdBytes() {
                return ((PackageData) this.instance).getAppInstanceIdBytes();
            }

            public String getAppInstanceIdToken() {
                return ((PackageData) this.instance).getAppInstanceIdToken();
            }

            public ByteString getAppInstanceIdTokenBytes() {
                return ((PackageData) this.instance).getAppInstanceIdTokenBytes();
            }

            public String getAppVersion() {
                return ((PackageData) this.instance).getAppVersion();
            }

            public ByteString getAppVersionBytes() {
                return ((PackageData) this.instance).getAppVersionBytes();
            }

            public int getAppVersionCode() {
                return ((PackageData) this.instance).getAppVersionCode();
            }

            public ByteString getCertHash() {
                return ((PackageData) this.instance).getCertHash();
            }

            public String getConfigId() {
                return ((PackageData) this.instance).getConfigId();
            }

            public ByteString getConfigIdBytes() {
                return ((PackageData) this.instance).getConfigIdBytes();
            }

            public NamedValue getCustomVariable(int i) {
                return ((PackageData) this.instance).getCustomVariable(i);
            }

            public int getCustomVariableCount() {
                return ((PackageData) this.instance).getCustomVariableCount();
            }

            public List<NamedValue> getCustomVariableList() {
                return Collections.unmodifiableList(((PackageData) this.instance).getCustomVariableList());
            }

            public ByteString getDigest() {
                return ((PackageData) this.instance).getDigest();
            }

            public int getFetchedConfigAgeSeconds() {
                return ((PackageData) this.instance).getFetchedConfigAgeSeconds();
            }

            public String getGamesProjectId() {
                return ((PackageData) this.instance).getGamesProjectId();
            }

            public ByteString getGamesProjectIdBytes() {
                return ((PackageData) this.instance).getGamesProjectIdBytes();
            }

            public String getGmpProjectId() {
                return ((PackageData) this.instance).getGmpProjectId();
            }

            public ByteString getGmpProjectIdBytes() {
                return ((PackageData) this.instance).getGmpProjectIdBytes();
            }

            public NamedValue getNamespaceDigest(int i) {
                return ((PackageData) this.instance).getNamespaceDigest(i);
            }

            public int getNamespaceDigestCount() {
                return ((PackageData) this.instance).getNamespaceDigestCount();
            }

            public List<NamedValue> getNamespaceDigestList() {
                return Collections.unmodifiableList(((PackageData) this.instance).getNamespaceDigestList());
            }

            public String getPackageName() {
                return ((PackageData) this.instance).getPackageName();
            }

            public ByteString getPackageNameBytes() {
                return ((PackageData) this.instance).getPackageNameBytes();
            }

            public int getRequestedCacheExpirationSeconds() {
                return ((PackageData) this.instance).getRequestedCacheExpirationSeconds();
            }

            public String getRequestedHiddenNamespace(int i) {
                return ((PackageData) this.instance).getRequestedHiddenNamespace(i);
            }

            public ByteString getRequestedHiddenNamespaceBytes(int i) {
                return ((PackageData) this.instance).getRequestedHiddenNamespaceBytes(i);
            }

            public int getRequestedHiddenNamespaceCount() {
                return ((PackageData) this.instance).getRequestedHiddenNamespaceCount();
            }

            public List<String> getRequestedHiddenNamespaceList() {
                return Collections.unmodifiableList(((PackageData) this.instance).getRequestedHiddenNamespaceList());
            }

            public int getSdkVersion() {
                return ((PackageData) this.instance).getSdkVersion();
            }

            public int getVersionCode() {
                return ((PackageData) this.instance).getVersionCode();
            }

            public boolean hasActiveConfigAgeSeconds() {
                return ((PackageData) this.instance).hasActiveConfigAgeSeconds();
            }

            public boolean hasAppCertHash() {
                return ((PackageData) this.instance).hasAppCertHash();
            }

            public boolean hasAppInstanceId() {
                return ((PackageData) this.instance).hasAppInstanceId();
            }

            public boolean hasAppInstanceIdToken() {
                return ((PackageData) this.instance).hasAppInstanceIdToken();
            }

            public boolean hasAppVersion() {
                return ((PackageData) this.instance).hasAppVersion();
            }

            public boolean hasAppVersionCode() {
                return ((PackageData) this.instance).hasAppVersionCode();
            }

            public boolean hasCertHash() {
                return ((PackageData) this.instance).hasCertHash();
            }

            public boolean hasConfigId() {
                return ((PackageData) this.instance).hasConfigId();
            }

            public boolean hasDigest() {
                return ((PackageData) this.instance).hasDigest();
            }

            public boolean hasFetchedConfigAgeSeconds() {
                return ((PackageData) this.instance).hasFetchedConfigAgeSeconds();
            }

            public boolean hasGamesProjectId() {
                return ((PackageData) this.instance).hasGamesProjectId();
            }

            public boolean hasGmpProjectId() {
                return ((PackageData) this.instance).hasGmpProjectId();
            }

            public boolean hasPackageName() {
                return ((PackageData) this.instance).hasPackageName();
            }

            public boolean hasRequestedCacheExpirationSeconds() {
                return ((PackageData) this.instance).hasRequestedCacheExpirationSeconds();
            }

            public boolean hasSdkVersion() {
                return ((PackageData) this.instance).hasSdkVersion();
            }

            public boolean hasVersionCode() {
                return ((PackageData) this.instance).hasVersionCode();
            }

            public Builder removeAnalyticsUserProperty(int i) {
                copyOnWrite();
                ((PackageData) this.instance).m5659l1(i);
                return this;
            }

            public Builder removeCustomVariable(int i) {
                copyOnWrite();
                ((PackageData) this.instance).m5661m1(i);
                return this;
            }

            public Builder removeNamespaceDigest(int i) {
                copyOnWrite();
                ((PackageData) this.instance).m5663n1(i);
                return this;
            }

            public Builder setActiveConfigAgeSeconds(int i) {
                copyOnWrite();
                ((PackageData) this.instance).m5665o1(i);
                return this;
            }

            public Builder setAnalyticsUserProperty(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).m5667p1(i, namedValue);
                return this;
            }

            public Builder setAppCertHash(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5670q1(byteString);
                return this;
            }

            public Builder setAppInstanceId(String str) {
                copyOnWrite();
                ((PackageData) this.instance).m5673r1(str);
                return this;
            }

            public Builder setAppInstanceIdBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5676s1(byteString);
                return this;
            }

            public Builder setAppInstanceIdToken(String str) {
                copyOnWrite();
                ((PackageData) this.instance).m5679t1(str);
                return this;
            }

            public Builder setAppInstanceIdTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5682u1(byteString);
                return this;
            }

            public Builder setAppVersion(String str) {
                copyOnWrite();
                ((PackageData) this.instance).m5685v1(str);
                return this;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5688w1(byteString);
                return this;
            }

            public Builder setAppVersionCode(int i) {
                copyOnWrite();
                ((PackageData) this.instance).m5691x1(i);
                return this;
            }

            public Builder setCertHash(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5694y1(byteString);
                return this;
            }

            public Builder setConfigId(String str) {
                copyOnWrite();
                ((PackageData) this.instance).m5697z1(str);
                return this;
            }

            public Builder setConfigIdBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5571A1(byteString);
                return this;
            }

            public Builder setCustomVariable(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).m5574B1(i, namedValue);
                return this;
            }

            public Builder setDigest(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5577C1(byteString);
                return this;
            }

            public Builder setFetchedConfigAgeSeconds(int i) {
                copyOnWrite();
                ((PackageData) this.instance).m5580D1(i);
                return this;
            }

            public Builder setGamesProjectId(String str) {
                copyOnWrite();
                ((PackageData) this.instance).m5583E1(str);
                return this;
            }

            public Builder setGamesProjectIdBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5586F1(byteString);
                return this;
            }

            public Builder setGmpProjectId(String str) {
                copyOnWrite();
                ((PackageData) this.instance).m5589G1(str);
                return this;
            }

            public Builder setGmpProjectIdBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5592H1(byteString);
                return this;
            }

            public Builder setNamespaceDigest(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).m5595I1(i, namedValue);
                return this;
            }

            public Builder setPackageName(String str) {
                copyOnWrite();
                ((PackageData) this.instance).m5598J1(str);
                return this;
            }

            public Builder setPackageNameBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageData) this.instance).m5601K1(byteString);
                return this;
            }

            public Builder setRequestedCacheExpirationSeconds(int i) {
                copyOnWrite();
                ((PackageData) this.instance).m5604L1(i);
                return this;
            }

            public Builder setRequestedHiddenNamespace(int i, String str) {
                copyOnWrite();
                ((PackageData) this.instance).m5607M1(i, str);
                return this;
            }

            public Builder setSdkVersion(int i) {
                copyOnWrite();
                ((PackageData) this.instance).m5610N1(i);
                return this;
            }

            public Builder setVersionCode(int i) {
                copyOnWrite();
                ((PackageData) this.instance).m5613O1(i);
                return this;
            }

            private Builder() {
                super(PackageData.f7713w);
            }

            public Builder addAnalyticsUserProperty(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).m5585F0(i, namedValue);
                return this;
            }

            public Builder addCustomVariable(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).m5591H0(i, namedValue);
                return this;
            }

            public Builder addNamespaceDigest(int i, NamedValue namedValue) {
                copyOnWrite();
                ((PackageData) this.instance).m5597J0(i, namedValue);
                return this;
            }

            public Builder setAnalyticsUserProperty(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).m5667p1(i, (NamedValue) builder.build());
                return this;
            }

            public Builder setCustomVariable(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).m5574B1(i, (NamedValue) builder.build());
                return this;
            }

            public Builder setNamespaceDigest(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).m5595I1(i, (NamedValue) builder.build());
                return this;
            }

            public Builder addAnalyticsUserProperty(NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).m5588G0((NamedValue) builder.build());
                return this;
            }

            public Builder addCustomVariable(NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).m5594I0((NamedValue) builder.build());
                return this;
            }

            public Builder addNamespaceDigest(NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).m5600K0((NamedValue) builder.build());
                return this;
            }

            public Builder addAnalyticsUserProperty(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).m5585F0(i, (NamedValue) builder.build());
                return this;
            }

            public Builder addCustomVariable(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).m5591H0(i, (NamedValue) builder.build());
                return this;
            }

            public Builder addNamespaceDigest(int i, NamedValue.Builder builder) {
                copyOnWrite();
                ((PackageData) this.instance).m5597J0(i, (NamedValue) builder.build());
                return this;
            }
        }

        static {
            PackageData packageData = new PackageData();
            f7713w = packageData;
            GeneratedMessageLite.registerDefaultInstance(PackageData.class, packageData);
        }

        private PackageData() {
            ByteString byteString = ByteString.EMPTY;
            this.f7717d = byteString;
            this.f7718e = byteString;
            this.f7725l = byteString;
            this.f7727n = "";
            this.f7728o = "";
            this.f7729p = "";
            this.f7730q = GeneratedMessageLite.emptyProtobufList();
            this.f7732s = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: A1 */
        public void m5571A1(ByteString byteString) {
            this.f7719f = byteString.toStringUtf8();
            this.f7715b |= 8;
        }

        /* access modifiers changed from: private */
        /* renamed from: B0 */
        public void m5573B0(Iterable<? extends NamedValue> iterable) {
            m5651h1();
            AbstractMessageLite.addAll(iterable, this.f7732s);
        }

        /* access modifiers changed from: private */
        /* renamed from: B1 */
        public void m5574B1(int i, NamedValue namedValue) {
            namedValue.getClass();
            m5653i1();
            this.f7724k.set(i, namedValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: C0 */
        public void m5576C0(Iterable<? extends NamedValue> iterable) {
            m5653i1();
            AbstractMessageLite.addAll(iterable, this.f7724k);
        }

        /* access modifiers changed from: private */
        /* renamed from: C1 */
        public void m5577C1(ByteString byteString) {
            byteString.getClass();
            this.f7715b |= 2;
            this.f7717d = byteString;
        }

        /* access modifiers changed from: private */
        /* renamed from: D0 */
        public void m5579D0(Iterable<? extends NamedValue> iterable) {
            m5655j1();
            AbstractMessageLite.addAll(iterable, this.f7723j);
        }

        /* access modifiers changed from: private */
        /* renamed from: D1 */
        public void m5580D1(int i) {
            this.f7715b |= 16384;
            this.f7734u = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: E0 */
        public void m5582E0(Iterable<String> iterable) {
            m5657k1();
            AbstractMessageLite.addAll(iterable, this.f7730q);
        }

        /* access modifiers changed from: private */
        /* renamed from: E1 */
        public void m5583E1(String str) {
            str.getClass();
            this.f7715b |= 64;
            this.f7722i = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: F0 */
        public void m5585F0(int i, NamedValue namedValue) {
            namedValue.getClass();
            m5651h1();
            this.f7732s.add(i, namedValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: F1 */
        public void m5586F1(ByteString byteString) {
            this.f7722i = byteString.toStringUtf8();
            this.f7715b |= 64;
        }

        /* access modifiers changed from: private */
        /* renamed from: G0 */
        public void m5588G0(NamedValue namedValue) {
            namedValue.getClass();
            m5651h1();
            this.f7732s.add(namedValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: G1 */
        public void m5589G1(String str) {
            str.getClass();
            this.f7715b |= 32;
            this.f7721h = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: H0 */
        public void m5591H0(int i, NamedValue namedValue) {
            namedValue.getClass();
            m5653i1();
            this.f7724k.add(i, namedValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: H1 */
        public void m5592H1(ByteString byteString) {
            this.f7721h = byteString.toStringUtf8();
            this.f7715b |= 32;
        }

        /* access modifiers changed from: private */
        /* renamed from: I0 */
        public void m5594I0(NamedValue namedValue) {
            namedValue.getClass();
            m5653i1();
            this.f7724k.add(namedValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: I1 */
        public void m5595I1(int i, NamedValue namedValue) {
            namedValue.getClass();
            m5655j1();
            this.f7723j.set(i, namedValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: J0 */
        public void m5597J0(int i, NamedValue namedValue) {
            namedValue.getClass();
            m5655j1();
            this.f7723j.add(i, namedValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: J1 */
        public void m5598J1(String str) {
            str.getClass();
            this.f7715b |= 16;
            this.f7720g = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: K0 */
        public void m5600K0(NamedValue namedValue) {
            namedValue.getClass();
            m5655j1();
            this.f7723j.add(namedValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: K1 */
        public void m5601K1(ByteString byteString) {
            this.f7720g = byteString.toStringUtf8();
            this.f7715b |= 16;
        }

        /* access modifiers changed from: private */
        /* renamed from: L0 */
        public void m5603L0(String str) {
            str.getClass();
            m5657k1();
            this.f7730q.add(str);
        }

        /* access modifiers changed from: private */
        /* renamed from: L1 */
        public void m5604L1(int i) {
            this.f7715b |= 8192;
            this.f7733t = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: M0 */
        public void m5606M0(ByteString byteString) {
            m5657k1();
            this.f7730q.add(byteString.toStringUtf8());
        }

        /* access modifiers changed from: private */
        /* renamed from: M1 */
        public void m5607M1(int i, String str) {
            str.getClass();
            m5657k1();
            this.f7730q.set(i, str);
        }

        /* access modifiers changed from: private */
        /* renamed from: N0 */
        public void m5609N0() {
            this.f7715b &= -32769;
            this.f7735v = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: N1 */
        public void m5610N1(int i) {
            this.f7715b |= 4096;
            this.f7731r = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: O0 */
        public void m5612O0() {
            this.f7732s = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: O1 */
        public void m5613O1(int i) {
            this.f7715b |= 1;
            this.f7716c = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: P0 */
        public void m5615P0() {
            this.f7715b &= -129;
            this.f7725l = getDefaultInstance().getAppCertHash();
        }

        /* access modifiers changed from: private */
        /* renamed from: Q0 */
        public void m5617Q0() {
            this.f7715b &= -1025;
            this.f7728o = getDefaultInstance().getAppInstanceId();
        }

        /* access modifiers changed from: private */
        /* renamed from: R0 */
        public void m5619R0() {
            this.f7715b &= -2049;
            this.f7729p = getDefaultInstance().getAppInstanceIdToken();
        }

        /* access modifiers changed from: private */
        /* renamed from: S0 */
        public void m5621S0() {
            this.f7715b &= -513;
            this.f7727n = getDefaultInstance().getAppVersion();
        }

        /* access modifiers changed from: private */
        /* renamed from: T0 */
        public void m5623T0() {
            this.f7715b &= -257;
            this.f7726m = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: U0 */
        public void m5625U0() {
            this.f7715b &= -5;
            this.f7718e = getDefaultInstance().getCertHash();
        }

        /* access modifiers changed from: private */
        /* renamed from: V0 */
        public void m5627V0() {
            this.f7715b &= -9;
            this.f7719f = getDefaultInstance().getConfigId();
        }

        /* access modifiers changed from: private */
        /* renamed from: W0 */
        public void m5629W0() {
            this.f7724k = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: X0 */
        public void m5631X0() {
            this.f7715b &= -3;
            this.f7717d = getDefaultInstance().getDigest();
        }

        /* access modifiers changed from: private */
        /* renamed from: Y0 */
        public void m5633Y0() {
            this.f7715b &= -16385;
            this.f7734u = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: Z0 */
        public void m5635Z0() {
            this.f7715b &= -65;
            this.f7722i = getDefaultInstance().getGamesProjectId();
        }

        /* access modifiers changed from: private */
        /* renamed from: a1 */
        public void m5637a1() {
            this.f7715b &= -33;
            this.f7721h = getDefaultInstance().getGmpProjectId();
        }

        /* access modifiers changed from: private */
        /* renamed from: b1 */
        public void m5639b1() {
            this.f7723j = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: c1 */
        public void m5641c1() {
            this.f7715b &= -17;
            this.f7720g = getDefaultInstance().getPackageName();
        }

        /* access modifiers changed from: private */
        /* renamed from: d1 */
        public void m5643d1() {
            this.f7715b &= -8193;
            this.f7733t = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: e1 */
        public void m5645e1() {
            this.f7730q = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: f1 */
        public void m5647f1() {
            this.f7715b &= -4097;
            this.f7731r = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: g1 */
        public void m5649g1() {
            this.f7715b &= -2;
            this.f7716c = 0;
        }

        public static PackageData getDefaultInstance() {
            return f7713w;
        }

        /* renamed from: h1 */
        private void m5651h1() {
            if (!this.f7732s.isModifiable()) {
                this.f7732s = GeneratedMessageLite.mutableCopy(this.f7732s);
            }
        }

        /* renamed from: i1 */
        private void m5653i1() {
            if (!this.f7724k.isModifiable()) {
                this.f7724k = GeneratedMessageLite.mutableCopy(this.f7724k);
            }
        }

        /* renamed from: j1 */
        private void m5655j1() {
            if (!this.f7723j.isModifiable()) {
                this.f7723j = GeneratedMessageLite.mutableCopy(this.f7723j);
            }
        }

        /* renamed from: k1 */
        private void m5657k1() {
            if (!this.f7730q.isModifiable()) {
                this.f7730q = GeneratedMessageLite.mutableCopy(this.f7730q);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: l1 */
        public void m5659l1(int i) {
            m5651h1();
            this.f7732s.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: m1 */
        public void m5661m1(int i) {
            m5653i1();
            this.f7724k.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: n1 */
        public void m5663n1(int i) {
            m5655j1();
            this.f7723j.remove(i);
        }

        public static Builder newBuilder() {
            return (Builder) f7713w.createBuilder();
        }

        /* access modifiers changed from: private */
        /* renamed from: o1 */
        public void m5665o1(int i) {
            this.f7715b |= 32768;
            this.f7735v = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: p1 */
        public void m5667p1(int i, NamedValue namedValue) {
            namedValue.getClass();
            m5651h1();
            this.f7732s.set(i, namedValue);
        }

        public static PackageData parseDelimitedFrom(InputStream inputStream) {
            return (PackageData) GeneratedMessageLite.parseDelimitedFrom(f7713w, inputStream);
        }

        public static PackageData parseFrom(ByteBuffer byteBuffer) {
            return (PackageData) GeneratedMessageLite.parseFrom(f7713w, byteBuffer);
        }

        public static Parser<PackageData> parser() {
            return f7713w.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: q1 */
        public void m5670q1(ByteString byteString) {
            byteString.getClass();
            this.f7715b |= 128;
            this.f7725l = byteString;
        }

        /* access modifiers changed from: private */
        /* renamed from: r1 */
        public void m5673r1(String str) {
            str.getClass();
            this.f7715b |= 1024;
            this.f7728o = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: s1 */
        public void m5676s1(ByteString byteString) {
            this.f7728o = byteString.toStringUtf8();
            this.f7715b |= 1024;
        }

        /* access modifiers changed from: private */
        /* renamed from: t1 */
        public void m5679t1(String str) {
            str.getClass();
            this.f7715b |= 2048;
            this.f7729p = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: u1 */
        public void m5682u1(ByteString byteString) {
            this.f7729p = byteString.toStringUtf8();
            this.f7715b |= 2048;
        }

        /* access modifiers changed from: private */
        /* renamed from: v1 */
        public void m5685v1(String str) {
            str.getClass();
            this.f7715b |= 512;
            this.f7727n = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: w1 */
        public void m5688w1(ByteString byteString) {
            this.f7727n = byteString.toStringUtf8();
            this.f7715b |= 512;
        }

        /* access modifiers changed from: private */
        /* renamed from: x1 */
        public void m5691x1(int i) {
            this.f7715b |= 256;
            this.f7726m = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: y1 */
        public void m5694y1(ByteString byteString) {
            byteString.getClass();
            this.f7715b |= 4;
            this.f7718e = byteString;
        }

        /* access modifiers changed from: private */
        /* renamed from: z1 */
        public void m5697z1(String str) {
            str.getClass();
            this.f7715b |= 8;
            this.f7719f = str;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Class<NamedValue> cls = NamedValue.class;
            switch (C1695a.f7742a[methodToInvoke.ordinal()]) {
                case 1:
                    return new PackageData();
                case 2:
                    return new Builder((C1695a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f7713w, "\u0001\u0014\u0000\u0001\u0001\u0014\u0014\u0000\u0004\u0000\u0001\b\u0004\u0002\u0004\u0000\u0003\n\u0001\u0004\n\u0002\u0005\b\u0003\u0006\b\u0005\u0007\b\u0006\b\u001b\t\u001b\n\n\u0007\u000b\u0004\b\f\b\n\r\b\t\u000e\b\u000b\u000f\u001a\u0010\u0004\f\u0011\u001b\u0012\u0004\r\u0013\u0004\u000e\u0014\u0004\u000f", new Object[]{"bitField0_", "packageName_", "versionCode_", "digest_", "certHash_", "configId_", "gmpProjectId_", "gamesProjectId_", "namespaceDigest_", cls, "customVariable_", cls, "appCertHash_", "appVersionCode_", "appInstanceId_", "appVersion_", "appInstanceIdToken_", "requestedHiddenNamespace_", "sdkVersion_", "analyticsUserProperty_", cls, "requestedCacheExpirationSeconds_", "fetchedConfigAgeSeconds_", "activeConfigAgeSeconds_"});
                case 4:
                    return f7713w;
                case 5:
                    Parser<PackageData> parser = f7714x;
                    if (parser == null) {
                        synchronized (PackageData.class) {
                            parser = f7714x;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f7713w);
                                f7714x = parser;
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

        public int getActiveConfigAgeSeconds() {
            return this.f7735v;
        }

        public NamedValue getAnalyticsUserProperty(int i) {
            return this.f7732s.get(i);
        }

        public int getAnalyticsUserPropertyCount() {
            return this.f7732s.size();
        }

        public List<NamedValue> getAnalyticsUserPropertyList() {
            return this.f7732s;
        }

        public NamedValueOrBuilder getAnalyticsUserPropertyOrBuilder(int i) {
            return this.f7732s.get(i);
        }

        public List<? extends NamedValueOrBuilder> getAnalyticsUserPropertyOrBuilderList() {
            return this.f7732s;
        }

        public ByteString getAppCertHash() {
            return this.f7725l;
        }

        public String getAppInstanceId() {
            return this.f7728o;
        }

        public ByteString getAppInstanceIdBytes() {
            return ByteString.copyFromUtf8(this.f7728o);
        }

        public String getAppInstanceIdToken() {
            return this.f7729p;
        }

        public ByteString getAppInstanceIdTokenBytes() {
            return ByteString.copyFromUtf8(this.f7729p);
        }

        public String getAppVersion() {
            return this.f7727n;
        }

        public ByteString getAppVersionBytes() {
            return ByteString.copyFromUtf8(this.f7727n);
        }

        public int getAppVersionCode() {
            return this.f7726m;
        }

        public ByteString getCertHash() {
            return this.f7718e;
        }

        public String getConfigId() {
            return this.f7719f;
        }

        public ByteString getConfigIdBytes() {
            return ByteString.copyFromUtf8(this.f7719f);
        }

        public NamedValue getCustomVariable(int i) {
            return this.f7724k.get(i);
        }

        public int getCustomVariableCount() {
            return this.f7724k.size();
        }

        public List<NamedValue> getCustomVariableList() {
            return this.f7724k;
        }

        public NamedValueOrBuilder getCustomVariableOrBuilder(int i) {
            return this.f7724k.get(i);
        }

        public List<? extends NamedValueOrBuilder> getCustomVariableOrBuilderList() {
            return this.f7724k;
        }

        public ByteString getDigest() {
            return this.f7717d;
        }

        public int getFetchedConfigAgeSeconds() {
            return this.f7734u;
        }

        public String getGamesProjectId() {
            return this.f7722i;
        }

        public ByteString getGamesProjectIdBytes() {
            return ByteString.copyFromUtf8(this.f7722i);
        }

        public String getGmpProjectId() {
            return this.f7721h;
        }

        public ByteString getGmpProjectIdBytes() {
            return ByteString.copyFromUtf8(this.f7721h);
        }

        public NamedValue getNamespaceDigest(int i) {
            return this.f7723j.get(i);
        }

        public int getNamespaceDigestCount() {
            return this.f7723j.size();
        }

        public List<NamedValue> getNamespaceDigestList() {
            return this.f7723j;
        }

        public NamedValueOrBuilder getNamespaceDigestOrBuilder(int i) {
            return this.f7723j.get(i);
        }

        public List<? extends NamedValueOrBuilder> getNamespaceDigestOrBuilderList() {
            return this.f7723j;
        }

        public String getPackageName() {
            return this.f7720g;
        }

        public ByteString getPackageNameBytes() {
            return ByteString.copyFromUtf8(this.f7720g);
        }

        public int getRequestedCacheExpirationSeconds() {
            return this.f7733t;
        }

        public String getRequestedHiddenNamespace(int i) {
            return this.f7730q.get(i);
        }

        public ByteString getRequestedHiddenNamespaceBytes(int i) {
            return ByteString.copyFromUtf8(this.f7730q.get(i));
        }

        public int getRequestedHiddenNamespaceCount() {
            return this.f7730q.size();
        }

        public List<String> getRequestedHiddenNamespaceList() {
            return this.f7730q;
        }

        public int getSdkVersion() {
            return this.f7731r;
        }

        public int getVersionCode() {
            return this.f7716c;
        }

        public boolean hasActiveConfigAgeSeconds() {
            return (this.f7715b & 32768) != 0;
        }

        public boolean hasAppCertHash() {
            return (this.f7715b & 128) != 0;
        }

        public boolean hasAppInstanceId() {
            return (this.f7715b & 1024) != 0;
        }

        public boolean hasAppInstanceIdToken() {
            return (this.f7715b & 2048) != 0;
        }

        public boolean hasAppVersion() {
            return (this.f7715b & 512) != 0;
        }

        public boolean hasAppVersionCode() {
            return (this.f7715b & 256) != 0;
        }

        public boolean hasCertHash() {
            return (this.f7715b & 4) != 0;
        }

        public boolean hasConfigId() {
            return (this.f7715b & 8) != 0;
        }

        public boolean hasDigest() {
            return (this.f7715b & 2) != 0;
        }

        public boolean hasFetchedConfigAgeSeconds() {
            return (this.f7715b & 16384) != 0;
        }

        public boolean hasGamesProjectId() {
            return (this.f7715b & 64) != 0;
        }

        public boolean hasGmpProjectId() {
            return (this.f7715b & 32) != 0;
        }

        public boolean hasPackageName() {
            return (this.f7715b & 16) != 0;
        }

        public boolean hasRequestedCacheExpirationSeconds() {
            return (this.f7715b & 8192) != 0;
        }

        public boolean hasSdkVersion() {
            return (this.f7715b & 4096) != 0;
        }

        public boolean hasVersionCode() {
            return (this.f7715b & 1) != 0;
        }

        public static Builder newBuilder(PackageData packageData) {
            return (Builder) f7713w.createBuilder(packageData);
        }

        public static PackageData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageData) GeneratedMessageLite.parseDelimitedFrom(f7713w, inputStream, extensionRegistryLite);
        }

        public static PackageData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageData) GeneratedMessageLite.parseFrom(f7713w, byteBuffer, extensionRegistryLite);
        }

        public static PackageData parseFrom(ByteString byteString) {
            return (PackageData) GeneratedMessageLite.parseFrom(f7713w, byteString);
        }

        public static PackageData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageData) GeneratedMessageLite.parseFrom(f7713w, byteString, extensionRegistryLite);
        }

        public static PackageData parseFrom(byte[] bArr) {
            return (PackageData) GeneratedMessageLite.parseFrom(f7713w, bArr);
        }

        public static PackageData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageData) GeneratedMessageLite.parseFrom(f7713w, bArr, extensionRegistryLite);
        }

        public static PackageData parseFrom(InputStream inputStream) {
            return (PackageData) GeneratedMessageLite.parseFrom(f7713w, inputStream);
        }

        public static PackageData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageData) GeneratedMessageLite.parseFrom(f7713w, inputStream, extensionRegistryLite);
        }

        public static PackageData parseFrom(CodedInputStream codedInputStream) {
            return (PackageData) GeneratedMessageLite.parseFrom(f7713w, codedInputStream);
        }

        public static PackageData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageData) GeneratedMessageLite.parseFrom(f7713w, codedInputStream, extensionRegistryLite);
        }
    }

    public interface PackageDataOrBuilder extends MessageLiteOrBuilder {
        int getActiveConfigAgeSeconds();

        NamedValue getAnalyticsUserProperty(int i);

        int getAnalyticsUserPropertyCount();

        List<NamedValue> getAnalyticsUserPropertyList();

        ByteString getAppCertHash();

        String getAppInstanceId();

        ByteString getAppInstanceIdBytes();

        String getAppInstanceIdToken();

        ByteString getAppInstanceIdTokenBytes();

        String getAppVersion();

        ByteString getAppVersionBytes();

        int getAppVersionCode();

        ByteString getCertHash();

        String getConfigId();

        ByteString getConfigIdBytes();

        NamedValue getCustomVariable(int i);

        int getCustomVariableCount();

        List<NamedValue> getCustomVariableList();

        ByteString getDigest();

        int getFetchedConfigAgeSeconds();

        String getGamesProjectId();

        ByteString getGamesProjectIdBytes();

        String getGmpProjectId();

        ByteString getGmpProjectIdBytes();

        NamedValue getNamespaceDigest(int i);

        int getNamespaceDigestCount();

        List<NamedValue> getNamespaceDigestList();

        String getPackageName();

        ByteString getPackageNameBytes();

        int getRequestedCacheExpirationSeconds();

        String getRequestedHiddenNamespace(int i);

        ByteString getRequestedHiddenNamespaceBytes(int i);

        int getRequestedHiddenNamespaceCount();

        List<String> getRequestedHiddenNamespaceList();

        int getSdkVersion();

        int getVersionCode();

        boolean hasActiveConfigAgeSeconds();

        boolean hasAppCertHash();

        boolean hasAppInstanceId();

        boolean hasAppInstanceIdToken();

        boolean hasAppVersion();

        boolean hasAppVersionCode();

        boolean hasCertHash();

        boolean hasConfigId();

        boolean hasDigest();

        boolean hasFetchedConfigAgeSeconds();

        boolean hasGamesProjectId();

        boolean hasGmpProjectId();

        boolean hasPackageName();

        boolean hasRequestedCacheExpirationSeconds();

        boolean hasSdkVersion();

        boolean hasVersionCode();
    }

    public static final class PackageTable extends GeneratedMessageLite<PackageTable, Builder> implements PackageTableOrBuilder {
        public static final int CONFIG_ID_FIELD_NUMBER = 3;
        public static final int ENTRY_FIELD_NUMBER = 2;
        public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public static final PackageTable f7736f;

        /* renamed from: g */
        private static volatile Parser<PackageTable> f7737g;

        /* renamed from: b */
        private int f7738b;

        /* renamed from: c */
        private String f7739c = "";

        /* renamed from: d */
        private Internal.ProtobufList<KeyValue> f7740d = GeneratedMessageLite.emptyProtobufList();

        /* renamed from: e */
        private String f7741e = "";

        public static final class Builder extends GeneratedMessageLite.Builder<PackageTable, Builder> implements PackageTableOrBuilder {
            /* synthetic */ Builder(C1695a aVar) {
                this();
            }

            public Builder addAllEntry(Iterable<? extends KeyValue> iterable) {
                copyOnWrite();
                ((PackageTable) this.instance).m5701D(iterable);
                return this;
            }

            public Builder addEntry(KeyValue keyValue) {
                copyOnWrite();
                ((PackageTable) this.instance).m5703F(keyValue);
                return this;
            }

            public Builder clearConfigId() {
                copyOnWrite();
                ((PackageTable) this.instance).m5704G();
                return this;
            }

            public Builder clearEntry() {
                copyOnWrite();
                ((PackageTable) this.instance).m5705H();
                return this;
            }

            public Builder clearPackageName() {
                copyOnWrite();
                ((PackageTable) this.instance).m5706I();
                return this;
            }

            public String getConfigId() {
                return ((PackageTable) this.instance).getConfigId();
            }

            public ByteString getConfigIdBytes() {
                return ((PackageTable) this.instance).getConfigIdBytes();
            }

            public KeyValue getEntry(int i) {
                return ((PackageTable) this.instance).getEntry(i);
            }

            public int getEntryCount() {
                return ((PackageTable) this.instance).getEntryCount();
            }

            public List<KeyValue> getEntryList() {
                return Collections.unmodifiableList(((PackageTable) this.instance).getEntryList());
            }

            public String getPackageName() {
                return ((PackageTable) this.instance).getPackageName();
            }

            public ByteString getPackageNameBytes() {
                return ((PackageTable) this.instance).getPackageNameBytes();
            }

            public boolean hasConfigId() {
                return ((PackageTable) this.instance).hasConfigId();
            }

            public boolean hasPackageName() {
                return ((PackageTable) this.instance).hasPackageName();
            }

            public Builder removeEntry(int i) {
                copyOnWrite();
                ((PackageTable) this.instance).m5708K(i);
                return this;
            }

            public Builder setConfigId(String str) {
                copyOnWrite();
                ((PackageTable) this.instance).m5709L(str);
                return this;
            }

            public Builder setConfigIdBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageTable) this.instance).m5710M(byteString);
                return this;
            }

            public Builder setEntry(int i, KeyValue keyValue) {
                copyOnWrite();
                ((PackageTable) this.instance).m5711N(i, keyValue);
                return this;
            }

            public Builder setPackageName(String str) {
                copyOnWrite();
                ((PackageTable) this.instance).m5712O(str);
                return this;
            }

            public Builder setPackageNameBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageTable) this.instance).m5713P(byteString);
                return this;
            }

            private Builder() {
                super(PackageTable.f7736f);
            }

            public Builder addEntry(int i, KeyValue keyValue) {
                copyOnWrite();
                ((PackageTable) this.instance).m5702E(i, keyValue);
                return this;
            }

            public Builder setEntry(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((PackageTable) this.instance).m5711N(i, (KeyValue) builder.build());
                return this;
            }

            public Builder addEntry(KeyValue.Builder builder) {
                copyOnWrite();
                ((PackageTable) this.instance).m5703F((KeyValue) builder.build());
                return this;
            }

            public Builder addEntry(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((PackageTable) this.instance).m5702E(i, (KeyValue) builder.build());
                return this;
            }
        }

        static {
            PackageTable packageTable = new PackageTable();
            f7736f = packageTable;
            GeneratedMessageLite.registerDefaultInstance(PackageTable.class, packageTable);
        }

        private PackageTable() {
        }

        /* access modifiers changed from: private */
        /* renamed from: D */
        public void m5701D(Iterable<? extends KeyValue> iterable) {
            m5707J();
            AbstractMessageLite.addAll(iterable, this.f7740d);
        }

        /* access modifiers changed from: private */
        /* renamed from: E */
        public void m5702E(int i, KeyValue keyValue) {
            keyValue.getClass();
            m5707J();
            this.f7740d.add(i, keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: F */
        public void m5703F(KeyValue keyValue) {
            keyValue.getClass();
            m5707J();
            this.f7740d.add(keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: G */
        public void m5704G() {
            this.f7738b &= -3;
            this.f7741e = getDefaultInstance().getConfigId();
        }

        /* access modifiers changed from: private */
        /* renamed from: H */
        public void m5705H() {
            this.f7740d = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: I */
        public void m5706I() {
            this.f7738b &= -2;
            this.f7739c = getDefaultInstance().getPackageName();
        }

        /* renamed from: J */
        private void m5707J() {
            if (!this.f7740d.isModifiable()) {
                this.f7740d = GeneratedMessageLite.mutableCopy(this.f7740d);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: K */
        public void m5708K(int i) {
            m5707J();
            this.f7740d.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: L */
        public void m5709L(String str) {
            str.getClass();
            this.f7738b |= 2;
            this.f7741e = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: M */
        public void m5710M(ByteString byteString) {
            this.f7741e = byteString.toStringUtf8();
            this.f7738b |= 2;
        }

        /* access modifiers changed from: private */
        /* renamed from: N */
        public void m5711N(int i, KeyValue keyValue) {
            keyValue.getClass();
            m5707J();
            this.f7740d.set(i, keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: O */
        public void m5712O(String str) {
            str.getClass();
            this.f7738b |= 1;
            this.f7739c = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: P */
        public void m5713P(ByteString byteString) {
            this.f7739c = byteString.toStringUtf8();
            this.f7738b |= 1;
        }

        public static PackageTable getDefaultInstance() {
            return f7736f;
        }

        public static Builder newBuilder() {
            return (Builder) f7736f.createBuilder();
        }

        public static PackageTable parseDelimitedFrom(InputStream inputStream) {
            return (PackageTable) GeneratedMessageLite.parseDelimitedFrom(f7736f, inputStream);
        }

        public static PackageTable parseFrom(ByteBuffer byteBuffer) {
            return (PackageTable) GeneratedMessageLite.parseFrom(f7736f, byteBuffer);
        }

        public static Parser<PackageTable> parser() {
            return f7736f.getParserForType();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C1695a.f7742a[methodToInvoke.ordinal()]) {
                case 1:
                    return new PackageTable();
                case 2:
                    return new Builder((C1695a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f7736f, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b\u0003\b\u0001", new Object[]{"bitField0_", "packageName_", "entry_", KeyValue.class, "configId_"});
                case 4:
                    return f7736f;
                case 5:
                    Parser<PackageTable> parser = f7737g;
                    if (parser == null) {
                        synchronized (PackageTable.class) {
                            parser = f7737g;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f7736f);
                                f7737g = parser;
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

        public String getConfigId() {
            return this.f7741e;
        }

        public ByteString getConfigIdBytes() {
            return ByteString.copyFromUtf8(this.f7741e);
        }

        public KeyValue getEntry(int i) {
            return this.f7740d.get(i);
        }

        public int getEntryCount() {
            return this.f7740d.size();
        }

        public List<KeyValue> getEntryList() {
            return this.f7740d;
        }

        public KeyValueOrBuilder getEntryOrBuilder(int i) {
            return this.f7740d.get(i);
        }

        public List<? extends KeyValueOrBuilder> getEntryOrBuilderList() {
            return this.f7740d;
        }

        public String getPackageName() {
            return this.f7739c;
        }

        public ByteString getPackageNameBytes() {
            return ByteString.copyFromUtf8(this.f7739c);
        }

        public boolean hasConfigId() {
            return (this.f7738b & 2) != 0;
        }

        public boolean hasPackageName() {
            return (this.f7738b & 1) != 0;
        }

        public static Builder newBuilder(PackageTable packageTable) {
            return (Builder) f7736f.createBuilder(packageTable);
        }

        public static PackageTable parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageTable) GeneratedMessageLite.parseDelimitedFrom(f7736f, inputStream, extensionRegistryLite);
        }

        public static PackageTable parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageTable) GeneratedMessageLite.parseFrom(f7736f, byteBuffer, extensionRegistryLite);
        }

        public static PackageTable parseFrom(ByteString byteString) {
            return (PackageTable) GeneratedMessageLite.parseFrom(f7736f, byteString);
        }

        public static PackageTable parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageTable) GeneratedMessageLite.parseFrom(f7736f, byteString, extensionRegistryLite);
        }

        public static PackageTable parseFrom(byte[] bArr) {
            return (PackageTable) GeneratedMessageLite.parseFrom(f7736f, bArr);
        }

        public static PackageTable parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageTable) GeneratedMessageLite.parseFrom(f7736f, bArr, extensionRegistryLite);
        }

        public static PackageTable parseFrom(InputStream inputStream) {
            return (PackageTable) GeneratedMessageLite.parseFrom(f7736f, inputStream);
        }

        public static PackageTable parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageTable) GeneratedMessageLite.parseFrom(f7736f, inputStream, extensionRegistryLite);
        }

        public static PackageTable parseFrom(CodedInputStream codedInputStream) {
            return (PackageTable) GeneratedMessageLite.parseFrom(f7736f, codedInputStream);
        }

        public static PackageTable parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PackageTable) GeneratedMessageLite.parseFrom(f7736f, codedInputStream, extensionRegistryLite);
        }
    }

    public interface PackageTableOrBuilder extends MessageLiteOrBuilder {
        String getConfigId();

        ByteString getConfigIdBytes();

        KeyValue getEntry(int i);

        int getEntryCount();

        List<KeyValue> getEntryList();

        String getPackageName();

        ByteString getPackageNameBytes();

        boolean hasConfigId();

        boolean hasPackageName();
    }

    /* renamed from: com.google.android.gms.config.proto.Config$a */
    static /* synthetic */ class C1695a {

        /* renamed from: a */
        static final /* synthetic */ int[] f7742a;

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
                f7742a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7742a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7742a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7742a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7742a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7742a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7742a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.config.proto.Config.C1695a.<clinit>():void");
        }
    }

    private Config() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
