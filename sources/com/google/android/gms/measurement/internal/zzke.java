package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzh;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class zzke extends C3071o7 {

    /* renamed from: b */
    private final AlarmManager f18688b = ((AlarmManager) zzm().getSystemService(NotificationCompat.CATEGORY_ALARM));

    /* renamed from: c */
    private final C2990g f18689c;

    /* renamed from: d */
    private Integer f18690d;

    protected zzke(zzki zzki) {
        super(zzki);
        this.f18689c = new C3062n7(this, zzki.mo20512V(), zzki);
    }

    @TargetApi(24)
    /* renamed from: b */
    private final void m10895b() {
        ((JobScheduler) zzm().getSystemService("jobscheduler")).cancel(m10896c());
    }

    /* renamed from: c */
    private final int m10896c() {
        if (this.f18690d == null) {
            String valueOf = String.valueOf(zzm().getPackageName());
            this.f18690d = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f18690d.intValue();
    }

    /* renamed from: d */
    private final PendingIntent m10897d() {
        Context zzm = zzm();
        return PendingIntent.getBroadcast(zzm, 0, new Intent().setClassName(zzm, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    /* renamed from: f_ */
    public final /* bridge */ /* synthetic */ zzks mo20059f_() {
        return super.mo20059f_();
    }

    public final void zza(long j) {
        zzaj();
        Context zzm = zzm();
        if (!zzfn.zza(zzm)) {
            zzq().zzv().zza("Receiver not registered/enabled");
        }
        if (!zzkw.m11005r(zzm, false)) {
            zzq().zzv().zza("Service not registered/enabled");
        }
        zze();
        zzq().zzw().zza("Scheduling upload, millis", Long.valueOf(j));
        long elapsedRealtime = zzl().elapsedRealtime() + j;
        if (j < Math.max(0, zzat.zzw.zza(null).longValue()) && !this.f18689c.mo19914d()) {
            this.f18689c.mo19913c(j);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Context zzm2 = zzm();
            ComponentName componentName = new ComponentName(zzm2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int c = m10896c();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            zzh.zza(zzm2, new JobInfo.Builder(c, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        this.f18688b.setInexactRepeating(2, elapsedRealtime, Math.max(zzat.zzr.zza(null).longValue(), j), m10897d());
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        this.f18688b.cancel(m10897d());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        m10895b();
        return false;
    }

    public final void zze() {
        zzaj();
        zzq().zzw().zza("Unscheduling upload");
        this.f18688b.cancel(m10897d());
        this.f18689c.mo19915e();
        if (Build.VERSION.SDK_INT >= 24) {
            m10895b();
        }
    }

    public final /* bridge */ /* synthetic */ zzjo zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ C2939a8 zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ C2950c zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfp zzj() {
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

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
