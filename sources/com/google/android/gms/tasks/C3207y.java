package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.tasks.y */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3207y implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C3204w f18816a;

    /* renamed from: b */
    private final /* synthetic */ Callable f18817b;

    C3207y(C3204w wVar, Callable callable) {
        this.f18816a = wVar;
        this.f18817b = callable;
    }

    public final void run() {
        try {
            this.f18816a.mo20692b(this.f18817b.call());
        } catch (Exception e) {
            this.f18816a.mo20691a(e);
        }
    }
}
