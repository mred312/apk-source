package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassEventParcelCreator")
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdtq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdtq> CREATOR = new zzdtp();
    @SafeParcelable.VersionField(mo13017id = 1)

    /* renamed from: a */
    private final int f15954a;
    @SafeParcelable.Field(mo13011id = 2)

    /* renamed from: b */
    private final byte[] f15955b;

    @SafeParcelable.Constructor
    zzdtq(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) byte[] bArr) {
        this.f15954a = i;
        this.f15955b = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f15954a);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f15955b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzdtq(byte[] bArr) {
        this(1, bArr);
    }
}
