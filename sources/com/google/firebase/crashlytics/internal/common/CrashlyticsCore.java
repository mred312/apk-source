package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.BuildConfig;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStoreImpl;
import com.google.firebase.crashlytics.internal.report.ReportManager;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CrashlyticsCore {

    /* renamed from: a */
    private final Context f19007a;

    /* renamed from: b */
    private final FirebaseApp f19008b;

    /* renamed from: c */
    private final DataCollectionArbiter f19009c;

    /* renamed from: d */
    private final long f19010d = System.currentTimeMillis();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C3324j f19011e;

    /* renamed from: f */
    private C3324j f19012f;

    /* renamed from: g */
    private boolean f19013g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C3287h f19014h;

    /* renamed from: i */
    private final IdManager f19015i;

    /* renamed from: j */
    private final BreadcrumbSource f19016j;

    /* renamed from: k */
    private final AnalyticsEventLogger f19017k;

    /* renamed from: l */
    private ExecutorService f19018l;

    /* renamed from: m */
    private C3281f f19019m;

    /* renamed from: n */
    private CrashlyticsNativeComponent f19020n;

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$a */
    class C3265a implements Callable<Task<Void>> {

        /* renamed from: a */
        final /* synthetic */ SettingsDataProvider f19021a;

        C3265a(SettingsDataProvider settingsDataProvider) {
            this.f19021a = settingsDataProvider;
        }

        /* renamed from: a */
        public Task<Void> call() {
            return CrashlyticsCore.this.m11238f(this.f19021a);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$b */
    class C3266b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ SettingsDataProvider f19023a;

        C3266b(SettingsDataProvider settingsDataProvider) {
            this.f19023a = settingsDataProvider;
        }

        public void run() {
            Task unused = CrashlyticsCore.this.m11238f(this.f19023a);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$c */
    class C3267c implements Callable<Boolean> {
        C3267c() {
        }

        /* renamed from: a */
        public Boolean call() {
            try {
                boolean d = CrashlyticsCore.this.f19011e.mo21030d();
                Logger logger = Logger.getLogger();
                logger.mo20859d("Initialization marker file removed: " + d);
                return Boolean.valueOf(d);
            } catch (Exception e) {
                Logger.getLogger().mo20862e("Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.FALSE;
            }
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$d */
    class C3268d implements Callable<Boolean> {
        C3268d() {
        }

        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(CrashlyticsCore.this.f19014h.mo20972L());
        }
    }

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, ExecutorService executorService) {
        this.f19008b = firebaseApp;
        this.f19009c = dataCollectionArbiter;
        this.f19007a = firebaseApp.getApplicationContext();
        this.f19015i = idManager;
        this.f19020n = crashlyticsNativeComponent;
        this.f19016j = breadcrumbSource;
        this.f19017k = analyticsEventLogger;
        this.f19018l = executorService;
        this.f19019m = new C3281f(executorService);
    }

    /* renamed from: d */
    private void m11237d() {
        try {
            this.f19013g = Boolean.TRUE.equals((Boolean) Utils.awaitEvenIfOnMainThread(this.f19019m.mo20957h(new C3268d())));
        } catch (Exception unused) {
            this.f19013g = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public Task<Void> m11238f(SettingsDataProvider settingsDataProvider) {
        mo20902j();
        this.f19014h.mo20967E();
        try {
            this.f19016j.registerBreadcrumbHandler(C3323i.m11438a(this));
            Settings settings = settingsDataProvider.getSettings();
            if (!settings.getFeaturesData().collectReports) {
                Logger.getLogger().mo20859d("Collection of crash reports disabled in Crashlytics settings.");
                return Tasks.forException(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f19014h.mo20977W(settings.getSessionData().maxCustomExceptionEvents)) {
                Logger.getLogger().mo20859d("Could not finalize previous sessions.");
            }
            Task<Void> F0 = this.f19014h.mo20969F0(1.0f, settingsDataProvider.getAppSettings());
            mo20901i();
            return F0;
        } catch (Exception e) {
            Logger.getLogger().mo20862e("Crashlytics encountered a problem during asynchronous initialization.", e);
            return Tasks.forException(e);
        } finally {
            mo20901i();
        }
    }

    /* renamed from: g */
    private void m11239g(SettingsDataProvider settingsDataProvider) {
        Future<?> submit = this.f19018l.submit(new C3266b(settingsDataProvider));
        Logger.getLogger().mo20859d("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Logger.getLogger().mo20862e("Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            Logger.getLogger().mo20862e("Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            Logger.getLogger().mo20862e("Crashlytics timed out during initialization.", e3);
        }
    }

    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    /* renamed from: h */
    static boolean m11240h(String str, boolean z) {
        if (!z) {
            Logger.getLogger().mo20859d("Configured not to require a build ID.");
            return true;
        } else if (!CommonUtils.isNullOrEmpty(str)) {
            return true;
        } else {
            Log.e(Logger.TAG, ".");
            Log.e(Logger.TAG, ".     |  | ");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".   \\ |  | /");
            Log.e(Logger.TAG, ".    \\    /");
            Log.e(Logger.TAG, ".     \\  /");
            Log.e(Logger.TAG, ".      \\/");
            Log.e(Logger.TAG, ".");
            Log.e(Logger.TAG, "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
            Log.e(Logger.TAG, ".");
            Log.e(Logger.TAG, ".      /\\");
            Log.e(Logger.TAG, ".     /  \\");
            Log.e(Logger.TAG, ".    /    \\");
            Log.e(Logger.TAG, ".   / |  | \\");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".");
            return false;
        }
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        return this.f19014h.mo20965D();
    }

    public Task<Void> deleteUnsentReports() {
        return this.f19014h.mo20971K();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.f19013g;
    }

    public Task<Void> doBackgroundInitializationAsync(SettingsDataProvider settingsDataProvider) {
        return Utils.callTask(this.f19018l, new C3265a(settingsDataProvider));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo20900e() {
        return this.f19011e.mo21029c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo20901i() {
        this.f19019m.mo20957h(new C3267c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo20902j() {
        this.f19019m.mo20954b();
        this.f19011e.mo21028a();
        Logger.getLogger().mo20859d("Initialization marker file created.");
    }

    public void log(String str) {
        this.f19014h.mo20978X0(System.currentTimeMillis() - this.f19010d, str);
    }

    public void logException(@NonNull Throwable th) {
        this.f19014h.mo20975O0(Thread.currentThread(), th);
    }

    public boolean onPreExecute(SettingsDataProvider settingsDataProvider) {
        String mappingFileId = CommonUtils.getMappingFileId(this.f19007a);
        Logger logger = Logger.getLogger();
        logger.mo20859d("Mapping file ID is: " + mappingFileId);
        if (m11240h(mappingFileId, CommonUtils.getBooleanResourceValue(this.f19007a, "com.crashlytics.RequireBuildId", true))) {
            String applicationId = this.f19008b.getOptions().getApplicationId();
            try {
                Logger logger2 = Logger.getLogger();
                logger2.mo20863i("Initializing Crashlytics " + getVersion());
                FileStoreImpl fileStoreImpl = new FileStoreImpl(this.f19007a);
                this.f19012f = new C3324j("crash_marker", fileStoreImpl);
                this.f19011e = new C3324j("initialization_marker", fileStoreImpl);
                HttpRequestFactory httpRequestFactory = new HttpRequestFactory();
                C3276a a = C3276a.m11287a(this.f19007a, this.f19015i, applicationId, mappingFileId);
                ResourceUnityVersionProvider resourceUnityVersionProvider = new ResourceUnityVersionProvider(this.f19007a);
                Logger logger3 = Logger.getLogger();
                logger3.mo20859d("Installer package name is: " + a.f19068c);
                this.f19014h = new C3287h(this.f19007a, this.f19019m, httpRequestFactory, this.f19015i, this.f19009c, fileStoreImpl, this.f19012f, a, (ReportManager) null, (ReportUploader.Provider) null, this.f19020n, resourceUnityVersionProvider, this.f19017k, settingsDataProvider);
                boolean e = mo20900e();
                m11237d();
                this.f19014h.mo20976T(Thread.getDefaultUncaughtExceptionHandler(), settingsDataProvider);
                if (!e || !CommonUtils.canTryConnection(this.f19007a)) {
                    Logger.getLogger().mo20859d("Exception handling initialization successful");
                    return true;
                }
                Logger.getLogger().mo20859d("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                m11239g(settingsDataProvider);
                return false;
            } catch (Exception e2) {
                Logger.getLogger().mo20862e("Crashlytics was not started due to an exception during initialization", e2);
                this.f19014h = null;
                return false;
            }
        } else {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        }
    }

    public Task<Void> sendUnsentReports() {
        return this.f19014h.mo20964C0();
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.f19009c.setCrashlyticsDataCollectionEnabled(bool);
    }

    public void setCustomKey(String str, String str2) {
        this.f19014h.mo20966D0(str, str2);
    }

    public void setUserId(String str) {
        this.f19014h.mo20968E0(str);
    }
}
