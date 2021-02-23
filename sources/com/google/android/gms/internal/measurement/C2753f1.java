package com.google.android.gms.internal.measurement;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.f1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2753f1 extends zzdh<Long> {
    C2753f1(zzdm zzdm, String str, Long l, boolean z) {
        super(zzdm, str, l, true, (C2753f1) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public final Long mo18624e(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 25 + String.valueOf(valueOf).length());
        sb.append("Invalid long value for ");
        sb.append(zzb);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
