package android.support.p000v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

@RequiresApi(21)
/* renamed from: android.support.v4.media.a */
/* compiled from: MediaBrowserCompatApi21 */
class C0038a {

    /* renamed from: android.support.v4.media.a$a */
    /* compiled from: MediaBrowserCompatApi21 */
    interface C0039a {
        /* renamed from: b */
        void mo54b();

        /* renamed from: c */
        void mo55c();

        void onConnected();
    }

    /* renamed from: android.support.v4.media.a$b */
    /* compiled from: MediaBrowserCompatApi21 */
    static class C0040b<T extends C0039a> extends MediaBrowser.ConnectionCallback {

        /* renamed from: a */
        protected final T f121a;

        public C0040b(T t) {
            this.f121a = t;
        }

        public void onConnected() {
            this.f121a.onConnected();
        }

        public void onConnectionFailed() {
            this.f121a.mo55c();
        }

        public void onConnectionSuspended() {
            this.f121a.mo54b();
        }
    }

    /* renamed from: android.support.v4.media.a$c */
    /* compiled from: MediaBrowserCompatApi21 */
    static class C0041c {
        /* renamed from: a */
        public static Object m105a(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getDescription();
        }

        /* renamed from: b */
        public static int m106b(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getFlags();
        }
    }

    /* renamed from: android.support.v4.media.a$d */
    /* compiled from: MediaBrowserCompatApi21 */
    interface C0042d {
        /* renamed from: c */
        void mo84c(@NonNull String str, List<?> list);

        void onError(@NonNull String str);
    }

    /* renamed from: android.support.v4.media.a$e */
    /* compiled from: MediaBrowserCompatApi21 */
    static class C0043e<T extends C0042d> extends MediaBrowser.SubscriptionCallback {

        /* renamed from: a */
        protected final T f122a;

        public C0043e(T t) {
            this.f122a = t;
        }

        public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
            this.f122a.mo84c(str, list);
        }

        public void onError(@NonNull String str) {
            this.f122a.onError(str);
        }
    }

    /* renamed from: a */
    public static void m91a(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    /* renamed from: b */
    public static Object m92b(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    /* renamed from: c */
    public static Object m93c(C0039a aVar) {
        return new C0040b(aVar);
    }

    /* renamed from: d */
    public static Object m94d(C0042d dVar) {
        return new C0043e(dVar);
    }

    /* renamed from: e */
    public static void m95e(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    /* renamed from: f */
    public static Bundle m96f(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    /* renamed from: g */
    public static String m97g(Object obj) {
        return ((MediaBrowser) obj).getRoot();
    }

    /* renamed from: h */
    public static ComponentName m98h(Object obj) {
        return ((MediaBrowser) obj).getServiceComponent();
    }

    /* renamed from: i */
    public static Object m99i(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }

    /* renamed from: j */
    public static boolean m100j(Object obj) {
        return ((MediaBrowser) obj).isConnected();
    }

    /* renamed from: k */
    public static void m101k(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).subscribe(str, (MediaBrowser.SubscriptionCallback) obj2);
    }

    /* renamed from: l */
    public static void m102l(Object obj, String str) {
        ((MediaBrowser) obj).unsubscribe(str);
    }
}
