package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzpi;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzek extends C3130v3 {

    /* renamed from: b */
    private String f18520b;

    /* renamed from: c */
    private String f18521c;

    /* renamed from: d */
    private int f18522d;

    /* renamed from: e */
    private String f18523e;

    /* renamed from: f */
    private long f18524f;

    /* renamed from: g */
    private long f18525g;

    /* renamed from: h */
    private List<String> f18526h;

    /* renamed from: i */
    private int f18527i;

    /* renamed from: j */
    private String f18528j;

    /* renamed from: k */
    private String f18529k;

    /* renamed from: l */
    private String f18530l;

    zzek(zzfv zzfv, long j) {
        super(zzfv);
        this.f18525g = j;
    }

    @WorkerThread
    @VisibleForTesting
    /* renamed from: i */
    private final String m10757i() {
        if (!zzpi.zzb() || !zzs().zza(zzat.zzbk)) {
            try {
                Class<?> loadClass = zzm().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{zzm()});
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        zzq().zzj().zza("Failed to retrieve Firebase Instance Id");
                        return null;
                    }
                } catch (Exception unused2) {
                    zzq().zzi().zza("Failed to obtain Firebase Analytics instance");
                    return null;
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        } else {
            zzq().zzw().zza("Disabled IID for tests.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: b */
    public final zzn mo20274b(String str) {
        String str2;
        long j;
        Boolean bool;
        zzc();
        String c = mo20275c();
        String d = mo20276d();
        zzv();
        String str3 = this.f18521c;
        long f = (long) mo20278f();
        zzv();
        String str4 = this.f18523e;
        zzv();
        zzc();
        if (this.f18524f == 0) {
            this.f18524f = this.zzy.zzh().mo20566d(zzm(), zzm().getPackageName());
        }
        long j2 = this.f18524f;
        boolean zzaa = this.zzy.zzaa();
        boolean z = !zzr().f18245u;
        zzc();
        if (!this.zzy.zzaa()) {
            str2 = null;
        } else {
            str2 = m10757i();
        }
        zzfv zzfv = this.zzy;
        Long valueOf = Long.valueOf(zzfv.zzb().f18233i.zza());
        if (valueOf.longValue() == 0) {
            j = zzfv.f18608G;
        } else {
            j = Math.min(zzfv.f18608G, valueOf.longValue());
        }
        int g = mo20279g();
        boolean booleanValue = zzs().zzg().booleanValue();
        Boolean f2 = zzs().mo20604f("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(f2 == null || f2.booleanValue()).booleanValue();
        C3049m3 zzr = zzr();
        zzr.zzc();
        boolean z2 = zzr.mo20043h().getBoolean("deferred_analytics_collection", false);
        String zzac = zzac();
        Boolean f3 = zzs().mo20604f("google_analytics_default_allow_ad_personalization_signals");
        if (f3 == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(true ^ f3.booleanValue());
        }
        return new zzn(c, d, str3, f, str4, 32053, j2, str, zzaa, z, str2, 0, j, g, booleanValue, booleanValue2, z2, zzac, bool, this.f18525g, this.f18526h, (!zznt.zzb() || !zzs().zza(zzat.zzbi)) ? null : mo20277e(), (!zzmj.zzb() || !zzs().zza(zzat.zzcg)) ? "" : zzr().mo20050o().zza());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final String mo20275c() {
        zzv();
        return this.f18520b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final String mo20276d() {
        zzv();
        return this.f18528j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final String mo20277e() {
        zzv();
        return this.f18530l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final int mo20278f() {
        zzv();
        return this.f18522d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final int mo20279g() {
        zzv();
        return this.f18527i;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: h */
    public final List<String> mo20280h() {
        return this.f18526h;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: package-private */
    public final String zzac() {
        zzv();
        return this.f18529k;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
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

    /* access modifiers changed from: protected */
    public final boolean zzy() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c1 A[Catch:{ IllegalStateException -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01cc A[Catch:{ IllegalStateException -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01d6 A[Catch:{ IllegalStateException -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d8 A[Catch:{ IllegalStateException -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01e3 A[SYNTHETIC, Splitter:B:76:0x01e3] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0221 A[Catch:{ IllegalStateException -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0232 A[Catch:{ IllegalStateException -> 0x024f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzz() {
        /*
            r11 = this;
            android.content.Context r0 = r11.zzm()
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r1 = r11.zzm()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = "unknown"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.zzer r7 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r7 = r7.zze()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.zza(r9, r8)
            goto L_0x008c
        L_0x002d:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0032 }
            goto L_0x0043
        L_0x0032:
            com.google.android.gms.measurement.internal.zzer r7 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r7 = r7.zze()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zza(r9, r8)
        L_0x0043:
            if (r5 != 0) goto L_0x0048
            java.lang.String r5 = "manual_install"
            goto L_0x0051
        L_0x0048:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x0051
            r5 = r3
        L_0x0051:
            android.content.Context r7 = r11.zzm()     // Catch:{ NameNotFoundException -> 0x0079 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0079 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x0079 }
            if (r7 == 0) goto L_0x008c
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0079 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0079 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0079 }
            if (r9 != 0) goto L_0x0070
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0079 }
            goto L_0x0071
        L_0x0070:
            r8 = r2
        L_0x0071:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0076 }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0076 }
            goto L_0x008c
        L_0x0076:
            r7 = r2
            r2 = r8
            goto L_0x007a
        L_0x0079:
            r7 = r2
        L_0x007a:
            com.google.android.gms.measurement.internal.zzer r8 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r8 = r8.zze()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.zza(r10, r9, r2)
            r2 = r7
        L_0x008c:
            r11.f18520b = r0
            r11.f18523e = r5
            r11.f18521c = r2
            r11.f18522d = r6
            r5 = 0
            r11.f18524f = r5
            android.content.Context r2 = r11.zzm()
            com.google.android.gms.common.api.Status r2 = com.google.android.gms.common.api.internal.GoogleServices.initialize(r2)
            r5 = 1
            if (r2 == 0) goto L_0x00ab
            boolean r6 = r2.isSuccess()
            if (r6 == 0) goto L_0x00ab
            r6 = 1
            goto L_0x00ac
        L_0x00ab:
            r6 = 0
        L_0x00ac:
            com.google.android.gms.measurement.internal.zzfv r7 = r11.zzy
            java.lang.String r7 = r7.zzn()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00c8
            com.google.android.gms.measurement.internal.zzfv r7 = r11.zzy
            java.lang.String r7 = r7.zzo()
            java.lang.String r8 = "am"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x00c8
            r7 = 1
            goto L_0x00c9
        L_0x00c8:
            r7 = 0
        L_0x00c9:
            r6 = r6 | r7
            if (r6 != 0) goto L_0x00f5
            if (r2 != 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzer r2 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzf()
            java.lang.String r8 = "GoogleService failed to initialize (no status)"
            r2.zza(r8)
            goto L_0x00f5
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzer r8 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzf()
            int r9 = r2.getStatusCode()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = r2.getStatusMessage()
            java.lang.String r10 = "GoogleService failed to initialize, status"
            r8.zza(r10, r9, r2)
        L_0x00f5:
            if (r6 == 0) goto L_0x019e
            com.google.android.gms.measurement.internal.zzfv r2 = r11.zzy
            int r2 = r2.zzab()
            switch(r2) {
                case 0: goto L_0x018d;
                case 1: goto L_0x017f;
                case 2: goto L_0x0171;
                case 3: goto L_0x0163;
                case 4: goto L_0x0155;
                case 5: goto L_0x0147;
                case 6: goto L_0x0139;
                case 7: goto L_0x012b;
                case 8: goto L_0x011c;
                default: goto L_0x0100;
            }
        L_0x0100:
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzu()
            java.lang.String r8 = "App measurement disabled"
            r6.zza(r8)
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzf()
            java.lang.String r8 = "Invalid scion state in identity"
            r6.zza(r8)
            goto L_0x019a
        L_0x011c:
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzu()
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r6.zza(r8)
            goto L_0x019a
        L_0x012b:
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzu()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r6.zza(r8)
            goto L_0x019a
        L_0x0139:
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzj()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r6.zza(r8)
            goto L_0x019a
        L_0x0147:
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzw()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r6.zza(r8)
            goto L_0x019a
        L_0x0155:
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzu()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r6.zza(r8)
            goto L_0x019a
        L_0x0163:
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzu()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r6.zza(r8)
            goto L_0x019a
        L_0x0171:
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzw()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r6.zza(r8)
            goto L_0x019a
        L_0x017f:
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzu()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r6.zza(r8)
            goto L_0x019a
        L_0x018d:
            com.google.android.gms.measurement.internal.zzer r6 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzw()
            java.lang.String r8 = "App measurement collection enabled"
            r6.zza(r8)
        L_0x019a:
            if (r2 != 0) goto L_0x019e
            r2 = 1
            goto L_0x019f
        L_0x019e:
            r2 = 0
        L_0x019f:
            r11.f18528j = r3
            r11.f18529k = r3
            r11.f18530l = r3
            if (r7 == 0) goto L_0x01af
            com.google.android.gms.measurement.internal.zzfv r6 = r11.zzy
            java.lang.String r6 = r6.zzn()
            r11.f18529k = r6
        L_0x01af:
            boolean r6 = com.google.android.gms.internal.measurement.zzpc.zzb()     // Catch:{ IllegalStateException -> 0x024f }
            if (r6 == 0) goto L_0x01cc
            com.google.android.gms.measurement.internal.zzy r6 = r11.zzs()     // Catch:{ IllegalStateException -> 0x024f }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzcb     // Catch:{ IllegalStateException -> 0x024f }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r7)     // Catch:{ IllegalStateException -> 0x024f }
            if (r6 == 0) goto L_0x01cc
            android.content.Context r6 = r11.zzm()     // Catch:{ IllegalStateException -> 0x024f }
            java.lang.String r7 = "google_app_id"
            java.lang.String r6 = com.google.android.gms.measurement.internal.zzih.zza(r6, r7)     // Catch:{ IllegalStateException -> 0x024f }
            goto L_0x01d0
        L_0x01cc:
            java.lang.String r6 = com.google.android.gms.common.api.internal.GoogleServices.getGoogleAppId()     // Catch:{ IllegalStateException -> 0x024f }
        L_0x01d0:
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x024f }
            if (r7 == 0) goto L_0x01d8
            r7 = r3
            goto L_0x01d9
        L_0x01d8:
            r7 = r6
        L_0x01d9:
            r11.f18528j = r7     // Catch:{ IllegalStateException -> 0x024f }
            boolean r7 = com.google.android.gms.internal.measurement.zznt.zzb()     // Catch:{ IllegalStateException -> 0x024f }
            java.lang.String r8 = "admob_app_id"
            if (r7 == 0) goto L_0x021b
            com.google.android.gms.measurement.internal.zzy r7 = r11.zzs()     // Catch:{ IllegalStateException -> 0x024f }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzat.zzbi     // Catch:{ IllegalStateException -> 0x024f }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r9)     // Catch:{ IllegalStateException -> 0x024f }
            if (r7 == 0) goto L_0x021b
            com.google.android.gms.common.internal.StringResourceValueReader r7 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x024f }
            android.content.Context r9 = r11.zzm()     // Catch:{ IllegalStateException -> 0x024f }
            r7.<init>(r9)     // Catch:{ IllegalStateException -> 0x024f }
            java.lang.String r9 = "ga_app_id"
            java.lang.String r9 = r7.getString(r9)     // Catch:{ IllegalStateException -> 0x024f }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IllegalStateException -> 0x024f }
            if (r10 == 0) goto L_0x0205
            goto L_0x0206
        L_0x0205:
            r3 = r9
        L_0x0206:
            r11.f18530l = r3     // Catch:{ IllegalStateException -> 0x024f }
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x024f }
            if (r3 == 0) goto L_0x0214
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IllegalStateException -> 0x024f }
            if (r3 != 0) goto L_0x0230
        L_0x0214:
            java.lang.String r3 = r7.getString(r8)     // Catch:{ IllegalStateException -> 0x024f }
            r11.f18529k = r3     // Catch:{ IllegalStateException -> 0x024f }
            goto L_0x0230
        L_0x021b:
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x024f }
            if (r3 != 0) goto L_0x0230
            com.google.android.gms.common.internal.StringResourceValueReader r3 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x024f }
            android.content.Context r6 = r11.zzm()     // Catch:{ IllegalStateException -> 0x024f }
            r3.<init>(r6)     // Catch:{ IllegalStateException -> 0x024f }
            java.lang.String r3 = r3.getString(r8)     // Catch:{ IllegalStateException -> 0x024f }
            r11.f18529k = r3     // Catch:{ IllegalStateException -> 0x024f }
        L_0x0230:
            if (r2 == 0) goto L_0x0261
            com.google.android.gms.measurement.internal.zzer r2 = r11.zzq()     // Catch:{ IllegalStateException -> 0x024f }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzw()     // Catch:{ IllegalStateException -> 0x024f }
            java.lang.String r3 = "App measurement enabled for app package, google app id"
            java.lang.String r6 = r11.f18520b     // Catch:{ IllegalStateException -> 0x024f }
            java.lang.String r7 = r11.f18528j     // Catch:{ IllegalStateException -> 0x024f }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x024f }
            if (r7 == 0) goto L_0x0249
            java.lang.String r7 = r11.f18529k     // Catch:{ IllegalStateException -> 0x024f }
            goto L_0x024b
        L_0x0249:
            java.lang.String r7 = r11.f18528j     // Catch:{ IllegalStateException -> 0x024f }
        L_0x024b:
            r2.zza(r3, r6, r7)     // Catch:{ IllegalStateException -> 0x024f }
            goto L_0x0261
        L_0x024f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzer r3 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r3 = r3.zze()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r0)
            java.lang.String r6 = "Fetching Google App Id failed with exception. appId"
            r3.zza(r6, r0, r2)
        L_0x0261:
            r0 = 0
            r11.f18526h = r0
            com.google.android.gms.measurement.internal.zzy r0 = r11.zzs()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.mo20605g(r2)
            if (r0 == 0) goto L_0x02a2
            int r2 = r0.size()
            if (r2 != 0) goto L_0x0285
            com.google.android.gms.measurement.internal.zzer r2 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzj()
            java.lang.String r3 = "Safelisted event list is empty. Ignoring"
            r2.zza(r3)
        L_0x0283:
            r5 = 0
            goto L_0x02a2
        L_0x0285:
            java.util.Iterator r2 = r0.iterator()
        L_0x0289:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x02a2
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zzkw r6 = r11.zzo()
            java.lang.String r7 = "safelisted event"
            boolean r3 = r6.mo20560M(r7, r3)
            if (r3 != 0) goto L_0x0289
            goto L_0x0283
        L_0x02a2:
            if (r5 == 0) goto L_0x02a6
            r11.f18526h = r0
        L_0x02a6:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 < r2) goto L_0x02bc
            if (r1 == 0) goto L_0x02b9
            android.content.Context r0 = r11.zzm()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.f18527i = r0
            return
        L_0x02b9:
            r11.f18527i = r4
            return
        L_0x02bc:
            r11.f18527i = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzek.zzz():void");
    }
}
