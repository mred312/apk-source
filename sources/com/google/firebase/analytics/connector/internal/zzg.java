package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.6.0 */
public final class zzg implements zza {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AnalyticsConnector.AnalyticsConnectorListener f18894a;

    /* renamed from: b */
    private AppMeasurementSdk f18895b;

    /* renamed from: c */
    private C3231c f18896c;

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f18894a = analyticsConnectorListener;
        this.f18895b = appMeasurementSdk;
        C3231c cVar = new C3231c(this);
        this.f18896c = cVar;
        appMeasurementSdk.registerOnMeasurementEventListener(cVar);
    }

    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.f18894a;
    }

    public final void zza(Set<String> set) {
    }

    public final void zzb() {
    }
}
