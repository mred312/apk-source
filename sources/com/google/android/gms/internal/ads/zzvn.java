package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class zzvn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvn> CREATOR = new zzvq();
    @SafeParcelable.Field(mo13011id = 13)

    /* renamed from: a */
    private boolean f17078a;
    @SafeParcelable.Field(mo13011id = 3)
    public final int height;
    @SafeParcelable.Field(mo13011id = 4)
    public final int heightPixels;
    @SafeParcelable.Field(mo13011id = 6)
    public final int width;
    @SafeParcelable.Field(mo13011id = 7)
    public final int widthPixels;
    @SafeParcelable.Field(mo13011id = 2)
    public final String zzacv;
    @SafeParcelable.Field(mo13011id = 9)
    public final boolean zzbrh;
    @SafeParcelable.Field(mo13011id = 5)
    public final boolean zzchp;
    @SafeParcelable.Field(mo13011id = 8)
    public final zzvn[] zzchq;
    @SafeParcelable.Field(mo13011id = 10)
    public final boolean zzchr;
    @SafeParcelable.Field(mo13011id = 11)
    public boolean zzchs;
    @SafeParcelable.Field(mo13011id = 12)
    public boolean zzcht;
    @SafeParcelable.Field(mo13011id = 14)
    public boolean zzchv;
    @SafeParcelable.Field(mo13011id = 15)
    public boolean zzchw;

    public zzvn() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zzvn[]) null, false, false, false, false, false, false, false);
    }

    /* renamed from: a */
    private static int m9251a(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (((float) m9251a(displayMetrics)) * displayMetrics.density);
    }

    public static zzvn zzpo() {
        return new zzvn("320x50_mb", 0, 0, false, 0, 0, (zzvn[]) null, true, false, false, false, false, false, false);
    }

    public static zzvn zzpp() {
        return new zzvn("reward_mb", 0, 0, true, 0, 0, (zzvn[]) null, false, false, false, false, false, false, false);
    }

    public static zzvn zzpq() {
        return new zzvn("interstitial_mb", 0, 0, false, 0, 0, (zzvn[]) null, false, false, false, false, true, false, false);
    }

    public static zzvn zzpr() {
        return new zzvn("invalid", 0, 0, false, 0, 0, (zzvn[]) null, false, false, false, true, false, false, false);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzacv, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzchp);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzchq, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbrh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzchr);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzchs);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzcht);
        SafeParcelWriter.writeBoolean(parcel, 13, this.f17078a);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzchv);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzchw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdSize zzps() {
        return zzb.zza(this.width, this.height, this.zzacv);
    }

    public zzvn(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzvn(android.content.Context r14, com.google.android.gms.ads.AdSize[] r15) {
        /*
            r13 = this;
            r13.<init>()
            r0 = 0
            r1 = r15[r0]
            r13.zzchp = r0
            boolean r2 = r1.isFluid()
            r13.zzchr = r2
            boolean r3 = com.google.android.gms.ads.zzb.zza(r1)
            r13.zzchv = r3
            boolean r3 = com.google.android.gms.ads.zzb.zzb(r1)
            r13.zzchw = r3
            if (r2 == 0) goto L_0x002b
            com.google.android.gms.ads.AdSize r3 = com.google.android.gms.ads.AdSize.BANNER
            int r4 = r3.getWidth()
            r13.width = r4
            int r3 = r3.getHeight()
            r13.height = r3
            goto L_0x0046
        L_0x002b:
            if (r3 == 0) goto L_0x003a
            int r3 = r1.getWidth()
            r13.width = r3
            int r3 = com.google.android.gms.ads.zzb.zzc(r1)
            r13.height = r3
            goto L_0x0046
        L_0x003a:
            int r3 = r1.getWidth()
            r13.width = r3
            int r3 = r1.getHeight()
            r13.height = r3
        L_0x0046:
            int r3 = r13.width
            r4 = -1
            r5 = 1
            if (r3 != r4) goto L_0x004e
            r3 = 1
            goto L_0x004f
        L_0x004e:
            r3 = 0
        L_0x004f:
            int r4 = r13.height
            r6 = -2
            if (r4 != r6) goto L_0x0056
            r4 = 1
            goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            android.content.res.Resources r6 = r14.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            if (r3 == 0) goto L_0x00a0
            com.google.android.gms.internal.ads.zzwq.zzqa()
            boolean r7 = com.google.android.gms.internal.ads.zzayr.zzbq(r14)
            if (r7 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzwq.zzqa()
            boolean r7 = com.google.android.gms.internal.ads.zzayr.zzbr(r14)
            if (r7 == 0) goto L_0x0080
            int r7 = r6.widthPixels
            com.google.android.gms.internal.ads.zzwq.zzqa()
            int r8 = com.google.android.gms.internal.ads.zzayr.zzbs(r14)
            int r7 = r7 - r8
            r13.widthPixels = r7
            goto L_0x0084
        L_0x0080:
            int r7 = r6.widthPixels
            r13.widthPixels = r7
        L_0x0084:
            int r7 = r13.widthPixels
            float r7 = (float) r7
            float r8 = r6.density
            float r7 = r7 / r8
            double r7 = (double) r7
            int r9 = (int) r7
            double r10 = (double) r9
            java.lang.Double.isNaN(r7)
            java.lang.Double.isNaN(r10)
            double r7 = r7 - r10
            r10 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x00ad
            int r9 = r9 + 1
            goto L_0x00ad
        L_0x00a0:
            int r9 = r13.width
            com.google.android.gms.internal.ads.zzwq.zzqa()
            int r7 = r13.width
            int r7 = com.google.android.gms.internal.ads.zzayr.zza((android.util.DisplayMetrics) r6, (int) r7)
            r13.widthPixels = r7
        L_0x00ad:
            if (r4 == 0) goto L_0x00b4
            int r7 = m9251a(r6)
            goto L_0x00b6
        L_0x00b4:
            int r7 = r13.height
        L_0x00b6:
            com.google.android.gms.internal.ads.zzwq.zzqa()
            int r6 = com.google.android.gms.internal.ads.zzayr.zza((android.util.DisplayMetrics) r6, (int) r7)
            r13.heightPixels = r6
            java.lang.String r6 = "_as"
            java.lang.String r8 = "x"
            r10 = 26
            if (r3 != 0) goto L_0x00f8
            if (r4 == 0) goto L_0x00ca
            goto L_0x00f8
        L_0x00ca:
            boolean r3 = r13.zzchw
            if (r3 == 0) goto L_0x00ea
            int r1 = r13.width
            int r2 = r13.height
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r10)
            r3.append(r1)
            r3.append(r8)
            r3.append(r2)
            r3.append(r6)
            java.lang.String r1 = r3.toString()
            r13.zzacv = r1
            goto L_0x010f
        L_0x00ea:
            if (r2 == 0) goto L_0x00f1
            java.lang.String r1 = "320x50_mb"
            r13.zzacv = r1
            goto L_0x010f
        L_0x00f1:
            java.lang.String r1 = r1.toString()
            r13.zzacv = r1
            goto L_0x010f
        L_0x00f8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r10)
            r1.append(r9)
            r1.append(r8)
            r1.append(r7)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r13.zzacv = r1
        L_0x010f:
            int r1 = r15.length
            if (r1 <= r5) goto L_0x0129
            int r1 = r15.length
            com.google.android.gms.internal.ads.zzvn[] r1 = new com.google.android.gms.internal.ads.zzvn[r1]
            r13.zzchq = r1
            r1 = 0
        L_0x0118:
            int r2 = r15.length
            if (r1 >= r2) goto L_0x012c
            com.google.android.gms.internal.ads.zzvn[] r2 = r13.zzchq
            com.google.android.gms.internal.ads.zzvn r3 = new com.google.android.gms.internal.ads.zzvn
            r4 = r15[r1]
            r3.<init>((android.content.Context) r14, (com.google.android.gms.ads.AdSize) r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x0118
        L_0x0129:
            r14 = 0
            r13.zzchq = r14
        L_0x012c:
            r13.zzbrh = r0
            r13.zzchs = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvn.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @SafeParcelable.Constructor
    zzvn(@SafeParcelable.Param(mo13014id = 2) String str, @SafeParcelable.Param(mo13014id = 3) int i, @SafeParcelable.Param(mo13014id = 4) int i2, @SafeParcelable.Param(mo13014id = 5) boolean z, @SafeParcelable.Param(mo13014id = 6) int i3, @SafeParcelable.Param(mo13014id = 7) int i4, @SafeParcelable.Param(mo13014id = 8) zzvn[] zzvnArr, @SafeParcelable.Param(mo13014id = 9) boolean z2, @SafeParcelable.Param(mo13014id = 10) boolean z3, @SafeParcelable.Param(mo13014id = 11) boolean z4, @SafeParcelable.Param(mo13014id = 12) boolean z5, @SafeParcelable.Param(mo13014id = 13) boolean z6, @SafeParcelable.Param(mo13014id = 14) boolean z7, @SafeParcelable.Param(mo13014id = 15) boolean z8) {
        this.zzacv = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzchp = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzchq = zzvnArr;
        this.zzbrh = z2;
        this.zzchr = z3;
        this.zzchs = z4;
        this.zzcht = z5;
        this.f17078a = z6;
        this.zzchv = z7;
        this.zzchw = z8;
    }
}
