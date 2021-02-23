package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.w1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
abstract class C2893w1<K, V> implements zzfk<K, V> {
    C2893w1() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfk) {
            return zza().equals(((zzfk) obj).zza());
        }
        return false;
    }

    public int hashCode() {
        return zza().hashCode();
    }

    public String toString() {
        return zza().toString();
    }

    public abstract Map<K, Collection<V>> zza();

    public boolean zza(@NullableDecl Object obj) {
        for (Collection contains : zza().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
