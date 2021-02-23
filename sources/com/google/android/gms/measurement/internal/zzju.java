package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzq;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzju extends C3130v3 {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f18686b;

    /* renamed from: c */
    private final C2988f7 f18687c = new C2988f7(this);
    protected final C3026j7 zza = new C3026j7(this);
    protected final C3008h7 zzb = new C3008h7(this);

    zzju(zzfv zzfv) {
        super(zzfv);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: f */
    public final void m10891f(long j) {
        zzc();
        zzaa();
        zzq().zzw().zza("Activity resumed, time", Long.valueOf(j));
        if (zzs().zza(zzat.zzbu)) {
            if (zzs().zzh().booleanValue() || zzr().f18246v.zza()) {
                this.zzb.mo19929b(j);
            }
            this.f18687c.mo19910a();
        } else {
            this.f18687c.mo19910a();
            if (zzs().zzh().booleanValue()) {
                this.zzb.mo19929b(j);
            }
        }
        C3026j7 j7Var = this.zza;
        j7Var.f18187a.zzc();
        if (j7Var.f18187a.zzy.zzaa()) {
            if (!j7Var.f18187a.zzs().zza(zzat.zzbu)) {
                j7Var.f18187a.zzr().f18246v.zza(false);
            }
            j7Var.mo20011b(j7Var.f18187a.zzl().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: h */
    public final void m10893h(long j) {
        zzc();
        zzaa();
        zzq().zzw().zza("Activity paused, time", Long.valueOf(j));
        this.f18687c.mo19911b(j);
        if (zzs().zzh().booleanValue()) {
            this.zzb.mo19932f(j);
        }
        C3026j7 j7Var = this.zza;
        if (!j7Var.f18187a.zzs().zza(zzat.zzbu)) {
            j7Var.f18187a.zzr().f18246v.zza(true);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzaa() {
        zzc();
        if (this.f18686b == null) {
            this.f18686b = new zzq(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final long mo20498b(long j) {
        return this.zzb.mo19933g(j);
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        return this.zzb.mo19930d(z, z2, j);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzgy zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzek zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzio zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzij zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzen zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzju zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzep zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkw zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfo zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzer zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ C3049m3 zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    /* access modifiers changed from: protected */
    public final boolean zzy() {
        return false;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
