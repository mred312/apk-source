package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

/* renamed from: com.google.firebase.components.i */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
final /* synthetic */ class C3248i implements Runnable {

    /* renamed from: a */
    private final Map.Entry f18936a;

    /* renamed from: b */
    private final Event f18937b;

    private C3248i(Map.Entry entry, Event event) {
        this.f18936a = entry;
        this.f18937b = event;
    }

    /* renamed from: a */
    public static Runnable m11191a(Map.Entry entry, Event event) {
        return new C3248i(entry, event);
    }

    public void run() {
        ((EventHandler) this.f18936a.getKey()).handle(this.f18937b);
    }
}
