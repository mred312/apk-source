package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.o4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2832o4 extends C2800k4 {
    private C2832o4() {
        super();
    }

    /* renamed from: f */
    private static <E> zzii<E> m9689f(Object obj, long j) {
        return (zzii) C2758f6.m9413F(obj, j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final <L> List<L> mo18691b(Object obj, long j) {
        zzii f = m9689f(obj, j);
        if (f.zza()) {
            return f;
        }
        int size = f.size();
        zzii zza = f.zza(size == 0 ? 10 : size << 1);
        C2758f6.m9432j(obj, j, zza);
        return zza;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final <E> void mo18692c(Object obj, Object obj2, long j) {
        zzii f = m9689f(obj, j);
        zzii f2 = m9689f(obj2, j);
        int size = f.size();
        int size2 = f2.size();
        if (size > 0 && size2 > 0) {
            if (!f.zza()) {
                f = f.zza(size2 + size);
            }
            f.addAll(f2);
        }
        if (size > 0) {
            f2 = f;
        }
        C2758f6.m9432j(obj, j, f2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo18693e(Object obj, long j) {
        m9689f(obj, j).zzb();
    }
}
