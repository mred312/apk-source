package com.google.firebase.components;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final class Dependency {

    /* renamed from: a */
    private final Class<?> f18917a;

    /* renamed from: b */
    private final int f18918b;

    /* renamed from: c */
    private final int f18919c;

    private Dependency(Class<?> cls, int i, int i2) {
        this.f18917a = (Class) Preconditions.checkNotNull(cls, "Null dependency anInterface.");
        this.f18918b = i;
        this.f18919c = i2;
    }

    public static Dependency optional(Class<?> cls) {
        return new Dependency(cls, 0, 0);
    }

    public static Dependency optionalProvider(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency required(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency requiredProvider(Class<?> cls) {
        return new Dependency(cls, 1, 1);
    }

    public static Dependency setOf(Class<?> cls) {
        return new Dependency(cls, 2, 0);
    }

    public static Dependency setOfProvider(Class<?> cls) {
        return new Dependency(cls, 2, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        if (this.f18917a == dependency.f18917a && this.f18918b == dependency.f18918b && this.f18919c == dependency.f18919c) {
            return true;
        }
        return false;
    }

    public Class<?> getInterface() {
        return this.f18917a;
    }

    public int hashCode() {
        return ((((this.f18917a.hashCode() ^ 1000003) * 1000003) ^ this.f18918b) * 1000003) ^ this.f18919c;
    }

    public boolean isDirectInjection() {
        return this.f18919c == 0;
    }

    public boolean isRequired() {
        return this.f18918b == 1;
    }

    public boolean isSet() {
        return this.f18918b == 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f18917a);
        sb.append(", type=");
        int i = this.f18918b;
        boolean z = true;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        if (this.f18919c != 0) {
            z = false;
        }
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
