package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzazq<T> implements zzdyz<T> {
    private final zzdzh<T> zzegz = zzdzh.zzazp();

    private static boolean zzar(boolean z) {
        if (!z) {
            zzp.zzku().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.zzegz.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        return this.zzegz.cancel(z);
    }

    public T get() {
        return this.zzegz.get();
    }

    public boolean isCancelled() {
        return this.zzegz.isCancelled();
    }

    public boolean isDone() {
        return this.zzegz.isDone();
    }

    public final boolean set(@Nullable T t) {
        return zzar(this.zzegz.set(t));
    }

    public final boolean setException(Throwable th) {
        return zzar(this.zzegz.setException(th));
    }

    public T get(long j, TimeUnit timeUnit) {
        return this.zzegz.get(j, timeUnit);
    }
}
