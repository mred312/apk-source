package androidx.media;

import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;

    /* renamed from: a */
    private final int f3757a;

    /* renamed from: b */
    private final int f3758b;

    /* renamed from: c */
    private int f3759c;

    /* renamed from: d */
    private Callback f3760d;

    /* renamed from: e */
    private Object f3761e;

    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    /* renamed from: androidx.media.VolumeProviderCompat$a */
    class C0838a implements VolumeProviderCompatApi21.Delegate {
        C0838a() {
        }

        public void onAdjustVolume(int i) {
            VolumeProviderCompat.this.onAdjustVolume(i);
        }

        public void onSetVolumeTo(int i) {
            VolumeProviderCompat.this.onSetVolumeTo(i);
        }
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this.f3757a = i;
        this.f3758b = i2;
        this.f3759c = i3;
    }

    public final int getCurrentVolume() {
        return this.f3759c;
    }

    public final int getMaxVolume() {
        return this.f3758b;
    }

    public final int getVolumeControl() {
        return this.f3757a;
    }

    public Object getVolumeProvider() {
        if (this.f3761e == null && Build.VERSION.SDK_INT >= 21) {
            this.f3761e = VolumeProviderCompatApi21.m2761a(this.f3757a, this.f3758b, this.f3759c, new C0838a());
        }
        return this.f3761e;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(Callback callback) {
        this.f3760d = callback;
    }

    public final void setCurrentVolume(int i) {
        this.f3759c = i;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null && Build.VERSION.SDK_INT >= 21) {
            VolumeProviderCompatApi21.m2762b(volumeProvider, i);
        }
        Callback callback = this.f3760d;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }
}
