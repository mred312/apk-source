package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzepi<T> implements zzeoz<T>, zzepf<T> {

    /* renamed from: b */
    private static final zzepi<Object> f16359b = new zzepi<>((Object) null);

    /* renamed from: a */
    private final T f16360a;

    private zzepi(T t) {
        this.f16360a = t;
    }

    public static <T> zzepf<T> zzbb(T t) {
        return new zzepi(zzepl.zza(t, "instance cannot be null"));
    }

    public static <T> zzepf<T> zzbc(T t) {
        if (t == null) {
            return f16359b;
        }
        return new zzepi(t);
    }

    public final T get() {
        return this.f16360a;
    }
}
