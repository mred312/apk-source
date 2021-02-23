package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.l4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2808l4 extends C2800k4 {

    /* renamed from: c */
    private static final Class<?> f17370c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private C2808l4() {
        super();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.measurement.zzip} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.measurement.zzip} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.measurement.zzip} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> m9564f(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = m9565g(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzis
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.measurement.zzip r0 = new com.google.android.gms.internal.measurement.zzip
            r0.<init>((int) r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C2757f5
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzii
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.measurement.zzii r0 = (com.google.android.gms.internal.measurement.zzii) r0
            com.google.android.gms.internal.measurement.zzii r6 = r0.zza(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.measurement.C2758f6.m9432j(r3, r4, r0)
            goto L_0x007f
        L_0x002d:
            java.lang.Class<?> r1 = f17370c
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.measurement.C2758f6.m9432j(r3, r4, r1)
        L_0x0049:
            r0 = r1
            goto L_0x007f
        L_0x004b:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzkw
            if (r1 == 0) goto L_0x0062
            com.google.android.gms.internal.measurement.zzip r1 = new com.google.android.gms.internal.measurement.zzip
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.measurement.zzkw r0 = (com.google.android.gms.internal.measurement.zzkw) r0
            r1.addAll(r0)
            com.google.android.gms.internal.measurement.C2758f6.m9432j(r3, r4, r1)
            goto L_0x0049
        L_0x0062:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C2757f5
            if (r1 == 0) goto L_0x007f
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzii
            if (r1 == 0) goto L_0x007f
            r1 = r0
            com.google.android.gms.internal.measurement.zzii r1 = (com.google.android.gms.internal.measurement.zzii) r1
            boolean r2 = r1.zza()
            if (r2 != 0) goto L_0x007f
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.measurement.zzii r0 = r1.zza(r0)
            com.google.android.gms.internal.measurement.C2758f6.m9432j(r3, r4, r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2808l4.m9564f(java.lang.Object, long, int):java.util.List");
    }

    /* renamed from: g */
    private static <E> List<E> m9565g(Object obj, long j) {
        return (List) C2758f6.m9413F(obj, j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final <L> List<L> mo18691b(Object obj, long j) {
        return m9564f(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final <E> void mo18692c(Object obj, Object obj2, long j) {
        List g = m9565g(obj2, j);
        List f = m9564f(obj, j, g.size());
        int size = f.size();
        int size2 = g.size();
        if (size > 0 && size2 > 0) {
            f.addAll(g);
        }
        if (size > 0) {
            g = f;
        }
        C2758f6.m9432j(obj, j, g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo18693e(Object obj, long j) {
        Object obj2;
        List list = (List) C2758f6.m9413F(obj, j);
        if (list instanceof zzis) {
            obj2 = ((zzis) list).zze();
        } else if (!f17370c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof C2757f5) || !(list instanceof zzii)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzii zzii = (zzii) list;
                if (zzii.zza()) {
                    zzii.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        C2758f6.m9432j(obj, j, obj2);
    }
}
