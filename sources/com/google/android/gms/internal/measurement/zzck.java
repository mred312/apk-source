package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhz;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class zzck {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
    public static final class zza extends zzhz<zza, C3999zza> implements zzjj {
        /* access modifiers changed from: private */
        public static final zza zzd;
        private static volatile zzju<zza> zze;
        private zzii<zzb> zzc = zzhz.zzbr();

        /* renamed from: com.google.android.gms.internal.measurement.zzck$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class C3999zza extends zzhz.zza<zza, C3999zza> implements zzjj {
            private C3999zza() {
                super(zza.zzd);
            }

            /* synthetic */ C3999zza(C2876u0 u0Var) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zzd = zza;
            zzhz.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (C2876u0.f17477a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3999zza((C2876u0) null);
                case 3:
                    return zzhz.zza((zzjh) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzb.class});
                case 4:
                    return zzd;
                case 5:
                    zzju<zza> zzju = zze;
                    if (zzju == null) {
                        synchronized (zza.class) {
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
    public static final class zzb extends zzhz<zzb, C4000zzb> implements zzjj {
        /* access modifiers changed from: private */
        public static final zzb zzk;
        private static volatile zzju<zzb> zzl;
        private int zzc;
        private int zzd;
        private String zze = "";
        private boolean zzf;
        private long zzg;
        private double zzh;
        private zzii<zzb> zzi = zzhz.zzbr();
        private String zzj = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public enum zza implements zzib {
            UNDEFINED(0),
            NULL(1),
            STRING(2),
            NUMBER(3),
            BOOLEAN(4),
            LIST(5),
            MAP(6),
            STATEMENT(7);
            

            /* renamed from: a */
            private final int f17600a;

            private zza(int i) {
                this.f17600a = i;
            }

            public static zzid zzb() {
                return C2884v0.f17490a;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17600a + " name=" + name() + '>';
            }

            public final int zza() {
                return this.f17600a;
            }

            public static zza zza(int i) {
                switch (i) {
                    case 0:
                        return UNDEFINED;
                    case 1:
                        return NULL;
                    case 2:
                        return STRING;
                    case 3:
                        return NUMBER;
                    case 4:
                        return BOOLEAN;
                    case 5:
                        return LIST;
                    case 6:
                        return MAP;
                    case 7:
                        return STATEMENT;
                    default:
                        return null;
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzck$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
        public static final class C4000zzb extends zzhz.zza<zzb, C4000zzb> implements zzjj {
            private C4000zzb() {
                super(zzb.zzk);
            }

            /* synthetic */ C4000zzb(C2876u0 u0Var) {
                this();
            }
        }

        static {
            zzb zzb = new zzb();
            zzk = zzb;
            zzhz.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            Class<zzb> cls = zzb.class;
            switch (C2876u0.f17477a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C4000zzb((C2876u0) null);
                case 3:
                    return zzhz.zza((zzjh) zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005က\u0004\u0006\u001b\u0007ဈ\u0005", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", cls, "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzju<zzb> zzju = zzl;
                    if (zzju == null) {
                        synchronized (cls) {
                            zzju = zzl;
                            if (zzju == null) {
                                zzju = new zzhz.zzc<>(zzk);
                                zzl = zzju;
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
