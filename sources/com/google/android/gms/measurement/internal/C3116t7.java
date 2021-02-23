package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.t7 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C3116t7 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f18382a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f18383b;

    /* renamed from: c */
    private final /* synthetic */ C3125u7 f18384c;

    C3116t7(C3125u7 u7Var, String str, Bundle bundle) {
        this.f18384c = u7Var;
        this.f18382a = str;
        this.f18383b = bundle;
    }

    public final void run() {
        this.f18384c.f18401a.mo20516k(this.f18384c.f18401a.zzk().mo20570i(this.f18382a, "_err", this.f18383b, "auto", this.f18384c.f18401a.zzl().currentTimeMillis(), false, false, false), this.f18382a);
    }
}
