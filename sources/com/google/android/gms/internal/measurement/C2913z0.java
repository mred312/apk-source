package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.measurement.z0 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2913z0 extends ContentObserver {

    /* renamed from: a */
    private final /* synthetic */ zzct f17549a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2913z0(zzct zzct, Handler handler) {
        super((Handler) null);
        this.f17549a = zzct;
    }

    public final void onChange(boolean z) {
        this.f17549a.zzb();
    }
}
