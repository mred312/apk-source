package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzefc extends zzekh<zzefc, zza> implements zzelu {
    private static volatile zzemb<zzefc> zzei;
    /* access modifiers changed from: private */
    public static final zzefc zzido;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;
    private zzefg zzidn;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzefc, zza> implements zzelu {
        private zza() {
            super(zzefc.zzido);
        }

        public final zza zzae(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefc) this.zzinm).m8721o(zzeiu);
            return this;
        }

        public final zza zzd(zzefg zzefg) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefc) this.zzinm).m8720n(zzefg);
            return this;
        }

        public final zza zzfh(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefc) this.zzinm).m8715i(0);
            return this;
        }

        /* synthetic */ zza(z60 z60) {
            this();
        }
    }

    static {
        zzefc zzefc = new zzefc();
        zzido = zzefc;
        zzekh.zza(zzefc.class, zzefc);
    }

    private zzefc() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8715i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public final void m8720n(zzefg zzefg) {
        zzefg.getClass();
        this.zzidn = zzefg;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void m8721o(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zziba = zzeiu;
    }

    public static zza zzbcx() {
        return (zza) zzido.zzbhx();
    }

    public static zzefc zzbcy() {
        return zzido;
    }

    public static zzefc zzt(zzeiu zzeiu, zzeju zzeju) {
        return (zzefc) zzekh.zza(zzido, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (z60.f12258a[i - 1]) {
            case 1:
                return new zzefc();
            case 2:
                return new zza((z60) null);
            case 3:
                return zzekh.zza((zzels) zzido, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zziaz", "zzidn", "zziba"});
            case 4:
                return zzido;
            case 5:
                zzemb<zzefc> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefc.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzido);
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

    public final zzefg zzbcw() {
        zzefg zzefg = this.zzidn;
        return zzefg == null ? zzefg.zzbdd() : zzefg;
    }
}
