package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class u30 implements Executor {

    /* renamed from: a */
    private final /* synthetic */ Executor f11245a;

    /* renamed from: b */
    private final /* synthetic */ zzdxo f11246b;

    u30(Executor executor, zzdxo zzdxo) {
        this.f11245a = executor;
        this.f11246b = zzdxo;
    }

    public final void execute(Runnable runnable) {
        try {
            this.f11245a.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.f11246b.setException(e);
        }
    }
}
