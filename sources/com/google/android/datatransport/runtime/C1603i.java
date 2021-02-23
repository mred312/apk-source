package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;

/* renamed from: com.google.android.datatransport.runtime.i */
/* compiled from: TransportImpl */
final class C1603i<T> implements Transport<T> {

    /* renamed from: a */
    private final TransportContext f7249a;

    /* renamed from: b */
    private final String f7250b;

    /* renamed from: c */
    private final Encoding f7251c;

    /* renamed from: d */
    private final Transformer<T, byte[]> f7252d;

    /* renamed from: e */
    private final C1604j f7253e;

    C1603i(TransportContext transportContext, String str, Encoding encoding, Transformer<T, byte[]> transformer, C1604j jVar) {
        this.f7249a = transportContext;
        this.f7250b = str;
        this.f7251c = encoding;
        this.f7252d = transformer;
        this.f7253e = jVar;
    }

    /* renamed from: a */
    static /* synthetic */ void m5066a(Exception exc) {
    }

    public void schedule(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
        this.f7253e.send(SendRequest.m5032a().setTransportContext(this.f7249a).mo11399b(event).setTransportName(this.f7250b).mo11401c(this.f7252d).mo11398a(this.f7251c).build(), transportScheduleCallback);
    }

    public void send(Event<T> event) {
        schedule(event, C1602h.m5065a());
    }
}
