package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class th0 implements Comparator<zzry> {
    th0(zzrt zzrt) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzry zzry = (zzry) obj;
        zzry zzry2 = (zzry) obj2;
        int i = zzry.f16967c - zzry2.f16967c;
        if (i != 0) {
            return i;
        }
        return (int) (zzry.f16965a - zzry2.f16965a);
    }
}
