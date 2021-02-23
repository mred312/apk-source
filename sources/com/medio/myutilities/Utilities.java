package com.medio.myutilities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.PowerManager;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.medio.catchexception.CatchException;
import com.medio.locale.LocaleManager;
import java.util.Locale;

public class Utilities {

    public static class LocaleHolder {
        public String country = "";
        public String lang = "";

        public LocaleHolder(String str, String str2) {
            this.lang = str;
            this.country = str2;
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i == 0 || i2 == 0) {
            return 4;
        }
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static LocaleHolder checkAndPrepareLanguage(@NonNull Context context, @NonNull LanguagesBase languagesBase, @NonNull String str, @NonNull String str2) {
        return checkAndPrepareLanguage(context, languagesBase, str, str2, false);
    }

    @TargetApi(23)
    public static boolean checkIfBatteryOptimizationsIsOn(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        String packageName = context.getPackageName();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager != null && !powerManager.isIgnoringBatteryOptimizations(packageName);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r1 = (r1 = (android.net.ConnectivityManager) r1.getSystemService("connectivity")).getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkNetworkConnection(android.content.Context r1) {
        /*
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r1, r0)
            if (r1 == 0) goto L_0x0028
            if (r0 != 0) goto L_0x0028
            java.lang.String r0 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            if (r1 == 0) goto L_0x0028
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            if (r1 == 0) goto L_0x0028
            boolean r0 = r1.isAvailable()
            if (r0 == 0) goto L_0x0028
            boolean r1 = r1.isConnected()
            if (r1 == 0) goto L_0x0028
            r1 = 1
            return r1
        L_0x0028:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medio.myutilities.Utilities.checkNetworkConnection(android.content.Context):boolean");
    }

    public static String getDeviceId(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            str = null;
        }
        return (str == null || str == "") ? "android_id" : str;
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isDebugable(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static void restart(@NonNull Activity activity, boolean z) {
        if (z) {
            restartApp(activity);
        } else {
            restartActivity(activity);
        }
    }

    @TargetApi(11)
    public static void restartActivity(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 11) {
            activity.recreate();
            return;
        }
        Intent intent = activity.getIntent();
        intent.addFlags(65536);
        activity.finish();
        activity.overridePendingTransition(0, 0);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    public static void restartApp(@NonNull Activity activity) {
        Intent launchIntentForPackage = activity.getBaseContext().getPackageManager().getLaunchIntentForPackage(activity.getBaseContext().getPackageName());
        if (Build.VERSION.SDK_INT >= 21) {
            launchIntentForPackage.addFlags(67141632);
            activity.startActivity(launchIntentForPackage);
            return;
        }
        ((AlarmManager) activity.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(activity, 31071973, launchIntentForPackage, 268435456));
        System.exit(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        if (r1 == 1) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (r1 == 1) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (r1 == 0) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        if (r1 == 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r6 = 9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setScreenOrientation(android.view.WindowManager r6, android.app.Activity r7) {
        /*
            android.view.Display r0 = r6.getDefaultDisplay()
            int r1 = r0.getRotation()
            android.graphics.Point r2 = new android.graphics.Point
            r2.<init>()
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 13
            if (r3 < r4) goto L_0x001b
            android.view.Display r6 = r6.getDefaultDisplay()
            r6.getSize(r2)
            goto L_0x0027
        L_0x001b:
            int r6 = r0.getWidth()
            r2.x = r6
            int r6 = r0.getHeight()
            r2.y = r6
        L_0x0027:
            r6 = 0
            r0 = 8
            r3 = 9
            r4 = 1
            if (r1 == 0) goto L_0x003f
            r5 = 2
            if (r1 != r5) goto L_0x0033
            goto L_0x003f
        L_0x0033:
            int r5 = r2.x
            int r2 = r2.y
            if (r5 <= r2) goto L_0x003c
            if (r1 != r4) goto L_0x0048
            goto L_0x0051
        L_0x003c:
            if (r1 != r4) goto L_0x004d
            goto L_0x004f
        L_0x003f:
            int r5 = r2.x
            int r2 = r2.y
            if (r5 <= r2) goto L_0x004b
            if (r1 != 0) goto L_0x0048
            goto L_0x0051
        L_0x0048:
            r6 = 8
            goto L_0x0051
        L_0x004b:
            if (r1 != 0) goto L_0x004f
        L_0x004d:
            r6 = 1
            goto L_0x0051
        L_0x004f:
            r6 = 9
        L_0x0051:
            r7.setRequestedOrientation(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medio.myutilities.Utilities.setScreenOrientation(android.view.WindowManager, android.app.Activity):void");
    }

    public static void setStatusbarTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
            setWindowFlag(activity, 67108864, false);
            activity.getWindow().setStatusBarColor(0);
        }
    }

    public static void setWindowFlag(Activity activity, int i, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags = i | attributes.flags;
        } else {
            attributes.flags = (i ^ -1) & attributes.flags;
        }
        window.setAttributes(attributes);
    }

    public static void vibrate(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                ((Vibrator) context.getSystemService("vibrator")).vibrate(VibrationEffect.createOneShot(100, -1));
                return;
            }
            ((Vibrator) context.getSystemService("vibrator")).vibrate(new long[]{0, 100, 200}, -1);
        } catch (Exception e) {
            CatchException.logException(e);
        }
    }

    public static LocaleHolder checkAndPrepareLanguage(@NonNull Context context, @NonNull LanguagesBase languagesBase, @NonNull String str, @NonNull String str2, boolean z) {
        Activity activity = (Activity) context;
        if (str.isEmpty()) {
            String systemLanguage = LocaleManager.getSystemLanguage(context);
            int checkLanguagePosition = languagesBase.checkLanguagePosition(systemLanguage, LocaleManager.getSystemCountry(context));
            if (checkLanguagePosition != -1) {
                languagesBase.selectedItem = checkLanguagePosition;
                if (!languagesBase.langList.get(checkLanguagePosition).langListLocale.getLanguage().contentEquals(systemLanguage) || !Locale.getDefault().getLanguage().contentEquals(systemLanguage)) {
                    str = languagesBase.langList.get(checkLanguagePosition).langListLocale.getLanguage();
                    LocaleManager.setNewLocale(context, str);
                    restart(activity, z);
                } else {
                    str = languagesBase.langList.get(checkLanguagePosition).langListLocale.getLanguage();
                    LocaleManager.setNewLocale(context, str);
                }
            } else if (languagesBase.checkLanguagePosition(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry()) != 0) {
                languagesBase.selectedItem = 0;
                str = languagesBase.langList.get(0).langListLocale.getLanguage();
                LocaleManager.setNewLocale(context, str);
                restart(activity, z);
            } else {
                str = languagesBase.langList.get(0).langListLocale.getLanguage();
                LocaleManager.setNewLocale(context, str);
            }
        } else if (!Locale.getDefault().getLanguage().contentEquals(str)) {
            languagesBase.selectedItem = languagesBase.checkLanguagePosition(str, str2);
            LocaleManager.setNewLocale(context, str);
            restart(activity, z);
        } else {
            languagesBase.selectedItem = languagesBase.checkLanguagePosition(str, str2);
        }
        String country = languagesBase.langList.get(languagesBase.selectedItem).langListLocale.getCountry();
        if (!LocaleManager.getCountry(activity).equals(country)) {
            LocaleManager.setCountry(activity, country);
        }
        return new LocaleHolder(str, country);
    }
}
