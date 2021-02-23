package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzawx {

    /* renamed from: a */
    private final AtomicReference<ExecutorService> f12902a = new AtomicReference<>((Object) null);

    /* renamed from: b */
    private final Object f12903b = new Object();
    @GuardedBy("gmpAppIdLock")
    @Nullable

    /* renamed from: c */
    private String f12904c = null;
    @GuardedBy("gmpAppIdLock")
    @Nullable

    /* renamed from: d */
    private String f12905d = null;
    @VisibleForTesting

    /* renamed from: e */
    private final AtomicBoolean f12906e = new AtomicBoolean(false);

    /* renamed from: f */
    private final AtomicInteger f12907f = new AtomicInteger(-1);

    /* renamed from: g */
    private final AtomicReference<Object> f12908g = new AtomicReference<>((Object) null);

    /* renamed from: h */
    private final AtomicReference<Object> f12909h = new AtomicReference<>((Object) null);

    /* renamed from: i */
    private final ConcurrentMap<String, Method> f12910i = new ConcurrentHashMap(9);

    /* renamed from: j */
    private final AtomicReference<zzbgf> f12911j = new AtomicReference<>((Object) null);
    @GuardedBy("proxyReference")

    /* renamed from: k */
    private final BlockingQueue<FutureTask<?>> f12912k = new ArrayBlockingQueue(20);

    /* renamed from: l */
    private final Object f12913l = new Object();

    /* renamed from: a */
    private final Object m7587a(String str, Context context) {
        if (!m7592g(context, "com.google.android.gms.measurement.AppMeasurement", this.f12908g, true)) {
            return null;
        }
        try {
            return m7598n(context, str).invoke(this.f12908g.get(), new Object[0]);
        } catch (Exception unused) {
            m7595k(str, true);
            return null;
        }
    }

    /* renamed from: b */
    private final <T> T m7588b(String str, @Nullable T t, C2052j5<T> j5Var) {
        synchronized (this.f12911j) {
            if (this.f12911j.get() != null) {
                try {
                    T a = j5Var.mo13631a(this.f12911j.get());
                    return a;
                } catch (Exception unused) {
                    m7595k(str, false);
                    return t;
                }
            }
        }
    }

    /* renamed from: c */
    private final void m7589c(Context context, String str, String str2) {
        if (m7592g(context, "com.google.android.gms.measurement.AppMeasurement", this.f12908g, true)) {
            Method l = m7596l(context, str2);
            try {
                l.invoke(this.f12908g.get(), new Object[]{str});
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzd.zzee(sb.toString());
            } catch (Exception unused) {
                m7595k(str2, false);
            }
        }
    }

    /* renamed from: d */
    private final void m7590d(Context context, String str, String str2, @Nullable Bundle bundle) {
        if (zzz(context)) {
            Bundle m = m7597m(str2, str);
            if (bundle != null) {
                m.putAll(bundle);
            }
            if (m7593h(context)) {
                m7591f("logEventInternal", new C2537w4(str, m));
            } else if (m7592g(context, "com.google.android.gms.measurement.AppMeasurement", this.f12908g, true)) {
                Method i = m7594i(context);
                try {
                    i.invoke(this.f12908g.get(), new Object[]{"am", str, m});
                } catch (Exception unused) {
                    m7595k("logEventInternal", true);
                }
            }
        }
    }

    /* renamed from: f */
    private final void m7591f(String str, C2126l5 l5Var) {
        synchronized (this.f12911j) {
            FutureTask futureTask = new FutureTask(new C1719a5(this, l5Var, str), (Object) null);
            if (this.f12911j.get() != null) {
                futureTask.run();
            } else {
                this.f12912k.offer(futureTask);
            }
        }
    }

    /* renamed from: g */
    private final boolean m7592g(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet((Object) null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
            } catch (Exception unused) {
                m7595k("getInstance", z);
                return false;
            }
        }
        return true;
    }

    @VisibleForTesting
    /* renamed from: h */
    private static boolean m7593h(Context context) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcns)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzwq.zzqe().zzd(zzabf.zzcnt)).intValue()) {
            return false;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnu)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    @Nullable
    /* renamed from: i */
    private final Method m7594i(Context context) {
        Class<String> cls = String.class;
        Method method = (Method) this.f12910i.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[]{cls, cls, Bundle.class});
            this.f12910i.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            m7595k("logEventInternal", true);
            return null;
        }
    }

    /* renamed from: k */
    private final void m7595k(String str, boolean z) {
        if (!this.f12906e.get()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
            sb.append("Invoke Firebase method ");
            sb.append(str);
            sb.append(" error.");
            zzaza.zzfa(sb.toString());
            if (z) {
                zzaza.zzfa("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.f12906e.set(true);
            }
        }
    }

    @Nullable
    /* renamed from: l */
    private final Method m7596l(Context context, String str) {
        Method method = (Method) this.f12910i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class});
            this.f12910i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            m7595k(str, false);
            return null;
        }
    }

    /* renamed from: m */
    private static Bundle m7597m(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzaza.zzc(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    @Nullable
    /* renamed from: n */
    private final Method m7598n(Context context, String str) {
        Method method = (Method) this.f12910i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.f12910i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            m7595k(str, false);
            return null;
        }
    }

    /* renamed from: o */
    private final Method m7599o(Context context, String str) {
        Class<String> cls = String.class;
        Method method = (Method) this.f12910i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, new Class[]{Activity.class, cls, cls});
            this.f12910i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            m7595k(str, false);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.concurrent.ExecutorService m7600p() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r0 = r9.f12902a
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0064
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzdul r0 = com.google.android.gms.internal.ads.zzduo.zzayg()
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabf.zzcnr
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.util.concurrent.ThreadFactory r2 = r9.m7601q()
            int r3 = com.google.android.gms.internal.ads.zzdut.zzhsl
            java.util.concurrent.ExecutorService r0 = r0.zza(r1, r2, r3)
            goto L_0x005e
        L_0x002d:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabf.zzcnr
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r2 = r2.zzd(r1)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r1 = r3.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r3 = r1.intValue()
            r4 = 1
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MINUTES
            java.util.concurrent.LinkedBlockingQueue r7 = new java.util.concurrent.LinkedBlockingQueue
            r7.<init>()
            java.util.concurrent.ThreadFactory r8 = r9.m7601q()
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r7, r8)
        L_0x005e:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r1 = r9.f12902a
            r2 = 0
            r1.compareAndSet(r2, r0)
        L_0x0064:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r0 = r9.f12902a
            java.lang.Object r0 = r0.get()
            java.util.concurrent.ExecutorService r0 = (java.util.concurrent.ExecutorService) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawx.m7600p():java.util.concurrent.ExecutorService");
    }

    /* renamed from: q */
    private final ThreadFactory m7601q() {
        return new C2089k5(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo15821e(C2126l5 l5Var, String str) {
        if (this.f12911j.get() != null) {
            try {
                l5Var.mo13736a(this.f12911j.get());
            } catch (Exception unused) {
                m7595k(str, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final /* synthetic */ String mo15822j(Context context) {
        return (String) m7587a("getAppInstanceId", context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public final /* synthetic */ String mo15823r() {
        return (String) m7588b("getAppInstanceId", (Object) null, C2650z4.f12256a);
    }

    public final void zza(Context context, zzaae zzaae) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnx)).booleanValue() && zzz(context) && m7593h(context)) {
            synchronized (this.f12913l) {
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzab(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "getCurrentScreenName"
            boolean r1 = r6.zzz(r7)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x000b
            return r2
        L_0x000b:
            boolean r1 = m7593h(r7)
            if (r1 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.j5 r7 = com.google.android.gms.internal.ads.C1756b5.f7873a
            java.lang.String r0 = "getCurrentScreenNameOrScreenClass"
            java.lang.Object r7 = r6.m7588b(r0, r2, r7)
            java.lang.String r7 = (java.lang.String) r7
            return r7
        L_0x001c:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r6.f12908g
            r3 = 1
            java.lang.String r4 = "com.google.android.gms.measurement.AppMeasurement"
            boolean r1 = r6.m7592g(r7, r4, r1, r3)
            if (r1 != 0) goto L_0x0028
            return r2
        L_0x0028:
            r1 = 0
            java.lang.reflect.Method r3 = r6.m7598n(r7, r0)     // Catch:{ Exception -> 0x0056 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r4 = r6.f12908g     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0056 }
            if (r3 != 0) goto L_0x0052
            java.lang.String r3 = "getCurrentScreenClass"
            java.lang.reflect.Method r7 = r6.m7598n(r7, r3)     // Catch:{ Exception -> 0x0056 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r3 = r6.f12908g     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r7 = r7.invoke(r3, r4)     // Catch:{ Exception -> 0x0056 }
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0056 }
        L_0x0052:
            if (r3 == 0) goto L_0x0055
            return r3
        L_0x0055:
            return r2
        L_0x0056:
            r6.m7595k(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawx.zzab(android.content.Context):java.lang.String");
    }

    @Nullable
    public final String zzac(Context context) {
        if (!zzz(context)) {
            return null;
        }
        synchronized (this.f12903b) {
            String str = this.f12904c;
            if (str != null) {
                return str;
            }
            if (m7593h(context)) {
                this.f12904c = (String) m7588b("getGmpAppId", this.f12904c, C1830d5.f8051a);
            } else {
                this.f12904c = (String) m7587a("getGmpAppId", context);
            }
            String str2 = this.f12904c;
            return str2;
        }
    }

    @Nullable
    public final String zzad(Context context) {
        if (!zzz(context)) {
            return null;
        }
        long longValue = ((Long) zzwq.zzqe().zzd(zzabf.zzcnq)).longValue();
        if (m7593h(context)) {
            if (longValue >= 0) {
                return (String) m7600p().submit(new C1904f5(this)).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) m7588b("getAppInstanceId", (Object) null, C1941g5.f8514a);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        } else if (longValue < 0) {
            return (String) m7587a("getAppInstanceId", context);
        } else {
            try {
                return (String) m7600p().submit(new C2015i5(this, context)).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused3) {
                return "TIME_OUT";
            } catch (Exception unused4) {
                return null;
            }
        }
    }

    @Nullable
    public final String zzae(Context context) {
        if (!zzz(context)) {
            return null;
        }
        if (m7593h(context)) {
            Long l = (Long) m7588b("getAdEventId", (Object) null, C1978h5.f8831a);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object a = m7587a("generateEventId", context);
        if (a != null) {
            return a.toString();
        }
        return null;
    }

    @Nullable
    public final String zzaf(Context context) {
        if (!zzz(context)) {
            return null;
        }
        synchronized (this.f12903b) {
            String str = this.f12905d;
            if (str != null) {
                return str;
            }
            if (m7593h(context)) {
                this.f12905d = (String) m7588b("getAppIdOrigin", this.f12905d, C2575x4.f11758a);
            } else {
                this.f12905d = "fa";
            }
            String str2 = this.f12905d;
            return str2;
        }
    }

    public final void zzd(Context context, String str) {
        if (zzz(context)) {
            if (m7593h(context)) {
                m7591f("beginAdUnitExposure", new C2500v4(str));
            } else {
                m7589c(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zze(Context context, String str) {
        if (zzz(context)) {
            if (m7593h(context)) {
                m7591f("endAdUnitExposure", new C1793c5(str));
            } else {
                m7589c(context, str, "endAdUnitExposure");
            }
        }
    }

    @Deprecated
    public final void zzf(Context context, String str) {
        if (!zzz(context) || !(context instanceof Activity)) {
            return;
        }
        if (m7593h(context)) {
            m7591f("setScreenName", new C1867e5(context, str));
        } else if (m7592g(context, "com.google.firebase.analytics.FirebaseAnalytics", this.f12909h, false)) {
            Method o = m7599o(context, "setCurrentScreen");
            try {
                o.invoke(this.f12909h.get(), new Object[]{(Activity) context, str, context.getPackageName()});
            } catch (Exception unused) {
                m7595k("setCurrentScreen", false);
            }
        }
    }

    public final void zzg(Context context, String str) {
        m7590d(context, "_ac", str, (Bundle) null);
    }

    public final void zzh(Context context, String str) {
        m7590d(context, "_ai", str, (Bundle) null);
    }

    public final void zzi(Context context, String str) {
        m7590d(context, "_aq", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        m7590d(context, "_aa", str, (Bundle) null);
    }

    public final boolean zzz(Context context) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnl)).booleanValue() && !this.f12906e.get()) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnv)).booleanValue()) {
                return true;
            }
            if (this.f12907f.get() == -1) {
                zzwq.zzqa();
                if (!zzayr.zzd(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzwq.zzqa();
                    if (zzayr.zzbp(context)) {
                        zzaza.zzfa("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.f12907f.set(0);
                    }
                }
                this.f12907f.set(1);
            }
            if (this.f12907f.get() == 1) {
                return true;
            }
        }
        return false;
    }

    public final void zza(Context context, zzvk zzvk) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnx)).booleanValue() && zzz(context) && m7593h(context)) {
            synchronized (this.f12913l) {
            }
        }
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzz(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            m7590d(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzd.zzee(sb.toString());
        }
    }
}
