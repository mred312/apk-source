package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.a5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2717a5<T> implements C2793j5<T> {

    /* renamed from: a */
    private final zzjh f17217a;

    /* renamed from: b */
    private final C2734c6<?, ?> f17218b;

    /* renamed from: c */
    private final boolean f17219c;

    /* renamed from: d */
    private final C2902x3<?> f17220d;

    private C2717a5(C2734c6<?, ?> c6Var, C2902x3<?> x3Var, zzjh zzjh) {
        this.f17218b = c6Var;
        this.f17219c = x3Var.mo18945h(zzjh);
        this.f17220d = x3Var;
        this.f17217a = zzjh;
    }

    /* renamed from: i */
    static <T> C2717a5<T> m9305i(C2734c6<?, ?> c6Var, C2902x3<?> x3Var, zzjh zzjh) {
        return new C2717a5<>(c6Var, x3Var, zzjh);
    }

    /* renamed from: a */
    public final int mo18541a(T t) {
        int hashCode = this.f17218b.mo18594k(t).hashCode();
        return this.f17219c ? (hashCode * 53) + this.f17220d.mo18939b(t).hashCode() : hashCode;
    }

    /* renamed from: b */
    public final boolean mo18542b(T t) {
        return this.f17220d.mo18939b(t).mo18990r();
    }

    /* renamed from: c */
    public final void mo18543c(T t) {
        this.f17218b.mo18600q(t);
        this.f17220d.mo18947j(t);
    }

    /* renamed from: d */
    public final boolean mo18544d(T t, T t2) {
        if (!this.f17218b.mo18594k(t).equals(this.f17218b.mo18594k(t2))) {
            return false;
        }
        if (this.f17219c) {
            return this.f17220d.mo18939b(t).equals(this.f17220d.mo18939b(t2));
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzhz$zzd} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo18545e(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.C2739d3 r14) {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzhz r0 = (com.google.android.gms.internal.measurement.zzhz) r0
            com.google.android.gms.internal.measurement.zzku r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzku r2 = com.google.android.gms.internal.measurement.zzku.zza()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.zzku r1 = com.google.android.gms.internal.measurement.zzku.m10404f()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.measurement.zzhz$zzb r10 = (com.google.android.gms.internal.measurement.zzhz.zzb) r10
            r10.mo19532e()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.measurement.C2747e3.m9386i(r11, r12, r14)
            int r2 = r14.f17257a
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.measurement.x3<?> r12 = r9.f17220d
            com.google.android.gms.internal.measurement.zzhm r0 = r14.f17260d
            com.google.android.gms.internal.measurement.zzjh r3 = r9.f17217a
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.mo18940c(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzhz$zzd r0 = (com.google.android.gms.internal.measurement.zzhz.zzd) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.C2747e3.m9380c(r2, r3, r4, r5, r6, r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.measurement.C2769g5.m9493a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.measurement.C2747e3.m9378a(r2, r11, r4, r13, r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.C2747e3.m9386i(r11, r4, r14)
            int r5 = r14.f17257a
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.C2747e3.m9394q(r11, r4, r14)
            java.lang.Object r2 = r14.f17259c
            com.google.android.gms.internal.measurement.zzgr r2 = (com.google.android.gms.internal.measurement.zzgr) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.measurement.C2769g5.m9493a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.C2747e3.m9386i(r11, r4, r14)
            int r12 = r14.f17257a
            com.google.android.gms.internal.measurement.x3<?> r0 = r9.f17220d
            com.google.android.gms.internal.measurement.zzhm r5 = r14.f17260d
            com.google.android.gms.internal.measurement.zzjh r6 = r9.f17217a
            java.lang.Object r0 = r0.mo18940c(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzhz$zzd r0 = (com.google.android.gms.internal.measurement.zzhz.zzd) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.C2747e3.m9378a(r5, r11, r4, r13, r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.mo19557b(r12, r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.measurement.zzih r10 = com.google.android.gms.internal.measurement.zzih.m10393g()
            goto L_0x00ad
        L_0x00ac:
            throw r10
        L_0x00ad:
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2717a5.mo18545e(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.d3):void");
    }

    /* renamed from: f */
    public final void mo18546f(T t, C2882u6 u6Var) {
        Iterator<Map.Entry<?, Object>> p = this.f17220d.mo18939b(t).mo18988p();
        while (p.hasNext()) {
            Map.Entry next = p.next();
            zzhr zzhr = (zzhr) next.getKey();
            if (zzhr.zzc() != zzll.MESSAGE || zzhr.zzd() || zzhr.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof C2792j4) {
                u6Var.zza(zzhr.zza(), (Object) ((C2792j4) next).mo18684a().zzc());
            } else {
                u6Var.zza(zzhr.zza(), next.getValue());
            }
        }
        C2734c6<?, ?> c6Var = this.f17218b;
        c6Var.mo18596m(c6Var.mo18594k(t), u6Var);
    }

    /* renamed from: g */
    public final void mo18547g(T t, C2809l5 l5Var, zzhm zzhm) {
        boolean z;
        C2734c6<?, ?> c6Var = this.f17218b;
        C2902x3<?> x3Var = this.f17220d;
        Object o = c6Var.mo18598o(t);
        C2909y3<?> i = x3Var.mo18946i(t);
        do {
            try {
                if (l5Var.zza() == Integer.MAX_VALUE) {
                    c6Var.mo18597n(t, o);
                    return;
                }
                int zzb = l5Var.zzb();
                if (zzb == 11) {
                    int i2 = 0;
                    Object obj = null;
                    zzgr zzgr = null;
                    while (l5Var.zza() != Integer.MAX_VALUE) {
                        int zzb2 = l5Var.zzb();
                        if (zzb2 == 16) {
                            i2 = l5Var.zzo();
                            obj = x3Var.mo18940c(zzhm, this.f17217a, i2);
                        } else if (zzb2 == 26) {
                            if (obj != null) {
                                x3Var.mo18943f(l5Var, obj, zzhm, i);
                            } else {
                                zzgr = l5Var.zzn();
                            }
                        } else if (!l5Var.zzc()) {
                            break;
                        }
                    }
                    if (l5Var.zzb() != 12) {
                        throw zzih.m10391e();
                    } else if (zzgr != null) {
                        if (obj != null) {
                            x3Var.mo18942e(zzgr, obj, zzhm, i);
                        } else {
                            c6Var.mo18588e(o, i2, zzgr);
                        }
                    }
                } else if ((zzb & 7) == 2) {
                    Object c = x3Var.mo18940c(zzhm, this.f17217a, zzb >>> 3);
                    if (c != null) {
                        x3Var.mo18943f(l5Var, c, zzhm, i);
                    } else {
                        z = c6Var.mo18593j(o, l5Var);
                        continue;
                    }
                } else {
                    z = l5Var.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                c6Var.mo18597n(t, o);
            }
        } while (z);
    }

    /* renamed from: h */
    public final void mo18548h(T t, T t2) {
        C2817m5.m9652o(this.f17218b, t, t2);
        if (this.f17219c) {
            C2817m5.m9650m(this.f17220d, t, t2);
        }
    }

    public final T zza() {
        return this.f17217a.zzbt().zzy();
    }

    public final int zzb(T t) {
        C2734c6<?, ?> c6Var = this.f17218b;
        int r = c6Var.mo18601r(c6Var.mo18594k(t)) + 0;
        return this.f17219c ? r + this.f17220d.mo18939b(t).mo18991s() : r;
    }
}
