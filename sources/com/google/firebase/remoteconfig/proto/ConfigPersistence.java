package com.google.firebase.remoteconfig.proto;

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

public final class ConfigPersistence {

    public static final class ConfigHolder extends GeneratedMessageLite<ConfigHolder, Builder> implements ConfigHolderOrBuilder {
        public static final int EXPERIMENT_PAYLOAD_FIELD_NUMBER = 3;
        public static final int NAMESPACE_KEY_VALUE_FIELD_NUMBER = 1;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public static final ConfigHolder f20300f;

        /* renamed from: g */
        private static volatile Parser<ConfigHolder> f20301g;

        /* renamed from: b */
        private int f20302b;

        /* renamed from: c */
        private Internal.ProtobufList<NamespaceKeyValue> f20303c = GeneratedMessageLite.emptyProtobufList();

        /* renamed from: d */
        private long f20304d;

        /* renamed from: e */
        private Internal.ProtobufList<ByteString> f20305e = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<ConfigHolder, Builder> implements ConfigHolderOrBuilder {
            /* synthetic */ Builder(C3595a aVar) {
                this();
            }

            public Builder addAllExperimentPayload(Iterable<? extends ByteString> iterable) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12192D(iterable);
                return this;
            }

            public Builder addAllNamespaceKeyValue(Iterable<? extends NamespaceKeyValue> iterable) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12193E(iterable);
                return this;
            }

            public Builder addExperimentPayload(ByteString byteString) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12194F(byteString);
                return this;
            }

            public Builder addNamespaceKeyValue(NamespaceKeyValue namespaceKeyValue) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12196H(namespaceKeyValue);
                return this;
            }

            public Builder clearExperimentPayload() {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12197I();
                return this;
            }

            public Builder clearNamespaceKeyValue() {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12198J();
                return this;
            }

            public Builder clearTimestamp() {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12199K();
                return this;
            }

            public ByteString getExperimentPayload(int i) {
                return ((ConfigHolder) this.instance).getExperimentPayload(i);
            }

            public int getExperimentPayloadCount() {
                return ((ConfigHolder) this.instance).getExperimentPayloadCount();
            }

            public List<ByteString> getExperimentPayloadList() {
                return Collections.unmodifiableList(((ConfigHolder) this.instance).getExperimentPayloadList());
            }

            public NamespaceKeyValue getNamespaceKeyValue(int i) {
                return ((ConfigHolder) this.instance).getNamespaceKeyValue(i);
            }

            public int getNamespaceKeyValueCount() {
                return ((ConfigHolder) this.instance).getNamespaceKeyValueCount();
            }

            public List<NamespaceKeyValue> getNamespaceKeyValueList() {
                return Collections.unmodifiableList(((ConfigHolder) this.instance).getNamespaceKeyValueList());
            }

            public long getTimestamp() {
                return ((ConfigHolder) this.instance).getTimestamp();
            }

            public boolean hasTimestamp() {
                return ((ConfigHolder) this.instance).hasTimestamp();
            }

            public Builder removeNamespaceKeyValue(int i) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12202N(i);
                return this;
            }

            public Builder setExperimentPayload(int i, ByteString byteString) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12203O(i, byteString);
                return this;
            }

            public Builder setNamespaceKeyValue(int i, NamespaceKeyValue namespaceKeyValue) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12204P(i, namespaceKeyValue);
                return this;
            }

            public Builder setTimestamp(long j) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12205Q(j);
                return this;
            }

            private Builder() {
                super(ConfigHolder.f20300f);
            }

            public Builder addNamespaceKeyValue(int i, NamespaceKeyValue namespaceKeyValue) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12195G(i, namespaceKeyValue);
                return this;
            }

            public Builder setNamespaceKeyValue(int i, NamespaceKeyValue.Builder builder) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12204P(i, (NamespaceKeyValue) builder.build());
                return this;
            }

            public Builder addNamespaceKeyValue(NamespaceKeyValue.Builder builder) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12196H((NamespaceKeyValue) builder.build());
                return this;
            }

            public Builder addNamespaceKeyValue(int i, NamespaceKeyValue.Builder builder) {
                copyOnWrite();
                ((ConfigHolder) this.instance).m12195G(i, (NamespaceKeyValue) builder.build());
                return this;
            }
        }

        static {
            ConfigHolder configHolder = new ConfigHolder();
            f20300f = configHolder;
            GeneratedMessageLite.registerDefaultInstance(ConfigHolder.class, configHolder);
        }

        private ConfigHolder() {
        }

        /* access modifiers changed from: private */
        /* renamed from: D */
        public void m12192D(Iterable<? extends ByteString> iterable) {
            m12200L();
            AbstractMessageLite.addAll(iterable, this.f20305e);
        }

        /* access modifiers changed from: private */
        /* renamed from: E */
        public void m12193E(Iterable<? extends NamespaceKeyValue> iterable) {
            m12201M();
            AbstractMessageLite.addAll(iterable, this.f20303c);
        }

        /* access modifiers changed from: private */
        /* renamed from: F */
        public void m12194F(ByteString byteString) {
            byteString.getClass();
            m12200L();
            this.f20305e.add(byteString);
        }

        /* access modifiers changed from: private */
        /* renamed from: G */
        public void m12195G(int i, NamespaceKeyValue namespaceKeyValue) {
            namespaceKeyValue.getClass();
            m12201M();
            this.f20303c.add(i, namespaceKeyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: H */
        public void m12196H(NamespaceKeyValue namespaceKeyValue) {
            namespaceKeyValue.getClass();
            m12201M();
            this.f20303c.add(namespaceKeyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: I */
        public void m12197I() {
            this.f20305e = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: J */
        public void m12198J() {
            this.f20303c = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: K */
        public void m12199K() {
            this.f20302b &= -2;
            this.f20304d = 0;
        }

        /* renamed from: L */
        private void m12200L() {
            if (!this.f20305e.isModifiable()) {
                this.f20305e = GeneratedMessageLite.mutableCopy(this.f20305e);
            }
        }

        /* renamed from: M */
        private void m12201M() {
            if (!this.f20303c.isModifiable()) {
                this.f20303c = GeneratedMessageLite.mutableCopy(this.f20303c);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: N */
        public void m12202N(int i) {
            m12201M();
            this.f20303c.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: O */
        public void m12203O(int i, ByteString byteString) {
            byteString.getClass();
            m12200L();
            this.f20305e.set(i, byteString);
        }

        /* access modifiers changed from: private */
        /* renamed from: P */
        public void m12204P(int i, NamespaceKeyValue namespaceKeyValue) {
            namespaceKeyValue.getClass();
            m12201M();
            this.f20303c.set(i, namespaceKeyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: Q */
        public void m12205Q(long j) {
            this.f20302b |= 1;
            this.f20304d = j;
        }

        public static ConfigHolder getDefaultInstance() {
            return f20300f;
        }

        public static Builder newBuilder() {
            return (Builder) f20300f.createBuilder();
        }

        public static ConfigHolder parseDelimitedFrom(InputStream inputStream) {
            return (ConfigHolder) GeneratedMessageLite.parseDelimitedFrom(f20300f, inputStream);
        }

        public static ConfigHolder parseFrom(ByteBuffer byteBuffer) {
            return (ConfigHolder) GeneratedMessageLite.parseFrom(f20300f, byteBuffer);
        }

        public static Parser<ConfigHolder> parser() {
            return f20300f.getParserForType();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C3595a.f20336a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ConfigHolder();
                case 2:
                    return new Builder((C3595a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f20300f, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u0005\u0000\u0003\u001c", new Object[]{"bitField0_", "namespaceKeyValue_", NamespaceKeyValue.class, "timestamp_", "experimentPayload_"});
                case 4:
                    return f20300f;
                case 5:
                    Parser<ConfigHolder> parser = f20301g;
                    if (parser == null) {
                        synchronized (ConfigHolder.class) {
                            parser = f20301g;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20300f);
                                f20301g = parser;
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

        public ByteString getExperimentPayload(int i) {
            return this.f20305e.get(i);
        }

        public int getExperimentPayloadCount() {
            return this.f20305e.size();
        }

        public List<ByteString> getExperimentPayloadList() {
            return this.f20305e;
        }

        public NamespaceKeyValue getNamespaceKeyValue(int i) {
            return this.f20303c.get(i);
        }

        public int getNamespaceKeyValueCount() {
            return this.f20303c.size();
        }

        public List<NamespaceKeyValue> getNamespaceKeyValueList() {
            return this.f20303c;
        }

        public NamespaceKeyValueOrBuilder getNamespaceKeyValueOrBuilder(int i) {
            return this.f20303c.get(i);
        }

        public List<? extends NamespaceKeyValueOrBuilder> getNamespaceKeyValueOrBuilderList() {
            return this.f20303c;
        }

        public long getTimestamp() {
            return this.f20304d;
        }

        public boolean hasTimestamp() {
            return (this.f20302b & 1) != 0;
        }

        public static Builder newBuilder(ConfigHolder configHolder) {
            return (Builder) f20300f.createBuilder(configHolder);
        }

        public static ConfigHolder parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigHolder) GeneratedMessageLite.parseDelimitedFrom(f20300f, inputStream, extensionRegistryLite);
        }

        public static ConfigHolder parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigHolder) GeneratedMessageLite.parseFrom(f20300f, byteBuffer, extensionRegistryLite);
        }

        public static ConfigHolder parseFrom(ByteString byteString) {
            return (ConfigHolder) GeneratedMessageLite.parseFrom(f20300f, byteString);
        }

        public static ConfigHolder parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigHolder) GeneratedMessageLite.parseFrom(f20300f, byteString, extensionRegistryLite);
        }

        public static ConfigHolder parseFrom(byte[] bArr) {
            return (ConfigHolder) GeneratedMessageLite.parseFrom(f20300f, bArr);
        }

        public static ConfigHolder parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigHolder) GeneratedMessageLite.parseFrom(f20300f, bArr, extensionRegistryLite);
        }

        public static ConfigHolder parseFrom(InputStream inputStream) {
            return (ConfigHolder) GeneratedMessageLite.parseFrom(f20300f, inputStream);
        }

        public static ConfigHolder parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigHolder) GeneratedMessageLite.parseFrom(f20300f, inputStream, extensionRegistryLite);
        }

        public static ConfigHolder parseFrom(CodedInputStream codedInputStream) {
            return (ConfigHolder) GeneratedMessageLite.parseFrom(f20300f, codedInputStream);
        }

        public static ConfigHolder parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ConfigHolder) GeneratedMessageLite.parseFrom(f20300f, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ConfigHolderOrBuilder extends MessageLiteOrBuilder {
        ByteString getExperimentPayload(int i);

        int getExperimentPayloadCount();

        List<ByteString> getExperimentPayloadList();

        NamespaceKeyValue getNamespaceKeyValue(int i);

        int getNamespaceKeyValueCount();

        List<NamespaceKeyValue> getNamespaceKeyValueList();

        long getTimestamp();

        boolean hasTimestamp();
    }

    public static final class KeyValue extends GeneratedMessageLite<KeyValue, Builder> implements KeyValueOrBuilder {
        public static final int KEY_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public static final KeyValue f20306e;

        /* renamed from: f */
        private static volatile Parser<KeyValue> f20307f;

        /* renamed from: b */
        private int f20308b;

        /* renamed from: c */
        private String f20309c = "";

        /* renamed from: d */
        private ByteString f20310d = ByteString.EMPTY;

        public static final class Builder extends GeneratedMessageLite.Builder<KeyValue, Builder> implements KeyValueOrBuilder {
            /* synthetic */ Builder(C3595a aVar) {
                this();
            }

            public Builder clearKey() {
                copyOnWrite();
                ((KeyValue) this.instance).m12223w();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((KeyValue) this.instance).m12224x();
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
                ((KeyValue) this.instance).m12225y(str);
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((KeyValue) this.instance).m12226z(byteString);
                return this;
            }

            public Builder setValue(ByteString byteString) {
                copyOnWrite();
                ((KeyValue) this.instance).m12216A(byteString);
                return this;
            }

            private Builder() {
                super(KeyValue.f20306e);
            }
        }

        static {
            KeyValue keyValue = new KeyValue();
            f20306e = keyValue;
            GeneratedMessageLite.registerDefaultInstance(KeyValue.class, keyValue);
        }

        private KeyValue() {
        }

        /* access modifiers changed from: private */
        /* renamed from: A */
        public void m12216A(ByteString byteString) {
            byteString.getClass();
            this.f20308b |= 2;
            this.f20310d = byteString;
        }

        public static KeyValue getDefaultInstance() {
            return f20306e;
        }

        public static Builder newBuilder() {
            return (Builder) f20306e.createBuilder();
        }

        public static KeyValue parseDelimitedFrom(InputStream inputStream) {
            return (KeyValue) GeneratedMessageLite.parseDelimitedFrom(f20306e, inputStream);
        }

        public static KeyValue parseFrom(ByteBuffer byteBuffer) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f20306e, byteBuffer);
        }

        public static Parser<KeyValue> parser() {
            return f20306e.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: w */
        public void m12223w() {
            this.f20308b &= -2;
            this.f20309c = getDefaultInstance().getKey();
        }

        /* access modifiers changed from: private */
        /* renamed from: x */
        public void m12224x() {
            this.f20308b &= -3;
            this.f20310d = getDefaultInstance().getValue();
        }

        /* access modifiers changed from: private */
        /* renamed from: y */
        public void m12225y(String str) {
            str.getClass();
            this.f20308b |= 1;
            this.f20309c = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: z */
        public void m12226z(ByteString byteString) {
            this.f20309c = byteString.toStringUtf8();
            this.f20308b |= 1;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C3595a.f20336a[methodToInvoke.ordinal()]) {
                case 1:
                    return new KeyValue();
                case 2:
                    return new Builder((C3595a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f20306e, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "key_", "value_"});
                case 4:
                    return f20306e;
                case 5:
                    Parser<KeyValue> parser = f20307f;
                    if (parser == null) {
                        synchronized (KeyValue.class) {
                            parser = f20307f;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20306e);
                                f20307f = parser;
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
            return this.f20309c;
        }

        public ByteString getKeyBytes() {
            return ByteString.copyFromUtf8(this.f20309c);
        }

        public ByteString getValue() {
            return this.f20310d;
        }

        public boolean hasKey() {
            return (this.f20308b & 1) != 0;
        }

        public boolean hasValue() {
            return (this.f20308b & 2) != 0;
        }

        public static Builder newBuilder(KeyValue keyValue) {
            return (Builder) f20306e.createBuilder(keyValue);
        }

        public static KeyValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseDelimitedFrom(f20306e, inputStream, extensionRegistryLite);
        }

        public static KeyValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f20306e, byteBuffer, extensionRegistryLite);
        }

        public static KeyValue parseFrom(ByteString byteString) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f20306e, byteString);
        }

        public static KeyValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f20306e, byteString, extensionRegistryLite);
        }

        public static KeyValue parseFrom(byte[] bArr) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f20306e, bArr);
        }

        public static KeyValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f20306e, bArr, extensionRegistryLite);
        }

        public static KeyValue parseFrom(InputStream inputStream) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f20306e, inputStream);
        }

        public static KeyValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f20306e, inputStream, extensionRegistryLite);
        }

        public static KeyValue parseFrom(CodedInputStream codedInputStream) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f20306e, codedInputStream);
        }

        public static KeyValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValue) GeneratedMessageLite.parseFrom(f20306e, codedInputStream, extensionRegistryLite);
        }
    }

    public interface KeyValueOrBuilder extends MessageLiteOrBuilder {
        String getKey();

        ByteString getKeyBytes();

        ByteString getValue();

        boolean hasKey();

        boolean hasValue();
    }

    public static final class Metadata extends GeneratedMessageLite<Metadata, Builder> implements MetadataOrBuilder {
        public static final int DEVELOPER_MODE_ENABLED_FIELD_NUMBER = 2;
        public static final int LAST_FETCH_STATUS_FIELD_NUMBER = 1;
        public static final int LAST_KNOWN_EXPERIMENT_START_TIME_FIELD_NUMBER = 3;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public static final Metadata f20311f;

        /* renamed from: g */
        private static volatile Parser<Metadata> f20312g;

        /* renamed from: b */
        private int f20313b;

        /* renamed from: c */
        private int f20314c;

        /* renamed from: d */
        private boolean f20315d;

        /* renamed from: e */
        private long f20316e;

        public static final class Builder extends GeneratedMessageLite.Builder<Metadata, Builder> implements MetadataOrBuilder {
            /* synthetic */ Builder(C3595a aVar) {
                this();
            }

            public Builder clearDeveloperModeEnabled() {
                copyOnWrite();
                ((Metadata) this.instance).m12237x();
                return this;
            }

            public Builder clearLastFetchStatus() {
                copyOnWrite();
                ((Metadata) this.instance).m12238y();
                return this;
            }

            public Builder clearLastKnownExperimentStartTime() {
                copyOnWrite();
                ((Metadata) this.instance).m12239z();
                return this;
            }

            public boolean getDeveloperModeEnabled() {
                return ((Metadata) this.instance).getDeveloperModeEnabled();
            }

            public int getLastFetchStatus() {
                return ((Metadata) this.instance).getLastFetchStatus();
            }

            public long getLastKnownExperimentStartTime() {
                return ((Metadata) this.instance).getLastKnownExperimentStartTime();
            }

            public boolean hasDeveloperModeEnabled() {
                return ((Metadata) this.instance).hasDeveloperModeEnabled();
            }

            public boolean hasLastFetchStatus() {
                return ((Metadata) this.instance).hasLastFetchStatus();
            }

            public boolean hasLastKnownExperimentStartTime() {
                return ((Metadata) this.instance).hasLastKnownExperimentStartTime();
            }

            public Builder setDeveloperModeEnabled(boolean z) {
                copyOnWrite();
                ((Metadata) this.instance).m12227A(z);
                return this;
            }

            public Builder setLastFetchStatus(int i) {
                copyOnWrite();
                ((Metadata) this.instance).m12228B(i);
                return this;
            }

            public Builder setLastKnownExperimentStartTime(long j) {
                copyOnWrite();
                ((Metadata) this.instance).m12229C(j);
                return this;
            }

            private Builder() {
                super(Metadata.f20311f);
            }
        }

        static {
            Metadata metadata = new Metadata();
            f20311f = metadata;
            GeneratedMessageLite.registerDefaultInstance(Metadata.class, metadata);
        }

        private Metadata() {
        }

        /* access modifiers changed from: private */
        /* renamed from: A */
        public void m12227A(boolean z) {
            this.f20313b |= 2;
            this.f20315d = z;
        }

        /* access modifiers changed from: private */
        /* renamed from: B */
        public void m12228B(int i) {
            this.f20313b |= 1;
            this.f20314c = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: C */
        public void m12229C(long j) {
            this.f20313b |= 4;
            this.f20316e = j;
        }

        public static Metadata getDefaultInstance() {
            return f20311f;
        }

        public static Builder newBuilder() {
            return (Builder) f20311f.createBuilder();
        }

        public static Metadata parseDelimitedFrom(InputStream inputStream) {
            return (Metadata) GeneratedMessageLite.parseDelimitedFrom(f20311f, inputStream);
        }

        public static Metadata parseFrom(ByteBuffer byteBuffer) {
            return (Metadata) GeneratedMessageLite.parseFrom(f20311f, byteBuffer);
        }

        public static Parser<Metadata> parser() {
            return f20311f.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: x */
        public void m12237x() {
            this.f20313b &= -3;
            this.f20315d = false;
        }

        /* access modifiers changed from: private */
        /* renamed from: y */
        public void m12238y() {
            this.f20313b &= -2;
            this.f20314c = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: z */
        public void m12239z() {
            this.f20313b &= -5;
            this.f20316e = 0;
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C3595a.f20336a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Metadata();
                case 2:
                    return new Builder((C3595a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f20311f, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0007\u0001\u0003\u0005\u0002", new Object[]{"bitField0_", "lastFetchStatus_", "developerModeEnabled_", "lastKnownExperimentStartTime_"});
                case 4:
                    return f20311f;
                case 5:
                    Parser<Metadata> parser = f20312g;
                    if (parser == null) {
                        synchronized (Metadata.class) {
                            parser = f20312g;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20311f);
                                f20312g = parser;
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

        public boolean getDeveloperModeEnabled() {
            return this.f20315d;
        }

        public int getLastFetchStatus() {
            return this.f20314c;
        }

        public long getLastKnownExperimentStartTime() {
            return this.f20316e;
        }

        public boolean hasDeveloperModeEnabled() {
            return (this.f20313b & 2) != 0;
        }

        public boolean hasLastFetchStatus() {
            return (this.f20313b & 1) != 0;
        }

        public boolean hasLastKnownExperimentStartTime() {
            return (this.f20313b & 4) != 0;
        }

        public static Builder newBuilder(Metadata metadata) {
            return (Builder) f20311f.createBuilder(metadata);
        }

        public static Metadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Metadata) GeneratedMessageLite.parseDelimitedFrom(f20311f, inputStream, extensionRegistryLite);
        }

        public static Metadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Metadata) GeneratedMessageLite.parseFrom(f20311f, byteBuffer, extensionRegistryLite);
        }

        public static Metadata parseFrom(ByteString byteString) {
            return (Metadata) GeneratedMessageLite.parseFrom(f20311f, byteString);
        }

        public static Metadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Metadata) GeneratedMessageLite.parseFrom(f20311f, byteString, extensionRegistryLite);
        }

        public static Metadata parseFrom(byte[] bArr) {
            return (Metadata) GeneratedMessageLite.parseFrom(f20311f, bArr);
        }

        public static Metadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Metadata) GeneratedMessageLite.parseFrom(f20311f, bArr, extensionRegistryLite);
        }

        public static Metadata parseFrom(InputStream inputStream) {
            return (Metadata) GeneratedMessageLite.parseFrom(f20311f, inputStream);
        }

        public static Metadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Metadata) GeneratedMessageLite.parseFrom(f20311f, inputStream, extensionRegistryLite);
        }

        public static Metadata parseFrom(CodedInputStream codedInputStream) {
            return (Metadata) GeneratedMessageLite.parseFrom(f20311f, codedInputStream);
        }

        public static Metadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Metadata) GeneratedMessageLite.parseFrom(f20311f, codedInputStream, extensionRegistryLite);
        }
    }

    public interface MetadataOrBuilder extends MessageLiteOrBuilder {
        boolean getDeveloperModeEnabled();

        int getLastFetchStatus();

        long getLastKnownExperimentStartTime();

        boolean hasDeveloperModeEnabled();

        boolean hasLastFetchStatus();

        boolean hasLastKnownExperimentStartTime();
    }

    public static final class NamespaceKeyValue extends GeneratedMessageLite<NamespaceKeyValue, Builder> implements NamespaceKeyValueOrBuilder {
        public static final int KEY_VALUE_FIELD_NUMBER = 2;
        public static final int NAMESPACE_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public static final NamespaceKeyValue f20317e;

        /* renamed from: f */
        private static volatile Parser<NamespaceKeyValue> f20318f;

        /* renamed from: b */
        private int f20319b;

        /* renamed from: c */
        private String f20320c = "";

        /* renamed from: d */
        private Internal.ProtobufList<KeyValue> f20321d = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<NamespaceKeyValue, Builder> implements NamespaceKeyValueOrBuilder {
            /* synthetic */ Builder(C3595a aVar) {
                this();
            }

            public Builder addAllKeyValue(Iterable<? extends KeyValue> iterable) {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12240A(iterable);
                return this;
            }

            public Builder addKeyValue(KeyValue keyValue) {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12242C(keyValue);
                return this;
            }

            public Builder clearKeyValue() {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12243D();
                return this;
            }

            public Builder clearNamespace() {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12244E();
                return this;
            }

            public KeyValue getKeyValue(int i) {
                return ((NamespaceKeyValue) this.instance).getKeyValue(i);
            }

            public int getKeyValueCount() {
                return ((NamespaceKeyValue) this.instance).getKeyValueCount();
            }

            public List<KeyValue> getKeyValueList() {
                return Collections.unmodifiableList(((NamespaceKeyValue) this.instance).getKeyValueList());
            }

            public String getNamespace() {
                return ((NamespaceKeyValue) this.instance).getNamespace();
            }

            public ByteString getNamespaceBytes() {
                return ((NamespaceKeyValue) this.instance).getNamespaceBytes();
            }

            public boolean hasNamespace() {
                return ((NamespaceKeyValue) this.instance).hasNamespace();
            }

            public Builder removeKeyValue(int i) {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12246G(i);
                return this;
            }

            public Builder setKeyValue(int i, KeyValue keyValue) {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12247H(i, keyValue);
                return this;
            }

            public Builder setNamespace(String str) {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12248I(str);
                return this;
            }

            public Builder setNamespaceBytes(ByteString byteString) {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12249J(byteString);
                return this;
            }

            private Builder() {
                super(NamespaceKeyValue.f20317e);
            }

            public Builder addKeyValue(int i, KeyValue keyValue) {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12241B(i, keyValue);
                return this;
            }

            public Builder setKeyValue(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12247H(i, (KeyValue) builder.build());
                return this;
            }

            public Builder addKeyValue(KeyValue.Builder builder) {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12242C((KeyValue) builder.build());
                return this;
            }

            public Builder addKeyValue(int i, KeyValue.Builder builder) {
                copyOnWrite();
                ((NamespaceKeyValue) this.instance).m12241B(i, (KeyValue) builder.build());
                return this;
            }
        }

        static {
            NamespaceKeyValue namespaceKeyValue = new NamespaceKeyValue();
            f20317e = namespaceKeyValue;
            GeneratedMessageLite.registerDefaultInstance(NamespaceKeyValue.class, namespaceKeyValue);
        }

        private NamespaceKeyValue() {
        }

        /* access modifiers changed from: private */
        /* renamed from: A */
        public void m12240A(Iterable<? extends KeyValue> iterable) {
            m12245F();
            AbstractMessageLite.addAll(iterable, this.f20321d);
        }

        /* access modifiers changed from: private */
        /* renamed from: B */
        public void m12241B(int i, KeyValue keyValue) {
            keyValue.getClass();
            m12245F();
            this.f20321d.add(i, keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: C */
        public void m12242C(KeyValue keyValue) {
            keyValue.getClass();
            m12245F();
            this.f20321d.add(keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: D */
        public void m12243D() {
            this.f20321d = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: E */
        public void m12244E() {
            this.f20319b &= -2;
            this.f20320c = getDefaultInstance().getNamespace();
        }

        /* renamed from: F */
        private void m12245F() {
            if (!this.f20321d.isModifiable()) {
                this.f20321d = GeneratedMessageLite.mutableCopy(this.f20321d);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: G */
        public void m12246G(int i) {
            m12245F();
            this.f20321d.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: H */
        public void m12247H(int i, KeyValue keyValue) {
            keyValue.getClass();
            m12245F();
            this.f20321d.set(i, keyValue);
        }

        /* access modifiers changed from: private */
        /* renamed from: I */
        public void m12248I(String str) {
            str.getClass();
            this.f20319b |= 1;
            this.f20320c = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: J */
        public void m12249J(ByteString byteString) {
            this.f20320c = byteString.toStringUtf8();
            this.f20319b |= 1;
        }

        public static NamespaceKeyValue getDefaultInstance() {
            return f20317e;
        }

        public static Builder newBuilder() {
            return (Builder) f20317e.createBuilder();
        }

        public static NamespaceKeyValue parseDelimitedFrom(InputStream inputStream) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseDelimitedFrom(f20317e, inputStream);
        }

        public static NamespaceKeyValue parseFrom(ByteBuffer byteBuffer) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseFrom(f20317e, byteBuffer);
        }

        public static Parser<NamespaceKeyValue> parser() {
            return f20317e.getParserForType();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C3595a.f20336a[methodToInvoke.ordinal()]) {
                case 1:
                    return new NamespaceKeyValue();
                case 2:
                    return new Builder((C3595a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f20317e, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b", new Object[]{"bitField0_", "namespace_", "keyValue_", KeyValue.class});
                case 4:
                    return f20317e;
                case 5:
                    Parser<NamespaceKeyValue> parser = f20318f;
                    if (parser == null) {
                        synchronized (NamespaceKeyValue.class) {
                            parser = f20318f;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20317e);
                                f20318f = parser;
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

        public KeyValue getKeyValue(int i) {
            return this.f20321d.get(i);
        }

        public int getKeyValueCount() {
            return this.f20321d.size();
        }

        public List<KeyValue> getKeyValueList() {
            return this.f20321d;
        }

        public KeyValueOrBuilder getKeyValueOrBuilder(int i) {
            return this.f20321d.get(i);
        }

        public List<? extends KeyValueOrBuilder> getKeyValueOrBuilderList() {
            return this.f20321d;
        }

        public String getNamespace() {
            return this.f20320c;
        }

        public ByteString getNamespaceBytes() {
            return ByteString.copyFromUtf8(this.f20320c);
        }

        public boolean hasNamespace() {
            return (this.f20319b & 1) != 0;
        }

        public static Builder newBuilder(NamespaceKeyValue namespaceKeyValue) {
            return (Builder) f20317e.createBuilder(namespaceKeyValue);
        }

        public static NamespaceKeyValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseDelimitedFrom(f20317e, inputStream, extensionRegistryLite);
        }

        public static NamespaceKeyValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseFrom(f20317e, byteBuffer, extensionRegistryLite);
        }

        public static NamespaceKeyValue parseFrom(ByteString byteString) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseFrom(f20317e, byteString);
        }

        public static NamespaceKeyValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseFrom(f20317e, byteString, extensionRegistryLite);
        }

        public static NamespaceKeyValue parseFrom(byte[] bArr) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseFrom(f20317e, bArr);
        }

        public static NamespaceKeyValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseFrom(f20317e, bArr, extensionRegistryLite);
        }

        public static NamespaceKeyValue parseFrom(InputStream inputStream) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseFrom(f20317e, inputStream);
        }

        public static NamespaceKeyValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseFrom(f20317e, inputStream, extensionRegistryLite);
        }

        public static NamespaceKeyValue parseFrom(CodedInputStream codedInputStream) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseFrom(f20317e, codedInputStream);
        }

        public static NamespaceKeyValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (NamespaceKeyValue) GeneratedMessageLite.parseFrom(f20317e, codedInputStream, extensionRegistryLite);
        }
    }

    public interface NamespaceKeyValueOrBuilder extends MessageLiteOrBuilder {
        KeyValue getKeyValue(int i);

        int getKeyValueCount();

        List<KeyValue> getKeyValueList();

        String getNamespace();

        ByteString getNamespaceBytes();

        boolean hasNamespace();
    }

    public static final class PersistedConfig extends GeneratedMessageLite<PersistedConfig, Builder> implements PersistedConfigOrBuilder {
        public static final int ACTIVE_CONFIG_HOLDER_FIELD_NUMBER = 2;
        public static final int APPLIED_RESOURCE_FIELD_NUMBER = 5;
        public static final int DEFAULTS_CONFIG_HOLDER_FIELD_NUMBER = 3;
        public static final int FETCHED_CONFIG_HOLDER_FIELD_NUMBER = 1;
        public static final int METADATA_FIELD_NUMBER = 4;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public static final PersistedConfig f20322h;

        /* renamed from: i */
        private static volatile Parser<PersistedConfig> f20323i;

        /* renamed from: b */
        private int f20324b;

        /* renamed from: c */
        private ConfigHolder f20325c;

        /* renamed from: d */
        private ConfigHolder f20326d;

        /* renamed from: e */
        private ConfigHolder f20327e;

        /* renamed from: f */
        private Metadata f20328f;

        /* renamed from: g */
        private Internal.ProtobufList<Resource> f20329g = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<PersistedConfig, Builder> implements PersistedConfigOrBuilder {
            /* synthetic */ Builder(C3595a aVar) {
                this();
            }

            public Builder addAllAppliedResource(Iterable<? extends Resource> iterable) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12269J(iterable);
                return this;
            }

            public Builder addAppliedResource(Resource resource) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12271L(resource);
                return this;
            }

            public Builder clearActiveConfigHolder() {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12272M();
                return this;
            }

            public Builder clearAppliedResource() {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12273N();
                return this;
            }

            public Builder clearDefaultsConfigHolder() {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12274O();
                return this;
            }

            public Builder clearFetchedConfigHolder() {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12275P();
                return this;
            }

            public Builder clearMetadata() {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12276Q();
                return this;
            }

            public ConfigHolder getActiveConfigHolder() {
                return ((PersistedConfig) this.instance).getActiveConfigHolder();
            }

            public Resource getAppliedResource(int i) {
                return ((PersistedConfig) this.instance).getAppliedResource(i);
            }

            public int getAppliedResourceCount() {
                return ((PersistedConfig) this.instance).getAppliedResourceCount();
            }

            public List<Resource> getAppliedResourceList() {
                return Collections.unmodifiableList(((PersistedConfig) this.instance).getAppliedResourceList());
            }

            public ConfigHolder getDefaultsConfigHolder() {
                return ((PersistedConfig) this.instance).getDefaultsConfigHolder();
            }

            public ConfigHolder getFetchedConfigHolder() {
                return ((PersistedConfig) this.instance).getFetchedConfigHolder();
            }

            public Metadata getMetadata() {
                return ((PersistedConfig) this.instance).getMetadata();
            }

            public boolean hasActiveConfigHolder() {
                return ((PersistedConfig) this.instance).hasActiveConfigHolder();
            }

            public boolean hasDefaultsConfigHolder() {
                return ((PersistedConfig) this.instance).hasDefaultsConfigHolder();
            }

            public boolean hasFetchedConfigHolder() {
                return ((PersistedConfig) this.instance).hasFetchedConfigHolder();
            }

            public boolean hasMetadata() {
                return ((PersistedConfig) this.instance).hasMetadata();
            }

            public Builder mergeActiveConfigHolder(ConfigHolder configHolder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12278S(configHolder);
                return this;
            }

            public Builder mergeDefaultsConfigHolder(ConfigHolder configHolder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12279T(configHolder);
                return this;
            }

            public Builder mergeFetchedConfigHolder(ConfigHolder configHolder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12280U(configHolder);
                return this;
            }

            public Builder mergeMetadata(Metadata metadata) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12281V(metadata);
                return this;
            }

            public Builder removeAppliedResource(int i) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12282W(i);
                return this;
            }

            public Builder setActiveConfigHolder(ConfigHolder configHolder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12283X(configHolder);
                return this;
            }

            public Builder setAppliedResource(int i, Resource resource) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12284Y(i, resource);
                return this;
            }

            public Builder setDefaultsConfigHolder(ConfigHolder configHolder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12285Z(configHolder);
                return this;
            }

            public Builder setFetchedConfigHolder(ConfigHolder configHolder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12286a0(configHolder);
                return this;
            }

            public Builder setMetadata(Metadata metadata) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12287b0(metadata);
                return this;
            }

            private Builder() {
                super(PersistedConfig.f20322h);
            }

            public Builder addAppliedResource(int i, Resource resource) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12270K(i, resource);
                return this;
            }

            public Builder setActiveConfigHolder(ConfigHolder.Builder builder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12283X((ConfigHolder) builder.build());
                return this;
            }

            public Builder setAppliedResource(int i, Resource.Builder builder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12284Y(i, (Resource) builder.build());
                return this;
            }

            public Builder setDefaultsConfigHolder(ConfigHolder.Builder builder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12285Z((ConfigHolder) builder.build());
                return this;
            }

            public Builder setFetchedConfigHolder(ConfigHolder.Builder builder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12286a0((ConfigHolder) builder.build());
                return this;
            }

            public Builder setMetadata(Metadata.Builder builder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12287b0((Metadata) builder.build());
                return this;
            }

            public Builder addAppliedResource(Resource.Builder builder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12271L((Resource) builder.build());
                return this;
            }

            public Builder addAppliedResource(int i, Resource.Builder builder) {
                copyOnWrite();
                ((PersistedConfig) this.instance).m12270K(i, (Resource) builder.build());
                return this;
            }
        }

        static {
            PersistedConfig persistedConfig = new PersistedConfig();
            f20322h = persistedConfig;
            GeneratedMessageLite.registerDefaultInstance(PersistedConfig.class, persistedConfig);
        }

        private PersistedConfig() {
        }

        /* access modifiers changed from: private */
        /* renamed from: J */
        public void m12269J(Iterable<? extends Resource> iterable) {
            m12277R();
            AbstractMessageLite.addAll(iterable, this.f20329g);
        }

        /* access modifiers changed from: private */
        /* renamed from: K */
        public void m12270K(int i, Resource resource) {
            resource.getClass();
            m12277R();
            this.f20329g.add(i, resource);
        }

        /* access modifiers changed from: private */
        /* renamed from: L */
        public void m12271L(Resource resource) {
            resource.getClass();
            m12277R();
            this.f20329g.add(resource);
        }

        /* access modifiers changed from: private */
        /* renamed from: M */
        public void m12272M() {
            this.f20326d = null;
            this.f20324b &= -3;
        }

        /* access modifiers changed from: private */
        /* renamed from: N */
        public void m12273N() {
            this.f20329g = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: O */
        public void m12274O() {
            this.f20327e = null;
            this.f20324b &= -5;
        }

        /* access modifiers changed from: private */
        /* renamed from: P */
        public void m12275P() {
            this.f20325c = null;
            this.f20324b &= -2;
        }

        /* access modifiers changed from: private */
        /* renamed from: Q */
        public void m12276Q() {
            this.f20328f = null;
            this.f20324b &= -9;
        }

        /* renamed from: R */
        private void m12277R() {
            if (!this.f20329g.isModifiable()) {
                this.f20329g = GeneratedMessageLite.mutableCopy(this.f20329g);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: S */
        public void m12278S(ConfigHolder configHolder) {
            configHolder.getClass();
            ConfigHolder configHolder2 = this.f20326d;
            if (configHolder2 == null || configHolder2 == ConfigHolder.getDefaultInstance()) {
                this.f20326d = configHolder;
            } else {
                this.f20326d = (ConfigHolder) ((ConfigHolder.Builder) ConfigHolder.newBuilder(this.f20326d).mergeFrom(configHolder)).buildPartial();
            }
            this.f20324b |= 2;
        }

        /* access modifiers changed from: private */
        /* renamed from: T */
        public void m12279T(ConfigHolder configHolder) {
            configHolder.getClass();
            ConfigHolder configHolder2 = this.f20327e;
            if (configHolder2 == null || configHolder2 == ConfigHolder.getDefaultInstance()) {
                this.f20327e = configHolder;
            } else {
                this.f20327e = (ConfigHolder) ((ConfigHolder.Builder) ConfigHolder.newBuilder(this.f20327e).mergeFrom(configHolder)).buildPartial();
            }
            this.f20324b |= 4;
        }

        /* access modifiers changed from: private */
        /* renamed from: U */
        public void m12280U(ConfigHolder configHolder) {
            configHolder.getClass();
            ConfigHolder configHolder2 = this.f20325c;
            if (configHolder2 == null || configHolder2 == ConfigHolder.getDefaultInstance()) {
                this.f20325c = configHolder;
            } else {
                this.f20325c = (ConfigHolder) ((ConfigHolder.Builder) ConfigHolder.newBuilder(this.f20325c).mergeFrom(configHolder)).buildPartial();
            }
            this.f20324b |= 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: V */
        public void m12281V(Metadata metadata) {
            metadata.getClass();
            Metadata metadata2 = this.f20328f;
            if (metadata2 == null || metadata2 == Metadata.getDefaultInstance()) {
                this.f20328f = metadata;
            } else {
                this.f20328f = (Metadata) ((Metadata.Builder) Metadata.newBuilder(this.f20328f).mergeFrom(metadata)).buildPartial();
            }
            this.f20324b |= 8;
        }

        /* access modifiers changed from: private */
        /* renamed from: W */
        public void m12282W(int i) {
            m12277R();
            this.f20329g.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: X */
        public void m12283X(ConfigHolder configHolder) {
            configHolder.getClass();
            this.f20326d = configHolder;
            this.f20324b |= 2;
        }

        /* access modifiers changed from: private */
        /* renamed from: Y */
        public void m12284Y(int i, Resource resource) {
            resource.getClass();
            m12277R();
            this.f20329g.set(i, resource);
        }

        /* access modifiers changed from: private */
        /* renamed from: Z */
        public void m12285Z(ConfigHolder configHolder) {
            configHolder.getClass();
            this.f20327e = configHolder;
            this.f20324b |= 4;
        }

        /* access modifiers changed from: private */
        /* renamed from: a0 */
        public void m12286a0(ConfigHolder configHolder) {
            configHolder.getClass();
            this.f20325c = configHolder;
            this.f20324b |= 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: b0 */
        public void m12287b0(Metadata metadata) {
            metadata.getClass();
            this.f20328f = metadata;
            this.f20324b |= 8;
        }

        public static PersistedConfig getDefaultInstance() {
            return f20322h;
        }

        public static Builder newBuilder() {
            return (Builder) f20322h.createBuilder();
        }

        public static PersistedConfig parseDelimitedFrom(InputStream inputStream) {
            return (PersistedConfig) GeneratedMessageLite.parseDelimitedFrom(f20322h, inputStream);
        }

        public static PersistedConfig parseFrom(ByteBuffer byteBuffer) {
            return (PersistedConfig) GeneratedMessageLite.parseFrom(f20322h, byteBuffer);
        }

        public static Parser<PersistedConfig> parser() {
            return f20322h.getParserForType();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C3595a.f20336a[methodToInvoke.ordinal()]) {
                case 1:
                    return new PersistedConfig();
                case 2:
                    return new Builder((C3595a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f20322h, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b", new Object[]{"bitField0_", "fetchedConfigHolder_", "activeConfigHolder_", "defaultsConfigHolder_", "metadata_", "appliedResource_", Resource.class});
                case 4:
                    return f20322h;
                case 5:
                    Parser<PersistedConfig> parser = f20323i;
                    if (parser == null) {
                        synchronized (PersistedConfig.class) {
                            parser = f20323i;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20322h);
                                f20323i = parser;
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

        public ConfigHolder getActiveConfigHolder() {
            ConfigHolder configHolder = this.f20326d;
            return configHolder == null ? ConfigHolder.getDefaultInstance() : configHolder;
        }

        public Resource getAppliedResource(int i) {
            return this.f20329g.get(i);
        }

        public int getAppliedResourceCount() {
            return this.f20329g.size();
        }

        public List<Resource> getAppliedResourceList() {
            return this.f20329g;
        }

        public ResourceOrBuilder getAppliedResourceOrBuilder(int i) {
            return this.f20329g.get(i);
        }

        public List<? extends ResourceOrBuilder> getAppliedResourceOrBuilderList() {
            return this.f20329g;
        }

        public ConfigHolder getDefaultsConfigHolder() {
            ConfigHolder configHolder = this.f20327e;
            return configHolder == null ? ConfigHolder.getDefaultInstance() : configHolder;
        }

        public ConfigHolder getFetchedConfigHolder() {
            ConfigHolder configHolder = this.f20325c;
            return configHolder == null ? ConfigHolder.getDefaultInstance() : configHolder;
        }

        public Metadata getMetadata() {
            Metadata metadata = this.f20328f;
            return metadata == null ? Metadata.getDefaultInstance() : metadata;
        }

        public boolean hasActiveConfigHolder() {
            return (this.f20324b & 2) != 0;
        }

        public boolean hasDefaultsConfigHolder() {
            return (this.f20324b & 4) != 0;
        }

        public boolean hasFetchedConfigHolder() {
            return (this.f20324b & 1) != 0;
        }

        public boolean hasMetadata() {
            return (this.f20324b & 8) != 0;
        }

        public static Builder newBuilder(PersistedConfig persistedConfig) {
            return (Builder) f20322h.createBuilder(persistedConfig);
        }

        public static PersistedConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PersistedConfig) GeneratedMessageLite.parseDelimitedFrom(f20322h, inputStream, extensionRegistryLite);
        }

        public static PersistedConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (PersistedConfig) GeneratedMessageLite.parseFrom(f20322h, byteBuffer, extensionRegistryLite);
        }

        public static PersistedConfig parseFrom(ByteString byteString) {
            return (PersistedConfig) GeneratedMessageLite.parseFrom(f20322h, byteString);
        }

        public static PersistedConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (PersistedConfig) GeneratedMessageLite.parseFrom(f20322h, byteString, extensionRegistryLite);
        }

        public static PersistedConfig parseFrom(byte[] bArr) {
            return (PersistedConfig) GeneratedMessageLite.parseFrom(f20322h, bArr);
        }

        public static PersistedConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (PersistedConfig) GeneratedMessageLite.parseFrom(f20322h, bArr, extensionRegistryLite);
        }

        public static PersistedConfig parseFrom(InputStream inputStream) {
            return (PersistedConfig) GeneratedMessageLite.parseFrom(f20322h, inputStream);
        }

        public static PersistedConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PersistedConfig) GeneratedMessageLite.parseFrom(f20322h, inputStream, extensionRegistryLite);
        }

        public static PersistedConfig parseFrom(CodedInputStream codedInputStream) {
            return (PersistedConfig) GeneratedMessageLite.parseFrom(f20322h, codedInputStream);
        }

        public static PersistedConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PersistedConfig) GeneratedMessageLite.parseFrom(f20322h, codedInputStream, extensionRegistryLite);
        }
    }

    public interface PersistedConfigOrBuilder extends MessageLiteOrBuilder {
        ConfigHolder getActiveConfigHolder();

        Resource getAppliedResource(int i);

        int getAppliedResourceCount();

        List<Resource> getAppliedResourceList();

        ConfigHolder getDefaultsConfigHolder();

        ConfigHolder getFetchedConfigHolder();

        Metadata getMetadata();

        boolean hasActiveConfigHolder();

        boolean hasDefaultsConfigHolder();

        boolean hasFetchedConfigHolder();

        boolean hasMetadata();
    }

    public static final class Resource extends GeneratedMessageLite<Resource, Builder> implements ResourceOrBuilder {
        public static final int APP_UPDATE_TIME_FIELD_NUMBER = 2;
        public static final int NAMESPACE_FIELD_NUMBER = 3;
        public static final int RESOURCE_ID_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public static final Resource f20330f;

        /* renamed from: g */
        private static volatile Parser<Resource> f20331g;

        /* renamed from: b */
        private int f20332b;

        /* renamed from: c */
        private int f20333c;

        /* renamed from: d */
        private long f20334d;

        /* renamed from: e */
        private String f20335e = "";

        public static final class Builder extends GeneratedMessageLite.Builder<Resource, Builder> implements ResourceOrBuilder {
            /* synthetic */ Builder(C3595a aVar) {
                this();
            }

            public Builder clearAppUpdateTime() {
                copyOnWrite();
                ((Resource) this.instance).m12311y();
                return this;
            }

            public Builder clearNamespace() {
                copyOnWrite();
                ((Resource) this.instance).m12312z();
                return this;
            }

            public Builder clearResourceId() {
                copyOnWrite();
                ((Resource) this.instance).m12298A();
                return this;
            }

            public long getAppUpdateTime() {
                return ((Resource) this.instance).getAppUpdateTime();
            }

            public String getNamespace() {
                return ((Resource) this.instance).getNamespace();
            }

            public ByteString getNamespaceBytes() {
                return ((Resource) this.instance).getNamespaceBytes();
            }

            public int getResourceId() {
                return ((Resource) this.instance).getResourceId();
            }

            public boolean hasAppUpdateTime() {
                return ((Resource) this.instance).hasAppUpdateTime();
            }

            public boolean hasNamespace() {
                return ((Resource) this.instance).hasNamespace();
            }

            public boolean hasResourceId() {
                return ((Resource) this.instance).hasResourceId();
            }

            public Builder setAppUpdateTime(long j) {
                copyOnWrite();
                ((Resource) this.instance).m12299B(j);
                return this;
            }

            public Builder setNamespace(String str) {
                copyOnWrite();
                ((Resource) this.instance).m12300C(str);
                return this;
            }

            public Builder setNamespaceBytes(ByteString byteString) {
                copyOnWrite();
                ((Resource) this.instance).m12301D(byteString);
                return this;
            }

            public Builder setResourceId(int i) {
                copyOnWrite();
                ((Resource) this.instance).m12302E(i);
                return this;
            }

            private Builder() {
                super(Resource.f20330f);
            }
        }

        static {
            Resource resource = new Resource();
            f20330f = resource;
            GeneratedMessageLite.registerDefaultInstance(Resource.class, resource);
        }

        private Resource() {
        }

        /* access modifiers changed from: private */
        /* renamed from: A */
        public void m12298A() {
            this.f20332b &= -2;
            this.f20333c = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: B */
        public void m12299B(long j) {
            this.f20332b |= 2;
            this.f20334d = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: C */
        public void m12300C(String str) {
            str.getClass();
            this.f20332b |= 4;
            this.f20335e = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: D */
        public void m12301D(ByteString byteString) {
            this.f20335e = byteString.toStringUtf8();
            this.f20332b |= 4;
        }

        /* access modifiers changed from: private */
        /* renamed from: E */
        public void m12302E(int i) {
            this.f20332b |= 1;
            this.f20333c = i;
        }

        public static Resource getDefaultInstance() {
            return f20330f;
        }

        public static Builder newBuilder() {
            return (Builder) f20330f.createBuilder();
        }

        public static Resource parseDelimitedFrom(InputStream inputStream) {
            return (Resource) GeneratedMessageLite.parseDelimitedFrom(f20330f, inputStream);
        }

        public static Resource parseFrom(ByteBuffer byteBuffer) {
            return (Resource) GeneratedMessageLite.parseFrom(f20330f, byteBuffer);
        }

        public static Parser<Resource> parser() {
            return f20330f.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: y */
        public void m12311y() {
            this.f20332b &= -3;
            this.f20334d = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: z */
        public void m12312z() {
            this.f20332b &= -5;
            this.f20335e = getDefaultInstance().getNamespace();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C3595a.f20336a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Resource();
                case 2:
                    return new Builder((C3595a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f20330f, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0005\u0001\u0003\b\u0002", new Object[]{"bitField0_", "resourceId_", "appUpdateTime_", "namespace_"});
                case 4:
                    return f20330f;
                case 5:
                    Parser<Resource> parser = f20331g;
                    if (parser == null) {
                        synchronized (Resource.class) {
                            parser = f20331g;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f20330f);
                                f20331g = parser;
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

        public long getAppUpdateTime() {
            return this.f20334d;
        }

        public String getNamespace() {
            return this.f20335e;
        }

        public ByteString getNamespaceBytes() {
            return ByteString.copyFromUtf8(this.f20335e);
        }

        public int getResourceId() {
            return this.f20333c;
        }

        public boolean hasAppUpdateTime() {
            return (this.f20332b & 2) != 0;
        }

        public boolean hasNamespace() {
            return (this.f20332b & 4) != 0;
        }

        public boolean hasResourceId() {
            return (this.f20332b & 1) != 0;
        }

        public static Builder newBuilder(Resource resource) {
            return (Builder) f20330f.createBuilder(resource);
        }

        public static Resource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) GeneratedMessageLite.parseDelimitedFrom(f20330f, inputStream, extensionRegistryLite);
        }

        public static Resource parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) GeneratedMessageLite.parseFrom(f20330f, byteBuffer, extensionRegistryLite);
        }

        public static Resource parseFrom(ByteString byteString) {
            return (Resource) GeneratedMessageLite.parseFrom(f20330f, byteString);
        }

        public static Resource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) GeneratedMessageLite.parseFrom(f20330f, byteString, extensionRegistryLite);
        }

        public static Resource parseFrom(byte[] bArr) {
            return (Resource) GeneratedMessageLite.parseFrom(f20330f, bArr);
        }

        public static Resource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) GeneratedMessageLite.parseFrom(f20330f, bArr, extensionRegistryLite);
        }

        public static Resource parseFrom(InputStream inputStream) {
            return (Resource) GeneratedMessageLite.parseFrom(f20330f, inputStream);
        }

        public static Resource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) GeneratedMessageLite.parseFrom(f20330f, inputStream, extensionRegistryLite);
        }

        public static Resource parseFrom(CodedInputStream codedInputStream) {
            return (Resource) GeneratedMessageLite.parseFrom(f20330f, codedInputStream);
        }

        public static Resource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) GeneratedMessageLite.parseFrom(f20330f, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ResourceOrBuilder extends MessageLiteOrBuilder {
        long getAppUpdateTime();

        String getNamespace();

        ByteString getNamespaceBytes();

        int getResourceId();

        boolean hasAppUpdateTime();

        boolean hasNamespace();

        boolean hasResourceId();
    }

    /* renamed from: com.google.firebase.remoteconfig.proto.ConfigPersistence$a */
    static /* synthetic */ class C3595a {

        /* renamed from: a */
        static final /* synthetic */ int[] f20336a;

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
                f20336a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20336a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20336a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20336a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20336a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20336a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20336a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.proto.ConfigPersistence.C3595a.<clinit>():void");
        }
    }

    private ConfigPersistence() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
