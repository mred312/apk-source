package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzefd extends zzekh<zzefd, zza> implements zzelu {
    private static volatile zzemb<zzefd> zzei;
    /* access modifiers changed from: private */
    public static final zzefd zzidp;
    private int zziaz;
    private int zzibd;
    private zzefg zzidn;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzefd, zza> implements zzelu {
        private zza() {
            super(zzefd.zzidp);
        }

        /* synthetic */ zza(a70 a70) {
            this();
        }
    }

    static {
        zzefd zzefd = new zzefd();
        zzidp = zzefd;
        zzekh.zza(zzefd.class, zzefd);
    }

    private zzefd() {
    }

    public static zzefd zzbda() {
        return zzidp;
    }

    public static zzefd zzu(zzeiu zzeiu, zzeju zzeju) {
        return (zzefd) zzekh.zza(zzidp, zzeiu, zzeju);
    }

    public final int getKeySize() {
        return this.zzibd;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (a70.f7793a[i - 1]) {
            case 1:
                return new zzefd();
            case 2:
                return new zza((a70) null);
            case 3:
                return zzekh.zza((zzels) zzidp, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzidn", "zzibd", "zziaz"});
            case 4:
                return zzidp;
            case 5:
                zzemb<zzefd> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefd.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzidp);
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

    public final zzefg zzbcw() {
        zzefg zzefg = this.zzidn;
        return zzefg == null ? zzefg.zzbdd() : zzefg;
    }
}
