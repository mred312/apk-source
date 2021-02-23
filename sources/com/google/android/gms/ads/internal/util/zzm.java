package com.google.android.gms.ads.internal.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.NotificationManagerCompat;
import com.bumptech.glide.load.Key;
import com.google.android.gms.ads.impl.C1656R;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzaam;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzace;
import com.google.android.gms.internal.ads.zzacf;
import com.google.android.gms.internal.ads.zzach;
import com.google.android.gms.internal.ads.zzacx;
import com.google.android.gms.internal.ads.zzadg;
import com.google.android.gms.internal.ads.zzauc;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzduw;
import com.google.android.gms.internal.ads.zzdyr;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzwq;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzm {
    public static final zzduw zzedd = new zzg(Looper.getMainLooper());
    /* access modifiers changed from: private */
    @GuardedBy("userAgentLock")
    public String zzbih;
    private AtomicReference<Pattern> zzedb = new AtomicReference<>((Object) null);
    private AtomicReference<Pattern> zzedc = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public final Object zzede = new Object();
    private boolean zzedf = false;
    private boolean zzedg = false;
    /* access modifiers changed from: private */
    public boolean zzys = true;

    private static Bundle getMetadata(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            zzd.zza("Error getting metadata", e);
            return null;
        }
    }

    @VisibleForTesting
    protected static String zzao(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return zzye();
        }
    }

    public static AlertDialog.Builder zzap(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static zzaam zzaq(Context context) {
        return new zzaam(context);
    }

    @SuppressLint({"NewApi"})
    public static String zzar(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        ComponentName componentName;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (!(activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty() || (runningTaskInfo = runningTasks.get(0)) == null || (componentName = runningTaskInfo.topActivity) == null)) {
                return componentName.getClassName();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean zzas(Context context) {
        boolean z;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (Process.myPid() == next.pid) {
                            if (next.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                                return true;
                            }
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager == null) {
                                z = false;
                            } else {
                                z = powerManager.isScreenOn();
                            }
                            if (z) {
                                return false;
                            }
                            return true;
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int zzat(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    @Nullable
    private static KeyguardManager zzau(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    @TargetApi(16)
    public static boolean zzav(Context context) {
        KeyguardManager zzau;
        if (context == null || !PlatformVersion.isAtLeastJellyBean() || (zzau = zzau(context)) == null || !zzau.isKeyguardLocked()) {
            return false;
        }
        return true;
    }

    public static boolean zzaw(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzaza.zzc("Error loading class.", th);
            zzp.zzku().zza(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static String zzax(Context context) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwn)).booleanValue()) {
            return "";
        }
        return context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
    }

    public static Bundle zzay(Context context) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwo)).booleanValue()) {
            return null;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Bundle bundle = new Bundle();
        if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
            bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
        }
        String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (defaultSharedPreferences.contains(str)) {
                bundle.putString(str, defaultSharedPreferences.getString(str, (String) null));
            }
        }
        return bundle;
    }

    public static boolean zzaz(Context context) {
        Window window;
        if (!(!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || window.getDecorView() == null)) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, (Point) null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static void zzb(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            new zzbp(context, str, (String) obj).zzxl();
        }
    }

    public static String zzba(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return zzd(getMetadata(context));
    }

    public static boolean zzbb(Context context) {
        Bundle metadata = getMetadata(context);
        return TextUtils.isEmpty(zzd(metadata)) && !TextUtils.isEmpty(metadata.getString("com.google.android.gms.ads.INTEGRATION_MANAGER"));
    }

    public static boolean zzbc(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @TargetApi(26)
    public static void zzbd(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    public static boolean zzbe(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static zzbf zzbf(Context context) {
        try {
            Object newInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzaza.zzey("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            if (queryLocalInterface instanceof zzbf) {
                return (zzbf) queryLocalInterface;
            }
            return new zzbh(iBinder);
        } catch (Exception e) {
            zzp.zzku().zza(e, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    @Nullable
    public static WebResourceResponse zzd(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(AbstractSpiCall.HEADER_USER_AGENT, zzp.zzkq().zzq(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = new zzax(context).zzc(str2, hashMap).get(60, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", Key.STRING_CHARSET_NAME, new ByteArrayInputStream(str3.getBytes(Key.STRING_CHARSET_NAME)));
            }
            return null;
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzaza.zzd("Could not fetch MRAID JS.", e);
            return null;
        }
    }

    public static int zzdg(int i) {
        if (i >= 5000) {
            return i;
        }
        if (i <= 0) {
            return 60000;
        }
        StringBuilder sb = new StringBuilder(97);
        sb.append("HTTP timeout too low: ");
        sb.append(i);
        sb.append(" milliseconds. Reverting to default timeout: 60000 milliseconds.");
        zzaza.zzfa(sb.toString());
        return 60000;
    }

    public static int zzej(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzaza.zzfa(sb.toString());
            return 0;
        }
    }

    public static boolean zzek(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static boolean zzen(String str) {
        if (!zzayu.isEnabled()) {
            return false;
        }
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcue)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzwq.zzqe().zzd(zzabf.zzcug);
        if (!str2.isEmpty()) {
            for (String equals : str2.split(";")) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        String str3 = (String) zzwq.zzqe().zzd(zzabf.zzcuf);
        if (str3.isEmpty()) {
            return true;
        }
        for (String equals2 : str3.split(";")) {
            if (equals2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int[] zzf(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window == null || (findViewById = window.findViewById(16908290)) == null) {
            return zzyh();
        }
        return new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public static int[] zzg(Activity activity) {
        int[] zzf = zzf(activity);
        return new int[]{zzwq.zzqa().zzb((Context) activity, zzf[0]), zzwq.zzqa().zzb((Context) activity, zzf[1])};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.findViewById(16908290);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] zzh(android.app.Activity r6) {
        /*
            android.view.Window r0 = r6.getWindow()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0021
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r4)
            if (r0 == 0) goto L_0x0021
            int[] r4 = new int[r1]
            int r5 = r0.getTop()
            r4[r3] = r5
            int r0 = r0.getBottom()
            r4[r2] = r0
            goto L_0x0025
        L_0x0021:
            int[] r4 = zzyh()
        L_0x0025:
            int[] r0 = new int[r1]
            com.google.android.gms.internal.ads.zzayr r1 = com.google.android.gms.internal.ads.zzwq.zzqa()
            r5 = r4[r3]
            int r1 = r1.zzb((android.content.Context) r6, (int) r5)
            r0[r3] = r1
            com.google.android.gms.internal.ads.zzayr r1 = com.google.android.gms.internal.ads.zzwq.zzqa()
            r3 = r4[r2]
            int r6 = r1.zzb((android.content.Context) r6, (int) r3)
            r0[r2] = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzm.zzh(android.app.Activity):int[]");
    }

    public static Bitmap zzm(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap zzn(View view) {
        if (view == null) {
            return null;
        }
        Bitmap zzp = zzp(view);
        return zzp == null ? zzo(view) : zzp;
    }

    private static Bitmap zzo(@NonNull View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0) {
                if (height != 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                    Canvas canvas = new Canvas(createBitmap);
                    view.layout(0, 0, width, height);
                    view.draw(canvas);
                    return createBitmap;
                }
            }
            zzaza.zzfa("Width or height of view is zero");
            return null;
        } catch (RuntimeException e) {
            zzaza.zzc("Fail to capture the webview", e);
            return null;
        }
    }

    public static boolean zzp(Context context, String str) {
        Context zzy = zzauc.zzy(context);
        return Wrappers.packageManager(zzy).checkPermission(str, zzy.getPackageName()) == 0;
    }

    public static int zzr(@Nullable View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public static boolean zzs(@Nullable View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof ScrollView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return false;
        }
        return true;
    }

    private static String zzye() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        String str2 = Build.DEVICE;
        if (str2 != null) {
            sb.append("; ");
            sb.append(str2);
            String str3 = Build.DISPLAY;
            if (str3 != null) {
                sb.append(" Build/");
                sb.append(str3);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static String zzyf() {
        return UUID.randomUUID().toString();
    }

    public static String zzyg() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    private static int[] zzyh() {
        return new int[]{0, 0};
    }

    public static String zzyi() {
        Resources resources = zzp.zzku().getResources();
        return resources != null ? resources.getString(C1656R.string.f7418s7) : "Test Ad";
    }

    public final void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        zza(context, str, false, httpURLConnection, false, 60000);
    }

    public final boolean zzam(Context context) {
        if (this.zzedf) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zzr(this, (zzo) null), intentFilter);
        this.zzedf = true;
        return true;
    }

    public final boolean zzan(Context context) {
        if (this.zzedg) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new zzs(this, (zzo) null), intentFilter);
        this.zzedg = true;
        return true;
    }

    public final JSONObject zzc(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public final boolean zzel(String str) {
        return zza(str, this.zzedb, (String) zzwq.zzqe().zzd(zzabf.zzcnm));
    }

    public final boolean zzem(String str) {
        return zza(str, this.zzedc, (String) zzwq.zzqe().zzd(zzabf.zzcnn));
    }

    public final zzdyz<Map<String, String>> zzi(Uri uri) {
        return zzdyr.zzb(zzdyr.zzag(null), new zzl(this, uri), (Executor) zzazj.zzegp);
    }

    public final JSONObject zzj(Map<String, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String next : map.keySet()) {
                zza(jSONObject, next, (Object) map.get(next));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0039, code lost:
        continue;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0043 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023 A[Catch:{ Exception -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055 A[Catch:{ Exception -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[Catch:{ Exception -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2 A[Catch:{ Exception -> 0x00b1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzq(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzede
            monitor-enter(r0)
            java.lang.String r1 = r4.zzbih     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x00cb }
            return r1
        L_0x0009:
            if (r6 != 0) goto L_0x0011
            java.lang.String r5 = zzye()     // Catch:{ all -> 0x00cb }
            monitor-exit(r0)     // Catch:{ all -> 0x00cb }
            return r5
        L_0x0011:
            com.google.android.gms.ads.internal.util.zzu r1 = com.google.android.gms.ads.internal.zzp.zzks()     // Catch:{ Exception -> 0x001b }
            java.lang.String r1 = r1.getDefaultUserAgent(r5)     // Catch:{ Exception -> 0x001b }
            r4.zzbih = r1     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            java.lang.String r1 = r4.zzbih     // Catch:{ all -> 0x00cb }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ all -> 0x00cb }
            boolean r1 = com.google.android.gms.internal.ads.zzayr.zzze()     // Catch:{ all -> 0x00cb }
            if (r1 != 0) goto L_0x0063
            r1 = 0
            r4.zzbih = r1     // Catch:{ all -> 0x00cb }
            com.google.android.gms.internal.ads.zzduw r1 = zzedd     // Catch:{ all -> 0x00cb }
            com.google.android.gms.ads.internal.util.zzq r2 = new com.google.android.gms.ads.internal.util.zzq     // Catch:{ all -> 0x00cb }
            r2.<init>(r4, r5)     // Catch:{ all -> 0x00cb }
            r1.post(r2)     // Catch:{ all -> 0x00cb }
        L_0x0039:
            java.lang.String r1 = r4.zzbih     // Catch:{ all -> 0x00cb }
            if (r1 != 0) goto L_0x0069
            java.lang.Object r1 = r4.zzede     // Catch:{ InterruptedException -> 0x0043 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0043 }
            goto L_0x0039
        L_0x0043:
            java.lang.String r1 = zzye()     // Catch:{ all -> 0x00cb }
            r4.zzbih = r1     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "Interrupted, use default user agent: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00cb }
            int r3 = r1.length()     // Catch:{ all -> 0x00cb }
            if (r3 == 0) goto L_0x005a
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x00cb }
            goto L_0x005f
        L_0x005a:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x00cb }
            r1.<init>(r2)     // Catch:{ all -> 0x00cb }
        L_0x005f:
            com.google.android.gms.internal.ads.zzaza.zzfa(r1)     // Catch:{ all -> 0x00cb }
            goto L_0x0039
        L_0x0063:
            java.lang.String r1 = zzao(r5)     // Catch:{ all -> 0x00cb }
            r4.zzbih = r1     // Catch:{ all -> 0x00cb }
        L_0x0069:
            java.lang.String r1 = r4.zzbih     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00cb }
            int r2 = r2.length()     // Catch:{ all -> 0x00cb }
            int r2 = r2 + 10
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x00cb }
            int r3 = r3.length()     // Catch:{ all -> 0x00cb }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r3.<init>(r2)     // Catch:{ all -> 0x00cb }
            r3.append(r1)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = " (Mobile; "
            r3.append(r1)     // Catch:{ all -> 0x00cb }
            r3.append(r6)     // Catch:{ all -> 0x00cb }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x00cb }
            r4.zzbih = r6     // Catch:{ all -> 0x00cb }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r5 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r5)     // Catch:{ Exception -> 0x00b1 }
            boolean r5 = r5.isCallerInstantApp()     // Catch:{ Exception -> 0x00b1 }
            if (r5 == 0) goto L_0x00bb
            java.lang.String r5 = r4.zzbih     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r6 = ";aia"
            java.lang.String r5 = r5.concat(r6)     // Catch:{ Exception -> 0x00b1 }
            r4.zzbih = r5     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00bb
        L_0x00b1:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzayg r6 = com.google.android.gms.ads.internal.zzp.zzku()     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = "AdUtil.getUserAgent"
            r6.zza(r5, r1)     // Catch:{ all -> 0x00cb }
        L_0x00bb:
            java.lang.String r5 = r4.zzbih     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00cb }
            java.lang.String r6 = ")"
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x00cb }
            r4.zzbih = r5     // Catch:{ all -> 0x00cb }
            monitor-exit(r0)     // Catch:{ all -> 0x00cb }
            return r5
        L_0x00cb:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00cb }
            goto L_0x00cf
        L_0x00ce:
            throw r5
        L_0x00cf:
            goto L_0x00ce
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzm.zzq(android.content.Context, java.lang.String):java.lang.String");
    }

    public final void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2, int i) {
        int zzdg = zzdg(i);
        StringBuilder sb = new StringBuilder(39);
        sb.append("HTTP timeout: ");
        sb.append(zzdg);
        sb.append(" milliseconds.");
        zzaza.zzez(sb.toString());
        httpURLConnection.setConnectTimeout(zzdg);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(zzdg);
        httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, zzq(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public static void zzc(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzazj.zzegp.execute(runnable);
        }
    }

    private static Bitmap zzp(@NonNull View view) {
        Bitmap bitmap = null;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                bitmap = Bitmap.createBitmap(drawingCache);
            }
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (RuntimeException e) {
            zzaza.zzc("Fail to capture the web view", e);
        }
        return bitmap;
    }

    @TargetApi(18)
    public static void zzb(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzb(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzaza.zzeb(sb.toString());
        } catch (ActivityNotFoundException e) {
            zzaza.zzc("No browser is found.", e);
        }
    }

    public static Map<String, String> zzj(Uri uri) {
        if (!zzacx.zzdcb.get().booleanValue()) {
            if (uri == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            zzp.zzks();
            for (String next : uri.getQueryParameterNames()) {
                hashMap.put(next, uri.getQueryParameter(next));
            }
            return hashMap;
        } else if (uri == null) {
            return null;
        } else {
            HashMap hashMap2 = new HashMap(20);
            String encodedQuery = uri.getEncodedQuery();
            if (encodedQuery == null) {
                return hashMap2;
            }
            int length = encodedQuery.length();
            StringBuilder sb = new StringBuilder(100);
            StringBuilder sb2 = new StringBuilder(length);
            StringBuilder sb3 = sb;
            int i = 0;
            while (i < length) {
                char charAt = encodedQuery.charAt(i);
                if (charAt == '%') {
                    byte[] bArr = new byte[((length - i) / 3)];
                    int i2 = 0;
                    while (i < length - 2 && charAt == '%') {
                        try {
                            bArr[i2] = (byte) ((zza(encodedQuery.charAt(i + 1)) << 4) + zza(encodedQuery.charAt(i + 2)));
                            i2++;
                        } catch (IllegalArgumentException unused) {
                        }
                        i += 3;
                        if (i < length) {
                            charAt = encodedQuery.charAt(i);
                        }
                    }
                    try {
                        sb3.append(new String(bArr, 0, i2, Key.STRING_CHARSET_NAME));
                    } catch (UnsupportedEncodingException unused2) {
                    }
                    if (charAt != '%') {
                    }
                } else if (charAt == '&') {
                    if (sb.length() > 0 && sb3 != sb) {
                        hashMap2.put(sb.toString(), sb2.toString());
                        sb.setLength(0);
                        sb2.setLength(0);
                    }
                    sb3 = sb;
                } else if (charAt == '+') {
                    sb3.append(' ');
                } else if (charAt != '=') {
                    sb3.append(charAt);
                } else if (sb3 != sb2) {
                    sb3 = sb2;
                } else {
                    sb3.append(charAt);
                }
                i++;
            }
            if (sb.length() > 0 && sb3 != sb) {
                hashMap2.put(sb.toString(), sb2.toString());
            }
            return hashMap2;
        }
    }

    public static String zzr(Context context, String str) {
        try {
            return new String(IOUtils.readInputStreamFully(context.openFileInput(str), true), Key.STRING_CHARSET_NAME);
        } catch (IOException unused) {
            zzaza.zzeb("Error reading from internal storage.");
            return "";
        }
    }

    public static void zzc(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes(Key.STRING_CHARSET_NAME));
            openFileOutput.close();
        } catch (Exception e) {
            zzaza.zzc("Error writing to file in internal storage.", e);
        }
    }

    @TargetApi(18)
    public final int zza(Context context, Uri uri) {
        int i;
        if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
            zzd.zzee("Chrome Custom Tabs can only work with version Jellybean onwards.");
            i = zzach.zzdam;
        } else if (!(context instanceof Activity)) {
            zzd.zzee("Chrome Custom Tabs can only work with Activity context.");
            i = zzach.zzdan;
        } else if (!zzacf.zzj(context)) {
            zzd.zzee("Default browser does not support custom tabs.");
            i = zzach.zzdao;
        } else {
            i = 0;
        }
        if (i != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return i;
        }
        zzacf zzacf = new zzacf();
        zzacf.zza((zzace) new zzn(this, zzacf, context, uri));
        zzacf.zzd((Activity) context);
        return zzach.zzdap;
    }

    public static WebResourceResponse zzd(HttpURLConnection httpURLConnection) {
        String str;
        zzp.zzkq();
        String contentType = httpURLConnection.getContentType();
        String str2 = "";
        if (TextUtils.isEmpty(contentType)) {
            str = str2;
        } else {
            str = contentType.split(";")[0].trim();
        }
        zzp.zzkq();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(";");
            if (split.length != 1) {
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    if (split[i].trim().startsWith("charset")) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            str2 = split2[1].trim();
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        String str3 = str2;
        Map headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Map.Entry entry : headerFields.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null || ((List) entry.getValue()).size() <= 0)) {
                hashMap.put((String) entry.getKey(), (String) ((List) entry.getValue()).get(0));
            }
        }
        return zzp.zzks().zza(str, str3, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    @TargetApi(18)
    public static void zzb(Context context, Intent intent) {
        if (intent != null && PlatformVersion.isAtLeastJellyBeanMR2()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzq(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 == 0) goto L_0x0012
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0012
            android.app.Activity r2 = (android.app.Activity) r2
            goto L_0x0013
        L_0x0012:
            r2 = r0
        L_0x0013:
            r1 = 0
            if (r2 != 0) goto L_0x0017
            return r1
        L_0x0017:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L_0x0022:
            if (r0 == 0) goto L_0x002d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x002d
            r2 = 1
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzm.zzq(android.view.View):boolean");
    }

    public static String zza(InputStreamReader inputStreamReader) {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    public final void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zzq(context, str));
    }

    public static boolean zza(ClassLoader classLoader, Class<?> cls, List<String> list) {
        for (String cls2 : list) {
            try {
                if (Class.forName(cls2, false, classLoader).isAssignableFrom(cls)) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static String zzd(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) {
            return string;
        }
        return "";
    }

    public final JSONObject zza(@Nullable Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                return zzc(bundle);
            } catch (JSONException e) {
                zzaza.zzc("Error converting Bundle to JSON", e);
            }
        }
        return null;
    }

    private final JSONArray zza(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object zza : collection) {
            zza(jSONArray, (Object) zza);
        }
        return jSONArray;
    }

    private final void zza(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(zzc((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzj((Map<String, ?>) (Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zza((Collection<?>) (Collection) obj));
        } else if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object zza : (Object[]) obj) {
                zza(jSONArray2, zza);
            }
            jSONArray.put(jSONArray2);
        } else {
            jSONArray.put(obj);
        }
    }

    private final void zza(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzc((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzj((Map<String, ?>) (Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zza((Collection<?>) (Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zza((Collection<?>) Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private static int zza(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'A';
        if (c < 'A' || c > 'F') {
            c2 = 'a';
            if (c < 'a' || c > 'f') {
                throw new IllegalArgumentException("Invalid Hex.");
            }
        }
        return (c - c2) + 10;
    }

    public static DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    public final void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        zzp.zzkq();
        bundle.putString("device", zzyg());
        bundle.putString("eids", TextUtils.join(",", zzabf.zzrl()));
        zzwq.zzqa();
        zzayr.zza(context, str, str2, bundle, true, new zzp(this, context, str));
    }

    public static void zza(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public final boolean zza(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zza(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, zzau(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.view.View r3, android.os.PowerManager r4, android.app.KeyguardManager r5) {
        /*
            com.google.android.gms.ads.internal.util.zzm r0 = com.google.android.gms.ads.internal.zzp.zzkq()
            boolean r0 = r0.zzys
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001d
            if (r5 != 0) goto L_0x000e
            r5 = 0
            goto L_0x0012
        L_0x000e:
            boolean r5 = r5.inKeyguardRestrictedInputMode()
        L_0x0012:
            if (r5 == 0) goto L_0x001d
            boolean r5 = zzq(r3)
            if (r5 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r5 = 0
            goto L_0x001e
        L_0x001d:
            r5 = 1
        L_0x001e:
            int r0 = r3.getVisibility()
            if (r0 != 0) goto L_0x0063
            boolean r0 = r3.isShown()
            if (r0 == 0) goto L_0x0063
            if (r4 == 0) goto L_0x0035
            boolean r4 = r4.isScreenOn()
            if (r4 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r4 = 0
            goto L_0x0036
        L_0x0035:
            r4 = 1
        L_0x0036:
            if (r4 == 0) goto L_0x0063
            if (r5 == 0) goto L_0x0063
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzabf.zzcpt
            com.google.android.gms.internal.ads.zzabb r5 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r4 = r5.zzd(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0062
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            boolean r4 = r3.getLocalVisibleRect(r4)
            if (r4 != 0) goto L_0x0062
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            boolean r3 = r3.getGlobalVisibleRect(r4)
            if (r3 == 0) goto L_0x0063
        L_0x0062:
            return r1
        L_0x0063:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzm.zza(android.view.View, android.os.PowerManager, android.app.KeyguardManager):boolean");
    }

    private static boolean zza(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static void zza(Context context, Throwable th) {
        if (context != null) {
            boolean z = false;
            try {
                z = zzadg.zzdde.get().booleanValue();
            } catch (IllegalStateException unused) {
            }
            if (z) {
                CrashUtils.addDynamiteErrorToDropBox(context, th);
            }
        }
    }
}
