package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzedm extends zzekh<zzedm, zza> implements zzelu {
    private static volatile zzemb<zzedm> zzei;
    /* access modifiers changed from: private */
    public static final zzedm zzibo;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;
    private zzedq zzibn;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzedm, zza> implements zzelu {
        private zza() {
            super(zzedm.zzibo);
        }

        public final zza zzc(zzedq zzedq) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedm) this.zzinm).m8661m(zzedq);
            return this;
        }

        public final zza zzex(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedm) this.zzinm).m8657i(0);
            return this;
        }

        public final zza zzu(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedm) this.zzinm).m8663o(zzeiu);
            return this;
        }

        /* synthetic */ zza(g60 g60) {
            this();
        }
    }

    static {
        zzedm zzedm = new zzedm();
        zzibo = zzedm;
        zzekh.zza(zzedm.class, zzedm);
    }

    private zzedm() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8657i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8661m(zzedq zzedq) {
        zzedq.getClass();
        this.zzibn = zzedq;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void m8663o(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zziba = zzeiu;
    }

    public static zza zzbbc() {
        return (zza) zzibo.zzbhx();
    }

    public static zzedm zzbbd() {
        return zzibo;
    }

    public static zzedm zzg(zzeiu zzeiu, zzeju zzeju) {
        return (zzedm) zzekh.zza(zzibo, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (g60.f8516a[i - 1]) {
            case 1:
                return new zzedm();
            case 2:
                return new zza((g60) null);
            case 3:
                return zzekh.zza((zzels) zzibo, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zziaz", "zzibn", "zziba"});
            case 4:
                return zzibo;
            case 5:
                zzemb<zzedm> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedm.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibo);
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

    public final zzedq zzbbb() {
        zzedq zzedq = this.zzibn;
        return zzedq == null ? zzedq.zzbbi() : zzedq;
    }
}
