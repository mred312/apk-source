package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdte;
import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdti extends zzekh<zzdti, zza> implements zzelu {
    private static volatile zzemb<zzdti> zzei;
    /* access modifiers changed from: private */
    public static final zzdti zzhqy;
    private int zzdt;
    private String zzdu = "";
    private int zzhqv;
    private String zzhqw = "";
    private zzdte zzhqx;

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public static final class zza extends zzekh.zza<zzdti, zza> implements zzelu {
        private zza() {
            super(zzdti.zzhqy);
        }

        public final zza zza(zzdte.zzb zzb) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzdti) this.zzinm).m8498i((zzdte) ((zzekh) zzb.zzbhv()));
            return this;
        }

        public final zza zzb(zzb zzb) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzdti) this.zzinm).m8499j(zzb);
            return this;
        }

        public final zza zzhc(String str) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzdti) this.zzinm).m8504o(str);
            return this;
        }

        /* synthetic */ zza(b10 b10) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public enum zzb implements zzekj {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);
        

        /* renamed from: a */
        private final int f15951a;

        private zzb(int i) {
            this.f15951a = i;
        }

        public static zzb zzei(int i) {
            if (i == 0) {
                return EVENT_TYPE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return BLOCKED_IMPRESSION;
        }

        public static zzekl zzw() {
            return c10.f7956a;
        }

        public final String toString() {
            return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f15951a + " name=" + name() + '>';
        }

        public final int zzv() {
            return this.f15951a;
        }
    }

    static {
        zzdti zzdti = new zzdti();
        zzhqy = zzdti;
        zzekh.zza(zzdti.class, zzdti);
    }

    private zzdti() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8498i(zzdte zzdte) {
        zzdte.getClass();
        this.zzhqx = zzdte;
        this.zzdt |= 8;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public final void m8499j(zzb zzb2) {
        this.zzhqv = zzb2.zzv();
        this.zzdt |= 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void m8504o(String str) {
        str.getClass();
        this.zzdt |= 2;
        this.zzdu = str;
    }

    public static zza zzaxl() {
        return (zza) zzhqy.zzbhx();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (b10.f7864a[i - 1]) {
            case 1:
                return new zzdti();
            case 2:
                return new zza((b10) null);
            case 3:
                return zzekh.zza((zzels) zzhqy, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzdt", "zzhqv", zzb.zzw(), "zzdu", "zzhqw", "zzhqx"});
            case 4:
                return zzhqy;
            case 5:
                zzemb<zzdti> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzdti.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzhqy);
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
}
