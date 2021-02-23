package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StringParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzatn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatn> CREATOR = new zzatm();
    @SafeParcelable.Field(mo13011id = 2)

    /* renamed from: a */
    String f12806a;

    @SafeParcelable.Constructor
    public zzatn(@SafeParcelable.Param(mo13014id = 2) String str) {
        this.f12806a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f12806a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
