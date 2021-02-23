package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzafg implements NativeCustomTemplateAd {

    /* renamed from: a */
    private final zzaff f12443a;

    /* renamed from: b */
    private final MediaView f12444b;

    /* renamed from: c */
    private final VideoController f12445c = new VideoController();

    /* renamed from: d */
    private NativeCustomTemplateAd.DisplayOpenMeasurement f12446d;

    @VisibleForTesting
    public zzafg(zzaff zzaff) {
        Context context;
        this.f12443a = zzaff;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzaff.zzta());
        } catch (RemoteException | NullPointerException e) {
            zzaza.zzc("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.f12443a.zzp(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
        }
        this.f12444b = mediaView;
    }

    public final void destroy() {
        try {
            this.f12443a.destroy();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.f12443a.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.f12443a.getCustomTemplateId();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final NativeCustomTemplateAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.f12446d == null && this.f12443a.zztb()) {
                this.f12446d = new zzaef(this.f12443a);
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
        return this.f12446d;
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzaej zzcu = this.f12443a.zzcu(str);
            if (zzcu != null) {
                return new zzaek(zzcu);
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.f12443a.zzct(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzys videoController = this.f12443a.getVideoController();
            if (videoController != null) {
                this.f12445c.zza(videoController);
            }
        } catch (RemoteException e) {
            zzaza.zzc("Exception occurred while getting video controller", e);
        }
        return this.f12445c;
    }

    public final MediaView getVideoMediaView() {
        return this.f12444b;
    }

    public final void performClick(String str) {
        try {
            this.f12443a.performClick(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.f12443a.recordImpression();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final zzaff zzte() {
        return this.f12443a;
    }
}
