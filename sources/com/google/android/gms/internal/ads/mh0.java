package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class mh0 implements zzrf {

    /* renamed from: a */
    private final /* synthetic */ Activity f9985a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f9986b;

    mh0(gh0 gh0, Activity activity, Bundle bundle) {
        this.f9985a = activity;
        this.f9986b = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f9985a, this.f9986b);
    }
}
