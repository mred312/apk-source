package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* renamed from: com.google.firebase.analytics.connector.internal.c */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.6.0 */
final class C3231c implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a */
    private final /* synthetic */ zzg f18883a;

    public C3231c(zzg zzg) {
        this.f18883a = zzg;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (str != null && !str.equals("crash") && zzb.zzb(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("timestampInMillis", j);
            bundle2.putBundle("params", bundle);
            this.f18883a.f18894a.onMessageTriggered(3, bundle2);
        }
    }
}
