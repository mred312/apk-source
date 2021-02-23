package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

@SafeParcelable.Class(creator = "HttpRequestParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzail extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzail> CREATOR = new zzaik();
    @SafeParcelable.Field(mo13011id = 1)

    /* renamed from: a */
    private final String f12479a;
    @SafeParcelable.Field(mo13011id = 2)

    /* renamed from: b */
    private final String[] f12480b;
    @SafeParcelable.Field(mo13011id = 3)

    /* renamed from: c */
    private final String[] f12481c;

    @SafeParcelable.Constructor
    zzail(@SafeParcelable.Param(mo13014id = 1) String str, @SafeParcelable.Param(mo13014id = 2) String[] strArr, @SafeParcelable.Param(mo13014id = 3) String[] strArr2) {
        this.f12479a = str;
        this.f12480b = strArr;
        this.f12481c = strArr2;
    }

    public static zzail zzh(zzaa<?> zzaa) {
        Map<String, String> headers = zzaa.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry next : headers.entrySet()) {
            strArr[i] = (String) next.getKey();
            strArr2[i] = (String) next.getValue();
            i++;
        }
        return new zzail(zzaa.getUrl(), strArr, strArr2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f12479a, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.f12480b, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.f12481c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
