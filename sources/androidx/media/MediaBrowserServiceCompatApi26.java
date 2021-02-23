package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.media.MediaBrowserServiceCompatApi23;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(26)
class MediaBrowserServiceCompatApi26 {

    /* renamed from: a */
    static Field f3750a;

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String str, C0832b bVar, Bundle bundle);
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompatApi26$a */
    static class C0831a extends MediaBrowserServiceCompatApi23.C0830a {
        C0831a(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((ServiceCompatProxy) this.f3748a).onLoadChildren(str, new C0832b(result), bundle);
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompatApi26$b */
    static class C0832b {

        /* renamed from: a */
        MediaBrowserService.Result f3751a;

        C0832b(MediaBrowserService.Result result) {
            this.f3751a = result;
        }

        /* renamed from: a */
        public void mo6526a() {
            this.f3751a.detach();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public List<MediaBrowser.MediaItem> mo6527b(List<Parcel> list) {
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
        public void mo6528c(List<Parcel> list, int i) {
            try {
                MediaBrowserServiceCompatApi26.f3750a.setInt(this.f3751a, i);
            } catch (IllegalAccessException e) {
                Log.w("MBSCompatApi26", e);
            }
            this.f3751a.sendResult(mo6527b(list));
        }
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f3750a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.w("MBSCompatApi26", e);
        }
    }

    /* renamed from: a */
    public static Object m2752a(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new C0831a(context, serviceCompatProxy);
    }

    /* renamed from: b */
    public static Bundle m2753b(Object obj) {
        return ((MediaBrowserService) obj).getBrowserRootHints();
    }

    /* renamed from: c */
    public static void m2754c(Object obj, String str, Bundle bundle) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
    }
}
