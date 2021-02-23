package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassRequestParcelCreator")
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdtr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdtr> CREATOR = new zzdtu();
    @SafeParcelable.VersionField(mo13017id = 1)

    /* renamed from: a */
    private final int f15956a;
    @SafeParcelable.Field(mo13011id = 2)

    /* renamed from: b */
    private final String f15957b;
    @SafeParcelable.Field(mo13011id = 3)

    /* renamed from: c */
    private final String f15958c;

    @SafeParcelable.Constructor
    zzdtr(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) String str, @SafeParcelable.Param(mo13014id = 3) String str2) {
        this.f15956a = i;
        this.f15957b = str;
        this.f15958c = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f15956a);
        SafeParcelWriter.writeString(parcel, 2, this.f15957b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f15958c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzdtr(String str, String str2) {
        this(1, str, str2);
    }
}
