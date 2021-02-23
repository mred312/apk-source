package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class mf0 {

    /* renamed from: a */
    public ef0 f9964a;

    /* renamed from: b */
    public long f9965b;

    /* renamed from: c */
    public long f9966c;

    /* renamed from: d */
    public long f9967d;

    /* renamed from: e */
    public int f9968e;

    /* renamed from: f */
    public int f9969f;

    /* renamed from: g */
    public long[] f9970g;

    /* renamed from: h */
    public int[] f9971h;

    /* renamed from: i */
    public int[] f9972i;

    /* renamed from: j */
    public int[] f9973j;

    /* renamed from: k */
    public long[] f9974k;

    /* renamed from: l */
    public boolean[] f9975l;

    /* renamed from: m */
    public boolean f9976m;

    /* renamed from: n */
    public boolean[] f9977n;

    /* renamed from: o */
    public zzlr f9978o;

    /* renamed from: p */
    public int f9979p;

    /* renamed from: q */
    public zzpn f9980q;

    /* renamed from: r */
    public boolean f9981r;

    /* renamed from: s */
    public long f9982s;

    mf0() {
    }

    /* renamed from: a */
    public final void mo14441a(int i) {
        zzpn zzpn = this.f9980q;
        if (zzpn == null || zzpn.limit() < i) {
            this.f9980q = new zzpn(i);
        }
        this.f9979p = i;
        this.f9976m = true;
        this.f9981r = true;
    }

    /* renamed from: b */
    public final long mo14442b(int i) {
        return this.f9974k[i] + ((long) this.f9973j[i]);
    }
}
