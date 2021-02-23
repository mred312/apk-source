package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeen extends zzekh<zzeen, zza> implements zzelu {
    private static volatile zzemb<zzeen> zzei;
    /* access modifiers changed from: private */
    public static final zzeen zzicl;
    private zzeeq zzick;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzeen, zza> implements zzelu {
        private zza() {
            super(zzeen.zzicl);
        }

        /* synthetic */ zza(u60 u60) {
            this();
        }
    }

    static {
        zzeen zzeen = new zzeen();
        zzicl = zzeen;
        zzekh.zza(zzeen.class, zzeen);
    }

    private zzeen() {
    }

    public static zzeen zzq(zzeiu zzeiu, zzeju zzeju) {
        return (zzeen) zzekh.zza(zzicl, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (u60.f11252a[i - 1]) {
            case 1:
                return new zzeen();
            case 2:
                return new zza((u60) null);
            case 3:
                return zzekh.zza((zzels) zzicl, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzick"});
            case 4:
                return zzicl;
            case 5:
                zzemb<zzeen> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeen.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicl);
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

    public final zzeeq zzbcc() {
        zzeeq zzeeq = this.zzick;
        return zzeeq == null ? zzeeq.zzbch() : zzeeq;
    }
}
