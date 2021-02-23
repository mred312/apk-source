package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzedi extends zzekh<zzedi, zza> implements zzelu {
    private static volatile zzemb<zzedi> zzei;
    /* access modifiers changed from: private */
    public static final zzedi zzibj;
    private int zziaz;
    private zzedm zzibh;
    private zzefc zzibi;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza extends zzekh.zza<zzedi, zza> implements zzelu {
        private zza() {
            super(zzedi.zzibj);
        }

        public final zza zzc(zzedm zzedm) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedi) this.zzinm).m8653m(zzedm);
            return this;
        }

        public final zza zzew(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedi) this.zzinm).m8649i(i);
            return this;
        }

        /* synthetic */ zza(e60 e60) {
            this();
        }

        public final zza zzc(zzefc zzefc) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedi) this.zzinm).m8654n(zzefc);
            return this;
        }
    }

    static {
        zzedi zzedi = new zzedi();
        zzibj = zzedi;
        zzekh.zza(zzedi.class, zzedi);
    }

    private zzedi() {
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m8649i(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m8653m(zzedm zzedm) {
        zzedm.getClass();
        this.zzibh = zzedm;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public final void m8654n(zzefc zzefc) {
        zzefc.getClass();
        this.zzibi = zzefc;
    }

    public static zza zzbaw() {
        return (zza) zzibj.zzbhx();
    }

    public static zzedi zze(zzeiu zzeiu, zzeju zzeju) {
        return (zzedi) zzekh.zza(zzibj, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (e60.f8319a[i - 1]) {
            case 1:
                return new zzedi();
            case 2:
                return new zza((e60) null);
            case 3:
                return zzekh.zza((zzels) zzibj, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zziaz", "zzibh", "zzibi"});
            case 4:
                return zzibj;
            case 5:
                zzemb<zzedi> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedi.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibj);
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

    public final zzedm zzbau() {
        zzedm zzedm = this.zzibh;
        return zzedm == null ? zzedm.zzbbd() : zzedm;
    }

    public final zzefc zzbav() {
        zzefc zzefc = this.zzibi;
        return zzefc == null ? zzefc.zzbcy() : zzefc;
    }
}
