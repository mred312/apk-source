package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeeh extends zzekh<zzeeh, zza> implements zzelu {
    private static volatile zzemb<zzeeh> zzei;
    /* access modifiers changed from: private */
    public static final zzeeh zzicb;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzeeh, zza> implements zzelu {
        private zza() {
            super(zzeeh.zzicb);
        }

        /* synthetic */ zza(s60 s60) {
            this();
        }
    }

    static {
        zzeeh zzeeh = new zzeeh();
        zzicb = zzeeh;
        zzekh.zza(zzeeh.class, zzeeh);
    }

    private zzeeh() {
    }

    public static zzeeh zzp(zzeiu zzeiu, zzeju zzeju) {
        return (zzeeh) zzekh.zza(zzicb, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (s60.f10855a[i - 1]) {
            case 1:
                return new zzeeh();
            case 2:
                return new zza((s60) null);
            case 3:
                return zzekh.zza((zzels) zzicb, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzicb;
            case 5:
                zzemb<zzeeh> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeeh.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicb);
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
