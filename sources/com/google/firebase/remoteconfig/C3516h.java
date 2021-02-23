package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* renamed from: com.google.firebase.remoteconfig.h */
/* compiled from: FirebaseRemoteConfig */
final /* synthetic */ class C3516h implements SuccessContinuation {

    /* renamed from: a */
    private static final C3516h f19708a = new C3516h();

    private C3516h() {
    }

    /* renamed from: a */
    public static SuccessContinuation m11883a() {
        return f19708a;
    }

    public Task then(Object obj) {
        return Tasks.forResult(null);
    }
}
