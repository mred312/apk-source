package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e */
    private static final BackgroundDetector f7470e = new BackgroundDetector();

    /* renamed from: a */
    private final AtomicBoolean f7471a = new AtomicBoolean();

    /* renamed from: b */
    private final AtomicBoolean f7472b = new AtomicBoolean();
    @GuardedBy("sInstance")

    /* renamed from: c */
    private final ArrayList<BackgroundStateChangeListener> f7473c = new ArrayList<>();
    @GuardedBy("sInstance")

    /* renamed from: d */
    private boolean f7474d = false;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @KeepForSdk
    private BackgroundDetector() {
    }

    /* renamed from: a */
    private final void m5251a(boolean z) {
        synchronized (f7470e) {
            ArrayList<BackgroundStateChangeListener> arrayList = this.f7473c;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                BackgroundStateChangeListener backgroundStateChangeListener = arrayList.get(i);
                i++;
                backgroundStateChangeListener.onBackgroundStateChanged(z);
            }
        }
    }

    @KeepForSdk
    public static BackgroundDetector getInstance() {
        return f7470e;
    }

    @KeepForSdk
    public static void initialize(Application application) {
        BackgroundDetector backgroundDetector = f7470e;
        synchronized (backgroundDetector) {
            if (!backgroundDetector.f7474d) {
                application.registerActivityLifecycleCallbacks(backgroundDetector);
                application.registerComponentCallbacks(backgroundDetector);
                backgroundDetector.f7474d = true;
            }
        }
    }

    @KeepForSdk
    public final void addListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (f7470e) {
            this.f7473c.add(backgroundStateChangeListener);
        }
    }

    @KeepForSdk
    public final boolean isInBackground() {
        return this.f7471a.get();
    }

    public final void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
        boolean compareAndSet = this.f7471a.compareAndSet(true, false);
        this.f7472b.set(true);
        if (compareAndSet) {
            m5251a(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f7471a.compareAndSet(true, false);
        this.f7472b.set(true);
        if (compareAndSet) {
            m5251a(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.f7471a.compareAndSet(false, true)) {
            this.f7472b.set(true);
            m5251a(true);
        }
    }

    @TargetApi(16)
    @KeepForSdk
    public final boolean readCurrentStateIfPossible(boolean z) {
        if (!this.f7472b.get()) {
            if (!PlatformVersion.isAtLeastJellyBean()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f7472b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f7471a.set(true);
            }
        }
        return isInBackground();
    }
}
