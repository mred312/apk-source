package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FieldDescriptor {

    /* renamed from: a */
    private final String f19542a;

    /* renamed from: b */
    private final Map<Class<?>, Object> f19543b;

    public static final class Builder {

        /* renamed from: a */
        private final String f19544a;

        /* renamed from: b */
        private Map<Class<?>, Object> f19545b = null;

        Builder(String str) {
            this.f19544a = str;
        }

        @NonNull
        public FieldDescriptor build() {
            Map map;
            String str = this.f19544a;
            if (this.f19545b == null) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(new HashMap(this.f19545b));
            }
            return new FieldDescriptor(str, map);
        }

        @NonNull
        public <T extends Annotation> Builder withProperty(@NonNull T t) {
            if (this.f19545b == null) {
                this.f19545b = new HashMap();
            }
            this.f19545b.put(t.annotationType(), t);
            return this;
        }
    }

    @NonNull
    public static Builder builder(@NonNull String str) {
        return new Builder(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        if (!this.f19542a.equals(fieldDescriptor.f19542a) || !this.f19543b.equals(fieldDescriptor.f19543b)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getName() {
        return this.f19542a;
    }

    @Nullable
    public <T extends Annotation> T getProperty(@NonNull Class<T> cls) {
        return (Annotation) this.f19543b.get(cls);
    }

    public int hashCode() {
        return (this.f19542a.hashCode() * 31) + this.f19543b.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.f19542a + ", properties=" + this.f19543b.values() + "}";
    }

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.f19542a = str;
        this.f19543b = map;
    }
}
