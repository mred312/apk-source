package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzjr;
import com.google.android.gms.measurement.internal.zzjv;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class AppMeasurementService extends Service implements zzjv {

    /* renamed from: a */
    private zzjr<AppMeasurementService> f17923a;

    /* renamed from: a */
    private final zzjr<AppMeasurementService> m10414a() {
        if (this.f17923a == null) {
            this.f17923a = new zzjr<>(this);
        }
        return this.f17923a;
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        return m10414a().zza(intent);
    }

    @MainThread
    public final void onCreate() {
        super.onCreate();
        m10414a().zza();
    }

    @MainThread
    public final void onDestroy() {
        m10414a().zzb();
        super.onDestroy();
    }

    @MainThread
    public final void onRebind(Intent intent) {
        m10414a().zzc(intent);
    }

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        return m10414a().zza(intent, i, i2);
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return m10414a().zzb(intent);
    }

    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zza(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
