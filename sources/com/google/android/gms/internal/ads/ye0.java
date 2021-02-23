package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ye0 {

    /* renamed from: a */
    public final int f12185a;

    /* renamed from: b */
    public int f12186b;

    /* renamed from: c */
    public int f12187c;

    /* renamed from: d */
    public long f12188d;

    /* renamed from: e */
    private final boolean f12189e;

    /* renamed from: f */
    private final zzpn f12190f;

    /* renamed from: g */
    private final zzpn f12191g;

    /* renamed from: h */
    private int f12192h;

    /* renamed from: i */
    private int f12193i;

    public ye0(zzpn zzpn, zzpn zzpn2, boolean z) {
        this.f12191g = zzpn;
        this.f12190f = zzpn2;
        this.f12189e = z;
        zzpn2.zzbl(12);
        this.f12185a = zzpn2.zzjf();
        zzpn.zzbl(12);
        this.f12193i = zzpn.zzjf();
        zzpc.checkState(zzpn.readInt() != 1 ? false : true, "first_chunk must be 1");
        this.f12186b = -1;
    }

    /* renamed from: a */
    public final boolean mo15064a() {
        long j;
        int i = this.f12186b + 1;
        this.f12186b = i;
        if (i == this.f12185a) {
            return false;
        }
        if (this.f12189e) {
            j = this.f12190f.zzjg();
        } else {
            j = this.f12190f.zzjc();
        }
        this.f12188d = j;
        if (this.f12186b == this.f12192h) {
            this.f12187c = this.f12191g.zzjf();
            this.f12191g.zzbm(4);
            int i2 = this.f12193i - 1;
            this.f12193i = i2;
            this.f12192h = i2 > 0 ? this.f12191g.zzjf() - 1 : -1;
        }
        return true;
    }
}
