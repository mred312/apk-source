package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

public class IdManager implements InstallIdProvider {
    public static final String DEFAULT_VERSION_NAME = "0.0";

    /* renamed from: f */
    private static final Pattern f19051f = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: g */
    private static final String f19052g = Pattern.quote("/");

    /* renamed from: a */
    private final C3328m f19053a;

    /* renamed from: b */
    private final Context f19054b;

    /* renamed from: c */
    private final String f19055c;

    /* renamed from: d */
    private final FirebaseInstallationsApi f19056d;

    /* renamed from: e */
    private String f19057e;

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str != null) {
            this.f19054b = context;
            this.f19055c = str;
            this.f19056d = firebaseInstallationsApi;
            this.f19053a = new C3328m();
        } else {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
    }

    /* renamed from: a */
    private synchronized String m11274a(String str, SharedPreferences sharedPreferences) {
        String b;
        b = m11275b(UUID.randomUUID().toString());
        Logger logger = Logger.getLogger();
        logger.mo20859d("Created new Crashlytics IID: " + b);
        sharedPreferences.edit().putString("crashlytics.installation.id", b).putString("firebase.installation.id", str).apply();
        return b;
    }

    /* renamed from: b */
    private static String m11275b(String str) {
        if (str == null) {
            return null;
        }
        return f19051f.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    /* renamed from: c */
    private synchronized void m11276c(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        Logger logger = Logger.getLogger();
        logger.mo20859d("Migrating legacy Crashlytics IID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
    }

    /* renamed from: d */
    private String m11277d(String str) {
        return str.replaceAll(f19052g, "");
    }

    public String getAppIdentifier() {
        return this.f19055c;
    }

    @NonNull
    public synchronized String getCrashlyticsInstallId() {
        String str;
        String str2 = this.f19057e;
        if (str2 != null) {
            return str2;
        }
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.f19054b);
        Task<String> id = this.f19056d.getId();
        String string = sharedPrefs.getString("firebase.installation.id", (String) null);
        try {
            str = (String) Utils.awaitEvenIfOnMainThread(id);
        } catch (Exception e) {
            Logger.getLogger().mo20860d("Failed to retrieve installation id", e);
            str = string != null ? string : null;
        }
        if (string == null) {
            SharedPreferences legacySharedPrefs = CommonUtils.getLegacySharedPrefs(this.f19054b);
            String string2 = legacySharedPrefs.getString("crashlytics.installation.id", (String) null);
            Logger logger = Logger.getLogger();
            logger.mo20859d("No cached FID; legacy id is " + string2);
            if (string2 == null) {
                this.f19057e = m11274a(str, sharedPrefs);
            } else {
                this.f19057e = string2;
                m11276c(string2, str, sharedPrefs, legacySharedPrefs);
            }
            return this.f19057e;
        }
        if (string.equals(str)) {
            this.f19057e = sharedPrefs.getString("crashlytics.installation.id", (String) null);
            Logger logger2 = Logger.getLogger();
            logger2.mo20859d("Found matching FID, using Crashlytics IID: " + this.f19057e);
            if (this.f19057e == null) {
                this.f19057e = m11274a(str, sharedPrefs);
            }
        } else {
            this.f19057e = m11274a(str, sharedPrefs);
        }
        return this.f19057e;
    }

    public String getInstallerPackageName() {
        return this.f19053a.mo21033a(this.f19054b);
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", new Object[]{m11277d(Build.MANUFACTURER), m11277d(Build.MODEL)});
    }

    public String getOsBuildVersionString() {
        return m11277d(Build.VERSION.INCREMENTAL);
    }

    public String getOsDisplayVersionString() {
        return m11277d(Build.VERSION.RELEASE);
    }
}
