package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdte extends zzekh<zzdte, zzb> implements zzelu {
    private static volatile zzemb<zzdte> zzei;
    private static final zzekn<Integer, zza> zzhqn = new y00();
    /* access modifiers changed from: private */
    public static final zzdte zzhqr;
    private int zzdt;
    private zzeko zzhqm = zzekh.zzbia();
    private String zzhqo = "";
    private String zzhqp = "";
    private String zzhqq = "";

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public enum zza implements zzekj {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        

        /* renamed from: a */
        private final int f15948a;

        private zza(int i) {
            this.f15948a = i;
        }

        public static zza zzeh(int i) {
            if (i == 1) {
                return BLOCKED_REASON_UNKNOWN;
            }
            if (i != 2) {
                return null;
            }
            return BLOCKED_REASON_BACKGROUND;
        }

        public static zzekl zzw() {
            return a10.f7777a;
        }

        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f15948a + " name=" + name() + '>';
        }

        public final int zzv() {
            return this.f15948a;
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public static final class zzb extends zzekh.zza<zzdte, zzb> implements zzelu {
        private zzb() {
            super(zzdte.zzhqr);
        }

        public final zzb zzb(zza zza) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzdte) this.zzinm).m8493i(zza);
            return this;
        }

        public final zzb zzhb(String str) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzdte) this.zzinm).m8497m(str);
            return this;
        }

        /* synthetic */ zzb(y00 y00) {
            this();
        }
    }

    static {
        zzdte zzdte = new zzdte();
        zzhqr = zzdte;
        zzekh.zza(zzdte.class, zzdte);
    }

    private zzdte() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8493i(zza zza2) {
        zza2.getClass();
        zzeko zzeko = this.zzhqm;
        if (!zzeko.zzbfk()) {
            this.zzhqm = zzekh.zza(zzeko);
        }
        this.zzhqm.zzhg(zza2.zzv());
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8497m(String str) {
        str.getClass();
        this.zzdt |= 1;
        this.zzhqo = str;
    }

    public static zzb zzaxj() {
        return (zzb) zzhqr.zzbhx();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (z00.f12244a[i - 1]) {
            case 1:
                return new zzdte();
            case 2:
                return new zzb((y00) null);
            case 3:
                return zzekh.zza((zzels) zzhqr, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzdt", "zzhqm", zza.zzw(), "zzhqo", "zzhqp", "zzhqq"});
            case 4:
                return zzhqr;
            case 5:
                zzemb<zzdte> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzdte.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzhqr);
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
