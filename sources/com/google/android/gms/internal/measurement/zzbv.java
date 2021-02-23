package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhz;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class zzbv {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zza extends zzhz<zza, C3996zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zza zzi;
        private static volatile zzju<zza> zzj;
        private int zzc;
        private int zzd;
        private zzii<zze> zze = zzhz.zzbr();
        private zzii<zzb> zzf = zzhz.zzbr();
        private boolean zzg;
        private boolean zzh;

        /* renamed from: com.google.android.gms.internal.measurement.zzbv$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class C3996zza extends zzhz.zza<zza, C3996zza> implements zzjj {
            private C3996zza() {
                super(zza.zzi);
            }

            public final int zza() {
                return ((zza) this.zza).zzd();
            }

            public final int zzb() {
                return ((zza) this.zza).zzf();
            }

            /* synthetic */ C3996zza(C2820n0 n0Var) {
                this();
            }

            public final zze zza(int i) {
                return ((zza) this.zza).zza(i);
            }

            public final zzb zzb(int i) {
                return ((zza) this.zza).zzb(i);
            }

            public final C3996zza zza(int i, zze.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).m10044f(i, (zze) ((zzhz) zza.zzz()));
                return this;
            }

            public final C3996zza zza(int i, zzb.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).m10043e(i, (zzb) ((zzhz) zza.zzz()));
                return this;
            }
        }

        static {
            zza zza = new zza();
            zzi = zza;
            zzhz.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public final void m10043e(int i, zzb zzb) {
            zzb.getClass();
            zzii<zzb> zzii = this.zzf;
            if (!zzii.zza()) {
                this.zzf = zzhz.zza(zzii);
            }
            this.zzf.set(i, zzb);
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public final void m10044f(int i, zze zze2) {
            zze2.getClass();
            zzii<zze> zzii = this.zze;
            if (!zzii.zza()) {
                this.zze = zzhz.zza(zzii);
            }
            this.zze.set(i, zze2);
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<zze> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final List<zzb> zze() {
            return this.zzf;
        }

        public final int zzf() {
            return this.zzf.size();
        }

        public final zze zza(int i) {
            return this.zze.get(i);
        }

        public final zzb zzb(int i) {
            return this.zzf.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2820n0.f17386a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3996zza((C2820n0) null);
                case 3:
                    return zzhz.zza((zzjh) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", zze.class, "zzf", zzb.class, "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzju<zza> zzju = zzj;
                    if (zzju == null) {
                        synchronized (zza.class) {
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
    public static final class zzb extends zzhz<zzb, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzb zzl;
        private static volatile zzju<zzb> zzm;
        private int zzc;
        private int zzd;
        private String zze = "";
        private zzii<zzc> zzf = zzhz.zzbr();
        private boolean zzg;
        private zzd zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzb, zza> implements zzjj {
            private zza() {
                super(zzb.zzl);
            }

            public final String zza() {
                return ((zzb) this.zza).zzc();
            }

            public final int zzb() {
                return ((zzb) this.zza).zze();
            }

            /* synthetic */ zza(C2820n0 n0Var) {
                this();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).m10051h(str);
                return this;
            }

            public final zzc zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zzc zzc) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).m10048e(i, zzc);
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zzl = zzb;
            zzhz.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public final void m10048e(int i, zzc zzc2) {
            zzc2.getClass();
            zzii<zzc> zzii = this.zzf;
            if (!zzii.zza()) {
                this.zzf = zzhz.zza(zzii);
            }
            this.zzf.set(i, zzc2);
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public final void m10051h(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public static zza zzl() {
            return (zza) zzl.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final List<zzc> zzd() {
            return this.zzf;
        }

        public final int zze() {
            return this.zzf.size();
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final zzd zzg() {
            zzd zzd2 = this.zzh;
            return zzd2 == null ? zzd.zzk() : zzd2;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        public final boolean zzi() {
            return this.zzj;
        }

        public final boolean zzj() {
            return (this.zzc & 64) != 0;
        }

        public final boolean zzk() {
            return this.zzk;
        }

        public final zzc zza(int i) {
            return this.zzf.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2820n0.f17386a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((C2820n0) null);
                case 3:
                    return zzhz.zza((zzjh) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzju<zzb> zzju = zzm;
                    if (zzju == null) {
                        synchronized (zzb.class) {
                            zzju = zzm;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzl);
                                zzm = zzju;
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
        public static final zzc zzh;
        private static volatile zzju<zzc> zzi;
        private int zzc;
        private zzf zzd;
        private zzd zze;
        private boolean zzf;
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzc, zza> implements zzjj {
            private zza() {
                super(zzc.zzh);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).m10054f(str);
                return this;
            }

            /* synthetic */ zza(C2820n0 n0Var) {
                this();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzh = zzc2;
            zzhz.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public final void m10054f(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        public static zzc zzi() {
            return zzh;
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzf zzb() {
            zzf zzf2 = this.zzd;
            return zzf2 == null ? zzf.zzi() : zzf2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final zzd zzd() {
            zzd zzd2 = this.zze;
            return zzd2 == null ? zzd.zzk() : zzd2;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2820n0.f17386a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((C2820n0) null);
                case 3:
                    return zzhz.zza((zzjh) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzju<zzc> zzju = zzi;
                    if (zzju == null) {
                        synchronized (zzc.class) {
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
    public static final class zzd extends zzhz<zzd, zzb> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzd zzi;
        private static volatile zzju<zzd> zzj;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public enum zza implements zzib {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);
            

            /* renamed from: a */
            private final int f17576a;

            private zza(int i) {
                this.f17576a = i;
            }

            public static zzid zzb() {
                return C2828o0.f17396a;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17576a + " name=" + name() + '>';
            }

            public final int zza() {
                return this.f17576a;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i == 1) {
                    return LESS_THAN;
                }
                if (i == 2) {
                    return GREATER_THAN;
                }
                if (i == 3) {
                    return EQUAL;
                }
                if (i != 4) {
                    return null;
                }
                return BETWEEN;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zzb extends zzhz.zza<zzd, zzb> implements zzjj {
            private zzb() {
                super(zzd.zzi);
            }

            /* synthetic */ zzb(C2820n0 n0Var) {
                this();
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzi = zzd2;
            zzhz.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        public static zzd zzk() {
            return zzi;
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zza zzb() {
            zza zza2 = zza.zza(this.zzd);
            return zza2 == null ? zza.UNKNOWN_COMPARISON_TYPE : zza2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final boolean zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final String zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return (this.zzc & 16) != 0;
        }

        public final String zzj() {
            return this.zzh;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2820n0.f17386a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb((C2820n0) null);
                case 3:
                    return zzhz.zza((zzjh) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzju<zzd> zzju = zzj;
                    if (zzju == null) {
                        synchronized (zzd.class) {
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
    public static final class zze extends zzhz<zze, zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zze zzj;
        private static volatile zzju<zze> zzk;
        private int zzc;
        private int zzd;
        private String zze = "";
        private zzc zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;

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
                ((zze) this.zza).m10058f(str);
                return this;
            }

            /* synthetic */ zza(C2820n0 n0Var) {
                this();
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
        /* renamed from: f */
        public final void m10058f(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public static zza zzi() {
            return (zza) zzj.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final zzc zzd() {
            zzc zzc2 = this.zzf;
            return zzc2 == null ? zzc.zzi() : zzc2;
        }

        public final boolean zze() {
            return this.zzg;
        }

        public final boolean zzf() {
            return this.zzh;
        }

        public final boolean zzg() {
            return (this.zzc & 32) != 0;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2820n0.f17386a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((C2820n0) null);
                case 3:
                    return zzhz.zza((zzjh) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzju<zze> zzju = zzk;
                    if (zzju == null) {
                        synchronized (zze.class) {
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
        public static final zzf zzh;
        private static volatile zzju<zzf> zzi;
        private int zzc;
        private int zzd;
        private String zze = "";
        private boolean zzf;
        private zzii<String> zzg = zzhz.zzbr();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class zza extends zzhz.zza<zzf, zza> implements zzjj {
            private zza() {
                super(zzf.zzh);
            }

            /* synthetic */ zza(C2820n0 n0Var) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public enum zzb implements zzib {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);
            

            /* renamed from: a */
            private final int f17578a;

            private zzb(int i) {
                this.f17578a = i;
            }

            public static zzid zzb() {
                return C2836p0.f17403a;
            }

            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17578a + " name=" + name() + '>';
            }

            public final int zza() {
                return this.f17578a;
            }

            public static zzb zza(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzh = zzf2;
            zzhz.zza(zzf.class, zzf2);
        }

        private zzf() {
        }

        public static zzf zzi() {
            return zzh;
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzb zzb() {
            zzb zza2 = zzb.zza(this.zzd);
            return zza2 == null ? zzb.UNKNOWN_MATCH_TYPE : zza2;
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

        public final boolean zzf() {
            return this.zzf;
        }

        public final List<String> zzg() {
            return this.zzg;
        }

        public final int zzh() {
            return this.zzg.size();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2820n0.f17386a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((C2820n0) null);
                case 3:
                    return zzhz.zza((zzjh) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzju<zzf> zzju = zzi;
                    if (zzju == null) {
                        synchronized (zzf.class) {
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
}
