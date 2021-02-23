package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzmn extends zzmk {
    public static final Parcelable.Creator<zzmn> CREATOR = new wf0();

    /* renamed from: a */
    private final String f16732a;

    /* renamed from: b */
    private final String f16733b;

    public zzmn(String str, String str2, String str3) {
        super(str);
        this.f16732a = null;
        this.f16733b = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmn.class == obj.getClass()) {
            zzmn zzmn = (zzmn) obj;
            return this.f16731id.equals(zzmn.f16731id) && zzpt.zza(this.f16732a, zzmn.f16732a) && zzpt.zza(this.f16733b, zzmn.f16733b);
        }
    }

    public final int hashCode() {
        int hashCode = (this.f16731id.hashCode() + 527) * 31;
        String str = this.f16732a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f16733b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16731id);
        parcel.writeString(this.f16732a);
        parcel.writeString(this.f16733b);
    }

    zzmn(Parcel parcel) {
        super(parcel.readString());
        this.f16732a = parcel.readString();
        this.f16733b = parcel.readString();
    }
}
