package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzmp implements zznm {

    /* renamed from: a */
    private final zznm[] f16734a;

    public zzmp(zznm[] zznmArr) {
        this.f16734a = zznmArr;
    }

    public final boolean zzef(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzhp = zzhp();
            if (zzhp == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zznm zznm : this.f16734a) {
                if (zznm.zzhp() == zzhp) {
                    z |= zznm.zzef(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    public final long zzhp() {
        long j = Long.MAX_VALUE;
        for (zznm zzhp : this.f16734a) {
            long zzhp2 = zzhp.zzhp();
            if (zzhp2 != Long.MIN_VALUE) {
                j = Math.min(j, zzhp2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }
}
