package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new C0613a();

    /* renamed from: a */
    final int[] f2945a;

    /* renamed from: b */
    final ArrayList<String> f2946b;

    /* renamed from: c */
    final int[] f2947c;

    /* renamed from: d */
    final int[] f2948d;

    /* renamed from: e */
    final int f2949e;

    /* renamed from: f */
    final String f2950f;

    /* renamed from: g */
    final int f2951g;

    /* renamed from: h */
    final int f2952h;

    /* renamed from: i */
    final CharSequence f2953i;

    /* renamed from: j */
    final int f2954j;

    /* renamed from: k */
    final CharSequence f2955k;

    /* renamed from: l */
    final ArrayList<String> f2956l;

    /* renamed from: m */
    final ArrayList<String> f2957m;

    /* renamed from: n */
    final boolean f2958n;

    /* renamed from: androidx.fragment.app.BackStackState$a */
    class C0613a implements Parcelable.Creator<BackStackState> {
        C0613a() {
        }

        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: b */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(C0663a aVar) {
        int size = aVar.f3209c.size();
        this.f2945a = new int[(size * 5)];
        if (aVar.f3215i) {
            this.f2946b = new ArrayList<>(size);
            this.f2947c = new int[size];
            this.f2948d = new int[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                FragmentTransaction.C0657a aVar2 = aVar.f3209c.get(i);
                int i3 = i2 + 1;
                this.f2945a[i2] = aVar2.f3226a;
                ArrayList<String> arrayList = this.f2946b;
                Fragment fragment = aVar2.f3227b;
                arrayList.add(fragment != null ? fragment.f3013f : null);
                int[] iArr = this.f2945a;
                int i4 = i3 + 1;
                iArr[i3] = aVar2.f3228c;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.f3229d;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f3230e;
                iArr[i6] = aVar2.f3231f;
                this.f2947c[i] = aVar2.f3232g.ordinal();
                this.f2948d[i] = aVar2.f3233h.ordinal();
                i++;
                i2 = i6 + 1;
            }
            this.f2949e = aVar.f3214h;
            this.f2950f = aVar.f3217k;
            this.f2951g = aVar.f3258v;
            this.f2952h = aVar.f3218l;
            this.f2953i = aVar.f3219m;
            this.f2954j = aVar.f3220n;
            this.f2955k = aVar.f3221o;
            this.f2956l = aVar.f3222p;
            this.f2957m = aVar.f3223q;
            this.f2958n = aVar.f3224r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    /* renamed from: a */
    public C0663a mo5380a(FragmentManager fragmentManager) {
        C0663a aVar = new C0663a(fragmentManager);
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f2945a;
            if (i < iArr.length) {
                FragmentTransaction.C0657a aVar2 = new FragmentTransaction.C0657a();
                int i3 = i + 1;
                aVar2.f3226a = iArr[i];
                if (FragmentManager.m2230w0(2)) {
                    Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.f2945a[i3]);
                }
                String str = this.f2946b.get(i2);
                if (str != null) {
                    aVar2.f3227b = fragmentManager.mo5748c0(str);
                } else {
                    aVar2.f3227b = null;
                }
                aVar2.f3232g = Lifecycle.State.values()[this.f2947c[i2]];
                aVar2.f3233h = Lifecycle.State.values()[this.f2948d[i2]];
                int[] iArr2 = this.f2945a;
                int i4 = i3 + 1;
                int i5 = iArr2[i3];
                aVar2.f3228c = i5;
                int i6 = i4 + 1;
                int i7 = iArr2[i4];
                aVar2.f3229d = i7;
                int i8 = i6 + 1;
                int i9 = iArr2[i6];
                aVar2.f3230e = i9;
                int i10 = iArr2[i8];
                aVar2.f3231f = i10;
                aVar.f3210d = i5;
                aVar.f3211e = i7;
                aVar.f3212f = i9;
                aVar.f3213g = i10;
                aVar.mo5908c(aVar2);
                i2++;
                i = i8 + 1;
            } else {
                aVar.f3214h = this.f2949e;
                aVar.f3217k = this.f2950f;
                aVar.f3258v = this.f2951g;
                aVar.f3215i = true;
                aVar.f3218l = this.f2952h;
                aVar.f3219m = this.f2953i;
                aVar.f3220n = this.f2954j;
                aVar.f3221o = this.f2955k;
                aVar.f3222p = this.f2956l;
                aVar.f3223q = this.f2957m;
                aVar.f3224r = this.f2958n;
                aVar.mo5978f(1);
                return aVar;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f2945a);
        parcel.writeStringList(this.f2946b);
        parcel.writeIntArray(this.f2947c);
        parcel.writeIntArray(this.f2948d);
        parcel.writeInt(this.f2949e);
        parcel.writeString(this.f2950f);
        parcel.writeInt(this.f2951g);
        parcel.writeInt(this.f2952h);
        TextUtils.writeToParcel(this.f2953i, parcel, 0);
        parcel.writeInt(this.f2954j);
        TextUtils.writeToParcel(this.f2955k, parcel, 0);
        parcel.writeStringList(this.f2956l);
        parcel.writeStringList(this.f2957m);
        parcel.writeInt(this.f2958n ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f2945a = parcel.createIntArray();
        this.f2946b = parcel.createStringArrayList();
        this.f2947c = parcel.createIntArray();
        this.f2948d = parcel.createIntArray();
        this.f2949e = parcel.readInt();
        this.f2950f = parcel.readString();
        this.f2951g = parcel.readInt();
        this.f2952h = parcel.readInt();
        this.f2953i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2954j = parcel.readInt();
        this.f2955k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2956l = parcel.createStringArrayList();
        this.f2957m = parcel.createStringArrayList();
        this.f2958n = parcel.readInt() != 0;
    }
}
