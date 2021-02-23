package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RequestConfigurationParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaae> CREATOR = new zzaah();
    @SafeParcelable.Field(mo13011id = 1)

    /* renamed from: a */
    private final int f12329a;
    @SafeParcelable.Field(mo13011id = 2)

    /* renamed from: b */
    private final int f12330b;

    @SafeParcelable.Constructor
    public zzaae(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) int i2) {
        this.f12329a = i;
        this.f12330b = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f12329a);
        SafeParcelWriter.writeInt(parcel, 2, this.f12330b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzaae(RequestConfiguration requestConfiguration) {
        this.f12329a = requestConfiguration.getTagForChildDirectedTreatment();
        this.f12330b = requestConfiguration.getTagForUnderAgeOfConsent();
    }
}
