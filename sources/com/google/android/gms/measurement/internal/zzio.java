package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzio extends C3130v3 {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzji f18672b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public zzej f18673c;

    /* renamed from: d */
    private volatile Boolean f18674d;

    /* renamed from: e */
    private final C2990g f18675e;

    /* renamed from: f */
    private final C3044l7 f18676f;

    /* renamed from: g */
    private final List<Runnable> f18677g = new ArrayList();

    /* renamed from: h */
    private final C2990g f18678h;

    protected zzio(zzfv zzfv) {
        super(zzfv);
        this.f18676f = new C3044l7(zzfv.zzl());
        this.f18672b = new zzji(this);
        this.f18675e = new C2947b6(this, zzfv);
        this.f18678h = new C3052m6(this, zzfv);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: d */
    public final void m10865d(ComponentName componentName) {
        zzc();
        if (this.f18673c != null) {
            this.f18673c = null;
            zzq().zzw().zza("Disconnected from device MeasurementService", componentName);
            zzc();
            mo20458g();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f4  */
    @androidx.annotation.WorkerThread
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m10867k() {
        /*
            r5 = this;
            r5.zzc()
            r5.zzv()
            java.lang.Boolean r0 = r5.f18674d
            if (r0 != 0) goto L_0x0101
            r5.zzc()
            r5.zzv()
            com.google.android.gms.measurement.internal.m3 r0 = r5.zzr()
            java.lang.Boolean r0 = r0.mo20046k()
            r1 = 1
            if (r0 == 0) goto L_0x0023
            boolean r2 = r0.booleanValue()
            if (r2 == 0) goto L_0x0023
            goto L_0x00fb
        L_0x0023:
            com.google.android.gms.measurement.internal.zzek r2 = r5.zzf()
            int r2 = r2.mo20279g()
            r3 = 0
            if (r2 != r1) goto L_0x0031
        L_0x002e:
            r0 = 1
            goto L_0x00d7
        L_0x0031:
            com.google.android.gms.measurement.internal.zzer r2 = r5.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzw()
            java.lang.String r4 = "Checking service availability"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zzkw r2 = r5.zzo()
            r4 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r2 = r2.zza((int) r4)
            if (r2 == 0) goto L_0x00c8
            if (r2 == r1) goto L_0x00b8
            r4 = 2
            if (r2 == r4) goto L_0x0098
            r0 = 3
            if (r2 == r0) goto L_0x0089
            r0 = 9
            if (r2 == r0) goto L_0x007b
            r0 = 18
            if (r2 == r0) goto L_0x006d
            com.google.android.gms.measurement.internal.zzer r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzh()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "Unexpected service status"
            r0.zza(r2, r1)
            goto L_0x0096
        L_0x006d:
            com.google.android.gms.measurement.internal.zzer r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzh()
            java.lang.String r2 = "Service updating"
            r0.zza(r2)
            goto L_0x002e
        L_0x007b:
            com.google.android.gms.measurement.internal.zzer r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzh()
            java.lang.String r1 = "Service invalid"
            r0.zza(r1)
            goto L_0x0096
        L_0x0089:
            com.google.android.gms.measurement.internal.zzer r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzh()
            java.lang.String r1 = "Service disabled"
            r0.zza(r1)
        L_0x0096:
            r0 = 0
            goto L_0x00c6
        L_0x0098:
            com.google.android.gms.measurement.internal.zzer r2 = r5.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzv()
            java.lang.String r4 = "Service container out of date"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zzkw r2 = r5.zzo()
            int r2 = r2.zzi()
            r4 = 17443(0x4423, float:2.4443E-41)
            if (r2 >= r4) goto L_0x00b2
            goto L_0x00c5
        L_0x00b2:
            if (r0 != 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            r1 = 0
        L_0x00b6:
            r0 = 0
            goto L_0x00d7
        L_0x00b8:
            com.google.android.gms.measurement.internal.zzer r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzw()
            java.lang.String r2 = "Service missing"
            r0.zza(r2)
        L_0x00c5:
            r0 = 1
        L_0x00c6:
            r1 = 0
            goto L_0x00d7
        L_0x00c8:
            com.google.android.gms.measurement.internal.zzer r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzw()
            java.lang.String r2 = "Service available"
            r0.zza(r2)
            goto L_0x002e
        L_0x00d7:
            if (r1 != 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.zzy r2 = r5.zzs()
            boolean r2 = r2.mo20608j()
            if (r2 == 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.zzer r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zze()
            java.lang.String r2 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r2)
            goto L_0x00f2
        L_0x00f1:
            r3 = r0
        L_0x00f2:
            if (r3 == 0) goto L_0x00fb
            com.google.android.gms.measurement.internal.m3 r0 = r5.zzr()
            r0.zza((boolean) r1)
        L_0x00fb:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r5.f18674d = r0
        L_0x0101:
            java.lang.Boolean r0 = r5.f18674d
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzio.m10867k():boolean");
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: l */
    public final void m10868l() {
        zzc();
        if (zzaa()) {
            zzq().zzw().zza("Inactivity, disconnecting from the service");
            zzag();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: m */
    public final void m10869m() {
        zzc();
        zzq().zzw().zza("Processing queued up service tasks", Integer.valueOf(this.f18677g.size()));
        for (Runnable run : this.f18677g) {
            try {
                run.run();
            } catch (Exception e) {
                zzq().zze().zza("Task exception while flushing queue", e);
            }
        }
        this.f18677g.clear();
        this.f18678h.mo19915e();
    }

    @WorkerThread
    @Nullable
    /* renamed from: n */
    private final zzn m10870n(boolean z) {
        return zzf().mo20274b(z ? zzq().zzx() : null);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzaj() {
        zzc();
        this.f18676f.mo20033a();
        this.f18675e.mo19913c(zzat.zzai.zza(null).longValue());
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    /* renamed from: e */
    public final void mo20457e(zzej zzej, AbstractSafeParcelable abstractSafeParcelable, zzn zzn) {
        int i;
        zzc();
        zzv();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zza = zzi().zza(100);
            if (zza != null) {
                arrayList.addAll(zza);
                i = zza.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzar) {
                    try {
                        zzej.zza((zzar) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e) {
                        zzq().zze().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkr) {
                    try {
                        zzej.zza((zzkr) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e2) {
                        zzq().zze().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzw) {
                    try {
                        zzej.zza((zzw) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e3) {
                        zzq().zze().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzq().zze().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: g */
    public final void mo20458g() {
        zzc();
        zzv();
        if (!zzaa()) {
            if (m10867k()) {
                this.f18672b.zzb();
            } else if (!zzs().mo20608j()) {
                List<ResolveInfo> queryIntentServices = zzm().getPackageManager().queryIntentServices(new Intent().setClassName(zzm(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    intent.setComponent(new ComponentName(zzm(), "com.google.android.gms.measurement.AppMeasurementService"));
                    this.f18672b.zza(intent);
                    return;
                }
                zzq().zze().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final Boolean mo20459h() {
        return this.f18674d;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: i */
    public final boolean mo20460i() {
        zzc();
        zzv();
        if (m10867k() && zzo().zzi() < 200900) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: j */
    public final boolean mo20461j() {
        zzc();
        zzv();
        if (!zzs().zza(zzat.zzci)) {
            return false;
        }
        if (m10867k() && zzo().zzi() < zzat.zzcj.zza(null).intValue()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(boolean z) {
        if (zzmj.zzb() && zzs().zza(zzat.zzcg)) {
            zzc();
            zzv();
            if (z) {
                zzi().zzaa();
            }
            if (mo20461j()) {
                zza((Runnable) new C3061n6(this, m10870n(false)));
            }
        }
    }

    @WorkerThread
    public final boolean zzaa() {
        zzc();
        zzv();
        return this.f18673c != null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzab() {
        zzc();
        zzv();
        zza((Runnable) new C3070o6(this, m10870n(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzac() {
        zzc();
        zzv();
        zzn n = m10870n(false);
        zzi().zzaa();
        zza((Runnable) new C2987f6(this, n));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzad() {
        zzc();
        zzv();
        zzn n = m10870n(true);
        zzi().zzab();
        zza((Runnable) new C2997g6(this, n));
    }

    @WorkerThread
    public final void zzag() {
        zzc();
        zzv();
        this.f18672b.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzm(), this.f18672b);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f18673c = null;
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
        return false;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzar zzar, String str) {
        Preconditions.checkNotNull(zzar);
        zzc();
        zzv();
        zza((Runnable) new C3088q6(this, true, zzi().zza(zzar), zzar, m10870n(true), str));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzw zzw) {
        Preconditions.checkNotNull(zzw);
        zzc();
        zzv();
        zza((Runnable) new C3079p6(this, true, zzi().zza(zzw), new zzw(zzw), m10870n(true), zzw));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzw>> atomicReference, String str, String str2, String str3) {
        zzc();
        zzv();
        zza((Runnable) new C3106s6(this, atomicReference, str, str2, str3, m10870n(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzw zzw, String str, String str2) {
        zzc();
        zzv();
        zza((Runnable) new C3097r6(this, str, str2, m10870n(false), zzw));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzkr>> atomicReference, String str, String str2, String str3, boolean z) {
        zzc();
        zzv();
        zza((Runnable) new C3115t6(this, atomicReference, str, str2, str3, z, m10870n(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzw zzw, String str, String str2, boolean z) {
        zzc();
        zzv();
        zza((Runnable) new C2937a6(this, str, str2, z, m10870n(false), zzw));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzkr zzkr) {
        zzc();
        zzv();
        zza((Runnable) new C2967d6(this, zzi().zza(zzkr), zzkr, m10870n(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzkr>> atomicReference, boolean z) {
        zzc();
        zzv();
        zza((Runnable) new C2957c6(this, atomicReference, m10870n(false), z));
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzc();
        zzv();
        zza((Runnable) new C2977e6(this, atomicReference, m10870n(false)));
    }

    @WorkerThread
    public final void zza(zzw zzw) {
        zzc();
        zzv();
        zza((Runnable) new C3007h6(this, m10870n(false), zzw));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzig zzig) {
        zzc();
        zzv();
        zza((Runnable) new C3025j6(this, zzig));
    }

    @WorkerThread
    public final void zza(Bundle bundle) {
        zzc();
        zzv();
        zza((Runnable) new C3016i6(this, bundle, m10870n(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzej zzej) {
        zzc();
        Preconditions.checkNotNull(zzej);
        this.f18673c = zzej;
        zzaj();
        m10869m();
    }

    @WorkerThread
    private final void zza(Runnable runnable) {
        zzc();
        if (zzaa()) {
            runnable.run();
        } else if (((long) this.f18677g.size()) >= 1000) {
            zzq().zze().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.f18677g.add(runnable);
            this.f18678h.mo19913c(60000);
            mo20458g();
        }
    }

    @WorkerThread
    public final void zza(zzw zzw, zzar zzar, String str) {
        zzc();
        zzv();
        if (zzo().zza((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzq().zzh().zza("Not bundling data. Service unavailable or out of date");
            zzo().zza(zzw, new byte[0]);
            return;
        }
        zza((Runnable) new C3043l6(this, zzar, str, zzw));
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
