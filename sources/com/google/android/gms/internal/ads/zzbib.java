package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbib {

    /* renamed from: a */
    private zzbgl f13324a;

    /* renamed from: b */
    private zzbim f13325b;

    /* renamed from: c */
    private zzdrv f13326c;

    /* renamed from: d */
    private zzbiy f13327d;

    /* renamed from: e */
    private zzdoj f13328e;

    private zzbib() {
    }

    public final zzbib zza(zzbim zzbim) {
        this.f13325b = (zzbim) zzepl.checkNotNull(zzbim);
        return this;
    }

    public final zzbgm zzahg() {
        zzepl.zza(this.f13324a, zzbgl.class);
        zzepl.zza(this.f13325b, zzbim.class);
        if (this.f13326c == null) {
            this.f13326c = new zzdrv();
        }
        if (this.f13327d == null) {
            this.f13327d = new zzbiy();
        }
        if (this.f13328e == null) {
            this.f13328e = new zzdoj();
        }
        return new zzbhg(this.f13324a, this.f13325b, this.f13326c, this.f13327d, this.f13328e);
    }

    public final zzbib zzc(zzbgl zzbgl) {
        this.f13324a = (zzbgl) zzepl.checkNotNull(zzbgl);
        return this;
    }
}
