package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzedy extends zzekh<zzedy, zza> implements zzelu {
    private static volatile zzemb<zzedy> zzei;
    /* access modifiers changed from: private */
    public static final zzedy zzibw;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzedy, zza> implements zzelu {
        private zza() {
            super(zzedy.zzibw);
        }

        public final zza zzez(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedy) this.zzinm).m8675i(0);
            return this;
        }

        public final zza zzw(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedy) this.zzinm).m8679m(zzeiu);
            return this;
        }

        /* synthetic */ zza(m60 m60) {
            this();
        }
    }

    static {
        zzedy zzedy = new zzedy();
        zzibw = zzedy;
        zzekh.zza(zzedy.class, zzedy);
    }

    private zzedy() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8675i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8679m(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zziba = zzeiu;
    }

    public static zza zzbbq() {
        return (zza) zzibw.zzbhx();
    }

    public static zzedy zzk(zzeiu zzeiu, zzeju zzeju) {
        return (zzedy) zzekh.zza(zzibw, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (m60.f9916a[i - 1]) {
            case 1:
                return new zzedy();
            case 2:
                return new zza((m60) null);
            case 3:
                return zzekh.zza((zzels) zzibw, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zzibw;
            case 5:
                zzemb<zzedy> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedy.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibw);
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
