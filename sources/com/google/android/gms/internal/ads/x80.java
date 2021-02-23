package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class x80 implements qa0 {

    /* renamed from: a */
    private final zzejj f11767a;

    /* renamed from: b */
    private int f11768b;

    /* renamed from: c */
    private int f11769c;

    /* renamed from: d */
    private int f11770d = 0;

    private x80(zzejj zzejj) {
        zzekk.m8825c(zzejj, "input");
        zzejj zzejj2 = zzejj;
        this.f11767a = zzejj2;
        zzejj2.f16202d = this;
    }

    /* renamed from: N */
    public static x80 m7161N(zzejj zzejj) {
        x80 x80 = zzejj.f16202d;
        if (x80 != null) {
            return x80;
        }
        return new x80(zzejj);
    }

    /* renamed from: O */
    private final Object m7162O(zzenw zzenw, Class<?> cls, zzeju zzeju) {
        switch (y80.f11999a[zzenw.ordinal()]) {
            case 1:
                return Boolean.valueOf(mo14685y());
            case 2:
                return mo14650F();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(mo14656L());
            case 5:
                return Integer.valueOf(mo14680t());
            case 6:
                return Long.valueOf(mo14673o());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(mo14668j());
            case 9:
                return Long.valueOf(mo14655K());
            case 10:
                m7166S(2);
                return m7164Q(pa0.m6655b().mo14585c(cls), zzeju);
            case 11:
                return Integer.valueOf(mo14670l());
            case 12:
                return Long.valueOf(mo14676r());
            case 13:
                return Integer.valueOf(mo14682v());
            case 14:
                return Long.valueOf(mo14645A());
            case 15:
                return mo14647C();
            case 16:
                return Integer.valueOf(mo14654J());
            case 17:
                return Long.valueOf(mo14652H());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* renamed from: P */
    private final void m7163P(List<String> list, boolean z) {
        int zzbga;
        int zzbga2;
        if ((this.f11768b & 7) != 2) {
            throw zzeks.m8833f();
        } else if (!(list instanceof zzekz) || z) {
            do {
                list.add(z ? mo14647C() : mo14662e());
                if (!this.f11767a.zzbgq()) {
                    zzbga = this.f11767a.zzbga();
                } else {
                    return;
                }
            } while (zzbga == this.f11768b);
            this.f11770d = zzbga;
        } else {
            zzekz zzekz = (zzekz) list;
            do {
                zzekz.zzak(mo14650F());
                if (!this.f11767a.zzbgq()) {
                    zzbga2 = this.f11767a.zzbga();
                } else {
                    return;
                }
            } while (zzbga2 == this.f11768b);
            this.f11770d = zzbga2;
        }
    }

    /* renamed from: Q */
    private final <T> T m7164Q(wa0<T> wa0, zzeju zzeju) {
        int zzbgj = this.f11767a.zzbgj();
        zzejj zzejj = this.f11767a;
        if (zzejj.f16199a < zzejj.f16200b) {
            int zzge = zzejj.zzge(zzbgj);
            T c = wa0.mo14190c();
            this.f11767a.f16199a++;
            wa0.mo14194g(c, this, zzeju);
            wa0.mo14196i(c);
            this.f11767a.zzgc(0);
            zzejj zzejj2 = this.f11767a;
            zzejj2.f16199a--;
            zzejj2.zzgf(zzge);
            return c;
        }
        throw new zzeks("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: R */
    private final <T> T m7165R(wa0<T> wa0, zzeju zzeju) {
        int i = this.f11769c;
        this.f11769c = ((this.f11768b >>> 3) << 3) | 4;
        try {
            T c = wa0.mo14190c();
            wa0.mo14194g(c, this, zzeju);
            wa0.mo14196i(c);
            if (this.f11768b == this.f11769c) {
                return c;
            }
            throw zzeks.m8835h();
        } finally {
            this.f11769c = i;
        }
    }

    /* renamed from: S */
    private final void m7166S(int i) {
        if ((this.f11768b & 7) != i) {
            throw zzeks.m8833f();
        }
    }

    /* renamed from: T */
    private static void m7167T(int i) {
        if ((i & 7) != 0) {
            throw zzeks.m8835h();
        }
    }

    /* renamed from: U */
    private static void m7168U(int i) {
        if ((i & 3) != 0) {
            throw zzeks.m8835h();
        }
    }

    /* renamed from: V */
    private final void m7169V(int i) {
        if (this.f11767a.zzbgr() != i) {
            throw zzeks.m8828a();
        }
    }

    /* renamed from: A */
    public final long mo14645A() {
        m7166S(0);
        return this.f11767a.zzbgo();
    }

    /* renamed from: B */
    public final void mo14646B(List<String> list) {
        m7163P(list, true);
    }

    /* renamed from: C */
    public final String mo14647C() {
        m7166S(2);
        return this.f11767a.zzbgh();
    }

    /* renamed from: D */
    public final int mo14648D() {
        int i = this.f11770d;
        if (i != 0) {
            this.f11768b = i;
            this.f11770d = 0;
        } else {
            this.f11768b = this.f11767a.zzbga();
        }
        int i2 = this.f11768b;
        if (i2 == 0 || i2 == this.f11769c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    /* renamed from: E */
    public final boolean mo14649E() {
        int i;
        if (this.f11767a.zzbgq() || (i = this.f11768b) == this.f11769c) {
            return false;
        }
        return this.f11767a.zzgd(i);
    }

    /* renamed from: F */
    public final zzeiu mo14650F() {
        m7166S(2);
        return this.f11767a.zzbgi();
    }

    /* renamed from: G */
    public final void mo14651G(List<Boolean> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof j80) {
            j80 j80 = (j80) list;
            int i = this.f11768b & 7;
            if (i == 0) {
                do {
                    j80.addBoolean(this.f11767a.zzbgg());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    j80.addBoolean(this.f11767a.zzbgg());
                } while (this.f11767a.zzbgr() < zzbgr);
                m7169V(zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f11767a.zzbgg()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    list.add(Boolean.valueOf(this.f11767a.zzbgg()));
                } while (this.f11767a.zzbgr() < zzbgr2);
                m7169V(zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: H */
    public final long mo14652H() {
        m7166S(0);
        return this.f11767a.zzbgb();
    }

    /* renamed from: I */
    public final void mo14653I(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof m90) {
            m90 m90 = (m90) list;
            int i = this.f11768b & 7;
            if (i == 0) {
                do {
                    m90.zzhg(this.f11767a.zzbgj());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    m90.zzhg(this.f11767a.zzbgj());
                } while (this.f11767a.zzbgr() < zzbgr);
                m7169V(zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgj()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgj()));
                } while (this.f11767a.zzbgr() < zzbgr2);
                m7169V(zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: J */
    public final int mo14654J() {
        m7166S(0);
        return this.f11767a.zzbgj();
    }

    /* renamed from: K */
    public final long mo14655K() {
        m7166S(0);
        return this.f11767a.zzbgc();
    }

    /* renamed from: L */
    public final int mo14656L() {
        m7166S(0);
        return this.f11767a.zzbgk();
    }

    /* renamed from: M */
    public final void mo14657M(List<zzeiu> list) {
        int zzbga;
        if ((this.f11768b & 7) == 2) {
            do {
                list.add(mo14650F());
                if (!this.f11767a.zzbgq()) {
                    zzbga = this.f11767a.zzbga();
                } else {
                    return;
                }
            } while (zzbga == this.f11768b);
            this.f11770d = zzbga;
            return;
        }
        throw zzeks.m8833f();
    }

    /* renamed from: a */
    public final void mo14658a(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof m90) {
            m90 m90 = (m90) list;
            int i = this.f11768b & 7;
            if (i == 0) {
                do {
                    m90.zzhg(this.f11767a.zzbgd());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    m90.zzhg(this.f11767a.zzbgd());
                } while (this.f11767a.zzbgr() < zzbgr);
                m7169V(zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgd()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgd()));
                } while (this.f11767a.zzbgr() < zzbgr2);
                m7169V(zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: b */
    public final void mo14659b(List<Long> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof w90) {
            w90 w90 = (w90) list;
            int i = this.f11768b & 7;
            if (i == 0) {
                do {
                    w90.mo14960b(this.f11767a.zzbgc());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    w90.mo14960b(this.f11767a.zzbgc());
                } while (this.f11767a.zzbgr() < zzbgr);
                m7169V(zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f11767a.zzbgc()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    list.add(Long.valueOf(this.f11767a.zzbgc()));
                } while (this.f11767a.zzbgr() < zzbgr2);
                m7169V(zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: c */
    public final void mo14660c(List<Long> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof w90) {
            w90 w90 = (w90) list;
            int i = this.f11768b & 7;
            if (i == 1) {
                do {
                    w90.mo14960b(this.f11767a.zzbge());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgj = this.f11767a.zzbgj();
                m7167T(zzbgj);
                int zzbgr = this.f11767a.zzbgr() + zzbgj;
                do {
                    w90.mo14960b(this.f11767a.zzbge());
                } while (this.f11767a.zzbgr() < zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f11767a.zzbge()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgj2 = this.f11767a.zzbgj();
                m7167T(zzbgj2);
                int zzbgr2 = this.f11767a.zzbgr() + zzbgj2;
                do {
                    list.add(Long.valueOf(this.f11767a.zzbge()));
                } while (this.f11767a.zzbgr() < zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: d */
    public final void mo14661d(List<Double> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof b90) {
            b90 b90 = (b90) list;
            int i = this.f11768b & 7;
            if (i == 1) {
                do {
                    b90.mo13639a(this.f11767a.readDouble());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgj = this.f11767a.zzbgj();
                m7167T(zzbgj);
                int zzbgr = this.f11767a.zzbgr() + zzbgj;
                do {
                    b90.mo13639a(this.f11767a.readDouble());
                } while (this.f11767a.zzbgr() < zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.f11767a.readDouble()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgj2 = this.f11767a.zzbgj();
                m7167T(zzbgj2);
                int zzbgr2 = this.f11767a.zzbgr() + zzbgj2;
                do {
                    list.add(Double.valueOf(this.f11767a.readDouble()));
                } while (this.f11767a.zzbgr() < zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: e */
    public final String mo14662e() {
        m7166S(2);
        return this.f11767a.readString();
    }

    /* renamed from: f */
    public final void mo14663f(List<String> list) {
        m7163P(list, false);
    }

    /* renamed from: g */
    public final void mo14664g(List<Long> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof w90) {
            w90 w90 = (w90) list;
            int i = this.f11768b & 7;
            if (i == 0) {
                do {
                    w90.mo14960b(this.f11767a.zzbgb());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    w90.mo14960b(this.f11767a.zzbgb());
                } while (this.f11767a.zzbgr() < zzbgr);
                m7169V(zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f11767a.zzbgb()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    list.add(Long.valueOf(this.f11767a.zzbgb()));
                } while (this.f11767a.zzbgr() < zzbgr2);
                m7169V(zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    public final int getTag() {
        return this.f11768b;
    }

    /* renamed from: h */
    public final void mo14666h(List<Float> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof i90) {
            i90 i90 = (i90) list;
            int i = this.f11768b & 7;
            if (i == 2) {
                int zzbgj = this.f11767a.zzbgj();
                m7168U(zzbgj);
                int zzbgr = this.f11767a.zzbgr() + zzbgj;
                do {
                    i90.mo14255c(this.f11767a.readFloat());
                } while (this.f11767a.zzbgr() < zzbgr);
            } else if (i == 5) {
                do {
                    i90.mo14255c(this.f11767a.readFloat());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 2) {
                int zzbgj2 = this.f11767a.zzbgj();
                m7168U(zzbgj2);
                int zzbgr2 = this.f11767a.zzbgr() + zzbgj2;
                do {
                    list.add(Float.valueOf(this.f11767a.readFloat()));
                } while (this.f11767a.zzbgr() < zzbgr2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.f11767a.readFloat()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: i */
    public final <T> void mo14667i(List<T> list, wa0<T> wa0, zzeju zzeju) {
        int zzbga;
        int i = this.f11768b;
        if ((i & 7) == 3) {
            do {
                list.add(m7165R(wa0, zzeju));
                if (!this.f11767a.zzbgq() && this.f11770d == 0) {
                    zzbga = this.f11767a.zzbga();
                } else {
                    return;
                }
            } while (zzbga == i);
            this.f11770d = zzbga;
            return;
        }
        throw zzeks.m8833f();
    }

    /* renamed from: j */
    public final int mo14668j() {
        m7166S(0);
        return this.f11767a.zzbgd();
    }

    /* renamed from: k */
    public final void mo14669k(List<Long> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof w90) {
            w90 w90 = (w90) list;
            int i = this.f11768b & 7;
            if (i == 1) {
                do {
                    w90.mo14960b(this.f11767a.zzbgm());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgj = this.f11767a.zzbgj();
                m7167T(zzbgj);
                int zzbgr = this.f11767a.zzbgr() + zzbgj;
                do {
                    w90.mo14960b(this.f11767a.zzbgm());
                } while (this.f11767a.zzbgr() < zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f11767a.zzbgm()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgj2 = this.f11767a.zzbgj();
                m7167T(zzbgj2);
                int zzbgr2 = this.f11767a.zzbgr() + zzbgj2;
                do {
                    list.add(Long.valueOf(this.f11767a.zzbgm()));
                } while (this.f11767a.zzbgr() < zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: l */
    public final int mo14670l() {
        m7166S(5);
        return this.f11767a.zzbgl();
    }

    /* renamed from: m */
    public final <T> void mo14671m(List<T> list, wa0<T> wa0, zzeju zzeju) {
        int zzbga;
        int i = this.f11768b;
        if ((i & 7) == 2) {
            do {
                list.add(m7164Q(wa0, zzeju));
                if (!this.f11767a.zzbgq() && this.f11770d == 0) {
                    zzbga = this.f11767a.zzbga();
                } else {
                    return;
                }
            } while (zzbga == i);
            this.f11770d = zzbga;
            return;
        }
        throw zzeks.m8833f();
    }

    /* renamed from: n */
    public final void mo14672n(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof m90) {
            m90 m90 = (m90) list;
            int i = this.f11768b & 7;
            if (i == 2) {
                int zzbgj = this.f11767a.zzbgj();
                m7168U(zzbgj);
                int zzbgr = this.f11767a.zzbgr() + zzbgj;
                do {
                    m90.zzhg(this.f11767a.zzbgl());
                } while (this.f11767a.zzbgr() < zzbgr);
            } else if (i == 5) {
                do {
                    m90.zzhg(this.f11767a.zzbgl());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 2) {
                int zzbgj2 = this.f11767a.zzbgj();
                m7168U(zzbgj2);
                int zzbgr2 = this.f11767a.zzbgr() + zzbgj2;
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgl()));
                } while (this.f11767a.zzbgr() < zzbgr2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgl()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: o */
    public final long mo14673o() {
        m7166S(1);
        return this.f11767a.zzbge();
    }

    /* renamed from: p */
    public final void mo14674p(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof m90) {
            m90 m90 = (m90) list;
            int i = this.f11768b & 7;
            if (i == 0) {
                do {
                    m90.zzhg(this.f11767a.zzbgk());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    m90.zzhg(this.f11767a.zzbgk());
                } while (this.f11767a.zzbgr() < zzbgr);
                m7169V(zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgk()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgk()));
                } while (this.f11767a.zzbgr() < zzbgr2);
                m7169V(zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: q */
    public final void mo14675q(List<Long> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof w90) {
            w90 w90 = (w90) list;
            int i = this.f11768b & 7;
            if (i == 0) {
                do {
                    w90.mo14960b(this.f11767a.zzbgo());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    w90.mo14960b(this.f11767a.zzbgo());
                } while (this.f11767a.zzbgr() < zzbgr);
                m7169V(zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f11767a.zzbgo()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    list.add(Long.valueOf(this.f11767a.zzbgo()));
                } while (this.f11767a.zzbgr() < zzbgr2);
                m7169V(zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: r */
    public final long mo14676r() {
        m7166S(1);
        return this.f11767a.zzbgm();
    }

    public final double readDouble() {
        m7166S(1);
        return this.f11767a.readDouble();
    }

    public final float readFloat() {
        m7166S(5);
        return this.f11767a.readFloat();
    }

    /* renamed from: s */
    public final <T> T mo14679s(wa0<T> wa0, zzeju zzeju) {
        m7166S(2);
        return m7164Q(wa0, zzeju);
    }

    /* renamed from: t */
    public final int mo14680t() {
        m7166S(5);
        return this.f11767a.zzbgf();
    }

    /* renamed from: u */
    public final void mo14681u(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof m90) {
            m90 m90 = (m90) list;
            int i = this.f11768b & 7;
            if (i == 2) {
                int zzbgj = this.f11767a.zzbgj();
                m7168U(zzbgj);
                int zzbgr = this.f11767a.zzbgr() + zzbgj;
                do {
                    m90.zzhg(this.f11767a.zzbgf());
                } while (this.f11767a.zzbgr() < zzbgr);
            } else if (i == 5) {
                do {
                    m90.zzhg(this.f11767a.zzbgf());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 2) {
                int zzbgj2 = this.f11767a.zzbgj();
                m7168U(zzbgj2);
                int zzbgr2 = this.f11767a.zzbgr() + zzbgj2;
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgf()));
                } while (this.f11767a.zzbgr() < zzbgr2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgf()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else {
                throw zzeks.m8833f();
            }
        }
    }

    /* renamed from: v */
    public final int mo14682v() {
        m7166S(0);
        return this.f11767a.zzbgn();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (mo14649E() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.ads.zzeks("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* renamed from: w */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void mo14683w(java.util.Map<K, V> r8, com.google.android.gms.internal.ads.z90<K, V> r9, com.google.android.gms.internal.ads.zzeju r10) {
        /*
            r7 = this;
            r0 = 2
            r7.m7166S(r0)
            com.google.android.gms.internal.ads.zzejj r1 = r7.f11767a
            int r1 = r1.zzbgj()
            com.google.android.gms.internal.ads.zzejj r2 = r7.f11767a
            int r1 = r2.zzge(r1)
            K r2 = r9.f12264b
            V r3 = r9.f12266d
        L_0x0014:
            int r4 = r7.mo14648D()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.ads.zzejj r5 = r7.f11767a     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzbgq()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.mo14649E()     // Catch:{ zzekr -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.ads.zzeks r4 = new com.google.android.gms.internal.ads.zzeks     // Catch:{ zzekr -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzekr -> 0x004e }
            throw r4     // Catch:{ zzekr -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.ads.zzenw r4 = r9.f12265c     // Catch:{ zzekr -> 0x004e }
            V r5 = r9.f12266d     // Catch:{ zzekr -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzekr -> 0x004e }
            java.lang.Object r3 = r7.m7162O(r4, r5, r10)     // Catch:{ zzekr -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.ads.zzenw r4 = r9.f12263a     // Catch:{ zzekr -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.m7162O(r4, r5, r5)     // Catch:{ zzekr -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.mo14649E()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.ads.zzeks r8 = new com.google.android.gms.internal.ads.zzeks     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.ads.zzejj r8 = r7.f11767a
            r8.zzgf(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzejj r9 = r7.f11767a
            r9.zzgf(r1)
            goto L_0x006c
        L_0x006b:
            throw r8
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.x80.mo14683w(java.util.Map, com.google.android.gms.internal.ads.z90, com.google.android.gms.internal.ads.zzeju):void");
    }

    /* renamed from: x */
    public final <T> T mo14684x(wa0<T> wa0, zzeju zzeju) {
        m7166S(3);
        return m7165R(wa0, zzeju);
    }

    /* renamed from: y */
    public final boolean mo14685y() {
        m7166S(0);
        return this.f11767a.zzbgg();
    }

    /* renamed from: z */
    public final void mo14686z(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof m90) {
            m90 m90 = (m90) list;
            int i = this.f11768b & 7;
            if (i == 0) {
                do {
                    m90.zzhg(this.f11767a.zzbgn());
                    if (!this.f11767a.zzbgq()) {
                        zzbga2 = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.f11768b);
                this.f11770d = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    m90.zzhg(this.f11767a.zzbgn());
                } while (this.f11767a.zzbgr() < zzbgr);
                m7169V(zzbgr);
            } else {
                throw zzeks.m8833f();
            }
        } else {
            int i2 = this.f11768b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgn()));
                    if (!this.f11767a.zzbgq()) {
                        zzbga = this.f11767a.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.f11768b);
                this.f11770d = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.f11767a.zzbgr() + this.f11767a.zzbgj();
                do {
                    list.add(Integer.valueOf(this.f11767a.zzbgn()));
                } while (this.f11767a.zzbgr() < zzbgr2);
                m7169V(zzbgr2);
            } else {
                throw zzeks.m8833f();
            }
        }
    }
}
