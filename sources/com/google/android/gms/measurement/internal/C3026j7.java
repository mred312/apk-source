package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzmu;

/* renamed from: com.google.android.gms.measurement.internal.j7 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3026j7 {

    /* renamed from: a */
    final /* synthetic */ zzju f18187a;

    C3026j7(zzju zzju) {
        this.f18187a = zzju;
    }

    @WorkerThread
    @VisibleForTesting
    /* renamed from: c */
    private final void m10595c(long j, boolean z) {
        this.f18187a.zzc();
        if (this.f18187a.zzy.zzaa()) {
            this.f18187a.zzr().f18244t.zza(j);
            this.f18187a.zzq().zzw().zza("Session started, time", Long.valueOf(this.f18187a.zzl().elapsedRealtime()));
            Long valueOf = Long.valueOf(j / 1000);
            this.f18187a.zze().mo20389m("auto", "_sid", valueOf, j);
            this.f18187a.zzr().f18241q.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.f18187a.zzs().zza(zzat.zzbj) && z) {
                bundle.putLong("_aib", 1);
            }
            this.f18187a.zze().mo20388k("auto", "_s", j, bundle);
            if (zzmu.zzb() && this.f18187a.zzs().zza(zzat.zzbo)) {
                String zza = this.f18187a.zzr().f18249y.zza();
                if (!TextUtils.isEmpty(zza)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", zza);
                    this.f18187a.zze().mo20388k("auto", "_ssr", j, bundle2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: a */
    public final void mo20010a() {
        this.f18187a.zzc();
        if (this.f18187a.zzr().mo20037c(this.f18187a.zzl().currentTimeMillis())) {
            this.f18187a.zzr().f18241q.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f18187a.zzq().zzw().zza("Detected application was in foreground");
                m10595c(this.f18187a.zzl().currentTimeMillis(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: b */
    public final void mo20011b(long j, boolean z) {
        this.f18187a.zzc();
        this.f18187a.zzaa();
        if (this.f18187a.zzr().mo20037c(j)) {
            this.f18187a.zzr().f18241q.zza(true);
        }
        this.f18187a.zzr().f18244t.zza(j);
        if (this.f18187a.zzr().f18241q.zza()) {
            m10595c(j, z);
        }
    }
}
