package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.k */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3519k implements Callable {

    /* renamed from: a */
    private final FirebaseRemoteConfig f19716a;

    private C3519k(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f19716a = firebaseRemoteConfig;
    }

    /* renamed from: a */
    public static Callable m11887a(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new C3519k(firebaseRemoteConfig);
    }

    public Object call() {
        return FirebaseRemoteConfig.m11855i(this.f19716a);
    }
}
