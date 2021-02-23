package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzdxr extends AbstractExecutorService implements zzdzc {
    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return d40.m5922t(runnable, t);
    }

    /* renamed from: zze */
    public final <T> zzdyz<T> submit(Callable<T> callable) {
        return (zzdyz) super.submit(callable);
    }

    /* renamed from: zzg */
    public final zzdyz<?> submit(Runnable runnable) {
        return (zzdyz) super.submit(runnable);
    }

    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return d40.m5923u(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @NullableDecl Object obj) {
        return (zzdyz) super.submit(runnable, obj);
    }
}
