package androidx.media;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* renamed from: androidx.media.c */
/* compiled from: AudioAttributesImplBase */
class C0842c implements C0840a {

    /* renamed from: a */
    int f3771a = 0;

    /* renamed from: b */
    int f3772b = 0;

    /* renamed from: c */
    int f3773c = 0;

    /* renamed from: d */
    int f3774d = -1;

    C0842c() {
    }

    /* renamed from: c */
    public static C0840a m2778c(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new C0842c(bundle.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), bundle.getInt("androidx.media.audio_attrs.FLAGS", 0), bundle.getInt("androidx.media.audio_attrs.USAGE", 0), bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    /* renamed from: a */
    public int mo6551a() {
        return this.f3774d;
    }

    /* renamed from: b */
    public Object mo6552b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0842c)) {
            return false;
        }
        C0842c cVar = (C0842c) obj;
        if (this.f3772b == cVar.getContentType() && this.f3773c == cVar.getFlags() && this.f3771a == cVar.getUsage() && this.f3774d == cVar.f3774d) {
            return true;
        }
        return false;
    }

    public int getContentType() {
        return this.f3772b;
    }

    public int getFlags() {
        int i = this.f3773c;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i |= 4;
        } else if (legacyStreamType == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int getLegacyStreamType() {
        int i = this.f3774d;
        if (i != -1) {
            return i;
        }
        return AudioAttributesCompat.m2659c(false, this.f3773c, this.f3771a);
    }

    public int getUsage() {
        return this.f3771a;
    }

    public int getVolumeControlStream() {
        return AudioAttributesCompat.m2659c(true, this.f3773c, this.f3771a);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3772b), Integer.valueOf(this.f3773c), Integer.valueOf(this.f3771a), Integer.valueOf(this.f3774d)});
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.media.audio_attrs.USAGE", this.f3771a);
        bundle.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.f3772b);
        bundle.putInt("androidx.media.audio_attrs.FLAGS", this.f3773c);
        int i = this.f3774d;
        if (i != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3774d != -1) {
            sb.append(" stream=");
            sb.append(this.f3774d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.m2661e(this.f3771a));
        sb.append(" content=");
        sb.append(this.f3772b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3773c).toUpperCase());
        return sb.toString();
    }

    C0842c(int i, int i2, int i3, int i4) {
        this.f3772b = i;
        this.f3773c = i2;
        this.f3771a = i3;
        this.f3774d = i4;
    }
}
