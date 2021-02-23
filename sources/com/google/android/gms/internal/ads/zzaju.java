package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.ads.instream.InstreamAdView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaju extends InstreamAd {

    /* renamed from: a */
    private final zzajn f12488a;

    /* renamed from: b */
    private VideoController f12489b = m7470a();

    /* renamed from: c */
    private MediaContent f12490c = m7471b();

    public zzaju(zzajn zzajn) {
        this.f12488a = zzajn;
    }

    /* renamed from: a */
    private final VideoController m7470a() {
        VideoController videoController = new VideoController();
        try {
            videoController.zza(this.f12488a.getVideoController());
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return videoController;
    }

    /* renamed from: b */
    private final MediaContent m7471b() {
        try {
            if (this.f12488a.zzth() != null) {
                return new zzzm(this.f12488a.zzth());
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.f12488a.destroy();
            this.f12489b = null;
            this.f12490c = null;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final float getAspectRatio() {
        VideoController videoController = this.f12489b;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getAspectRatio();
    }

    public final MediaContent getMediaContent() {
        return this.f12490c;
    }

    public final VideoController getVideoController() {
        return this.f12489b;
    }

    public final float getVideoCurrentTime() {
        VideoController videoController = this.f12489b;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getVideoCurrentTime();
    }

    public final float getVideoDuration() {
        VideoController videoController = this.f12489b;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getVideoDuration();
    }

    public final void zza(InstreamAdView instreamAdView) {
        if (instreamAdView == null) {
            zzaza.zzey("showInView: parameter view must not be null.");
            return;
        }
        try {
            this.f12488a.zzr(ObjectWrapper.wrap(instreamAdView));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
