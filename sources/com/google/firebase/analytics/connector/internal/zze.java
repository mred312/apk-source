package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.6.0 */
public final class zze implements zza {

    /* renamed from: a */
    Set<String> f18890a = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AnalyticsConnector.AnalyticsConnectorListener f18891b;

    /* renamed from: c */
    private AppMeasurementSdk f18892c;

    /* renamed from: d */
    private C3230b f18893d;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f18891b = analyticsConnectorListener;
        this.f18892c = appMeasurementSdk;
        C3230b bVar = new C3230b(this);
        this.f18893d = bVar;
        appMeasurementSdk.registerOnMeasurementEventListener(bVar);
    }

    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.f18891b;
    }

    public final void zzb() {
        this.f18890a.clear();
    }

    public final void zza(Set<String> set) {
        this.f18890a.clear();
        Set<String> set2 = this.f18890a;
        HashSet hashSet = new HashSet();
        for (String next : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzb.zzd(next) && zzb.zzc(next)) {
                hashSet.add(zzb.zzf(next));
            }
        }
        set2.addAll(hashSet);
    }
}
