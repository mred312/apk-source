package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzass extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzass> CREATOR = new zzasv();
    @SafeParcelable.Field(mo13011id = 31)

    /* renamed from: A */
    private final long f12687A;
    @SafeParcelable.Field(mo13011id = 33)

    /* renamed from: B */
    private final String f12688B;
    @SafeParcelable.Field(mo13011id = 34)

    /* renamed from: C */
    private final float f12689C;
    @SafeParcelable.Field(mo13011id = 35)

    /* renamed from: D */
    private final int f12690D;
    @SafeParcelable.Field(mo13011id = 36)

    /* renamed from: E */
    private final int f12691E;
    @SafeParcelable.Field(mo13011id = 37)

    /* renamed from: F */
    private final boolean f12692F;
    @SafeParcelable.Field(mo13011id = 38)

    /* renamed from: G */
    private final boolean f12693G;
    @SafeParcelable.Field(mo13011id = 39)

    /* renamed from: H */
    private final String f12694H;
    @SafeParcelable.Field(mo13011id = 40)

    /* renamed from: I */
    private final boolean f12695I;
    @SafeParcelable.Field(mo13011id = 41)

    /* renamed from: J */
    private final String f12696J;
    @SafeParcelable.Field(mo13011id = 42)

    /* renamed from: K */
    private final boolean f12697K;
    @SafeParcelable.Field(mo13011id = 43)

    /* renamed from: L */
    private final int f12698L;
    @SafeParcelable.Field(mo13011id = 44)

    /* renamed from: M */
    private final Bundle f12699M;
    @SafeParcelable.Field(mo13011id = 45)

    /* renamed from: N */
    private final String f12700N;
    @SafeParcelable.Field(mo13011id = 46)
    @Nullable

    /* renamed from: O */
    private final zzyy f12701O;
    @SafeParcelable.Field(mo13011id = 47)

    /* renamed from: P */
    private final boolean f12702P;
    @SafeParcelable.Field(mo13011id = 48)

    /* renamed from: Q */
    private final Bundle f12703Q;
    @SafeParcelable.Field(mo13011id = 49)
    @Nullable

    /* renamed from: R */
    private final String f12704R;
    @SafeParcelable.Field(mo13011id = 50)
    @Nullable

    /* renamed from: S */
    private final String f12705S;
    @SafeParcelable.Field(mo13011id = 51)
    @Nullable

    /* renamed from: T */
    private final String f12706T;
    @SafeParcelable.Field(mo13011id = 52)

    /* renamed from: U */
    private final boolean f12707U;
    @SafeParcelable.Field(mo13011id = 53)

    /* renamed from: V */
    private final List<Integer> f12708V;
    @SafeParcelable.Field(mo13011id = 54)

    /* renamed from: W */
    private final String f12709W;
    @SafeParcelable.Field(mo13011id = 55)

    /* renamed from: X */
    private final List<String> f12710X;
    @SafeParcelable.Field(mo13011id = 56)

    /* renamed from: Y */
    private final int f12711Y;
    @SafeParcelable.Field(mo13011id = 57)

    /* renamed from: Z */
    private final boolean f12712Z;
    @SafeParcelable.Field(mo13011id = 1)

    /* renamed from: a */
    private final int f12713a;
    @SafeParcelable.Field(mo13011id = 58)

    /* renamed from: a0 */
    private final boolean f12714a0;
    @SafeParcelable.Field(mo13011id = 2)
    @Nullable

    /* renamed from: b */
    private final Bundle f12715b;
    @SafeParcelable.Field(mo13011id = 59)

    /* renamed from: b0 */
    private final boolean f12716b0;
    @SafeParcelable.Field(mo13011id = 3)

    /* renamed from: c */
    private final zzvk f12717c;
    @SafeParcelable.Field(mo13011id = 60)

    /* renamed from: c0 */
    private final ArrayList<String> f12718c0;
    @SafeParcelable.Field(mo13011id = 4)

    /* renamed from: d */
    private final zzvn f12719d;
    @SafeParcelable.Field(mo13011id = 61)

    /* renamed from: d0 */
    private final String f12720d0;
    @SafeParcelable.Field(mo13011id = 5)

    /* renamed from: e */
    private final String f12721e;
    @SafeParcelable.Field(mo13011id = 63)

    /* renamed from: e0 */
    private final zzajl f12722e0;
    @SafeParcelable.Field(mo13011id = 6)

    /* renamed from: f */
    private final ApplicationInfo f12723f;
    @SafeParcelable.Field(mo13011id = 64)
    @Nullable

    /* renamed from: f0 */
    private final String f12724f0;
    @SafeParcelable.Field(mo13011id = 7)
    @Nullable

    /* renamed from: g */
    private final PackageInfo f12725g;
    @SafeParcelable.Field(mo13011id = 65)

    /* renamed from: g0 */
    private final Bundle f12726g0;
    @SafeParcelable.Field(mo13011id = 8)

    /* renamed from: h */
    private final String f12727h;
    @SafeParcelable.Field(mo13011id = 9)

    /* renamed from: i */
    private final String f12728i;
    @SafeParcelable.Field(mo13011id = 10)

    /* renamed from: j */
    private final String f12729j;
    @SafeParcelable.Field(mo13011id = 11)

    /* renamed from: k */
    private final zzazh f12730k;
    @SafeParcelable.Field(mo13011id = 12)

    /* renamed from: l */
    private final Bundle f12731l;
    @SafeParcelable.Field(mo13011id = 13)

    /* renamed from: m */
    private final int f12732m;
    @SafeParcelable.Field(mo13011id = 14)

    /* renamed from: n */
    private final List<String> f12733n;
    @SafeParcelable.Field(mo13011id = 15)

    /* renamed from: o */
    private final Bundle f12734o;
    @SafeParcelable.Field(mo13011id = 16)

    /* renamed from: p */
    private final boolean f12735p;
    @SafeParcelable.Field(mo13011id = 18)

    /* renamed from: q */
    private final int f12736q;
    @SafeParcelable.Field(mo13011id = 19)

    /* renamed from: r */
    private final int f12737r;
    @SafeParcelable.Field(mo13011id = 20)

    /* renamed from: s */
    private final float f12738s;
    @SafeParcelable.Field(mo13011id = 21)

    /* renamed from: t */
    private final String f12739t;
    @SafeParcelable.Field(mo13011id = 25)

    /* renamed from: u */
    private final long f12740u;
    @SafeParcelable.Field(mo13011id = 26)

    /* renamed from: v */
    private final String f12741v;
    @SafeParcelable.Field(mo13011id = 27)
    @Nullable

    /* renamed from: w */
    private final List<String> f12742w;
    @SafeParcelable.Field(mo13011id = 28)

    /* renamed from: x */
    private final String f12743x;
    @SafeParcelable.Field(mo13011id = 29)

    /* renamed from: y */
    private final zzadz f12744y;
    @SafeParcelable.Field(mo13011id = 30)

    /* renamed from: z */
    private final List<String> f12745z;

    @SafeParcelable.Constructor
    zzass(@SafeParcelable.Param(mo13014id = 1) int i, @SafeParcelable.Param(mo13014id = 2) Bundle bundle, @SafeParcelable.Param(mo13014id = 3) zzvk zzvk, @SafeParcelable.Param(mo13014id = 4) zzvn zzvn, @SafeParcelable.Param(mo13014id = 5) String str, @SafeParcelable.Param(mo13014id = 6) ApplicationInfo applicationInfo, @SafeParcelable.Param(mo13014id = 7) PackageInfo packageInfo, @SafeParcelable.Param(mo13014id = 8) String str2, @SafeParcelable.Param(mo13014id = 9) String str3, @SafeParcelable.Param(mo13014id = 10) String str4, @SafeParcelable.Param(mo13014id = 11) zzazh zzazh, @SafeParcelable.Param(mo13014id = 12) Bundle bundle2, @SafeParcelable.Param(mo13014id = 13) int i2, @SafeParcelable.Param(mo13014id = 14) List<String> list, @SafeParcelable.Param(mo13014id = 15) Bundle bundle3, @SafeParcelable.Param(mo13014id = 16) boolean z, @SafeParcelable.Param(mo13014id = 18) int i3, @SafeParcelable.Param(mo13014id = 19) int i4, @SafeParcelable.Param(mo13014id = 20) float f, @SafeParcelable.Param(mo13014id = 21) String str5, @SafeParcelable.Param(mo13014id = 25) long j, @SafeParcelable.Param(mo13014id = 26) String str6, @SafeParcelable.Param(mo13014id = 27) List<String> list2, @SafeParcelable.Param(mo13014id = 28) String str7, @SafeParcelable.Param(mo13014id = 29) zzadz zzadz, @SafeParcelable.Param(mo13014id = 30) List<String> list3, @SafeParcelable.Param(mo13014id = 31) long j2, @SafeParcelable.Param(mo13014id = 33) String str8, @SafeParcelable.Param(mo13014id = 34) float f2, @SafeParcelable.Param(mo13014id = 40) boolean z2, @SafeParcelable.Param(mo13014id = 35) int i5, @SafeParcelable.Param(mo13014id = 36) int i6, @SafeParcelable.Param(mo13014id = 37) boolean z3, @SafeParcelable.Param(mo13014id = 38) boolean z4, @SafeParcelable.Param(mo13014id = 39) String str9, @SafeParcelable.Param(mo13014id = 41) String str10, @SafeParcelable.Param(mo13014id = 42) boolean z5, @SafeParcelable.Param(mo13014id = 43) int i7, @SafeParcelable.Param(mo13014id = 44) Bundle bundle4, @SafeParcelable.Param(mo13014id = 45) String str11, @SafeParcelable.Param(mo13014id = 46) zzyy zzyy, @SafeParcelable.Param(mo13014id = 47) boolean z6, @SafeParcelable.Param(mo13014id = 48) Bundle bundle5, @SafeParcelable.Param(mo13014id = 49) @Nullable String str12, @SafeParcelable.Param(mo13014id = 50) @Nullable String str13, @SafeParcelable.Param(mo13014id = 51) @Nullable String str14, @SafeParcelable.Param(mo13014id = 52) boolean z7, @SafeParcelable.Param(mo13014id = 53) List<Integer> list4, @SafeParcelable.Param(mo13014id = 54) String str15, @SafeParcelable.Param(mo13014id = 55) List<String> list5, @SafeParcelable.Param(mo13014id = 56) int i8, @SafeParcelable.Param(mo13014id = 57) boolean z8, @SafeParcelable.Param(mo13014id = 58) boolean z9, @SafeParcelable.Param(mo13014id = 59) boolean z10, @SafeParcelable.Param(mo13014id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(mo13014id = 61) String str16, @SafeParcelable.Param(mo13014id = 63) zzajl zzajl, @SafeParcelable.Param(mo13014id = 64) @Nullable String str17, @SafeParcelable.Param(mo13014id = 65) Bundle bundle6) {
        List<String> list6;
        List<String> list7;
        this.f12713a = i;
        this.f12715b = bundle;
        this.f12717c = zzvk;
        this.f12719d = zzvn;
        this.f12721e = str;
        this.f12723f = applicationInfo;
        this.f12725g = packageInfo;
        this.f12727h = str2;
        this.f12728i = str3;
        this.f12729j = str4;
        this.f12730k = zzazh;
        this.f12731l = bundle2;
        this.f12732m = i2;
        this.f12733n = list;
        if (list3 == null) {
            list6 = Collections.emptyList();
        } else {
            list6 = Collections.unmodifiableList(list3);
        }
        this.f12745z = list6;
        this.f12734o = bundle3;
        this.f12735p = z;
        this.f12736q = i3;
        this.f12737r = i4;
        this.f12738s = f;
        this.f12739t = str5;
        this.f12740u = j;
        this.f12741v = str6;
        if (list2 == null) {
            list7 = Collections.emptyList();
        } else {
            list7 = Collections.unmodifiableList(list2);
        }
        this.f12742w = list7;
        this.f12743x = str7;
        this.f12744y = zzadz;
        this.f12687A = j2;
        this.f12688B = str8;
        this.f12689C = f2;
        this.f12695I = z2;
        this.f12690D = i5;
        this.f12691E = i6;
        this.f12692F = z3;
        this.f12693G = z4;
        this.f12694H = str9;
        this.f12696J = str10;
        this.f12697K = z5;
        this.f12698L = i7;
        this.f12699M = bundle4;
        this.f12700N = str11;
        this.f12701O = zzyy;
        this.f12702P = z6;
        this.f12703Q = bundle5;
        this.f12704R = str12;
        this.f12705S = str13;
        this.f12706T = str14;
        this.f12707U = z7;
        this.f12708V = list4;
        this.f12709W = str15;
        this.f12710X = list5;
        this.f12711Y = i8;
        this.f12712Z = z8;
        this.f12714a0 = z9;
        this.f12716b0 = z10;
        this.f12718c0 = arrayList;
        this.f12720d0 = str16;
        this.f12722e0 = zzajl;
        this.f12724f0 = str17;
        this.f12726g0 = bundle6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f12713a);
        SafeParcelWriter.writeBundle(parcel, 2, this.f12715b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f12717c, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f12719d, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.f12721e, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f12723f, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f12725g, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.f12727h, false);
        SafeParcelWriter.writeString(parcel, 9, this.f12728i, false);
        SafeParcelWriter.writeString(parcel, 10, this.f12729j, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.f12730k, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.f12731l, false);
        SafeParcelWriter.writeInt(parcel, 13, this.f12732m);
        SafeParcelWriter.writeStringList(parcel, 14, this.f12733n, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.f12734o, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.f12735p);
        SafeParcelWriter.writeInt(parcel, 18, this.f12736q);
        SafeParcelWriter.writeInt(parcel, 19, this.f12737r);
        SafeParcelWriter.writeFloat(parcel, 20, this.f12738s);
        SafeParcelWriter.writeString(parcel, 21, this.f12739t, false);
        SafeParcelWriter.writeLong(parcel, 25, this.f12740u);
        SafeParcelWriter.writeString(parcel, 26, this.f12741v, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.f12742w, false);
        SafeParcelWriter.writeString(parcel, 28, this.f12743x, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.f12744y, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.f12745z, false);
        SafeParcelWriter.writeLong(parcel, 31, this.f12687A);
        SafeParcelWriter.writeString(parcel, 33, this.f12688B, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.f12689C);
        SafeParcelWriter.writeInt(parcel, 35, this.f12690D);
        SafeParcelWriter.writeInt(parcel, 36, this.f12691E);
        SafeParcelWriter.writeBoolean(parcel, 37, this.f12692F);
        SafeParcelWriter.writeBoolean(parcel, 38, this.f12693G);
        SafeParcelWriter.writeString(parcel, 39, this.f12694H, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.f12695I);
        SafeParcelWriter.writeString(parcel, 41, this.f12696J, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.f12697K);
        SafeParcelWriter.writeInt(parcel, 43, this.f12698L);
        SafeParcelWriter.writeBundle(parcel, 44, this.f12699M, false);
        SafeParcelWriter.writeString(parcel, 45, this.f12700N, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.f12701O, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.f12702P);
        SafeParcelWriter.writeBundle(parcel, 48, this.f12703Q, false);
        SafeParcelWriter.writeString(parcel, 49, this.f12704R, false);
        SafeParcelWriter.writeString(parcel, 50, this.f12705S, false);
        SafeParcelWriter.writeString(parcel, 51, this.f12706T, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.f12707U);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.f12708V, false);
        SafeParcelWriter.writeString(parcel, 54, this.f12709W, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.f12710X, false);
        SafeParcelWriter.writeInt(parcel, 56, this.f12711Y);
        SafeParcelWriter.writeBoolean(parcel, 57, this.f12712Z);
        SafeParcelWriter.writeBoolean(parcel, 58, this.f12714a0);
        SafeParcelWriter.writeBoolean(parcel, 59, this.f12716b0);
        SafeParcelWriter.writeStringList(parcel, 60, this.f12718c0, false);
        SafeParcelWriter.writeString(parcel, 61, this.f12720d0, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.f12722e0, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.f12724f0, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.f12726g0, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
