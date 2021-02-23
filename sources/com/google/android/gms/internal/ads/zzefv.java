package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzefv extends zzekh<zzefv, zza> implements zzelu {
    private static volatile zzemb<zzefv> zzei;
    /* access modifiers changed from: private */
    public static final zzefv zzifb;
    private int zziaz;
    private zzefw zzifa;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzefv, zza> implements zzelu {
        private zza() {
            super(zzefv.zzifb);
        }

        public final zza zzb(zzefw zzefw) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefv) this.zzinm).m8752l(zzefw);
            return this;
        }

        public final zza zzfo(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefv) this.zzinm).m8749i(0);
            return this;
        }

        /* synthetic */ zza(h70 h70) {
            this();
        }
    }

    static {
        zzefv zzefv = new zzefv();
        zzifb = zzefv;
        zzekh.zza(zzefv.class, zzefv);
    }

    private zzefv() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8749i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void m8752l(zzefw zzefw) {
        zzefw.getClass();
        this.zzifa = zzefw;
    }

    public static zza zzbef() {
        return (zza) zzifb.zzbhx();
    }

    public static zzefv zzv(zzeiu zzeiu, zzeju zzeju) {
        return (zzefv) zzekh.zza(zzifb, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (h70.f8840a[i - 1]) {
            case 1:
                return new zzefv();
            case 2:
                return new zza((h70) null);
            case 3:
                return zzekh.zza((zzels) zzifb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zziaz", "zzifa"});
            case 4:
                return zzifb;
            case 5:
                zzemb<zzefv> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefv.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzifb);
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

    public final zzefw zzbee() {
        zzefw zzefw = this.zzifa;
        return zzefw == null ? zzefw.zzbei() : zzefw;
    }
}
