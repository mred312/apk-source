package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.events.Subscriber;

/* renamed from: com.google.firebase.analytics.connector.internal.a */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.6.0 */
final /* synthetic */ class C3229a implements ComponentFactory {

    /* renamed from: a */
    static final ComponentFactory f18881a = new C3229a();

    private C3229a() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return AnalyticsConnectorImpl.getInstance((FirebaseApp) componentContainer.get(FirebaseApp.class), (Context) componentContainer.get(Context.class), (Subscriber) componentContainer.get(Subscriber.class));
    }
}
