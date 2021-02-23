package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new C0589a();
    public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {
    };

    /* renamed from: a */
    private final Parcelable f2841a;

    /* renamed from: androidx.customview.view.AbsSavedState$a */
    static class C0589a implements Parcelable.ClassLoaderCreator<AbsSavedState> {
        C0589a() {
        }

        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        /* renamed from: b */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: c */
        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Parcelable getSuperState() {
        return this.f2841a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2841a, i);
    }

    private AbsSavedState() {
        this.f2841a = null;
    }

    protected AbsSavedState(@NonNull Parcelable parcelable) {
        if (parcelable != null) {
            this.f2841a = parcelable == EMPTY_STATE ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbsSavedState(@NonNull Parcel parcel) {
        this(parcel, (ClassLoader) null);
    }

    protected AbsSavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f2841a = readParcelable == null ? EMPTY_STATE : readParcelable;
    }
}
