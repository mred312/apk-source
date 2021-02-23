package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public abstract class zzdy<T> implements Serializable {
    zzdy() {
    }

    public static <T> zzdy<T> zza(T t) {
        return new C2837p1(zzeb.zza(t));
    }

    public static <T> zzdy<T> zzc() {
        return C2813m1.f17375a;
    }

    public abstract boolean zza();

    public abstract T zzb();
}
