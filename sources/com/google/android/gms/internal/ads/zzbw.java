package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzbw {

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public static final class zza extends zzekh<zza, C3974zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zza zzeh;
        private static volatile zzemb<zza> zzei;
        private int zzdt;
        private String zzdu = "";
        private long zzdv;
        private String zzdw = "";
        private String zzdx = "";
        private String zzdy = "";
        private long zzdz;
        private long zzea;
        private String zzeb = "";
        private long zzec;
        private String zzed = "";
        private String zzee = "";
        private zzekp<zzb> zzef = zzekh.zzbic();
        private int zzeg;

        /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
        public static final class C3974zza extends zzekh.zza<zza, C3974zza> implements zzelu {
            private C3974zza() {
                super(zza.zzeh);
            }

            public final C3974zza zza(zzc zzc) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).m7872l(zzc);
                return this;
            }

            public final C3974zza zzc(long j) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).m7875o(j);
                return this;
            }

            public final C3974zza zzj(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).m7878r(str);
                return this;
            }

            public final C3974zza zzk(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).m7879s(str);
                return this;
            }

            public final C3974zza zzl(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).m7880t(str);
                return this;
            }

            public final C3974zza zzm(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).m7881u(str);
                return this;
            }

            public final C3974zza zzn(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).m7882v(str);
                return this;
            }

            /* synthetic */ C3974zza(C2660ze zeVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
        public static final class zzb extends zzekh<zzb, C3975zza> implements zzelu {
            private static volatile zzemb<zzb> zzei;
            /* access modifiers changed from: private */
            public static final zzb zzel;
            private int zzdt;
            private String zzej = "";
            private String zzek = "";

            /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zzb$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
            public static final class C3975zza extends zzekh.zza<zzb, C3975zza> implements zzelu {
                private C3975zza() {
                    super(zzb.zzel);
                }

                /* synthetic */ C3975zza(C2660ze zeVar) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzel = zzb;
                zzekh.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (C2660ze.f12285a[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C3975zza((C2660ze) null);
                    case 3:
                        return zzekh.zza((zzels) zzel, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzdt", "zzej", "zzek"});
                    case 4:
                        return zzel;
                    case 5:
                        zzemb<zzb> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzb.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzel);
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

        /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
        public enum zzc implements zzekj {
            UNKNOWN(0),
            ENABLED(1),
            DISABLED(2);
            

            /* renamed from: a */
            private final int f13792a;

            private zzc(int i) {
                this.f13792a = i;
            }

            public static zzc zzh(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return ENABLED;
                }
                if (i != 2) {
                    return null;
                }
                return DISABLED;
            }

            public static zzekl zzw() {
                return C2323qg.f10717a;
            }

            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f13792a + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.f13792a;
            }
        }

        static {
            zza zza = new zza();
            zzeh = zza;
            zzekh.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public final void m7872l(zzc zzc2) {
            this.zzeg = zzc2.zzv();
            this.zzdt |= 2048;
        }

        /* access modifiers changed from: private */
        /* renamed from: o */
        public final void m7875o(long j) {
            this.zzdt |= 2;
            this.zzdv = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: r */
        public final void m7878r(String str) {
            str.getClass();
            this.zzdt |= 1;
            this.zzdu = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: s */
        public final void m7879s(String str) {
            str.getClass();
            this.zzdt |= 4;
            this.zzdw = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: t */
        public final void m7880t(String str) {
            str.getClass();
            this.zzdt |= 8;
            this.zzdx = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public final void m7881u(String str) {
            str.getClass();
            this.zzdt |= 16;
            this.zzdy = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: v */
        public final void m7882v(String str) {
            str.getClass();
            this.zzdt |= 1024;
            this.zzee = str;
        }

        public static C3974zza zzs() {
            return (C3974zza) zzeh.zzbhx();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2660ze.f12285a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3974zza((C2660ze) null);
                case 3:
                    return zzekh.zza((zzels) zzeh, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zzdt", "zzdu", "zzdv", "zzdw", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", zzb.class, "zzeg", zzc.zzw()});
                case 4:
                    return zzeh;
                case 5:
                    zzemb<zza> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zza.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzeh);
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
