package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeeu extends zzekh<zzeeu, zza> implements zzelu {
    private static volatile zzemb<zzeeu> zzei;
    /* access modifiers changed from: private */
    public static final zzeeu zzicu;
    private int zziaz;
    private zzeeq zzick;
    private zzeiu zzics;
    private zzeiu zzict;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzeeu, zza> implements zzelu {
        private zza() {
            super(zzeeu.zzicu);
        }

        public final zza zzac(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeu) this.zzinm).m8707m(zzeiu);
            return this;
        }

        public final zza zzad(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeu) this.zzinm).m8708n(zzeiu);
            return this;
        }

        public final zza zzc(zzeeq zzeeq) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeu) this.zzinm).m8709o(zzeeq);
            return this;
        }

        public final zza zzfe(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeu) this.zzinm).m8703i(0);
            return this;
        }

        /* synthetic */ zza(x60 x60) {
            this();
        }
    }

    static {
        zzeeu zzeeu = new zzeeu();
        zzicu = zzeeu;
        zzekh.zza(zzeeu.class, zzeeu);
    }

    private zzeeu() {
        zzeiu zzeiu = zzeiu.zziiy;
        this.zzics = zzeiu;
        this.zzict = zzeiu;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8703i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8707m(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zzics = zzeiu;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public final void m8708n(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zzict = zzeiu;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void m8709o(zzeeq zzeeq) {
        zzeeq.getClass();
        this.zzick = zzeeq;
    }

    public static zza zzbco() {
        return (zza) zzicu.zzbhx();
    }

    public static zzeeu zzbcp() {
        return zzicu;
    }

    public static zzeeu zzs(zzeiu zzeiu, zzeju zzeju) {
        return (zzeeu) zzekh.zza(zzicu, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (x60.f11762a[i - 1]) {
            case 1:
                return new zzeeu();
            case 2:
                return new zza((x60) null);
            case 3:
                return zzekh.zza((zzels) zzicu, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zziaz", "zzick", "zzics", "zzict"});
            case 4:
                return zzicu;
            case 5:
                zzemb<zzeeu> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeeu.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicu);
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

    public final zzeeq zzbcc() {
        zzeeq zzeeq = this.zzick;
        return zzeeq == null ? zzeeq.zzbch() : zzeeq;
    }

    public final zzeiu zzbcm() {
        return this.zzics;
    }

    public final zzeiu zzbcn() {
        return this.zzict;
    }
}
