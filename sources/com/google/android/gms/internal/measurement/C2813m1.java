package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.m1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2813m1<T> extends zzdy<T> {

    /* renamed from: a */
    static final C2813m1<Object> f17375a = new C2813m1<>();

    private C2813m1() {
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    public final boolean zza() {
        return false;
    }

    public final T zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }
}
