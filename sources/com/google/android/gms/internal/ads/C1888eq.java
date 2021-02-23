package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.eq */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1888eq implements zzbyl {

    /* renamed from: a */
    private final /* synthetic */ zzdnj f8392a;

    /* renamed from: b */
    private final /* synthetic */ zzdmu f8393b;

    /* renamed from: c */
    private final /* synthetic */ zzcrb f8394c;

    /* renamed from: d */
    final /* synthetic */ zzcvo f8395d;

    C1888eq(zzcvo zzcvo, zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        this.f8395d = zzcvo;
        this.f8392a = zzdnj;
        this.f8393b = zzdmu;
        this.f8394c = zzcrb;
    }

    public final void onInitializationSucceeded() {
        this.f8395d.f14948b.execute(new C1851dq(this, this.f8392a, this.f8393b, this.f8394c));
    }

    public final void zzdy(int i) {
        String valueOf = String.valueOf(this.f8394c.zzchy);
        zzaza.zzfa(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
