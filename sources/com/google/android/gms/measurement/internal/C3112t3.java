package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* renamed from: com.google.android.gms.measurement.internal.t3 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C3112t3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzn f18366a;

    /* renamed from: b */
    private final /* synthetic */ zzfw f18367b;

    C3112t3(zzfw zzfw, zzn zzn) {
        this.f18367b = zzfw;
        this.f18366a = zzn;
    }

    public final void run() {
        this.f18367b.f18635a.mo20510T();
        zzki a = this.f18367b.f18635a;
        zzn zzn = this.f18366a;
        a.zzp().zzc();
        a.mo20508R();
        Preconditions.checkNotEmpty(zzn.zza);
        a.mo20506N(zzn);
    }
}
