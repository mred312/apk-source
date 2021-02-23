package com.google.android.datatransport;

import androidx.annotation.Nullable;

/* renamed from: com.google.android.datatransport.a */
/* compiled from: AutoValue_Event */
final class C1547a<T> extends Event<T> {

    /* renamed from: a */
    private final Integer f7076a;

    /* renamed from: b */
    private final T f7077b;

    /* renamed from: c */
    private final Priority f7078c;

    C1547a(@Nullable Integer num, T t, Priority priority) {
        this.f7076a = num;
        if (t != null) {
            this.f7077b = t;
            if (priority != null) {
                this.f7078c = priority;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.f7076a;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            if (!this.f7077b.equals(event.getPayload()) || !this.f7078c.equals(event.getPriority())) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Nullable
    public Integer getCode() {
        return this.f7076a;
    }

    public T getPayload() {
        return this.f7077b;
    }

    public Priority getPriority() {
        return this.f7078c;
    }

    public int hashCode() {
        Integer num = this.f7076a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f7077b.hashCode()) * 1000003) ^ this.f7078c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f7076a + ", payload=" + this.f7077b + ", priority=" + this.f7078c + "}";
    }
}
