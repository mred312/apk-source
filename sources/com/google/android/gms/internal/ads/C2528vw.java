package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.ads.vw */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2528vw implements zzdyo<Void> {
    C2528vw(zzdju zzdju) {
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Void voidR = (Void) obj;
        zzd.zzee("Notification of cache hit successful.");
    }

    public final void zzb(Throwable th) {
        zzd.zzee("Notification of cache hit failed.");
    }
}
