package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhz;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class zzcd {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zza extends zzhz<zza, C3998zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzju<zza> zzi;
        private int zzc;
        private int zzd;
        private zzi zze;
        private zzi zzf;
        private boolean zzg;

        /* renamed from: com.google.android.gms.internal.measurement.zzcd$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class C3998zza extends zzhz.zza<zza, C3998zza> implements zzjj {
            private C3998zza() {
                super(zza.zzh);
            }

            public final C3998zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).m10070e(i);
                return this;
            }

            /* synthetic */ C3998zza(C2852r0 r0Var) {
                this();
            }

            public final C3998zza zza(zzi.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).m10074i((zzi) ((zzhz) zza.zzz()));
                return this;
            }

            public final C3998zza zza(zzi zzi) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).m10077l(zzi);
                return this;
            }

            public final C3998zza zza(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).m10075j(z);
                return this;
            }
        }

        static {
            zza zza = new zza();
            zzh = zza;
            zzhz.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public final void m10070e(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public final void m10074i(zzi zzi2) {
            zzi2.getClass();
            this.zze = zzi2;
            this.zzc |= 2;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public final void m10075j(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public final void m10077l(zzi zzi2) {
            zzi2.getClass();
            this.zzf = zzi2;
            this.zzc |= 4;
        }

        public static C3998zza zzh() {
            return (C3998zza) zzh.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final zzi zzc() {
            zzi zzi2 = this.zze;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final zzi zze() {
            zzi zzi2 = this.zzf;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final boolean zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3998zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzju<zza> zzju = zzi;
                    if (zzju == null) {
                        synchronized (zza.class) {
                            zzju = zzi;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzh);
                                zzi = zzju;
                            }
                        }
                    }
                    return zzju;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zzb extends zzhz<zzb, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzb zzf;
        private static volatile zzju<zzb> zzg;
        private int zzc;
        private int zzd;
        private long zze;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzb, zza> implements zzjj {
            private zza() {
                super(zzb.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).m10079e(i);
                return this;
            }

            /* synthetic */ zza(C2852r0 r0Var) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).m10080f(j);
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zzf = zzb;
            zzhz.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public final void m10079e(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public final void m10080f(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zze() {
            return (zza) zzf.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final long zzd() {
            return this.zze;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzju<zzb> zzju = zzg;
                    if (zzju == null) {
                        synchronized (zzb.class) {
                            zzju = zzg;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzf);
                                zzg = zzju;
                            }
                        }
                    }
                    return zzju;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zzc extends zzhz<zzc, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzc zzi;
        private static volatile zzju<zzc> zzj;
        private int zzc;
        private zzii<zze> zzd = zzhz.zzbr();
        private String zze = "";
        private long zzf;
        private long zzg;
        private int zzh;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzc, zza> implements zzjj {
            private zza() {
                super(zzc.zzi);
            }

            public final List<zze> zza() {
                return Collections.unmodifiableList(((zzc) this.zza).zza());
            }

            public final int zzb() {
                return ((zzc) this.zza).zzb();
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10101v();
                return this;
            }

            public final String zzd() {
                return ((zzc) this.zza).zzc();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzd();
            }

            public final long zzf() {
                return ((zzc) this.zza).zze();
            }

            public final long zzg() {
                return ((zzc) this.zza).zzg();
            }

            /* synthetic */ zza(C2852r0 r0Var) {
                this();
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10096q(i);
                return this;
            }

            public final zze zza(int i) {
                return ((zzc) this.zza).zza(i);
            }

            public final zza zza(int i, zze zze) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10084e(i, zze);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10097r(j);
                return this;
            }

            public final zza zza(int i, zze.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10084e(i, (zze) ((zzhz) zza.zzz()));
                return this;
            }

            public final zza zza(zze zze) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10093n(zze);
                return this;
            }

            public final zza zza(zze.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10093n((zze) ((zzhz) zza.zzz()));
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10094o(iterable);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10095p(str);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10085f(j);
                return this;
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzi = zzc2;
            zzhz.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public final void m10084e(int i, zze zze2) {
            zze2.getClass();
            m10100u();
            this.zzd.set(i, zze2);
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public final void m10085f(long j) {
            this.zzc |= 2;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public final void m10093n(zze zze2) {
            zze2.getClass();
            m10100u();
            this.zzd.add(zze2);
        }

        /* access modifiers changed from: private */
        /* renamed from: o */
        public final void m10094o(Iterable<? extends zze> iterable) {
            m10100u();
            zzgh.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        /* renamed from: p */
        public final void m10095p(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: q */
        public final void m10096q(int i) {
            m10100u();
            this.zzd.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: r */
        public final void m10097r(long j) {
            this.zzc |= 4;
            this.zzg = j;
        }

        /* renamed from: u */
        private final void m10100u() {
            zzii<zze> zzii = this.zzd;
            if (!zzii.zza()) {
                this.zzd = zzhz.zza(zzii);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: v */
        public final void m10101v() {
            this.zzd = zzhz.zzbr();
        }

        public static zza zzj() {
            return (zza) zzi.zzbm();
        }

        public final List<zze> zza() {
            return this.zzd;
        }

        public final int zzb() {
            return this.zzd.size();
        }

        public final String zzc() {
            return this.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 2) != 0;
        }

        public final long zze() {
            return this.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 4) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zzc & 8) != 0;
        }

        public final int zzi() {
            return this.zzh;
        }

        public final zze zza(int i) {
            return this.zzd.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", zze.class, "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzju<zzc> zzju = zzj;
                    if (zzju == null) {
                        synchronized (zzc.class) {
                            zzju = zzj;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzi);
                                zzj = zzju;
                            }
                        }
                    }
                    return zzju;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zzd extends zzhz<zzd, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzd zzf;
        private static volatile zzju<zzd> zzg;
        private int zzc;
        private String zzd = "";
        private long zze;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzd, zza> implements zzjj {
            private zza() {
                super(zzd.zzf);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzd) this.zza).m10105h(str);
                return this;
            }

            /* synthetic */ zza(C2852r0 r0Var) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzd) this.zza).m10102e(j);
                return this;
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzf = zzd2;
            zzhz.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public final void m10102e(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public final void m10105h(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public static zza zza() {
            return (zza) zzf.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzju<zzd> zzju = zzg;
                    if (zzju == null) {
                        synchronized (zzd.class) {
                            zzju = zzg;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzf);
                                zzg = zzju;
                            }
                        }
                    }
                    return zzju;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zze extends zzhz<zze, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zze zzj;
        private static volatile zzju<zze> zzk;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private long zzf;
        private float zzg;
        private double zzh;
        private zzii<zze> zzi = zzhz.zzbr();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zze, zza> implements zzjj {
            private zza() {
                super(zze.zzj);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).m10116n(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).m10119q(str);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).m10126x();
                return this;
            }

            public final int zzd() {
                return ((zze) this.zza).zzl();
            }

            public final zza zze() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).m10128z();
                return this;
            }

            /* synthetic */ zza(C2852r0 r0Var) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).m10124v();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).m10125w();
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).m10108f(j);
                return this;
            }

            public final zza zza(double d) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).m10107e(d);
                return this;
            }

            public final zza zza(zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).m10122t((zze) ((zzhz) zza.zzz()));
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).m10115m(iterable);
                return this;
            }
        }

        static {
            zze zze2 = new zze();
            zzj = zze2;
            zzhz.zza(zze.class, zze2);
        }

        private zze() {
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public final void m10107e(double d) {
            this.zzc |= 16;
            this.zzh = d;
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public final void m10108f(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: m */
        public final void m10115m(Iterable<? extends zze> iterable) {
            m10127y();
            zzgh.zza(iterable, this.zzi);
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public final void m10116n(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: q */
        public final void m10119q(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: t */
        public final void m10122t(zze zze2) {
            zze2.getClass();
            m10127y();
            this.zzi.add(zze2);
        }

        /* access modifiers changed from: private */
        /* renamed from: v */
        public final void m10124v() {
            this.zzc &= -3;
            this.zze = zzj.zze;
        }

        /* access modifiers changed from: private */
        /* renamed from: w */
        public final void m10125w() {
            this.zzc &= -5;
            this.zzf = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: x */
        public final void m10126x() {
            this.zzc &= -17;
            this.zzh = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        /* renamed from: y */
        private final void m10127y() {
            zzii<zze> zzii = this.zzi;
            if (!zzii.zza()) {
                this.zzi = zzhz.zza(zzii);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: z */
        public final void m10128z() {
            this.zzi = zzhz.zzbr();
        }

        public static zza zzm() {
            return (zza) zzj.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final String zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final long zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final float zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return (this.zzc & 16) != 0;
        }

        public final double zzj() {
            return this.zzh;
        }

        public final List<zze> zzk() {
            return this.zzi;
        }

        public final int zzl() {
            return this.zzi.size();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            Class<zze> cls = zze.class;
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", cls});
                case 4:
                    return zzj;
                case 5:
                    zzju<zze> zzju = zzk;
                    if (zzju == null) {
                        synchronized (cls) {
                            zzju = zzk;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzj);
                                zzk = zzju;
                            }
                        }
                    }
                    return zzju;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zzf extends zzhz<zzf, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzf zzd;
        private static volatile zzju<zzf> zze;
        private zzii<zzg> zzc = zzhz.zzbr();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzf, zza> implements zzjj {
            private zza() {
                super(zzf.zzd);
            }

            public final zzg zza(int i) {
                return ((zzf) this.zza).zza(0);
            }

            /* synthetic */ zza(C2852r0 r0Var) {
                this();
            }

            public final zza zza(zzg.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzf) this.zza).m10130f((zzg) ((zzhz) zza.zzz()));
                return this;
            }
        }

        static {
            zzf zzf = new zzf();
            zzd = zzf;
            zzhz.zza(zzf.class, zzf);
        }

        private zzf() {
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public final void m10130f(zzg zzg) {
            zzg.getClass();
            zzii<zzg> zzii = this.zzc;
            if (!zzii.zza()) {
                this.zzc = zzhz.zza(zzii);
            }
            this.zzc.add(zzg);
        }

        public static zza zzb() {
            return (zza) zzd.zzbm();
        }

        public final List<zzg> zza() {
            return this.zzc;
        }

        public final zzg zza(int i) {
            return this.zzc.get(0);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzg.class});
                case 4:
                    return zzd;
                case 5:
                    zzju<zzf> zzju = zze;
                    if (zzju == null) {
                        synchronized (zzf.class) {
                            zzju = zze;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzd);
                                zze = zzju;
                            }
                        }
                    }
                    return zzju;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zzg extends zzhz<zzg, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzg zzax;
        private static volatile zzju<zzg> zzay;
        private int zzaa;
        private String zzab = "";
        private String zzac = "";
        private boolean zzad;
        private zzii<zza> zzae = zzhz.zzbr();
        private String zzaf = "";
        private int zzag;
        private int zzah;
        private int zzai;
        private String zzaj = "";
        private long zzak;
        private long zzal;
        private String zzam = "";
        private String zzan = "";
        private int zzao;
        private String zzap = "";
        private zzh zzaq;
        private zzig zzar = zzhz.zzbp();
        private long zzas;
        private long zzat;
        private String zzau = "";
        private String zzav = "";
        private int zzaw;
        private int zzc;
        private int zzd;
        private int zze;
        private zzii<zzc> zzf = zzhz.zzbr();
        private zzii<zzk> zzg = zzhz.zzbr();
        private long zzh;
        private long zzi;
        private long zzj;
        private long zzk;
        private long zzl;
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private int zzq;
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private long zzu;
        private long zzv;
        private String zzw = "";
        private boolean zzx;
        private String zzy = "";
        private long zzz;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzg, zza> implements zzjj {
            private zza() {
                super(zzg.zzax);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10190d0(1);
                return this;
            }

            public final int zzb() {
                return ((zzg) this.zza).zzd();
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10152K();
                return this;
            }

            public final List<zzk> zzd() {
                return Collections.unmodifiableList(((zzg) this.zza).zze());
            }

            public final int zze() {
                return ((zzg) this.zza).zzf();
            }

            public final long zzf() {
                return ((zzg) this.zza).zzj();
            }

            public final long zzg() {
                return ((zzg) this.zza).zzl();
            }

            public final zza zzh() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10156M();
                return this;
            }

            public final zza zzi() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10158N();
                return this;
            }

            public final String zzj() {
                return ((zzg) this.zza).zzx();
            }

            public final zza zzk() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10160O();
                return this;
            }

            public final zza zzl() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10178X();
                return this;
            }

            public final zza zzm() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10180Y();
                return this;
            }

            public final zza zzn() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10182Z();
                return this;
            }

            public final String zzo() {
                return ((zzg) this.zza).zzam();
            }

            public final zza zzp() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10184a0();
                return this;
            }

            public final zza zzq() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10186b0();
                return this;
            }

            public final zza zzr() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10188c0();
                return this;
            }

            public final String zzs() {
                return ((zzg) this.zza).zzbe();
            }

            /* synthetic */ zza(C2852r0 r0Var) {
                this();
            }

            public final zzc zzb(int i) {
                return ((zzg) this.zza).zza(i);
            }

            public final zza zze(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10236t0(i);
                return this;
            }

            public final zza zzf(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10133A0(i);
                return this;
            }

            public final zza zzg(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10145G0(str);
                return this;
            }

            public final zza zzj(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10181Y0(str);
                return this;
            }

            public final zza zzo(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10218m1(str);
                return this;
            }

            public final zza zzb(Iterable<? extends zzk> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10142F(iterable);
                return this;
            }

            public final zzk zzd(int i) {
                return ((zzg) this.zza).zzb(i);
            }

            public final List<zzc> zza() {
                return Collections.unmodifiableList(((zzg) this.zza).zzc());
            }

            public final zza zzc(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10217m0(i);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10193e0(j);
                return this;
            }

            public final zza zzh(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10157M0(str);
                return this;
            }

            public final zza zzi(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10169S0(str);
                return this;
            }

            public final zza zzk(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10189c1(str);
                return this;
            }

            public final zza zzl(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10200g1(str);
                return this;
            }

            public final zza zzm(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10206i1(str);
                return this;
            }

            public final zza zzn(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10212k1((String) null);
                return this;
            }

            public final zza zzp(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10224o1(str);
                return this;
            }

            public final zza zzq(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10230q1(str);
                return this;
            }

            public final zza zze(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10220n0(j);
                return this;
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10248z0(str);
                return this;
            }

            public final zza zzg(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10135B0(j);
                return this;
            }

            public final zza zzj(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10173U0(j);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10245y(j);
                return this;
            }

            public final zza zza(int i, zzc.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10192e(i, (zzc) ((zzhz) zza.zzz()));
                return this;
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10162P(j);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10214l0(str);
                return this;
            }

            public final zza zzh(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10149I0(j);
                return this;
            }

            public final zza zzi(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10161O0(j);
                return this;
            }

            public final zza zzk(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10183Z0(j);
                return this;
            }

            public final zza zzl(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10191d1(j);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10234s0(str);
                return this;
            }

            public final zza zzf(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10238u0(j);
                return this;
            }

            public final zza zzg(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10147H0(i);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10144G(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10176W(str);
                return this;
            }

            public final zza zzd(Iterable<? extends Integer> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10211k0(iterable);
                return this;
            }

            public final zza zzh(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10159N0(i);
                return this;
            }

            public final zza zzi(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10171T0(i);
                return this;
            }

            public final zza zza(zzc.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10201h((zzc) ((zzhz) zza.zzz()));
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10146H(z);
                return this;
            }

            public final zza zzc(Iterable<? extends zza> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10174V(iterable);
                return this;
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10239v(iterable);
                return this;
            }

            public final zza zza(int i, zzk zzk) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10195f(i, zzk);
                return this;
            }

            public final zza zza(zzk zzk) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10237u(zzk);
                return this;
            }

            public final zza zza(zzk.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10237u((zzk) ((zzhz) zza.zzz()));
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10198g(j);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10241w(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10243x(z);
                return this;
            }

            public final zza zza(zzh.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).m10235t((zzh) ((zzhz) zza.zzz()));
                return this;
            }
        }

        static {
            zzg zzg2 = new zzg();
            zzax = zzg2;
            zzhz.zza(zzg.class, zzg2);
        }

        private zzg() {
        }

        /* access modifiers changed from: private */
        /* renamed from: A0 */
        public final void m10133A0(int i) {
            this.zzc |= 1024;
            this.zzq = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: B0 */
        public final void m10135B0(long j) {
            this.zzc |= 32768;
            this.zzv = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: F */
        public final void m10142F(Iterable<? extends zzk> iterable) {
            m10154L();
            zzgh.zza(iterable, this.zzg);
        }

        /* access modifiers changed from: private */
        /* renamed from: G */
        public final void m10144G(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzn = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: G0 */
        public final void m10145G0(String str) {
            str.getClass();
            this.zzc |= 8192;
            this.zzt = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: H */
        public final void m10146H(boolean z) {
            this.zzc |= 8388608;
            this.zzad = z;
        }

        /* access modifiers changed from: private */
        /* renamed from: H0 */
        public final void m10147H0(int i) {
            this.zzc |= 1048576;
            this.zzaa = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: I0 */
        public final void m10149I0(long j) {
            this.zzc |= 524288;
            this.zzz = j;
        }

        /* renamed from: J */
        private final void m10150J() {
            zzii<zzc> zzii = this.zzf;
            if (!zzii.zza()) {
                this.zzf = zzhz.zza(zzii);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: K */
        public final void m10152K() {
            this.zzf = zzhz.zzbr();
        }

        /* renamed from: L */
        private final void m10154L() {
            zzii<zzk> zzii = this.zzg;
            if (!zzii.zza()) {
                this.zzg = zzhz.zza(zzii);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: M */
        public final void m10156M() {
            this.zzc &= -17;
            this.zzk = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: M0 */
        public final void m10157M0(String str) {
            str.getClass();
            this.zzc |= 65536;
            this.zzw = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: N */
        public final void m10158N() {
            this.zzc &= -33;
            this.zzl = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: N0 */
        public final void m10159N0(int i) {
            this.zzc |= 33554432;
            this.zzag = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: O */
        public final void m10160O() {
            this.zzc &= -65537;
            this.zzw = zzax.zzw;
        }

        /* access modifiers changed from: private */
        /* renamed from: O0 */
        public final void m10161O0(long j) {
            this.zzc |= 536870912;
            this.zzak = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: P */
        public final void m10162P(long j) {
            this.zzc |= 8;
            this.zzj = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: S0 */
        public final void m10169S0(String str) {
            str.getClass();
            this.zzc |= 262144;
            this.zzy = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: T0 */
        public final void m10171T0(int i) {
            this.zzd |= 2;
            this.zzao = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: U0 */
        public final void m10173U0(long j) {
            this.zzc |= 1073741824;
            this.zzal = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: V */
        public final void m10174V(Iterable<? extends zza> iterable) {
            zzii<zza> zzii = this.zzae;
            if (!zzii.zza()) {
                this.zzae = zzhz.zza(zzii);
            }
            zzgh.zza(iterable, this.zzae);
        }

        /* access modifiers changed from: private */
        /* renamed from: W */
        public final void m10176W(String str) {
            str.getClass();
            this.zzc |= 256;
            this.zzo = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: X */
        public final void m10178X() {
            this.zzc &= -131073;
            this.zzx = false;
        }

        /* access modifiers changed from: private */
        /* renamed from: Y */
        public final void m10180Y() {
            this.zzc &= -262145;
            this.zzy = zzax.zzy;
        }

        /* access modifiers changed from: private */
        /* renamed from: Y0 */
        public final void m10181Y0(String str) {
            str.getClass();
            this.zzc |= 2097152;
            this.zzab = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: Z */
        public final void m10182Z() {
            this.zzc &= -2097153;
            this.zzab = zzax.zzab;
        }

        /* access modifiers changed from: private */
        /* renamed from: Z0 */
        public final void m10183Z0(long j) {
            this.zzd |= 16;
            this.zzas = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: a0 */
        public final void m10184a0() {
            this.zzae = zzhz.zzbr();
        }

        /* access modifiers changed from: private */
        /* renamed from: b0 */
        public final void m10186b0() {
            this.zzc &= -268435457;
            this.zzaj = zzax.zzaj;
        }

        /* access modifiers changed from: private */
        /* renamed from: c0 */
        public final void m10188c0() {
            this.zzc &= Integer.MAX_VALUE;
            this.zzam = zzax.zzam;
        }

        /* access modifiers changed from: private */
        /* renamed from: c1 */
        public final void m10189c1(String str) {
            str.getClass();
            this.zzc |= 4194304;
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: d0 */
        public final void m10190d0(int i) {
            this.zzc |= 1;
            this.zze = 1;
        }

        /* access modifiers changed from: private */
        /* renamed from: d1 */
        public final void m10191d1(long j) {
            this.zzd |= 32;
            this.zzat = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public final void m10192e(int i, zzc zzc2) {
            zzc2.getClass();
            m10150J();
            this.zzf.set(i, zzc2);
        }

        /* access modifiers changed from: private */
        /* renamed from: e0 */
        public final void m10193e0(long j) {
            this.zzc |= 16;
            this.zzk = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public final void m10195f(int i, zzk zzk2) {
            zzk2.getClass();
            m10154L();
            this.zzg.set(i, zzk2);
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public final void m10198g(long j) {
            this.zzc |= 2;
            this.zzh = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: g1 */
        public final void m10200g1(String str) {
            str.getClass();
            this.zzc |= 16777216;
            this.zzaf = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public final void m10201h(zzc zzc2) {
            zzc2.getClass();
            m10150J();
            this.zzf.add(zzc2);
        }

        /* access modifiers changed from: private */
        /* renamed from: i1 */
        public final void m10206i1(String str) {
            str.getClass();
            this.zzc |= 268435456;
            this.zzaj = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: k0 */
        public final void m10211k0(Iterable<? extends Integer> iterable) {
            zzig zzig = this.zzar;
            if (!zzig.zza()) {
                int size = zzig.size();
                this.zzar = zzig.zzb(size == 0 ? 10 : size << 1);
            }
            zzgh.zza(iterable, this.zzar);
        }

        /* access modifiers changed from: private */
        /* renamed from: k1 */
        public final void m10212k1(String str) {
            str.getClass();
            this.zzc |= Integer.MIN_VALUE;
            this.zzam = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: l0 */
        public final void m10214l0(String str) {
            str.getClass();
            this.zzc |= 512;
            this.zzp = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: m0 */
        public final void m10217m0(int i) {
            m10150J();
            this.zzf.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: m1 */
        public final void m10218m1(String str) {
            str.getClass();
            this.zzd |= 4;
            this.zzap = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: n0 */
        public final void m10220n0(long j) {
            this.zzc |= 32;
            this.zzl = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: o1 */
        public final void m10224o1(String str) {
            str.getClass();
            this.zzd |= 64;
            this.zzau = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: q1 */
        public final void m10230q1(String str) {
            str.getClass();
            this.zzd |= 128;
            this.zzav = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: s0 */
        public final void m10234s0(String str) {
            str.getClass();
            this.zzc |= 2048;
            this.zzr = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: t */
        public final void m10235t(zzh zzh2) {
            zzh2.getClass();
            this.zzaq = zzh2;
            this.zzd |= 8;
        }

        /* access modifiers changed from: private */
        /* renamed from: t0 */
        public final void m10236t0(int i) {
            m10154L();
            this.zzg.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public final void m10237u(zzk zzk2) {
            zzk2.getClass();
            m10154L();
            this.zzg.add(zzk2);
        }

        /* access modifiers changed from: private */
        /* renamed from: u0 */
        public final void m10238u0(long j) {
            this.zzc |= 16384;
            this.zzu = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: v */
        public final void m10239v(Iterable<? extends zzc> iterable) {
            m10150J();
            zzgh.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        /* renamed from: w */
        public final void m10241w(String str) {
            str.getClass();
            this.zzc |= 64;
            this.zzm = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: x */
        public final void m10243x(boolean z) {
            this.zzc |= 131072;
            this.zzx = z;
        }

        /* access modifiers changed from: private */
        /* renamed from: y */
        public final void m10245y(long j) {
            this.zzc |= 4;
            this.zzi = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: z0 */
        public final void m10248z0(String str) {
            str.getClass();
            this.zzc |= 4096;
            this.zzs = str;
        }

        public static zza zzbh() {
            return (zza) zzax.zzbm();
        }

        /* renamed from: h_ */
        public final long mo19221h_() {
            return this.zzu;
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final boolean zzab() {
            return (this.zzc & 32768) != 0;
        }

        public final long zzac() {
            return this.zzv;
        }

        public final String zzad() {
            return this.zzw;
        }

        public final boolean zzae() {
            return (this.zzc & 131072) != 0;
        }

        public final boolean zzaf() {
            return this.zzx;
        }

        public final String zzag() {
            return this.zzy;
        }

        public final boolean zzah() {
            return (this.zzc & 524288) != 0;
        }

        public final long zzai() {
            return this.zzz;
        }

        public final boolean zzaj() {
            return (this.zzc & 1048576) != 0;
        }

        public final int zzak() {
            return this.zzaa;
        }

        public final String zzal() {
            return this.zzab;
        }

        public final String zzam() {
            return this.zzac;
        }

        public final boolean zzan() {
            return (this.zzc & 8388608) != 0;
        }

        public final boolean zzao() {
            return this.zzad;
        }

        public final List<zza> zzap() {
            return this.zzae;
        }

        public final String zzaq() {
            return this.zzaf;
        }

        public final boolean zzar() {
            return (this.zzc & 33554432) != 0;
        }

        public final int zzas() {
            return this.zzag;
        }

        public final String zzat() {
            return this.zzaj;
        }

        public final boolean zzau() {
            return (this.zzc & 536870912) != 0;
        }

        public final long zzav() {
            return this.zzak;
        }

        public final boolean zzaw() {
            return (this.zzc & 1073741824) != 0;
        }

        public final long zzax() {
            return this.zzal;
        }

        public final String zzay() {
            return this.zzam;
        }

        public final boolean zzaz() {
            return (this.zzd & 2) != 0;
        }

        public final int zzb() {
            return this.zze;
        }

        public final int zzba() {
            return this.zzao;
        }

        public final String zzbb() {
            return this.zzap;
        }

        public final boolean zzbc() {
            return (this.zzd & 16) != 0;
        }

        public final long zzbd() {
            return this.zzas;
        }

        public final String zzbe() {
            return this.zzau;
        }

        public final boolean zzbf() {
            return (this.zzd & 128) != 0;
        }

        public final String zzbg() {
            return this.zzav;
        }

        public final List<zzc> zzc() {
            return this.zzf;
        }

        public final int zzd() {
            return this.zzf.size();
        }

        public final List<zzk> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzg.size();
        }

        public final boolean zzg() {
            return (this.zzc & 2) != 0;
        }

        public final long zzh() {
            return this.zzh;
        }

        public final boolean zzi() {
            return (this.zzc & 4) != 0;
        }

        public final long zzj() {
            return this.zzi;
        }

        public final boolean zzk() {
            return (this.zzc & 8) != 0;
        }

        public final long zzl() {
            return this.zzj;
        }

        public final boolean zzm() {
            return (this.zzc & 16) != 0;
        }

        public final long zzn() {
            return this.zzk;
        }

        public final boolean zzo() {
            return (this.zzc & 32) != 0;
        }

        public final long zzp() {
            return this.zzl;
        }

        public final String zzq() {
            return this.zzm;
        }

        public final String zzr() {
            return this.zzn;
        }

        public final String zzs() {
            return this.zzo;
        }

        public final String zzt() {
            return this.zzp;
        }

        public final boolean zzu() {
            return (this.zzc & 1024) != 0;
        }

        public final int zzv() {
            return this.zzq;
        }

        public final String zzw() {
            return this.zzr;
        }

        public final String zzx() {
            return this.zzs;
        }

        public final String zzy() {
            return this.zzt;
        }

        public final boolean zzz() {
            return (this.zzc & 16384) != 0;
        }

        public final zzc zza(int i) {
            return this.zzf.get(i);
        }

        public final zzk zzb(int i) {
            return this.zzg.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzax, "\u0001-\u0000\u0002\u00015-\u0000\u0004\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", zzk.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", zza.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzaw", zzce.zzb()});
                case 4:
                    return zzax;
                case 5:
                    zzju<zzg> zzju = zzay;
                    if (zzju == null) {
                        synchronized (zzg.class) {
                            zzju = zzay;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzax);
                                zzay = zzju;
                            }
                        }
                    }
                    return zzju;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zzh extends zzhz<zzh, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzh zzf;
        private static volatile zzju<zzh> zzg;
        private int zzc;
        private int zzd = 1;
        private zzii<zzd> zze = zzhz.zzbr();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzh, zza> implements zzjj {
            private zza() {
                super(zzh.zzf);
            }

            public final zza zza(zzd.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzh) this.zza).m10250e((zzd) ((zzhz) zza.zzz()));
                return this;
            }

            /* synthetic */ zza(C2852r0 r0Var) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public enum zzb implements zzib {
            RADS(1),
            PROVISIONING(2);
            

            /* renamed from: a */
            private final int f17582a;

            private zzb(int i) {
                this.f17582a = i;
            }

            public static zzid zzb() {
                return C2868t0.f17469a;
            }

            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17582a + " name=" + name() + '>';
            }

            public final int zza() {
                return this.f17582a;
            }

            public static zzb zza(int i) {
                if (i == 1) {
                    return RADS;
                }
                if (i != 2) {
                    return null;
                }
                return PROVISIONING;
            }
        }

        static {
            zzh zzh = new zzh();
            zzf = zzh;
            zzhz.zza(zzh.class, zzh);
        }

        private zzh() {
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public final void m10250e(zzd zzd2) {
            zzd2.getClass();
            zzii<zzd> zzii = this.zze;
            if (!zzii.zza()) {
                this.zze = zzhz.zza(zzii);
            }
            this.zze.add(zzd2);
        }

        public static zza zza() {
            return (zza) zzf.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", zzd.class});
                case 4:
                    return zzf;
                case 5:
                    zzju<zzh> zzju = zzg;
                    if (zzju == null) {
                        synchronized (zzh.class) {
                            zzju = zzg;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzf);
                                zzg = zzju;
                            }
                        }
                    }
                    return zzju;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zzi extends zzhz<zzi, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzi zzg;
        private static volatile zzju<zzi> zzh;
        private zzif zzc = zzhz.zzbq();
        private zzif zzd = zzhz.zzbq();
        private zzii<zzb> zze = zzhz.zzbr();
        private zzii<zzj> zzf = zzhz.zzbr();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzi, zza> implements zzjj {
            private zza() {
                super(zzi.zzg);
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).m10256h(iterable);
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).m10260l(iterable);
                return this;
            }

            public final zza zzc(Iterable<? extends zzb> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).m10262n(iterable);
                return this;
            }

            public final zza zzd(Iterable<? extends zzj> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).m10265q(iterable);
                return this;
            }

            /* synthetic */ zza(C2852r0 r0Var) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).m10268t();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).m10269u();
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).m10263o(i);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).m10266r(i);
                return this;
            }
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzhz.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public final void m10256h(Iterable<? extends Long> iterable) {
            zzif zzif = this.zzc;
            if (!zzif.zza()) {
                this.zzc = zzhz.zza(zzif);
            }
            zzgh.zza(iterable, this.zzc);
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public final void m10260l(Iterable<? extends Long> iterable) {
            zzif zzif = this.zzd;
            if (!zzif.zza()) {
                this.zzd = zzhz.zza(zzif);
            }
            zzgh.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public final void m10262n(Iterable<? extends zzb> iterable) {
            m10270v();
            zzgh.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        /* renamed from: o */
        public final void m10263o(int i) {
            m10270v();
            this.zze.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: q */
        public final void m10265q(Iterable<? extends zzj> iterable) {
            m10271w();
            zzgh.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        /* renamed from: r */
        public final void m10266r(int i) {
            m10271w();
            this.zzf.remove(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: t */
        public final void m10268t() {
            this.zzc = zzhz.zzbq();
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public final void m10269u() {
            this.zzd = zzhz.zzbq();
        }

        /* renamed from: v */
        private final void m10270v() {
            zzii<zzb> zzii = this.zze;
            if (!zzii.zza()) {
                this.zze = zzhz.zza(zzii);
            }
        }

        /* renamed from: w */
        private final void m10271w() {
            zzii<zzj> zzii = this.zzf;
            if (!zzii.zza()) {
                this.zzf = zzhz.zza(zzii);
            }
        }

        public static zza zzi() {
            return (zza) zzg.zzbm();
        }

        public static zzi zzj() {
            return zzg;
        }

        public final List<Long> zza() {
            return this.zzc;
        }

        public final int zzb() {
            return this.zzc.size();
        }

        public final List<Long> zzc() {
            return this.zzd;
        }

        public final int zzd() {
            return this.zzd.size();
        }

        public final List<zzb> zze() {
            return this.zze;
        }

        public final int zzf() {
            return this.zze.size();
        }

        public final List<zzj> zzg() {
            return this.zzf;
        }

        public final int zzh() {
            return this.zzf.size();
        }

        public final zzb zza(int i) {
            return this.zze.get(i);
        }

        public final zzj zzb(int i) {
            return this.zzf.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", zzb.class, "zzf", zzj.class});
                case 4:
                    return zzg;
                case 5:
                    zzju<zzi> zzju = zzh;
                    if (zzju == null) {
                        synchronized (zzi.class) {
                            zzju = zzh;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzg);
                                zzh = zzju;
                            }
                        }
                    }
                    return zzju;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zzj extends zzhz<zzj, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzj zzf;
        private static volatile zzju<zzj> zzg;
        private int zzc;
        private int zzd;
        private zzif zze = zzhz.zzbq();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzj, zza> implements zzjj {
            private zza() {
                super(zzj.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzj) this.zza).m10275h(i);
                return this;
            }

            /* synthetic */ zza(C2852r0 r0Var) {
                this();
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzj) this.zza).m10274g(iterable);
                return this;
            }
        }

        static {
            zzj zzj = new zzj();
            zzf = zzj;
            zzhz.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public final void m10274g(Iterable<? extends Long> iterable) {
            zzif zzif = this.zze;
            if (!zzif.zza()) {
                this.zze = zzhz.zza(zzif);
            }
            zzgh.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public final void m10275h(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public static zza zze() {
            return (zza) zzf.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<Long> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final long zza(int i) {
            return this.zze.zzb(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzju<zzj> zzju = zzg;
                    if (zzju == null) {
                        synchronized (zzj.class) {
                            zzju = zzg;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzf);
                                zzg = zzju;
                            }
                        }
                    }
                    return zzju;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zzk extends zzhz<zzk, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzk zzj;
        private static volatile zzju<zzk> zzk;
        private int zzc;
        private long zzd;
        private String zze = "";
        private String zzf = "";
        private long zzg;
        private float zzh;
        private double zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzk, zza> implements zzjj {
            private zza() {
                super(zzk.zzj);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).m10278f(j);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).m10288p(str);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).m10293u();
                return this;
            }

            /* synthetic */ zza(C2852r0 r0Var) {
                this();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).m10283k(str);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).m10284l(j);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).m10291s();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).m10292t();
                return this;
            }

            public final zza zza(double d) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).m10277e(d);
                return this;
            }
        }

        static {
            zzk zzk2 = new zzk();
            zzj = zzk2;
            zzhz.zza(zzk.class, zzk2);
        }

        private zzk() {
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public final void m10277e(double d) {
            this.zzc |= 32;
            this.zzi = d;
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public final void m10278f(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public final void m10283k(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public final void m10284l(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: p */
        public final void m10288p(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: s */
        public final void m10291s() {
            this.zzc &= -5;
            this.zzf = zzj.zzf;
        }

        /* access modifiers changed from: private */
        /* renamed from: t */
        public final void m10292t() {
            this.zzc &= -9;
            this.zzg = 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public final void m10293u() {
            this.zzc &= -33;
            this.zzi = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        public static zza zzj() {
            return (zza) zzj.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final String zze() {
            return this.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zzc & 32) != 0;
        }

        public final double zzi() {
            return this.zzi;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2852r0.f17433a[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((C2852r0) null);
                case 3:
                    return zzhz.zza((zzjh) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzju<zzk> zzju = zzk;
                    if (zzju == null) {
                        synchronized (zzk.class) {
                            zzju = zzk;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzj);
                                zzk = zzju;
                            }
                        }
                    }
                    return zzju;
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
