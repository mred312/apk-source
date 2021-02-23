package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.remoteconfig.internal.ConfigContainer;

/* renamed from: com.google.firebase.remoteconfig.f */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3514f implements OnSuccessListener {

    /* renamed from: a */
    private final FirebaseRemoteConfig f19704a;

    private C3514f(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f19704a = firebaseRemoteConfig;
    }

    /* renamed from: a */
    public static OnSuccessListener m11881a(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new C3514f(firebaseRemoteConfig);
    }

    public void onSuccess(Object obj) {
        FirebaseRemoteConfig.m11850d(this.f19704a, (ConfigContainer) obj);
    }
}
