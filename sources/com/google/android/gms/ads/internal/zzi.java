package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzh();
    @SafeParcelable.Field(mo13011id = 2)
    public final boolean zzbou;
    @SafeParcelable.Field(mo13011id = 3)
    public final boolean zzbov;
    @SafeParcelable.Field(mo13011id = 4)
    private final String zzbow;
    @SafeParcelable.Field(mo13011id = 5)
    public final boolean zzbox;
    @SafeParcelable.Field(mo13011id = 6)
    public final float zzboy;
    @SafeParcelable.Field(mo13011id = 7)
    public final int zzboz;
    @SafeParcelable.Field(mo13011id = 8)
    public final boolean zzbpa;
    @SafeParcelable.Field(mo13011id = 9)
    public final boolean zzbpb;
    @SafeParcelable.Field(mo13011id = 10)
    public final boolean zzbpc;

    public zzi(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, (String) null, false, 0.0f, -1, z4, z5, z6);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbou);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbov);
        SafeParcelWriter.writeString(parcel, 4, this.zzbow, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbox);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzboy);
        SafeParcelWriter.writeInt(parcel, 7, this.zzboz);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbpa);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbpb);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzbpc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzi(@SafeParcelable.Param(mo13014id = 2) boolean z, @SafeParcelable.Param(mo13014id = 3) boolean z2, @SafeParcelable.Param(mo13014id = 4) String str, @SafeParcelable.Param(mo13014id = 5) boolean z3, @SafeParcelable.Param(mo13014id = 6) float f, @SafeParcelable.Param(mo13014id = 7) int i, @SafeParcelable.Param(mo13014id = 8) boolean z4, @SafeParcelable.Param(mo13014id = 9) boolean z5, @SafeParcelable.Param(mo13014id = 10) boolean z6) {
        this.zzbou = z;
        this.zzbov = z2;
        this.zzbow = str;
        this.zzbox = z3;
        this.zzboy = f;
        this.zzboz = i;
        this.zzbpa = z4;
        this.zzbpb = z5;
        this.zzbpc = z6;
    }
}
