package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.remoteconfig.d */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3512d implements Continuation {

    /* renamed from: a */
    private final Task f19702a;

    private C3512d(Task task) {
        this.f19702a = task;
    }

    /* renamed from: a */
    public static Continuation m11879a(Task task) {
        return new C3512d(task);
    }

    public Object then(Task task) {
        return FirebaseRemoteConfig.m11851e(this.f19702a, task);
    }
}
