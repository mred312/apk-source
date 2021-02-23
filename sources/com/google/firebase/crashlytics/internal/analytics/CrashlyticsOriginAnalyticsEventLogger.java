package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;

public class CrashlyticsOriginAnalyticsEventLogger implements AnalyticsEventLogger {
    @NonNull

    /* renamed from: a */
    private final AnalyticsConnector f18986a;

    public CrashlyticsOriginAnalyticsEventLogger(@NonNull AnalyticsConnector analyticsConnector) {
        this.f18986a = analyticsConnector;
    }

    public void logEvent(@NonNull String str, @Nullable Bundle bundle) {
        this.f18986a.logEvent("clx", str, bundle);
    }
}
