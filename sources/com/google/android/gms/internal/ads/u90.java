package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class u90 extends s90 {

    /* renamed from: c */
    private static final Class<?> f11301c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private u90() {
        super();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.ads.zzela} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.ads.zzela} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.ads.zzela} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> m7035f(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = m7036g(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzekz
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzela r0 = new com.google.android.gms.internal.ads.zzela
            r0.<init>((int) r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.na0
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzekp
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzekp r0 = (com.google.android.gms.internal.ads.zzekp) r0
            com.google.android.gms.internal.ads.zzekp r6 = r0.zzfx(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.ads.sb0.m6911f(r3, r4, r0)
            goto L_0x007f
        L_0x002d:
            java.lang.Class<?> r1 = f11301c
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.ads.sb0.m6911f(r3, r4, r1)
        L_0x0049:
            r0 = r1
            goto L_0x007f
        L_0x004b:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzenk
            if (r1 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzela r1 = new com.google.android.gms.internal.ads.zzela
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.ads.zzenk r0 = (com.google.android.gms.internal.ads.zzenk) r0
            r1.addAll(r0)
            com.google.android.gms.internal.ads.sb0.m6911f(r3, r4, r1)
            goto L_0x0049
        L_0x0062:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.na0
            if (r1 == 0) goto L_0x007f
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzekp
            if (r1 == 0) goto L_0x007f
            r1 = r0
            com.google.android.gms.internal.ads.zzekp r1 = (com.google.android.gms.internal.ads.zzekp) r1
            boolean r2 = r1.zzbfk()
            if (r2 != 0) goto L_0x007f
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.ads.zzekp r0 = r1.zzfx(r0)
            com.google.android.gms.internal.ads.sb0.m6911f(r3, r4, r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.u90.m7035f(java.lang.Object, long, int):java.util.List");
    }

    /* renamed from: g */
    private static <E> List<E> m7036g(Object obj, long j) {
        return (List) sb0.m6897G(obj, j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final <L> List<L> mo14772a(Object obj, long j) {
        return m7035f(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final <E> void mo14773b(Object obj, Object obj2, long j) {
        List g = m7036g(obj2, j);
        List f = m7035f(obj, j, g.size());
        int size = f.size();
        int size2 = g.size();
        if (size > 0 && size2 > 0) {
            f.addAll(g);
        }
        if (size > 0) {
            g = f;
        }
        sb0.m6911f(obj, j, g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo14774c(Object obj, long j) {
        Object obj2;
        List list = (List) sb0.m6897G(obj, j);
        if (list instanceof zzekz) {
            obj2 = ((zzekz) list).zzbiv();
        } else if (!f11301c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof na0) || !(list instanceof zzekp)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzekp zzekp = (zzekp) list;
                if (zzekp.zzbfk()) {
                    zzekp.zzbfl();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        sb0.m6911f(obj, j, obj2);
    }
}
