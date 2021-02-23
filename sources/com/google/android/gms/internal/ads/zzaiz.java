package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdapterStatusParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaiz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaiz> CREATOR = new zzaiy();
    @SafeParcelable.Field(mo13011id = 4)
    public final String description;
    @SafeParcelable.Field(mo13011id = 1)
    public final String zzdhn;
    @SafeParcelable.Field(mo13011id = 2)
    public final boolean zzdho;
    @SafeParcelable.Field(mo13011id = 3)
    public final int zzdhp;

    @SafeParcelable.Constructor
    public zzaiz(@SafeParcelable.Param(mo13014id = 1) String str, @SafeParcelable.Param(mo13014id = 2) boolean z, @SafeParcelable.Param(mo13014id = 3) int i, @SafeParcelable.Param(mo13014id = 4) String str2) {
        this.zzdhn = str;
        this.zzdho = z;
        this.zzdhp = i;
        this.description = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdhn, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdho);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdhp);
        SafeParcelWriter.writeString(parcel, 4, this.description, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
