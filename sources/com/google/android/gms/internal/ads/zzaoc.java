package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaoc extends zzyr {

    /* renamed from: a */
    private final Object f12556a = new Object();

    /* renamed from: b */
    private volatile zzyt f12557b;

    public final float getAspectRatio() {
        throw new RemoteException();
    }

    public final float getCurrentTime() {
        throw new RemoteException();
    }

    public final float getDuration() {
        throw new RemoteException();
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
        synchronized (this.f12556a) {
            this.f12557b = zzyt;
        }
    }

    public final zzyt zzqq() {
        zzyt zzyt;
        synchronized (this.f12556a) {
            zzyt = this.f12557b;
        }
        return zzyt;
    }
}
