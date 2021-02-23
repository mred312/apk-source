package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzedj extends zzekh<zzedj, zza> implements zzelu {
    private static volatile zzemb<zzedj> zzei;
    /* access modifiers changed from: private */
    public static final zzedj zzibm;
    private zzedn zzibk;
    private zzefd zzibl;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzedj, zza> implements zzelu {
        private zza() {
            super(zzedj.zzibm);
        }

        /* synthetic */ zza(f60 f60) {
            this();
        }
    }

    static {
        zzedj zzedj = new zzedj();
        zzibm = zzedj;
        zzekh.zza(zzedj.class, zzedj);
    }

    private zzedj() {
    }

    public static zzedj zzf(zzeiu zzeiu, zzeju zzeju) {
        return (zzedj) zzekh.zza(zzibm, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (f60.f8429a[i - 1]) {
            case 1:
                return new zzedj();
            case 2:
                return new zza((f60) null);
            case 3:
                return zzekh.zza((zzels) zzibm, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzibk", "zzibl"});
            case 4:
                return zzibm;
            case 5:
                zzemb<zzedj> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedj.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibm);
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

    public final zzedn zzbay() {
        zzedn zzedn = this.zzibk;
        return zzedn == null ? zzedn.zzbbf() : zzedn;
    }

    public final zzefd zzbaz() {
        zzefd zzefd = this.zzibl;
        return zzefd == null ? zzefd.zzbda() : zzefd;
    }
}
