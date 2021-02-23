package android.support.p000v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p000v4.media.session.C0103c;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SET_REPEAT_MODE = 262144;
    public static final long ACTION_SET_SHUFFLE_MODE = 2097152;
    @Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new C0097a();
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;

    /* renamed from: a */
    final int f225a;

    /* renamed from: b */
    final long f226b;

    /* renamed from: c */
    final long f227c;

    /* renamed from: d */
    final float f228d;

    /* renamed from: e */
    final long f229e;

    /* renamed from: f */
    final int f230f;

    /* renamed from: g */
    final CharSequence f231g;

    /* renamed from: h */
    final long f232h;

    /* renamed from: i */
    List<CustomAction> f233i;

    /* renamed from: j */
    final long f234j;

    /* renamed from: k */
    final Bundle f235k;

    /* renamed from: l */
    private Object f236l;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Actions */
    public @interface Actions {
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Builder */
    public static final class Builder {

        /* renamed from: a */
        private final List<CustomAction> f237a;

        /* renamed from: b */
        private int f238b;

        /* renamed from: c */
        private long f239c;

        /* renamed from: d */
        private long f240d;

        /* renamed from: e */
        private float f241e;

        /* renamed from: f */
        private long f242f;

        /* renamed from: g */
        private int f243g;

        /* renamed from: h */
        private CharSequence f244h;

        /* renamed from: i */
        private long f245i;

        /* renamed from: j */
        private long f246j;

        /* renamed from: k */
        private Bundle f247k;

        public Builder() {
            this.f237a = new ArrayList();
            this.f246j = -1;
        }

        public Builder addCustomAction(String str, String str2, int i) {
            return addCustomAction(new CustomAction(str, str2, i, (Bundle) null));
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.f238b, this.f239c, this.f240d, this.f241e, this.f242f, this.f243g, this.f244h, this.f245i, this.f237a, this.f246j, this.f247k);
        }

        public Builder setActions(long j) {
            this.f242f = j;
            return this;
        }

        public Builder setActiveQueueItemId(long j) {
            this.f246j = j;
            return this;
        }

        public Builder setBufferedPosition(long j) {
            this.f240d = j;
            return this;
        }

        public Builder setErrorMessage(CharSequence charSequence) {
            this.f244h = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f247k = bundle;
            return this;
        }

        public Builder setState(int i, long j, float f) {
            return setState(i, j, f, SystemClock.elapsedRealtime());
        }

        public Builder addCustomAction(CustomAction customAction) {
            if (customAction != null) {
                this.f237a.add(customAction);
                return this;
            }
            throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
        }

        public Builder setErrorMessage(int i, CharSequence charSequence) {
            this.f243g = i;
            this.f244h = charSequence;
            return this;
        }

        public Builder setState(int i, long j, float f, long j2) {
            this.f238b = i;
            this.f239c = j;
            this.f245i = j2;
            this.f241e = f;
            return this;
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f237a = arrayList;
            this.f246j = -1;
            this.f238b = playbackStateCompat.f225a;
            this.f239c = playbackStateCompat.f226b;
            this.f241e = playbackStateCompat.f228d;
            this.f245i = playbackStateCompat.f232h;
            this.f240d = playbackStateCompat.f227c;
            this.f242f = playbackStateCompat.f229e;
            this.f243g = playbackStateCompat.f230f;
            this.f244h = playbackStateCompat.f231g;
            List<CustomAction> list = playbackStateCompat.f233i;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f246j = playbackStateCompat.f234j;
            this.f247k = playbackStateCompat.f235k;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$ErrorCode */
    public @interface ErrorCode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$MediaKeyAction */
    public @interface MediaKeyAction {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$RepeatMode */
    public @interface RepeatMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$ShuffleMode */
    public @interface ShuffleMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$State */
    public @interface State {
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$a */
    static class C0097a implements Parcelable.Creator<PlaybackStateCompat> {
        C0097a() {
        }

        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f225a = i;
        this.f226b = j;
        this.f227c = j2;
        this.f228d = f;
        this.f229e = j3;
        this.f230f = i2;
        this.f231g = charSequence;
        this.f232h = j4;
        this.f233i = new ArrayList(list);
        this.f234j = j5;
        this.f235k = bundle;
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        ArrayList arrayList;
        Object obj2 = obj;
        int i = Build.VERSION.SDK_INT;
        Bundle bundle = null;
        if (obj2 == null || i < 21) {
            return null;
        }
        List<Object> d = C0103c.m343d(obj);
        if (d != null) {
            ArrayList arrayList2 = new ArrayList(d.size());
            for (Object fromCustomAction : d) {
                arrayList2.add(CustomAction.fromCustomAction(fromCustomAction));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (i >= 22) {
            bundle = C0105d.m355a(obj);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(C0103c.m348i(obj), C0103c.m347h(obj), C0103c.m342c(obj), C0103c.m346g(obj), C0103c.m340a(obj), 0, C0103c.m344e(obj), C0103c.m345f(obj), arrayList, C0103c.m341b(obj), bundle);
        playbackStateCompat.f236l = obj2;
        return playbackStateCompat;
    }

    public static int toKeyCode(long j) {
        if (j == 4) {
            return 126;
        }
        if (j == 2) {
            return 127;
        }
        if (j == 32) {
            return 87;
        }
        if (j == 16) {
            return 88;
        }
        if (j == 1) {
            return 86;
        }
        if (j == 64) {
            return 90;
        }
        if (j == 8) {
            return 89;
        }
        return j == 512 ? 85 : 0;
    }

    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.f229e;
    }

    public long getActiveQueueItemId() {
        return this.f234j;
    }

    public long getBufferedPosition() {
        return this.f227c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getCurrentPosition(Long l) {
        return Math.max(0, this.f226b + ((long) (this.f228d * ((float) (l != null ? l.longValue() : SystemClock.elapsedRealtime() - this.f232h)))));
    }

    public List<CustomAction> getCustomActions() {
        return this.f233i;
    }

    public int getErrorCode() {
        return this.f230f;
    }

    public CharSequence getErrorMessage() {
        return this.f231g;
    }

    @Nullable
    public Bundle getExtras() {
        return this.f235k;
    }

    public long getLastPositionUpdateTime() {
        return this.f232h;
    }

    public float getPlaybackSpeed() {
        return this.f228d;
    }

    public Object getPlaybackState() {
        int i = Build.VERSION.SDK_INT;
        if (this.f236l == null && i >= 21) {
            ArrayList arrayList = null;
            if (this.f233i != null) {
                arrayList = new ArrayList(this.f233i.size());
                for (CustomAction customAction : this.f233i) {
                    arrayList.add(customAction.getCustomAction());
                }
            }
            ArrayList arrayList2 = arrayList;
            if (i >= 22) {
                this.f236l = C0105d.m356b(this.f225a, this.f226b, this.f227c, this.f228d, this.f229e, this.f231g, this.f232h, arrayList2, this.f234j, this.f235k);
            } else {
                this.f236l = C0103c.m349j(this.f225a, this.f226b, this.f227c, this.f228d, this.f229e, this.f231g, this.f232h, arrayList2, this.f234j);
            }
        }
        return this.f236l;
    }

    public long getPosition() {
        return this.f226b;
    }

    public int getState() {
        return this.f225a;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f225a + ", position=" + this.f226b + ", buffered position=" + this.f227c + ", speed=" + this.f228d + ", updated=" + this.f232h + ", actions=" + this.f229e + ", error code=" + this.f230f + ", error message=" + this.f231g + ", custom actions=" + this.f233i + ", active item id=" + this.f234j + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f225a);
        parcel.writeLong(this.f226b);
        parcel.writeFloat(this.f228d);
        parcel.writeLong(this.f232h);
        parcel.writeLong(this.f227c);
        parcel.writeLong(this.f229e);
        TextUtils.writeToParcel(this.f231g, parcel, i);
        parcel.writeTypedList(this.f233i);
        parcel.writeLong(this.f234j);
        parcel.writeBundle(this.f235k);
        parcel.writeInt(this.f230f);
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new C0096a();

        /* renamed from: a */
        private final String f248a;

        /* renamed from: b */
        private final CharSequence f249b;

        /* renamed from: c */
        private final int f250c;

        /* renamed from: d */
        private final Bundle f251d;

        /* renamed from: e */
        private Object f252e;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder */
        public static final class Builder {

            /* renamed from: a */
            private final String f253a;

            /* renamed from: b */
            private final CharSequence f254b;

            /* renamed from: c */
            private final int f255c;

            /* renamed from: d */
            private Bundle f256d;

            public Builder(String str, CharSequence charSequence, int i) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
                } else if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
                } else if (i != 0) {
                    this.f253a = str;
                    this.f254b = charSequence;
                    this.f255c = i;
                } else {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                }
            }

            public CustomAction build() {
                return new CustomAction(this.f253a, this.f254b, this.f255c, this.f256d);
            }

            public Builder setExtras(Bundle bundle) {
                this.f256d = bundle;
                return this;
            }
        }

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$a */
        static class C0096a implements Parcelable.Creator<CustomAction> {
            C0096a() {
            }

            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f248a = str;
            this.f249b = charSequence;
            this.f250c = i;
            this.f251d = bundle;
        }

        public static CustomAction fromCustomAction(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(C0103c.C0104a.m350a(obj), C0103c.C0104a.m353d(obj), C0103c.C0104a.m352c(obj), C0103c.C0104a.m351b(obj));
            customAction.f252e = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String getAction() {
            return this.f248a;
        }

        public Object getCustomAction() {
            Object obj = this.f252e;
            if (obj != null || Build.VERSION.SDK_INT < 21) {
                return obj;
            }
            Object e = C0103c.C0104a.m354e(this.f248a, this.f249b, this.f250c, this.f251d);
            this.f252e = e;
            return e;
        }

        public Bundle getExtras() {
            return this.f251d;
        }

        public int getIcon() {
            return this.f250c;
        }

        public CharSequence getName() {
            return this.f249b;
        }

        public String toString() {
            return "Action:mName='" + this.f249b + ", mIcon=" + this.f250c + ", mExtras=" + this.f251d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f248a);
            TextUtils.writeToParcel(this.f249b, parcel, i);
            parcel.writeInt(this.f250c);
            parcel.writeBundle(this.f251d);
        }

        CustomAction(Parcel parcel) {
            this.f248a = parcel.readString();
            this.f249b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f250c = parcel.readInt();
            this.f251d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f225a = parcel.readInt();
        this.f226b = parcel.readLong();
        this.f228d = parcel.readFloat();
        this.f232h = parcel.readLong();
        this.f227c = parcel.readLong();
        this.f229e = parcel.readLong();
        this.f231g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f233i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f234j = parcel.readLong();
        this.f235k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f230f = parcel.readInt();
    }
}
