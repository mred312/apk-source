package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VideoOptionsParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaak> CREATOR = new zzaan();
    @SafeParcelable.Field(mo13011id = 2)
    public final boolean zzadu;
    @SafeParcelable.Field(mo13011id = 3)
    public final boolean zzadv;
    @SafeParcelable.Field(mo13011id = 4)
    public final boolean zzadw;

    public zzaak(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzadu);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzadv);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzadw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzaak(@SafeParcelable.Param(mo13014id = 2) boolean z, @SafeParcelable.Param(mo13014id = 3) boolean z2, @SafeParcelable.Param(mo13014id = 4) boolean z3) {
        this.zzadu = z;
        this.zzadv = z2;
        this.zzadw = z3;
    }
}
