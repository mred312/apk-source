package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeeg extends zzekh<zzeeg, zza> implements zzelu {
    private static volatile zzemb<zzeeg> zzei;
    /* access modifiers changed from: private */
    public static final zzeeg zzica;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzeeg, zza> implements zzelu {
        private zza() {
            super(zzeeg.zzica);
        }

        public final zza zzfb(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeg) this.zzinm).m8687i(0);
            return this;
        }

        public final zza zzy(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeg) this.zzinm).m8691m(zzeiu);
            return this;
        }

        /* synthetic */ zza(r60 r60) {
            this();
        }
    }

    static {
        zzeeg zzeeg = new zzeeg();
        zzica = zzeeg;
        zzekh.zza(zzeeg.class, zzeeg);
    }

    private zzeeg() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8687i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8691m(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zziba = zzeiu;
    }

    public static zza zzbbw() {
        return (zza) zzica.zzbhx();
    }

    public static zzeeg zzo(zzeiu zzeiu, zzeju zzeju) {
        return (zzeeg) zzekh.zza(zzica, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (r60.f10767a[i - 1]) {
            case 1:
                return new zzeeg();
            case 2:
                return new zza((r60) null);
            case 3:
                return zzekh.zza((zzels) zzica, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zzica;
            case 5:
                zzemb<zzeeg> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeeg.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzica);
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

    public final zzeiu zzbam() {
        return this.zziba;
    }
}
