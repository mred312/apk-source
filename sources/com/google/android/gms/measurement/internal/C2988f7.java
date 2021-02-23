package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

/* renamed from: com.google.android.gms.measurement.internal.f7 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2988f7 {

    /* renamed from: a */
    private C2978e7 f18062a;

    /* renamed from: b */
    final /* synthetic */ zzju f18063b;

    C2988f7(zzju zzju) {
        this.f18063b = zzju;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: a */
    public final void mo19910a() {
        this.f18063b.zzc();
        if (this.f18062a != null) {
            this.f18063b.f18686b.removeCallbacks(this.f18062a);
        }
        if (this.f18063b.zzs().zza(zzat.zzbu)) {
            this.f18063b.zzr().f18246v.zza(false);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: b */
    public final void mo19911b(long j) {
        this.f18062a = new C2978e7(this, this.f18063b.zzl().currentTimeMillis(), j);
        this.f18063b.f18686b.postDelayed(this.f18062a, 2000);
    }
}
