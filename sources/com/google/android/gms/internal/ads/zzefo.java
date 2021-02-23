package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzefo extends zzekh<zzefo, zza> implements zzelu {
    private static volatile zzemb<zzefo> zzei;
    /* access modifiers changed from: private */
    public static final zzefo zziep;
    private String zzids = "";
    private String zziel = "";
    private int zziem;
    private boolean zzien;
    private String zzieo = "";

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzefo, zza> implements zzelu {
        private zza() {
            super(zzefo.zziep);
        }

        /* synthetic */ zza(e70 e70) {
            this();
        }
    }

    static {
        zzefo zzefo = new zzefo();
        zziep = zzefo;
        zzekh.zza(zzefo.class, zzefo);
    }

    private zzefo() {
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (e70.f8322a[i - 1]) {
            case 1:
                return new zzefo();
            case 2:
                return new zza((e70) null);
            case 3:
                return zzekh.zza((zzels) zziep, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zziel", "zzids", "zziem", "zzien", "zzieo"});
            case 4:
                return zziep;
            case 5:
                zzemb<zzefo> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefo.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zziep);
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

    public final String zzbdf() {
        return this.zzids;
    }

    public final String zzbdn() {
        return this.zziel;
    }

    public final int zzbdo() {
        return this.zziem;
    }

    public final boolean zzbdp() {
        return this.zzien;
    }

    public final String zzbdq() {
        return this.zzieo;
    }
}
