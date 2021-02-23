package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.remoteconfig.e */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3513e implements SuccessContinuation {

    /* renamed from: a */
    private final FirebaseRemoteConfig f19703a;

    private C3513e(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f19703a = firebaseRemoteConfig;
    }

    /* renamed from: a */
    public static SuccessContinuation m11880a(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new C3513e(firebaseRemoteConfig);
    }

    public Task then(Object obj) {
        return this.f19703a.activate();
    }
}
