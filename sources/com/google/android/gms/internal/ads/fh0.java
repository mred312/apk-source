package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class fh0 implements zzrf {

    /* renamed from: a */
    private final /* synthetic */ Activity f8467a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f8468b;

    fh0(gh0 gh0, Activity activity, Bundle bundle) {
        this.f8467a = activity;
        this.f8468b = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f8467a, this.f8468b);
    }
}
