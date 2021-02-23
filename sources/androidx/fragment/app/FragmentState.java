package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new C0653a();

    /* renamed from: a */
    final String f3173a;

    /* renamed from: b */
    final String f3174b;

    /* renamed from: c */
    final boolean f3175c;

    /* renamed from: d */
    final int f3176d;

    /* renamed from: e */
    final int f3177e;

    /* renamed from: f */
    final String f3178f;

    /* renamed from: g */
    final boolean f3179g;

    /* renamed from: h */
    final boolean f3180h;

    /* renamed from: i */
    final boolean f3181i;

    /* renamed from: j */
    final Bundle f3182j;

    /* renamed from: k */
    final boolean f3183k;

    /* renamed from: l */
    final int f3184l;

    /* renamed from: m */
    Bundle f3185m;

    /* renamed from: androidx.fragment.app.FragmentState$a */
    class C0653a implements Parcelable.Creator<FragmentState> {
        C0653a() {
        }

        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: b */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    FragmentState(Fragment fragment) {
        this.f3173a = fragment.getClass().getName();
        this.f3174b = fragment.f3013f;
        this.f3175c = fragment.f3021n;
        this.f3176d = fragment.f3030w;
        this.f3177e = fragment.f3031x;
        this.f3178f = fragment.f3032y;
        this.f3179g = fragment.f2983B;
        this.f3180h = fragment.f3020m;
        this.f3181i = fragment.f2982A;
        this.f3182j = fragment.f3014g;
        this.f3183k = fragment.f3033z;
        this.f3184l = fragment.f2999R.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3173a);
        sb.append(" (");
        sb.append(this.f3174b);
        sb.append(")}:");
        if (this.f3175c) {
            sb.append(" fromLayout");
        }
        if (this.f3177e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3177e));
        }
        String str = this.f3178f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f3178f);
        }
        if (this.f3179g) {
            sb.append(" retainInstance");
        }
        if (this.f3180h) {
            sb.append(" removing");
        }
        if (this.f3181i) {
            sb.append(" detached");
        }
        if (this.f3183k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3173a);
        parcel.writeString(this.f3174b);
        parcel.writeInt(this.f3175c ? 1 : 0);
        parcel.writeInt(this.f3176d);
        parcel.writeInt(this.f3177e);
        parcel.writeString(this.f3178f);
        parcel.writeInt(this.f3179g ? 1 : 0);
        parcel.writeInt(this.f3180h ? 1 : 0);
        parcel.writeInt(this.f3181i ? 1 : 0);
        parcel.writeBundle(this.f3182j);
        parcel.writeInt(this.f3183k ? 1 : 0);
        parcel.writeBundle(this.f3185m);
        parcel.writeInt(this.f3184l);
    }

    FragmentState(Parcel parcel) {
        this.f3173a = parcel.readString();
        this.f3174b = parcel.readString();
        boolean z = true;
        this.f3175c = parcel.readInt() != 0;
        this.f3176d = parcel.readInt();
        this.f3177e = parcel.readInt();
        this.f3178f = parcel.readString();
        this.f3179g = parcel.readInt() != 0;
        this.f3180h = parcel.readInt() != 0;
        this.f3181i = parcel.readInt() != 0;
        this.f3182j = parcel.readBundle();
        this.f3183k = parcel.readInt() == 0 ? false : z;
        this.f3185m = parcel.readBundle();
        this.f3184l = parcel.readInt();
    }
}
