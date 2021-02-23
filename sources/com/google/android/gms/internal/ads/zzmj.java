package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzmj extends zzmk {
    public static final Parcelable.Creator<zzmj> CREATOR = new vf0();

    /* renamed from: a */
    private final String f16730a;
    public final String description;
    public final String text;

    public zzmj(String str, String str2, String str3) {
        super("COMM");
        this.f16730a = str;
        this.description = str2;
        this.text = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmj.class == obj.getClass()) {
            zzmj zzmj = (zzmj) obj;
            return zzpt.zza(this.description, zzmj.description) && zzpt.zza(this.f16730a, zzmj.f16730a) && zzpt.zza(this.text, zzmj.text);
        }
    }

    public final int hashCode() {
        String str = this.f16730a;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16731id);
        parcel.writeString(this.f16730a);
        parcel.writeString(this.text);
    }

    zzmj(Parcel parcel) {
        super("COMM");
        this.f16730a = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
    }
}
