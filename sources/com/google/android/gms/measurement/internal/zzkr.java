package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzkr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkr> CREATOR = new zzku();
    @SafeParcelable.Field(mo13011id = 1)

    /* renamed from: a */
    private final int f18723a;
    @SafeParcelable.Field(mo13011id = 2)
    public final String zza;
    @SafeParcelable.Field(mo13011id = 3)
    public final long zzb;
    @SafeParcelable.Field(mo13011id = 4)
    public final Long zzc;
    @SafeParcelable.Field(mo13011id = 6)
    public final String zzd;
    @SafeParcelable.Field(mo13011id = 7)
    public final String zze;
    @SafeParcelable.Field(mo13011id = 8)
    public final Double zzf;

    zzkr(C3134v7 v7Var) {
        this(v7Var.f18417c, v7Var.f18418d, v7Var.f18419e, v7Var.f18416b);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f18723a);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, (Float) null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 7, this.zze, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Object zza() {
        Long l = this.zzc;
        if (l != null) {
            return l;
        }
        Double d = this.zzf;
        if (d != null) {
            return d;
        }
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        return null;
    }

    zzkr(String str, long j, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.f18723a = 2;
        this.zza = str;
        this.zzb = j;
        this.zze = str2;
        if (obj == null) {
            this.zzc = null;
            this.zzf = null;
            this.zzd = null;
        } else if (obj instanceof Long) {
            this.zzc = (Long) obj;
            this.zzf = null;
            this.zzd = null;
        } else if (obj instanceof String) {
            this.zzc = null;
            this.zzf = null;
            this.zzd = (String) obj;
        } else if (obj instanceof Double) {
            this.zzc = null;
            this.zzf = (Double) obj;
            this.zzd = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    @SafeParcelable.Constructor
    zzkr(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) String str, @SafeParcelable.Param(mo13014id = 3) long j, @SafeParcelable.Param(mo13014id = 4) Long l, @SafeParcelable.Param(mo13014id = 5) Float f, @SafeParcelable.Param(mo13014id = 6) String str2, @SafeParcelable.Param(mo13014id = 7) String str3, @SafeParcelable.Param(mo13014id = 8) Double d) {
        this.f18723a = i;
        this.zza = str;
        this.zzb = j;
        this.zzc = l;
        if (i == 1) {
            this.zzf = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.zzf = d;
        }
        this.zzd = str2;
        this.zze = str3;
    }
}
