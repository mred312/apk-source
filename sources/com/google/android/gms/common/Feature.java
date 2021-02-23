package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.unity3d.ads.metadata.MediationMetaData;

@KeepForSdk
@SafeParcelable.Class(creator = "FeatureCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getName", mo13011id = 1)

    /* renamed from: a */
    private final String f7444a;
    @SafeParcelable.Field(getter = "getOldVersion", mo13011id = 2)
    @Deprecated

    /* renamed from: b */
    private final int f7445b;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getVersion", mo13011id = 3)

    /* renamed from: c */
    private final long f7446c;

    @KeepForSdk
    public Feature(String str, long j) {
        this.f7444a = str;
        this.f7446c = j;
        this.f7445b = -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() == null || !getName().equals(feature.getName())) && (getName() != null || feature.getName() != null)) || getVersion() != feature.getVersion()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @KeepForSdk
    public String getName() {
        return this.f7444a;
    }

    @KeepForSdk
    public long getVersion() {
        long j = this.f7446c;
        return j == -1 ? (long) this.f7445b : j;
    }

    public int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", getName()).add(MediationMetaData.KEY_VERSION, Long.valueOf(getVersion())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.f7445b);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public Feature(@SafeParcelable.Param(mo13014id = 1) String str, @SafeParcelable.Param(mo13014id = 2) int i, @SafeParcelable.Param(mo13014id = 3) long j) {
        this.f7444a = str;
        this.f7445b = i;
        this.f7446c = j;
    }
}
