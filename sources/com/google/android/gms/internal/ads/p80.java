package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class p80 extends r80 {

    /* renamed from: d */
    private final int f10455d;

    /* renamed from: e */
    private final int f10456e;

    p80(byte[] bArr, int i, int i2) {
        super(bArr);
        zzeiu.m8790f(i, i + i2, bArr.length);
        this.f10455d = i;
        this.f10456e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final byte mo14574d(int i) {
        return this.f10771c[this.f10455d + i];
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final int mo14575i() {
        return this.f10455d;
    }

    public final int size() {
        return this.f10456e;
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f10771c, mo14575i() + i, bArr, i2, i3);
    }

    public final byte zzfy(int i) {
        zzeiu.m8788c(i, size());
        return this.f10771c[this.f10455d + i];
    }
}
