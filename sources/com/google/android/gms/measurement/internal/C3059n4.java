package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.n4 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
abstract class C3059n4 extends C3032k4 {

    /* renamed from: a */
    private boolean f18264a;

    C3059n4(zzfv zzfv) {
        super(zzfv);
        this.zzy.mo20350d(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo20065a() {
        return this.f18264a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g_ */
    public void mo20042g_() {
    }

    /* access modifiers changed from: protected */
    public final void zzaa() {
        if (!mo20065a()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzab() {
        if (this.f18264a) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzd()) {
            this.zzy.mo20354i();
            this.f18264a = true;
        }
    }

    public final void zzac() {
        if (!this.f18264a) {
            mo20042g_();
            this.zzy.mo20354i();
            this.f18264a = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzd();
}
