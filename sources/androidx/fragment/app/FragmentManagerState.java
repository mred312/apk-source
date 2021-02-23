package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new C0652a();

    /* renamed from: a */
    ArrayList<FragmentState> f3160a;

    /* renamed from: b */
    ArrayList<String> f3161b;

    /* renamed from: c */
    BackStackState[] f3162c;

    /* renamed from: d */
    int f3163d;

    /* renamed from: e */
    String f3164e = null;

    /* renamed from: f */
    ArrayList<String> f3165f = new ArrayList<>();

    /* renamed from: g */
    ArrayList<Bundle> f3166g = new ArrayList<>();

    /* renamed from: h */
    ArrayList<FragmentManager.LaunchedFragmentInfo> f3167h;

    /* renamed from: androidx.fragment.app.FragmentManagerState$a */
    class C0652a implements Parcelable.Creator<FragmentManagerState> {
        C0652a() {
        }

        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* renamed from: b */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f3160a);
        parcel.writeStringList(this.f3161b);
        parcel.writeTypedArray(this.f3162c, i);
        parcel.writeInt(this.f3163d);
        parcel.writeString(this.f3164e);
        parcel.writeStringList(this.f3165f);
        parcel.writeTypedList(this.f3166g);
        parcel.writeTypedList(this.f3167h);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f3160a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f3161b = parcel.createStringArrayList();
        this.f3162c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f3163d = parcel.readInt();
        this.f3164e = parcel.readString();
        this.f3165f = parcel.createStringArrayList();
        this.f3166g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f3167h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
