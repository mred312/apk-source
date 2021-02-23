package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzedr extends zzekh<zzedr, zza> implements zzelu {
    private static volatile zzemb<zzedr> zzei;
    /* access modifiers changed from: private */
    public static final zzedr zzibt;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;
    private zzedv zzibs;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzedr, zza> implements zzelu {
        private zza() {
            super(zzedr.zzibt);
        }

        public final zza zzb(zzedv zzedv) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedr) this.zzinm).m8670m(zzedv);
            return this;
        }

        public final zza zzey(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedr) this.zzinm).m8666i(0);
            return this;
        }

        public final zza zzv(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedr) this.zzinm).m8672o(zzeiu);
            return this;
        }

        /* synthetic */ zza(j60 j60) {
            this();
        }
    }

    static {
        zzedr zzedr = new zzedr();
        zzibt = zzedr;
        zzekh.zza(zzedr.class, zzedr);
    }

    private zzedr() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8666i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8670m(zzedv zzedv) {
        zzedv.getClass();
        this.zzibs = zzedv;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void m8672o(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zziba = zzeiu;
    }

    public static zza zzbbl() {
        return (zza) zzibt.zzbhx();
    }

    public static zzedr zzi(zzeiu zzeiu, zzeju zzeju) {
        return (zzedr) zzekh.zza(zzibt, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (j60.f9374a[i - 1]) {
            case 1:
                return new zzedr();
            case 2:
                return new zza((j60) null);
            case 3:
                return zzekh.zza((zzels) zzibt, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zziaz", "zzibs", "zziba"});
            case 4:
                return zzibt;
            case 5:
                zzemb<zzedr> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedr.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibt);
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

    public final zzedv zzbbk() {
        zzedv zzedv = this.zzibs;
        return zzedv == null ? zzedv.zzbbo() : zzedv;
    }
}
