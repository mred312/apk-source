package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzatl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatl> CREATOR = new zzatk();
    @SafeParcelable.Field(mo13011id = 3)
    public final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(mo13011id = 4)
    public final String packageName;
    @SafeParcelable.Field(mo13011id = 2)
    public final zzazh zzdsm;
    @SafeParcelable.Field(mo13011id = 6)
    @Nullable
    public final PackageInfo zzdss;
    @SafeParcelable.Field(mo13011id = 5)
    public final List<String> zzdtc;
    @SafeParcelable.Field(mo13011id = 7)
    public final String zzdtm;
    @SafeParcelable.Field(mo13011id = 1)
    public final Bundle zzdvx;
    @SafeParcelable.Field(mo13011id = 8)
    public final boolean zzdvy;
    @SafeParcelable.Field(mo13011id = 9)
    public final String zzdvz;
    @SafeParcelable.Field(mo13011id = 10)
    @Nullable
    public zzdpk zzdwa;
    @SafeParcelable.Field(mo13011id = 11)
    @Nullable
    public String zzdwb;

    @SafeParcelable.Constructor
    public zzatl(@SafeParcelable.Param(mo13014id = 1) Bundle bundle, @SafeParcelable.Param(mo13014id = 2) zzazh zzazh, @SafeParcelable.Param(mo13014id = 3) ApplicationInfo applicationInfo2, @SafeParcelable.Param(mo13014id = 4) String str, @SafeParcelable.Param(mo13014id = 5) List<String> list, @SafeParcelable.Param(mo13014id = 6) @Nullable PackageInfo packageInfo, @SafeParcelable.Param(mo13014id = 7) String str2, @SafeParcelable.Param(mo13014id = 8) boolean z, @SafeParcelable.Param(mo13014id = 9) String str3, @SafeParcelable.Param(mo13014id = 10) zzdpk zzdpk, @SafeParcelable.Param(mo13014id = 11) String str4) {
        this.zzdvx = bundle;
        this.zzdsm = zzazh;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzdtc = list;
        this.zzdss = packageInfo;
        this.zzdtm = str2;
        this.zzdvy = z;
        this.zzdvz = str3;
        this.zzdwa = zzdpk;
        this.zzdwb = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdvx, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdsm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdtc, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdss, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdtm, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdvy);
        SafeParcelWriter.writeString(parcel, 9, this.zzdvz, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzdwa, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzdwb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
