package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdErrorParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzve extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzve> CREATOR = new zzvd();
    @SafeParcelable.Field(mo13011id = 1)
    public final int errorCode;
    @SafeParcelable.Field(mo13011id = 2)
    public final String zzcgs;
    @SafeParcelable.Field(mo13011id = 3)
    public final String zzcgt;
    @SafeParcelable.Field(mo13011id = 4)
    @Nullable
    public zzve zzcgu;
    @SafeParcelable.Field(mo13011id = 5, type = "android.os.IBinder")
    @Nullable
    public IBinder zzcgv;

    @SafeParcelable.Constructor
    public zzve(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) String str, @SafeParcelable.Param(mo13014id = 3) String str2, @SafeParcelable.Param(mo13014id = 4) @Nullable zzve zzve, @SafeParcelable.Param(mo13014id = 5) @Nullable IBinder iBinder) {
        this.errorCode = i;
        this.zzcgs = str;
        this.zzcgt = str2;
        this.zzcgu = zzve;
        this.zzcgv = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.errorCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgs, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcgt, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzcgu, i, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzcgv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdError zzpl() {
        zzve zzve = this.zzcgu;
        return new AdError(this.errorCode, this.zzcgs, this.zzcgt, zzve == null ? null : new AdError(zzve.errorCode, zzve.zzcgs, zzve.zzcgt));
    }

    public final LoadAdError zzpm() {
        zzve zzve = this.zzcgu;
        zzyn zzyn = null;
        AdError adError = zzve == null ? null : new AdError(zzve.errorCode, zzve.zzcgs, zzve.zzcgt);
        int i = this.errorCode;
        String str = this.zzcgs;
        String str2 = this.zzcgt;
        IBinder iBinder = this.zzcgv;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            if (queryLocalInterface instanceof zzyn) {
                zzyn = (zzyn) queryLocalInterface;
            } else {
                zzyn = new zzyp(iBinder);
            }
        }
        return new LoadAdError(i, str, str2, adError, ResponseInfo.zza(zzyn));
    }
}
