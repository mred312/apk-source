package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.remoteconfig.g */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3515g implements Continuation {

    /* renamed from: a */
    private final FirebaseRemoteConfig f19705a;

    /* renamed from: b */
    private final Task f19706b;

    /* renamed from: c */
    private final Task f19707c;

    private C3515g(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        this.f19705a = firebaseRemoteConfig;
        this.f19706b = task;
        this.f19707c = task2;
    }

    /* renamed from: a */
    public static Continuation m11882a(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        return new C3515g(firebaseRemoteConfig, task, task2);
    }

    public Object then(Task task) {
        return FirebaseRemoteConfig.m11849c(this.f19705a, this.f19706b, this.f19707c, task);
    }
}
