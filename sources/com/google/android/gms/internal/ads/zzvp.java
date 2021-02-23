package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AdValueParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzvp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvp> CREATOR = new zzvs();
    @SafeParcelable.Field(mo13011id = 1)
    public final int type;
    @SafeParcelable.Field(mo13011id = 2)
    public final int zzacz;
    @SafeParcelable.Field(mo13011id = 3)
    public final String zzada;
    @SafeParcelable.Field(mo13011id = 4)
    public final long zzadb;

    @SafeParcelable.Constructor
    public zzvp(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) int i2, @SafeParcelable.Param(mo13014id = 3) String str, @SafeParcelable.Param(mo13014id = 4) long j) {
        this.type = i;
        this.zzacz = i2;
        this.zzada = str;
        this.zzadb = j;
    }

    public static zzvp zza(JSONObject jSONObject) {
        return new zzvp(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString("currency"), jSONObject.getLong("value"));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.type);
        SafeParcelWriter.writeInt(parcel, 2, this.zzacz);
        SafeParcelWriter.writeString(parcel, 3, this.zzada, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzadb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
