package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzegf extends zzekh<zzegf, zza> implements zzelu {
    private static volatile zzemb<zzegf> zzei;
    /* access modifiers changed from: private */
    public static final zzegf zzifs;
    private String zzifq = "";
    private zzekp<zzefo> zzifr = zzekh.zzbic();

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzegf, zza> implements zzelu {
        private zza() {
            super(zzegf.zzifs);
        }

        /* synthetic */ zza(l70 l70) {
            this();
        }
    }

    static {
        zzegf zzegf = new zzegf();
        zzifs = zzegf;
        zzekh.zza(zzegf.class, zzegf);
    }

    private zzegf() {
    }

    public static zzegf zzbes() {
        return zzifs;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (l70.f9809a[i - 1]) {
            case 1:
                return new zzegf();
            case 2:
                return new zza((l70) null);
            case 3:
                return zzekh.zza((zzels) zzifs, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzifq", "zzifr", zzefo.class});
            case 4:
                return zzifs;
            case 5:
                zzemb<zzegf> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzegf.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzifs);
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

    public final List<zzefo> zzber() {
        return this.zzifr;
    }
}
