package android.support.p000v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
/* renamed from: android.support.v4.media.b */
/* compiled from: MediaBrowserCompatApi23 */
class C0044b {

    /* renamed from: android.support.v4.media.b$a */
    /* compiled from: MediaBrowserCompatApi23 */
    interface C0045a {
        /* renamed from: a */
        void mo63a(Parcel parcel);

        void onError(@NonNull String str);
    }

    /* renamed from: android.support.v4.media.b$b */
    /* compiled from: MediaBrowserCompatApi23 */
    static class C0046b<T extends C0045a> extends MediaBrowser.ItemCallback {

        /* renamed from: a */
        protected final T f123a;

        public C0046b(T t) {
            this.f123a = t;
        }

        public void onError(@NonNull String str) {
            this.f123a.onError(str);
        }

        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            if (mediaItem == null) {
                this.f123a.mo63a((Parcel) null);
                return;
            }
            Parcel obtain = Parcel.obtain();
            mediaItem.writeToParcel(obtain, 0);
            this.f123a.mo63a(obtain);
        }
    }

    /* renamed from: a */
    public static Object m108a(C0045a aVar) {
        return new C0046b(aVar);
    }

    /* renamed from: b */
    public static void m109b(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).getItem(str, (MediaBrowser.ItemCallback) obj2);
    }
}
