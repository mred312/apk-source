package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeeq extends zzekh<zzeeq, zza> implements zzelu {
    private static volatile zzemb<zzeeq> zzei;
    /* access modifiers changed from: private */
    public static final zzeeq zzicp;
    private zzeev zzicm;
    private zzeem zzicn;
    private int zzico;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzeeq, zza> implements zzelu {
        private zza() {
            super(zzeeq.zzicp);
        }

        /* synthetic */ zza(v60 v60) {
            this();
        }
    }

    static {
        zzeeq zzeeq = new zzeeq();
        zzicp = zzeeq;
        zzekh.zza(zzeeq.class, zzeeq);
    }

    private zzeeq() {
    }

    public static zzeeq zzbch() {
        return zzicp;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (v60.f11472a[i - 1]) {
            case 1:
                return new zzeeq();
            case 2:
                return new zza((v60) null);
            case 3:
                return zzekh.zza((zzels) zzicp, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzicm", "zzicn", "zzico"});
            case 4:
                return zzicp;
            case 5:
                zzemb<zzeeq> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeeq.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicp);
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

    public final zzeev zzbce() {
        zzeev zzeev = this.zzicm;
        return zzeev == null ? zzeev.zzbcu() : zzeev;
    }

    public final zzeem zzbcf() {
        zzeem zzeem = this.zzicn;
        return zzeem == null ? zzeem.zzbca() : zzeem;
    }

    public final zzeek zzbcg() {
        zzeek zzfc = zzeek.zzfc(this.zzico);
        return zzfc == null ? zzeek.UNRECOGNIZED : zzfc;
    }
}
