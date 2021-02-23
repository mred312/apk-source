package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzz();
    @SafeParcelable.Field(mo13011id = 2)
    public String zza;
    @SafeParcelable.Field(mo13011id = 3)
    public String zzb;
    @SafeParcelable.Field(mo13011id = 4)
    public zzkr zzc;
    @SafeParcelable.Field(mo13011id = 5)
    public long zzd;
    @SafeParcelable.Field(mo13011id = 6)
    public boolean zze;
    @SafeParcelable.Field(mo13011id = 7)
    public String zzf;
    @SafeParcelable.Field(mo13011id = 8)
    public zzar zzg;
    @SafeParcelable.Field(mo13011id = 9)
    public long zzh;
    @SafeParcelable.Field(mo13011id = 10)
    public zzar zzi;
    @SafeParcelable.Field(mo13011id = 11)
    public long zzj;
    @SafeParcelable.Field(mo13011id = 12)
    public zzar zzk;

    zzw(zzw zzw) {
        Preconditions.checkNotNull(zzw);
        this.zza = zzw.zza;
        this.zzb = zzw.zzb;
        this.zzc = zzw.zzc;
        this.zzd = zzw.zzd;
        this.zze = zzw.zze;
        this.zzf = zzw.zzf;
        this.zzg = zzw.zzg;
        this.zzh = zzw.zzh;
        this.zzi = zzw.zzi;
        this.zzj = zzw.zzj;
        this.zzk = zzw.zzk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzw(@SafeParcelable.Param(mo13014id = 2) String str, @SafeParcelable.Param(mo13014id = 3) String str2, @SafeParcelable.Param(mo13014id = 4) zzkr zzkr, @SafeParcelable.Param(mo13014id = 5) long j, @SafeParcelable.Param(mo13014id = 6) boolean z, @SafeParcelable.Param(mo13014id = 7) String str3, @SafeParcelable.Param(mo13014id = 8) zzar zzar, @SafeParcelable.Param(mo13014id = 9) long j2, @SafeParcelable.Param(mo13014id = 10) zzar zzar2, @SafeParcelable.Param(mo13014id = 11) long j3, @SafeParcelable.Param(mo13014id = 12) zzar zzar3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzkr;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzar;
        this.zzh = j2;
        this.zzi = zzar2;
        this.zzj = j3;
        this.zzk = zzar3;
    }
}
