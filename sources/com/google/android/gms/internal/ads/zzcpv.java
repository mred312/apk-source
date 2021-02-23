package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcpv implements zzbrz, zzbtj {

    /* renamed from: b */
    private static final Object f14688b = new Object();

    /* renamed from: c */
    private static int f14689c;

    /* renamed from: a */
    private final zzcqe f14690a;

    public zzcpv(zzcqe zzcqe) {
        this.f14690a = zzcqe;
    }

    /* renamed from: a */
    private static boolean m8229a() {
        boolean z;
        synchronized (f14688b) {
            z = f14689c < ((Integer) zzwq.zzqe().zzd(zzabf.zzcwv)).intValue();
        }
        return z;
    }

    /* renamed from: b */
    private final void m8230b(boolean z) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue() && m8229a()) {
            this.f14690a.zzbj(z);
            synchronized (f14688b) {
                f14689c++;
            }
        }
    }

    public final void onAdLoaded() {
        m8230b(true);
    }

    public final void zzk(zzve zzve) {
        m8230b(false);
    }
}
