package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "ProgramResponseCreator")
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdud extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdud> CREATOR = new zzdug();
    @SafeParcelable.VersionField(mo13017id = 1)

    /* renamed from: a */
    private final int f15977a;
    @SafeParcelable.Field(mo13011id = 3)
    public final int status;
    @SafeParcelable.Field(mo13011id = 2)
    public final byte[] zzhrt;

    @SafeParcelable.Constructor
    zzdud(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) byte[] bArr, @SafeParcelable.Param(mo13014id = 3) int i2) {
        byte[] bArr2;
        this.f15977a = i;
        if (bArr == null) {
            bArr2 = null;
        } else {
            bArr2 = Arrays.copyOf(bArr, bArr.length);
        }
        this.zzhrt = bArr2;
        this.status = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f15977a);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzhrt, false);
        SafeParcelWriter.writeInt(parcel, 3, this.status);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzdud(byte[] bArr, int i) {
        this(1, (byte[]) null, 1);
    }
}
