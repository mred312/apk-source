package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class t90 extends s90 {
    private t90() {
        super();
    }

    /* renamed from: f */
    private static <E> zzekp<E> m6997f(Object obj, long j) {
        return (zzekp) sb0.m6897G(obj, j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final <L> List<L> mo14772a(Object obj, long j) {
        zzekp f = m6997f(obj, j);
        if (f.zzbfk()) {
            return f;
        }
        int size = f.size();
        zzekp zzfx = f.zzfx(size == 0 ? 10 : size << 1);
        sb0.m6911f(obj, j, zzfx);
        return zzfx;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final <E> void mo14773b(Object obj, Object obj2, long j) {
        zzekp f = m6997f(obj, j);
        zzekp f2 = m6997f(obj2, j);
        int size = f.size();
        int size2 = f2.size();
        if (size > 0 && size2 > 0) {
            if (!f.zzbfk()) {
                f = f.zzfx(size2 + size);
            }
            f.addAll(f2);
        }
        if (size > 0) {
            f2 = f;
        }
        sb0.m6911f(obj, j, f2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo14774c(Object obj, long j) {
        m6997f(obj, j).zzbfl();
    }
}
