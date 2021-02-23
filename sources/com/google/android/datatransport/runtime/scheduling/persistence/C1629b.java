package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.b */
/* compiled from: AutoValue_PersistedEvent */
final class C1629b extends PersistedEvent {

    /* renamed from: a */
    private final long f7373a;

    /* renamed from: b */
    private final TransportContext f7374b;

    /* renamed from: c */
    private final EventInternal f7375c;

    C1629b(long j, TransportContext transportContext, EventInternal eventInternal) {
        this.f7373a = j;
        if (transportContext != null) {
            this.f7374b = transportContext;
            if (eventInternal != null) {
                this.f7375c = eventInternal;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        if (this.f7373a != persistedEvent.getId() || !this.f7374b.equals(persistedEvent.getTransportContext()) || !this.f7375c.equals(persistedEvent.getEvent())) {
            return false;
        }
        return true;
    }

    public EventInternal getEvent() {
        return this.f7375c;
    }

    public long getId() {
        return this.f7373a;
    }

    public TransportContext getTransportContext() {
        return this.f7374b;
    }

    public int hashCode() {
        long j = this.f7373a;
        return this.f7375c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f7374b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f7373a + ", transportContext=" + this.f7374b + ", event=" + this.f7375c + "}";
    }
}
