package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.r1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2853r1<T> implements zzec<T>, Serializable {
    @NullableDecl

    /* renamed from: a */
    private final T f17434a;

    C2853r1(@NullableDecl T t) {
        this.f17434a = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof C2853r1) {
            return zzdz.zza(this.f17434a, ((C2853r1) obj).f17434a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17434a});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f17434a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }

    public final T zza() {
        return this.f17434a;
    }
}
