package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.analytics.connector.a */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.6.0 */
final /* synthetic */ class C3227a implements Executor {

    /* renamed from: a */
    static final Executor f18879a = new C3227a();

    private C3227a() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
