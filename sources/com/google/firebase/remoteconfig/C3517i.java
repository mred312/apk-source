package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* renamed from: com.google.firebase.remoteconfig.i */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3517i implements SuccessContinuation {

    /* renamed from: a */
    private static final C3517i f19709a = new C3517i();

    private C3517i() {
    }

    /* renamed from: a */
    public static SuccessContinuation m11884a() {
        return f19709a;
    }

    public Task then(Object obj) {
        return Tasks.forResult(null);
    }
}
