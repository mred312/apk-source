package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.p000v4.media.session.MediaSessionCompat;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class MediaBrowserServiceCompatApi21 {

    public interface ServiceCompatProxy {
        C0827a onGetRoot(String str, int i, Bundle bundle);

        void onLoadChildren(String str, C0829c<List<Parcel>> cVar);
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompatApi21$a */
    static class C0827a {

        /* renamed from: a */
        final String f3746a;

        /* renamed from: b */
        final Bundle f3747b;

        C0827a(String str, Bundle bundle) {
            this.f3746a = str;
            this.f3747b = bundle;
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompatApi21$b */
    static class C0828b extends MediaBrowserService {

        /* renamed from: a */
        final ServiceCompatProxy f3748a;

        C0828b(Context context, ServiceCompatProxy serviceCompatProxy) {
            attachBaseContext(context);
            this.f3748a = serviceCompatProxy;
        }

        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            C0827a onGetRoot = this.f3748a.onGetRoot(str, i, bundle == null ? null : new Bundle(bundle));
            if (onGetRoot == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(onGetRoot.f3746a, onGetRoot.f3747b);
        }

        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.f3748a.onLoadChildren(str, new C0829c(result));
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompatApi21$c */
    static class C0829c<T> {

        /* renamed from: a */
        MediaBrowserService.Result f3749a;

        C0829c(MediaBrowserService.Result result) {
            this.f3749a = result;
        }

        /* renamed from: a */
        public void mo6521a() {
            this.f3749a.detach();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public List<MediaBrowser.MediaItem> mo6522b(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel next : list) {
                next.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(next));
                next.recycle();
            }
            return arrayList;
        }

        /* renamed from: c */
        public void mo6523c(T t) {
            if (t instanceof List) {
                this.f3749a.sendResult(mo6522b((List) t));
            } else if (t instanceof Parcel) {
                Parcel parcel = (Parcel) t;
                parcel.setDataPosition(0);
                this.f3749a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.f3749a.sendResult((Object) null);
            }
        }
    }

    /* renamed from: a */
    public static Object m2743a(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new C0828b(context, serviceCompatProxy);
    }

    /* renamed from: b */
    public static void m2744b(Object obj, String str) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str);
    }

    /* renamed from: c */
    public static IBinder m2745c(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    /* renamed from: d */
    public static void m2746d(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    /* renamed from: e */
    public static void m2747e(Object obj, Object obj2) {
        ((MediaBrowserService) obj).setSessionToken((MediaSession.Token) obj2);
    }
}
