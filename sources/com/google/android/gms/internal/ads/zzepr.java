package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsService;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzepr {

    /* renamed from: a */
    private static String f16369a;

    /* renamed from: a */
    private static boolean m8918a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities != null) {
                if (queryIntentActivities.size() != 0) {
                    for (ResolveInfo next : queryIntentActivities) {
                        IntentFilter intentFilter = next.filter;
                        if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && next.activityInfo != null) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (RuntimeException unused) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
    }

    public static String zzcn(Context context) {
        String str = f16369a;
        if (str != null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        String str2 = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo next : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
            intent2.setPackage(next.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(next.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            f16369a = null;
        } else if (arrayList.size() == 1) {
            f16369a = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(str2) && !m8918a(context, intent) && arrayList.contains(str2)) {
            f16369a = str2;
        } else if (arrayList.contains("com.android.chrome")) {
            f16369a = "com.android.chrome";
        } else if (arrayList.contains("com.chrome.beta")) {
            f16369a = "com.chrome.beta";
        } else if (arrayList.contains("com.chrome.dev")) {
            f16369a = "com.chrome.dev";
        } else if (arrayList.contains("com.google.android.apps.chrome")) {
            f16369a = "com.google.android.apps.chrome";
        }
        return f16369a;
    }
}
