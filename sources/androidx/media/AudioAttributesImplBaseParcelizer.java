package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplBaseParcelizer {
    public static C0842c read(VersionedParcel versionedParcel) {
        C0842c cVar = new C0842c();
        cVar.f3771a = versionedParcel.readInt(cVar.f3771a, 1);
        cVar.f3772b = versionedParcel.readInt(cVar.f3772b, 2);
        cVar.f3773c = versionedParcel.readInt(cVar.f3773c, 3);
        cVar.f3774d = versionedParcel.readInt(cVar.f3774d, 4);
        return cVar;
    }

    public static void write(C0842c cVar, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(cVar.f3771a, 1);
        versionedParcel.writeInt(cVar.f3772b, 2);
        versionedParcel.writeInt(cVar.f3773c, 3);
        versionedParcel.writeInt(cVar.f3774d, 4);
    }
}
