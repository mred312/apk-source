package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbro implements zzepf<zzbrp> {

    /* renamed from: a */
    private final zzeps<zzdmu> f13741a;

    /* renamed from: b */
    private final zzeps<String> f13742b;

    /* renamed from: c */
    private final zzeps<zzcrg> f13743c;

    private zzbro(zzeps<zzdmu> zzeps, zzeps<String> zzeps2, zzeps<zzcrg> zzeps3) {
        this.f13741a = zzeps;
        this.f13742b = zzeps2;
        this.f13743c = zzeps3;
    }

    public static zzbro zzi(zzeps<zzdmu> zzeps, zzeps<String> zzeps2, zzeps<zzcrg> zzeps3) {
        return new zzbro(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzbrp(this.f13741a.get(), this.f13742b.get(), this.f13743c.get());
    }
}
