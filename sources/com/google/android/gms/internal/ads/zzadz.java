package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzadz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzadz> CREATOR = new zzady();
    @SafeParcelable.Field(mo13011id = 1)
    public final int versionCode;
    @SafeParcelable.Field(mo13011id = 3)
    public final int zzbnm;
    @SafeParcelable.Field(mo13011id = 8)
    public final int zzbnn;
    @SafeParcelable.Field(mo13011id = 4)
    public final boolean zzbno;
    @SafeParcelable.Field(mo13011id = 5)
    public final int zzbnp;
    @SafeParcelable.Field(mo13011id = 7)
    public final boolean zzbnr;
    @SafeParcelable.Field(mo13011id = 2)
    public final boolean zzdeo;
    @SafeParcelable.Field(mo13011id = 6)
    @Nullable
    public final zzaak zzdep;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzadz(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzaak(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjs(), nativeAdOptions.getMediaAspectRatio());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdeo);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbnm);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbno);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbnp);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdep, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbnr);
        SafeParcelWriter.writeInt(parcel, 8, this.zzbnn);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzadz(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) boolean z, @SafeParcelable.Param(mo13014id = 3) int i2, @SafeParcelable.Param(mo13014id = 4) boolean z2, @SafeParcelable.Param(mo13014id = 5) int i3, @SafeParcelable.Param(mo13014id = 6) zzaak zzaak, @SafeParcelable.Param(mo13014id = 7) boolean z3, @SafeParcelable.Param(mo13014id = 8) int i4) {
        this.versionCode = i;
        this.zzdeo = z;
        this.zzbnm = i2;
        this.zzbno = z2;
        this.zzbnp = i3;
        this.zzdep = zzaak;
        this.zzbnr = z3;
        this.zzbnn = i4;
    }
}
