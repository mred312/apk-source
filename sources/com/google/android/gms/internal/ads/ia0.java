package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class ia0<T> implements wa0<T> {

    /* renamed from: a */
    private final zzels f9304a;

    /* renamed from: b */
    private final pb0<?, ?> f9305b;

    /* renamed from: c */
    private final boolean f9306c;

    /* renamed from: d */
    private final d90<?> f9307d;

    private ia0(pb0<?, ?> pb0, d90<?> d90, zzels zzels) {
        this.f9305b = pb0;
        this.f9306c = d90.mo13761j(zzels);
        this.f9307d = d90;
        this.f9304a = zzels;
    }

    /* renamed from: a */
    static <T> ia0<T> m6321a(pb0<?, ?> pb0, d90<?> d90, zzels zzels) {
        return new ia0<>(pb0, d90, zzels);
    }

    /* renamed from: b */
    public final boolean mo14189b(T t, T t2) {
        if (!this.f9305b.mo14595j(t).equals(this.f9305b.mo14595j(t2))) {
            return false;
        }
        if (this.f9306c) {
            return this.f9307d.mo13758g(t).equals(this.f9307d.mo13758g(t2));
        }
        return true;
    }

    /* renamed from: c */
    public final T mo14190c() {
        return this.f9304a.zzbie().zzbhu();
    }

    /* renamed from: d */
    public final int mo14191d(T t) {
        int hashCode = this.f9305b.mo14595j(t).hashCode();
        return this.f9306c ? (hashCode * 53) + this.f9307d.mo13758g(t).hashCode() : hashCode;
    }

    /* renamed from: e */
    public final boolean mo14192e(T t) {
        return this.f9307d.mo13758g(t).mo13878c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.ads.zzekh$zzd} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo14193f(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.ads.k80 r14) {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.ads.zzekh r0 = (com.google.android.gms.internal.ads.zzekh) r0
            com.google.android.gms.internal.ads.zzeni r1 = r0.zzino
            com.google.android.gms.internal.ads.zzeni r2 = com.google.android.gms.internal.ads.zzeni.zzbkg()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.ads.zzeni r1 = com.google.android.gms.internal.ads.zzeni.m8845e()
            r0.zzino = r1
        L_0x0011:
            com.google.android.gms.internal.ads.zzekh$zzb r10 = (com.google.android.gms.internal.ads.zzekh.zzb) r10
            r10.mo17674i()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.ads.h80.m6118h(r11, r12, r14)
            int r2 = r14.f9575a
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.ads.d90<?> r12 = r9.f9307d
            com.google.android.gms.internal.ads.zzeju r0 = r14.f9578d
            com.google.android.gms.internal.ads.zzels r3 = r9.f9304a
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.mo13753b(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.ads.zzekh$zzd r0 = (com.google.android.gms.internal.ads.zzekh.zzd) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.ads.h80.m6113c(r2, r3, r4, r5, r6, r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.ads.pa0.m6655b()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.ads.h80.m6111a(r2, r11, r4, r13, r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.ads.h80.m6118h(r11, r4, r14)
            int r5 = r14.f9575a
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.ads.h80.m6123m(r11, r4, r14)
            java.lang.Object r2 = r14.f9577c
            com.google.android.gms.internal.ads.zzeiu r2 = (com.google.android.gms.internal.ads.zzeiu) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.ads.pa0.m6655b()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.ads.h80.m6118h(r11, r4, r14)
            int r12 = r14.f9575a
            com.google.android.gms.internal.ads.d90<?> r0 = r9.f9307d
            com.google.android.gms.internal.ads.zzeju r5 = r14.f9578d
            com.google.android.gms.internal.ads.zzels r6 = r9.f9304a
            java.lang.Object r0 = r0.mo13753b(r5, r6, r12)
            com.google.android.gms.internal.ads.zzekh$zzd r0 = (com.google.android.gms.internal.ads.zzekh.zzd) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.ads.h80.m6111a(r5, r11, r4, r13, r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.mo17703f(r12, r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.ads.zzeks r10 = com.google.android.gms.internal.ads.zzeks.m8835h()
            goto L_0x00ad
        L_0x00ac:
            throw r10
        L_0x00ad:
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ia0.mo14193f(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.k80):void");
    }

    /* renamed from: g */
    public final void mo14194g(T t, qa0 qa0, zzeju zzeju) {
        boolean z;
        pb0<?, ?> pb0 = this.f9305b;
        d90<?> d90 = this.f9307d;
        Object k = pb0.mo14596k(t);
        e90<?> h = d90.mo13759h(t);
        do {
            try {
                if (qa0.mo14648D() == Integer.MAX_VALUE) {
                    pb0.mo14603r(t, k);
                    return;
                }
                int tag = qa0.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzeiu zzeiu = null;
                    while (qa0.mo14648D() != Integer.MAX_VALUE) {
                        int tag2 = qa0.getTag();
                        if (tag2 == 16) {
                            i = qa0.mo14654J();
                            obj = d90.mo13753b(zzeju, this.f9304a, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                d90.mo13756e(qa0, obj, zzeju, h);
                            } else {
                                zzeiu = qa0.mo14650F();
                            }
                        } else if (!qa0.mo14649E()) {
                            break;
                        }
                    }
                    if (qa0.getTag() != 12) {
                        throw zzeks.m8832e();
                    } else if (zzeiu != null) {
                        if (obj != null) {
                            d90.mo13755d(zzeiu, obj, zzeju, h);
                        } else {
                            pb0.mo14587b(k, i, zzeiu);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object b = d90.mo13753b(zzeju, this.f9304a, tag >>> 3);
                    if (b != null) {
                        d90.mo13756e(qa0, b, zzeju, h);
                    } else {
                        z = pb0.mo14591f(k, qa0);
                        continue;
                    }
                } else {
                    z = qa0.mo14649E();
                    continue;
                }
                z = true;
                continue;
            } finally {
                pb0.mo14603r(t, k);
            }
        } while (z);
    }

    /* renamed from: h */
    public final void mo14195h(T t, T t2) {
        ya0.m7356h(this.f9305b, t, t2);
        if (this.f9306c) {
            ya0.m7354f(this.f9307d, t, t2);
        }
    }

    /* renamed from: i */
    public final void mo14196i(T t) {
        this.f9305b.mo14592g(t);
        this.f9307d.mo13760i(t);
    }

    /* renamed from: j */
    public final int mo14197j(T t) {
        pb0<?, ?> pb0 = this.f9305b;
        int m = pb0.mo14598m(pb0.mo14595j(t)) + 0;
        return this.f9306c ? m + this.f9307d.mo13758g(t).mo13885q() : m;
    }

    /* renamed from: k */
    public final void mo14198k(T t, hc0 hc0) {
        Iterator<Map.Entry<?, Object>> d = this.f9307d.mo13758g(t).mo13880d();
        while (d.hasNext()) {
            Map.Entry next = d.next();
            zzejz zzejz = (zzejz) next.getKey();
            if (zzejz.zzbhm() != zzenz.MESSAGE || zzejz.zzbhn() || zzejz.zzbho()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof n90) {
                hc0.mo13578u(zzejz.zzv(), ((n90) next).mo14470a().zzbfg());
            } else {
                hc0.mo13578u(zzejz.zzv(), next.getValue());
            }
        }
        pb0<?, ?> pb0 = this.f9305b;
        pb0.mo14601p(pb0.mo14595j(t), hc0);
    }
}
