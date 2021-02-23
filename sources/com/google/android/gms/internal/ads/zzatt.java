package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzatt {

    /* renamed from: A */
    private int f12816A;

    /* renamed from: B */
    private String f12817B;

    /* renamed from: C */
    private boolean f12818C;

    /* renamed from: a */
    private int f12819a;

    /* renamed from: b */
    private boolean f12820b;

    /* renamed from: c */
    private boolean f12821c;

    /* renamed from: d */
    private int f12822d;

    /* renamed from: e */
    private int f12823e;

    /* renamed from: f */
    private int f12824f;

    /* renamed from: g */
    private String f12825g;

    /* renamed from: h */
    private int f12826h;

    /* renamed from: i */
    private int f12827i;

    /* renamed from: j */
    private int f12828j;

    /* renamed from: k */
    private boolean f12829k;

    /* renamed from: l */
    private int f12830l;

    /* renamed from: m */
    private double f12831m;

    /* renamed from: n */
    private boolean f12832n;

    /* renamed from: o */
    private String f12833o;

    /* renamed from: p */
    private String f12834p;

    /* renamed from: q */
    private boolean f12835q;

    /* renamed from: r */
    private boolean f12836r;

    /* renamed from: s */
    private String f12837s;

    /* renamed from: t */
    private boolean f12838t;

    /* renamed from: u */
    private final boolean f12839u;

    /* renamed from: v */
    private boolean f12840v;

    /* renamed from: w */
    private String f12841w;

    /* renamed from: x */
    private String f12842x;

    /* renamed from: y */
    private float f12843y;

    /* renamed from: z */
    private int f12844z;

    public zzatt(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        m7554c(context);
        m7555d(context);
        m7556e(context);
        Locale locale = Locale.getDefault();
        boolean z = true;
        this.f12835q = m7552a(packageManager, "geo:0,0?q=donuts") != null;
        this.f12836r = m7552a(packageManager, "http://www.google.com") == null ? false : z;
        this.f12837s = locale.getCountry();
        zzwq.zzqa();
        this.f12838t = zzayr.zzzd();
        this.f12839u = DeviceProperties.isLatchsky(context);
        this.f12840v = DeviceProperties.isSidewinder(context);
        this.f12841w = locale.getLanguage();
        this.f12842x = m7553b(context, packageManager);
        this.f12817B = m7557f(context);
        Resources resources = context.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            this.f12843y = displayMetrics.density;
            this.f12844z = displayMetrics.widthPixels;
            this.f12816A = displayMetrics.heightPixels;
        }
    }

    /* renamed from: a */
    private static ResolveInfo m7552a(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzp.zzku().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    /* renamed from: b */
    private static String m7553b(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo a = m7552a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a == null || (activityInfo = a.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    /* renamed from: c */
    private final void m7554c(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.f12819a = audioManager.getMode();
                this.f12820b = audioManager.isMusicActive();
                this.f12821c = audioManager.isSpeakerphoneOn();
                this.f12822d = audioManager.getStreamVolume(3);
                this.f12823e = audioManager.getRingerMode();
                this.f12824f = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzp.zzku().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.f12819a = -2;
        this.f12820b = false;
        this.f12821c = false;
        this.f12822d = 0;
        this.f12823e = 2;
        this.f12824f = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0050  */
    @android.annotation.TargetApi(16)
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m7555d(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r6.getSystemService(r1)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            java.lang.String r2 = r0.getNetworkOperator()
            r5.f12825g = r2
            boolean r2 = com.google.android.gms.common.util.PlatformVersion.isAtLeastR()
            r3 = 0
            if (r2 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabf.zzczg
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r2 = r4.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0031
            r2 = 0
            goto L_0x0035
        L_0x0031:
            int r2 = r0.getNetworkType()
        L_0x0035:
            r5.f12827i = r2
            int r0 = r0.getPhoneType()
            r5.f12828j = r0
            r0 = -2
            r5.f12826h = r0
            r5.f12829k = r3
            r0 = -1
            r5.f12830l = r0
            com.google.android.gms.ads.internal.zzp.zzkq()
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = com.google.android.gms.ads.internal.util.zzm.zzp(r6, r2)
            if (r6 == 0) goto L_0x006f
            android.net.NetworkInfo r6 = r1.getActiveNetworkInfo()
            if (r6 == 0) goto L_0x0067
            int r0 = r6.getType()
            r5.f12826h = r0
            android.net.NetworkInfo$DetailedState r6 = r6.getDetailedState()
            int r6 = r6.ordinal()
            r5.f12830l = r6
            goto L_0x0069
        L_0x0067:
            r5.f12826h = r0
        L_0x0069:
            boolean r6 = r1.isActiveNetworkMetered()
            r5.f12829k = r6
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatt.m7555d(android.content.Context):void");
    }

    /* renamed from: e */
    private final void m7556e(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            this.f12831m = (double) (((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.f12832n = z;
            return;
        }
        this.f12831m = -1.0d;
        this.f12832n = false;
    }

    /* renamed from: f */
    private static String m7557f(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzatq zzvz() {
        return new zzatq(this.f12819a, this.f12835q, this.f12836r, this.f12825g, this.f12837s, this.f12838t, this.f12839u, this.f12840v, this.f12820b, this.f12821c, this.f12841w, this.f12842x, this.f12817B, this.f12822d, this.f12826h, this.f12827i, this.f12828j, this.f12823e, this.f12824f, this.f12843y, this.f12844z, this.f12816A, this.f12831m, this.f12832n, this.f12829k, this.f12830l, this.f12833o, this.f12818C, this.f12834p);
    }

    public zzatt(Context context, zzatq zzatq) {
        m7554c(context);
        m7555d(context);
        m7556e(context);
        this.f12833o = Build.FINGERPRINT;
        this.f12834p = Build.DEVICE;
        this.f12818C = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacf.zzj(context);
        this.f12835q = zzatq.zzdwe;
        this.f12836r = zzatq.zzdwf;
        this.f12837s = zzatq.zzdwh;
        this.f12838t = zzatq.zzdwi;
        this.f12839u = zzatq.zzdwj;
        this.f12840v = zzatq.zzdwk;
        this.f12841w = zzatq.zzdwn;
        this.f12842x = zzatq.zzdwo;
        this.f12817B = zzatq.zzdwp;
        this.f12843y = zzatq.zzbrt;
        this.f12844z = zzatq.zzdpl;
        this.f12816A = zzatq.zzdpm;
    }
}
