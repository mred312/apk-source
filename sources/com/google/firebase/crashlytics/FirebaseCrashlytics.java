package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.Onboarding;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class FirebaseCrashlytics {

    /* renamed from: a */
    private final CrashlyticsCore f18949a;

    /* renamed from: com.google.firebase.crashlytics.FirebaseCrashlytics$a */
    class C3252a implements Callable<Void> {

        /* renamed from: a */
        final /* synthetic */ Onboarding f18950a;

        /* renamed from: b */
        final /* synthetic */ ExecutorService f18951b;

        /* renamed from: c */
        final /* synthetic */ SettingsController f18952c;

        /* renamed from: d */
        final /* synthetic */ boolean f18953d;

        /* renamed from: e */
        final /* synthetic */ CrashlyticsCore f18954e;

        C3252a(Onboarding onboarding, ExecutorService executorService, SettingsController settingsController, boolean z, CrashlyticsCore crashlyticsCore) {
            this.f18950a = onboarding;
            this.f18951b = executorService;
            this.f18952c = settingsController;
            this.f18953d = z;
            this.f18954e = crashlyticsCore;
        }

        /* renamed from: a */
        public Void call() {
            this.f18950a.doOnboarding(this.f18951b, this.f18952c);
            if (!this.f18953d) {
                return null;
            }
            this.f18954e.doBackgroundInitializationAsync(this.f18952c);
            return null;
        }
    }

    private FirebaseCrashlytics(@NonNull CrashlyticsCore crashlyticsCore) {
        this.f18949a = crashlyticsCore;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.google.firebase.crashlytics.internal.MissingNativeComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger} */
    /* JADX WARNING: type inference failed for: r0v16, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver] */
    /* JADX WARNING: type inference failed for: r6v2, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.firebase.crashlytics.FirebaseCrashlytics m11197a(@androidx.annotation.NonNull com.google.firebase.FirebaseApp r16, @androidx.annotation.NonNull com.google.firebase.installations.FirebaseInstallationsApi r17, @androidx.annotation.Nullable com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent r18, @androidx.annotation.Nullable com.google.firebase.analytics.connector.AnalyticsConnector r19) {
        /*
            r8 = r16
            r0 = r19
            android.content.Context r9 = r16.getApplicationContext()
            java.lang.String r1 = r9.getPackageName()
            com.google.firebase.crashlytics.internal.common.IdManager r2 = new com.google.firebase.crashlytics.internal.common.IdManager
            r3 = r17
            r2.<init>(r9, r1, r3)
            com.google.firebase.crashlytics.internal.common.DataCollectionArbiter r4 = new com.google.firebase.crashlytics.internal.common.DataCollectionArbiter
            r4.<init>(r8)
            if (r18 != 0) goto L_0x0021
            com.google.firebase.crashlytics.internal.MissingNativeComponent r1 = new com.google.firebase.crashlytics.internal.MissingNativeComponent
            r1.<init>()
            r3 = r1
            goto L_0x0023
        L_0x0021:
            r3 = r18
        L_0x0023:
            com.google.firebase.crashlytics.internal.Onboarding r11 = new com.google.firebase.crashlytics.internal.Onboarding
            r11.<init>(r8, r9, r2, r4)
            if (r0 == 0) goto L_0x0071
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r5 = "Firebase Analytics is available."
            r1.mo20859d(r5)
            com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger r1 = new com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger
            r1.<init>(r0)
            com.google.firebase.crashlytics.a r5 = new com.google.firebase.crashlytics.a
            r5.<init>()
            com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorHandle r0 = m11198b(r0, r5)
            if (r0 == 0) goto L_0x0062
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r6 = "Firebase Analytics listener registered successfully."
            r0.mo20859d(r6)
            com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver r0 = new com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver
            r0.<init>()
            com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger r6 = new com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger
            r7 = 500(0x1f4, float:7.0E-43)
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS
            r6.<init>(r1, r7, r10)
            r5.mo20849c(r0)
            r5.mo20850d(r6)
            r1 = r6
            goto L_0x0084
        L_0x0062:
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r5 = "Firebase Analytics listener registration failed."
            r0.mo20859d(r5)
            com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource r0 = new com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource
            r0.<init>()
            goto L_0x0084
        L_0x0071:
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r1 = "Firebase Analytics is unavailable."
            r0.mo20859d(r1)
            com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource r0 = new com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource
            r0.<init>()
            com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger r1 = new com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger
            r1.<init>()
        L_0x0084:
            r5 = r0
            r6 = r1
            java.lang.String r0 = "Crashlytics Exception Handler"
            java.util.concurrent.ExecutorService r7 = com.google.firebase.crashlytics.internal.common.ExecutorUtils.buildSingleThreadExecutorService(r0)
            com.google.firebase.crashlytics.internal.common.CrashlyticsCore r15 = new com.google.firebase.crashlytics.internal.common.CrashlyticsCore
            r0 = r15
            r1 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r11.onPreExecute()
            if (r0 != 0) goto L_0x00a5
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r1 = "Unable to start Crashlytics."
            r0.mo20861e(r1)
            r0 = 0
            return r0
        L_0x00a5:
            java.lang.String r0 = "com.google.firebase.crashlytics.startup"
            java.util.concurrent.ExecutorService r0 = com.google.firebase.crashlytics.internal.common.ExecutorUtils.buildSingleThreadExecutorService(r0)
            com.google.firebase.crashlytics.internal.settings.SettingsController r13 = r11.retrieveSettingsData(r9, r8, r0)
            boolean r14 = r15.onPreExecute(r13)
            com.google.firebase.crashlytics.FirebaseCrashlytics$a r1 = new com.google.firebase.crashlytics.FirebaseCrashlytics$a
            r10 = r1
            r12 = r0
            r2 = r15
            r10.<init>(r11, r12, r13, r14, r15)
            com.google.android.gms.tasks.Tasks.call(r0, r1)
            com.google.firebase.crashlytics.FirebaseCrashlytics r0 = new com.google.firebase.crashlytics.FirebaseCrashlytics
            r0.<init>(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.FirebaseCrashlytics.m11197a(com.google.firebase.FirebaseApp, com.google.firebase.installations.FirebaseInstallationsApi, com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent, com.google.firebase.analytics.connector.AnalyticsConnector):com.google.firebase.crashlytics.FirebaseCrashlytics");
    }

    /* renamed from: b */
    private static AnalyticsConnector.AnalyticsConnectorHandle m11198b(@NonNull AnalyticsConnector analyticsConnector, @NonNull C3256a aVar) {
        AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener("clx", aVar);
        if (registerAnalyticsConnectorListener == null) {
            Logger.getLogger().mo20859d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener("crash", aVar);
            if (registerAnalyticsConnectorListener != null) {
                Logger.getLogger().mo20869w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return registerAnalyticsConnectorListener;
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        return this.f18949a.checkForUnsentReports();
    }

    public void deleteUnsentReports() {
        this.f18949a.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.f18949a.didCrashOnPreviousExecution();
    }

    public void log(@NonNull String str) {
        this.f18949a.log(str);
    }

    public void recordException(@NonNull Throwable th) {
        if (th == null) {
            Logger.getLogger().mo20869w("Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.f18949a.logException(th);
        }
    }

    public void sendUnsentReports() {
        this.f18949a.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.f18949a.setCrashlyticsCollectionEnabled(Boolean.valueOf(z));
    }

    public void setCustomKey(@NonNull String str, boolean z) {
        this.f18949a.setCustomKey(str, Boolean.toString(z));
    }

    public void setUserId(@NonNull String str) {
        this.f18949a.setUserId(str);
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.f18949a.setCrashlyticsCollectionEnabled(bool);
    }

    public void setCustomKey(@NonNull String str, double d) {
        this.f18949a.setCustomKey(str, Double.toString(d));
    }

    public void setCustomKey(@NonNull String str, float f) {
        this.f18949a.setCustomKey(str, Float.toString(f));
    }

    public void setCustomKey(@NonNull String str, int i) {
        this.f18949a.setCustomKey(str, Integer.toString(i));
    }

    public void setCustomKey(@NonNull String str, long j) {
        this.f18949a.setCustomKey(str, Long.toString(j));
    }

    public void setCustomKey(@NonNull String str, @NonNull String str2) {
        this.f18949a.setCustomKey(str, str2);
    }
}
