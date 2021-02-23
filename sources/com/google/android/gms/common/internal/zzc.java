package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConnectionInfoCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();
    @SafeParcelable.Field(mo13011id = 1)

    /* renamed from: a */
    Bundle f7573a;
    @SafeParcelable.Field(mo13011id = 2)

    /* renamed from: b */
    Feature[] f7574b;
    @SafeParcelable.Field(defaultValue = "0", mo13011id = 3)

    /* renamed from: c */
    private int f7575c;

    @SafeParcelable.Constructor
    zzc(@SafeParcelable.Param(mo13014id = 1) Bundle bundle, @SafeParcelable.Param(mo13014id = 2) Feature[] featureArr, @SafeParcelable.Param(mo13014id = 3) int i) {
        this.f7573a = bundle;
        this.f7574b = featureArr;
        this.f7575c = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.f7573a, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.f7574b, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f7575c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzc() {
    }
}
