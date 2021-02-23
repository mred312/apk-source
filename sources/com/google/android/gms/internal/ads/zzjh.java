package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzjh {

    /* renamed from: a */
    private byte[] f16542a;

    /* renamed from: b */
    private int f16543b;

    /* renamed from: c */
    private int f16544c;

    /* renamed from: d */
    private final MediaCodec.CryptoInfo f16545d;

    /* renamed from: e */
    private final he0 f16546e;

    /* renamed from: iv */
    public byte[] f16547iv;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;

    public zzjh() {
        int i = zzpt.SDK_INT;
        he0 he0 = null;
        MediaCodec.CryptoInfo cryptoInfo = i >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.f16545d = cryptoInfo;
        this.f16546e = i >= 24 ? new he0(cryptoInfo) : he0;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.f16544c = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.f16542a = bArr;
        this.f16547iv = bArr2;
        this.f16543b = i2;
        int i3 = zzpt.SDK_INT;
        if (i3 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.f16545d;
            cryptoInfo.numSubSamples = i;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = i2;
            if (i3 >= 24) {
                this.f16546e.m6285a(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzgj() {
        return this.f16545d;
    }
}
