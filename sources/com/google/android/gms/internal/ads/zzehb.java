package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzehb {

    /* renamed from: a */
    private final zzehs f16164a;

    /* renamed from: b */
    private final zzehs f16165b;

    public zzehb(byte[] bArr, byte[] bArr2) {
        this.f16164a = zzehs.zzr(bArr);
        this.f16165b = zzehs.zzr(bArr2);
    }

    public final byte[] zzbey() {
        zzehs zzehs = this.f16164a;
        if (zzehs == null) {
            return null;
        }
        return zzehs.getBytes();
    }

    public final byte[] zzbez() {
        zzehs zzehs = this.f16165b;
        if (zzehs == null) {
            return null;
        }
        return zzehs.getBytes();
    }
}
