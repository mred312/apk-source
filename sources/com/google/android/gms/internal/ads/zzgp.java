package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzgp extends zzekh<zzgp, zza> implements zzelu {
    /* access modifiers changed from: private */
    public static final zzgp zzabz;
    private static volatile zzemb<zzgp> zzei;
    private zzgt zzabw;
    private zzeiu zzabx;
    private zzeiu zzaby;
    private int zzdt;

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public static final class zza extends zzekh.zza<zzgp, zza> implements zzelu {
        private zza() {
            super(zzgp.zzabz);
        }

        /* synthetic */ zza(id0 id0) {
            this();
        }
    }

    static {
        zzgp zzgp = new zzgp();
        zzabz = zzgp;
        zzekh.zza(zzgp.class, zzgp);
    }

    private zzgp() {
        zzeiu zzeiu = zzeiu.zziiy;
        this.zzabx = zzeiu;
        this.zzaby = zzeiu;
    }

    public static zzgp zza(zzeiu zzeiu, zzeju zzeju) {
        return (zzgp) zzekh.zza(zzabz, zzeiu, zzeju);
    }

    public final zzgt zzdc() {
        zzgt zzgt = this.zzabw;
        return zzgt == null ? zzgt.zzdm() : zzgt;
    }

    public final zzeiu zzdd() {
        return this.zzabx;
    }

    public final zzeiu zzde() {
        return this.zzaby;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (id0.f9314a[i - 1]) {
            case 1:
                return new zzgp();
            case 2:
                return new zza((id0) null);
            case 3:
                return zzekh.zza((zzels) zzabz, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdt", "zzabw", "zzabx", "zzaby"});
            case 4:
                return zzabz;
            case 5:
                zzemb<zzgp> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzgp.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzabz);
                            zzei = zzemb;
                        }
                    }
                }
                return zzemb;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
