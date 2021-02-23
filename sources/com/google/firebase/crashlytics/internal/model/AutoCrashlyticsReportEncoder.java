package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.ads.adunit.AdUnitActivity;

public final class AutoCrashlyticsReportEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 1;
    public static final Configurator CONFIG = new AutoCrashlyticsReportEncoder();

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$a */
    private static final class C3346a implements ObjectEncoder<CrashlyticsReport.CustomAttribute> {

        /* renamed from: a */
        static final C3346a f19237a = new C3346a();

        private C3346a() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.CustomAttribute customAttribute, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("key", (Object) customAttribute.getKey());
            objectEncoderContext.add("value", (Object) customAttribute.getValue());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$b */
    private static final class C3347b implements ObjectEncoder<CrashlyticsReport> {

        /* renamed from: a */
        static final C3347b f19238a = new C3347b();

        private C3347b() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport crashlyticsReport, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, (Object) crashlyticsReport.getSdkVersion());
            objectEncoderContext.add("gmpAppId", (Object) crashlyticsReport.getGmpAppId());
            objectEncoderContext.add("platform", crashlyticsReport.getPlatform());
            objectEncoderContext.add("installationUuid", (Object) crashlyticsReport.getInstallationUuid());
            objectEncoderContext.add("buildVersion", (Object) crashlyticsReport.getBuildVersion());
            objectEncoderContext.add("displayVersion", (Object) crashlyticsReport.getDisplayVersion());
            objectEncoderContext.add("session", (Object) crashlyticsReport.getSession());
            objectEncoderContext.add("ndkPayload", (Object) crashlyticsReport.getNdkPayload());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$c */
    private static final class C3348c implements ObjectEncoder<CrashlyticsReport.FilesPayload> {

        /* renamed from: a */
        static final C3348c f19239a = new C3348c();

        private C3348c() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.FilesPayload filesPayload, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("files", (Object) filesPayload.getFiles());
            objectEncoderContext.add("orgId", (Object) filesPayload.getOrgId());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$d */
    private static final class C3349d implements ObjectEncoder<CrashlyticsReport.FilesPayload.File> {

        /* renamed from: a */
        static final C3349d f19240a = new C3349d();

        private C3349d() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.FilesPayload.File file, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("filename", (Object) file.getFilename());
            objectEncoderContext.add("contents", (Object) file.getContents());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$e */
    private static final class C3350e implements ObjectEncoder<CrashlyticsReport.Session.Application> {

        /* renamed from: a */
        static final C3350e f19241a = new C3350e();

        private C3350e() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Application application, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("identifier", (Object) application.getIdentifier());
            objectEncoderContext.add(MediationMetaData.KEY_VERSION, (Object) application.getVersion());
            objectEncoderContext.add("displayVersion", (Object) application.getDisplayVersion());
            objectEncoderContext.add("organization", (Object) application.getOrganization());
            objectEncoderContext.add("installationUuid", (Object) application.getInstallationUuid());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$f */
    private static final class C3351f implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization> {

        /* renamed from: a */
        static final C3351f f19242a = new C3351f();

        private C3351f() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Application.Organization organization, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("clsId", (Object) organization.getClsId());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$g */
    private static final class C3352g implements ObjectEncoder<CrashlyticsReport.Session.Device> {

        /* renamed from: a */
        static final C3352g f19243a = new C3352g();

        private C3352g() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Device device, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("arch", device.getArch());
            objectEncoderContext.add("model", (Object) device.getModel());
            objectEncoderContext.add("cores", device.getCores());
            objectEncoderContext.add("ram", device.getRam());
            objectEncoderContext.add("diskSpace", device.getDiskSpace());
            objectEncoderContext.add("simulator", device.isSimulator());
            objectEncoderContext.add(RemoteConfigConstants.ResponseFieldKey.STATE, device.getState());
            objectEncoderContext.add("manufacturer", (Object) device.getManufacturer());
            objectEncoderContext.add("modelClass", (Object) device.getModelClass());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$h */
    private static final class C3353h implements ObjectEncoder<CrashlyticsReport.Session> {

        /* renamed from: a */
        static final C3353h f19244a = new C3353h();

        private C3353h() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session session, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("generator", (Object) session.getGenerator());
            objectEncoderContext.add("identifier", (Object) session.getIdentifierUtf8Bytes());
            objectEncoderContext.add("startedAt", session.getStartedAt());
            objectEncoderContext.add("endedAt", (Object) session.getEndedAt());
            objectEncoderContext.add("crashed", session.isCrashed());
            objectEncoderContext.add("app", (Object) session.getApp());
            objectEncoderContext.add("user", (Object) session.getUser());
            objectEncoderContext.add("os", (Object) session.getOs());
            objectEncoderContext.add("device", (Object) session.getDevice());
            objectEncoderContext.add("events", (Object) session.getEvents());
            objectEncoderContext.add("generatorType", session.getGeneratorType());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$i */
    private static final class C3354i implements ObjectEncoder<CrashlyticsReport.Session.Event.Application> {

        /* renamed from: a */
        static final C3354i f19245a = new C3354i();

        private C3354i() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application application, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("execution", (Object) application.getExecution());
            objectEncoderContext.add("customAttributes", (Object) application.getCustomAttributes());
            objectEncoderContext.add("background", (Object) application.getBackground());
            objectEncoderContext.add("uiOrientation", application.getUiOrientation());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$j */
    private static final class C3355j implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> {

        /* renamed from: a */
        static final C3355j f19246a = new C3355j();

        private C3355j() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("baseAddress", binaryImage.getBaseAddress());
            objectEncoderContext.add("size", binaryImage.getSize());
            objectEncoderContext.add("name", (Object) binaryImage.getName());
            objectEncoderContext.add("uuid", (Object) binaryImage.getUuidUtf8Bytes());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$k */
    private static final class C3356k implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution> {

        /* renamed from: a */
        static final C3356k f19247a = new C3356k();

        private C3356k() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution execution, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("threads", (Object) execution.getThreads());
            objectEncoderContext.add("exception", (Object) execution.getException());
            objectEncoderContext.add("signal", (Object) execution.getSignal());
            objectEncoderContext.add("binaries", (Object) execution.getBinaries());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$l */
    private static final class C3357l implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception> {

        /* renamed from: a */
        static final C3357l f19248a = new C3357l();

        private C3357l() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Exception exception, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("type", (Object) exception.getType());
            objectEncoderContext.add("reason", (Object) exception.getReason());
            objectEncoderContext.add("frames", (Object) exception.getFrames());
            objectEncoderContext.add("causedBy", (Object) exception.getCausedBy());
            objectEncoderContext.add("overflowCount", exception.getOverflowCount());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$m */
    private static final class C3358m implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal> {

        /* renamed from: a */
        static final C3358m f19249a = new C3358m();

        private C3358m() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("name", (Object) signal.getName());
            objectEncoderContext.add("code", (Object) signal.getCode());
            objectEncoderContext.add("address", signal.getAddress());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$n */
    private static final class C3359n implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread> {

        /* renamed from: a */
        static final C3359n f19250a = new C3359n();

        private C3359n() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Thread thread, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("name", (Object) thread.getName());
            objectEncoderContext.add("importance", thread.getImportance());
            objectEncoderContext.add("frames", (Object) thread.getFrames());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$o */
    private static final class C3360o implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> {

        /* renamed from: a */
        static final C3360o f19251a = new C3360o();

        private C3360o() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("pc", frame.getPc());
            objectEncoderContext.add("symbol", (Object) frame.getSymbol());
            objectEncoderContext.add("file", (Object) frame.getFile());
            objectEncoderContext.add("offset", frame.getOffset());
            objectEncoderContext.add("importance", frame.getImportance());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$p */
    private static final class C3361p implements ObjectEncoder<CrashlyticsReport.Session.Event.Device> {

        /* renamed from: a */
        static final C3361p f19252a = new C3361p();

        private C3361p() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Device device, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("batteryLevel", (Object) device.getBatteryLevel());
            objectEncoderContext.add("batteryVelocity", device.getBatteryVelocity());
            objectEncoderContext.add("proximityOn", device.isProximityOn());
            objectEncoderContext.add(AdUnitActivity.EXTRA_ORIENTATION, device.getOrientation());
            objectEncoderContext.add("ramUsed", device.getRamUsed());
            objectEncoderContext.add("diskUsed", device.getDiskUsed());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$q */
    private static final class C3362q implements ObjectEncoder<CrashlyticsReport.Session.Event> {

        /* renamed from: a */
        static final C3362q f19253a = new C3362q();

        private C3362q() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event event, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("timestamp", event.getTimestamp());
            objectEncoderContext.add("type", (Object) event.getType());
            objectEncoderContext.add("app", (Object) event.getApp());
            objectEncoderContext.add("device", (Object) event.getDevice());
            objectEncoderContext.add("log", (Object) event.getLog());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$r */
    private static final class C3363r implements ObjectEncoder<CrashlyticsReport.Session.Event.Log> {

        /* renamed from: a */
        static final C3363r f19254a = new C3363r();

        private C3363r() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Log log, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(FirebaseAnalytics.Param.CONTENT, (Object) log.getContent());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$s */
    private static final class C3364s implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem> {

        /* renamed from: a */
        static final C3364s f19255a = new C3364s();

        private C3364s() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.OperatingSystem operatingSystem, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("platform", operatingSystem.getPlatform());
            objectEncoderContext.add(MediationMetaData.KEY_VERSION, (Object) operatingSystem.getVersion());
            objectEncoderContext.add("buildVersion", (Object) operatingSystem.getBuildVersion());
            objectEncoderContext.add("jailbroken", operatingSystem.isJailbroken());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder$t */
    private static final class C3365t implements ObjectEncoder<CrashlyticsReport.Session.User> {

        /* renamed from: a */
        static final C3365t f19256a = new C3365t();

        private C3365t() {
        }

        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.User user, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("identifier", (Object) user.getIdentifier());
        }
    }

    private AutoCrashlyticsReportEncoder() {
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        C3347b bVar = C3347b.f19238a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.class, (ObjectEncoder<? super U>) bVar);
        encoderConfig.registerEncoder((Class<U>) C3366a.class, (ObjectEncoder<? super U>) bVar);
        C3353h hVar = C3353h.f19244a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.class, (ObjectEncoder<? super U>) hVar);
        encoderConfig.registerEncoder((Class<U>) C3378e.class, (ObjectEncoder<? super U>) hVar);
        C3350e eVar = C3350e.f19241a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Application.class, (ObjectEncoder<? super U>) eVar);
        encoderConfig.registerEncoder((Class<U>) C3381f.class, (ObjectEncoder<? super U>) eVar);
        C3351f fVar = C3351f.f19242a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Application.Organization.class, (ObjectEncoder<? super U>) fVar);
        encoderConfig.registerEncoder((Class<U>) C3384g.class, (ObjectEncoder<? super U>) fVar);
        C3365t tVar = C3365t.f19256a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.User.class, (ObjectEncoder<? super U>) tVar);
        encoderConfig.registerEncoder((Class<U>) C3431t.class, (ObjectEncoder<? super U>) tVar);
        C3364s sVar = C3364s.f19255a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.OperatingSystem.class, (ObjectEncoder<? super U>) sVar);
        encoderConfig.registerEncoder((Class<U>) C3420s.class, (ObjectEncoder<? super U>) sVar);
        C3352g gVar = C3352g.f19243a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Device.class, (ObjectEncoder<? super U>) gVar);
        encoderConfig.registerEncoder((Class<U>) C3387h.class, (ObjectEncoder<? super U>) gVar);
        C3362q qVar = C3362q.f19253a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Event.class, (ObjectEncoder<? super U>) qVar);
        encoderConfig.registerEncoder((Class<U>) C3390i.class, (ObjectEncoder<? super U>) qVar);
        C3354i iVar = C3354i.f19245a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Event.Application.class, (ObjectEncoder<? super U>) iVar);
        encoderConfig.registerEncoder((Class<U>) C3393j.class, (ObjectEncoder<? super U>) iVar);
        C3356k kVar = C3356k.f19247a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Event.Application.Execution.class, (ObjectEncoder<? super U>) kVar);
        encoderConfig.registerEncoder((Class<U>) C3396k.class, (ObjectEncoder<? super U>) kVar);
        C3359n nVar = C3359n.f19250a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Event.Application.Execution.Thread.class, (ObjectEncoder<? super U>) nVar);
        encoderConfig.registerEncoder((Class<U>) C3408o.class, (ObjectEncoder<? super U>) nVar);
        C3360o oVar = C3360o.f19251a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, (ObjectEncoder<? super U>) oVar);
        encoderConfig.registerEncoder((Class<U>) C3411p.class, (ObjectEncoder<? super U>) oVar);
        C3357l lVar = C3357l.f19248a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Event.Application.Execution.Exception.class, (ObjectEncoder<? super U>) lVar);
        encoderConfig.registerEncoder((Class<U>) C3402m.class, (ObjectEncoder<? super U>) lVar);
        C3358m mVar = C3358m.f19249a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Event.Application.Execution.Signal.class, (ObjectEncoder<? super U>) mVar);
        encoderConfig.registerEncoder((Class<U>) C3405n.class, (ObjectEncoder<? super U>) mVar);
        C3355j jVar = C3355j.f19246a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, (ObjectEncoder<? super U>) jVar);
        encoderConfig.registerEncoder((Class<U>) C3399l.class, (ObjectEncoder<? super U>) jVar);
        C3346a aVar = C3346a.f19237a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.CustomAttribute.class, (ObjectEncoder<? super U>) aVar);
        encoderConfig.registerEncoder((Class<U>) C3369b.class, (ObjectEncoder<? super U>) aVar);
        C3361p pVar = C3361p.f19252a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Event.Device.class, (ObjectEncoder<? super U>) pVar);
        encoderConfig.registerEncoder((Class<U>) C3414q.class, (ObjectEncoder<? super U>) pVar);
        C3363r rVar = C3363r.f19254a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.Session.Event.Log.class, (ObjectEncoder<? super U>) rVar);
        encoderConfig.registerEncoder((Class<U>) C3417r.class, (ObjectEncoder<? super U>) rVar);
        C3348c cVar = C3348c.f19239a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.FilesPayload.class, (ObjectEncoder<? super U>) cVar);
        encoderConfig.registerEncoder((Class<U>) C3372c.class, (ObjectEncoder<? super U>) cVar);
        C3349d dVar = C3349d.f19240a;
        encoderConfig.registerEncoder((Class<U>) CrashlyticsReport.FilesPayload.File.class, (ObjectEncoder<? super U>) dVar);
        encoderConfig.registerEncoder((Class<U>) C3375d.class, (ObjectEncoder<? super U>) dVar);
    }
}
