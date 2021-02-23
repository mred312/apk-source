package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiresApi(21)
/* renamed from: android.support.v4.media.session.a */
/* compiled from: MediaSessionCompatApi21 */
class C0098a {

    /* renamed from: android.support.v4.media.session.a$a */
    /* compiled from: MediaSessionCompatApi21 */
    interface C0099a {
        void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void onCustomAction(String str, Bundle bundle);

        void onFastForward();

        boolean onMediaButtonEvent(Intent intent);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String str, Bundle bundle);

        void onPlayFromSearch(String str, Bundle bundle);

        void onRewind();

        void onSeekTo(long j);

        void onSetRating(Object obj);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long j);

        void onStop();
    }

    /* renamed from: android.support.v4.media.session.a$b */
    /* compiled from: MediaSessionCompatApi21 */
    static class C0100b<T extends C0099a> extends MediaSession.Callback {

        /* renamed from: a */
        protected final T f257a;

        public C0100b(T t) {
            this.f257a = t;
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.f257a.onCommand(str, bundle, resultReceiver);
        }

        public void onCustomAction(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.f257a.onCustomAction(str, bundle);
        }

        public void onFastForward() {
            this.f257a.onFastForward();
        }

        public boolean onMediaButtonEvent(Intent intent) {
            return this.f257a.onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent);
        }

        public void onPause() {
            this.f257a.onPause();
        }

        public void onPlay() {
            this.f257a.onPlay();
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.f257a.onPlayFromMediaId(str, bundle);
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.f257a.onPlayFromSearch(str, bundle);
        }

        public void onRewind() {
            this.f257a.onRewind();
        }

        public void onSeekTo(long j) {
            this.f257a.onSeekTo(j);
        }

        public void onSetRating(Rating rating) {
            this.f257a.onSetRating(rating);
        }

        public void onSkipToNext() {
            this.f257a.onSkipToNext();
        }

        public void onSkipToPrevious() {
            this.f257a.onSkipToPrevious();
        }

        public void onSkipToQueueItem(long j) {
            this.f257a.onSkipToQueueItem(j);
        }

        public void onStop() {
            this.f257a.onStop();
        }
    }

    /* renamed from: android.support.v4.media.session.a$c */
    /* compiled from: MediaSessionCompatApi21 */
    static class C0101c {
        /* renamed from: a */
        public static Object m336a(Object obj, long j) {
            return new MediaSession.QueueItem((MediaDescription) obj, j);
        }

        /* renamed from: b */
        public static Object m337b(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        /* renamed from: c */
        public static long m338c(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }
    }

    /* renamed from: a */
    public static Object m315a(C0099a aVar) {
        return new C0100b(aVar);
    }

    /* renamed from: b */
    public static Object m316b(Context context, String str) {
        return new MediaSession(context, str);
    }

    /* renamed from: c */
    public static Parcelable m317c(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }

    /* renamed from: d */
    public static boolean m318d(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mCallback");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                if (declaredField.get(obj) != null) {
                    return true;
                }
                return false;
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            Log.w("MediaSessionCompatApi21", "Failed to get mCallback object.");
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m319e(Object obj) {
        return ((MediaSession) obj).isActive();
    }

    /* renamed from: f */
    public static void m320f(Object obj) {
        ((MediaSession) obj).release();
    }

    /* renamed from: g */
    public static void m321g(Object obj, String str, Bundle bundle) {
        ((MediaSession) obj).sendSessionEvent(str, bundle);
    }

    /* renamed from: h */
    public static void m322h(Object obj, boolean z) {
        ((MediaSession) obj).setActive(z);
    }

    /* renamed from: i */
    public static void m323i(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((MediaSession.Callback) obj2, handler);
    }

    /* renamed from: j */
    public static void m324j(Object obj, Bundle bundle) {
        ((MediaSession) obj).setExtras(bundle);
    }

    /* renamed from: k */
    public static void m325k(Object obj, int i) {
        ((MediaSession) obj).setFlags(i);
    }

    /* renamed from: l */
    public static void m326l(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setMediaButtonReceiver(pendingIntent);
    }

    /* renamed from: m */
    public static void m327m(Object obj, Object obj2) {
        ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
    }

    /* renamed from: n */
    public static void m328n(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }

    /* renamed from: o */
    public static void m329o(Object obj, int i) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i);
        ((MediaSession) obj).setPlaybackToLocal(builder.build());
    }

    /* renamed from: p */
    public static void m330p(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
    }

    /* renamed from: q */
    public static void m331q(Object obj, List<Object> list) {
        if (list == null) {
            ((MediaSession) obj).setQueue((List) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((MediaSession.QueueItem) it.next());
        }
        ((MediaSession) obj).setQueue(arrayList);
    }

    /* renamed from: r */
    public static void m332r(Object obj, CharSequence charSequence) {
        ((MediaSession) obj).setQueueTitle(charSequence);
    }

    /* renamed from: s */
    public static void m333s(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setSessionActivity(pendingIntent);
    }

    /* renamed from: t */
    public static Object m334t(Object obj) {
        if (obj instanceof MediaSession) {
            return obj;
        }
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    /* renamed from: u */
    public static Object m335u(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
