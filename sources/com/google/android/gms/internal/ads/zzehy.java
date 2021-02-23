package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzehy implements zzeak {

    /* renamed from: a */
    private final zzedb f16185a;

    /* renamed from: b */
    private final int f16186b;

    public zzehy(zzedb zzedb, int i) {
        this.f16185a = zzedb;
        this.f16186b = i;
        if (i >= 10) {
            zzedb.zzd(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final byte[] zzl(byte[] bArr) {
        return this.f16185a.zzd(bArr, this.f16186b);
    }
}
