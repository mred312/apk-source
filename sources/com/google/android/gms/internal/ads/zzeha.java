package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.interfaces.ECPublicKey;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeha implements zzeaa {

    /* renamed from: f */
    private static final byte[] f16158f = new byte[0];

    /* renamed from: a */
    private final zzehc f16159a;

    /* renamed from: b */
    private final String f16160b;

    /* renamed from: c */
    private final byte[] f16161c;

    /* renamed from: d */
    private final zzehf f16162d;

    /* renamed from: e */
    private final zzegy f16163e;

    public zzeha(ECPublicKey eCPublicKey, byte[] bArr, String str, zzehf zzehf, zzegy zzegy) {
        zzehe.m8775b(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.f16159a = new zzehc(eCPublicKey);
        this.f16161c = bArr;
        this.f16160b = str;
        this.f16162d = zzehf;
        this.f16163e = zzegy;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        zzehb zza = this.f16159a.zza(this.f16160b, this.f16161c, bArr2, this.f16163e.zzbal(), this.f16162d);
        byte[] zzc = this.f16163e.zzm(zza.zzbez()).zzc(bArr, f16158f);
        byte[] zzbey = zza.zzbey();
        return ByteBuffer.allocate(zzbey.length + zzc.length).put(zzbey).put(zzc).array();
    }
}
