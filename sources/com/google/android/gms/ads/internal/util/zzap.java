package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzdoi;
import com.google.android.gms.internal.ads.zzdwc;
import com.google.android.gms.internal.ads.zzve;

@SafeParcelable.Class(creator = "ExceptionParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new zzar();
    @SafeParcelable.Field(mo13011id = 2)
    public final int errorCode;
    @SafeParcelable.Field(mo13011id = 1)
    public final String zzacm;

    @SafeParcelable.Constructor
    zzap(@SafeParcelable.Param(mo13014id = 1) @Nullable String str, @SafeParcelable.Param(mo13014id = 2) int i) {
        this.zzacm = str == null ? "" : str;
        this.errorCode = i;
    }

    @Nullable
    public static zzap zzc(Throwable th) {
        String str;
        zzve zzh = zzdoi.zzh(th);
        if (zzdwc.zzar(th.getMessage())) {
            str = zzh.zzcgs;
        } else {
            str = th.getMessage();
        }
        return new zzap(str, zzh.errorCode);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzacm, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
