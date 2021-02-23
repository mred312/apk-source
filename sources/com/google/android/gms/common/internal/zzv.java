package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ValidateAccountRequestCreator")
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzu();
    @SafeParcelable.VersionField(mo13017id = 1)

    /* renamed from: a */
    private final int f7584a;

    @SafeParcelable.Constructor
    zzv(@SafeParcelable.Param(mo13014id = 1) int i) {
        this.f7584a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7584a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
