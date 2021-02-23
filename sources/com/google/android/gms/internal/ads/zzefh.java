package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzefh extends zzekh<zzefh, zza> implements zzelu {
    private static volatile zzemb<zzefh> zzei;
    /* access modifiers changed from: private */
    public static final zzefh zzidv;
    private String zzids = "";
    private zzeiu zzidt = zzeiu.zziiy;
    private int zzidu;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzefh, zza> implements zzelu {
        private zza() {
            super(zzefh.zzidv);
        }

        public final zza zzag(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefh) this.zzinm).m8728m(zzeiu);
            return this;
        }

        public final zza zzb(zzb zzb) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefh) this.zzinm).m8724i(zzb);
            return this;
        }

        public final zza zzho(String str) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefh) this.zzinm).m8730o(str);
            return this;
        }

        /* synthetic */ zza(c70 c70) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public enum zzb implements zzekj {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        

        /* renamed from: a */
        private final int f16135a;

        private zzb(int i) {
            this.f16135a = i;
        }

        public static zzb zzfi(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zzb.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzv());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        public final int zzv() {
            if (this != UNRECOGNIZED) {
                return this.f16135a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        zzefh zzefh = new zzefh();
        zzidv = zzefh;
        zzekh.zza(zzefh.class, zzefh);
    }

    private zzefh() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8724i(zzb zzb2) {
        this.zzidu = zzb2.zzv();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8728m(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zzidt = zzeiu;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void m8730o(String str) {
        str.getClass();
        this.zzids = str;
    }

    public static zza zzbdi() {
        return (zza) zzidv.zzbhx();
    }

    public static zzefh zzbdj() {
        return zzidv;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (c70.f7978a[i - 1]) {
            case 1:
                return new zzefh();
            case 2:
                return new zza((c70) null);
            case 3:
                return zzekh.zza((zzels) zzidv, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzids", "zzidt", "zzidu"});
            case 4:
                return zzidv;
            case 5:
                zzemb<zzefh> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefh.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzidv);
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

    public final String zzbdf() {
        return this.zzids;
    }

    public final zzeiu zzbdg() {
        return this.zzidt;
    }

    public final zzb zzbdh() {
        zzb zzfi = zzb.zzfi(this.zzidu);
        return zzfi == null ? zzb.UNRECOGNIZED : zzfi;
    }
}
