package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.facebook.ads.AdError;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzmi;
import com.google.android.gms.internal.measurement.zzof;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzy extends C3032k4 {

    /* renamed from: a */
    private Boolean f18731a;
    @NonNull

    /* renamed from: b */
    private C2930a f18732b = C2940b.f17954a;

    /* renamed from: c */
    private Boolean f18733c;

    zzy(zzfv zzfv) {
        super(zzfv);
    }

    @WorkerThread
    /* renamed from: a */
    private final int m11042a(String str, @NonNull zzeg<Integer> zzeg, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzeg), i2), i);
    }

    @Nullable
    @VisibleForTesting
    /* renamed from: k */
    private final Bundle m11043k() {
        try {
            if (zzm().getPackageManager() == null) {
                zzq().zze().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzm()).getApplicationInfo(zzm().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzq().zze().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zzq().zze().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public static long zzi() {
        return zzat.zzac.zza(null).longValue();
    }

    public static long zzj() {
        return zzat.zzc.zza(null).longValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo20600b(@NonNull C2930a aVar) {
        this.f18732b = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo20601c(@Size(min = 1) String str) {
        if (!zzmi.zzb() || !zzd((String) null, zzat.zzbv)) {
            return 500;
        }
        return m11042a(str, zzat.zzag, 500, AdError.SERVER_ERROR_CODE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final int mo20602d(@Size(min = 1) String str) {
        if (!zzmi.zzb() || !zzd((String) null, zzat.zzbv)) {
            return 25;
        }
        return m11042a(str, zzat.zzaf, 25, 100);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: e */
    public final long mo20603e(String str) {
        return zza(str, zzat.zza);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @VisibleForTesting
    /* renamed from: f */
    public final Boolean mo20604f(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle k = m11043k();
        if (k == null) {
            zzq().zze().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!k.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(k.getBoolean(str));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b A[SYNTHETIC, Splitter:B:9:0x002b] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.util.VisibleForTesting
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> mo20605g(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.m11043k()
            r1 = 0
            if (r0 != 0) goto L_0x0019
            com.google.android.gms.measurement.internal.zzer r4 = r3.zzq()
            com.google.android.gms.measurement.internal.zzet r4 = r4.zze()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L_0x0017:
            r4 = r1
            goto L_0x0028
        L_0x0019:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0020
            goto L_0x0017
        L_0x0020:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0028:
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            android.content.Context r0 = r3.zzm()     // Catch:{ NotFoundException -> 0x0043 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0043 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0043 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0043 }
            if (r4 != 0) goto L_0x003e
            return r1
        L_0x003e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0043 }
            return r4
        L_0x0043:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzer r0 = r3.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zze()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.mo20605g(java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: h */
    public final boolean mo20606h(String str) {
        return zzd(str, zzat.zzaj);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: i */
    public final String mo20607i(String str) {
        zzeg<String> zzeg = zzat.zzak;
        if (str == null) {
            return zzeg.zza(null);
        }
        return zzeg.zza(this.f18732b.zza(str, zzeg.zza()));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: j */
    public final boolean mo20608j() {
        if (this.f18731a == null) {
            Boolean f = mo20604f("app_measurement_lite");
            this.f18731a = f;
            if (f == null) {
                this.f18731a = Boolean.FALSE;
            }
        }
        return this.f18731a.booleanValue() || !this.zzy.zzs();
    }

    public final int zza(@Size(min = 1) String str) {
        return m11042a(str, zzat.zzah, 25, 100);
    }

    @WorkerThread
    public final int zzb(String str, @NonNull zzeg<Integer> zzeg) {
        if (str == null) {
            return zzeg.zza(null).intValue();
        }
        String zza = this.f18732b.zza(str, zzeg.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzeg.zza(null).intValue();
        }
        try {
            return zzeg.zza(Integer.valueOf(Integer.parseInt(zza))).intValue();
        } catch (NumberFormatException unused) {
            return zzeg.zza(null).intValue();
        }
    }

    @WorkerThread
    public final int zzc(@Size(min = 1) String str) {
        return zzb(str, zzat.zzn);
    }

    public final int zzd() {
        if (zzmi.zzb() && zzs().zzd((String) null, zzat.zzbw)) {
            zzkw zzo = zzo();
            Boolean h = zzo.zzy.zzv().mo20459h();
            if (zzo.zzi() >= 201500 || (h != null && !h.booleanValue())) {
                return 100;
            }
        }
        return 25;
    }

    public final boolean zze() {
        if (this.f18733c == null) {
            synchronized (this) {
                if (this.f18733c == null) {
                    ApplicationInfo applicationInfo = zzm().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f18733c = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.f18733c == null) {
                        this.f18733c = Boolean.TRUE;
                        zzq().zze().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f18733c.booleanValue();
    }

    public final boolean zzf() {
        Boolean f = mo20604f("firebase_analytics_collection_deactivated");
        return f != null && f.booleanValue();
    }

    public final Boolean zzg() {
        Boolean f = mo20604f("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(f == null || f.booleanValue());
    }

    public final Boolean zzh() {
        if (!zzof.zzb() || !zza(zzat.zzbt)) {
            return Boolean.TRUE;
        }
        Boolean f = mo20604f("google_analytics_automatic_screen_reporting_enabled");
        return Boolean.valueOf(f == null || f.booleanValue());
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

    public final String zzu() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzv() {
        return zza("debug.deferred.deeplink", "");
    }

    @WorkerThread
    public final long zza(String str, @NonNull zzeg<Long> zzeg) {
        if (str == null) {
            return zzeg.zza(null).longValue();
        }
        String zza = this.f18732b.zza(str, zzeg.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzeg.zza(null).longValue();
        }
        try {
            return zzeg.zza(Long.valueOf(Long.parseLong(zza))).longValue();
        } catch (NumberFormatException unused) {
            return zzeg.zza(null).longValue();
        }
    }

    @WorkerThread
    public final double zzc(String str, @NonNull zzeg<Double> zzeg) {
        if (str == null) {
            return zzeg.zza(null).doubleValue();
        }
        String zza = this.f18732b.zza(str, zzeg.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzeg.zza(null).doubleValue();
        }
        try {
            return zzeg.zza(Double.valueOf(Double.parseDouble(zza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzeg.zza(null).doubleValue();
        }
    }

    public final boolean zzi(String str) {
        return "1".equals(this.f18732b.zza(str, "measurement.event_sampling_enabled"));
    }

    public final boolean zzh(String str) {
        return "1".equals(this.f18732b.zza(str, "gaia_collection_enabled"));
    }

    @WorkerThread
    public final boolean zzd(String str, @NonNull zzeg<Boolean> zzeg) {
        if (str == null) {
            return zzeg.zza(null).booleanValue();
        }
        String zza = this.f18732b.zza(str, zzeg.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzeg.zza(null).booleanValue();
        }
        return zzeg.zza(Boolean.valueOf(Boolean.parseBoolean(zza))).booleanValue();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final boolean zza(zzeg<Boolean> zzeg) {
        return zzd((String) null, zzeg);
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(com.google.android.gms.measurement.internal.C3013i3 r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.mo19937A()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0033
            boolean r1 = com.google.android.gms.internal.measurement.zznt.zzb()
            if (r1 == 0) goto L_0x002f
            com.google.android.gms.measurement.internal.zzy r1 = r5.zzs()
            java.lang.String r2 = r6.mo19995t()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbi
            boolean r1 = r1.zzd(r2, r3)
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = r6.mo19943G()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0033
        L_0x002f:
            java.lang.String r1 = r6.mo19940D()
        L_0x0033:
            com.google.android.gms.measurement.internal.zzeg<java.lang.String> r2 = com.google.android.gms.measurement.internal.zzat.zzd
            r3 = 0
            java.lang.Object r2 = r2.zza(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.zzeg<java.lang.String> r4 = com.google.android.gms.measurement.internal.zzat.zze
            java.lang.Object r3 = r4.zza(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L_0x005d
            java.lang.String r1 = r3.concat(r1)
            goto L_0x0062
        L_0x005d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L_0x0062:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.mo19999x()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            java.lang.String r1 = "gmp_version"
            java.lang.String r2 = "32053"
            r6.appendQueryParameter(r1, r2)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zza(com.google.android.gms.measurement.internal.i3):java.lang.String");
    }

    public final boolean zze(String str, zzeg<Boolean> zzeg) {
        return zzd(str, zzeg);
    }

    private final String zza(String str, String str2) {
        Class<String> cls = String.class;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, str2});
        } catch (ClassNotFoundException e) {
            zzq().zze().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (NoSuchMethodException e2) {
            zzq().zze().zza("Could not find SystemProperties.get() method", e2);
            return str2;
        } catch (IllegalAccessException e3) {
            zzq().zze().zza("Could not access SystemProperties.get()", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzq().zze().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
