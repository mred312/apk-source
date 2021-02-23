package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzebv implements zzdzt {

    /* renamed from: c */
    private static final byte[] f16114c = new byte[0];

    /* renamed from: a */
    private final zzefn f16115a;

    /* renamed from: b */
    private final zzdzt f16116b;

    public zzebv(zzefn zzefn, zzdzt zzdzt) {
        this.f16115a = zzefn;
        this.f16116b = zzdzt;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] byteArray = zzeap.zzb(this.f16115a).toByteArray();
        byte[] zzc = this.f16116b.zzc(byteArray, f16114c);
        byte[] zzc2 = ((zzdzt) zzeap.zza(this.f16115a.zzbdf(), byteArray, zzdzt.class)).zzc(bArr, bArr2);
        return ByteBuffer.allocate(zzc.length + 4 + zzc2.length).putInt(zzc.length).put(zzc).put(zzc2).array();
    }
}
