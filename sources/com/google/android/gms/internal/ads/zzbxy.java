package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbxy<T> {
    public Executor executor;
    public T zzfzl;

    public zzbxy(T t, Executor executor2) {
        this.zzfzl = t;
        this.executor = executor2;
    }

    public static <T> zzbxy<T> zzb(T t, Executor executor2) {
        return new zzbxy<>(t, executor2);
    }
}
