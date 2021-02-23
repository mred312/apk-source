package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzefg extends zzekh<zzefg, zza> implements zzelu {
    private static volatile zzemb<zzefg> zzei;
    /* access modifiers changed from: private */
    public static final zzefg zzidr;
    private int zzibf;
    private int zzidq;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzefg, zza> implements zzelu {
        private zza() {
            super(zzefg.zzidr);
        }

        /* synthetic */ zza(b70 b70) {
            this();
        }
    }

    static {
        zzefg zzefg = new zzefg();
        zzidr = zzefg;
        zzekh.zza(zzefg.class, zzefg);
    }

    private zzefg() {
    }

    public static zzefg zzbdd() {
        return zzidr;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (b70.f7876a[i - 1]) {
            case 1:
                return new zzefg();
            case 2:
                return new zza((b70) null);
            case 3:
                return zzekh.zza((zzels) zzidr, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzidq", "zzibf"});
            case 4:
                return zzidr;
            case 5:
                zzemb<zzefg> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefg.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzidr);
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

    public final int zzbar() {
        return this.zzibf;
    }

    public final zzefa zzbdc() {
        zzefa zzfg = zzefa.zzfg(this.zzidq);
        return zzfg == null ? zzefa.UNRECOGNIZED : zzfg;
    }
}
