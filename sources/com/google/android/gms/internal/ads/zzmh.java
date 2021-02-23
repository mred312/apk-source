package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzmh extends zzmk {
    public static final Parcelable.Creator<zzmh> CREATOR = new uf0();

    /* renamed from: a */
    private final String f16726a;

    /* renamed from: b */
    private final String f16727b;

    /* renamed from: c */
    private final int f16728c;

    /* renamed from: d */
    private final byte[] f16729d;

    public zzmh(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.f16726a = str;
        this.f16727b = null;
        this.f16728c = 3;
        this.f16729d = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmh.class == obj.getClass()) {
            zzmh zzmh = (zzmh) obj;
            return this.f16728c == zzmh.f16728c && zzpt.zza(this.f16726a, zzmh.f16726a) && zzpt.zza(this.f16727b, zzmh.f16727b) && Arrays.equals(this.f16729d, zzmh.f16729d);
        }
    }

    public final int hashCode() {
        int i = (this.f16728c + 527) * 31;
        String str = this.f16726a;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f16727b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.hashCode(this.f16729d);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16726a);
        parcel.writeString(this.f16727b);
        parcel.writeInt(this.f16728c);
        parcel.writeByteArray(this.f16729d);
    }

    zzmh(Parcel parcel) {
        super("APIC");
        this.f16726a = parcel.readString();
        this.f16727b = parcel.readString();
        this.f16728c = parcel.readInt();
        this.f16729d = parcel.createByteArray();
    }
}
