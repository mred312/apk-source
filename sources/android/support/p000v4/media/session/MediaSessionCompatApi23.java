package android.support.p000v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.p000v4.media.session.C0098a;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
/* renamed from: android.support.v4.media.session.MediaSessionCompatApi23 */
class MediaSessionCompatApi23 {

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi23$Callback */
    public interface Callback extends C0098a.C0099a {
        /* synthetic */ void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        /* synthetic */ void onCustomAction(String str, Bundle bundle);

        /* synthetic */ void onFastForward();

        /* synthetic */ boolean onMediaButtonEvent(Intent intent);

        /* synthetic */ void onPause();

        /* synthetic */ void onPlay();

        /* synthetic */ void onPlayFromMediaId(String str, Bundle bundle);

        /* synthetic */ void onPlayFromSearch(String str, Bundle bundle);

        void onPlayFromUri(Uri uri, Bundle bundle);

        /* synthetic */ void onRewind();

        /* synthetic */ void onSeekTo(long j);

        /* synthetic */ void onSetRating(Object obj);

        /* synthetic */ void onSetRating(Object obj, Bundle bundle);

        /* synthetic */ void onSkipToNext();

        /* synthetic */ void onSkipToPrevious();

        /* synthetic */ void onSkipToQueueItem(long j);

        /* synthetic */ void onStop();
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi23$a */
    static class C0093a<T extends Callback> extends C0098a.C0100b<T> {
        public C0093a(T t) {
            super(t);
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.f257a).onPlayFromUri(uri, bundle);
        }
    }

    /* renamed from: a */
    public static Object m306a(Callback callback) {
        return new C0093a(callback);
    }
}
