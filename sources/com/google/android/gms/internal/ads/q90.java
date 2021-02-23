package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class q90 implements zzeu {

    /* renamed from: a */
    private final /* synthetic */ Activity f10697a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f10698b;

    q90(ka0 ka0, Activity activity, Bundle bundle) {
        this.f10697a = activity;
        this.f10698b = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f10697a, this.f10698b);
    }
}
