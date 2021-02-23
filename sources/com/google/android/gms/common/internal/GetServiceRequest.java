package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();
    @SafeParcelable.VersionField(mo13017id = 1)

    /* renamed from: a */
    private final int f7528a;
    @SafeParcelable.Field(mo13011id = 2)

    /* renamed from: b */
    private final int f7529b;
    @SafeParcelable.Field(mo13011id = 3)

    /* renamed from: c */
    private int f7530c;
    @SafeParcelable.Field(mo13011id = 4)

    /* renamed from: d */
    String f7531d;
    @SafeParcelable.Field(mo13011id = 5)

    /* renamed from: e */
    IBinder f7532e;
    @SafeParcelable.Field(mo13011id = 6)

    /* renamed from: f */
    Scope[] f7533f;
    @SafeParcelable.Field(mo13011id = 7)

    /* renamed from: g */
    Bundle f7534g;
    @SafeParcelable.Field(mo13011id = 8)

    /* renamed from: h */
    Account f7535h;
    @SafeParcelable.Field(mo13011id = 10)

    /* renamed from: i */
    Feature[] f7536i;
    @SafeParcelable.Field(mo13011id = 11)

    /* renamed from: j */
    Feature[] f7537j;
    @SafeParcelable.Field(mo13011id = 12)

    /* renamed from: k */
    private boolean f7538k;
    @SafeParcelable.Field(defaultValue = "0", mo13011id = 13)

    /* renamed from: l */
    private int f7539l;

    public GetServiceRequest(int i) {
        this.f7528a = 4;
        this.f7530c = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.f7529b = i;
        this.f7538k = true;
    }

    @KeepForSdk
    public Bundle getExtraArgs() {
        return this.f7534g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7528a);
        SafeParcelWriter.writeInt(parcel, 2, this.f7529b);
        SafeParcelWriter.writeInt(parcel, 3, this.f7530c);
        SafeParcelWriter.writeString(parcel, 4, this.f7531d, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.f7532e, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.f7533f, i, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.f7534g, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.f7535h, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 10, this.f7536i, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, this.f7537j, i, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.f7538k);
        SafeParcelWriter.writeInt(parcel, 13, this.f7539l);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    GetServiceRequest(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) int i2, @SafeParcelable.Param(mo13014id = 3) int i3, @SafeParcelable.Param(mo13014id = 4) String str, @SafeParcelable.Param(mo13014id = 5) IBinder iBinder, @SafeParcelable.Param(mo13014id = 6) Scope[] scopeArr, @SafeParcelable.Param(mo13014id = 7) Bundle bundle, @SafeParcelable.Param(mo13014id = 8) Account account, @SafeParcelable.Param(mo13014id = 10) Feature[] featureArr, @SafeParcelable.Param(mo13014id = 11) Feature[] featureArr2, @SafeParcelable.Param(mo13014id = 12) boolean z, @SafeParcelable.Param(mo13014id = 13) int i4) {
        this.f7528a = i;
        this.f7529b = i2;
        this.f7530c = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f7531d = "com.google.android.gms";
        } else {
            this.f7531d = str;
        }
        if (i < 2) {
            this.f7535h = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.f7532e = iBinder;
            this.f7535h = account;
        }
        this.f7533f = scopeArr;
        this.f7534g = bundle;
        this.f7536i = featureArr;
        this.f7537j = featureArr2;
        this.f7538k = z;
        this.f7539l = i4;
    }
}
