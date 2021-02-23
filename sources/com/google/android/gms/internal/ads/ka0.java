package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ka0 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final Application f9737a;

    /* renamed from: b */
    private final WeakReference<Application.ActivityLifecycleCallbacks> f9738b;

    /* renamed from: c */
    private boolean f9739c = false;

    public ka0(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f9738b = new WeakReference<>(activityLifecycleCallbacks);
        this.f9737a = application;
    }

    /* renamed from: a */
    private final void m6422a(zzeu zzeu) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.f9738b.get();
            if (activityLifecycleCallbacks != null) {
                zzeu.zza(activityLifecycleCallbacks);
            } else if (!this.f9739c) {
                this.f9737a.unregisterActivityLifecycleCallbacks(this);
                this.f9739c = true;
            }
        } catch (Exception unused) {
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m6422a(new q90(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        m6422a(new uc0(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        m6422a(new tc0(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        m6422a(new jb0(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m6422a(new vc0(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        m6422a(new fc0(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        m6422a(new pc0(this, activity));
    }
}
