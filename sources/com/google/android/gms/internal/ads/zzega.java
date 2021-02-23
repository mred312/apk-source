package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzega extends zzekh<zzega, zza> implements zzelu {
    private static volatile zzemb<zzega> zzei;
    /* access modifiers changed from: private */
    public static final zzega zzifi;
    private String zzifg = "";
    private zzefn zzifh;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzega, zza> implements zzelu {
        private zza() {
            super(zzega.zzifi);
        }

        /* synthetic */ zza(k70 k70) {
            this();
        }
    }

    static {
        zzega zzega = new zzega();
        zzifi = zzega;
        zzekh.zza(zzega.class, zzega);
    }

    private zzega() {
    }

    public static zzega zzbep() {
        return zzifi;
    }

    public static zzega zzy(zzeiu zzeiu, zzeju zzeju) {
        return (zzega) zzekh.zza(zzifi, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (k70.f9570a[i - 1]) {
            case 1:
                return new zzega();
            case 2:
                return new zza((k70) null);
            case 3:
                return zzekh.zza((zzels) zzifi, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzifg", "zzifh"});
            case 4:
                return zzifi;
            case 5:
                zzemb<zzega> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzega.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzifi);
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

    public final String zzben() {
        return this.zzifg;
    }

    public final zzefn zzbeo() {
        zzefn zzefn = this.zzifh;
        return zzefn == null ? zzefn.zzbdl() : zzefn;
    }
}
