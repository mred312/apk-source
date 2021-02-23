package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzehi implements zzdzt {

    /* renamed from: a */
    private final zzehr f16174a;

    /* renamed from: b */
    private final zzeak f16175b;

    public zzehi(zzehr zzehr, zzeak zzeak, int i) {
        this.f16174a = zzehr;
        this.f16175b = zzeak;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] zzn = this.f16174a.zzn(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return zzegr.zza(zzn, this.f16175b.zzl(zzegr.zza(bArr2, zzn, copyOf)));
    }
}
