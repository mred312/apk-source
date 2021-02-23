package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.u3 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final /* synthetic */ class C3121u3 implements Runnable {

    /* renamed from: a */
    private final zzfw f18389a;

    /* renamed from: b */
    private final zzn f18390b;

    /* renamed from: c */
    private final Bundle f18391c;

    C3121u3(zzfw zzfw, zzn zzn, Bundle bundle) {
        this.f18389a = zzfw;
        this.f18390b = zzn;
        this.f18391c = bundle;
    }

    public final void run() {
        this.f18389a.mo20383b(this.f18390b, this.f18391c);
    }
}
