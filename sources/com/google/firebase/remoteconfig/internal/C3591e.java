package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.remoteconfig.internal.e */
/* compiled from: ConfigFetchHandler */
final /* synthetic */ class C3591e implements Continuation {

    /* renamed from: a */
    private final ConfigFetchHandler f20291a;

    /* renamed from: b */
    private final long f20292b;

    private C3591e(ConfigFetchHandler configFetchHandler, long j) {
        this.f20291a = configFetchHandler;
        this.f20292b = j;
    }

    /* renamed from: a */
    public static Continuation m12185a(ConfigFetchHandler configFetchHandler, long j) {
        return new C3591e(configFetchHandler, j);
    }

    public Object then(Task task) {
        return this.f20291a.m12109f(task, this.f20292b);
    }
}
