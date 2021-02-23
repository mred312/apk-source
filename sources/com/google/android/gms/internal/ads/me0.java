package com.google.android.gms.internal.ads;

import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class me0 implements ne0 {

    /* renamed from: a */
    private final byte[] f9957a = new byte[8];

    /* renamed from: b */
    private final Stack<oe0> f9958b = new Stack<>();

    /* renamed from: c */
    private final ve0 f9959c = new ve0();

    /* renamed from: d */
    private pe0 f9960d;

    /* renamed from: e */
    private int f9961e;

    /* renamed from: f */
    private int f9962f;

    /* renamed from: g */
    private long f9963g;

    me0() {
    }

    /* renamed from: c */
    private final long m6504c(zzjz zzjz, int i) {
        zzjz.readFully(this.f9957a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.f9957a[i2] & 255));
        }
        return j;
    }

    /* renamed from: a */
    public final boolean mo14438a(zzjz zzjz) {
        String str;
        double d;
        int d2;
        int c;
        zzpc.checkState(this.f9960d != null);
        while (true) {
            if (this.f9958b.isEmpty() || zzjz.getPosition() < this.f9958b.peek().f10365b) {
                if (this.f9961e == 0) {
                    long b = this.f9959c.mo14934b(zzjz, true, false, 4);
                    if (b == -2) {
                        zzjz.zzgq();
                        while (true) {
                            zzjz.zza(this.f9957a, 0, 4);
                            d2 = ve0.m7092d(this.f9957a[0]);
                            if (d2 != -1 && d2 <= 4) {
                                c = (int) ve0.m7091c(this.f9957a, d2, false);
                                if (this.f9960d.mo14611s(c)) {
                                    break;
                                }
                            }
                            zzjz.zzag(1);
                        }
                        zzjz.zzag(d2);
                        b = (long) c;
                    }
                    if (b == -1) {
                        return false;
                    }
                    this.f9962f = (int) b;
                    this.f9961e = 1;
                }
                if (this.f9961e == 1) {
                    this.f9963g = this.f9959c.mo14934b(zzjz, false, true, 8);
                    this.f9961e = 2;
                }
                int u = this.f9960d.mo14613u(this.f9962f);
                if (u == 0) {
                    zzjz.zzag((int) this.f9963g);
                    this.f9961e = 0;
                } else if (u == 1) {
                    long position = zzjz.getPosition();
                    this.f9958b.add(new oe0(this.f9962f, this.f9963g + position));
                    this.f9960d.mo14612t(this.f9962f, position, this.f9963g);
                    this.f9961e = 0;
                    return true;
                } else if (u == 2) {
                    long j = this.f9963g;
                    if (j <= 8) {
                        this.f9960d.mo14610r(this.f9962f, m6504c(zzjz, (int) j));
                        this.f9961e = 0;
                        return true;
                    }
                    long j2 = this.f9963g;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j2);
                    throw new zzhw(sb.toString());
                } else if (u == 3) {
                    long j3 = this.f9963g;
                    if (j3 <= 2147483647L) {
                        pe0 pe0 = this.f9960d;
                        int i = this.f9962f;
                        int i2 = (int) j3;
                        if (i2 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i2];
                            zzjz.readFully(bArr, 0, i2);
                            str = new String(bArr);
                        }
                        pe0.mo14608g(i, str);
                        this.f9961e = 0;
                        return true;
                    }
                    long j4 = this.f9963g;
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j4);
                    throw new zzhw(sb2.toString());
                } else if (u == 4) {
                    this.f9960d.mo14615w(this.f9962f, (int) this.f9963g, zzjz);
                    this.f9961e = 0;
                    return true;
                } else if (u == 5) {
                    long j5 = this.f9963g;
                    if (j5 == 4 || j5 == 8) {
                        pe0 pe02 = this.f9960d;
                        int i3 = this.f9962f;
                        int i4 = (int) j5;
                        long c2 = m6504c(zzjz, i4);
                        if (i4 == 4) {
                            d = (double) Float.intBitsToFloat((int) c2);
                        } else {
                            d = Double.longBitsToDouble(c2);
                        }
                        pe02.mo14609j(i3, d);
                        this.f9961e = 0;
                        return true;
                    }
                    long j6 = this.f9963g;
                    StringBuilder sb3 = new StringBuilder(40);
                    sb3.append("Invalid float size: ");
                    sb3.append(j6);
                    throw new zzhw(sb3.toString());
                } else {
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(u);
                    throw new zzhw(sb4.toString());
                }
            } else {
                this.f9960d.mo14614v(this.f9958b.pop().f10364a);
                return true;
            }
        }
    }

    /* renamed from: b */
    public final void mo14439b(pe0 pe0) {
        this.f9960d = pe0;
    }

    public final void reset() {
        this.f9961e = 0;
        this.f9958b.clear();
        this.f9959c.mo14933a();
    }
}
