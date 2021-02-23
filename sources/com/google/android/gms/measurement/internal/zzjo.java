package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzmj;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class zzjo extends C3071o7 {

    /* renamed from: b */
    private String f18682b;

    /* renamed from: c */
    private boolean f18683c;

    /* renamed from: d */
    private long f18684d;

    zzjo(zzki zzki) {
        super(zzki);
    }

    @WorkerThread
    @NonNull
    @Deprecated
    /* renamed from: c */
    private final Pair<String, Boolean> m10881c(String str) {
        zzc();
        long elapsedRealtime = zzl().elapsedRealtime();
        if (this.f18682b != null && elapsedRealtime < this.f18684d) {
            return new Pair<>(this.f18682b, Boolean.valueOf(this.f18683c));
        }
        this.f18684d = elapsedRealtime + zzs().mo20603e(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzm());
            if (advertisingIdInfo != null) {
                this.f18682b = advertisingIdInfo.getId();
                this.f18683c = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.f18682b == null) {
                this.f18682b = "";
            }
        } catch (Exception e) {
            zzq().zzv().zza("Unable to get advertising id", e);
            this.f18682b = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.f18682b, Boolean.valueOf(this.f18683c));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    /* renamed from: b */
    public final Pair<String, Boolean> mo20487b(String str, zzad zzad) {
        if (!zzmj.zzb() || !zzs().zza(zzat.zzci) || zzad.zzc()) {
            return m10881c(str);
        }
        return new Pair<>("", Boolean.FALSE);
    }

    /* renamed from: f_ */
    public final /* bridge */ /* synthetic */ zzks mo20059f_() {
        return super.mo20059f_();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @Deprecated
    public final String zza(String str) {
        zzc();
        String str2 = (String) m10881c(str).first;
        MessageDigest X = zzkw.m10998X();
        if (X == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, X.digest(str2.getBytes()))});
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
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
