package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;

public class DataCollectionArbiter {

    /* renamed from: a */
    private final SharedPreferences f19033a;

    /* renamed from: b */
    private final FirebaseApp f19034b;

    /* renamed from: c */
    private final Object f19035c;

    /* renamed from: d */
    TaskCompletionSource<Void> f19036d = new TaskCompletionSource<>();

    /* renamed from: e */
    boolean f19037e = false;

    /* renamed from: f */
    private boolean f19038f = false;
    @Nullable

    /* renamed from: g */
    private Boolean f19039g;

    /* renamed from: h */
    private TaskCompletionSource<Void> f19040h = new TaskCompletionSource<>();

    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Object obj = new Object();
        this.f19035c = obj;
        Context applicationContext = firebaseApp.getApplicationContext();
        this.f19034b = firebaseApp;
        this.f19033a = CommonUtils.getSharedPrefs(applicationContext);
        Boolean b = m11267b();
        this.f19039g = b == null ? m11266a(applicationContext) : b;
        synchronized (obj) {
            if (isAutomaticDataCollectionEnabled()) {
                this.f19036d.trySetResult(null);
                this.f19037e = true;
            }
        }
    }

    @Nullable
    /* renamed from: a */
    private Boolean m11266a(Context context) {
        Boolean d = m11269d(context);
        if (d == null) {
            this.f19038f = false;
            return null;
        }
        this.f19038f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(d));
    }

    @Nullable
    /* renamed from: b */
    private Boolean m11267b() {
        if (!this.f19033a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f19038f = false;
        return Boolean.valueOf(this.f19033a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    /* renamed from: c */
    private void m11268c(boolean z) {
        String str;
        String str2 = z ? "ENABLED" : "DISABLED";
        if (this.f19039g == null) {
            str = "global Firebase setting";
        } else {
            str = this.f19038f ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        }
        Logger.getLogger().mo20859d(String.format("Crashlytics automatic data collection %s by %s.", new Object[]{str2, str}));
    }

    @Nullable
    /* renamed from: d */
    private static Boolean m11269d(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e) {
            Logger.getLogger().mo20860d("Unable to get PackageManager. Falling through", e);
            return null;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: e */
    private static void m11270e(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (bool != null) {
            edit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            edit.remove("firebase_crashlytics_collection_enabled");
        }
        edit.commit();
    }

    public void grantDataCollectionPermission(boolean z) {
        if (z) {
            this.f19040h.trySetResult(null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public synchronized boolean isAutomaticDataCollectionEnabled() {
        boolean z;
        Boolean bool = this.f19039g;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = this.f19034b.isDataCollectionDefaultEnabled();
        }
        m11268c(z);
        return z;
    }

    public synchronized void setCrashlyticsDataCollectionEnabled(@Nullable Boolean bool) {
        Boolean bool2;
        if (bool != null) {
            try {
                this.f19038f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            bool2 = bool;
        } else {
            bool2 = m11266a(this.f19034b.getApplicationContext());
        }
        this.f19039g = bool2;
        m11270e(this.f19033a, bool);
        synchronized (this.f19035c) {
            if (isAutomaticDataCollectionEnabled()) {
                if (!this.f19037e) {
                    this.f19036d.trySetResult(null);
                    this.f19037e = true;
                }
            } else if (this.f19037e) {
                this.f19036d = new TaskCompletionSource<>();
                this.f19037e = false;
            }
        }
    }

    public Task<Void> waitForAutomaticDataCollectionEnabled() {
        Task<Void> task;
        synchronized (this.f19035c) {
            task = this.f19036d.getTask();
        }
        return task;
    }

    public Task<Void> waitForDataCollectionPermission() {
        return Utils.race(this.f19040h.getTask(), waitForAutomaticDataCollectionEnabled());
    }
}
