package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "WakeLockEventCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzb();
    @SafeParcelable.VersionField(mo13017id = 1)

    /* renamed from: a */
    private final int f7595a;
    @SafeParcelable.Field(getter = "getTimeMillis", mo13011id = 2)

    /* renamed from: b */
    private final long f7596b;
    @SafeParcelable.Field(getter = "getEventType", mo13011id = 11)

    /* renamed from: c */
    private int f7597c;
    @SafeParcelable.Field(getter = "getWakeLockName", mo13011id = 4)

    /* renamed from: d */
    private final String f7598d;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", mo13011id = 10)

    /* renamed from: e */
    private final String f7599e;
    @SafeParcelable.Field(getter = "getCodePackage", mo13011id = 17)

    /* renamed from: f */
    private final String f7600f;
    @SafeParcelable.Field(getter = "getWakeLockType", mo13011id = 5)

    /* renamed from: g */
    private final int f7601g;
    @SafeParcelable.Field(getter = "getCallingPackages", mo13011id = 6)

    /* renamed from: h */
    private final List<String> f7602h;
    @SafeParcelable.Field(getter = "getEventKey", mo13011id = 12)

    /* renamed from: i */
    private final String f7603i;
    @SafeParcelable.Field(getter = "getElapsedRealtime", mo13011id = 8)

    /* renamed from: j */
    private final long f7604j;
    @SafeParcelable.Field(getter = "getDeviceState", mo13011id = 14)

    /* renamed from: k */
    private int f7605k;
    @SafeParcelable.Field(getter = "getHostPackage", mo13011id = 13)

    /* renamed from: l */
    private final String f7606l;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", mo13011id = 15)

    /* renamed from: m */
    private final float f7607m;
    @SafeParcelable.Field(getter = "getTimeout", mo13011id = 16)

    /* renamed from: n */
    private final long f7608n;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", mo13011id = 18)

    /* renamed from: o */
    private final boolean f7609o;

    /* renamed from: p */
    private long f7610p;

    @SafeParcelable.Constructor
    WakeLockEvent(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) long j, @SafeParcelable.Param(mo13014id = 11) int i2, @SafeParcelable.Param(mo13014id = 4) String str, @SafeParcelable.Param(mo13014id = 5) int i3, @SafeParcelable.Param(mo13014id = 6) List<String> list, @SafeParcelable.Param(mo13014id = 12) String str2, @SafeParcelable.Param(mo13014id = 8) long j2, @SafeParcelable.Param(mo13014id = 14) int i4, @SafeParcelable.Param(mo13014id = 10) String str3, @SafeParcelable.Param(mo13014id = 13) String str4, @SafeParcelable.Param(mo13014id = 15) float f, @SafeParcelable.Param(mo13014id = 16) long j3, @SafeParcelable.Param(mo13014id = 17) String str5, @SafeParcelable.Param(mo13014id = 18) boolean z) {
        this.f7595a = i;
        this.f7596b = j;
        this.f7597c = i2;
        this.f7598d = str;
        this.f7599e = str3;
        this.f7600f = str5;
        this.f7601g = i3;
        this.f7610p = -1;
        this.f7602h = list;
        this.f7603i = str2;
        this.f7604j = j2;
        this.f7605k = i4;
        this.f7606l = str4;
        this.f7607m = f;
        this.f7608n = j3;
        this.f7609o = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7595a);
        SafeParcelWriter.writeLong(parcel, 2, zza());
        SafeParcelWriter.writeString(parcel, 4, this.f7598d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f7601g);
        SafeParcelWriter.writeStringList(parcel, 6, this.f7602h, false);
        SafeParcelWriter.writeLong(parcel, 8, this.f7604j);
        SafeParcelWriter.writeString(parcel, 10, this.f7599e, false);
        SafeParcelWriter.writeInt(parcel, 11, zzb());
        SafeParcelWriter.writeString(parcel, 12, this.f7603i, false);
        SafeParcelWriter.writeString(parcel, 13, this.f7606l, false);
        SafeParcelWriter.writeInt(parcel, 14, this.f7605k);
        SafeParcelWriter.writeFloat(parcel, 15, this.f7607m);
        SafeParcelWriter.writeLong(parcel, 16, this.f7608n);
        SafeParcelWriter.writeString(parcel, 17, this.f7600f, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.f7609o);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final long zza() {
        return this.f7596b;
    }

    public final int zzb() {
        return this.f7597c;
    }

    public final long zzc() {
        return this.f7610p;
    }

    public final String zzd() {
        String str;
        String str2 = this.f7598d;
        int i = this.f7601g;
        List<String> list = this.f7602h;
        String str3 = "";
        if (list == null) {
            str = str3;
        } else {
            str = TextUtils.join(",", list);
        }
        int i2 = this.f7605k;
        String str4 = this.f7599e;
        if (str4 == null) {
            str4 = str3;
        }
        String str5 = this.f7606l;
        if (str5 == null) {
            str5 = str3;
        }
        float f = this.f7607m;
        String str6 = this.f7600f;
        if (str6 != null) {
            str3 = str6;
        }
        boolean z = this.f7609o;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 51 + String.valueOf(str).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str3).length());
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5, boolean z) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5, z);
    }
}
