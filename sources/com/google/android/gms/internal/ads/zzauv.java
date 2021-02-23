package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzauv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzauv> CREATOR = new zzauu();
    @SafeParcelable.Field(mo13011id = 3)
    public final String zzbum;
    @SafeParcelable.Field(mo13011id = 2)
    public final zzvk zzdsr;

    @SafeParcelable.Constructor
    public zzauv(@SafeParcelable.Param(mo13014id = 2) zzvk zzvk, @SafeParcelable.Param(mo13014id = 3) String str) {
        this.zzdsr = zzvk;
        this.zzbum = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdsr, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbum, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
