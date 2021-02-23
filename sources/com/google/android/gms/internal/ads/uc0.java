package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class uc0 implements zzeu {

    /* renamed from: a */
    private final /* synthetic */ Activity f11321a;

    uc0(ka0 ka0, Activity activity) {
        this.f11321a = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f11321a);
    }
}
