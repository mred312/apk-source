package com.google.firebase.crashlytics.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsCacheBehavior;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.model.AppRequestData;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.network.CreateAppSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.UpdateAppSpiCall;
import java.util.concurrent.Executor;

public class Onboarding {

    /* renamed from: a */
    private final HttpRequestFactory f18962a = new HttpRequestFactory();

    /* renamed from: b */
    private final FirebaseApp f18963b;

    /* renamed from: c */
    private final Context f18964c;

    /* renamed from: d */
    private PackageManager f18965d;

    /* renamed from: e */
    private String f18966e;

    /* renamed from: f */
    private PackageInfo f18967f;

    /* renamed from: g */
    private String f18968g;

    /* renamed from: h */
    private String f18969h;

    /* renamed from: i */
    private String f18970i;

    /* renamed from: j */
    private String f18971j;

    /* renamed from: k */
    private String f18972k;

    /* renamed from: l */
    private IdManager f18973l;

    /* renamed from: m */
    private DataCollectionArbiter f18974m;

    /* renamed from: com.google.firebase.crashlytics.internal.Onboarding$a */
    class C3260a implements SuccessContinuation<AppSettingsData, Void> {

        /* renamed from: a */
        final /* synthetic */ String f18975a;

        /* renamed from: b */
        final /* synthetic */ SettingsController f18976b;

        /* renamed from: c */
        final /* synthetic */ Executor f18977c;

        C3260a(String str, SettingsController settingsController, Executor executor) {
            this.f18975a = str;
            this.f18976b = settingsController;
            this.f18977c = executor;
        }

        @NonNull
        /* renamed from: a */
        public Task<Void> then(@Nullable AppSettingsData appSettingsData) {
            try {
                Onboarding.this.m11220f(appSettingsData, this.f18975a, this.f18976b, this.f18977c, true);
                return null;
            } catch (Exception e) {
                Logger.getLogger().mo20862e("Error performing auto configuration.", e);
                throw e;
            }
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.Onboarding$b */
    class C3261b implements SuccessContinuation<Void, AppSettingsData> {

        /* renamed from: a */
        final /* synthetic */ SettingsController f18979a;

        C3261b(Onboarding onboarding, SettingsController settingsController) {
            this.f18979a = settingsController;
        }

        @NonNull
        /* renamed from: a */
        public Task<AppSettingsData> then(@Nullable Void voidR) {
            return this.f18979a.getAppSettings();
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.Onboarding$c */
    class C3262c implements Continuation<Void, Object> {
        C3262c(Onboarding onboarding) {
        }

        public Object then(@NonNull Task<Void> task) {
            if (task.isSuccessful()) {
                return null;
            }
            Logger.getLogger().mo20862e("Error fetching settings.", task.getException());
            return null;
        }
    }

    public Onboarding(FirebaseApp firebaseApp, Context context, IdManager idManager, DataCollectionArbiter dataCollectionArbiter) {
        this.f18963b = firebaseApp;
        this.f18964c = context;
        this.f18973l = idManager;
        this.f18974m = dataCollectionArbiter;
    }

    /* renamed from: b */
    private AppRequestData m11217b(String str, String str2) {
        return new AppRequestData(str, str2, m11218c().getAppIdentifier(), this.f18969h, this.f18968g, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(getContext()), str2, this.f18969h, this.f18968g), this.f18971j, DeliveryMechanism.determineFrom(this.f18970i).getId(), this.f18972k, "0");
    }

    /* renamed from: c */
    private IdManager m11218c() {
        return this.f18973l;
    }

    /* renamed from: e */
    private static String m11219e() {
        return CrashlyticsCore.getVersion();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m11220f(AppSettingsData appSettingsData, String str, SettingsController settingsController, Executor executor, boolean z) {
        if (AppSettingsData.STATUS_NEW.equals(appSettingsData.status)) {
            if (m11221g(appSettingsData, str, z)) {
                settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, executor);
            } else {
                Logger.getLogger().mo20862e("Failed to create app with Crashlytics service.", (Throwable) null);
            }
        } else if (AppSettingsData.STATUS_CONFIGURED.equals(appSettingsData.status)) {
            settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, executor);
        } else if (appSettingsData.updateRequired) {
            Logger.getLogger().mo20859d("Server says an update is required - forcing a full App update.");
            m11222h(appSettingsData, str, z);
        }
    }

    /* renamed from: g */
    private boolean m11221g(AppSettingsData appSettingsData, String str, boolean z) {
        return new CreateAppSpiCall(mo20878d(), appSettingsData.url, this.f18962a, m11219e()).invoke(m11217b(appSettingsData.organizationId, str), z);
    }

    /* renamed from: h */
    private boolean m11222h(AppSettingsData appSettingsData, String str, boolean z) {
        return new UpdateAppSpiCall(mo20878d(), appSettingsData.url, this.f18962a, m11219e()).invoke(m11217b(appSettingsData.organizationId, str), z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo20878d() {
        return CommonUtils.getStringsFileValue(this.f18964c, "com.crashlytics.ApiEndpoint");
    }

    public void doOnboarding(Executor executor, SettingsController settingsController) {
        this.f18974m.waitForDataCollectionPermission().onSuccessTask(executor, new C3261b(this, settingsController)).onSuccessTask(executor, new C3260a(this.f18963b.getOptions().getApplicationId(), settingsController, executor));
    }

    public Context getContext() {
        return this.f18964c;
    }

    public boolean onPreExecute() {
        try {
            this.f18970i = this.f18973l.getInstallerPackageName();
            this.f18965d = this.f18964c.getPackageManager();
            String packageName = this.f18964c.getPackageName();
            this.f18966e = packageName;
            PackageInfo packageInfo = this.f18965d.getPackageInfo(packageName, 0);
            this.f18967f = packageInfo;
            this.f18968g = Integer.toString(packageInfo.versionCode);
            String str = this.f18967f.versionName;
            if (str == null) {
                str = IdManager.DEFAULT_VERSION_NAME;
            }
            this.f18969h = str;
            this.f18971j = this.f18965d.getApplicationLabel(this.f18964c.getApplicationInfo()).toString();
            this.f18972k = Integer.toString(this.f18964c.getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.getLogger().mo20862e("Failed init", e);
            return false;
        }
    }

    public SettingsController retrieveSettingsData(Context context, FirebaseApp firebaseApp, Executor executor) {
        SettingsController create = SettingsController.create(context, firebaseApp.getOptions().getApplicationId(), this.f18973l, this.f18962a, this.f18968g, this.f18969h, mo20878d(), this.f18974m);
        create.loadSettingsData(executor).continueWith(executor, new C3262c(this));
        return create;
    }
}
