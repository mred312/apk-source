package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.j */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3518j implements Callable {

    /* renamed from: a */
    private final FirebaseRemoteConfig f19714a;

    /* renamed from: b */
    private final FirebaseRemoteConfigSettings f19715b;

    private C3518j(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.f19714a = firebaseRemoteConfig;
        this.f19715b = firebaseRemoteConfigSettings;
    }

    /* renamed from: a */
    public static Callable m11886a(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return new C3518j(firebaseRemoteConfig, firebaseRemoteConfigSettings);
    }

    public Object call() {
        return this.f19714a.f19678i.setConfigSettings(this.f19715b);
    }
}
