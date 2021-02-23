package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new C1050a();

    /* renamed from: a */
    private final VersionedParcelable f4871a;

    /* renamed from: androidx.versionedparcelable.ParcelImpl$a */
    static class C1050a implements Parcelable.Creator<ParcelImpl> {
        C1050a() {
        }

        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* renamed from: b */
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    }

    public ParcelImpl(VersionedParcelable versionedParcelable) {
        this.f4871a = versionedParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return this.f4871a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        new C1053a(parcel).writeVersionedParcelable(this.f4871a);
    }

    protected ParcelImpl(Parcel parcel) {
        this.f4871a = new C1053a(parcel).readVersionedParcelable();
    }
}
