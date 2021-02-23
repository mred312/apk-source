package android.support.p000v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.p000v4.media.C0038a;
import android.support.p000v4.media.session.MediaSessionCompat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

@RequiresApi(26)
/* renamed from: android.support.v4.media.c */
/* compiled from: MediaBrowserCompatApi26 */
class C0047c {

    /* renamed from: android.support.v4.media.c$a */
    /* compiled from: MediaBrowserCompatApi26 */
    interface C0048a extends C0038a.C0042d {
        /* renamed from: a */
        void mo87a(@NonNull String str, @NonNull Bundle bundle);

        /* renamed from: b */
        void mo88b(@NonNull String str, List<?> list, @NonNull Bundle bundle);
    }

    /* renamed from: android.support.v4.media.c$b */
    /* compiled from: MediaBrowserCompatApi26 */
    static class C0049b<T extends C0048a> extends C0038a.C0043e<T> {
        C0049b(T t) {
            super(t);
        }

        public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list, @NonNull Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((C0048a) this.f122a).mo88b(str, list, bundle);
        }

        public void onError(@NonNull String str, @NonNull Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((C0048a) this.f122a).mo87a(str, bundle);
        }
    }

    /* renamed from: a */
    static Object m111a(C0048a aVar) {
        return new C0049b(aVar);
    }

    /* renamed from: b */
    public static void m112b(Object obj, String str, Bundle bundle, Object obj2) {
        ((MediaBrowser) obj).subscribe(str, bundle, (MediaBrowser.SubscriptionCallback) obj2);
    }

    /* renamed from: c */
    public static void m113c(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).unsubscribe(str, (MediaBrowser.SubscriptionCallback) obj2);
    }
}
