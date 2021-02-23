package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzhp implements Parcelable {
    public static final Parcelable.Creator<zzhp> CREATOR = new pd0();

    /* renamed from: a */
    private final String f16448a;

    /* renamed from: b */
    private final zzmd f16449b;

    /* renamed from: c */
    private final int f16450c;

    /* renamed from: d */
    private final byte[] f16451d;

    /* renamed from: e */
    private final zzpu f16452e;

    /* renamed from: f */
    private final int f16453f;

    /* renamed from: g */
    private final int f16454g;

    /* renamed from: h */
    private final int f16455h;
    public final int height;

    /* renamed from: i */
    private int f16456i;
    public final int width;
    public final int zzagw;
    public final String zzagx;
    public final String zzagz;
    public final String zzaha;
    public final int zzahb;
    public final List<byte[]> zzahc;
    public final zzjo zzahd;
    public final float zzahe;
    public final int zzahf;
    public final float zzahg;
    public final int zzahk;
    public final int zzahl;
    public final int zzahm;
    public final long zzahp;
    public final int zzahq;
    public final String zzahr;

    private zzhp(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zzpu zzpu, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzjo zzjo, zzmd zzmd) {
        this.f16448a = str;
        this.zzagz = str2;
        this.zzaha = str3;
        this.zzagx = str4;
        this.zzagw = i;
        this.zzahb = i2;
        this.width = i3;
        this.height = i4;
        this.zzahe = f;
        this.zzahf = i5;
        this.zzahg = f2;
        this.f16451d = bArr;
        this.f16450c = i6;
        this.f16452e = zzpu;
        this.zzahk = i7;
        this.zzahl = i8;
        this.zzahm = i9;
        this.f16453f = i10;
        this.f16454g = i11;
        this.zzahq = i12;
        this.zzahr = str5;
        this.f16455h = i13;
        this.zzahp = j;
        this.zzahc = list == null ? Collections.emptyList() : list;
        this.zzahd = zzjo;
        this.f16449b = zzmd;
    }

    @TargetApi(16)
    /* renamed from: a */
    private static void m8961a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static zzhp zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zzpu zzpu, zzjo zzjo) {
        return new zzhp(str, (String) null, str2, (String) null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zzpu, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, list, zzjo, (zzmd) null);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhp.class == obj.getClass()) {
            zzhp zzhp = (zzhp) obj;
            if (this.zzagw == zzhp.zzagw && this.zzahb == zzhp.zzahb && this.width == zzhp.width && this.height == zzhp.height && this.zzahe == zzhp.zzahe && this.zzahf == zzhp.zzahf && this.zzahg == zzhp.zzahg && this.f16450c == zzhp.f16450c && this.zzahk == zzhp.zzahk && this.zzahl == zzhp.zzahl && this.zzahm == zzhp.zzahm && this.f16453f == zzhp.f16453f && this.f16454g == zzhp.f16454g && this.zzahp == zzhp.zzahp && this.zzahq == zzhp.zzahq && zzpt.zza(this.f16448a, zzhp.f16448a) && zzpt.zza(this.zzahr, zzhp.zzahr) && this.f16455h == zzhp.f16455h && zzpt.zza(this.zzagz, zzhp.zzagz) && zzpt.zza(this.zzaha, zzhp.zzaha) && zzpt.zza(this.zzagx, zzhp.zzagx) && zzpt.zza(this.zzahd, zzhp.zzahd) && zzpt.zza(this.f16449b, zzhp.f16449b) && zzpt.zza(this.f16452e, zzhp.f16452e) && Arrays.equals(this.f16451d, zzhp.f16451d) && this.zzahc.size() == zzhp.zzahc.size()) {
                for (int i = 0; i < this.zzahc.size(); i++) {
                    if (!Arrays.equals(this.zzahc.get(i), zzhp.zzahc.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f16456i == 0) {
            String str = this.f16448a;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.zzagz;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzaha;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzagx;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.zzagw) * 31) + this.width) * 31) + this.height) * 31) + this.zzahk) * 31) + this.zzahl) * 31;
            String str5 = this.zzahr;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f16455h) * 31;
            zzjo zzjo = this.zzahd;
            int hashCode6 = (hashCode5 + (zzjo == null ? 0 : zzjo.hashCode())) * 31;
            zzmd zzmd = this.f16449b;
            if (zzmd != null) {
                i = zzmd.hashCode();
            }
            this.f16456i = hashCode6 + i;
        }
        return this.f16456i;
    }

    public final String toString() {
        String str = this.f16448a;
        String str2 = this.zzagz;
        String str3 = this.zzaha;
        int i = this.zzagw;
        String str4 = this.zzahr;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.zzahe;
        int i4 = this.zzahk;
        int i5 = this.zzahl;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16448a);
        parcel.writeString(this.zzagz);
        parcel.writeString(this.zzaha);
        parcel.writeString(this.zzagx);
        parcel.writeInt(this.zzagw);
        parcel.writeInt(this.zzahb);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzahe);
        parcel.writeInt(this.zzahf);
        parcel.writeFloat(this.zzahg);
        parcel.writeInt(this.f16451d != null ? 1 : 0);
        byte[] bArr = this.f16451d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.f16450c);
        parcel.writeParcelable(this.f16452e, i);
        parcel.writeInt(this.zzahk);
        parcel.writeInt(this.zzahl);
        parcel.writeInt(this.zzahm);
        parcel.writeInt(this.f16453f);
        parcel.writeInt(this.f16454g);
        parcel.writeInt(this.zzahq);
        parcel.writeString(this.zzahr);
        parcel.writeInt(this.f16455h);
        parcel.writeLong(this.zzahp);
        int size = this.zzahc.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzahc.get(i2));
        }
        parcel.writeParcelable(this.zzahd, 0);
        parcel.writeParcelable(this.f16449b, 0);
    }

    public final zzhp zzb(int i, int i2) {
        String str = this.f16448a;
        return new zzhp(str, this.zzagz, this.zzaha, this.zzagx, this.zzagw, this.zzahb, this.width, this.height, this.zzahe, this.zzahf, this.zzahg, this.f16451d, this.f16450c, this.f16452e, this.zzahk, this.zzahl, this.zzahm, i, i2, this.zzahq, this.zzahr, this.f16455h, this.zzahp, this.zzahc, this.zzahd, this.f16449b);
    }

    public final zzhp zzds(long j) {
        return new zzhp(this.f16448a, this.zzagz, this.zzaha, this.zzagx, this.zzagw, this.zzahb, this.width, this.height, this.zzahe, this.zzahf, this.zzahg, this.f16451d, this.f16450c, this.f16452e, this.zzahk, this.zzahl, this.zzahm, this.f16453f, this.f16454g, this.zzahq, this.zzahr, this.f16455h, j, this.zzahc, this.zzahd, this.f16449b);
    }

    public final int zzez() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat zzfa() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzaha);
        String str = this.zzahr;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        m8961a(mediaFormat, "max-input-size", this.zzahb);
        m8961a(mediaFormat, "width", this.width);
        m8961a(mediaFormat, "height", this.height);
        float f = this.zzahe;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        m8961a(mediaFormat, "rotation-degrees", this.zzahf);
        m8961a(mediaFormat, "channel-count", this.zzahk);
        m8961a(mediaFormat, "sample-rate", this.zzahl);
        m8961a(mediaFormat, "encoder-delay", this.f16453f);
        m8961a(mediaFormat, "encoder-padding", this.f16454g);
        for (int i = 0; i < this.zzahc.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzahc.get(i)));
        }
        zzpu zzpu = this.f16452e;
        if (zzpu != null) {
            m8961a(mediaFormat, "color-transfer", zzpu.zzarv);
            m8961a(mediaFormat, "color-standard", zzpu.zzaru);
            m8961a(mediaFormat, "color-range", zzpu.zzarw);
            byte[] bArr = zzpu.zzbkq;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final zzhp zzv(int i) {
        String str = this.f16448a;
        return new zzhp(str, this.zzagz, this.zzaha, this.zzagx, this.zzagw, i, this.width, this.height, this.zzahe, this.zzahf, this.zzahg, this.f16451d, this.f16450c, this.f16452e, this.zzahk, this.zzahl, this.zzahm, this.f16453f, this.f16454g, this.zzahq, this.zzahr, this.f16455h, this.zzahp, this.zzahc, this.zzahd, this.f16449b);
    }

    public static zzhp zza(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzjo zzjo, int i5, String str4) {
        return zza(str, str2, (String) null, -1, -1, i3, i4, -1, (List<byte[]>) null, zzjo, 0, str4);
    }

    public static zzhp zza(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzjo zzjo, int i6, String str4) {
        return new zzhp(str, (String) null, str2, (String) null, -1, i2, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpu) null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, zzjo, (zzmd) null);
    }

    public static zzhp zza(String str, String str2, String str3, int i, int i2, String str4, zzjo zzjo) {
        return zza(str, str2, (String) null, -1, i2, str4, -1, zzjo, Long.MAX_VALUE, Collections.emptyList());
    }

    public static zzhp zza(String str, String str2, String str3, int i, int i2, String str4, int i3, zzjo zzjo, long j, List<byte[]> list) {
        return new zzhp(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpu) null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzjo, (zzmd) null);
    }

    public static zzhp zza(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzjo zzjo) {
        return new zzhp(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpu) null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzjo, (zzmd) null);
    }

    public static zzhp zza(String str, String str2, long j) {
        return new zzhp((String) null, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpu) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, (List<byte[]>) null, (zzjo) null, (zzmd) null);
    }

    public static zzhp zza(String str, String str2, String str3, int i, zzjo zzjo) {
        return new zzhp(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpu) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, (List<byte[]>) null, zzjo, (zzmd) null);
    }

    public final zzhp zza(zzjo zzjo) {
        String str = this.f16448a;
        return new zzhp(str, this.zzagz, this.zzaha, this.zzagx, this.zzagw, this.zzahb, this.width, this.height, this.zzahe, this.zzahf, this.zzahg, this.f16451d, this.f16450c, this.f16452e, this.zzahk, this.zzahl, this.zzahm, this.f16453f, this.f16454g, this.zzahq, this.zzahr, this.f16455h, this.zzahp, this.zzahc, zzjo, this.f16449b);
    }

    public final zzhp zza(zzmd zzmd) {
        String str = this.f16448a;
        return new zzhp(str, this.zzagz, this.zzaha, this.zzagx, this.zzagw, this.zzahb, this.width, this.height, this.zzahe, this.zzahf, this.zzahg, this.f16451d, this.f16450c, this.f16452e, this.zzahk, this.zzahl, this.zzahm, this.f16453f, this.f16454g, this.zzahq, this.zzahr, this.f16455h, this.zzahp, this.zzahc, this.zzahd, zzmd);
    }

    zzhp(Parcel parcel) {
        this.f16448a = parcel.readString();
        this.zzagz = parcel.readString();
        this.zzaha = parcel.readString();
        this.zzagx = parcel.readString();
        this.zzagw = parcel.readInt();
        this.zzahb = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzahe = parcel.readFloat();
        this.zzahf = parcel.readInt();
        this.zzahg = parcel.readFloat();
        this.f16451d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.f16450c = parcel.readInt();
        this.f16452e = (zzpu) parcel.readParcelable(zzpu.class.getClassLoader());
        this.zzahk = parcel.readInt();
        this.zzahl = parcel.readInt();
        this.zzahm = parcel.readInt();
        this.f16453f = parcel.readInt();
        this.f16454g = parcel.readInt();
        this.zzahq = parcel.readInt();
        this.zzahr = parcel.readString();
        this.f16455h = parcel.readInt();
        this.zzahp = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzahc = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.zzahc.add(parcel.createByteArray());
        }
        this.zzahd = (zzjo) parcel.readParcelable(zzjo.class.getClassLoader());
        this.f16449b = (zzmd) parcel.readParcelable(zzmd.class.getClassLoader());
    }
}
