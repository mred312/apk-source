package com.google.android.gms.internal.measurement;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.h1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2773h1 extends zzdh<Double> {
    C2773h1(zzdm zzdm, String str, Double d, boolean z) {
        super(zzdm, str, d, true, (C2753f1) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public final Double mo18624e(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 27 + String.valueOf(valueOf).length());
        sb.append("Invalid double value for ");
        sb.append(zzb);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
