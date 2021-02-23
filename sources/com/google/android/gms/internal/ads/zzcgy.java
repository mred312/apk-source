package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcgy extends VideoController.VideoLifecycleCallbacks {

    /* renamed from: a */
    private final zzcce f14357a;

    public zzcgy(zzcce zzcce) {
        this.f14357a = zzcce;
    }

    /* renamed from: a */
    private static zzyt m8153a(zzcce zzcce) {
        zzys videoController = zzcce.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzqq();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void onVideoEnd() {
        zzyt a = m8153a(this.f14357a);
        if (a != null) {
            try {
                a.onVideoEnd();
            } catch (RemoteException e) {
                zzaza.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoPause() {
        zzyt a = m8153a(this.f14357a);
        if (a != null) {
            try {
                a.onVideoPause();
            } catch (RemoteException e) {
                zzaza.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoStart() {
        zzyt a = m8153a(this.f14357a);
        if (a != null) {
            try {
                a.onVideoStart();
            } catch (RemoteException e) {
                zzaza.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }
}
