package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.ads.h6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1979h6 implements zzdyo<T> {

    /* renamed from: a */
    private final /* synthetic */ zzazu f8835a;

    /* renamed from: b */
    private final /* synthetic */ zzazs f8836b;

    C1979h6(zzazx zzazx, zzazu zzazu, zzazs zzazs) {
        this.f8835a = zzazu;
        this.f8836b = zzazs;
    }

    public final void onSuccess(@Nullable T t) {
        this.f8835a.zzh(t);
    }

    public final void zzb(Throwable th) {
        this.f8836b.run();
    }
}
