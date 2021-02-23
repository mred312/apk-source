package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzlk implements zzjw, zzkf {

    /* renamed from: p */
    private static final int f16652p = zzpt.zzbh("qt  ");

    /* renamed from: a */
    private final zzpn f16653a = new zzpn(zzpi.zzbjq);

    /* renamed from: b */
    private final zzpn f16654b = new zzpn(4);

    /* renamed from: c */
    private final zzpn f16655c = new zzpn(16);

    /* renamed from: d */
    private final Stack<xe0> f16656d = new Stack<>();

    /* renamed from: e */
    private int f16657e;

    /* renamed from: f */
    private int f16658f;

    /* renamed from: g */
    private long f16659g;

    /* renamed from: h */
    private int f16660h;

    /* renamed from: i */
    private zzpn f16661i;

    /* renamed from: j */
    private int f16662j;

    /* renamed from: k */
    private int f16663k;

    /* renamed from: l */
    private zzjy f16664l;

    /* renamed from: m */
    private kf0[] f16665m;

    /* renamed from: n */
    private long f16666n;

    /* renamed from: o */
    private boolean f16667o;

    /* renamed from: a */
    private final void m9011a(long j) {
        zzmd zzmd;
        zzka zzka;
        zzlo b;
        while (!this.f16656d.isEmpty() && this.f16656d.peek().f11896P0 == j) {
            xe0 pop = this.f16656d.pop();
            if (pop.f11418a == ue0.f11330C) {
                long j2 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                long j3 = Long.MAX_VALUE;
                zzmd zzmd2 = null;
                zzka zzka2 = new zzka();
                we0 f = pop.mo15028f(ue0.f11327A0);
                if (!(f == null || (zzmd2 = ze0.m7409d(f, this.f16667o)) == null)) {
                    zzka2.zzb(zzmd2);
                }
                int i = 0;
                while (i < pop.f11898R0.size()) {
                    xe0 xe0 = pop.f11898R0.get(i);
                    if (xe0.f11418a == ue0.f11334E && (b = ze0.m7407b(xe0, pop.mo15028f(ue0.f11332D), -9223372036854775807L, (zzjo) null, this.f16667o)) != null) {
                        nf0 c = ze0.m7408c(b, xe0.mo15029g(ue0.f11336F).mo15029g(ue0.f11338G).mo15029g(ue0.f11340H), zzka2);
                        if (c.f10185a != 0) {
                            kf0 kf0 = new kf0(b, c, this.f16664l.zzc(i, b.type));
                            zzhp zzv = b.zzahv.zzv(c.f10188d + 30);
                            if (b.type == 1) {
                                if (zzka2.zzgs()) {
                                    zzv = zzv.zzb(zzka2.zzahn, zzka2.zzaho);
                                }
                                if (zzmd2 != null) {
                                    zzv = zzv.zza(zzmd2);
                                }
                            }
                            kf0.f9753c.zze(zzv);
                            zzmd = zzmd2;
                            zzka = zzka2;
                            j2 = Math.max(j2, b.zzaif);
                            arrayList.add(kf0);
                            long j4 = c.f10186b[0];
                            if (j4 < j3) {
                                j3 = j4;
                            }
                            i++;
                            zzka2 = zzka;
                            zzmd2 = zzmd;
                        }
                    }
                    zzmd = zzmd2;
                    zzka = zzka2;
                    i++;
                    zzka2 = zzka;
                    zzmd2 = zzmd;
                }
                this.f16666n = j2;
                this.f16665m = (kf0[]) arrayList.toArray(new kf0[arrayList.size()]);
                this.f16664l.zzgr();
                this.f16664l.zza(this);
                this.f16656d.clear();
                this.f16657e = 2;
            } else if (!this.f16656d.isEmpty()) {
                this.f16656d.peek().mo15027e(pop);
            }
        }
        if (this.f16657e != 2) {
            m9012b();
        }
    }

    /* renamed from: b */
    private final void m9012b() {
        this.f16657e = 0;
        this.f16660h = 0;
    }

    public final long getDurationUs() {
        return this.f16666n;
    }

    public final boolean isSeekable() {
        return true;
    }

    public final void release() {
    }

    public final boolean zza(zzjz zzjz) {
        return lf0.m6456c(zzjz);
    }

    public final void zzc(long j, long j2) {
        this.f16656d.clear();
        this.f16660h = 0;
        this.f16662j = 0;
        this.f16663k = 0;
        if (j == 0) {
            m9012b();
            return;
        }
        kf0[] kf0Arr = this.f16665m;
        if (kf0Arr != null) {
            for (kf0 kf0 : kf0Arr) {
                nf0 nf0 = kf0.f9752b;
                int a = nf0.mo14489a(j2);
                if (a == -1) {
                    a = nf0.mo14490b(j2);
                }
                kf0.f9754d = a;
            }
        }
    }

    public final long zzdz(long j) {
        long j2 = Long.MAX_VALUE;
        for (kf0 kf0 : this.f16665m) {
            nf0 nf0 = kf0.f9752b;
            int a = nf0.mo14489a(j);
            if (a == -1) {
                a = nf0.mo14490b(j);
            }
            long j3 = nf0.f10186b[a];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public final void zza(zzjy zzjy) {
        this.f16664l = zzjy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:148:0x0188 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0293 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0006 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjz r24, com.google.android.gms.internal.ads.zzkc r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
        L_0x0006:
            int r3 = r0.f16657e
            r4 = -1
            r5 = 8
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L_0x0189
            r8 = 262144(0x40000, double:1.295163E-318)
            r10 = 2
            if (r3 == r6) goto L_0x0109
            if (r3 != r10) goto L_0x0103
            r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = 0
            r5 = -1
        L_0x001e:
            com.google.android.gms.internal.ads.kf0[] r14 = r0.f16665m
            int r15 = r14.length
            if (r3 >= r15) goto L_0x003a
            r14 = r14[r3]
            int r15 = r14.f9754d
            com.google.android.gms.internal.ads.nf0 r14 = r14.f9752b
            int r11 = r14.f10185a
            if (r15 == r11) goto L_0x0037
            long[] r11 = r14.f10186b
            r14 = r11[r15]
            int r11 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r11 >= 0) goto L_0x0037
            r5 = r3
            r12 = r14
        L_0x0037:
            int r3 = r3 + 1
            goto L_0x001e
        L_0x003a:
            if (r5 != r4) goto L_0x003d
            return r4
        L_0x003d:
            r3 = r14[r5]
            com.google.android.gms.internal.ads.zzkh r4 = r3.f9753c
            int r5 = r3.f9754d
            com.google.android.gms.internal.ads.nf0 r11 = r3.f9752b
            long[] r12 = r11.f10186b
            r13 = r12[r5]
            int[] r11 = r11.f10187c
            r11 = r11[r5]
            com.google.android.gms.internal.ads.zzlo r12 = r3.f9751a
            int r12 = r12.zzbac
            if (r12 != r6) goto L_0x0059
            r16 = 8
            long r13 = r13 + r16
            int r11 = r11 + -8
        L_0x0059:
            long r16 = r24.getPosition()
            long r16 = r13 - r16
            int r12 = r0.f16662j
            r18 = r11
            long r10 = (long) r12
            long r10 = r16 + r10
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 < 0) goto L_0x0100
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 < 0) goto L_0x0072
            goto L_0x0100
        L_0x0072:
            int r2 = (int) r10
            r1.zzag(r2)
            com.google.android.gms.internal.ads.zzlo r2 = r3.f9751a
            int r2 = r2.zzasp
            if (r2 == 0) goto L_0x00c8
            com.google.android.gms.internal.ads.zzpn r8 = r0.f16654b
            byte[] r8 = r8.data
            r8[r7] = r7
            r8[r6] = r7
            r9 = 2
            r8[r9] = r7
            int r8 = 4 - r2
            r11 = r18
        L_0x008b:
            int r9 = r0.f16662j
            if (r9 >= r11) goto L_0x00e1
            int r9 = r0.f16663k
            if (r9 != 0) goto L_0x00b9
            com.google.android.gms.internal.ads.zzpn r9 = r0.f16654b
            byte[] r9 = r9.data
            r1.readFully(r9, r8, r2)
            com.google.android.gms.internal.ads.zzpn r9 = r0.f16654b
            r9.zzbl(r7)
            com.google.android.gms.internal.ads.zzpn r9 = r0.f16654b
            int r9 = r9.zzjf()
            r0.f16663k = r9
            com.google.android.gms.internal.ads.zzpn r9 = r0.f16653a
            r9.zzbl(r7)
            com.google.android.gms.internal.ads.zzpn r9 = r0.f16653a
            r10 = 4
            r4.zza(r9, r10)
            int r9 = r0.f16662j
            int r9 = r9 + r10
            r0.f16662j = r9
            int r11 = r11 + r8
            goto L_0x008b
        L_0x00b9:
            int r9 = r4.zza(r1, r9, r7)
            int r10 = r0.f16662j
            int r10 = r10 + r9
            r0.f16662j = r10
            int r10 = r0.f16663k
            int r10 = r10 - r9
            r0.f16663k = r10
            goto L_0x008b
        L_0x00c8:
            int r2 = r0.f16662j
            r11 = r18
            if (r2 >= r11) goto L_0x00e1
            int r2 = r11 - r2
            int r2 = r4.zza(r1, r2, r7)
            int r8 = r0.f16662j
            int r8 = r8 + r2
            r0.f16662j = r8
            int r8 = r0.f16663k
            int r8 = r8 - r2
            r0.f16663k = r8
            r18 = r11
            goto L_0x00c8
        L_0x00e1:
            r20 = r11
            com.google.android.gms.internal.ads.nf0 r1 = r3.f9752b
            long[] r2 = r1.f10189e
            r17 = r2[r5]
            int[] r1 = r1.f10190f
            r19 = r1[r5]
            r21 = 0
            r22 = 0
            r16 = r4
            r16.zza(r17, r19, r20, r21, r22)
            int r1 = r3.f9754d
            int r1 = r1 + r6
            r3.f9754d = r1
            r0.f16662j = r7
            r0.f16663k = r7
            return r7
        L_0x0100:
            r2.position = r13
            return r6
        L_0x0103:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0109:
            long r3 = r0.f16659g
            int r10 = r0.f16660h
            long r10 = (long) r10
            long r3 = r3 - r10
            long r10 = r24.getPosition()
            long r10 = r10 + r3
            com.google.android.gms.internal.ads.zzpn r12 = r0.f16661i
            if (r12 == 0) goto L_0x0169
            byte[] r8 = r12.data
            int r9 = r0.f16660h
            int r4 = (int) r3
            r1.readFully(r8, r9, r4)
            int r3 = r0.f16658f
            int r4 = com.google.android.gms.internal.ads.ue0.f11368b
            if (r3 != r4) goto L_0x014c
            com.google.android.gms.internal.ads.zzpn r3 = r0.f16661i
            r3.zzbl(r5)
            int r4 = r3.readInt()
            int r5 = f16652p
            if (r4 != r5) goto L_0x0135
        L_0x0133:
            r3 = 1
            goto L_0x0149
        L_0x0135:
            r4 = 4
            r3.zzbm(r4)
        L_0x0139:
            int r4 = r3.zzja()
            if (r4 <= 0) goto L_0x0148
            int r4 = r3.readInt()
            int r5 = f16652p
            if (r4 != r5) goto L_0x0139
            goto L_0x0133
        L_0x0148:
            r3 = 0
        L_0x0149:
            r0.f16667o = r3
            goto L_0x0171
        L_0x014c:
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r3 = r0.f16656d
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0171
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r3 = r0.f16656d
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.xe0 r3 = (com.google.android.gms.internal.ads.xe0) r3
            com.google.android.gms.internal.ads.we0 r4 = new com.google.android.gms.internal.ads.we0
            int r5 = r0.f16658f
            com.google.android.gms.internal.ads.zzpn r8 = r0.f16661i
            r4.<init>(r5, r8)
            r3.mo15026d(r4)
            goto L_0x0171
        L_0x0169:
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x0173
            int r4 = (int) r3
            r1.zzag(r4)
        L_0x0171:
            r3 = 0
            goto L_0x017b
        L_0x0173:
            long r8 = r24.getPosition()
            long r8 = r8 + r3
            r2.position = r8
            r3 = 1
        L_0x017b:
            r0.m9011a(r10)
            if (r3 == 0) goto L_0x0186
            int r3 = r0.f16657e
            r4 = 2
            if (r3 == r4) goto L_0x0186
            r7 = 1
        L_0x0186:
            if (r7 == 0) goto L_0x0006
            return r6
        L_0x0189:
            int r3 = r0.f16660h
            if (r3 != 0) goto L_0x01b1
            com.google.android.gms.internal.ads.zzpn r3 = r0.f16655c
            byte[] r3 = r3.data
            boolean r3 = r1.zza(r3, r7, r5, r6)
            if (r3 != 0) goto L_0x019a
            r6 = 0
            goto L_0x0291
        L_0x019a:
            r0.f16660h = r5
            com.google.android.gms.internal.ads.zzpn r3 = r0.f16655c
            r3.zzbl(r7)
            com.google.android.gms.internal.ads.zzpn r3 = r0.f16655c
            long r8 = r3.zzjc()
            r0.f16659g = r8
            com.google.android.gms.internal.ads.zzpn r3 = r0.f16655c
            int r3 = r3.readInt()
            r0.f16658f = r3
        L_0x01b1:
            long r8 = r0.f16659g
            r10 = 1
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 != 0) goto L_0x01cd
            com.google.android.gms.internal.ads.zzpn r3 = r0.f16655c
            byte[] r3 = r3.data
            r1.readFully(r3, r5, r5)
            int r3 = r0.f16660h
            int r3 = r3 + r5
            r0.f16660h = r3
            com.google.android.gms.internal.ads.zzpn r3 = r0.f16655c
            long r8 = r3.zzjg()
            r0.f16659g = r8
        L_0x01cd:
            int r3 = r0.f16658f
            int r8 = com.google.android.gms.internal.ads.ue0.f11330C
            if (r3 == r8) goto L_0x01ea
            int r8 = com.google.android.gms.internal.ads.ue0.f11334E
            if (r3 == r8) goto L_0x01ea
            int r8 = com.google.android.gms.internal.ads.ue0.f11336F
            if (r3 == r8) goto L_0x01ea
            int r8 = com.google.android.gms.internal.ads.ue0.f11338G
            if (r3 == r8) goto L_0x01ea
            int r8 = com.google.android.gms.internal.ads.ue0.f11340H
            if (r3 == r8) goto L_0x01ea
            int r8 = com.google.android.gms.internal.ads.ue0.f11357Q
            if (r3 != r8) goto L_0x01e8
            goto L_0x01ea
        L_0x01e8:
            r8 = 0
            goto L_0x01eb
        L_0x01ea:
            r8 = 1
        L_0x01eb:
            if (r8 == 0) goto L_0x0217
            long r7 = r24.getPosition()
            long r9 = r0.f16659g
            long r7 = r7 + r9
            int r3 = r0.f16660h
            long r9 = (long) r3
            long r7 = r7 - r9
            java.util.Stack<com.google.android.gms.internal.ads.xe0> r3 = r0.f16656d
            com.google.android.gms.internal.ads.xe0 r5 = new com.google.android.gms.internal.ads.xe0
            int r9 = r0.f16658f
            r5.<init>(r9, r7)
            r3.add(r5)
            long r9 = r0.f16659g
            int r3 = r0.f16660h
            long r11 = (long) r3
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0212
            r0.m9011a(r7)
            goto L_0x0291
        L_0x0212:
            r23.m9012b()
            goto L_0x0291
        L_0x0217:
            int r8 = com.google.android.gms.internal.ads.ue0.f11359S
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11332D
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11360T
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11361U
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11391m0
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11393n0
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11395o0
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11358R
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11397p0
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11399q0
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11401r0
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11403s0
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11405t0
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11356P
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11368b
            if (r3 == r8) goto L_0x025a
            int r8 = com.google.android.gms.internal.ads.ue0.f11327A0
            if (r3 != r8) goto L_0x0258
            goto L_0x025a
        L_0x0258:
            r3 = 0
            goto L_0x025b
        L_0x025a:
            r3 = 1
        L_0x025b:
            if (r3 == 0) goto L_0x028c
            int r3 = r0.f16660h
            if (r3 != r5) goto L_0x0263
            r3 = 1
            goto L_0x0264
        L_0x0263:
            r3 = 0
        L_0x0264:
            com.google.android.gms.internal.ads.zzpc.checkState(r3)
            long r8 = r0.f16659g
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x0272
            r3 = 1
            goto L_0x0273
        L_0x0272:
            r3 = 0
        L_0x0273:
            com.google.android.gms.internal.ads.zzpc.checkState(r3)
            com.google.android.gms.internal.ads.zzpn r3 = new com.google.android.gms.internal.ads.zzpn
            long r8 = r0.f16659g
            int r9 = (int) r8
            r3.<init>((int) r9)
            r0.f16661i = r3
            com.google.android.gms.internal.ads.zzpn r8 = r0.f16655c
            byte[] r8 = r8.data
            byte[] r3 = r3.data
            java.lang.System.arraycopy(r8, r7, r3, r7, r5)
            r0.f16657e = r6
            goto L_0x0291
        L_0x028c:
            r3 = 0
            r0.f16661i = r3
            r0.f16657e = r6
        L_0x0291:
            if (r6 != 0) goto L_0x0006
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlk.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkc):int");
    }
}
