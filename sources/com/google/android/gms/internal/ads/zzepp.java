package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzepp<T> implements zzeps<T> {

    /* renamed from: c */
    private static final Object f16364c = new Object();

    /* renamed from: a */
    private volatile zzeps<T> f16365a;

    /* renamed from: b */
    private volatile Object f16366b = f16364c;

    private zzepp(zzeps<T> zzeps) {
        this.f16365a = zzeps;
    }

    public static <P extends zzeps<T>, T> zzeps<T> zzas(P p) {
        return ((p instanceof zzepp) || (p instanceof zzepg)) ? p : new zzepp((zzeps) zzepl.checkNotNull(p));
    }

    public final T get() {
        T t = this.f16366b;
        if (t != f16364c) {
            return t;
        }
        zzeps<T> zzeps = this.f16365a;
        if (zzeps == null) {
            return this.f16366b;
        }
        T t2 = zzeps.get();
        this.f16366b = t2;
        this.f16365a = null;
        return t2;
    }
}
