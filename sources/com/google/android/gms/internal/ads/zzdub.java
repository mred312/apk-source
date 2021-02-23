package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ProgramRequestCreator")
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdub extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdub> CREATOR = new zzdue();
    @SafeParcelable.VersionField(mo13017id = 1)

    /* renamed from: a */
    private final int f15972a;
    @SafeParcelable.Field(mo13011id = 2)

    /* renamed from: b */
    private final int f15973b;
    @SafeParcelable.Field(mo13011id = 3)

    /* renamed from: c */
    private final String f15974c;
    @SafeParcelable.Field(mo13011id = 4)

    /* renamed from: d */
    private final String f15975d;
    @SafeParcelable.Field(mo13011id = 5)

    /* renamed from: e */
    private final int f15976e;

    @SafeParcelable.Constructor
    zzdub(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) int i2, @SafeParcelable.Param(mo13014id = 5) int i3, @SafeParcelable.Param(mo13014id = 3) String str, @SafeParcelable.Param(mo13014id = 4) String str2) {
        this.f15972a = i;
        this.f15973b = i2;
        this.f15974c = str;
        this.f15975d = str2;
        this.f15976e = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f15972a);
        SafeParcelWriter.writeInt(parcel, 2, this.f15973b);
        SafeParcelWriter.writeString(parcel, 3, this.f15974c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f15975d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f15976e);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzdub(int i, zzgn zzgn, String str, String str2) {
        this(1, i, zzgn.zzv(), str, str2);
    }
}
