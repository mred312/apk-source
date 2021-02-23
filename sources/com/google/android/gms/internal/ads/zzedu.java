package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzedu extends zzekh<zzedu, zza> implements zzelu {
    private static volatile zzemb<zzedu> zzei;
    /* access modifiers changed from: private */
    public static final zzedu zzibu;
    private int zzibd;
    private zzedv zzibs;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzedu, zza> implements zzelu {
        private zza() {
            super(zzedu.zzibu);
        }

        /* synthetic */ zza(k60 k60) {
            this();
        }
    }

    static {
        zzedu zzedu = new zzedu();
        zzibu = zzedu;
        zzekh.zza(zzedu.class, zzedu);
    }

    private zzedu() {
    }

    public static zzedu zzj(zzeiu zzeiu, zzeju zzeju) {
        return (zzedu) zzekh.zza(zzibu, zzeiu, zzeju);
    }

    public final int getKeySize() {
        return this.zzibd;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (k60.f9568a[i - 1]) {
            case 1:
                return new zzedu();
            case 2:
                return new zza((k60) null);
            case 3:
                return zzekh.zza((zzels) zzibu, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzibs", "zzibd"});
            case 4:
                return zzibu;
            case 5:
                zzemb<zzedu> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedu.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibu);
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

    public final zzedv zzbbk() {
        zzedv zzedv = this.zzibs;
        return zzedv == null ? zzedv.zzbbo() : zzedv;
    }
}
