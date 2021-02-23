package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zznm;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzij extends C3130v3 {

    /* renamed from: b */
    private volatile zzig f18662b;

    /* renamed from: c */
    private zzig f18663c;

    /* renamed from: d */
    private final Map<Activity, zzig> f18664d = new ConcurrentHashMap();

    /* renamed from: e */
    private Activity f18665e;

    /* renamed from: f */
    private volatile boolean f18666f;

    /* renamed from: g */
    private volatile zzig f18667g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public zzig f18668h;

    /* renamed from: i */
    private boolean f18669i;

    /* renamed from: j */
    private final Object f18670j = new Object();

    /* renamed from: k */
    private String f18671k;
    @VisibleForTesting
    protected zzig zza;

    public zzij(zzfv zzfv) {
        super(zzfv);
    }

    @MainThread
    /* renamed from: d */
    private final void m10855d(Activity activity, zzig zzig, boolean z) {
        zzig zzig2;
        zzig zzig3 = zzig;
        zzig zzig4 = this.f18662b == null ? this.f18663c : this.f18662b;
        if (zzig3.zzb == null) {
            zzig2 = new zzig(zzig3.zza, activity != null ? zza(activity.getClass().getCanonicalName()) : null, zzig3.zzc, zzig3.zze, zzig3.zzf);
        } else {
            zzig2 = zzig3;
        }
        this.f18663c = this.f18662b;
        this.f18662b = zzig2;
        zzp().zza((Runnable) new C3141w5(this, zzig2, zzig4, zzl().elapsedRealtime(), z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: e */
    public final void m10856e(Bundle bundle, @NonNull zzig zzig, zzig zzig2, long j) {
        if (bundle != null) {
            bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        m10857f(zzig, zzig2, j, true, zzo().mo20569h((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, true, true));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: f */
    public final void m10857f(zzig zzig, zzig zzig2, long j, boolean z, Bundle bundle) {
        boolean z2;
        long j2;
        long j3;
        zzig zzig3;
        zzc();
        boolean z3 = false;
        if (zzs().zza(zzat.zzas)) {
            z2 = z && this.zza != null;
            if (z2) {
                m10858g(this.zza, true, j);
            }
        } else {
            if (z && (zzig3 = this.zza) != null) {
                m10858g(zzig3, true, j);
            }
            z2 = false;
        }
        if (zzig2 == null || zzig2.zzc != zzig.zzc || !zzkw.m10994R(zzig2.zzb, zzig.zzb) || !zzkw.m10994R(zzig2.zza, zzig.zza)) {
            z3 = true;
        }
        if (z3) {
            Bundle bundle2 = new Bundle();
            if (zzs().zza(zzat.zzbu)) {
                bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            }
            Bundle bundle3 = bundle2;
            zza(zzig, bundle3, true);
            if (zzig2 != null) {
                String str = zzig2.zza;
                if (str != null) {
                    bundle3.putString("_pn", str);
                }
                String str2 = zzig2.zzb;
                if (str2 != null) {
                    bundle3.putString("_pc", str2);
                }
                bundle3.putLong("_pi", zzig2.zzc);
            }
            if (zzs().zza(zzat.zzas) && z2) {
                if (!zznm.zzb() || !zzs().zza(zzat.zzau)) {
                    j3 = zzj().zzb.mo19931e();
                } else {
                    j3 = zzj().mo20498b(j);
                }
                if (j3 > 0) {
                    zzo().zza(bundle3, j3);
                }
            }
            String str3 = "auto";
            if (zzs().zza(zzat.zzbu)) {
                if (!zzs().zzh().booleanValue()) {
                    bundle3.putLong("_mst", 1);
                }
                if (zzig.zze) {
                    str3 = "app";
                }
            }
            String str4 = str3;
            if (zzs().zza(zzat.zzbu)) {
                long currentTimeMillis = zzl().currentTimeMillis();
                if (zzig.zze) {
                    long j4 = zzig.zzf;
                    if (j4 != 0) {
                        j2 = j4;
                        zze().mo20388k(str4, "_vs", j2, bundle3);
                    }
                }
                j2 = currentTimeMillis;
                zze().mo20388k(str4, "_vs", j2, bundle3);
            } else {
                zze().mo20390t(str4, "_vs", bundle3);
            }
        }
        this.zza = zzig;
        if (zzs().zza(zzat.zzbu) && zzig.zze) {
            this.f18668h = zzig;
        }
        zzg().zza(zzig);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: g */
    public final void m10858g(zzig zzig, boolean z, long j) {
        zzd().zza(zzl().elapsedRealtime());
        if (zzj().zza(zzig != null && zzig.f18661a, z, j) && zzig != null) {
            zzig.f18661a = false;
        }
    }

    @MainThread
    /* renamed from: k */
    private final zzig m10862k(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzig zzig = this.f18664d.get(activity);
        if (zzig == null) {
            zzig zzig2 = new zzig((String) null, zza(activity.getClass().getCanonicalName()), zzo().zzf());
            this.f18664d.put(activity, zzig2);
            zzig = zzig2;
        }
        return (zzs().zza(zzat.zzbu) && this.f18667g != null) ? this.f18667g : zzig;
    }

    @WorkerThread
    public final zzig zza(boolean z) {
        zzv();
        zzc();
        if (!zzs().zza(zzat.zzbu) || !z) {
            return this.zza;
        }
        zzig zzig = this.zza;
        return zzig != null ? zzig : this.f18668h;
    }

    public final zzig zzaa() {
        return this.f18662b;
    }

    @MainThread
    public final void zzb(Activity activity) {
        if (zzs().zza(zzat.zzbu)) {
            synchronized (this.f18670j) {
                this.f18669i = false;
                this.f18666f = true;
            }
        }
        long elapsedRealtime = zzl().elapsedRealtime();
        if (!zzs().zza(zzat.zzbt) || zzs().zzh().booleanValue()) {
            zzig k = m10862k(activity);
            this.f18663c = this.f18662b;
            this.f18662b = null;
            zzp().zza((Runnable) new C3150x5(this, k, elapsedRealtime));
            return;
        }
        this.f18662b = null;
        zzp().zza((Runnable) new C3159y5(this, elapsedRealtime));
    }

    @MainThread
    public final void zzc(Activity activity) {
        synchronized (this.f18670j) {
            if (activity == this.f18665e) {
                this.f18665e = null;
            }
        }
        if (zzs().zzh().booleanValue()) {
            this.f18664d.remove(activity);
        }
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
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d8, code lost:
        r1 = zzq().zzw();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e2, code lost:
        if (r10 != null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e4, code lost:
        r3 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e8, code lost:
        if (r11 != null) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ea, code lost:
        r4 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ed, code lost:
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ee, code lost:
        r1.zza("Logging screen view with name, class", r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f3, code lost:
        if (r8.f18662b != null) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f5, code lost:
        r1 = r8.f18663c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f8, code lost:
        r1 = r8.f18662b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fa, code lost:
        r5 = r1;
        r9 = new com.google.android.gms.measurement.internal.zzig(r10, r11, zzo().zzf(), true, r19);
        r8.f18662b = r9;
        r8.f18663c = r5;
        r8.f18667g = r9;
        zzp().zza((java.lang.Runnable) new com.google.android.gms.measurement.internal.C3123u5(r17, r18, r9, r5, zzl().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.os.Bundle r18, long r19) {
        /*
            r17 = this;
            r8 = r17
            r0 = r18
            com.google.android.gms.measurement.internal.zzy r1 = r17.zzs()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzbu
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r2)
            if (r1 != 0) goto L_0x001e
            com.google.android.gms.measurement.internal.zzer r0 = r17.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzj()
            java.lang.String r1 = "Manual screen reporting is disabled."
            r0.zza(r1)
            return
        L_0x001e:
            java.lang.Object r1 = r8.f18670j
            monitor-enter(r1)
            boolean r2 = r8.f18669i     // Catch:{ all -> 0x012c }
            if (r2 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzer r0 = r17.zzq()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzj()     // Catch:{ all -> 0x012c }
            java.lang.String r2 = "Cannot log screen view event when the app is in the background."
            r0.zza(r2)     // Catch:{ all -> 0x012c }
            monitor-exit(r1)     // Catch:{ all -> 0x012c }
            return
        L_0x0034:
            r2 = 0
            if (r0 == 0) goto L_0x0092
            java.lang.String r2 = "screen_name"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x012c }
            r3 = 100
            if (r2 == 0) goto L_0x0064
            int r4 = r2.length()     // Catch:{ all -> 0x012c }
            if (r4 <= 0) goto L_0x004d
            int r4 = r2.length()     // Catch:{ all -> 0x012c }
            if (r4 <= r3) goto L_0x0064
        L_0x004d:
            com.google.android.gms.measurement.internal.zzer r0 = r17.zzq()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzj()     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "Invalid screen name length for screen view. Length"
            int r2 = r2.length()     // Catch:{ all -> 0x012c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x012c }
            r0.zza(r3, r2)     // Catch:{ all -> 0x012c }
            monitor-exit(r1)     // Catch:{ all -> 0x012c }
            return
        L_0x0064:
            java.lang.String r4 = "screen_class"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x012c }
            if (r4 == 0) goto L_0x008f
            int r5 = r4.length()     // Catch:{ all -> 0x012c }
            if (r5 <= 0) goto L_0x0078
            int r5 = r4.length()     // Catch:{ all -> 0x012c }
            if (r5 <= r3) goto L_0x008f
        L_0x0078:
            com.google.android.gms.measurement.internal.zzer r0 = r17.zzq()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzj()     // Catch:{ all -> 0x012c }
            java.lang.String r2 = "Invalid screen class length for screen view. Length"
            int r3 = r4.length()     // Catch:{ all -> 0x012c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x012c }
            r0.zza(r2, r3)     // Catch:{ all -> 0x012c }
            monitor-exit(r1)     // Catch:{ all -> 0x012c }
            return
        L_0x008f:
            r10 = r2
            r2 = r4
            goto L_0x0093
        L_0x0092:
            r10 = r2
        L_0x0093:
            if (r2 != 0) goto L_0x00a8
            android.app.Activity r2 = r8.f18665e     // Catch:{ all -> 0x012c }
            if (r2 == 0) goto L_0x00a6
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x012c }
            java.lang.String r2 = r2.getCanonicalName()     // Catch:{ all -> 0x012c }
            java.lang.String r2 = zza((java.lang.String) r2)     // Catch:{ all -> 0x012c }
            goto L_0x00a8
        L_0x00a6:
            java.lang.String r2 = "Activity"
        L_0x00a8:
            r11 = r2
            boolean r2 = r8.f18666f     // Catch:{ all -> 0x012c }
            if (r2 == 0) goto L_0x00d7
            com.google.android.gms.measurement.internal.zzig r2 = r8.f18662b     // Catch:{ all -> 0x012c }
            if (r2 == 0) goto L_0x00d7
            r2 = 0
            r8.f18666f = r2     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzig r2 = r8.f18662b     // Catch:{ all -> 0x012c }
            java.lang.String r2 = r2.zzb     // Catch:{ all -> 0x012c }
            boolean r2 = com.google.android.gms.measurement.internal.zzkw.m10994R(r2, r11)     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzig r3 = r8.f18662b     // Catch:{ all -> 0x012c }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x012c }
            boolean r3 = com.google.android.gms.measurement.internal.zzkw.m10994R(r3, r10)     // Catch:{ all -> 0x012c }
            if (r2 == 0) goto L_0x00d7
            if (r3 == 0) goto L_0x00d7
            com.google.android.gms.measurement.internal.zzer r0 = r17.zzq()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzj()     // Catch:{ all -> 0x012c }
            java.lang.String r2 = "Ignoring call to log screen view event with duplicate parameters."
            r0.zza(r2)     // Catch:{ all -> 0x012c }
            monitor-exit(r1)     // Catch:{ all -> 0x012c }
            return
        L_0x00d7:
            monitor-exit(r1)     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzer r1 = r17.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzw()
            java.lang.String r2 = "Logging screen view with name, class"
            if (r10 != 0) goto L_0x00e7
            java.lang.String r3 = "null"
            goto L_0x00e8
        L_0x00e7:
            r3 = r10
        L_0x00e8:
            if (r11 != 0) goto L_0x00ed
            java.lang.String r4 = "null"
            goto L_0x00ee
        L_0x00ed:
            r4 = r11
        L_0x00ee:
            r1.zza(r2, r3, r4)
            com.google.android.gms.measurement.internal.zzig r1 = r8.f18662b
            if (r1 != 0) goto L_0x00f8
            com.google.android.gms.measurement.internal.zzig r1 = r8.f18663c
            goto L_0x00fa
        L_0x00f8:
            com.google.android.gms.measurement.internal.zzig r1 = r8.f18662b
        L_0x00fa:
            r5 = r1
            com.google.android.gms.measurement.internal.zzig r4 = new com.google.android.gms.measurement.internal.zzig
            com.google.android.gms.measurement.internal.zzkw r1 = r17.zzo()
            long r12 = r1.zzf()
            r14 = 1
            r9 = r4
            r15 = r19
            r9.<init>(r10, r11, r12, r14, r15)
            r8.f18662b = r4
            r8.f18663c = r5
            r8.f18667g = r4
            com.google.android.gms.common.util.Clock r1 = r17.zzl()
            long r6 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzfo r9 = r17.zzp()
            com.google.android.gms.measurement.internal.u5 r10 = new com.google.android.gms.measurement.internal.u5
            r1 = r10
            r2 = r17
            r3 = r18
            r1.<init>(r2, r3, r4, r5, r6)
            r9.zza((java.lang.Runnable) r10)
            return
        L_0x012c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x012c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzij.zza(android.os.Bundle, long):void");
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @MainThread
    public final void zzb(Activity activity, Bundle bundle) {
        zzig zzig;
        if (zzs().zzh().booleanValue() && bundle != null && (zzig = this.f18664d.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong(FacebookAdapter.KEY_ID, zzig.zzc);
            bundle2.putString("name", zzig.zza);
            bundle2.putString("referrer_name", zzig.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @MainThread
    @Deprecated
    public final void zza(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        if (!zzs().zzh().booleanValue()) {
            zzq().zzj().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
        } else if (this.f18662b == null) {
            zzq().zzj().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.f18664d.get(activity) == null) {
            zzq().zzj().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean R = zzkw.m10994R(this.f18662b.zzb, str2);
            boolean R2 = zzkw.m10994R(this.f18662b.zza, str);
            if (R && R2) {
                zzq().zzj().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzq().zzj().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzq().zzw().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzig zzig = new zzig(str, str2, zzo().zzf());
                this.f18664d.put(activity, zzig);
                m10855d(activity, zzig, true);
            } else {
                zzq().zzj().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public static void zza(zzig zzig, Bundle bundle, boolean z) {
        if (bundle != null && zzig != null && (!bundle.containsKey("_sc") || z)) {
            String str = zzig.zza;
            if (str != null) {
                bundle.putString("_sn", str);
            } else {
                bundle.remove("_sn");
            }
            String str2 = zzig.zzb;
            if (str2 != null) {
                bundle.putString("_sc", str2);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", zzig.zzc);
        } else if (bundle != null && zzig == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    @WorkerThread
    public final void zza(String str, zzig zzig) {
        zzc();
        synchronized (this) {
            String str2 = this.f18671k;
            if (str2 == null || str2.equals(str) || zzig != null) {
                this.f18671k = str;
            }
        }
    }

    @VisibleForTesting
    private static String zza(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    @MainThread
    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (zzs().zzh().booleanValue() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.f18664d.put(activity, new zzig(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(FacebookAdapter.KEY_ID)));
        }
    }

    @MainThread
    public final void zza(Activity activity) {
        if (zzs().zza(zzat.zzbu)) {
            synchronized (this.f18670j) {
                this.f18669i = true;
                if (activity != this.f18665e) {
                    synchronized (this.f18670j) {
                        this.f18665e = activity;
                        this.f18666f = false;
                    }
                    if (zzs().zza(zzat.zzbt) && zzs().zzh().booleanValue()) {
                        this.f18667g = null;
                        zzp().zza((Runnable) new C3168z5(this));
                    }
                }
            }
        }
        if (!zzs().zza(zzat.zzbt) || zzs().zzh().booleanValue()) {
            m10855d(activity, m10862k(activity), false);
            zza zzd = zzd();
            zzd.zzp().zza((Runnable) new C3111t2(zzd, zzd.zzl().elapsedRealtime()));
            return;
        }
        this.f18662b = this.f18667g;
        zzp().zza((Runnable) new C3132v5(this));
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
