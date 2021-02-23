package android.support.p000v4.media.session;

import android.content.Intent;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.p000v4.media.session.MediaSessionCompatApi23;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;

@RequiresApi(24)
/* renamed from: android.support.v4.media.session.MediaSessionCompatApi24 */
class MediaSessionCompatApi24 {

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi24$Callback */
    public interface Callback extends MediaSessionCompatApi23.Callback {
        /* synthetic */ void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        /* synthetic */ void onCustomAction(String str, Bundle bundle);

        /* synthetic */ void onFastForward();

        /* synthetic */ boolean onMediaButtonEvent(Intent intent);

        /* synthetic */ void onPause();

        /* synthetic */ void onPlay();

        /* synthetic */ void onPlayFromMediaId(String str, Bundle bundle);

        /* synthetic */ void onPlayFromSearch(String str, Bundle bundle);

        void onPrepare();

        void onPrepareFromMediaId(String str, Bundle bundle);

        void onPrepareFromSearch(String str, Bundle bundle);

        void onPrepareFromUri(Uri uri, Bundle bundle);

        /* synthetic */ void onRewind();

        /* synthetic */ void onSeekTo(long j);

        /* synthetic */ void onSetRating(Object obj);

        /* synthetic */ void onSetRating(Object obj, Bundle bundle);

        /* synthetic */ void onSkipToNext();

        /* synthetic */ void onSkipToPrevious();

        /* synthetic */ void onSkipToQueueItem(long j);

        /* synthetic */ void onStop();
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi24$a */
    static class C0094a<T extends Callback> extends MediaSessionCompatApi23.C0093a<T> {
        public C0094a(T t) {
            super(t);
        }

        public void onPrepare() {
            ((Callback) this.f257a).onPrepare();
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.f257a).onPrepareFromMediaId(str, bundle);
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.f257a).onPrepareFromSearch(str, bundle);
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.f257a).onPrepareFromUri(uri, bundle);
        }
    }

    /* renamed from: a */
    public static Object m307a(Callback callback) {
        return new C0094a(callback);
    }

    /* renamed from: b */
    public static String m308b(Object obj) {
        MediaSession mediaSession = (MediaSession) obj;
        try {
            return (String) mediaSession.getClass().getMethod("getCallingPackage", new Class[0]).invoke(mediaSession, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("MediaSessionCompatApi24", "Cannot execute MediaSession.getCallingPackage()", e);
            return null;
        }
    }
}
