package com.google.android.gms.internal.ads;

import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public interface zzys extends IInterface {
    float getAspectRatio();

    float getCurrentTime();

    float getDuration();

    int getPlaybackState();

    boolean isClickToExpandEnabled();

    boolean isCustomControlsEnabled();

    boolean isMuted();

    void mute(boolean z);

    void pause();

    void play();

    void stop();

    void zza(zzyt zzyt);

    zzyt zzqq();
}
