package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzsd implements Comparator<zzrr> {
    public zzsd(zzsa zzsa) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzrr zzrr = (zzrr) obj;
        zzrr zzrr2 = (zzrr) obj2;
        if (zzrr.mo18203b() < zzrr2.mo18203b()) {
            return -1;
        }
        if (zzrr.mo18203b() > zzrr2.mo18203b()) {
            return 1;
        }
        if (zzrr.mo18202a() < zzrr2.mo18202a()) {
            return -1;
        }
        if (zzrr.mo18202a() > zzrr2.mo18202a()) {
            return 1;
        }
        float d = (zzrr.mo18205d() - zzrr.mo18203b()) * (zzrr.mo18204c() - zzrr.mo18202a());
        float d2 = (zzrr2.mo18205d() - zzrr2.mo18203b()) * (zzrr2.mo18204c() - zzrr2.mo18202a());
        if (d > d2) {
            return -1;
        }
        if (d < d2) {
            return 1;
        }
        return 0;
    }
}
