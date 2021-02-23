package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzefz extends zzekh<zzefz, zza> implements zzelu {
    private static volatile zzemb<zzefz> zzei;
    /* access modifiers changed from: private */
    public static final zzefz zziff;
    private int zziaz;
    private zzega zzife;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzefz, zza> implements zzelu {
        private zza() {
            super(zzefz.zziff);
        }

        public final zza zzb(zzega zzega) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefz) this.zzinm).m8758l(zzega);
            return this;
        }

        public final zza zzfp(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefz) this.zzinm).m8755i(0);
            return this;
        }

        /* synthetic */ zza(j70 j70) {
            this();
        }
    }

    static {
        zzefz zzefz = new zzefz();
        zziff = zzefz;
        zzekh.zza(zzefz.class, zzefz);
    }

    private zzefz() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8755i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void m8758l(zzega zzega) {
        zzega.getClass();
        this.zzife = zzega;
    }

    public static zza zzbel() {
        return (zza) zziff.zzbhx();
    }

    public static zzefz zzx(zzeiu zzeiu, zzeju zzeju) {
        return (zzefz) zzekh.zza(zziff, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (j70.f9376a[i - 1]) {
            case 1:
                return new zzefz();
            case 2:
                return new zza((j70) null);
            case 3:
                return zzekh.zza((zzels) zziff, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zziaz", "zzife"});
            case 4:
                return zziff;
            case 5:
                zzemb<zzefz> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefz.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zziff);
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

    public final zzega zzbek() {
        zzega zzega = this.zzife;
        return zzega == null ? zzega.zzbep() : zzega;
    }
}
