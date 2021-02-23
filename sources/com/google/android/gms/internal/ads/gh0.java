package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class gh0 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final Application f8773a;

    /* renamed from: b */
    private final WeakReference<Application.ActivityLifecycleCallbacks> f8774b;

    /* renamed from: c */
    private boolean f8775c = false;

    public gh0(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f8774b = new WeakReference<>(activityLifecycleCallbacks);
        this.f8773a = application;
    }

    /* renamed from: a */
    private final void m6096a(zzrf zzrf) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.f8774b.get();
            if (activityLifecycleCallbacks != null) {
                zzrf.zza(activityLifecycleCallbacks);
            } else if (!this.f8775c) {
                this.f8773a.unregisterActivityLifecycleCallbacks(this);
                this.f8775c = true;
            }
        } catch (Exception e) {
            zzaza.zzc("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m6096a(new fh0(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        m6096a(new lh0(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        m6096a(new kh0(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        m6096a(new hh0(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m6096a(new mh0(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        m6096a(new ih0(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        m6096a(new jh0(this, activity));
    }
}
