package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzalo extends zzazx<zzalz> {

    /* renamed from: c */
    private final Object f12511c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzals f12512d;

    /* renamed from: e */
    private boolean f12513e;

    public zzalo(zzals zzals) {
        this.f12512d = zzals;
    }

    public final void release() {
        synchronized (this.f12511c) {
            if (!this.f12513e) {
                this.f12513e = true;
                zza(new C1864e2(this), new zzazv());
                zza(new C1827d2(this), new C1901f2(this));
            }
        }
    }
}
