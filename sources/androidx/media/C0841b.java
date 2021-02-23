package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(21)
/* renamed from: androidx.media.b */
/* compiled from: AudioAttributesImplApi21 */
class C0841b implements C0840a {

    /* renamed from: c */
    static Method f3768c;

    /* renamed from: a */
    AudioAttributes f3769a;

    /* renamed from: b */
    int f3770b;

    C0841b() {
        this.f3770b = -1;
    }

    /* renamed from: c */
    public static C0840a m2774c(Bundle bundle) {
        AudioAttributes audioAttributes;
        if (bundle == null || (audioAttributes = (AudioAttributes) bundle.getParcelable("androidx.media.audio_attrs.FRAMEWORKS")) == null) {
            return null;
        }
        return new C0841b(audioAttributes, bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    /* renamed from: d */
    static Method m2775d() {
        try {
            if (f3768c == null) {
                f3768c = AudioAttributes.class.getMethod("toLegacyStreamType", new Class[]{AudioAttributes.class});
            }
            return f3768c;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public int mo6551a() {
        return this.f3770b;
    }

    /* renamed from: b */
    public Object mo6552b() {
        return this.f3769a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0841b)) {
            return false;
        }
        return this.f3769a.equals(((C0841b) obj).f3769a);
    }

    public int getContentType() {
        return this.f3769a.getContentType();
    }

    public int getFlags() {
        return this.f3769a.getFlags();
    }

    public int getLegacyStreamType() {
        int i = Build.VERSION.SDK_INT;
        int i2 = this.f3770b;
        if (i2 != -1) {
            return i2;
        }
        Method d = m2775d();
        if (d == null) {
            Log.w("AudioAttributesCompat21", "No AudioAttributes#toLegacyStreamType() on API: " + i);
            return -1;
        }
        try {
            return ((Integer) d.invoke((Object) null, new Object[]{this.f3769a})).intValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.w("AudioAttributesCompat21", "getLegacyStreamType() failed on API: " + i, e);
            return -1;
        }
    }

    public int getUsage() {
        return this.f3769a.getUsage();
    }

    public int getVolumeControlStream() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f3769a.getVolumeControlStream();
        }
        return AudioAttributesCompat.m2659c(true, getFlags(), getUsage());
    }

    public int hashCode() {
        return this.f3769a.hashCode();
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.f3769a);
        int i = this.f3770b;
        if (i != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i);
        }
        return bundle;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3769a;
    }

    C0841b(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    C0841b(AudioAttributes audioAttributes, int i) {
        this.f3770b = -1;
        this.f3769a = audioAttributes;
        this.f3770b = i;
    }
}
