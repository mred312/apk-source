package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.s1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2861s1<T> implements zzec<T> {

    /* renamed from: a */
    private volatile zzec<T> f17453a;

    /* renamed from: b */
    private volatile boolean f17454b;
    @NullableDecl

    /* renamed from: c */
    private T f17455c;

    C2861s1(zzec<T> zzec) {
        this.f17453a = (zzec) zzeb.zza(zzec);
    }

    public final String toString() {
        Object obj = this.f17453a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f17455c);
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
        if (!this.f17454b) {
            synchronized (this) {
                if (!this.f17454b) {
                    T zza = this.f17453a.zza();
                    this.f17455c = zza;
                    this.f17454b = true;
                    this.f17453a = null;
                    return zza;
                }
            }
        }
        return this.f17455c;
    }
}
