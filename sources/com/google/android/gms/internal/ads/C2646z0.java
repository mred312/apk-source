package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* renamed from: com.google.android.gms.internal.ads.z0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2646z0 implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    private final /* synthetic */ zzazq f12243a;

    C2646z0(zzait zzait, zzazq zzazq) {
        this.f12243a = zzazq;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.f12243a.setException(new RuntimeException("Connection failed."));
    }
}
