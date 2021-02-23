package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.ads.pu */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2300pu implements zzdfi<zzdfp> {

    /* renamed from: a */
    private final zzdzc f10652a;

    /* renamed from: b */
    private final Context f10653b;

    public C2300pu(zzdzc zzdzc, Context context) {
        this.f10652a = zzdzc;
        this.f10653b = context;
    }

    /* renamed from: a */
    private static ResolveInfo m6689a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    /* renamed from: b */
    private static String m6690b(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo a = m6689a(packageManager, "market://details?id=com.google.android.gms.ads");
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

    /* renamed from: d */
    private static String m6691d(Context context) {
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

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ zzdfp mo14624c() {
        boolean z;
        PackageManager packageManager = this.f10653b.getPackageManager();
        Locale locale = Locale.getDefault();
        boolean z2 = m6689a(packageManager, "geo:0,0?q=donuts") != null;
        boolean z3 = m6689a(packageManager, "http://www.google.com") != null;
        String country = locale.getCountry();
        boolean startsWith = Build.DEVICE.startsWith("generic");
        boolean isLatchsky = DeviceProperties.isLatchsky(this.f10653b);
        boolean isSidewinder = DeviceProperties.isSidewinder(this.f10653b);
        String language = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = LocaleList.getDefault();
            for (int i = 0; i < localeList.size(); i++) {
                arrayList.add(localeList.get(i).getLanguage());
            }
        }
        String b = m6690b(this.f10653b, packageManager);
        String d = m6691d(this.f10653b);
        String str = Build.FINGERPRINT;
        Context context = this.f10653b;
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= queryIntentActivities.size()) {
                        break;
                    } else if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i2).activityInfo.name)) {
                        z = resolveActivity.activityInfo.packageName.equals(zzepr.zzcn(context));
                        break;
                    } else {
                        i2++;
                    }
                }
                return new zzdfp(z2, z3, country, startsWith, isLatchsky, isSidewinder, language, arrayList, b, d, str, z, Build.MODEL, zzp.zzks().zzyn());
            }
        }
        z = false;
        return new zzdfp(z2, z3, country, startsWith, isLatchsky, isSidewinder, language, arrayList, b, d, str, z, Build.MODEL, zzp.zzks().zzyn());
    }

    public final zzdyz<zzdfp> zzasm() {
        return this.f10652a.zze(new C2337qu(this));
    }
}
