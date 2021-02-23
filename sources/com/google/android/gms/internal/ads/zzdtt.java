package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzcf;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdtt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdtt> CREATOR = new zzdtw();
    @SafeParcelable.VersionField(mo13017id = 1)

    /* renamed from: a */
    private final int f15960a;
    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", mo13011id = 2, type = "byte[]")

    /* renamed from: b */
    private zzcf.zza f15961b = null;

    /* renamed from: c */
    private byte[] f15962c;

    @SafeParcelable.Constructor
    zzdtt(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) byte[] bArr) {
        this.f15960a = i;
        this.f15962c = bArr;
        m8508a();
    }

    /* renamed from: a */
    private final void m8508a() {
        zzcf.zza zza = this.f15961b;
        if (zza == null && this.f15962c != null) {
            return;
        }
        if (zza != null && this.f15962c == null) {
            return;
        }
        if (zza != null && this.f15962c != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (zza == null && this.f15962c == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f15960a);
        byte[] bArr = this.f15962c;
        if (bArr == null) {
            bArr = this.f15961b.toByteArray();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzcf.zza zzaxr() {
        if (!(this.f15961b != null)) {
            try {
                this.f15961b = zzcf.zza.zza(this.f15962c, zzeju.zzbhf());
                this.f15962c = null;
            } catch (zzeks e) {
                throw new IllegalStateException(e);
            }
        }
        m8508a();
        return this.f15961b;
    }
}
