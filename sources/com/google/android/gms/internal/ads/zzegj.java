package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzegj extends zzekh<zzegj, zza> implements zzelu {
    private static volatile zzemb<zzegj> zzei;
    /* access modifiers changed from: private */
    public static final zzegj zzifu;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzegj, zza> implements zzelu {
        private zza() {
            super(zzegj.zzifu);
        }

        /* synthetic */ zza(n70 n70) {
            this();
        }
    }

    static {
        zzegj zzegj = new zzegj();
        zzifu = zzegj;
        zzekh.zza(zzegj.class, zzegj);
    }

    private zzegj() {
    }

    public static zzegj zzaa(zzeiu zzeiu, zzeju zzeju) {
        return (zzegj) zzekh.zza(zzifu, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (n70.f10043a[i - 1]) {
            case 1:
                return new zzegj();
            case 2:
                return new zza((n70) null);
            case 3:
                return zzekh.zza((zzels) zzifu, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzifu;
            case 5:
                zzemb<zzegj> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzegj.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzifu);
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
