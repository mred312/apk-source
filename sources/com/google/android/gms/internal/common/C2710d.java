package com.google.android.gms.internal.common;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.common.d */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C2710d<T> implements zzo<T>, Serializable {

    /* renamed from: a */
    private final zzo<T> f17204a;

    /* renamed from: b */
    private volatile transient boolean f17205b;
    @NullableDecl

    /* renamed from: c */
    private transient T f17206c;

    C2710d(zzo<T> zzo) {
        this.f17204a = (zzo) zzl.zza(zzo);
    }

    public final String toString() {
        Object obj;
        if (this.f17205b) {
            String valueOf = String.valueOf(this.f17206c);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        } else {
            obj = this.f17204a;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    public final T zza() {
        if (!this.f17205b) {
            synchronized (this) {
                if (!this.f17205b) {
                    T zza = this.f17204a.zza();
                    this.f17206c = zza;
                    this.f17205b = true;
                    return zza;
                }
            }
        }
        return this.f17206c;
    }
}
