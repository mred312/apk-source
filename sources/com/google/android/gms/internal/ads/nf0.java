package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class nf0 {

    /* renamed from: a */
    public final int f10185a;

    /* renamed from: b */
    public final long[] f10186b;

    /* renamed from: c */
    public final int[] f10187c;

    /* renamed from: d */
    public final int f10188d;

    /* renamed from: e */
    public final long[] f10189e;

    /* renamed from: f */
    public final int[] f10190f;

    public nf0(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        zzpc.checkArgument(iArr.length == jArr2.length);
        zzpc.checkArgument(jArr.length == jArr2.length);
        zzpc.checkArgument(iArr2.length != jArr2.length ? false : z);
        this.f10186b = jArr;
        this.f10187c = iArr;
        this.f10188d = i;
        this.f10189e = jArr2;
        this.f10190f = iArr2;
        this.f10185a = jArr.length;
    }

    /* renamed from: a */
    public final int mo14489a(long j) {
        for (int zza = zzpt.zza(this.f10189e, j, true, false); zza >= 0; zza--) {
            if ((this.f10190f[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public final int mo14490b(long j) {
        for (int zzb = zzpt.zzb(this.f10189e, j, true, false); zzb < this.f10189e.length; zzb++) {
            if ((this.f10190f[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
