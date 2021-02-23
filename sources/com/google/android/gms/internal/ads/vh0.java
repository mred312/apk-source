package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class vh0 implements Executor {

    /* renamed from: a */
    private final /* synthetic */ Handler f11619a;

    vh0(zzt zzt, Handler handler) {
        this.f11619a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f11619a.post(runnable);
    }
}
