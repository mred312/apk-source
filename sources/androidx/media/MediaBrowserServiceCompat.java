package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
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
import android.service.media.MediaBrowserService;
import android.support.p000v4.media.MediaBrowserCompat;
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
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;
import androidx.media.MediaBrowserServiceCompatApi26;
import androidx.media.MediaSessionManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_MEDIA_ITEM = "media_item";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SEARCH_RESULTS = "search_results";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_ERROR = -1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_OK = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";

    /* renamed from: f */
    static final boolean f3644f = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: a */
    private C0799f f3645a;

    /* renamed from: b */
    final ArrayMap<IBinder, C0797e> f3646b = new ArrayMap<>();

    /* renamed from: c */
    C0797e f3647c;

    /* renamed from: d */
    final C0826o f3648d = new C0826o();

    /* renamed from: e */
    MediaSessionCompat.Token f3649e;

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";

        /* renamed from: a */
        private final String f3650a;

        /* renamed from: b */
        private final Bundle f3651b;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            if (str != null) {
                this.f3650a = str;
                this.f3651b = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        }

        public Bundle getExtras() {
            return this.f3651b;
        }

        public String getRootId() {
            return this.f3650a;
        }
    }

    public static class Result<T> {

        /* renamed from: a */
        private final Object f3652a;

        /* renamed from: b */
        private boolean f3653b;

        /* renamed from: c */
        private boolean f3654c;

        /* renamed from: d */
        private boolean f3655d;

        /* renamed from: e */
        private int f3656e;

        Result(Object obj) {
            this.f3652a = obj;
        }

        /* renamed from: a */
        private void m2672a(Bundle bundle) {
            if (bundle != null && bundle.containsKey(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                float f = bundle.getFloat(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                if (f < -1.0E-5f || f > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo6453b() {
            return this.f3656e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo6454c() {
            return this.f3653b || this.f3654c || this.f3655d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo6455d(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f3652a);
        }

        public void detach() {
            if (this.f3653b) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.f3652a);
            } else if (this.f3654c) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.f3652a);
            } else if (!this.f3655d) {
                this.f3653b = true;
            } else {
                throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.f3652a);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo6457e(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.f3652a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo6458f(T t) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo6459g(int i) {
            this.f3656e = i;
        }

        public void sendError(Bundle bundle) {
            if (this.f3654c || this.f3655d) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f3652a);
            }
            this.f3655d = true;
            mo6455d(bundle);
        }

        public void sendProgressUpdate(Bundle bundle) {
            if (this.f3654c || this.f3655d) {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.f3652a);
            }
            m2672a(bundle);
            mo6457e(bundle);
        }

        public void sendResult(T t) {
            if (this.f3654c || this.f3655d) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f3652a);
            }
            this.f3654c = true;
            mo6458f(t);
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$a */
    class C0793a extends Result<List<MediaBrowserCompat.MediaItem>> {

        /* renamed from: f */
        final /* synthetic */ C0797e f3657f;

        /* renamed from: g */
        final /* synthetic */ String f3658g;

        /* renamed from: h */
        final /* synthetic */ Bundle f3659h;

        /* renamed from: i */
        final /* synthetic */ Bundle f3660i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0793a(Object obj, C0797e eVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f3657f = eVar;
            this.f3658g = str;
            this.f3659h = bundle;
            this.f3660i = bundle2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo6458f(List<MediaBrowserCompat.MediaItem> list) {
            if (MediaBrowserServiceCompat.this.f3646b.get(this.f3657f.f3668d.asBinder()) == this.f3657f) {
                if ((mo6453b() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.mo6426b(list, this.f3659h);
                }
                try {
                    this.f3657f.f3668d.mo6512a(this.f3658g, list, this.f3659h, this.f3660i);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.f3658g + " package=" + this.f3657f.f3665a);
                }
            } else if (MediaBrowserServiceCompat.f3644f) {
                Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f3657f.f3665a + " id=" + this.f3658g);
            }
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$b */
    class C0794b extends Result<MediaBrowserCompat.MediaItem> {

        /* renamed from: f */
        final /* synthetic */ ResultReceiver f3662f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0794b(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f3662f = resultReceiver;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo6458f(MediaBrowserCompat.MediaItem mediaItem) {
            if ((mo6453b() & 2) != 0) {
                this.f3662f.send(-1, (Bundle) null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
            this.f3662f.send(0, bundle);
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$c */
    class C0795c extends Result<List<MediaBrowserCompat.MediaItem>> {

        /* renamed from: f */
        final /* synthetic */ ResultReceiver f3663f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0795c(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f3663f = resultReceiver;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo6458f(List<MediaBrowserCompat.MediaItem> list) {
            if ((mo6453b() & 4) != 0 || list == null) {
                this.f3663f.send(-1, (Bundle) null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f3663f.send(0, bundle);
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$d */
    class C0796d extends Result<Bundle> {

        /* renamed from: f */
        final /* synthetic */ ResultReceiver f3664f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0796d(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f3664f = resultReceiver;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo6455d(Bundle bundle) {
            this.f3664f.send(-1, bundle);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo6457e(Bundle bundle) {
            this.f3664f.send(1, bundle);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo6458f(Bundle bundle) {
            this.f3664f.send(0, bundle);
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$e */
    private class C0797e implements IBinder.DeathRecipient {

        /* renamed from: a */
        public final String f3665a;

        /* renamed from: b */
        public final MediaSessionManager.RemoteUserInfo f3666b;

        /* renamed from: c */
        public final Bundle f3667c;

        /* renamed from: d */
        public final C0824m f3668d;

        /* renamed from: e */
        public final HashMap<String, List<Pair<IBinder, Bundle>>> f3669e = new HashMap<>();

        /* renamed from: f */
        public BrowserRoot f3670f;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$e$a */
        class C0798a implements Runnable {
            C0798a() {
            }

            public void run() {
                C0797e eVar = C0797e.this;
                MediaBrowserServiceCompat.this.f3646b.remove(eVar.f3668d.asBinder());
            }
        }

        C0797e(String str, int i, int i2, Bundle bundle, C0824m mVar) {
            this.f3665a = str;
            this.f3666b = new MediaSessionManager.RemoteUserInfo(str, i, i2);
            this.f3667c = bundle;
            this.f3668d = mVar;
        }

        public void binderDied() {
            MediaBrowserServiceCompat.this.f3648d.post(new C0798a());
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$f */
    interface C0799f {
        /* renamed from: a */
        void mo6469a();

        /* renamed from: b */
        Bundle mo6470b();

        /* renamed from: c */
        void mo6471c(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle);

        /* renamed from: d */
        MediaSessionManager.RemoteUserInfo mo6472d();

        /* renamed from: e */
        IBinder mo6473e(Intent intent);

        /* renamed from: f */
        void mo6474f(String str, Bundle bundle);

        /* renamed from: g */
        void mo6475g(MediaSessionCompat.Token token);
    }

    @RequiresApi(21)
    /* renamed from: androidx.media.MediaBrowserServiceCompat$g */
    class C0800g implements C0799f, MediaBrowserServiceCompatApi21.ServiceCompatProxy {

        /* renamed from: a */
        final List<Bundle> f3673a = new ArrayList();

        /* renamed from: b */
        Object f3674b;

        /* renamed from: c */
        Messenger f3675c;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$g$a */
        class C0801a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ MediaSessionCompat.Token f3677a;

            C0801a(MediaSessionCompat.Token token) {
                this.f3677a = token;
            }

            public void run() {
                if (!C0800g.this.f3673a.isEmpty()) {
                    IMediaSession extraBinder = this.f3677a.getExtraBinder();
                    if (extraBinder != null) {
                        for (Bundle putBinder : C0800g.this.f3673a) {
                            BundleCompat.putBinder(putBinder, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                        }
                    }
                    C0800g.this.f3673a.clear();
                }
                MediaBrowserServiceCompatApi21.m2747e(C0800g.this.f3674b, this.f3677a.getToken());
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$g$b */
        class C0802b extends Result<List<MediaBrowserCompat.MediaItem>> {

            /* renamed from: f */
            final /* synthetic */ MediaBrowserServiceCompatApi21.C0829c f3679f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0802b(C0800g gVar, Object obj, MediaBrowserServiceCompatApi21.C0829c cVar) {
                super(obj);
                this.f3679f = cVar;
            }

            public void detach() {
                this.f3679f.mo6521a();
            }

            /* access modifiers changed from: package-private */
            /* renamed from: h */
            public void mo6458f(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem writeToParcel : list) {
                        Parcel obtain = Parcel.obtain();
                        writeToParcel.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f3679f.mo6523c(arrayList);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$g$c */
        class C0803c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f3680a;

            /* renamed from: b */
            final /* synthetic */ Bundle f3681b;

            C0803c(String str, Bundle bundle) {
                this.f3680a = str;
                this.f3681b = bundle;
            }

            public void run() {
                for (IBinder iBinder : MediaBrowserServiceCompat.this.f3646b.keySet()) {
                    ArrayMap<IBinder, C0797e> arrayMap = MediaBrowserServiceCompat.this.f3646b;
                    C0800g.this.mo6478j(arrayMap.get(iBinder), this.f3680a, this.f3681b);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$g$d */
        class C0804d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ MediaSessionManager.RemoteUserInfo f3683a;

            /* renamed from: b */
            final /* synthetic */ String f3684b;

            /* renamed from: c */
            final /* synthetic */ Bundle f3685c;

            C0804d(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
                this.f3683a = remoteUserInfo;
                this.f3684b = str;
                this.f3685c = bundle;
            }

            public void run() {
                for (int i = 0; i < MediaBrowserServiceCompat.this.f3646b.size(); i++) {
                    C0797e valueAt = MediaBrowserServiceCompat.this.f3646b.valueAt(i);
                    if (valueAt.f3666b.equals(this.f3683a)) {
                        C0800g.this.mo6478j(valueAt, this.f3684b, this.f3685c);
                    }
                }
            }
        }

        C0800g() {
        }

        /* renamed from: a */
        public void mo6469a() {
            Object a = MediaBrowserServiceCompatApi21.m2743a(MediaBrowserServiceCompat.this, this);
            this.f3674b = a;
            MediaBrowserServiceCompatApi21.m2746d(a);
        }

        /* renamed from: b */
        public Bundle mo6470b() {
            if (this.f3675c == null) {
                return null;
            }
            C0797e eVar = MediaBrowserServiceCompat.this.f3647c;
            if (eVar == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (eVar.f3667c == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.f3647c.f3667c);
            }
        }

        /* renamed from: c */
        public void mo6471c(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            mo6476h(remoteUserInfo, str, bundle);
        }

        /* renamed from: d */
        public MediaSessionManager.RemoteUserInfo mo6472d() {
            C0797e eVar = MediaBrowserServiceCompat.this.f3647c;
            if (eVar != null) {
                return eVar.f3666b;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        /* renamed from: e */
        public IBinder mo6473e(Intent intent) {
            return MediaBrowserServiceCompatApi21.m2745c(this.f3674b, intent);
        }

        /* renamed from: f */
        public void mo6474f(String str, Bundle bundle) {
            mo6479k(str, bundle);
            mo6477i(str, bundle);
        }

        /* renamed from: g */
        public void mo6475g(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.f3648d.mo6516a(new C0801a(token));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo6476h(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f3648d.post(new C0804d(remoteUserInfo, str, bundle));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo6477i(String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f3648d.post(new C0803c(str, bundle));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo6478j(C0797e eVar, String str, Bundle bundle) {
            List<Pair> list = eVar.f3669e.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                        MediaBrowserServiceCompat.this.mo6430e(str, eVar, (Bundle) pair.second, bundle);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo6479k(String str, Bundle bundle) {
            MediaBrowserServiceCompatApi21.m2744b(this.f3674b, str);
        }

        public MediaBrowserServiceCompatApi21.C0827a onGetRoot(String str, int i, Bundle bundle) {
            Bundle bundle2;
            IBinder iBinder;
            if (bundle == null || bundle.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.f3675c = new Messenger(MediaBrowserServiceCompat.this.f3648d);
                bundle2 = new Bundle();
                bundle2.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.f3675c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f3649e;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    if (extraBinder == null) {
                        iBinder = null;
                    } else {
                        iBinder = extraBinder.asBinder();
                    }
                    BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_SESSION_BINDER, iBinder);
                } else {
                    this.f3673a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f3647c = new C0797e(str, -1, i, bundle, (C0824m) null);
            BrowserRoot onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            MediaBrowserServiceCompat.this.f3647c = null;
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.getExtras();
            } else if (onGetRoot.getExtras() != null) {
                bundle2.putAll(onGetRoot.getExtras());
            }
            return new MediaBrowserServiceCompatApi21.C0827a(onGetRoot.getRootId(), bundle2);
        }

        public void onLoadChildren(String str, MediaBrowserServiceCompatApi21.C0829c<List<Parcel>> cVar) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new C0802b(this, str, cVar));
        }
    }

    @RequiresApi(23)
    /* renamed from: androidx.media.MediaBrowserServiceCompat$h */
    class C0805h extends C0800g implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$h$a */
        class C0806a extends Result<MediaBrowserCompat.MediaItem> {

            /* renamed from: f */
            final /* synthetic */ MediaBrowserServiceCompatApi21.C0829c f3688f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0806a(C0805h hVar, Object obj, MediaBrowserServiceCompatApi21.C0829c cVar) {
                super(obj);
                this.f3688f = cVar;
            }

            public void detach() {
                this.f3688f.mo6521a();
            }

            /* access modifiers changed from: package-private */
            /* renamed from: h */
            public void mo6458f(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f3688f.mo6523c(null);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                this.f3688f.mo6523c(obtain);
            }
        }

        C0805h() {
            super();
        }

        /* renamed from: a */
        public void mo6469a() {
            Object a = MediaBrowserServiceCompatApi23.m2751a(MediaBrowserServiceCompat.this, this);
            this.f3674b = a;
            MediaBrowserServiceCompatApi21.m2746d(a);
        }

        public void onLoadItem(String str, MediaBrowserServiceCompatApi21.C0829c<Parcel> cVar) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new C0806a(this, str, cVar));
        }
    }

    @RequiresApi(26)
    /* renamed from: androidx.media.MediaBrowserServiceCompat$i */
    class C0807i extends C0805h implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$i$a */
        class C0808a extends Result<List<MediaBrowserCompat.MediaItem>> {

            /* renamed from: f */
            final /* synthetic */ MediaBrowserServiceCompatApi26.C0832b f3690f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0808a(C0807i iVar, Object obj, MediaBrowserServiceCompatApi26.C0832b bVar) {
                super(obj);
                this.f3690f = bVar;
            }

            public void detach() {
                this.f3690f.mo6526a();
            }

            /* access modifiers changed from: package-private */
            /* renamed from: h */
            public void mo6458f(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem writeToParcel : list) {
                        Parcel obtain = Parcel.obtain();
                        writeToParcel.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f3690f.mo6528c(arrayList, mo6453b());
            }
        }

        C0807i() {
            super();
        }

        /* renamed from: a */
        public void mo6469a() {
            Object a = MediaBrowserServiceCompatApi26.m2752a(MediaBrowserServiceCompat.this, this);
            this.f3674b = a;
            MediaBrowserServiceCompatApi21.m2746d(a);
        }

        /* renamed from: b */
        public Bundle mo6470b() {
            C0797e eVar = MediaBrowserServiceCompat.this.f3647c;
            if (eVar == null) {
                return MediaBrowserServiceCompatApi26.m2753b(this.f3674b);
            }
            if (eVar.f3667c == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.f3647c.f3667c);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo6479k(String str, Bundle bundle) {
            if (bundle != null) {
                MediaBrowserServiceCompatApi26.m2754c(this.f3674b, str, bundle);
            } else {
                super.mo6479k(str, bundle);
            }
        }

        public void onLoadChildren(String str, MediaBrowserServiceCompatApi26.C0832b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new C0808a(this, str, bVar), bundle);
        }
    }

    @RequiresApi(28)
    /* renamed from: androidx.media.MediaBrowserServiceCompat$j */
    class C0809j extends C0807i {
        C0809j() {
            super();
        }

        /* renamed from: d */
        public MediaSessionManager.RemoteUserInfo mo6472d() {
            C0797e eVar = MediaBrowserServiceCompat.this.f3647c;
            if (eVar != null) {
                return eVar.f3666b;
            }
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.f3674b).getCurrentBrowserInfo());
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$k */
    class C0810k implements C0799f {

        /* renamed from: a */
        private Messenger f3692a;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$k$a */
        class C0811a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ MediaSessionCompat.Token f3694a;

            C0811a(MediaSessionCompat.Token token) {
                this.f3694a = token;
            }

            public void run() {
                Iterator<C0797e> it = MediaBrowserServiceCompat.this.f3646b.values().iterator();
                while (it.hasNext()) {
                    C0797e next = it.next();
                    try {
                        next.f3668d.mo6515c(next.f3670f.getRootId(), this.f3694a, next.f3670f.getExtras());
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Connection for " + next.f3665a + " is no longer valid.");
                        it.remove();
                    }
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$k$b */
        class C0812b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f3696a;

            /* renamed from: b */
            final /* synthetic */ Bundle f3697b;

            C0812b(String str, Bundle bundle) {
                this.f3696a = str;
                this.f3697b = bundle;
            }

            public void run() {
                for (IBinder iBinder : MediaBrowserServiceCompat.this.f3646b.keySet()) {
                    ArrayMap<IBinder, C0797e> arrayMap = MediaBrowserServiceCompat.this.f3646b;
                    C0810k.this.mo6490h(arrayMap.get(iBinder), this.f3696a, this.f3697b);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$k$c */
        class C0813c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ MediaSessionManager.RemoteUserInfo f3699a;

            /* renamed from: b */
            final /* synthetic */ String f3700b;

            /* renamed from: c */
            final /* synthetic */ Bundle f3701c;

            C0813c(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
                this.f3699a = remoteUserInfo;
                this.f3700b = str;
                this.f3701c = bundle;
            }

            public void run() {
                for (int i = 0; i < MediaBrowserServiceCompat.this.f3646b.size(); i++) {
                    C0797e valueAt = MediaBrowserServiceCompat.this.f3646b.valueAt(i);
                    if (valueAt.f3666b.equals(this.f3699a)) {
                        C0810k.this.mo6490h(valueAt, this.f3700b, this.f3701c);
                        return;
                    }
                }
            }
        }

        C0810k() {
        }

        /* renamed from: a */
        public void mo6469a() {
            this.f3692a = new Messenger(MediaBrowserServiceCompat.this.f3648d);
        }

        /* renamed from: b */
        public Bundle mo6470b() {
            C0797e eVar = MediaBrowserServiceCompat.this.f3647c;
            if (eVar == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (eVar.f3667c == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.f3647c.f3667c);
            }
        }

        /* renamed from: c */
        public void mo6471c(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f3648d.post(new C0813c(remoteUserInfo, str, bundle));
        }

        /* renamed from: d */
        public MediaSessionManager.RemoteUserInfo mo6472d() {
            C0797e eVar = MediaBrowserServiceCompat.this.f3647c;
            if (eVar != null) {
                return eVar.f3666b;
            }
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        /* renamed from: e */
        public IBinder mo6473e(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.f3692a.getBinder();
            }
            return null;
        }

        /* renamed from: f */
        public void mo6474f(@NonNull String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f3648d.post(new C0812b(str, bundle));
        }

        /* renamed from: g */
        public void mo6475g(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.f3648d.post(new C0811a(token));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo6490h(C0797e eVar, String str, Bundle bundle) {
            List<Pair> list = eVar.f3669e.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                        MediaBrowserServiceCompat.this.mo6430e(str, eVar, (Bundle) pair.second, bundle);
                    }
                }
            }
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$l */
    private class C0814l {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$l$a */
        class C0815a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0824m f3704a;

            /* renamed from: b */
            final /* synthetic */ String f3705b;

            /* renamed from: c */
            final /* synthetic */ int f3706c;

            /* renamed from: d */
            final /* synthetic */ int f3707d;

            /* renamed from: e */
            final /* synthetic */ Bundle f3708e;

            C0815a(C0824m mVar, String str, int i, int i2, Bundle bundle) {
                this.f3704a = mVar;
                this.f3705b = str;
                this.f3706c = i;
                this.f3707d = i2;
                this.f3708e = bundle;
            }

            public void run() {
                IBinder asBinder = this.f3704a.asBinder();
                MediaBrowserServiceCompat.this.f3646b.remove(asBinder);
                C0797e eVar = new C0797e(this.f3705b, this.f3706c, this.f3707d, this.f3708e, this.f3704a);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f3647c = eVar;
                BrowserRoot onGetRoot = mediaBrowserServiceCompat.onGetRoot(this.f3705b, this.f3707d, this.f3708e);
                eVar.f3670f = onGetRoot;
                MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat2.f3647c = null;
                if (onGetRoot == null) {
                    Log.i("MBServiceCompat", "No root for client " + this.f3705b + " from service " + C0815a.class.getName());
                    try {
                        this.f3704a.mo6514b();
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f3705b);
                    }
                } else {
                    try {
                        mediaBrowserServiceCompat2.f3646b.put(asBinder, eVar);
                        asBinder.linkToDeath(eVar, 0);
                        if (MediaBrowserServiceCompat.this.f3649e != null) {
                            this.f3704a.mo6515c(eVar.f3670f.getRootId(), MediaBrowserServiceCompat.this.f3649e, eVar.f3670f.getExtras());
                        }
                    } catch (RemoteException unused2) {
                        Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.f3705b);
                        MediaBrowserServiceCompat.this.f3646b.remove(asBinder);
                    }
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$l$b */
        class C0816b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0824m f3710a;

            C0816b(C0824m mVar) {
                this.f3710a = mVar;
            }

            public void run() {
                C0797e remove = MediaBrowserServiceCompat.this.f3646b.remove(this.f3710a.asBinder());
                if (remove != null) {
                    remove.f3668d.asBinder().unlinkToDeath(remove, 0);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$l$c */
        class C0817c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0824m f3712a;

            /* renamed from: b */
            final /* synthetic */ String f3713b;

            /* renamed from: c */
            final /* synthetic */ IBinder f3714c;

            /* renamed from: d */
            final /* synthetic */ Bundle f3715d;

            C0817c(C0824m mVar, String str, IBinder iBinder, Bundle bundle) {
                this.f3712a = mVar;
                this.f3713b = str;
                this.f3714c = iBinder;
                this.f3715d = bundle;
            }

            public void run() {
                C0797e eVar = MediaBrowserServiceCompat.this.f3646b.get(this.f3712a.asBinder());
                if (eVar == null) {
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.f3713b);
                    return;
                }
                MediaBrowserServiceCompat.this.mo6424a(this.f3713b, eVar, this.f3714c, this.f3715d);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$l$d */
        class C0818d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0824m f3717a;

            /* renamed from: b */
            final /* synthetic */ String f3718b;

            /* renamed from: c */
            final /* synthetic */ IBinder f3719c;

            C0818d(C0824m mVar, String str, IBinder iBinder) {
                this.f3717a = mVar;
                this.f3718b = str;
                this.f3719c = iBinder;
            }

            public void run() {
                C0797e eVar = MediaBrowserServiceCompat.this.f3646b.get(this.f3717a.asBinder());
                if (eVar == null) {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.f3718b);
                } else if (!MediaBrowserServiceCompat.this.mo6436h(this.f3718b, eVar, this.f3719c)) {
                    Log.w("MBServiceCompat", "removeSubscription called for " + this.f3718b + " which is not subscribed");
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$l$e */
        class C0819e implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0824m f3721a;

            /* renamed from: b */
            final /* synthetic */ String f3722b;

            /* renamed from: c */
            final /* synthetic */ ResultReceiver f3723c;

            C0819e(C0824m mVar, String str, ResultReceiver resultReceiver) {
                this.f3721a = mVar;
                this.f3722b = str;
                this.f3723c = resultReceiver;
            }

            public void run() {
                C0797e eVar = MediaBrowserServiceCompat.this.f3646b.get(this.f3721a.asBinder());
                if (eVar == null) {
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f3722b);
                    return;
                }
                MediaBrowserServiceCompat.this.mo6431f(this.f3722b, eVar, this.f3723c);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$l$f */
        class C0820f implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0824m f3725a;

            /* renamed from: b */
            final /* synthetic */ String f3726b;

            /* renamed from: c */
            final /* synthetic */ int f3727c;

            /* renamed from: d */
            final /* synthetic */ int f3728d;

            /* renamed from: e */
            final /* synthetic */ Bundle f3729e;

            C0820f(C0824m mVar, String str, int i, int i2, Bundle bundle) {
                this.f3725a = mVar;
                this.f3726b = str;
                this.f3727c = i;
                this.f3728d = i2;
                this.f3729e = bundle;
            }

            public void run() {
                IBinder asBinder = this.f3725a.asBinder();
                MediaBrowserServiceCompat.this.f3646b.remove(asBinder);
                C0797e eVar = new C0797e(this.f3726b, this.f3727c, this.f3728d, this.f3729e, this.f3725a);
                MediaBrowserServiceCompat.this.f3646b.put(asBinder, eVar);
                try {
                    asBinder.linkToDeath(eVar, 0);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$l$g */
        class C0821g implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0824m f3731a;

            C0821g(C0824m mVar) {
                this.f3731a = mVar;
            }

            public void run() {
                IBinder asBinder = this.f3731a.asBinder();
                C0797e remove = MediaBrowserServiceCompat.this.f3646b.remove(asBinder);
                if (remove != null) {
                    asBinder.unlinkToDeath(remove, 0);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$l$h */
        class C0822h implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0824m f3733a;

            /* renamed from: b */
            final /* synthetic */ String f3734b;

            /* renamed from: c */
            final /* synthetic */ Bundle f3735c;

            /* renamed from: d */
            final /* synthetic */ ResultReceiver f3736d;

            C0822h(C0824m mVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f3733a = mVar;
                this.f3734b = str;
                this.f3735c = bundle;
                this.f3736d = resultReceiver;
            }

            public void run() {
                C0797e eVar = MediaBrowserServiceCompat.this.f3646b.get(this.f3733a.asBinder());
                if (eVar == null) {
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f3734b);
                    return;
                }
                MediaBrowserServiceCompat.this.mo6432g(this.f3734b, this.f3735c, eVar, this.f3736d);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$l$i */
        class C0823i implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0824m f3738a;

            /* renamed from: b */
            final /* synthetic */ String f3739b;

            /* renamed from: c */
            final /* synthetic */ Bundle f3740c;

            /* renamed from: d */
            final /* synthetic */ ResultReceiver f3741d;

            C0823i(C0824m mVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f3738a = mVar;
                this.f3739b = str;
                this.f3740c = bundle;
                this.f3741d = resultReceiver;
            }

            public void run() {
                C0797e eVar = MediaBrowserServiceCompat.this.f3646b.get(this.f3738a.asBinder());
                if (eVar == null) {
                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f3739b + ", extras=" + this.f3740c);
                    return;
                }
                MediaBrowserServiceCompat.this.mo6428d(this.f3739b, this.f3740c, eVar, this.f3741d);
            }
        }

        C0814l() {
        }

        /* renamed from: a */
        public void mo6494a(String str, IBinder iBinder, Bundle bundle, C0824m mVar) {
            MediaBrowserServiceCompat.this.f3648d.mo6516a(new C0817c(mVar, str, iBinder, bundle));
        }

        /* renamed from: b */
        public void mo6495b(String str, int i, int i2, Bundle bundle, C0824m mVar) {
            if (MediaBrowserServiceCompat.this.mo6427c(str, i2)) {
                MediaBrowserServiceCompat.this.f3648d.mo6516a(new C0815a(mVar, str, i, i2, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + str);
        }

        /* renamed from: c */
        public void mo6496c(C0824m mVar) {
            MediaBrowserServiceCompat.this.f3648d.mo6516a(new C0816b(mVar));
        }

        /* renamed from: d */
        public void mo6497d(String str, ResultReceiver resultReceiver, C0824m mVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f3648d.mo6516a(new C0819e(mVar, str, resultReceiver));
            }
        }

        /* renamed from: e */
        public void mo6498e(C0824m mVar, String str, int i, int i2, Bundle bundle) {
            MediaBrowserServiceCompat.this.f3648d.mo6516a(new C0820f(mVar, str, i, i2, bundle));
        }

        /* renamed from: f */
        public void mo6499f(String str, IBinder iBinder, C0824m mVar) {
            MediaBrowserServiceCompat.this.f3648d.mo6516a(new C0818d(mVar, str, iBinder));
        }

        /* renamed from: g */
        public void mo6500g(String str, Bundle bundle, ResultReceiver resultReceiver, C0824m mVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f3648d.mo6516a(new C0822h(mVar, str, bundle, resultReceiver));
            }
        }

        /* renamed from: h */
        public void mo6501h(String str, Bundle bundle, ResultReceiver resultReceiver, C0824m mVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f3648d.mo6516a(new C0823i(mVar, str, bundle, resultReceiver));
            }
        }

        /* renamed from: i */
        public void mo6502i(C0824m mVar) {
            MediaBrowserServiceCompat.this.f3648d.mo6516a(new C0821g(mVar));
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$m */
    private interface C0824m {
        /* renamed from: a */
        void mo6512a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();

        /* renamed from: b */
        void mo6514b();

        /* renamed from: c */
        void mo6515c(String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$n */
    private static class C0825n implements C0824m {

        /* renamed from: a */
        final Messenger f3743a;

        C0825n(Messenger messenger) {
            this.f3743a = messenger;
        }

        /* renamed from: d */
        private void m2738d(int i, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f3743a.send(obtain);
        }

        /* renamed from: a */
        public void mo6512a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) {
            Bundle bundle3 = new Bundle();
            bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            bundle3.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            m2738d(3, bundle3);
        }

        public IBinder asBinder() {
            return this.f3743a.getBinder();
        }

        /* renamed from: b */
        public void mo6514b() {
            m2738d(2, (Bundle) null);
        }

        /* renamed from: c */
        public void mo6515c(String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            m2738d(1, bundle2);
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$o */
    private final class C0826o extends Handler {

        /* renamed from: a */
        private final C0814l f3744a;

        C0826o() {
            this.f3744a = new C0814l();
        }

        /* renamed from: a */
        public void mo6516a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.f3744a.mo6495b(data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle, new C0825n(message.replyTo));
                    return;
                case 2:
                    this.f3744a.mo6496c(new C0825n(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.f3744a.mo6494a(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), bundle2, new C0825n(message.replyTo));
                    return;
                case 4:
                    this.f3744a.mo6499f(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new C0825n(message.replyTo));
                    return;
                case 5:
                    this.f3744a.mo6497d(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new C0825n(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    C0814l lVar = this.f3744a;
                    C0825n nVar = new C0825n(message.replyTo);
                    lVar.mo6498e(nVar, data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle3);
                    return;
                case 7:
                    this.f3744a.mo6502i(new C0825n(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.f3744a.mo6500g(data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), bundle4, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new C0825n(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.f3744a.mo6501h(data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), bundle5, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new C0825n(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: " + 2 + "\n  Client version: " + message.arg1);
                    return;
            }
        }

        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6424a(String str, C0797e eVar, IBinder iBinder, Bundle bundle) {
        List<Pair> list = eVar.f3669e.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Pair pair : list) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, (Bundle) pair.second)) {
                return;
            }
        }
        list.add(new Pair(iBinder, bundle));
        eVar.f3669e.put(str, list);
        mo6430e(str, eVar, bundle, (Bundle) null);
        this.f3647c = eVar;
        onSubscribe(str, bundle);
        this.f3647c = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<MediaBrowserCompat.MediaItem> mo6426b(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
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

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6427c(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6428d(String str, Bundle bundle, C0797e eVar, ResultReceiver resultReceiver) {
        C0796d dVar = new C0796d(this, str, resultReceiver);
        this.f3647c = eVar;
        onCustomAction(str, bundle, dVar);
        this.f3647c = null;
        if (!dVar.mo6454c()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6430e(String str, C0797e eVar, Bundle bundle, Bundle bundle2) {
        C0793a aVar = new C0793a(str, eVar, str, bundle, bundle2);
        this.f3647c = eVar;
        if (bundle == null) {
            onLoadChildren(str, aVar);
        } else {
            onLoadChildren(str, aVar, bundle);
        }
        this.f3647c = null;
        if (!aVar.mo6454c()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + eVar.f3665a + " id=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6431f(String str, C0797e eVar, ResultReceiver resultReceiver) {
        C0794b bVar = new C0794b(this, str, resultReceiver);
        this.f3647c = eVar;
        onLoadItem(str, bVar);
        this.f3647c = null;
        if (!bVar.mo6454c()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo6432g(String str, Bundle bundle, C0797e eVar, ResultReceiver resultReceiver) {
        C0795c cVar = new C0795c(this, str, resultReceiver);
        this.f3647c = eVar;
        onSearch(str, bundle, cVar);
        this.f3647c = null;
        if (!cVar.mo6454c()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    public final Bundle getBrowserRootHints() {
        return this.f3645a.mo6470b();
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.f3645a.mo6472d();
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return this.f3649e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo6436h(String str, C0797e eVar, IBinder iBinder) {
        boolean z = true;
        boolean z2 = false;
        if (iBinder == null) {
            try {
                if (eVar.f3669e.remove(str) == null) {
                    z = false;
                }
                return z;
            } finally {
                this.f3647c = eVar;
                onUnsubscribe(str);
                this.f3647c = null;
            }
        } else {
            List list = eVar.f3669e.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((Pair) it.next()).first) {
                        it.remove();
                        z2 = true;
                    }
                }
                if (list.size() == 0) {
                    eVar.f3669e.remove(str);
                }
            }
            this.f3647c = eVar;
            onUnsubscribe(str);
            this.f3647c = null;
            return z2;
        }
    }

    public void notifyChildrenChanged(@NonNull String str) {
        if (str != null) {
            this.f3645a.mo6474f(str, (Bundle) null);
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public IBinder onBind(Intent intent) {
        return this.f3645a.mo6473e(intent);
    }

    public void onCreate() {
        super.onCreate();
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f3645a = new C0809j();
        } else if (i >= 26) {
            this.f3645a = new C0807i();
        } else if (i >= 23) {
            this.f3645a = new C0805h();
        } else if (i >= 21) {
            this.f3645a = new C0800g();
        } else {
            this.f3645a = new C0810k();
        }
        this.f3645a.mo6469a();
    }

    public void onCustomAction(@NonNull String str, Bundle bundle, @NonNull Result<Bundle> result) {
        result.sendError((Bundle) null);
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result, @NonNull Bundle bundle) {
        result.mo6459g(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, @NonNull Result<MediaBrowserCompat.MediaItem> result) {
        result.mo6459g(2);
        result.sendResult(null);
    }

    public void onSearch(@NonNull String str, Bundle bundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.mo6459g(4);
        result.sendResult(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSubscribe(String str, Bundle bundle) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnsubscribe(String str) {
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.f3649e == null) {
            this.f3649e = token;
            this.f3645a.mo6475g(token);
        } else {
            throw new IllegalStateException("The session token has already been set.");
        }
    }

    public void notifyChildrenChanged(@NonNull String str, @NonNull Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.f3645a.mo6474f(str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, @NonNull Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        } else if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.f3645a.mo6471c(remoteUserInfo, str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }
}
