package android.support.p000v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.p000v4.media.C0038a;
import android.support.p000v4.media.C0044b;
import android.support.p000v4.media.C0047c;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.support.p000v4.p001os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.media.MediaBrowserCompat */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";

    /* renamed from: b */
    static final boolean f5b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a */
    private final C0011b f6a;

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback */
    public static class ConnectionCallback {

        /* renamed from: a */
        final Object f7a;

        /* renamed from: b */
        C0004a f8b;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback$a */
        interface C0004a {
            /* renamed from: b */
            void mo51b();

            /* renamed from: c */
            void mo52c();

            void onConnected();
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback$b */
        private class C0005b implements C0038a.C0039a {
            C0005b() {
            }

            /* renamed from: b */
            public void mo54b() {
                C0004a aVar = ConnectionCallback.this.f8b;
                if (aVar != null) {
                    aVar.mo51b();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }

            /* renamed from: c */
            public void mo55c() {
                C0004a aVar = ConnectionCallback.this.f8b;
                if (aVar != null) {
                    aVar.mo52c();
                }
                ConnectionCallback.this.onConnectionFailed();
            }

            public void onConnected() {
                C0004a aVar = ConnectionCallback.this.f8b;
                if (aVar != null) {
                    aVar.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }
        }

        public ConnectionCallback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f7a = C0038a.m93c(new C0005b());
            } else {
                this.f7a = null;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo47a(C0004a aVar) {
            this.f8b = aVar;
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionCallback */
    public static abstract class CustomActionCallback {
        public void onError(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onProgressUpdate(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onResult(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver */
    private static class CustomActionResultReceiver extends ResultReceiver {

        /* renamed from: d */
        private final String f10d;

        /* renamed from: e */
        private final Bundle f11e;

        /* renamed from: f */
        private final CustomActionCallback f12f;

        CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, Handler handler) {
            super(handler);
            this.f10d = str;
            this.f11e = bundle;
            this.f12f = customActionCallback;
        }

        /* access modifiers changed from: protected */
        public void onReceiveResult(int i, Bundle bundle) {
            if (this.f12f != null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                if (i == -1) {
                    this.f12f.onError(this.f10d, this.f11e, bundle);
                } else if (i == 0) {
                    this.f12f.onResult(this.f10d, this.f11e, bundle);
                } else if (i != 1) {
                    Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.f11e + ", resultData=" + bundle + ")");
                } else {
                    this.f12f.onProgressUpdate(this.f10d, this.f11e, bundle);
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemCallback */
    public static abstract class ItemCallback {

        /* renamed from: a */
        final Object f13a;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemCallback$a */
        private class C0006a implements C0044b.C0045a {
            C0006a() {
            }

            /* renamed from: a */
            public void mo63a(Parcel parcel) {
                if (parcel == null) {
                    ItemCallback.this.onItemLoaded((MediaItem) null);
                    return;
                }
                parcel.setDataPosition(0);
                parcel.recycle();
                ItemCallback.this.onItemLoaded(MediaItem.CREATOR.createFromParcel(parcel));
            }

            public void onError(@NonNull String str) {
                ItemCallback.this.onError(str);
            }
        }

        public ItemCallback() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f13a = C0044b.m108a(new C0006a());
            } else {
                this.f13a = null;
            }
        }

        public void onError(@NonNull String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemReceiver */
    private static class ItemReceiver extends ResultReceiver {

        /* renamed from: d */
        private final String f15d;

        /* renamed from: e */
        private final ItemCallback f16e;

        ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.f15d = str;
            this.f16e = itemCallback;
        }

        /* access modifiers changed from: protected */
        public void onReceiveResult(int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                this.f16e.onError(this.f15d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.f16e.onItemLoaded((MediaItem) parcelable);
            } else {
                this.f16e.onError(this.f15d);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SearchCallback */
    public static abstract class SearchCallback {
        public void onError(@NonNull String str, Bundle bundle) {
        }

        public void onSearchResult(@NonNull String str, Bundle bundle, @NonNull List<MediaItem> list) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SearchResultReceiver */
    private static class SearchResultReceiver extends ResultReceiver {

        /* renamed from: d */
        private final String f19d;

        /* renamed from: e */
        private final Bundle f20e;

        /* renamed from: f */
        private final SearchCallback f21f;

        SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, Handler handler) {
            super(handler);
            this.f19d = str;
            this.f20e = bundle;
            this.f21f = searchCallback;
        }

        /* access modifiers changed from: protected */
        public void onReceiveResult(int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                this.f21f.onError(this.f19d, this.f20e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.f21f.onSearchResult(this.f19d, this.f20e, arrayList);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback */
    public static abstract class SubscriptionCallback {

        /* renamed from: a */
        final Object f22a;

        /* renamed from: b */
        final IBinder f23b = new Binder();

        /* renamed from: c */
        WeakReference<C0034i> f24c;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$a */
        private class C0008a implements C0038a.C0042d {
            C0008a() {
            }

            /* renamed from: c */
            public void mo84c(@NonNull String str, List<?> list) {
                WeakReference<C0034i> weakReference = SubscriptionCallback.this.f24c;
                C0034i iVar = weakReference == null ? null : (C0034i) weakReference.get();
                if (iVar == null) {
                    SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list));
                    return;
                }
                List<MediaItem> fromMediaItemList = MediaItem.fromMediaItemList(list);
                List<SubscriptionCallback> b = iVar.mo137b();
                List<Bundle> c = iVar.mo138c();
                for (int i = 0; i < b.size(); i++) {
                    Bundle bundle = c.get(i);
                    if (bundle == null) {
                        SubscriptionCallback.this.onChildrenLoaded(str, fromMediaItemList);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(str, mo85d(fromMediaItemList, bundle), bundle);
                    }
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: d */
            public List<MediaItem> mo85d(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i == -1 && i2 == -1) {
                    return list;
                }
                int i3 = i2 * i;
                int i4 = i3 + i2;
                if (i < 0 || i2 < 1 || i3 >= list.size()) {
                    return Collections.emptyList();
                }
                if (i4 > list.size()) {
                    i4 = list.size();
                }
                return list.subList(i3, i4);
            }

            public void onError(@NonNull String str) {
                SubscriptionCallback.this.onError(str);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$b */
        private class C0009b extends C0008a implements C0047c.C0048a {
            C0009b() {
                super();
            }

            /* renamed from: a */
            public void mo87a(@NonNull String str, @NonNull Bundle bundle) {
                SubscriptionCallback.this.onError(str, bundle);
            }

            /* renamed from: b */
            public void mo88b(@NonNull String str, List<?> list, @NonNull Bundle bundle) {
                SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list), bundle);
            }
        }

        public SubscriptionCallback() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                this.f22a = C0047c.m111a(new C0009b());
            } else if (i >= 21) {
                this.f22a = C0038a.m94d(new C0008a());
            } else {
                this.f22a = null;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo79a(C0034i iVar) {
            this.f24c = new WeakReference<>(iVar);
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list, @NonNull Bundle bundle) {
        }

        public void onError(@NonNull String str) {
        }

        public void onError(@NonNull String str, @NonNull Bundle bundle) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$a */
    private static class C0010a extends Handler {

        /* renamed from: a */
        private final WeakReference<C0032g> f27a;

        /* renamed from: b */
        private WeakReference<Messenger> f28b;

        C0010a(C0032g gVar) {
            this.f27a = new WeakReference<>(gVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo89a(Messenger messenger) {
            this.f28b = new WeakReference<>(messenger);
        }

        public void handleMessage(Message message) {
            WeakReference<Messenger> weakReference = this.f28b;
            if (weakReference != null && weakReference.get() != null && this.f27a.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.ensureClassLoader(data);
                C0032g gVar = (C0032g) this.f27a.get();
                Messenger messenger = (Messenger) this.f28b.get();
                try {
                    int i = message.what;
                    if (i == 1) {
                        Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                        MediaSessionCompat.ensureClassLoader(bundle);
                        gVar.mo104e(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                    } else if (i == 2) {
                        gVar.mo106m(messenger);
                    } else if (i != 3) {
                        Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: " + 1 + "\n  Service version: " + message.arg1);
                    } else {
                        Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                        MediaSessionCompat.ensureClassLoader(bundle2);
                        Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        gVar.mo105g(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        gVar.mo106m(messenger);
                    }
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$b */
    interface C0011b {
        @NonNull
        /* renamed from: a */
        MediaSessionCompat.Token mo91a();

        /* renamed from: d */
        void mo92d(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback);

        /* renamed from: f */
        ComponentName mo93f();

        @Nullable
        Bundle getExtras();

        @NonNull
        String getRoot();

        /* renamed from: h */
        void mo96h(@NonNull String str, @NonNull ItemCallback itemCallback);

        /* renamed from: i */
        void mo97i();

        /* renamed from: j */
        void mo98j();

        /* renamed from: k */
        void mo99k(@NonNull String str, @Nullable Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback);

        /* renamed from: l */
        boolean mo100l();

        /* renamed from: n */
        void mo101n(@NonNull String str, SubscriptionCallback subscriptionCallback);

        /* renamed from: o */
        void mo102o(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback);

        @Nullable
        /* renamed from: p */
        Bundle mo103p();
    }

    @RequiresApi(21)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$c */
    static class C0012c implements C0011b, C0032g, ConnectionCallback.C0004a {

        /* renamed from: a */
        final Context f29a;

        /* renamed from: b */
        protected final Object f30b;

        /* renamed from: c */
        protected final Bundle f31c;

        /* renamed from: d */
        protected final C0010a f32d = new C0010a(this);

        /* renamed from: e */
        private final ArrayMap<String, C0034i> f33e = new ArrayMap<>();

        /* renamed from: f */
        protected int f34f;

        /* renamed from: g */
        protected C0033h f35g;

        /* renamed from: h */
        protected Messenger f36h;

        /* renamed from: i */
        private MediaSessionCompat.Token f37i;

        /* renamed from: j */
        private Bundle f38j;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$c$a */
        class C0013a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ItemCallback f39a;

            /* renamed from: b */
            final /* synthetic */ String f40b;

            C0013a(C0012c cVar, ItemCallback itemCallback, String str) {
                this.f39a = itemCallback;
                this.f40b = str;
            }

            public void run() {
                this.f39a.onError(this.f40b);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$c$b */
        class C0014b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ItemCallback f41a;

            /* renamed from: b */
            final /* synthetic */ String f42b;

            C0014b(C0012c cVar, ItemCallback itemCallback, String str) {
                this.f41a = itemCallback;
                this.f42b = str;
            }

            public void run() {
                this.f41a.onError(this.f42b);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$c$c */
        class C0015c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ItemCallback f43a;

            /* renamed from: b */
            final /* synthetic */ String f44b;

            C0015c(C0012c cVar, ItemCallback itemCallback, String str) {
                this.f43a = itemCallback;
                this.f44b = str;
            }

            public void run() {
                this.f43a.onError(this.f44b);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$c$d */
        class C0016d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SearchCallback f45a;

            /* renamed from: b */
            final /* synthetic */ String f46b;

            /* renamed from: c */
            final /* synthetic */ Bundle f47c;

            C0016d(C0012c cVar, SearchCallback searchCallback, String str, Bundle bundle) {
                this.f45a = searchCallback;
                this.f46b = str;
                this.f47c = bundle;
            }

            public void run() {
                this.f45a.onError(this.f46b, this.f47c);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$c$e */
        class C0017e implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SearchCallback f48a;

            /* renamed from: b */
            final /* synthetic */ String f49b;

            /* renamed from: c */
            final /* synthetic */ Bundle f50c;

            C0017e(C0012c cVar, SearchCallback searchCallback, String str, Bundle bundle) {
                this.f48a = searchCallback;
                this.f49b = str;
                this.f50c = bundle;
            }

            public void run() {
                this.f48a.onError(this.f49b, this.f50c);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$c$f */
        class C0018f implements Runnable {

            /* renamed from: a */
            final /* synthetic */ CustomActionCallback f51a;

            /* renamed from: b */
            final /* synthetic */ String f52b;

            /* renamed from: c */
            final /* synthetic */ Bundle f53c;

            C0018f(C0012c cVar, CustomActionCallback customActionCallback, String str, Bundle bundle) {
                this.f51a = customActionCallback;
                this.f52b = str;
                this.f53c = bundle;
            }

            public void run() {
                this.f51a.onError(this.f52b, this.f53c, (Bundle) null);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$c$g */
        class C0019g implements Runnable {

            /* renamed from: a */
            final /* synthetic */ CustomActionCallback f54a;

            /* renamed from: b */
            final /* synthetic */ String f55b;

            /* renamed from: c */
            final /* synthetic */ Bundle f56c;

            C0019g(C0012c cVar, CustomActionCallback customActionCallback, String str, Bundle bundle) {
                this.f54a = customActionCallback;
                this.f55b = str;
                this.f56c = bundle;
            }

            public void run() {
                this.f54a.onError(this.f55b, this.f56c, (Bundle) null);
            }
        }

        C0012c(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            Bundle bundle2;
            this.f29a = context;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            this.f31c = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            connectionCallback.mo47a(this);
            this.f30b = C0038a.m92b(context, componentName, connectionCallback.f7a, bundle2);
        }

        @NonNull
        /* renamed from: a */
        public MediaSessionCompat.Token mo91a() {
            if (this.f37i == null) {
                this.f37i = MediaSessionCompat.Token.fromToken(C0038a.m99i(this.f30b));
            }
            return this.f37i;
        }

        /* renamed from: b */
        public void mo51b() {
            this.f35g = null;
            this.f36h = null;
            this.f37i = null;
            this.f32d.mo89a((Messenger) null);
        }

        /* renamed from: c */
        public void mo52c() {
        }

        /* renamed from: d */
        public void mo92d(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
            if (mo100l()) {
                if (this.f35g == null) {
                    Log.i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
                    if (customActionCallback != null) {
                        this.f32d.post(new C0018f(this, customActionCallback, str, bundle));
                    }
                }
                try {
                    this.f35g.mo134h(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.f32d), this.f36h);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                    if (customActionCallback != null) {
                        this.f32d.post(new C0019g(this, customActionCallback, str, bundle));
                    }
                }
            } else {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with " + "extras " + bundle + " because the browser is not connected to the " + "service.");
            }
        }

        /* renamed from: e */
        public void mo104e(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        /* renamed from: f */
        public ComponentName mo93f() {
            return C0038a.m98h(this.f30b);
        }

        /* renamed from: g */
        public void mo105g(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f36h == messenger) {
                C0034i iVar = this.f33e.get(str);
                if (iVar != null) {
                    SubscriptionCallback a = iVar.mo136a(bundle);
                    if (a == null) {
                        return;
                    }
                    if (bundle == null) {
                        if (list == null) {
                            a.onError(str);
                            return;
                        }
                        this.f38j = bundle2;
                        a.onChildrenLoaded(str, list);
                        this.f38j = null;
                    } else if (list == null) {
                        a.onError(str, bundle);
                    } else {
                        this.f38j = bundle2;
                        a.onChildrenLoaded(str, list, bundle);
                        this.f38j = null;
                    }
                } else if (MediaBrowserCompat.f5b) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                }
            }
        }

        @Nullable
        public Bundle getExtras() {
            return C0038a.m96f(this.f30b);
        }

        @NonNull
        public String getRoot() {
            return C0038a.m97g(this.f30b);
        }

        /* renamed from: h */
        public void mo96h(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            } else if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            } else if (!C0038a.m100j(this.f30b)) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.f32d.post(new C0013a(this, itemCallback, str));
            } else if (this.f35g == null) {
                this.f32d.post(new C0014b(this, itemCallback, str));
            } else {
                try {
                    this.f35g.mo130d(str, new ItemReceiver(str, itemCallback, this.f32d), this.f36h);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                    this.f32d.post(new C0015c(this, itemCallback, str));
                }
            }
        }

        /* renamed from: i */
        public void mo97i() {
            Messenger messenger;
            C0033h hVar = this.f35g;
            if (!(hVar == null || (messenger = this.f36h) == null)) {
                try {
                    hVar.mo135j(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            C0038a.m95e(this.f30b);
        }

        /* renamed from: j */
        public void mo98j() {
            C0038a.m91a(this.f30b);
        }

        /* renamed from: k */
        public void mo99k(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            Bundle bundle2;
            C0034i iVar = this.f33e.get(str);
            if (iVar == null) {
                iVar = new C0034i();
                this.f33e.put(str, iVar);
            }
            subscriptionCallback.mo79a(iVar);
            if (bundle == null) {
                bundle2 = null;
            } else {
                bundle2 = new Bundle(bundle);
            }
            iVar.mo140e(bundle2, subscriptionCallback);
            C0033h hVar = this.f35g;
            if (hVar == null) {
                C0038a.m101k(this.f30b, str, subscriptionCallback.f22a);
                return;
            }
            try {
                hVar.mo127a(str, subscriptionCallback.f23b, bundle2, this.f36h);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + str);
            }
        }

        /* renamed from: l */
        public boolean mo100l() {
            return C0038a.m100j(this.f30b);
        }

        /* renamed from: m */
        public void mo106m(Messenger messenger) {
        }

        /* renamed from: n */
        public void mo101n(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            C0034i iVar = this.f33e.get(str);
            if (iVar != null) {
                C0033h hVar = this.f35g;
                if (hVar == null) {
                    if (subscriptionCallback == null) {
                        C0038a.m102l(this.f30b, str);
                    } else {
                        List<SubscriptionCallback> b = iVar.mo137b();
                        List<Bundle> c = iVar.mo138c();
                        for (int size = b.size() - 1; size >= 0; size--) {
                            if (b.get(size) == subscriptionCallback) {
                                b.remove(size);
                                c.remove(size);
                            }
                        }
                        if (b.size() == 0) {
                            C0038a.m102l(this.f30b, str);
                        }
                    }
                } else if (subscriptionCallback == null) {
                    try {
                        hVar.mo132f(str, (IBinder) null, this.f36h);
                    } catch (RemoteException unused) {
                        Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
                    }
                } else {
                    List<SubscriptionCallback> b2 = iVar.mo137b();
                    List<Bundle> c2 = iVar.mo138c();
                    for (int size2 = b2.size() - 1; size2 >= 0; size2--) {
                        if (b2.get(size2) == subscriptionCallback) {
                            this.f35g.mo132f(str, subscriptionCallback.f23b, this.f36h);
                            b2.remove(size2);
                            c2.remove(size2);
                        }
                    }
                }
                if (iVar.mo139d() || subscriptionCallback == null) {
                    this.f33e.remove(str);
                }
            }
        }

        /* renamed from: o */
        public void mo102o(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
            if (!mo100l()) {
                throw new IllegalStateException("search() called while not connected");
            } else if (this.f35g == null) {
                Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
                this.f32d.post(new C0016d(this, searchCallback, str, bundle));
            } else {
                try {
                    this.f35g.mo133g(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.f32d), this.f36h);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error searching items with query: " + str, e);
                    this.f32d.post(new C0017e(this, searchCallback, str, bundle));
                }
            }
        }

        public void onConnected() {
            Bundle f = C0038a.m96f(this.f30b);
            if (f != null) {
                this.f34f = f.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(f, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    this.f35g = new C0033h(binder, this.f31c);
                    Messenger messenger = new Messenger(this.f32d);
                    this.f36h = messenger;
                    this.f32d.mo89a(messenger);
                    try {
                        this.f35g.mo131e(this.f29a, this.f36h);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(f, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (asInterface != null) {
                    this.f37i = MediaSessionCompat.Token.fromToken(C0038a.m99i(this.f30b), asInterface);
                }
            }
        }

        /* renamed from: p */
        public Bundle mo103p() {
            return this.f38j;
        }
    }

    @RequiresApi(23)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$d */
    static class C0020d extends C0012c {
        C0020d(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        /* renamed from: h */
        public void mo96h(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (this.f35g == null) {
                C0044b.m109b(this.f30b, str, itemCallback.f13a);
            } else {
                super.mo96h(str, itemCallback);
            }
        }
    }

    @RequiresApi(26)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$e */
    static class C0021e extends C0020d {
        C0021e(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        /* renamed from: k */
        public void mo99k(@NonNull String str, @Nullable Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            if (this.f35g != null && this.f34f >= 2) {
                super.mo99k(str, bundle, subscriptionCallback);
            } else if (bundle == null) {
                C0038a.m101k(this.f30b, str, subscriptionCallback.f22a);
            } else {
                C0047c.m112b(this.f30b, str, bundle, subscriptionCallback.f22a);
            }
        }

        /* renamed from: n */
        public void mo101n(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            if (this.f35g != null && this.f34f >= 2) {
                super.mo101n(str, subscriptionCallback);
            } else if (subscriptionCallback == null) {
                C0038a.m102l(this.f30b, str);
            } else {
                C0047c.m113c(this.f30b, str, subscriptionCallback.f22a);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$f */
    static class C0022f implements C0011b, C0032g {

        /* renamed from: a */
        final Context f57a;

        /* renamed from: b */
        final ComponentName f58b;

        /* renamed from: c */
        final ConnectionCallback f59c;

        /* renamed from: d */
        final Bundle f60d;

        /* renamed from: e */
        final C0010a f61e = new C0010a(this);

        /* renamed from: f */
        private final ArrayMap<String, C0034i> f62f = new ArrayMap<>();

        /* renamed from: g */
        int f63g = 1;

        /* renamed from: h */
        C0029g f64h;

        /* renamed from: i */
        C0033h f65i;

        /* renamed from: j */
        Messenger f66j;

        /* renamed from: k */
        private String f67k;

        /* renamed from: l */
        private MediaSessionCompat.Token f68l;

        /* renamed from: m */
        private Bundle f69m;

        /* renamed from: n */
        private Bundle f70n;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$f$a */
        class C0023a implements Runnable {
            C0023a() {
            }

            public void run() {
                C0022f fVar = C0022f.this;
                if (fVar.f63g != 0) {
                    fVar.f63g = 2;
                    if (MediaBrowserCompat.f5b && fVar.f64h != null) {
                        throw new RuntimeException("mServiceConnection should be null. Instead it is " + C0022f.this.f64h);
                    } else if (fVar.f65i != null) {
                        throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + C0022f.this.f65i);
                    } else if (fVar.f66j == null) {
                        Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                        intent.setComponent(C0022f.this.f58b);
                        C0022f fVar2 = C0022f.this;
                        C0029g gVar = new C0029g();
                        fVar2.f64h = gVar;
                        boolean z = false;
                        try {
                            z = fVar2.f57a.bindService(intent, gVar, 1);
                        } catch (Exception unused) {
                            Log.e("MediaBrowserCompat", "Failed binding to service " + C0022f.this.f58b);
                        }
                        if (!z) {
                            C0022f.this.mo115c();
                            C0022f.this.f59c.onConnectionFailed();
                        }
                        if (MediaBrowserCompat.f5b) {
                            Log.d("MediaBrowserCompat", "connect...");
                            C0022f.this.mo114b();
                        }
                    } else {
                        throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + C0022f.this.f66j);
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$f$b */
        class C0024b implements Runnable {
            C0024b() {
            }

            public void run() {
                C0022f fVar = C0022f.this;
                Messenger messenger = fVar.f66j;
                if (messenger != null) {
                    try {
                        fVar.f65i.mo129c(messenger);
                    } catch (RemoteException unused) {
                        Log.w("MediaBrowserCompat", "RemoteException during connect for " + C0022f.this.f58b);
                    }
                }
                C0022f fVar2 = C0022f.this;
                int i = fVar2.f63g;
                fVar2.mo115c();
                if (i != 0) {
                    C0022f.this.f63g = i;
                }
                if (MediaBrowserCompat.f5b) {
                    Log.d("MediaBrowserCompat", "disconnect...");
                    C0022f.this.mo114b();
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$f$c */
        class C0025c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ItemCallback f73a;

            /* renamed from: b */
            final /* synthetic */ String f74b;

            C0025c(C0022f fVar, ItemCallback itemCallback, String str) {
                this.f73a = itemCallback;
                this.f74b = str;
            }

            public void run() {
                this.f73a.onError(this.f74b);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$f$d */
        class C0026d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ItemCallback f75a;

            /* renamed from: b */
            final /* synthetic */ String f76b;

            C0026d(C0022f fVar, ItemCallback itemCallback, String str) {
                this.f75a = itemCallback;
                this.f76b = str;
            }

            public void run() {
                this.f75a.onError(this.f76b);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$f$e */
        class C0027e implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SearchCallback f77a;

            /* renamed from: b */
            final /* synthetic */ String f78b;

            /* renamed from: c */
            final /* synthetic */ Bundle f79c;

            C0027e(C0022f fVar, SearchCallback searchCallback, String str, Bundle bundle) {
                this.f77a = searchCallback;
                this.f78b = str;
                this.f79c = bundle;
            }

            public void run() {
                this.f77a.onError(this.f78b, this.f79c);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$f$f */
        class C0028f implements Runnable {

            /* renamed from: a */
            final /* synthetic */ CustomActionCallback f80a;

            /* renamed from: b */
            final /* synthetic */ String f81b;

            /* renamed from: c */
            final /* synthetic */ Bundle f82c;

            C0028f(C0022f fVar, CustomActionCallback customActionCallback, String str, Bundle bundle) {
                this.f80a = customActionCallback;
                this.f81b = str;
                this.f82c = bundle;
            }

            public void run() {
                this.f80a.onError(this.f81b, this.f82c, (Bundle) null);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$f$g */
        private class C0029g implements ServiceConnection {

            /* renamed from: android.support.v4.media.MediaBrowserCompat$f$g$a */
            class C0030a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ ComponentName f84a;

                /* renamed from: b */
                final /* synthetic */ IBinder f85b;

                C0030a(ComponentName componentName, IBinder iBinder) {
                    this.f84a = componentName;
                    this.f85b = iBinder;
                }

                public void run() {
                    boolean z = MediaBrowserCompat.f5b;
                    if (z) {
                        Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + this.f84a + " binder=" + this.f85b);
                        C0022f.this.mo114b();
                    }
                    if (C0029g.this.mo122a("onServiceConnected")) {
                        C0022f fVar = C0022f.this;
                        fVar.f65i = new C0033h(this.f85b, fVar.f60d);
                        C0022f.this.f66j = new Messenger(C0022f.this.f61e);
                        C0022f fVar2 = C0022f.this;
                        fVar2.f61e.mo89a(fVar2.f66j);
                        C0022f.this.f63g = 2;
                        if (z) {
                            try {
                                Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                C0022f.this.mo114b();
                            } catch (RemoteException unused) {
                                Log.w("MediaBrowserCompat", "RemoteException during connect for " + C0022f.this.f58b);
                                if (MediaBrowserCompat.f5b) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    C0022f.this.mo114b();
                                    return;
                                }
                                return;
                            }
                        }
                        C0022f fVar3 = C0022f.this;
                        fVar3.f65i.mo128b(fVar3.f57a, fVar3.f66j);
                    }
                }
            }

            /* renamed from: android.support.v4.media.MediaBrowserCompat$f$g$b */
            class C0031b implements Runnable {

                /* renamed from: a */
                final /* synthetic */ ComponentName f87a;

                C0031b(ComponentName componentName) {
                    this.f87a = componentName;
                }

                public void run() {
                    if (MediaBrowserCompat.f5b) {
                        Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + this.f87a + " this=" + this + " mServiceConnection=" + C0022f.this.f64h);
                        C0022f.this.mo114b();
                    }
                    if (C0029g.this.mo122a("onServiceDisconnected")) {
                        C0022f fVar = C0022f.this;
                        fVar.f65i = null;
                        fVar.f66j = null;
                        fVar.f61e.mo89a((Messenger) null);
                        C0022f fVar2 = C0022f.this;
                        fVar2.f63g = 4;
                        fVar2.f59c.onConnectionSuspended();
                    }
                }
            }

            C0029g() {
            }

            /* renamed from: b */
            private void m62b(Runnable runnable) {
                if (Thread.currentThread() == C0022f.this.f61e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    C0022f.this.f61e.post(runnable);
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public boolean mo122a(String str) {
                int i;
                C0022f fVar = C0022f.this;
                if (fVar.f64h == this && (i = fVar.f63g) != 0 && i != 1) {
                    return true;
                }
                int i2 = fVar.f63g;
                if (i2 == 0 || i2 == 1) {
                    return false;
                }
                Log.i("MediaBrowserCompat", str + " for " + C0022f.this.f58b + " with mServiceConnection=" + C0022f.this.f64h + " this=" + this);
                return false;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                m62b(new C0030a(componentName, iBinder));
            }

            public void onServiceDisconnected(ComponentName componentName) {
                m62b(new C0031b(componentName));
            }
        }

        public C0022f(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            Bundle bundle2;
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (connectionCallback != null) {
                this.f57a = context;
                this.f58b = componentName;
                this.f59c = connectionCallback;
                if (bundle == null) {
                    bundle2 = null;
                } else {
                    bundle2 = new Bundle(bundle);
                }
                this.f60d = bundle2;
            } else {
                throw new IllegalArgumentException("connection callback must not be null");
            }
        }

        /* renamed from: q */
        private static String m44q(int i) {
            if (i == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i;
        }

        /* renamed from: r */
        private boolean m45r(Messenger messenger, String str) {
            int i;
            if (this.f66j == messenger && (i = this.f63g) != 0 && i != 1) {
                return true;
            }
            int i2 = this.f63g;
            if (i2 == 0 || i2 == 1) {
                return false;
            }
            Log.i("MediaBrowserCompat", str + " for " + this.f58b + " with mCallbacksMessenger=" + this.f66j + " this=" + this);
            return false;
        }

        @NonNull
        /* renamed from: a */
        public MediaSessionCompat.Token mo91a() {
            if (mo100l()) {
                return this.f68l;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f63g + ")");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo114b() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.f58b);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.f59c);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.f60d);
            Log.d("MediaBrowserCompat", "  mState=" + m44q(this.f63g));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.f64h);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.f65i);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.f66j);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.f67k);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.f68l);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo115c() {
            C0029g gVar = this.f64h;
            if (gVar != null) {
                this.f57a.unbindService(gVar);
            }
            this.f63g = 1;
            this.f64h = null;
            this.f65i = null;
            this.f66j = null;
            this.f61e.mo89a((Messenger) null);
            this.f67k = null;
            this.f68l = null;
        }

        /* renamed from: d */
        public void mo92d(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
            if (mo100l()) {
                try {
                    this.f65i.mo134h(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.f61e), this.f66j);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                    if (customActionCallback != null) {
                        this.f61e.post(new C0028f(this, customActionCallback, str, bundle));
                    }
                }
            } else {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with " + "extras " + bundle + " because the browser is not connected to the " + "service.");
            }
        }

        /* renamed from: e */
        public void mo104e(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (m45r(messenger, "onConnect")) {
                if (this.f63g != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + m44q(this.f63g) + "... ignoring");
                    return;
                }
                this.f67k = str;
                this.f68l = token;
                this.f69m = bundle;
                this.f63g = 3;
                if (MediaBrowserCompat.f5b) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    mo114b();
                }
                this.f59c.onConnected();
                try {
                    for (Map.Entry next : this.f62f.entrySet()) {
                        String str2 = (String) next.getKey();
                        C0034i iVar = (C0034i) next.getValue();
                        List<SubscriptionCallback> b = iVar.mo137b();
                        List<Bundle> c = iVar.mo138c();
                        for (int i = 0; i < b.size(); i++) {
                            this.f65i.mo127a(str2, b.get(i).f23b, c.get(i), this.f66j);
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }

        @NonNull
        /* renamed from: f */
        public ComponentName mo93f() {
            if (mo100l()) {
                return this.f58b;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.f63g + ")");
        }

        /* renamed from: g */
        public void mo105g(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (m45r(messenger, "onLoadChildren")) {
                boolean z = MediaBrowserCompat.f5b;
                if (z) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for " + this.f58b + " id=" + str);
                }
                C0034i iVar = this.f62f.get(str);
                if (iVar != null) {
                    SubscriptionCallback a = iVar.mo136a(bundle);
                    if (a == null) {
                        return;
                    }
                    if (bundle == null) {
                        if (list == null) {
                            a.onError(str);
                            return;
                        }
                        this.f70n = bundle2;
                        a.onChildrenLoaded(str, list);
                        this.f70n = null;
                    } else if (list == null) {
                        a.onError(str, bundle);
                    } else {
                        this.f70n = bundle2;
                        a.onChildrenLoaded(str, list, bundle);
                        this.f70n = null;
                    }
                } else if (z) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                }
            }
        }

        @Nullable
        public Bundle getExtras() {
            if (mo100l()) {
                return this.f69m;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + m44q(this.f63g) + ")");
        }

        @NonNull
        public String getRoot() {
            if (mo100l()) {
                return this.f67k;
            }
            throw new IllegalStateException("getRoot() called while not connected(state=" + m44q(this.f63g) + ")");
        }

        /* renamed from: h */
        public void mo96h(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            } else if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            } else if (!mo100l()) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.f61e.post(new C0025c(this, itemCallback, str));
            } else {
                try {
                    this.f65i.mo130d(str, new ItemReceiver(str, itemCallback, this.f61e), this.f66j);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                    this.f61e.post(new C0026d(this, itemCallback, str));
                }
            }
        }

        /* renamed from: i */
        public void mo97i() {
            this.f63g = 0;
            this.f61e.post(new C0024b());
        }

        /* renamed from: j */
        public void mo98j() {
            int i = this.f63g;
            if (i == 0 || i == 1) {
                this.f63g = 2;
                this.f61e.post(new C0023a());
                return;
            }
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + m44q(this.f63g) + ")");
        }

        /* renamed from: k */
        public void mo99k(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            Bundle bundle2;
            C0034i iVar = this.f62f.get(str);
            if (iVar == null) {
                iVar = new C0034i();
                this.f62f.put(str, iVar);
            }
            if (bundle == null) {
                bundle2 = null;
            } else {
                bundle2 = new Bundle(bundle);
            }
            iVar.mo140e(bundle2, subscriptionCallback);
            if (mo100l()) {
                try {
                    this.f65i.mo127a(str, subscriptionCallback.f23b, bundle2, this.f66j);
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        /* renamed from: l */
        public boolean mo100l() {
            return this.f63g == 3;
        }

        /* renamed from: m */
        public void mo106m(Messenger messenger) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.f58b);
            if (m45r(messenger, "onConnectFailed")) {
                if (this.f63g != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + m44q(this.f63g) + "... ignoring");
                    return;
                }
                mo115c();
                this.f59c.onConnectionFailed();
            }
        }

        /* renamed from: n */
        public void mo101n(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            C0034i iVar = this.f62f.get(str);
            if (iVar != null) {
                if (subscriptionCallback == null) {
                    try {
                        if (mo100l()) {
                            this.f65i.mo132f(str, (IBinder) null, this.f66j);
                        }
                    } catch (RemoteException unused) {
                        Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
                    }
                } else {
                    List<SubscriptionCallback> b = iVar.mo137b();
                    List<Bundle> c = iVar.mo138c();
                    for (int size = b.size() - 1; size >= 0; size--) {
                        if (b.get(size) == subscriptionCallback) {
                            if (mo100l()) {
                                this.f65i.mo132f(str, subscriptionCallback.f23b, this.f66j);
                            }
                            b.remove(size);
                            c.remove(size);
                        }
                    }
                }
                if (iVar.mo139d() || subscriptionCallback == null) {
                    this.f62f.remove(str);
                }
            }
        }

        /* renamed from: o */
        public void mo102o(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
            if (mo100l()) {
                try {
                    this.f65i.mo133g(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.f61e), this.f66j);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error searching items with query: " + str, e);
                    this.f61e.post(new C0027e(this, searchCallback, str, bundle));
                }
            } else {
                throw new IllegalStateException("search() called while not connected (state=" + m44q(this.f63g) + ")");
            }
        }

        /* renamed from: p */
        public Bundle mo103p() {
            return this.f70n;
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$g */
    interface C0032g {
        /* renamed from: e */
        void mo104e(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        /* renamed from: g */
        void mo105g(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        /* renamed from: m */
        void mo106m(Messenger messenger);
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$h */
    private static class C0033h {

        /* renamed from: a */
        private Messenger f89a;

        /* renamed from: b */
        private Bundle f90b;

        public C0033h(IBinder iBinder, Bundle bundle) {
            this.f89a = new Messenger(iBinder);
            this.f90b = bundle;
        }

        /* renamed from: i */
        private void m67i(int i, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f89a.send(obtain);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo127a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle2, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            m67i(3, bundle2, messenger);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo128b(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f90b);
            m67i(1, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo129c(Messenger messenger) {
            m67i(2, (Bundle) null, messenger);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo130d(String str, ResultReceiver resultReceiver, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            m67i(5, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo131e(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f90b);
            m67i(6, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo132f(String str, IBinder iBinder, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            m67i(4, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo133g(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            m67i(8, bundle2, messenger);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo134h(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            m67i(9, bundle2, messenger);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo135j(Messenger messenger) {
            m67i(7, (Bundle) null, messenger);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$i */
    private static class C0034i {

        /* renamed from: a */
        private final List<SubscriptionCallback> f91a = new ArrayList();

        /* renamed from: b */
        private final List<Bundle> f92b = new ArrayList();

        /* renamed from: a */
        public SubscriptionCallback mo136a(Bundle bundle) {
            for (int i = 0; i < this.f92b.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.f92b.get(i), bundle)) {
                    return this.f91a.get(i);
                }
            }
            return null;
        }

        /* renamed from: b */
        public List<SubscriptionCallback> mo137b() {
            return this.f91a;
        }

        /* renamed from: c */
        public List<Bundle> mo138c() {
            return this.f92b;
        }

        /* renamed from: d */
        public boolean mo139d() {
            return this.f91a.isEmpty();
        }

        /* renamed from: e */
        public void mo140e(Bundle bundle, SubscriptionCallback subscriptionCallback) {
            for (int i = 0; i < this.f92b.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.f92b.get(i), bundle)) {
                    this.f91a.set(i, subscriptionCallback);
                    return;
                }
            }
            this.f91a.add(subscriptionCallback);
            this.f92b.add(bundle);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f6a = new C0021e(context, componentName, connectionCallback, bundle);
        } else if (i >= 23) {
            this.f6a = new C0020d(context, componentName, connectionCallback, bundle);
        } else if (i >= 21) {
            this.f6a = new C0012c(context, componentName, connectionCallback, bundle);
        } else {
            this.f6a = new C0022f(context, componentName, connectionCallback, bundle);
        }
    }

    public void connect() {
        this.f6a.mo98j();
    }

    public void disconnect() {
        this.f6a.mo97i();
    }

    @Nullable
    public Bundle getExtras() {
        return this.f6a.getExtras();
    }

    public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
        this.f6a.mo96h(str, itemCallback);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Bundle getNotifyChildrenChangedOptions() {
        return this.f6a.mo103p();
    }

    @NonNull
    public String getRoot() {
        return this.f6a.getRoot();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.f6a.mo93f();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return this.f6a.mo91a();
    }

    public boolean isConnected() {
        return this.f6a.mo100l();
    }

    public void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query cannot be empty");
        } else if (searchCallback != null) {
            this.f6a.mo102o(str, bundle, searchCallback);
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    public void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.f6a.mo92d(str, bundle, customActionCallback);
            return;
        }
        throw new IllegalArgumentException("action cannot be empty");
    }

    public void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback != null) {
            this.f6a.mo99k(str, (Bundle) null, subscriptionCallback);
        } else {
            throw new IllegalArgumentException("callback is null");
        }
    }

    public void unsubscribe(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f6a.mo101n(str, (SubscriptionCallback) null);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback != null) {
            this.f6a.mo101n(str, subscriptionCallback);
        } else {
            throw new IllegalArgumentException("callback is null");
        }
    }

    public void subscribe(@NonNull String str, @NonNull Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        } else if (bundle != null) {
            this.f6a.mo99k(str, bundle, subscriptionCallback);
        } else {
            throw new IllegalArgumentException("options are null");
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new C0007a();
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;

        /* renamed from: a */
        private final int f17a;

        /* renamed from: b */
        private final MediaDescriptionCompat f18b;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$Flags */
        public @interface Flags {
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$a */
        static class C0007a implements Parcelable.Creator<MediaItem> {
            C0007a() {
            }

            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: b */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (!TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                this.f17a = i;
                this.f18b = mediaDescriptionCompat;
            } else {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(C0038a.C0041c.m105a(obj)), C0038a.C0041c.m106b(obj));
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object fromMediaItem : list) {
                arrayList.add(fromMediaItem(fromMediaItem));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.f18b;
        }

        public int getFlags() {
            return this.f17a;
        }

        @Nullable
        public String getMediaId() {
            return this.f18b.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.f17a & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.f17a & 2) != 0;
        }

        public String toString() {
            return "MediaItem{" + "mFlags=" + this.f17a + ", mDescription=" + this.f18b + '}';
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f17a);
            this.f18b.writeToParcel(parcel, i);
        }

        MediaItem(Parcel parcel) {
            this.f17a = parcel.readInt();
            this.f18b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
