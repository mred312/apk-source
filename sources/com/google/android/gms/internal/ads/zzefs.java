package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzefs extends zzekh<zzefs, zza> implements zzelu {
    private static volatile zzemb<zzefs> zzei;
    /* access modifiers changed from: private */
    public static final zzefs zziey;
    private int zzieq;
    private zzekp<zzb> zziex = zzekh.zzbic();

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzefs, zza> implements zzelu {
        private zza() {
            super(zzefs.zziey);
        }

        public final zza zzb(zzb zzb) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefs) this.zzinm).m8735i(zzb);
            return this;
        }

        public final zza zzfl(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefs) this.zzinm).m8739m(i);
            return this;
        }

        /* synthetic */ zza(g70 g70) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzb extends zzekh<zzb, zza> implements zzelu {
        private static volatile zzemb<zzb> zzei;
        /* access modifiers changed from: private */
        public static final zzb zziez;
        private String zzids = "";
        private int zziej;
        private int zzieu;
        private int zziev;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzb, zza> implements zzelu {
            private zza() {
                super(zzb.zziez);
            }

            public final zza zza(zzefl zzefl) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8744m(zzefl);
                return this;
            }

            public final zza zzfm(int i) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8747p(i);
                return this;
            }

            public final zza zzhp(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8748q(str);
                return this;
            }

            /* synthetic */ zza(g70 g70) {
                this();
            }

            public final zza zza(zzegd zzegd) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8745n(zzegd);
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zziez = zzb;
            zzekh.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        /* renamed from: m */
        public final void m8744m(zzefl zzefl) {
            this.zzieu = zzefl.zzv();
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public final void m8745n(zzegd zzegd) {
            this.zziej = zzegd.zzv();
        }

        /* access modifiers changed from: private */
        /* renamed from: p */
        public final void m8747p(int i) {
            this.zziev = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: q */
        public final void m8748q(String str) {
            str.getClass();
            this.zzids = str;
        }

        public static zza zzbec() {
            return (zza) zziez.zzbhx();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (g70.f8518a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((g70) null);
                case 3:
                    return zzekh.zza((zzels) zziez, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzids", "zzieu", "zziev", "zziej"});
                case 4:
                    return zziez;
                case 5:
                    zzemb<zzb> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzb.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zziez);
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

    static {
        zzefs zzefs = new zzefs();
        zziey = zzefs;
        zzekh.zza(zzefs.class, zzefs);
    }

    private zzefs() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8735i(zzb zzb2) {
        zzb2.getClass();
        zzekp<zzb> zzekp = this.zziex;
        if (!zzekp.zzbfk()) {
            this.zziex = zzekh.zza(zzekp);
        }
        this.zziex.add(zzb2);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8739m(int i) {
        this.zzieq = i;
    }

    public static zza zzbea() {
        return (zza) zziey.zzbhx();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (g70.f8518a[i - 1]) {
            case 1:
                return new zzefs();
            case 2:
                return new zza((g70) null);
            case 3:
                return zzekh.zza((zzels) zziey, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzieq", "zziex", zzb.class});
            case 4:
                return zziey;
            case 5:
                zzemb<zzefs> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefs.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zziey);
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
