package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;

@SafeParcelable.Class(creator = "RewardItemParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzava extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzava> CREATOR = new zzavd();
    @SafeParcelable.Field(mo13011id = 2)
    public final String type;
    @SafeParcelable.Field(mo13011id = 3)
    public final int zzdxu;

    public zzava(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    @Nullable
    public static zzava zza(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzava(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzava)) {
            zzava zzava = (zzava) obj;
            if (!Objects.equal(this.type, zzava.type) || !Objects.equal(Integer.valueOf(this.zzdxu), Integer.valueOf(zzava.zzdxu))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.type, Integer.valueOf(this.zzdxu));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.type, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdxu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzava(@SafeParcelable.Param(mo13014id = 2) String str, @SafeParcelable.Param(mo13014id = 3) int i) {
        this.type = str;
        this.zzdxu = i;
    }
}
