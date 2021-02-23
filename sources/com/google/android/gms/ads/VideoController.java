package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaal;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzys;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object lock = new Object();
    @GuardedBy("lock")
    @Nullable
    private zzys zzadq;
    @GuardedBy("lock")
    @Nullable
    private VideoLifecycleCallbacks zzadr;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    @Deprecated
    public final float getAspectRatio() {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys == null) {
                return 0.0f;
            }
            try {
                float aspectRatio = zzys.getAspectRatio();
                return aspectRatio;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }

    @KeepForSdk
    public final int getPlaybackState() {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys == null) {
                return 0;
            }
            try {
                int playbackState = zzys.getPlaybackState();
                return playbackState;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final float getVideoCurrentTime() {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys == null) {
                return 0.0f;
            }
            try {
                float currentTime = zzys.getCurrentTime();
                return currentTime;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call getCurrentTime on video controller.", e);
                return 0.0f;
            }
        }
    }

    public final float getVideoDuration() {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys == null) {
                return 0.0f;
            }
            try {
                float duration = zzys.getDuration();
                return duration;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call getDuration on video controller.", e);
                return 0.0f;
            }
        }
    }

    @Nullable
    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.lock) {
            videoLifecycleCallbacks = this.zzadr;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzadq != null;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys == null) {
                return false;
            }
            try {
                boolean isClickToExpandEnabled = zzys.isClickToExpandEnabled();
                return isClickToExpandEnabled;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys == null) {
                return false;
            }
            try {
                boolean isCustomControlsEnabled = zzys.isCustomControlsEnabled();
                return isCustomControlsEnabled;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys == null) {
                return true;
            }
            try {
                boolean isMuted = zzys.isMuted();
                return isMuted;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys != null) {
                try {
                    zzys.mute(z);
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public final void pause() {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys != null) {
                try {
                    zzys.pause();
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public final void play() {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys != null) {
                try {
                    zzys.play();
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.lock) {
            this.zzadr = videoLifecycleCallbacks;
            zzys zzys = this.zzadq;
            if (zzys != null) {
                try {
                    zzys.zza(new zzaal(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    public final void stop() {
        synchronized (this.lock) {
            zzys zzys = this.zzadq;
            if (zzys != null) {
                try {
                    zzys.stop();
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public final void zza(zzys zzys) {
        synchronized (this.lock) {
            this.zzadq = zzys;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzadr;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    public final zzys zzdw() {
        zzys zzys;
        synchronized (this.lock) {
            zzys = this.zzadq;
        }
        return zzys;
    }
}
