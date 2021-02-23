package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.o30;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdyr extends m30 {
    public static <V> zzdyz<V> immediateFailedFuture(Throwable th) {
        zzdvv.checkNotNull(th);
        return new o30.C2236a(th);
    }

    public static <O> zzdyz<O> zza(zzdxz<O> zzdxz, Executor executor) {
        d40 d40 = new d40(zzdxz);
        executor.execute(d40);
        return d40;
    }

    public static <V> zzdyz<V> zzag(@NullableDecl V v) {
        if (v == null) {
            return o30.f10250b;
        }
        return new o30(v);
    }

    public static <V, X extends Throwable> zzdyz<V> zzb(zzdyz<? extends V> zzdyz, Class<X> cls, zzdyb<? super X, ? extends V> zzdyb, Executor executor) {
        return r20.m6790u(zzdyz, cls, zzdyb, executor);
    }

    public static <V> zzdyz<List<V>> zzi(Iterable<? extends zzdyz<? extends V>> iterable) {
        return new d30(zzdwm.zzh(iterable), true);
    }

    public static <V> zzdys<V> zzj(Iterable<? extends zzdyz<? extends V>> iterable) {
        return new zzdys<>(false, zzdwm.zzh(iterable), (k30) null);
    }

    public static <V> zzdys<V> zzk(Iterable<? extends zzdyz<? extends V>> iterable) {
        return new zzdys<>(true, zzdwm.zzh(iterable), (k30) null);
    }

    public static <I, O> zzdyz<O> zzb(zzdyz<I> zzdyz, zzdyb<? super I, ? extends O> zzdyb, Executor executor) {
        return t20.m6984v(zzdyz, zzdyb, executor);
    }

    public static <V> zzdyz<V> zza(zzdyz<V> zzdyz, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzdyz.isDone()) {
            return zzdyz;
        }
        return z30.m7392v(zzdyz, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> zzdyz<O> zzb(zzdyz<I> zzdyz, zzdvm<? super I, ? extends O> zzdvm, Executor executor) {
        return t20.m6983u(zzdyz, zzdvm, executor);
    }

    @SafeVarargs
    public static <V> zzdys<V> zzb(zzdyz<? extends V>... zzdyzArr) {
        return new zzdys<>(true, zzdwm.zzb((E[]) zzdyzArr), (k30) null);
    }

    @SafeVarargs
    public static <V> zzdys<V> zza(zzdyz<? extends V>... zzdyzArr) {
        return new zzdys<>(false, zzdwm.zzb((E[]) zzdyzArr), (k30) null);
    }

    public static <V> V zzb(Future<V> future) {
        zzdvv.checkNotNull(future);
        try {
            return zzdzs.getUninterruptibly(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzdyj((Error) cause);
            }
            throw new zzdzp(cause);
        }
    }

    public static <V> void zza(zzdyz<V> zzdyz, zzdyo<? super V> zzdyo, Executor executor) {
        zzdvv.checkNotNull(zzdyo);
        zzdyz.addListener(new l30(zzdyz, zzdyo), executor);
    }

    public static <V> V zza(Future<V> future) {
        if (future.isDone()) {
            return zzdzs.getUninterruptibly(future);
        }
        throw new IllegalStateException(zzdwc.zzb("Future was expected to be done: %s", future));
    }
}
