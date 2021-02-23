package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* renamed from: com.google.firebase.remoteconfig.a */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3509a implements SuccessContinuation {

    /* renamed from: a */
    private static final C3509a f19699a = new C3509a();

    private C3509a() {
    }

    /* renamed from: a */
    public static SuccessContinuation m11876a() {
        return f19699a;
    }

    public Task then(Object obj) {
        return Tasks.forResult(null);
    }
}
