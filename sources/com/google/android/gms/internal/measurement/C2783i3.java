package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.i3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2783i3 extends C2831o3 {

    /* renamed from: d */
    private final int f17344d;

    /* renamed from: e */
    private final int f17345e;

    C2783i3(byte[] bArr, int i, int i2) {
        super(bArr);
        zzgr.m10350d(i, i + i2, bArr.length);
        this.f17344d = i;
        this.f17345e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final byte mo18674c(int i) {
        return this.f17400c[this.f17344d + i];
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final int mo18675g() {
        return this.f17344d;
    }

    public final byte zza(int i) {
        int zza = zza();
        if (((zza - (i + 1)) | i) >= 0) {
            return this.f17400c[this.f17344d + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(zza);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    public final int zza() {
        return this.f17345e;
    }
}
