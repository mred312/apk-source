package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "RtbVersionInfoParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaqc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaqc> CREATOR = new zzaqf();
    @SafeParcelable.Field(mo13011id = 1)

    /* renamed from: a */
    private final int f12601a;
    @SafeParcelable.Field(mo13011id = 2)

    /* renamed from: b */
    private final int f12602b;
    @SafeParcelable.Field(mo13011id = 3)

    /* renamed from: c */
    private final int f12603c;

    @SafeParcelable.Constructor
    zzaqc(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) int i2, @SafeParcelable.Param(mo13014id = 3) int i3) {
        this.f12601a = i;
        this.f12602b = i2;
        this.f12603c = i3;
    }

    public static zzaqc zza(VersionInfo versionInfo) {
        return new zzaqc(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzaqc)) {
            zzaqc zzaqc = (zzaqc) obj;
            if (zzaqc.f12603c == this.f12603c && zzaqc.f12602b == this.f12602b && zzaqc.f12601a == this.f12601a) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.f12601a, this.f12602b, this.f12603c});
    }

    public final String toString() {
        int i = this.f12601a;
        int i2 = this.f12602b;
        int i3 = this.f12603c;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f12601a);
        SafeParcelWriter.writeInt(parcel, 2, this.f12602b);
        SafeParcelWriter.writeInt(parcel, 3, this.f12603c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
