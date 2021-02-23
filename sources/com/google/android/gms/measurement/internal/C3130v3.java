package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.v3 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
abstract class C3130v3 extends C3101s1 {

    /* renamed from: a */
    private boolean f18406a;

    C3130v3(zzfv zzfv) {
        super(zzfv);
        this.zzy.mo20349b(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo20123a() {
        return this.f18406a;
    }

    /* access modifiers changed from: protected */
    public final void zzv() {
        if (!mo20123a()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzw() {
        if (this.f18406a) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzy()) {
            this.zzy.mo20354i();
            this.f18406a = true;
        }
    }

    public final void zzx() {
        if (!this.f18406a) {
            zzz();
            this.zzy.mo20354i();
            this.f18406a = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzy();

    /* access modifiers changed from: protected */
    public void zzz() {
    }
}
