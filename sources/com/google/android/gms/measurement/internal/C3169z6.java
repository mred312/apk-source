package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* renamed from: com.google.android.gms.measurement.internal.z6 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final /* synthetic */ class C3169z6 implements Runnable {

    /* renamed from: a */
    private final zzjr f18480a;

    /* renamed from: b */
    private final int f18481b;

    /* renamed from: c */
    private final zzer f18482c;

    /* renamed from: d */
    private final Intent f18483d;

    C3169z6(zzjr zzjr, int i, zzer zzer, Intent intent) {
        this.f18480a = zzjr;
        this.f18481b = i;
        this.f18482c = zzer;
        this.f18483d = intent;
    }

    public final void run() {
        this.f18480a.mo20489a(this.f18481b, this.f18482c, this.f18483d);
    }
}
