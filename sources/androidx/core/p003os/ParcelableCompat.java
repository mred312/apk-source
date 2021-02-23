package androidx.core.p003os;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* renamed from: androidx.core.os.ParcelableCompat */
public final class ParcelableCompat {

    /* renamed from: androidx.core.os.ParcelableCompat$a */
    static class C0484a<T> implements Parcelable.ClassLoaderCreator<T> {

        /* renamed from: a */
        private final ParcelableCompatCreatorCallbacks<T> f2424a;

        C0484a(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            this.f2424a = parcelableCompatCreatorCallbacks;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f2424a.createFromParcel(parcel, (ClassLoader) null);
        }

        public T[] newArray(int i) {
            return this.f2424a.newArray(i);
        }

        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f2424a.createFromParcel(parcel, classLoader);
        }
    }

    private ParcelableCompat() {
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new C0484a(parcelableCompatCreatorCallbacks);
    }
}
