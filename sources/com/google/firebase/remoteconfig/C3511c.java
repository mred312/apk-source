package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.c */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3511c implements Callable {

    /* renamed from: a */
    private final FirebaseRemoteConfig f19701a;

    private C3511c(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f19701a = firebaseRemoteConfig;
    }

    /* renamed from: a */
    public static Callable m11878a(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new C3511c(firebaseRemoteConfig);
    }

    public Object call() {
        return this.f19701a.getInfo();
    }
}
