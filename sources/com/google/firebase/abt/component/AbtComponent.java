package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashMap;
import java.util.Map;

public class AbtComponent {
    @GuardedBy("this")

    /* renamed from: a */
    private final Map<String, FirebaseABTesting> f18865a = new HashMap();

    /* renamed from: b */
    private final Context f18866b;

    /* renamed from: c */
    private final AnalyticsConnector f18867c;

    @VisibleForTesting(otherwise = 3)
    protected AbtComponent(Context context, AnalyticsConnector analyticsConnector) {
        this.f18866b = context;
        this.f18867c = analyticsConnector;
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public FirebaseABTesting createAbtInstance(String str) {
        return new FirebaseABTesting(this.f18866b, this.f18867c, str);
    }

    public synchronized FirebaseABTesting get(String str) {
        if (!this.f18865a.containsKey(str)) {
            this.f18865a.put(str, createAbtInstance(str));
        }
        return this.f18865a.get(str);
    }
}
