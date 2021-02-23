package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zza extends C3101s1 {

    /* renamed from: a */
    private final Map<String, Long> f18488a = new ArrayMap();

    /* renamed from: b */
    private final Map<String, Integer> f18489b = new ArrayMap();

    /* renamed from: c */
    private long f18490c;

    public zza(zzfv zzfv) {
        super(zzfv);
    }

    @WorkerThread
    /* renamed from: a */
    private final void m10640a(long j, zzig zzig) {
        if (zzig == null) {
            zzq().zzw().zza("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            zzq().zzw().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzij.zza(zzig, bundle, true);
            zze().zza("am", "_xa", bundle);
        }
    }

    @WorkerThread
    /* renamed from: d */
    private final void m10643d(String str, long j, zzig zzig) {
        if (zzig == null) {
            zzq().zzw().zza("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            zzq().zzw().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzij.zza(zzig, bundle, true);
            zze().zza("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: e */
    public final void m10644e(long j) {
        for (String put : this.f18488a.keySet()) {
            this.f18488a.put(put, Long.valueOf(j));
        }
        if (!this.f18488a.isEmpty()) {
            this.f18490c = j;
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: g */
    public final void m10646g(String str, long j) {
        zzc();
        Preconditions.checkNotEmpty(str);
        if (this.f18489b.isEmpty()) {
            this.f18490c = j;
        }
        Integer num = this.f18489b.get(str);
        if (num != null) {
            this.f18489b.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f18489b.size() >= 100) {
            zzq().zzh().zza("Too many ads visible");
        } else {
            this.f18489b.put(str, 1);
            this.f18488a.put(str, Long.valueOf(j));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: h */
    public final void m10647h(String str, long j) {
        zzc();
        Preconditions.checkNotEmpty(str);
        Integer num = this.f18489b.get(str);
        if (num != null) {
            zzig zza = zzh().zza(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f18489b.remove(str);
                Long l = this.f18488a.get(str);
                if (l == null) {
                    zzq().zze().zza("First ad unit exposure time was never set");
                } else {
                    this.f18488a.remove(str);
                    m10643d(str, j - l.longValue(), zza);
                }
                if (this.f18489b.isEmpty()) {
                    long j2 = this.f18490c;
                    if (j2 == 0) {
                        zzq().zze().zza("First ad exposure time was never set");
                        return;
                    }
                    m10640a(j - j2, zza);
                    this.f18490c = 0;
                    return;
                }
                return;
            }
            this.f18489b.put(str, Integer.valueOf(intValue));
            return;
        }
        zzq().zze().zza("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            zzq().zze().zza("Ad unit id must be a non-empty string");
        } else {
            zzp().zza((Runnable) new C3091r0(this, str, j));
        }
    }

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            zzq().zze().zza("Ad unit id must be a non-empty string");
        } else {
            zzp().zza((Runnable) new C3081q(this, str, j));
        }
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

    @WorkerThread
    public final void zza(long j) {
        zzig zza = zzh().zza(false);
        for (String next : this.f18488a.keySet()) {
            m10643d(next, j - this.f18488a.get(next).longValue(), zza);
        }
        if (!this.f18488a.isEmpty()) {
            m10640a(j - this.f18490c, zza);
        }
        m10644e(j);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
