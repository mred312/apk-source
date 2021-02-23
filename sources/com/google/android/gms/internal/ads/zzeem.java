package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeem extends zzekh<zzeem, zza> implements zzelu {
    private static volatile zzemb<zzeem> zzei;
    /* access modifiers changed from: private */
    public static final zzeem zzicj;
    private zzefn zzici;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzeem, zza> implements zzelu {
        private zza() {
            super(zzeem.zzicj);
        }

        /* synthetic */ zza(t60 t60) {
            this();
        }
    }

    static {
        zzeem zzeem = new zzeem();
        zzicj = zzeem;
        zzekh.zza(zzeem.class, zzeem);
    }

    private zzeem() {
    }

    public static zzeem zzbca() {
        return zzicj;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (t60.f11137a[i - 1]) {
            case 1:
                return new zzeem();
            case 2:
                return new zza((t60) null);
            case 3:
                return zzekh.zza((zzels) zzicj, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzici"});
            case 4:
                return zzicj;
            case 5:
                zzemb<zzeem> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeem.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicj);
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

    public final zzefn zzbbz() {
        zzefn zzefn = this.zzici;
        return zzefn == null ? zzefn.zzbdl() : zzefn;
    }
}
