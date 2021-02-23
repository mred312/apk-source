package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;

public class DataCollectionConfigStorage {
    @VisibleForTesting
    public static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";

    /* renamed from: a */
    private final Context f19659a;

    /* renamed from: b */
    private final SharedPreferences f19660b;

    /* renamed from: c */
    private final Publisher f19661c;

    /* renamed from: d */
    private boolean f19662d = m11834b();

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        Context a = m11833a(context);
        this.f19659a = a;
        this.f19660b = a.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f19661c = publisher;
    }

    /* renamed from: a */
    private static Context m11833a(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        return ContextCompat.createDeviceProtectedStorageContext(context);
    }

    /* renamed from: b */
    private boolean m11834b() {
        if (this.f19660b.contains(DATA_COLLECTION_DEFAULT_ENABLED)) {
            return this.f19660b.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED, true);
        }
        return m11835c();
    }

    /* renamed from: c */
    private boolean m11835c() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f19659a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f19659a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(DATA_COLLECTION_DEFAULT_ENABLED)) {
                return true;
            }
            return applicationInfo.metaData.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED);
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    /* renamed from: d */
    private synchronized void m11836d(boolean z) {
        if (this.f19662d != z) {
            this.f19662d = z;
            this.f19661c.publish(new Event(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(z)));
        }
    }

    public synchronized boolean isEnabled() {
        return this.f19662d;
    }

    public synchronized void setEnabled(Boolean bool) {
        if (bool == null) {
            this.f19660b.edit().remove(DATA_COLLECTION_DEFAULT_ENABLED).apply();
            m11836d(m11835c());
        } else {
            boolean equals = Boolean.TRUE.equals(bool);
            this.f19660b.edit().putBoolean(DATA_COLLECTION_DEFAULT_ENABLED, equals).apply();
            m11836d(equals);
        }
    }
}
