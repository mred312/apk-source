package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdDataParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzvc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvc> CREATOR = new zzvb();
    @SafeParcelable.Field(mo13011id = 1)
    public final String zzcgq;
    @SafeParcelable.Field(mo13011id = 2)
    public final String zzcgr;

    @SafeParcelable.Constructor
    public zzvc(@SafeParcelable.Param(mo13014id = 1) String str, @SafeParcelable.Param(mo13014id = 2) String str2) {
        this.zzcgq = str;
        this.zzcgr = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcgq, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
