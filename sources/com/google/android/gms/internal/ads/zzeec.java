package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeec extends zzekh<zzeec, zza> implements zzelu {
    private static volatile zzemb<zzeec> zzei;
    /* access modifiers changed from: private */
    public static final zzeec zziby;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzeec, zza> implements zzelu {
        private zza() {
            super(zzeec.zziby);
        }

        public final zza zzfa(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeec) this.zzinm).m8681i(0);
            return this;
        }

        public final zza zzx(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeec) this.zzinm).m8685m(zzeiu);
            return this;
        }

        /* synthetic */ zza(p60 p60) {
            this();
        }
    }

    static {
        zzeec zzeec = new zzeec();
        zziby = zzeec;
        zzekh.zza(zzeec.class, zzeec);
    }

    private zzeec() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8681i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8685m(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zziba = zzeiu;
    }

    public static zza zzbbt() {
        return (zza) zziby.zzbhx();
    }

    public static zzeec zzm(zzeiu zzeiu, zzeju zzeju) {
        return (zzeec) zzekh.zza(zziby, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (p60.f10435a[i - 1]) {
            case 1:
                return new zzeec();
            case 2:
                return new zza((p60) null);
            case 3:
                return zzekh.zza((zzels) zziby, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zziby;
            case 5:
                zzemb<zzeec> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeec.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zziby);
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
