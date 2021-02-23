package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AudioAttributesCompat implements VersionedParcelable {
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    public static final int FLAG_HW_AV_SYNC = 16;
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;

    /* renamed from: b */
    private static final SparseIntArray f3637b;

    /* renamed from: c */
    static boolean f3638c;

    /* renamed from: a */
    C0840a f3639a;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeContentType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeUsage {
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3637b = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    AudioAttributesCompat() {
    }

    /* renamed from: c */
    static int m2659c(boolean z, int i, int i2) {
        if ((i & 1) == 1) {
            return z ? 1 : 7;
        }
        if ((i & 4) == 4) {
            return z ? 0 : 6;
        }
        switch (i2) {
            case 0:
                return z ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            default:
                if (!z) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i2 + " in audio attributes");
        }
    }

    /* renamed from: d */
    static int m2660d(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
            case 7:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 2;
            case 8:
                return 3;
            case 10:
                return 11;
            default:
                return 0;
        }
    }

    /* renamed from: e */
    static String m2661e(int i) {
        switch (i) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 16:
                return "USAGE_ASSISTANT";
            default:
                return "unknown usage " + i;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static AudioAttributesCompat fromBundle(Bundle bundle) {
        C0840a aVar;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar = C0841b.m2774c(bundle);
        } else {
            aVar = C0842c.m2778c(bundle);
        }
        if (aVar == null) {
            return null;
        }
        return new AudioAttributesCompat(aVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setForceLegacyBehavior(boolean z) {
        f3638c = z;
    }

    @Nullable
    public static AudioAttributesCompat wrap(@NonNull Object obj) {
        if (Build.VERSION.SDK_INT < 21 || f3638c) {
            return null;
        }
        C0841b bVar = new C0841b((AudioAttributes) obj);
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f3639a = bVar;
        return audioAttributesCompat;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6407a() {
        return this.f3639a.mo6551a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        C0840a aVar = this.f3639a;
        if (aVar != null) {
            return aVar.equals(audioAttributesCompat.f3639a);
        }
        if (audioAttributesCompat.f3639a == null) {
            return true;
        }
        return false;
    }

    public int getContentType() {
        return this.f3639a.getContentType();
    }

    public int getFlags() {
        return this.f3639a.getFlags();
    }

    public int getLegacyStreamType() {
        return this.f3639a.getLegacyStreamType();
    }

    public int getUsage() {
        return this.f3639a.getUsage();
    }

    public int getVolumeControlStream() {
        return this.f3639a.getVolumeControlStream();
    }

    public int hashCode() {
        return this.f3639a.hashCode();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle toBundle() {
        return this.f3639a.toBundle();
    }

    public String toString() {
        return this.f3639a.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.f3639a.mo6552b();
    }

    AudioAttributesCompat(C0840a aVar) {
        this.f3639a = aVar;
    }

    public static class Builder {

        /* renamed from: a */
        private int f3640a = 0;

        /* renamed from: b */
        private int f3641b = 0;

        /* renamed from: c */
        private int f3642c = 0;

        /* renamed from: d */
        private int f3643d = -1;

        public Builder() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Builder mo6418a(int i) {
            switch (i) {
                case 0:
                    this.f3641b = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.f3641b = 4;
                    break;
                case 3:
                    this.f3641b = 2;
                    break;
                case 4:
                    this.f3641b = 4;
                    break;
                case 5:
                    this.f3641b = 4;
                    break;
                case 6:
                    this.f3641b = 1;
                    this.f3642c |= 4;
                    break;
                case 7:
                    this.f3642c = 1 | this.f3642c;
                    break;
                case 8:
                    this.f3641b = 4;
                    break;
                case 9:
                    this.f3641b = 4;
                    break;
                case 10:
                    this.f3641b = 1;
                    break;
                default:
                    Log.e("AudioAttributesCompat", "Invalid stream type " + i + " for AudioAttributesCompat");
                    break;
            }
            this.f3641b = 4;
            this.f3640a = AudioAttributesCompat.m2660d(i);
            return this;
        }

        public AudioAttributesCompat build() {
            C0840a aVar;
            if (AudioAttributesCompat.f3638c || Build.VERSION.SDK_INT < 21) {
                aVar = new C0842c(this.f3641b, this.f3642c, this.f3640a, this.f3643d);
            } else {
                AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f3641b).setFlags(this.f3642c).setUsage(this.f3640a);
                int i = this.f3643d;
                if (i != -1) {
                    usage.setLegacyStreamType(i);
                }
                aVar = new C0841b(usage.build(), this.f3643d);
            }
            return new AudioAttributesCompat(aVar);
        }

        public Builder setContentType(int i) {
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
                this.f3641b = i;
            } else {
                this.f3640a = 0;
            }
            return this;
        }

        public Builder setFlags(int i) {
            this.f3642c = (i & 1023) | this.f3642c;
            return this;
        }

        public Builder setLegacyStreamType(int i) {
            if (i != 10) {
                this.f3643d = i;
                if (Build.VERSION.SDK_INT >= 21) {
                    mo6418a(i);
                }
                return this;
            }
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }

        public Builder setUsage(int i) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    this.f3640a = i;
                    break;
                case 16:
                    if (!AudioAttributesCompat.f3638c && Build.VERSION.SDK_INT > 25) {
                        this.f3640a = i;
                        break;
                    } else {
                        this.f3640a = 12;
                        break;
                    }
                default:
                    this.f3640a = 0;
                    break;
            }
            return this;
        }

        public Builder(AudioAttributesCompat audioAttributesCompat) {
            this.f3640a = audioAttributesCompat.getUsage();
            this.f3641b = audioAttributesCompat.getContentType();
            this.f3642c = audioAttributesCompat.getFlags();
            this.f3643d = audioAttributesCompat.mo6407a();
        }
    }
}
