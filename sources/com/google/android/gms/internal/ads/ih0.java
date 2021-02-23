package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ih0 implements zzrf {

    /* renamed from: a */
    private final /* synthetic */ Activity f9326a;

    ih0(gh0 gh0, Activity activity) {
        this.f9326a = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f9326a);
    }
}
