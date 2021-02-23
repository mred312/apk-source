package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzedq extends zzekh<zzedq, zza> implements zzelu {
    private static volatile zzemb<zzedq> zzei;
    /* access modifiers changed from: private */
    public static final zzedq zzibr;
    private int zzibq;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzedq, zza> implements zzelu {
        private zza() {
            super(zzedq.zzibr);
        }

        /* synthetic */ zza(i60 i60) {
            this();
        }
    }

    static {
        zzedq zzedq = new zzedq();
        zzibr = zzedq;
        zzekh.zza(zzedq.class, zzedq);
    }

    private zzedq() {
    }

    public static zzedq zzbbi() {
        return zzibr;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (i60.f9261a[i - 1]) {
            case 1:
                return new zzedq();
            case 2:
                return new zza((i60) null);
            case 3:
                return zzekh.zza((zzels) zzibr, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzibq"});
            case 4:
                return zzibr;
            case 5:
                zzemb<zzedq> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedq.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibr);
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

    public final int zzbbh() {
        return this.zzibq;
    }
}
