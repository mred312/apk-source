package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InitializationParamsCreator")
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new zzah();
    @SafeParcelable.Field(mo13011id = 1)
    public final long zza;
    @SafeParcelable.Field(mo13011id = 2)
    public final long zzb;
    @SafeParcelable.Field(mo13011id = 3)
    public final boolean zzc;
    @SafeParcelable.Field(mo13011id = 4)
    public final String zzd;
    @SafeParcelable.Field(mo13011id = 5)
    public final String zze;
    @SafeParcelable.Field(mo13011id = 6)
    public final String zzf;
    @SafeParcelable.Field(mo13011id = 7)
    public final Bundle zzg;

    @SafeParcelable.Constructor
    public zzae(@SafeParcelable.Param(mo13014id = 1) long j, @SafeParcelable.Param(mo13014id = 2) long j2, @SafeParcelable.Param(mo13014id = 3) boolean z, @SafeParcelable.Param(mo13014id = 4) String str, @SafeParcelable.Param(mo13014id = 5) String str2, @SafeParcelable.Param(mo13014id = 6) String str3, @SafeParcelable.Param(mo13014id = 7) Bundle bundle) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = z;
        this.zzd = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
