package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.remoteconfig.internal.d */
/* compiled from: ConfigCacheClient */
final /* synthetic */ class C3590d implements Executor {

    /* renamed from: a */
    private static final C3590d f20290a = new C3590d();

    private C3590d() {
    }

    /* renamed from: a */
    public static Executor m12184a() {
        return f20290a;
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
