package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* renamed from: com.google.android.gms.measurement.internal.u6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3124u6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ ComponentName f18399a;

    /* renamed from: b */
    private final /* synthetic */ zzji f18400b;

    C3124u6(zzji zzji, ComponentName componentName) {
        this.f18400b = zzji;
        this.f18399a = componentName;
    }

    public final void run() {
        this.f18400b.f18681c.m10865d(this.f18399a);
    }
}
