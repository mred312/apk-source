package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.t4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2872t4 implements C2880u4 {
    C2872t4() {
    }

    /* renamed from: a */
    public final Map<?, ?> mo18859a(Object obj) {
        return (zzjb) obj;
    }

    /* renamed from: b */
    public final boolean mo18860b(Object obj) {
        return !((zzjb) obj).zzd();
    }

    /* renamed from: c */
    public final Map<?, ?> mo18861c(Object obj) {
        return (zzjb) obj;
    }

    /* renamed from: d */
    public final Object mo18862d(Object obj, Object obj2) {
        zzjb zzjb = (zzjb) obj;
        zzjb zzjb2 = (zzjb) obj2;
        if (!zzjb2.isEmpty()) {
            if (!zzjb.zzd()) {
                zzjb = zzjb.zzb();
            }
            zzjb.zza(zzjb2);
        }
        return zzjb;
    }

    /* renamed from: e */
    public final int mo18863e(int i, Object obj, Object obj2) {
        zzjb zzjb = (zzjb) obj;
        zziz zziz = (zziz) obj2;
        if (zzjb.isEmpty()) {
            return 0;
        }
        Iterator it = zzjb.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    public final C2864s4<?, ?> zzb(Object obj) {
        zziz zziz = (zziz) obj;
        throw new NoSuchMethodError();
    }

    public final Object zze(Object obj) {
        ((zzjb) obj).zzc();
        return obj;
    }

    public final Object zzf(Object obj) {
        return zzjb.zza().zzb();
    }
}
