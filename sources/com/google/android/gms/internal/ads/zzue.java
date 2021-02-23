package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzue {

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh<zza, zzb> implements zzelu {
        /* access modifiers changed from: private */
        public static final zza zzbyx;
        private static volatile zzemb<zza> zzei;
        private int zzbym;
        private int zzbyn = 1000;
        private zzd zzbyo;
        private zze zzbyp;
        private zzekp<zzc> zzbyq = zzekh.zzbic();
        private zzf zzbyr;
        private zzp zzbys;
        private zzn zzbyt;
        private zzk zzbyu;
        private zzl zzbyv;
        private zzekp<zzv> zzbyw = zzekh.zzbic();
        private int zzdt;

        /* renamed from: com.google.android.gms.internal.ads.zzue$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public enum C3992zza implements zzekj {
            AD_INITIATER_UNSPECIFIED(0),
            BANNER(1),
            DFP_BANNER(2),
            INTERSTITIAL(3),
            DFP_INTERSTITIAL(4),
            NATIVE_EXPRESS(5),
            AD_LOADER(6),
            REWARD_BASED_VIDEO_AD(7),
            BANNER_SEARCH_ADS(8),
            GOOGLE_MOBILE_ADS_SDK_ADAPTER(9),
            APP_OPEN(10);
            

            /* renamed from: a */
            private final int f17033a;

            private C3992zza(int i) {
                this.f17033a = i;
            }

            public static C3992zza zzbw(int i) {
                switch (i) {
                    case 0:
                        return AD_INITIATER_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return DFP_BANNER;
                    case 3:
                        return INTERSTITIAL;
                    case 4:
                        return DFP_INTERSTITIAL;
                    case 5:
                        return NATIVE_EXPRESS;
                    case 6:
                        return AD_LOADER;
                    case 7:
                        return REWARD_BASED_VIDEO_AD;
                    case 8:
                        return BANNER_SEARCH_ADS;
                    case 9:
                        return GOOGLE_MOBILE_ADS_SDK_ADAPTER;
                    case 10:
                        return APP_OPEN;
                    default:
                        return null;
                }
            }

            public static zzekl zzw() {
                return li0.f9870a;
            }

            public final String toString() {
                return "<" + C3992zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17033a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f17033a;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzb extends zzekh.zza<zza, zzb> implements zzelu {
            private zzb() {
                super(zza.zzbyx);
            }

            public final zzb zza(zze.zza zza) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).m9122l((zze) ((zzekh) zza.zzbhv()));
                return this;
            }

            public final zzb zzb(C3992zza zza) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).m9119i(zza);
                return this;
            }

            /* synthetic */ zzb(ki0 ki0) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zzbyx = zza;
            zzekh.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public final void m9119i(C3992zza zza) {
            this.zzbym = zza.zzv();
            this.zzdt |= 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public final void m9122l(zze zze) {
            zze.getClass();
            this.zzbyp = zze;
            this.zzdt |= 8;
        }

        public static zza zzni() {
            return zzbyx;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzbyx, "\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007ဌ\u0000\bဌ\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zzdt", "zzbym", C3992zza.zzw(), "zzbyn", zzuo.zzw(), "zzbyo", "zzbyp", "zzbyq", zzc.class, "zzbyr", "zzbys", "zzbyt", "zzbyu", "zzbyv", "zzbyw", zzv.class});
                case 4:
                    return zzbyx;
                case 5:
                    zzemb<zza> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zza.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzbyx);
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

        public final zze zznh() {
            zze zze = this.zzbyp;
            return zze == null ? zze.zznu() : zze;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzaa extends zzekh<zzaa, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzaa zzcgh;
        private static volatile zzemb<zzaa> zzei;
        private int zzcci = 1000;
        private zzx zzcft;
        private zzt zzcfu;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzaa, zza> implements zzelu {
            private zza() {
                super(zzaa.zzcgh);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzaa zzaa = new zzaa();
            zzcgh = zzaa;
            zzekh.zza(zzaa.class, zzaa);
        }

        private zzaa() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzaa();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcgh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzdt", "zzcci", zzuo.zzw(), "zzcft", "zzcfu"});
                case 4:
                    return zzcgh;
                case 5:
                    zzemb<zzaa> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzaa.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcgh);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzab extends zzekh<zzab, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzab zzcgj;
        private static volatile zzemb<zzab> zzei;
        private int zzcci = 1000;
        private int zzcfj;
        private int zzcfk;
        private zzx zzcft;
        private int zzcgf;
        private long zzcgi;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzab, zza> implements zzelu {
            private zza() {
                super(zzab.zzcgj);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzab zzab = new zzab();
            zzcgj = zzab;
            zzekh.zza(zzab.class, zzab);
        }

        private zzab() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzab();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcgj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဃ\u0005", new Object[]{"zzdt", "zzcci", zzuo.zzw(), "zzcft", "zzcfj", "zzcfk", "zzcgf", "zzcgi"});
                case 4:
                    return zzcgj;
                case 5:
                    zzemb<zzab> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzab.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcgj);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzac extends zzekh<zzac, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzac zzcgk;
        private static volatile zzemb<zzac> zzei;
        private int zzcci = 1000;
        private zzx zzcft;
        private zzt zzcfu;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzac, zza> implements zzelu {
            private zza() {
                super(zzac.zzcgk);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzac zzac = new zzac();
            zzcgk = zzac;
            zzekh.zza(zzac.class, zzac);
        }

        private zzac() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzac();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcgk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzdt", "zzcci", zzuo.zzw(), "zzcft", "zzcfu"});
                case 4:
                    return zzcgk;
                case 5:
                    zzemb<zzac> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzac.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcgk);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzad extends zzekh<zzad, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzad zzcgl;
        private static volatile zzemb<zzad> zzei;
        private int zzcci = 1000;
        private zzx zzcft;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzad, zza> implements zzelu {
            private zza() {
                super(zzad.zzcgl);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzad zzad = new zzad();
            zzcgl = zzad;
            zzekh.zza(zzad.class, zzad);
        }

        private zzad() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzad();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcgl, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzdt", "zzcci", zzuo.zzw(), "zzcft"});
                case 4:
                    return zzcgl;
                case 5:
                    zzemb<zzad> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzad.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcgl);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzae extends zzekh<zzae, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzae zzcgo;
        private static volatile zzemb<zzae> zzei;
        private boolean zzcgm;
        private int zzcgn;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzae, zza> implements zzelu {
            private zza() {
                super(zzae.zzcgo);
            }

            public final zza zzcu(int i) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzae) this.zzinm).m9130k(i);
                return this;
            }

            public final boolean zzpi() {
                return ((zzae) this.zzinm).zzpi();
            }

            public final zza zzw(boolean z) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzae) this.zzinm).m9132m(z);
                return this;
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzae zzae = new zzae();
            zzcgo = zzae;
            zzekh.zza(zzae.class, zzae);
        }

        private zzae() {
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public final void m9130k(int i) {
            this.zzdt |= 2;
            this.zzcgn = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: m */
        public final void m9132m(boolean z) {
            this.zzdt |= 1;
            this.zzcgm = z;
        }

        public static zza zzpj() {
            return (zza) zzcgo.zzbhx();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzae();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcgo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzdt", "zzcgm", "zzcgn"});
                case 4:
                    return zzcgo;
                case 5:
                    zzemb<zzae> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzae.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcgo);
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

        public final boolean zzpi() {
            return this.zzcgm;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzb extends zzekh<zzb, zzc> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzb zzbyz;
        private static volatile zzemb<zzb> zzei;
        private zzekp<zza> zzbyy = zzekh.zzbic();

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh<zza, C3993zza> implements zzelu {
            /* access modifiers changed from: private */
            public static final zza zzbzd;
            private static volatile zzemb<zza> zzei;
            private int zzbza;
            private zzd zzbzb;
            private zze zzbzc;
            private int zzdt;

            /* renamed from: com.google.android.gms.internal.ads.zzue$zzb$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class C3993zza extends zzekh.zza<zza, C3993zza> implements zzelu {
                private C3993zza() {
                    super(zza.zzbzd);
                }

                public final C3993zza zza(C3994zzb zzb) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9141n(zzb);
                    return this;
                }

                /* synthetic */ C3993zza(ki0 ki0) {
                    this();
                }

                public final C3993zza zza(zzd.zza zza) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9139l((zzd) ((zzekh) zza.zzbhv()));
                    return this;
                }

                public final C3993zza zza(zze.zza zza) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9140m((zze) ((zzekh) zza.zzbhv()));
                    return this;
                }
            }

            static {
                zza zza = new zza();
                zzbzd = zza;
                zzekh.zza(zza.class, zza);
            }

            private zza() {
            }

            /* access modifiers changed from: private */
            /* renamed from: l */
            public final void m9139l(zzd zzd) {
                zzd.getClass();
                this.zzbzb = zzd;
                this.zzdt |= 2;
            }

            /* access modifiers changed from: private */
            /* renamed from: m */
            public final void m9140m(zze zze) {
                zze.getClass();
                this.zzbzc = zze;
                this.zzdt |= 4;
            }

            /* access modifiers changed from: private */
            /* renamed from: n */
            public final void m9141n(C3994zzb zzb) {
                this.zzbza = zzb.zzv();
                this.zzdt |= 1;
            }

            public static C3993zza zznm() {
                return (C3993zza) zzbzd.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (ki0.f9758a[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C3993zza((ki0) null);
                    case 3:
                        return zzekh.zza((zzels) zzbzd, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzdt", "zzbza", C3994zzb.zzw(), "zzbzb", "zzbzc"});
                    case 4:
                        return zzbzd;
                    case 5:
                        zzemb<zza> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zza.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzbzd);
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

        /* renamed from: com.google.android.gms.internal.ads.zzue$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public enum C3994zzb implements zzekj {
            UNSPECIFIED(0),
            IN_MEMORY(1);
            

            /* renamed from: a */
            private final int f17036a;

            private C3994zzb(int i) {
                this.f17036a = i;
            }

            public static C3994zzb zzbx(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i != 1) {
                    return null;
                }
                return IN_MEMORY;
            }

            public static zzekl zzw() {
                return mi0.f9988a;
            }

            public final String toString() {
                return "<" + C3994zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17036a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f17036a;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzc extends zzekh.zza<zzb, zzc> implements zzelu {
            private zzc() {
                super(zzb.zzbyz);
            }

            public final zzc zza(zza.C3993zza zza) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m9133i((zza) ((zzekh) zza.zzbhv()));
                return this;
            }

            /* synthetic */ zzc(ki0 ki0) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzd extends zzekh<zzd, zza> implements zzelu {
            /* access modifiers changed from: private */
            public static final zzd zzbzj;
            private static volatile zzemb<zzd> zzei;
            private boolean zzbzh;
            private int zzbzi;
            private int zzdt;

            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class zza extends zzekh.zza<zzd, zza> implements zzelu {
                private zza() {
                    super(zzd.zzbzj);
                }

                public final zza zzby(int i) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzd) this.zzinm).m9145k(i);
                    return this;
                }

                public final zza zzq(boolean z) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzd) this.zzinm).m9147m(z);
                    return this;
                }

                /* synthetic */ zza(ki0 ki0) {
                    this();
                }
            }

            static {
                zzd zzd = new zzd();
                zzbzj = zzd;
                zzekh.zza(zzd.class, zzd);
            }

            private zzd() {
            }

            /* access modifiers changed from: private */
            /* renamed from: k */
            public final void m9145k(int i) {
                this.zzdt |= 2;
                this.zzbzi = i;
            }

            /* access modifiers changed from: private */
            /* renamed from: m */
            public final void m9147m(boolean z) {
                this.zzdt |= 1;
                this.zzbzh = z;
            }

            public static zza zzno() {
                return (zza) zzbzj.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (ki0.f9758a[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza((ki0) null);
                    case 3:
                        return zzekh.zza((zzels) zzbzj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zzdt", "zzbzh", "zzbzi"});
                    case 4:
                        return zzbzj;
                    case 5:
                        zzemb<zzd> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzd.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzbzj);
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

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zze extends zzekh<zze, zza> implements zzelu {
            /* access modifiers changed from: private */
            public static final zze zzbzm;
            private static volatile zzemb<zze> zzei;
            private int zzbzi;
            private boolean zzbzk;
            private boolean zzbzl;
            private int zzdt;

            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class zza extends zzekh.zza<zze, zza> implements zzelu {
                private zza() {
                    super(zze.zzbzm);
                }

                public final zza zzca(int i) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zze) this.zzinm).m9151l(i);
                    return this;
                }

                public final zza zzs(boolean z) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zze) this.zzinm).m9153n(z);
                    return this;
                }

                public final zza zzt(boolean z) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zze) this.zzinm).m9154o(z);
                    return this;
                }

                /* synthetic */ zza(ki0 ki0) {
                    this();
                }
            }

            static {
                zze zze = new zze();
                zzbzm = zze;
                zzekh.zza(zze.class, zze);
            }

            private zze() {
            }

            /* access modifiers changed from: private */
            /* renamed from: l */
            public final void m9151l(int i) {
                this.zzdt |= 4;
                this.zzbzi = i;
            }

            /* access modifiers changed from: private */
            /* renamed from: n */
            public final void m9153n(boolean z) {
                this.zzdt |= 1;
                this.zzbzk = z;
            }

            /* access modifiers changed from: private */
            /* renamed from: o */
            public final void m9154o(boolean z) {
                this.zzdt |= 2;
                this.zzbzl = z;
            }

            public static zza zznq() {
                return (zza) zzbzm.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (ki0.f9758a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza((ki0) null);
                    case 3:
                        return zzekh.zza((zzels) zzbzm, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzdt", "zzbzk", "zzbzl", "zzbzi"});
                    case 4:
                        return zzbzm;
                    case 5:
                        zzemb<zze> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zze.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzbzm);
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
            zzb zzb = new zzb();
            zzbyz = zzb;
            zzekh.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public final void m9133i(zza zza2) {
            zza2.getClass();
            zzekp<zza> zzekp = this.zzbyy;
            if (!zzekp.zzbfk()) {
                this.zzbyy = zzekh.zza(zzekp);
            }
            this.zzbyy.add(zza2);
        }

        public static zzc zznk() {
            return (zzc) zzbyz.zzbhx();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zzc((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzbyz, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbyy", zza.class});
                case 4:
                    return zzbyz;
                case 5:
                    zzemb<zzb> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzb.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzbyz);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzc extends zzekh<zzc, zzb> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzc zzcab;
        private static volatile zzemb<zzc> zzei;
        private int zzbzz;
        private zzr zzcaa;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public enum zza implements zzekj {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);
            

            /* renamed from: a */
            private final int f17044a;

            private zza(int i) {
                this.f17044a = i;
            }

            public static zza zzcb(int i) {
                switch (i) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
            }

            public static zzekl zzw() {
                return ni0.f10205a;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17044a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f17044a;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzb extends zzekh.zza<zzc, zzb> implements zzelu {
            private zzb() {
                super(zzc.zzcab);
            }

            /* synthetic */ zzb(ki0 ki0) {
                this();
            }
        }

        static {
            zzc zzc = new zzc();
            zzcab = zzc;
            zzekh.zza(zzc.class, zzc);
        }

        private zzc() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zzb((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcab, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzdt", "zzbzz", zza.zzw(), "zzcaa"});
                case 4:
                    return zzcab;
                case 5:
                    zzemb<zzc> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzc.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcab);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzd extends zzekh<zzd, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzd zzcaf;
        private static volatile zzemb<zzd> zzei;
        private String zzcac = "";
        private zzekp<zzc> zzcad = zzekh.zzbic();
        private int zzcae;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzd, zza> implements zzelu {
            private zza() {
                super(zzd.zzcaf);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzd zzd = new zzd();
            zzcaf = zzd;
            zzekh.zza(zzd.class, zzd);
        }

        private zzd() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcaf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဌ\u0001", new Object[]{"zzdt", "zzcac", "zzcad", zzc.class, "zzcae", zzuo.zzw()});
                case 4:
                    return zzcaf;
                case 5:
                    zzemb<zzd> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzd.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcaf);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zze extends zzekh<zze, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zze zzcal;
        private static volatile zzemb<zze> zzei;
        private String zzcag = "";
        private zzekp<zzc> zzcah = zzekh.zzbic();
        private int zzcai = 1000;
        private int zzcaj = 1000;
        private int zzcak = 1000;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zze, zza> implements zzelu {
            private zza() {
                super(zze.zzcal);
            }

            public final zza zzbu(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zze) this.zzinm).m9158j(str);
                return this;
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zze zze = new zze();
            zzcal = zze;
            zzekh.zza(zze.class, zze);
        }

        private zze() {
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public final void m9158j(String str) {
            str.getClass();
            this.zzdt |= 1;
            this.zzcag = str;
        }

        public static zze zznu() {
            return zzcal;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcal, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဌ\u0001\u0004ဌ\u0002\u0005ဌ\u0003", new Object[]{"zzdt", "zzcag", "zzcah", zzc.class, "zzcai", zzuo.zzw(), "zzcaj", zzuo.zzw(), "zzcak", zzuo.zzw()});
                case 4:
                    return zzcal;
                case 5:
                    zzemb<zze> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zze.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcal);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzf extends zzekh<zzf, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzf zzcas;
        private static volatile zzemb<zzf> zzei;
        private int zzcam;
        private zzt zzcan;
        private zzt zzcao;
        private zzt zzcap;
        private zzekp<zzt> zzcaq = zzekh.zzbic();
        private int zzcar;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzf, zza> implements zzelu {
            private zza() {
                super(zzf.zzcas);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzf zzf = new zzf();
            zzcas = zzf;
            zzekh.zza(zzf.class, zzf);
        }

        private zzf() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcas, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006င\u0004", new Object[]{"zzdt", "zzcam", "zzcan", "zzcao", "zzcap", "zzcaq", zzt.class, "zzcar"});
                case 4:
                    return zzcas;
                case 5:
                    zzemb<zzf> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzf.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcas);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzg extends zzekh<zzg, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzg zzcbb;
        private static volatile zzemb<zzg> zzei;
        private String zzcat = "";
        private zzt zzcau;
        private int zzcav;
        private zzu zzcaw;
        private int zzcax;
        private int zzcay = 1000;
        private int zzcaz = 1000;
        private int zzcba = 1000;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzg, zza> implements zzelu {
            private zza() {
                super(zzg.zzcbb);
            }

            public final zza zzb(zzu zzu) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzg) this.zzinm).m9163k(zzu);
                return this;
            }

            public final zza zzbw(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzg) this.zzinm).m9164l(str);
                return this;
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzg zzg = new zzg();
            zzcbb = zzg;
            zzekh.zza(zzg.class, zzg);
        }

        private zzg() {
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public final void m9163k(zzu zzu) {
            zzu.getClass();
            this.zzcaw = zzu;
            this.zzdt |= 8;
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public final void m9164l(String str) {
            str.getClass();
            this.zzdt |= 1;
            this.zzcat = str;
        }

        public static zzg zznx() {
            return zzcbb;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcbb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006ဌ\u0005\u0007ဌ\u0006\bဌ\u0007", new Object[]{"zzdt", "zzcat", "zzcau", "zzcav", "zzcaw", "zzcax", "zzcay", zzuo.zzw(), "zzcaz", zzuo.zzw(), "zzcba", zzuo.zzw()});
                case 4:
                    return zzcbb;
                case 5:
                    zzemb<zzg> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzg.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcbb);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzh extends zzekh<zzh, zzb> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzh zzcbg;
        private static volatile zzemb<zzh> zzei;
        private int zzcbc;
        private zzu zzcbd;
        private String zzcbe = "";
        private String zzcbf = "";
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public enum zza implements zzekj {
            PLATFORM_UNSPECIFIED(0),
            IOS(1),
            ANDROID(2);
            

            /* renamed from: a */
            private final int f17049a;

            private zza(int i) {
                this.f17049a = i;
            }

            public static zza zzcc(int i) {
                if (i == 0) {
                    return PLATFORM_UNSPECIFIED;
                }
                if (i == 1) {
                    return IOS;
                }
                if (i != 2) {
                    return null;
                }
                return ANDROID;
            }

            public static zzekl zzw() {
                return oi0.f10384a;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17049a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f17049a;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzb extends zzekh.zza<zzh, zzb> implements zzelu {
            private zzb() {
                super(zzh.zzcbg);
            }

            /* synthetic */ zzb(ki0 ki0) {
                this();
            }
        }

        static {
            zzh zzh = new zzh();
            zzcbg = zzh;
            zzekh.zza(zzh.class, zzh);
        }

        private zzh() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcbg, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005ဌ\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zzdt", "zzcbc", zza.zzw(), "zzcbd", "zzcbe", "zzcbf"});
                case 4:
                    return zzcbg;
                case 5:
                    zzemb<zzh> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzh.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcbg);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzi extends zzekh<zzi, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzi zzccc;
        private static volatile zzemb<zzi> zzei;
        private int zzcbp;
        private String zzcbq = "";
        private int zzcbr;
        private int zzcbs = 1000;
        private zzu zzcbt;
        private zzekq zzcbu = zzekh.zzbib();
        private zzg zzcbv;
        private zzh zzcbw;
        private zzm zzcbx;
        private zza zzcby;
        private zzo zzcbz;
        private zzae zzcca;
        private zzb zzccb;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzi, zza> implements zzelu {
            private zza() {
                super(zzi.zzccc);
            }

            public final zza zza(zzg.zza zza) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzi) this.zzinm).m9170l((zzg) ((zzekh) zza.zzbhv()));
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzi) this.zzinm).m9180v(iterable);
                return this;
            }

            public final zza zzby(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzi) this.zzinm).m9181w(str);
                return this;
            }

            public final String zzoa() {
                return ((zzi) this.zzinm).zzoa();
            }

            public final zzg zzoc() {
                return ((zzi) this.zzinm).zzoc();
            }

            public final zza zzod() {
                return ((zzi) this.zzinm).zzod();
            }

            public final zza zzoh() {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzi) this.zzinm).m9182x();
                return this;
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }

            public final zza zza(zza.zzb zzb) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzi) this.zzinm).m9167i((zza) ((zzekh) zzb.zzbhv()));
                return this;
            }

            public final zza zzb(zzo zzo) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzi) this.zzinm).m9179u(zzo);
                return this;
            }

            public final zza zzb(zzae zzae) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzi) this.zzinm).m9168j(zzae);
                return this;
            }

            public final zza zzb(zzb zzb) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzi) this.zzinm).m9169k(zzb);
                return this;
            }
        }

        static {
            zzi zzi = new zzi();
            zzccc = zzi;
            zzekh.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public final void m9167i(zza zza2) {
            zza2.getClass();
            this.zzcby = zza2;
            this.zzdt |= 256;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public final void m9168j(zzae zzae) {
            zzae.getClass();
            this.zzcca = zzae;
            this.zzdt |= 1024;
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public final void m9169k(zzb zzb) {
            zzb.getClass();
            this.zzccb = zzb;
            this.zzdt |= 2048;
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public final void m9170l(zzg zzg) {
            zzg.getClass();
            this.zzcbv = zzg;
            this.zzdt |= 32;
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public final void m9179u(zzo zzo) {
            zzo.getClass();
            this.zzcbz = zzo;
            this.zzdt |= 512;
        }

        /* access modifiers changed from: private */
        /* renamed from: v */
        public final void m9180v(Iterable<? extends Long> iterable) {
            zzekq zzekq = this.zzcbu;
            if (!zzekq.zzbfk()) {
                int size = zzekq.size();
                this.zzcbu = zzekq.zzhh(size == 0 ? 10 : size << 1);
            }
            zzeik.zza(iterable, this.zzcbu);
        }

        /* access modifiers changed from: private */
        /* renamed from: w */
        public final void m9181w(String str) {
            str.getClass();
            this.zzdt |= 2;
            this.zzcbq = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: x */
        public final void m9182x() {
            this.zzcbu = zzekh.zzbib();
        }

        public static zza zzoe() {
            return (zza) zzccc.zzbhx();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzccc, "\u0001\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\fဌ\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zzdt", "zzcbp", "zzcbq", "zzcbr", "zzcbs", zzuo.zzw(), "zzcbt", "zzcbu", "zzcbv", "zzcbw", "zzcbx", "zzcby", "zzcbz", "zzcca", "zzccb"});
                case 4:
                    return zzccc;
                case 5:
                    zzemb<zzi> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzi.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzccc);
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

        public final String zzoa() {
            return this.zzcbq;
        }

        public final zzg zzoc() {
            zzg zzg = this.zzcbv;
            return zzg == null ? zzg.zznx() : zzg;
        }

        public final zza zzod() {
            zza zza2 = this.zzcby;
            return zza2 == null ? zza.zzni() : zza2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzj extends zzekh<zzj, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzj zzcch;
        private static volatile zzemb<zzj> zzei;
        private String zzccd = "";
        private int zzcce;
        private zzeko zzccf = zzekh.zzbia();
        private zzt zzccg;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzj, zza> implements zzelu {
            private zza() {
                super(zzj.zzcch);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzj zzj = new zzj();
            zzcch = zzj;
            zzekh.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcch, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zzdt", "zzccd", "zzcce", zzuo.zzw(), "zzccf", "zzccg"});
                case 4:
                    return zzcch;
                case 5:
                    zzemb<zzj> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzj.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcch);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzk extends zzekh<zzk, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzk zzccj;
        private static volatile zzemb<zzk> zzei;
        private zzeko zzccf = zzekh.zzbia();
        private int zzcci;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzk, zza> implements zzelu {
            private zza() {
                super(zzk.zzccj);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzk zzk = new zzk();
            zzccj = zzk;
            zzekh.zza(zzk.class, zzk);
        }

        private zzk() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzccj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016", new Object[]{"zzdt", "zzcci", zzuo.zzw(), "zzccf"});
                case 4:
                    return zzccj;
                case 5:
                    zzemb<zzk> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzk.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzccj);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzl extends zzekh<zzl, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzl zzccm;
        private static volatile zzemb<zzl> zzei;
        private zzt zzccg;
        private int zzcci;
        private zzj zzcck;
        private zzekp<zzs> zzccl = zzekh.zzbic();
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzl, zza> implements zzelu {
            private zza() {
                super(zzl.zzccm);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzl zzl = new zzl();
            zzccm = zzl;
            zzekh.zza(zzl.class, zzl);
        }

        private zzl() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzccm, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004ဉ\u0002", new Object[]{"zzdt", "zzcck", "zzccl", zzs.class, "zzcci", zzuo.zzw(), "zzccg"});
                case 4:
                    return zzccm;
                case 5:
                    zzemb<zzl> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzl.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzccm);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzm extends zzekh<zzm, zzb> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzm zzcco;
        private static volatile zzemb<zzm> zzei;
        private int zzbzz;
        private int zzccn;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public enum zza implements zzekj {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);
            

            /* renamed from: a */
            private final int f17051a;

            private zza(int i) {
                this.f17051a = i;
            }

            public static zza zzce(int i) {
                if (i == 0) {
                    return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return TWO_G;
                }
                if (i == 2) {
                    return THREE_G;
                }
                if (i != 4) {
                    return null;
                }
                return LTE;
            }

            public static zzekl zzw() {
                return qi0.f10723a;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17051a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f17051a;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzb extends zzekh.zza<zzm, zzb> implements zzelu {
            private zzb() {
                super(zzm.zzcco);
            }

            public final zzb zzb(zzc zzc) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzm) this.zzinm).m9188j(zzc);
                return this;
            }

            /* synthetic */ zzb(ki0 ki0) {
                this();
            }

            public final zzb zzb(zza zza) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzm) this.zzinm).m9187i(zza);
                return this;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public enum zzc implements zzekj {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);
            

            /* renamed from: a */
            private final int f17053a;

            private zzc(int i) {
                this.f17053a = i;
            }

            public static zzc zzcf(int i) {
                if (i == 0) {
                    return NETWORKTYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return CELL;
                }
                if (i != 2) {
                    return null;
                }
                return WIFI;
            }

            public static zzekl zzw() {
                return ri0.f10807a;
            }

            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17053a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f17053a;
            }
        }

        static {
            zzm zzm = new zzm();
            zzcco = zzm;
            zzekh.zza(zzm.class, zzm);
        }

        private zzm() {
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public final void m9187i(zza zza2) {
            this.zzccn = zza2.zzv();
            this.zzdt |= 2;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public final void m9188j(zzc zzc2) {
            this.zzbzz = zzc2.zzv();
            this.zzdt |= 1;
        }

        public static zzb zzok() {
            return (zzb) zzcco.zzbhx();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zzb((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcco, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzdt", "zzbzz", zzc.zzw(), "zzccn", zza.zzw()});
                case 4:
                    return zzcco;
                case 5:
                    zzemb<zzm> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzm.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcco);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzn extends zzekh<zzn, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzn zzcda;
        private static volatile zzemb<zzn> zzei;
        private int zzccy;
        private zzt zzccz;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzn, zza> implements zzelu {
            private zza() {
                super(zzn.zzcda);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzn zzn = new zzn();
            zzcda = zzn;
            zzekh.zza(zzn.class, zzn);
        }

        private zzn() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcda, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzdt", "zzccy", zzuo.zzw(), "zzccz"});
                case 4:
                    return zzcda;
                case 5:
                    zzemb<zzn> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzn.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcda);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzo extends zzekh<zzo, zzb> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzo zzcdg;
        private static volatile zzemb<zzo> zzei;
        private zzekp<zza> zzbyy = zzekh.zzbic();
        private int zzcdb;
        private int zzcdc;
        private long zzcdd;
        private String zzcde = "";
        private long zzcdf;
        private int zzdt;
        private String zzdu = "";

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh<zza, C3995zza> implements zzelu {
            private static final zzekn<Integer, zzc.zza> zzcdm = new si0();
            /* access modifiers changed from: private */
            public static final zza zzcdu;
            private static volatile zzemb<zza> zzei;
            private long zzcdh;
            private int zzcdi;
            private long zzcdj;
            private long zzcdk;
            private zzeko zzcdl = zzekh.zzbia();
            private zzm zzcdn;
            private int zzcdo;
            private int zzcdp;
            private int zzcdq;
            private int zzcdr;
            private int zzcds;
            private int zzcdt;
            private int zzdt;

            /* renamed from: com.google.android.gms.internal.ads.zzue$zzo$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class C3995zza extends zzekh.zza<zza, C3995zza> implements zzelu {
                private C3995zza() {
                    super(zza.zzcdu);
                }

                public final C3995zza zzb(zzm zzm) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9216j(zzm);
                    return this;
                }

                public final C3995zza zzcl(int i) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9231y(i);
                    return this;
                }

                public final C3995zza zzeu(long j) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9215i(j);
                    return this;
                }

                public final C3995zza zzev(long j) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9212E(j);
                    return this;
                }

                public final C3995zza zzew(long j) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9213F(j);
                    return this;
                }

                public final C3995zza zzf(zzuo zzuo) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9224r(zzuo);
                    return this;
                }

                public final C3995zza zzg(zzuo zzuo) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9227u(zzuo);
                    return this;
                }

                public final C3995zza zzh(zzuo zzuo) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9230x(zzuo);
                    return this;
                }

                public final C3995zza zzi(zzuo zzuo) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9208A(zzuo);
                    return this;
                }

                public final C3995zza zzj(zzuo zzuo) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9211D(zzuo);
                    return this;
                }

                /* synthetic */ C3995zza(ki0 ki0) {
                    this();
                }

                public final C3995zza zzb(zzc zzc) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9223q(zzc);
                    return this;
                }

                public final C3995zza zzf(Iterable<? extends zzc.zza> iterable) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m9209B(iterable);
                    return this;
                }
            }

            static {
                zza zza = new zza();
                zzcdu = zza;
                zzekh.zza(zza.class, zza);
            }

            private zza() {
            }

            /* access modifiers changed from: private */
            /* renamed from: A */
            public final void m9208A(zzuo zzuo) {
                this.zzcdq = zzuo.zzv();
                this.zzdt |= 128;
            }

            /* access modifiers changed from: private */
            /* renamed from: B */
            public final void m9209B(Iterable<? extends zzc.zza> iterable) {
                zzeko zzeko = this.zzcdl;
                if (!zzeko.zzbfk()) {
                    this.zzcdl = zzekh.zza(zzeko);
                }
                for (zzc.zza zzv : iterable) {
                    this.zzcdl.zzhg(zzv.zzv());
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: D */
            public final void m9211D(zzuo zzuo) {
                this.zzcds = zzuo.zzv();
                this.zzdt |= 512;
            }

            /* access modifiers changed from: private */
            /* renamed from: E */
            public final void m9212E(long j) {
                this.zzdt |= 4;
                this.zzcdj = j;
            }

            /* access modifiers changed from: private */
            /* renamed from: F */
            public final void m9213F(long j) {
                this.zzdt |= 8;
                this.zzcdk = j;
            }

            /* access modifiers changed from: private */
            /* renamed from: i */
            public final void m9215i(long j) {
                this.zzdt |= 1;
                this.zzcdh = j;
            }

            /* access modifiers changed from: private */
            /* renamed from: j */
            public final void m9216j(zzm zzm) {
                zzm.getClass();
                this.zzcdn = zzm;
                this.zzdt |= 16;
            }

            /* access modifiers changed from: private */
            /* renamed from: q */
            public final void m9223q(zzc zzc) {
                this.zzcdt = zzc.zzv();
                this.zzdt |= 1024;
            }

            /* access modifiers changed from: private */
            /* renamed from: r */
            public final void m9224r(zzuo zzuo) {
                this.zzcdi = zzuo.zzv();
                this.zzdt |= 2;
            }

            /* access modifiers changed from: private */
            /* renamed from: u */
            public final void m9227u(zzuo zzuo) {
                this.zzcdo = zzuo.zzv();
                this.zzdt |= 32;
            }

            /* access modifiers changed from: private */
            /* renamed from: x */
            public final void m9230x(zzuo zzuo) {
                this.zzcdp = zzuo.zzv();
                this.zzdt |= 64;
            }

            /* access modifiers changed from: private */
            /* renamed from: y */
            public final void m9231y(int i) {
                this.zzdt |= 256;
                this.zzcdr = i;
            }

            public static zza zzg(byte[] bArr) {
                return (zza) zzekh.zza(zzcdu, bArr);
            }

            public static C3995zza zzoq() {
                return (C3995zza) zzcdu.zzbhx();
            }

            public final long getTimestamp() {
                return this.zzcdh;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (ki0.f9758a[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C3995zza((ki0) null);
                    case 3:
                        return zzekh.zza((zzels) zzcdu, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005\u001e\u0006ဉ\u0004\u0007ဌ\u0005\bဌ\u0006\tဌ\u0007\nင\b\u000bဌ\t\fဌ\n", new Object[]{"zzdt", "zzcdh", "zzcdi", zzuo.zzw(), "zzcdj", "zzcdk", "zzcdl", zzc.zza.zzw(), "zzcdn", "zzcdo", zzuo.zzw(), "zzcdp", zzuo.zzw(), "zzcdq", zzuo.zzw(), "zzcdr", "zzcds", zzuo.zzw(), "zzcdt", zzc.zzw()});
                    case 4:
                        return zzcdu;
                    case 5:
                        zzemb<zza> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zza.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzcdu);
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

            public final zzuo zzop() {
                zzuo zzcd = zzuo.zzcd(this.zzcdi);
                return zzcd == null ? zzuo.ENUM_FALSE : zzcd;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzb extends zzekh.zza<zzo, zzb> implements zzelu {
            private zzb() {
                super(zzo.zzcdg);
            }

            public final zzb zzca(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzo) this.zzinm).m9206v(str);
                return this;
            }

            public final zzb zzcb(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzo) this.zzinm).m9200p(str);
                return this;
            }

            public final zzb zzcj(int i) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzo) this.zzinm).m9202r(i);
                return this;
            }

            public final zzb zzck(int i) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzo) this.zzinm).m9203s(i);
                return this;
            }

            public final zzb zze(Iterable<? extends zza> iterable) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzo) this.zzinm).m9201q(iterable);
                return this;
            }

            public final zzb zzes(long j) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzo) this.zzinm).m9204t(j);
                return this;
            }

            public final zzb zzet(long j) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzo) this.zzinm).m9205u(j);
                return this;
            }

            /* synthetic */ zzb(ki0 ki0) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public enum zzc implements zzekj {
            UNSPECIFIED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            DISCONNECTED(4),
            SUSPENDED(5);
            

            /* renamed from: a */
            private final int f17055a;

            private zzc(int i) {
                this.f17055a = i;
            }

            public static zzc zzcm(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i == 1) {
                    return CONNECTING;
                }
                if (i == 2) {
                    return CONNECTED;
                }
                if (i == 3) {
                    return DISCONNECTING;
                }
                if (i == 4) {
                    return DISCONNECTED;
                }
                if (i != 5) {
                    return null;
                }
                return SUSPENDED;
            }

            public static zzekl zzw() {
                return ti0.f11219a;
            }

            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17055a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f17055a;
            }
        }

        static {
            zzo zzo = new zzo();
            zzcdg = zzo;
            zzekh.zza(zzo.class, zzo);
        }

        private zzo() {
        }

        /* access modifiers changed from: private */
        /* renamed from: p */
        public final void m9200p(String str) {
            str.getClass();
            this.zzdt |= 16;
            this.zzcde = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: q */
        public final void m9201q(Iterable<? extends zza> iterable) {
            zzekp<zza> zzekp = this.zzbyy;
            if (!zzekp.zzbfk()) {
                this.zzbyy = zzekh.zza(zzekp);
            }
            zzeik.zza(iterable, this.zzbyy);
        }

        /* access modifiers changed from: private */
        /* renamed from: r */
        public final void m9202r(int i) {
            this.zzdt |= 1;
            this.zzcdb = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: s */
        public final void m9203s(int i) {
            this.zzdt |= 2;
            this.zzcdc = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: t */
        public final void m9204t(long j) {
            this.zzdt |= 4;
            this.zzcdd = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public final void m9205u(long j) {
            this.zzdt |= 32;
            this.zzcdf = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: v */
        public final void m9206v(String str) {
            str.getClass();
            this.zzdt |= 8;
            this.zzdu = str;
        }

        public static zzb zzon() {
            return (zzb) zzcdg.zzbhx();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zzb((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcdg, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005", new Object[]{"zzdt", "zzbyy", zza.class, "zzcdb", "zzcdc", "zzcdd", "zzdu", "zzcde", "zzcdf"});
                case 4:
                    return zzcdg;
                case 5:
                    zzemb<zzo> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzo.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcdg);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzp extends zzekh<zzp, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzp zzcen;
        private static volatile zzemb<zzp> zzei;
        private int zzcec = 1000;
        private int zzced = 1000;
        private int zzcee;
        private int zzcef;
        private int zzceg;
        private int zzceh;
        private int zzcei;
        private int zzcej;
        private int zzcek;
        private int zzcel;
        private zzq zzcem;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzp, zza> implements zzelu {
            private zza() {
                super(zzp.zzcen);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzp zzp = new zzp();
            zzcen = zzp;
            zzekh.zza(zzp.class, zzp);
        }

        private zzp() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcen, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bဉ\n", new Object[]{"zzdt", "zzcec", zzuo.zzw(), "zzced", zzuo.zzw(), "zzcee", "zzcef", "zzceg", "zzceh", "zzcei", "zzcej", "zzcek", "zzcel", "zzcem"});
                case 4:
                    return zzcen;
                case 5:
                    zzemb<zzp> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzp.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcen);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzq extends zzekh<zzq, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzq zzceq;
        private static volatile zzemb<zzq> zzei;
        private int zzceo;
        private int zzcep;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzq, zza> implements zzelu {
            private zza() {
                super(zzq.zzceq);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzq zzq = new zzq();
            zzceq = zzq;
            zzekh.zza(zzq.class, zzq);
        }

        private zzq() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzceq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzdt", "zzceo", "zzcep"});
                case 4:
                    return zzceq;
                case 5:
                    zzemb<zzq> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzq.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzceq);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzr extends zzekh<zzr, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzr zzcet;
        private static volatile zzemb<zzr> zzei;
        private int zzcer;
        private int zzces;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzr, zza> implements zzelu {
            private zza() {
                super(zzr.zzcet);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzr zzr = new zzr();
            zzcet = zzr;
            zzekh.zza(zzr.class, zzr);
        }

        private zzr() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcet, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzdt", "zzcer", "zzces"});
                case 4:
                    return zzcet;
                case 5:
                    zzemb<zzr> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzr.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcet);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzs extends zzekh<zzs, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzs zzceu;
        private static volatile zzemb<zzs> zzei;
        private String zzccd = "";
        private int zzcce;
        private zzt zzccg;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzs, zza> implements zzelu {
            private zza() {
                super(zzs.zzceu);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzs zzs = new zzs();
            zzceu = zzs;
            zzekh.zza(zzs.class, zzs);
        }

        private zzs() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzceu, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003ဉ\u0002", new Object[]{"zzdt", "zzccd", "zzcce", zzuo.zzw(), "zzccg"});
                case 4:
                    return zzceu;
                case 5:
                    zzemb<zzs> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzs.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzceu);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzt extends zzekh<zzt, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzt zzcex;
        private static volatile zzemb<zzt> zzei;
        private int zzcev;
        private int zzcew;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzt, zza> implements zzelu {
            private zza() {
                super(zzt.zzcex);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzt zzt = new zzt();
            zzcex = zzt;
            zzekh.zza(zzt.class, zzt);
        }

        private zzt() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcex, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzdt", "zzcev", "zzcew"});
                case 4:
                    return zzcex;
                case 5:
                    zzemb<zzt> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzt.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcex);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzu extends zzekh<zzu, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzu zzcfb;
        private static volatile zzemb<zzu> zzei;
        private int zzcey;
        private int zzcez;
        private int zzcfa;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzu, zza> implements zzelu {
            private zza() {
                super(zzu.zzcfb);
            }

            public final zza zzcq(int i) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzu) this.zzinm).m9241l(i);
                return this;
            }

            public final zza zzcr(int i) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzu) this.zzinm).m9242m(i);
                return this;
            }

            public final zza zzcs(int i) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzu) this.zzinm).m9243n(i);
                return this;
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzu zzu = new zzu();
            zzcfb = zzu;
            zzekh.zza(zzu.class, zzu);
        }

        private zzu() {
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public final void m9241l(int i) {
            this.zzdt |= 1;
            this.zzcey = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: m */
        public final void m9242m(int i) {
            this.zzdt |= 2;
            this.zzcez = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public final void m9243n(int i) {
            this.zzdt |= 4;
            this.zzcfa = i;
        }

        public static zza zzox() {
            return (zza) zzcfb.zzbhx();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcfb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzdt", "zzcey", "zzcez", "zzcfa"});
                case 4:
                    return zzcfb;
                case 5:
                    zzemb<zzu> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzu.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcfb);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzv extends zzekh<zzv, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzv zzcfs;
        private static volatile zzemb<zzv> zzei;
        private zzz zzcfc;
        private zzab zzcfd;
        private zzac zzcfe;
        private zzad zzcff;
        private zzw zzcfg;
        private zzaa zzcfh;
        private zzy zzcfi;
        private int zzcfj;
        private int zzcfk;
        private zzt zzcfl;
        private int zzcfm;
        private int zzcfn;
        private int zzcfo;
        private int zzcfp;
        private int zzcfq;
        private long zzcfr;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzv, zza> implements zzelu {
            private zza() {
                super(zzv.zzcfs);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzv zzv = new zzv();
            zzcfs = zzv;
            zzekh.zza(zzv.class, zzv);
        }

        private zzv() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcfs, "\u0001\u0010\u0000\u0001\u0005\u0014\u0010\u0000\u0000\u0000\u0005ဉ\u0000\u0006ဉ\u0001\u0007ဉ\u0002\bဉ\u0003\tဉ\u0004\nဉ\u0005\u000bဉ\u0006\fင\u0007\rင\b\u000eဉ\t\u000fင\n\u0010င\u000b\u0011င\f\u0012င\r\u0013င\u000e\u0014ဃ\u000f", new Object[]{"zzdt", "zzcfc", "zzcfd", "zzcfe", "zzcff", "zzcfg", "zzcfh", "zzcfi", "zzcfj", "zzcfk", "zzcfl", "zzcfm", "zzcfn", "zzcfo", "zzcfp", "zzcfq", "zzcfr"});
                case 4:
                    return zzcfs;
                case 5:
                    zzemb<zzv> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzv.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcfs);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzw extends zzekh<zzw, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzw zzcfv;
        private static volatile zzemb<zzw> zzei;
        private int zzcci = 1000;
        private zzx zzcft;
        private zzt zzcfu;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzw, zza> implements zzelu {
            private zza() {
                super(zzw.zzcfv);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzw zzw = new zzw();
            zzcfv = zzw;
            zzekh.zza(zzw.class, zzw);
        }

        private zzw() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcfv, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzdt", "zzcci", zzuo.zzw(), "zzcft", "zzcfu"});
                case 4:
                    return zzcfv;
                case 5:
                    zzemb<zzw> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzw.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcfv);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzx extends zzekh<zzx, zzb> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzx zzcfx;
        private static volatile zzemb<zzx> zzei;
        private int zzcfw;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public enum zza implements zzekj {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);
            

            /* renamed from: a */
            private final int f17061a;

            private zza(int i) {
                this.f17061a = i;
            }

            public static zza zzct(int i) {
                if (i == 0) {
                    return VIDEO_ERROR_CODE_UNSPECIFIED;
                }
                if (i == 1) {
                    return OPENGL_RENDERING_FAILED;
                }
                if (i == 2) {
                    return CACHE_LOAD_FAILED;
                }
                if (i != 3) {
                    return null;
                }
                return ANDROID_TARGET_API_TOO_LOW;
            }

            public static zzekl zzw() {
                return ui0.f11425a;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17061a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f17061a;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzb extends zzekh.zza<zzx, zzb> implements zzelu {
            private zzb() {
                super(zzx.zzcfx);
            }

            /* synthetic */ zzb(ki0 ki0) {
                this();
            }
        }

        static {
            zzx zzx = new zzx();
            zzcfx = zzx;
            zzekh.zza(zzx.class, zzx);
        }

        private zzx() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zzb((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcfx, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzdt", "zzcfw", zza.zzw()});
                case 4:
                    return zzcfx;
                case 5:
                    zzemb<zzx> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzx.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcfx);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzy extends zzekh<zzy, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzy zzcge;
        private static volatile zzemb<zzy> zzei;
        private int zzcci = 1000;
        private zzx zzcft;
        private zzt zzcfu;
        private zzu zzcgd;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzy, zza> implements zzelu {
            private zza() {
                super(zzy.zzcge);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzy zzy = new zzy();
            zzcge = zzy;
            zzekh.zza(zzy.class, zzy);
        }

        private zzy() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzy();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcge, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzdt", "zzcgd", "zzcci", zzuo.zzw(), "zzcft", "zzcfu"});
                case 4:
                    return zzcge;
                case 5:
                    zzemb<zzy> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzy.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcge);
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

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzz extends zzekh<zzz, zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zzz zzcgg;
        private static volatile zzemb<zzz> zzei;
        private int zzcci = 1000;
        private int zzcfj;
        private int zzcfk;
        private zzx zzcft;
        private int zzcgf;
        private int zzdt;

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh.zza<zzz, zza> implements zzelu {
            private zza() {
                super(zzz.zzcgg);
            }

            /* synthetic */ zza(ki0 ki0) {
                this();
            }
        }

        static {
            zzz zzz = new zzz();
            zzcgg = zzz;
            zzekh.zza(zzz.class, zzz);
        }

        private zzz() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (ki0.f9758a[i - 1]) {
                case 1:
                    return new zzz();
                case 2:
                    return new zza((ki0) null);
                case 3:
                    return zzekh.zza((zzels) zzcgg, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzdt", "zzcci", zzuo.zzw(), "zzcft", "zzcfj", "zzcfk", "zzcgf"});
                case 4:
                    return zzcgg;
                case 5:
                    zzemb<zzz> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzz.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzcgg);
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
}
