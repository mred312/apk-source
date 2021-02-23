package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zztf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zztf> CREATOR = new zzte();
    @SafeParcelable.Field(mo13011id = 3)

    /* renamed from: a */
    private final long f16997a;
    @SafeParcelable.Field(mo13011id = 4)

    /* renamed from: b */
    private final String f16998b;
    @SafeParcelable.Field(mo13011id = 5)

    /* renamed from: c */
    private final String f16999c;
    @SafeParcelable.Field(mo13011id = 6)

    /* renamed from: d */
    private final String f17000d;
    @SafeParcelable.Field(mo13011id = 7)

    /* renamed from: e */
    private final Bundle f17001e;
    @SafeParcelable.Field(mo13011id = 2)
    @Nullable
    public final String url;
    @SafeParcelable.Field(mo13011id = 8)
    public final boolean zzbvd;
    @SafeParcelable.Field(mo13011id = 9)
    public long zzbve;
    @SafeParcelable.Field(mo13011id = 10)
    public String zzbvf;
    @SafeParcelable.Field(mo13011id = 11)
    public int zzbvg;

    @SafeParcelable.Constructor
    zztf(@SafeParcelable.Param(mo13014id = 2) @Nullable String str, @SafeParcelable.Param(mo13014id = 3) long j, @SafeParcelable.Param(mo13014id = 4) String str2, @SafeParcelable.Param(mo13014id = 5) String str3, @SafeParcelable.Param(mo13014id = 6) String str4, @SafeParcelable.Param(mo13014id = 7) Bundle bundle, @SafeParcelable.Param(mo13014id = 8) boolean z, @SafeParcelable.Param(mo13014id = 9) long j2, @SafeParcelable.Param(mo13014id = 10) String str5, @SafeParcelable.Param(mo13014id = 11) int i) {
        this.url = str;
        this.f16997a = j;
        this.f16998b = str2 == null ? "" : str2;
        this.f16999c = str3 == null ? "" : str3;
        this.f17000d = str4 == null ? "" : str4;
        this.f17001e = bundle == null ? new Bundle() : bundle;
        this.zzbvd = z;
        this.zzbve = j2;
        this.zzbvf = str5;
        this.zzbvg = i;
    }

    @Nullable
    public static zztf zzbs(String str) {
        return zzd(Uri.parse(str));
    }

    @Nullable
    public static zztf zzd(Uri uri) {
        long j;
        Uri uri2 = uri;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzaza.zzfa(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri2.getQueryParameter(ImagesContract.URL);
            boolean equals = "1".equals(uri2.getQueryParameter("read_only"));
            String queryParameter2 = uri2.getQueryParameter("expiration");
            if (queryParameter2 == null) {
                j = 0;
            } else {
                j = Long.parseLong(queryParameter2);
            }
            long j2 = j;
            Bundle bundle = new Bundle();
            zzp.zzks();
            for (String next : uri.getQueryParameterNames()) {
                if (next.startsWith("tag.")) {
                    bundle.putString(next.substring(4), uri2.getQueryParameter(next));
                }
            }
            return new zztf(queryParameter, j2, host, str, str2, bundle, equals, 0, "", 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzaza.zzd("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.f16997a);
        SafeParcelWriter.writeString(parcel, 4, this.f16998b, false);
        SafeParcelWriter.writeString(parcel, 5, this.f16999c, false);
        SafeParcelWriter.writeString(parcel, 6, this.f17000d, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.f17001e, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbvd);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbve);
        SafeParcelWriter.writeString(parcel, 10, this.zzbvf, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzbvg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
