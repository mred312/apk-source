package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzpn {

    /* renamed from: a */
    private int f16835a;

    /* renamed from: b */
    private int f16836b;
    public byte[] data;

    public zzpn() {
    }

    public final int capacity() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int getPosition() {
        return this.f16835a;
    }

    public final int limit() {
        return this.f16836b;
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i = this.f16835a;
        int i2 = i + 1;
        this.f16835a = i2;
        int i3 = i2 + 1;
        this.f16835a = i3;
        byte b = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
        int i4 = i3 + 1;
        this.f16835a = i4;
        byte b2 = b | ((bArr[i3] & 255) << 8);
        this.f16835a = i4 + 1;
        return (bArr[i4] & 255) | b2;
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i = this.f16835a;
        int i2 = i + 1;
        this.f16835a = i2;
        int i3 = i2 + 1;
        this.f16835a = i3;
        int i4 = i3 + 1;
        this.f16835a = i4;
        int i5 = i4 + 1;
        this.f16835a = i5;
        int i6 = i5 + 1;
        this.f16835a = i6;
        int i7 = i6 + 1;
        this.f16835a = i7;
        int i8 = i7 + 1;
        this.f16835a = i8;
        this.f16835a = i8 + 1;
        return (((long) bArr[i8]) & 255) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i2]) & 255) << 48) | ((((long) bArr[i3]) & 255) << 40) | ((((long) bArr[i4]) & 255) << 32) | ((((long) bArr[i5]) & 255) << 24) | ((((long) bArr[i6]) & 255) << 16) | ((((long) bArr[i7]) & 255) << 8);
    }

    public final short readShort() {
        byte[] bArr = this.data;
        int i = this.f16835a;
        int i2 = i + 1;
        this.f16835a = i2;
        this.f16835a = i2 + 1;
        return (short) ((bArr[i2] & 255) | ((bArr[i] & 255) << 8));
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.f16835a;
        this.f16835a = i + 1;
        return bArr[i] & 255;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.f16835a;
        int i2 = i + 1;
        this.f16835a = i2;
        this.f16835a = i2 + 1;
        return (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
    }

    public final void reset(int i) {
        zzc(capacity() < i ? new byte[i] : this.data, i);
    }

    public final void zzbk(int i) {
        zzpc.checkArgument(i >= 0 && i <= this.data.length);
        this.f16836b = i;
    }

    public final void zzbl(int i) {
        zzpc.checkArgument(i >= 0 && i <= this.f16836b);
        this.f16835a = i;
    }

    public final void zzbm(int i) {
        zzbl(this.f16835a + i);
    }

    public final String zzbn(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.f16835a + i) - 1;
        String str = new String(this.data, this.f16835a, (i2 >= this.f16836b || this.data[i2] != 0) ? i : i - 1);
        this.f16835a += i;
        return str;
    }

    public final void zzc(byte[] bArr, int i) {
        this.data = bArr;
        this.f16836b = i;
        this.f16835a = 0;
    }

    public final void zze(byte[] bArr, int i, int i2) {
        System.arraycopy(this.data, this.f16835a, bArr, i, i2);
        this.f16835a += i2;
    }

    public final int zzja() {
        return this.f16836b - this.f16835a;
    }

    public final int zzjb() {
        byte[] bArr = this.data;
        int i = this.f16835a;
        int i2 = i + 1;
        this.f16835a = i2;
        this.f16835a = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (bArr[i] & 255);
    }

    public final long zzjc() {
        byte[] bArr = this.data;
        int i = this.f16835a;
        int i2 = i + 1;
        this.f16835a = i2;
        int i3 = i2 + 1;
        this.f16835a = i3;
        int i4 = i3 + 1;
        this.f16835a = i4;
        this.f16835a = i4 + 1;
        return (((long) bArr[i4]) & 255) | ((((long) bArr[i]) & 255) << 24) | ((((long) bArr[i2]) & 255) << 16) | ((((long) bArr[i3]) & 255) << 8);
    }

    public final long zzjd() {
        byte[] bArr = this.data;
        int i = this.f16835a;
        int i2 = i + 1;
        this.f16835a = i2;
        int i3 = i2 + 1;
        this.f16835a = i3;
        int i4 = i3 + 1;
        this.f16835a = i4;
        this.f16835a = i4 + 1;
        return ((((long) bArr[i4]) & 255) << 24) | (((long) bArr[i]) & 255) | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16);
    }

    public final int zzje() {
        byte[] bArr = this.data;
        int i = this.f16835a;
        int i2 = i + 1;
        this.f16835a = i2;
        int i3 = i2 + 1;
        this.f16835a = i3;
        byte b = (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
        this.f16835a = i3 + 2;
        return b;
    }

    public final int zzjf() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(readInt);
        throw new IllegalStateException(sb.toString());
    }

    public final long zzjg() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(readLong);
        throw new IllegalStateException(sb.toString());
    }

    public final String zzjh() {
        if (zzja() == 0) {
            return null;
        }
        int i = this.f16835a;
        while (i < this.f16836b && this.data[i] != 0) {
            i++;
        }
        byte[] bArr = this.data;
        int i2 = this.f16835a;
        String str = new String(bArr, i2, i - i2);
        this.f16835a = i;
        if (i < this.f16836b) {
            this.f16835a = i + 1;
        }
        return str;
    }

    public zzpn(int i) {
        this.data = new byte[i];
        this.f16836b = i;
    }

    public final void reset() {
        this.f16835a = 0;
        this.f16836b = 0;
    }

    public zzpn(byte[] bArr) {
        this.data = bArr;
        this.f16836b = bArr.length;
    }
}
