package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.remoteconfig.b */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3510b implements Continuation {

    /* renamed from: a */
    private final FirebaseRemoteConfig f19700a;

    private C3510b(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f19700a = firebaseRemoteConfig;
    }

    /* renamed from: a */
    public static Continuation m11877a(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new C3510b(firebaseRemoteConfig);
    }

    public Object then(Task task) {
        return Boolean.valueOf(this.f19700a.m11858l(task));
    }
}
