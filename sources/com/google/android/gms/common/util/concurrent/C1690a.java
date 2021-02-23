package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* renamed from: com.google.android.gms.common.util.concurrent.a */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1690a implements Runnable {

    /* renamed from: a */
    private final Runnable f7643a;

    /* renamed from: b */
    private final int f7644b;

    public C1690a(Runnable runnable, int i) {
        this.f7643a = runnable;
        this.f7644b = i;
    }

    public final void run() {
        Process.setThreadPriority(this.f7644b);
        this.f7643a.run();
    }
}
