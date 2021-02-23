package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.ads.g6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1942g6 implements zzdyo<T> {

    /* renamed from: a */
    private final /* synthetic */ zzazx f8515a;

    C1942g6(zzazx zzazx) {
        this.f8515a = zzazx;
    }

    public final void onSuccess(@Nullable T t) {
        this.f8515a.f12981b.set(1);
    }

    public final void zzb(Throwable th) {
        this.f8515a.f12981b.set(-1);
    }
}
