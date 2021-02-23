package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.q3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2847q3 implements C2809l5 {

    /* renamed from: a */
    private final zzhd f17424a;

    /* renamed from: b */
    private int f17425b;

    /* renamed from: c */
    private int f17426c;

    /* renamed from: d */
    private int f17427d = 0;

    private C2847q3(zzhd zzhd) {
        zzic.m10385d(zzhd, "input");
        zzhd zzhd2 = zzhd;
        this.f17424a = zzhd2;
        zzhd2.f17663c = this;
    }

    /* renamed from: A */
    private static void m9728A(int i) {
        if ((i & 3) != 0) {
            throw zzih.m10393g();
        }
    }

    /* renamed from: B */
    private final <T> T m9729B(C2793j5<T> j5Var, zzhm zzhm) {
        int i = this.f17426c;
        this.f17426c = ((this.f17425b >>> 3) << 3) | 4;
        try {
            T zza = j5Var.zza();
            j5Var.mo18547g(zza, this, zzhm);
            j5Var.mo18543c(zza);
            if (this.f17425b == this.f17426c) {
                return zza;
            }
            throw zzih.m10393g();
        } finally {
            this.f17426c = i;
        }
    }

    /* renamed from: C */
    private final void m9730C(int i) {
        if (this.f17424a.zzu() != i) {
            throw zzih.m10387a();
        }
    }

    /* renamed from: u */
    public static C2847q3 m9731u(zzhd zzhd) {
        C2847q3 q3Var = zzhd.f17663c;
        if (q3Var != null) {
            return q3Var;
        }
        return new C2847q3(zzhd);
    }

    /* renamed from: v */
    private final Object m9732v(zzli zzli, Class<?> cls, zzhm zzhm) {
        switch (C2863s3.f17462a[zzli.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzk());
            case 2:
                return zzn();
            case 3:
                return Double.valueOf(zzd());
            case 4:
                return Integer.valueOf(zzp());
            case 5:
                return Integer.valueOf(zzj());
            case 6:
                return Long.valueOf(zzi());
            case 7:
                return Float.valueOf(zze());
            case 8:
                return Integer.valueOf(zzh());
            case 9:
                return Long.valueOf(zzg());
            case 10:
                m9733w(2);
                return m9736z(C2769g5.m9493a().mo18661b(cls), zzhm);
            case 11:
                return Integer.valueOf(zzq());
            case 12:
                return Long.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Long.valueOf(zzt());
            case 15:
                return zzm();
            case 16:
                return Integer.valueOf(zzo());
            case 17:
                return Long.valueOf(zzf());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* renamed from: w */
    private final void m9733w(int i) {
        if ((this.f17425b & 7) != i) {
            throw zzih.m10392f();
        }
    }

    /* renamed from: x */
    private final void m9734x(List<String> list, boolean z) {
        int zza;
        int zza2;
        if ((this.f17425b & 7) != 2) {
            throw zzih.m10392f();
        } else if (!(list instanceof zzis) || z) {
            do {
                list.add(z ? zzm() : zzl());
                if (!this.f17424a.zzt()) {
                    zza = this.f17424a.zza();
                } else {
                    return;
                }
            } while (zza == this.f17425b);
            this.f17427d = zza;
        } else {
            zzis zzis = (zzis) list;
            do {
                zzis.zza(zzn());
                if (!this.f17424a.zzt()) {
                    zza2 = this.f17424a.zza();
                } else {
                    return;
                }
            } while (zza2 == this.f17425b);
            this.f17427d = zza2;
        }
    }

    /* renamed from: y */
    private static void m9735y(int i) {
        if ((i & 7) != 0) {
            throw zzih.m10393g();
        }
    }

    /* renamed from: z */
    private final <T> T m9736z(C2793j5<T> j5Var, zzhm zzhm) {
        int zzm = this.f17424a.zzm();
        zzhd zzhd = this.f17424a;
        if (zzhd.f17661a < zzhd.f17662b) {
            int zzc = zzhd.zzc(zzm);
            T zza = j5Var.zza();
            this.f17424a.f17661a++;
            j5Var.mo18547g(zza, this, zzhm);
            j5Var.mo18543c(zza);
            this.f17424a.zza(0);
            zzhd zzhd2 = this.f17424a;
            zzhd2.f17661a--;
            zzhd2.zzd(zzc);
            return zza;
        }
        throw new zzih("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: a */
    public final void mo18711a(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof C2768g4) {
            C2768g4 g4Var = (C2768g4) list;
            int i = this.f17425b & 7;
            if (i == 0) {
                do {
                    g4Var.mo18654c(this.f17424a.zzq());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzu = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    g4Var.mo18654c(this.f17424a.zzq());
                } while (this.f17424a.zzu() < zzu);
                m9730C(zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f17424a.zzq()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzu2 = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    list.add(Integer.valueOf(this.f17424a.zzq()));
                } while (this.f17424a.zzu() < zzu2);
                m9730C(zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: b */
    public final void mo18712b(List<Long> list) {
        int zza;
        int zza2;
        if (list instanceof C2824n4) {
            C2824n4 n4Var = (C2824n4) list;
            int i = this.f17425b & 7;
            if (i == 1) {
                do {
                    n4Var.mo18765a(this.f17424a.zzp());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzm = this.f17424a.zzm();
                m9735y(zzm);
                int zzu = this.f17424a.zzu() + zzm;
                do {
                    n4Var.mo18765a(this.f17424a.zzp());
                } while (this.f17424a.zzu() < zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f17424a.zzp()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzm2 = this.f17424a.zzm();
                m9735y(zzm2);
                int zzu2 = this.f17424a.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.f17424a.zzp()));
                } while (this.f17424a.zzu() < zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: c */
    public final void mo18713c(List<Long> list) {
        int zza;
        int zza2;
        if (list instanceof C2824n4) {
            C2824n4 n4Var = (C2824n4) list;
            int i = this.f17425b & 7;
            if (i == 0) {
                do {
                    n4Var.mo18765a(this.f17424a.zzr());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzu = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    n4Var.mo18765a(this.f17424a.zzr());
                } while (this.f17424a.zzu() < zzu);
                m9730C(zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f17424a.zzr()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzu2 = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    list.add(Long.valueOf(this.f17424a.zzr()));
                } while (this.f17424a.zzu() < zzu2);
                m9730C(zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: d */
    public final void mo18714d(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof C2768g4) {
            C2768g4 g4Var = (C2768g4) list;
            int i = this.f17425b & 7;
            if (i == 0) {
                do {
                    g4Var.mo18654c(this.f17424a.zzm());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzu = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    g4Var.mo18654c(this.f17424a.zzm());
                } while (this.f17424a.zzu() < zzu);
                m9730C(zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f17424a.zzm()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzu2 = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    list.add(Integer.valueOf(this.f17424a.zzm()));
                } while (this.f17424a.zzu() < zzu2);
                m9730C(zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: e */
    public final void mo18715e(List<Boolean> list) {
        int zza;
        int zza2;
        if (list instanceof C2755f3) {
            C2755f3 f3Var = (C2755f3) list;
            int i = this.f17425b & 7;
            if (i == 0) {
                do {
                    f3Var.mo18628a(this.f17424a.zzi());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzu = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    f3Var.mo18628a(this.f17424a.zzi());
                } while (this.f17424a.zzu() < zzu);
                m9730C(zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f17424a.zzi()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzu2 = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    list.add(Boolean.valueOf(this.f17424a.zzi()));
                } while (this.f17424a.zzu() < zzu2);
                m9730C(zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: f */
    public final void mo18716f(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof C2768g4) {
            C2768g4 g4Var = (C2768g4) list;
            int i = this.f17425b & 7;
            if (i == 2) {
                int zzm = this.f17424a.zzm();
                m9728A(zzm);
                int zzu = this.f17424a.zzu() + zzm;
                do {
                    g4Var.mo18654c(this.f17424a.zzh());
                } while (this.f17424a.zzu() < zzu);
            } else if (i == 5) {
                do {
                    g4Var.mo18654c(this.f17424a.zzh());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 2) {
                int zzm2 = this.f17424a.zzm();
                m9728A(zzm2);
                int zzu2 = this.f17424a.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.f17424a.zzh()));
                } while (this.f17424a.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f17424a.zzh()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: g */
    public final void mo18717g(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof C2768g4) {
            C2768g4 g4Var = (C2768g4) list;
            int i = this.f17425b & 7;
            if (i == 2) {
                int zzm = this.f17424a.zzm();
                m9728A(zzm);
                int zzu = this.f17424a.zzu() + zzm;
                do {
                    g4Var.mo18654c(this.f17424a.zzo());
                } while (this.f17424a.zzu() < zzu);
            } else if (i == 5) {
                do {
                    g4Var.mo18654c(this.f17424a.zzo());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 2) {
                int zzm2 = this.f17424a.zzm();
                m9728A(zzm2);
                int zzu2 = this.f17424a.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.f17424a.zzo()));
                } while (this.f17424a.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f17424a.zzo()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: h */
    public final void mo18718h(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof C2768g4) {
            C2768g4 g4Var = (C2768g4) list;
            int i = this.f17425b & 7;
            if (i == 0) {
                do {
                    g4Var.mo18654c(this.f17424a.zzn());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzu = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    g4Var.mo18654c(this.f17424a.zzn());
                } while (this.f17424a.zzu() < zzu);
                m9730C(zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f17424a.zzn()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzu2 = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    list.add(Integer.valueOf(this.f17424a.zzn()));
                } while (this.f17424a.zzu() < zzu2);
                m9730C(zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: i */
    public final <T> T mo18719i(C2793j5<T> j5Var, zzhm zzhm) {
        m9733w(2);
        return m9736z(j5Var, zzhm);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzc() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.measurement.zzih("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void mo18720j(java.util.Map<K, V> r8, com.google.android.gms.internal.measurement.C2864s4<K, V> r9, com.google.android.gms.internal.measurement.zzhm r10) {
        /*
            r7 = this;
            r0 = 2
            r7.m9733w(r0)
            com.google.android.gms.internal.measurement.zzhd r1 = r7.f17424a
            int r1 = r1.zzm()
            com.google.android.gms.internal.measurement.zzhd r2 = r7.f17424a
            int r1 = r2.zzc(r1)
            K r2 = r9.f17464b
            V r3 = r9.f17466d
        L_0x0014:
            int r4 = r7.zza()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.measurement.zzhd r5 = r7.f17424a     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzt()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzc()     // Catch:{ zzik -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.measurement.zzih r4 = new com.google.android.gms.internal.measurement.zzih     // Catch:{ zzik -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzik -> 0x004e }
            throw r4     // Catch:{ zzik -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.measurement.zzli r4 = r9.f17465c     // Catch:{ zzik -> 0x004e }
            V r5 = r9.f17466d     // Catch:{ zzik -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzik -> 0x004e }
            java.lang.Object r3 = r7.m9732v(r4, r5, r10)     // Catch:{ zzik -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.measurement.zzli r4 = r9.f17463a     // Catch:{ zzik -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.m9732v(r4, r5, r5)     // Catch:{ zzik -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzc()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.measurement.zzih r8 = new com.google.android.gms.internal.measurement.zzih     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.measurement.zzhd r8 = r7.f17424a
            r8.zzd(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.measurement.zzhd r9 = r7.f17424a
            r9.zzd(r1)
            goto L_0x006c
        L_0x006b:
            throw r8
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2847q3.mo18720j(java.util.Map, com.google.android.gms.internal.measurement.s4, com.google.android.gms.internal.measurement.zzhm):void");
    }

    /* renamed from: k */
    public final void mo18721k(List<String> list) {
        m9734x(list, true);
    }

    /* renamed from: l */
    public final void mo18722l(List<Double> list) {
        int zza;
        int zza2;
        if (list instanceof C2887v3) {
            C2887v3 v3Var = (C2887v3) list;
            int i = this.f17425b & 7;
            if (i == 1) {
                do {
                    v3Var.mo18923a(this.f17424a.zzb());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzm = this.f17424a.zzm();
                m9735y(zzm);
                int zzu = this.f17424a.zzu() + zzm;
                do {
                    v3Var.mo18923a(this.f17424a.zzb());
                } while (this.f17424a.zzu() < zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.f17424a.zzb()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzm2 = this.f17424a.zzm();
                m9735y(zzm2);
                int zzu2 = this.f17424a.zzu() + zzm2;
                do {
                    list.add(Double.valueOf(this.f17424a.zzb()));
                } while (this.f17424a.zzu() < zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: m */
    public final void mo18723m(List<String> list) {
        m9734x(list, false);
    }

    /* renamed from: n */
    public final void mo18724n(List<Long> list) {
        int zza;
        int zza2;
        if (list instanceof C2824n4) {
            C2824n4 n4Var = (C2824n4) list;
            int i = this.f17425b & 7;
            if (i == 0) {
                do {
                    n4Var.mo18765a(this.f17424a.zzd());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzu = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    n4Var.mo18765a(this.f17424a.zzd());
                } while (this.f17424a.zzu() < zzu);
                m9730C(zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f17424a.zzd()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzu2 = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    list.add(Long.valueOf(this.f17424a.zzd()));
                } while (this.f17424a.zzu() < zzu2);
                m9730C(zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: o */
    public final <T> T mo18725o(C2793j5<T> j5Var, zzhm zzhm) {
        m9733w(3);
        return m9729B(j5Var, zzhm);
    }

    /* renamed from: p */
    public final void mo18726p(List<zzgr> list) {
        int zza;
        if ((this.f17425b & 7) == 2) {
            do {
                list.add(zzn());
                if (!this.f17424a.zzt()) {
                    zza = this.f17424a.zza();
                } else {
                    return;
                }
            } while (zza == this.f17425b);
            this.f17427d = zza;
            return;
        }
        throw zzih.m10392f();
    }

    /* renamed from: q */
    public final void mo18727q(List<Float> list) {
        int zza;
        int zza2;
        if (list instanceof C2732c4) {
            C2732c4 c4Var = (C2732c4) list;
            int i = this.f17425b & 7;
            if (i == 2) {
                int zzm = this.f17424a.zzm();
                m9728A(zzm);
                int zzu = this.f17424a.zzu() + zzm;
                do {
                    c4Var.mo18576a(this.f17424a.zzc());
                } while (this.f17424a.zzu() < zzu);
            } else if (i == 5) {
                do {
                    c4Var.mo18576a(this.f17424a.zzc());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 2) {
                int zzm2 = this.f17424a.zzm();
                m9728A(zzm2);
                int zzu2 = this.f17424a.zzu() + zzm2;
                do {
                    list.add(Float.valueOf(this.f17424a.zzc()));
                } while (this.f17424a.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.f17424a.zzc()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else {
                throw zzih.m10392f();
            }
        }
    }

    /* renamed from: r */
    public final <T> void mo18728r(List<T> list, C2793j5<T> j5Var, zzhm zzhm) {
        int zza;
        int i = this.f17425b;
        if ((i & 7) == 2) {
            do {
                list.add(m9736z(j5Var, zzhm));
                if (!this.f17424a.zzt() && this.f17427d == 0) {
                    zza = this.f17424a.zza();
                } else {
                    return;
                }
            } while (zza == i);
            this.f17427d = zza;
            return;
        }
        throw zzih.m10392f();
    }

    /* renamed from: s */
    public final <T> void mo18729s(List<T> list, C2793j5<T> j5Var, zzhm zzhm) {
        int zza;
        int i = this.f17425b;
        if ((i & 7) == 3) {
            do {
                list.add(m9729B(j5Var, zzhm));
                if (!this.f17424a.zzt() && this.f17427d == 0) {
                    zza = this.f17424a.zza();
                } else {
                    return;
                }
            } while (zza == i);
            this.f17427d = zza;
            return;
        }
        throw zzih.m10392f();
    }

    /* renamed from: t */
    public final void mo18730t(List<Long> list) {
        int zza;
        int zza2;
        if (list instanceof C2824n4) {
            C2824n4 n4Var = (C2824n4) list;
            int i = this.f17425b & 7;
            if (i == 0) {
                do {
                    n4Var.mo18765a(this.f17424a.zze());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzu = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    n4Var.mo18765a(this.f17424a.zze());
                } while (this.f17424a.zzu() < zzu);
                m9730C(zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f17424a.zze()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzu2 = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    list.add(Long.valueOf(this.f17424a.zze()));
                } while (this.f17424a.zzu() < zzu2);
                m9730C(zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }

    public final int zza() {
        int i = this.f17427d;
        if (i != 0) {
            this.f17425b = i;
            this.f17427d = 0;
        } else {
            this.f17425b = this.f17424a.zza();
        }
        int i2 = this.f17425b;
        if (i2 == 0 || i2 == this.f17426c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int zzb() {
        return this.f17425b;
    }

    public final boolean zzc() {
        int i;
        if (this.f17424a.zzt() || (i = this.f17425b) == this.f17426c) {
            return false;
        }
        return this.f17424a.zzb(i);
    }

    public final double zzd() {
        m9733w(1);
        return this.f17424a.zzb();
    }

    public final float zze() {
        m9733w(5);
        return this.f17424a.zzc();
    }

    public final long zzf() {
        m9733w(0);
        return this.f17424a.zzd();
    }

    public final long zzg() {
        m9733w(0);
        return this.f17424a.zze();
    }

    public final int zzh() {
        m9733w(0);
        return this.f17424a.zzf();
    }

    public final long zzi() {
        m9733w(1);
        return this.f17424a.zzg();
    }

    public final int zzj() {
        m9733w(5);
        return this.f17424a.zzh();
    }

    public final boolean zzk() {
        m9733w(0);
        return this.f17424a.zzi();
    }

    public final String zzl() {
        m9733w(2);
        return this.f17424a.zzj();
    }

    public final String zzm() {
        m9733w(2);
        return this.f17424a.zzk();
    }

    public final zzgr zzn() {
        m9733w(2);
        return this.f17424a.zzl();
    }

    public final int zzo() {
        m9733w(0);
        return this.f17424a.zzm();
    }

    public final int zzp() {
        m9733w(0);
        return this.f17424a.zzn();
    }

    public final int zzq() {
        m9733w(5);
        return this.f17424a.zzo();
    }

    public final long zzr() {
        m9733w(1);
        return this.f17424a.zzp();
    }

    public final int zzs() {
        m9733w(0);
        return this.f17424a.zzq();
    }

    public final long zzt() {
        m9733w(0);
        return this.f17424a.zzr();
    }

    public final void zze(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof C2768g4) {
            C2768g4 g4Var = (C2768g4) list;
            int i = this.f17425b & 7;
            if (i == 0) {
                do {
                    g4Var.mo18654c(this.f17424a.zzf());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzu = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    g4Var.mo18654c(this.f17424a.zzf());
                } while (this.f17424a.zzu() < zzu);
                m9730C(zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f17424a.zzf()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzu2 = this.f17424a.zzu() + this.f17424a.zzm();
                do {
                    list.add(Integer.valueOf(this.f17424a.zzf()));
                } while (this.f17424a.zzu() < zzu2);
                m9730C(zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }

    public final void zzf(List<Long> list) {
        int zza;
        int zza2;
        if (list instanceof C2824n4) {
            C2824n4 n4Var = (C2824n4) list;
            int i = this.f17425b & 7;
            if (i == 1) {
                do {
                    n4Var.mo18765a(this.f17424a.zzg());
                    if (!this.f17424a.zzt()) {
                        zza2 = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.f17425b);
                this.f17427d = zza2;
            } else if (i == 2) {
                int zzm = this.f17424a.zzm();
                m9735y(zzm);
                int zzu = this.f17424a.zzu() + zzm;
                do {
                    n4Var.mo18765a(this.f17424a.zzg());
                } while (this.f17424a.zzu() < zzu);
            } else {
                throw zzih.m10392f();
            }
        } else {
            int i2 = this.f17425b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f17424a.zzg()));
                    if (!this.f17424a.zzt()) {
                        zza = this.f17424a.zza();
                    } else {
                        return;
                    }
                } while (zza == this.f17425b);
                this.f17427d = zza;
            } else if (i2 == 2) {
                int zzm2 = this.f17424a.zzm();
                m9735y(zzm2);
                int zzu2 = this.f17424a.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.f17424a.zzg()));
                } while (this.f17424a.zzu() < zzu2);
            } else {
                throw zzih.m10392f();
            }
        }
    }
}
