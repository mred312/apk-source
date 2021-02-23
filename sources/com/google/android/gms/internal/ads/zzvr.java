package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdapterResponseInfoParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzvr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvr> CREATOR = new zzvu();
    @SafeParcelable.Field(mo13011id = 1)
    public String zzchy;
    @SafeParcelable.Field(mo13011id = 2)
    public long zzchz;
    @SafeParcelable.Field(mo13011id = 3)
    @Nullable
    public zzve zzcia;
    @SafeParcelable.Field(mo13011id = 4)
    public Bundle zzcib;

    @SafeParcelable.Constructor
    public zzvr(@SafeParcelable.Param(mo13014id = 1) String str, @SafeParcelable.Param(mo13014id = 2) long j, @SafeParcelable.Param(mo13014id = 3) @Nullable zzve zzve, @SafeParcelable.Param(mo13014id = 4) Bundle bundle) {
        this.zzchy = str;
        this.zzchz = j;
        this.zzcia = zzve;
        this.zzcib = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzchy, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzchz);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzcia, i, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzcib, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
