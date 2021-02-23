package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import androidx.annotation.RequiresApi;
import androidx.media.MediaBrowserServiceCompatApi21;

@RequiresApi(23)
class MediaBrowserServiceCompatApi23 {

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(String str, MediaBrowserServiceCompatApi21.C0829c<Parcel> cVar);
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompatApi23$a */
    static class C0830a extends MediaBrowserServiceCompatApi21.C0828b {
        C0830a(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
            ((ServiceCompatProxy) this.f3748a).onLoadItem(str, new MediaBrowserServiceCompatApi21.C0829c(result));
        }
    }

    /* renamed from: a */
    public static Object m2751a(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new C0830a(context, serviceCompatProxy);
    }
}
