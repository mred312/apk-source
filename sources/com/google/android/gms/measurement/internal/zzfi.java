package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzd;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzfi {

    /* renamed from: a */
    final zzfv f18575a;

    zzfi(zzfv zzfv) {
        this.f18575a = zzfv;
    }

    @VisibleForTesting
    /* renamed from: b */
    private final boolean m10784b() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.f18575a.zzm());
            if (packageManager == null) {
                this.f18575a.zzq().zzw().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            this.f18575a.zzq().zzw().zza("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @Nullable
    @VisibleForTesting
    /* renamed from: a */
    public final Bundle mo20323a(String str, zzd zzd) {
        this.f18575a.zzp().zzc();
        if (zzd == null) {
            this.f18575a.zzq().zzh().zza("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle zza = zzd.zza(bundle);
            if (zza != null) {
                return zza;
            }
            this.f18575a.zzq().zze().zza("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.f18575a.zzq().zze().zza("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(String str) {
        if (str == null || str.isEmpty()) {
            this.f18575a.zzq().zzi().zza("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.f18575a.zzp().zzc();
        if (!m10784b()) {
            this.f18575a.zzq().zzu().zza("Install Referrer Reporter is not available");
            return;
        }
        zzfl zzfl = new zzfl(this, str);
        this.f18575a.zzp().zzc();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f18575a.zzm().getPackageManager();
        if (packageManager == null) {
            this.f18575a.zzq().zzi().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.f18575a.zzq().zzu().zza("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (serviceInfo.name == null || !"com.android.vending".equals(str2) || !m10784b()) {
                this.f18575a.zzq().zzh().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            try {
                this.f18575a.zzq().zzw().zza("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.f18575a.zzm(), new Intent(intent), zzfl, 1) ? "available" : "not available");
            } catch (Exception e) {
                this.f18575a.zzq().zze().zza("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }
}
