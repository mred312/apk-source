package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzmd implements Parcelable {
    public static final Parcelable.Creator<zzmd> CREATOR = new tf0();

    /* renamed from: a */
    private final zza[] f16725a;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public interface zza extends Parcelable {
    }

    public zzmd(List<? extends zza> list) {
        zza[] zzaArr = new zza[list.size()];
        this.f16725a = zzaArr;
        list.toArray(zzaArr);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzmd.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f16725a, ((zzmd) obj).f16725a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f16725a);
    }

    public final int length() {
        return this.f16725a.length;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f16725a.length);
        for (zza writeParcelable : this.f16725a) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public final zza zzay(int i) {
        return this.f16725a[i];
    }

    zzmd(Parcel parcel) {
        this.f16725a = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaArr = this.f16725a;
            if (i < zzaArr.length) {
                zzaArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }
}
