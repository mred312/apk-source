package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class Event<T> {

    /* renamed from: a */
    private final Class<T> f19566a;

    /* renamed from: b */
    private final T f19567b;

    public Event(Class<T> cls, T t) {
        this.f19566a = (Class) Preconditions.checkNotNull(cls);
        this.f19567b = Preconditions.checkNotNull(t);
    }

    public T getPayload() {
        return this.f19567b;
    }

    public Class<T> getType() {
        return this.f19566a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", new Object[]{this.f19566a, this.f19567b});
    }
}
