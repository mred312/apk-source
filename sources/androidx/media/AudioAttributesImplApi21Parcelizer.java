package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplApi21Parcelizer {
    public static C0841b read(VersionedParcel versionedParcel) {
        C0841b bVar = new C0841b();
        bVar.f3769a = (AudioAttributes) versionedParcel.readParcelable(bVar.f3769a, 1);
        bVar.f3770b = versionedParcel.readInt(bVar.f3770b, 2);
        return bVar;
    }

    public static void write(C0841b bVar, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeParcelable(bVar.f3769a, 1);
        versionedParcel.writeInt(bVar.f3770b, 2);
    }
}
