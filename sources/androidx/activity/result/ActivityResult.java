package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = new C0122a();

    /* renamed from: a */
    private final int f305a;
    @Nullable

    /* renamed from: b */
    private final Intent f306b;

    /* renamed from: androidx.activity.result.ActivityResult$a */
    class C0122a implements Parcelable.Creator<ActivityResult> {
        C0122a() {
        }

        /* renamed from: a */
        public ActivityResult createFromParcel(@NonNull Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* renamed from: b */
        public ActivityResult[] newArray(int i) {
            return new ActivityResult[i];
        }
    }

    public ActivityResult(int i, @Nullable Intent intent) {
        this.f305a = i;
        this.f306b = intent;
    }

    @NonNull
    public static String resultCodeToString(int i) {
        if (i != -1) {
            return i != 0 ? String.valueOf(i) : "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getData() {
        return this.f306b;
    }

    public int getResultCode() {
        return this.f305a;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.f305a) + ", data=" + this.f306b + '}';
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.f305a);
        parcel.writeInt(this.f306b == null ? 0 : 1);
        Intent intent = this.f306b;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }

    ActivityResult(Parcel parcel) {
        this.f305a = parcel.readInt();
        this.f306b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
