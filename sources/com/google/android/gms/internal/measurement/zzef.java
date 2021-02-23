package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzef {
    public static <T> zzec<T> zza(zzec<T> zzec) {
        if ((zzec instanceof C2861s1) || (zzec instanceof C2845q1)) {
            return zzec;
        }
        if (zzec instanceof Serializable) {
            return new C2845q1(zzec);
        }
        return new C2861s1(zzec);
    }

    public static <T> zzec<T> zza(@NullableDecl T t) {
        return new C2853r1(t);
    }
}
