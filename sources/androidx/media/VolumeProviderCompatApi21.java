package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    /* renamed from: androidx.media.VolumeProviderCompatApi21$a */
    static class C0839a extends VolumeProvider {

        /* renamed from: a */
        final /* synthetic */ Delegate f3763a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0839a(int i, int i2, int i3, Delegate delegate) {
            super(i, i2, i3);
            this.f3763a = delegate;
        }

        public void onAdjustVolume(int i) {
            this.f3763a.onAdjustVolume(i);
        }

        public void onSetVolumeTo(int i) {
            this.f3763a.onSetVolumeTo(i);
        }
    }

    /* renamed from: a */
    public static Object m2761a(int i, int i2, int i3, Delegate delegate) {
        return new C0839a(i, i2, i3, delegate);
    }

    /* renamed from: b */
    public static void m2762b(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }
}
