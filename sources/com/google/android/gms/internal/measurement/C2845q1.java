package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.q1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2845q1<T> implements zzec<T>, Serializable {

    /* renamed from: a */
    private final zzec<T> f17419a;

    /* renamed from: b */
    private volatile transient boolean f17420b;
    @NullableDecl

    /* renamed from: c */
    private transient T f17421c;

    C2845q1(zzec<T> zzec) {
        this.f17419a = (zzec) zzeb.zza(zzec);
    }

    public final String toString() {
        Object obj;
        if (this.f17420b) {
            String valueOf = String.valueOf(this.f17421c);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        } else {
            obj = this.f17419a;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    public final T zza() {
        if (!this.f17420b) {
            synchronized (this) {
                if (!this.f17420b) {
                    T zza = this.f17419a.zza();
                    this.f17421c = zza;
                    this.f17420b = true;
                    return zza;
                }
            }
        }
        return this.f17421c;
    }
}
