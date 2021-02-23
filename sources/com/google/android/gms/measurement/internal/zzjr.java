package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.measurement.internal.zzjv;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class zzjr<T extends Context & zzjv> {

    /* renamed from: a */
    private final T f18685a;

    public zzjr(T t) {
        Preconditions.checkNotNull(t);
        this.f18685a = t;
    }

    /* renamed from: c */
    private final void m10884c(Runnable runnable) {
        zzki zza = zzki.zza(this.f18685a);
        zza.zzp().zza((Runnable) new C2938a7(this, zza, runnable));
    }

    /* renamed from: d */
    private final zzer m10885d() {
        return zzfv.zza(this.f18685a, (zzae) null, (Long) null).zzq();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo20489a(int i, zzer zzer, Intent intent) {
        if (((zzjv) this.f18685a).zza(i)) {
            zzer.zzw().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            m10885d().zzw().zza("Completed wakeful intent.");
            ((zzjv) this.f18685a).zza(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo20490b(zzer zzer, JobParameters jobParameters) {
        zzer.zzw().zza("AppMeasurementJobService processed last upload request.");
        ((zzjv) this.f18685a).zza(jobParameters, false);
    }

    @MainThread
    public final void zza() {
        zzfv.zza(this.f18685a, (zzae) null, (Long) null).zzq().zzw().zza("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void zzb() {
        zzfv.zza(this.f18685a, (zzae) null, (Long) null).zzq().zzw().zza("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final void zzc(Intent intent) {
        if (intent == null) {
            m10885d().zze().zza("onRebind called with null intent");
            return;
        }
        m10885d().zzw().zza("onRebind called. action", intent.getAction());
    }

    @MainThread
    public final int zza(Intent intent, int i, int i2) {
        zzer zzq = zzfv.zza(this.f18685a, (zzae) null, (Long) null).zzq();
        if (intent == null) {
            zzq.zzh().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzq.zzw().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            m10884c(new C3169z6(this, i2, zzq, intent));
        }
        return 2;
    }

    @MainThread
    public final boolean zzb(Intent intent) {
        if (intent == null) {
            m10885d().zze().zza("onUnbind called with null intent");
            return true;
        }
        m10885d().zzw().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    @MainThread
    public final IBinder zza(Intent intent) {
        if (intent == null) {
            m10885d().zze().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzfw(zzki.zza(this.f18685a));
        }
        m10885d().zzh().zza("onBind received unknown action", action);
        return null;
    }

    @TargetApi(24)
    @MainThread
    public final boolean zza(JobParameters jobParameters) {
        zzer zzq = zzfv.zza(this.f18685a, (zzae) null, (Long) null).zzq();
        String string = jobParameters.getExtras().getString("action");
        zzq.zzw().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        m10884c(new C2948b7(this, zzq, jobParameters));
        return true;
    }
}
