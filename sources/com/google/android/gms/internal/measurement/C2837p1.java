package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.p1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2837p1<T> extends zzdy<T> {

    /* renamed from: a */
    private final T f17404a;

    C2837p1(T t) {
        this.f17404a = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof C2837p1) {
            return this.f17404a.equals(((C2837p1) obj).f17404a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f17404a.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f17404a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }

    public final boolean zza() {
        return true;
    }

    public final T zzb() {
        return this.f17404a;
    }
}
