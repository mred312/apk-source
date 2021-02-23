package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaxw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaxw> CREATOR = new zzaxz();
    @SafeParcelable.Field(mo13011id = 2)
    public final String zzbrc;
    @SafeParcelable.Field(mo13011id = 1)
    @Deprecated
    public final String zzbum;
    @SafeParcelable.Field(mo13011id = 3)
    @Deprecated
    public final zzvn zzead;
    @SafeParcelable.Field(mo13011id = 4)
    public final zzvk zzeae;

    @SafeParcelable.Constructor
    public zzaxw(@SafeParcelable.Param(mo13014id = 1) String str, @SafeParcelable.Param(mo13014id = 2) String str2, @SafeParcelable.Param(mo13014id = 3) zzvn zzvn, @SafeParcelable.Param(mo13014id = 4) zzvk zzvk) {
        this.zzbum = str;
        this.zzbrc = str2;
        this.zzead = zzvn;
        this.zzeae = zzvk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbum, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbrc, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzead, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzeae, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
