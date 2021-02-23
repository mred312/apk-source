package com.google.android.gms.internal.measurement;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.i1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2781i1 extends zzdh<Boolean> {
    C2781i1(zzdm zzdm, String str, Boolean bool, boolean z) {
        super(zzdm, str, bool, true, (C2753f1) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ Object mo18624e(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzcp.zzb.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzcp.zzc.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(zzb);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
