package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzor implements zzol {

    /* renamed from: a */
    private final boolean f16806a;

    /* renamed from: b */
    private final int f16807b;

    /* renamed from: c */
    private final zzoi[] f16808c;

    /* renamed from: d */
    private int f16809d;

    /* renamed from: e */
    private int f16810e;

    /* renamed from: f */
    private int f16811f;

    /* renamed from: g */
    private zzoi[] f16812g;

    public zzor(boolean z, int i) {
        this(true, 65536, 0);
    }

    public final synchronized void reset() {
        if (this.f16806a) {
            zzbf(0);
        }
    }

    public final synchronized void zza(zzoi zzoi) {
        zzoi[] zzoiArr = this.f16808c;
        zzoiArr[0] = zzoi;
        zza(zzoiArr);
    }

    public final synchronized void zzbf(int i) {
        boolean z = i < this.f16809d;
        this.f16809d = i;
        if (z) {
            zzn();
        }
    }

    public final synchronized zzoi zzin() {
        zzoi zzoi;
        this.f16810e++;
        int i = this.f16811f;
        if (i > 0) {
            zzoi[] zzoiArr = this.f16812g;
            int i2 = i - 1;
            this.f16811f = i2;
            zzoi = zzoiArr[i2];
            zzoiArr[i2] = null;
        } else {
            zzoi = new zzoi(new byte[this.f16807b], 0);
        }
        return zzoi;
    }

    public final int zzio() {
        return this.f16807b;
    }

    public final synchronized int zzir() {
        return this.f16810e * this.f16807b;
    }

    public final synchronized void zzn() {
        int max = Math.max(0, zzpt.zzf(this.f16809d, this.f16807b) - this.f16810e);
        int i = this.f16811f;
        if (max < i) {
            Arrays.fill(this.f16812g, max, i, (Object) null);
            this.f16811f = max;
        }
    }

    private zzor(boolean z, int i, int i2) {
        zzpc.checkArgument(true);
        zzpc.checkArgument(true);
        this.f16806a = true;
        this.f16807b = 65536;
        this.f16811f = 0;
        this.f16812g = new zzoi[100];
        this.f16808c = new zzoi[1];
    }

    public final synchronized void zza(zzoi[] zzoiArr) {
        boolean z;
        int i = this.f16811f;
        int length = zzoiArr.length + i;
        zzoi[] zzoiArr2 = this.f16812g;
        if (length >= zzoiArr2.length) {
            this.f16812g = (zzoi[]) Arrays.copyOf(zzoiArr2, Math.max(zzoiArr2.length << 1, i + zzoiArr.length));
        }
        for (zzoi zzoi : zzoiArr) {
            byte[] bArr = zzoi.data;
            if (bArr != null) {
                if (bArr.length != this.f16807b) {
                    z = false;
                    zzpc.checkArgument(z);
                    zzoi[] zzoiArr3 = this.f16812g;
                    int i2 = this.f16811f;
                    this.f16811f = i2 + 1;
                    zzoiArr3[i2] = zzoi;
                }
            }
            z = true;
            zzpc.checkArgument(z);
            zzoi[] zzoiArr32 = this.f16812g;
            int i22 = this.f16811f;
            this.f16811f = i22 + 1;
            zzoiArr32[i22] = zzoi;
        }
        this.f16810e -= zzoiArr.length;
        notifyAll();
    }
}
