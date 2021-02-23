package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.media.C0050d;
import android.support.p000v4.media.C0052e;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new C0035a();
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;

    /* renamed from: a */
    private final String f93a;

    /* renamed from: b */
    private final CharSequence f94b;

    /* renamed from: c */
    private final CharSequence f95c;

    /* renamed from: d */
    private final CharSequence f96d;

    /* renamed from: e */
    private final Bitmap f97e;

    /* renamed from: f */
    private final Uri f98f;

    /* renamed from: g */
    private final Bundle f99g;

    /* renamed from: h */
    private final Uri f100h;

    /* renamed from: i */
    private Object f101i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$Builder */
    public static final class Builder {

        /* renamed from: a */
        private String f102a;

        /* renamed from: b */
        private CharSequence f103b;

        /* renamed from: c */
        private CharSequence f104c;

        /* renamed from: d */
        private CharSequence f105d;

        /* renamed from: e */
        private Bitmap f106e;

        /* renamed from: f */
        private Uri f107f;

        /* renamed from: g */
        private Bundle f108g;

        /* renamed from: h */
        private Uri f109h;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.f102a, this.f103b, this.f104c, this.f105d, this.f106e, this.f107f, this.f108g, this.f109h);
        }

        public Builder setDescription(@Nullable CharSequence charSequence) {
            this.f105d = charSequence;
            return this;
        }

        public Builder setExtras(@Nullable Bundle bundle) {
            this.f108g = bundle;
            return this;
        }

        public Builder setIconBitmap(@Nullable Bitmap bitmap) {
            this.f106e = bitmap;
            return this;
        }

        public Builder setIconUri(@Nullable Uri uri) {
            this.f107f = uri;
            return this;
        }

        public Builder setMediaId(@Nullable String str) {
            this.f102a = str;
            return this;
        }

        public Builder setMediaUri(@Nullable Uri uri) {
            this.f109h = uri;
            return this;
        }

        public Builder setSubtitle(@Nullable CharSequence charSequence) {
            this.f104c = charSequence;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f103b = charSequence;
            return this;
        }
    }

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$a */
    static class C0035a implements Parcelable.Creator<MediaDescriptionCompat> {
        C0035a() {
        }

        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.fromMediaDescription(C0050d.m116a(parcel));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f93a = str;
        this.f94b = charSequence;
        this.f95c = charSequence2;
        this.f96d = charSequence3;
        this.f97e = bitmap;
        this.f98f = uri;
        this.f99g = bundle;
        this.f100h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.media.MediaDescriptionCompat fromMediaDescription(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x007e
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x007e
            android.support.v4.media.MediaDescriptionCompat$Builder r2 = new android.support.v4.media.MediaDescriptionCompat$Builder
            r2.<init>()
            java.lang.String r3 = android.support.p000v4.media.C0050d.m121f(r9)
            r2.setMediaId(r3)
            java.lang.CharSequence r3 = android.support.p000v4.media.C0050d.m123h(r9)
            r2.setTitle(r3)
            java.lang.CharSequence r3 = android.support.p000v4.media.C0050d.m122g(r9)
            r2.setSubtitle(r3)
            java.lang.CharSequence r3 = android.support.p000v4.media.C0050d.m117b(r9)
            r2.setDescription(r3)
            android.graphics.Bitmap r3 = android.support.p000v4.media.C0050d.m119d(r9)
            r2.setIconBitmap(r3)
            android.net.Uri r3 = android.support.p000v4.media.C0050d.m120e(r9)
            r2.setIconUri(r3)
            android.os.Bundle r3 = android.support.p000v4.media.C0050d.m118c(r9)
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L_0x004a
            android.support.p000v4.media.session.MediaSessionCompat.ensureClassLoader(r3)
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x004b
        L_0x004a:
            r5 = r0
        L_0x004b:
            if (r5 == 0) goto L_0x0063
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L_0x005d
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L_0x005d
            goto L_0x0064
        L_0x005d:
            r3.remove(r4)
            r3.remove(r6)
        L_0x0063:
            r0 = r3
        L_0x0064:
            r2.setExtras(r0)
            if (r5 == 0) goto L_0x006d
            r2.setMediaUri(r5)
            goto L_0x0078
        L_0x006d:
            r0 = 23
            if (r1 < r0) goto L_0x0078
            android.net.Uri r0 = android.support.p000v4.media.C0052e.m134a(r9)
            r2.setMediaUri(r0)
        L_0x0078:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.build()
            r0.f101i = r9
        L_0x007e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.media.MediaDescriptionCompat.fromMediaDescription(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public CharSequence getDescription() {
        return this.f96d;
    }

    @Nullable
    public Bundle getExtras() {
        return this.f99g;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        return this.f97e;
    }

    @Nullable
    public Uri getIconUri() {
        return this.f98f;
    }

    public Object getMediaDescription() {
        int i;
        Object obj = this.f101i;
        if (obj != null || (i = Build.VERSION.SDK_INT) < 21) {
            return obj;
        }
        Object b = C0050d.C0051a.m126b();
        C0050d.C0051a.m131g(b, this.f93a);
        C0050d.C0051a.m133i(b, this.f94b);
        C0050d.C0051a.m132h(b, this.f95c);
        C0050d.C0051a.m127c(b, this.f96d);
        C0050d.C0051a.m129e(b, this.f97e);
        C0050d.C0051a.m130f(b, this.f98f);
        Bundle bundle = this.f99g;
        if (i < 23 && this.f100h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
            }
            bundle.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.f100h);
        }
        C0050d.C0051a.m128d(b, bundle);
        if (i >= 23) {
            C0052e.C0053a.m135a(b, this.f100h);
        }
        Object a = C0050d.C0051a.m125a(b);
        this.f101i = a;
        return a;
    }

    @Nullable
    public String getMediaId() {
        return this.f93a;
    }

    @Nullable
    public Uri getMediaUri() {
        return this.f100h;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.f95c;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.f94b;
    }

    public String toString() {
        return this.f94b + ", " + this.f95c + ", " + this.f96d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f93a);
            TextUtils.writeToParcel(this.f94b, parcel, i);
            TextUtils.writeToParcel(this.f95c, parcel, i);
            TextUtils.writeToParcel(this.f96d, parcel, i);
            parcel.writeParcelable(this.f97e, i);
            parcel.writeParcelable(this.f98f, i);
            parcel.writeBundle(this.f99g);
            parcel.writeParcelable(this.f100h, i);
            return;
        }
        C0050d.m124i(getMediaDescription(), parcel, i);
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f93a = parcel.readString();
        this.f94b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f95c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f96d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f97e = (Bitmap) parcel.readParcelable(classLoader);
        this.f98f = (Uri) parcel.readParcelable(classLoader);
        this.f99g = parcel.readBundle(classLoader);
        this.f100h = (Uri) parcel.readParcelable(classLoader);
    }
}
