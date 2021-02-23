package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzat {
    private final String[] zzeee;
    private final double[] zzeef;
    private final double[] zzeeg;
    private final int[] zzeeh;
    private int zzeei;

    private zzat(zzay zzay) {
        int size = zzay.zzeeq.size();
        this.zzeee = (String[]) zzay.zzeep.toArray(new String[size]);
        this.zzeef = zzg(zzay.zzeeq);
        this.zzeeg = zzg(zzay.zzeer);
        this.zzeeh = new int[size];
        this.zzeei = 0;
    }

    private static double[] zzg(List<Double> list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d) {
        this.zzeei++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzeeg;
            if (i < dArr.length) {
                if (dArr[i] <= d && d < this.zzeef[i]) {
                    int[] iArr = this.zzeeh;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= dArr[i]) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final List<zzav> zzyu() {
        ArrayList arrayList = new ArrayList(this.zzeee.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzeee;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.zzeeg[i];
            double d2 = this.zzeef[i];
            int[] iArr = this.zzeeh;
            double d3 = (double) iArr[i];
            double d4 = (double) this.zzeei;
            Double.isNaN(d3);
            Double.isNaN(d4);
            arrayList.add(new zzav(str, d, d2, d3 / d4, iArr[i]));
            i++;
        }
    }
}
