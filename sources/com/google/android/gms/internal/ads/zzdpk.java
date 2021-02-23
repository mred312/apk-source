package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "PoolConfigurationCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdpk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdpk> CREATOR = new zzdpo();

    /* renamed from: a */
    private final zzdpj[] f15856a;

    /* renamed from: b */
    private final int[] f15857b;

    /* renamed from: c */
    private final int[] f15858c;
    @Nullable
    public final Context context;
    @SafeParcelable.Field(getter = "getFormatInt", mo13011id = 1)

    /* renamed from: d */
    private final int f15859d;
    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", mo13011id = 6)

    /* renamed from: e */
    private final int f15860e;
    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", mo13011id = 7)

    /* renamed from: f */
    private final int f15861f;

    /* renamed from: g */
    private final int f15862g;
    public final zzdpj zzhlm;
    @SafeParcelable.Field(mo13011id = 2)
    public final int zzhln;
    @SafeParcelable.Field(mo13011id = 3)
    public final int zzhlo;
    @SafeParcelable.Field(mo13011id = 4)
    public final int zzhlp;
    @SafeParcelable.Field(mo13011id = 5)
    public final String zzhlq;
    public final int zzhls;

    private zzdpk(@Nullable Context context2, zzdpj zzdpj, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.f15856a = zzdpj.values();
        this.f15857b = zzdpm.zzavt();
        this.f15858c = zzdpl.zzavs();
        this.context = context2;
        this.f15859d = zzdpj.ordinal();
        this.zzhlm = zzdpj;
        this.zzhln = i;
        this.zzhlo = i2;
        this.zzhlp = i3;
        this.zzhlq = str;
        if ("oldest".equals(str2)) {
            i4 = zzdpm.zzhlx;
        } else if ("lru".equals(str2) || !"lfu".equals(str2)) {
            i4 = zzdpm.zzhly;
        } else {
            i4 = zzdpm.zzhlz;
        }
        this.zzhls = i4;
        this.f15860e = i4 - 1;
        "onAdClosed".equals(str3);
        int i5 = zzdpl.zzhlv;
        this.f15862g = i5;
        this.f15861f = i5 - 1;
    }

    public static zzdpk zza(zzdpj zzdpj, Context context2) {
        if (zzdpj == zzdpj.Rewarded) {
            return new zzdpk(context2, zzdpj, ((Integer) zzwq.zzqe().zzd(zzabf.zzcxb)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxh)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxj)).intValue(), (String) zzwq.zzqe().zzd(zzabf.zzcxl), (String) zzwq.zzqe().zzd(zzabf.zzcxd), (String) zzwq.zzqe().zzd(zzabf.zzcxf));
        } else if (zzdpj == zzdpj.Interstitial) {
            return new zzdpk(context2, zzdpj, ((Integer) zzwq.zzqe().zzd(zzabf.zzcxc)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxi)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxk)).intValue(), (String) zzwq.zzqe().zzd(zzabf.zzcxm), (String) zzwq.zzqe().zzd(zzabf.zzcxe), (String) zzwq.zzqe().zzd(zzabf.zzcxg));
        } else if (zzdpj != zzdpj.AppOpen) {
            return null;
        } else {
            return new zzdpk(context2, zzdpj, ((Integer) zzwq.zzqe().zzd(zzabf.zzcxp)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxr)).intValue(), ((Integer) zzwq.zzqe().zzd(zzabf.zzcxs)).intValue(), (String) zzwq.zzqe().zzd(zzabf.zzcxn), (String) zzwq.zzqe().zzd(zzabf.zzcxo), (String) zzwq.zzqe().zzd(zzabf.zzcxq));
        }
    }

    public static boolean zzavr() {
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcxa)).booleanValue();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f15859d);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhln);
        SafeParcelWriter.writeInt(parcel, 3, this.zzhlo);
        SafeParcelWriter.writeInt(parcel, 4, this.zzhlp);
        SafeParcelWriter.writeString(parcel, 5, this.zzhlq, false);
        SafeParcelWriter.writeInt(parcel, 6, this.f15860e);
        SafeParcelWriter.writeInt(parcel, 7, this.f15861f);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzdpk(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) int i2, @SafeParcelable.Param(mo13014id = 3) int i3, @SafeParcelable.Param(mo13014id = 4) int i4, @SafeParcelable.Param(mo13014id = 5) String str, @SafeParcelable.Param(mo13014id = 6) int i5, @SafeParcelable.Param(mo13014id = 7) int i6) {
        zzdpj[] values = zzdpj.values();
        this.f15856a = values;
        int[] zzavt = zzdpm.zzavt();
        this.f15857b = zzavt;
        int[] zzavs = zzdpl.zzavs();
        this.f15858c = zzavs;
        this.context = null;
        this.f15859d = i;
        this.zzhlm = values[i];
        this.zzhln = i2;
        this.zzhlo = i3;
        this.zzhlp = i4;
        this.zzhlq = str;
        this.f15860e = i5;
        this.zzhls = zzavt[i5];
        this.f15861f = i6;
        this.f15862g = zzavs[i6];
    }
}
