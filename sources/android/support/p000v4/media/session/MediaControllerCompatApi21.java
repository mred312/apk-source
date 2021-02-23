package android.support.p000v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* renamed from: android.support.v4.media.session.MediaControllerCompatApi21 */
class MediaControllerCompatApi21 {

    /* renamed from: android.support.v4.media.session.MediaControllerCompatApi21$Callback */
    public interface Callback {
        void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5);

        void onExtrasChanged(Bundle bundle);

        void onMetadataChanged(Object obj);

        void onPlaybackStateChanged(Object obj);

        void onQueueChanged(List<?> list);

        void onQueueTitleChanged(CharSequence charSequence);

        void onSessionDestroyed();

        void onSessionEvent(String str, Bundle bundle);
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompatApi21$PlaybackInfo */
    public static class PlaybackInfo {
        private PlaybackInfo() {
        }

        /* renamed from: a */
        private static int m202a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            int usage = audioAttributes.getUsage();
            if (usage == 13) {
                return 1;
            }
            switch (usage) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }

        public static AudioAttributes getAudioAttributes(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int getCurrentVolume(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getCurrentVolume();
        }

        public static int getLegacyAudioStream(Object obj) {
            return m202a(getAudioAttributes(obj));
        }

        public static int getMaxVolume(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getMaxVolume();
        }

        public static int getPlaybackType(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getPlaybackType();
        }

        public static int getVolumeControl(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getVolumeControl();
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompatApi21$TransportControls */
    public static class TransportControls {
        private TransportControls() {
        }

        public static void fastForward(Object obj) {
            ((MediaController.TransportControls) obj).fastForward();
        }

        public static void pause(Object obj) {
            ((MediaController.TransportControls) obj).pause();
        }

        public static void play(Object obj) {
            ((MediaController.TransportControls) obj).play();
        }

        public static void playFromMediaId(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromMediaId(str, bundle);
        }

        public static void playFromSearch(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromSearch(str, bundle);
        }

        public static void rewind(Object obj) {
            ((MediaController.TransportControls) obj).rewind();
        }

        public static void seekTo(Object obj, long j) {
            ((MediaController.TransportControls) obj).seekTo(j);
        }

        public static void sendCustomAction(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).sendCustomAction(str, bundle);
        }

        public static void setRating(Object obj, Object obj2) {
            ((MediaController.TransportControls) obj).setRating((Rating) obj2);
        }

        public static void skipToNext(Object obj) {
            ((MediaController.TransportControls) obj).skipToNext();
        }

        public static void skipToPrevious(Object obj) {
            ((MediaController.TransportControls) obj).skipToPrevious();
        }

        public static void skipToQueueItem(Object obj, long j) {
            ((MediaController.TransportControls) obj).skipToQueueItem(j);
        }

        public static void stop(Object obj) {
            ((MediaController.TransportControls) obj).stop();
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompatApi21$a */
    static class C0069a<T extends Callback> extends MediaController.Callback {

        /* renamed from: a */
        protected final T f152a;

        public C0069a(T t) {
            this.f152a = t;
        }

        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f152a.onAudioInfoChanged(playbackInfo.getPlaybackType(), PlaybackInfo.getLegacyAudioStream(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.f152a.onExtrasChanged(bundle);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f152a.onMetadataChanged(mediaMetadata);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f152a.onPlaybackStateChanged(playbackState);
        }

        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f152a.onQueueChanged(list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f152a.onQueueTitleChanged(charSequence);
        }

        public void onSessionDestroyed() {
            this.f152a.onSessionDestroyed();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.f152a.onSessionEvent(str, bundle);
        }
    }

    /* renamed from: a */
    public static void m180a(Object obj, int i, int i2) {
        ((MediaController) obj).adjustVolume(i, i2);
    }

    /* renamed from: b */
    public static Object m181b(Callback callback) {
        return new C0069a(callback);
    }

    /* renamed from: c */
    public static boolean m182c(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    /* renamed from: d */
    public static Object m183d(Context context, Object obj) {
        return new MediaController(context, (MediaSession.Token) obj);
    }

    /* renamed from: e */
    public static Bundle m184e(Object obj) {
        return ((MediaController) obj).getExtras();
    }

    /* renamed from: f */
    public static long m185f(Object obj) {
        return ((MediaController) obj).getFlags();
    }

    /* renamed from: g */
    public static Object m186g(Activity activity) {
        return activity.getMediaController();
    }

    /* renamed from: h */
    public static Object m187h(Object obj) {
        return ((MediaController) obj).getMetadata();
    }

    /* renamed from: i */
    public static String m188i(Object obj) {
        return ((MediaController) obj).getPackageName();
    }

    /* renamed from: j */
    public static Object m189j(Object obj) {
        return ((MediaController) obj).getPlaybackInfo();
    }

    /* renamed from: k */
    public static Object m190k(Object obj) {
        return ((MediaController) obj).getPlaybackState();
    }

    /* renamed from: l */
    public static List<Object> m191l(Object obj) {
        List<MediaSession.QueueItem> queue = ((MediaController) obj).getQueue();
        if (queue == null) {
            return null;
        }
        return new ArrayList(queue);
    }

    /* renamed from: m */
    public static CharSequence m192m(Object obj) {
        return ((MediaController) obj).getQueueTitle();
    }

    /* renamed from: n */
    public static int m193n(Object obj) {
        return ((MediaController) obj).getRatingType();
    }

    /* renamed from: o */
    public static PendingIntent m194o(Object obj) {
        return ((MediaController) obj).getSessionActivity();
    }

    /* renamed from: p */
    public static Object m195p(Object obj) {
        return ((MediaController) obj).getSessionToken();
    }

    /* renamed from: q */
    public static Object m196q(Object obj) {
        return ((MediaController) obj).getTransportControls();
    }

    /* renamed from: r */
    public static void m197r(Object obj, Object obj2, Handler handler) {
        ((MediaController) obj).registerCallback((MediaController.Callback) obj2, handler);
    }

    /* renamed from: s */
    public static void m198s(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    /* renamed from: t */
    public static void m199t(Activity activity, Object obj) {
        activity.setMediaController((MediaController) obj);
    }

    /* renamed from: u */
    public static void m200u(Object obj, int i, int i2) {
        ((MediaController) obj).setVolumeTo(i, i2);
    }

    /* renamed from: v */
    public static void m201v(Object obj, Object obj2) {
        ((MediaController) obj).unregisterCallback((MediaController.Callback) obj2);
    }
}
