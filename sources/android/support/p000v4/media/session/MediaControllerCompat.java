package android.support.p000v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.p000v4.media.MediaDescriptionCompat;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.RatingCompat;
import android.support.p000v4.media.session.IMediaControllerCallback;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.MediaControllerCompatApi21;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.app.ComponentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaControllerCompat */
public final class MediaControllerCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";

    /* renamed from: a */
    private final C0061b f126a;

    /* renamed from: b */
    private final MediaSessionCompat.Token f127b;

    /* renamed from: c */
    private final HashSet<Callback> f128c = new HashSet<>();

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback */
    public static abstract class Callback implements IBinder.DeathRecipient {

        /* renamed from: a */
        final Object f129a;

        /* renamed from: b */
        C0056a f130b;

        /* renamed from: c */
        IMediaControllerCallback f131c;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$a */
        private class C0056a extends Handler {

            /* renamed from: a */
            boolean f132a = false;

            C0056a(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (this.f132a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.ensureClassLoader(data);
                            Callback.this.onSessionEvent((String) message.obj, data);
                            return;
                        case 2:
                            Callback.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            Callback.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            Callback.this.onAudioInfoChanged((PlaybackInfo) message.obj);
                            return;
                        case 5:
                            Callback.this.onQueueChanged((List) message.obj);
                            return;
                        case 6:
                            Callback.this.onQueueTitleChanged((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.ensureClassLoader(bundle);
                            Callback.this.onExtrasChanged(bundle);
                            return;
                        case 8:
                            Callback.this.onSessionDestroyed();
                            return;
                        case 9:
                            Callback.this.onRepeatModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 11:
                            Callback.this.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            Callback.this.onShuffleModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            Callback.this.onSessionReady();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$b */
        private static class C0057b implements MediaControllerCompatApi21.Callback {

            /* renamed from: a */
            private final WeakReference<Callback> f134a;

            C0057b(Callback callback) {
                this.f134a = new WeakReference<>(callback);
            }

            public void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5) {
                Callback callback = (Callback) this.f134a.get();
                if (callback != null) {
                    callback.onAudioInfoChanged(new PlaybackInfo(i, i2, i3, i4, i5));
                }
            }

            public void onExtrasChanged(Bundle bundle) {
                Callback callback = (Callback) this.f134a.get();
                if (callback != null) {
                    callback.onExtrasChanged(bundle);
                }
            }

            public void onMetadataChanged(Object obj) {
                Callback callback = (Callback) this.f134a.get();
                if (callback != null) {
                    callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
                }
            }

            public void onPlaybackStateChanged(Object obj) {
                Callback callback = (Callback) this.f134a.get();
                if (callback != null && callback.f131c == null) {
                    callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
                }
            }

            public void onQueueChanged(List<?> list) {
                Callback callback = (Callback) this.f134a.get();
                if (callback != null) {
                    callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback = (Callback) this.f134a.get();
                if (callback != null) {
                    callback.onQueueTitleChanged(charSequence);
                }
            }

            public void onSessionDestroyed() {
                Callback callback = (Callback) this.f134a.get();
                if (callback != null) {
                    callback.onSessionDestroyed();
                }
            }

            public void onSessionEvent(String str, Bundle bundle) {
                Callback callback = (Callback) this.f134a.get();
                if (callback == null) {
                    return;
                }
                if (callback.f131c == null || Build.VERSION.SDK_INT >= 23) {
                    callback.onSessionEvent(str, bundle);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$c */
        private static class C0058c extends IMediaControllerCallback.Stub {

            /* renamed from: a */
            private final WeakReference<Callback> f135a;

            C0058c(Callback callback) {
                this.f135a = new WeakReference<>(callback);
            }

            public void onCaptioningEnabledChanged(boolean z) {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(11, Boolean.valueOf(z), (Bundle) null);
                }
            }

            public void onEvent(String str, Bundle bundle) {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(1, str, bundle);
                }
            }

            public void onExtrasChanged(Bundle bundle) {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(7, bundle, (Bundle) null);
                }
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(3, mediaMetadataCompat, (Bundle) null);
                }
            }

            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(2, playbackStateCompat, (Bundle) null);
                }
            }

            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(5, list, (Bundle) null);
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(6, charSequence, (Bundle) null);
                }
            }

            public void onRepeatModeChanged(int i) {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(9, Integer.valueOf(i), (Bundle) null);
                }
            }

            public void onSessionDestroyed() {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(8, (Object) null, (Bundle) null);
                }
            }

            public void onSessionReady() {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(13, (Object) null, (Bundle) null);
                }
            }

            public void onShuffleModeChanged(int i) {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(12, Integer.valueOf(i), (Bundle) null);
                }
            }

            public void onShuffleModeChangedRemoved(boolean z) {
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
                Callback callback = (Callback) this.f135a.get();
                if (callback != null) {
                    callback.mo309a(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume) : null, (Bundle) null);
                }
            }
        }

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f129a = MediaControllerCompatApi21.m181b(new C0057b(this));
                return;
            }
            C0058c cVar = new C0058c(this);
            this.f131c = cVar;
            this.f129a = cVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo309a(int i, Object obj, Bundle bundle) {
            C0056a aVar = this.f130b;
            if (aVar != null) {
                Message obtainMessage = aVar.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo310b(Handler handler) {
            if (handler == null) {
                C0056a aVar = this.f130b;
                if (aVar != null) {
                    aVar.f132a = false;
                    aVar.removeCallbacksAndMessages((Object) null);
                    this.f130b = null;
                    return;
                }
                return;
            }
            C0056a aVar2 = new C0056a(handler.getLooper());
            this.f130b = aVar2;
            aVar2.f132a = true;
        }

        public void binderDied() {
            mo309a(8, (Object) null, (Bundle) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public IMediaControllerCallback getIControllerCallback() {
            return this.f131c;
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onCaptioningEnabledChanged(boolean z) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int i) {
        }
    }

    @RequiresApi(21)
    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21 */
    static class MediaControllerImplApi21 implements C0061b {

        /* renamed from: a */
        protected final Object f136a;

        /* renamed from: b */
        final Object f137b = new Object();
        @GuardedBy("mLock")

        /* renamed from: c */
        private final List<Callback> f138c = new ArrayList();

        /* renamed from: d */
        private HashMap<Callback, C0059a> f139d = new HashMap<>();

        /* renamed from: e */
        final MediaSessionCompat.Token f140e;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver */
        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a */
            private WeakReference<MediaControllerImplApi21> f141a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super((Handler) null);
                this.f141a = new WeakReference<>(mediaControllerImplApi21);
            }

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f141a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f137b) {
                        mediaControllerImplApi21.f140e.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER)));
                        mediaControllerImplApi21.f140e.setSessionToken2Bundle(bundle.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE));
                        mediaControllerImplApi21.mo358m();
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a */
        private static class C0059a extends Callback.C0058c {
            C0059a(Callback callback) {
                super(callback);
            }

            public void onExtrasChanged(Bundle bundle) {
                throw new AssertionError();
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
                throw new AssertionError();
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                throw new AssertionError();
            }

            public void onSessionDestroyed() {
                throw new AssertionError();
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f140e = token;
            Object d = MediaControllerCompatApi21.m183d(context, token.getToken());
            this.f136a = d;
            if (d == null) {
                throw new RemoteException();
            } else if (token.getExtraBinder() == null) {
                m139n();
            }
        }

        /* renamed from: n */
        private void m139n() {
            mo341g(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, (Bundle) null, new ExtraBinderRequestResultReceiver(this));
        }

        /* renamed from: a */
        public PlaybackInfo mo334a() {
            Object j = MediaControllerCompatApi21.m189j(this.f136a);
            if (j != null) {
                return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(j), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(j), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(j), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(j), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(j));
            }
            return null;
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                mo341g(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, bundle, (ResultReceiver) null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        /* renamed from: b */
        public void mo336b(int i, int i2) {
            MediaControllerCompatApi21.m180a(this.f136a, i, i2);
        }

        /* renamed from: c */
        public final void mo337c(Callback callback) {
            MediaControllerCompatApi21.m201v(this.f136a, callback.f129a);
            synchronized (this.f137b) {
                if (this.f140e.getExtraBinder() != null) {
                    try {
                        C0059a remove = this.f139d.remove(callback);
                        if (remove != null) {
                            callback.f131c = null;
                            this.f140e.getExtraBinder().unregisterCallbackListener(remove);
                        }
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e);
                    }
                } else {
                    this.f138c.remove(callback);
                }
            }
        }

        /* renamed from: d */
        public boolean mo338d(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.m182c(this.f136a, keyEvent);
        }

        /* renamed from: e */
        public void mo339e(int i, int i2) {
            MediaControllerCompatApi21.m200u(this.f136a, i, i2);
        }

        /* renamed from: f */
        public void mo340f(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                bundle.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, i);
                mo341g(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, bundle, (ResultReceiver) null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        /* renamed from: g */
        public void mo341g(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.m198s(this.f136a, str, bundle, resultReceiver);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.m184e(this.f136a);
        }

        public long getFlags() {
            return MediaControllerCompatApi21.m185f(this.f136a);
        }

        public MediaMetadataCompat getMetadata() {
            Object h = MediaControllerCompatApi21.m187h(this.f136a);
            if (h != null) {
                return MediaMetadataCompat.fromMediaMetadata(h);
            }
            return null;
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.m188i(this.f136a);
        }

        public PlaybackStateCompat getPlaybackState() {
            if (this.f140e.getExtraBinder() != null) {
                try {
                    return this.f140e.getExtraBinder().getPlaybackState();
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
                }
            }
            Object k = MediaControllerCompatApi21.m190k(this.f136a);
            if (k != null) {
                return PlaybackStateCompat.fromPlaybackState(k);
            }
            return null;
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> l = MediaControllerCompatApi21.m191l(this.f136a);
            if (l != null) {
                return MediaSessionCompat.QueueItem.fromQueueItemList(l);
            }
            return null;
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.m192m(this.f136a);
        }

        public int getRatingType() {
            if (Build.VERSION.SDK_INT < 22 && this.f140e.getExtraBinder() != null) {
                try {
                    return this.f140e.getExtraBinder().getRatingType();
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in getRatingType.", e);
                }
            }
            return MediaControllerCompatApi21.m193n(this.f136a);
        }

        public int getRepeatMode() {
            if (this.f140e.getExtraBinder() == null) {
                return -1;
            }
            try {
                return this.f140e.getExtraBinder().getRepeatMode();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
                return -1;
            }
        }

        public int getShuffleMode() {
            if (this.f140e.getExtraBinder() == null) {
                return -1;
            }
            try {
                return this.f140e.getExtraBinder().getShuffleMode();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e);
                return -1;
            }
        }

        /* renamed from: h */
        public boolean mo352h() {
            return this.f140e.getExtraBinder() != null;
        }

        /* renamed from: i */
        public PendingIntent mo353i() {
            return MediaControllerCompatApi21.m194o(this.f136a);
        }

        public boolean isCaptioningEnabled() {
            if (this.f140e.getExtraBinder() == null) {
                return false;
            }
            try {
                return this.f140e.getExtraBinder().isCaptioningEnabled();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e);
                return false;
            }
        }

        /* renamed from: j */
        public TransportControls mo355j() {
            Object q = MediaControllerCompatApi21.m196q(this.f136a);
            if (q != null) {
                return new C0065f(q);
            }
            return null;
        }

        /* renamed from: k */
        public Object mo356k() {
            return this.f136a;
        }

        /* renamed from: l */
        public final void mo357l(Callback callback, Handler handler) {
            MediaControllerCompatApi21.m197r(this.f136a, callback.f129a, handler);
            synchronized (this.f137b) {
                if (this.f140e.getExtraBinder() != null) {
                    C0059a aVar = new C0059a(callback);
                    this.f139d.put(callback, aVar);
                    callback.f131c = aVar;
                    try {
                        this.f140e.getExtraBinder().registerCallbackListener(aVar);
                        callback.mo309a(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    }
                } else {
                    callback.f131c = null;
                    this.f138c.add(callback);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("mLock")
        /* renamed from: m */
        public void mo358m() {
            if (this.f140e.getExtraBinder() != null) {
                for (Callback next : this.f138c) {
                    C0059a aVar = new C0059a(next);
                    this.f139d.put(next, aVar);
                    next.f131c = aVar;
                    try {
                        this.f140e.getExtraBinder().registerCallbackListener(aVar);
                        next.mo309a(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    }
                }
                this.f138c.clear();
            }
        }

        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                mo341g(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, bundle, (ResultReceiver) null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$PlaybackInfo */
    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;

        /* renamed from: a */
        private final int f142a;

        /* renamed from: b */
        private final int f143b;

        /* renamed from: c */
        private final int f144c;

        /* renamed from: d */
        private final int f145d;

        /* renamed from: e */
        private final int f146e;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.f142a = i;
            this.f143b = i2;
            this.f144c = i3;
            this.f145d = i4;
            this.f146e = i5;
        }

        public int getAudioStream() {
            return this.f143b;
        }

        public int getCurrentVolume() {
            return this.f146e;
        }

        public int getMaxVolume() {
            return this.f145d;
        }

        public int getPlaybackType() {
            return this.f142a;
        }

        public int getVolumeControl() {
            return this.f144c;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControls */
    public static abstract class TransportControls {
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        TransportControls() {
        }

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setCaptioningEnabled(boolean z);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRating(RatingCompat ratingCompat, Bundle bundle);

        public abstract void setRepeatMode(int i);

        public abstract void setShuffleMode(int i);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$a */
    private static class C0060a extends ComponentActivity.ExtraData {

        /* renamed from: a */
        private final MediaControllerCompat f147a;

        C0060a(MediaControllerCompat mediaControllerCompat) {
            this.f147a = mediaControllerCompat;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public MediaControllerCompat mo389a() {
            return this.f147a;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$b */
    interface C0061b {
        /* renamed from: a */
        PlaybackInfo mo334a();

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        /* renamed from: b */
        void mo336b(int i, int i2);

        /* renamed from: c */
        void mo337c(Callback callback);

        /* renamed from: d */
        boolean mo338d(KeyEvent keyEvent);

        /* renamed from: e */
        void mo339e(int i, int i2);

        /* renamed from: f */
        void mo340f(MediaDescriptionCompat mediaDescriptionCompat, int i);

        /* renamed from: g */
        void mo341g(String str, Bundle bundle, ResultReceiver resultReceiver);

        Bundle getExtras();

        long getFlags();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        int getShuffleMode();

        /* renamed from: h */
        boolean mo352h();

        /* renamed from: i */
        PendingIntent mo353i();

        boolean isCaptioningEnabled();

        /* renamed from: j */
        TransportControls mo355j();

        /* renamed from: k */
        Object mo356k();

        /* renamed from: l */
        void mo357l(Callback callback, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);
    }

    @RequiresApi(23)
    /* renamed from: android.support.v4.media.session.MediaControllerCompat$c */
    static class C0062c extends MediaControllerImplApi21 {
        public C0062c(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }

        /* renamed from: j */
        public TransportControls mo355j() {
            Object q = MediaControllerCompatApi21.m196q(this.f136a);
            if (q != null) {
                return new C0066g(q);
            }
            return null;
        }
    }

    @RequiresApi(24)
    /* renamed from: android.support.v4.media.session.MediaControllerCompat$d */
    static class C0063d extends C0062c {
        public C0063d(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }

        /* renamed from: j */
        public TransportControls mo355j() {
            Object q = MediaControllerCompatApi21.m196q(this.f136a);
            if (q != null) {
                return new C0067h(q);
            }
            return null;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$e */
    static class C0064e implements C0061b {

        /* renamed from: a */
        private IMediaSession f148a;

        /* renamed from: b */
        private TransportControls f149b;

        public C0064e(MediaSessionCompat.Token token) {
            this.f148a = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        /* renamed from: a */
        public PlaybackInfo mo334a() {
            try {
                ParcelableVolumeInfo volumeAttributes = this.f148a.getVolumeAttributes();
                return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo.", e);
                return null;
            }
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.f148a.getFlags() & 4) != 0) {
                    this.f148a.addQueueItem(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItem.", e);
            }
        }

        /* renamed from: b */
        public void mo336b(int i, int i2) {
            try {
                this.f148a.adjustVolume(i, i2, (String) null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in adjustVolume.", e);
            }
        }

        /* renamed from: c */
        public void mo337c(Callback callback) {
            if (callback != null) {
                try {
                    this.f148a.unregisterCallbackListener((IMediaControllerCallback) callback.f129a);
                    this.f148a.asBinder().unlinkToDeath(callback, 0);
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e);
                }
            } else {
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        /* renamed from: d */
        public boolean mo338d(KeyEvent keyEvent) {
            if (keyEvent != null) {
                try {
                    this.f148a.sendMediaButton(keyEvent);
                    return false;
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e);
                    return false;
                }
            } else {
                throw new IllegalArgumentException("event may not be null.");
            }
        }

        /* renamed from: e */
        public void mo339e(int i, int i2) {
            try {
                this.f148a.setVolumeTo(i, i2, (String) null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setVolumeTo.", e);
            }
        }

        /* renamed from: f */
        public void mo340f(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            try {
                if ((this.f148a.getFlags() & 4) != 0) {
                    this.f148a.addQueueItemAt(mediaDescriptionCompat, i);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItemAt.", e);
            }
        }

        /* renamed from: g */
        public void mo341g(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.f148a.sendCommand(str, bundle, new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in sendCommand.", e);
            }
        }

        public Bundle getExtras() {
            try {
                return this.f148a.getExtras();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getExtras.", e);
                return null;
            }
        }

        public long getFlags() {
            try {
                return this.f148a.getFlags();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getFlags.", e);
                return 0;
            }
        }

        public MediaMetadataCompat getMetadata() {
            try {
                return this.f148a.getMetadata();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata.", e);
                return null;
            }
        }

        public String getPackageName() {
            try {
                return this.f148a.getPackageName();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPackageName.", e);
                return null;
            }
        }

        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.f148a.getPlaybackState();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
                return null;
            }
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            try {
                return this.f148a.getQueue();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getQueue.", e);
                return null;
            }
        }

        public CharSequence getQueueTitle() {
            try {
                return this.f148a.getQueueTitle();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getQueueTitle.", e);
                return null;
            }
        }

        public int getRatingType() {
            try {
                return this.f148a.getRatingType();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getRatingType.", e);
                return 0;
            }
        }

        public int getRepeatMode() {
            try {
                return this.f148a.getRepeatMode();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
                return -1;
            }
        }

        public int getShuffleMode() {
            try {
                return this.f148a.getShuffleMode();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e);
                return -1;
            }
        }

        /* renamed from: h */
        public boolean mo352h() {
            return true;
        }

        /* renamed from: i */
        public PendingIntent mo353i() {
            try {
                return this.f148a.getLaunchPendingIntent();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", e);
                return null;
            }
        }

        public boolean isCaptioningEnabled() {
            try {
                return this.f148a.isCaptioningEnabled();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e);
                return false;
            }
        }

        /* renamed from: j */
        public TransportControls mo355j() {
            if (this.f149b == null) {
                this.f149b = new C0068i(this.f148a);
            }
            return this.f149b;
        }

        /* renamed from: k */
        public Object mo356k() {
            return null;
        }

        /* renamed from: l */
        public void mo357l(Callback callback, Handler handler) {
            if (callback != null) {
                try {
                    this.f148a.asBinder().linkToDeath(callback, 0);
                    this.f148a.registerCallbackListener((IMediaControllerCallback) callback.f129a);
                    callback.mo309a(13, (Object) null, (Bundle) null);
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    callback.mo309a(8, (Object) null, (Bundle) null);
                }
            } else {
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.f148a.getFlags() & 4) != 0) {
                    this.f148a.removeQueueItem(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in removeQueueItem.", e);
            }
        }
    }

    @RequiresApi(23)
    /* renamed from: android.support.v4.media.session.MediaControllerCompat$g */
    static class C0066g extends C0065f {
        public C0066g(Object obj) {
            super(obj);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi23$TransportControls.playFromUri(this.f150a, uri, bundle);
        }
    }

    @RequiresApi(24)
    /* renamed from: android.support.v4.media.session.MediaControllerCompat$h */
    static class C0067h extends C0066g {
        public C0067h(Object obj) {
            super(obj);
        }

        public void prepare() {
            MediaControllerCompatApi24$TransportControls.prepare(this.f150a);
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi24$TransportControls.prepareFromMediaId(this.f150a, str, bundle);
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi24$TransportControls.prepareFromSearch(this.f150a, str, bundle);
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi24$TransportControls.prepareFromUri(this.f150a, uri, bundle);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$i */
    static class C0068i extends TransportControls {

        /* renamed from: a */
        private IMediaSession f151a;

        public C0068i(IMediaSession iMediaSession) {
            this.f151a = iMediaSession;
        }

        public void fastForward() {
            try {
                this.f151a.fastForward();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in fastForward.", e);
            }
        }

        public void pause() {
            try {
                this.f151a.pause();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in pause.", e);
            }
        }

        public void play() {
            try {
                this.f151a.play();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in play.", e);
            }
        }

        public void playFromMediaId(String str, Bundle bundle) {
            try {
                this.f151a.playFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromMediaId.", e);
            }
        }

        public void playFromSearch(String str, Bundle bundle) {
            try {
                this.f151a.playFromSearch(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromSearch.", e);
            }
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            try {
                this.f151a.playFromUri(uri, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromUri.", e);
            }
        }

        public void prepare() {
            try {
                this.f151a.prepare();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepare.", e);
            }
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            try {
                this.f151a.prepareFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromMediaId.", e);
            }
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            try {
                this.f151a.prepareFromSearch(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromSearch.", e);
            }
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            try {
                this.f151a.prepareFromUri(uri, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromUri.", e);
            }
        }

        public void rewind() {
            try {
                this.f151a.rewind();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in rewind.", e);
            }
        }

        public void seekTo(long j) {
            try {
                this.f151a.seekTo(j);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in seekTo.", e);
            }
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        public void setCaptioningEnabled(boolean z) {
            try {
                this.f151a.setCaptioningEnabled(z);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setCaptioningEnabled.", e);
            }
        }

        public void setRating(RatingCompat ratingCompat) {
            try {
                this.f151a.rate(ratingCompat);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", e);
            }
        }

        public void setRepeatMode(int i) {
            try {
                this.f151a.setRepeatMode(i);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setRepeatMode.", e);
            }
        }

        public void setShuffleMode(int i) {
            try {
                this.f151a.setShuffleMode(i);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setShuffleMode.", e);
            }
        }

        public void skipToNext() {
            try {
                this.f151a.next();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext.", e);
            }
        }

        public void skipToPrevious() {
            try {
                this.f151a.previous();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToPrevious.", e);
            }
        }

        public void skipToQueueItem(long j) {
            try {
                this.f151a.skipToQueueItem(j);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToQueueItem.", e);
            }
        }

        public void stop() {
            try {
                this.f151a.stop();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in stop.", e);
            }
        }

        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompat.m136a(str, bundle);
            try {
                this.f151a.sendCustomAction(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in sendCustomAction.", e);
            }
        }

        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            try {
                this.f151a.rateWithExtras(ratingCompat, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", e);
            }
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat mediaSessionCompat) {
        C0061b mediaControllerImplApi21;
        if (mediaSessionCompat != null) {
            MediaSessionCompat.Token sessionToken = mediaSessionCompat.getSessionToken();
            this.f127b = sessionToken;
            C0064e eVar = null;
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    mediaControllerImplApi21 = new C0063d(context, sessionToken);
                } else if (i >= 23) {
                    mediaControllerImplApi21 = new C0062c(context, sessionToken);
                } else if (i >= 21) {
                    mediaControllerImplApi21 = new MediaControllerImplApi21(context, sessionToken);
                } else {
                    eVar = new C0064e(sessionToken);
                    this.f126a = eVar;
                    return;
                }
                eVar = mediaControllerImplApi21;
            } catch (RemoteException e) {
                Log.w("MediaControllerCompat", "Failed to create MediaControllerImpl.", e);
            }
            this.f126a = eVar;
            return;
        }
        throw new IllegalArgumentException("session must not be null");
    }

    /* renamed from: a */
    static void m136a(String str, Bundle bundle) {
        if (str != null) {
            str.hashCode();
            if (!str.equals(MediaSessionCompat.ACTION_FOLLOW) && !str.equals(MediaSessionCompat.ACTION_UNFOLLOW)) {
                return;
            }
            if (bundle == null || !bundle.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE)) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + ".");
            }
        }
    }

    public static MediaControllerCompat getMediaController(@NonNull Activity activity) {
        Object g;
        if (activity instanceof ComponentActivity) {
            C0060a aVar = (C0060a) ((ComponentActivity) activity).getExtraData(C0060a.class);
            if (aVar != null) {
                return aVar.mo389a();
            }
            return null;
        } else if (Build.VERSION.SDK_INT < 21 || (g = MediaControllerCompatApi21.m186g(activity)) == null) {
            return null;
        } else {
            try {
                return new MediaControllerCompat((Context) activity, MediaSessionCompat.Token.fromToken(MediaControllerCompatApi21.m195p(g)));
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getMediaController.", e);
                return null;
            }
        }
    }

    public static void setMediaController(@NonNull Activity activity, MediaControllerCompat mediaControllerCompat) {
        if (activity instanceof ComponentActivity) {
            ((ComponentActivity) activity).putExtraData(new C0060a(mediaControllerCompat));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Object obj = null;
            if (mediaControllerCompat != null) {
                obj = MediaControllerCompatApi21.m183d(activity, mediaControllerCompat.getSessionToken().getToken());
            }
            MediaControllerCompatApi21.m199t(activity, obj);
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f126a.addQueueItem(mediaDescriptionCompat);
    }

    public void adjustVolume(int i, int i2) {
        this.f126a.mo336b(i, i2);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f126a.mo338d(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle getExtras() {
        return this.f126a.getExtras();
    }

    public long getFlags() {
        return this.f126a.getFlags();
    }

    public MediaMetadataCompat getMetadata() {
        return this.f126a.getMetadata();
    }

    public String getPackageName() {
        return this.f126a.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.f126a.mo334a();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.f126a.getPlaybackState();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.f126a.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.f126a.getQueueTitle();
    }

    public int getRatingType() {
        return this.f126a.getRatingType();
    }

    public int getRepeatMode() {
        return this.f126a.getRepeatMode();
    }

    public PendingIntent getSessionActivity() {
        return this.f126a.mo353i();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.f127b;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle getSessionToken2Bundle() {
        return this.f127b.getSessionToken2Bundle();
    }

    public int getShuffleMode() {
        return this.f126a.getShuffleMode();
    }

    public TransportControls getTransportControls() {
        return this.f126a.mo355j();
    }

    public boolean isCaptioningEnabled() {
        return this.f126a.isCaptioningEnabled();
    }

    public boolean isSessionReady() {
        return this.f126a.mo352h();
    }

    public void registerCallback(@NonNull Callback callback) {
        registerCallback(callback, (Handler) null);
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f126a.removeQueueItem(mediaDescriptionCompat);
    }

    @Deprecated
    public void removeQueueItemAt(int i) {
        MediaSessionCompat.QueueItem queueItem;
        List<MediaSessionCompat.QueueItem> queue = getQueue();
        if (queue != null && i >= 0 && i < queue.size() && (queueItem = queue.get(i)) != null) {
            removeQueueItem(queueItem.getDescription());
        }
    }

    public void sendCommand(@NonNull String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (!TextUtils.isEmpty(str)) {
            this.f126a.mo341g(str, bundle, resultReceiver);
            return;
        }
        throw new IllegalArgumentException("command must neither be null nor empty");
    }

    public void setVolumeTo(int i, int i2) {
        this.f126a.mo339e(i, i2);
    }

    public void unregisterCallback(@NonNull Callback callback) {
        if (callback != null) {
            try {
                this.f128c.remove(callback);
                this.f126a.mo337c(callback);
            } finally {
                callback.mo310b((Handler) null);
            }
        } else {
            throw new IllegalArgumentException("callback must not be null");
        }
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        this.f126a.mo340f(mediaDescriptionCompat, i);
    }

    public void registerCallback(@NonNull Callback callback, Handler handler) {
        if (callback != null) {
            if (handler == null) {
                handler = new Handler();
            }
            callback.mo310b(handler);
            this.f126a.mo357l(callback, handler);
            this.f128c.add(callback);
            return;
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$f */
    static class C0065f extends TransportControls {

        /* renamed from: a */
        protected final Object f150a;

        public C0065f(Object obj) {
            this.f150a = obj;
        }

        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.f150a);
        }

        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.f150a);
        }

        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.f150a);
        }

        public void playFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.f150a, str, bundle);
        }

        public void playFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.f150a, str, bundle);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            if (uri == null || Uri.EMPTY.equals(uri)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PLAY_FROM_URI, bundle2);
        }

        public void prepare() {
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE, (Bundle) null);
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID, str);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID, bundle2);
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.ACTION_ARGUMENT_QUERY, str);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH, bundle2);
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_URI, bundle2);
        }

        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.f150a);
        }

        public void seekTo(long j) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.f150a, j);
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompat.m136a(customAction.getAction(), bundle);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.f150a, customAction.getAction(), bundle);
        }

        public void setCaptioningEnabled(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED, z);
            sendCustomAction(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED, bundle);
        }

        public void setRating(RatingCompat ratingCompat) {
            MediaControllerCompatApi21.TransportControls.setRating(this.f150a, ratingCompat != null ? ratingCompat.getRating() : null);
        }

        public void setRepeatMode(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, i);
            sendCustomAction(MediaSessionCompat.ACTION_SET_REPEAT_MODE, bundle);
        }

        public void setShuffleMode(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, i);
            sendCustomAction(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, bundle);
        }

        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.f150a);
        }

        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.f150a);
        }

        public void skipToQueueItem(long j) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.f150a, j);
        }

        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.f150a);
        }

        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING, ratingCompat);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_SET_RATING, bundle2);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompat.m136a(str, bundle);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.f150a, str, bundle);
        }
    }

    public Object getMediaController() {
        return this.f126a.mo356k();
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat.Token token) {
        if (token != null) {
            this.f127b = token;
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                this.f126a = new C0063d(context, token);
            } else if (i >= 23) {
                this.f126a = new C0062c(context, token);
            } else if (i >= 21) {
                this.f126a = new MediaControllerImplApi21(context, token);
            } else {
                this.f126a = new C0064e(token);
            }
        } else {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
    }
}
