package com.google.firebase.crashlytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;

/* renamed from: com.google.firebase.crashlytics.a */
/* compiled from: CrashlyticsAnalyticsListener */
class C3256a implements AnalyticsConnector.AnalyticsConnectorListener {

    /* renamed from: a */
    private AnalyticsEventReceiver f18955a;

    /* renamed from: b */
    private AnalyticsEventReceiver f18956b;

    C3256a() {
    }

    /* renamed from: a */
    private static void m11200a(@Nullable AnalyticsEventReceiver analyticsEventReceiver, @NonNull String str, @NonNull Bundle bundle) {
        if (analyticsEventReceiver != null) {
            analyticsEventReceiver.onEvent(str, bundle);
        }
    }

    /* renamed from: b */
    private void m11201b(@NonNull String str, @NonNull Bundle bundle) {
        AnalyticsEventReceiver analyticsEventReceiver;
        if ("clx".equals(bundle.getString("_o"))) {
            analyticsEventReceiver = this.f18955a;
        } else {
            analyticsEventReceiver = this.f18956b;
        }
        m11200a(analyticsEventReceiver, str, bundle);
    }

    /* renamed from: c */
    public void mo20849c(@Nullable AnalyticsEventReceiver analyticsEventReceiver) {
        this.f18956b = analyticsEventReceiver;
    }

    /* renamed from: d */
    public void mo20850d(@Nullable AnalyticsEventReceiver analyticsEventReceiver) {
        this.f18955a = analyticsEventReceiver;
    }

    public void onMessageTriggered(int i, @Nullable Bundle bundle) {
        String string;
        Logger logger = Logger.getLogger();
        logger.mo20859d("Received Analytics message: " + i + " " + bundle);
        if (bundle != null && (string = bundle.getString("name")) != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            m11201b(string, bundle2);
        }
    }
}
