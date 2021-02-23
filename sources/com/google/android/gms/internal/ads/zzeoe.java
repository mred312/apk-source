package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeoe {

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh<zza, C3981zza> implements zzelu {
        private static volatile zzemb<zza> zzei;
        /* access modifiers changed from: private */
        public static final zza zziuq;
        private int zzdt;
        private int zziuj;
        private zzb zziuk;
        private zzeiu zziul;
        private zzeiu zzium;
        private boolean zziun;
        private boolean zziuo;
        private byte zziup = 2;

        /* renamed from: com.google.android.gms.internal.ads.zzeoe$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class C3981zza extends zzekh.zza<zza, C3981zza> implements zzelu {
            private C3981zza() {
                super(zza.zziuq);
            }

            /* synthetic */ C3981zza(ic0 ic0) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzb extends zzekh<zzb, C3982zza> implements zzelu {
            private static volatile zzemb<zzb> zzei;
            /* access modifiers changed from: private */
            public static final zzb zziuv;
            private int zzdt;
            private String zziur = "";
            private String zzius = "";
            private String zziut = "";
            private int zziuu;

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zza$zzb$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class C3982zza extends zzekh.zza<zzb, C3982zza> implements zzelu {
                private C3982zza() {
                    super(zzb.zziuv);
                }

                /* synthetic */ C3982zza(ic0 ic0) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zziuv = zzb;
                zzekh.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (ic0.f9312a[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C3982zza((ic0) null);
                    case 3:
                        return zzekh.zza((zzels) zziuv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zzdt", "zziur", "zzius", "zziut", "zziuu"});
                    case 4:
                        return zziuv;
                    case 5:
                        zzemb<zzb> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzb.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zziuv);
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
        public enum zzc implements zzekj {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            

            /* renamed from: a */
            private final int f16298a;

            private zzc(int i) {
                this.f16298a = i;
            }

            public static zzc zzhx(int i) {
                if (i == 0) {
                    return SAFE;
                }
                if (i == 1) {
                    return DANGEROUS;
                }
                if (i == 2) {
                    return UNKNOWN;
                }
                if (i == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            public static zzekl zzw() {
                return jc0.f9476a;
            }

            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f16298a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f16298a;
            }
        }

        static {
            zza zza = new zza();
            zziuq = zza;
            zzekh.zza(zza.class, zza);
        }

        private zza() {
            zzeiu zzeiu = zzeiu.zziiy;
            this.zziul = zzeiu;
            this.zzium = zzeiu;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (ic0.f9312a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3981zza((ic0) null);
                case 3:
                    return zzekh.zza((zzels) zziuq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001\u0003ည\u0002\u0004ည\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzdt", "zziuj", zzc.zzw(), "zziuk", "zziul", "zzium", "zziun", "zziuo"});
                case 4:
                    return zziuq;
                case 5:
                    zzemb<zza> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zza.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zziuq);
                                zzei = zzemb;
                            }
                        }
                    }
                    return zzemb;
                case 6:
                    return Byte.valueOf(this.zziup);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zziup = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zzb extends zzekh<zzb, C3984zzb> implements zzelu {
        private static volatile zzemb<zzb> zzei;
        /* access modifiers changed from: private */
        public static final zzb zzivr;
        private int zzbzz;
        private int zzdt;
        private zzeiu zziul = zzeiu.zziiy;
        private byte zziup = 2;
        private String zzius = "";
        private int zzivc;
        private String zzivd = "";
        private String zzive = "";
        private zza zzivf;
        private zzekp<zzh> zzivg = zzekh.zzbic();
        private String zzivh = "";
        private zzf zzivi;
        private boolean zzivj;
        private zzekp<String> zzivk = zzekh.zzbic();
        private String zzivl = "";
        private boolean zzivm;
        private boolean zzivn;
        private zzi zzivo;
        private zzekp<String> zzivp = zzekh.zzbic();
        private zzekp<String> zzivq = zzekh.zzbic();

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zza extends zzekh<zza, C3983zza> implements zzelu {
            private static volatile zzemb<zza> zzei;
            /* access modifiers changed from: private */
            public static final zza zzivt;
            private int zzdt;
            private String zzivs = "";

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class C3983zza extends zzekh.zza<zza, C3983zza> implements zzelu {
                private C3983zza() {
                    super(zza.zzivt);
                }

                public final C3983zza zzib(String str) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).m8877k(str);
                    return this;
                }

                /* synthetic */ C3983zza(ic0 ic0) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zzivt = zza;
                zzekh.zza(zza.class, zza);
            }

            private zza() {
            }

            /* access modifiers changed from: private */
            /* renamed from: k */
            public final void m8877k(String str) {
                str.getClass();
                this.zzdt |= 1;
                this.zzivs = str;
            }

            public static C3983zza zzbky() {
                return (C3983zza) zzivt.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (ic0.f9312a[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C3983zza((ic0) null);
                    case 3:
                        return zzekh.zza((zzels) zzivt, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdt", "zzivs"});
                    case 4:
                        return zzivt;
                    case 5:
                        zzemb<zza> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zza.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzivt);
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

        /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class C3984zzb extends zzekh.zza<zzb, C3984zzb> implements zzelu {
            private C3984zzb() {
                super(zzb.zzivr);
            }

            public final String getUrl() {
                return ((zzb) this.zzinm).getUrl();
            }

            public final C3984zzb zzb(zzg zzg) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8860l(zzg);
                return this;
            }

            public final List<zzh> zzbkt() {
                return Collections.unmodifiableList(((zzb) this.zzinm).zzbkt());
            }

            public final String zzbku() {
                return ((zzb) this.zzinm).zzbku();
            }

            public final C3984zzb zzbla() {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8873y();
                return this;
            }

            public final C3984zzb zzhy(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8857i(str);
                return this;
            }

            public final C3984zzb zzhz(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8854C(str);
                return this;
            }

            public final C3984zzb zzia(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8853B(str);
                return this;
            }

            public final C3984zzb zzo(Iterable<String> iterable) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8855D(iterable);
                return this;
            }

            public final C3984zzb zzp(Iterable<String> iterable) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8856E(iterable);
                return this;
            }

            /* synthetic */ C3984zzb(ic0 ic0) {
                this();
            }

            public final C3984zzb zzb(zza zza) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8858j(zza);
                return this;
            }

            public final C3984zzb zzb(zzh zzh) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8861m(zzh);
                return this;
            }

            public final C3984zzb zzb(zzf zzf) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8859k(zzf);
                return this;
            }

            public final C3984zzb zzb(zzi zzi) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).m8862n(zzi);
                return this;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzc extends zzekh<zzc, zza> implements zzelu {
            private static volatile zzemb<zzc> zzei;
            /* access modifiers changed from: private */
            public static final zzc zzivv;
            private int zzdt;
            private zzeiu zzidt;
            private byte zziup = 2;
            private zzeiu zzivu;

            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class zza extends zzekh.zza<zzc, zza> implements zzelu {
                private zza() {
                    super(zzc.zzivv);
                }

                public final zza zzap(zzeiu zzeiu) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzc) this.zzinm).m8880k(zzeiu);
                    return this;
                }

                public final zza zzaq(zzeiu zzeiu) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzc) this.zzinm).m8879j(zzeiu);
                    return this;
                }

                /* synthetic */ zza(ic0 ic0) {
                    this();
                }
            }

            static {
                zzc zzc = new zzc();
                zzivv = zzc;
                zzekh.zza(zzc.class, zzc);
            }

            private zzc() {
                zzeiu zzeiu = zzeiu.zziiy;
                this.zzivu = zzeiu;
                this.zzidt = zzeiu;
            }

            /* access modifiers changed from: private */
            /* renamed from: j */
            public final void m8879j(zzeiu zzeiu) {
                zzeiu.getClass();
                this.zzdt |= 2;
                this.zzidt = zzeiu;
            }

            /* access modifiers changed from: private */
            /* renamed from: k */
            public final void m8880k(zzeiu zzeiu) {
                zzeiu.getClass();
                this.zzdt |= 1;
                this.zzivu = zzeiu;
            }

            public static zza zzblb() {
                return (zza) zzivv.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (ic0.f9312a[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza((ic0) null);
                    case 3:
                        return zzekh.zza((zzels) zzivv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzdt", "zzivu", "zzidt"});
                    case 4:
                        return zzivv;
                    case 5:
                        zzemb<zzc> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzc.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzivv);
                                    zzei = zzemb;
                                }
                            }
                        }
                        return zzemb;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zziup = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzd extends zzekh<zzd, C3986zzb> implements zzelu {
            private static volatile zzemb<zzd> zzei;
            /* access modifiers changed from: private */
            public static final zzd zziwb;
            private int zzdt;
            private byte zziup = 2;
            private zza zzivw;
            private zzekp<zzc> zzivx = zzekh.zzbic();
            private zzeiu zzivy;
            private zzeiu zzivz;
            private int zziwa;

            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class zza extends zzekh<zza, C3985zza> implements zzelu {
                private static volatile zzemb<zza> zzei;
                /* access modifiers changed from: private */
                public static final zza zziwf;
                private int zzdt;
                private zzeiu zziwc;
                private zzeiu zziwd;
                private zzeiu zziwe;

                /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzd$zza$zza  reason: collision with other inner class name */
                /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
                public static final class C3985zza extends zzekh.zza<zza, C3985zza> implements zzelu {
                    private C3985zza() {
                        super(zza.zziwf);
                    }

                    /* synthetic */ C3985zza(ic0 ic0) {
                        this();
                    }
                }

                static {
                    zza zza = new zza();
                    zziwf = zza;
                    zzekh.zza(zza.class, zza);
                }

                private zza() {
                    zzeiu zzeiu = zzeiu.zziiy;
                    this.zziwc = zzeiu;
                    this.zziwd = zzeiu;
                    this.zziwe = zzeiu;
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (ic0.f9312a[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C3985zza((ic0) null);
                        case 3:
                            return zzekh.zza((zzels) zziwf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdt", "zziwc", "zziwd", "zziwe"});
                        case 4:
                            return zziwf;
                        case 5:
                            zzemb<zza> zzemb = zzei;
                            if (zzemb == null) {
                                synchronized (zza.class) {
                                    zzemb = zzei;
                                    if (zzemb == null) {
                                        zzemb = new zzekh.zzc<>(zziwf);
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

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzd$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class C3986zzb extends zzekh.zza<zzd, C3986zzb> implements zzelu {
                private C3986zzb() {
                    super(zzd.zziwb);
                }

                public final C3986zzb zzb(zzc zzc) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzd) this.zzinm).m8883i(zzc);
                    return this;
                }

                /* synthetic */ C3986zzb(ic0 ic0) {
                    this();
                }
            }

            static {
                zzd zzd = new zzd();
                zziwb = zzd;
                zzekh.zza(zzd.class, zzd);
            }

            private zzd() {
                zzeiu zzeiu = zzeiu.zziiy;
                this.zzivy = zzeiu;
                this.zzivz = zzeiu;
            }

            /* access modifiers changed from: private */
            /* renamed from: i */
            public final void m8883i(zzc zzc) {
                zzc.getClass();
                zzekp<zzc> zzekp = this.zzivx;
                if (!zzekp.zzbfk()) {
                    this.zzivx = zzekh.zza(zzekp);
                }
                this.zzivx.add(zzc);
            }

            public static C3986zzb zzbld() {
                return (C3986zzb) zziwb.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (ic0.f9312a[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new C3986zzb((ic0) null);
                    case 3:
                        return zzekh.zza((zzels) zziwb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzdt", "zzivw", "zzivx", zzc.class, "zzivy", "zzivz", "zziwa"});
                    case 4:
                        return zziwb;
                    case 5:
                        zzemb<zzd> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzd.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zziwb);
                                    zzei = zzemb;
                                }
                            }
                        }
                        return zzemb;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zziup = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zze extends zzekh<zze, C3988zzb> implements zzelu {
            private static volatile zzemb<zze> zzei;
            /* access modifiers changed from: private */
            public static final zze zziwi;
            private int zzdt;
            private byte zziup = 2;
            private zzekp<zzc> zzivx = zzekh.zzbic();
            private zzeiu zzivy;
            private zzeiu zzivz;
            private int zziwa;
            private zza zziwg;
            private zzeiu zziwh;

            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class zza extends zzekh<zza, C3987zza> implements zzelu {
                private static volatile zzemb<zza> zzei;
                /* access modifiers changed from: private */
                public static final zza zziwl;
                private int zzdt;
                private zzeiu zziwe;
                private int zziwj;
                private zzeiu zziwk;

                /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zze$zza$zza  reason: collision with other inner class name */
                /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
                public static final class C3987zza extends zzekh.zza<zza, C3987zza> implements zzelu {
                    private C3987zza() {
                        super(zza.zziwl);
                    }

                    /* synthetic */ C3987zza(ic0 ic0) {
                        this();
                    }
                }

                static {
                    zza zza = new zza();
                    zziwl = zza;
                    zzekh.zza(zza.class, zza);
                }

                private zza() {
                    zzeiu zzeiu = zzeiu.zziiy;
                    this.zziwk = zzeiu;
                    this.zziwe = zzeiu;
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (ic0.f9312a[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C3987zza((ic0) null);
                        case 3:
                            return zzekh.zza((zzels) zziwl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdt", "zziwj", "zziwk", "zziwe"});
                        case 4:
                            return zziwl;
                        case 5:
                            zzemb<zza> zzemb = zzei;
                            if (zzemb == null) {
                                synchronized (zza.class) {
                                    zzemb = zzei;
                                    if (zzemb == null) {
                                        zzemb = new zzekh.zzc<>(zziwl);
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

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zze$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class C3988zzb extends zzekh.zza<zze, C3988zzb> implements zzelu {
                private C3988zzb() {
                    super(zze.zziwi);
                }

                /* synthetic */ C3988zzb(ic0 ic0) {
                    this();
                }
            }

            static {
                zze zze = new zze();
                zziwi = zze;
                zzekh.zza(zze.class, zze);
            }

            private zze() {
                zzeiu zzeiu = zzeiu.zziiy;
                this.zzivy = zzeiu;
                this.zzivz = zzeiu;
                this.zziwh = zzeiu;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (ic0.f9312a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C3988zzb((ic0) null);
                    case 3:
                        return zzekh.zza((zzels) zziwi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzdt", "zziwg", "zzivx", zzc.class, "zzivy", "zzivz", "zziwa", "zziwh"});
                    case 4:
                        return zziwi;
                    case 5:
                        zzemb<zze> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zze.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zziwi);
                                    zzei = zzemb;
                                }
                            }
                        }
                        return zzemb;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zziup = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzf extends zzekh<zzf, C3989zzb> implements zzelu {
            private static volatile zzemb<zzf> zzei;
            /* access modifiers changed from: private */
            public static final zzf zziwo;
            private int zzbzz;
            private int zzdt;
            private String zziwm = "";
            private zzeiu zziwn = zzeiu.zziiy;

            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public enum zza implements zzekj {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                

                /* renamed from: a */
                private final int f16301a;

                private zza(int i) {
                    this.f16301a = i;
                }

                public static zza zzhy(int i) {
                    if (i == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                public static zzekl zzw() {
                    return kc0.f9747a;
                }

                public final String toString() {
                    return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f16301a + " name=" + name() + '>';
                }

                public final int zzv() {
                    return this.f16301a;
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzf$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class C3989zzb extends zzekh.zza<zzf, C3989zzb> implements zzelu {
                private C3989zzb() {
                    super(zzf.zziwo);
                }

                public final C3989zzb zzas(zzeiu zzeiu) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzf) this.zzinm).m8894n(zzeiu);
                    return this;
                }

                public final C3989zzb zzb(zza zza) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzf) this.zzinm).m8890j(zza);
                    return this;
                }

                public final C3989zzb zzic(String str) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzf) this.zzinm).m8889i(str);
                    return this;
                }

                /* synthetic */ C3989zzb(ic0 ic0) {
                    this();
                }
            }

            static {
                zzf zzf = new zzf();
                zziwo = zzf;
                zzekh.zza(zzf.class, zzf);
            }

            private zzf() {
            }

            /* access modifiers changed from: private */
            /* renamed from: i */
            public final void m8889i(String str) {
                str.getClass();
                this.zzdt |= 2;
                this.zziwm = str;
            }

            /* access modifiers changed from: private */
            /* renamed from: j */
            public final void m8890j(zza zza2) {
                this.zzbzz = zza2.zzv();
                this.zzdt |= 1;
            }

            /* access modifiers changed from: private */
            /* renamed from: n */
            public final void m8894n(zzeiu zzeiu) {
                zzeiu.getClass();
                this.zzdt |= 4;
                this.zziwn = zzeiu;
            }

            public static C3989zzb zzbli() {
                return (C3989zzb) zziwo.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (ic0.f9312a[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C3989zzb((ic0) null);
                    case 3:
                        return zzekh.zza((zzels) zziwo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzdt", "zzbzz", zza.zzw(), "zziwm", "zziwn"});
                    case 4:
                        return zziwo;
                    case 5:
                        zzemb<zzf> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzf.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zziwo);
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
        public enum zzg implements zzekj {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            

            /* renamed from: a */
            private final int f16311a;

            private zzg(int i) {
                this.f16311a = i;
            }

            public static zzg zzhz(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzekl zzw() {
                return lc0.f9834a;
            }

            public final String toString() {
                return "<" + zzg.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f16311a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f16311a;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzh extends zzekh<zzh, C3990zzb> implements zzelu {
            private static volatile zzemb<zzh> zzei;
            /* access modifiers changed from: private */
            public static final zzh zzixl;
            private int zzdt;
            private byte zziup = 2;
            private String zzius = "";
            private int zzixd;
            private zzd zzixe;
            private zze zzixf;
            private int zzixg;
            private zzeko zzixh = zzekh.zzbia();
            private String zzixi = "";
            private int zzixj;
            private zzekp<String> zzixk = zzekh.zzbic();

            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public enum zza implements zzekj {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                

                /* renamed from: a */
                private final int f16317a;

                private zza(int i) {
                    this.f16317a = i;
                }

                public static zza zzia(int i) {
                    if (i == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                }

                public static zzekl zzw() {
                    return mc0.f9935a;
                }

                public final String toString() {
                    return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f16317a + " name=" + name() + '>';
                }

                public final int zzv() {
                    return this.f16317a;
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class C3990zzb extends zzekh.zza<zzh, C3990zzb> implements zzelu {
                private C3990zzb() {
                    super(zzh.zzixl);
                }

                public final C3990zzb zzb(zzd zzd) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzh) this.zzinm).m8898k(zzd);
                    return this;
                }

                public final C3990zzb zzib(int i) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzh) this.zzinm).m8896i(i);
                    return this;
                }

                public final C3990zzb zzie(String str) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzh) this.zzinm).m8897j(str);
                    return this;
                }

                public final C3990zzb zzif(String str) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzh) this.zzinm).m8906s(str);
                    return this;
                }

                /* synthetic */ C3990zzb(ic0 ic0) {
                    this();
                }

                public final C3990zzb zzb(zza zza) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzh) this.zzinm).m8899l(zza);
                    return this;
                }
            }

            static {
                zzh zzh = new zzh();
                zzixl = zzh;
                zzekh.zza(zzh.class, zzh);
            }

            private zzh() {
            }

            /* access modifiers changed from: private */
            /* renamed from: i */
            public final void m8896i(int i) {
                this.zzdt |= 1;
                this.zzixd = i;
            }

            /* access modifiers changed from: private */
            /* renamed from: j */
            public final void m8897j(String str) {
                str.getClass();
                this.zzdt |= 2;
                this.zzius = str;
            }

            /* access modifiers changed from: private */
            /* renamed from: k */
            public final void m8898k(zzd zzd) {
                zzd.getClass();
                this.zzixe = zzd;
                this.zzdt |= 4;
            }

            /* access modifiers changed from: private */
            /* renamed from: l */
            public final void m8899l(zza zza2) {
                this.zzixj = zza2.zzv();
                this.zzdt |= 64;
            }

            /* access modifiers changed from: private */
            /* renamed from: s */
            public final void m8906s(String str) {
                str.getClass();
                zzekp<String> zzekp = this.zzixk;
                if (!zzekp.zzbfk()) {
                    this.zzixk = zzekh.zza(zzekp);
                }
                this.zzixk.add(str);
            }

            public static C3990zzb zzbll() {
                return (C3990zzb) zzixl.zzbhx();
            }

            public final String getUrl() {
                return this.zzius;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (ic0.f9312a[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C3990zzb((ic0) null);
                    case 3:
                        return zzekh.zza((zzels) zzixl, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzdt", "zzixd", "zzius", "zzixe", "zzixf", "zzixg", "zzixh", "zzixi", "zzixj", zza.zzw(), "zzixk"});
                    case 4:
                        return zzixl;
                    case 5:
                        zzemb<zzh> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzh.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzixl);
                                    zzei = zzemb;
                                }
                            }
                        }
                        return zzemb;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zziup = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public final int zzblk() {
                return this.zzixk.size();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        public static final class zzi extends zzekh<zzi, zza> implements zzelu {
            private static volatile zzemb<zzi> zzei;
            /* access modifiers changed from: private */
            public static final zzi zzixu;
            private int zzdt;
            private String zzixr = "";
            private long zzixs;
            private boolean zzixt;

            /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
            public static final class zza extends zzekh.zza<zzi, zza> implements zzelu {
                private zza() {
                    super(zzi.zzixu);
                }

                public final zza zzbw(boolean z) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzi) this.zzinm).m8911m(z);
                    return this;
                }

                public final zza zzfs(long j) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzi) this.zzinm).m8912n(j);
                    return this;
                }

                public final zza zzig(String str) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzi) this.zzinm).m8913o(str);
                    return this;
                }

                /* synthetic */ zza(ic0 ic0) {
                    this();
                }
            }

            static {
                zzi zzi = new zzi();
                zzixu = zzi;
                zzekh.zza(zzi.class, zzi);
            }

            private zzi() {
            }

            /* access modifiers changed from: private */
            /* renamed from: m */
            public final void m8911m(boolean z) {
                this.zzdt |= 4;
                this.zzixt = z;
            }

            /* access modifiers changed from: private */
            /* renamed from: n */
            public final void m8912n(long j) {
                this.zzdt |= 2;
                this.zzixs = j;
            }

            /* access modifiers changed from: private */
            /* renamed from: o */
            public final void m8913o(String str) {
                str.getClass();
                this.zzdt |= 1;
                this.zzixr = str;
            }

            public static zza zzbln() {
                return (zza) zzixu.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (ic0.f9312a[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza((ic0) null);
                    case 3:
                        return zzekh.zza((zzels) zzixu, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzdt", "zzixr", "zzixs", "zzixt"});
                    case 4:
                        return zzixu;
                    case 5:
                        zzemb<zzi> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzi.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzixu);
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
            zzivr = zzb;
            zzekh.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        /* renamed from: B */
        public final void m8853B(String str) {
            str.getClass();
            this.zzdt |= 64;
            this.zzivh = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: C */
        public final void m8854C(String str) {
            str.getClass();
            this.zzdt |= 8;
            this.zzivd = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: D */
        public final void m8855D(Iterable<String> iterable) {
            zzekp<String> zzekp = this.zzivp;
            if (!zzekp.zzbfk()) {
                this.zzivp = zzekh.zza(zzekp);
            }
            zzeik.zza(iterable, this.zzivp);
        }

        /* access modifiers changed from: private */
        /* renamed from: E */
        public final void m8856E(Iterable<String> iterable) {
            zzekp<String> zzekp = this.zzivq;
            if (!zzekp.zzbfk()) {
                this.zzivq = zzekh.zza(zzekp);
            }
            zzeik.zza(iterable, this.zzivq);
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public final void m8857i(String str) {
            str.getClass();
            this.zzdt |= 4;
            this.zzius = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public final void m8858j(zza zza2) {
            zza2.getClass();
            this.zzivf = zza2;
            this.zzdt |= 32;
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public final void m8859k(zzf zzf2) {
            zzf2.getClass();
            this.zzivi = zzf2;
            this.zzdt |= 128;
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public final void m8860l(zzg zzg2) {
            this.zzbzz = zzg2.zzv();
            this.zzdt |= 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: m */
        public final void m8861m(zzh zzh2) {
            zzh2.getClass();
            zzekp<zzh> zzekp = this.zzivg;
            if (!zzekp.zzbfk()) {
                this.zzivg = zzekh.zza(zzekp);
            }
            this.zzivg.add(zzh2);
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public final void m8862n(zzi zzi2) {
            zzi2.getClass();
            this.zzivo = zzi2;
            this.zzdt |= 8192;
        }

        /* access modifiers changed from: private */
        /* renamed from: y */
        public final void m8873y() {
            this.zzdt &= -65;
            this.zzivh = zzivr.zzivh;
        }

        public static C3984zzb zzbkw() {
            return (C3984zzb) zzivr.zzbhx();
        }

        public final String getUrl() {
            return this.zzius;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (ic0.f9312a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C3984zzb((ic0) null);
                case 3:
                    return zzekh.zza((zzels) zzivr, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzdt", "zzius", "zzivd", "zzive", "zzivg", zzh.class, "zzivj", "zzivk", "zzivl", "zzivm", "zzivn", "zzbzz", zzg.zzw(), "zzivc", zza.zzc.zzw(), "zzivf", "zzivh", "zzivi", "zziul", "zzivo", "zzivp", "zzivq"});
                case 4:
                    return zzivr;
                case 5:
                    zzemb<zzb> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzb.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzivr);
                                zzei = zzemb;
                            }
                        }
                    }
                    return zzemb;
                case 6:
                    return Byte.valueOf(this.zziup);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zziup = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final List<zzh> zzbkt() {
            return this.zzivg;
        }

        public final String zzbku() {
            return this.zzivh;
        }
    }
}
