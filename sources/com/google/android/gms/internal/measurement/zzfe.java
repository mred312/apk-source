package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public class zzfe<K, V> extends C2885v1<K, V> implements Serializable {

    /* renamed from: a */
    private final transient zzfc<K, ? extends zzey<V>> f17650a;

    zzfe(zzfc<K, ? extends zzey<V>> zzfc, int i) {
        this.f17650a = zzfc;
    }

    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public final boolean zza(@NullableDecl Object obj) {
        return obj != null && super.zza(obj);
    }

    public final /* synthetic */ Map zza() {
        return this.f17650a;
    }
}
