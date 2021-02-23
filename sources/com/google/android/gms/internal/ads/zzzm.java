package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzzm implements MediaContent {

    /* renamed from: a */
    private final zzaee f17192a;

    /* renamed from: b */
    private final VideoController f17193b = new VideoController();

    public zzzm(zzaee zzaee) {
        this.f17192a = zzaee;
    }

    public final float getAspectRatio() {
        try {
            return this.f17192a.getAspectRatio();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return 0.0f;
        }
    }

    public final float getCurrentTime() {
        try {
            return this.f17192a.getCurrentTime();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return 0.0f;
        }
    }

    public final float getDuration() {
        try {
            return this.f17192a.getDuration();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return 0.0f;
        }
    }

    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzsu = this.f17192a.zzsu();
            if (zzsu != null) {
                return (Drawable) ObjectWrapper.unwrap(zzsu);
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.f17192a.getVideoController() != null) {
                this.f17193b.zza(this.f17192a.getVideoController());
            }
        } catch (RemoteException e) {
            zzaza.zzc("Exception occurred while getting video controller", e);
        }
        return this.f17193b;
    }

    public final boolean hasVideoContent() {
        try {
            return this.f17192a.hasVideoContent();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }

    public final void setMainImage(Drawable drawable) {
        try {
            this.f17192a.zzo(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final zzaee zzrc() {
        return this.f17192a;
    }
}
