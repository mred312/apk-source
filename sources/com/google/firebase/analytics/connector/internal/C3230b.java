package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* renamed from: com.google.firebase.analytics.connector.internal.b */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.6.0 */
final class C3230b implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a */
    private final /* synthetic */ zze f18882a;

    public C3230b(zze zze) {
        this.f18882a = zze;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (this.f18882a.f18890a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzb.zze(str2));
            this.f18882a.f18891b.onMessageTriggered(2, bundle2);
        }
    }
}
