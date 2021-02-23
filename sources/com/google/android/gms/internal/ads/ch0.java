package com.google.android.gms.internal.ads;

import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ch0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Surface f8009a;

    /* renamed from: b */
    private final /* synthetic */ zzqj f8010b;

    ch0(zzqj zzqj, Surface surface) {
        this.f8010b = zzqj;
        this.f8009a = surface;
    }

    public final void run() {
        this.f8010b.f16894b.zza(this.f8009a);
    }
}
