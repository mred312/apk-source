package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsRegistrar implements ComponentRegistrar {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public FirebaseCrashlytics m11196b(ComponentContainer componentContainer) {
        return FirebaseCrashlytics.m11197a((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), (CrashlyticsNativeComponent) componentContainer.get(CrashlyticsNativeComponent.class), (AnalyticsConnector) componentContainer.get(AnalyticsConnector.class));
    }

    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseCrashlytics.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.optional(AnalyticsConnector.class)).add(Dependency.optional(CrashlyticsNativeComponent.class)).factory(C3257b.m11204a(this)).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-cls", BuildConfig.VERSION_NAME)});
    }
}
