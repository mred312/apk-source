package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class xh0 implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a */
    private final /* synthetic */ zzsx f11938a;

    xh0(zzsx zzsx) {
        this.f11938a = zzsx;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.f11938a.f16987b) {
            try {
                if (this.f11938a.f16988c != null) {
                    zzsx zzsx = this.f11938a;
                    zztg unused = zzsx.f16990e = zzsx.f16988c.zznc();
                }
            } catch (DeadObjectException e) {
                zzaza.zzc("Unable to obtain a cache service instance.", e);
                this.f11938a.m9098b();
            }
            this.f11938a.f16987b.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.f11938a.f16987b) {
            zztg unused = this.f11938a.f16990e = null;
            this.f11938a.f16987b.notifyAll();
        }
    }
}
