package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzju implements zzkf {

    /* renamed from: a */
    private final int f16555a;

    /* renamed from: b */
    private final long[] f16556b;

    /* renamed from: c */
    private final long[] f16557c;

    /* renamed from: d */
    private final long f16558d;

    public zzju(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f16556b = jArr;
        this.f16557c = jArr3;
        int length = iArr.length;
        this.f16555a = length;
        if (length > 0) {
            this.f16558d = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f16558d = 0;
        }
    }

    public final long getDurationUs() {
        return this.f16558d;
    }

    public final boolean isSeekable() {
        return true;
    }

    public final long zzdz(long j) {
        return this.f16556b[zzpt.zza(this.f16557c, j, true, true)];
    }
}
