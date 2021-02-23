package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zznh;
import com.google.android.gms.internal.measurement.zznm;

/* renamed from: com.google.android.gms.measurement.internal.h7 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3008h7 {
    @VisibleForTesting

    /* renamed from: a */
    private long f18121a;
    @VisibleForTesting

    /* renamed from: b */
    private long f18122b;

    /* renamed from: c */
    private final C2990g f18123c;

    /* renamed from: d */
    private final /* synthetic */ zzju f18124d;

    public C3008h7(zzju zzju) {
        this.f18124d = zzju;
        this.f18123c = new C3035k7(this, zzju.zzy);
        long elapsedRealtime = zzju.zzl().elapsedRealtime();
        this.f18121a = elapsedRealtime;
        this.f18122b = elapsedRealtime;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: h */
    public final void m10523h() {
        this.f18124d.zzc();
        mo19930d(false, false, this.f18124d.zzl().elapsedRealtime());
        this.f18124d.zzd().zza(this.f18124d.zzl().elapsedRealtime());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19928a() {
        this.f18123c.mo19915e();
        this.f18121a = 0;
        this.f18122b = 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: b */
    public final void mo19929b(long j) {
        this.f18124d.zzc();
        this.f18123c.mo19915e();
        this.f18121a = j;
        this.f18122b = j;
    }

    @WorkerThread
    /* renamed from: d */
    public final boolean mo19930d(boolean z, boolean z2, long j) {
        this.f18124d.zzc();
        this.f18124d.zzv();
        if (!zznh.zzb() || !this.f18124d.zzs().zza(zzat.zzbp) || this.f18124d.zzy.zzaa()) {
            this.f18124d.zzr().f18244t.zza(this.f18124d.zzl().currentTimeMillis());
        }
        long j2 = j - this.f18121a;
        if (z || j2 >= 1000) {
            if (this.f18124d.zzs().zza(zzat.zzas) && !z2) {
                j2 = (!zznm.zzb() || !this.f18124d.zzs().zza(zzat.zzau)) ? mo19931e() : mo19933g(j);
            }
            this.f18124d.zzq().zzw().zza("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzij.zza(this.f18124d.zzh().zza(!this.f18124d.zzs().zzh().booleanValue()), bundle, true);
            if (this.f18124d.zzs().zza(zzat.zzas) && !this.f18124d.zzs().zza(zzat.zzat) && z2) {
                bundle.putLong("_fr", 1);
            }
            if (!this.f18124d.zzs().zza(zzat.zzat) || !z2) {
                this.f18124d.zze().zza("auto", "_e", bundle);
            }
            this.f18121a = j;
            this.f18123c.mo19915e();
            this.f18123c.mo19913c(3600000);
            return true;
        }
        this.f18124d.zzq().zzw().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    /* renamed from: e */
    public final long mo19931e() {
        long elapsedRealtime = this.f18124d.zzl().elapsedRealtime();
        long j = elapsedRealtime - this.f18122b;
        this.f18122b = elapsedRealtime;
        return j;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: f */
    public final void mo19932f(long j) {
        this.f18123c.mo19915e();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    /* renamed from: g */
    public final long mo19933g(long j) {
        long j2 = j - this.f18122b;
        this.f18122b = j;
        return j2;
    }
}
