package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcbr extends zzaeh {

    /* renamed from: a */
    private final zzcce f13996a;

    /* renamed from: b */
    private IObjectWrapper f13997b;

    public zzcbr(zzcce zzcce) {
        this.f13996a = zzcce;
    }

    /* renamed from: a */
    private final float m7910a() {
        try {
            return this.f13996a.getVideoController().getAspectRatio();
        } catch (RemoteException e) {
            zzaza.zzc("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    /* renamed from: b */
    private static float m7911b(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }

    public final float getAspectRatio() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwx)).booleanValue()) {
            return 0.0f;
        }
        if (this.f13996a.getMediaContentAspectRatio() != 0.0f) {
            return this.f13996a.getMediaContentAspectRatio();
        }
        if (this.f13996a.getVideoController() != null) {
            return m7910a();
        }
        IObjectWrapper iObjectWrapper = this.f13997b;
        if (iObjectWrapper != null) {
            return m7911b(iObjectWrapper);
        }
        zzaej zzane = this.f13996a.zzane();
        if (zzane == null) {
            return 0.0f;
        }
        float width = (zzane == null || zzane.getWidth() == -1 || zzane.getHeight() == -1) ? 0.0f : ((float) zzane.getWidth()) / ((float) zzane.getHeight());
        if (width != 0.0f) {
            return width;
        }
        return m7911b(zzane.zzsr());
    }

    public final float getCurrentTime() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwy)).booleanValue() && this.f13996a.getVideoController() != null) {
            return this.f13996a.getVideoController().getCurrentTime();
        }
        return 0.0f;
    }

    public final float getDuration() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwy)).booleanValue() && this.f13996a.getVideoController() != null) {
            return this.f13996a.getVideoController().getDuration();
        }
        return 0.0f;
    }

    public final zzys getVideoController() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwy)).booleanValue()) {
            return null;
        }
        return this.f13996a.getVideoController();
    }

    public final boolean hasVideoContent() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwy)).booleanValue() && this.f13996a.getVideoController() != null) {
            return true;
        }
        return false;
    }

    public final void zza(zzafv zzafv) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwy)).booleanValue() && (this.f13996a.getVideoController() instanceof zzbep)) {
            ((zzbep) this.f13996a.getVideoController()).zza(zzafv);
        }
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcsd)).booleanValue()) {
            this.f13997b = iObjectWrapper;
        }
    }

    public final IObjectWrapper zzsu() {
        IObjectWrapper iObjectWrapper = this.f13997b;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzaej zzane = this.f13996a.zzane();
        if (zzane == null) {
            return null;
        }
        return zzane.zzsr();
    }
}
