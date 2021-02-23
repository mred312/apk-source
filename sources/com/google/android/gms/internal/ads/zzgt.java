package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzgt extends zzekh<zzgt, zza> implements zzelu {
    /* access modifiers changed from: private */
    public static final zzgt zzacf;
    private static volatile zzemb<zzgt> zzei;
    private String zzaca = "";
    private String zzacb = "";
    private long zzacc;
    private long zzacd;
    private long zzace;
    private int zzdt;

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public static final class zza extends zzekh.zza<zzgt, zza> implements zzelu {
        private zza() {
            super(zzgt.zzacf);
        }

        public final zza zzav(String str) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzgt) this.zzinm).m8951k(str);
            return this;
        }

        public final zza zzaw(String str) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzgt) this.zzinm).m8952l(str);
            return this;
        }

        public final zza zzdj(long j) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzgt) this.zzinm).m8956p(j);
            return this;
        }

        public final zza zzdk(long j) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzgt) this.zzinm).m8957q(j);
            return this;
        }

        public final zza zzdl(long j) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzgt) this.zzinm).m8958r(j);
            return this;
        }

        /* synthetic */ zza(jd0 jd0) {
            this();
        }
    }

    static {
        zzgt zzgt = new zzgt();
        zzacf = zzgt;
        zzekh.zza(zzgt.class, zzgt);
    }

    private zzgt() {
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public final void m8951k(String str) {
        str.getClass();
        this.zzdt |= 1;
        this.zzaca = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void m8952l(String str) {
        str.getClass();
        this.zzdt |= 2;
        this.zzacb = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public final void m8956p(long j) {
        this.zzdt |= 4;
        this.zzacc = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public final void m8957q(long j) {
        this.zzdt |= 8;
        this.zzacd = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public final void m8958r(long j) {
        this.zzdt |= 16;
        this.zzace = j;
    }

    public static zzgt zzb(zzeiu zzeiu, zzeju zzeju) {
        return (zzgt) zzekh.zza(zzacf, zzeiu, zzeju);
    }

    public static zza zzdl() {
        return (zza) zzacf.zzbhx();
    }

    public static zzgt zzdm() {
        return zzacf;
    }

    public static zzgt zzl(zzeiu zzeiu) {
        return (zzgt) zzekh.zza(zzacf, zzeiu);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (jd0.f9478a[i - 1]) {
            case 1:
                return new zzgt();
            case 2:
                return new zza((jd0) null);
            case 3:
                return zzekh.zza((zzels) zzacf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzdt", "zzaca", "zzacb", "zzacc", "zzacd", "zzace"});
            case 4:
                return zzacf;
            case 5:
                zzemb<zzgt> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzgt.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzacf);
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

    public final String zzdg() {
        return this.zzaca;
    }

    public final String zzdh() {
        return this.zzacb;
    }

    public final long zzdi() {
        return this.zzacc;
    }

    public final long zzdj() {
        return this.zzacd;
    }

    public final long zzdk() {
        return this.zzace;
    }
}
