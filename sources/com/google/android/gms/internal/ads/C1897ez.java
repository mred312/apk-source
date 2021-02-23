package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ez */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1897ez {

    /* renamed from: a */
    private final zzdph f8409a = new zzdph();

    /* renamed from: b */
    private int f8410b;

    /* renamed from: c */
    private int f8411c;

    /* renamed from: d */
    private int f8412d;

    /* renamed from: e */
    private int f8413e;

    /* renamed from: f */
    private int f8414f;

    C1897ez() {
    }

    /* renamed from: a */
    public final void mo13922a() {
        this.f8412d++;
    }

    /* renamed from: b */
    public final void mo13923b() {
        this.f8413e++;
    }

    /* renamed from: c */
    public final void mo13924c() {
        this.f8410b++;
        this.f8409a.zzhkw = true;
    }

    /* renamed from: d */
    public final void mo13925d() {
        this.f8411c++;
        this.f8409a.zzhkx = true;
    }

    /* renamed from: e */
    public final void mo13926e() {
        this.f8414f++;
    }

    /* renamed from: f */
    public final zzdph mo13927f() {
        zzdph zzdph = (zzdph) this.f8409a.clone();
        zzdph zzdph2 = this.f8409a;
        zzdph2.zzhkw = false;
        zzdph2.zzhkx = false;
        return zzdph;
    }

    /* renamed from: g */
    public final String mo13928g() {
        return "\n\tPool does not exist: " + this.f8412d + "\n\tNew pools created: " + this.f8410b + "\n\tPools removed: " + this.f8411c + "\n\tEntries added: " + this.f8414f + "\n\tNo entries retrieved: " + this.f8413e + "\n";
    }
}
