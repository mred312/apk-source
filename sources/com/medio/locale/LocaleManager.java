package com.medio.locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import androidx.core.text.TextUtilsCompat;
import com.medio.catchexception.CatchException;
import java.util.Locale;

public class LocaleManager {
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: a */
    private static void m14050a(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("language", str).commit();
    }

    public static String getAppNameEN(Context context, int i) {
        Resources resources = context.getResources();
        AssetManager assets = resources.getAssets();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = new Configuration(resources.getConfiguration());
        if (Build.VERSION.SDK_INT < 24) {
            configuration.locale = Locale.ENGLISH;
        } else {
            configuration.setLocale(Locale.ENGLISH);
        }
        String string = new Resources(assets, displayMetrics, configuration).getString(i);
        new Resources(assets, displayMetrics, resources.getConfiguration());
        return string;
    }

    public static String getCountry(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("country", "");
    }

    public static String getLanguage(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("language", "");
    }

    public static Locale getLocale(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        return Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
    }

    public static String getSystemCountry(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Resources.getSystem().getConfiguration().getLocales().get(0);
            } else {
                locale = Resources.getSystem().getConfiguration().locale;
            }
            return locale.getCountry();
        } catch (Exception e) {
            CatchException.logException(e);
            return "";
        }
    }

    public static String getSystemLanguage(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Resources.getSystem().getConfiguration().getLocales().get(0);
            } else {
                locale = Resources.getSystem().getConfiguration().locale;
            }
            return locale.getLanguage();
        } catch (Exception e) {
            CatchException.logException(e);
            return "";
        }
    }

    public static boolean isRTL(String str) {
        if (Build.VERSION.SDK_INT < 17 || str == null || str.isEmpty() || TextUtilsCompat.getLayoutDirectionFromLocale(new Locale(str)) != 1) {
            return false;
        }
        return true;
    }

    public static void setCountry(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("country", str).commit();
    }

    public static void setLayoutDirection(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            activity.getWindow().getDecorView().setLayoutDirection(isRTL(str) ? 1 : 0);
        }
    }

    public static Context setLocale(Context context) {
        return updateConfig(context, getLanguage(context));
    }

    public static Context setNewLocale(Context context, String str) {
        m14050a(context, str);
        return updateConfig(context, str);
    }

    public static void setSystemLanguage(Context context) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.remove("language");
        edit.remove("country");
        edit.commit();
    }

    public static Context updateConfig(Context context, String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            return context;
        }
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = new Configuration();
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            configuration.setLayoutDirection(locale);
        }
        if (i < 24) {
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            return context;
        }
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    public static void updateConfig(Context context, Configuration configuration) {
        String language = getLanguage(context);
        if (!language.equalsIgnoreCase("")) {
            Locale locale = new Locale(language);
            Locale.setDefault(locale);
            int i = Build.VERSION.SDK_INT;
            if (i < 24) {
                Configuration configuration2 = new Configuration(configuration);
                if (i >= 17) {
                    configuration2.setLayoutDirection(locale);
                }
                configuration2.locale = locale;
                Resources resources = context.getResources();
                resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
            }
        }
    }
}
