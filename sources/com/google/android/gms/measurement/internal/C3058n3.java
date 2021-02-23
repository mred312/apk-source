package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzna;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.measurement.internal.n3 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3058n3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzd f18261a;

    /* renamed from: b */
    private final /* synthetic */ ServiceConnection f18262b;

    /* renamed from: c */
    private final /* synthetic */ zzfl f18263c;

    C3058n3(zzfl zzfl, zzd zzd, ServiceConnection serviceConnection) {
        this.f18263c = zzfl;
        this.f18261a = zzd;
        this.f18262b = serviceConnection;
    }

    public final void run() {
        zzfl zzfl = this.f18263c;
        zzfi zzfi = zzfl.f18581b;
        String a = zzfl.f18580a;
        zzd zzd = this.f18261a;
        ServiceConnection serviceConnection = this.f18262b;
        Bundle a2 = zzfi.mo20323a(a, zzd);
        zzfi.f18575a.zzp().zzc();
        if (a2 != null) {
            long j = a2.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzfi.f18575a.zzq().zzh().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = a2.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfi.f18575a.zzq().zze().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfi.f18575a.zzq().zzw().zza("InstallReferrer API result", string);
                    zzkw zzh = zzfi.f18575a.zzh();
                    String valueOf = String.valueOf(string);
                    Bundle f = zzh.mo20567f(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (f == null) {
                        zzfi.f18575a.zzq().zze().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = f.getString(FirebaseAnalytics.Param.MEDIUM);
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = a2.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzfi.f18575a.zzq().zze().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                f.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzfi.f18575a.zzb().f18234j.zza()) {
                            zzfi.f18575a.zzq().zzw().zza("Install Referrer campaign has already been logged");
                        } else if (!zzna.zzb() || !zzfi.f18575a.zza().zza(zzat.zzbs) || zzfi.f18575a.zzaa()) {
                            zzfi.f18575a.zzb().f18234j.zza(j);
                            zzfi.f18575a.zzq().zzw().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            f.putString("_cis", "referrer API");
                            zzfi.f18575a.zzg().zza("auto", "_cmp", f);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzfi.f18575a.zzm(), serviceConnection);
        }
    }
}
