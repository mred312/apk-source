package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzlq;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzna;
import com.google.android.gms.internal.measurement.zznh;
import com.google.android.gms.internal.measurement.zzny;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzgy extends C3130v3 {

    /* renamed from: b */
    private zzgx f18638b;

    /* renamed from: c */
    private final Set<zzgw> f18639c = new CopyOnWriteArraySet();

    /* renamed from: d */
    private boolean f18640d;

    /* renamed from: e */
    private final AtomicReference<String> f18641e = new AtomicReference<>();

    /* renamed from: f */
    private final Object f18642f = new Object();
    @GuardedBy("consentLock")

    /* renamed from: g */
    private zzad f18643g = new zzad((Boolean) null, (Boolean) null);
    @GuardedBy("consentLock")

    /* renamed from: h */
    private int f18644h = 100;

    /* renamed from: i */
    private final AtomicLong f18645i = new AtomicLong(0);

    /* renamed from: j */
    private long f18646j = -1;

    /* renamed from: k */
    private int f18647k = 100;

    /* renamed from: l */
    final zzp f18648l;
    @VisibleForTesting

    /* renamed from: m */
    private boolean f18649m = true;

    /* renamed from: n */
    private final C3143w7 f18650n = new C2996g5(this);
    @VisibleForTesting
    protected C3069o5 zza;

    protected zzgy(zzfv zzfv) {
        super(zzfv);
        this.f18648l = new zzp(zzfv);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: d */
    public final void m10828d(zzad zzad, int i, long j, boolean z, boolean z2) {
        zzc();
        zzv();
        if (j <= this.f18646j && zzad.zza(this.f18647k, i)) {
            zzq().zzu().zza("Dropped out-of-date consent setting, proposed settings", zzad);
        } else if (zzr().mo20038d(zzad, i)) {
            this.f18646j = j;
            this.f18647k = i;
            zzg().zza(z);
            if (z2) {
                zzg().zza((AtomicReference<String>) new AtomicReference());
            }
        } else {
            zzq().zzu().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: i */
    public final void m10833i(@Nullable Boolean bool, boolean z) {
        zzc();
        zzv();
        zzq().zzv().zza("Setting app measurement enabled (FE)", bool);
        zzr().zza(bool);
        if (zzmj.zzb() && zzs().zza(zzat.zzcg) && z) {
            zzr().mo20039e(bool);
        }
        if (!zzmj.zzb() || !zzs().zza(zzat.zzcg) || this.zzy.zzac() || !bool.booleanValue()) {
            m10835n();
        }
    }

    /* renamed from: l */
    private final void m10834l(String str, String str2, long j, Object obj) {
        zzp().zza((Runnable) new C3131v4(this, str, str2, obj, j));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: n */
    public final void m10835n() {
        zzc();
        String zza2 = zzr().f18242r.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                mo20389m("app", "_npa", (Object) null, zzl().currentTimeMillis());
            } else {
                mo20389m("app", "_npa", Long.valueOf("true".equals(zza2) ? 1 : 0), zzl().currentTimeMillis());
            }
        }
        if (!this.zzy.zzaa() || !this.f18649m) {
            zzq().zzv().zza("Updating Scion state (FE)");
            zzg().zzab();
            return;
        }
        zzq().zzv().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzah();
        if (zznh.zzb() && zzs().zza(zzat.zzbp)) {
            zzj().zza.mo20010a();
        }
        if (zzna.zzb() && zzs().zza(zzat.zzbs)) {
            if (!(this.zzy.zze().f18575a.zzb().f18234j.zza() > 0)) {
                zzfi zze = this.zzy.zze();
                zze.zza(zze.f18575a.zzm().getPackageName());
            }
        }
        if (zzs().zza(zzat.zzcc)) {
            zzp().zza((Runnable) new C3095r4(this));
        }
    }

    @VisibleForTesting
    /* renamed from: o */
    private final ArrayList<Bundle> m10836o(String str, String str2, String str3) {
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzx.zza()) {
            zzq().zze().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().mo20330c(atomicReference, 5000, "get conditional user properties", new C2976e5(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzkw.zzb((List<zzw>) list);
            }
            zzq().zze().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    @VisibleForTesting
    /* renamed from: p */
    private final Map<String, Object> m10837p(String str, String str2, String str3, boolean z) {
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzx.zza()) {
            zzq().zze().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().mo20330c(atomicReference, 5000, "get user properties", new C2966d5(this, atomicReference, str, str2, str3, z));
            List<zzkr> list = (List) atomicReference.get();
            if (list == null) {
                zzq().zze().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzkr zzkr : list) {
                arrayMap.put(zzkr.zza, zzkr.zza());
            }
            return arrayMap;
        }
    }

    /* renamed from: q */
    private final void m10838q(Bundle bundle, long j) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        Preconditions.checkNotNull(bundle);
        zzgt.zza(bundle, "app_id", cls2, null);
        zzgt.zza(bundle, "origin", cls2, null);
        zzgt.zza(bundle, "name", cls2, null);
        zzgt.zza(bundle, "value", Object.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, cls2, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cls, 0L);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, cls2, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, cls2, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cls, 0L);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, cls2, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString("name");
        Object obj = bundle.get("value");
        if (zzo().mo20558I(string) != 0) {
            zzq().zze().zza("Invalid conditional user property name", zzn().zzc(string));
        } else if (zzo().mo20559J(string, obj) != 0) {
            zzq().zze().zza("Invalid conditional user property value", zzn().zzc(string), obj);
        } else {
            Object O = zzo().mo20561O(string, obj);
            if (O == null) {
                zzq().zze().zza("Unable to normalize conditional user property value", zzn().zzc(string), obj);
                return;
            }
            zzgt.zza(bundle, O);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzq().zze().zza("Invalid conditional user property time to live", zzn().zzc(string), Long.valueOf(j3));
                } else {
                    zzp().zza((Runnable) new C3167z4(this, bundle));
                }
            } else {
                zzq().zze().zza("Invalid conditional user property timeout", zzn().zzc(string), Long.valueOf(j2));
            }
        }
    }

    /* renamed from: s */
    private final void m10840s(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzp().zza((Runnable) new C3140w4(this, str, str2, j, zzkw.zzb(bundle), z, z2, z3, str3));
    }

    /* renamed from: u */
    private final void m10841u(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzl().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzp().zza((Runnable) new C2946b5(this, bundle2));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: w */
    public final void m10842w(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzc();
        zzv();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        try {
            zzg().zza(new zzw(bundle2.getString("app_id"), bundle2.getString("origin"), new zzkr(bundle2.getString("name"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), bundle2.getString("origin")), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzo().mo20570i(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlq.zzb() && zzs().zza(zzat.zzck)), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzo().mo20570i(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlq.zzb() && zzs().zza(zzat.zzck)), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzo().mo20570i(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlq.zzb() && zzs().zza(zzat.zzck))));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: x */
    public final void m10843x(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzc();
        zzv();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkr zzkr = new zzkr(bundle2.getString("name"), 0, (Object) null, (String) null);
        try {
            zzg().zza(new zzw(bundle2.getString("app_id"), bundle2.getString("origin"), zzkr, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzar) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzar) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzo().mo20570i(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false, zzlq.zzb() && zzs().zza(zzat.zzck))));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo20385b(long j, boolean z) {
        zzc();
        zzv();
        zzq().zzv().zza("Resetting analytics data (FE)");
        zzju zzj = zzj();
        zzj.zzc();
        zzj.zzb.mo19928a();
        boolean zzaa = this.zzy.zzaa();
        C3049m3 zzr = zzr();
        zzr.f18233i.zza(j);
        if (!TextUtils.isEmpty(zzr.zzr().f18249y.zza())) {
            zzr.f18249y.zza((String) null);
        }
        if (zznh.zzb() && zzr.zzs().zza(zzat.zzbp)) {
            zzr.f18244t.zza(0);
        }
        if (!zzr.zzs().zzf()) {
            zzr.mo20041g(!zzaa);
        }
        zzr.f18250z.zza((String) null);
        zzr.f18224A.zza(0);
        zzr.f18225B.zza((Bundle) null);
        if (z) {
            zzg().zzac();
        }
        if (zznh.zzb() && zzs().zza(zzat.zzbp)) {
            zzj().zza.mo20010a();
        }
        this.f18649m = !zzaa;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: c */
    public final void mo20386c(zzad zzad) {
        zzc();
        boolean z = (zzad.zze() && zzad.zzc()) || zzg().mo20461j();
        if (z != this.zzy.zzac()) {
            this.zzy.zzb(z);
            Boolean n = zzr().mo20049n();
            if (!z || n == null || n.booleanValue()) {
                m10833i(Boolean.valueOf(z), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final void mo20387j(@Nullable String str) {
        this.f18641e.set(str);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: k */
    public final void mo20388k(String str, String str2, long j, Bundle bundle) {
        zzc();
        zza(str, str2, j, bundle, true, this.f18638b == null || zzkw.m10995S(str2), false, (String) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    @androidx.annotation.WorkerThread
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo20389m(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzc()
            r8.zzv()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0060
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0050
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0050
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0035
            r4 = r2
            goto L_0x0037
        L_0x0035:
            r4 = 0
        L_0x0037:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.m3 r0 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfj r0 = r0.f18242r
            long r4 = r10.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004b
            java.lang.String r11 = "true"
        L_0x004b:
            r0.zza(r11)
            r6 = r10
            goto L_0x005e
        L_0x0050:
            if (r11 != 0) goto L_0x0060
            com.google.android.gms.measurement.internal.m3 r10 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfj r10 = r10.f18242r
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L_0x005e:
            r3 = r1
            goto L_0x0062
        L_0x0060:
            r3 = r10
            r6 = r11
        L_0x0062:
            com.google.android.gms.measurement.internal.zzfv r10 = r8.zzy
            boolean r10 = r10.zzaa()
            if (r10 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzer r9 = r8.zzq()
            com.google.android.gms.measurement.internal.zzet r9 = r9.zzw()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x0078:
            com.google.android.gms.measurement.internal.zzfv r10 = r8.zzy
            boolean r10 = r10.zzaf()
            if (r10 != 0) goto L_0x0081
            return
        L_0x0081:
            com.google.android.gms.measurement.internal.zzkr r10 = new com.google.android.gms.measurement.internal.zzkr
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzio r9 = r8.zzg()
            r9.zza((com.google.android.gms.measurement.internal.zzkr) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgy.mo20389m(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: t */
    public final void mo20390t(String str, String str2, Bundle bundle) {
        zzc();
        mo20388k(str, str2, zzl().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public final /* synthetic */ void mo20391v(Bundle bundle) {
        if (zzny.zzb() && zzs().zza(zzat.zzby)) {
            if (bundle == null) {
                zzr().f18225B.zza(new Bundle());
                return;
            }
            Bundle zza2 = zzr().f18225B.zza();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzo();
                    if (zzkw.m11009v(obj)) {
                        zzo().zza(this.f18650n, 27, (String) null, (String) null, 0);
                    }
                    zzq().zzj().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzkw.m10995S(str)) {
                    zzq().zzj().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    zza2.remove(str);
                } else if (zzo().mo20554A("param", str, 100, obj)) {
                    zzo().mo20573n(zza2, str, obj);
                }
            }
            zzo();
            if (zzkw.m11007t(zza2, zzs().zzd())) {
                zzo().zza(this.f18650n, 26, (String) null, (String) null, 0);
                zzq().zzj().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            zzr().f18225B.zza(zza2);
            zzg().zza(zza2);
        }
    }

    public final void zza(@Nullable Boolean bool) {
        zzv();
        zzp().zza((Runnable) new C3033k5(this, bool));
    }

    public final void zzaa() {
        if (zzm().getApplicationContext() instanceof Application) {
            ((Application) zzm().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzab() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzp().mo20330c(atomicReference, 15000, "boolean test flag value", new C3104s4(this, atomicReference));
    }

    public final String zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzp().mo20330c(atomicReference, 15000, "String test flag value", new C2956c5(this, atomicReference));
    }

    public final Long zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzp().mo20330c(atomicReference, 15000, "long test flag value", new C2986f5(this, atomicReference));
    }

    public final Integer zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzp().mo20330c(atomicReference, 15000, "int test flag value", new C3015i5(this, atomicReference));
    }

    public final Double zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzp().mo20330c(atomicReference, 15000, "double test flag value", new C3006h5(this, atomicReference));
    }

    @Nullable
    public final String zzag() {
        return this.f18641e.get();
    }

    @WorkerThread
    public final void zzah() {
        zzc();
        zzv();
        if (this.zzy.zzaf()) {
            if (zzs().zza(zzat.zzbc)) {
                Boolean f = zzs().mo20604f("google_analytics_deferred_deep_link_enabled");
                if (f != null && f.booleanValue()) {
                    zzq().zzv().zza("Deferred Deep Link feature enabled.");
                    zzp().zza((Runnable) new C3077p4(this));
                }
            }
            zzg().zzad();
            this.f18649m = false;
            String zzx = zzr().zzx();
            if (!TextUtils.isEmpty(zzx)) {
                zzk().zzaa();
                if (!zzx.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzx);
                    zza("auto", "_ou", bundle);
                }
            }
        }
    }

    @Nullable
    public final String zzai() {
        zzig zzaa = this.zzy.zzu().zzaa();
        if (zzaa != null) {
            return zzaa.zza;
        }
        return null;
    }

    @Nullable
    public final String zzaj() {
        zzig zzaa = this.zzy.zzu().zzaa();
        if (zzaa != null) {
            return zzaa.zzb;
        }
        return null;
    }

    @Nullable
    public final String zzak() {
        if (this.zzy.zzn() != null) {
            return this.zzy.zzn();
        }
        try {
            return zzih.zza(zzm(), "google_app_id");
        } catch (IllegalStateException e) {
            this.zzy.zzq().zze().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final void zzb(zzgw zzgw) {
        zzv();
        Preconditions.checkNotNull(zzgw);
        if (!this.f18639c.remove(zzgw)) {
            zzq().zzh().zza("OnEventListener had not been registered");
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        m10841u((String) null, str, str2, bundle);
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

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final void zza(Bundle bundle, int i, long j) {
        if (zzmj.zzb() && zzs().zza(zzat.zzcg)) {
            zzv();
            String zza2 = zzad.zza(bundle);
            if (zza2 != null) {
                zzq().zzj().zza("Ignoring invalid consent setting", zza2);
                zzq().zzj().zza("Valid consent values are 'granted', 'denied'");
            }
            zza(zzad.zzb(bundle), i, j);
        }
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        m10838q(new Bundle(bundle), zzl().currentTimeMillis());
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final void zza(zzad zzad, int i, long j) {
        boolean z;
        boolean z2;
        boolean z3;
        zzad zzad2 = zzad;
        if (zzmj.zzb() && zzs().zza(zzat.zzcg)) {
            zzv();
            if (zzad.zzb() == null && zzad.zzd() == null) {
                zzq().zzj().zza("Discarding empty consent settings");
                return;
            }
            synchronized (this.f18642f) {
                int i2 = i;
                z = true;
                z2 = false;
                if (zzad.zza(i, this.f18644h)) {
                    boolean zza2 = zzad.zza(this.f18643g);
                    if (zzad.zze() && !this.f18643g.zze()) {
                        z2 = true;
                    }
                    zzad2 = zzad.zzc(this.f18643g);
                    this.f18643g = zzad2;
                    z3 = z2;
                    z2 = zza2;
                } else {
                    z = false;
                    z3 = false;
                }
            }
            if (!z) {
                zzq().zzu().zza("Ignoring lower-priority consent settings, proposed settings", zzad2);
                return;
            }
            long andIncrement = this.f18645i.getAndIncrement();
            if (z2) {
                mo20387j((String) null);
                zzp().zzb((Runnable) new C3024j5(this, zzad2, j, i, andIncrement, z3));
                return;
            }
            zzp().zza((Runnable) new C3051m5(this, zzad2, i, andIncrement, z3));
        }
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzl().currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0426  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0442  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0152  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r21, java.lang.String r22, long r23, android.os.Bundle r25, boolean r26, boolean r27, boolean r28, java.lang.String r29) {
        /*
            r20 = this;
            r7 = r20
            r8 = r21
            r15 = r22
            r13 = r23
            r12 = r25
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            r20.zzc()
            r20.zzv()
            com.google.android.gms.measurement.internal.zzfv r1 = r7.zzy
            boolean r1 = r1.zzaa()
            if (r1 != 0) goto L_0x002e
            com.google.android.gms.measurement.internal.zzer r0 = r20.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzv()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        L_0x002e:
            com.google.android.gms.measurement.internal.zzek r1 = r20.zzf()
            java.util.List r1 = r1.mo20280h()
            if (r1 == 0) goto L_0x004c
            boolean r1 = r1.contains(r15)
            if (r1 != 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzer r0 = r20.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzv()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zza(r1, r15, r8)
            return
        L_0x004c:
            boolean r1 = r7.f18640d
            r11 = 0
            r10 = 0
            r9 = 1
            if (r1 != 0) goto L_0x00a2
            r7.f18640d = r9
            com.google.android.gms.measurement.internal.zzfv r1 = r7.zzy     // Catch:{ ClassNotFoundException -> 0x0095 }
            boolean r1 = r1.zzs()     // Catch:{ ClassNotFoundException -> 0x0095 }
            if (r1 != 0) goto L_0x006a
            android.content.Context r1 = r20.zzm()     // Catch:{ ClassNotFoundException -> 0x0095 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0095 }
            java.lang.Class r0 = java.lang.Class.forName(r0, r9, r1)     // Catch:{ ClassNotFoundException -> 0x0095 }
            goto L_0x006e
        L_0x006a:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0095 }
        L_0x006e:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x0086 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r10] = r3     // Catch:{ Exception -> 0x0086 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0086 }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0086 }
            android.content.Context r2 = r20.zzm()     // Catch:{ Exception -> 0x0086 }
            r1[r10] = r2     // Catch:{ Exception -> 0x0086 }
            r0.invoke(r11, r1)     // Catch:{ Exception -> 0x0086 }
            goto L_0x00a2
        L_0x0086:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzer r1 = r20.zzq()     // Catch:{ ClassNotFoundException -> 0x0095 }
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzh()     // Catch:{ ClassNotFoundException -> 0x0095 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zza(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0095 }
            goto L_0x00a2
        L_0x0095:
            com.google.android.gms.measurement.internal.zzer r0 = r20.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzu()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00a2:
            com.google.android.gms.measurement.internal.zzy r0 = r20.zzs()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzbd
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x00d3
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x00d3
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00d3
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.common.util.Clock r0 = r20.zzl()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r20
            r1.mo20389m(r2, r3, r4, r5)
        L_0x00d3:
            boolean r0 = com.google.android.gms.internal.measurement.zzny.zzb()
            if (r0 == 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzy r0 = r20.zzs()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzby
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x00fe
            if (r26 == 0) goto L_0x00fe
            boolean r0 = com.google.android.gms.measurement.internal.zzkw.zzf(r22)
            if (r0 == 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzkw r0 = r20.zzo()
            com.google.android.gms.measurement.internal.m3 r1 = r20.zzr()
            com.google.android.gms.measurement.internal.zzfe r1 = r1.f18225B
            android.os.Bundle r1 = r1.zza()
            r0.mo20572m(r12, r1)
        L_0x00fe:
            r0 = 40
            r1 = 2
            if (r28 == 0) goto L_0x0190
            java.lang.String r2 = "_iap"
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x0190
            com.google.android.gms.measurement.internal.zzfv r2 = r7.zzy
            com.google.android.gms.measurement.internal.zzkw r2 = r2.zzh()
            boolean r3 = com.google.android.gms.internal.measurement.zzlq.zzb()
            if (r3 == 0) goto L_0x0125
            com.google.android.gms.measurement.internal.zzy r3 = r20.zzs()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzck
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r4)
            if (r3 == 0) goto L_0x0125
            r3 = 1
            goto L_0x0126
        L_0x0125:
            r3 = 0
        L_0x0126:
            java.lang.String r4 = "event"
            boolean r5 = r2.mo20578z(r4, r15)
            r6 = 13
            if (r5 != 0) goto L_0x0132
        L_0x0130:
            r6 = 2
            goto L_0x0150
        L_0x0132:
            if (r3 == 0) goto L_0x013f
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzgs.zza
            java.lang.String[] r5 = com.google.android.gms.measurement.internal.zzgs.zzb
            boolean r3 = r2.mo20557F(r4, r3, r5, r15)
            if (r3 != 0) goto L_0x0148
            goto L_0x0150
        L_0x013f:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzgs.zza
            boolean r3 = r2.mo20556E(r4, r3, r15)
            if (r3 != 0) goto L_0x0148
            goto L_0x0150
        L_0x0148:
            boolean r2 = r2.mo20577y(r4, r0, r15)
            if (r2 != 0) goto L_0x014f
            goto L_0x0130
        L_0x014f:
            r6 = 0
        L_0x0150:
            if (r6 == 0) goto L_0x0190
            com.google.android.gms.measurement.internal.zzer r1 = r20.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzg()
            com.google.android.gms.measurement.internal.zzep r2 = r20.zzn()
            java.lang.String r2 = r2.zza((java.lang.String) r15)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzfv r1 = r7.zzy
            r1.zzh()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzkw.zza(r15, r0, r9)
            if (r15 == 0) goto L_0x0176
            int r10 = r22.length()
        L_0x0176:
            com.google.android.gms.measurement.internal.zzfv r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkw r1 = r1.zzh()
            com.google.android.gms.measurement.internal.w7 r2 = r7.f18650n
            java.lang.String r3 = "_ev"
            r21 = r1
            r22 = r2
            r23 = r6
            r24 = r3
            r25 = r0
            r26 = r10
            r21.zza(r22, r23, r24, r25, r26)
            return
        L_0x0190:
            com.google.android.gms.measurement.internal.zzij r2 = r20.zzh()
            com.google.android.gms.measurement.internal.zzig r2 = r2.zza((boolean) r10)
            java.lang.String r3 = "_sc"
            if (r2 == 0) goto L_0x01a4
            boolean r4 = r12.containsKey(r3)
            if (r4 != 0) goto L_0x01a4
            r2.f18661a = r9
        L_0x01a4:
            if (r26 == 0) goto L_0x01aa
            if (r28 == 0) goto L_0x01aa
            r4 = 1
            goto L_0x01ab
        L_0x01aa:
            r4 = 0
        L_0x01ab:
            com.google.android.gms.measurement.internal.zzij.zza((com.google.android.gms.measurement.internal.zzig) r2, (android.os.Bundle) r12, (boolean) r4)
            java.lang.String r2 = "am"
            boolean r16 = r2.equals(r8)
            boolean r2 = com.google.android.gms.measurement.internal.zzkw.m10995S(r22)
            if (r26 == 0) goto L_0x01ed
            com.google.android.gms.measurement.internal.zzgx r4 = r7.f18638b
            if (r4 == 0) goto L_0x01ed
            if (r2 != 0) goto L_0x01ed
            if (r16 != 0) goto L_0x01ed
            com.google.android.gms.measurement.internal.zzer r0 = r20.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzv()
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzn()
            java.lang.String r1 = r1.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzep r2 = r20.zzn()
            java.lang.String r2 = r2.zza((android.os.Bundle) r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zza(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzgx r1 = r7.f18638b
            r2 = r21
            r3 = r22
            r4 = r25
            r5 = r23
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01ed:
            com.google.android.gms.measurement.internal.zzfv r2 = r7.zzy
            boolean r2 = r2.zzaf()
            if (r2 != 0) goto L_0x01f6
            return
        L_0x01f6:
            com.google.android.gms.measurement.internal.zzkw r2 = r20.zzo()
            boolean r4 = com.google.android.gms.internal.measurement.zzlq.zzb()
            if (r4 == 0) goto L_0x020e
            com.google.android.gms.measurement.internal.zzy r4 = r20.zzs()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzat.zzck
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r5)
            if (r4 == 0) goto L_0x020e
            r4 = 1
            goto L_0x020f
        L_0x020e:
            r4 = 0
        L_0x020f:
            int r2 = r2.mo20565c(r15, r4)
            if (r2 == 0) goto L_0x0253
            com.google.android.gms.measurement.internal.zzer r1 = r20.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzg()
            com.google.android.gms.measurement.internal.zzep r3 = r20.zzn()
            java.lang.String r3 = r3.zza((java.lang.String) r15)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r1.zza(r4, r3)
            r20.zzo()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzkw.zza(r15, r0, r9)
            if (r15 == 0) goto L_0x0237
            int r10 = r22.length()
        L_0x0237:
            com.google.android.gms.measurement.internal.zzfv r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkw r1 = r1.zzh()
            com.google.android.gms.measurement.internal.w7 r3 = r7.f18650n
            java.lang.String r4 = "_ev"
            r21 = r1
            r22 = r3
            r23 = r29
            r24 = r2
            r25 = r4
            r26 = r0
            r27 = r10
            r21.mo20575p(r22, r23, r24, r25, r26, r27)
            return
        L_0x0253:
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r5 = "_o"
            r0[r10] = r5
            java.lang.String r2 = "_sn"
            r0[r9] = r2
            r0[r1] = r3
            r1 = 3
            java.lang.String r4 = "_si"
            r0[r1] = r4
            java.util.List r0 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r0)
            com.google.android.gms.measurement.internal.zzkw r1 = r20.zzo()
            r6 = 1
            r9 = r1
            r1 = 0
            r10 = r29
            r17 = r11
            r11 = r22
            r12 = r25
            r13 = r0
            r14 = r28
            r15 = r6
            android.os.Bundle r0 = r9.mo20569h(r10, r11, r12, r13, r14, r15)
            if (r0 == 0) goto L_0x02a8
            boolean r6 = r0.containsKey(r3)
            if (r6 == 0) goto L_0x02a8
            boolean r6 = r0.containsKey(r4)
            if (r6 != 0) goto L_0x028f
            goto L_0x02a8
        L_0x028f:
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r3 = r0.getString(r3)
            long r9 = r0.getLong(r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r9)
            com.google.android.gms.measurement.internal.zzig r6 = new com.google.android.gms.measurement.internal.zzig
            long r9 = r4.longValue()
            r6.<init>(r2, r3, r9)
        L_0x02a8:
            com.google.android.gms.measurement.internal.zzy r2 = r20.zzs()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzas
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r3)
            java.lang.String r9 = "_ae"
            r10 = 0
            if (r2 == 0) goto L_0x02e0
            com.google.android.gms.measurement.internal.zzij r2 = r20.zzh()
            com.google.android.gms.measurement.internal.zzig r2 = r2.zza((boolean) r1)
            if (r2 == 0) goto L_0x02e0
            r12 = r22
            boolean r2 = r9.equals(r12)
            if (r2 == 0) goto L_0x02e2
            com.google.android.gms.measurement.internal.zzju r2 = r20.zzj()
            com.google.android.gms.measurement.internal.h7 r2 = r2.zzb
            long r2 = r2.mo19931e()
            int r4 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x02e2
            com.google.android.gms.measurement.internal.zzkw r4 = r20.zzo()
            r4.zza((android.os.Bundle) r0, (long) r2)
            goto L_0x02e2
        L_0x02e0:
            r12 = r22
        L_0x02e2:
            boolean r2 = com.google.android.gms.internal.measurement.zzmu.zzb()
            if (r2 == 0) goto L_0x0364
            com.google.android.gms.measurement.internal.zzy r2 = r20.zzs()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbo
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x0364
            java.lang.String r2 = "auto"
            boolean r2 = r2.equals(r8)
            java.lang.String r3 = "_ffr"
            if (r2 != 0) goto L_0x0347
            java.lang.String r2 = "_ssr"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0347
            com.google.android.gms.measurement.internal.zzkw r2 = r20.zzo()
            java.lang.String r3 = r0.getString(r3)
            boolean r4 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r3)
            if (r4 == 0) goto L_0x0317
            r3 = r17
            goto L_0x031b
        L_0x0317:
            java.lang.String r3 = r3.trim()
        L_0x031b:
            com.google.android.gms.measurement.internal.m3 r4 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfj r4 = r4.f18249y
            java.lang.String r4 = r4.zza()
            boolean r4 = com.google.android.gms.measurement.internal.zzkw.m10994R(r3, r4)
            if (r4 == 0) goto L_0x033a
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzv()
            java.lang.String r3 = "Not logging duplicate session_start_with_rollout event"
            r2.zza(r3)
            r2 = 0
            goto L_0x0344
        L_0x033a:
            com.google.android.gms.measurement.internal.m3 r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfj r2 = r2.f18249y
            r2.zza(r3)
            r2 = 1
        L_0x0344:
            if (r2 != 0) goto L_0x0364
            return
        L_0x0347:
            boolean r2 = r9.equals(r12)
            if (r2 == 0) goto L_0x0364
            com.google.android.gms.measurement.internal.zzkw r2 = r20.zzo()
            com.google.android.gms.measurement.internal.m3 r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfj r2 = r2.f18249y
            java.lang.String r2 = r2.zza()
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L_0x0364
            r0.putString(r3, r2)
        L_0x0364:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r13.add(r0)
            com.google.android.gms.measurement.internal.zzkw r2 = r20.zzo()
            java.security.SecureRandom r2 = r2.mo20564V()
            r2.nextLong()
            com.google.android.gms.measurement.internal.m3 r2 = r20.zzr()
            com.google.android.gms.measurement.internal.zzfh r2 = r2.f18244t
            long r2 = r2.zza()
            int r4 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x03e4
            com.google.android.gms.measurement.internal.m3 r2 = r20.zzr()
            r14 = r23
            boolean r2 = r2.mo20037c(r14)
            if (r2 == 0) goto L_0x03e6
            com.google.android.gms.measurement.internal.m3 r2 = r20.zzr()
            com.google.android.gms.measurement.internal.zzff r2 = r2.f18246v
            boolean r2 = r2.zza()
            if (r2 == 0) goto L_0x03e6
            com.google.android.gms.measurement.internal.zzer r2 = r20.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzw()
            java.lang.String r3 = "Current session is expired, remove the session number, ID, and engagement time"
            r2.zza(r3)
            r4 = 0
            com.google.android.gms.common.util.Clock r2 = r20.zzl()
            long r17 = r2.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sid"
            r6 = 0
            r1 = r20
            r19 = r5
            r5 = r17
            r1.mo20389m(r2, r3, r4, r5)
            com.google.android.gms.common.util.Clock r1 = r20.zzl()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r20
            r1.mo20389m(r2, r3, r4, r5)
            com.google.android.gms.common.util.Clock r1 = r20.zzl()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r20
            r1.mo20389m(r2, r3, r4, r5)
            goto L_0x03e8
        L_0x03e4:
            r14 = r23
        L_0x03e6:
            r19 = r5
        L_0x03e8:
            java.lang.String r1 = "extend_session"
            long r1 = r0.getLong(r1, r10)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x040e
            com.google.android.gms.measurement.internal.zzer r1 = r20.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzw()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfv r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzju r1 = r1.zzd()
            com.google.android.gms.measurement.internal.j7 r1 = r1.zza
            r10 = 1
            r1.mo20011b(r14, r10)
            goto L_0x040f
        L_0x040e:
            r10 = 1
        L_0x040f:
            java.util.Set r1 = r0.keySet()
            int r2 = r0.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.Arrays.sort(r1)
            int r2 = r1.length
            r3 = 0
        L_0x0424:
            if (r3 >= r2) goto L_0x043b
            r4 = r1[r3]
            r20.zzo()
            java.lang.Object r5 = r0.get(r4)
            android.os.Bundle[] r5 = com.google.android.gms.measurement.internal.zzkw.m10992N(r5)
            if (r5 == 0) goto L_0x0438
            r0.putParcelableArray(r4, r5)
        L_0x0438:
            int r3 = r3 + 1
            goto L_0x0424
        L_0x043b:
            r0 = 0
        L_0x043c:
            int r1 = r13.size()
            if (r0 >= r1) goto L_0x04aa
            java.lang.Object r1 = r13.get(r0)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r0 == 0) goto L_0x044c
            r2 = 1
            goto L_0x044d
        L_0x044c:
            r2 = 0
        L_0x044d:
            if (r2 == 0) goto L_0x0452
            java.lang.String r2 = "_ep"
            goto L_0x0453
        L_0x0452:
            r2 = r12
        L_0x0453:
            r11 = r19
            r1.putString(r11, r8)
            if (r27 == 0) goto L_0x0462
            com.google.android.gms.measurement.internal.zzkw r3 = r20.zzo()
            android.os.Bundle r1 = r3.mo20568g(r1)
        L_0x0462:
            r5 = r1
            com.google.android.gms.measurement.internal.zzar r6 = new com.google.android.gms.measurement.internal.zzar
            com.google.android.gms.measurement.internal.zzam r3 = new com.google.android.gms.measurement.internal.zzam
            r3.<init>(r5)
            r1 = r6
            r4 = r21
            r10 = r5
            r8 = r6
            r5 = r23
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzio r1 = r20.zzg()
            r5 = r29
            r1.zza((com.google.android.gms.measurement.internal.zzar) r8, (java.lang.String) r5)
            if (r16 != 0) goto L_0x04a2
            java.util.Set<com.google.android.gms.measurement.internal.zzgw> r1 = r7.f18639c
            java.util.Iterator r8 = r1.iterator()
        L_0x0485:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x04a2
            java.lang.Object r1 = r8.next()
            com.google.android.gms.measurement.internal.zzgw r1 = (com.google.android.gms.measurement.internal.zzgw) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r10)
            r2 = r21
            r3 = r22
            r5 = r23
            r1.onEvent(r2, r3, r4, r5)
            r5 = r29
            goto L_0x0485
        L_0x04a2:
            int r0 = r0 + 1
            r8 = r21
            r19 = r11
            r10 = 1
            goto L_0x043c
        L_0x04aa:
            com.google.android.gms.measurement.internal.zzij r0 = r20.zzh()
            r1 = 0
            com.google.android.gms.measurement.internal.zzig r0 = r0.zza((boolean) r1)
            if (r0 == 0) goto L_0x04cb
            boolean r0 = r9.equals(r12)
            if (r0 == 0) goto L_0x04cb
            com.google.android.gms.measurement.internal.zzju r0 = r20.zzj()
            com.google.android.gms.common.util.Clock r1 = r20.zzl()
            long r1 = r1.elapsedRealtime()
            r3 = 1
            r0.zza(r3, r3, r1)
        L_0x04cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgy.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zza();
        m10840s(str, str2, zzl().currentTimeMillis(), bundle, false, true, false, str3);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (zzs().zza(zzat.zzbu)) {
            String str4 = str2;
            if (zzkw.m10994R(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
                zzh().zza(bundle2, j);
                return;
            }
        } else {
            String str5 = str2;
        }
        long j2 = j;
        m10840s(str3, str2, j, bundle2, z2, !z2 || this.f18638b == null || zzkw.m10995S(str2), !z, (String) null);
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, true, zzl().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int i2;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z) {
            i = zzo().mo20558I(str2);
        } else {
            zzkw zzo = zzo();
            if (zzo.mo20578z("user property", str2)) {
                if (!zzo.mo20556E("user property", zzgu.zza, str2)) {
                    i = 15;
                } else if (zzo.mo20577y("user property", 24, str2)) {
                    i = 0;
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzo();
            this.zzy.zzh().zza(this.f18650n, i, "_ev", zzkw.zza(str2, 24, true), str2 != null ? str2.length() : 0);
        } else if (obj != null) {
            int J = zzo().mo20559J(str2, obj);
            if (J != 0) {
                zzo();
                String zza2 = zzkw.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                } else {
                    i2 = 0;
                }
                this.zzy.zzh().zza(this.f18650n, J, "_ev", zza2, i2);
                return;
            }
            Object O = zzo().mo20561O(str2, obj);
            if (O != null) {
                m10834l(str3, str2, j, O);
            }
        } else {
            m10834l(str3, str2, j, (Object) null);
        }
    }

    public final List<zzkr> zza(boolean z) {
        zzv();
        zzq().zzw().zza("Getting user properties (FE)");
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzx.zza()) {
            zzq().zze().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().mo20330c(atomicReference, 5000, "get user properties", new C3158y4(this, atomicReference, z));
            List<zzkr> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzq().zze().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    @WorkerThread
    public final void zza(zzgx zzgx) {
        zzgx zzgx2;
        zzc();
        zzv();
        if (!(zzgx == null || zzgx == (zzgx2 = this.f18638b))) {
            Preconditions.checkState(zzgx2 == null, "EventInterceptor already set.");
        }
        this.f18638b = zzgx;
    }

    public final void zza(zzgw zzgw) {
        zzv();
        Preconditions.checkNotNull(zzgw);
        if (!this.f18639c.add(zzgw)) {
            zzq().zzh().zza("OnEventListener already registered");
        }
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzl().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzq().zzh().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        m10838q(bundle2, j);
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        m10841u(str, str2, str3, bundle);
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        return m10836o((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return m10836o(str, str2, str3);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return m10837p((String) null, str, str2, z);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return m10837p(str, str2, str3, z);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
