package com.google.android.gms.internal.common;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.common.c */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C2709c<T> implements zzo<T> {

    /* renamed from: a */
    private volatile zzo<T> f17201a;

    /* renamed from: b */
    private volatile boolean f17202b;
    @NullableDecl

    /* renamed from: c */
    private T f17203c;

    C2709c(zzo<T> zzo) {
        this.f17201a = (zzo) zzl.zza(zzo);
    }

    public final String toString() {
        Object obj = this.f17201a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f17203c);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    public final T zza() {
        if (!this.f17202b) {
            synchronized (this) {
                if (!this.f17202b) {
                    T zza = this.f17201a.zza();
                    this.f17203c = zza;
                    this.f17202b = true;
                    this.f17201a = null;
                    return zza;
                }
            }
        }
        return this.f17203c;
    }
}
