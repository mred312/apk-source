package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzccb extends zzyr {

    /* renamed from: a */
    private final Object f14042a = new Object();
    @Nullable

    /* renamed from: b */
    private zzys f14043b;
    @Nullable

    /* renamed from: c */
    private final zzaob f14044c;

    public zzccb(@Nullable zzys zzys, @Nullable zzaob zzaob) {
        this.f14043b = zzys;
        this.f14044c = zzaob;
    }

    public final float getAspectRatio() {
        throw new RemoteException();
    }

    public final float getCurrentTime() {
        zzaob zzaob = this.f14044c;
        if (zzaob != null) {
            return zzaob.getVideoCurrentTime();
        }
        return 0.0f;
    }

    public final float getDuration() {
        zzaob zzaob = this.f14044c;
        if (zzaob != null) {
            return zzaob.getVideoDuration();
        }
        return 0.0f;
    }

    public final int getPlaybackState() {
        throw new RemoteException();
    }

    public final boolean isClickToExpandEnabled() {
        throw new RemoteException();
    }

    public final boolean isCustomControlsEnabled() {
        throw new RemoteException();
    }

    public final boolean isMuted() {
        throw new RemoteException();
    }

    public final void mute(boolean z) {
        throw new RemoteException();
    }

    public final void pause() {
        throw new RemoteException();
    }

    public final void play() {
        throw new RemoteException();
    }

    public final void stop() {
        throw new RemoteException();
    }

    public final void zza(zzyt zzyt) {
        synchronized (this.f14042a) {
            zzys zzys = this.f14043b;
            if (zzys != null) {
                zzys.zza(zzyt);
            }
        }
    }

    public final zzyt zzqq() {
        synchronized (this.f14042a) {
            zzys zzys = this.f14043b;
            if (zzys == null) {
                return null;
            }
            zzyt zzqq = zzys.zzqq();
            return zzqq;
        }
    }
}
