package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.o7 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
abstract class C3071o7 extends C3053m7 {

    /* renamed from: a */
    private boolean f18285a;

    C3071o7(zzki zzki) {
        super(zzki);
        this.zza.mo20517n(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo20081a() {
        return this.f18285a;
    }

    /* access modifiers changed from: protected */
    public final void zzaj() {
        if (!mo20081a()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzak() {
        if (!this.f18285a) {
            zzd();
            this.zza.mo20511U();
            this.f18285a = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzd();
}
