package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class fi0 implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    private final /* synthetic */ zzazq f8472a;

    /* renamed from: b */
    private final /* synthetic */ zztl f8473b;

    fi0(zztl zztl, zzazq zzazq) {
        this.f8473b = zztl;
        this.f8472a = zzazq;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.f8473b.f17005d) {
            this.f8472a.setException(new RuntimeException("Connection failed."));
        }
    }
}
