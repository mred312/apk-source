package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zh0 implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    private final /* synthetic */ zzsx f12304a;

    zh0(zzsx zzsx) {
        this.f12304a = zzsx;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.f12304a.f16987b) {
            zztg unused = this.f12304a.f16990e = null;
            if (this.f12304a.f16988c != null) {
                zztc unused2 = this.f12304a.f16988c = null;
            }
            this.f12304a.f16987b.notifyAll();
        }
    }
}
