package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeal<P> {

    /* renamed from: a */
    private final P f16098a;

    /* renamed from: b */
    private final byte[] f16099b;

    /* renamed from: c */
    private final zzefl f16100c;

    /* renamed from: d */
    private final zzegd f16101d;

    zzeal(P p, byte[] bArr, zzefl zzefl, zzegd zzegd, int i) {
        this.f16098a = p;
        this.f16099b = Arrays.copyOf(bArr, bArr.length);
        this.f16100c = zzefl;
        this.f16101d = zzegd;
    }

    public final P zzbaa() {
        return this.f16098a;
    }

    public final zzefl zzbab() {
        return this.f16100c;
    }

    public final zzegd zzbac() {
        return this.f16101d;
    }

    public final byte[] zzbad() {
        byte[] bArr = this.f16099b;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
