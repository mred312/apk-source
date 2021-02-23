package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbfn {

    /* renamed from: a */
    private final int f13241a;
    public final int heightPixels;
    public final int widthPixels;

    private zzbfn(int i, int i2, int i3) {
        this.f13241a = i;
        this.widthPixels = i2;
        this.heightPixels = i3;
    }

    public static zzbfn zzadv() {
        return new zzbfn(0, 0, 0);
    }

    public static zzbfn zzadw() {
        return new zzbfn(4, 0, 0);
    }

    public static zzbfn zzadx() {
        return new zzbfn(5, 0, 0);
    }

    public static zzbfn zzb(zzvn zzvn) {
        if (zzvn.zzchp) {
            return new zzbfn(3, 0, 0);
        }
        if (zzvn.zzchr) {
            return new zzbfn(2, 0, 0);
        }
        if (zzvn.zzbrh) {
            return zzadv();
        }
        return zzq(zzvn.widthPixels, zzvn.heightPixels);
    }

    public static zzbfn zzq(int i, int i2) {
        return new zzbfn(1, i, i2);
    }

    public final boolean isFluid() {
        return this.f13241a == 2;
    }

    public final boolean zzady() {
        return this.f13241a == 3;
    }

    public final boolean zzadz() {
        return this.f13241a == 0;
    }

    public final boolean zzaea() {
        return this.f13241a == 4;
    }

    public final boolean zzaeb() {
        return this.f13241a == 5;
    }
}
