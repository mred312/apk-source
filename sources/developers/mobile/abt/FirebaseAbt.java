package developers.mobile.abt;

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

public final class FirebaseAbt {

    public static final class ExperimentLite extends GeneratedMessageLite<ExperimentLite, Builder> implements ExperimentLiteOrBuilder {
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public static final ExperimentLite f21074c;

        /* renamed from: d */
        private static volatile Parser<ExperimentLite> f21075d;

        /* renamed from: b */
        private String f21076b = "";

        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentLite, Builder> implements ExperimentLiteOrBuilder {
            /* synthetic */ Builder(C3921a aVar) {
                this();
            }

            public Builder clearExperimentId() {
                copyOnWrite();
                ((ExperimentLite) this.instance).m14136u();
                return this;
            }

            public String getExperimentId() {
                return ((ExperimentLite) this.instance).getExperimentId();
            }

            public ByteString getExperimentIdBytes() {
                return ((ExperimentLite) this.instance).getExperimentIdBytes();
            }

            public Builder setExperimentId(String str) {
                copyOnWrite();
                ((ExperimentLite) this.instance).m14137v(str);
                return this;
            }

            public Builder setExperimentIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentLite) this.instance).m14138w(byteString);
                return this;
            }

            private Builder() {
                super(ExperimentLite.f21074c);
            }
        }

        static {
            ExperimentLite experimentLite = new ExperimentLite();
            f21074c = experimentLite;
            GeneratedMessageLite.registerDefaultInstance(ExperimentLite.class, experimentLite);
        }

        private ExperimentLite() {
        }

        public static ExperimentLite getDefaultInstance() {
            return f21074c;
        }

        public static Builder newBuilder() {
            return (Builder) f21074c.createBuilder();
        }

        public static ExperimentLite parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentLite) GeneratedMessageLite.parseDelimitedFrom(f21074c, inputStream);
        }

        public static ExperimentLite parseFrom(ByteBuffer byteBuffer) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(f21074c, byteBuffer);
        }

        public static Parser<ExperimentLite> parser() {
            return f21074c.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public void m14136u() {
            this.f21076b = getDefaultInstance().getExperimentId();
        }

        /* access modifiers changed from: private */
        /* renamed from: v */
        public void m14137v(String str) {
            str.getClass();
            this.f21076b = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: w */
        public void m14138w(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f21076b = byteString.toStringUtf8();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C3921a.f21096a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentLite();
                case 2:
                    return new Builder((C3921a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f21074c, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"experimentId_"});
                case 4:
                    return f21074c;
                case 5:
                    Parser<ExperimentLite> parser = f21075d;
                    if (parser == null) {
                        synchronized (ExperimentLite.class) {
                            parser = f21075d;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f21074c);
                                f21075d = parser;
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

        public String getExperimentId() {
            return this.f21076b;
        }

        public ByteString getExperimentIdBytes() {
            return ByteString.copyFromUtf8(this.f21076b);
        }

        public static Builder newBuilder(ExperimentLite experimentLite) {
            return (Builder) f21074c.createBuilder(experimentLite);
        }

        public static ExperimentLite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseDelimitedFrom(f21074c, inputStream, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(f21074c, byteBuffer, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(ByteString byteString) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(f21074c, byteString);
        }

        public static ExperimentLite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(f21074c, byteString, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(byte[] bArr) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(f21074c, bArr);
        }

        public static ExperimentLite parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(f21074c, bArr, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(InputStream inputStream) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(f21074c, inputStream);
        }

        public static ExperimentLite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(f21074c, inputStream, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(f21074c, codedInputStream);
        }

        public static ExperimentLite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(f21074c, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ExperimentLiteOrBuilder extends MessageLiteOrBuilder {
        String getExperimentId();

        ByteString getExperimentIdBytes();
    }

    public static final class ExperimentPayload extends GeneratedMessageLite<ExperimentPayload, Builder> implements ExperimentPayloadOrBuilder {
        public static final int ACTIVATE_EVENT_TO_LOG_FIELD_NUMBER = 8;
        public static final int CLEAR_EVENT_TO_LOG_FIELD_NUMBER = 9;
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        public static final int EXPERIMENT_START_TIME_MILLIS_FIELD_NUMBER = 3;
        public static final int ONGOING_EXPERIMENTS_FIELD_NUMBER = 13;
        public static final int OVERFLOW_POLICY_FIELD_NUMBER = 12;
        public static final int SET_EVENT_TO_LOG_FIELD_NUMBER = 7;
        public static final int TIMEOUT_EVENT_TO_LOG_FIELD_NUMBER = 10;
        public static final int TIME_TO_LIVE_MILLIS_FIELD_NUMBER = 6;
        public static final int TRIGGER_EVENT_FIELD_NUMBER = 4;
        public static final int TRIGGER_TIMEOUT_MILLIS_FIELD_NUMBER = 5;
        public static final int TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER = 11;
        public static final int VARIANT_ID_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public static final ExperimentPayload f21077o;

        /* renamed from: p */
        private static volatile Parser<ExperimentPayload> f21078p;

        /* renamed from: b */
        private String f21079b = "";

        /* renamed from: c */
        private String f21080c = "";

        /* renamed from: d */
        private long f21081d;

        /* renamed from: e */
        private String f21082e = "";

        /* renamed from: f */
        private long f21083f;

        /* renamed from: g */
        private long f21084g;

        /* renamed from: h */
        private String f21085h = "";

        /* renamed from: i */
        private String f21086i = "";

        /* renamed from: j */
        private String f21087j = "";

        /* renamed from: k */
        private String f21088k = "";

        /* renamed from: l */
        private String f21089l = "";

        /* renamed from: m */
        private int f21090m;

        /* renamed from: n */
        private Internal.ProtobufList<ExperimentLite> f21091n = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentPayload, Builder> implements ExperimentPayloadOrBuilder {
            /* synthetic */ Builder(C3921a aVar) {
                this();
            }

            public Builder addAllOngoingExperiments(Iterable<? extends ExperimentLite> iterable) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14187e0(iterable);
                return this;
            }

            public Builder addOngoingExperiments(ExperimentLite experimentLite) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14189g0(experimentLite);
                return this;
            }

            public Builder clearActivateEventToLog() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14190h0();
                return this;
            }

            public Builder clearClearEventToLog() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14191i0();
                return this;
            }

            public Builder clearExperimentId() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14192j0();
                return this;
            }

            public Builder clearExperimentStartTimeMillis() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14193k0();
                return this;
            }

            public Builder clearOngoingExperiments() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14194l0();
                return this;
            }

            public Builder clearOverflowPolicy() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14195m0();
                return this;
            }

            public Builder clearSetEventToLog() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14196n0();
                return this;
            }

            public Builder clearTimeToLiveMillis() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14197o0();
                return this;
            }

            public Builder clearTimeoutEventToLog() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14198p0();
                return this;
            }

            public Builder clearTriggerEvent() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14200q0();
                return this;
            }

            public Builder clearTriggerTimeoutMillis() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14202r0();
                return this;
            }

            public Builder clearTtlExpiryEventToLog() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14204s0();
                return this;
            }

            public Builder clearVariantId() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14206t0();
                return this;
            }

            public String getActivateEventToLog() {
                return ((ExperimentPayload) this.instance).getActivateEventToLog();
            }

            public ByteString getActivateEventToLogBytes() {
                return ((ExperimentPayload) this.instance).getActivateEventToLogBytes();
            }

            public String getClearEventToLog() {
                return ((ExperimentPayload) this.instance).getClearEventToLog();
            }

            public ByteString getClearEventToLogBytes() {
                return ((ExperimentPayload) this.instance).getClearEventToLogBytes();
            }

            public String getExperimentId() {
                return ((ExperimentPayload) this.instance).getExperimentId();
            }

            public ByteString getExperimentIdBytes() {
                return ((ExperimentPayload) this.instance).getExperimentIdBytes();
            }

            public long getExperimentStartTimeMillis() {
                return ((ExperimentPayload) this.instance).getExperimentStartTimeMillis();
            }

            public ExperimentLite getOngoingExperiments(int i) {
                return ((ExperimentPayload) this.instance).getOngoingExperiments(i);
            }

            public int getOngoingExperimentsCount() {
                return ((ExperimentPayload) this.instance).getOngoingExperimentsCount();
            }

            public List<ExperimentLite> getOngoingExperimentsList() {
                return Collections.unmodifiableList(((ExperimentPayload) this.instance).getOngoingExperimentsList());
            }

            public ExperimentOverflowPolicy getOverflowPolicy() {
                return ((ExperimentPayload) this.instance).getOverflowPolicy();
            }

            public int getOverflowPolicyValue() {
                return ((ExperimentPayload) this.instance).getOverflowPolicyValue();
            }

            public String getSetEventToLog() {
                return ((ExperimentPayload) this.instance).getSetEventToLog();
            }

            public ByteString getSetEventToLogBytes() {
                return ((ExperimentPayload) this.instance).getSetEventToLogBytes();
            }

            public long getTimeToLiveMillis() {
                return ((ExperimentPayload) this.instance).getTimeToLiveMillis();
            }

            public String getTimeoutEventToLog() {
                return ((ExperimentPayload) this.instance).getTimeoutEventToLog();
            }

            public ByteString getTimeoutEventToLogBytes() {
                return ((ExperimentPayload) this.instance).getTimeoutEventToLogBytes();
            }

            public String getTriggerEvent() {
                return ((ExperimentPayload) this.instance).getTriggerEvent();
            }

            public ByteString getTriggerEventBytes() {
                return ((ExperimentPayload) this.instance).getTriggerEventBytes();
            }

            public long getTriggerTimeoutMillis() {
                return ((ExperimentPayload) this.instance).getTriggerTimeoutMillis();
            }

            public String getTtlExpiryEventToLog() {
                return ((ExperimentPayload) this.instance).getTtlExpiryEventToLog();
            }

            public ByteString getTtlExpiryEventToLogBytes() {
                return ((ExperimentPayload) this.instance).getTtlExpiryEventToLogBytes();
            }

            public String getVariantId() {
                return ((ExperimentPayload) this.instance).getVariantId();
            }

            public ByteString getVariantIdBytes() {
                return ((ExperimentPayload) this.instance).getVariantIdBytes();
            }

            public Builder removeOngoingExperiments(int i) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14210v0(i);
                return this;
            }

            public Builder setActivateEventToLog(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14212w0(str);
                return this;
            }

            public Builder setActivateEventToLogBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14214x0(byteString);
                return this;
            }

            public Builder setClearEventToLog(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14216y0(str);
                return this;
            }

            public Builder setClearEventToLogBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14218z0(byteString);
                return this;
            }

            public Builder setExperimentId(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14140A0(str);
                return this;
            }

            public Builder setExperimentIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14142B0(byteString);
                return this;
            }

            public Builder setExperimentStartTimeMillis(long j) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14144C0(j);
                return this;
            }

            public Builder setOngoingExperiments(int i, ExperimentLite experimentLite) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14146D0(i, experimentLite);
                return this;
            }

            public Builder setOverflowPolicy(ExperimentOverflowPolicy experimentOverflowPolicy) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14148E0(experimentOverflowPolicy);
                return this;
            }

            public Builder setOverflowPolicyValue(int i) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14150F0(i);
                return this;
            }

            public Builder setSetEventToLog(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14152G0(str);
                return this;
            }

            public Builder setSetEventToLogBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14154H0(byteString);
                return this;
            }

            public Builder setTimeToLiveMillis(long j) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14156I0(j);
                return this;
            }

            public Builder setTimeoutEventToLog(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14158J0(str);
                return this;
            }

            public Builder setTimeoutEventToLogBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14160K0(byteString);
                return this;
            }

            public Builder setTriggerEvent(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14162L0(str);
                return this;
            }

            public Builder setTriggerEventBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14164M0(byteString);
                return this;
            }

            public Builder setTriggerTimeoutMillis(long j) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14166N0(j);
                return this;
            }

            public Builder setTtlExpiryEventToLog(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14168O0(str);
                return this;
            }

            public Builder setTtlExpiryEventToLogBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14170P0(byteString);
                return this;
            }

            public Builder setVariantId(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14172Q0(str);
                return this;
            }

            public Builder setVariantIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14174R0(byteString);
                return this;
            }

            private Builder() {
                super(ExperimentPayload.f21077o);
            }

            public Builder addOngoingExperiments(int i, ExperimentLite experimentLite) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14188f0(i, experimentLite);
                return this;
            }

            public Builder setOngoingExperiments(int i, ExperimentLite.Builder builder) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14146D0(i, (ExperimentLite) builder.build());
                return this;
            }

            public Builder addOngoingExperiments(ExperimentLite.Builder builder) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14189g0((ExperimentLite) builder.build());
                return this;
            }

            public Builder addOngoingExperiments(int i, ExperimentLite.Builder builder) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).m14188f0(i, (ExperimentLite) builder.build());
                return this;
            }
        }

        public enum ExperimentOverflowPolicy implements Internal.EnumLite {
            POLICY_UNSPECIFIED(0),
            DISCARD_OLDEST(1),
            IGNORE_NEWEST(2),
            UNRECOGNIZED(-1);
            
            public static final int DISCARD_OLDEST_VALUE = 1;
            public static final int IGNORE_NEWEST_VALUE = 2;
            public static final int POLICY_UNSPECIFIED_VALUE = 0;

            /* renamed from: b */
            private static final Internal.EnumLiteMap<ExperimentOverflowPolicy> f21092b = null;

            /* renamed from: a */
            private final int f21094a;

            /* renamed from: developers.mobile.abt.FirebaseAbt$ExperimentPayload$ExperimentOverflowPolicy$a */
            class C3919a implements Internal.EnumLiteMap<ExperimentOverflowPolicy> {
                C3919a() {
                }

                /* renamed from: a */
                public ExperimentOverflowPolicy findValueByNumber(int i) {
                    return ExperimentOverflowPolicy.forNumber(i);
                }
            }

            /* renamed from: developers.mobile.abt.FirebaseAbt$ExperimentPayload$ExperimentOverflowPolicy$b */
            private static final class C3920b implements Internal.EnumVerifier {

                /* renamed from: a */
                static final Internal.EnumVerifier f21095a = null;

                static {
                    f21095a = new C3920b();
                }

                private C3920b() {
                }

                public boolean isInRange(int i) {
                    return ExperimentOverflowPolicy.forNumber(i) != null;
                }
            }

            static {
                f21092b = new C3919a();
            }

            private ExperimentOverflowPolicy(int i) {
                this.f21094a = i;
            }

            public static ExperimentOverflowPolicy forNumber(int i) {
                if (i == 0) {
                    return POLICY_UNSPECIFIED;
                }
                if (i == 1) {
                    return DISCARD_OLDEST;
                }
                if (i != 2) {
                    return null;
                }
                return IGNORE_NEWEST;
            }

            public static Internal.EnumLiteMap<ExperimentOverflowPolicy> internalGetValueMap() {
                return f21092b;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return C3920b.f21095a;
            }

            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f21094a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static ExperimentOverflowPolicy valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            ExperimentPayload experimentPayload = new ExperimentPayload();
            f21077o = experimentPayload;
            GeneratedMessageLite.registerDefaultInstance(ExperimentPayload.class, experimentPayload);
        }

        private ExperimentPayload() {
        }

        /* access modifiers changed from: private */
        /* renamed from: A0 */
        public void m14140A0(String str) {
            str.getClass();
            this.f21079b = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: B0 */
        public void m14142B0(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f21079b = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        /* renamed from: C0 */
        public void m14144C0(long j) {
            this.f21081d = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: D0 */
        public void m14146D0(int i, ExperimentLite experimentLite) {
            experimentLite.getClass();
            m14208u0();
            this.f21091n.set(i, experimentLite);
        }

        /* access modifiers changed from: private */
        /* renamed from: E0 */
        public void m14148E0(ExperimentOverflowPolicy experimentOverflowPolicy) {
            this.f21090m = experimentOverflowPolicy.getNumber();
        }

        /* access modifiers changed from: private */
        /* renamed from: F0 */
        public void m14150F0(int i) {
            this.f21090m = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: G0 */
        public void m14152G0(String str) {
            str.getClass();
            this.f21085h = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: H0 */
        public void m14154H0(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f21085h = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        /* renamed from: I0 */
        public void m14156I0(long j) {
            this.f21084g = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: J0 */
        public void m14158J0(String str) {
            str.getClass();
            this.f21088k = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: K0 */
        public void m14160K0(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f21088k = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        /* renamed from: L0 */
        public void m14162L0(String str) {
            str.getClass();
            this.f21082e = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: M0 */
        public void m14164M0(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f21082e = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        /* renamed from: N0 */
        public void m14166N0(long j) {
            this.f21083f = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: O0 */
        public void m14168O0(String str) {
            str.getClass();
            this.f21089l = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: P0 */
        public void m14170P0(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f21089l = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        /* renamed from: Q0 */
        public void m14172Q0(String str) {
            str.getClass();
            this.f21080c = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: R0 */
        public void m14174R0(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f21080c = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        /* renamed from: e0 */
        public void m14187e0(Iterable<? extends ExperimentLite> iterable) {
            m14208u0();
            AbstractMessageLite.addAll(iterable, this.f21091n);
        }

        /* access modifiers changed from: private */
        /* renamed from: f0 */
        public void m14188f0(int i, ExperimentLite experimentLite) {
            experimentLite.getClass();
            m14208u0();
            this.f21091n.add(i, experimentLite);
        }

        /* access modifiers changed from: private */
        /* renamed from: g0 */
        public void m14189g0(ExperimentLite experimentLite) {
            experimentLite.getClass();
            m14208u0();
            this.f21091n.add(experimentLite);
        }

        public static ExperimentPayload getDefaultInstance() {
            return f21077o;
        }

        /* access modifiers changed from: private */
        /* renamed from: h0 */
        public void m14190h0() {
            this.f21086i = getDefaultInstance().getActivateEventToLog();
        }

        /* access modifiers changed from: private */
        /* renamed from: i0 */
        public void m14191i0() {
            this.f21087j = getDefaultInstance().getClearEventToLog();
        }

        /* access modifiers changed from: private */
        /* renamed from: j0 */
        public void m14192j0() {
            this.f21079b = getDefaultInstance().getExperimentId();
        }

        /* access modifiers changed from: private */
        /* renamed from: k0 */
        public void m14193k0() {
            this.f21081d = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: l0 */
        public void m14194l0() {
            this.f21091n = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        /* renamed from: m0 */
        public void m14195m0() {
            this.f21090m = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: n0 */
        public void m14196n0() {
            this.f21085h = getDefaultInstance().getSetEventToLog();
        }

        public static Builder newBuilder() {
            return (Builder) f21077o.createBuilder();
        }

        /* access modifiers changed from: private */
        /* renamed from: o0 */
        public void m14197o0() {
            this.f21084g = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: p0 */
        public void m14198p0() {
            this.f21088k = getDefaultInstance().getTimeoutEventToLog();
        }

        public static ExperimentPayload parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentPayload) GeneratedMessageLite.parseDelimitedFrom(f21077o, inputStream);
        }

        public static ExperimentPayload parseFrom(ByteBuffer byteBuffer) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(f21077o, byteBuffer);
        }

        public static Parser<ExperimentPayload> parser() {
            return f21077o.getParserForType();
        }

        /* access modifiers changed from: private */
        /* renamed from: q0 */
        public void m14200q0() {
            this.f21082e = getDefaultInstance().getTriggerEvent();
        }

        /* access modifiers changed from: private */
        /* renamed from: r0 */
        public void m14202r0() {
            this.f21083f = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: s0 */
        public void m14204s0() {
            this.f21089l = getDefaultInstance().getTtlExpiryEventToLog();
        }

        /* access modifiers changed from: private */
        /* renamed from: t0 */
        public void m14206t0() {
            this.f21080c = getDefaultInstance().getVariantId();
        }

        /* renamed from: u0 */
        private void m14208u0() {
            if (!this.f21091n.isModifiable()) {
                this.f21091n = GeneratedMessageLite.mutableCopy(this.f21091n);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: v0 */
        public void m14210v0(int i) {
            m14208u0();
            this.f21091n.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: w0 */
        public void m14212w0(String str) {
            str.getClass();
            this.f21086i = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: x0 */
        public void m14214x0(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f21086i = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        /* renamed from: y0 */
        public void m14216y0(String str) {
            str.getClass();
            this.f21087j = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: z0 */
        public void m14218z0(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f21087j = byteString.toStringUtf8();
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (C3921a.f21096a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentPayload();
                case 2:
                    return new Builder((C3921a) null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(f21077o, "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0002\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\f\f\r\u001b", new Object[]{"experimentId_", "variantId_", "experimentStartTimeMillis_", "triggerEvent_", "triggerTimeoutMillis_", "timeToLiveMillis_", "setEventToLog_", "activateEventToLog_", "clearEventToLog_", "timeoutEventToLog_", "ttlExpiryEventToLog_", "overflowPolicy_", "ongoingExperiments_", ExperimentLite.class});
                case 4:
                    return f21077o;
                case 5:
                    Parser<ExperimentPayload> parser = f21078p;
                    if (parser == null) {
                        synchronized (ExperimentPayload.class) {
                            parser = f21078p;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(f21077o);
                                f21078p = parser;
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

        public String getActivateEventToLog() {
            return this.f21086i;
        }

        public ByteString getActivateEventToLogBytes() {
            return ByteString.copyFromUtf8(this.f21086i);
        }

        public String getClearEventToLog() {
            return this.f21087j;
        }

        public ByteString getClearEventToLogBytes() {
            return ByteString.copyFromUtf8(this.f21087j);
        }

        public String getExperimentId() {
            return this.f21079b;
        }

        public ByteString getExperimentIdBytes() {
            return ByteString.copyFromUtf8(this.f21079b);
        }

        public long getExperimentStartTimeMillis() {
            return this.f21081d;
        }

        public ExperimentLite getOngoingExperiments(int i) {
            return this.f21091n.get(i);
        }

        public int getOngoingExperimentsCount() {
            return this.f21091n.size();
        }

        public List<ExperimentLite> getOngoingExperimentsList() {
            return this.f21091n;
        }

        public ExperimentLiteOrBuilder getOngoingExperimentsOrBuilder(int i) {
            return this.f21091n.get(i);
        }

        public List<? extends ExperimentLiteOrBuilder> getOngoingExperimentsOrBuilderList() {
            return this.f21091n;
        }

        public ExperimentOverflowPolicy getOverflowPolicy() {
            ExperimentOverflowPolicy forNumber = ExperimentOverflowPolicy.forNumber(this.f21090m);
            return forNumber == null ? ExperimentOverflowPolicy.UNRECOGNIZED : forNumber;
        }

        public int getOverflowPolicyValue() {
            return this.f21090m;
        }

        public String getSetEventToLog() {
            return this.f21085h;
        }

        public ByteString getSetEventToLogBytes() {
            return ByteString.copyFromUtf8(this.f21085h);
        }

        public long getTimeToLiveMillis() {
            return this.f21084g;
        }

        public String getTimeoutEventToLog() {
            return this.f21088k;
        }

        public ByteString getTimeoutEventToLogBytes() {
            return ByteString.copyFromUtf8(this.f21088k);
        }

        public String getTriggerEvent() {
            return this.f21082e;
        }

        public ByteString getTriggerEventBytes() {
            return ByteString.copyFromUtf8(this.f21082e);
        }

        public long getTriggerTimeoutMillis() {
            return this.f21083f;
        }

        public String getTtlExpiryEventToLog() {
            return this.f21089l;
        }

        public ByteString getTtlExpiryEventToLogBytes() {
            return ByteString.copyFromUtf8(this.f21089l);
        }

        public String getVariantId() {
            return this.f21080c;
        }

        public ByteString getVariantIdBytes() {
            return ByteString.copyFromUtf8(this.f21080c);
        }

        public static Builder newBuilder(ExperimentPayload experimentPayload) {
            return (Builder) f21077o.createBuilder(experimentPayload);
        }

        public static ExperimentPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseDelimitedFrom(f21077o, inputStream, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(f21077o, byteBuffer, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(ByteString byteString) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(f21077o, byteString);
        }

        public static ExperimentPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(f21077o, byteString, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(byte[] bArr) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(f21077o, bArr);
        }

        public static ExperimentPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(f21077o, bArr, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(InputStream inputStream) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(f21077o, inputStream);
        }

        public static ExperimentPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(f21077o, inputStream, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(f21077o, codedInputStream);
        }

        public static ExperimentPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(f21077o, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ExperimentPayloadOrBuilder extends MessageLiteOrBuilder {
        String getActivateEventToLog();

        ByteString getActivateEventToLogBytes();

        String getClearEventToLog();

        ByteString getClearEventToLogBytes();

        String getExperimentId();

        ByteString getExperimentIdBytes();

        long getExperimentStartTimeMillis();

        ExperimentLite getOngoingExperiments(int i);

        int getOngoingExperimentsCount();

        List<ExperimentLite> getOngoingExperimentsList();

        ExperimentPayload.ExperimentOverflowPolicy getOverflowPolicy();

        int getOverflowPolicyValue();

        String getSetEventToLog();

        ByteString getSetEventToLogBytes();

        long getTimeToLiveMillis();

        String getTimeoutEventToLog();

        ByteString getTimeoutEventToLogBytes();

        String getTriggerEvent();

        ByteString getTriggerEventBytes();

        long getTriggerTimeoutMillis();

        String getTtlExpiryEventToLog();

        ByteString getTtlExpiryEventToLogBytes();

        String getVariantId();

        ByteString getVariantIdBytes();
    }

    /* renamed from: developers.mobile.abt.FirebaseAbt$a */
    static /* synthetic */ class C3921a {

        /* renamed from: a */
        static final /* synthetic */ int[] f21096a;

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
                f21096a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21096a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21096a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21096a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f21096a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f21096a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f21096a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: developers.mobile.abt.FirebaseAbt.C3921a.<clinit>():void");
        }
    }

    private FirebaseAbt() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
