package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public abstract class zzdh<T> {

    /* renamed from: g */
    private static final Object f17625g = new Object();
    @Nullable

    /* renamed from: h */
    private static volatile C2797k1 f17626h;

    /* renamed from: i */
    private static zzdq f17627i = new zzdq(C2765g1.f17315a);

    /* renamed from: j */
    private static final AtomicInteger f17628j = new AtomicInteger();

    /* renamed from: a */
    private final zzdm f17629a;

    /* renamed from: b */
    private final String f17630b;

    /* renamed from: c */
    private final T f17631c;

    /* renamed from: d */
    private volatile int f17632d;

    /* renamed from: e */
    private volatile T f17633e;

    /* renamed from: f */
    private final boolean f17634f;

    static {
        new AtomicReference();
    }

    private zzdh(zzdm zzdm, String str, T t, boolean z) {
        this.f17632d = -1;
        if (zzdm.f17635a != null) {
            this.f17629a = zzdm;
            this.f17630b = str;
            this.f17631c = t;
            this.f17634f = z;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    /* renamed from: f */
    private final String m10311f(String str) {
        if (str != null && str.isEmpty()) {
            return this.f17630b;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f17630b);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: g */
    static void m10312g() {
        f17628j.incrementAndGet();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static zzdh<Double> m10313h(zzdm zzdm, String str, double d, boolean z) {
        return new C2773h1(zzdm, str, Double.valueOf(-3.0d), true);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static zzdh<Long> m10314i(zzdm zzdm, String str, long j, boolean z) {
        return new C2753f1(zzdm, str, Long.valueOf(j), true);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static zzdh<String> m10315j(zzdm zzdm, String str, String str2, boolean z) {
        return new C2789j1(zzdm, str, str2, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static zzdh<Boolean> m10316k(zzdm zzdm, String str, boolean z, boolean z2) {
        return new C2781i1(zzdm, str, Boolean.valueOf(z), true);
    }

    /* renamed from: l */
    static final /* synthetic */ zzdy m10317l(Context context) {
        new zzdc();
        return zzdc.zza(context);
    }

    /* renamed from: m */
    static final /* synthetic */ boolean m10318m() {
        return true;
    }

    @Deprecated
    public static void zza(Context context) {
        synchronized (f17625g) {
            C2797k1 k1Var = f17626h;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (k1Var == null || k1Var.mo18688a() != context) {
                zzct.m10301a();
                zzdo.m10321b();
                C2721b1.m9317b();
                f17626h = new C2899x0(context, zzef.zza(new C2745e1(context)));
                f17628j.incrementAndGet();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract T mo18624e(Object obj);

    public final String zzb() {
        return m10311f(this.f17629a.f17637c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzc() {
        /*
            r7 = this;
            boolean r0 = r7.f17634f
            if (r0 != 0) goto L_0x0011
            com.google.android.gms.internal.measurement.zzdq r0 = f17627i
            java.lang.String r1 = r7.f17630b
            boolean r0 = r0.zza(r1)
            java.lang.String r1 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            com.google.android.gms.internal.measurement.zzeb.zzb((boolean) r0, (java.lang.Object) r1)
        L_0x0011:
            java.util.concurrent.atomic.AtomicInteger r0 = f17628j
            int r0 = r0.get()
            int r1 = r7.f17632d
            if (r1 >= r0) goto L_0x0113
            monitor-enter(r7)
            int r1 = r7.f17632d     // Catch:{ all -> 0x0110 }
            if (r1 >= r0) goto L_0x010e
            com.google.android.gms.internal.measurement.k1 r1 = f17626h     // Catch:{ all -> 0x0110 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0028
            r4 = 1
            goto L_0x0029
        L_0x0028:
            r4 = 0
        L_0x0029:
            java.lang.String r5 = "Must call PhenotypeFlag.init() first"
            com.google.android.gms.internal.measurement.zzeb.zzb((boolean) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x0110 }
            android.content.Context r4 = r1.mo18688a()     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.measurement.b1 r4 = com.google.android.gms.internal.measurement.C2721b1.m9316a(r4)     // Catch:{ all -> 0x0110 }
            java.lang.String r5 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.Object r4 = r4.zza(r5)     // Catch:{ all -> 0x0110 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0110 }
            if (r4 == 0) goto L_0x004d
            java.util.regex.Pattern r5 = com.google.android.gms.internal.measurement.zzcp.zzb     // Catch:{ all -> 0x0110 }
            java.util.regex.Matcher r4 = r5.matcher(r4)     // Catch:{ all -> 0x0110 }
            boolean r4 = r4.matches()     // Catch:{ all -> 0x0110 }
            if (r4 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r2 = 0
        L_0x004e:
            r3 = 0
            if (r2 != 0) goto L_0x0091
            com.google.android.gms.internal.measurement.zzdm r2 = r7.f17629a     // Catch:{ all -> 0x0110 }
            android.net.Uri r2 = r2.f17635a     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x0078
            android.content.Context r2 = r1.mo18688a()     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.measurement.zzdm r4 = r7.f17629a     // Catch:{ all -> 0x0110 }
            android.net.Uri r4 = r4.f17635a     // Catch:{ all -> 0x0110 }
            boolean r2 = com.google.android.gms.internal.measurement.zzdf.zza(r2, r4)     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x0076
            android.content.Context r2 = r1.mo18688a()     // Catch:{ all -> 0x0110 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.measurement.zzdm r4 = r7.f17629a     // Catch:{ all -> 0x0110 }
            android.net.Uri r4 = r4.f17635a     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.measurement.zzct r2 = com.google.android.gms.internal.measurement.zzct.zza(r2, r4)     // Catch:{ all -> 0x0110 }
            goto L_0x0080
        L_0x0076:
            r2 = r3
            goto L_0x0080
        L_0x0078:
            android.content.Context r2 = r1.mo18688a()     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.measurement.zzdo r2 = com.google.android.gms.internal.measurement.zzdo.m10320a(r2, r3)     // Catch:{ all -> 0x0110 }
        L_0x0080:
            if (r2 == 0) goto L_0x00ba
            java.lang.String r4 = r7.zzb()     // Catch:{ all -> 0x0110 }
            java.lang.Object r2 = r2.zza(r4)     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x00ba
            java.lang.Object r2 = r7.mo18624e(r2)     // Catch:{ all -> 0x0110 }
            goto L_0x00bb
        L_0x0091:
            java.lang.String r2 = "PhenotypeFlag"
            r4 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r4)     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x00ba
            java.lang.String r2 = "PhenotypeFlag"
            java.lang.String r4 = "Bypass reading Phenotype values for flag: "
            java.lang.String r5 = r7.zzb()     // Catch:{ all -> 0x0110 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0110 }
            int r6 = r5.length()     // Catch:{ all -> 0x0110 }
            if (r6 == 0) goto L_0x00b1
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0110 }
            goto L_0x00b7
        L_0x00b1:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0110 }
            r5.<init>(r4)     // Catch:{ all -> 0x0110 }
            r4 = r5
        L_0x00b7:
            android.util.Log.d(r2, r4)     // Catch:{ all -> 0x0110 }
        L_0x00ba:
            r2 = r3
        L_0x00bb:
            if (r2 == 0) goto L_0x00be
            goto L_0x00df
        L_0x00be:
            android.content.Context r2 = r1.mo18688a()     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.measurement.b1 r2 = com.google.android.gms.internal.measurement.C2721b1.m9316a(r2)     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.measurement.zzdm r4 = r7.f17629a     // Catch:{ all -> 0x0110 }
            java.lang.String r4 = r4.f17636b     // Catch:{ all -> 0x0110 }
            java.lang.String r4 = r7.m10311f(r4)     // Catch:{ all -> 0x0110 }
            java.lang.Object r2 = r2.zza(r4)     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x00d9
            java.lang.Object r2 = r7.mo18624e(r2)     // Catch:{ all -> 0x0110 }
            goto L_0x00da
        L_0x00d9:
            r2 = r3
        L_0x00da:
            if (r2 == 0) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            T r2 = r7.f17631c     // Catch:{ all -> 0x0110 }
        L_0x00df:
            com.google.android.gms.internal.measurement.zzec r1 = r1.mo18689b()     // Catch:{ all -> 0x0110 }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.measurement.zzdy r1 = (com.google.android.gms.internal.measurement.zzdy) r1     // Catch:{ all -> 0x0110 }
            boolean r4 = r1.zza()     // Catch:{ all -> 0x0110 }
            if (r4 == 0) goto L_0x010a
            java.lang.Object r1 = r1.zzb()     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.measurement.zzdd r1 = (com.google.android.gms.internal.measurement.zzdd) r1     // Catch:{ all -> 0x0110 }
            com.google.android.gms.internal.measurement.zzdm r2 = r7.f17629a     // Catch:{ all -> 0x0110 }
            android.net.Uri r4 = r2.f17635a     // Catch:{ all -> 0x0110 }
            java.lang.String r2 = r2.f17637c     // Catch:{ all -> 0x0110 }
            java.lang.String r5 = r7.f17630b     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = r1.zza(r4, r3, r2, r5)     // Catch:{ all -> 0x0110 }
            if (r1 != 0) goto L_0x0106
            T r2 = r7.f17631c     // Catch:{ all -> 0x0110 }
            goto L_0x010a
        L_0x0106:
            java.lang.Object r2 = r7.mo18624e(r1)     // Catch:{ all -> 0x0110 }
        L_0x010a:
            r7.f17633e = r2     // Catch:{ all -> 0x0110 }
            r7.f17632d = r0     // Catch:{ all -> 0x0110 }
        L_0x010e:
            monitor-exit(r7)     // Catch:{ all -> 0x0110 }
            goto L_0x0113
        L_0x0110:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0110 }
            throw r0
        L_0x0113:
            T r0 = r7.f17633e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzdh.zzc():java.lang.Object");
    }

    /* synthetic */ zzdh(zzdm zzdm, String str, Object obj, boolean z, C2753f1 f1Var) {
        this(zzdm, str, obj, z);
    }
}
