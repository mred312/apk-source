package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzjr;
import com.google.android.gms.measurement.internal.zzjv;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class AppMeasurementJobService extends JobService implements zzjv {

    /* renamed from: a */
    private zzjr<AppMeasurementJobService> f17921a;

    /* renamed from: a */
    private final zzjr<AppMeasurementJobService> m10413a() {
        if (this.f17921a == null) {
            this.f17921a = new zzjr<>(this);
        }
        return this.f17921a;
    }

    @MainThread
    public final void onCreate() {
        super.onCreate();
        m10413a().zza();
    }

    @MainThread
    public final void onDestroy() {
        m10413a().zzb();
        super.onDestroy();
    }

    @MainThread
    public final void onRebind(Intent intent) {
        m10413a().zzc(intent);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return m10413a().zza(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return m10413a().zzb(intent);
    }

    public final void zza(Intent intent) {
    }

    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
