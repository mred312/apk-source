package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.p000v4.media.MediaDescriptionCompat;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.RatingCompat;
import android.support.p000v4.media.session.C0098a;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.MediaSessionCompatApi23;
import android.support.p000v4.media.session.MediaSessionCompatApi24;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaSessionCompat */
public class MediaSessionCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;

    /* renamed from: d */
    static int f153d;

    /* renamed from: a */
    private final C0080d f154a;

    /* renamed from: b */
    private final MediaControllerCompat f155b;

    /* renamed from: c */
    private final ArrayList<OnActiveChangeListener> f156c;

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback */
    public static abstract class Callback {

        /* renamed from: a */
        final Object f157a;

        /* renamed from: b */
        WeakReference<C0080d> f158b;

        /* renamed from: c */
        private C0070a f159c = null;

        /* renamed from: d */
        private boolean f160d;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$a */
        private class C0070a extends Handler {
            C0070a(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    Callback.this.mo426a((MediaSessionManager.RemoteUserInfo) message.obj);
                }
            }
        }

        @RequiresApi(21)
        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$b */
        private class C0071b implements C0098a.C0099a {
            C0071b() {
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.support.v4.media.session.MediaSessionCompat$QueueItem} */
            /* JADX WARNING: type inference failed for: r1v0 */
            /* JADX WARNING: type inference failed for: r1v4, types: [android.os.IBinder] */
            /* JADX WARNING: type inference failed for: r1v6 */
            /* JADX WARNING: type inference failed for: r1v7 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCommand(java.lang.String r5, android.os.Bundle r6, android.os.ResultReceiver r7) {
                /*
                    r4 = this;
                    java.lang.String r0 = "android.support.v4.media.session.command.GET_EXTRA_BINDER"
                    boolean r0 = r5.equals(r0)     // Catch:{ BadParcelableException -> 0x00c4 }
                    r1 = 0
                    if (r0 == 0) goto L_0x003d
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.p000v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c4 }
                    java.lang.ref.WeakReference<android.support.v4.media.session.MediaSessionCompat$d> r5 = r5.f158b     // Catch:{ BadParcelableException -> 0x00c4 }
                    java.lang.Object r5 = r5.get()     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.support.v4.media.session.MediaSessionCompat$g r5 = (android.support.p000v4.media.session.MediaSessionCompat.C0085g) r5     // Catch:{ BadParcelableException -> 0x00c4 }
                    if (r5 == 0) goto L_0x00cb
                    android.os.Bundle r6 = new android.os.Bundle     // Catch:{ BadParcelableException -> 0x00c4 }
                    r6.<init>()     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.support.v4.media.session.MediaSessionCompat$Token r5 = r5.mo509a()     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.support.v4.media.session.IMediaSession r0 = r5.getExtraBinder()     // Catch:{ BadParcelableException -> 0x00c4 }
                    java.lang.String r2 = "android.support.v4.media.session.EXTRA_BINDER"
                    if (r0 != 0) goto L_0x0027
                    goto L_0x002b
                L_0x0027:
                    android.os.IBinder r1 = r0.asBinder()     // Catch:{ BadParcelableException -> 0x00c4 }
                L_0x002b:
                    androidx.core.app.BundleCompat.putBinder(r6, r2, r1)     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.os.Bundle r5 = r5.getSessionToken2Bundle()     // Catch:{ BadParcelableException -> 0x00c4 }
                    java.lang.String r0 = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"
                    r6.putBundle(r0, r5)     // Catch:{ BadParcelableException -> 0x00c4 }
                    r5 = 0
                    r7.send(r5, r6)     // Catch:{ BadParcelableException -> 0x00c4 }
                    goto L_0x00cb
                L_0x003d:
                    java.lang.String r0 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM"
                    boolean r0 = r5.equals(r0)     // Catch:{ BadParcelableException -> 0x00c4 }
                    java.lang.String r2 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"
                    if (r0 == 0) goto L_0x0054
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.p000v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.os.Parcelable r6 = r6.getParcelable(r2)     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.support.v4.media.MediaDescriptionCompat r6 = (android.support.p000v4.media.MediaDescriptionCompat) r6     // Catch:{ BadParcelableException -> 0x00c4 }
                    r5.onAddQueueItem(r6)     // Catch:{ BadParcelableException -> 0x00c4 }
                    goto L_0x00cb
                L_0x0054:
                    java.lang.String r0 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT"
                    boolean r0 = r5.equals(r0)     // Catch:{ BadParcelableException -> 0x00c4 }
                    java.lang.String r3 = "android.support.v4.media.session.command.ARGUMENT_INDEX"
                    if (r0 == 0) goto L_0x006e
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.p000v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.os.Parcelable r7 = r6.getParcelable(r2)     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.support.v4.media.MediaDescriptionCompat r7 = (android.support.p000v4.media.MediaDescriptionCompat) r7     // Catch:{ BadParcelableException -> 0x00c4 }
                    int r6 = r6.getInt(r3)     // Catch:{ BadParcelableException -> 0x00c4 }
                    r5.onAddQueueItem(r7, r6)     // Catch:{ BadParcelableException -> 0x00c4 }
                    goto L_0x00cb
                L_0x006e:
                    java.lang.String r0 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM"
                    boolean r0 = r5.equals(r0)     // Catch:{ BadParcelableException -> 0x00c4 }
                    if (r0 == 0) goto L_0x0082
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.p000v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.os.Parcelable r6 = r6.getParcelable(r2)     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.support.v4.media.MediaDescriptionCompat r6 = (android.support.p000v4.media.MediaDescriptionCompat) r6     // Catch:{ BadParcelableException -> 0x00c4 }
                    r5.onRemoveQueueItem(r6)     // Catch:{ BadParcelableException -> 0x00c4 }
                    goto L_0x00cb
                L_0x0082:
                    java.lang.String r0 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT"
                    boolean r0 = r5.equals(r0)     // Catch:{ BadParcelableException -> 0x00c4 }
                    if (r0 == 0) goto L_0x00be
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.p000v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c4 }
                    java.lang.ref.WeakReference<android.support.v4.media.session.MediaSessionCompat$d> r5 = r5.f158b     // Catch:{ BadParcelableException -> 0x00c4 }
                    java.lang.Object r5 = r5.get()     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.support.v4.media.session.MediaSessionCompat$g r5 = (android.support.p000v4.media.session.MediaSessionCompat.C0085g) r5     // Catch:{ BadParcelableException -> 0x00c4 }
                    if (r5 == 0) goto L_0x00cb
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r7 = r5.f180f     // Catch:{ BadParcelableException -> 0x00c4 }
                    if (r7 == 0) goto L_0x00cb
                    r7 = -1
                    int r6 = r6.getInt(r3, r7)     // Catch:{ BadParcelableException -> 0x00c4 }
                    if (r6 < 0) goto L_0x00b2
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r7 = r5.f180f     // Catch:{ BadParcelableException -> 0x00c4 }
                    int r7 = r7.size()     // Catch:{ BadParcelableException -> 0x00c4 }
                    if (r6 >= r7) goto L_0x00b2
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r5 = r5.f180f     // Catch:{ BadParcelableException -> 0x00c4 }
                    java.lang.Object r5 = r5.get(r6)     // Catch:{ BadParcelableException -> 0x00c4 }
                    r1 = r5
                    android.support.v4.media.session.MediaSessionCompat$QueueItem r1 = (android.support.p000v4.media.session.MediaSessionCompat.QueueItem) r1     // Catch:{ BadParcelableException -> 0x00c4 }
                L_0x00b2:
                    if (r1 == 0) goto L_0x00cb
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.p000v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c4 }
                    android.support.v4.media.MediaDescriptionCompat r6 = r1.getDescription()     // Catch:{ BadParcelableException -> 0x00c4 }
                    r5.onRemoveQueueItem(r6)     // Catch:{ BadParcelableException -> 0x00c4 }
                    goto L_0x00cb
                L_0x00be:
                    android.support.v4.media.session.MediaSessionCompat$Callback r0 = android.support.p000v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c4 }
                    r0.onCommand(r5, r6, r7)     // Catch:{ BadParcelableException -> 0x00c4 }
                    goto L_0x00cb
                L_0x00c4:
                    java.lang.String r5 = "MediaSessionCompat"
                    java.lang.String r6 = "Could not unparcel the extra data."
                    android.util.Log.e(r5, r6)
                L_0x00cb:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.media.session.MediaSessionCompat.Callback.C0071b.onCommand(java.lang.String, android.os.Bundle, android.os.ResultReceiver):void");
            }

            public void onCustomAction(String str, Bundle bundle) {
                Bundle bundle2 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle2);
                if (str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                    Callback.this.onPlayFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                    Callback.this.onPrepare();
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                    Callback.this.onPrepareFromMediaId(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                    Callback.this.onPrepareFromSearch(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                    Callback.this.onPrepareFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                    Callback.this.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                    Callback.this.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                    Callback.this.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                    Callback.this.onSetRating((RatingCompat) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle2);
                } else {
                    Callback.this.onCustomAction(str, bundle);
                }
            }

            public void onFastForward() {
                Callback.this.onFastForward();
            }

            public boolean onMediaButtonEvent(Intent intent) {
                return Callback.this.onMediaButtonEvent(intent);
            }

            public void onPause() {
                Callback.this.onPause();
            }

            public void onPlay() {
                Callback.this.onPlay();
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                Callback.this.onPlayFromMediaId(str, bundle);
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                Callback.this.onPlayFromSearch(str, bundle);
            }

            public void onRewind() {
                Callback.this.onRewind();
            }

            public void onSeekTo(long j) {
                Callback.this.onSeekTo(j);
            }

            public void onSetRating(Object obj) {
                Callback.this.onSetRating(RatingCompat.fromRating(obj));
            }

            public void onSetRating(Object obj, Bundle bundle) {
            }

            public void onSkipToNext() {
                Callback.this.onSkipToNext();
            }

            public void onSkipToPrevious() {
                Callback.this.onSkipToPrevious();
            }

            public void onSkipToQueueItem(long j) {
                Callback.this.onSkipToQueueItem(j);
            }

            public void onStop() {
                Callback.this.onStop();
            }
        }

        @RequiresApi(23)
        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$c */
        private class C0072c extends C0071b implements MediaSessionCompatApi23.Callback {
            C0072c() {
                super();
            }

            public void onPlayFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPlayFromUri(uri, bundle);
            }
        }

        @RequiresApi(24)
        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$d */
        private class C0073d extends C0072c implements MediaSessionCompatApi24.Callback {
            C0073d() {
                super();
            }

            public void onPrepare() {
                Callback.this.onPrepare();
            }

            public void onPrepareFromMediaId(String str, Bundle bundle) {
                Callback.this.onPrepareFromMediaId(str, bundle);
            }

            public void onPrepareFromSearch(String str, Bundle bundle) {
                Callback.this.onPrepareFromSearch(str, bundle);
            }

            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPrepareFromUri(uri, bundle);
            }
        }

        public Callback() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                this.f157a = MediaSessionCompatApi24.m307a(new C0073d());
            } else if (i >= 23) {
                this.f157a = MediaSessionCompatApi23.m306a(new C0072c());
            } else if (i >= 21) {
                this.f157a = C0098a.m315a(new C0071b());
            } else {
                this.f157a = null;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo426a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            long j;
            if (this.f160d) {
                boolean z = false;
                this.f160d = false;
                this.f159c.removeMessages(1);
                C0080d dVar = (C0080d) this.f158b.get();
                if (dVar != null) {
                    PlaybackStateCompat playbackState = dVar.getPlaybackState();
                    if (playbackState == null) {
                        j = 0;
                    } else {
                        j = playbackState.getActions();
                    }
                    boolean z2 = playbackState != null && playbackState.getState() == 3;
                    boolean z3 = (516 & j) != 0;
                    if ((j & 514) != 0) {
                        z = true;
                    }
                    dVar.mo525o(remoteUserInfo);
                    if (z2 && z) {
                        onPause();
                    } else if (!z2 && z3) {
                        onPlay();
                    }
                    dVar.mo525o((MediaSessionManager.RemoteUserInfo) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo427b(C0080d dVar, Handler handler) {
            this.f158b = new WeakReference<>(dVar);
            C0070a aVar = this.f159c;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages((Object) null);
            }
            this.f159c = new C0070a(handler.getLooper());
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            C0080d dVar;
            KeyEvent keyEvent;
            long j;
            if (Build.VERSION.SDK_INT >= 27 || (dVar = (C0080d) this.f158b.get()) == null || this.f159c == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            MediaSessionManager.RemoteUserInfo s = dVar.mo530s();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 79 || keyCode == 85) {
                if (keyEvent.getRepeatCount() > 0) {
                    mo426a(s);
                } else if (this.f160d) {
                    this.f159c.removeMessages(1);
                    this.f160d = false;
                    PlaybackStateCompat playbackState = dVar.getPlaybackState();
                    if (playbackState == null) {
                        j = 0;
                    } else {
                        j = playbackState.getActions();
                    }
                    if ((j & 32) != 0) {
                        onSkipToNext();
                    }
                } else {
                    this.f160d = true;
                    C0070a aVar = this.f159c;
                    aVar.sendMessageDelayed(aVar.obtainMessage(1, s), (long) ViewConfiguration.getDoubleTapTimeout());
                }
                return true;
            }
            mo426a(s);
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetCaptioningEnabled(boolean z) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void onSetRepeatMode(int i) {
        }

        public void onSetShuffleMode(int i) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onStop() {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$OnActiveChangeListener */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new C0074a();
        public static final int UNKNOWN_ID = -1;

        /* renamed from: a */
        private final MediaDescriptionCompat f165a;

        /* renamed from: b */
        private final long f166b;

        /* renamed from: c */
        private Object f167c;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$a */
        static class C0074a implements Parcelable.Creator<QueueItem> {
            C0074a() {
            }

            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: b */
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this((Object) null, mediaDescriptionCompat, j);
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(C0098a.C0101c.m337b(obj)), C0098a.C0101c.m338c(obj));
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object fromQueueItem : list) {
                arrayList.add(fromQueueItem(fromQueueItem));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.f165a;
        }

        public long getQueueId() {
            return this.f166b;
        }

        public Object getQueueItem() {
            Object obj = this.f167c;
            if (obj != null || Build.VERSION.SDK_INT < 21) {
                return obj;
            }
            Object a = C0098a.C0101c.m336a(this.f165a.getMediaDescription(), this.f166b);
            this.f167c = a;
            return a;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f165a + ", Id=" + this.f166b + " }";
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f165a.writeToParcel(parcel, i);
            parcel.writeLong(this.f166b);
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j != -1) {
                this.f165a = mediaDescriptionCompat;
                this.f166b = j;
                this.f167c = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        QueueItem(Parcel parcel) {
            this.f165a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f166b = parcel.readLong();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$SessionFlags */
    public @interface SessionFlags {
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new C0076a();

        /* renamed from: a */
        private final Object f169a;

        /* renamed from: b */
        private IMediaSession f170b;

        /* renamed from: c */
        private Bundle f171c;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token$a */
        static class C0076a implements Parcelable.Creator<Token> {
            C0076a() {
            }

            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                Object obj;
                if (Build.VERSION.SDK_INT >= 21) {
                    obj = parcel.readParcelable((ClassLoader) null);
                } else {
                    obj = parcel.readStrongBinder();
                }
                return new Token(obj);
            }

            /* renamed from: b */
            public Token[] newArray(int i) {
                return new Token[i];
            }
        }

        Token(Object obj) {
            this(obj, (IMediaSession) null, (Bundle) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Token fromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER));
            Bundle bundle2 = bundle.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE);
            Token token = (Token) bundle.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (token == null) {
                return null;
            }
            return new Token(token.f169a, asInterface, bundle2);
        }

        public static Token fromToken(Object obj) {
            return fromToken(obj, (IMediaSession) null);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f169a;
            if (obj2 != null) {
                Object obj3 = token.f169a;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            } else if (token.f169a == null) {
                return true;
            } else {
                return false;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public IMediaSession getExtraBinder() {
            return this.f170b;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Bundle getSessionToken2Bundle() {
            return this.f171c;
        }

        public Object getToken() {
            return this.f169a;
        }

        public int hashCode() {
            Object obj = this.f169a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setExtraBinder(IMediaSession iMediaSession) {
            this.f170b = iMediaSession;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setSessionToken2Bundle(Bundle bundle) {
            this.f171c = bundle;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            IMediaSession iMediaSession = this.f170b;
            if (iMediaSession != null) {
                BundleCompat.putBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER, iMediaSession.asBinder());
            }
            Bundle bundle2 = this.f171c;
            if (bundle2 != null) {
                bundle.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, bundle2);
            }
            return bundle;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f169a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f169a);
            }
        }

        Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, (Bundle) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            C0098a.m335u(obj);
            return new Token(obj, iMediaSession);
        }

        Token(Object obj, IMediaSession iMediaSession, Bundle bundle) {
            this.f169a = obj;
            this.f170b = iMediaSession;
            this.f171c = bundle;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$a */
    class C0077a extends Callback {
        C0077a(MediaSessionCompat mediaSessionCompat) {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$b */
    class C0078b extends Callback {
        C0078b(MediaSessionCompat mediaSessionCompat) {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$c */
    class C0079c extends Callback {
        C0079c(MediaSessionCompat mediaSessionCompat) {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$d */
    interface C0080d {
        /* renamed from: a */
        Token mo509a();

        /* renamed from: b */
        void mo510b(String str, Bundle bundle);

        /* renamed from: c */
        String mo511c();

        /* renamed from: d */
        void mo512d(PendingIntent pendingIntent);

        /* renamed from: e */
        void mo513e(Callback callback, Handler handler);

        /* renamed from: f */
        void mo514f(int i);

        /* renamed from: g */
        void mo515g(CharSequence charSequence);

        PlaybackStateCompat getPlaybackState();

        /* renamed from: h */
        void mo517h(MediaMetadataCompat mediaMetadataCompat);

        /* renamed from: i */
        void mo518i(PendingIntent pendingIntent);

        boolean isActive();

        /* renamed from: j */
        void mo520j(int i);

        /* renamed from: k */
        void mo521k(int i);

        /* renamed from: l */
        void mo522l(List<QueueItem> list);

        /* renamed from: m */
        Object mo523m();

        /* renamed from: n */
        void mo524n(boolean z);

        /* renamed from: o */
        void mo525o(MediaSessionManager.RemoteUserInfo remoteUserInfo);

        /* renamed from: p */
        void mo526p(PlaybackStateCompat playbackStateCompat);

        /* renamed from: q */
        Object mo527q();

        /* renamed from: r */
        void mo528r(VolumeProviderCompat volumeProviderCompat);

        void release();

        /* renamed from: s */
        MediaSessionManager.RemoteUserInfo mo530s();

        void setCaptioningEnabled(boolean z);

        void setExtras(Bundle bundle);

        void setRepeatMode(int i);

        void setShuffleMode(int i);
    }

    @RequiresApi(18)
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$e */
    static class C0081e extends C0088i {

        /* renamed from: G */
        private static boolean f172G = true;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$e$a */
        class C0082a implements RemoteControlClient.OnPlaybackPositionUpdateListener {
            C0082a() {
            }

            public void onPlaybackPositionUpdate(long j) {
                C0081e.this.mo547x(18, -1, -1, Long.valueOf(j), (Bundle) null);
            }
        }

        C0081e(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: K */
        public void mo535K(PlaybackStateCompat playbackStateCompat) {
            long position = playbackStateCompat.getPosition();
            float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.getState() == 3) {
                long j = 0;
                if (position > 0) {
                    if (lastPositionUpdateTime > 0) {
                        j = elapsedRealtime - lastPositionUpdateTime;
                        if (playbackSpeed > 0.0f && playbackSpeed != 1.0f) {
                            j = (long) (((float) j) * playbackSpeed);
                        }
                    }
                    position += j;
                }
            }
            this.f200h.setPlaybackState(mo546v(playbackStateCompat.getState()), position, playbackSpeed);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: M */
        public void mo536M(PendingIntent pendingIntent, ComponentName componentName) {
            if (f172G) {
                this.f199g.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.mo536M(pendingIntent, componentName);
            }
        }

        /* renamed from: e */
        public void mo513e(Callback callback, Handler handler) {
            super.mo513e(callback, handler);
            if (callback == null) {
                this.f200h.setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener) null);
                return;
            }
            this.f200h.setPlaybackPositionUpdateListener(new C0082a());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w */
        public int mo537w(long j) {
            int w = super.mo537w(j);
            return (j & 256) != 0 ? w | 256 : w;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: y */
        public void mo538y(PendingIntent pendingIntent, ComponentName componentName) {
            if (f172G) {
                try {
                    this.f199g.registerMediaButtonEventReceiver(pendingIntent);
                } catch (NullPointerException unused) {
                    Log.w("MediaSessionCompat", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    f172G = false;
                }
            }
            if (!f172G) {
                super.mo538y(pendingIntent, componentName);
            }
        }
    }

    @RequiresApi(19)
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$f */
    static class C0083f extends C0081e {

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$f$a */
        class C0084a implements RemoteControlClient.OnMetadataUpdateListener {
            C0084a() {
            }

            public void onMetadataUpdate(int i, Object obj) {
                if (i == 268435457 && (obj instanceof Rating)) {
                    C0083f.this.mo547x(19, -1, -1, RatingCompat.fromRating(obj), (Bundle) null);
                }
            }
        }

        C0083f(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        /* renamed from: e */
        public void mo513e(Callback callback, Handler handler) {
            super.mo513e(callback, handler);
            if (callback == null) {
                this.f200h.setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener) null);
                return;
            }
            this.f200h.setMetadataUpdateListener(new C0084a());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: u */
        public RemoteControlClient.MetadataEditor mo540u(Bundle bundle) {
            RemoteControlClient.MetadataEditor u = super.mo540u(bundle);
            PlaybackStateCompat playbackStateCompat = this.f212t;
            if (((playbackStateCompat == null ? 0 : playbackStateCompat.getActions()) & 128) != 0) {
                u.addEditableKey(268435457);
            }
            if (bundle == null) {
                return u;
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
                u.putLong(8, bundle.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_RATING)) {
                u.putObject(101, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                u.putObject(268435457, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
            }
            return u;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w */
        public int mo537w(long j) {
            int w = super.mo537w(j);
            return (j & 128) != 0 ? w | 512 : w;
        }
    }

    @RequiresApi(28)
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$h */
    static class C0087h extends C0085g {
        C0087h(Context context, String str, Bundle bundle) {
            super(context, str, bundle);
        }

        /* renamed from: o */
        public void mo525o(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }

        @NonNull
        /* renamed from: s */
        public final MediaSessionManager.RemoteUserInfo mo530s() {
            return new MediaSessionManager.RemoteUserInfo(((MediaSession) this.f175a).getCurrentControllerInfo());
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$i */
    static class C0088i implements C0080d {

        /* renamed from: A */
        int f187A;

        /* renamed from: B */
        Bundle f188B;

        /* renamed from: C */
        int f189C;

        /* renamed from: D */
        int f190D;

        /* renamed from: E */
        VolumeProviderCompat f191E;

        /* renamed from: F */
        private VolumeProviderCompat.Callback f192F = new C0089a();

        /* renamed from: a */
        private final ComponentName f193a;

        /* renamed from: b */
        private final PendingIntent f194b;

        /* renamed from: c */
        private final C0091c f195c;

        /* renamed from: d */
        private final Token f196d;

        /* renamed from: e */
        final String f197e;

        /* renamed from: f */
        final String f198f;

        /* renamed from: g */
        final AudioManager f199g;

        /* renamed from: h */
        final RemoteControlClient f200h;

        /* renamed from: i */
        final Object f201i = new Object();

        /* renamed from: j */
        final RemoteCallbackList<IMediaControllerCallback> f202j = new RemoteCallbackList<>();

        /* renamed from: k */
        private C0092d f203k;

        /* renamed from: l */
        boolean f204l = false;

        /* renamed from: m */
        boolean f205m = false;

        /* renamed from: n */
        private boolean f206n = false;

        /* renamed from: o */
        private boolean f207o = false;

        /* renamed from: p */
        volatile Callback f208p;

        /* renamed from: q */
        private MediaSessionManager.RemoteUserInfo f209q;

        /* renamed from: r */
        int f210r;

        /* renamed from: s */
        MediaMetadataCompat f211s;

        /* renamed from: t */
        PlaybackStateCompat f212t;

        /* renamed from: u */
        PendingIntent f213u;

        /* renamed from: v */
        List<QueueItem> f214v;

        /* renamed from: w */
        CharSequence f215w;

        /* renamed from: x */
        int f216x;

        /* renamed from: y */
        boolean f217y;

        /* renamed from: z */
        int f218z;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$i$a */
        class C0089a extends VolumeProviderCompat.Callback {
            C0089a() {
            }

            public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                if (C0088i.this.f191E == volumeProviderCompat) {
                    C0088i iVar = C0088i.this;
                    C0088i.this.mo542J(new ParcelableVolumeInfo(iVar.f189C, iVar.f190D, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$i$b */
        private static final class C0090b {

            /* renamed from: a */
            public final String f220a;

            /* renamed from: b */
            public final Bundle f221b;

            /* renamed from: c */
            public final ResultReceiver f222c;

            public C0090b(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f220a = str;
                this.f221b = bundle;
                this.f222c = resultReceiver;
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$i$c */
        class C0091c extends IMediaSession.Stub {
            C0091c() {
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo549a(int i) {
                C0088i.this.mo547x(i, 0, 0, (Object) null, (Bundle) null);
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                mo551c(25, mediaDescriptionCompat);
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                mo552d(26, mediaDescriptionCompat, i);
            }

            public void adjustVolume(int i, int i2, String str) {
                C0088i.this.mo545t(i, i2);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public void mo550b(int i, int i2) {
                C0088i.this.mo547x(i, i2, 0, (Object) null, (Bundle) null);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: c */
            public void mo551c(int i, Object obj) {
                C0088i.this.mo547x(i, 0, 0, obj, (Bundle) null);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: d */
            public void mo552d(int i, Object obj, int i2) {
                C0088i.this.mo547x(i, i2, 0, obj, (Bundle) null);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: e */
            public void mo553e(int i, Object obj, Bundle bundle) {
                C0088i.this.mo547x(i, 0, 0, obj, bundle);
            }

            public void fastForward() {
                mo549a(16);
            }

            public Bundle getExtras() {
                Bundle bundle;
                synchronized (C0088i.this.f201i) {
                    bundle = C0088i.this.f188B;
                }
                return bundle;
            }

            public long getFlags() {
                long j;
                synchronized (C0088i.this.f201i) {
                    j = (long) C0088i.this.f210r;
                }
                return j;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                synchronized (C0088i.this.f201i) {
                    pendingIntent = C0088i.this.f213u;
                }
                return pendingIntent;
            }

            public MediaMetadataCompat getMetadata() {
                return C0088i.this.f211s;
            }

            public String getPackageName() {
                return C0088i.this.f197e;
            }

            public PlaybackStateCompat getPlaybackState() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (C0088i.this.f201i) {
                    C0088i iVar = C0088i.this;
                    playbackStateCompat = iVar.f212t;
                    mediaMetadataCompat = iVar.f211s;
                }
                return MediaSessionCompat.m203a(playbackStateCompat, mediaMetadataCompat);
            }

            public List<QueueItem> getQueue() {
                List<QueueItem> list;
                synchronized (C0088i.this.f201i) {
                    list = C0088i.this.f214v;
                }
                return list;
            }

            public CharSequence getQueueTitle() {
                return C0088i.this.f215w;
            }

            public int getRatingType() {
                return C0088i.this.f216x;
            }

            public int getRepeatMode() {
                return C0088i.this.f218z;
            }

            public int getShuffleMode() {
                return C0088i.this.f187A;
            }

            public String getTag() {
                return C0088i.this.f198f;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                synchronized (C0088i.this.f201i) {
                    C0088i iVar = C0088i.this;
                    i = iVar.f189C;
                    i2 = iVar.f190D;
                    VolumeProviderCompat volumeProviderCompat = iVar.f191E;
                    i3 = 2;
                    if (i == 2) {
                        int volumeControl = volumeProviderCompat.getVolumeControl();
                        int maxVolume = volumeProviderCompat.getMaxVolume();
                        i4 = volumeProviderCompat.getCurrentVolume();
                        i5 = maxVolume;
                        i3 = volumeControl;
                    } else {
                        i5 = iVar.f199g.getStreamMaxVolume(i2);
                        i4 = C0088i.this.f199g.getStreamVolume(i2);
                    }
                }
                return new ParcelableVolumeInfo(i, i2, i3, i5, i4);
            }

            public boolean isCaptioningEnabled() {
                return C0088i.this.f217y;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                return (C0088i.this.f210r & 2) != 0;
            }

            public void next() {
                mo549a(14);
            }

            public void pause() {
                mo549a(12);
            }

            public void play() {
                mo549a(7);
            }

            public void playFromMediaId(String str, Bundle bundle) {
                mo553e(8, str, bundle);
            }

            public void playFromSearch(String str, Bundle bundle) {
                mo553e(9, str, bundle);
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                mo553e(10, uri, bundle);
            }

            public void prepare() {
                mo549a(3);
            }

            public void prepareFromMediaId(String str, Bundle bundle) {
                mo553e(4, str, bundle);
            }

            public void prepareFromSearch(String str, Bundle bundle) {
                mo553e(5, str, bundle);
            }

            public void prepareFromUri(Uri uri, Bundle bundle) {
                mo553e(6, uri, bundle);
            }

            public void previous() {
                mo549a(15);
            }

            public void rate(RatingCompat ratingCompat) {
                mo551c(19, ratingCompat);
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                mo553e(31, ratingCompat, bundle);
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (C0088i.this.f204l) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                    } catch (Exception unused) {
                    }
                } else {
                    C0088i.this.f202j.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                mo551c(27, mediaDescriptionCompat);
            }

            public void removeQueueItemAt(int i) {
                mo550b(28, i);
            }

            public void rewind() {
                mo549a(17);
            }

            public void seekTo(long j) {
                mo551c(18, Long.valueOf(j));
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                mo551c(1, new C0090b(str, bundle, resultReceiverWrapper.f168a));
            }

            public void sendCustomAction(String str, Bundle bundle) {
                mo553e(20, str, bundle);
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                boolean z = true;
                if ((C0088i.this.f210r & 1) == 0) {
                    z = false;
                }
                if (z) {
                    mo551c(21, keyEvent);
                }
                return z;
            }

            public void setCaptioningEnabled(boolean z) {
                mo551c(29, Boolean.valueOf(z));
            }

            public void setRepeatMode(int i) {
                mo550b(23, i);
            }

            public void setShuffleMode(int i) {
                mo550b(30, i);
            }

            public void setShuffleModeEnabledRemoved(boolean z) {
            }

            public void setVolumeTo(int i, int i2, String str) {
                C0088i.this.mo543L(i, i2);
            }

            public void skipToQueueItem(long j) {
                mo551c(11, Long.valueOf(j));
            }

            public void stop() {
                mo549a(13);
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                C0088i.this.f202j.unregister(iMediaControllerCallback);
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$i$d */
        class C0092d extends Handler {
            public C0092d(Looper looper) {
                super(looper);
            }

            /* renamed from: a */
            private void m305a(KeyEvent keyEvent, Callback callback) {
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    PlaybackStateCompat playbackStateCompat = C0088i.this.f212t;
                    long actions = playbackStateCompat == null ? 0 : playbackStateCompat.getActions();
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79) {
                        if (keyCode != 126) {
                            if (keyCode != 127) {
                                switch (keyCode) {
                                    case 85:
                                        break;
                                    case 86:
                                        if ((actions & 1) != 0) {
                                            callback.onStop();
                                            return;
                                        }
                                        return;
                                    case 87:
                                        if ((actions & 32) != 0) {
                                            callback.onSkipToNext();
                                            return;
                                        }
                                        return;
                                    case 88:
                                        if ((actions & 16) != 0) {
                                            callback.onSkipToPrevious();
                                            return;
                                        }
                                        return;
                                    case 89:
                                        if ((actions & 8) != 0) {
                                            callback.onRewind();
                                            return;
                                        }
                                        return;
                                    case 90:
                                        if ((actions & 64) != 0) {
                                            callback.onFastForward();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            } else if ((actions & 2) != 0) {
                                callback.onPause();
                                return;
                            } else {
                                return;
                            }
                        } else if ((actions & 4) != 0) {
                            callback.onPlay();
                            return;
                        } else {
                            return;
                        }
                    }
                    Log.w("MediaSessionCompat", "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                }
            }

            public void handleMessage(Message message) {
                Callback callback = C0088i.this.f208p;
                if (callback != null) {
                    Bundle data = message.getData();
                    MediaSessionCompat.ensureClassLoader(data);
                    C0088i.this.mo525o(new MediaSessionManager.RemoteUserInfo(data.getString("data_calling_pkg"), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID)));
                    Bundle bundle = data.getBundle("data_extras");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    try {
                        switch (message.what) {
                            case 1:
                                C0090b bVar = (C0090b) message.obj;
                                callback.onCommand(bVar.f220a, bVar.f221b, bVar.f222c);
                                break;
                            case 2:
                                C0088i.this.mo545t(message.arg1, 0);
                                break;
                            case 3:
                                callback.onPrepare();
                                break;
                            case 4:
                                callback.onPrepareFromMediaId((String) message.obj, bundle);
                                break;
                            case 5:
                                callback.onPrepareFromSearch((String) message.obj, bundle);
                                break;
                            case 6:
                                callback.onPrepareFromUri((Uri) message.obj, bundle);
                                break;
                            case 7:
                                callback.onPlay();
                                break;
                            case 8:
                                callback.onPlayFromMediaId((String) message.obj, bundle);
                                break;
                            case 9:
                                callback.onPlayFromSearch((String) message.obj, bundle);
                                break;
                            case 10:
                                callback.onPlayFromUri((Uri) message.obj, bundle);
                                break;
                            case 11:
                                callback.onSkipToQueueItem(((Long) message.obj).longValue());
                                break;
                            case 12:
                                callback.onPause();
                                break;
                            case 13:
                                callback.onStop();
                                break;
                            case 14:
                                callback.onSkipToNext();
                                break;
                            case 15:
                                callback.onSkipToPrevious();
                                break;
                            case 16:
                                callback.onFastForward();
                                break;
                            case 17:
                                callback.onRewind();
                                break;
                            case 18:
                                callback.onSeekTo(((Long) message.obj).longValue());
                                break;
                            case 19:
                                callback.onSetRating((RatingCompat) message.obj);
                                break;
                            case 20:
                                callback.onCustomAction((String) message.obj, bundle);
                                break;
                            case 21:
                                KeyEvent keyEvent = (KeyEvent) message.obj;
                                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                                intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                                if (!callback.onMediaButtonEvent(intent)) {
                                    m305a(keyEvent, callback);
                                    break;
                                }
                                break;
                            case 22:
                                C0088i.this.mo543L(message.arg1, 0);
                                break;
                            case 23:
                                callback.onSetRepeatMode(message.arg1);
                                break;
                            case 25:
                                callback.onAddQueueItem((MediaDescriptionCompat) message.obj);
                                break;
                            case 26:
                                callback.onAddQueueItem((MediaDescriptionCompat) message.obj, message.arg1);
                                break;
                            case 27:
                                callback.onRemoveQueueItem((MediaDescriptionCompat) message.obj);
                                break;
                            case 28:
                                List<QueueItem> list = C0088i.this.f214v;
                                if (list != null) {
                                    int i = message.arg1;
                                    QueueItem queueItem = (i < 0 || i >= list.size()) ? null : C0088i.this.f214v.get(message.arg1);
                                    if (queueItem != null) {
                                        callback.onRemoveQueueItem(queueItem.getDescription());
                                        break;
                                    }
                                }
                                break;
                            case 29:
                                callback.onSetCaptioningEnabled(((Boolean) message.obj).booleanValue());
                                break;
                            case 30:
                                callback.onSetShuffleMode(message.arg1);
                                break;
                            case 31:
                                callback.onSetRating((RatingCompat) message.obj, bundle);
                                break;
                        }
                    } finally {
                        C0088i.this.mo525o((MediaSessionManager.RemoteUserInfo) null);
                    }
                }
            }
        }

        public C0088i(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            if (componentName != null) {
                this.f197e = context.getPackageName();
                this.f199g = (AudioManager) context.getSystemService("audio");
                this.f198f = str;
                this.f193a = componentName;
                this.f194b = pendingIntent;
                C0091c cVar = new C0091c();
                this.f195c = cVar;
                this.f196d = new Token(cVar);
                this.f216x = 0;
                this.f189C = 1;
                this.f190D = 3;
                this.f200h = new RemoteControlClient(pendingIntent);
                return;
            }
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        }

        /* renamed from: A */
        private void m260A(String str, Bundle bundle) {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
        }

        /* renamed from: B */
        private void m261B(Bundle bundle) {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onExtrasChanged(bundle);
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
        }

        /* renamed from: C */
        private void m262C(MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onMetadataChanged(mediaMetadataCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
        }

        /* renamed from: D */
        private void m263D(List<QueueItem> list) {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onQueueChanged(list);
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
        }

        /* renamed from: E */
        private void m264E(CharSequence charSequence) {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onQueueTitleChanged(charSequence);
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
        }

        /* renamed from: F */
        private void m265F(int i) {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i);
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
        }

        /* renamed from: G */
        private void m266G() {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onSessionDestroyed();
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
            this.f202j.kill();
        }

        /* renamed from: H */
        private void m267H(int i) {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i);
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
        }

        /* renamed from: I */
        private void m268I(PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
        }

        /* renamed from: z */
        private void m269z(boolean z) {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z);
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: J */
        public void mo542J(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int beginBroadcast = this.f202j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f202j.getBroadcastItem(beginBroadcast).onVolumeInfoChanged(parcelableVolumeInfo);
                } catch (RemoteException unused) {
                }
            }
            this.f202j.finishBroadcast();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: K */
        public void mo535K(PlaybackStateCompat playbackStateCompat) {
            this.f200h.setPlaybackState(mo546v(playbackStateCompat.getState()));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: L */
        public void mo543L(int i, int i2) {
            if (this.f189C == 2) {
                VolumeProviderCompat volumeProviderCompat = this.f191E;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.onSetVolumeTo(i);
                    return;
                }
                return;
            }
            this.f199g.setStreamVolume(this.f190D, i, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: M */
        public void mo536M(PendingIntent pendingIntent, ComponentName componentName) {
            this.f199g.unregisterMediaButtonEventReceiver(componentName);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: N */
        public boolean mo544N() {
            if (this.f205m) {
                boolean z = this.f206n;
                if (!z && (this.f210r & 1) != 0) {
                    mo538y(this.f194b, this.f193a);
                    this.f206n = true;
                } else if (z && (this.f210r & 1) == 0) {
                    mo536M(this.f194b, this.f193a);
                    this.f206n = false;
                }
                boolean z2 = this.f207o;
                if (!z2 && (this.f210r & 2) != 0) {
                    this.f199g.registerRemoteControlClient(this.f200h);
                    this.f207o = true;
                    return true;
                } else if (z2 && (this.f210r & 2) == 0) {
                    this.f200h.setPlaybackState(0);
                    this.f199g.unregisterRemoteControlClient(this.f200h);
                    this.f207o = false;
                }
            } else {
                if (this.f206n) {
                    mo536M(this.f194b, this.f193a);
                    this.f206n = false;
                }
                if (this.f207o) {
                    this.f200h.setPlaybackState(0);
                    this.f199g.unregisterRemoteControlClient(this.f200h);
                    this.f207o = false;
                }
            }
            return false;
        }

        /* renamed from: a */
        public Token mo509a() {
            return this.f196d;
        }

        /* renamed from: b */
        public void mo510b(String str, Bundle bundle) {
            m260A(str, bundle);
        }

        /* renamed from: c */
        public String mo511c() {
            return null;
        }

        /* renamed from: d */
        public void mo512d(PendingIntent pendingIntent) {
            synchronized (this.f201i) {
                this.f213u = pendingIntent;
            }
        }

        /* renamed from: e */
        public void mo513e(Callback callback, Handler handler) {
            this.f208p = callback;
            if (callback != null) {
                if (handler == null) {
                    handler = new Handler();
                }
                synchronized (this.f201i) {
                    C0092d dVar = this.f203k;
                    if (dVar != null) {
                        dVar.removeCallbacksAndMessages((Object) null);
                    }
                    this.f203k = new C0092d(handler.getLooper());
                    this.f208p.mo427b(this, handler);
                }
            }
        }

        /* renamed from: f */
        public void mo514f(int i) {
            VolumeProviderCompat volumeProviderCompat = this.f191E;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.setCallback((VolumeProviderCompat.Callback) null);
            }
            this.f190D = i;
            this.f189C = 1;
            int i2 = this.f189C;
            int i3 = this.f190D;
            mo542J(new ParcelableVolumeInfo(i2, i3, 2, this.f199g.getStreamMaxVolume(i3), this.f199g.getStreamVolume(this.f190D)));
        }

        /* renamed from: g */
        public void mo515g(CharSequence charSequence) {
            this.f215w = charSequence;
            m264E(charSequence);
        }

        public PlaybackStateCompat getPlaybackState() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.f201i) {
                playbackStateCompat = this.f212t;
            }
            return playbackStateCompat;
        }

        /* renamed from: h */
        public void mo517h(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle;
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.Builder(mediaMetadataCompat, MediaSessionCompat.f153d).build();
            }
            synchronized (this.f201i) {
                this.f211s = mediaMetadataCompat;
            }
            m262C(mediaMetadataCompat);
            if (this.f205m) {
                if (mediaMetadataCompat == null) {
                    bundle = null;
                } else {
                    bundle = mediaMetadataCompat.getBundle();
                }
                mo540u(bundle).apply();
            }
        }

        /* renamed from: i */
        public void mo518i(PendingIntent pendingIntent) {
        }

        public boolean isActive() {
            return this.f205m;
        }

        /* renamed from: j */
        public void mo520j(int i) {
            this.f216x = i;
        }

        /* renamed from: k */
        public void mo521k(int i) {
            synchronized (this.f201i) {
                this.f210r = i;
            }
            mo544N();
        }

        /* renamed from: l */
        public void mo522l(List<QueueItem> list) {
            this.f214v = list;
            m263D(list);
        }

        /* renamed from: m */
        public Object mo523m() {
            return null;
        }

        /* renamed from: n */
        public void mo524n(boolean z) {
            if (z != this.f205m) {
                this.f205m = z;
                if (mo544N()) {
                    mo517h(this.f211s);
                    mo526p(this.f212t);
                }
            }
        }

        /* renamed from: o */
        public void mo525o(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.f201i) {
                this.f209q = remoteUserInfo;
            }
        }

        /* renamed from: p */
        public void mo526p(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.f201i) {
                this.f212t = playbackStateCompat;
            }
            m268I(playbackStateCompat);
            if (this.f205m) {
                if (playbackStateCompat == null) {
                    this.f200h.setPlaybackState(0);
                    this.f200h.setTransportControlFlags(0);
                    return;
                }
                mo535K(playbackStateCompat);
                this.f200h.setTransportControlFlags(mo537w(playbackStateCompat.getActions()));
            }
        }

        /* renamed from: q */
        public Object mo527q() {
            return null;
        }

        /* renamed from: r */
        public void mo528r(VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat != null) {
                VolumeProviderCompat volumeProviderCompat2 = this.f191E;
                if (volumeProviderCompat2 != null) {
                    volumeProviderCompat2.setCallback((VolumeProviderCompat.Callback) null);
                }
                this.f189C = 2;
                this.f191E = volumeProviderCompat;
                mo542J(new ParcelableVolumeInfo(this.f189C, this.f190D, this.f191E.getVolumeControl(), this.f191E.getMaxVolume(), this.f191E.getCurrentVolume()));
                volumeProviderCompat.setCallback(this.f192F);
                return;
            }
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        public void release() {
            this.f205m = false;
            this.f204l = true;
            mo544N();
            m266G();
        }

        /* renamed from: s */
        public MediaSessionManager.RemoteUserInfo mo530s() {
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.f201i) {
                remoteUserInfo = this.f209q;
            }
            return remoteUserInfo;
        }

        public void setCaptioningEnabled(boolean z) {
            if (this.f217y != z) {
                this.f217y = z;
                m269z(z);
            }
        }

        public void setExtras(Bundle bundle) {
            this.f188B = bundle;
            m261B(bundle);
        }

        public void setRepeatMode(int i) {
            if (this.f218z != i) {
                this.f218z = i;
                m265F(i);
            }
        }

        public void setShuffleMode(int i) {
            if (this.f187A != i) {
                this.f187A = i;
                m267H(i);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public void mo545t(int i, int i2) {
            if (this.f189C == 2) {
                VolumeProviderCompat volumeProviderCompat = this.f191E;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.onAdjustVolume(i);
                    return;
                }
                return;
            }
            this.f199g.adjustStreamVolume(this.f190D, i, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: u */
        public RemoteControlClient.MetadataEditor mo540u(Bundle bundle) {
            RemoteControlClient.MetadataEditor editMetadata = this.f200h.editMetadata(true);
            if (bundle == null) {
                return editMetadata;
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ART)) {
                Bitmap bitmap = (Bitmap) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_ART);
                if (bitmap != null) {
                    bitmap = bitmap.copy(bitmap.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap);
            } else if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ART)) {
                Bitmap bitmap2 = (Bitmap) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
                if (bitmap2 != null) {
                    bitmap2 = bitmap2.copy(bitmap2.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap2);
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM)) {
                editMetadata.putString(1, bundle.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST)) {
                editMetadata.putString(13, bundle.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ARTIST)) {
                editMetadata.putString(2, bundle.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_AUTHOR)) {
                editMetadata.putString(3, bundle.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_COMPILATION)) {
                editMetadata.putString(15, bundle.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_COMPOSER)) {
                editMetadata.putString(4, bundle.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DATE)) {
                editMetadata.putString(5, bundle.getString(MediaMetadataCompat.METADATA_KEY_DATE));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER)) {
                editMetadata.putLong(14, bundle.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                editMetadata.putLong(9, bundle.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_GENRE)) {
                editMetadata.putString(6, bundle.getString(MediaMetadataCompat.METADATA_KEY_GENRE));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_TITLE)) {
                editMetadata.putString(7, bundle.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER)) {
                editMetadata.putLong(0, bundle.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_WRITER)) {
                editMetadata.putString(11, bundle.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
            }
            return editMetadata;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: v */
        public int mo546v(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w */
        public int mo537w(long j) {
            int i = (1 & j) != 0 ? 32 : 0;
            if ((2 & j) != 0) {
                i |= 16;
            }
            if ((4 & j) != 0) {
                i |= 4;
            }
            if ((8 & j) != 0) {
                i |= 2;
            }
            if ((16 & j) != 0) {
                i |= 1;
            }
            if ((32 & j) != 0) {
                i |= 128;
            }
            if ((64 & j) != 0) {
                i |= 64;
            }
            return (j & 512) != 0 ? i | 8 : i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: x */
        public void mo547x(int i, int i2, int i3, Object obj, Bundle bundle) {
            synchronized (this.f201i) {
                C0092d dVar = this.f203k;
                if (dVar != null) {
                    Message obtainMessage = dVar.obtainMessage(i, i2, i3, obj);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("data_calling_pkg", MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER);
                    bundle2.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
                    bundle2.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
                    if (bundle != null) {
                        bundle2.putBundle("data_extras", bundle);
                    }
                    obtainMessage.setData(bundle2);
                    obtainMessage.sendToTarget();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: y */
        public void mo538y(PendingIntent pendingIntent, ComponentName componentName) {
            this.f199g.registerMediaButtonEventReceiver(componentName);
        }
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, (ComponentName) null, (PendingIntent) null);
    }

    /* renamed from: a */
    static PlaybackStateCompat m203a(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j = -1;
        if (playbackStateCompat.getPosition() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4 && playbackStateCompat.getState() != 5) {
            return playbackStateCompat;
        }
        long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
        if (lastPositionUpdateTime <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long playbackSpeed = ((long) (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - lastPositionUpdateTime)))) + playbackStateCompat.getPosition();
        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
            j = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
        }
        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), (j < 0 || playbackSpeed <= j) ? playbackSpeed < 0 ? 0 : playbackSpeed : j, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void ensureClassLoader(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        if (context == null || obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return new MediaSessionCompat(context, (C0080d) new C0085g(obj));
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.f156c.add(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getCallingPackage() {
        return this.f154a.mo511c();
    }

    public MediaControllerCompat getController() {
        return this.f155b;
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return this.f154a.mo530s();
    }

    public Object getMediaSession() {
        return this.f154a.mo527q();
    }

    public Object getRemoteControlClient() {
        return this.f154a.mo523m();
    }

    public Token getSessionToken() {
        return this.f154a.mo509a();
    }

    public boolean isActive() {
        return this.f154a.isActive();
    }

    public void release() {
        this.f154a.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.f156c.remove(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f154a.mo510b(str, bundle);
            return;
        }
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void setActive(boolean z) {
        this.f154a.mo524n(z);
        Iterator<OnActiveChangeListener> it = this.f156c.iterator();
        while (it.hasNext()) {
            it.next().onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, (Handler) null);
    }

    public void setCaptioningEnabled(boolean z) {
        this.f154a.setCaptioningEnabled(z);
    }

    public void setExtras(Bundle bundle) {
        this.f154a.setExtras(bundle);
    }

    public void setFlags(int i) {
        this.f154a.mo521k(i);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.f154a.mo518i(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.f154a.mo517h(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.f154a.mo526p(playbackStateCompat);
    }

    public void setPlaybackToLocal(int i) {
        this.f154a.mo514f(i);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat != null) {
            this.f154a.mo528r(volumeProviderCompat);
            return;
        }
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setQueue(List<QueueItem> list) {
        this.f154a.mo522l(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.f154a.mo515g(charSequence);
    }

    public void setRatingType(int i) {
        this.f154a.mo520j(i);
    }

    public void setRepeatMode(int i) {
        this.f154a.setRepeatMode(i);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.f154a.mo512d(pendingIntent);
    }

    public void setShuffleMode(int i) {
        this.f154a.setShuffleMode(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new C0075a();

        /* renamed from: a */
        ResultReceiver f168a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$a */
        static class C0075a implements Parcelable.Creator<ResultReceiverWrapper> {
            C0075a() {
            }

            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.f168a = resultReceiver;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f168a.writeToParcel(parcel, i);
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f168a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, (Bundle) null);
    }

    public void setCallback(Callback callback, Handler handler) {
        if (callback == null) {
            this.f154a.mo513e((Callback) null, (Handler) null);
            return;
        }
        C0080d dVar = this.f154a;
        if (handler == null) {
            handler = new Handler();
        }
        dVar.mo513e(callback, handler);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MediaSessionCompat(Context context, String str, Bundle bundle) {
        this(context, str, (ComponentName) null, (PendingIntent) null, bundle);
    }

    private MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this.f156c = new ArrayList<>();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (!TextUtils.isEmpty(str)) {
            if (componentName == null && (componentName = MediaButtonReceiver.getMediaButtonReceiverComponent(context)) == null) {
                Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
            }
            if (componentName != null && pendingIntent == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                C0087h hVar = new C0087h(context, str, bundle);
                this.f154a = hVar;
                setCallback(new C0077a(this));
                hVar.mo518i(pendingIntent);
            } else if (i >= 21) {
                C0085g gVar = new C0085g(context, str, bundle);
                this.f154a = gVar;
                setCallback(new C0078b(this));
                gVar.mo518i(pendingIntent);
            } else if (i >= 19) {
                this.f154a = new C0083f(context, str, componentName, pendingIntent);
            } else if (i >= 18) {
                this.f154a = new C0081e(context, str, componentName, pendingIntent);
            } else {
                this.f154a = new C0088i(context, str, componentName, pendingIntent);
            }
            this.f155b = new MediaControllerCompat(context, this);
            if (f153d == 0) {
                f153d = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
            }
        } else {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
    }

    @RequiresApi(21)
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$g */
    static class C0085g implements C0080d {

        /* renamed from: a */
        final Object f175a;

        /* renamed from: b */
        final Token f176b;

        /* renamed from: c */
        boolean f177c = false;

        /* renamed from: d */
        final RemoteCallbackList<IMediaControllerCallback> f178d = new RemoteCallbackList<>();

        /* renamed from: e */
        PlaybackStateCompat f179e;

        /* renamed from: f */
        List<QueueItem> f180f;

        /* renamed from: g */
        MediaMetadataCompat f181g;

        /* renamed from: h */
        int f182h;

        /* renamed from: i */
        boolean f183i;

        /* renamed from: j */
        int f184j;

        /* renamed from: k */
        int f185k;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$g$a */
        class C0086a extends IMediaSession.Stub {
            C0086a() {
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                throw new AssertionError();
            }

            public void adjustVolume(int i, int i2, String str) {
                throw new AssertionError();
            }

            public void fastForward() {
                throw new AssertionError();
            }

            public Bundle getExtras() {
                throw new AssertionError();
            }

            public long getFlags() {
                throw new AssertionError();
            }

            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            public String getPackageName() {
                throw new AssertionError();
            }

            public PlaybackStateCompat getPlaybackState() {
                C0085g gVar = C0085g.this;
                return MediaSessionCompat.m203a(gVar.f179e, gVar.f181g);
            }

            public List<QueueItem> getQueue() {
                return null;
            }

            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            public int getRatingType() {
                return C0085g.this.f182h;
            }

            public int getRepeatMode() {
                return C0085g.this.f184j;
            }

            public int getShuffleMode() {
                return C0085g.this.f185k;
            }

            public String getTag() {
                throw new AssertionError();
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            public boolean isCaptioningEnabled() {
                return C0085g.this.f183i;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            public void next() {
                throw new AssertionError();
            }

            public void pause() {
                throw new AssertionError();
            }

            public void play() {
                throw new AssertionError();
            }

            public void playFromMediaId(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void playFromSearch(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepare() {
                throw new AssertionError();
            }

            public void prepareFromMediaId(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepareFromSearch(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepareFromUri(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void previous() {
                throw new AssertionError();
            }

            public void rate(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                C0085g gVar = C0085g.this;
                if (!gVar.f177c) {
                    String c = gVar.mo511c();
                    if (c == null) {
                        c = MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER;
                    }
                    C0085g.this.f178d.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(c, Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void removeQueueItemAt(int i) {
                throw new AssertionError();
            }

            public void rewind() {
                throw new AssertionError();
            }

            public void seekTo(long j) {
                throw new AssertionError();
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            public void sendCustomAction(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            public void setCaptioningEnabled(boolean z) {
                throw new AssertionError();
            }

            public void setRepeatMode(int i) {
                throw new AssertionError();
            }

            public void setShuffleMode(int i) {
                throw new AssertionError();
            }

            public void setShuffleModeEnabledRemoved(boolean z) {
            }

            public void setVolumeTo(int i, int i2, String str) {
                throw new AssertionError();
            }

            public void skipToQueueItem(long j) {
                throw new AssertionError();
            }

            public void stop() {
                throw new AssertionError();
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                C0085g.this.f178d.unregister(iMediaControllerCallback);
            }
        }

        C0085g(Context context, String str, Bundle bundle) {
            Object b = C0098a.m316b(context, str);
            this.f175a = b;
            this.f176b = new Token(C0098a.m317c(b), new C0086a(), bundle);
        }

        /* renamed from: a */
        public Token mo509a() {
            return this.f176b;
        }

        /* renamed from: b */
        public void mo510b(String str, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 23) {
                for (int beginBroadcast = this.f178d.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f178d.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.f178d.finishBroadcast();
            }
            C0098a.m321g(this.f175a, str, bundle);
        }

        /* renamed from: c */
        public String mo511c() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return MediaSessionCompatApi24.m308b(this.f175a);
        }

        /* renamed from: d */
        public void mo512d(PendingIntent pendingIntent) {
            C0098a.m333s(this.f175a, pendingIntent);
        }

        /* renamed from: e */
        public void mo513e(Callback callback, Handler handler) {
            C0098a.m323i(this.f175a, callback == null ? null : callback.f157a, handler);
            if (callback != null) {
                callback.mo427b(this, handler);
            }
        }

        /* renamed from: f */
        public void mo514f(int i) {
            C0098a.m329o(this.f175a, i);
        }

        /* renamed from: g */
        public void mo515g(CharSequence charSequence) {
            C0098a.m332r(this.f175a, charSequence);
        }

        public PlaybackStateCompat getPlaybackState() {
            return this.f179e;
        }

        /* renamed from: h */
        public void mo517h(MediaMetadataCompat mediaMetadataCompat) {
            Object obj;
            this.f181g = mediaMetadataCompat;
            Object obj2 = this.f175a;
            if (mediaMetadataCompat == null) {
                obj = null;
            } else {
                obj = mediaMetadataCompat.getMediaMetadata();
            }
            C0098a.m327m(obj2, obj);
        }

        /* renamed from: i */
        public void mo518i(PendingIntent pendingIntent) {
            C0098a.m326l(this.f175a, pendingIntent);
        }

        public boolean isActive() {
            return C0098a.m319e(this.f175a);
        }

        /* renamed from: j */
        public void mo520j(int i) {
            if (Build.VERSION.SDK_INT < 22) {
                this.f182h = i;
            } else {
                C0102b.m339a(this.f175a, i);
            }
        }

        /* renamed from: k */
        public void mo521k(int i) {
            C0098a.m325k(this.f175a, i);
        }

        /* renamed from: l */
        public void mo522l(List<QueueItem> list) {
            ArrayList arrayList;
            this.f180f = list;
            if (list != null) {
                arrayList = new ArrayList();
                for (QueueItem queueItem : list) {
                    arrayList.add(queueItem.getQueueItem());
                }
            } else {
                arrayList = null;
            }
            C0098a.m331q(this.f175a, arrayList);
        }

        /* renamed from: m */
        public Object mo523m() {
            return null;
        }

        /* renamed from: n */
        public void mo524n(boolean z) {
            C0098a.m322h(this.f175a, z);
        }

        /* renamed from: o */
        public void mo525o(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }

        /* renamed from: p */
        public void mo526p(PlaybackStateCompat playbackStateCompat) {
            Object obj;
            this.f179e = playbackStateCompat;
            for (int beginBroadcast = this.f178d.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f178d.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f178d.finishBroadcast();
            Object obj2 = this.f175a;
            if (playbackStateCompat == null) {
                obj = null;
            } else {
                obj = playbackStateCompat.getPlaybackState();
            }
            C0098a.m328n(obj2, obj);
        }

        /* renamed from: q */
        public Object mo527q() {
            return this.f175a;
        }

        /* renamed from: r */
        public void mo528r(VolumeProviderCompat volumeProviderCompat) {
            C0098a.m330p(this.f175a, volumeProviderCompat.getVolumeProvider());
        }

        public void release() {
            this.f177c = true;
            C0098a.m320f(this.f175a);
        }

        /* renamed from: s */
        public MediaSessionManager.RemoteUserInfo mo530s() {
            return null;
        }

        public void setCaptioningEnabled(boolean z) {
            if (this.f183i != z) {
                this.f183i = z;
                for (int beginBroadcast = this.f178d.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f178d.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z);
                    } catch (RemoteException unused) {
                    }
                }
                this.f178d.finishBroadcast();
            }
        }

        public void setExtras(Bundle bundle) {
            C0098a.m324j(this.f175a, bundle);
        }

        public void setRepeatMode(int i) {
            if (this.f184j != i) {
                this.f184j = i;
                for (int beginBroadcast = this.f178d.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f178d.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i);
                    } catch (RemoteException unused) {
                    }
                }
                this.f178d.finishBroadcast();
            }
        }

        public void setShuffleMode(int i) {
            if (this.f185k != i) {
                this.f185k = i;
                for (int beginBroadcast = this.f178d.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f178d.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i);
                    } catch (RemoteException unused) {
                    }
                }
                this.f178d.finishBroadcast();
            }
        }

        C0085g(Object obj) {
            C0098a.m334t(obj);
            this.f175a = obj;
            this.f176b = new Token(C0098a.m317c(obj), new C0086a());
        }
    }

    private MediaSessionCompat(Context context, C0080d dVar) {
        this.f156c = new ArrayList<>();
        this.f154a = dVar;
        if (Build.VERSION.SDK_INT >= 21 && !C0098a.m318d(dVar.mo527q())) {
            setCallback(new C0079c(this));
        }
        this.f155b = new MediaControllerCompat(context, this);
    }
}
