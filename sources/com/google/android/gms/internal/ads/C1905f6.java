package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.f6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1905f6 implements zzdyo<Object> {

    /* renamed from: a */
    private final /* synthetic */ String f8428a;

    C1905f6(String str) {
        this.f8428a = str;
    }

    public final void onSuccess(@Nullable Object obj) {
    }

    public final void zzb(Throwable th) {
        zzp.zzku().zza(th, this.f8428a);
    }
}
