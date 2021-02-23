package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzegg extends zzekh<zzegg, zza> implements zzelu {
    private static volatile zzemb<zzegg> zzei;
    /* access modifiers changed from: private */
    public static final zzegg zzift;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzegg, zza> implements zzelu {
        private zza() {
            super(zzegg.zzift);
        }

        public final zza zzah(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzegg) this.zzinm).m8766m(zzeiu);
            return this;
        }

        public final zza zzfr(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzegg) this.zzinm).m8762i(0);
            return this;
        }

        /* synthetic */ zza(m70 m70) {
            this();
        }
    }

    static {
        zzegg zzegg = new zzegg();
        zzift = zzegg;
        zzekh.zza(zzegg.class, zzegg);
    }

    private zzegg() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8762i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8766m(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zziba = zzeiu;
    }

    public static zza zzbeu() {
        return (zza) zzift.zzbhx();
    }

    public static zzegg zzz(zzeiu zzeiu, zzeju zzeju) {
        return (zzegg) zzekh.zza(zzift, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (m70.f9918a[i - 1]) {
            case 1:
                return new zzegg();
            case 2:
                return new zza((m70) null);
            case 3:
                return zzekh.zza((zzels) zzift, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zzift;
            case 5:
                zzemb<zzegg> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzegg.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzift);
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
