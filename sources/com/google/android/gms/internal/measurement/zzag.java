package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgx;
import com.google.android.gms.measurement.internal.zzih;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
public class zzag {

    /* renamed from: i */
    private static volatile zzag f17556i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static Boolean f17557j = null;
    @VisibleForTesting

    /* renamed from: k */
    private static String f17558k = "allow_remote_dynamite";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f17559a;

    /* renamed from: b */
    private final ExecutorService f17560b;

    /* renamed from: c */
    private final AppMeasurementSdk f17561c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<Pair<zzgw, C2922d>> f17562d;

    /* renamed from: e */
    private int f17563e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f17564f;

    /* renamed from: g */
    private String f17565g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public zzv f17566h;
    protected final Clock zza;

    /* renamed from: com.google.android.gms.internal.measurement.zzag$a */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
    static class C2919a extends zzaa {

        /* renamed from: a */
        private final zzgx f17567a;

        C2919a(zzgx zzgx) {
            this.f17567a = zzgx;
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.f17567a.interceptEvent(str, str2, bundle, j);
        }

        public final int zza() {
            return System.identityHashCode(this.f17567a);
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.zzag$b */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
    abstract class C2920b implements Runnable {

        /* renamed from: a */
        final long f17568a;

        /* renamed from: b */
        final long f17569b;

        /* renamed from: c */
        private final boolean f17570c;

        C2920b(zzag zzag) {
            this(true);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo18537a();

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo18559b() {
        }

        public void run() {
            if (zzag.this.f17564f) {
                mo18559b();
                return;
            }
            try {
                mo18537a();
            } catch (Exception e) {
                zzag.this.m10022f(e, false, this.f17570c);
                mo18559b();
            }
        }

        C2920b(boolean z) {
            this.f17568a = zzag.this.zza.currentTimeMillis();
            this.f17569b = zzag.this.zza.elapsedRealtime();
            this.f17570c = z;
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.zzag$c */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
    class C2921c implements Application.ActivityLifecycleCallbacks {
        C2921c() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzag.this.m10019c(new C2772h0(this, bundle, activity));
        }

        public final void onActivityDestroyed(Activity activity) {
            zzag.this.m10019c(new C2812m0(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzag.this.m10019c(new C2780i0(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzag.this.m10019c(new C2788j0(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzt zzt = new zzt();
            zzag.this.m10019c(new C2796k0(this, activity, zzt));
            Bundle zzb = zzt.zzb(50);
            if (zzb != null) {
                bundle.putAll(zzb);
            }
        }

        public final void onActivityStarted(Activity activity) {
            zzag.this.m10019c(new C2764g0(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzag.this.m10019c(new C2804l0(this, activity));
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.zzag$d */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
    static class C2922d extends zzaa {

        /* renamed from: a */
        private final zzgw f17573a;

        C2922d(zzgw zzgw) {
            this.f17573a = zzgw;
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.f17573a.onEvent(str, str2, bundle, j);
        }

        public final int zza() {
            return System.identityHashCode(this.f17573a);
        }
    }

    private zzag(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !m10032p(str2, str3)) {
            this.f17559a = "FA";
        } else {
            this.f17559a = str;
        }
        this.zza = DefaultClock.getInstance();
        this.f17560b = zzi.zza().zza(new C2803l(this), zzr.zza);
        this.f17561c = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!m10035s(context) || m10040x())) {
            this.f17565g = null;
            this.f17564f = true;
            Log.w(this.f17559a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!m10032p(str2, str3)) {
            this.f17565g = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null ? true : z)) {
                    Log.w(this.f17559a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.f17559a, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.f17565g = str2;
        }
        m10019c(new C2719b(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f17559a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new C2921c());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m10019c(C2920b bVar) {
        this.f17560b.execute(bVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m10022f(Exception exc, boolean z, boolean z2) {
        this.f17564f |= z;
        if (z) {
            Log.w(this.f17559a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", (Object) exc, (Object) null, (Object) null);
        }
        Log.w(this.f17559a, "Error with data collection. Data lost.", exc);
    }

    /* renamed from: g */
    private final void m10023g(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        m10019c(new C2752f0(this, l, str, str2, bundle, z, z2));
    }

    /* renamed from: h */
    private final void m10024h(String str, String str2, Object obj, boolean z) {
        m10019c(new C2744e0(this, str, str2, obj, z));
    }

    /* renamed from: i */
    private static boolean m10025i(Context context, @Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle.getBoolean(str);
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public static boolean m10032p(String str, String str2) {
        return (str2 == null || str == null || m10040x()) ? false : true;
    }

    /* renamed from: s */
    private static boolean m10035s(Context context) {
        try {
            return zzih.zza(context, "google_app_id") != null;
        } catch (IllegalStateException unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public static int m10036t(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public static int m10037u(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public static void m10038v(Context context) {
        Boolean bool = Boolean.FALSE;
        synchronized (zzag.class) {
            try {
                if (f17557j == null) {
                    if (m10025i(context, "app_measurement_internal_disable_startup_flags")) {
                        f17557j = bool;
                        return;
                    }
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                    f17557j = Boolean.valueOf(sharedPreferences.getBoolean(f17558k, false));
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.remove(f17558k);
                    edit.apply();
                }
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                f17557j = bool;
            }
        }
    }

    /* renamed from: x */
    private static boolean m10040x() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static zzag zza(@NonNull Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public final void zzb(zzgw zzgw) {
        Preconditions.checkNotNull(zzgw);
        m10019c(new C2728c0(this, zzgw));
    }

    public final void zzc(String str) {
        m10019c(new C2811m(this, str));
    }

    public final String zzd() {
        zzt zzt = new zzt();
        m10019c(new C2827o(this, zzt));
        return zzt.zza(50);
    }

    public final long zze() {
        zzt zzt = new zzt();
        m10019c(new C2851r(this, zzt));
        Long l = (Long) zzt.zza(zzt.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.f17563e + 1;
        this.f17563e = i;
        return nextLong + ((long) i);
    }

    public final String zzf() {
        zzt zzt = new zzt();
        m10019c(new C2843q(this, zzt));
        return zzt.zza(500);
    }

    public final String zzg() {
        zzt zzt = new zzt();
        m10019c(new C2867t(this, zzt));
        return zzt.zza(500);
    }

    @WorkerThread
    public final String zzh() {
        zzt zzt = new zzt();
        m10019c(new C2912z(this, zzt));
        return zzt.zza(120000);
    }

    public final String zzi() {
        return this.f17565g;
    }

    public static zzag zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (f17556i == null) {
            synchronized (zzag.class) {
                if (f17556i == null) {
                    f17556i = new zzag(context, str, str2, str3, bundle);
                }
            }
        }
        return f17556i;
    }

    public final String zzc() {
        zzt zzt = new zzt();
        m10019c(new C2835p(this, zzt));
        return zzt.zza(500);
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        m10019c(new C2735d(this, str, str2, bundle));
    }

    public final List<Bundle> zzb(String str, String str2) {
        zzt zzt = new zzt();
        m10019c(new C2727c(this, str, str2, zzt));
        List<Bundle> list = (List) zzt.zza(zzt.zzb(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final int zzd(String str) {
        zzt zzt = new zzt();
        m10019c(new C2891w(this, str, zzt));
        Integer num = (Integer) zzt.zza(zzt.zzb(WorkRequest.MIN_BACKOFF_MILLIS), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final void zzc(Bundle bundle) {
        m10019c(new C2712a0(this, bundle));
    }

    public final void zzb(Bundle bundle) {
        m10019c(new C2763g(this, bundle));
    }

    public final AppMeasurementSdk zza() {
        return this.f17561c;
    }

    public final void zzb() {
        m10019c(new C2787j(this));
    }

    /* access modifiers changed from: protected */
    public final zzv zza(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } catch (DynamiteModule.LoadingException e) {
                m10022f(e, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzu.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    public final void zzb(long j) {
        m10019c(new C2795k(this, j));
    }

    public final void zzb(String str) {
        m10019c(new C2819n(this, str));
    }

    public final void zza(zzgx zzgx) {
        m10019c(new C2875u(this, zzgx));
    }

    public final void zza(zzgw zzgw) {
        Preconditions.checkNotNull(zzgw);
        m10019c(new C2736d0(this, zzgw));
    }

    public final void zza(@NonNull String str, Bundle bundle) {
        m10023g((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        m10023g(str, str2, bundle, true, true, (Long) null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        m10023g(str, str2, bundle, true, false, Long.valueOf(j));
    }

    public final void zza(String str, String str2) {
        m10024h((String) null, str, str2, false);
    }

    public final void zza(String str, String str2, Object obj) {
        m10024h(str, str2, obj, true);
    }

    public final void zza(Bundle bundle) {
        m10019c(new C2711a(this, bundle));
    }

    public final void zza(String str) {
        m10019c(new C2751f(this, str));
    }

    public final void zza(Activity activity, String str, String str2) {
        m10019c(new C2743e(this, activity, str, str2));
    }

    public final void zza(@Nullable Boolean bool) {
        m10019c(new C2771h(this, bool));
    }

    public final void zza(long j) {
        m10019c(new C2779i(this, j));
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzt zzt = new zzt();
        m10019c(new C2859s(this, str, str2, z, zzt));
        Bundle zzb = zzt.zzb(5000);
        if (zzb == null || zzb.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb.size());
        for (String str3 : zzb.keySet()) {
            Object obj = zzb.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        m10019c(new C2883v(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzt zzt = new zzt();
        m10019c(new C2898x(this, bundle, zzt));
        if (z) {
            return zzt.zzb(5000);
        }
        return null;
    }

    public final Object zza(int i) {
        zzt zzt = new zzt();
        m10019c(new C2905y(this, zzt, i));
        return zzt.zza(zzt.zzb(15000), Object.class);
    }

    public final void zza(boolean z) {
        m10019c(new C2720b0(this, z));
    }
}
