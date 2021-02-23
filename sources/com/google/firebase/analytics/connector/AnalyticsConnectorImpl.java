package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzb;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.6.0 */
public class AnalyticsConnectorImpl implements AnalyticsConnector {

    /* renamed from: c */
    private static volatile AnalyticsConnector f18874c;
    @VisibleForTesting

    /* renamed from: a */
    private final AppMeasurementSdk f18875a;
    @VisibleForTesting

    /* renamed from: b */
    final Map<String, zza> f18876b = new ConcurrentHashMap();

    /* renamed from: com.google.firebase.analytics.connector.AnalyticsConnectorImpl$a */
    /* compiled from: com.google.android.gms:play-services-measurement-api@@17.6.0 */
    class C3225a implements AnalyticsConnector.AnalyticsConnectorHandle {

        /* renamed from: a */
        private final /* synthetic */ String f18877a;

        C3225a(String str) {
            this.f18877a = str;
        }

        @KeepForSdk
        public void registerEventNames(Set<String> set) {
            if (AnalyticsConnectorImpl.this.m11152c(this.f18877a) && this.f18877a.equals("fiam") && set != null && !set.isEmpty()) {
                AnalyticsConnectorImpl.this.f18876b.get(this.f18877a).zza(set);
            }
        }

        public void unregister() {
            if (AnalyticsConnectorImpl.this.m11152c(this.f18877a)) {
                AnalyticsConnector.AnalyticsConnectorListener zza = AnalyticsConnectorImpl.this.f18876b.get(this.f18877a).zza();
                if (zza != null) {
                    zza.onMessageTriggered(0, (Bundle) null);
                }
                AnalyticsConnectorImpl.this.f18876b.remove(this.f18877a);
            }
        }

        @KeepForSdk
        public void unregisterEventNames() {
            if (AnalyticsConnectorImpl.this.m11152c(this.f18877a) && this.f18877a.equals("fiam")) {
                AnalyticsConnectorImpl.this.f18876b.get(this.f18877a).zzb();
            }
        }
    }

    private AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.f18875a = appMeasurementSdk;
    }

    /* renamed from: a */
    static final /* synthetic */ void m11150a(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) f18874c).f18875a.zza(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final boolean m11152c(@NonNull String str) {
        return !str.isEmpty() && this.f18876b.containsKey(str) && this.f18876b.get(str) != null;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f18874c == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (f18874c == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, C3227a.f18879a, C3228b.f18880a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    f18874c = new AnalyticsConnectorImpl(zzag.zza(context, (String) null, (String) null, (String) null, bundle).zza());
                }
            }
        }
        return f18874c;
    }

    @KeepForSdk
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (str2 == null || zzb.zza(str2, bundle)) {
            this.f18875a.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @WorkerThread
    @KeepForSdk
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Size(max = 23, min = 1) @Nullable String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle zza : this.f18875a.getConditionalUserProperties(str, str2)) {
            arrayList.add(zzb.zza(zza));
        }
        return arrayList;
    }

    @WorkerThread
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.f18875a.getMaxUserProperties(str);
    }

    @WorkerThread
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        return this.f18875a.getUserProperties((String) null, (String) null, z);
    }

    @KeepForSdk
    public void logEvent(@NonNull String str, @NonNull String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzb.zza(str) && zzb.zza(str2, bundle) && zzb.zza(str, str2, bundle)) {
            zzb.zzb(str, str2, bundle);
            this.f18875a.logEvent(str, str2, bundle);
        }
    }

    @WorkerThread
    @KeepForSdk
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzb.zza(str) || m11152c(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.f18875a;
        if ("fiam".equals(str)) {
            obj = new zze(appMeasurementSdk, analyticsConnectorListener);
        } else if ("crash".equals(str) || "clx".equals(str)) {
            obj = new zzg(appMeasurementSdk, analyticsConnectorListener);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        this.f18876b.put(str, obj);
        return new C3225a(str);
    }

    @KeepForSdk
    public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzb.zza(conditionalUserProperty)) {
            this.f18875a.setConditionalUserProperty(zzb.zzb(conditionalUserProperty));
        }
    }

    @KeepForSdk
    public void setUserProperty(@NonNull String str, @NonNull String str2, Object obj) {
        if (zzb.zza(str) && zzb.zza(str, str2)) {
            this.f18875a.setUserProperty(str, str2, obj);
        }
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }
}
