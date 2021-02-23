package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.kz */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2119kz {

    /* renamed from: a */
    private final long f9784a;

    /* renamed from: b */
    private final zzdqg f9785b = new zzdqg();

    /* renamed from: c */
    private long f9786c;

    /* renamed from: d */
    private int f9787d = 0;

    /* renamed from: e */
    private int f9788e = 0;

    /* renamed from: f */
    private int f9789f = 0;

    public C2119kz() {
        long currentTimeMillis = zzp.zzkx().currentTimeMillis();
        this.f9784a = currentTimeMillis;
        this.f9786c = currentTimeMillis;
    }

    /* renamed from: a */
    public final long mo14355a() {
        return this.f9784a;
    }

    /* renamed from: b */
    public final long mo14356b() {
        return this.f9786c;
    }

    /* renamed from: c */
    public final int mo14357c() {
        return this.f9787d;
    }

    /* renamed from: d */
    public final String mo14358d() {
        return "Created: " + this.f9784a + " Last accessed: " + this.f9786c + " Accesses: " + this.f9787d + "\nEntries retrieved: Valid: " + this.f9788e + " Stale: " + this.f9789f;
    }

    /* renamed from: e */
    public final void mo14359e() {
        this.f9786c = zzp.zzkx().currentTimeMillis();
        this.f9787d++;
    }

    /* renamed from: f */
    public final void mo14360f() {
        this.f9788e++;
        this.f9785b.zzhnd = true;
    }

    /* renamed from: g */
    public final void mo14361g() {
        this.f9789f++;
        this.f9785b.zzhmy++;
    }

    /* renamed from: h */
    public final zzdqg mo14362h() {
        zzdqg zzdqg = (zzdqg) this.f9785b.clone();
        zzdqg zzdqg2 = this.f9785b;
        zzdqg2.zzhnd = false;
        zzdqg2.zzhmy = 0;
        return zzdqg;
    }
}
