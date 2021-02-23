package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeda extends zzekh<zzeda, zza> implements zzelu {
    private static volatile zzemb<zzeda> zzei;
    /* access modifiers changed from: private */
    public static final zzeda zzibc;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;
    private zzedf zzibb;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzeda, zza> implements zzelu {
        private zza() {
            super(zzeda.zzibc);
        }

        public final zza zzd(zzedf zzedf) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeda) this.zzinm).m8645n(zzedf);
            return this;
        }

        public final zza zzev(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeda) this.zzinm).m8640i(0);
            return this;
        }

        public final zza zzt(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeda) this.zzinm).m8646o(zzeiu);
            return this;
        }

        /* synthetic */ zza(b60 b60) {
            this();
        }
    }

    static {
        zzeda zzeda = new zzeda();
        zzibc = zzeda;
        zzekh.zza(zzeda.class, zzeda);
    }

    private zzeda() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8640i(int i) {
        this.zziaz = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public final void m8645n(zzedf zzedf) {
        zzedf.getClass();
        this.zzibb = zzedf;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void m8646o(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zziba = zzeiu;
    }

    public static zza zzbao() {
        return (zza) zzibc.zzbhx();
    }

    public static zzeda zzc(zzeiu zzeiu, zzeju zzeju) {
        return (zzeda) zzekh.zza(zzibc, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (b60.f7875a[i - 1]) {
            case 1:
                return new zzeda();
            case 2:
                return new zza((b60) null);
            case 3:
                return zzekh.zza((zzels) zzibc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zziaz", "zziba", "zzibb"});
            case 4:
                return zzibc;
            case 5:
                zzemb<zzeda> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeda.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibc);
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

    public final zzedf zzban() {
        zzedf zzedf = this.zzibb;
        return zzedf == null ? zzedf.zzbas() : zzedf;
    }
}
